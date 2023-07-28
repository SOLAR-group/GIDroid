package acr.browser.lightning.database.allowlist;

import java.lang.System;

/**
 * The disk backed ad block allow list database. See [AdBlockAllowListRepository] for function
 * documentation.s
 */
@androidx.annotation.WorkerThread()
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \"2\u00020\u00012\u00020\u0002:\u0001\"B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0014\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u00120\u0011H\u0016J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\rH\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J \u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\f\u0010 \u001a\u00020\u000f*\u00020!H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u00a8\u0006#"}, d2 = {"Lacr/browser/lightning/database/allowlist/AdBlockAllowListDatabase;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Lacr/browser/lightning/database/allowlist/AdBlockAllowListRepository;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "database", "Landroid/database/sqlite/SQLiteDatabase;", "getDatabase", "()Landroid/database/sqlite/SQLiteDatabase;", "database$delegate", "Lkotlin/properties/ReadOnlyProperty;", "addAllowListItem", "Lio/reactivex/Completable;", "whitelistItem", "Lacr/browser/lightning/database/allowlist/AllowListEntry;", "allAllowListItems", "Lio/reactivex/Single;", "", "allowListItemForUrl", "Lio/reactivex/Maybe;", "url", "", "clearAllowList", "onCreate", "", "db", "onUpgrade", "oldVersion", "", "newVersion", "removeAllowListItem", "bindToAllowListItem", "Landroid/database/Cursor;", "Companion", "app_lightningPlusDebug"})
@javax.inject.Singleton()
public final class AdBlockAllowListDatabase extends android.database.sqlite.SQLiteOpenHelper implements acr.browser.lightning.database.allowlist.AdBlockAllowListRepository {
    private final kotlin.properties.ReadOnlyProperty database$delegate = null;
    private static final int DATABASE_VERSION = 1;
    private static final java.lang.String DATABASE_NAME = "allowListManager";
    private static final java.lang.String TABLE_WHITELIST = "allowList";
    private static final java.lang.String KEY_ID = "id";
    private static final java.lang.String KEY_URL = "url";
    private static final java.lang.String KEY_CREATED = "created";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.database.allowlist.AdBlockAllowListDatabase.Companion Companion = null;
    
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
    
    private final acr.browser.lightning.database.allowlist.AllowListEntry bindToAllowListItem(android.database.Cursor $this$bindToAllowListItem) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<acr.browser.lightning.database.allowlist.AllowListEntry>> allAllowListItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Maybe<acr.browser.lightning.database.allowlist.AllowListEntry> allowListItemForUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable addAllowListItem(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.allowlist.AllowListEntry whitelistItem) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable removeAllowListItem(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.allowlist.AllowListEntry whitelistItem) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable clearAllowList() {
        return null;
    }
    
    @javax.inject.Inject()
    public AdBlockAllowListDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null, null, null, 0);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lacr/browser/lightning/database/allowlist/AdBlockAllowListDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "KEY_CREATED", "KEY_ID", "KEY_URL", "TABLE_WHITELIST", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}