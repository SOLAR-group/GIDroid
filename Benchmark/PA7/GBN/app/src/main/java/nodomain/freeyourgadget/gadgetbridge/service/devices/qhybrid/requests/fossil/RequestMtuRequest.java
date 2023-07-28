/*  Copyright (C) 2019-2021 Daniel Dakhno

    This file is part of Gadgetbridge.

    Gadgetbridge is free software: you can redistribute it and/or modify
    it under the terms of the GNU Affero General Public License as published
    by the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    Gadgetbridge is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Affero General Public License for more details.

    You should have received a copy of the GNU Affero General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>. */
package nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.requests.fossil;

import android.os.Build;

import androidx.annotation.RequiresApi;

public class RequestMtuRequest extends FossilRequest {
    private int mtu;
    private boolean finished = false;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public RequestMtuRequest(int mtu) {
        this.mtu = mtu;
    }

    public int getMtu() {
        return mtu;
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    @Override
    public byte[] getStartSequence() {
        return new byte[0];
    }
}
