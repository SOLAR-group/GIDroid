/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.collector.validators.specific;

import android.telephony.CellIdentityGsm;

import timber.log.Timber;

public class GsmCellIdentityValidator {

    public boolean isValid(CellIdentityGsm cell) {
        boolean valid = (isCidInRange(cell.getCid()) && isLacInRange(cell.getLac())
                && isMncInRange(cell.getMnc()) && isMccInRange(cell.getMcc()));
        if (!valid) {
            Timber.w("isValid(): Invalid CellIdentityGsm [mcc=%s, mnc=%s, lac=%s, cid=%s, psc=%s]", cell.getMcc(), cell.getMnc(), cell.getLac(), cell.getCid(), cell.getPsc());
            Timber.w("isValid(): Invalid CellIdentityGsm %s", cell);
        }
        return valid;
    }

    private boolean isCidInRange(int cid) {
        return (cid >= 1 && cid <= 65535);
    }

    private boolean isLacInRange(int lac) {
        return (lac >= 1 && lac <= 65535);
    }

    private boolean isMncInRange(int mnc) {
        return (mnc >= 0 && mnc <= 999);
    }

    private boolean isMccInRange(int mcc) {
        return (mcc >= 100 && mcc <= 999);
    }

}
