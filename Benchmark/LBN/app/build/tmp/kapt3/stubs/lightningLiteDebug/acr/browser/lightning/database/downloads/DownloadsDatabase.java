package acr.browser.lightning.database.downloads;

import java.lang.System;

/**
 * The disk backed download database. See [DownloadsRepository] for function documentation.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0016\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00100\u001c2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00140\rH\u0016J\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0007H\u0016J \u0010\"\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00072\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0016J\f\u0010&\u001a\u00020\u0010*\u00020\'H\u0002J\f\u0010(\u001a\u00020)*\u00020\u0010H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006+"}, d2 = {"Lacr/browser/lightning/database/downloads/DownloadsDatabase;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Lacr/browser/lightning/database/downloads/DownloadsRepository;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "database", "Landroid/database/sqlite/SQLiteDatabase;", "getDatabase", "()Landroid/database/sqlite/SQLiteDatabase;", "database$delegate", "Lkotlin/properties/ReadOnlyProperty;", "addDownloadIfNotExists", "Lio/reactivex/Single;", "", "entry", "Lacr/browser/lightning/database/downloads/DownloadEntry;", "addDownloadsList", "Lio/reactivex/Completable;", "downloadEntries", "", "count", "", "deleteAllDownloads", "deleteDownload", "url", "", "findDownloadForUrl", "Lio/reactivex/Maybe;", "getAllDownloads", "isDownload", "onCreate", "", "db", "onUpgrade", "oldVersion", "", "newVersion", "bindToDownloadItem", "Landroid/database/Cursor;", "toContentValues", "Landroid/content/ContentValues;", "Companion", "app_lightningLiteDebug"})
@javax.inject.Singleton()
public final class DownloadsDatabase extends android.database.sqlite.SQLiteOpenHelper implements acr.browser.lightning.database.downloads.DownloadsRepository {
    private final kotlin.properties.ReadOnlyProperty database$delegate = null;
    private static final int DATABASE_VERSION = 1;
    private static final java.lang.String DATABASE_NAME = "downloadManager";
    private static final java.lang.String TABLE_DOWNLOADS = "download";
    private static final java.lang.String KEY_ID = "id";
    private static final java.lang.String KEY_URL = "url";
    private static final java.lang.String KEY_TITLE = "title";
    private static final java.lang.String KEY_SIZE = "size";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.database.downloads.DownloadsDatabase.Companion Companion = null;
    
    private final android.database.sqlite.SQLiteDatabase getDatabase() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Maybe<acr.browser.lightning.database.downloads.DownloadEntry> findDownloadForUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.Boolean> isDownload(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.Boolean> addDownloadIfNotExists(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.downloads.DownloadEntry entry) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable addDownloadsList(@org.jetbrains.annotations.NotNull()
    java.util.List<acr.browser.lightning.database.downloads.DownloadEntry> downloadEntries) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.Boolean> deleteDownload(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable deleteAllDownloads() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<acr.browser.lightning.database.downloads.DownloadEntry>> getAllDownloads() {
        return null;
    }
    
    @java.lang.Override()
    public long count() {
        return 0L;
    }
    
    /**
     * Maps the fields of [DownloadEntry] to [ContentValues].
     */
    private final android.content.ContentValues toContentValues(acr.browser.lightning.database.downloads.DownloadEntry $this$toContentValues) {
        return null;
    }
    
    /**
     * Binds a [Cursor] to a single [DownloadEntry].
     */
    private final acr.browser.lightning.database.downloads.DownloadEntry bindToDownloadItem(android.database.Cursor $this$bindToDownloadItem) {
        return null;
    }
    
    @javax.inject.Inject()
    public DownloadsDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null, null, null, 0);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lacr/browser/lightning/database/downloads/DownloadsDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "KEY_ID", "KEY_SIZE", "KEY_TITLE", "KEY_URL", "TABLE_DOWNLOADS", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}