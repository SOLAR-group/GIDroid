/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.PowerManager;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ShareCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.Tab;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import info.zamojski.soft.towercollector.analytics.IntentSource;
import info.zamojski.soft.towercollector.broadcast.AirplaneModeBroadcastReceiver;
import info.zamojski.soft.towercollector.broadcast.BatterySaverBroadcastReceiver;
import info.zamojski.soft.towercollector.controls.DialogManager;
import info.zamojski.soft.towercollector.dao.MeasurementsDatabase;
import info.zamojski.soft.towercollector.enums.ExportAction;
import info.zamojski.soft.towercollector.enums.FileType;
import info.zamojski.soft.towercollector.enums.MeansOfTransport;
import info.zamojski.soft.towercollector.enums.Validity;
import info.zamojski.soft.towercollector.events.AirplaneModeChangedEvent;
import info.zamojski.soft.towercollector.events.BatteryOptimizationsChangedEvent;
import info.zamojski.soft.towercollector.events.CollectorStartedEvent;
import info.zamojski.soft.towercollector.events.GpsStatusChangedEvent;
import info.zamojski.soft.towercollector.events.MapEnabledChanged;
import info.zamojski.soft.towercollector.events.PowerSaveModeChangedEvent;
import info.zamojski.soft.towercollector.events.PrintMainWindowEvent;
import info.zamojski.soft.towercollector.events.SystemTimeChangedEvent;
import info.zamojski.soft.towercollector.model.ChangelogInfo;
import info.zamojski.soft.towercollector.model.UpdateInfo;
import info.zamojski.soft.towercollector.model.UpdateInfo.DownloadLink;
import info.zamojski.soft.towercollector.providers.ChangelogProvider;
import info.zamojski.soft.towercollector.providers.HtmlChangelogFormatter;
import info.zamojski.soft.towercollector.providers.preferences.PreferencesProvider;
import info.zamojski.soft.towercollector.tasks.ExportFileAsyncTask;
import info.zamojski.soft.towercollector.tasks.UpdateCheckAsyncTask;
import info.zamojski.soft.towercollector.utils.ApkUtils;
import info.zamojski.soft.towercollector.utils.BackgroundTaskHelper;
import info.zamojski.soft.towercollector.utils.BatteryUtils;
import info.zamojski.soft.towercollector.utils.DateUtils;
import info.zamojski.soft.towercollector.utils.FileUtils;
import info.zamojski.soft.towercollector.utils.GpsUtils;
import info.zamojski.soft.towercollector.utils.MapUtils;
import info.zamojski.soft.towercollector.utils.NetworkUtils;
import info.zamojski.soft.towercollector.utils.PermissionUtils;
import info.zamojski.soft.towercollector.utils.StorageUtils;
import info.zamojski.soft.towercollector.utils.StringUtils;
import info.zamojski.soft.towercollector.utils.UpdateDialogArrayAdapter;
import info.zamojski.soft.towercollector.utils.Validator;
import info.zamojski.soft.towercollector.views.MainActivityPagerAdapter;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;
import timber.log.Timber;

@RuntimePermissions
public class MainActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private static final int BATTERY_OPTIMIZATIONS_ACTIVITY_RESULT = 'B';
    private static final int BATTERY_SAVER_ACTIVITY_RESULT = 'S';
    private static final int AIRPLANE_MODE_ACTIVITY_RESULT = 'A';

    private AtomicBoolean isCollectorServiceRunning = new AtomicBoolean(false);
    private boolean isGpsEnabled = false;
    private boolean showAskForLocationSettingsDialog = false;
    private boolean showNotCompatibleDialog = true;

    private BroadcastReceiver airplaneModeBroadcastReceiver = new AirplaneModeBroadcastReceiver();
    private BroadcastReceiver batterySaverBroadcastReceiver = null;

    private String exportedDirAbsolutePath;
    private String[] exportedFilePaths;
    private boolean showExportFinishedDialog = false;

    private Boolean canStartNetworkTypeSystemActivityResult = null;

    private Menu mainMenu;
    private MenuItem startMenu;
    private MenuItem stopMenu;
    private MenuItem networkTypeMenu;

    private TabLayout tabLayout;

    private boolean isMinimized = false;

    public ICollectorService collectorServiceBinder;

    private BackgroundTaskHelper backgroundTaskHelper;

    private ViewPager viewPager;

    private View activityView;

    // ========== ACTIVITY ========== //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(MyApplication.getCurrentAppTheme());
        super.onCreate(savedInstanceState);
        Timber.d("onCreate(): Creating activity");
        // set fixed screen orientation
        if (!ApkUtils.isRunningOnBuggyOreoSetRequestedOrientation(this))
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.main);
        activityView = findViewById(R.id.main_root);
        //setup toolbar
        Toolbar toolbar = findViewById(R.id.main_toolbar);
        toolbar.setPopupTheme(MyApplication.getCurrentPopupTheme());
        setSupportActionBar(toolbar);
        // setup tabbed layout
        MainActivityPagerAdapter pageAdapter = new MainActivityPagerAdapter(getSupportFragmentManager(), getApplication());
        viewPager = findViewById(R.id.main_pager);
        viewPager.setAdapter(pageAdapter);
        tabLayout = findViewById(R.id.main_tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(this);

        backgroundTaskHelper = new BackgroundTaskHelper(this);

        displayNotCompatibleDialog();

        // show latest developer's messages
        displayDevelopersMessages();

        // show introduction
        displayIntroduction();

        processOnStartIntent(getIntent());

        // check for availability of new version
        checkForNewVersionAvailability();

        registerReceiver(airplaneModeBroadcastReceiver, new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            batterySaverBroadcastReceiver = new BatterySaverBroadcastReceiver();
            registerReceiver(batterySaverBroadcastReceiver, new IntentFilter(PowerManager.ACTION_POWER_SAVE_MODE_CHANGED));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.d("onDestroy(): Unbinding from service");
        if (isCollectorServiceRunning.get())
            unbindService(collectorServiceConnection);
        tabLayout.removeOnTabSelectedListener(this);

        if (airplaneModeBroadcastReceiver != null)
            unregisterReceiver(airplaneModeBroadcastReceiver);
        if (batterySaverBroadcastReceiver != null)
            unregisterReceiver(batterySaverBroadcastReceiver);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Timber.d("onStart(): Binding to service");
        isCollectorServiceRunning.set(MyApplication.isBackgroundTaskRunning(CollectorService.class));
        if (isCollectorServiceRunning.get()) {
            bindService(new Intent(this, CollectorService.class), collectorServiceConnection, 0);
        }
        if (isMinimized && showExportFinishedDialog) {
            displayExportFinishedDialog();
        }
        isMinimized = false;
        EventBus.getDefault().register(this);

        String appThemeName = MyApplication.getPreferencesProvider().getAppTheme();
        MyApplication.getAnalytics().sendPrefsAppTheme(appThemeName);
    }

    @Override
    protected void onStop() {
        super.onStop();
        isMinimized = true;
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.d("onResume(): Resuming");
        // print on UI
        EventBus.getDefault().post(new PrintMainWindowEvent());
        // restore recent tab
        int recentTabIndex = MyApplication.getPreferencesProvider().getMainWindowRecentTab();
        viewPager.setCurrentItem(recentTabIndex);
        // if coming back from Android settings rerun the action
        if (showAskForLocationSettingsDialog) {
            startCollectorServiceWithCheck();
        }
        // if keep on is checked
        if (MyApplication.getPreferencesProvider().getMainKeepScreenOnMode()) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Timber.d("onPause(): Pausing");
        // remember current tab
        int currentTabIndex = viewPager.getCurrentItem();
        MyApplication.getPreferencesProvider().setMainWindowRecentTab(currentTabIndex);
    }

    // ========== MENU ========== //

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        Timber.d("onCreateOptionsMenu(): Loading action bar");
        getMenuInflater().inflate(R.menu.main, menu);
        // save references
        startMenu = menu.findItem(R.id.main_menu_start);
        stopMenu = menu.findItem(R.id.main_menu_stop);
        networkTypeMenu = menu.findItem(R.id.main_menu_network_type);
        mainMenu = menu;// store the menu in an local variable for hardware key
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        boolean isRunning = isCollectorServiceRunning.get();
        Timber.d("onPrepareOptionsMenu(): Preparing action bar menu for running = %s", isRunning);
        // toggle visibility
        startMenu.setVisible(!isRunning);
        stopMenu.setVisible(isRunning);
        boolean networkTypeAvailable = canStartNetworkTypeSystemActivity();
        networkTypeMenu.setVisible(networkTypeAvailable);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // start action
        switch (item.getItemId()) {
            case R.id.main_menu_start:
                startCollectorServiceWithCheck();
                return true;
            case R.id.main_menu_stop:
                stopCollectorService();
                return true;
            case R.id.main_menu_upload:
                startUploaderServiceWithCheck();
                return true;
            case R.id.main_menu_export:
                // NOTE: delegate the permission handling to generated method
                MainActivityPermissionsDispatcher.startExportAsyncTaskWithPermissionCheck(this);
                return true;
            case R.id.main_menu_clear:
                startCleanup();
                return true;
            case R.id.main_menu_preferences:
                startPreferencesActivity();
                return true;
            case R.id.main_menu_network_type:
                startNetworkTypeSystemActivity();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == BATTERY_OPTIMIZATIONS_ACTIVITY_RESULT) {
            // don't check resultCode because it's always 0 (user needs to manually navigate back)
            boolean batteryOptimizationsEnabled = BatteryUtils.areBatteryOptimizationsEnabled(MyApplication.getApplication());
            EventBus.getDefault().postSticky(new BatteryOptimizationsChangedEvent(batteryOptimizationsEnabled));
        } else if (requestCode == BATTERY_SAVER_ACTIVITY_RESULT) {
            // don't check resultCode because it's always 0 (user needs to manually navigate back)
            boolean powerSaveModeEnabled = BatteryUtils.isPowerSaveModeEnabled(MyApplication.getApplication());
            EventBus.getDefault().postSticky(new PowerSaveModeChangedEvent(powerSaveModeEnabled));
        } else if (requestCode == AIRPLANE_MODE_ACTIVITY_RESULT) {
            // don't check resultCode because it's always 0 (user needs to manually navigate back)
            boolean airplaneModeEnabled = NetworkUtils.isInAirplaneMode(MyApplication.getApplication());
            EventBus.getDefault().postSticky(new AirplaneModeChangedEvent(airplaneModeEnabled));
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Timber.d("onNewIntent(): New intent received: %s", intent);
        processOnStartIntent(intent);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_MENU) {
            if (event.getAction() == KeyEvent.ACTION_UP && mainMenu != null) {
                Timber.i("onKeyUp(): Hardware menu key pressed");
                mainMenu.performIdentifierAction(R.id.main_menu_more, 0);
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void onTabSelected(Tab tab) {
        Timber.d("onTabSelected() Switching to tab %s", tab.getPosition());
        // switch to page when tab is selected
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab tab) {
        // nothing
    }

    @Override
    public void onTabReselected(Tab tab) {
        // nothing
    }

    // ========== UI ========== //

    private void printInvalidSystemTime(ICollectorService collectorServiceBinder) {
        Validity valid = collectorServiceBinder.isSystemTimeValid();
        EventBus.getDefault().postSticky(new SystemTimeChangedEvent(valid));
    }

    private void hideInvalidSystemTime() {
        EventBus.getDefault().postSticky(new SystemTimeChangedEvent(Validity.Valid));
    }

    private void refreshTabs() {
        viewPager.getAdapter().notifyDataSetChanged();
    }

    // have to be public to prevent Force Close
    public void displayHelpOnClick(View view) {
        int titleId = View.NO_ID;
        int messageId = View.NO_ID;
        switch (view.getId()) {
            case R.id.main_gps_status_tablerow:
                titleId = R.string.main_help_gps_status_title;
                messageId = R.string.main_help_gps_status_description;
                break;
            case R.id.main_invalid_system_time_tablerow:
                titleId = R.string.main_help_invalid_system_time_title;
                messageId = R.string.main_help_invalid_system_time_description;
                break;
            case R.id.main_stats_today_locations_tablerow:
                titleId = R.string.main_help_today_locations_title;
                messageId = R.string.main_help_today_locations_description;
                break;
            case R.id.main_stats_today_cells_tablerow:
                titleId = R.string.main_help_today_cells_title;
                messageId = R.string.main_help_today_cells_description;
                break;
            case R.id.main_stats_local_locations_tablerow:
                titleId = R.string.main_help_local_locations_title;
                messageId = R.string.main_help_local_locations_description;
                break;
            case R.id.main_stats_local_cells_tablerow:
                titleId = R.string.main_help_local_cells_title;
                messageId = R.string.main_help_local_cells_description;
                break;
            case R.id.main_stats_global_locations_tablerow:
                titleId = R.string.main_help_global_locations_title;
                messageId = R.string.main_help_global_locations_description;
                break;
            case R.id.main_stats_global_cells_tablerow:
                titleId = R.string.main_help_global_cells_title;
                messageId = R.string.main_help_global_cells_description;
                break;
            case R.id.main_last_number_of_cells_tablerow:
                titleId = R.string.mail_help_last_number_of_cells_title;
                messageId = R.string.mail_help_last_number_of_cells_description;
                break;
            case R.id.main_last_network_type_tablerow:
                titleId = R.string.main_help_last_network_type_title;
                messageId = R.string.main_help_last_network_type_description;
                break;
            case R.id.main_last_long_cell_id_tablerow:
                titleId = R.string.main_help_last_long_cell_id_title;
                messageId = R.string.main_help_last_long_cell_id_description;
                break;
            case R.id.main_last_cell_id_rnc_tablerow:
                titleId = R.string.main_help_last_cell_id_rnc_title;
                messageId = R.string.main_help_last_cell_id_rnc_description;
                break;
            case R.id.main_last_cell_id_tablerow:
                titleId = R.string.main_help_last_cell_id_title;
                messageId = R.string.main_help_last_cell_id_description;
                break;
            case R.id.main_last_lac_tablerow:
                titleId = R.string.main_help_last_lac_title;
                messageId = R.string.main_help_last_lac_description;
                break;
            case R.id.main_last_mcc_tablerow:
                titleId = R.string.main_help_last_mcc_title;
                messageId = R.string.main_help_last_mcc_description;
                break;
            case R.id.main_last_mnc_tablerow:
                titleId = R.string.main_help_last_mnc_title;
                messageId = R.string.main_help_last_mnc_description;
                break;
            case R.id.main_last_signal_strength_tablerow:
                titleId = R.string.main_help_last_signal_strength_title;
                messageId = R.string.main_help_last_signal_strength_description;
                break;
            case R.id.main_last_latitude_tablerow:
                titleId = R.string.main_help_last_latitude_title;
                messageId = R.string.main_help_last_latitude_description;
                break;
            case R.id.main_last_longitude_tablerow:
                titleId = R.string.main_help_last_longitude_title;
                messageId = R.string.main_help_last_longitude_description;
                break;
            case R.id.main_last_gps_accuracy_tablerow:
                titleId = R.string.main_help_last_gps_accuracy_title;
                messageId = R.string.main_help_last_gps_accuracy_description;
                break;
            case R.id.main_last_date_time_tablerow:
                titleId = R.string.main_help_last_date_time_title;
                messageId = R.string.main_help_last_date_time_description;
                break;
            case R.id.main_stats_to_upload_ocid_locations_tablerow:
                titleId = R.string.main_help_to_upload_common_locations_title;
                messageId = R.string.main_help_to_upload_ocid_locations_description;
                break;
            case R.id.main_stats_to_upload_mls_locations_tablerow:
                titleId = R.string.main_help_to_upload_common_locations_title;
                messageId = R.string.main_help_to_upload_mls_locations_description;
                break;
        }
        Timber.d("displayHelpOnClick(): Displaying help for title: %s", titleId);
        if (titleId != View.NO_ID && messageId != View.NO_ID) {
            AlertDialog dialog = new AlertDialog.Builder(this).setTitle(titleId).setMessage(messageId).setPositiveButton(R.string.dialog_ok, null).create();
            dialog.setCanceledOnTouchOutside(true);
            dialog.setCancelable(true);
            dialog.show();
        }
    }

    // have to be public to prevent Force Close
    public void displayBatteryOptimizationsHelpOnClick(View view) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.main_help_battery_optimizations_title)
                .setMessage(R.string.main_help_battery_optimizations_description)
                .setPositiveButton(R.string.dialog_settings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startBatteryOptimizationsSystemActivity();
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, null)
                .create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.show();
    }

    // have to be public to prevent Force Close
    public void displayPowerSaveModeHelpOnClick(View view) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.main_help_power_save_mode_title)
                .setMessage(R.string.main_help_power_save_mode_description)
                .setPositiveButton(R.string.dialog_settings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startBatterySaverSystemActivity();
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, null)
                .create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.show();
    }

    // have to be public to prevent Force Close
    public void displayAirplaneModeHelpOnClick(View view) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle(R.string.main_help_airplane_mode_title)
                .setMessage(R.string.main_help_airplane_mode_description)
                .setPositiveButton(R.string.dialog_settings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startAirplaneModeSystemActivity();
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, null)
                .create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.show();
    }

    private void displayUploadResultDialog(String descriptionContent) {
        try {
            Timber.d("displayUploadResultDialog(): Received extras: %s", descriptionContent);
            // display dialog
            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setCanceledOnTouchOutside(true);
            alertDialog.setCancelable(true);
            alertDialog.setTitle(R.string.uploader_result_dialog_title);
            alertDialog.setMessage(descriptionContent);
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.dialog_ok), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();
        } catch (NotFoundException ex) {
            Timber.w("displayUploadResultDialog(): Invalid string id received with intent extras: %s", descriptionContent);
            MyApplication.handleSilentException(ex);
        }
    }

    private void displayNewVersionDownloadOptions(UpdateInfo updateInfo) {
        // display dialog
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogLayout = inflater.inflate(R.layout.new_version, null);
        dialogBuilder.setView(dialogLayout);
        final AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.setCancelable(true);
        alertDialog.setTitle(R.string.updater_dialog_new_version_available);
        // load data
        ArrayAdapter<UpdateInfo.DownloadLink> adapter = new UpdateDialogArrayAdapter(alertDialog.getContext(), inflater, updateInfo.getDownloadLinks());
        ListView listView = (ListView) dialogLayout.findViewById(R.id.download_options_list);
        listView.setAdapter(adapter);
        // bind events
        final CheckBox disableAutoUpdateCheckCheckbox = (CheckBox) dialogLayout.findViewById(R.id.download_options_disable_auto_update_check_checkbox);
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DownloadLink downloadLink = (DownloadLink) parent.getItemAtPosition(position);
                Timber.d("displayNewVersionDownloadOptions(): Selected position: %s", downloadLink.getLabel());
                boolean disableAutoUpdateCheckCheckboxChecked = disableAutoUpdateCheckCheckbox.isChecked();
                Timber.d("displayNewVersionDownloadOptions(): Disable update check checkbox checked = %s", disableAutoUpdateCheckCheckboxChecked);
                if (disableAutoUpdateCheckCheckboxChecked) {
                    MyApplication.getPreferencesProvider().setUpdateCheckEnabled(false);
                }
                MyApplication.getAnalytics().sendUpdateAction(downloadLink.getLabel());
                String[] links = downloadLink.getLinks();
                boolean startActivityFailed = false;
                for (String link : links) {
                    startActivityFailed = false;
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(link)));
                        break;
                    } catch (ActivityNotFoundException ex) {
                        startActivityFailed = true;
                    }
                }
                if (startActivityFailed)
                    Toast.makeText(getApplication(), R.string.web_browser_missing, Toast.LENGTH_LONG).show();
                alertDialog.dismiss();
            }
        });
        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.dialog_cancel), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                boolean disableAutoUpdateCheckCheckboxChecked = disableAutoUpdateCheckCheckbox.isChecked();
                Timber.d("displayNewVersionDownloadOptions(): Disable update check checkbox checked = %s", disableAutoUpdateCheckCheckboxChecked);
                if (disableAutoUpdateCheckCheckboxChecked) {
                    MyApplication.getPreferencesProvider().setUpdateCheckEnabled(false);
                }
            }
        });
        alertDialog.show();
    }

    private void displayNotCompatibleDialog() {
        // check if displayed in this app run
        if (showNotCompatibleDialog) {
            // check if not disabled in preferences
            boolean showCompatibilityWarningEnabled = MyApplication.getPreferencesProvider().getShowCompatibilityWarning();
            if (showCompatibilityWarningEnabled) {
                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                // check if device contains telephony hardware (some tablets doesn't report even if have)
                // NOTE: in the future this may need to be expanded when new specific features appear
                PackageManager packageManager = getPackageManager();
                boolean noRadioDetected = !(packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY) && (packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_GSM) || packageManager.hasSystemFeature(PackageManager.FEATURE_TELEPHONY_CDMA)));
                // show dialog if something is not supported
                if (noRadioDetected) {
                    Timber.d("displayNotCompatibleDialog(): Not compatible because of radio: %s, phone type: %s", noRadioDetected, telephonyManager.getPhoneType());
                    //use custom layout to show "don't show this again" checkbox
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
                    LayoutInflater inflater = LayoutInflater.from(this);
                    View dialogLayout = inflater.inflate(R.layout.dont_show_again_dialog, null);
                    final CheckBox dontShowAgainCheckbox = (CheckBox) dialogLayout.findViewById(R.id.dont_show_again_dialog_checkbox);
                    dialogBuilder.setView(dialogLayout);
                    AlertDialog alertDialog = dialogBuilder.create();
                    alertDialog.setCanceledOnTouchOutside(true);
                    alertDialog.setCancelable(true);
                    alertDialog.setTitle(R.string.main_dialog_not_compatible_title);
                    StringBuilder stringBuilder = new StringBuilder(getString(R.string.main_dialog_not_compatible_begin));
                    if (noRadioDetected) {
                        stringBuilder.append(getString(R.string.main_dialog_no_compatible_mobile_radio_message));
                    }
                    // text set this way to prevent checkbox from disappearing when text is too long
                    TextView messageTextView = (TextView) dialogLayout.findViewById(R.id.dont_show_again_dialog_textview);
                    messageTextView.setText(stringBuilder.toString());
                    alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.dialog_ok), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            boolean dontShowAgainCheckboxChecked = dontShowAgainCheckbox.isChecked();
                            Timber.d("displayNotCompatibleDialog(): Don't show again checkbox checked = %s", dontShowAgainCheckboxChecked);
                            if (dontShowAgainCheckboxChecked) {
                                MyApplication.getPreferencesProvider().setShowCompatibilityWarning(false);
                            }
                        }
                    });
                    alertDialog.show();
                }
            }
            showNotCompatibleDialog = false;
        }
    }

    private void displayIntroduction() {
        if (MyApplication.getPreferencesProvider().getShowIntroduction()) {
            Timber.d("displayIntroduction(): Showing introduction");
            DialogManager.createHtmlInfoDialog(this, R.string.info_introduction_title, R.raw.info_introduction_content, false, false).show();
            MyApplication.getPreferencesProvider().setShowIntroduction(false);
        }
    }

    private void displayDevelopersMessages() {
        int previousVersionCode = MyApplication.getPreferencesProvider().getPreviousDeveloperMessagesVersion();
        int currentVersionCode = ApkUtils.getApkVersionCode();
        if (previousVersionCode != currentVersionCode) {
            MyApplication.getPreferencesProvider().setRecentDeveloperMessagesVersion(currentVersionCode);
            // skip recent changes for first startup
            if (MyApplication.getPreferencesProvider().getShowIntroduction()) {
                return;
            }
            Timber.d("displayDevelopersMessages(): Showing changelog between %s and %s", previousVersionCode, currentVersionCode);
            ChangelogProvider provider = new ChangelogProvider(getApplication(), R.raw.changelog);
            ChangelogInfo changelog = provider.getChangelog(previousVersionCode);
            if (changelog.isEmpty())
                return;
            HtmlChangelogFormatter formatter = new HtmlChangelogFormatter();
            String message = formatter.formatChangelog(changelog);
            DialogManager.createHtmlInfoDialog(this, R.string.dialog_what_is_new, message, false, false).show();
        }
    }

    public void displayExportFinishedDialog() {
        showExportFinishedDialog = false;

        LayoutInflater inflater = LayoutInflater.from(this);
        View dialogLayout = inflater.inflate(R.layout.export_finished_dialog, null);
        TextView messageTextView = dialogLayout.findViewById(R.id.export_finished_dialog_textview);
        messageTextView.setText(getString(R.string.export_dialog_finished_message, exportedDirAbsolutePath));
        ExportAction recentAction = MyApplication.getPreferencesProvider().getExportAction();
        boolean singleFile = exportedFilePaths.length == 1;
        if (!singleFile && recentAction == ExportAction.Open)
            recentAction = ExportAction.Keep;
        final RadioButton keepRadioButton = dialogLayout.findViewById(R.id.export_finished_dialog_keep_radiobutton);
        final RadioButton openRadioButton = dialogLayout.findViewById(R.id.export_finished_dialog_open_radiobutton);
        final RadioButton shareRadioButton = dialogLayout.findViewById(R.id.export_finished_dialog_share_radiobutton);
        openRadioButton.setEnabled(singleFile);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(R.string.export_dialog_finished_title);
        builder.setView(dialogLayout);
        builder.setCancelable(true);
        if (recentAction == ExportAction.Share) {
            builder.setPositiveButton(R.string.dialog_share, (dialog, which) -> {
                exportShareAction();
                dismissExportFinishedDialog(dialog);
            });
        } else if (recentAction == ExportAction.Open) {
            builder.setPositiveButton(R.string.dialog_open, (dialog, which) -> {
                exportOpenAction();
                dismissExportFinishedDialog(dialog);
            });
        } else {
            builder.setPositiveButton(R.string.dialog_keep, (dialog, which) -> {
                exportKeepAction();
                dismissExportFinishedDialog(dialog);
            });
        }
        builder.setNeutralButton(R.string.dialog_upload, (dialog, which) -> {
            MyApplication.getAnalytics().sendExportUploadAction();
            startUploaderServiceWithCheck();
        });
        builder.setNegativeButton(R.string.dialog_delete, (dialog, which) -> {
            // show dialog that runs async task
            AlertDialog.Builder deleteBuilder = new AlertDialog.Builder(this);
            deleteBuilder.setTitle(R.string.delete_dialog_title);
            deleteBuilder.setMessage(R.string.delete_dialog_message);
            deleteBuilder.setPositiveButton(R.string.dialog_ok, (positiveDialog, positiveWhich) -> {
                MeasurementsDatabase.getInstance(MyApplication.getApplication()).deleteAllMeasurements();
                EventBus.getDefault().post(new PrintMainWindowEvent());
                MyApplication.getAnalytics().sendExportDeleteAction();
            });
            deleteBuilder.setNegativeButton(R.string.dialog_cancel, (negativeDialog, id) -> {
                // cancel
            });
            AlertDialog deleteDialog = deleteBuilder.create();
            deleteDialog.setCanceledOnTouchOutside(true);
            deleteDialog.setCancelable(true);
            deleteDialog.show();
        });
        builder.setOnCancelListener(dialog -> {
            exportKeepAction();
            exportedFilePaths = null;
        });

        AlertDialog dialog = builder.create();
        ExportAction finalRecentAction = recentAction;
        dialog.setOnShowListener(dialog1 -> {
            keepRadioButton.setChecked(finalRecentAction == ExportAction.Keep);
            openRadioButton.setChecked(finalRecentAction == ExportAction.Open);
            shareRadioButton.setChecked(finalRecentAction == ExportAction.Share);
            CompoundButton.OnCheckedChangeListener listener = (buttonView, isChecked) -> {
                Button positiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                if (isChecked) {
                    ExportAction newRecentAction;
                    if (buttonView == openRadioButton) {
                        newRecentAction = ExportAction.Open;
                        positiveButton.setText(R.string.dialog_open);
                        positiveButton.setOnClickListener(v -> {
                            exportOpenAction();
                            dismissExportFinishedDialog(dialog);
                        });
                    } else if (buttonView == shareRadioButton) {
                        newRecentAction = ExportAction.Share;
                        positiveButton.setText(R.string.dialog_share);
                        positiveButton.setOnClickListener(v -> {
                            exportShareAction();
                            dismissExportFinishedDialog(dialog);
                        });
                    } else {
                        newRecentAction = ExportAction.Keep;
                        positiveButton.setText(R.string.dialog_keep);
                        positiveButton.setOnClickListener(v -> {
                            exportKeepAction();
                            dismissExportFinishedDialog(dialog);
                        });
                    }
                    MyApplication.getPreferencesProvider().setExportAction(newRecentAction);
                }
            };
            keepRadioButton.setOnCheckedChangeListener(listener);
            openRadioButton.setOnCheckedChangeListener(listener);
            shareRadioButton.setOnCheckedChangeListener(listener);
        });

        dialog.show();

        exportedDirAbsolutePath = null;
    }

    private void dismissExportFinishedDialog(DialogInterface dialog) {
        dialog.dismiss();
        exportedFilePaths = null;
    }

    private void exportKeepAction() {
        MyApplication.getAnalytics().sendExportKeepAction();
    }

    private void exportOpenAction() {
        Intent openIntent = new Intent(Intent.ACTION_VIEW);
        File file = new File(exportedFilePaths[0]);
        Uri fileUri = FileProvider.getUriForFile(this, getString(R.string.file_provider_authority), file);
        String calculatedMimeType = getApplication().getContentResolver().getType(fileUri);
        openIntent.setDataAndType(fileUri, calculatedMimeType);
        openIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_GRANT_READ_URI_PERMISSION);
        if (openIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(openIntent);
        } else {
            Toast.makeText(getApplication(), R.string.export_toast_no_handler_for_file_type, Toast.LENGTH_LONG).show();
        }
    }

    private void exportShareAction() {
        MyApplication.getAnalytics().sendExportShareAction();
        ShareCompat.IntentBuilder shareIntent = ShareCompat.IntentBuilder.from(this);
        for (String filePath : exportedFilePaths) {
            File file = new File(filePath);
            Uri fileUri = FileProvider.getUriForFile(this, getString(R.string.file_provider_authority), file);
            shareIntent.addStream(fileUri);
        }
        String calculatedMimeType = FileUtils.getFileMimeType(getApplication(), exportedFilePaths);
        shareIntent.setType(calculatedMimeType);
        Intent intent = shareIntent.getIntent();
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        startActivity(Intent.createChooser(intent, null));
    }

    // ========== MENU START/STOP METHODS ========== //

    private void startCollectorServiceWithCheck() {
        String runningTaskClassName = MyApplication.getBackgroundTaskName();
        if (runningTaskClassName != null) {
            Timber.d("startCollectorServiceWithCheck(): Another task is running in background: %s", runningTaskClassName);
            backgroundTaskHelper.showTaskRunningMessage(runningTaskClassName);
            return;
        }
        MainActivityPermissionsDispatcher.startCollectorServiceWithPermissionCheck(MainActivity.this);
    }

    @NeedsPermission({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE})
    void startCollectorService() {
        askAndSetGpsEnabled();
        if (isGpsEnabled) {
            Timber.d("startCollectorService(): Air plane mode off, starting service");
            // create intent
            final Intent intent = new Intent(this, CollectorService.class);
            // pass means of transport inside intent
            boolean gpsOptimizationsEnabled = MyApplication.getPreferencesProvider().getGpsOptimizationsEnabled();
            MeansOfTransport selectedType = (gpsOptimizationsEnabled ? MeansOfTransport.Universal : MeansOfTransport.Fixed);
            intent.putExtra(CollectorService.INTENT_KEY_TRANSPORT_MODE, selectedType);
            // pass screen on mode
            final String keepScreenOnMode = MyApplication.getPreferencesProvider().getCollectorKeepScreenOnMode();
            intent.putExtra(CollectorService.INTENT_KEY_KEEP_SCREEN_ON_MODE, keepScreenOnMode);
            // pass analytics data
            intent.putExtra(CollectorService.INTENT_KEY_START_INTENT_SOURCE, IntentSource.User);
            // start service
            ContextCompat.startForegroundService(this, intent);
            EventBus.getDefault().post(new CollectorStartedEvent(intent));
            ApkUtils.reportShortcutUsage(MyApplication.getApplication(), R.string.shortcut_id_collector_toggle);
        }
    }

    @OnShowRationale({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE})
    void onStartCollectorShowRationale(PermissionRequest request) {
        onShowRationale(request, R.string.permission_collector_rationale_message);
    }

    @OnPermissionDenied({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE})
    void onStartCollectorPermissionDenied() {
        onStartCollectorPermissionDeniedInternal();
    }

    void onStartCollectorPermissionDeniedInternal() {
        onPermissionDenied(R.string.permission_collector_denied_message);
    }

    @OnNeverAskAgain({Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.READ_PHONE_STATE})
    void onStartCollectorNeverAskAgain() {
        onNeverAskAgain(R.string.permission_collector_never_ask_again_message);
    }

    private void stopCollectorService() {
        stopService(new Intent(this, CollectorService.class));
        ApkUtils.reportShortcutUsage(MyApplication.getApplication(), R.string.shortcut_id_collector_toggle);
    }

    private void startUploaderServiceWithCheck() {
        String runningTaskClassName = MyApplication.getBackgroundTaskName();
        if (runningTaskClassName != null) {
            Timber.d("startUploaderServiceWithCheck(): Another task is running in background: %s", runningTaskClassName);
            backgroundTaskHelper.showTaskRunningMessage(runningTaskClassName);
            return;
        }

        final PreferencesProvider preferencesProvider = MyApplication.getPreferencesProvider();
        final boolean isOcidUploadEnabled = preferencesProvider.isOpenCellIdUploadEnabled();
        final boolean isMlsUploadEnabled = preferencesProvider.isMlsUploadEnabled();
        final boolean isReuploadIfUploadFailsEnabled = preferencesProvider.isReuploadIfUploadFailsEnabled();
        Timber.i("startUploaderServiceWithCheck(): Upload for OCID = " + isOcidUploadEnabled + ", MLS = " + isMlsUploadEnabled);
        boolean showConfigurator = preferencesProvider.getShowConfiguratorBeforeUpload();
        if (showConfigurator) {
            Timber.d("startUploaderServiceWithCheck(): Showing upload configurator");
            // check API key
            String apiKey = preferencesProvider.getApiKey();
            boolean isApiKeyValid = Validator.isOpenCellIdApiKeyValid(apiKey);
            LayoutInflater inflater = LayoutInflater.from(this);
            View dialogLayout = inflater.inflate(R.layout.configure_uploader_dialog, null);
            final CheckBox ocidUploadCheckbox = dialogLayout.findViewById(R.id.ocid_upload_dialog_checkbox);
            ocidUploadCheckbox.setChecked(isOcidUploadEnabled);
            dialogLayout.findViewById(R.id.ocid_invalid_api_key_upload_dialog_textview).setVisibility(isApiKeyValid ? View.GONE : View.VISIBLE);
            final CheckBox mlsUploadCheckbox = dialogLayout.findViewById(R.id.mls_upload_dialog_checkbox);
            mlsUploadCheckbox.setChecked(isMlsUploadEnabled);
            final CheckBox reuploadCheckbox = dialogLayout.findViewById(R.id.reupload_if_upload_fails_upload_dialog_checkbox);
            reuploadCheckbox.setChecked(isReuploadIfUploadFailsEnabled);
            final CheckBox dontShowAgainCheckbox = dialogLayout.findViewById(R.id.dont_show_again_dialog_checkbox);
            AlertDialog alertDialog = new AlertDialog.Builder(this).setView(dialogLayout).create();
            alertDialog.setCanceledOnTouchOutside(true);
            alertDialog.setCancelable(true);
            alertDialog.setTitle(R.string.upload_configurator_dialog_title);
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.dialog_upload), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    boolean isOcidUploadEnabledTemp = ocidUploadCheckbox.isChecked();
                    boolean isMlsUploadEnabledTemp = mlsUploadCheckbox.isChecked();
                    boolean isReuploadIfUploadFailsEnabledTemp = reuploadCheckbox.isChecked();
                    if (dontShowAgainCheckbox.isChecked()) {
                        preferencesProvider.setOpenCellIdUploadEnabled(isOcidUploadEnabled);
                        preferencesProvider.setMlsUploadEnabled(isMlsUploadEnabled);
                        preferencesProvider.setReuploadIfUploadFailsEnabled(isReuploadIfUploadFailsEnabledTemp);
                        preferencesProvider.setShowConfiguratorBeforeUpload(false);
                    }
                    if (!isOcidUploadEnabledTemp && !isMlsUploadEnabledTemp) {
                        showAllProjectsDisabledMessage();
                    } else {
                        startUploaderService(isOcidUploadEnabledTemp, isMlsUploadEnabledTemp, isReuploadIfUploadFailsEnabledTemp);
                    }
                }
            });
            alertDialog.setButton(DialogInterface.BUTTON_NEUTRAL, getString(R.string.main_menu_preferences_button), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startPreferencesActivity();
                }
            });
            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.dialog_cancel), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                }
            });
            alertDialog.show();
        } else {
            Timber.d("startUploaderServiceWithCheck(): Using upload configuration from preferences");
            if (!isOcidUploadEnabled && !isMlsUploadEnabled) {
                showAllProjectsDisabledMessage();
            } else {
                startUploaderService(isOcidUploadEnabled, isMlsUploadEnabled, isReuploadIfUploadFailsEnabled);
            }
        }
    }

    private void showAllProjectsDisabledMessage() {
        Snackbar snackbar = Snackbar.make(activityView, R.string.uploader_all_projects_disabled, Snackbar.LENGTH_LONG)
                .setAction(R.string.main_menu_preferences_button, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startPreferencesActivity();
                    }
                });
        // hack for black text on dark grey background
        View view = snackbar.getView();
        TextView tv = view.findViewById(R.id.snackbar_text);
        tv.setTextColor(Color.WHITE);
        snackbar.show();
    }

    private void startUploaderService(boolean isOcidUploadEnabled, boolean isMlsUploadEnabled, boolean isReuploadIfUploadFailsEnabled) {
        // start task
        if (!MyApplication.isBackgroundTaskRunning(UploaderService.class)) {
            Intent intent = new Intent(MainActivity.this, UploaderService.class);
            intent.putExtra(UploaderService.INTENT_KEY_UPLOAD_TO_OCID, isOcidUploadEnabled);
            intent.putExtra(UploaderService.INTENT_KEY_UPLOAD_TO_MLS, isMlsUploadEnabled);
            intent.putExtra(UploaderService.INTENT_KEY_UPLOAD_TRY_REUPLOAD, isReuploadIfUploadFailsEnabled);
            intent.putExtra(UploaderService.INTENT_KEY_START_INTENT_SOURCE, IntentSource.User);
            ContextCompat.startForegroundService(this, intent);
            ApkUtils.reportShortcutUsage(MyApplication.getApplication(), R.string.shortcut_id_uploader_toggle);
        } else
            Toast.makeText(getApplication(), R.string.uploader_already_running, Toast.LENGTH_LONG).show();
    }

    @NeedsPermission({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void startExportAsyncTask() {
        String runningTaskClassName = MyApplication.getBackgroundTaskName();
        if (runningTaskClassName != null) {
            Timber.d("startExportAsyncTask(): Another task is running in background: %s", runningTaskClassName);
            backgroundTaskHelper.showTaskRunningMessage(runningTaskClassName);
            return;
        }
        if (StorageUtils.isExternalMemoryWritable()) {
            final PreferencesProvider preferencesProvider = MyApplication.getPreferencesProvider();
            List<FileType> recentFileTypes = preferencesProvider.getEnabledExportFileTypes();
            LayoutInflater inflater = LayoutInflater.from(this);
            View dialogLayout = inflater.inflate(R.layout.configure_exporter_dialog, null);
            final CheckBox csvExportCheckbox = dialogLayout.findViewById(R.id.csv_export_dialog_checkbox);
            csvExportCheckbox.setChecked(recentFileTypes.contains(FileType.Csv));
            final CheckBox gpxExportCheckbox = dialogLayout.findViewById(R.id.gpx_export_dialog_checkbox);
            gpxExportCheckbox.setChecked(recentFileTypes.contains(FileType.Gpx));
            final CheckBox kmlExportCheckbox = dialogLayout.findViewById(R.id.kml_export_dialog_checkbox);
            kmlExportCheckbox.setChecked(recentFileTypes.contains(FileType.Kml));
            final CheckBox kmzExportCheckbox = dialogLayout.findViewById(R.id.kmz_export_dialog_checkbox);
            kmzExportCheckbox.setChecked(recentFileTypes.contains(FileType.Kmz));
            final CheckBox csvOcidExportCheckbox = dialogLayout.findViewById(R.id.csv_ocid_export_dialog_checkbox);
            csvOcidExportCheckbox.setChecked(recentFileTypes.contains(FileType.CsvOcid));
            final CheckBox jsonMlsExportCheckbox = dialogLayout.findViewById(R.id.json_mls_export_dialog_checkbox);
            jsonMlsExportCheckbox.setChecked(recentFileTypes.contains(FileType.JsonMls));
            final CheckBox compressExportCheckbox = dialogLayout.findViewById(R.id.compress_export_dialog_checkbox);
            compressExportCheckbox.setChecked(recentFileTypes.contains(FileType.Compress));
            AlertDialog alertDialog = new AlertDialog.Builder(this).setView(dialogLayout).create();
            alertDialog.setCanceledOnTouchOutside(true);
            alertDialog.setCancelable(true);
            alertDialog.setTitle(R.string.export_dialog_format_selection_title);
            alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, getString(R.string.dialog_export), (dialog, which) -> {
                List<FileType> selectedFileTypes = new ArrayList<>();
                if (csvExportCheckbox.isChecked())
                    selectedFileTypes.add(FileType.Csv);
                if (gpxExportCheckbox.isChecked())
                    selectedFileTypes.add(FileType.Gpx);
                if (kmlExportCheckbox.isChecked())
                    selectedFileTypes.add(FileType.Kml);
                if (kmzExportCheckbox.isChecked())
                    selectedFileTypes.add(FileType.Kmz);
                if (csvOcidExportCheckbox.isChecked())
                    selectedFileTypes.add(FileType.CsvOcid);
                if (jsonMlsExportCheckbox.isChecked())
                    selectedFileTypes.add(FileType.JsonMls);
                if (compressExportCheckbox.isChecked())
                    selectedFileTypes.add(FileType.Compress);
                preferencesProvider.setEnabledExportFileTypes(selectedFileTypes);
                Timber.d("startExportAsyncTask(): User selected positions: %s", TextUtils.join(",", selectedFileTypes));
                if (selectedFileTypes.isEmpty()) {
                    Toast.makeText(getApplication(), R.string.export_toast_no_file_types_selected, Toast.LENGTH_LONG).show();
                } else {
                    ExportFileAsyncTask task = new ExportFileAsyncTask(MainActivity.this, new InternalMessageHandler(MainActivity.this), selectedFileTypes);
                    task.execute();
                }
            });
            alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, getString(R.string.dialog_cancel), (dialog, which) -> {
                // empty
            });
            alertDialog.show();
        } else if (StorageUtils.isExternalMemoryPresent()) {
            Toast.makeText(getApplication(), R.string.export_toast_storage_read_only, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplication(), R.string.export_toast_no_storage, Toast.LENGTH_LONG).show();
        }
    }

    @OnShowRationale({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onStartExportShowRationale(PermissionRequest request) {
        onShowRationale(request, R.string.permission_export_rationale_message);
    }

    @OnPermissionDenied({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onStartExportPermissionDenied() {
        onPermissionDenied(R.string.permission_export_denied_message);
    }

    @OnNeverAskAgain({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onStartExportNeverAskAgain() {
        onNeverAskAgain(R.string.permission_export_never_ask_again_message);
    }

    private void startCleanup() {
        // show dialog that runs async task
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.clear_dialog_title);
        builder.setMessage(R.string.clear_dialog_message);
        builder.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                MeasurementsDatabase.getInstance(MyApplication.getApplication()).clearAllData();
                Toast.makeText(MainActivity.this, R.string.clear_toast_finished, Toast.LENGTH_SHORT).show();
                MapUtils.clearMapCache(MainActivity.this);
                EventBus.getDefault().post(new PrintMainWindowEvent());
            }
        });
        builder.setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                // cancel
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        dialog.show();
    }

    private void startPreferencesActivity() {
        startActivity(new Intent(this, PreferencesActivity.class));
    }

    private boolean canStartNetworkTypeSystemActivity() {
        if (canStartNetworkTypeSystemActivityResult == null) {
            canStartNetworkTypeSystemActivityResult = (createDataRoamingSettingsIntent().resolveActivity(getPackageManager()) != null);
        }
        return canStartNetworkTypeSystemActivityResult;
    }

    private void startNetworkTypeSystemActivity() {
        try {
            startActivity(createDataRoamingSettingsIntent());
        } catch (ActivityNotFoundException ex) {
            Timber.w(ex, "startNetworkTypeSystemActivity(): Could not open Settings to change network type");
            MyApplication.handleSilentException(ex);
            showCannotOpenAndroidSettingsDialog();
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void startBatteryOptimizationsSystemActivity() {
        try {
            Intent intent = new Intent(Settings.ACTION_IGNORE_BATTERY_OPTIMIZATION_SETTINGS);
            startActivityForResult(intent, BATTERY_OPTIMIZATIONS_ACTIVITY_RESULT);
        } catch (ActivityNotFoundException ex) {
            Timber.w(ex, "startBatteryOptimizationsSystemActivity(): Could not open Settings to change battery optimizations");
            showCannotOpenAndroidSettingsDialog();
        }
    }

    private void startBatterySaverSystemActivity() {
        try {
            Intent intent;
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {
                intent = new Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS);
            } else {
                intent = new Intent();
                intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.Settings$BatterySaverSettingsActivity"));
            }
            startActivityForResult(intent, BATTERY_SAVER_ACTIVITY_RESULT);
        } catch (ActivityNotFoundException ex) {
            Timber.w(ex, "startBatterySaverSystemActivity(): Could not open Settings to disable battery saver");
            MyApplication.handleSilentException(ex);
            showCannotOpenAndroidSettingsDialog();
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void startAirplaneModeSystemActivity() {
        try {
            Intent intent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
            startActivityForResult(intent, AIRPLANE_MODE_ACTIVITY_RESULT);
        } catch (ActivityNotFoundException ex) {
            Timber.w(ex, "startAirplaneModeSystemActivity(): Could not open Settings to change airplane mode");
            MyApplication.handleSilentException(ex);
            showCannotOpenAndroidSettingsDialog();
        }
    }

    private void showCannotOpenAndroidSettingsDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).setMessage(R.string.dialog_could_not_open_android_settings).setPositiveButton(R.string.dialog_ok, null).create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.setCancelable(true);
        alertDialog.show();
    }

    private Intent createDataRoamingSettingsIntent() {
        return new Intent(Settings.ACTION_DATA_ROAMING_SETTINGS);
    }

    // ========== SERVICE CONNECTIONS ========== //

    private ServiceConnection collectorServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Timber.d("onServiceConnected(): Service connection created for %s", name);
            isCollectorServiceRunning.set(true);
            // refresh menu status
            invalidateOptionsMenu();
            if (binder instanceof ICollectorService) {
                collectorServiceBinder = (ICollectorService) binder;
                // display invalid system time if necessary
                printInvalidSystemTime(collectorServiceBinder);
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Timber.d("onServiceDisconnected(): Service connection destroyed of %s", name);
            unbindService(collectorServiceConnection);
            isCollectorServiceRunning.set(false);
            // refresh menu status
            invalidateOptionsMenu();
            // hide invalid system time message
            hideInvalidSystemTime();
            // release reference to service
            collectorServiceBinder = null;
        }
    };

    // ========== PERMISSION REQUEST HANDLING ========== //
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    private void onShowRationale(final PermissionRequest request, @StringRes int messageResId) {
        onShowRationale(request, getString(messageResId));
    }

    private void onShowRationale(final PermissionRequest request, String message) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.permission_required)
                .setMessage(message)
                .setCancelable(true)
                .setPositiveButton(R.string.dialog_proceed, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.proceed();
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request.cancel();
                    }
                })
                .show();
    }

    private void onPermissionDenied(@StringRes int messageResId) {
        Toast.makeText(this, messageResId, Toast.LENGTH_LONG).show();
    }

    private void onNeverAskAgain(@StringRes int messageResId) {
        new AlertDialog.Builder(this)
                .setTitle(R.string.permission_denied)
                .setMessage(messageResId)
                .setCancelable(true)
                .setPositiveButton(R.string.dialog_settings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PermissionUtils.openAppSettings(MainActivity.this);
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, null)
                .show();
    }

    // ========== MISCELLANEOUS ========== //

    private void askAndSetGpsEnabled() {
        if (GpsUtils.isGpsEnabled(getApplication())) {
            Timber.d("askAndSetGpsEnabled(): GPS enabled");
            isGpsEnabled = true;
            showAskForLocationSettingsDialog = false;
        } else {
            Timber.d("askAndSetGpsEnabled(): GPS disabled, asking user");
            isGpsEnabled = false;
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(R.string.dialog_want_enable_gps).setPositiveButton(R.string.dialog_yes, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Timber.d("askAndSetGpsEnabled(): display settings");
                    Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                    try {
                        startActivity(intent);
                        showAskForLocationSettingsDialog = true;
                    } catch (ActivityNotFoundException ex1) {
                        intent = new Intent(Settings.ACTION_SECURITY_SETTINGS);
                        try {
                            startActivity(intent);
                            showAskForLocationSettingsDialog = true;
                        } catch (ActivityNotFoundException ex2) {
                            Timber.w("askAndSetGpsEnabled(): Could not open Settings to enable GPS");
                            MyApplication.handleSilentException(ex2);
                            AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).setMessage(R.string.dialog_could_not_open_android_settings).setPositiveButton(R.string.dialog_ok, null).create();
                            alertDialog.setCanceledOnTouchOutside(true);
                            alertDialog.setCancelable(true);
                            alertDialog.show();
                        }
                    } finally {
                        dialog.dismiss();
                    }
                }
            }).setNegativeButton(R.string.dialog_no, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Timber.d("askAndSetGpsEnabled(): cancel");
                    dialog.cancel();
                    if (GpsUtils.isGpsEnabled(getApplication())) {
                        Timber.d("askAndSetGpsEnabled(): provider enabled in the meantime");
                        startCollectorServiceWithCheck();
                    } else {
                        isGpsEnabled = false;
                        showAskForLocationSettingsDialog = false;
                    }
                }
            });
            AlertDialog dialog = builder.create();
            dialog.setCanceledOnTouchOutside(true);
            dialog.setCancelable(true);
            dialog.show();
        }
    }

    private void checkForNewVersionAvailability() {
        boolean isAutoUpdateEnabled = MyApplication.getPreferencesProvider().getUpdateCheckEnabled();
        MyApplication.getAnalytics().sendPrefsUpdateCheckEnabled(isAutoUpdateEnabled);
        if (isAutoUpdateEnabled) {
            long currentDate = DateUtils.getCurrentDateWithoutTime();
            long lastUpdateCheckDate = MyApplication.getPreferencesProvider().getLastUpdateCheckDate();
            long diffInDays = DateUtils.getTimeDiff(currentDate, lastUpdateCheckDate);
            Timber.d("checkForNewVersionAvailability(): Last update check performed on: %s, diff to current in days: %s", new Date(lastUpdateCheckDate), diffInDays);
            // if currently is at least one day after last check (day, not 24 hrs)
            if (diffInDays >= 1) {
                // check if network available
                if (NetworkUtils.isNetworkAvailable(getApplication())) {
                    int currentVersion = ApkUtils.getApkVersionCode();
                    String updateFeedUrl = String.format(BuildConfig.UPDATE_CHECK_FEED_URI, currentVersion);
                    if (!StringUtils.isNullEmptyOrWhitespace(updateFeedUrl)) {
                        UpdateCheckAsyncTask updateCheckTask = new UpdateCheckAsyncTask(getApplication(), currentVersion);
                        updateCheckTask.execute(updateFeedUrl);
                    }
                    MyApplication.getPreferencesProvider().setLastUpdateCheckDate(currentDate);
                } else {
                    Timber.d("checkForNewVersionAvailability(): No active network connection");
                }
            }
        }
    }

    private void processOnStartIntent(Intent intent) {
        if (intent != null) {
            if (intent.hasExtra(UploaderService.INTENT_KEY_RESULT_DESCRIPTION)) {
                // display upload result
                displayUploadResultDialog(intent.getStringExtra(UploaderService.INTENT_KEY_RESULT_DESCRIPTION));
            } else if (intent.hasExtra(UpdateCheckAsyncTask.INTENT_KEY_UPDATE_INFO)) {
                // display dialog with download options
                displayNewVersionDownloadOptions((UpdateInfo) intent.getSerializableExtra(UpdateCheckAsyncTask.INTENT_KEY_UPDATE_INFO));
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(CollectorStartedEvent event) {
        bindService(event.getIntent(), collectorServiceConnection, 0);
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(GpsStatusChangedEvent event) {
        if (!event.isActive()) {
            isCollectorServiceRunning.set(false);
            invalidateOptionsMenu();
            hideInvalidSystemTime();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onEvent(MapEnabledChanged event) {
        refreshTabs();
    }

    // ========== INNER OBJECTS ========== //

    public static class InternalMessageHandler extends Handler {
        public static final int EXPORT_FINISHED_UI_REFRESH = 0;

        private MainActivity mainActivity;

        public InternalMessageHandler(MainActivity mainActivity) {
            this.mainActivity = mainActivity;
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case EXPORT_FINISHED_UI_REFRESH:
                    mainActivity.exportedDirAbsolutePath = msg.getData().getString(ExportFileAsyncTask.DIR_PATH);
                    mainActivity.exportedFilePaths = msg.getData().getStringArray(ExportFileAsyncTask.FILE_PATHS);
                    if (!mainActivity.isMinimized)
                        mainActivity.displayExportFinishedDialog();
                    else
                        mainActivity.showExportFinishedDialog = true;
                    break;
            }
        }
    }
}
