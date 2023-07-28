/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.files.formatters.csv;

import info.zamojski.soft.towercollector.enums.NetworkGroup;
import info.zamojski.soft.towercollector.model.Measurement;
import info.zamojski.soft.towercollector.providers.ICellUtils;
import info.zamojski.soft.towercollector.providers.OpencellidCellUtils;
import info.zamojski.soft.towercollector.utils.StringUtils;

public class CsvUploadFormatter extends CsvFormatter {

    private static final ICellUtils cellUtils;

    static {
        cellUtils = new OpencellidCellUtils();
        deviceName = StringUtils.substring(deviceName, 0, 50);
    }

    @Override
    public String formatHeader() {
        return "lat,lon,mcc,mnc,sid,lac,tac,nid,cellid,bid,psc,pci,signal,ta,measured_at,rating,speed,direction,act,devn\n";
    }

    @Override
    public String formatRow(Measurement m) {
        StringBuilder sb = new StringBuilder(140);

        sb.append(formatCoordinate(m.getLatitude()));
        sb.append(',');
        sb.append(formatCoordinate(m.getLongitude()));
        sb.append(',');

        // depending on cell type
        if (m.getNetworkType() == NetworkGroup.Cdma || m.getMcc() == Measurement.UNKNOWN_CID) {
            // mcc
            sb.append(',');
            // mnc
            sb.append(',');
            // sid
            sb.append(m.getMnc());
            sb.append(',');
            // lac
            sb.append(',');
            // tac
            sb.append(',');
            // nid
            sb.append(m.getLac());
            sb.append(',');
            // cellid
            sb.append(',');
            // bid
            sb.append(m.getCid());
            sb.append(',');
        } else {
            // mcc
            sb.append(m.getMcc());
            sb.append(',');
            // mnc
            sb.append(m.getMnc());
            sb.append(',');
            // sid
            sb.append(',');
            // lac
            if (m.getNetworkType() != NetworkGroup.Lte)
                sb.append(m.getLac());
            sb.append(',');
            // tac
            if (m.getNetworkType() == NetworkGroup.Lte)
                sb.append(m.getLac());
            sb.append(',');
            // nid
            sb.append(',');
            // cellid
            sb.append(m.getCid());
            sb.append(',');
            // bid
            sb.append(',');
        }

        // psc
        int psc = m.getPsc();
        if (psc != Measurement.UNKNOWN_CID && m.getNetworkType() == NetworkGroup.Wcdma)
            sb.append(psc);
        sb.append(',');
        // pci
        if (psc != Measurement.UNKNOWN_CID && m.getNetworkType() == NetworkGroup.Lte)
            sb.append(psc);
        sb.append(',');

        sb.append(formatSignal(m.getAsu(), m.getDbm()));
        sb.append(',');
        int ta = m.getTa();
        if (ta != Measurement.UNKNOWN_SIGNAL)
            sb.append(ta);
        sb.append(',');

        sb.append(m.getTimestamp());
        sb.append(',');

        sb.append(convertToInt(m.getGpsAccuracy()));
        sb.append(',');
        sb.append(convertToInt(m.getGpsSpeed()));
        sb.append(',');
        sb.append(convertToInt(m.getGpsBearing()));
        sb.append(',');

        sb.append(cellUtils.getSystemType(m.getNetworkType()));
        sb.append(',');

        sb.append("\"");
        sb.append(deviceName);
        sb.append("\"");

        sb.append('\n');

        return sb.toString();
    }

    private int convertToInt(double value) {
        return (int) Math.round(value);
    }

    private String formatSignal(int asu, int dbm) {
        String signalString;
        if (asu != Measurement.UNKNOWN_SIGNAL)
            signalString = String.valueOf(asu);
        else if (dbm != Measurement.UNKNOWN_SIGNAL)
            signalString = String.valueOf(dbm);
        else
            signalString = "";
        return signalString;
    }
}
