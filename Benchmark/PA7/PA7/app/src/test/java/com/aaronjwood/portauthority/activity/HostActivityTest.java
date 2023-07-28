package com.aaronjwood.portauthority.activity;

import android.content.Intent;

import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RunWith(RobolectricTestRunner.class)
public class HostActivityTest{

    @Test
    public void testProcessFinish() {
        Intent intent = new Intent();
        intent.putExtra("HOSTNAME", "testHost");
        intent.putExtra("IP","0.0.0.0");
        intent.putExtra("MAC","0;0;0;0");
        Map<Integer, String> map = new HashMap<>();
        map.put(80,"");
        map.put(22,"");
        LanHostActivity activity = Robolectric.buildActivity(LanHostActivity.class, intent).create().get();
        activity.processFinish(map);
        map = new HashMap<>();
        map.put(10000000, "");
        activity.processFinish(map);
        ArrayList<String> ports = new ArrayList<>();
        ports.add("80 - http () \uD83C\uDF0E");
        ports.add("10000000 - unknown ()");
        assert activity.ports.equals(ports);
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

    }
}