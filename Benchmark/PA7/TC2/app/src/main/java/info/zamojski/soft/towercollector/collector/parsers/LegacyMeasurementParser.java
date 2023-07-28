/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.collector.parsers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.acra.ACRA;

import de.greenrobot.event.EventBus;

import android.location.Location;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.gsm.GsmCellLocation;
import android.util.Log;

import info.zamojski.soft.towercollector.MyApplication;
import info.zamojski.soft.towercollector.collector.ParseResult;
import info.zamojski.soft.towercollector.collector.converters.CellLocationConverter;
import info.zamojski.soft.towercollector.collector.converters.CellLocationSignalConverter;
import info.zamojski.soft.towercollector.collector.validators.CellLocationValidator;
import info.zamojski.soft.towercollector.collector.validators.ConditionsValidator;
import info.zamojski.soft.towercollector.collector.validators.LocationValidator;
import info.zamojski.soft.towercollector.collector.validators.SystemTimeValidator;
import info.zamojski.soft.towercollector.dao.MeasurementsDatabase;
import info.zamojski.soft.towercollector.enums.NetworkGroup;
import info.zamojski.soft.towercollector.events.LegacyMeasurementProcessingEvent;
import info.zamojski.soft.towercollector.events.MeasurementSavedEvent;
import info.zamojski.soft.towercollector.model.Measurement;
import info.zamojski.soft.towercollector.model.Statistics;
import info.zamojski.soft.towercollector.utils.MobileUtils;

public class LegacyMeasurementParser extends MeasurementParser {

    private static final String TAG = LegacyMeasurementParser.class.getSimpleName();

    private CellLocationValidator cellLocationValidator;

    private CellLocationConverter cellLocationConverter;
    private CellLocationSignalConverter cellSignalConverter;

    public LegacyMeasurementParser(LocationValidator locationValidator, CellLocationValidator cellLocationValidator,
                                   ConditionsValidator conditionsValidator, SystemTimeValidator systemTimeValidator,
                                   CellLocationConverter cellLocationConverter, CellLocationSignalConverter cellSignalConverter,
                                   boolean collectNeighboringCells) {
        super(locationValidator, conditionsValidator, systemTimeValidator, collectNeighboringCells);
        this.cellLocationValidator = cellLocationValidator;
        this.cellLocationConverter = cellLocationConverter;
        this.cellSignalConverter = cellSignalConverter;
    }

    private ParseResult parse(Location location, CellLocation cellLocation, SignalStrength signalStrength,
                              NetworkGroup networkType, String operatorCode, String operatorName, List<NeighboringCellInfo> neighboringCells,
                              long timestamp, int minDistance) {
        // if required accuracy was achieved
        if (!locationValidator.isValid(location)) {
            Log.d(TAG, "parse(): Required accuracy not achieved: " + location.getAccuracy());
            return ParseResult.AccuracyNotAchieved;
        }
        Log.d(TAG, "parse(): Required accuracy achieved: " + location.getAccuracy());
        // get last location
        getAndSetLastLocation();
        // operator name may be unreliable for CDMA
        Log.d(TAG, "parse(): Operator name = '" + operatorName + "'");
        // get operator codes
        int mcc = Measurement.UNKNOWN_CID;
        int mnc = Measurement.UNKNOWN_CID;
        if (cellLocation instanceof GsmCellLocation) {
            int[] mccMncPair = MobileUtils.getMccMncPair(operatorCode);
            if (mccMncPair != null) {
                mcc = mccMncPair[0];
                mnc = mccMncPair[1];
            } else {
                Log.d(TAG, "parseLocation(): Network operator unknown: " + operatorCode);
            }
        }
        // validate cell
        if (!cellLocationValidator.isValid(cellLocation, mcc, mnc)) {
            Log.d(TAG, "parse(): Cell invalid");
            return ParseResult.NoNetworkSignal;
        }
        // create measurement with basic data
        Measurement measurement = new Measurement();
        cellLocationConverter.update(measurement, cellLocation, mcc, mnc, networkType);
        // fix time if incorrect
        fixMeasurementTimestamp(measurement, location);
        // if the same cell check distance condition, otherwise accept
        if (lastSavedLocation != null && !conditionsValidator.isMinDistanceSatisfied(lastSavedLocation, location, minDistance)) {
            Log.d(TAG, "parse(): Distance condition not achieved");
            return ParseResult.DistanceNotAchieved;
        }
        // check if location has been obtained recently
        if (!locationValidator.isUpToDate(timestamp, System.currentTimeMillis())) {
            Log.d(TAG, "parse(): Location too old");
            return ParseResult.LocationTooOld;
        }
        Log.d(TAG, "parse(): Destination and time conditions achieved");
        // update measurement with location
        updateMeasurementWithLocation(measurement, location);
        // update measurement with signal strength
        if (signalStrength != null) {
            cellSignalConverter.update(measurement, signalStrength);
        }
        // create a list of measurements to save
        List<Measurement> measurementsToSave = new ArrayList<Measurement>();
        Log.d(TAG, "parse(): Main: " + measurement);
        measurementsToSave.add(measurement);
        if (collectNeighboringCells) {
            // remove duplicated neighboring cells
            removeDuplicatedNeighbors(neighboringCells, measurement);
            // process neighboring cells
            for (NeighboringCellInfo neighboringCell : neighboringCells) {
                // copy measurement
                Measurement neighboringMeasurement = new Measurement(measurement);
                // validate cell
                if (cellLocationValidator.isValid(neighboringCell, neighboringMeasurement)) {
                    // set values
                    neighboringMeasurement.setNeighboring(true);
                    cellLocationConverter.update(neighboringMeasurement, neighboringCell, mcc, mnc);
                    // update measurement with signal strength
                    cellSignalConverter.update(neighboringMeasurement, neighboringCell.getRssi());
                    // write to database
                    Log.d(TAG, "parse(): Neighboring: " + neighboringMeasurement);
                    measurementsToSave.add(neighboringMeasurement);
                } else {
                    Log.d(TAG, "parse(): Neighboring cell invalid: " + neighboringCell);
                }
            }
        }
        // write to database
        Log.d(TAG, "parse(): Main: " + measurement);
        boolean inserted = MeasurementsDatabase.getInstance(MyApplication.getApplication()).insertMeasurements(measurementsToSave.toArray(new Measurement[measurementsToSave.size()]));
        if (inserted) {
            lastSavedLocation = location;
            lastSavedMeasurement = measurement;
            Log.d(TAG, "parse(): Measurement saved");
            // broadcast information to main activity
            Statistics stats = MeasurementsDatabase.getInstance(MyApplication.getApplication()).getMeasurementsStatistics();
            EventBus.getDefault().post(new MeasurementSavedEvent(measurement, stats));
            Log.d(TAG, "parse(): Notification updated and measurement broadcasted");
            return ParseResult.Saved;
        } else {
            Log.e(TAG, "parse(): Error while saving measurement");
            Exception ex = new Exception("Measurement save failed");
            MyApplication.getAnalytics().sendException(ex, Boolean.FALSE);
            ACRA.getErrorReporter().handleSilentException(ex);
            return ParseResult.SaveFailed;
        }
    }

    private void removeDuplicatedNeighbors(List<NeighboringCellInfo> neighboringCells, Measurement measurement) {
        List<NeighboringCellInfo> cellsToRemove = new ArrayList<NeighboringCellInfo>();
        Set<String> uniqueCellKeys = new HashSet<String>();

        uniqueCellKeys.add(createCellKey(measurement));
        for (NeighboringCellInfo cell : neighboringCells) {
            String key = createCellKey(cell, measurement);
            if (uniqueCellKeys.contains(key)) {
                Log.d(TAG, "removeDuplicatedNeighbors(): Remove duplicated cell: " + key);
                cellsToRemove.add(cell);
            } else {
                uniqueCellKeys.add(key);
            }
        }

        neighboringCells.removeAll(cellsToRemove);
    }

    private String createCellKey(NeighboringCellInfo cell, Measurement measurement) {
        StringBuilder sb = new StringBuilder();
        sb.append(cell.getLac())
                .append("_").append(cell.getCid());
        return sb.toString();
    }

    private String createCellKey(Measurement measurement) {
        StringBuilder sb = new StringBuilder();
        int lac = measurement.getLac();
        int cid = measurement.getCid();
        sb.append(lac)
                .append("_").append(cid);
        return sb.toString();
    }

    public void onEventBackgroundThread(LegacyMeasurementProcessingEvent event) {
        ParseResult result = parse(event.getLastLocation(), event.getLastCellLocation(), event.getLastSignalStrength(),
                event.getLastNetworkType(), event.getLastOperatorCode(), event.getLastOperatorName(),
                event.getNeighboringCells(), event.getLastLocationObtainedTime(), event.getMinDistance());
        // when saved different event is published
        if (result != ParseResult.Saved) {
            notifyResult(result);
        }
    }
}
