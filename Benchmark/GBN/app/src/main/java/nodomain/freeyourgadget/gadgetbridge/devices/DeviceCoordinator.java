/*  Copyright (C) 2015-2021 Andreas Shimokawa, Carsten Pfeiffer, Daniele
    Gobbetti, Dmitry Markin, JohnnySun, José Rebelo, Matthieu Baerts, Nephiel,
    Uwe Hermann

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

import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.le.ScanFilter;
import android.content.Context;
import android.net.Uri;
import android.os.Build;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import nodomain.freeyourgadget.gadgetbridge.GBException;
import nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSpecificSettingsCustomizer;
import nodomain.freeyourgadget.gadgetbridge.capabilities.password.PasswordCapabilityImpl;
import nodomain.freeyourgadget.gadgetbridge.entities.DaoSession;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDeviceCandidate;
import nodomain.freeyourgadget.gadgetbridge.model.ActivitySample;
import nodomain.freeyourgadget.gadgetbridge.model.BatteryConfig;
import nodomain.freeyourgadget.gadgetbridge.model.DeviceType;

/**
 * This interface is implemented at least once for every supported gadget device.
 * It allows Gadgetbridge to generically deal with different kinds of devices
 * without actually knowing the details of any device.
 * <p/>
 * Instances will be created as needed and asked whether they support a given
 * device. If a coordinator answers true, it will be used to assist in handling
 * the given device.
 */
public interface DeviceCoordinator {
    String EXTRA_DEVICE_CANDIDATE = "nodomain.freeyourgadget.gadgetbridge.impl.GBDeviceCandidate.EXTRA_DEVICE_CANDIDATE";
    /**
     * Do not attempt to bond after discovery.
     */
    int BONDING_STYLE_NONE = 0;
    /**
     * Bond after discovery.
     * This is not recommended, as there are mobile devices on which bonding does not work.
     * Prefer to use #BONDING_STYLE_ASK instead.
     */
    int BONDING_STYLE_BOND = 1;
    /**
     * Let the user decide whether to bond or not after discovery.
     * Prefer this over #BONDING_STYLE_BOND
     */
    int BONDING_STYLE_ASK = 2;

    /**
     * A secret key has to be entered before connecting
     */
    int BONDING_STYLE_REQUIRE_KEY = 3;

    /**
     * Lazy pairing, i.e. device initiated pairing is requested
     */
    int BONDING_STYLE_LAZY = 4;

    enum ConnectionType{
        BLE(false, true),
        BL_CLASSIC(true, false),
        BOTH(true, true)
        ;
        boolean usesBluetoothClassic, usesBluetoothLE;

        ConnectionType(boolean usesBluetoothClassic, boolean usesBluetoothLE) {
            this.usesBluetoothClassic = usesBluetoothClassic;
            this.usesBluetoothLE = usesBluetoothLE;
        }

        public boolean usesBluetoothLE(){
            return usesBluetoothLE;
        }

        public boolean usesBluetoothClassic(){
            return usesBluetoothClassic;
        }
    }

    /**
     * Checks whether this coordinator handles the given candidate.
     * Returns the supported device type for the given candidate or
     * DeviceType.UNKNOWN
     *
     * @param candidate
     * @return the supported device type for the given candidate.
     */
    @NonNull
    DeviceType getSupportedType(GBDeviceCandidate candidate);

    /**
     * Returns the type of connection, Classic of BLE
     *
     * @return ConnectionType
     */
    ConnectionType getConnectionType();

    /**
     * Checks whether this coordinator handles the given candidate.
     *
     * @param candidate
     * @return true if this coordinator handles the given candidate.
     */
    boolean supports(GBDeviceCandidate candidate);

    /**
     * Checks whether this candidate handles the given device.
     *
     * @param device
     * @return true if this coordinator handles the given device.
     */
    boolean supports(GBDevice device);

    /**
     * Returns a list of scan filters that shall be used to discover devices supported
     * by this coordinator.
     * @return the list of scan filters, may be empty
     */
    @NonNull
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    Collection<? extends ScanFilter> createBLEScanFilters();

    GBDevice createDevice(GBDeviceCandidate candidate);

    /**
     * Deletes all information, including all related database content about the
     * given device.
     * @throws GBException
     */
    void deleteDevice(GBDevice device) throws GBException;

    /**
     * Returns the kind of device type this coordinator supports.
     *
     * @return
     */
    DeviceType getDeviceType();

    /**
     * Returns the Activity class to be started in order to perform a pairing of a
     * given device after its discovery.
     *
     * @return the activity class for pairing/initial authentication, or null if none
     */
    @Nullable
    Class<? extends Activity> getPairingActivity();

    @Nullable
    Class<? extends Activity> getCalibrationActivity();

    /**
     * Returns true if activity data fetching is supported by the device
     * (with this coordinator).
     * This enables the sync button in control center and the device can thus be asked to send the data
     * (as opposed the device pushing the data to us by itself)
     *
     * @return
     */
    boolean supportsActivityDataFetching();

    /**
     * Returns true if activity tracking is supported by the device
     * (with this coordinator).
     * This enables the ChartsActivity.
     *
     * @return
     */
    boolean supportsActivityTracking();

    /**
     * Indicates whether the device supports recording dedicated activity tracks, like
     * walking, hiking, running, swimming, etc. and retrieving the recorded
     * data. This is different from the constant activity tracking since the tracks are
     * usually recorded with additional features, like e.g. GPS.
     */
    boolean supportsActivityTracks();

    /**
     * Returns true if activity data fetching is supported AND possible at this
     * very moment. This will consider the device state (being connected/disconnected/busy...)
     * etc.
     *
     * @param device
     * @return
     */
    boolean allowFetchActivityData(GBDevice device);

    /**
     * Returns the sample provider for the device being supported.
     *
     * @return
     */
    SampleProvider<? extends ActivitySample> getSampleProvider(GBDevice device, DaoSession session);

    /**
     * Returns true if this device/coordinator supports installing files like firmware,
     * watchfaces, gps, resources, fonts...
     *
     * @return
     */
    boolean supportsFlashing();

    /**
     * Finds an install handler for the given uri that can install the given
     * uri on the device being managed.
     *
     * @param uri
     * @param context
     * @return the install handler or null if that uri cannot be installed on the device
     */
    InstallHandler findInstallHandler(Uri uri, Context context);

    /**
     * Returns true if this device/coordinator supports taking screenshots.
     *
     * @return
     */
    boolean supportsScreenshots();

    /**
     * Returns the number of alarms this device/coordinator supports
     * Shall return 0 also if it is not possible to set alarms via
     * protocol, but only on the smart device itself.
     *
     * @return
     */
    int getAlarmSlotCount();

    /**
     * Returns true if this device/coordinator supports alarms with smart wakeup
     * @return
     */
    boolean supportsSmartWakeup(GBDevice device);

    /**
     * Returns true if this device/coordinator supports alarm snoozing
     * @return
     */
    boolean supportsAlarmSnoozing();

    /**
     * Returns true if this device/coordinator supports alarm descriptions
     * @return
     */
    boolean supportsAlarmDescription(GBDevice device);

    /**
     * Returns true if the given device supports heart rate measurements.
     * @return
     */
    boolean supportsHeartRateMeasurement(GBDevice device);

    /**
     * Returns the readable name of the manufacturer.
     */
    String getManufacturer();

    /**
     * Returns true if this device/coordinator supports managing device apps.
     *
     * @return
     */
    boolean supportsAppsManagement();

    /**
     * Returns the Activity class that will be used to manage device apps.
     *
     * @return
     */
    Class<? extends Activity> getAppsManagementActivity();

    /**
     * Returns the Activity class that will be used to design watchfaces.
     *
     * @return
     */
    Class<? extends Activity> getWatchfaceDesignerActivity();

    /**
     * Returns the device app cache directory.
     */
    File getAppCacheDir() throws IOException;

    /**
     * Returns a String containing the device app sort order filename.
     */
    String getAppCacheSortFilename();

    /**
     * Returns a String containing the file extension for watch apps.
     */
    String getAppFileExtension();

    /**
     * Indicated whether the device supports fetching a list of its apps.
     */
    boolean supportsAppListFetching();

    /**
     * Indicates whether the device supports reordering of apps.
     */
    boolean supportsAppReordering();

    /**
     * Returns how/if the given device should be bonded before connecting to it.
     */
    int getBondingStyle();

    /**
     * Indicates whether the device has some kind of calender we can sync to.
     * Also used for generated sunrise/sunset events
     */
    boolean supportsCalendarEvents();

    /**
     * Indicates whether the device supports getting a stream of live data.
     * This can be live HR, steps etc.
     */
    boolean supportsRealtimeData();

    /**
     * Indicates whether the device supports current weather and/or weather
     * forecast display.
     */
    boolean supportsWeather();

    /**
     * Indicates whether the device supports being found by vibrating, 
     * making some sound or lighting up
     */
    boolean supportsFindDevice();

    /**
     * Indicates whether the device supports displaying music information
     * like artist, title, album, play state etc.
     */
    boolean supportsMusicInfo();

    /**
     * Indicates the maximum reminder message length.
     */
    int getMaximumReminderMessageLength();

    /**
     * Indicates the maximum number of reminder slots available in the device.
     */
    int getReminderSlotCount();

    /**
     * Indicates the maximum number of slots available for world clocks in the device.
     */
    int getWorldClocksSlotCount();

    /**
     * Indicates the maximum label length for a world clock in the device.
     */
    int getWorldClocksLabelLength();

    /**
     * Indicates whether the device has an led which supports custom colors
     */
    boolean supportsLedColor();

    /**
     * Indicates whether the device's led supports any RGB color,
     * or only preset colors
     */
    boolean supportsRgbLedColor();

    /**
     * Returns the preset colors supported by the device, if any, in ARGB, with alpha = 255
     */
    @NonNull
    int[] getColorPresets();

    /**
     * Indicates whether the device supports unicode emojis.
     */
    boolean supportsUnicodeEmojis();

    /**
     * Returns device specific settings related to connection
     *
     * @return int[]
     */
    int[] getSupportedDeviceSpecificConnectionSettings();

    /**
     * Returns device specific settings related to the application itself
     * charts settings and so on
     * @return int[]
     */
    int[] getSupportedDeviceSpecificApplicationSettings();

    /**
     * Returns device specific settings related to the Auth key
     * @return int[]
     */
    int[] getSupportedDeviceSpecificAuthenticationSettings();

    /**
     * Indicates which device specific settings the device supports (not per device type or family, but unique per device).
     */
    int[] getSupportedDeviceSpecificSettings(GBDevice device);

    /**
     * Returns the {@link DeviceSpecificSettingsCustomizer}, allowing for the customization of the devices specific settings screen.
     */
    DeviceSpecificSettingsCustomizer getDeviceSpecificSettingsCustomizer(GBDevice device);

    /**
     * Indicates which device specific language the device supports
     */
    String[] getSupportedLanguageSettings(GBDevice device);

    /**
     *
     * Multiple battery support: Indicates how many batteries the device has.
     * 1 is default, 3 is maximum at the moment (as per UI layout)
     * 0 will disable the battery from the UI
     */
    int getBatteryCount();

    BatteryConfig[] getBatteryConfig();

    boolean supportsPowerOff();

    PasswordCapabilityImpl.Mode getPasswordCapability();
}
