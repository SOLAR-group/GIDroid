/*  Copyright (C) 2017-2021 Andreas Shimokawa, Daniele Gobbetti

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
package nodomain.freeyourgadget.gadgetbridge.service.devices.huami.amazfitbips;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nodomain.freeyourgadget.gadgetbridge.GBApplication;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice;
import nodomain.freeyourgadget.gadgetbridge.model.DeviceType;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.HuamiFirmwareInfo;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.HuamiFirmwareType;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.amazfitbip.AmazfitBipFirmwareInfo;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.miband4.MiBand4FirmwareInfo;
import nodomain.freeyourgadget.gadgetbridge.util.ArrayUtils;

public class AmazfitBipSFirmwareInfo extends HuamiFirmwareInfo {

    private static Map<Integer, String> crcToVersion = new HashMap<>();

    static {
        // fw tonlesap
        crcToVersion.put(5017, "2.1.1.08");
        crcToVersion.put(4638, "2.1.1.16");
        crcToVersion.put(63673, "2.1.1.26");
        crcToVersion.put(22035, "2.1.1.36");
        crcToVersion.put(21575, "2.1.1.46");
        crcToVersion.put(61709, "2.1.1.72");
        crcToVersion.put(21734, "2.1.1.76");

        // resources
        crcToVersion.put(61617, "2.1.1.08");
        crcToVersion.put(5887, "2.1.1.16");
        crcToVersion.put(15177, "2.1.1.26-36");
        crcToVersion.put(18775, "2.1.1.46");
        crcToVersion.put(48133, "2.1.1.72");
        crcToVersion.put(29102, "2.1.1.76");

        // font
        crcToVersion.put(62927, "3 (KO/JP)");
        crcToVersion.put(30818, "3");

        // gps
        crcToVersion.put(62532, "18344,eb2f43f,126");
        crcToVersion.put(31510, "19226,f3a8ad3,135");
        crcToVersion.put(41742, "19439,3aa3392,135");
    }

    public AmazfitBipSFirmwareInfo(byte[] bytes) {
        super(bytes);
    }

    @Override
    protected HuamiFirmwareType determineFirmwareType(byte[] bytes) {
        List<GBDevice> devices = GBApplication.app().getDeviceManager().getSelectedDevices();
        for (GBDevice device : devices) {
            if (device.getFirmwareVersion().startsWith("2.")) {
                //For devices on firmware 2.x it is a tonleasp device and needs a header which looks like Mi Band 4
                if (ArrayUtils.equals(bytes, MiBand4FirmwareInfo.FW_HEADER, MiBand4FirmwareInfo.FW_HEADER_OFFSET)) {
                    if (searchString32BitAligned(bytes, "Amazfit Bip S")) {
                        return HuamiFirmwareType.FIRMWARE;
                    }
                    return HuamiFirmwareType.INVALID;
                }
            } else if (device.getFirmwareVersion().startsWith("4.")) {
                //For devices on firmware 2.x it is a dth device and needs a header which looks like Bip
                if (ArrayUtils.startsWith(bytes, AmazfitBipFirmwareInfo.FW_HEADER)) {
                    if (searchString32BitAligned(bytes, "Amazfit Bip S")) {
                        return HuamiFirmwareType.FIRMWARE;
                    }
                    return HuamiFirmwareType.INVALID;
                }
            }
        }

        if (ArrayUtils.equals(bytes, NEWRES_HEADER, COMPRESSED_RES_HEADER_OFFSET) ||
                ArrayUtils.equals(bytes, NEWRES_HEADER, COMPRESSED_RES_HEADER_OFFSET_NEW)) {
            return HuamiFirmwareType.RES_COMPRESSED;
        }

        if (ArrayUtils.startsWith(bytes, WATCHFACE_HEADER)) {
            return HuamiFirmwareType.WATCHFACE;
        }
        if (ArrayUtils.startsWith(bytes, GPS_ALMANAC_HEADER)) {
            return HuamiFirmwareType.GPS_ALMANAC;
        }
        if (ArrayUtils.startsWith(bytes, GPS_CEP_HEADER)) {
            return HuamiFirmwareType.GPS_CEP;
        }
        if (ArrayUtils.startsWith(bytes, AGPS_UIHH_HEADER)) {
            return HuamiFirmwareType.AGPS_UIHH;
        }
        if (ArrayUtils.startsWith(bytes, NEWFT_HEADER)) {
            if (bytes[10] == 0x01 || bytes[10] == 0x06 || bytes[10] == 0x03) {
                return HuamiFirmwareType.FONT;
            } else if (bytes[10] == 0x02 || bytes[10] == 0x0A) {
                return HuamiFirmwareType.FONT_LATIN;
            }
        }
        for (byte[] gpsHeader : GPS_HEADERS) {
            if (ArrayUtils.startsWith(bytes, gpsHeader)) {
                return HuamiFirmwareType.GPS;
            }
        }
        return HuamiFirmwareType.INVALID;
    }

    @Override
    public boolean isGenerallyCompatibleWith(GBDevice device) {
        return isHeaderValid() && device.getType() == DeviceType.AMAZFITBIPS;
    }

    @Override
    protected Map<Integer, String> getCrcMap() {
        return crcToVersion;
    }
}
