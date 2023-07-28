/*  Copyright (C) 2019 José Rebelo

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
package nodomain.freeyourgadget.gadgetbridge.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import nodomain.freeyourgadget.gadgetbridge.GBApplication;
import nodomain.freeyourgadget.gadgetbridge.R;
import nodomain.freeyourgadget.gadgetbridge.activities.devicesettings.DeviceSettingsPreferenceConst;
import nodomain.freeyourgadget.gadgetbridge.adapter.GBReminderListAdapter;
import nodomain.freeyourgadget.gadgetbridge.database.DBHandler;
import nodomain.freeyourgadget.gadgetbridge.database.DBHelper;
import nodomain.freeyourgadget.gadgetbridge.devices.DeviceCoordinator;
import nodomain.freeyourgadget.gadgetbridge.entities.DaoSession;
import nodomain.freeyourgadget.gadgetbridge.entities.Device;
import nodomain.freeyourgadget.gadgetbridge.entities.Reminder;
import nodomain.freeyourgadget.gadgetbridge.entities.User;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice;
import nodomain.freeyourgadget.gadgetbridge.util.DeviceHelper;
import nodomain.freeyourgadget.gadgetbridge.util.Prefs;


public class ConfigureReminders extends AbstractGBActivity {
    private static final Logger LOG = LoggerFactory.getLogger(ConfigureReminders.class);

    private static final int REQ_CONFIGURE_REMINDER = 1;

    private GBReminderListAdapter mGBReminderListAdapter;
    private GBDevice gbDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_configure_reminders);

        gbDevice = getIntent().getParcelableExtra(GBDevice.EXTRA_DEVICE);

        mGBReminderListAdapter = new GBReminderListAdapter(this);

        final RecyclerView remindersRecyclerView = findViewById(R.id.reminder_list);
        remindersRecyclerView.setHasFixedSize(true);
        remindersRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        remindersRecyclerView.setAdapter(mGBReminderListAdapter);
        updateRemindersFromDB();

        final FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DeviceCoordinator coordinator = DeviceHelper.getInstance().getCoordinator(gbDevice);

                final Prefs prefs = new Prefs(GBApplication.getDeviceSpecificSharedPrefs(gbDevice.getAddress()));
                int reservedSlots = prefs.getInt(DeviceSettingsPreferenceConst.PREF_RESERVER_REMINDERS_CALENDAR, 9);

                int deviceSlots = coordinator.getReminderSlotCount() - reservedSlots;

                if (mGBReminderListAdapter.getItemCount() >= deviceSlots) {
                    // No more free slots
                    new AlertDialog.Builder(v.getContext())
                            .setTitle(R.string.reminder_no_free_slots_title)
                            .setMessage(getBaseContext().getString(R.string.reminder_no_free_slots_description, String.format(Locale.getDefault(), "%d", deviceSlots)))
                            .setIcon(R.drawable.ic_warning)
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(final DialogInterface dialog, final int whichButton) {
                                }
                            })
                            .show();
                    return;
                }

                final Reminder reminder;
                try (DBHandler db = GBApplication.acquireDB()) {
                    final DaoSession daoSession = db.getDaoSession();
                    final Device device = DBHelper.getDevice(gbDevice, daoSession);
                    final User user = DBHelper.getUser(daoSession);
                    reminder = createDefaultReminder(device, user);
                } catch (final Exception e) {
                    LOG.error("Error accessing database", e);
                    return;
                }

                configureReminder(reminder);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_CONFIGURE_REMINDER && resultCode == 1) {
            updateRemindersFromDB();
            sendRemindersToDevice();
        }
    }

    private Reminder createDefaultReminder(@NonNull Device device, @NonNull User user) {
        final Reminder reminder = new Reminder();
        reminder.setRepetition(Reminder.ONCE);
        reminder.setDate(Calendar.getInstance().getTime());
        reminder.setMessage("");
        reminder.setDeviceId(device.getId());
        reminder.setUserId(user.getId());
        reminder.setReminderId(UUID.randomUUID().toString());

        return reminder;
    }

    /**
     * Reads the available reminders from the database and updates the view afterwards.
     */
    private void updateRemindersFromDB() {
        final List<Reminder> reminders = DBHelper.getReminders(gbDevice);

        mGBReminderListAdapter.setReminderList(reminders);
        mGBReminderListAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // back button
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void configureReminder(final Reminder reminder) {
        final Intent startIntent = new Intent(getApplicationContext(), ReminderDetails.class);
        startIntent.putExtra(GBDevice.EXTRA_DEVICE, gbDevice);
        startIntent.putExtra(Reminder.EXTRA_REMINDER, reminder);
        startActivityForResult(startIntent, REQ_CONFIGURE_REMINDER);
    }

    public void deleteReminder(final Reminder reminder) {
        DBHelper.delete(reminder);
        updateRemindersFromDB();
        sendRemindersToDevice();
    }

    private void sendRemindersToDevice() {
        if (gbDevice.isInitialized()) {
            GBApplication.deviceService().onSetReminders(mGBReminderListAdapter.getReminderList());
        }
    }
}
