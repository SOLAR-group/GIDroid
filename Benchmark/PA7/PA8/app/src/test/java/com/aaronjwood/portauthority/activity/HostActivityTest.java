package com.aaronjwood.portauthority.activity;

import static org.junit.Assert.*;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Button;

import androidx.test.core.app.ApplicationProvider;

import com.aaronjwood.portauthority.R;
import com.aaronjwood.portauthority.async.ScanPortsAsyncTask;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.shadows.ShadowConnectivityManager;
import org.robolectric.shadows.ShadowNetworkInfo;

@RunWith(RobolectricTestRunner.class)
public class HostActivityTest {


    @Before
    public void setUp() {
        ConnectivityManager cm = (ConnectivityManager)
                ApplicationProvider.getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        ShadowConnectivityManager shadowCM = Shadows.shadowOf(cm);

        shadowCM.setNetworkInfo(
                ConnectivityManager.TYPE_WIFI,
                ShadowNetworkInfo.newInstance(
                        NetworkInfo.DetailedState.CONNECTED,
                        ConnectivityManager.TYPE_WIFI,
                        ConnectivityManager.TYPE_WIFI,
                        true,
                        true));


    }

    @Test
    public void processFinish() throws InterruptedException {
        Intent intent = new Intent();
        intent.putExtra("HOST", "testHost");
        intent.putExtra("MAC","0;0;0;0");
        HostActivity activity = Robolectric.buildActivity(HostActivity.class, intent).create().get();
        ((Button) activity.findViewById(R.id.scanWellKnownPorts)).performClick();
//        while (activity.scanProgress < 1024) {}
        activity.scanProgress = 0;
        assert activity.scanProgressDialog.getProgress() == 0;
        activity.processFinish(50);
        assert activity.scanProgressDialog.getProgress() == 50;
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }
}