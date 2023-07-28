package acr.browser.lightning.browser.download;

import java.lang.System;

/**
 * Wraps [DownloadHandler] for a better download API.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ<\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lacr/browser/lightning/browser/download/DownloadPermissionsHelper;", "", "downloadHandler", "Lacr/browser/lightning/download/DownloadHandler;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "logger", "Lacr/browser/lightning/log/Logger;", "downloadsRepository", "Lacr/browser/lightning/database/downloads/DownloadsRepository;", "databaseScheduler", "Lio/reactivex/Scheduler;", "(Lacr/browser/lightning/download/DownloadHandler;Lacr/browser/lightning/preference/UserPreferences;Lacr/browser/lightning/log/Logger;Lacr/browser/lightning/database/downloads/DownloadsRepository;Lio/reactivex/Scheduler;)V", "download", "", "activity", "Landroid/app/Activity;", "url", "", "userAgent", "contentDisposition", "mimeType", "contentLength", "", "Companion", "app_lightningLiteDebug"})
public final class DownloadPermissionsHelper {
    private final acr.browser.lightning.download.DownloadHandler downloadHandler = null;
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final acr.browser.lightning.log.Logger logger = null;
    private final acr.browser.lightning.database.downloads.DownloadsRepository downloadsRepository = null;
    private final io.reactivex.Scheduler databaseScheduler = null;
    private static final java.lang.String TAG = "DownloadPermissionsHelper";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.browser.download.DownloadPermissionsHelper.Companion Companion = null;
    
    /**
     * Download a file with the provided [url].
     */
    public final void download(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String userAgent, @org.jetbrains.annotations.Nullable()
    java.lang.String contentDisposition, @org.jetbrains.annotations.Nullable()
    java.lang.String mimeType, long contentLength) {
    }
    
    @javax.inject.Inject()
    public DownloadPermissionsHelper(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.download.DownloadHandler downloadHandler, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.downloads.DownloadsRepository downloadsRepository, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DatabaseScheduler()
    io.reactivex.Scheduler databaseScheduler) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/browser/download/DownloadPermissionsHelper$Companion;", "", "()V", "TAG", "", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}