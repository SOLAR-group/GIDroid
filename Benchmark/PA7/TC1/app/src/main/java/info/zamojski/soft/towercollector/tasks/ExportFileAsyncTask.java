/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import info.zamojski.soft.towercollector.MainActivity.InternalMessageHandler;
import info.zamojski.soft.towercollector.MyApplication;
import info.zamojski.soft.towercollector.R;
import info.zamojski.soft.towercollector.dao.MeasurementsDatabase;
import info.zamojski.soft.towercollector.enums.FileType;
import info.zamojski.soft.towercollector.files.FileGeneratorResult;
import info.zamojski.soft.towercollector.files.devices.FileTextDevice;
import info.zamojski.soft.towercollector.files.devices.GZipFileTextDevice;
import info.zamojski.soft.towercollector.files.devices.IPersistedTextDevice;
import info.zamojski.soft.towercollector.files.devices.IWritableTextDevice;
import info.zamojski.soft.towercollector.files.devices.ZipFileTextDevice;
import info.zamojski.soft.towercollector.files.formatters.csv.CsvExportFormatter;
import info.zamojski.soft.towercollector.files.formatters.csv.CsvUploadFormatter;
import info.zamojski.soft.towercollector.files.generators.wrappers.CompositeTextGeneratorWrapper;
import info.zamojski.soft.towercollector.files.generators.wrappers.CsvTextGeneratorWrapper;
import info.zamojski.soft.towercollector.files.generators.wrappers.GpxTextGeneratorWrapper;
import info.zamojski.soft.towercollector.files.generators.wrappers.JsonTextGeneratorWrapper;
import info.zamojski.soft.towercollector.files.generators.wrappers.KmlTextGeneratorWrapper;
import info.zamojski.soft.towercollector.files.generators.wrappers.interfaces.IProgressListener;
import info.zamojski.soft.towercollector.files.generators.wrappers.interfaces.IProgressiveTextGeneratorWrapper;
import info.zamojski.soft.towercollector.model.AnalyticsStatistics;
import info.zamojski.soft.towercollector.utils.FileUtils;
import info.zamojski.soft.towercollector.utils.StringUtils;
import timber.log.Timber;

public class ExportFileAsyncTask extends AsyncTask<Void, Integer, FileGeneratorResult> implements IProgressListener {

    public static final String DIR_PATH = "EXPORTED_DIR_PATH";
    public static final String FILE_PATHS = "EXPORTED_FILE_PATHS";

    private Context context;

    private Handler handler;
    private File appDir;
    private CompositeTextGeneratorWrapper generator;

    private ProgressDialog dialog;

    public ExportFileAsyncTask(Context context, Handler handler, List<FileType> fileTypes) {
        this.context = context;
        this.handler = handler;

        appDir = FileUtils.getExternalStorageAppDir();
        CreateGenerators(fileTypes);
    }

    @Override
    protected void onPreExecute() {
        Timber.d("onPreExecute(): Starting export");
        MyApplication.startBackgroundTask(this);
        generator.addProgressListener(this);
    }

    @Override
    protected FileGeneratorResult doInBackground(Void... params) {
        Timber.d("doInBackground(): Running export");
        // set thread name for easier bug tracking in GA
        Thread.currentThread().setName(ExportFileAsyncTask.class.getSimpleName() + ".Worker");
        long startTime = System.currentTimeMillis();
        // run generator
        FileGeneratorResult result = generator.generate();
        // send stats
        long endTime = System.currentTimeMillis();
        AnalyticsStatistics stats = MeasurementsDatabase.getInstance(MyApplication.getApplication()).getAnalyticsStatistics();
        long duration = (endTime - startTime);
        MyApplication.getAnalytics().sendExportFinishedTotal(duration, generator.getSubGenerators().size(), stats);
        return result;
    }

    @Override
    protected void onProgressUpdate(Integer... progress) {
        int currentPercent = progress[0];
        int maxPercent = progress[1];
        Timber.d("Updating progress: %s %s", currentPercent, maxPercent);
        if (dialog == null) {
            // show loading indicator
            dialog = new ProgressDialog(context);
            dialog.setTitle(R.string.export_dialog_progress_title);
            dialog.setMessage(context.getString(R.string.export_dialog_progress_message));
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setButton(DialogInterface.BUTTON_POSITIVE, context.getString(R.string.dialog_cancel), (dialog, which) -> {
                // cancel generation and it will return that task should be cancelled (anyway we cleanup in onCancelled to be sure)
                generator.cancel();
            });
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMax(maxPercent);
            dialog.show();
        } else if (currentPercent >= maxPercent) {
            // hide loading indicator
            dialog.dismiss();
        } else {
            dialog.setProgress(currentPercent);
        }
    }

    @Override
    protected void onPostExecute(FileGeneratorResult result) {
        Timber.d("onPostExecute(): Showing result: %s", result);
        MyApplication.stopBackgroundTask();
        generator.removeProgressListener(this);
        // check result
        switch (result.getResult()) {
            case NoData:
                Toast.makeText(context, R.string.export_toast_no_data, Toast.LENGTH_LONG).show();
                break;
            case Succeeded:
                // show dialog
                Message msg = new Message();
                msg.what = InternalMessageHandler.EXPORT_FINISHED_UI_REFRESH;
                msg.getData().putString(DIR_PATH, appDir.getPath());
                msg.getData().putStringArray(FILE_PATHS, getGeneratedFiles());
                handler.sendMessage(msg);
                break;
            case Cancelled:
                deleteFile();
                Toast.makeText(context, R.string.export_toast_cancelled, Toast.LENGTH_LONG).show();
                break;
            case Failed:
            case Unknown:
            default:
                deleteFile();
                String causeString = "";
                switch (result.getReason()) {
                    case LocationNotExists:
                        causeString = getStringById(R.string.export_toast_failed_cause_directory_not_exists);
                        break;
                    case LocationNotWritable:
                        causeString = getStringById(R.string.export_toast_failed_cause_directory_not_writable);
                        break;
                    case DeviceNotWritable:
                        causeString = getStringById(R.string.export_toast_failed_cause_file_not_writable);
                        break;
                    case Unknown:
                    default:
                        causeString = result.getMessage();
                        if (StringUtils.isNullEmptyOrWhitespace(causeString)) {
                            causeString = getStringById(R.string.export_toast_failed_cause_unknown);
                        }
                        break;
                }
                Toast.makeText(context, context.getString(R.string.export_toast_failed, causeString), Toast.LENGTH_LONG).show();
                break;
        }
        // hide loading indicator
        if (dialog != null)
            dialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        Timber.d("onCancelled(): Export cancelled");
        MyApplication.stopBackgroundTask();
        generator.removeProgressListener(this);
        // hide loading indicator
        if (dialog != null)
            dialog.dismiss();
    }

    @Override
    public void reportProgress(int value, int max) {
        publishProgress(value, max);
    }

    private void CreateGenerators(List<FileType> fileTypes) {
        boolean compressFiles = fileTypes.contains(FileType.Compress);
        fileTypes.remove(FileType.Compress); // not a separate format
        List<IProgressiveTextGeneratorWrapper> subGenerators = new ArrayList<>();
        Date currentDateTime = new Date();
        for (FileType fileType : fileTypes) {
            switch (fileType) {
                case Csv: {
                    String path = FileUtils.combinePath(appDir, FileUtils.getCurrentDateFileName(currentDateTime, "", "csv"));
                    subGenerators.add(new CsvTextGeneratorWrapper(context, getTextDevice(path, compressFiles), new CsvExportFormatter()));
                    break;
                }
                case CsvOcid: {
                    String path = FileUtils.combinePath(appDir, FileUtils.getCurrentDateFileName(currentDateTime, "-ocid", "csv"));
                    subGenerators.add(new CsvTextGeneratorWrapper(context, getTextDevice(path, compressFiles), new CsvUploadFormatter()));
                }
                break;
                case Gpx: {
                    String path = FileUtils.combinePath(appDir, FileUtils.getCurrentDateFileName(currentDateTime, "", "gpx"));
                    subGenerators.add(new GpxTextGeneratorWrapper(context, getTextDevice(path, compressFiles)));
                }
                break;
                case JsonMls: {
                    String path = FileUtils.combinePath(appDir, FileUtils.getCurrentDateFileName(currentDateTime, "-mls", "json"));
                    subGenerators.add(new JsonTextGeneratorWrapper(context, getTextDevice(path, compressFiles)));
                }
                break;
                case Kml: {
                    String path = FileUtils.combinePath(appDir, FileUtils.getCurrentDateFileName(currentDateTime, "", "kml"));
                    subGenerators.add(new KmlTextGeneratorWrapper(context, getTextDevice(path, compressFiles)));
                }
                break;
                case Kmz: {
                    String path = FileUtils.combinePath(appDir, FileUtils.getCurrentDateFileName(currentDateTime, "", "kml"));
                    subGenerators.add(new KmlTextGeneratorWrapper(context, getKmzTextDevice(path)));
                }
                break;
                default:
                    throw new UnsupportedOperationException("This file type " + fileType + " is not supported");
            }
        }
        generator = new CompositeTextGeneratorWrapper(subGenerators);
    }

    private IWritableTextDevice getTextDevice(String path, boolean compressFiles) {
        if (compressFiles) {
            String compressionFormat = MyApplication.getPreferencesProvider().getExportCompressionFormat();
            if (compressionFormat.equals(getStringById(R.string.preferences_export_compression_format_entries_value_zip))) {
                return new ZipFileTextDevice(path);
            } else if (compressionFormat.equals(getStringById(R.string.preferences_export_compression_format_entries_value_gzip))) {
                return new GZipFileTextDevice(path);
            }
        }
        return new FileTextDevice(path);
    }

    private IWritableTextDevice getKmzTextDevice(String path) {
        return new ZipFileTextDevice(path, "kmz");
    }

    private void deleteFile() {
        for (IProgressiveTextGeneratorWrapper subGenerator : generator.getSubGenerators()) {
            IWritableTextDevice device = subGenerator.getDevice();
            // delete file if exists
            device.close();
            if (device instanceof IPersistedTextDevice) {
                IPersistedTextDevice persistedDevice = (IPersistedTextDevice) device;
                File file = new File(persistedDevice.getPath());
                if (file.exists()) {
                    Timber.d("deleteFile(): Deleting exported file");
                    if (file.delete()) {
                        Timber.d("deleteFile(): Exported file deleted");
                    } else {
                        Timber.d("deleteFile(): Cannot delete file after export failure");
                    }
                }
            }
        }
    }

    private String[] getGeneratedFiles() {
        ArrayList<String> result = new ArrayList<>();
        for (IProgressiveTextGeneratorWrapper subGenerator : generator.getSubGenerators()) {
            IWritableTextDevice device = subGenerator.getDevice();
            if (device instanceof IPersistedTextDevice) {
                IPersistedTextDevice persistedDevice = (IPersistedTextDevice) device;
                File file = new File(persistedDevice.getPath());
                if (file.exists()) {
                    result.add(file.getAbsolutePath());
                }
            }
        }
        return result.toArray(new String[0]);
    }

    private String getStringById(int resId) {
        return context.getString(resId);
    }
}
