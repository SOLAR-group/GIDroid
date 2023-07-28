package com.aaronjwood.portauthority.runnable;


import android.widget.Button;

import com.aaronjwood.portauthority.R;
import com.aaronjwood.portauthority.activity.MainActivity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Timer;

@RunWith(RobolectricTestRunner.class)
public class ScanHostsRunnableTest {

    @Test
    public void test1() throws InterruptedException {
        ArrayList<String> a = new ArrayList<>();

        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        activity.setupHostDiscovery();
        ((Button) activity.findViewById(R.id.discoverHosts)).performClick();
//        assert activity.scanProgressDialog.getProgress()  == 0;
        String[] ipParts = new String[]{"127","0","0","0"};
        Thread running = new Thread(new ScanHostsRunnable(ipParts, 1, 255, activity));
        running.start();
        Timer timer = new Timer();
        long startTime = System.currentTimeMillis();
        while (running.isAlive()){
            if (System.currentTimeMillis() - startTime > 10000){
                assert false;
            }
        }
        while (activity.scanProgressDialog.getProgress() < 255) {
            if (System.currentTimeMillis() - startTime > 10000){
                assert false;
            }
        }
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));


    }

}