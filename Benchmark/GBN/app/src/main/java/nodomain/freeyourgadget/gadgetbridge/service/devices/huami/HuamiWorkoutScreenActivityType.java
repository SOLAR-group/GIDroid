/*  Copyright (C) 2022 José Rebelo

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
package nodomain.freeyourgadget.gadgetbridge.service.devices.huami;

import java.util.Locale;

/**
 * The workout types, to configure the workouts screen on the band.
 */
public enum HuamiWorkoutScreenActivityType {
    OutdoorRunning(0x01),
    Walking(0x06),
    Treadmill(0x08),
    OutdoorCycling(0x09),
    IndoorCycling(0x0a),
    Elliptical(0x0c),
    PoolSwimming(0x0e),
    Freestyle(0x10),
    JumpRope(0x15),
    RowingMachine(0x17),
    Yoga(0x3c);

    private final byte code;

    HuamiWorkoutScreenActivityType(final int code) {
        this.code = (byte) code;
    }

    public byte getCode() {
        return code;
    }

    public static HuamiWorkoutScreenActivityType fromPrefValue(final String prefValue) {
        for (final HuamiWorkoutScreenActivityType type : values()) {
            if (type.name().toLowerCase(Locale.ROOT).equals(prefValue.replace("_", "").toLowerCase(Locale.ROOT))) {
                return type;
            }
        }
        throw new RuntimeException("No matching HuamiWorkoutScreenActivityType for pref value: " + prefValue);
    }
}
