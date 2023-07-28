/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.files.formatters.csv;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import info.zamojski.soft.towercollector.model.Measurement;
import info.zamojski.soft.towercollector.providers.GeneralCellUtils;
import info.zamojski.soft.towercollector.providers.ICellUtils;

public class CsvExportFormatter extends CsvFormatter {

    private static final NumberFormat gpsDoubleFormater;
    private static final SimpleDateFormat exportDateFormater;

    private static final ICellUtils cellUtils;

    static {
        gpsDoubleFormater = NumberFormat.getNumberInstance(LOCALE);
        gpsDoubleFormater.setGroupingUsed(false);
        gpsDoubleFormater.setMinimumFractionDigits(0);
        gpsDoubleFormater.setMaximumFractionDigits(2);
        cellUtils = new GeneralCellUtils();
        exportDateFormater = new SimpleDateFormat("\"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'\"", LOCALE);
        exportDateFormater.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public String formatHeader() {
        return "mcc,mnc,lac,cell_id,psc,asu,dbm,ta,lat,lon,accuracy,speed,bearing,altitude,measured_at,net_type,neighboring,device\r\n";
    }

    @Override
    public String formatRow(Measurement m) {
        StringBuilder sb = new StringBuilder(150);

        // mcc value only when defined
        int mcc = m.getMcc();
        if (mcc != Measurement.UNKNOWN_CID)
            sb.append(mcc);
        sb.append(',');
        sb.append(m.getMnc());
        sb.append(',');
        sb.append(m.getLac());
        sb.append(',');
        sb.append(m.getCid());
        sb.append(',');
        int psc = m.getPsc();
        if (psc != Measurement.UNKNOWN_CID)
            sb.append(psc);
        sb.append(',');

        sb.append(formatAsuSignal(m.getAsu()));
        sb.append(',');
        sb.append(formatDbmSignal(m.getDbm()));
        sb.append(',');
        int ta = m.getTa();
        if (ta != Measurement.UNKNOWN_SIGNAL)
            sb.append(ta);
        sb.append(',');

        sb.append(formatCoordinate(m.getLatitude()));
        sb.append(',');
        sb.append(formatCoordinate(m.getLongitude()));
        sb.append(',');

        sb.append(formatGpsValue(m.getGpsAccuracy()));
        sb.append(',');
        sb.append(formatGpsValue(m.getGpsSpeed()));
        sb.append(',');
        sb.append(formatGpsValue(m.getGpsBearing()));
        sb.append(',');
        sb.append(formatGpsValue(m.getGpsAltitude()));
        sb.append(',');

        sb.append(formatDate(m.getTimestamp()));
        sb.append(',');

        sb.append(cellUtils.getSystemType(m.getNetworkType()));
        sb.append(',');

        sb.append(m.isNeighboring());
        sb.append(',');

        sb.append("\"");
        sb.append(deviceName);
        sb.append("\"");

        sb.append("\r\n");

        return sb.toString();
    }

    private String formatGpsValue(double value) {
        return gpsDoubleFormater.format(value);
    }

    private String formatAsuSignal(int asu) {
        String asuString;
        if (asu != Measurement.UNKNOWN_SIGNAL)
            asuString = String.valueOf(asu);
        else
            asuString = "";
        return asuString;
    }

    private String formatDbmSignal(int dbm) {
        if (dbm != Measurement.UNKNOWN_SIGNAL)
            return String.valueOf(dbm);
        else
            return "";
    }

    private String formatDate(long timestamp) {
        return exportDateFormater.format(new Date(timestamp));
    }
}
