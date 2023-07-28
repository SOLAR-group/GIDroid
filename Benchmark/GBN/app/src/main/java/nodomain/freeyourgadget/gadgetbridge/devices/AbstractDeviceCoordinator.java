/*  Copyright (C) 2015-2021 Andreas Shimokawa, Carsten Pfeiffer, Daniele
    Gobbetti, Dmitry Markin, José Rebelo, Matthieu Baerts, Nephiel, Petr Vaněk,
    Taavi Eomäe

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
package nodomain.freeyourgadget.gadgetbridge.devices;

import android.app.Activity;
import android.bluetooth.BluetoothClass;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanFilter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import de.greenrobot.dao.query.QueryBuilder;
import nodomain.freeyourgadget.gadgetbridge.GBApplication;
import nodomain.freeyourgadget.gadgetbridge.GBException;
import nodomain.freeyourgadget.gadgetbridge.R;
import nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSpecificSettingsCustomizer;
import nodomain.freeyourgadget.gadgetbridge.capabilities.password.PasswordCapabilityImpl;
import nodomain.freeyourgadget.gadgetbridge.database.DBHandler;
import nodomain.freeyourgadget.gadgetbridge.database.DBHelper;
import nodomain.freeyourgadget.gadgetbridge.devices.miband.MiBandConst;
import nodomain.freeyourgadget.gadgetbridge.entities.AlarmDao;
import nodomain.freeyourgadget.gadgetbridge.entities.BatteryLevelDao;
import nodomain.freeyourgadget.gadgetbridge.entities.DaoSession;
import nodomain.freeyourgadget.gadgetbridge.entities.Device;
import nodomain.freeyourgadget.gadgetbridge.entities.DeviceAttributesDao;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDeviceCandidate;
import nodomain.freeyourgadget.gadgetbridge.model.BatteryConfig;
import nodomain.freeyourgadget.gadgetbridge.util.Prefs;

import static nodomain.freeyourgadget.gadgetbridge.GBApplication.getPrefs;

public abstract class AbstractDeviceCoordinator implements DeviceCoordinator {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractDeviceCoordinator.class);

    @Override
    public final boolean supports(GBDeviceCandidate candidate) {
        return getSupportedType(candidate).isSupported();
    }

    @Override
    public ConnectionType getConnectionType() {
        return ConnectionType.BOTH;
    }

    @Override
    public boolean supports(GBDevice device) {
        return getDeviceType().equals(device.getType());
    }

    @NonNull
    @Override
    public Collection<? extends ScanFilter> createBLEScanFilters() {
        return Collections.emptyList();
    }

    @Override
    public GBDevice createDevice(GBDeviceCandidate candidate) {
        GBDevice gbDevice = new GBDevice(candidate.getDevice().getAddress(), candidate.getName(), null, null, getDeviceType());
        for (BatteryConfig batteryConfig : getBatteryConfig()) {
            gbDevice.setBatteryIcon(batteryConfig.getBatteryIcon(), batteryConfig.getBatteryIndex());
            gbDevice.setBatteryLabel(batteryConfig.getBatteryLabel(), batteryConfig.getBatteryIndex());
        }
        return gbDevice;
    }

    @Override
    public void deleteDevice(final GBDevice gbDevice) throws GBException {
        LOG.info("will try to delete device: " + gbDevice.getName());
        if (gbDevice.isConnected() || gbDevice.isConnecting()) {
            GBApplication.deviceService().disconnect(gbDevice);
        }
        Prefs prefs = getPrefs();

        String lastDevice = prefs.getPreferences().getString("last_device_address","");
        if (gbDevice.getAddress().equals(lastDevice)) {
            LOG.debug("#1605 removing last device");
            prefs.getPreferences().edit().remove("last_device_address").apply();
        }

        String macAddress = prefs.getPreferences().getString(MiBandConst.PREF_MIBAND_ADDRESS,"");
        if (gbDevice.getAddress().equals(macAddress)) {
            LOG.debug("#1605 removing devel miband");
            prefs.getPreferences().edit().remove(MiBandConst.PREF_MIBAND_ADDRESS).apply();
        }

        GBApplication.deleteDeviceSpecificSharedPrefs(gbDevice.getAddress());

        try (DBHandler dbHandler = GBApplication.acquireDB()) {
            DaoSession session = dbHandler.getDaoSession();
            Device device = DBHelper.findDevice(gbDevice, session);
            if (device != null) {
                deleteDevice(gbDevice, device, session);
                QueryBuilder<?> qb = session.getDeviceAttributesDao().queryBuilder();
                qb.where(DeviceAttributesDao.Properties.DeviceId.eq(device.getId())).buildDelete().executeDeleteWithoutDetachingEntities();
                QueryBuilder<?> batteryLevelQueryBuilder = session.getBatteryLevelDao().queryBuilder();
                batteryLevelQueryBuilder.where(BatteryLevelDao.Properties.DeviceId.eq(device.getId())).buildDelete().executeDeleteWithoutDetachingEntities();
                QueryBuilder<?> alarmDeviceQueryBuilder = session.getAlarmDao().queryBuilder();
                alarmDeviceQueryBuilder.where(AlarmDao.Properties.DeviceId.eq(device.getId())).buildDelete().executeDeleteWithoutDetachingEntities();
                session.getDeviceDao().delete(device);
            } else {
                LOG.info("device to delete not found in db: " + gbDevice);
            }
        } catch (Exception e) {
            throw new GBException("Error deleting device: " + e.getMessage(), e);
        }
    }

    /**
     * Hook for subclasses to perform device-specific deletion logic, e.g. db cleanup.
     *
     * @param gbDevice the GBDevice
     * @param device   the corresponding database Device
     * @param session  the session to use
     * @throws GBException
     */
    protected abstract void deleteDevice(@NonNull GBDevice gbDevice, @NonNull Device device, @NonNull DaoSession session) throws GBException;

    @Override
    public boolean allowFetchActivityData(GBDevice device) {
        return device.isInitialized() && !device.isBusy() && supportsActivityDataFetching();
    }

    public boolean isHealthWearable(BluetoothDevice device) {
        BluetoothClass bluetoothClass = device.getBluetoothClass();
        if (bluetoothClass == null) {
            LOG.warn("unable to determine bluetooth device class of " + device);
            return false;
        }
        if (bluetoothClass.getMajorDeviceClass() == BluetoothClass.Device.Major.WEARABLE
                || bluetoothClass.getMajorDeviceClass() == BluetoothClass.Device.Major.UNCATEGORIZED) {
            int deviceClasses =
                    BluetoothClass.Device.HEALTH_BLOOD_PRESSURE
                            | BluetoothClass.Device.HEALTH_DATA_DISPLAY
                            | BluetoothClass.Device.HEALTH_PULSE_RATE
                            | BluetoothClass.Device.HEALTH_WEIGHING
                            | BluetoothClass.Device.HEALTH_UNCATEGORIZED
                            | BluetoothClass.Device.HEALTH_PULSE_OXIMETER
                            | BluetoothClass.Device.HEALTH_GLUCOSE;

            return (bluetoothClass.getDeviceClass() & deviceClasses) != 0;
        }
        return false;
    }

    @Override
    public File getAppCacheDir() throws IOException {
        return null;
    }

    @Override
    public String getAppCacheSortFilename() {
        return null;
    }

    @Override
    public String getAppFileExtension() {
        return null;
    }

    @Override
    public boolean supportsAppListFetching() {
        return false;
    }

    @Override
    public boolean supportsFlashing() { return false; }

    @Override
    public boolean supportsAppReordering() {
        return false;
    }

    @Nullable
    @Override
    public Class<? extends Activity> getWatchfaceDesignerActivity() {
        return null;
    }

    @Override
    public int getBondingStyle() {
        return BONDING_STYLE_ASK;
    }

    @Override
    public boolean supportsActivityTracks() {
        return false;
    }

    @Override
    public boolean supportsAlarmSnoozing() {
        return false;
    }

    @Override
    public boolean supportsAlarmDescription(GBDevice device) {
        return false;
    }

    @Override
    public boolean supportsMusicInfo() {
        return false;
    }

    @Override
    public boolean supportsLedColor() {
        return false;
    }

    @Override
    public int getMaximumReminderMessageLength() {
        return 0;
    }

    @Override
    public int getReminderSlotCount() {
        return 0;
    }

    @Override
    public int getWorldClocksSlotCount() {
        return 0;
    }

    @Override
    public int getWorldClocksLabelLength() {
        return 10;
    }

    @Override
    public boolean supportsRgbLedColor() {
        return false;
    }

    @NonNull
    @Override
    public int[] getColorPresets() {
        return new int[0];
    }

    @Override
    public boolean supportsUnicodeEmojis() {
        return false;
    }

    @Override
    public int[] getSupportedDeviceSpecificConnectionSettings() {
        int[] settings = new int[0];
        ConnectionType connectionType = getConnectionType();

        if(connectionType.usesBluetoothLE()){
            settings = ArrayUtils.insert(0, settings, R.xml.devicesettings_reconnect_ble);
        }
        if(connectionType.usesBluetoothClassic()){
            settings = ArrayUtils.insert(0, settings, R.xml.devicesettings_reconnect_bl_classic);
        }

        return settings;
    }
    @Override
    public int[] getSupportedDeviceSpecificApplicationSettings() {
        return new int[0];
    }

    @Override
    public int[] getSupportedDeviceSpecificSettings(GBDevice device) {
        return new int[0];
    }

    @Override
    public int[] getSupportedDeviceSpecificAuthenticationSettings() {
        return new int[0];
    }

    @Override
    public DeviceSpecificSettingsCustomizer getDeviceSpecificSettingsCustomizer(GBDevice device) {
        return null;
    }

    @Override
    public String[] getSupportedLanguageSettings(GBDevice device) {
        return null;
    }

    @Nullable
    @Override
    public Class<? extends Activity> getCalibrationActivity() {
        return null;
    }

    @Override
    public int getBatteryCount() {
        return 1;
    } //multiple battery support, default is 1, maximum is 3, 0 will disable the battery in UI

    @Override
    public BatteryConfig[] getBatteryConfig() {
        return new BatteryConfig[0];
    }

    @Override
    public boolean supportsPowerOff() {
        return false;
    }

    @Override
    public PasswordCapabilityImpl.Mode getPasswordCapability() {
        return PasswordCapabilityImpl.Mode.NONE;
    }
}
