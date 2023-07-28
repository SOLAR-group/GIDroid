/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.collector.converters;

import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityNr;
import android.telephony.CellIdentityTdscdma;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoTdscdma;
import android.telephony.CellInfoWcdma;

import info.zamojski.soft.towercollector.MyApplication;
import info.zamojski.soft.towercollector.collector.validators.specific.WcdmaCellIdentityValidator;
import info.zamojski.soft.towercollector.model.Cell;
import timber.log.Timber;

public class CellIdentityConverter {

    private final WcdmaCellIdentityValidator wcdmaValidator;

    public CellIdentityConverter(WcdmaCellIdentityValidator wcdmaValidator) {
        this.wcdmaValidator = wcdmaValidator;
    }

    public Cell convert(CellInfo cellInfo) {
        Cell cell = new Cell();
        cell.setNeighboring(!cellInfo.isRegistered());
        if (cellInfo instanceof CellInfoGsm) {
            CellInfoGsm gsmCellInfo = (CellInfoGsm) cellInfo;
            CellIdentityGsm identity = gsmCellInfo.getCellIdentity();
            if (wcdmaValidator.isValid(identity)) {
                Timber.d("update(): Updating WCDMA reported by API 17 as GSM");
                cell.setWcdmaCellInfo(identity.getMcc(), identity.getMnc(), identity.getLac(), identity.getCid(), identity.getPsc());
            } else {
                cell.setGsmCellInfo(identity.getMcc(), identity.getMnc(), identity.getLac(), identity.getCid());
            }
        } else if (cellInfo instanceof CellInfoWcdma) {
            CellInfoWcdma wcdmaCellInfo = (CellInfoWcdma) cellInfo;
            CellIdentityWcdma identity = wcdmaCellInfo.getCellIdentity();
            cell.setWcdmaCellInfo(identity.getMcc(), identity.getMnc(), identity.getLac(), identity.getCid(), identity.getPsc());
        } else if (cellInfo instanceof CellInfoLte) {
            CellInfoLte lteCellInfo = (CellInfoLte) cellInfo;
            CellIdentityLte identity = lteCellInfo.getCellIdentity();
            cell.setLteCellInfo(identity.getMcc(), identity.getMnc(), identity.getTac(), identity.getCi(), identity.getPci());
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && cellInfo instanceof CellInfoNr) {
            CellInfoNr lteCellInfo = (CellInfoNr) cellInfo;
            CellIdentityNr identity = (CellIdentityNr) lteCellInfo.getCellIdentity();
            cell.setNrCellInfo(identity.getMccString(), identity.getMncString(), identity.getTac(), identity.getNci(), identity.getPci());
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && cellInfo instanceof CellInfoTdscdma) {
            CellInfoTdscdma lteCellInfo = (CellInfoTdscdma) cellInfo;
            CellIdentityTdscdma identity = lteCellInfo.getCellIdentity();
            cell.setTdscdmaCellInfo(identity.getMccString(), identity.getMncString(), identity.getLac(), identity.getCid(), identity.getCpid());
        } else if (cellInfo instanceof CellInfoCdma) {
            CellInfoCdma cdmaCellInfo = (CellInfoCdma) cellInfo;
            CellIdentityCdma identity = cdmaCellInfo.getCellIdentity();
            cell.setCdmaCellInfo(identity.getSystemId(), identity.getNetworkId(), identity.getBasestationId());
        } else {
            throw new UnsupportedOperationException("Cell identity type not supported `" + cellInfo.getClass().getName() + "`");
        }
        return cell;
    }

    public String createCellKey(Cell cell) {
        StringBuilder sb = new StringBuilder();
        sb.append(cell.getMcc())
                .append("_").append(cell.getMnc())
                .append("_").append(cell.getLac())
                .append("_").append(cell.getCid());
        return sb.toString();
    }

    public String createCellKey(CellInfo cellInfo) {
        StringBuilder sb = new StringBuilder();
        if (cellInfo instanceof CellInfoGsm) {
            CellInfoGsm gsmCellInfo = (CellInfoGsm) cellInfo;
            CellIdentityGsm identity = gsmCellInfo.getCellIdentity();
            sb.append(identity.getMcc())
                    .append("_").append(identity.getMnc())
                    .append("_").append(identity.getLac())
                    .append("_").append(identity.getCid());
        } else if (cellInfo instanceof CellInfoWcdma) {
            CellInfoWcdma wcdmaCellInfo = (CellInfoWcdma) cellInfo;
            CellIdentityWcdma identity = wcdmaCellInfo.getCellIdentity();
            sb.append(identity.getMcc())
                    .append("_").append(identity.getMnc())
                    .append("_").append(identity.getLac())
                    .append("_").append(identity.getCid());
        } else if (cellInfo instanceof CellInfoLte) {
            CellInfoLte lteCellInfo = (CellInfoLte) cellInfo;
            CellIdentityLte identity = lteCellInfo.getCellIdentity();
            sb.append(identity.getMcc())
                    .append("_").append(identity.getMnc())
                    .append("_").append(identity.getTac())
                    .append("_").append(identity.getCi());
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && cellInfo instanceof CellInfoNr) {
            CellInfoNr nrCellInfo = (CellInfoNr) cellInfo;
            CellIdentityNr identity = (CellIdentityNr) nrCellInfo.getCellIdentity();
            sb.append(identity.getMccString())
                    .append("_").append(identity.getMncString())
                    .append("_").append(identity.getTac())
                    .append("_").append(identity.getNci());
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q && cellInfo instanceof CellInfoTdscdma) {
            CellInfoTdscdma tdscdmaCellInfo = (CellInfoTdscdma) cellInfo;
            CellIdentityTdscdma identity = tdscdmaCellInfo.getCellIdentity();
            sb.append(identity.getMccString())
                    .append("_").append(identity.getMncString())
                    .append("_").append(identity.getLac())
                    .append("_").append(identity.getCid());
        } else if (cellInfo instanceof CellInfoCdma) {
            CellInfoCdma cdmaCellInfo = (CellInfoCdma) cellInfo;
            CellIdentityCdma identity = cdmaCellInfo.getCellIdentity();
            sb.append(Cell.UNKNOWN_CID)
                    .append("_").append(identity.getSystemId())
                    .append("_").append(identity.getNetworkId())
                    .append("_").append(identity.getBasestationId());
        } else {
            Exception ex = new UnsupportedOperationException("Cell identity type not supported `" + cellInfo.getClass().getName() + "` = `" + cellInfo.toString() + "`");
            Timber.e(ex);
            MyApplication.handleSilentException(ex);
        }
        return sb.toString();
    }
}
