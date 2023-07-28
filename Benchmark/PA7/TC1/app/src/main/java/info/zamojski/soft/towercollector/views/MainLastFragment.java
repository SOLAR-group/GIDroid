/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.views;

import java.util.Date;

import info.zamojski.soft.towercollector.MyApplication;
import info.zamojski.soft.towercollector.R;
import info.zamojski.soft.towercollector.dao.MeasurementsDatabase;
import info.zamojski.soft.towercollector.enums.NetworkGroup;
import info.zamojski.soft.towercollector.events.MeasurementSavedEvent;
import info.zamojski.soft.towercollector.events.PrintMainWindowEvent;
import info.zamojski.soft.towercollector.model.Cell;
import info.zamojski.soft.towercollector.model.Measurement;
import info.zamojski.soft.towercollector.utils.NetworkTypeUtils;
import info.zamojski.soft.towercollector.utils.UnitConverter;
import timber.log.Timber;

import android.os.Bundle;

import androidx.annotation.NonNull;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableRow;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainLastFragment extends MainFragmentBase {

    private TableRow lastLongCellIdValueTableRow;
    private TableRow lastCellIdRncValueTableRow;
    private TableRow lastCellIdValueTableRow;

    private TextView lastNumberOfCellsValueTextView;
    private TextView lastNetworkTypeValueTextView;
    private TextView lastLongCellIdValueTextView;
    private TextView lastCellIdRncValueTextView;
    private TextView lastCellIdValueTextView;
    private TextView lastMccValueTextView;
    private TextView lastMncValueTextView;
    private TextView lastLacValueTextView;
    private TextView lastSignalStrengthValueTextView;
    private TextView lastLatitudeValueTextView;
    private TextView lastLongitudeValueTextView;
    private TextView lastGpsAccuracyValueTextView;
    private TextView lastDateTimeValueTextView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.main_last_fragment, container, false);
        configureControls(rootView);
        return rootView;
    }

    @Override
    protected void configureOnResume() {
        super.configureOnResume();
        getAndPrintOrClearMeasurement();
    }

    @Override
    protected void configureControls(View view) {
        super.configureControls(view);
        lastLongCellIdValueTableRow = view.findViewById(R.id.main_last_long_cell_id_tablerow);
        lastCellIdRncValueTableRow = view.findViewById(R.id.main_last_cell_id_rnc_tablerow);
        lastCellIdValueTableRow = view.findViewById(R.id.main_last_cell_id_tablerow);
        lastNumberOfCellsValueTextView = view.findViewById(R.id.main_last_number_of_cells_value_textview);
        lastNetworkTypeValueTextView = view.findViewById(R.id.main_last_network_type_value_textview);
        lastLongCellIdValueTextView = view.findViewById(R.id.main_last_long_cell_id_value_textview);
        lastCellIdRncValueTextView = view.findViewById(R.id.main_last_cell_id_rnc_value_textview);
        lastCellIdValueTextView = view.findViewById(R.id.main_last_cell_id_value_textview);
        lastMccValueTextView = view.findViewById(R.id.main_last_mcc_value_textview);
        lastMncValueTextView = view.findViewById(R.id.main_last_mnc_value_textview);
        lastLacValueTextView = view.findViewById(R.id.main_last_lac_value_textview);
        lastSignalStrengthValueTextView = view.findViewById(R.id.main_last_signal_strength_value_textview);
        lastLatitudeValueTextView = view.findViewById(R.id.main_last_latitude_value_textview);
        lastLongitudeValueTextView = view.findViewById(R.id.main_last_longitude_value_textview);
        lastGpsAccuracyValueTextView = view.findViewById(R.id.main_last_gps_accuracy_value_textview);
        lastDateTimeValueTextView = view.findViewById(R.id.main_last_date_time_value_textview);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(MeasurementSavedEvent event) {
        Measurement measurement = event.getMeasurement();
        printOrClearMeasurement(measurement);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(PrintMainWindowEvent event) {
        getAndPrintOrClearMeasurement();
    }

    private void getAndPrintOrClearMeasurement() {
        Measurement measurement = MeasurementsDatabase.getInstance(MyApplication.getApplication()).getLastMeasurement();
        printOrClearMeasurement(measurement);
    }

    private void printOrClearMeasurement(Measurement measurement) {
        if (measurement != null) {
            printMeasurement(measurement);
        } else {
            clearMeasurement();
        }
    }

    private void printMeasurement(Measurement measurement) {
        Timber.d("printMeasurement(): Printing last measurement %s", measurement);
        int neighboringCellsCount = measurement.getNeighboringCellsCount();
        int mainCellsCount = measurement.getMainCells().size();
        Cell mainCell = measurement.getMainCells().get(0);
        lastNumberOfCellsValueTextView.setText(String.format(locale, getStringForLocale(R.string.main_last_number_of_cells_value), mainCellsCount, neighboringCellsCount));
        int networkNameId = NetworkTypeUtils.getNetworkGroupNameResId(mainCell.getNetworkType());
        lastNetworkTypeValueTextView.setText(getStringForLocale(networkNameId));
        // only for UMTS/LTE with valid CID
        if ((mainCell.getNetworkType() == NetworkGroup.Wcdma || mainCell.getNetworkType() == NetworkGroup.Lte) && mainCell.getLongCid() != Cell.UNKNOWN_CID) {
            lastLongCellIdValueTableRow.setVisibility(View.VISIBLE);
            lastCellIdRncValueTableRow.setVisibility(View.VISIBLE);
            lastCellIdValueTableRow.setVisibility(View.GONE);
        } else {
            lastLongCellIdValueTableRow.setVisibility(View.GONE);
            lastCellIdRncValueTableRow.setVisibility(View.GONE);
            lastCellIdValueTableRow.setVisibility(View.VISIBLE);
        }
        lastLongCellIdValueTextView.setText(String.format(locale, "%d", mainCell.getLongCid()));
        lastCellIdRncValueTextView.setText(String.format(locale, getStringForLocale(R.string.main_last_cell_id_rnc_value), mainCell.getShortCid(), mainCell.getRnc()));
        lastCellIdValueTextView.setText(String.format(locale, "%d", mainCell.getCid()));
        lastMccValueTextView.setText((mainCell.getMcc() != Cell.UNKNOWN_CID ? String.format(locale, "%d", mainCell.getMcc()) : ""));
        lastMncValueTextView.setText(String.format(locale, "%d", mainCell.getMnc()));
        lastLacValueTextView.setText(String.format(locale, "%d", mainCell.getLac()));
        if (mainCell.getDbm() != Cell.UNKNOWN_SIGNAL) {
            lastSignalStrengthValueTextView.setText(String.format(locale, getStringForLocale(R.string.main_last_signal_strength_value), mainCell.getDbm()));
        } else {
            lastSignalStrengthValueTextView.setText(getStringForLocale(R.string.main_signal_strength_not_available));
        }
        lastLatitudeValueTextView.setText(String.format(locale, getStringForLocale(R.string.main_last_latitude_value), measurement.getLatitude()));
        lastLongitudeValueTextView.setText(String.format(locale, getStringForLocale(R.string.main_last_longitude_value), measurement.getLongitude()));
        if (measurement.getGpsAccuracy() != Measurement.GPS_VALUE_NOT_AVAILABLE)
            lastGpsAccuracyValueTextView.setText(String.format(locale, getStringForLocale(R.string.main_last_gps_accuracy_value),
                    (useImperialUnits ? UnitConverter.convertMetersToFeet(measurement.getGpsAccuracy()) : measurement.getGpsAccuracy()), preferredLengthUnit));
        else
            lastGpsAccuracyValueTextView.setText(getStringForLocale(R.string.main_gps_accuracy_not_available));
        lastDateTimeValueTextView.setText(dateTimeFormatStandard.format(new Date(measurement.getMeasuredAt())));
    }

    private void clearMeasurement() {
        Timber.d("clearMeasurement(): Clearing last measurement");
        lastNumberOfCellsValueTextView.setText("");
        lastNetworkTypeValueTextView.setText("");
        lastLongCellIdValueTextView.setText("");
        lastCellIdRncValueTextView.setText("");
        lastCellIdValueTextView.setText("");
        lastMccValueTextView.setText("");
        lastMncValueTextView.setText("");
        lastLacValueTextView.setText("");
        lastSignalStrengthValueTextView.setText("");
        lastLatitudeValueTextView.setText("");
        lastLongitudeValueTextView.setText("");
        lastGpsAccuracyValueTextView.setText("");
        lastDateTimeValueTextView.setText("");
    }
}
