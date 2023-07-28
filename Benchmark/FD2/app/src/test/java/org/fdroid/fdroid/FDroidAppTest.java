package org.fdroid.fdroid;

import static org.junit.Assert.*;

import android.app.Application;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import org.apache.tools.ant.Main;
import org.fdroid.fdroid.net.ConnectivityMonitorService;
import org.fdroid.fdroid.net.ImageLoaderForUIL;
import org.fdroid.fdroid.views.main.MainActivity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;


@RunWith(RobolectricTestRunner.class)
@Config(sdk=21)
public class FDroidAppTest {

    @Test
    public void onCreate() {
        MainActivity activity = Robolectric.setupActivity(MainActivity.class);
        FDroidApp app = (FDroidApp) activity.getApplication();
        app.httpMethod(app.getAtStartTimeSharedPreferences(), "http-downloader-query-string");
        assert app.notificationHelper != null;
        assert app.port == 8888;
        assert app.ipAddressString == null;
        assert app.subnetInfo == app.UNSET_SUBNET_INFO;
        assert app.ssid.equals("");
        assert app.bssid.equals("");
        assert ! Preferences.get().allowPushRequests();
        assert Preferences.get().expertMode();
        assert ! Preferences.get().forceTouchApps();
        assert !Preferences.get().getUnstableUpdates();
        assert Preferences.get().hasTriedEmptyUpdate();
        assert !Preferences.get().hideAllNotifications();
        assert !Preferences.get().isAutoDownloadEnabled();
        assert !Preferences.get().isBackgroundDownloadAllowed();
        assert !Preferences.get().isKeepingInstallHistory();
        assert Preferences.get().isForceOldIndexEnabled();
        assert !Preferences.get().isTorEnabled();
        assert !Preferences.get().isLocalRepoHttpsEnabled();
        Preferences.get().setUnstableUpdates(true);
        Preferences.get().setPostPrivilegedInstall(true);
        assert ImageLoader.getInstance().isInited();
        assert ! (ConnectivityMonitorService.getNetworkState(app) == ConnectivityMonitorService.FLAG_NET_UNAVAILABLE);
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));


    }
}