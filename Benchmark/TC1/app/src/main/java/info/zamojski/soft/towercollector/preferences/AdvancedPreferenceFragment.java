/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.preferences;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.widget.Toast;

import androidx.preference.ListPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceCategory;
import androidx.preference.PreferenceManager;
import androidx.preference.SwitchPreferenceCompat;

import info.zamojski.soft.towercollector.BuildConfig;
import info.zamojski.soft.towercollector.CollectorService;
import info.zamojski.soft.towercollector.MyApplication;
import info.zamojski.soft.towercollector.R;
import info.zamojski.soft.towercollector.dev.DatabaseOperations;
import info.zamojski.soft.towercollector.dev.PreferencesOperations;
import info.zamojski.soft.towercollector.utils.PermissionUtils;
import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;
import timber.log.Timber;

@RuntimePermissions
public class AdvancedPreferenceFragment extends DialogEnabledPreferenceFragment implements OnSharedPreferenceChangeListener {

    private ListPreference collectorApiVersionPreference;
    private ListPreference fileLoggingLevelPreference;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.preferences_advanced);

        collectorApiVersionPreference = findPreference(getString(R.string.preferences_collector_api_version_key));
        fileLoggingLevelPreference = findPreference(getString(R.string.preferences_file_logging_level_key));

        fileLoggingLevelPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object newValue) {
                if (newValue.equals(getString(R.string.preferences_file_logging_level_entries_value_disabled))) {
                    Timber.d("onFileLoggingLevelChangeListener(): Disabling logger");
                } else {
                    Timber.d("onFileLoggingLevelChangeListener(): Requesting permission");
                }
                // NOTE: delegate the permission handling to generated method
                AdvancedPreferenceFragmentPermissionsDispatcher.requestLoggerChangeWithPermissionCheck(AdvancedPreferenceFragment.this);
                return true;
            }
        });

        setupApiVersionDialog();
        setupErrorReportingAvailability();
        setupDatabaseImport();
        setupDatabaseExport();
        setupPreferencesImport();
        setupPreferencesExport();
    }

    private void setupDatabaseImport() {
        showConfirmationDialog(R.string.preferences_import_database_key, R.string.unsafe_operation_warning_title,
                R.string.unsafe_operation_warning_message, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AdvancedPreferenceFragmentPermissionsDispatcher.importDatabaseWithPermissionCheck(AdvancedPreferenceFragment.this);
                    }
                });
    }

    private void setupDatabaseExport() {
        setupOnClick(R.string.preferences_export_database_key, new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                AdvancedPreferenceFragmentPermissionsDispatcher.exportDatabaseWithPermissionCheck(AdvancedPreferenceFragment.this);
                return true;
            }
        });
    }

    private void setupPreferencesImport() {
        showConfirmationDialog(R.string.preferences_import_preferences_key, R.string.unsafe_operation_warning_title,
                R.string.unsafe_operation_warning_message, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AdvancedPreferenceFragmentPermissionsDispatcher.importPreferencesWithPermissionCheck(AdvancedPreferenceFragment.this);
                    }
                });
    }

    private void setupPreferencesExport() {
        setupOnClick(R.string.preferences_export_preferences_key, new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference preference) {
                AdvancedPreferenceFragmentPermissionsDispatcher.exportPreferencesWithPermissionCheck(AdvancedPreferenceFragment.this);
                return true;
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        PreferenceManager.getDefaultSharedPreferences(getActivity()).registerOnSharedPreferenceChangeListener(this);
        // set summaries
        setupListPreferenceSummary(collectorApiVersionPreference, R.string.preferences_collector_api_version_summary);
        setupListPreferenceSummary(fileLoggingLevelPreference, R.string.preferences_file_logging_level_summary);
    }

    @Override
    public void onPause() {
        super.onPause();
        PreferenceManager.getDefaultSharedPreferences(getActivity()).unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(getString(R.string.preferences_collector_api_version_key))) {
            String collectorApiVersionValue = collectorApiVersionPreference.getValue();
            CharSequence collectorApiVersionLabel = collectorApiVersionPreference.getEntry();
            Timber.d("onSharedPreferenceChanged(): User set api version = \"%s\"", collectorApiVersionValue);
            collectorApiVersionPreference.setSummary(formatValueString(R.string.preferences_collector_api_version_summary, collectorApiVersionLabel));
            if (MyApplication.isBackgroundTaskRunning(CollectorService.class)) {
                Toast.makeText(getActivity(), R.string.preferences_restart_collector, Toast.LENGTH_SHORT).show();
            }
        } else if (key.equals(getString(R.string.preferences_file_logging_level_key))) {
            String fileLoggingLevelValue = fileLoggingLevelPreference.getValue();
            CharSequence fileLoggingLevelLabel = fileLoggingLevelPreference.getEntry();
            Timber.d("onSharedPreferenceChanged(): User set file logging level = \"%s\"", fileLoggingLevelValue);
            fileLoggingLevelPreference.setSummary(formatValueString(R.string.preferences_file_logging_level_summary, fileLoggingLevelLabel));
            // NOTE: configuration reapplied in PreferenceChangeListener
        }
    }

    private void setupApiVersionDialog() {
        setupDialog(R.string.preferences_about_collector_api_version_key, R.string.info_about_collector_api_version_title, R.raw.info_about_collector_api_version_content);
    }

    private void setupErrorReportingAvailability() {
        boolean available = BuildConfig.ACRA_SETTINGS_AVAILABLE;
        if (!available) {
            PreferenceCategory settingsCategoryPreference = findPreference(getString(R.string.preferences_advanced_category_settings_key));
            SwitchPreferenceCompat errorReportingSilentPreference = findPreference(getString(R.string.preferences_error_reporting_silent_key));
            settingsCategoryPreference.removePreference(errorReportingSilentPreference);
        }
    }

    @NeedsPermission({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void requestLoggerChange() {
        Timber.d("requestLoggerChange(): Reinitializing logger");
        MyApplication.getApplication().initLogger();
    }

    @NeedsPermission({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void importDatabase() {
        Timber.d("importDatabase(): Importing database");
        DatabaseOperations.importDatabase(MyApplication.getApplication());
    }

    @NeedsPermission({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void exportDatabase() {
        Timber.d("exportDatabase(): Exporting database");
        DatabaseOperations.exportDatabase(MyApplication.getApplication());
    }

    @NeedsPermission({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void importPreferences() {
        Timber.d("importPreferences(): Importing preferences");
        PreferencesOperations.importPreferences(MyApplication.getApplication());
    }

    @NeedsPermission({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void exportPreferences() {
        Timber.d("exportPreferences(): Exporting preferences");
        PreferencesOperations.exportPreferences(MyApplication.getApplication());
    }

    @OnShowRationale({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onLoggerChangeShowRationale(final PermissionRequest request) {
        new AlertDialog.Builder(getActivity())
                .setTitle(R.string.permission_required)
                .setMessage(R.string.permission_storage_rationale_message)
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

    @OnPermissionDenied({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onLoggerChangePermissionDenied() {
        fileLoggingLevelPreference.setValue(getString(R.string.preferences_file_logging_level_entries_value_disabled));
        Toast.makeText(getActivity(), R.string.permission_storage_denied_message, Toast.LENGTH_LONG).show();
    }

    @OnNeverAskAgain({Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE})
    void onLoggerChangeNeverAskAgain() {
        fileLoggingLevelPreference.setValue(getString(R.string.preferences_file_logging_level_entries_value_disabled));
        new AlertDialog.Builder(getActivity())
                .setTitle(R.string.permission_denied)
                .setMessage(R.string.permission_storage_never_ask_again_message)
                .setCancelable(true)
                .setPositiveButton(R.string.dialog_settings, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PermissionUtils.openAppSettings(getActivity());
                    }
                })
                .setNegativeButton(R.string.dialog_cancel, null)
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // NOTE: delegate the permission handling to generated method
        AdvancedPreferenceFragmentPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }
}
