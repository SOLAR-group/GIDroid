/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.collector.validators.specific;

import android.annotation.TargetApi;
import android.os.Build;
import android.telephony.CellIdentityCdma;
import android.util.Log;

public class CdmaCellIdentityValidator {

    private static final String TAG = CdmaCellIdentityValidator.class.getSimpleName();

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    public boolean isValid(CellIdentityCdma cell) {
        boolean valid = (isBidInRange(cell.getBasestationId()) && isNidInRange(cell.getNetworkId())
                && isSidInRange(cell.getSystemId()));
        if (!valid) {
            Log.w(TAG, "isValid(): Invalid CellIdentityCdma [sid=" + cell.getSystemId() + ", nid=" + cell.getNetworkId() + ", bid=" + cell.getBasestationId() + "]");
            Log.w(TAG, "isValid(): Invalid CellIdentityCdma " + cell);
        }
        return valid;
    }

    private boolean isBidInRange(int bid) {
        return (bid >= 1 && bid <= 65535);
    }

    private boolean isNidInRange(int nid) {
        return (nid >= 1 && nid <= 65535);
    }

    private boolean isSidInRange(int sid) {
        return (sid >= 0 && sid <= 32767);
    }

}
