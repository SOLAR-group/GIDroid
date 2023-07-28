package acr.browser.lightning.database;

import java.lang.System;

/**
 * A delegate that caches a [SQLiteDatabase] object for the consumer, reopening it whenever it is
 * provided if it has been closed between the last time it was accessed.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u001d\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00022\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0096\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lacr/browser/lightning/database/DatabaseDelegate;", "Lkotlin/properties/ReadOnlyProperty;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Landroid/database/sqlite/SQLiteDatabase;", "()V", "sqLiteDatabase", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "app_lightningPlusDebug"})
final class DatabaseDelegate implements kotlin.properties.ReadOnlyProperty<android.database.sqlite.SQLiteOpenHelper, android.database.sqlite.SQLiteDatabase> {
    private android.database.sqlite.SQLiteDatabase sqLiteDatabase;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.database.sqlite.SQLiteDatabase getValue(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteOpenHelper thisRef, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KProperty<?> property) {
        return null;
    }
    
    public DatabaseDelegate() {
        super();
    }
}