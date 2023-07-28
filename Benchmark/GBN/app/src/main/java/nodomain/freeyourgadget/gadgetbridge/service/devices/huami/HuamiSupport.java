/*  Copyright (C) 2015-2021 Andreas Shimokawa, Carsten Pfeiffer, Christian
    Fischer, Daniele Gobbetti, Dmitry Markin, JohnnySun, José Rebelo, Julien
    Pivotto, Kasha, Michal Novotny, Petr Vaněk, Sebastian Kranz, Sergey Trofimov,
    Steffen Liebergeld, Taavi Eomäe, Zhong Jianxin

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

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.media.AudioManager;
import android.net.Uri;
import android.widget.Toast;

import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import net.e175.klaus.solarpositioning.DeltaT;
import net.e175.klaus.solarpositioning.SPA;

import org.apache.commons.lang3.ArrayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.threeten.bp.Instant;
import org.threeten.bp.ZoneId;
import org.threeten.bp.zone.ZoneOffsetTransition;
import org.threeten.bp.zone.ZoneRules;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import cyanogenmod.weather.util.WeatherUtils;
import nodomain.freeyourgadget.gadgetbridge.GBApplication;
import nodomain.freeyourgadget.gadgetbridge.Logging;
import nodomain.freeyourgadget.gadgetbridge.R;
import nodomain.freeyourgadget.gadgetbridge.activities.SettingsActivity;
import nodomain.freeyourgadget.gadgetbridge.capabilities.password.PasswordCapabilityImpl;
import nodomain.freeyourgadget.gadgetbridge.database.DBHandler;
import nodomain.freeyourgadget.gadgetbridge.database.DBHelper;
import nodomain.freeyourgadget.gadgetbridge.deviceevents.GBDeviceEventBatteryInfo;
import nodomain.freeyourgadget.gadgetbridge.deviceevents.GBDeviceEventCallControl;
import nodomain.freeyourgadget.gadgetbridge.deviceevents.GBDeviceEventFindPhone;
import nodomain.freeyourgadget.gadgetbridge.deviceevents.GBDeviceEventMusicControl;
import nodomain.freeyourgadget.gadgetbridge.deviceevents.GBDeviceEventVersionInfo;
import nodomain.freeyourgadget.gadgetbridge.devices.DeviceCoordinator;
import nodomain.freeyourgadget.gadgetbridge.devices.SampleProvider;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.ActivateDisplayOnLift;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.ActivateDisplayOnLiftSensitivity;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.DisconnectNotificationSetting;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiCoordinator;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiFWHelper;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiService;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiWeatherConditions;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.amazfitbip.AmazfitBipService;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.miband2.MiBand2FWHelper;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.miband3.MiBand3Coordinator;
import nodomain.freeyourgadget.gadgetbridge.devices.huami.miband3.MiBand3Service;
import nodomain.freeyourgadget.gadgetbridge.devices.miband.DateTimeDisplay;
import nodomain.freeyourgadget.gadgetbridge.devices.miband.DoNotDisturb;
import nodomain.freeyourgadget.gadgetbridge.devices.miband.MiBand2SampleProvider;
import nodomain.freeyourgadget.gadgetbridge.devices.miband.MiBandConst;
import nodomain.freeyourgadget.gadgetbridge.devices.miband.MiBandCoordinator;
import nodomain.freeyourgadget.gadgetbridge.devices.miband.MiBandService;
import nodomain.freeyourgadget.gadgetbridge.devices.miband.VibrationProfile;
import nodomain.freeyourgadget.gadgetbridge.entities.DaoSession;
import nodomain.freeyourgadget.gadgetbridge.entities.Device;
import nodomain.freeyourgadget.gadgetbridge.entities.MiBandActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.User;
import nodomain.freeyourgadget.gadgetbridge.externalevents.gps.GBLocationManager;
import nodomain.freeyourgadget.gadgetbridge.externalevents.opentracks.OpenTracksController;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice.State;
import nodomain.freeyourgadget.gadgetbridge.model.ActivitySample;
import nodomain.freeyourgadget.gadgetbridge.model.ActivityUser;
import nodomain.freeyourgadget.gadgetbridge.model.Alarm;
import nodomain.freeyourgadget.gadgetbridge.model.CalendarEventSpec;
import nodomain.freeyourgadget.gadgetbridge.util.calendar.CalendarEvent;
import nodomain.freeyourgadget.gadgetbridge.util.calendar.CalendarManager;
import nodomain.freeyourgadget.gadgetbridge.model.CallSpec;
import nodomain.freeyourgadget.gadgetbridge.model.CannedMessagesSpec;
import nodomain.freeyourgadget.gadgetbridge.model.DeviceService;
import nodomain.freeyourgadget.gadgetbridge.model.DeviceType;
import nodomain.freeyourgadget.gadgetbridge.model.MusicSpec;
import nodomain.freeyourgadget.gadgetbridge.model.MusicStateSpec;
import nodomain.freeyourgadget.gadgetbridge.model.NotificationSpec;
import nodomain.freeyourgadget.gadgetbridge.model.NotificationType;
import nodomain.freeyourgadget.gadgetbridge.model.Reminder;
import nodomain.freeyourgadget.gadgetbridge.model.Weather;
import nodomain.freeyourgadget.gadgetbridge.model.WeatherSpec;
import nodomain.freeyourgadget.gadgetbridge.model.WorldClock;
import nodomain.freeyourgadget.gadgetbridge.service.btle.AbstractBTLEDeviceSupport;
import nodomain.freeyourgadget.gadgetbridge.service.btle.BLETypeConversions;
import nodomain.freeyourgadget.gadgetbridge.service.btle.BtLEAction;
import nodomain.freeyourgadget.gadgetbridge.service.btle.GattCharacteristic;
import nodomain.freeyourgadget.gadgetbridge.service.btle.GattService;
import nodomain.freeyourgadget.gadgetbridge.service.btle.TransactionBuilder;
import nodomain.freeyourgadget.gadgetbridge.service.btle.actions.AbortTransactionAction;
import nodomain.freeyourgadget.gadgetbridge.service.btle.actions.ConditionalWriteAction;
import nodomain.freeyourgadget.gadgetbridge.service.btle.actions.SetDeviceStateAction;
import nodomain.freeyourgadget.gadgetbridge.service.btle.profiles.IntentListener;
import nodomain.freeyourgadget.gadgetbridge.service.btle.profiles.alertnotification.AlertCategory;
import nodomain.freeyourgadget.gadgetbridge.service.btle.profiles.alertnotification.AlertNotificationProfile;
import nodomain.freeyourgadget.gadgetbridge.service.btle.profiles.alertnotification.NewAlert;
import nodomain.freeyourgadget.gadgetbridge.service.btle.profiles.deviceinfo.DeviceInfoProfile;
import nodomain.freeyourgadget.gadgetbridge.service.devices.common.SimpleNotification;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.actions.StopNotificationAction;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.miband2.Mi2NotificationStrategy;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.miband2.Mi2TextNotificationStrategy;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.operations.FetchActivityOperation;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.operations.InitOperation;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.operations.InitOperation2021;
import nodomain.freeyourgadget.gadgetbridge.service.devices.huami.operations.UpdateFirmwareOperation;
import nodomain.freeyourgadget.gadgetbridge.service.devices.miband.NotificationStrategy;
import nodomain.freeyourgadget.gadgetbridge.service.devices.miband.RealtimeSamplesSupport;
import nodomain.freeyourgadget.gadgetbridge.service.serial.GBDeviceProtocol;
import nodomain.freeyourgadget.gadgetbridge.util.AlarmUtils;
import nodomain.freeyourgadget.gadgetbridge.util.CheckSums;
import nodomain.freeyourgadget.gadgetbridge.util.CryptoUtils;
import nodomain.freeyourgadget.gadgetbridge.util.DeviceHelper;
import nodomain.freeyourgadget.gadgetbridge.util.GB;
import nodomain.freeyourgadget.gadgetbridge.util.GBPrefs;
import nodomain.freeyourgadget.gadgetbridge.util.NotificationUtils;
import nodomain.freeyourgadget.gadgetbridge.util.Prefs;
import nodomain.freeyourgadget.gadgetbridge.util.StringUtils;
import nodomain.freeyourgadget.gadgetbridge.util.Version;

import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_ACTIVATE_DISPLAY_ON_LIFT;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_ALLOW_HIGH_MTU;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_BT_CONNECTED_ADVERTISEMENT;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_DATEFORMAT;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_DISPLAY_ON_LIFT_SENSITIVITY;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_DISPLAY_ON_LIFT_START;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_DISPLAY_ON_LIFT_END;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_DISCONNECT_NOTIFICATION;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_DISCONNECT_NOTIFICATION_START;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_DISCONNECT_NOTIFICATION_END;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_DO_NOT_DISTURB;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_DO_NOT_DISTURB_START;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_DO_NOT_DISTURB_END;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_DO_NOT_DISTURB_LIFT_WRIST;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_HEARTRATE_ACTIVITY_MONITORING;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_HEARTRATE_ALERT_ENABLED;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_HEARTRATE_ALERT_THRESHOLD;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_HEARTRATE_STRESS_MONITORING;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_INACTIVITY_ENABLE;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_INACTIVITY_START;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_INACTIVITY_END;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_INACTIVITY_THRESHOLD;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_INACTIVITY_DND;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_INACTIVITY_DND_START;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_INACTIVITY_DND_END;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_LANGUAGE;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_RESERVER_ALARMS_CALENDAR;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_RESERVER_REMINDERS_CALENDAR;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_SOUNDS;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_SYNC_CALENDAR;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_TIMEFORMAT;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_USER_FITNESS_GOAL_NOTIFICATION;
import static nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst.PREF_WEARLOCATION;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_BUTTON_ACTION_SELECTION_BROADCAST;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_BUTTON_ACTION_SELECTION_FITNESS_APP_START;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_BUTTON_ACTION_SELECTION_FITNESS_APP_STOP;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_BUTTON_ACTION_SELECTION_FITNESS_APP_TOGGLE;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_BUTTON_ACTION_SELECTION_OFF;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_DEVICE_ACTION_FELL_SLEEP_BROADCAST;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_DEVICE_ACTION_FELL_SLEEP_SELECTION;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_DEVICE_ACTION_SELECTION_OFF;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_DEVICE_ACTION_START_NON_WEAR_BROADCAST;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_DEVICE_ACTION_START_NON_WEAR_SELECTION;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_DEVICE_ACTION_WOKE_UP_BROADCAST;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_DEVICE_ACTION_WOKE_UP_SELECTION;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_COUNT_ALARM;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_COUNT_APP_ALERTS;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_COUNT_EVENT_REMINDER;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_COUNT_FIND_BAND;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_COUNT_GOAL_NOTIFICATION;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_COUNT_IDLE_ALERTS;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_COUNT_INCOMING_CALL;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_COUNT_INCOMING_SMS;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_COUNT_PREFIX;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_PROFILE_ALARM;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_PROFILE_APP_ALERTS;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_PROFILE_EVENT_REMINDER;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_PROFILE_FIND_BAND;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_PROFILE_GOAL_NOTIFICATION;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_PROFILE_IDLE_ALERTS;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_PROFILE_INCOMING_CALL;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_PROFILE_INCOMING_SMS;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_PROFILE_PREFIX;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_TRY_ALARM;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_TRY_APP_ALERTS;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_TRY_EVENT_REMINDER;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_TRY_FIND_BAND;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_TRY_GOAL_NOTIFICATION;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_TRY_IDLE_ALERTS;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_TRY_INCOMING_CALL;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_TRY_INCOMING_SMS;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiConst.PREF_HUAMI_VIBRATION_TRY_PREFIX;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiService.COMMAND_ALARMS;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiService.COMMAND_ALARMS_WITH_TIMES;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiService.COMMAND_GPS_VERSION;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiService.COMMAND_WORKOUT_ACTIVITY_TYPES;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiService.DISPLAY_ITEM_BIT_CLOCK;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiService.ENDPOINT_DISPLAY;
import static nodomain.freeyourgadget.gadgetbridge.devices.huami.HuamiService.ENDPOINT_DISPLAY_ITEMS;
import static nodomain.freeyourgadget.gadgetbridge.devices.miband.MiBandConst.DEFAULT_VALUE_VIBRATION_COUNT;
import static nodomain.freeyourgadget.gadgetbridge.devices.miband.MiBandConst.DEFAULT_VALUE_VIBRATION_PROFILE;
import static nodomain.freeyourgadget.gadgetbridge.devices.miband.MiBandConst.VIBRATION_COUNT;
import static nodomain.freeyourgadget.gadgetbridge.devices.miband.MiBandConst.VIBRATION_PROFILE;
import static nodomain.freeyourgadget.gadgetbridge.devices.miband.MiBandConst.getNotificationPrefIntValue;
import static nodomain.freeyourgadget.gadgetbridge.devices.miband.MiBandConst.getNotificationPrefStringValue;
import static nodomain.freeyourgadget.gadgetbridge.model.ActivityUser.PREF_USER_GENDER;
import static nodomain.freeyourgadget.gadgetbridge.model.ActivityUser.PREF_USER_HEIGHT_CM;
import static nodomain.freeyourgadget.gadgetbridge.model.ActivityUser.PREF_USER_NAME;
import static nodomain.freeyourgadget.gadgetbridge.model.ActivityUser.PREF_USER_WEIGHT_KG;
import static nodomain.freeyourgadget.gadgetbridge.model.ActivityUser.PREF_USER_YEAR_OF_BIRTH;
import static nodomain.freeyourgadget.gadgetbridge.service.btle.GattCharacteristic.UUID_CHARACTERISTIC_ALERT_LEVEL;

public abstract class HuamiSupport extends AbstractBTLEDeviceSupport {

    // We introduce key press counter for notification purposes
    private static int currentButtonActionId = 0;
    private static int currentButtonPressCount = 0;
    private static long currentButtonPressTime = 0;
    private static long currentButtonTimerActivationTime = 0;

    public byte[] sharedSessionKey;
    public int encryptedSequenceNr;
    public byte handle;
    public byte getNextHandle() {
        return handle++;
    }


    private Timer buttonActionTimer = null;

    private static final Logger LOG = LoggerFactory.getLogger(HuamiSupport.class);
    private final DeviceInfoProfile<HuamiSupport> deviceInfoProfile;
    private final IntentListener mListener = new IntentListener() {
        @Override
        public void notify(Intent intent) {
            String s = intent.getAction();
            if (DeviceInfoProfile.ACTION_DEVICE_INFO.equals(s)) {
                handleDeviceInfo((nodomain.freeyourgadget.gadgetbridge.service.btle.profiles.deviceinfo.DeviceInfo) intent.getParcelableExtra(DeviceInfoProfile.EXTRA_DEVICE_INFO));
            }
        }
    };

    private BluetoothGattCharacteristic characteristicHRControlPoint;
    private BluetoothGattCharacteristic characteristicChunked;

    private BluetoothGattCharacteristic characteristicChunked2021Write;
    private BluetoothGattCharacteristic characteristicChunked2021Read;

    private boolean needsAuth;
    private volatile boolean telephoneRinging;
    private volatile boolean isLocatingDevice;

    private final GBDeviceEventVersionInfo versionCmd = new GBDeviceEventVersionInfo();
    private final GBDeviceEventBatteryInfo batteryCmd = new GBDeviceEventBatteryInfo();
    private final GBDeviceEventFindPhone findPhoneEvent = new GBDeviceEventFindPhone();

    private RealtimeSamplesSupport realtimeSamplesSupport;

    protected boolean isMusicAppStarted = false;
    protected MusicSpec bufferMusicSpec = null;
    protected MusicStateSpec bufferMusicStateSpec = null;
    private boolean heartRateNotifyEnabled;
    private int mMTU = 23;
    protected int mActivitySampleSize = 4;
    protected boolean force2021Protocol = false;
    private HuamiChunked2021Decoder huamiChunked2021Decoder;

    public HuamiSupport() {
        this(LOG);
    }

    public HuamiSupport(Logger logger) {
        super(logger);
        addSupportedService(GattService.UUID_SERVICE_GENERIC_ACCESS);
        addSupportedService(GattService.UUID_SERVICE_GENERIC_ATTRIBUTE);
        addSupportedService(GattService.UUID_SERVICE_HEART_RATE);
        addSupportedService(GattService.UUID_SERVICE_IMMEDIATE_ALERT);
        addSupportedService(GattService.UUID_SERVICE_DEVICE_INFORMATION);
        addSupportedService(GattService.UUID_SERVICE_ALERT_NOTIFICATION);

        addSupportedService(MiBandService.UUID_SERVICE_MIBAND_SERVICE);
        addSupportedService(MiBandService.UUID_SERVICE_MIBAND2_SERVICE);
        addSupportedService(HuamiService.UUID_SERVICE_FIRMWARE_SERVICE);

        deviceInfoProfile = new DeviceInfoProfile<>(this);
        deviceInfoProfile.addListener(mListener);
        addSupportedProfile(deviceInfoProfile);
    }

    @Override
    protected TransactionBuilder initializeDevice(TransactionBuilder builder) {
        try {
            byte authFlags = getAuthFlags();
            byte cryptFlags = getCryptFlags();
            heartRateNotifyEnabled = false;
            boolean authenticate = needsAuth && (cryptFlags == 0x00);
            needsAuth = false;
            characteristicChunked2021Read = getCharacteristic(HuamiService.UUID_CHARACTERISTIC_CHUNKEDTRANSFER_2021_READ);
            if (characteristicChunked2021Read != null) {
                huamiChunked2021Decoder = new HuamiChunked2021Decoder(this);
            }
            characteristicChunked2021Write = getCharacteristic(HuamiService.UUID_CHARACTERISTIC_CHUNKEDTRANSFER_2021_WRITE);
            if (characteristicChunked2021Write != null && GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()).getBoolean("force_new_protocol", false)) {
                force2021Protocol = true;
                new InitOperation2021(authenticate, authFlags, cryptFlags, this, builder).perform();
            } else {
                new InitOperation(authenticate, authFlags, cryptFlags, this, builder).perform();
            }
            characteristicHRControlPoint = getCharacteristic(GattCharacteristic.UUID_CHARACTERISTIC_HEART_RATE_CONTROL_POINT);
            characteristicChunked = getCharacteristic(HuamiService.UUID_CHARACTERISTIC_CHUNKEDTRANSFER);
        } catch (IOException e) {
            GB.toast(getContext(), "Initializing Huami device failed", Toast.LENGTH_SHORT, GB.ERROR, e);
        }
        return builder;
    }

    protected byte getAuthFlags() {
        return HuamiService.AUTH_BYTE;
    }

    public byte getCryptFlags() {
        return 0x00;
    }

    public boolean supportsSunriseSunsetWindHumidity() {
        return false;
    }

    /**
     * Return the wind speed as sting in a format that is supported by the device.
     *
     * A lot of devices only support "levels", in GB we send the Beaufort speed.
     * Override this in the device specific support class if other, more clear,
     * formats are supported.
     *
     * @param weatherSpec
     * @return
     */
    public String windSpeedString(WeatherSpec weatherSpec){
        return weatherSpec.windSpeedAsBeaufort() + ""; // cast to string
    }

    /**
     * Returns the given date/time (calendar) as a byte sequence, suitable for sending to the
     * Mi Band 2 (or derivative). The band appears to not handle DST offsets, so we simply add this
     * to the timezone.
     *
     * @param calendar
     * @param precision
     * @return
     */
    public byte[] getTimeBytes(Calendar calendar, TimeUnit precision) {
        byte[] bytes;
        if (precision == TimeUnit.MINUTES) {
            bytes = BLETypeConversions.shortCalendarToRawBytes(calendar);
        } else if (precision == TimeUnit.SECONDS) {
            bytes = BLETypeConversions.calendarToRawBytes(calendar);
        } else {
            throw new IllegalArgumentException("Unsupported precision, only MINUTES and SECONDS are supported till now");
        }
        byte[] tail = new byte[] { 0, BLETypeConversions.mapTimeZone(calendar, BLETypeConversions.TZ_FLAG_INCLUDE_DST_IN_TZ) };
        // 0 = adjust reason bitflags? or DST offset?? , timezone
//        byte[] tail = new byte[] { 0x2 }; // reason
        byte[] all = BLETypeConversions.join(bytes, tail);
        return all;
    }

    public Calendar fromTimeBytes(byte[] bytes) {
        GregorianCalendar timestamp = BLETypeConversions.rawBytesToCalendar(bytes);
        return timestamp;
    }

    public HuamiSupport setCurrentTimeWithService(TransactionBuilder builder) {
        GregorianCalendar now = BLETypeConversions.createCalendar();
        byte[] bytes = getTimeBytes(now, TimeUnit.SECONDS);
        builder.write(getCharacteristic(GattCharacteristic.UUID_CHARACTERISTIC_CURRENT_TIME), bytes);
        return this;
    }

    public HuamiSupport setLowLatency(TransactionBuilder builder) {
        // TODO: low latency?
        return this;
    }

    public HuamiSupport setHighLatency(TransactionBuilder builder) {
        // TODO: high latency?
        return this;
    }

    /**
     * Last action of initialization sequence. Sets the device to initialized.
     * It is only invoked if all other actions were successfully run, so the device
     * must be initialized, then.
     *
     * @param builder
     */
    public void setInitialized(TransactionBuilder builder) {
        builder.add(new SetDeviceStateAction(gbDevice, State.INITIALIZED, getContext()));
    }

    // MB2: AVL
    // TODO: tear down the notifications on quit
    public HuamiSupport enableNotifications(TransactionBuilder builder, boolean enable) {
        builder.notify(getCharacteristic(MiBandService.UUID_CHARACTERISTIC_NOTIFICATION), enable);
        builder.notify(getCharacteristic(GattService.UUID_SERVICE_CURRENT_TIME), enable);
        // Notify CHARACTERISTIC9 to receive random auth code
        builder.notify(getCharacteristic(HuamiService.UUID_CHARACTERISTIC_AUTH), enable);
        if (characteristicChunked2021Read != null) {
            builder.notify(characteristicChunked2021Read, enable);
        }

        return this;
    }

    public HuamiSupport enableFurtherNotifications(TransactionBuilder builder, boolean enable) {
        builder.notify(getCharacteristic(HuamiService.UUID_CHARACTERISTIC_3_CONFIGURATION), enable);
        builder.notify(getCharacteristic(HuamiService.UUID_CHARACTERISTIC_6_BATTERY_INFO), enable);
        builder.notify(getCharacteristic(HuamiService.UUID_CHARACTERISTIC_AUDIO), enable);
        builder.notify(getCharacteristic(HuamiService.UUID_CHARACTERISTIC_AUDIODATA), enable);
        builder.notify(getCharacteristic(HuamiService.UUID_CHARACTERISTIC_DEVICEEVENT), enable);
        builder.notify(getCharacteristic(HuamiService.UUID_CHARACTERISTIC_WORKOUT), enable);
        if (characteristicChunked2021Read != null) {
            builder.notify(characteristicChunked2021Read, enable);
        }

        return this;
    }

    @Override
    public boolean useAutoConnect() {
        return true;
    }

    @Override
    public boolean connectFirstTime() {
        needsAuth = true;
        return connect();
    }

    private HuamiSupport sendDefaultNotification(TransactionBuilder builder, SimpleNotification simpleNotification, short repeat, BtLEAction extraAction) {
        LOG.info("Sending notification to MiBand: (" + repeat + " times)");
        NotificationStrategy strategy = getNotificationStrategy();
        for (short i = 0; i < repeat; i++) {
            strategy.sendDefaultNotification(builder, simpleNotification, extraAction);
        }
        return this;
    }

    public NotificationStrategy getNotificationStrategy() {
        String firmwareVersion = gbDevice.getFirmwareVersion();
        if (firmwareVersion != null) {
            Version ver = new Version(firmwareVersion);
            if (MiBandConst.MI2_FW_VERSION_MIN_TEXT_NOTIFICATIONS.compareTo(ver) > 0) {
                return new Mi2NotificationStrategy(this);
            }
        }
        if (GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()).getBoolean(MiBandConst.PREF_MI2_ENABLE_TEXT_NOTIFICATIONS, true)) {
            return new Mi2TextNotificationStrategy(this);
        }
        return new Mi2NotificationStrategy(this);
    }

    private static final byte[] startHeartMeasurementManual = new byte[]{0x15, MiBandService.COMMAND_SET_HR_MANUAL, 1};
    private static final byte[] stopHeartMeasurementManual = new byte[]{0x15, MiBandService.COMMAND_SET_HR_MANUAL, 0};
    private static final byte[] startHeartMeasurementContinuous = new byte[]{0x15, MiBandService.COMMAND_SET__HR_CONTINUOUS, 1};
    private static final byte[] stopHeartMeasurementContinuous = new byte[]{0x15, MiBandService.COMMAND_SET__HR_CONTINUOUS, 0};

    private HuamiSupport requestBatteryInfo(TransactionBuilder builder) {
        LOG.debug("Requesting Battery Info!");
        BluetoothGattCharacteristic characteristic = getCharacteristic(HuamiService.UUID_CHARACTERISTIC_6_BATTERY_INFO);
        builder.read(characteristic);
        return this;
    }

    public HuamiSupport requestDeviceInfo(TransactionBuilder builder) {
        LOG.debug("Requesting Device Info!");
        deviceInfoProfile.requestDeviceInfo(builder);
        return this;
    }

    /**
     * Part of device initialization process. Do not call manually.
     *
     * @param transaction
     * @return
     */

    private HuamiSupport setFitnessGoal(TransactionBuilder transaction) {
        LOG.info("Attempting to set Fitness Goal...");
        BluetoothGattCharacteristic characteristic = getCharacteristic(HuamiService.UUID_CHARACTERISTIC_8_USER_SETTINGS);
        if (characteristic != null) {
            int fitnessGoal = GBApplication.getPrefs().getInt(ActivityUser.PREF_USER_STEPS_GOAL, ActivityUser.defaultUserStepsGoal);
            byte[] bytes = ArrayUtils.addAll(
                    HuamiService.COMMAND_SET_FITNESS_GOAL_START,
                    BLETypeConversions.fromUint16(fitnessGoal));
            bytes = ArrayUtils.addAll(bytes,
                    HuamiService.COMMAND_SET_FITNESS_GOAL_END);
            transaction.write(characteristic, bytes);
        } else {
            LOG.info("Unable to set Fitness Goal");
        }
        return this;
    }

    /**
     * Part of device initialization process. Do not call manually.
     *
     * @param transaction
     * @return
     */

    private HuamiSupport setUserInfo(TransactionBuilder transaction) {
        BluetoothGattCharacteristic characteristic = getCharacteristic(HuamiService.UUID_CHARACTERISTIC_8_USER_SETTINGS);
        if (characteristic == null) {
            return this;
        }

        LOG.info("Attempting to set user info...");
        Prefs prefs = GBApplication.getPrefs();
        String alias = prefs.getString(PREF_USER_NAME, null);
        ActivityUser activityUser = new ActivityUser();
        int height = activityUser.getHeightCm();
        int weight = activityUser.getWeightKg();
        int birth_year = activityUser.getYearOfBirth();
        byte birth_month = 7; // not in user attributes
        byte birth_day = 1; // not in user attributes

        if (alias == null || weight == 0 || height == 0 || birth_year == 0) {
            LOG.warn("Unable to set user info, make sure it is set up");
            return this;
        }

        byte sex = 2; // other
        switch (activityUser.getGender()) {
            case ActivityUser.GENDER_MALE:
                sex = 0;
                break;
            case ActivityUser.GENDER_FEMALE:
                sex = 1;
        }
        int userid = alias.hashCode(); // hash from alias like mi1

        // FIXME: Do encoding like in PebbleProtocol, this is ugly
        byte[] bytes = new byte[]{
                HuamiService.COMMAND_SET_USERINFO,
                0,
                0,
                (byte) (birth_year & 0xff),
                (byte) ((birth_year >> 8) & 0xff),
                birth_month,
                birth_day,
                sex,
                (byte) (height & 0xff),
                (byte) ((height >> 8) & 0xff),
                (byte) ((weight * 200) & 0xff),
                (byte) (((weight * 200) >> 8) & 0xff),
                (byte) (userid & 0xff),
                (byte) ((userid >> 8) & 0xff),
                (byte) ((userid >> 16) & 0xff),
                (byte) ((userid >> 24) & 0xff)
        };

        transaction.write(characteristic, bytes);
        return this;
    }

    /**
     * Part of device initialization process. Do not call manually.
     *
     * @param builder
     * @return
     */
    private HuamiSupport setWearLocation(TransactionBuilder builder) {
        LOG.info("Attempting to set wear location...");
        BluetoothGattCharacteristic characteristic = getCharacteristic(HuamiService.UUID_CHARACTERISTIC_8_USER_SETTINGS);
        if (characteristic != null) {
            builder.notify(characteristic, true);
            int location = MiBandCoordinator.getWearLocation(gbDevice.getAddress());
            switch (location) {
                case 0: // left hand
                    builder.write(characteristic, HuamiService.WEAR_LOCATION_LEFT_WRIST);
                    break;
                case 1: // right hand
                    builder.write(characteristic, HuamiService.WEAR_LOCATION_RIGHT_WRIST);
                    break;
            }
            builder.notify(characteristic, false); // TODO: this should actually be in some kind of finally-block in the queue. It should also be sent asynchronously after the notifications have completely arrived and processed.
        }
        return this;
    }

    @Override
    public void onEnableHeartRateSleepSupport(boolean enable) {
        try {
            TransactionBuilder builder = performInitialized("enable heart rate sleep support: " + enable);
            setHeartrateSleepSupport(builder);
            builder.queue(getQueue());
        } catch (IOException e) {
            GB.toast(getContext(), "Error toggling heart rate sleep support: " + e.getLocalizedMessage(), Toast.LENGTH_LONG, GB.ERROR);
        }
    }

    @Override
    public void onSetHeartRateMeasurementInterval(int seconds) {
        try {
            int minuteInterval = seconds / 60;
            minuteInterval = Math.min(minuteInterval, 120);
            minuteInterval = Math.max(0,minuteInterval);
            TransactionBuilder builder = performInitialized("set heart rate interval to: " + minuteInterval + " minutes");
            setHeartrateMeasurementInterval(builder, minuteInterval);
            builder.queue(getQueue());
        } catch (IOException e) {
            GB.toast(getContext(), "Error toggling heart rate sleep support: " + e.getLocalizedMessage(), Toast.LENGTH_LONG, GB.ERROR);
        }
    }

    @Override
    public void onAddCalendarEvent(CalendarEventSpec calendarEventSpec) {
        // not supported
    }

    @Override
    public void onDeleteCalendarEvent(byte type, long id) {
        // not supported
    }

    private HuamiSupport setPassword(final TransactionBuilder builder) {
        final boolean passwordEnabled = HuamiCoordinator.getPasswordEnabled(gbDevice.getAddress());
        final String password = HuamiCoordinator.getPassword(gbDevice.getAddress());

        LOG.info("Setting password: {}, {}", passwordEnabled, password);

        if (password == null || password.isEmpty()) {
            LOG.warn("Invalid password: {}", password);
            return this;
        }

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            baos.write(ENDPOINT_DISPLAY);
            baos.write(0x21);
            baos.write(0x00);
            baos.write((byte) (passwordEnabled ? 0x01 : 0x00));
            baos.write(password.getBytes());
            baos.write(0x00);
        } catch (final IOException e) {
            LOG.error("Failed to build password command", e);
            return this;
        }

        writeToConfiguration(builder, baos.toByteArray());

        return this;
    }

    /**
     * Part of device initialization process. Do not call manually.
     *
     * @param builder
     */
    private HuamiSupport setHeartrateSleepSupport(TransactionBuilder builder) {
        final boolean enableHrSleepSupport = MiBandCoordinator.getHeartrateSleepSupport(gbDevice.getAddress());
        if (characteristicHRControlPoint != null) {
            builder.notify(characteristicHRControlPoint, true);
            if (enableHrSleepSupport) {
                LOG.info("Enabling heartrate sleep support...");
                builder.write(characteristicHRControlPoint, HuamiService.COMMAND_ENABLE_HR_SLEEP_MEASUREMENT);
            } else {
                LOG.info("Disabling heartrate sleep support...");
                builder.write(characteristicHRControlPoint, HuamiService.COMMAND_DISABLE_HR_SLEEP_MEASUREMENT);
            }
            builder.notify(characteristicHRControlPoint, false); // TODO: this should actually be in some kind of finally-block in the queue. It should also be sent asynchronously after the notifications have completely arrived and processed.
        }
        return this;
    }

    private HuamiSupport setHeartrateActivityMonitoring(TransactionBuilder builder) {
        final boolean enableHrActivityMonitoring = HuamiCoordinator.getHeartrateActivityMonitoring(gbDevice.getAddress());
        final byte[] cmd = {ENDPOINT_DISPLAY, 0x22, 0x00, (byte) (enableHrActivityMonitoring ? 0x01 : 0x00)};
        writeToConfiguration(builder, cmd);
        return this;
    }

    private HuamiSupport setHeartrateAlert(TransactionBuilder builder) {
        final boolean enableHrAlert = HuamiCoordinator.getHeartrateAlert(gbDevice.getAddress());
        final int hrAlertThreshold = HuamiCoordinator.getHeartrateAlertThreshold(gbDevice.getAddress());

        final byte[] cmd = {
                ENDPOINT_DISPLAY,
                0x1a,
                0x00,
                (byte) (enableHrAlert ? 0x01 : 0x00),
                (byte) hrAlertThreshold
        };

        writeToConfiguration(builder, cmd);

        return this;
    }

    private HuamiSupport setHeartrateStressMonitoring(TransactionBuilder builder) {
        final boolean enableHrStressMonitoring = HuamiCoordinator.getHeartrateStressMonitoring(gbDevice.getAddress());
        final byte[] cmd = new byte[] {(byte) 0xfe, 0x06, 0x00, (byte) (enableHrStressMonitoring ? 0x01 : 0x00)};
        writeToConfiguration(builder, cmd);
        return this;
    }

    private HuamiSupport setHeartrateMeasurementInterval(TransactionBuilder builder, int minutes) {
        if (characteristicHRControlPoint != null) {
            builder.notify(characteristicHRControlPoint, true);
            LOG.info("Setting heart rate measurement interval to " + minutes + " minutes");
            builder.write(characteristicHRControlPoint, new byte[]{HuamiService.COMMAND_SET_PERIODIC_HR_MEASUREMENT_INTERVAL, (byte) minutes});
            builder.notify(characteristicHRControlPoint, false); // TODO: this should actually be in some kind of finally-block in the queue. It should also be sent asynchronously after the notifications have completely arrived and processed.
        }
        return this;
    }

    private void performDefaultNotification(String task, SimpleNotification simpleNotification, short repeat, BtLEAction extraAction) {
        try {
            TransactionBuilder builder = performInitialized(task);
            sendDefaultNotification(builder, simpleNotification, repeat, extraAction);
            builder.queue(getQueue());
        } catch (IOException ex) {
            LOG.error("Unable to send notification to MI device", ex);
        }
    }

    protected void performPreferredNotification(String task, String notificationOrigin, SimpleNotification simpleNotification, int alertLevel, BtLEAction extraAction) {
        try {
            TransactionBuilder builder = performInitialized(task);
            Prefs prefs = GBApplication.getPrefs();
            short vibrateTimes = getPreferredVibrateCount(notificationOrigin, prefs);
            VibrationProfile profile = getPreferredVibrateProfile(notificationOrigin, prefs, vibrateTimes);
            profile.setAlertLevel(alertLevel);

            getNotificationStrategy().sendCustomNotification(profile, simpleNotification, 0, 0, 0, 0, extraAction, builder);

            builder.queue(getQueue());
        } catch (IOException ex) {
            LOG.error("Unable to send notification to device", ex);
        }
    }

    private short getPreferredVibrateCount(String notificationOrigin, Prefs prefs) {
        return (short) Math.min(Short.MAX_VALUE, getNotificationPrefIntValue(VIBRATION_COUNT, notificationOrigin, prefs, DEFAULT_VALUE_VIBRATION_COUNT));
    }

    private VibrationProfile getPreferredVibrateProfile(String notificationOrigin, Prefs prefs, short repeat) {
        String profileId = getNotificationPrefStringValue(VIBRATION_PROFILE, notificationOrigin, prefs, DEFAULT_VALUE_VIBRATION_PROFILE);
        return VibrationProfile.getProfile(profileId, repeat);
    }

    @Override
    public void onSetAlarms(ArrayList<? extends Alarm> alarms) {
        try {
            TransactionBuilder builder = performInitialized("Set alarm");
            boolean anyAlarmEnabled = false;
            for (Alarm alarm : alarms) {
                anyAlarmEnabled |= alarm.getEnabled();
                queueAlarm(alarm, builder);
            }
            builder.queue(getQueue());
            if (anyAlarmEnabled) {
                GB.toast(getContext(), getContext().getString(R.string.user_feedback_miband_set_alarms_ok), Toast.LENGTH_SHORT, GB.INFO);
            } else {
                GB.toast(getContext(), getContext().getString(R.string.user_feedback_all_alarms_disabled), Toast.LENGTH_SHORT, GB.INFO);
            }
        } catch (IOException ex) {
            GB.toast(getContext(), getContext().getString(R.string.user_feedback_miband_set_alarms_failed), Toast.LENGTH_LONG, GB.ERROR, ex);
        }
    }

    @Override
    public void onNotification(NotificationSpec notificationSpec) {
        final boolean hasExtraHeader = notificationHasExtraHeader();
        final int maxLength = notificationMaxLength();

        String senderOrTitle = StringUtils.getFirstOf(notificationSpec.sender, notificationSpec.title);

        String message = StringUtils.truncate(senderOrTitle, 32) + "\0";
        if (notificationSpec.subject != null) {
            message += StringUtils.truncate(notificationSpec.subject, 128) + "\n\n";
        }
        if (notificationSpec.body != null) {
            message += StringUtils.truncate(notificationSpec.body, 512);
        }
        if (notificationSpec.body == null && notificationSpec.subject == null) {
            message += " "; // if we have no body we have to send at least something on some devices, else they reboot (Bip S)
        }

        try {
            TransactionBuilder builder = performInitialized("new notification");

            byte customIconId = HuamiIcon.mapToIconId(notificationSpec.type);
            AlertCategory alertCategory = AlertCategory.CustomHuami;

            // The SMS icon for AlertCategory.SMS is unique and not available as iconId
            if (notificationSpec.type == NotificationType.GENERIC_SMS) {
                alertCategory = AlertCategory.SMS;
            }
            // EMAIL icon does not work in FW 0.0.8.74, it did in 0.0.7.90
            else if (customIconId == HuamiIcon.EMAIL) {
                alertCategory = AlertCategory.Email;
            }

            if (characteristicChunked != null) {
                int prefixlength = 2;

                // We also need a (fake) source name for Mi Band 3 for SMS/EMAIL, else the message is not displayed
                byte[] appSuffix = "\0 \0".getBytes();
                int suffixlength = appSuffix.length;

                if (alertCategory == AlertCategory.CustomHuami) {
                    String appName;
                    prefixlength = 3;
                    final PackageManager pm = getContext().getPackageManager();
                    ApplicationInfo ai = null;
                    try {
                        ai = pm.getApplicationInfo(notificationSpec.sourceAppId, 0);
                    } catch (PackageManager.NameNotFoundException ignored) {
                    }

                    if (ai != null) {
                        appName = "\0" + pm.getApplicationLabel(ai) + "\0";
                    } else {
                        appName = "\0" + "UNKNOWN" + "\0";
                    }
                    appSuffix = appName.getBytes();
                    suffixlength = appSuffix.length;
                }
                if (hasExtraHeader) {
                    prefixlength += 4;
                }

                // final step: build command
                byte[] rawmessage = message.getBytes();
                int length = Math.min(rawmessage.length, maxLength - prefixlength);
                if (length < rawmessage.length) {
                    length = StringUtils.utf8ByteLength(message, length);
                }

                byte[] command = new byte[length + prefixlength + suffixlength];
                int pos = 0;
                command[pos++] = (byte) alertCategory.getId();
                if (hasExtraHeader) {
                    command[pos++] = 0; // TODO
                    command[pos++] = 0;
                    command[pos++] = 0;
                    command[pos++] = 0;
                }
                command[pos++] = 1;
                if (alertCategory == AlertCategory.CustomHuami) {
                    command[pos] = customIconId;
                }

                System.arraycopy(rawmessage, 0, command, prefixlength, length);
                System.arraycopy(appSuffix, 0, command, prefixlength + length, appSuffix.length);

                writeToChunked(builder, 0, command);
            } else {
                AlertNotificationProfile<?> profile = new AlertNotificationProfile(this);
                NewAlert alert = new NewAlert(alertCategory, 1, message, customIconId);
                profile.setMaxLength(maxLength);
                profile.newAlert(builder, alert);
            }
            builder.queue(getQueue());
        } catch (IOException ex) {
            LOG.error("Unable to send notification to device", ex);
        }
    }

    protected boolean notificationHasExtraHeader() {
        return false;
    }

    protected int notificationMaxLength() {
        return 230;
    }

    @Override
    public void onSetReminders(ArrayList<? extends Reminder> reminders) {
        final TransactionBuilder builder;
        try {
            builder = performInitialized("onSetReminders");
        } catch (final IOException e) {
            LOG.error("Unable to send reminders to device", e);
            return;
        }

        sendReminders(builder, reminders);

        builder.queue(getQueue());
    }

    private void sendReminders(final TransactionBuilder builder) {
        final List<? extends Reminder> reminders = DBHelper.getReminders(gbDevice);
        sendReminders(builder, reminders);
    }

    private void sendReminders(final TransactionBuilder builder, final List<? extends Reminder> reminders) {
        final DeviceCoordinator coordinator = DeviceHelper.getInstance().getCoordinator(gbDevice);

        final Prefs prefs = new Prefs(GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()));
        int reservedSlots = prefs.getInt(PREF_RESERVER_REMINDERS_CALENDAR, 9);
        LOG.info("On Set Reminders. Reminders: {}, Reserved slots: {}", reminders.size(), reservedSlots);

        // Send the reminders, skipping the reserved slots for calendar events
        for (int i = 0; i < reminders.size(); i++) {
            LOG.debug("Sending reminder at position {}", i + reservedSlots);

            sendReminderToDevice(builder, i + reservedSlots, reminders.get(i));
        }

        // Delete the remaining slots, skipping the sent reminders and reserved slots
        for (int i = reminders.size() + reservedSlots; i < coordinator.getReminderSlotCount(); i++) {
            LOG.debug("Deleting reminder at position {}", i);

            sendReminderToDevice(builder, i, null);
        }
    }

    private void sendReminderToDevice(final TransactionBuilder builder, int position, final Reminder reminder) {
        if (characteristicChunked == null) {
            LOG.warn("characteristicChunked is null, not sending reminder");
            return;
        }

        final DeviceCoordinator coordinator = DeviceHelper.getInstance().getCoordinator(gbDevice);

        if (position + 1 > coordinator.getReminderSlotCount()) {
            LOG.error("Reminder for position {} is over the limit of {} reminders", position, coordinator.getReminderSlotCount());
            return;
        }

        if (reminder == null) {
            // Delete reminder
            writeToChunked(builder, 2, new byte[]{(byte) 0x0b, (byte) (position & 0xFF), 0x08, 0, 0, 0, 0});

            return;
        }

        final ByteBuffer buf = ByteBuffer.allocate(14 + reminder.getMessage().getBytes().length);
        buf.order(ByteOrder.LITTLE_ENDIAN);

        buf.put((byte) 0x0B);
        buf.put((byte) (position & 0xFF));

        final Calendar cal = Calendar.getInstance();
        cal.setTime(reminder.getDate());

        int eventConfig = 0x01 | 0x08; // flags 0x01 = enable, 0x04 = end date present (not on reminders), 0x08 = has text

        switch(reminder.getRepetition()) {
            case Reminder.ONCE:
                // Default is once, nothing to do
                break;
            case Reminder.EVERY_DAY:
                eventConfig |= 0x0fe0; // all week day bits set
                break;
            case Reminder.EVERY_WEEK:
                int dayOfWeek = BLETypeConversions.dayOfWeekToRawBytes(cal) - 1; // Monday = 0
                eventConfig |= 0x20 << dayOfWeek;
                break;
            case Reminder.EVERY_MONTH:
                eventConfig |= 0x1000;
                break;
            case Reminder.EVERY_YEAR:
                eventConfig |= 0x2000;
                break;
            default:
                LOG.warn("Unknown repetition for reminder in position {}, defaulting to once", position);
        }

        buf.putInt(eventConfig);

        buf.put(BLETypeConversions.shortCalendarToRawBytes(cal));
        buf.put((byte) 0x00);

        if (reminder.getMessage().getBytes().length > coordinator.getMaximumReminderMessageLength()) {
            LOG.warn("The reminder message length {} is longer than {}, will be truncated",
                    reminder.getMessage().getBytes().length,
                    coordinator.getMaximumReminderMessageLength()
            );
            buf.put(Arrays.copyOf(reminder.getMessage().getBytes(), coordinator.getMaximumReminderMessageLength()));
        } else {
            buf.put(reminder.getMessage().getBytes());
        }
        buf.put((byte) 0x00);

        writeToChunked(builder, 2, buf.array());
    }

    @Override
    public void onSetWorldClocks(ArrayList<? extends WorldClock> clocks) {
        final TransactionBuilder builder;
        try {
            builder = performInitialized("onSetWorldClocks");
        } catch (final IOException e) {
            LOG.error("Unable to send world clocks to device", e);
            return;
        }

        sendWorldClocks(builder, clocks);

        builder.queue(getQueue());
    }

    private void setWorldClocks(final TransactionBuilder builder) {
        final List<? extends WorldClock> clocks = DBHelper.getWorldClocks(gbDevice);
        sendWorldClocks(builder, clocks);
    }

    private void sendWorldClocks(final TransactionBuilder builder, final List<? extends WorldClock> clocks) {
        final DeviceCoordinator coordinator = DeviceHelper.getInstance().getCoordinator(gbDevice);
        if (coordinator.getWorldClocksSlotCount() == 0) {
            return;
        }

        final ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            baos.write(0x03);
            
            if (clocks.size() != 0) {
                int i = clocks.size();
                for (final WorldClock clock : clocks) {
                    baos.write(i--);
                    baos.write(encodeWorldClock(clock));
                }
            } else {
                baos.write(0);
            }
        } catch (final IOException e) {
            LOG.error("Unable to send world clocks to device", e);
            return;
        }

        writeToChunked2021(builder, (short) 0x0008, getNextHandle(), baos.toByteArray(), force2021Protocol, false);
    }

    public byte[] encodeWorldClock(final WorldClock clock) {
        final DeviceCoordinator coordinator = DeviceHelper.getInstance().getCoordinator(gbDevice);

        try {
            final ByteArrayOutputStream baos = new ByteArrayOutputStream();

            final TimeZone timezone = TimeZone.getTimeZone(clock.getTimeZoneId());
            final ZoneId zoneId = ZoneId.of(clock.getTimeZoneId());

            // Usually the 3-letter city code (eg. LIS for Lisbon), but doesn't seem to be used in the UI
            baos.write("   ".getBytes(StandardCharsets.UTF_8));
            baos.write(0x00);

            // Some other string? Seems to be empty
            baos.write(0x00);

            // The city name / label that shows up on the band
            baos.write(StringUtils.truncate(clock.getLabel(), coordinator.getWorldClocksLabelLength()).getBytes(StandardCharsets.UTF_8));
            baos.write(0x00);

            // The raw offset from UTC, in number of 15-minute blocks
            baos.write((int) (timezone.getRawOffset() / (1000L * 60L * 15L)));

            // Daylight savings
            final boolean useDaylightTime = timezone.useDaylightTime();
            final boolean inDaylightTime = timezone.inDaylightTime(new Date());
            byte daylightByte = 0;
            // The daylight savings offset, either currently (the previous transition) or future (the next transition), in minutes
            byte daylightOffsetMinutes = 0;

            final ZoneRules zoneRules = zoneId.getRules();
            if (useDaylightTime) {
                final ZoneOffsetTransition transition;
                if (inDaylightTime) {
                    daylightByte = 0x01;
                    transition = zoneRules.previousTransition(Instant.now());
                } else {
                    daylightByte = 0x02;
                    transition = zoneRules.nextTransition(Instant.now());
                }
                daylightOffsetMinutes = (byte) transition.getDuration().toMinutes();
            }

            baos.write(daylightByte);
            baos.write(daylightOffsetMinutes);

            // The timestamp of the next daylight savings transition, if any
            final ZoneOffsetTransition nextTransition = zoneRules.nextTransition(Instant.now());
            long nextTransitionTs = 0;
            if (nextTransition != null) {
                nextTransitionTs = nextTransition
                        .getDateTimeBefore()
                        .atZone(zoneId)
                        .toEpochSecond();
            }

            for (int i = 0; i < 4; i++) {
                baos.write((byte) ((nextTransitionTs >> (i * 8)) & 0xff));
            }

            return baos.toByteArray();
        } catch (final IOException e) {
            throw new RuntimeException("This should never happen", e);
        }
    }

    @Override
    public void onDeleteNotification(int id) {

    }

    @Override
    public void onSetTime() {
        try {
            TransactionBuilder builder = performInitialized("Set date and time");
            setCurrentTimeWithService(builder);
            //TODO: once we have a common strategy for sending events (e.g. EventHandler), remove this call from here. Meanwhile it does no harm.
            // = we should genaralize the pebble calender code
            if (characteristicChunked == null) { // all except Mi Band 2
                sendCalendarEvents(builder);
            }
            else {
                sendCalendarEventsAsReminder(builder);
            }
            builder.queue(getQueue());
        } catch (IOException ex) {
            LOG.error("Unable to set time on Huami device", ex);
        }
    }

    @Override
    public void onSetCallState(CallSpec callSpec) {
        if (callSpec.command == CallSpec.CALL_INCOMING) {
            telephoneRinging = true;
            AbortTransactionAction abortAction = new StopNotificationAction(getCharacteristic(UUID_CHARACTERISTIC_ALERT_LEVEL)) {
                @Override
                protected boolean shouldAbort() {
                    return !isTelephoneRinging();
                }
            };
            String message = NotificationUtils.getPreferredTextFor(callSpec);
            SimpleNotification simpleNotification = new SimpleNotification(message, AlertCategory.IncomingCall, null);
            performPreferredNotification("incoming call", MiBandConst.ORIGIN_INCOMING_CALL, simpleNotification, HuamiService.ALERT_LEVEL_PHONE_CALL, abortAction);
        } else if ((callSpec.command == CallSpec.CALL_START) || (callSpec.command == CallSpec.CALL_END)) {
            telephoneRinging = false;
            stopCurrentCallNotification();
        }
    }

    public void onSetCallStateNew(CallSpec callSpec) {
        if (callSpec.command == CallSpec.CALL_INCOMING) {
            byte[] message = NotificationUtils.getPreferredTextFor(callSpec).getBytes();
            int length = 10 + message.length;
            ByteBuffer buf = ByteBuffer.allocate(length);
            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.put(new byte[]{3, 0, 0, 0, 0, 0});
            buf.put(message);
            buf.put(new byte[]{0, 0, 0, 2});
            try {
                TransactionBuilder builder = performInitialized("incoming call");
                writeToChunked(builder, 0, buf.array());
                builder.queue(getQueue());
            } catch (IOException e) {
                LOG.error("Unable to send incoming call");
            }
        } else if ((callSpec.command == CallSpec.CALL_START) || (callSpec.command == CallSpec.CALL_END)) {
            try {
                TransactionBuilder builder = performInitialized("end call");
                writeToChunked(builder, 0, new byte[]{3, 3, 0, 0, 0, 0});
                builder.queue(getQueue());
            } catch (IOException e) {
                LOG.error("Unable to send end call");
            }
        }
    }

    private void stopCurrentCallNotification() {
        try {
            TransactionBuilder builder = performInitialized("stop notification");
            getNotificationStrategy().stopCurrentNotification(builder);
            builder.queue(getQueue());
        } catch (IOException e) {
            LOG.error("Error stopping call notification");
        }
    }

    @Override
    public void onSetCannedMessages(CannedMessagesSpec cannedMessagesSpec) {
        if (cannedMessagesSpec.type == CannedMessagesSpec.TYPE_REJECTEDCALLS) {
            try {
                TransactionBuilder builder = performInitialized("Set canned messages");
                int handle = 0x12345678;

                for (int i = 0; i < 16; i++) {
                    byte[] delete_command = new byte[]{0x07, (byte) (handle & 0xff), (byte) ((handle & 0xff00) >> 8), (byte) ((handle & 0xff0000) >> 16), (byte) ((handle & 0xff000000) >> 24)};
                    writeToChunked2021(builder, (short) 0x0013, getNextHandle(), delete_command, force2021Protocol, false);
                    handle++;
                }
                handle = 0x12345678;
                for (String cannedMessage : cannedMessagesSpec.cannedMessages) {
                    int length = cannedMessage.getBytes().length + 6;
                    ByteBuffer buf = ByteBuffer.allocate(length);
                    buf.order(ByteOrder.LITTLE_ENDIAN);
                    buf.put((byte) 0x05); // create
                    buf.putInt(handle++);
                    buf.put(cannedMessage.getBytes());
                    buf.put((byte) 0x00);
                    writeToChunked2021(builder, (short) 0x0013, getNextHandle(), buf.array(), force2021Protocol, false);
                }
                builder.queue(getQueue());
            } catch (IOException ex) {
                LOG.error("Unable to set time on Huami device", ex);
            }
        }
    }

    private boolean isTelephoneRinging() {
        // don't synchronize, this is not really important
        return telephoneRinging;
    }

    @Override
    public void onSetMusicState(MusicStateSpec stateSpec) {
        DeviceCoordinator coordinator = DeviceHelper.getInstance().getCoordinator(gbDevice);
        if (!coordinator.supportsMusicInfo()) {
            return;
        }

        if (stateSpec != null && !stateSpec.equals(bufferMusicStateSpec)) {
            bufferMusicStateSpec = stateSpec;
            if (isMusicAppStarted) {
                sendMusicStateToDevice(null, bufferMusicStateSpec);
            }
        }
    }

    @Override
    public void onSetMusicInfo(MusicSpec musicSpec) {
        DeviceCoordinator coordinator = DeviceHelper.getInstance().getCoordinator(gbDevice);
        if (!coordinator.supportsMusicInfo()) {
            return;
        }

        if (musicSpec != null && !musicSpec.equals(bufferMusicSpec)) {
            bufferMusicSpec = musicSpec;
            if (bufferMusicStateSpec != null) {
                bufferMusicStateSpec.state = 0;
                bufferMusicStateSpec.position = 0;
            }
            if (isMusicAppStarted) {
                sendMusicStateToDevice(bufferMusicSpec, bufferMusicStateSpec);
            }
        }
    }

    private void sendMusicStateToDevice() {
        sendMusicStateToDevice(bufferMusicSpec, bufferMusicStateSpec);
    }

    @Override
    public void onSetPhoneVolume(final float volume) {
        if (characteristicChunked == null) {
            return;
        }

        final byte[] volumeCommand = new byte[]{0x40, (byte) Math.round(volume)};

        try {
            final TransactionBuilder builder = performInitialized("send volume");
            writeToChunked(builder, 3, volumeCommand);

            builder.queue(getQueue());
        } catch (final IOException e) {
            LOG.error("Unable to send volume", e);
        }

        LOG.info("sendVolumeStateToDevice: {}", volume);
    }

    private void sendVolumeStateToDevice() {
        final AudioManager audioManager = (AudioManager) getContext().getSystemService(Context.AUDIO_SERVICE);

        final int volumeLevel = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        final int volumeMax = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        final int volumePercentage = (byte) Math.round(100 * (volumeLevel / (float) volumeMax));

        onSetPhoneVolume(volumePercentage);
    }

    protected void sendMusicStateToDevice(MusicSpec musicSpec, MusicStateSpec musicStateSpec) {
        if (characteristicChunked == null) {
            return;
        }

        if (musicStateSpec == null) {
            return;
        }

        String artist = "";
        String album = "";
        String track = "";

        byte flags = 0x00;
        flags |= 0x01;
        int length = 5;
        if (musicSpec != null) {
            artist = StringUtils.truncate(musicSpec.artist, 80);
            album = StringUtils.truncate(musicSpec.album, 80);
            track = StringUtils.truncate(musicSpec.track, 80);

            if (artist.getBytes().length > 0) {
                length += artist.getBytes().length + 1;
                flags |= 0x02;
            }
            if (album.getBytes().length > 0) {
                length += album.getBytes().length + 1;
                flags |= 0x04;
            }
            if (track.getBytes().length > 0) {
                length += track.getBytes().length + 1;
                flags |= 0x08;
            }
            if (musicSpec.duration != 0) {
                length += 2;
                flags |= 0x10;
            }
        }

        try {
            ByteBuffer buf = ByteBuffer.allocate(length);
            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.put(flags);
            byte state;
            switch (musicStateSpec.state) {
                case MusicStateSpec.STATE_PLAYING:
                    state = 1;
                    break;
                default:
                    state = 0;
            }

            buf.put(state);
            buf.put((byte) 0);
            buf.putShort((short) musicStateSpec.position);

            if (musicSpec != null) {
                if (artist.getBytes().length > 0) {
                    buf.put(artist.getBytes());
                    buf.put((byte) 0);
                }
                if (album.getBytes().length > 0) {
                    buf.put(album.getBytes());
                    buf.put((byte) 0);
                }
                if (track.getBytes().length > 0) {
                    buf.put(track.getBytes());
                    buf.put((byte) 0);
                }
                if (musicSpec.duration != 0) {
                    buf.putShort((short) musicSpec.duration);
                }
            }

            TransactionBuilder builder = performInitialized("send playback info");
            writeToChunked(builder, 3, buf.array());

            builder.queue(getQueue());
        } catch (IOException e) {
            LOG.error("Unable to send playback state");
        }
        LOG.info("sendMusicStateToDevice: " + musicSpec + " " + musicStateSpec);
    }

    @Override
    public void onReset(int flags) {
        try {
            TransactionBuilder builder = performInitialized("Reset");
            if ((flags & GBDeviceProtocol.RESET_FLAGS_FACTORY_RESET) != 0) {
                sendFactoryReset(builder);
            } else {
                sendReboot(builder);
            }
            builder.queue(getQueue());
        } catch (IOException ex) {
            LOG.error("Unable to reset", ex);
        }
    }

    public HuamiSupport sendReboot(TransactionBuilder builder) {
        builder.write(getCharacteristic(HuamiService.UUID_CHARACTERISTIC_FIRMWARE), new byte[] { HuamiService.COMMAND_FIRMWARE_REBOOT});
        return this;
    }

    public HuamiSupport sendFactoryReset(TransactionBuilder builder) {
        writeToConfiguration(builder,  HuamiService.COMMAND_FACTORY_RESET);
        return this;
    }

    @Override
    public void onHeartRateTest() {
        if (characteristicHRControlPoint == null) {
            return;
        }
        try {
            TransactionBuilder builder = performInitialized("HeartRateTest");
            enableNotifyHeartRateMeasurements(true, builder);
            builder.write(characteristicHRControlPoint, stopHeartMeasurementContinuous);
            builder.write(characteristicHRControlPoint, stopHeartMeasurementManual);
            builder.write(characteristicHRControlPoint, startHeartMeasurementManual);
            builder.queue(getQueue());
        } catch (IOException ex) {
            LOG.error("Unable to read heart rate from Huami device", ex);
        }
    }

    @Override
    public void onEnableRealtimeHeartRateMeasurement(boolean enable) {
        if (characteristicHRControlPoint == null) {
            return;
        }
        try {
            TransactionBuilder builder = performInitialized("Enable realtime heart rate measurement");
            enableNotifyHeartRateMeasurements(enable, builder);
            if (enable) {
                builder.write(characteristicHRControlPoint, stopHeartMeasurementManual);
                builder.write(characteristicHRControlPoint, startHeartMeasurementContinuous);
            } else {
                builder.write(characteristicHRControlPoint, stopHeartMeasurementContinuous);
            }
            builder.queue(getQueue());
            enableRealtimeSamplesTimer(enable);
        } catch (IOException ex) {
            LOG.error("Unable to enable realtime heart rate measurement", ex);
        }
    }

    private void enableNotifyHeartRateMeasurements(boolean enable, TransactionBuilder builder) {
        if (heartRateNotifyEnabled != enable) {
            BluetoothGattCharacteristic heartrateCharacteristic = getCharacteristic(GattCharacteristic.UUID_CHARACTERISTIC_HEART_RATE_MEASUREMENT);
            if (heartrateCharacteristic != null) {
                builder.notify(heartrateCharacteristic, enable);
                heartRateNotifyEnabled = enable;
            }
        }
    }

    @Override
    public void onFindDevice(boolean start) {
        isLocatingDevice = start;

        if (start) {
            AbortTransactionAction abortAction = new AbortTransactionAction() {
                @Override
                protected boolean shouldAbort() {
                    return !isLocatingDevice;
                }
            };
            SimpleNotification simpleNotification = new SimpleNotification(getContext().getString(R.string.find_device_you_found_it), AlertCategory.HighPriorityAlert, null);
            performDefaultNotification("locating device", simpleNotification, (short) 255, abortAction);
        }
    }

    @Override
    public void onSetConstantVibration(int intensity) {

    }

    @Override
    public void onFetchRecordedData(int dataTypes) {
        try {
            new FetchActivityOperation(this).perform();
        } catch (IOException ex) {
            LOG.error("Unable to fetch activity data", ex);
        }
    }

    @Override
    public void onEnableRealtimeSteps(boolean enable) {
        try {
            TransactionBuilder builder = performInitialized(enable ? "Enabling realtime steps notifications" : "Disabling realtime steps notifications");
            if (enable) {
                builder.read(getCharacteristic(HuamiService.UUID_CHARACTERISTIC_7_REALTIME_STEPS));
            }
            builder.notify(getCharacteristic(HuamiService.UUID_CHARACTERISTIC_7_REALTIME_STEPS), enable);
            builder.queue(getQueue());
            enableRealtimeSamplesTimer(enable);
        } catch (IOException e) {
            LOG.error("Unable to change realtime steps notification to: " + enable, e);
        }
    }

    private byte[] getHighLatency() {
        int minConnectionInterval = 460;
        int maxConnectionInterval = 500;
        int latency = 0;
        int timeout = 500;
        int advertisementInterval = 0;

        return getLatency(minConnectionInterval, maxConnectionInterval, latency, timeout, advertisementInterval);
    }

    private byte[] getLatency(int minConnectionInterval, int maxConnectionInterval, int latency, int timeout, int advertisementInterval) {
        byte[] result = new byte[12];
        result[0] = (byte) (minConnectionInterval & 0xff);
        result[1] = (byte) (0xff & minConnectionInterval >> 8);
        result[2] = (byte) (maxConnectionInterval & 0xff);
        result[3] = (byte) (0xff & maxConnectionInterval >> 8);
        result[4] = (byte) (latency & 0xff);
        result[5] = (byte) (0xff & latency >> 8);
        result[6] = (byte) (timeout & 0xff);
        result[7] = (byte) (0xff & timeout >> 8);
        result[8] = 0;
        result[9] = 0;
        result[10] = (byte) (advertisementInterval & 0xff);
        result[11] = (byte) (0xff & advertisementInterval >> 8);

        return result;
    }

    private byte[] getLowLatency() {
        int minConnectionInterval = 39;
        int maxConnectionInterval = 49;
        int latency = 0;
        int timeout = 500;
        int advertisementInterval = 0;

        return getLatency(minConnectionInterval, maxConnectionInterval, latency, timeout, advertisementInterval);
    }

    @Override
    public void onInstallApp(Uri uri) {
        try {
            createUpdateFirmwareOperation(uri).perform();
        } catch (IOException ex) {
            GB.toast(getContext(), "Firmware cannot be installed: " + ex.getMessage(), Toast.LENGTH_LONG, GB.ERROR, ex);
        }
    }

    @Override
    public void onAppInfoReq() {
        // not supported
    }

    @Override
    public void onAppStart(UUID uuid, boolean start) {
        // not supported
    }

    @Override
    public void onAppDelete(UUID uuid) {
        // not supported
    }

    @Override
    public void onAppConfiguration(UUID uuid, String config, Integer id) {
        // not supported
    }

    @Override
    public void onAppReorder(UUID[] uuids) {
        // not supported
    }

    @Override
    public void onScreenshotReq() {
        // not supported
    }

    // this could go though onion code with preferred notification, but I this should work on all huami devices
    private void vibrateOnce() {
        BluetoothGattCharacteristic characteristic = getCharacteristic(UUID_CHARACTERISTIC_ALERT_LEVEL);
        try {
            TransactionBuilder builder = performInitialized("Vibrate once");
            builder.write(characteristic,new byte[] {3});
            builder.queue(getQueue());
        } catch (IOException e) {
            LOG.error("error while sending simple vibrate command", e);
        }
    }

    private void processButtonAction() {
        if (currentButtonTimerActivationTime != currentButtonPressTime) {
            return;
        }
        //handle user events settings. 0 is long press, rest are button_id 1-3
        switch (currentButtonActionId) {
            case 0:
                executeButtonAction("button_long_press_action_selection");
                break;
            case 1:
                executeButtonAction("button_single_press_action_selection");
                break;
            case 2:
                executeButtonAction("button_double_press_action_selection");
                break;
            case 3:
                executeButtonAction("button_triple_press_action_selection");
                break;
            default:
                break;
        }

        currentButtonActionId = 0;
        currentButtonPressCount = 0;
        currentButtonPressTime = System.currentTimeMillis();
    }

    private void executeButtonAction(String buttonKey) {
        Prefs prefs = new Prefs(GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()));
        String buttonPreference = prefs.getString(buttonKey, PREF_BUTTON_ACTION_SELECTION_OFF);

        if (buttonPreference.equals(PREF_BUTTON_ACTION_SELECTION_OFF)) {
            return;
        }
        if (prefs.getBoolean(HuamiConst.PREF_BUTTON_ACTION_VIBRATE, false)) {
            vibrateOnce();
        }
        switch (buttonPreference) {
            case PREF_BUTTON_ACTION_SELECTION_BROADCAST:
                sendSystemBroadcastWithButtonId();
                break;
            case PREF_BUTTON_ACTION_SELECTION_FITNESS_APP_START:
                OpenTracksController.startRecording(this.getContext());
                break;
            case PREF_BUTTON_ACTION_SELECTION_FITNESS_APP_STOP:
                OpenTracksController.stopRecording(this.getContext());
                break;
            case PREF_BUTTON_ACTION_SELECTION_FITNESS_APP_TOGGLE:
                OpenTracksController.toggleRecording(this.getContext());
                break;
            default:
                handleMediaButton(buttonPreference);
        }
    }

    private void handleDeviceAction(String deviceAction, String message) {
        if (deviceAction.equals(PREF_DEVICE_ACTION_SELECTION_OFF)) {
            return;
        }
        switch (deviceAction) {
            case PREF_BUTTON_ACTION_SELECTION_BROADCAST:
                sendSystemBroadcast(message);
                break;
            case PREF_BUTTON_ACTION_SELECTION_FITNESS_APP_START:
                OpenTracksController.startRecording(this.getContext());
                break;
            case PREF_BUTTON_ACTION_SELECTION_FITNESS_APP_STOP:
                OpenTracksController.stopRecording(this.getContext());
                break;
            case PREF_BUTTON_ACTION_SELECTION_FITNESS_APP_TOGGLE:
                OpenTracksController.toggleRecording(this.getContext());
                break;
            default:
                handleMediaButton(deviceAction);
        }
    }

    private void sendSystemBroadcast(String message){
        if (message !=null) {
            Intent in = new Intent();
            in.setAction(message);
            LOG.info("Sending broadcast " + message);
            this.getContext().getApplicationContext().sendBroadcast(in);
        }
    }

    private void sendSystemBroadcastWithButtonId() {
        Prefs prefs = new Prefs(GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()));
        String requiredButtonPressMessage = prefs.getString(HuamiConst.PREF_BUTTON_ACTION_BROADCAST,
                this.getContext().getString(R.string.mi2_prefs_button_press_broadcast_default_value));
        Intent in = new Intent();
        in.setAction(requiredButtonPressMessage);
        in.putExtra("button_id", currentButtonActionId);
        LOG.info("Sending " + requiredButtonPressMessage + " with button_id " + currentButtonActionId);
        this.getContext().getApplicationContext().sendBroadcast(in);
    }

    private void handleMediaButton(String MediaAction) {
        if (MediaAction.equals(PREF_DEVICE_ACTION_SELECTION_OFF)) {
            return;
        }
        GBDeviceEventMusicControl deviceEventMusicControl = new GBDeviceEventMusicControl();
        deviceEventMusicControl.event = GBDeviceEventMusicControl.Event.valueOf(MediaAction);
        evaluateGBDeviceEvent(deviceEventMusicControl);
    }

    private void handleDeviceEvent(byte[] value) {
        if (value == null || value.length == 0) {
            return;
        }
        GBDeviceEventCallControl callCmd = new GBDeviceEventCallControl();

        switch (value[0]) {
            case HuamiDeviceEvent.CALL_REJECT:
                LOG.info("call rejected");
                callCmd.event = GBDeviceEventCallControl.Event.REJECT;
                evaluateGBDeviceEvent(callCmd);
                break;
            case HuamiDeviceEvent.CALL_IGNORE:
                LOG.info("call ignored");
                callCmd.event = GBDeviceEventCallControl.Event.IGNORE;
                evaluateGBDeviceEvent(callCmd);
                break;
            case HuamiDeviceEvent.BUTTON_PRESSED:
                LOG.info("button pressed");
                handleButtonEvent();
                break;
            case HuamiDeviceEvent.BUTTON_PRESSED_LONG:
                LOG.info("button long-pressed ");
                handleLongButtonEvent();
                break;
            case HuamiDeviceEvent.START_NONWEAR:
                LOG.info("non-wear start detected");
                processDeviceEvent(HuamiDeviceEvent.START_NONWEAR);
                break;
            case HuamiDeviceEvent.ALARM_TOGGLED:
            case HuamiDeviceEvent.ALARM_CHANGED:
                LOG.info("An alarm was toggled or changed");
                TransactionBuilder builder = new TransactionBuilder("requestAlarms");
                requestAlarms(builder);
                builder.queue(getQueue());
                break;
            case HuamiDeviceEvent.FELL_ASLEEP:
                LOG.info("Fell asleep");
                processDeviceEvent(HuamiDeviceEvent.FELL_ASLEEP);
                break;
            case HuamiDeviceEvent.WOKE_UP:
                LOG.info("Woke up");
                processDeviceEvent(HuamiDeviceEvent.WOKE_UP);
                break;
            case HuamiDeviceEvent.STEPSGOAL_REACHED:
                LOG.info("Steps goal reached");
                break;
            case HuamiDeviceEvent.TICK_30MIN:
                LOG.info("Tick 30 min (?)");
                break;
            case HuamiDeviceEvent.FIND_PHONE_START:
                LOG.info("find phone started");
                acknowledgeFindPhone(); // FIXME: premature
                findPhoneEvent.event = GBDeviceEventFindPhone.Event.START;
                evaluateGBDeviceEvent(findPhoneEvent);
                break;
            case HuamiDeviceEvent.FIND_PHONE_STOP:
                LOG.info("find phone stopped");
                findPhoneEvent.event = GBDeviceEventFindPhone.Event.STOP;
                evaluateGBDeviceEvent(findPhoneEvent);
                break;
            case HuamiDeviceEvent.MUSIC_CONTROL:
                LOG.info("got music control");
                GBDeviceEventMusicControl deviceEventMusicControl = new GBDeviceEventMusicControl();

                switch (value[1]) {
                    case 0:
                        deviceEventMusicControl.event = GBDeviceEventMusicControl.Event.PLAY;
                        break;
                    case 1:
                        deviceEventMusicControl.event = GBDeviceEventMusicControl.Event.PAUSE;
                        break;
                    case 3:
                        deviceEventMusicControl.event = GBDeviceEventMusicControl.Event.NEXT;
                        break;
                    case 4:
                        deviceEventMusicControl.event = GBDeviceEventMusicControl.Event.PREVIOUS;
                        break;
                    case 5:
                        deviceEventMusicControl.event = GBDeviceEventMusicControl.Event.VOLUMEUP;
                        break;
                    case 6:
                        deviceEventMusicControl.event = GBDeviceEventMusicControl.Event.VOLUMEDOWN;
                        break;
                    case (byte) 224:
                        LOG.info("Music app started");
                        isMusicAppStarted = true;
                        sendMusicStateToDevice();
                        sendVolumeStateToDevice();
                        break;
                    case (byte) 225:
                        LOG.info("Music app terminated");
                        isMusicAppStarted = false;
                        break;
                    default:
                        LOG.info("unhandled music control event " + value[1]);
                        return;
                }
                evaluateGBDeviceEvent(deviceEventMusicControl);
                break;
            case HuamiDeviceEvent.MTU_REQUEST:
                int mtu = (value[2] & 0xff) << 8 | value[1] & 0xff;
                LOG.info("device announced MTU of " + mtu);
                Prefs prefs = new Prefs(GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()));
                if (!prefs.getBoolean(PREF_ALLOW_HIGH_MTU, false)) {
                    break;
                }
                if (mtu < 23) {
                    LOG.error("Device announced unreasonable low MTU of " + mtu + ", ignoring");
                    break;
                }
                mMTU = mtu;
                /*
                 * not really sure if this would make sense, is this event already a proof of a successful MTU
                 * negotiation initiated by the Huami device, and acknowledged by the phone? do we really have to
                 * requestMTU() from our side after receiving this?
                 * /
                if (mMTU != mtu) {
                    requestMTU(mtu);
                }
                */
                break;
            case HuamiDeviceEvent.WORKOUT_STARTING:
                final HuamiWorkoutTrackActivityType activityType = HuamiWorkoutTrackActivityType.fromCode(value[3]);
                this.workoutNeedsGps = (value[2] == 1);

                if (activityType == null) {
                    LOG.warn("Unknown workout activity type {}", String.format("0x%x", value[3]));
                }

                LOG.info("Workout starting on band: {}, needs gps = {}", activityType, workoutNeedsGps);

                final boolean sendGpsToBand = HuamiCoordinator.getWorkoutSendGpsToBand(getDevice().getAddress());

                if (workoutNeedsGps) {
                    if (sendGpsToBand) {
                        lastPhoneGpsSent = 0;
                        sendPhoneGpsStatus(HuamiPhoneGpsStatus.SEARCHING);
                        GBLocationManager.start(getContext(), this);
                    } else {
                        sendPhoneGpsStatus(HuamiPhoneGpsStatus.DISABLED);
                    }
                }

                break;
            default:
                LOG.warn("unhandled event {}", String.format("0x%x", value[0]));
        }
    }

    /**
     * Track whether the currently selected workout needs gps (received in {@link #handleDeviceEvent}, so we can start the activity tracking
     * if needed in {@link #handleDeviceWorkoutEvent}, since in there we don't know what's the current workout.
     */
    private boolean workoutNeedsGps = false;

    /**
     * Track the last time we actually sent a gps location. We need to signal that GPS as re-acquired if the last update was too long ago.
     */
    private long lastPhoneGpsSent = 0;

    private void handleDeviceWorkoutEvent(byte[] value) {
        if (value == null || value.length == 0) {
            return;
        }

        switch (value[0]) {
            case 0x11:
                final HuamiWorkoutStatus status = HuamiWorkoutStatus.fromCode(value[1]);
                if (status == null) {
                    LOG.warn("Unknown workout status {}", String.format("0x%x", value[1]));
                    return;
                }

                LOG.info("Got workout status {}", status);

                final boolean sendGpsToBand = HuamiCoordinator.getWorkoutSendGpsToBand(getDevice().getAddress());
                final boolean startOnPhone = HuamiCoordinator.getWorkoutStartOnPhone(getDevice().getAddress());

                switch (status) {
                    case Start:
                        if (workoutNeedsGps && startOnPhone) {
                            LOG.info("Starting OpenTracks recording");

                            OpenTracksController.startRecording(getContext());
                        }

                        break;
                    case End:
                        GBLocationManager.stop(getContext(), this);

                        if (startOnPhone) {
                            LOG.info("Stopping OpenTracks recording");
                            OpenTracksController.stopRecording(getContext());
                        }

                        break;
                }

                break;
            default:
                LOG.warn("Unhandled workout event {}", String.format("0x%x", value[0]));
        }
    }

    @Override
    public void onSetGpsLocation(final Location location) {
        if (characteristicChunked == null || location == null) {
            return;
        }

        final boolean sendGpsToBand = HuamiCoordinator.getWorkoutSendGpsToBand(getDevice().getAddress());

        if (!sendGpsToBand) {
            LOG.warn("Sending GPS to band is disabled, ignoring location update");
            return;
        }

        int flags = 0x40000;
        int length = 1 + 4 + 31;

        boolean newGpsLock = System.currentTimeMillis() - lastPhoneGpsSent > 5000;
        lastPhoneGpsSent = System.currentTimeMillis();

        if (newGpsLock) {
            flags |= 0x01;
            length += 1;
        }

        final ByteBuffer buf = ByteBuffer.allocate(length);
        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put((byte) 0x06);
        buf.putInt(flags);

        if (newGpsLock) {
            buf.put((byte) 0x01);
        }

        buf.putInt((int) (location.getLongitude() * 3000000.0));
        buf.putInt((int) (location.getLatitude() * 3000000.0));
        buf.putInt((int) location.getSpeed() * 10);

        buf.putInt((int) (location.getAltitude() * 100));
        buf.putLong(location.getTime());

        // Seems to always be ff ?
        buf.putInt(0xffffffff);

        // Not sure what this is, maybe bearing? It changes while moving, but
        // doesn't seem to be needed on the Mi Band 5
        buf.putShort((short) 0x00);

        // Seems to always be 0 ?
        buf.put((byte) 0x00);

        try {
            final TransactionBuilder builder = performInitialized("send phone gps location");
            writeToChunked(builder, 6, buf.array());
            builder.queue(getQueue());
        } catch (final IOException e) {
            LOG.error("Unable to send location", e);
        }

        LOG.info("sendLocationToBand: {}", location);
    }

    private void sendPhoneGpsStatus(final HuamiPhoneGpsStatus status) {
        int flags = 0x01;
        final ByteBuffer buf = ByteBuffer.allocate(1 + 4 + 1);

        buf.order(ByteOrder.LITTLE_ENDIAN);
        buf.put((byte) 0x06);
        buf.putInt(flags);

        buf.put(status.getCode());

        try {
            final TransactionBuilder builder = performInitialized("send phone gps status");
            writeToChunked(builder, 6, buf.array());
            builder.queue(getQueue());
        } catch (final IOException e) {
            LOG.error("Unable to send location", e);
        }

        LOG.info("sendPhoneGpsStatus: {}", status);
    }

    private void requestMTU(int mtu) {
        if (!GBApplication.isRunningLollipopOrLater()) {
            LOG.warn("Requesting MTU is only supported in Lollipop or later");
            return;
        }
        new TransactionBuilder("requestMtu")
                .requestMtu(mtu)
                .queue(getQueue());
        mMTU = mtu;
    }

    @Override
    public void onMtuChanged(BluetoothGatt gatt, int mtu, int status) {
        super.onMtuChanged(gatt, mtu, status);

        final Prefs prefs = new Prefs(GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()));

        if (!prefs.getBoolean(PREF_ALLOW_HIGH_MTU, false)) {
            LOG.warn("Ignoring MTU change to {}", mtu);
            return;
        }

        LOG.info("MTU changed to {}", mtu);
        this.mMTU = mtu;
    }

    private void acknowledgeFindPhone() {
        try {
            TransactionBuilder builder = performInitialized("acknowledge find phone");

            writeToConfiguration(builder,AmazfitBipService.COMMAND_ACK_FIND_PHONE_IN_PROGRESS);
            builder.queue(getQueue());
        } catch (Exception ex) {
            LOG.error("Error while ending acknowledge find phone", ex);
        }
    }

    private void processDeviceEvent(int event){
        LOG.debug("Handling device event: " + event);
        Prefs prefs = new Prefs(GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()));
        String deviceActionBroadcastMessage=null;

        switch (event) {
            case HuamiDeviceEvent.WOKE_UP:
                String wakeupAction = prefs.getString(PREF_DEVICE_ACTION_WOKE_UP_SELECTION,PREF_DEVICE_ACTION_SELECTION_OFF);
                if (wakeupAction.equals(PREF_DEVICE_ACTION_SELECTION_OFF)) return;
                deviceActionBroadcastMessage= prefs.getString(PREF_DEVICE_ACTION_WOKE_UP_BROADCAST,
                        this.getContext().getString(R.string.prefs_events_forwarding_wokeup_broadcast_default_value));
                handleDeviceAction(wakeupAction, deviceActionBroadcastMessage);
                break;
            case HuamiDeviceEvent.FELL_ASLEEP:
                String fellsleepAction = prefs.getString(PREF_DEVICE_ACTION_FELL_SLEEP_SELECTION,PREF_DEVICE_ACTION_SELECTION_OFF);
                if (fellsleepAction.equals(PREF_DEVICE_ACTION_SELECTION_OFF)) return;
                deviceActionBroadcastMessage= prefs.getString(PREF_DEVICE_ACTION_FELL_SLEEP_BROADCAST,
                        this.getContext().getString(R.string.prefs_events_forwarding_fellsleep_broadcast_default_value));
                handleDeviceAction(fellsleepAction, deviceActionBroadcastMessage);
                break;
            case HuamiDeviceEvent.START_NONWEAR:
                String nonwearAction = prefs.getString(PREF_DEVICE_ACTION_START_NON_WEAR_SELECTION,PREF_DEVICE_ACTION_SELECTION_OFF);
                if (nonwearAction.equals(PREF_DEVICE_ACTION_SELECTION_OFF)) return;
                deviceActionBroadcastMessage= prefs.getString(PREF_DEVICE_ACTION_START_NON_WEAR_BROADCAST,
                        this.getContext().getString(R.string.prefs_events_forwarding_startnonwear_broadcast_default_value));
                handleDeviceAction(nonwearAction, deviceActionBroadcastMessage);
                break;
        }

    }

    private void handleLongButtonEvent(){
        Prefs prefs = new Prefs(GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()));

        if (!prefs.getBoolean(HuamiConst.PREF_BUTTON_ACTION_ENABLE, false)) {
            return;
        }

        currentButtonActionId = 0;
        currentButtonPressTime = System.currentTimeMillis();
        currentButtonTimerActivationTime = currentButtonPressTime;
        processButtonAction();

    }

    private void handleButtonEvent() {

        // If disabled we return from function immediately
        Prefs prefs = new Prefs(GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()));
        if (!prefs.getBoolean(HuamiConst.PREF_BUTTON_ACTION_ENABLE, false)) {
            return;
        }

        int buttonPressMaxDelay = prefs.getInt(HuamiConst.PREF_BUTTON_ACTION_PRESS_MAX_INTERVAL, 2000);
        int requiredButtonPressCount = prefs.getInt(HuamiConst.PREF_BUTTON_ACTION_PRESS_COUNT, 0);

        if (requiredButtonPressCount > 0) {
            long timeSinceLastPress = System.currentTimeMillis() - currentButtonPressTime;

            if ((currentButtonPressTime == 0) || (timeSinceLastPress < buttonPressMaxDelay)) {
                currentButtonPressCount++;
            } else {
                currentButtonPressCount = 1;
                currentButtonActionId = 0;
            }
            if (buttonActionTimer != null){
                buttonActionTimer.cancel();
            }

            currentButtonPressTime = System.currentTimeMillis();
            if (currentButtonPressCount == requiredButtonPressCount) {
                currentButtonTimerActivationTime = currentButtonPressTime;
                LOG.info("Activating button timer");
                buttonActionTimer = new Timer("Huami Button Action Timer");
                buttonActionTimer.scheduleAtFixedRate(new TimerTask() {
                    @Override
                    public void run() {
                        processButtonAction();
                        buttonActionTimer.cancel();
                    }
                }, buttonPressMaxDelay, buttonPressMaxDelay);

                currentButtonActionId++;
                currentButtonPressCount = 0;
            }
        }
    }


    @Override
    public boolean onCharacteristicChanged(BluetoothGatt gatt,
                                           BluetoothGattCharacteristic characteristic) {
        super.onCharacteristicChanged(gatt, characteristic);

        UUID characteristicUUID = characteristic.getUuid();
        if (HuamiService.UUID_CHARACTERISTIC_6_BATTERY_INFO.equals(characteristicUUID)) {
            handleBatteryInfo(characteristic.getValue(), BluetoothGatt.GATT_SUCCESS);
            return true;
        } else if (MiBandService.UUID_CHARACTERISTIC_REALTIME_STEPS.equals(characteristicUUID)) {
            handleRealtimeSteps(characteristic.getValue());
            return true;
        } else if (GattCharacteristic.UUID_CHARACTERISTIC_HEART_RATE_MEASUREMENT.equals(characteristicUUID)) {
            handleHeartrate(characteristic.getValue());
            return true;
        } else if (HuamiService.UUID_CHARACTERISTIC_AUTH.equals(characteristicUUID)) {
            LOG.info("AUTHENTICATION?? " + characteristicUUID);
            logMessageContent(characteristic.getValue());
            return true;
        } else if (HuamiService.UUID_CHARACTERISTIC_DEVICEEVENT.equals(characteristicUUID)) {
            handleDeviceEvent(characteristic.getValue());
            return true;
        } else if (HuamiService.UUID_CHARACTERISTIC_WORKOUT.equals(characteristicUUID)) {
            handleDeviceWorkoutEvent(characteristic.getValue());
            return true;
        } else if (HuamiService.UUID_CHARACTERISTIC_7_REALTIME_STEPS.equals(characteristicUUID)) {
            handleRealtimeSteps(characteristic.getValue());
            return true;
        } else if (HuamiService.UUID_CHARACTERISTIC_3_CONFIGURATION.equals(characteristicUUID)) {
            handleConfigurationInfo(characteristic.getValue());
            return true;
        } else if (HuamiService.UUID_CHARACTERISTIC_CHUNKEDTRANSFER_2021_READ.equals(characteristicUUID) && huamiChunked2021Decoder != null) {
            byte[] decoded_data = huamiChunked2021Decoder.decode(characteristic.getValue());
            if (decoded_data != null) {
                handleConfigurationInfo(decoded_data);
            }
            return true;
        } else {
            LOG.info("Unhandled characteristic changed: " + characteristicUUID);
            logMessageContent(characteristic.getValue());
        }

        return false;
    }

    @Override
    public boolean onCharacteristicRead(BluetoothGatt gatt,
                                        BluetoothGattCharacteristic characteristic, int status) {
        super.onCharacteristicRead(gatt, characteristic, status);

        UUID characteristicUUID = characteristic.getUuid();
        if (GattCharacteristic.UUID_CHARACTERISTIC_DEVICE_NAME.equals(characteristicUUID)) {
            handleDeviceName(characteristic.getValue(), status);
            return true;
        } else if (HuamiService.UUID_CHARACTERISTIC_6_BATTERY_INFO.equals(characteristicUUID)) {
            handleBatteryInfo(characteristic.getValue(), status);
            return true;
        } else if (GattCharacteristic.UUID_CHARACTERISTIC_HEART_RATE_MEASUREMENT.equals(characteristicUUID)) {
            logHeartrate(characteristic.getValue(), status);
            return true;
        } else if (HuamiService.UUID_CHARACTERISTIC_7_REALTIME_STEPS.equals(characteristicUUID)) {
            handleRealtimeSteps(characteristic.getValue());
            return true;
        } else if (HuamiService.UUID_CHARACTERISTIC_DEVICEEVENT.equals(characteristicUUID)) {
            handleDeviceEvent(characteristic.getValue());
            return true;
        } else if (HuamiService.UUID_CHARACTERISTIC_WORKOUT.equals(characteristicUUID)) {
            handleDeviceWorkoutEvent(characteristic.getValue());
            return true;
        } else {
            LOG.info("Unhandled characteristic read: " + characteristicUUID);
            logMessageContent(characteristic.getValue());
        }

        return false;
    }

    @Override
    public boolean onCharacteristicWrite(BluetoothGatt gatt,
                                         BluetoothGattCharacteristic characteristic, int status) {
        UUID characteristicUUID = characteristic.getUuid();
        if (HuamiService.UUID_CHARACTERISTIC_AUTH.equals(characteristicUUID)) {
            LOG.info("KEY AES SEND");
            logMessageContent(characteristic.getValue());
            return true;
        }
        return false;
    }

    public void logHeartrate(byte[] value, int status) {
        if (status == BluetoothGatt.GATT_SUCCESS && value != null) {
            LOG.info("Got heartrate:");
            if (value.length == 2 && value[0] == 0) {
                int hrValue = (value[1] & 0xff);
                GB.toast(getContext(), "Heart Rate measured: " + hrValue, Toast.LENGTH_LONG, GB.INFO);
            }
            return;
        }
        logMessageContent(value);
    }

    private void handleHeartrate(byte[] value) {
        if (value.length == 2 && value[0] == 0) {
            int hrValue = (value[1] & 0xff);
            if (LOG.isDebugEnabled()) {
                LOG.debug("heart rate: " + hrValue);
            }
            RealtimeSamplesSupport realtimeSamplesSupport = getRealtimeSamplesSupport();
            realtimeSamplesSupport.setHeartrateBpm(hrValue);
            if (!realtimeSamplesSupport.isRunning()) {
                // single shot measurement, manually invoke storage and result publishing
                realtimeSamplesSupport.triggerCurrentSample();
            }
        }
    }

    private void handleRealtimeSteps(byte[] value) {
        if (value == null) {
            LOG.error("realtime steps: value is null");
            return;
        }

        if (value.length == 13) {
            byte[] stepsValue = new byte[] {value[1], value[2]};
            int steps = BLETypeConversions.toUint16(stepsValue);
            if (LOG.isDebugEnabled()) {
                LOG.debug("realtime steps: " + steps);
            }
            getRealtimeSamplesSupport().setSteps(steps);
        } else {
            LOG.warn("Unrecognized realtime steps value: " + Logging.formatBytes(value));
        }
    }

    byte[] reassemblyBuffer;
    byte reassemblyType = 0x00;

    private void handleConfigurationInfo(byte[] value) {
        if (value == null || value.length < 4) {
            return;
        }
        if (value[0] == 0x10 && value[2] == 0x01) {
            if (value[1] == COMMAND_GPS_VERSION) {
                String gpsVersion = new String(value, 3, value.length - 3);
                LOG.info("got gps version = " + gpsVersion);
                gbDevice.setFirmwareVersion2(gpsVersion);
            } else if (value[1] == COMMAND_ALARMS) {
                LOG.info("got alarms from watch");
                decodeAndUpdateAlarmStatus(value, false);
            } else {
                LOG.warn("got configuration info we do not handle yet " + GB.hexdump(value, 3, -1));
            }
        } else if (value[0] == ((byte) 0x80) && value[1] == 0x01) {
            boolean done = false;
            if (value[2] == 0x00 || value[2] == (byte) 0xc0) { // first chunk or complete data
                reassemblyBuffer = new byte[value.length - 8];
                reassemblyType = value[4];
                System.arraycopy(value, 8, reassemblyBuffer, 0, reassemblyBuffer.length);
                if (value[2] == (byte) 0xc0) {
                    done = true;
                }
            } else if (reassemblyBuffer != null && (value[2] == 0x40 || value[2] == (byte) 0x80)) {
                byte[] payload = new byte[value.length - 4];
                System.arraycopy(value, 4, payload, 0, payload.length);
                reassemblyBuffer = ArrayUtils.addAll(reassemblyBuffer, payload);
                if (value[2] == (byte) 0x80) {
                    done = true;
                }
            }
            if (!done) {
                LOG.info("got chunk of configuration data for {}", String.format("0x%x", reassemblyType));
            } else {
                LOG.info("got full/reassembled configuration data");
                switch (reassemblyType) {
                    case COMMAND_ALARMS_WITH_TIMES:
                        decodeAndUpdateAlarmStatus(reassemblyBuffer, true);
                        break;
                    case COMMAND_WORKOUT_ACTIVITY_TYPES:
                        LOG.warn("got workout activity types, not handled");
                        break;
                    default:
                        LOG.warn("got unknown chunked configuration response for {}, not handled", String.format("0x%x", reassemblyType));
                        break;
                }

                reassemblyBuffer = null;
            }
        } else {
            LOG.warn("unknown response got from configuration request " + GB.hexdump(value, 0, -1));
        }
    }

    private void decodeAndUpdateAlarmStatus(byte[] response, boolean withTimes) {
        List<nodomain.freeyourgadget.gadgetbridge.entities.Alarm> alarms = DBHelper.getAlarms(gbDevice);
        int maxAlarms = 10;

        //FIXME: we can rather have a full struct here probably
        boolean[] alarmsInUse = new boolean[maxAlarms];
        boolean[] alarmsEnabled = new boolean[maxAlarms];
        byte[] alarmsMinute = new byte[maxAlarms];
        byte[] alarmsHour = new byte[maxAlarms];
        byte[] alarmsRepetition = new byte[maxAlarms];

        int nr_alarms;
        byte enable_flag;
        if (withTimes) {
            nr_alarms = (response.length - 1) / 4;
            enable_flag = (byte) 0x80;
        } else {
            nr_alarms = response[8];
            enable_flag = (byte) 0x10;
        }
        for (int i = 0; i < nr_alarms; i++) {
            int offset;
            if (withTimes) {
                offset = i * 4 + 1;
            } else {
                offset = 9 + i;
            }
            byte alarm_data = response[offset];
            int index = alarm_data & 0xf;
            if (index >= maxAlarms) {
                GB.toast("Unexpected alarm index from device, ignoring: " + index, Toast.LENGTH_SHORT, GB.ERROR);
                return;
            }
            alarmsInUse[index] = true;
            boolean enabled = (alarm_data & enable_flag) == enable_flag;
            alarmsEnabled[index] = enabled;
            if (withTimes) {
                alarmsHour[index] = response[offset + 1];
                alarmsMinute[index] = response[offset + 2];
                alarmsRepetition[index] = response[offset + 3];
            }

            LOG.info("alarm " + index + " is enabled:" + enabled);
        }
        for (nodomain.freeyourgadget.gadgetbridge.entities.Alarm alarm : alarms) {
            int pos = alarm.getPosition();
            boolean enabled = alarmsEnabled[pos];
            boolean unused = !alarmsInUse[pos];
            if (alarm.getEnabled() != enabled || alarm.getUnused() != unused || (withTimes && !unused && (alarm.getHour() != alarmsHour[pos] || alarm.getMinute() != alarmsMinute[pos] || alarm.getRepetition() != alarmsRepetition[pos]))) {
                LOG.info("updating alarm index " + pos + " unused=" + unused + ", enabled=" + enabled);
                alarm.setEnabled(enabled);
                alarm.setUnused(unused);
                if (withTimes && !unused) {
                    alarm.setHour(alarmsHour[pos]);
                    alarm.setMinute(alarmsMinute[pos]);
                    alarm.setRepetition(alarmsRepetition[pos]);
                }
                DBHelper.store(alarm);
                Intent intent = new Intent(DeviceService.ACTION_SAVE_ALARMS);
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        }
    }

    private void enableRealtimeSamplesTimer(boolean enable) {
        if (enable) {
            getRealtimeSamplesSupport().start();
        } else {
            if (realtimeSamplesSupport != null) {
                realtimeSamplesSupport.stop();
            }
        }
    }

    public MiBandActivitySample createActivitySample(Device device, User user, int timestampInSeconds, SampleProvider provider) {
        MiBandActivitySample sample = new MiBandActivitySample();
        sample.setDevice(device);
        sample.setUser(user);
        sample.setTimestamp(timestampInSeconds);
        sample.setProvider(provider);

        return sample;
    }

    private RealtimeSamplesSupport getRealtimeSamplesSupport() {
        if (realtimeSamplesSupport == null) {
            realtimeSamplesSupport = new RealtimeSamplesSupport(1000, 1000) {
                @Override
                public void doCurrentSample() {

                    try (DBHandler handler = GBApplication.acquireDB()) {
                        DaoSession session = handler.getDaoSession();

                        Device device = DBHelper.getDevice(gbDevice, session);
                        User user = DBHelper.getUser(session);
                        int ts = (int) (System.currentTimeMillis() / 1000);
                        MiBand2SampleProvider provider = new MiBand2SampleProvider(gbDevice, session);
                        MiBandActivitySample sample = createActivitySample(device, user, ts, provider);
                        sample.setHeartRate(getHeartrateBpm());
//                        sample.setSteps(getSteps());
                        sample.setRawIntensity(ActivitySample.NOT_MEASURED);
                        sample.setRawKind(HuamiConst.TYPE_ACTIVITY); // to make it visible in the charts TODO: add a MANUAL kind for that?

                        provider.addGBActivitySample(sample);

                        // set the steps only afterwards, since realtime steps are also recorded
                        // in the regular samples and we must not count them twice
                        // Note: we know that the DAO sample is never committed again, so we simply
                        // change the value here in memory.
                        sample.setSteps(getSteps());

                        if (LOG.isDebugEnabled()) {
                            LOG.debug("realtime sample: " + sample);
                        }

                        Intent intent = new Intent(DeviceService.ACTION_REALTIME_SAMPLES)
                                .putExtra(DeviceService.EXTRA_REALTIME_SAMPLE, sample);
                        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);

                    } catch (Exception e) {
                        LOG.warn("Unable to acquire db for saving realtime samples", e);
                    }
                }
            };
        }
        return realtimeSamplesSupport;
    }

    private void handleDeviceName(byte[] value, int status) {
//        if (status == BluetoothGatt.GATT_SUCCESS) {
//            versionCmd.hwVersion = new String(value);
//            handleGBDeviceEvent(versionCmd);
//        }
    }

    /**
     * Convert an alarm from the GB internal structure to a Mi Band message and put on the specified
     * builder queue as a write message for the passed characteristic
     *
     * @param alarm
     * @param builder
     */
    private void queueAlarm(Alarm alarm, TransactionBuilder builder) {
        Calendar calendar = AlarmUtils.toCalendar(alarm);

        DeviceCoordinator coordinator = DeviceHelper.getInstance().getCoordinator(gbDevice);
        int maxAlarms = coordinator.getAlarmSlotCount();

        if (alarm.getPosition() >= maxAlarms) {
            if (alarm.getEnabled()) {
                GB.toast(getContext(), "Only " + maxAlarms + " alarms are currently supported.", Toast.LENGTH_LONG, GB.WARN);
            }
            return;
        }

        int actionMask = 0;
        int daysMask = 0;
        if (alarm.getEnabled() && !alarm.getUnused()) {
            actionMask = 0x80;

            if (coordinator.supportsAlarmSnoozing() && !alarm.getSnooze()) {
                actionMask |= 0x40;
            }
        }
        if (!alarm.getUnused()) {
            daysMask = alarm.getRepetition();
            if (!alarm.isRepetitive()) {
                daysMask = 128;
            }
        }

        byte[] alarmMessage = new byte[]{
                (byte) 0x2, // TODO what is this?
                (byte) (actionMask | alarm.getPosition()), // action mask + alarm slot
                (byte) calendar.get(Calendar.HOUR_OF_DAY),
                (byte) calendar.get(Calendar.MINUTE),
                (byte) daysMask,
        };

        writeToConfiguration(builder,alarmMessage);

        // TODO: react on 0x10, 0x02, 0x01 on notification (success)
    }

    protected void handleDeviceInfo(nodomain.freeyourgadget.gadgetbridge.service.btle.profiles.deviceinfo.DeviceInfo info) {
//        if (getDeviceInfo().supportsHeartrate()) {
//            getDevice().addDeviceInfo(new GenericItem(
//                    getContext().getString(R.string.DEVINFO_HR_VER),
//                    info.getSoftwareRevision()));
//        }

        LOG.warn("Device info: " + info);
        versionCmd.hwVersion = info.getHardwareRevision();
        versionCmd.fwVersion = info.getFirmwareRevision();
        if (versionCmd.fwVersion == null) {
            versionCmd.fwVersion = info.getSoftwareRevision();
        }
        if (versionCmd.fwVersion != null && versionCmd.fwVersion.length() > 0 && versionCmd.fwVersion.charAt(0) == 'V') {
            versionCmd.fwVersion = versionCmd.fwVersion.substring(1);
        }
        handleGBDeviceEvent(versionCmd);
    }

    private void handleBatteryInfo(byte[] value, int status) {
        if (status == BluetoothGatt.GATT_SUCCESS) {
            HuamiBatteryInfo info = new HuamiBatteryInfo(value);
            batteryCmd.level = ((short) info.getLevelInPercent());
            batteryCmd.state = info.getState();
            batteryCmd.lastChargeTime = info.getLastChargeTime();
            batteryCmd.numCharges = info.getNumCharges();
            handleGBDeviceEvent(batteryCmd);
        }
    }

    /**
     * Fetch the events from the android device calendars and set the alarms on the miband.
     * @param builder
     */
    private HuamiSupport sendCalendarEvents(TransactionBuilder builder) {
        Prefs prefs = new Prefs(GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()));
        int availableSlots = prefs.getInt(PREF_RESERVER_ALARMS_CALENDAR, 0);

        if (availableSlots > 0) {
            CalendarManager upcomingEvents = new CalendarManager(getContext(), getDevice().getAddress());
            List<CalendarEvent> mEvents = upcomingEvents.getCalendarEventList();

            int iteration = 0;

            for (CalendarEvent mEvt : mEvents) {
                if (mEvt.isAllDay()) {
                    continue;
                }
                if (iteration >= availableSlots || iteration > 2) {
                    break;
                }
                int slotToUse = 2 - iteration;
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(mEvt.getBegin());
                Alarm alarm = AlarmUtils.createSingleShot(slotToUse, false, true, calendar);
                queueAlarm(alarm, builder);
                iteration++;
            }
        }
        return this;
    }

    private HuamiSupport sendCalendarEventsAsReminder(TransactionBuilder builder) {
        boolean syncCalendar = GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()).getBoolean(PREF_SYNC_CALENDAR, false);
        if (!syncCalendar) {
            return this;
        }

        final Prefs prefs = new Prefs(GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()));
        int availableSlots = prefs.getInt(PREF_RESERVER_REMINDERS_CALENDAR, 9);

        CalendarManager upcomingEvents = new CalendarManager(getContext(), getDevice().getAddress());
        List<CalendarEvent> calendarEvents = upcomingEvents.getCalendarEventList();
        Calendar calendar = Calendar.getInstance();

        int iteration = 0;

        for (CalendarEvent calendarEvent : calendarEvents) {
            if (calendarEvent.isAllDay()) {
                continue;
            }

            if (iteration >= availableSlots) {
                break;
            }

            calendar.setTimeInMillis(calendarEvent.getBegin());
            byte[] title;
            if (calendarEvent.getTitle() != null) {
                title = calendarEvent.getTitle().getBytes();
            } else {
                title = new byte[]{};
            }

            int length = 1 + 1 + 4 + 6 + 6 + 1 + title.length + 1;

            ByteBuffer buf = ByteBuffer.allocate(length);

            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.put((byte) 0x0b); // always 0x0b?
            buf.put((byte) iteration); // id
            buf.putInt(0x08 | 0x04 | 0x01); // flags 0x01 = enable, 0x04 = end date present, 0x08 = has text
            calendar.setTimeInMillis(calendarEvent.getBegin());
            buf.put(BLETypeConversions.shortCalendarToRawBytes(calendar));
            calendar.setTimeInMillis(calendarEvent.getEnd());
            buf.put(BLETypeConversions.shortCalendarToRawBytes(calendar));
            buf.put((byte) 0); // 0 Terminated
            buf.put(title);
            buf.put((byte) 0); // 0 Terminated
            writeToChunked(builder, 2, buf.array());

            iteration++;
        }

        // Continue by deleting the events
        for(;iteration < availableSlots; iteration++){
            int length = 1 + 1 + 4 + 6 + 6 + 1 + 0 + 1;
            ByteBuffer buf = ByteBuffer.allocate(length);

            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.put((byte) 0x0b); // always 0x0b?
            buf.put((byte) iteration); // id
            buf.putInt(0x08); // flags 0x01 = enable, 0x04 = end date present, 0x08 = has text
            buf.put(new byte[6 + 6 + 1 + 1]); // default value is 0
            writeToChunked(builder, 2, buf.array());
        }

        return this;
    }

    @Override
    public void onSendConfiguration(String config) {
        TransactionBuilder builder;
        try {
            builder = performInitialized("Sending configuration for option: " + config);
            switch (config) {
                case MiBandConst.PREF_MI2_DATEFORMAT:
                    setDateDisplay(builder);
                    break;
                case PREF_USER_FITNESS_GOAL_NOTIFICATION:
                    setGoalNotification(builder);
                    break;
                case PREF_ACTIVATE_DISPLAY_ON_LIFT:
                case PREF_DISPLAY_ON_LIFT_START:
                case PREF_DISPLAY_ON_LIFT_END:
                    setActivateDisplayOnLiftWrist(builder);
                    break;
                case PREF_DISPLAY_ON_LIFT_SENSITIVITY:
                    setActivateDisplayOnLiftWristSensitivity(builder);
                    break;
                case PREF_DISCONNECT_NOTIFICATION:
                case PREF_DISCONNECT_NOTIFICATION_START:
                case PREF_DISCONNECT_NOTIFICATION_END:
                    setDisconnectNotification(builder);
                    break;
                case HuamiConst.PREF_DISPLAY_ITEMS:
                case HuamiConst.PREF_DISPLAY_ITEMS_SORTABLE:
                    setDisplayItems(builder);
                    break;
                case HuamiConst.PREF_SHORTCUTS:
                case HuamiConst.PREF_SHORTCUTS_SORTABLE:
                    setShortcuts(builder);
                    break;
                case HuamiConst.PREF_WORKOUT_ACTIVITY_TYPES_SORTABLE:
                    setWorkoutActivityTypes(builder);
                    break;
                case MiBandConst.PREF_MI2_ROTATE_WRIST_TO_SWITCH_INFO:
                    setRotateWristToSwitchInfo(builder);
                    break;
                case ActivityUser.PREF_USER_STEPS_GOAL:
                    setFitnessGoal(builder);
                    break;
                case PREF_DO_NOT_DISTURB:
                case PREF_DO_NOT_DISTURB_START:
                case PREF_DO_NOT_DISTURB_END:
                case PREF_DO_NOT_DISTURB_LIFT_WRIST:
                    setDoNotDisturb(builder);
                    break;
                case PREF_INACTIVITY_ENABLE:
                case PREF_INACTIVITY_THRESHOLD:
                case PREF_INACTIVITY_START:
                case PREF_INACTIVITY_END:
                case PREF_INACTIVITY_DND:
                case PREF_INACTIVITY_DND_START:
                case PREF_INACTIVITY_DND_END:
                    setInactivityWarnings(builder);
                    break;
                case SettingsActivity.PREF_MEASUREMENT_SYSTEM:
                    setDistanceUnit(builder);
                    break;
                case MiBandConst.PREF_SWIPE_UNLOCK:
                    setBandScreenUnlock(builder);
                    break;
                case PREF_TIMEFORMAT:
                    setTimeFormat(builder);
                    break;
                case PREF_DATEFORMAT:
                    setDateFormat(builder);
                    break;
                case PREF_LANGUAGE:
                    setLanguage(builder);
                    break;
                case HuamiConst.PREF_EXPOSE_HR_THIRDPARTY:
                    setExposeHRThridParty(builder);
                    break;
                case PREF_BT_CONNECTED_ADVERTISEMENT:
                    setBtConnectedAdvertising(builder);
                    break;
                case PREF_WEARLOCATION:
                    setWearLocation(builder);
                    break;
                case PREF_SOUNDS:
                    setBeepSounds(builder);
                    break;
                case PREF_USER_NAME:
                case PREF_USER_YEAR_OF_BIRTH:
                case PREF_USER_WEIGHT_KG:
                case PREF_USER_HEIGHT_CM:
                case PREF_USER_GENDER:
                    setUserInfo(builder);
                    break;
                case PREF_HUAMI_VIBRATION_PROFILE_APP_ALERTS:
                case PREF_HUAMI_VIBRATION_PROFILE_INCOMING_CALL:
                case PREF_HUAMI_VIBRATION_PROFILE_INCOMING_SMS:
                case PREF_HUAMI_VIBRATION_PROFILE_GOAL_NOTIFICATION:
                case PREF_HUAMI_VIBRATION_PROFILE_ALARM:
                case PREF_HUAMI_VIBRATION_PROFILE_IDLE_ALERTS:
                case PREF_HUAMI_VIBRATION_PROFILE_EVENT_REMINDER:
                case PREF_HUAMI_VIBRATION_PROFILE_FIND_BAND:
                case PREF_HUAMI_VIBRATION_COUNT_APP_ALERTS:
                case PREF_HUAMI_VIBRATION_COUNT_INCOMING_CALL:
                case PREF_HUAMI_VIBRATION_COUNT_INCOMING_SMS:
                case PREF_HUAMI_VIBRATION_COUNT_GOAL_NOTIFICATION:
                case PREF_HUAMI_VIBRATION_COUNT_ALARM:
                case PREF_HUAMI_VIBRATION_COUNT_IDLE_ALERTS:
                case PREF_HUAMI_VIBRATION_COUNT_EVENT_REMINDER:
                case PREF_HUAMI_VIBRATION_COUNT_FIND_BAND:
                case PREF_HUAMI_VIBRATION_TRY_APP_ALERTS:
                case PREF_HUAMI_VIBRATION_TRY_INCOMING_CALL:
                case PREF_HUAMI_VIBRATION_TRY_INCOMING_SMS:
                case PREF_HUAMI_VIBRATION_TRY_GOAL_NOTIFICATION:
                case PREF_HUAMI_VIBRATION_TRY_ALARM:
                case PREF_HUAMI_VIBRATION_TRY_IDLE_ALERTS:
                case PREF_HUAMI_VIBRATION_TRY_EVENT_REMINDER:
                case PREF_HUAMI_VIBRATION_TRY_FIND_BAND:
                    setVibrationPattern(builder, config);
                    break;
                case PREF_HEARTRATE_ACTIVITY_MONITORING:
                    setHeartrateActivityMonitoring(builder);
                    break;
                case PREF_HEARTRATE_ALERT_ENABLED:
                case PREF_HEARTRATE_ALERT_THRESHOLD:
                    setHeartrateAlert(builder);
                    break;
                case PREF_HEARTRATE_STRESS_MONITORING:
                    setHeartrateStressMonitoring(builder);
                    break;
                case PasswordCapabilityImpl.PREF_PASSWORD:
                case PasswordCapabilityImpl.PREF_PASSWORD_ENABLED:
                    setPassword(builder);
                    break;
            }
            builder.queue(getQueue());
        } catch (IOException e) {
            GB.toast("Error setting configuration", Toast.LENGTH_LONG, GB.ERROR, e);
        }
    }

    @Override
    public void onReadConfiguration(String config) {

    }

    @Override
    public void onTestNewFunction() {
        //requestMTU(23);
        try {
            final TransactionBuilder builder = performInitialized("test request");
            writeToConfiguration(builder, HuamiService.COMMAND_REQUEST_WORKOUT_ACTIVITY_TYPES);
            builder.queue(getQueue());
        } catch (final Exception e) {
            LOG.error("onTestNewFunction failed", e);
        }
    }

    private void setVibrationPattern(final TransactionBuilder builder, final String preferenceKey) {
        // The preference key has one of the 3 prefixes
        final String notificationTypeName = preferenceKey.replace(PREF_HUAMI_VIBRATION_COUNT_PREFIX, "")
                .replace(PREF_HUAMI_VIBRATION_PROFILE_PREFIX, "")
                .replace(PREF_HUAMI_VIBRATION_TRY_PREFIX, "")
                .toUpperCase(Locale.ROOT);
        final HuamiVibrationPatternNotificationType notificationType = HuamiVibrationPatternNotificationType.valueOf(notificationTypeName);
        final boolean isTry = preferenceKey.startsWith(PREF_HUAMI_VIBRATION_TRY_PREFIX);

        final VibrationProfile vibrationProfile = HuamiCoordinator.getVibrationProfile(getDevice().getAddress(), notificationType);

        setVibrationPattern(builder, notificationType, isTry, vibrationProfile);
    }

    /**
     * Test or set a {@link VibrationProfile}.
     *
     * @param builder          the {@link TransactionBuilder}
     * @param notificationType the notification type
     * @param test             test the pattern (only vibrate the band, do not set it)
     * @param profile          the {@link VibrationProfile}
     */
    private void setVibrationPattern(final TransactionBuilder builder,
                                     final HuamiVibrationPatternNotificationType notificationType,
                                     final boolean test,
                                     final VibrationProfile profile) {
        final int MAX_TOTAL_LENGTH_MS = 10_000; // 10 seconds, about as long as Mi Fit allows
        int totalLengthMs = 0;

        // The on-off sequence, until the max total length is reached
        final List<Short> onOff = new ArrayList<>(profile.getOnOffSequence().length);

        for (int c = 0; c < profile.getRepeat(); c++) {
            for (int i = 0; i < profile.getOnOffSequence().length; i += 2) {
                final short on = (short) profile.getOnOffSequence()[i];
                final short off = (short) profile.getOnOffSequence()[i + 1];

                if (totalLengthMs + on + off > MAX_TOTAL_LENGTH_MS) {
                    LOG.warn("VibrationProfile {} too long, truncating to {} ms", profile.getId(), MAX_TOTAL_LENGTH_MS);
                    break;
                }

                onOff.add(on);
                onOff.add(off);
                totalLengthMs += on + off;
            }
        }

        final ByteBuffer buf = ByteBuffer.allocate(3 + 2 * onOff.size());
        buf.order(ByteOrder.LITTLE_ENDIAN);

        buf.put((byte) 0x20);
        buf.put(notificationType.getCode());
        byte flag = (byte) (onOff.size() / 2);
        flag |= 0x40;
        if (test) {
            flag |= 0x80;
        }
        buf.put(flag);

        for (Short time : onOff) {
            buf.putShort(time);
        }

        writeToChunked(builder, 2, buf.array());
    }

    @Override
    public void onSendWeather(WeatherSpec weatherSpec) {
        final DeviceCoordinator coordinator = DeviceHelper.getInstance().getCoordinator(gbDevice);
        if (!coordinator.supportsWeather()) {
            return;
        }

        if (gbDevice.getFirmwareVersion() == null) {
            LOG.warn("Device not initialized yet, so not sending weather info");
            return;
        }
        boolean supportsConditionString = true;

        Version version = new Version(gbDevice.getFirmwareVersion());
        if (gbDevice.getType() == DeviceType.AMAZFITBIP && version.compareTo(new Version("0.0.8.74")) < 0) {
            supportsConditionString = false;
        }

        MiBandConst.DistanceUnit unit = HuamiCoordinator.getDistanceUnit();
        int tz_offset_hours = SimpleTimeZone.getDefault().getOffset(weatherSpec.timestamp * 1000L) / (1000 * 60 * 60);
        try {
            TransactionBuilder builder;
            builder = performInitialized("Sending current temp");

            byte condition = HuamiWeatherConditions.mapToAmazfitBipWeatherCode(weatherSpec.currentConditionCode);

            int length = 8;
            if (supportsConditionString) {
                length += weatherSpec.currentCondition.getBytes().length + 1;
            }
            ByteBuffer buf = ByteBuffer.allocate(length);
            buf.order(ByteOrder.LITTLE_ENDIAN);

            buf.put((byte) 2);
            buf.putInt(weatherSpec.timestamp);
            buf.put((byte) (tz_offset_hours * 4));
            buf.put(condition);

            int currentTemp = weatherSpec.currentTemp - 273;
            if (unit == MiBandConst.DistanceUnit.IMPERIAL) {
                currentTemp = (int) WeatherUtils.celsiusToFahrenheit(currentTemp);
            }
            buf.put((byte) currentTemp);

            if (supportsConditionString) {
                buf.put(weatherSpec.currentCondition.getBytes());
                buf.put((byte) 0);
            }

            if (characteristicChunked != null) {
                writeToChunked(builder, 1, buf.array());
            } else {
                builder.write(getCharacteristic(AmazfitBipService.UUID_CHARACTERISTIC_WEATHER), buf.array());
            }

            builder.queue(getQueue());
        } catch (Exception ex) {
            LOG.error("Error sending current weather", ex);
        }

        try {
            TransactionBuilder builder;
            builder = performInitialized("Sending air quality index");
            int length = 8;
            String aqiString = "(n/a)";
            if (supportsConditionString) {
                length += aqiString.getBytes().length + 1;
            }
            ByteBuffer buf = ByteBuffer.allocate(length);
            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.put((byte) 4);
            buf.putInt(weatherSpec.timestamp);
            buf.put((byte) (tz_offset_hours * 4));
            buf.putShort((short) -1);
            if (supportsConditionString) {
                buf.put(aqiString.getBytes());
                buf.put((byte) 0);
            }

            if (characteristicChunked != null) {
                writeToChunked(builder, 1, buf.array());
            } else {
                builder.write(getCharacteristic(AmazfitBipService.UUID_CHARACTERISTIC_WEATHER), buf.array());
            }

            builder.queue(getQueue());
        } catch (IOException ex) {
            LOG.error("Error sending air quality");
        }

        try {
            TransactionBuilder builder = performInitialized("Sending weather forecast");
            if (weatherSpec.forecasts.size() > 6) { //TDOD: find out the limits for each device
                weatherSpec.forecasts.subList(6, weatherSpec.forecasts.size()).clear();
            }
            final byte NR_DAYS = (byte) (1 + weatherSpec.forecasts.size());
            int bytesPerDay = 4;

            int conditionsLength = 0;
            if (supportsConditionString) {
                bytesPerDay = 5;
                conditionsLength = weatherSpec.currentCondition.getBytes().length;
                for (WeatherSpec.Forecast forecast : weatherSpec.forecasts) {
                    conditionsLength += Weather.getConditionString(forecast.conditionCode).getBytes().length;
                }
            }

            int length = 7 + bytesPerDay * NR_DAYS + conditionsLength;
            ByteBuffer buf = ByteBuffer.allocate(length);

            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.put((byte) 1);
            buf.putInt(weatherSpec.timestamp);
            buf.put((byte) (tz_offset_hours * 4));

            buf.put(NR_DAYS);

            byte condition = HuamiWeatherConditions.mapToAmazfitBipWeatherCode(weatherSpec.currentConditionCode);
            buf.put(condition);
            buf.put(condition);

            int todayMaxTemp = weatherSpec.todayMaxTemp - 273;
            int todayMinTemp = weatherSpec.todayMinTemp - 273;
            if (unit == MiBandConst.DistanceUnit.IMPERIAL) {
                todayMaxTemp = (int) WeatherUtils.celsiusToFahrenheit(todayMaxTemp);
                todayMinTemp = (int) WeatherUtils.celsiusToFahrenheit(todayMinTemp);
            }
            buf.put((byte) todayMaxTemp);
            buf.put((byte) todayMinTemp);

            if (supportsConditionString) {
                buf.put(weatherSpec.currentCondition.getBytes());
                buf.put((byte) 0);
            }

            for (WeatherSpec.Forecast forecast : weatherSpec.forecasts) {
                condition = HuamiWeatherConditions.mapToAmazfitBipWeatherCode(forecast.conditionCode);
                buf.put(condition);
                buf.put(condition);

                int forecastMaxTemp = forecast.maxTemp - 273;
                int forecastMinTemp = forecast.minTemp - 273;
                if (unit == MiBandConst.DistanceUnit.IMPERIAL) {
                    forecastMaxTemp = (int) WeatherUtils.celsiusToFahrenheit(forecastMaxTemp);
                    forecastMinTemp = (int) WeatherUtils.celsiusToFahrenheit(forecastMinTemp);
                }
                buf.put((byte) forecastMaxTemp);
                buf.put((byte) forecastMinTemp);

                if (supportsConditionString) {
                    buf.put(Weather.getConditionString(forecast.conditionCode).getBytes());
                    buf.put((byte) 0);
                }
            }

            if (characteristicChunked != null) {
                writeToChunked(builder, 1, buf.array());
            } else {
                builder.write(getCharacteristic(AmazfitBipService.UUID_CHARACTERISTIC_WEATHER), buf.array());
            }

            builder.queue(getQueue());
        } catch (Exception ex) {
            LOG.error("Error sending weather forecast", ex);
        }

        try {
            TransactionBuilder builder;
            builder = performInitialized("Sending forecast location");

            int length = 2 + weatherSpec.location.getBytes().length;
            ByteBuffer buf = ByteBuffer.allocate(length);
            buf.order(ByteOrder.LITTLE_ENDIAN);
            buf.put((byte) 8);
            buf.put(weatherSpec.location.getBytes());
            buf.put((byte) 0);


            if (characteristicChunked != null) {
                writeToChunked(builder, 1, buf.array());
            } else {
                builder.write(getCharacteristic(AmazfitBipService.UUID_CHARACTERISTIC_WEATHER), buf.array());
            }

            builder.queue(getQueue());
        } catch (Exception ex) {
            LOG.error("Error sending current forecast location", ex);
        }

        if (supportsSunriseSunsetWindHumidity()) {
            try {
                TransactionBuilder builder;
                builder = performInitialized("Sending wind/humidity");

                String windString = this.windSpeedString(weatherSpec);
                String humidityString = weatherSpec.currentHumidity + "%";

                int length = 8 + windString.getBytes().length + humidityString.getBytes().length;

                ByteBuffer buf = ByteBuffer.allocate(length);
                buf.order(ByteOrder.LITTLE_ENDIAN);
                buf.put((byte) 64);
                buf.putInt(weatherSpec.timestamp);
                buf.put((byte) (tz_offset_hours * 4));
                buf.put(windString.getBytes());
                buf.put((byte) 0);
                buf.put(humidityString.getBytes());
                buf.put((byte) 0);
                writeToChunked(builder, 1, buf.array());
                builder.queue(getQueue());
            } catch (Exception ex) {
                LOG.error("Error sending wind/humidity", ex);
            }

            float[] longlat = GBApplication.getGBPrefs().getLongLat(getContext());
            float longitude = longlat[0];
            float latitude = longlat[1];
            if (longitude != 0 && latitude != 0) {
                final GregorianCalendar dateTimeToday = new GregorianCalendar();

                GregorianCalendar[] sunriseTransitSet = SPA.calculateSunriseTransitSet(dateTimeToday, latitude, longitude, DeltaT.estimate(dateTimeToday));

                try {
                    TransactionBuilder builder;
                    builder = performInitialized("Sending sunrise/sunset");

                    ByteBuffer buf = ByteBuffer.allocate(10);
                    buf.order(ByteOrder.LITTLE_ENDIAN);
                    buf.put((byte) 16);
                    buf.putInt(weatherSpec.timestamp);
                    buf.put((byte) (tz_offset_hours * 4));
                    buf.put((byte) sunriseTransitSet[0].get(GregorianCalendar.HOUR_OF_DAY));
                    buf.put((byte) sunriseTransitSet[0].get(GregorianCalendar.MINUTE));
                    buf.put((byte) sunriseTransitSet[2].get(GregorianCalendar.HOUR_OF_DAY));
                    buf.put((byte) sunriseTransitSet[2].get(GregorianCalendar.MINUTE));

                    writeToChunked(builder, 1, buf.array());
                    builder.queue(getQueue());
                } catch (Exception ex) {
                    LOG.error("Error sending sunset/sunrise", ex);
                }
            }
        }
    }

    private HuamiSupport setDateDisplay(TransactionBuilder builder) {
        DateTimeDisplay dateTimeDisplay = HuamiCoordinator.getDateDisplay(getContext(), gbDevice.getAddress());
        LOG.info("Setting date display to " + dateTimeDisplay);
        switch (dateTimeDisplay) {
            case TIME:
                writeToConfiguration(builder,HuamiService.DATEFORMAT_TIME);
                break;
            case DATE_TIME:
                writeToConfiguration(builder,HuamiService.DATEFORMAT_DATE_TIME);
                break;
        }
        return this;
    }

    protected HuamiSupport setDateFormat(TransactionBuilder builder) {
        String dateFormat = GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()).getString("dateformat", "MM/dd/yyyy");
        if (dateFormat == null) {
            return null;
        }
        switch (dateFormat) {
            case "MM/dd/yyyy":
            case "dd.MM.yyyy":
            case "dd/MM/yyyy":
                byte[] command = HuamiService.DATEFORMAT_DATE_MM_DD_YYYY;
                System.arraycopy(dateFormat.getBytes(), 0, command, 3, 10);
                writeToConfiguration(builder,command);
                break;
            default:
                LOG.warn("unsupported date format " + dateFormat);
        }

        return this;
    }

    private HuamiSupport setTimeFormat(TransactionBuilder builder) {
        GBPrefs gbPrefs = new GBPrefs(new Prefs(GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress())));
        String timeFormat = gbPrefs.getTimeFormat();

        LOG.info("Setting time format to " + timeFormat);
        if (timeFormat.equals("24h")) {
            writeToConfiguration(builder,HuamiService.DATEFORMAT_TIME_24_HOURS);
        } else {
            writeToConfiguration(builder,HuamiService.DATEFORMAT_TIME_12_HOURS);
        }
        return this;
    }

    private HuamiSupport setGoalNotification(TransactionBuilder builder) {
        boolean enable = HuamiCoordinator.getGoalNotification(gbDevice.getAddress());
        LOG.info("Setting goal notification to " + enable);
        if (enable) {
            writeToConfiguration(builder,HuamiService.COMMAND_ENABLE_GOAL_NOTIFICATION);
        } else {
            writeToConfiguration(builder,HuamiService.COMMAND_DISABLE_GOAL_NOTIFICATION);
        }
        return this;
    }

    private HuamiSupport setActivateDisplayOnLiftWrist(TransactionBuilder builder) {
        ActivateDisplayOnLift displayOnLift = HuamiCoordinator.getActivateDisplayOnLiftWrist(getContext(), gbDevice.getAddress());
        LOG.info("Setting activate display on lift wrist to " + displayOnLift);

        switch (displayOnLift) {
            case ON:
                writeToConfiguration(builder, HuamiService.COMMAND_ENABLE_DISPLAY_ON_LIFT_WRIST);
                break;
            case OFF:
                writeToConfiguration(builder, HuamiService.COMMAND_DISABLE_DISPLAY_ON_LIFT_WRIST);
                break;
            case SCHEDULED:
                byte[] cmd = HuamiService.COMMAND_SCHEDULE_DISPLAY_ON_LIFT_WRIST.clone();

                Calendar calendar = GregorianCalendar.getInstance();

                Date start = HuamiCoordinator.getDisplayOnLiftStart(gbDevice.getAddress());
                calendar.setTime(start);
                cmd[4] = (byte) calendar.get(Calendar.HOUR_OF_DAY);
                cmd[5] = (byte) calendar.get(Calendar.MINUTE);

                Date end = HuamiCoordinator.getDisplayOnLiftEnd(gbDevice.getAddress());
                calendar.setTime(end);
                cmd[6] = (byte) calendar.get(Calendar.HOUR_OF_DAY);
                cmd[7] = (byte) calendar.get(Calendar.MINUTE);

                writeToConfiguration(builder, cmd);
        }
        return this;
    }

    protected HuamiSupport setActivateDisplayOnLiftWristSensitivity(TransactionBuilder builder) {
        final ActivateDisplayOnLiftSensitivity sensitivity = HuamiCoordinator.getDisplayOnLiftSensitivity(gbDevice.getAddress());
        LOG.info("Setting activate display on lift wrist sensitivity to " + sensitivity);

        switch (sensitivity) {
            case SENSITIVE:
                writeToConfiguration(builder, HuamiService.COMMAND_DISPLAY_ON_LIFT_WRIST_SPEED_SENSITIVE);
                break;
            case NORMAL:
            default:
                writeToConfiguration(builder, HuamiService.COMMAND_DISPLAY_ON_LIFT_WRIST_SPEED_NORMAL);
                break;
        }

        return this;
    }

    protected HuamiSupport setDisplayItems(TransactionBuilder builder) {
        SharedPreferences prefs = GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress());
        Set<String> pages = prefs.getStringSet(HuamiConst.PREF_DISPLAY_ITEMS, new HashSet<>(Arrays.asList(getContext().getResources().getStringArray(R.array.pref_mi2_display_items_default))));

        LOG.info("Setting display items to " + (pages == null ? "none" : pages));

        byte[] data = HuamiService.COMMAND_CHANGE_SCREENS.clone();

        if (pages != null) {
            if (pages.contains(MiBandConst.PREF_MI2_DISPLAY_ITEM_STEPS)) {
                data[HuamiService.SCREEN_CHANGE_BYTE] |= HuamiService.DISPLAY_ITEM_BIT_STEPS;
            }
            if (pages.contains(MiBandConst.PREF_MI2_DISPLAY_ITEM_DISTANCE)) {
                data[HuamiService.SCREEN_CHANGE_BYTE] |= HuamiService.DISPLAY_ITEM_BIT_DISTANCE;
            }
            if (pages.contains(MiBandConst.PREF_MI2_DISPLAY_ITEM_CALORIES)) {
                data[HuamiService.SCREEN_CHANGE_BYTE] |= HuamiService.DISPLAY_ITEM_BIT_CALORIES;
            }
            if (pages.contains(MiBandConst.PREF_MI2_DISPLAY_ITEM_HEART_RATE)) {
                data[HuamiService.SCREEN_CHANGE_BYTE] |= HuamiService.DISPLAY_ITEM_BIT_HEART_RATE;
            }
            if (pages.contains(MiBandConst.PREF_MI2_DISPLAY_ITEM_BATTERY)) {
                data[HuamiService.SCREEN_CHANGE_BYTE] |= HuamiService.DISPLAY_ITEM_BIT_BATTERY;
            }
            writeToConfiguration(builder,data);
        }

        return this;
    }

    protected HuamiSupport setDisplayItemsOld(TransactionBuilder builder, boolean isShortcuts, int defaultSettings, Map<String, Integer> keyPosMap) {
        SharedPreferences prefs = GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress());
        String pages;
        List<String> enabledList;
        if (isShortcuts) {
            pages = prefs.getString(HuamiConst.PREF_SHORTCUTS_SORTABLE, null);
            LOG.info("Setting shortcuts");
        } else {
            pages = prefs.getString(HuamiConst.PREF_DISPLAY_ITEMS_SORTABLE, null);
            LOG.info("Setting menu items");
        }
        if (pages == null) {
            enabledList = Arrays.asList(getContext().getResources().getStringArray(defaultSettings));
        } else {
            enabledList = Arrays.asList(pages.split(","));
        }
        LOG.info("enabled items" + enabledList);
        byte[] command;

        if (isShortcuts) {
            command = new byte[keyPosMap.size() * 2 + 1];
            command[0] = 0x10;
            int pos = 1;
            int index = 0;
            for (String key : enabledList) {
                Integer id = keyPosMap.get(key);
                if (id != null) {
                    command[pos++] = (byte) (0x80 | index++);
                    command[pos++] = id.byteValue();
                }
            }
            for (Map.Entry<String, Integer> entry : keyPosMap.entrySet()) {
                String key = entry.getKey();
                int id = entry.getValue();

                if (!enabledList.contains(key)) {
                    command[pos++] = (byte) index++;
                    command[pos++] = (byte) id;
                }
            }
        } else {
            command = new byte[keyPosMap.size() + 4];
            command[0] = ENDPOINT_DISPLAY_ITEMS;
            byte index = 1;
            int enabled_mask = DISPLAY_ITEM_BIT_CLOCK;
            // it seem that we first have to put all ENABLED items into the array, oder does matter
            for (String key : enabledList) {
                Integer id = keyPosMap.get(key);
                if (id != null) {
                    enabled_mask |= (1 << id.byteValue());
                    command[3 + id] = index++;
                }
            }
            // And then all DISABLED ones, order does not matter
            for (Map.Entry<String, Integer> entry : keyPosMap.entrySet()) {
                String key = entry.getKey();
                int id = entry.getValue();

                if (!enabledList.contains(key)) {
                    command[3 + id] = index++;
                }
            }

            command[1] = (byte) (enabled_mask & 0xff);
            command[2] = (byte) ((enabled_mask >> 8 & 0xff));
        }

        writeToConfiguration(builder,  command);
        return this;
    }

    protected HuamiSupport setDisplayItemsNew(TransactionBuilder builder, boolean isShortcuts, boolean forceWatchface, int defaultSettings) {
        SharedPreferences prefs = GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress());
        String pages;
        ArrayList<String> enabledList;
        byte menuType;
        if (isShortcuts) {
            menuType = (byte) 0xfd;
            pages = prefs.getString(HuamiConst.PREF_SHORTCUTS_SORTABLE, null);
            LOG.info("Setting shortcuts");
        } else {
            menuType = (byte) 0xff;
            pages = prefs.getString(HuamiConst.PREF_DISPLAY_ITEMS_SORTABLE, null);
            LOG.info("Setting menu items");
        }
        if (pages == null) {
            enabledList = new ArrayList<>(Arrays.asList(getContext().getResources().getStringArray(defaultSettings)));
        } else {
            enabledList = new ArrayList<>(Arrays.asList(pages.split(",")));
        }
        if (forceWatchface) {
            enabledList.add(0, "watchface");
        }
        LOG.info("enabled items" + enabledList);
        byte[] command = new byte[enabledList.size() * 4 + 1];
        command[0] = 0x1e;

        int pos = 1;
        int index = 0;

        for (String key : enabledList) {
            Integer id = HuamiMenuType.idLookup.get(key);
            if (id != null) {
                command[pos++] = (byte) index++;
                command[pos++] = 0x00;
                command[pos++] = menuType;
                command[pos++] = id.byteValue();
            }
        }

        writeToChunked(builder, 2, command);

        return this;
    }

    protected HuamiSupport setShortcuts(TransactionBuilder builder) {
        return this;
    }

    protected HuamiSupport setWorkoutActivityTypes(final TransactionBuilder builder) {
        final SharedPreferences prefs = GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress());

        final List<String> allActivityTypes = Arrays.asList(getContext().getResources().getStringArray(R.array.pref_miband5_workout_activity_types_values));
        final List<String> defaultActivityTypes = Arrays.asList(getContext().getResources().getStringArray(R.array.pref_miband5_workout_activity_types_default));
        final String activityTypesPref = prefs.getString(HuamiConst.PREF_WORKOUT_ACTIVITY_TYPES_SORTABLE, null);

        final List<String> enabledActivityTypes;
        if (activityTypesPref == null || activityTypesPref.equals("")) {
            enabledActivityTypes = defaultActivityTypes;
        } else {
            enabledActivityTypes = Arrays.asList(activityTypesPref.split(","));
        }

        LOG.info("Setting workout types to {}", enabledActivityTypes);

        final byte[] command = new byte[allActivityTypes.size() * 3 + 2];
        command[0] = 0x0b;
        command[1] = 0x00;

        int pos = 2;

        for (final String workoutType : enabledActivityTypes) {
            command[pos++] = HuamiWorkoutScreenActivityType.fromPrefValue(workoutType).getCode();
            command[pos++] = 0x00;
            command[pos++] = 0x01;
        }

        // Send all the remaining disabled workout types
        for (final String workoutType : allActivityTypes) {
            if (!enabledActivityTypes.contains(workoutType)) {
                command[pos++] = HuamiWorkoutScreenActivityType.fromPrefValue(workoutType).getCode();
                command[pos++] = 0x00;
                command[pos++] = 0x00;
            }
        }

        writeToChunked(builder, 9, command);

        return this;
    }

    protected HuamiSupport setBeepSounds(TransactionBuilder builder) {

        SharedPreferences prefs = GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress());
        Set<String> sounds = prefs.getStringSet(PREF_SOUNDS, new HashSet<>(Arrays.asList(getContext().getResources().getStringArray(R.array.pref_amazfitneo_sounds_default))));

        LOG.info("Setting sounds to " + (sounds == null ? "none" : sounds));


        if (sounds != null) {
            final String[] soundOrder = new String[]{"button", "calls", "alarm", "notifications", "inactivity_warning", "sms", "email", "goal"};
            byte[] command = new byte[]{0x3c, 0, 0, 0, 1, 0, 0, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 7, 0, 0};
            int i = 3;
            for (String sound : soundOrder) {
                if (sounds.contains(sound)) {
                    command[i] = 1;
                }
                i += 3;
            }
            writeToChunked(builder, 2, command);
        }

        return this;
    }

    private HuamiSupport setRotateWristToSwitchInfo(TransactionBuilder builder) {
        boolean enable = HuamiCoordinator.getRotateWristToSwitchInfo(gbDevice.getAddress());
        LOG.info("Setting rotate wrist to cycle info to " + enable);
        if (enable) {
            writeToConfiguration(builder,  HuamiService.COMMAND_ENABLE_ROTATE_WRIST_TO_SWITCH_INFO);
        } else {
            writeToConfiguration(builder,  HuamiService.COMMAND_DISABLE_ROTATE_WRIST_TO_SWITCH_INFO);
        }
        return this;
    }

    private HuamiSupport setDisplayCaller(TransactionBuilder builder) {
        writeToConfiguration(builder,  HuamiService.COMMAND_ENABLE_DISPLAY_CALLER);
        return this;
    }

    private HuamiSupport setDoNotDisturb(TransactionBuilder builder) {
        DoNotDisturb doNotDisturb = HuamiCoordinator.getDoNotDisturb(gbDevice.getAddress());
        boolean doNotDisturbLiftWrist = HuamiCoordinator.getDoNotDisturbLiftWrist(gbDevice.getAddress());
        LOG.info("Setting do not disturb to {}, wake on lift wrist {}", doNotDisturb, doNotDisturbLiftWrist);
        byte[] data = null;

        switch (doNotDisturb) {
            case OFF:
                data = HuamiService.COMMAND_DO_NOT_DISTURB_OFF.clone();
                break;
            case AUTOMATIC:
                data = HuamiService.COMMAND_DO_NOT_DISTURB_AUTOMATIC.clone();
                break;
            case SCHEDULED:
                data = HuamiService.COMMAND_DO_NOT_DISTURB_SCHEDULED.clone();

                Calendar calendar = GregorianCalendar.getInstance();

                Date start = HuamiCoordinator.getDoNotDisturbStart(gbDevice.getAddress());
                calendar.setTime(start);
                data[HuamiService.DND_BYTE_START_HOURS] = (byte) calendar.get(Calendar.HOUR_OF_DAY);
                data[HuamiService.DND_BYTE_START_MINUTES] = (byte) calendar.get(Calendar.MINUTE);

                Date end = HuamiCoordinator.getDoNotDisturbEnd(gbDevice.getAddress());
                calendar.setTime(end);
                data[HuamiService.DND_BYTE_END_HOURS] = (byte) calendar.get(Calendar.HOUR_OF_DAY);
                data[HuamiService.DND_BYTE_END_MINUTES] = (byte) calendar.get(Calendar.MINUTE);

                break;
        }

        if (data != null) {
            if (doNotDisturbLiftWrist && doNotDisturb != DoNotDisturb.OFF) {
                data[1] &= ~0x80;
            }

            writeToConfiguration(builder,  data);
        }

        return this;
    }

    private HuamiSupport setInactivityWarnings(TransactionBuilder builder) {
        boolean enable = HuamiCoordinator.getInactivityWarnings(gbDevice.getAddress());
        LOG.info("Setting inactivity warnings to " + enable);

        if (enable) {
            byte[] data = HuamiService.COMMAND_ENABLE_INACTIVITY_WARNINGS.clone();

            int threshold = HuamiCoordinator.getInactivityWarningsThreshold(gbDevice.getAddress());
            data[HuamiService.INACTIVITY_WARNINGS_THRESHOLD] = (byte) threshold;

            Calendar calendar = GregorianCalendar.getInstance();

            boolean enableDnd = HuamiCoordinator.getInactivityWarningsDnd(gbDevice.getAddress());

            Date intervalStart = HuamiCoordinator.getInactivityWarningsStart(gbDevice.getAddress());
            Date intervalEnd = HuamiCoordinator.getInactivityWarningsEnd(gbDevice.getAddress());
            Date dndStart = HuamiCoordinator.getInactivityWarningsDndStart(gbDevice.getAddress());
            Date dndEnd = HuamiCoordinator.getInactivityWarningsDndEnd(gbDevice.getAddress());

            // The first interval always starts when the warnings interval starts
            calendar.setTime(intervalStart);
            data[HuamiService.INACTIVITY_WARNINGS_INTERVAL_1_START_HOURS] = (byte) calendar.get(Calendar.HOUR_OF_DAY);
            data[HuamiService.INACTIVITY_WARNINGS_INTERVAL_1_START_MINUTES] = (byte) calendar.get(Calendar.MINUTE);

            if(enableDnd) {
                // The first interval ends when the dnd interval starts
                calendar.setTime(dndStart);
                data[HuamiService.INACTIVITY_WARNINGS_INTERVAL_1_END_HOURS] = (byte) calendar.get(Calendar.HOUR_OF_DAY);
                data[HuamiService.INACTIVITY_WARNINGS_INTERVAL_1_END_MINUTES] = (byte) calendar.get(Calendar.MINUTE);

                // The second interval starts when the dnd interval ends
                calendar.setTime(dndEnd);
                data[HuamiService.INACTIVITY_WARNINGS_INTERVAL_2_START_HOURS] = (byte) calendar.get(Calendar.HOUR_OF_DAY);
                data[HuamiService.INACTIVITY_WARNINGS_INTERVAL_2_START_MINUTES] = (byte) calendar.get(Calendar.MINUTE);

                // ... and it ends when the warnings interval ends
                calendar.setTime(intervalEnd);
                data[HuamiService.INACTIVITY_WARNINGS_INTERVAL_2_END_HOURS] = (byte) calendar.get(Calendar.HOUR_OF_DAY);
                data[HuamiService.INACTIVITY_WARNINGS_INTERVAL_2_END_MINUTES] = (byte) calendar.get(Calendar.MINUTE);
            } else {
                // No Dnd, use the first interval
                calendar.setTime(intervalEnd);
                data[HuamiService.INACTIVITY_WARNINGS_INTERVAL_1_END_HOURS] = (byte) calendar.get(Calendar.HOUR_OF_DAY);
                data[HuamiService.INACTIVITY_WARNINGS_INTERVAL_1_END_MINUTES] = (byte) calendar.get(Calendar.MINUTE);
            }

            writeToConfiguration(builder,  data);
        } else {
            writeToConfiguration(builder,  HuamiService.COMMAND_DISABLE_INACTIVITY_WARNINGS);
        }

        return this;
    }

    private HuamiSupport setDisconnectNotification(TransactionBuilder builder) {
        DisconnectNotificationSetting disconnectNotificationSetting = HuamiCoordinator.getDisconnectNotificationSetting(getContext(), gbDevice.getAddress());
        LOG.info("Setting disconnect notification to " + disconnectNotificationSetting);

        switch (disconnectNotificationSetting) {
            case ON:
                writeToConfiguration(builder,  HuamiService.COMMAND_ENABLE_DISCONNECT_NOTIFCATION);
                break;
            case OFF:
                writeToConfiguration(builder,  HuamiService.COMMAND_DISABLE_DISCONNECT_NOTIFCATION);
                break;
            case SCHEDULED:
                byte[] cmd = HuamiService.COMMAND_ENABLE_DISCONNECT_NOTIFCATION.clone();

                Calendar calendar = GregorianCalendar.getInstance();

                Date start = HuamiCoordinator.getDisconnectNotificationStart(gbDevice.getAddress());
                calendar.setTime(start);
                cmd[4] = (byte) calendar.get(Calendar.HOUR_OF_DAY);
                cmd[5] = (byte) calendar.get(Calendar.MINUTE);

                Date end = HuamiCoordinator.getDisconnectNotificationEnd(gbDevice.getAddress());
                calendar.setTime(end);
                cmd[6] = (byte) calendar.get(Calendar.HOUR_OF_DAY);
                cmd[7] = (byte) calendar.get(Calendar.MINUTE);

                writeToConfiguration(builder,  cmd);
        }
        return this;
    }

    private HuamiSupport setDistanceUnit(TransactionBuilder builder) {
        MiBandConst.DistanceUnit unit = HuamiCoordinator.getDistanceUnit();
        LOG.info("Setting distance unit to " + unit);
        if (unit == MiBandConst.DistanceUnit.METRIC) {
            writeToConfiguration(builder,  HuamiService.COMMAND_DISTANCE_UNIT_METRIC);
        } else {
            writeToConfiguration(builder,  HuamiService.COMMAND_DISTANCE_UNIT_IMPERIAL);
        }
        return this;
    }

    protected HuamiSupport setBandScreenUnlock(TransactionBuilder builder) {
        boolean enable = MiBand3Coordinator.getBandScreenUnlock(gbDevice.getAddress());
        LOG.info("Setting band screen unlock to " + enable);

        if (enable) {
            writeToConfiguration(builder,  MiBand3Service.COMMAND_ENABLE_BAND_SCREEN_UNLOCK);
        } else {
            writeToConfiguration(builder,  MiBand3Service.COMMAND_DISABLE_BAND_SCREEN_UNLOCK);
        }

        return this;
    }


    protected HuamiSupport setLanguage(TransactionBuilder builder) {
        String localeString = GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()).getString("language", "auto");
        if (localeString == null || localeString.equals("auto")) {
            String language = Locale.getDefault().getLanguage();
            String country = Locale.getDefault().getCountry();

            if (country == null) {
                // sometimes country is null, no idea why, guess it.
                country = language;
            }
            localeString = language + "_" + country.toUpperCase();
        }
        LOG.info("Setting device to locale: " + localeString);
        final byte[] command_new = HuamiService.COMMAND_SET_LANGUAGE_NEW_TEMPLATE.clone();
        System.arraycopy(localeString.getBytes(), 0, command_new, 3, localeString.getBytes().length);

        byte[] command_old;
        switch (localeString.substring(0, 2)) {
            case "es":
                command_old = AmazfitBipService.COMMAND_SET_LANGUAGE_SPANISH;
                break;
            case "zh":
                if (localeString.equals("zh_CN")) {
                    command_old = AmazfitBipService.COMMAND_SET_LANGUAGE_SIMPLIFIED_CHINESE;
                } else {
                    command_old = AmazfitBipService.COMMAND_SET_LANGUAGE_TRADITIONAL_CHINESE;

                }
                break;
            default:
                command_old = AmazfitBipService.COMMAND_SET_LANGUAGE_ENGLISH;
        }
        if (force2021Protocol) {
            writeToConfiguration(builder,command_new);
        } else {
            final byte[] finalCommand_old = command_old;
            builder.add(new ConditionalWriteAction(getCharacteristic(HuamiService.UUID_CHARACTERISTIC_3_CONFIGURATION)) {
                @Override
                protected byte[] checkCondition() {
                    if ((gbDevice.getType() == DeviceType.AMAZFITBIP && new Version(gbDevice.getFirmwareVersion()).compareTo(new Version("0.1.0.77")) < 0) ||
                            (gbDevice.getType() == DeviceType.AMAZFITCOR && new Version(gbDevice.getFirmwareVersion()).compareTo(new Version("1.0.7.23")) < 0)) {
                        return finalCommand_old;
                    } else {
                        return command_new;
                    }
                }
            });
        }
        return this;
    }

    /*
        Some newer devices seem to support setting the language by id again instead of a locale string
        Amazfit Bip U and GTS 2 mini tested so far
     */
    protected HuamiSupport setLanguageByIdNew(TransactionBuilder builder) {
        byte language_code = 0x02; // english default

        String localeString = GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()).getString("language", "auto");
        if (localeString == null || localeString.equals("auto")) {
            String language = Locale.getDefault().getLanguage();
            String country = Locale.getDefault().getCountry();

            localeString = language + "_" + country.toUpperCase();
        }

        Integer id = HuamiLanguageType.idLookup.get(localeString);
        if (id != null) {
            language_code = id.byteValue();
        }

        final byte[] command = new byte[]{0x06, 0x3b, 0x00, language_code, 0x03};
        writeToConfiguration(builder, command);
        return this;
    }

    private HuamiSupport setExposeHRThridParty(TransactionBuilder builder) {
        boolean enable = HuamiCoordinator.getExposeHRThirdParty(gbDevice.getAddress());
        LOG.info("Setting exposure of HR to third party apps to: " + enable);

        if (enable) {
            writeToConfiguration(builder,  HuamiService.COMMAND_ENBALE_HR_CONNECTION);
        } else {
            writeToConfiguration(builder,  HuamiService.COMMAND_DISABLE_HR_CONNECTION);
        }

        return this;
    }

    private HuamiSupport setBtConnectedAdvertising(TransactionBuilder builder) {
        boolean enable = HuamiCoordinator.getBtConnectedAdvertising(gbDevice.getAddress());
        LOG.info("Setting connected advertisement to: " + enable);

        if (enable) {
            writeToConfiguration(builder,  HuamiService.COMMAND_ENABLE_BT_CONNECTED_ADVERTISEMENT);
        } else {
            writeToConfiguration(builder,  HuamiService.COMMAND_DISABLE_BT_CONNECTED_ADVERTISEMENT);
        }

        return this;
    }

    protected void writeToChunked(TransactionBuilder builder, int type, byte[] data) {
        if (force2021Protocol && type > 0) {
            boolean encrypt = true;
            if (type == 1 && (data[1] == 2)) { // don't encypt current weather
                encrypt = false;
            }

            byte[] command = ArrayUtils.addAll(new byte[]{0x00, 0x00, (byte) (0xc0 | type), 0x00}, data);
            writeToChunked2021(builder, HuamiService.CHUNKED2021_ENDPOINT_COMPAT, getNextHandle(), command, true, encrypt);
        } else {
            writeToChunkedOld(builder, type, data);
        }
    }

    protected void writeToChunkedOld(TransactionBuilder builder, int type, byte[] data) {
        final int MAX_CHUNKLENGTH = mMTU - 6;
        int remaining = data.length;
        byte count = 0;
        while (remaining > 0) {
            int copybytes = Math.min(remaining, MAX_CHUNKLENGTH);
            byte[] chunk = new byte[copybytes + 3];

            byte flags = 0;
            if (remaining <= MAX_CHUNKLENGTH) {
                flags |= 0x80; // last chunk
                if (count == 0) {
                    flags |= 0x40; // weird but true
                }
            } else if (count > 0) {
                flags |= 0x40; // consecutive chunk
            }

            chunk[0] = 0;
            chunk[1] = (byte) (flags | type);
            chunk[2] = (byte) (count & 0xff);

            System.arraycopy(data, count++ * MAX_CHUNKLENGTH, chunk, 3, copybytes);
            builder.write(characteristicChunked, chunk);
            remaining -= copybytes;
        }
    }

    public void writeToChunked2021(TransactionBuilder builder, short type, byte handle, byte[] data, boolean extended_flags, boolean encrypt) {
        int remaining = data.length;
        int length = data.length;
        byte count = 0;
        int header_size = 10;

        if (extended_flags) {
            header_size++;
        }

        if (extended_flags && encrypt) {
            byte[] messagekey = new byte[16];
            for (int i = 0; i < 16; i++) {
                messagekey[i] = (byte) (sharedSessionKey[i] ^ handle);
            }
            int encrypted_length = length + 8;
            int overflow = encrypted_length % 16;
            if (overflow > 0) {
                encrypted_length += (16 - overflow);
            }

            byte[] encryptable_payload = new byte[encrypted_length];
            System.arraycopy(data, 0, encryptable_payload, 0, length);
            encryptable_payload[length] = (byte) (encryptedSequenceNr & 0xff);
            encryptable_payload[length + 1] = (byte) ((encryptedSequenceNr >> 8) & 0xff);
            encryptable_payload[length + 2] = (byte) ((encryptedSequenceNr >> 16) & 0xff);
            encryptable_payload[length + 3] = (byte) ((encryptedSequenceNr >> 24) & 0xff);
            encryptedSequenceNr++;
            int checksum = CheckSums.getCRC32(encryptable_payload, 0, length + 4);
            encryptable_payload[length + 4] = (byte) (checksum & 0xff);
            encryptable_payload[length + 5] = (byte) ((checksum >> 8) & 0xff);
            encryptable_payload[length + 6] = (byte) ((checksum >> 16) & 0xff);
            encryptable_payload[length + 7] = (byte) ((checksum >> 24) & 0xff);
            remaining = encrypted_length;
            try {
                data = CryptoUtils.encryptAES(encryptable_payload, messagekey);
            } catch (Exception e) {
                LOG.error("error while encrypting", e);
                return;
            }

        }

        while (remaining > 0) {
            int MAX_CHUNKLENGTH = mMTU - 3 - header_size;
            int copybytes = Math.min(remaining, MAX_CHUNKLENGTH);
            byte[] chunk = new byte[copybytes + header_size];

            byte flags = 0;
            if (encrypt) {
                flags |= 0x08;
            }
            if (count == 0) {
                flags |= 0x01;
                int i = 4;
                if (extended_flags) {
                    i++;
                }
                chunk[i++] = (byte) (length & 0xff);
                chunk[i++] = (byte) ((length >> 8) & 0xff);
                chunk[i++] = (byte) ((length >> 16) & 0xff);
                chunk[i++] = (byte) ((length >> 24) & 0xff);
                chunk[i++] = (byte) (type & 0xff);
                chunk[i] = (byte) ((type >> 8) & 0xff);
            }
            if (remaining <= MAX_CHUNKLENGTH) {
                flags |= 0x06; // last chunk?
            }
            chunk[0] = 0x03;
            chunk[1] = flags;
            if (extended_flags) {
                chunk[2] = 0;
                chunk[3] = handle;
                chunk[4] = count;
            } else {
                chunk[2] = handle;
                chunk[3] = count;
            }

            System.arraycopy(data, data.length - remaining, chunk, header_size, copybytes);
            builder.write(characteristicChunked2021Write, chunk);
            remaining -= copybytes;
            header_size = 4;

            if (extended_flags) {
                header_size++;
            }

            count++;
        }
    }

    public void writeToConfiguration(TransactionBuilder builder, byte[] data) {
        if (force2021Protocol) {
            data = ArrayUtils.insert(0, data, (byte) 1);
            writeToChunked2021(builder, HuamiService.CHUNKED2021_ENDPOINT_COMPAT, getNextHandle(), data, true, true);
        } else {
            builder.write(getCharacteristic(HuamiService.UUID_CHARACTERISTIC_3_CONFIGURATION), data);
        }
    }

    protected HuamiSupport requestGPSVersion(TransactionBuilder builder) {
        LOG.info("Requesting GPS version");
        writeToConfiguration(builder,  HuamiService.COMMAND_REQUEST_GPS_VERSION);
        return this;
    }

    private HuamiSupport requestAlarms(TransactionBuilder builder) {
        LOG.info("Requesting alarms");
        //FIXME: on older devices only the first one works, and on newer only the last is sufficient
        writeToConfiguration(builder, HuamiService.COMMAND_REQUEST_ALARMS);
        writeToConfiguration(builder, HuamiService.COMMAND_REQUEST_ALARMS_WITH_TIMES);
        return this;
    }

    @Override
    public String customStringFilter(String inputString) {
        if (HuamiCoordinator.getUseCustomFont(gbDevice.getAddress())) {
            return convertEmojiToCustomFont(inputString);
        }
        return inputString;
    }


    private String convertEmojiToCustomFont(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (Character.isHighSurrogate(charAt)) {
                int i2 = i + 1;
                try {
                    int codePoint = Character.toCodePoint(charAt, str.charAt(i2));
                    if (codePoint < 127744 || codePoint > 129510) {
                        sb.append(charAt);
                    } else {
                        sb.append((char) (codePoint - 83712));
                        i = i2;
                    }
                } catch (StringIndexOutOfBoundsException e) {
                    LOG.warn("error while converting emoji to custom font", e);
                    sb.append(charAt);
                }
            } else {
                sb.append(charAt);
            }
            i++;
        }
        return sb.toString();
    }

    public void phase2Initialize(TransactionBuilder builder) {
        LOG.info("phase2Initialize...");
        requestBatteryInfo(builder);
    }

    public void phase3Initialize(TransactionBuilder builder) {
        final DeviceCoordinator coordinator = DeviceHelper.getInstance().getCoordinator(gbDevice);

        LOG.info("phase3Initialize...");
        setDateDisplay(builder);
        setTimeFormat(builder);
        setUserInfo(builder);
        setDistanceUnit(builder);
        setWearLocation(builder);
        setFitnessGoal(builder);
        setDisplayItems(builder);
        setDoNotDisturb(builder);
        setRotateWristToSwitchInfo(builder);
        setActivateDisplayOnLiftWrist(builder);
        setDisplayCaller(builder);
        setGoalNotification(builder);
        setInactivityWarnings(builder);
        setHeartrateSleepSupport(builder);
        setHeartrateActivityMonitoring(builder);
        setHeartrateAlert(builder);
        setHeartrateStressMonitoring(builder);
        setDisconnectNotification(builder);
        setExposeHRThridParty(builder);
        setHeartrateMeasurementInterval(builder, HuamiCoordinator.getHeartRateMeasurementInterval(getDevice().getAddress()));
        sendReminders(builder);
        setWorldClocks(builder);
        if (!PasswordCapabilityImpl.Mode.NONE.equals(coordinator.getPasswordCapability())) {
            setPassword(builder);
        }
        requestAlarms(builder);
    }

    public abstract HuamiFWHelper createFWHelper(Uri uri, Context context) throws IOException;

    public UpdateFirmwareOperation createUpdateFirmwareOperation(Uri uri) {
        return new UpdateFirmwareOperation(uri, this);
    }

    public int getMTU() {
        return mMTU;
    }

    public int getActivitySampleSize() {
        return mActivitySampleSize;
    }
}
