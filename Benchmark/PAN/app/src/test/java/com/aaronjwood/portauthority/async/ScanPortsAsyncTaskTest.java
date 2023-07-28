package com.aaronjwood.portauthority.async;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.AndroidException;
import android.util.SparseArray;
import android.widget.Button;

import com.aaronjwood.portauthority.R;
import com.aaronjwood.portauthority.activity.HostActivity;
import com.aaronjwood.portauthority.activity.LanHostActivity;
import com.aaronjwood.portauthority.network.Host;
import com.aaronjwood.portauthority.response.HostAsyncResponse;

import org.awaitility.Awaitility;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.Shadows;
import org.robolectric.interceptors.AndroidInterceptors;
import org.robolectric.shadows.ShadowConnectivityManager;
import org.robolectric.shadows.ShadowNetworkInfo;

import org.awaitility.Awaitility.*;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

@RunWith(RobolectricTestRunner.class)
public class ScanPortsAsyncTaskTest {

    private ConnectivityManager connectivityManager;
    private ShadowConnectivityManager shadowConnectivityManager;
    private ShadowNetworkInfo shadowOfActiveNetworkInfo;

    @Before
    public void setUp() throws IOException {
        connectivityManager =(ConnectivityManager)     RuntimeEnvironment.application.getSystemService(Context.CONNECTIVITY_SERVICE);
        shadowConnectivityManager = Shadows.shadowOf(connectivityManager);
        shadowOfActiveNetworkInfo = Shadows.shadowOf(connectivityManager.getActiveNetworkInfo());
        NetworkInfo networkInfo =  ShadowNetworkInfo.newInstance(NetworkInfo.DetailedState.CONNECTED, ConnectivityManager.TYPE_WIFI, 0, true, true);
        shadowConnectivityManager.setActiveNetworkInfo(networkInfo);

    }


    @Test
    public void test1() throws InterruptedException, UnknownHostException {
        TestHostAsyncResponse delegate = Robolectric.setupActivity(TestHostAsyncResponse.class);
        ScanPortsAsyncTask task = new ScanPortsAsyncTask(delegate);
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "127.0.0.1", 0, 22, 10);
        TestHostAsyncResponse finalDelegate = delegate;
        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> finalDelegate.finished);
        assert ! delegate.errors;
        delegate = Robolectric.setupActivity(TestHostAsyncResponse.class);
        task = new ScanPortsAsyncTask(delegate);
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "127.0.0.1", 300, 350, 10);
        TestHostAsyncResponse finalDelegate1 = delegate;
        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> finalDelegate1.finished);
        assert ! delegate.errors;
        delegate = Robolectric.setupActivity(TestHostAsyncResponse.class);
        task = new ScanPortsAsyncTask(delegate);
        task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, "127.0.0.1", 100, 200, 10);
        TestHostAsyncResponse finalDelegate2 = delegate;
        Awaitility.await().atMost(10, TimeUnit.SECONDS).until(() -> finalDelegate2.finished);
        assert ! delegate.errors;
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }

    @After
    public void tearDown() {
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }




}


class TestHostAsyncResponse extends HostActivity implements HostAsyncResponse  {

    boolean finished;
    boolean errors;

    @Override
    public void onCreate(Bundle bundle) {
        layout = R.layout.activity_lanhost;
        super.onCreate(bundle);
        finished = false;
        errors = false;
    }

    @Override
    public <T extends Throwable> void processFinish(T output) {
        finished = true;
        errors = false;
    }

    @Override
    public void processFinish(int output) {
        finished = output==1;

    }

    @Override
    public void processFinish(boolean output) {
//        finished  = true;
    }

    @Override
    public void processFinish(SparseArray<String> output) {
        finished = true;
    }


}