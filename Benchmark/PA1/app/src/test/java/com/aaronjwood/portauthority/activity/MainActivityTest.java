package com.aaronjwood.portauthority.activity;

import static org.junit.Assert.*;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Parcel;
import android.widget.TextView;

import androidx.test.core.app.ApplicationProvider;

import com.aaronjwood.portauthority.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowNetworkInfo;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {


    @Test
    public void setupHostDiscovery() {
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        mainActivity.setupHostDiscovery();
	System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
	
    }

    @Test
    public void getNetworkInfo() {
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        Context context = ApplicationProvider.getApplicationContext();
        ConnectivityManager connectivityManager =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        mainActivity.getNetworkInfo(activeNetworkInfo);
        //No connection
        TextView macAddress = mainActivity.findViewById(R.id.deviceMacAddress);
        TextView macVendor = mainActivity.findViewById(R.id.deviceMacVendor);
        assert macAddress.isShown();
        CharSequence text = macAddress.getText();
        assert text.toString().equals("No WiFi connection");
        assert macVendor.isShown();
        text = macVendor.getText();
        assert text.toString().equals("No WiFi connection");
        TextView label = mainActivity.findViewById(R.id.externalIpAddressLabel);
        TextView ip = mainActivity.findViewById(R.id.externalIpAddress);
        assert label.isShown();
        text = label.getText();
        assert text.toString().equals("WAN IP");
        assert ip.isShown();
        text = ip.getText();
        assert text.toString().equals("Fetching…");
        text = mainActivity.signalStrength.getText();
        assert text.toString().equals("");
        text = mainActivity.ssid.getText();
        assert text.toString().equals("<unknown ssid>");
        text = mainActivity.bssid.getText();
        assert text.toString().equals("");
	System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

    }

    @Test
    public void exceptions(){
        MainActivity mainActivity = Robolectric.setupActivity(MainActivity.class);
        for (int i=0; i<10;i++){
            mainActivity.testing[i] = true;
            Context context = ApplicationProvider.getApplicationContext();
            ConnectivityManager connectivityManager =
                    (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            mainActivity.getNetworkInfo(activeNetworkInfo);
            mainActivity.setupHostDiscovery();
            mainActivity.testing[i] = false;
        }

	System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

    }
}
