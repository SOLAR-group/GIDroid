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
package nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.adapter;

import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.QHybridSupport;
import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.adapter.fossil.FossilWatchAdapter;
import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.adapter.fossil_hr.FossilHRWatchAdapter;
import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.adapter.misfit.MisfitWatchAdapter;

public final class WatchAdapterFactory {
    public final WatchAdapter createWatchAdapter(String firmwareVersion, QHybridSupport deviceSupport){
        char hardwareVersion = firmwareVersion.charAt(2);
        if(hardwareVersion == '1') return new FossilHRWatchAdapter(deviceSupport);

        char major = firmwareVersion.charAt(6);
        switch (major){
            case '0': return new MisfitWatchAdapter(deviceSupport);
            case '1': return new MisfitWatchAdapter(deviceSupport);
            case '2': return new FossilWatchAdapter(deviceSupport);
        }

        throw new UnsupportedOperationException("Firmware " + firmwareVersion + " not supported");
    }
}
