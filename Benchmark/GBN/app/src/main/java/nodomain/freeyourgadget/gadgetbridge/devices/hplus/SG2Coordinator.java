/*  Copyright (C) 2017-2021 Daniele Gobbetti, João Paulo Barraca, Lesur Frederic
    tiparega

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
package nodomain.freeyourgadget.gadgetbridge.devices.hplus;

import androidx.annotation.NonNull;

import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDeviceCandidate;
import nodomain.freeyourgadget.gadgetbridge.model.DeviceType;

/**
 * Pseudo Coordinator for the  Lemfo SG2, a sub type of the HPLUS devices
 */
public class SG2Coordinator extends HPlusCoordinator {

    @NonNull
    @Override
    public DeviceType getSupportedType(GBDeviceCandidate candidate) {
        String name = candidate.getDevice().getName();
        if (name != null && name.startsWith("SG2")) {
            HPlusCoordinator.setNotificationLinesNumber(candidate.getDevice().getAddress(), 9);
            HPlusCoordinator.setUnicodeSupport(candidate.getDevice().getAddress(), true);
            HPlusCoordinator.setDisplayIncomingMessageIcon(candidate.getDevice().getAddress(), false);
            return DeviceType.SG2;
        }

        return DeviceType.UNKNOWN;
    }

    @Override
    public DeviceType getDeviceType() {
        return DeviceType.SG2;
    }

    @Override
    public String getManufacturer() {
        return "Lemfo";
    }

    @Override
    public boolean supportsWeather() {
        return true;
    }

    @Override
    public boolean supportsSmartWakeup(GBDevice device) {
        return true;
    }

    @Override
    public int getBondingStyle() {
        return BONDING_STYLE_ASK;
    }
}
