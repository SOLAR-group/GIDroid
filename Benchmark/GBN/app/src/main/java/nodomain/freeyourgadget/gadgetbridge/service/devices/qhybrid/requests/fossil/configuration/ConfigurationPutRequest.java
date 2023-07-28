/*  Copyright (C) 2019-2021 Daniel Dakhno, Taavi Eomäe

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
package nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.requests.fossil.configuration;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;

import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.adapter.fossil.FossilWatchAdapter;
import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.file.FileHandle;
import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.requests.fossil.file.FilePutRequest;
import nodomain.freeyourgadget.gadgetbridge.util.GB;
import nodomain.freeyourgadget.gadgetbridge.util.StringUtils;

public class ConfigurationPutRequest extends FilePutRequest {
    private static final HashMap<Short, Class<? extends ConfigItem>> itemsById = new HashMap<>();

    static {
        itemsById.put((short) 0x02, CurrentStepCountConfigItem.class);
        itemsById.put((short) 0x03, DailyStepGoalConfigItem.class);
        itemsById.put((short) 0x0A, VibrationStrengthConfigItem.class);
        itemsById.put((short) 0x0C, TimeConfigItem.class);
        itemsById.put((short) 0x0D, BatteryConfigItem.class);
        itemsById.put((short) 0x0E, HeartRateMeasurementModeItem.class);
        itemsById.put((short) 0x10, UnitsConfigItem.class);
        itemsById.put((short) 0x14, FitnessConfigItem.class);
    }

    public static ConfigItem[] parsePayload(byte[] data) {
        ByteBuffer buffer = ByteBuffer.wrap(data);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        ArrayList<ConfigItem> configItems = new ArrayList<>();

        while (buffer.hasRemaining()) {
            short id = buffer.getShort();
            byte length = buffer.get();
            byte[] payload = new byte[length];

            for (int i = 0; i < length; i++) {
                payload[i] = buffer.get();
            }

            Class<? extends ConfigItem> configClass = itemsById.get(id);
            if (configClass == null) {
                continue;
            }

            ConfigItem item;
            try {
                item = configClass.newInstance();
            } catch (IllegalAccessException | InstantiationException e) {
                GB.log("error", GB.ERROR, e);
                continue;
            }
            item.parseData(payload);

            configItems.add(item);
        }

        return configItems.toArray(new ConfigItem[0]);
    }

    public ConfigurationPutRequest(ConfigItem item, FossilWatchAdapter adapter) {
        super(FileHandle.CONFIGURATION, createFileContent(new ConfigItem[]{item}), adapter);
    }

    public ConfigurationPutRequest(ConfigItem[] items, FossilWatchAdapter adapter) {
        super(FileHandle.CONFIGURATION, createFileContent(items), adapter);
    }

    private static byte[] createFileContent(ConfigItem[] items) {
        int overallSize = 0;
        for (ConfigItem item : items) {
            overallSize += item.getItemSize() + 3;
        }
        ByteBuffer buffer = ByteBuffer.allocate(overallSize);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        for (ConfigItem item : items) {
            buffer.putShort(item.getId());
            buffer.put((byte) item.getItemSize());
            buffer.put(item.getContent());
        }

        return buffer.array();
    }

    public static abstract class ConfigItem {
        public abstract int getItemSize();

        public abstract short getId();

        public abstract byte[] getContent();

        public abstract void parseData(byte[] data);
    }

    static public class GenericConfigItem<T> extends ConfigItem {
        private T value;
        private final short configId;

        public GenericConfigItem(short configId, T value) {
            this.value = value;
            this.configId = configId;
        }

        public T getValue() {
            return value;
        }

        @Override
        public int getItemSize() {
            switch (value.getClass().getName()) {
                case "java.lang.Byte":
                    return 1;
                case "java.lang.Short":
                    return 2;
                case "java.lang.Integer":
                    return 4;
                case "java.lang.Long":
                    return 8;
            }
            throw new UnsupportedOperationException("config type " + value.getClass().getName() + " not supported");
        }

        @Override
        public short getId() {
            return this.configId;
        }

        @Override
        public byte[] getContent() {
            ByteBuffer buffer = ByteBuffer.allocate(getItemSize());
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            switch (value.getClass().getName()) {
                case "java.lang.Byte": {
                    buffer.put((Byte) this.value);
                    break;
                }
                case "java.lang.Integer": {
                    buffer.putInt((Integer) this.value);
                    break;
                }
                case "java.lang.Long": {
                    buffer.putLong((Long) this.value);
                    break;
                }
                case "java.lang.Short": {
                    buffer.putShort((Short) this.value);
                    break;
                }
            }
            return buffer.array();
        }

        @Override
        public void parseData(byte[] data) {
            ByteBuffer buffer = ByteBuffer.wrap(data);
            buffer.order(ByteOrder.LITTLE_ENDIAN);

            switch (data.length) {
                case 1: {
                    this.value = (T) (Byte) buffer.get();
                    break;
                }
                case 2: {
                    this.value = (T) (Short) buffer.getShort();
                    break;
                }
                case 4: {
                    this.value = (T) (Integer) buffer.getInt();
                    break;
                }
                case 8: {
                    this.value = (T) (Long) buffer.getLong();
                    break;
                }
            }
        }
    }

    static public class BatteryConfigItem extends ConfigItem {
        private int batteryPercentage, batteryVoltage;

        public int getBatteryPercentage() {
            return batteryPercentage;
        }

        public int getBatteryVoltage() {
            return batteryVoltage;
        }

        @Override
        public int getItemSize() {
            return 3;
        }

        @Override
        public short getId() {
            return 0x0D;
        }

        @Override
        public byte[] getContent() {
            return new byte[0];
        }

        @Override
        public void parseData(byte[] data) {
            ByteBuffer buffer = ByteBuffer.wrap(data);
            buffer.order(ByteOrder.LITTLE_ENDIAN);

            this.batteryVoltage = buffer.getShort();
            this.batteryPercentage = buffer.get();
        }
    }

    static public class HeartRateMeasurementModeItem extends GenericConfigItem<Byte> {
        public HeartRateMeasurementModeItem() {
            this((byte) -1);
        }

        public HeartRateMeasurementModeItem(byte value) {
            super((short) 14, value);
        }
    }

    static public class DailyStepGoalConfigItem extends GenericConfigItem<Integer> {
        public DailyStepGoalConfigItem() {
            this(-1);
        }

        public DailyStepGoalConfigItem(int value) {
            super((short) 3, value);
        }
    }

    static public class TimezoneOffsetConfigItem extends GenericConfigItem<Short> {
        public TimezoneOffsetConfigItem(Short value) {
            super((short) 17, value);
        }
    }

    static public class VibrationStrengthConfigItem extends GenericConfigItem<Byte> {
        public VibrationStrengthConfigItem() {
            this((byte) -1);
        }

        public VibrationStrengthConfigItem(Byte value) {
            super((short) 10, value);
        }
    }

    static public class CurrentStepCountConfigItem extends GenericConfigItem<Integer> {
        public CurrentStepCountConfigItem() {
            this(-1);
        }

        public CurrentStepCountConfigItem(Integer value) {
            super((short) 2, value);
        }
    }

    static public class UnitsConfigItem extends GenericConfigItem<Integer> {
        public UnitsConfigItem() {
            this(-1);
        }

        public UnitsConfigItem(Integer value) {
            super((short) 16, value);
        }
    }

    static public class TimeConfigItem extends ConfigItem {
        private int epochSeconds;
        private short millis, offsetMinutes;

        public TimeConfigItem() {
            this(-1, (short) -1, (short) -1);
        }

        public TimeConfigItem(int epochSeconds, short millis, short offsetMinutes) {
            this.epochSeconds = epochSeconds;
            this.millis = millis;
            this.offsetMinutes = offsetMinutes;
        }


        @Override
        public int getItemSize() {
            return 8;
        }

        @Override
        public short getId() {
            return (short) 12;
        }

        @Override
        public byte[] getContent() {
            ByteBuffer buffer = ByteBuffer.allocate(getItemSize());
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            buffer.putInt(this.epochSeconds);
            buffer.putShort(millis);
            buffer.putShort(offsetMinutes);
            return buffer.array();
        }

        @Override
        public void parseData(byte[] data) {
            if (data.length != 8) throw new RuntimeException("wrong data");

            ByteBuffer buffer = ByteBuffer.wrap(data);
            buffer.order(ByteOrder.LITTLE_ENDIAN);

            this.epochSeconds = buffer.getInt();
            this.millis = buffer.getShort();
            this.offsetMinutes = buffer.getShort();
        }
    }


    static public class FitnessConfigItem extends ConfigItem {
        boolean recognizeRunning = false;
        boolean askRunning = false;

        boolean recognizeBiking = false;
        boolean askBiking = false;

        boolean recognizeWalk = false;
        boolean askWalk = false;

        boolean recognizeRudder = false;
        boolean askRudder = false;

        public FitnessConfigItem(boolean recognizeRunning, boolean askRunning, boolean recognizeBiking, boolean askBiking, boolean recognizeWalk, boolean askWalk, boolean recognizeRudder, boolean askRudder) {
            this.recognizeRunning = recognizeRunning;
            this.askRunning = askRunning;
            this.recognizeBiking = recognizeBiking;
            this.askBiking = askBiking;
            this.recognizeWalk = recognizeWalk;
            this.askWalk = askWalk;
            this.recognizeRudder = recognizeRudder;
            this.askRudder = askRudder;
        }

        public FitnessConfigItem() {
        }

        ;

        @Override
        public int getItemSize() {
            return 30;
        }

        @Override
        public short getId() {
            return 0x14;
        }

        @Override
        public byte[] getContent() {
            byte[] data = new byte[]{
                    (byte) 0x01, (byte) 0x00, (byte) 0x03, (byte) 0x01, (byte) 0x01, (byte) 0x05, (byte) 0x02, (byte) 0x00, (byte) 0x0A, (byte) 0x01, (byte) 0x01, (byte) 0x01, (byte) 0x04, (byte) 0x00, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0x08, (byte) 0x00, (byte) 0x0A, (byte) 0x01, (byte) 0x01, (byte) 0x05, (byte) 0x09, (byte) 0x00, (byte) 0x03, (byte) 0x01, (byte) 0x01, (byte) 0x01
            };
            if (recognizeRunning) {
                data[1] |= 0x01;
                if (askRunning) {
                    data[1] |= 0x02;
                }
            }
            if (recognizeBiking) {
                data[7] |= 0x01;
                if (askBiking) {
                    data[7] |= 0x02;
                }
            }
            if (recognizeWalk) {
                data[19] |= 0x01;
                if (askWalk) {
                    data[19] |= 0x02;
                }
            }
            if (recognizeRudder) {
                data[25] |= 0x01;
                if (askRudder) {
                    data[25] |= 0x02;
                }
            }
            return data;
        }

        @Override
        public void parseData(byte[] data) {
            recognizeRunning = (data[1] & 0x01) == 0x01;
            askRunning = (data[1] & 0x02) == 0x02;

            recognizeBiking = (data[7] & 0x01) == 0x01;
            askBiking = (data[7] & 0x02) == 0x02;

            recognizeWalk = (data[19] & 0x01) == 0x01;
            askWalk = (data[19] & 0x02) == 0x02;

            recognizeRudder = (data[25] & 0x01) == 0x01;
            askRudder = (data[25] & 0x02) == 0x02;
        }

        @NonNull
        @Override
        public String toString() {
            return
                    "recognizeRunning: " + recognizeRunning + "   askRunning: " + askRunning + "\n" +
                            "recognizeBiking: " + recognizeBiking + "   askBiking: " + askBiking + "\n" +
                            "recognizeWalking: " + recognizeWalk + "   askWalk: " + askWalk + "\n" +
                            "recognizeRudder: " + recognizeRudder + "   askRudder: " + askRudder;
        }
    }
}

