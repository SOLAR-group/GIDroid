package com.aaronjwood.portauthority.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Database extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "PortAuthority";

    private static final int DATABASE_VERSION = 2;

    private static final String OUI_TABLE = "ouis";

    private static final String PORT_TABLE = "ports";

    private static final String MAC_FIELD = "mac";

    private static final String VENDOR_FIELD = "vendor";

    private static final String PORT_FIELD = "port";

    private static final String DESCRIPTION_FIELD = "description";

    private static final String CREATE_OUI_TABLE = "CREATE TABLE " + OUI_TABLE + " (" + MAC_FIELD + " TEXT NOT NULL, " + VENDOR_FIELD + " TEXT NOT NULL);";

    private static final String CREATE_PORT_TABLE = "CREATE TABLE " + PORT_TABLE + " (" + PORT_FIELD + " INTEGER NOT NULL, " + DESCRIPTION_FIELD + " TEXT);";

    private static final String CREATE_PORT_INDEX = "CREATE INDEX IF NOT EXISTS idx_ports_port ON " + PORT_TABLE + " (" + PORT_FIELD + ");";

    private static final String CREATE_MAC_INDEX = "CREATE INDEX IF NOT EXISTS idx_ouis_mac ON " + OUI_TABLE + " (" + MAC_FIELD + ");";

    private static Database singleton;

    private final SQLiteDatabase db;

    public static Database getInstance(Context context) {
        if (singleton == null) {
            singleton = new Database(context);
        }
        return singleton;
    }

    Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        db = this.getWritableDatabase();
    }

    public void beginTransaction() {
        db.beginTransactionNonExclusive();
    }

    public void endTransaction() {
        db.endTransaction();
    }

    public void setTransactionSuccessful() {
        db.setTransactionSuccessful();
    }

    @Override
    public void onCreate(final SQLiteDatabase db) {
        db.execSQL(CREATE_OUI_TABLE);
        db.execSQL(CREATE_PORT_TABLE);
        db.execSQL(CREATE_PORT_INDEX);
        db.execSQL(CREATE_MAC_INDEX);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 1) {
                db.execSQL(CREATE_PORT_INDEX);
                db.execSQL(CREATE_MAC_INDEX);
        }
    }

    public long insertOui(String mac, String vendor) {
        ContentValues values = new ContentValues();
        values.put(MAC_FIELD, mac);
        values.put(VENDOR_FIELD, vendor);
        return db.insert(OUI_TABLE, null, values);
    }

    public long insertPort(String port, String description) {
        ContentValues values = new ContentValues();
        values.put(PORT_FIELD, port);
        values.put(DESCRIPTION_FIELD, description);
        return db.insert(PORT_TABLE, null, values);
    }

    public void clearOuis() {
        db.execSQL("DELETE FROM " + OUI_TABLE);
        db.execSQL("VACUUM");
    }

    public void clearPorts() {
        db.execSQL("DELETE FROM " + PORT_TABLE);
        db.execSQL("VACUUM");
    }

    public String selectVendor(String mac) {
        Cursor cursor = db.rawQuery("SELECT " + VENDOR_FIELD + " FROM " + OUI_TABLE + " WHERE " + MAC_FIELD + " = ?", new String[] { mac });
        String vendor;
        if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        vendor = cursor.getString(cursor.getColumnIndex("vendor"));
        cursor.close();
        return vendor;
    }

    public String selectPortDescription(String port) {
        Cursor cursor = db.rawQuery("SELECT " + DESCRIPTION_FIELD + " FROM " + PORT_TABLE + " WHERE " + PORT_FIELD + " = ?", new String[] { port });
        String name = "";
        if (cursor.moveToFirst()) {
            name = cursor.getString(cursor.getColumnIndex(DESCRIPTION_FIELD));
        }
        cursor.close();
        return name;
    }
}
