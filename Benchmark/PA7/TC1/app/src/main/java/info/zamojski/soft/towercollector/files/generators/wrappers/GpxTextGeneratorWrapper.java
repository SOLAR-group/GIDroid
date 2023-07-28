/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.files.generators.wrappers;

import android.content.Context;

import java.io.IOException;
import java.util.List;

import info.zamojski.soft.towercollector.MyApplication;
import info.zamojski.soft.towercollector.dao.MeasurementsDatabase;
import info.zamojski.soft.towercollector.enums.GeneratorResult;
import info.zamojski.soft.towercollector.files.DeviceOperationException;
import info.zamojski.soft.towercollector.files.DeviceOperationException.Reason;
import info.zamojski.soft.towercollector.files.FileGeneratorResult;
import info.zamojski.soft.towercollector.files.devices.IWritableTextDevice;
import info.zamojski.soft.towercollector.files.formatters.gpx.GpxExportFormatter;
import info.zamojski.soft.towercollector.files.formatters.gpx.IGpxFormatter;
import info.zamojski.soft.towercollector.files.formatters.gpx.model.HeaderData;
import info.zamojski.soft.towercollector.files.generators.GpxTextGenerator;
import info.zamojski.soft.towercollector.model.Boundaries;
import info.zamojski.soft.towercollector.model.Measurement;
import timber.log.Timber;

public class GpxTextGeneratorWrapper extends TextGeneratorWrapperBase {

    private GpxTextGenerator<IGpxFormatter, IWritableTextDevice> generator;

    public GpxTextGeneratorWrapper(Context context, IWritableTextDevice device) {
        this.context = context;
        this.device = device;
        this.generator = new GpxTextGenerator<>(new GpxExportFormatter(), device);
    }

    @Override
    public FileGeneratorResult generate() {
        try {
            // get number of locations to process
            int locationsCount = MeasurementsDatabase.getInstance(MyApplication.getApplication()).getAllLocationsCount(false);
            // check if there is anything to process
            if (locationsCount == 0) {
                Timber.d("generate(): Cancelling save due to no data");
                return new FileGeneratorResult(GeneratorResult.NoData, Reason.Unknown);
            }
            // calculate number of parts
            final int LOCATIONS_PER_PART = 80;
            int partsCount = 1;
            if (locationsCount > LOCATIONS_PER_PART) {
                partsCount = (int) Math.ceil(1.0 * locationsCount / LOCATIONS_PER_PART);
            }
            device.open();
            notifyProgressListeners(0, locationsCount);
            // write header
            Measurement firstMeasurement = MeasurementsDatabase.getInstance(MyApplication.getApplication()).getFirstMeasurement();
            Measurement lastMeasurement = MeasurementsDatabase.getInstance(MyApplication.getApplication()).getLastMeasurement();
            Boundaries bounds = MeasurementsDatabase.getInstance(MyApplication.getApplication()).getLocationBounds();
            HeaderData headerData = new HeaderData();
            headerData.FirstMeasurementTimestamp = firstMeasurement.getMeasuredAt();
            headerData.LastMeasurementTimestamp = lastMeasurement.getMeasuredAt();
            headerData.Boundaries = bounds;
            generator.writeHeader(headerData);
            // remember previous measurement
            Measurement prevMeasurement = firstMeasurement;
            // get locations in loop
            for (int i = 0; i < partsCount; i++) {
                // get from database
                List<Measurement> measurements = MeasurementsDatabase.getInstance(MyApplication.getApplication()).getMeasurementsPart(i * LOCATIONS_PER_PART, LOCATIONS_PER_PART);
                // write to file
                for (Measurement m : measurements) {
                    // if time difference is more than 30 minutes then create new segment
                    if ((m.getMeasuredAt() - prevMeasurement.getMeasuredAt()) > 1800000) {
                        generator.writeNewSegment();
                    }
                    generator.writeEntry(m);
                    prevMeasurement = m;
                }
                notifyProgressListeners(i * LOCATIONS_PER_PART + measurements.size(), locationsCount);
                if (cancel) {
                    break;
                }
            }
            // write footer
            generator.writeFooter();
            device.close();
            // fix for dialog not closed when operation is running in background and data deleted
            notifyProgressListeners(locationsCount, locationsCount);
            if (cancel) {
                Timber.d("generate(): Export cancelled");
                return new FileGeneratorResult(GeneratorResult.Cancelled, Reason.Unknown);
            } else {
                Timber.d("generate(): All %s locations exported", locationsCount);
                return new FileGeneratorResult(GeneratorResult.Succeeded, Reason.Unknown);
            }
        } catch (DeviceOperationException ex) {
            Timber.e(ex, "generate(): Failed to check external memory compatibility");
            MyApplication.handleSilentException(ex);
            return new FileGeneratorResult(GeneratorResult.Failed, ex.getReason());
        } catch (IOException ex) {
            Timber.e(ex, "generate(): Failed to save data on external memory");
            MyApplication.handleSilentException(ex);
            return new FileGeneratorResult(GeneratorResult.Failed, Reason.Unknown, ex.getMessage());
        } finally {
            // just for sure
            device.close();
        }
    }
}
