package com.aaronjwood.portauthority.runnable;

import android.os.Bundle;
import android.util.SparseArray;
import android.widget.Button;

import com.aaronjwood.portauthority.R;
import com.aaronjwood.portauthority.activity.HostActivity;
import com.aaronjwood.portauthority.activity.MainActivity;
import com.aaronjwood.portauthority.response.HostAsyncResponse;
import com.aaronjwood.portauthority.response.MainAsyncResponse;


import org.awaitility.Awaitility;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RunWith(RobolectricTestRunner.class)
@Config(sdk=26)
public class ScanHostsRunnableTest {

    @Test
    public void bestTest() throws InterruptedException {
        final TestHostAsyncResponse activity = Robolectric.setupActivity(TestHostAsyncResponse.class);
        String[] ipParts = new String[]{"127","0","0","0"};
        Thread running = new Thread(new ScanHostsRunnable(ipParts, 1, 255, activity));
        running.start();
        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> activity.count == 255);
        running = new Thread(new ScanHostsRunnable(ipParts, 1, 255, activity));
        running.start();
        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> activity.count == 255*2);
        running = new Thread(new ScanHostsRunnable(ipParts, 1, 255, activity));
        running.start();
        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> activity.count == 255*3);
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

    }

}


class TestHostAsyncResponse extends MainActivity implements MainAsyncResponse {

    int count;
    boolean errors;

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        count = 0;
    }




    @Override
    public void processFinish(int output) {
        count++;

    }

    @Override
    public void processFinish(String output) {

    }



}