package acr.browser.lightning.database.history;

import java.lang.System;

/**
 * The disk backed download database. See [HistoryRepository] for function documentation.
 */
@androidx.annotation.WorkerThread()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001c\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00170\u00162\u0006\u0010\u0018\u001a\u00020\u0014H\u0016J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0017H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0013\u001a\u00020\u0014H\u0003J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00170\u0016H\u0016J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0007H\u0016J \u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u001a\u0010$\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\u0014H\u0016J\f\u0010&\u001a\u00020\u000f*\u00020\'H\u0002J\f\u0010(\u001a\u00020)*\u00020\u000fH\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006+"}, d2 = {"Lacr/browser/lightning/database/history/HistoryDatabase;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Lacr/browser/lightning/database/history/HistoryRepository;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "database", "Landroid/database/sqlite/SQLiteDatabase;", "getDatabase", "()Landroid/database/sqlite/SQLiteDatabase;", "database$delegate", "Lkotlin/properties/ReadOnlyProperty;", "addHistoryEntry", "", "item", "Lacr/browser/lightning/database/HistoryEntry;", "deleteHistory", "Lio/reactivex/Completable;", "deleteHistoryEntry", "url", "", "findHistoryEntriesContaining", "Lio/reactivex/Single;", "", "query", "getAllHistoryEntries", "getHistoryEntriesCount", "", "getHistoryEntry", "lastHundredVisitedHistoryEntries", "onCreate", "db", "onUpgrade", "oldVersion", "", "newVersion", "visitHistoryEntry", "title", "bindToHistoryEntry", "Landroid/database/Cursor;", "toContentValues", "Landroid/content/ContentValues;", "Companion", "app_lightningPlusDebug"})
@javax.inject.Singleton()
public final class HistoryDatabase extends android.database.sqlite.SQLiteOpenHelper implements acr.browser.lightning.database.history.HistoryRepository {
    private final kotlin.properties.ReadOnlyProperty database$delegate = null;
    private static final int DATABASE_VERSION = 2;
    private static final java.lang.String DATABASE_NAME = "historyManager";
    private static final java.lang.String TABLE_HISTORY = "history";
    private static final java.lang.String KEY_ID = "id";
    private static final java.lang.String KEY_URL = "url";
    private static final java.lang.String KEY_TITLE = "title";
    private static final java.lang.String KEY_TIME_VISITED = "time";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.database.history.HistoryDatabase.Companion Companion = null;
    
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
    public io.reactivex.Completable deleteHistory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable deleteHistoryEntry(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable visitHistoryEntry(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String title) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<acr.browser.lightning.database.HistoryEntry>> findHistoryEntriesContaining(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<acr.browser.lightning.database.HistoryEntry>> lastHundredVisitedHistoryEntries() {
        return null;
    }
    
    @androidx.annotation.WorkerThread()
    private final void addHistoryEntry(acr.browser.lightning.database.HistoryEntry item) {
    }
    
    @androidx.annotation.WorkerThread()
    private final java.lang.String getHistoryEntry(java.lang.String url) {
        return null;
    }
    
    private final java.util.List<acr.browser.lightning.database.HistoryEntry> getAllHistoryEntries() {
        return null;
    }
    
    private final long getHistoryEntriesCount() {
        return 0L;
    }
    
    private final android.content.ContentValues toContentValues(acr.browser.lightning.database.HistoryEntry $this$toContentValues) {
        return null;
    }
    
    private final acr.browser.lightning.database.HistoryEntry bindToHistoryEntry(android.database.Cursor $this$bindToHistoryEntry) {
        return null;
    }
    
    @javax.inject.Inject()
    public HistoryDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null, null, null, 0);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lacr/browser/lightning/database/history/HistoryDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "KEY_ID", "KEY_TIME_VISITED", "KEY_TITLE", "KEY_URL", "TABLE_HISTORY", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}