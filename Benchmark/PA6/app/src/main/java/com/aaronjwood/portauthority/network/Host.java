package com.aaronjwood.portauthority.network;

import android.app.Activity;
import android.database.Cursor;

import com.aaronjwood.portauthority.async.GetHostnameAsyncTask;
import com.aaronjwood.portauthority.async.ScanPortsAsyncTask;
import com.aaronjwood.portauthority.db.Database;
import com.aaronjwood.portauthority.response.HostAsyncResponse;

public class Host {

    private static final String TAG = "Host";

    /**
     * Starts a port scan
     *
     * @param ip        IP address
     * @param startPort The port to start scanning at
     * @param stopPort  The port to stop scanning at
     * @param delegate  Delegate to be called when the port scan has finished
     */
    public void scanPorts(String ip, int startPort, int stopPort, HostAsyncResponse delegate) {
        new ScanPortsAsyncTask(delegate).execute(ip, startPort, stopPort);
    }

    /**
     * Fetches the hostname for a device on the network
     *
     * @param ip       IP address
     * @param delegate Delegate to be called when the hostname has been fetched
     */
    public void getHostname(String ip, HostAsyncResponse delegate) {
        new GetHostnameAsyncTask(delegate).execute(ip);
    }

    /**
     * Fetches the MAC vendor from the database
     *
     * @param mac      MAC address
     * @param activity The calling activity
     */
    public String getMacVendor(String mac, Activity activity) {
        Database db = new Database(activity);
        Cursor cursor = db.queryDatabase("oui.db", "SELECT vendor FROM oui WHERE mac LIKE ?", new String[]{mac});
        if(cursor != null && cursor.moveToFirst()) {
            return cursor.getString(cursor.getColumnIndex("vendor"));
        }
        else {
            return "Vendor not in database";
        }
    }

}
