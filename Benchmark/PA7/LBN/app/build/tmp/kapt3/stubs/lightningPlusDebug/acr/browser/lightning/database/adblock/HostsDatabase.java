package acr.browser.lightning.database.adblock;

import java.lang.System;

/**
 * A database that holds hosts, backed by SQLite.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 )2\u00020\u00012\u00020\u0002:\u0001)B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0019\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016\u00f8\u0001\u0000J\u0017\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0012H\u0016\u00f8\u0001\u0000J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0010H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0014H\u0016J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J \u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010 \u001a\u00020\rH\u0016J\u0019\u0010!\u001a\u00020\u0010*\u00020\"H\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b#\u0010$J\u0016\u0010%\u001a\u00020&*\u00020\u0010H\u0002\u00f8\u0001\u0000\u00a2\u0006\u0004\b\'\u0010(R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006*"}, d2 = {"Lacr/browser/lightning/database/adblock/HostsDatabase;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Lacr/browser/lightning/database/adblock/HostsRepository;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "database", "Landroid/database/sqlite/SQLiteDatabase;", "getDatabase", "()Landroid/database/sqlite/SQLiteDatabase;", "database$delegate", "Lkotlin/properties/ReadOnlyProperty;", "addHosts", "Lio/reactivex/Completable;", "hosts", "", "Lacr/browser/lightning/database/adblock/Host;", "allHosts", "Lio/reactivex/Single;", "containsHost", "", "host", "containsHost-M0b_tl8", "(Ljava/lang/String;)Z", "hasHosts", "onCreate", "", "db", "onUpgrade", "oldVersion", "", "newVersion", "removeAllHosts", "bindToHost", "Landroid/database/Cursor;", "bindToHost-2CZAygk", "(Landroid/database/Cursor;)Ljava/lang/String;", "toContentValues", "Landroid/content/ContentValues;", "toContentValues-M0b_tl8", "(Ljava/lang/String;)Landroid/content/ContentValues;", "Companion", "app_lightningPlusDebug"})
@javax.inject.Singleton()
public final class HostsDatabase extends android.database.sqlite.SQLiteOpenHelper implements acr.browser.lightning.database.adblock.HostsRepository {
    private final kotlin.properties.ReadOnlyProperty database$delegate = null;
    private static final int DATABASE_VERSION = 2;
    private static final java.lang.String DATABASE_NAME = "hostsDatabase";
    private static final java.lang.String TABLE_HOSTS = "hosts";
    private static final java.lang.String KEY_NAME = "url";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.database.adblock.HostsDatabase.Companion Companion = null;
    
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
    public io.reactivex.Completable addHosts(@org.jetbrains.annotations.NotNull()
    java.util.List<acr.browser.lightning.database.adblock.Host> hosts) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable removeAllHosts() {
        return null;
    }
    
    @java.lang.Override()
    public boolean hasHosts() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<acr.browser.lightning.database.adblock.Host>> allHosts() {
        return null;
    }
    
    @javax.inject.Inject()
    public HostsDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null, null, null, 0);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/database/adblock/HostsDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "KEY_NAME", "TABLE_HOSTS", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}