/*  Copyright (C) 2017-2021 Andreas Shimokawa, Carsten Pfeiffer, Nephiel,
    odavo32nof, Petr Vaněk, Zhong Jianxin

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
package nodomain.freeyourgadget.gadgetbridge.devices.huami;

import nodomain.freeyourgadget.gadgetbridge.model.ActivityKind;

public class HuamiConst {
    // observed the following values so far:
    // 00 01 02 09 0a 0b 0c 10 11

    // 0 = same activity kind as before
    // 1 = light activity walking?
    // 3 = definitely non-wear
    // 9 = probably light sleep, definitely some kind of sleep
    // 10 = ignore, except for hr (if valid)
    // 11 = probably deep sleep
    // 12 = definitely wake up
    // 17 = definitely not sleep related

    public static final int TYPE_UNSET = -1;
    public static final int TYPE_NO_CHANGE = 0;
    public static final int TYPE_ACTIVITY = 1;
    public static final int TYPE_RUNNING = 2;
    public static final int TYPE_NONWEAR = 3;
    public static final int TYPE_RIDE_BIKE = 4;
    public static final int TYPE_CHARGING = 6;
    public static final int TYPE_LIGHT_SLEEP = 9;
    public static final int TYPE_IGNORE = 10;
    public static final int TYPE_DEEP_SLEEP = 11;
    public static final int TYPE_WAKE_UP = 12;


    public static final String MI_BAND2_NAME = "MI Band 2";
    public static final String MI_BAND2_NAME_HRX = "Mi Band HRX";
    public static final String MI_BAND3_NAME = "Mi Band 3";
    public static final String MI_BAND3_NAME_2 = "Xiaomi Band 3";
    public static final String MI_BAND4_NAME = "Mi Smart Band 4";
    public static final String MI_BAND5_NAME = "Mi Smart Band 5";
    public static final String MI_BAND6_NAME = "Mi Smart Band 6";
    public static final String AMAZFIT_BAND5_NAME = "Amazfit Band 5";
    public static final String AMAZFIT_NEO_NAME = "Amazfit Neo";
    public static final String AMAZFIT_X = "Amazfit X";


    public static final String PREF_DISPLAY_ITEMS = "display_items";
    public static final String PREF_DISPLAY_ITEMS_SORTABLE = "display_items_sortable";
    public static final String PREF_WORKOUT_ACTIVITY_TYPES_SORTABLE = "workout_activity_types_sortable";
    public static final String PREF_SHORTCUTS = "shortcuts";
    public static final String PREF_SHORTCUTS_SORTABLE = "shortcuts_sortable";
    public static final String PREF_EXPOSE_HR_THIRDPARTY = "expose_hr_thirdparty";
    public static final String PREF_USE_CUSTOM_FONT = "use_custom_font";

    public static final String PREF_BUTTON_ACTION_ENABLE = "button_action_enable";
    public static final String PREF_BUTTON_ACTION_VIBRATE = "button_action_vibrate";
    public static final String PREF_BUTTON_ACTION_PRESS_COUNT = "button_action_press_count";
    public static final String PREF_BUTTON_ACTION_PRESS_MAX_INTERVAL = "button_action_press_max_interval";
    public static final String PREF_BUTTON_ACTION_BROADCAST_DELAY = "button_action_broadcast_delay";
    public static final String PREF_BUTTON_ACTION_BROADCAST = "button_action_broadcast";
    public static final String PREF_BUTTON_ACTION_SELECTION_OFF = "UNKNOWN";
    public static final String PREF_BUTTON_ACTION_SELECTION_BROADCAST = "BROADCAST";
    public static final String PREF_BUTTON_ACTION_SELECTION_FITNESS_APP_START = "FITNESS_CONTROL_START";
    public static final String PREF_BUTTON_ACTION_SELECTION_FITNESS_APP_STOP = "FITNESS_CONTROL_STOP";
    public static final String PREF_BUTTON_ACTION_SELECTION_FITNESS_APP_TOGGLE = "FITNESS_CONTROL_TOGGLE";

    public static final String PREF_DEVICE_ACTION_SELECTION_OFF = "UNKNOWN";
    public static final String PREF_DEVICE_ACTION_SELECTION_BROADCAST = "BROADCAST";
    public static final String PREF_DEVICE_ACTION_FELL_SLEEP_SELECTION = "events_forwarding_fellsleep_action_selection";
    public static final String PREF_DEVICE_ACTION_FELL_SLEEP_BROADCAST = "prefs_events_forwarding_fellsleep_broadcast";
    public static final String PREF_DEVICE_ACTION_WOKE_UP_SELECTION = "events_forwarding_wokeup_action_selection";
    public static final String PREF_DEVICE_ACTION_WOKE_UP_BROADCAST = "prefs_events_forwarding_wokeup_broadcast";
    public static final String PREF_DEVICE_ACTION_START_NON_WEAR_SELECTION = "events_forwarding_startnonwear_action_selection";
    public static final String PREF_DEVICE_ACTION_START_NON_WEAR_BROADCAST = "prefs_events_forwarding_startnonwear_broadcast";

    /**
     * The suffixes match the enum {@link nodomain.freeyourgadget.gadgetbridge.service.devices.huami.HuamiVibrationPatternNotificationType}.
     */
    // profile
    public static final String PREF_HUAMI_VIBRATION_PROFILE_PREFIX = "huami_vibration_profile_";
    public static final String PREF_HUAMI_VIBRATION_PROFILE_APP_ALERTS = PREF_HUAMI_VIBRATION_PROFILE_PREFIX + "app_alerts";
    public static final String PREF_HUAMI_VIBRATION_PROFILE_INCOMING_CALL = PREF_HUAMI_VIBRATION_PROFILE_PREFIX + "incoming_call";
    public static final String PREF_HUAMI_VIBRATION_PROFILE_INCOMING_SMS = PREF_HUAMI_VIBRATION_PROFILE_PREFIX + "incoming_sms";
    public static final String PREF_HUAMI_VIBRATION_PROFILE_GOAL_NOTIFICATION = PREF_HUAMI_VIBRATION_PROFILE_PREFIX + "goal_notification";
    public static final String PREF_HUAMI_VIBRATION_PROFILE_ALARM = PREF_HUAMI_VIBRATION_PROFILE_PREFIX + "alarm";
    public static final String PREF_HUAMI_VIBRATION_PROFILE_IDLE_ALERTS = PREF_HUAMI_VIBRATION_PROFILE_PREFIX + "idle_alerts";
    public static final String PREF_HUAMI_VIBRATION_PROFILE_EVENT_REMINDER = PREF_HUAMI_VIBRATION_PROFILE_PREFIX + "event_reminder";
    public static final String PREF_HUAMI_VIBRATION_PROFILE_FIND_BAND = PREF_HUAMI_VIBRATION_PROFILE_PREFIX + "find_band";
    // count
    public static final String PREF_HUAMI_VIBRATION_COUNT_PREFIX = "huami_vibration_count_";
    public static final String PREF_HUAMI_VIBRATION_COUNT_APP_ALERTS = PREF_HUAMI_VIBRATION_COUNT_PREFIX + "app_alerts";
    public static final String PREF_HUAMI_VIBRATION_COUNT_INCOMING_CALL = PREF_HUAMI_VIBRATION_COUNT_PREFIX + "incoming_call";
    public static final String PREF_HUAMI_VIBRATION_COUNT_INCOMING_SMS = PREF_HUAMI_VIBRATION_COUNT_PREFIX + "incoming_sms";
    public static final String PREF_HUAMI_VIBRATION_COUNT_GOAL_NOTIFICATION = PREF_HUAMI_VIBRATION_COUNT_PREFIX + "goal_notification";
    public static final String PREF_HUAMI_VIBRATION_COUNT_ALARM = PREF_HUAMI_VIBRATION_COUNT_PREFIX + "alarm";
    public static final String PREF_HUAMI_VIBRATION_COUNT_IDLE_ALERTS = PREF_HUAMI_VIBRATION_COUNT_PREFIX + "idle_alerts";
    public static final String PREF_HUAMI_VIBRATION_COUNT_EVENT_REMINDER = PREF_HUAMI_VIBRATION_COUNT_PREFIX + "event_reminder";
    public static final String PREF_HUAMI_VIBRATION_COUNT_FIND_BAND = PREF_HUAMI_VIBRATION_COUNT_PREFIX + "find_band";
    // try
    public static final String PREF_HUAMI_VIBRATION_TRY_PREFIX = "huami_vibration_try_";
    public static final String PREF_HUAMI_VIBRATION_TRY_APP_ALERTS = PREF_HUAMI_VIBRATION_TRY_PREFIX + "app_alerts";
    public static final String PREF_HUAMI_VIBRATION_TRY_INCOMING_CALL = PREF_HUAMI_VIBRATION_TRY_PREFIX + "incoming_call";
    public static final String PREF_HUAMI_VIBRATION_TRY_INCOMING_SMS = PREF_HUAMI_VIBRATION_TRY_PREFIX + "incoming_sms";
    public static final String PREF_HUAMI_VIBRATION_TRY_GOAL_NOTIFICATION = PREF_HUAMI_VIBRATION_TRY_PREFIX + "goal_notification";
    public static final String PREF_HUAMI_VIBRATION_TRY_ALARM = PREF_HUAMI_VIBRATION_TRY_PREFIX + "alarm";
    public static final String PREF_HUAMI_VIBRATION_TRY_IDLE_ALERTS = PREF_HUAMI_VIBRATION_TRY_PREFIX + "idle_alerts";
    public static final String PREF_HUAMI_VIBRATION_TRY_EVENT_REMINDER = PREF_HUAMI_VIBRATION_TRY_PREFIX + "event_reminder";
    public static final String PREF_HUAMI_VIBRATION_TRY_FIND_BAND = PREF_HUAMI_VIBRATION_TRY_PREFIX + "find_band";

    public static int toActivityKind(int rawType) {
        switch (rawType) {
            case TYPE_DEEP_SLEEP:
                return ActivityKind.TYPE_DEEP_SLEEP;
            case TYPE_LIGHT_SLEEP:
                return ActivityKind.TYPE_LIGHT_SLEEP;
            case TYPE_ACTIVITY:
            case TYPE_RUNNING:
            case TYPE_WAKE_UP:
                return ActivityKind.TYPE_ACTIVITY;
            case TYPE_NONWEAR:
                return ActivityKind.TYPE_NOT_WORN;
            case TYPE_CHARGING:
                return ActivityKind.TYPE_NOT_WORN; //I believe it's a safe assumption
            case TYPE_RIDE_BIKE:
                return ActivityKind.TYPE_CYCLING;
            default:
            case TYPE_UNSET: // fall through
                return ActivityKind.TYPE_UNKNOWN;
        }
    }

    public static int toRawActivityType(int activityKind) {
        switch (activityKind) {
            case ActivityKind.TYPE_ACTIVITY:
                return TYPE_ACTIVITY;
            case ActivityKind.TYPE_DEEP_SLEEP:
                return TYPE_DEEP_SLEEP;
            case ActivityKind.TYPE_LIGHT_SLEEP:
                return TYPE_LIGHT_SLEEP;
            case ActivityKind.TYPE_NOT_WORN:
                return TYPE_NONWEAR;
            case ActivityKind.TYPE_UNKNOWN: // fall through
            default:
                return TYPE_UNSET;
        }
    }

}
