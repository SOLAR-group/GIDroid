package nodomain.freeyourgadget.gadgetbridge.activities.appmanager;

import static org.junit.Assert.*;

import android.content.Intent;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.testing.FragmentScenario;
import androidx.viewpager.widget.ViewPager;

import org.junit.Test;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.util.UUID;

import nodomain.freeyourgadget.gadgetbridge.R;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDeviceApp;
import nodomain.freeyourgadget.gadgetbridge.service.btle.profiles.IntentListener;
import nodomain.freeyourgadget.gadgetbridge.test.TestBase;

public class AbstractAppManagerFragmentTest extends TestBase {


    @Test
    public void test1() throws InterruptedException {
        Intent intent = new Intent();
        GBDevice device = createDummyPebble("00:00:5e:00:53:af");
        intent.putExtra(GBDevice.EXTRA_DEVICE, device);
        AppManagerActivity activity = Robolectric.buildActivity(AppManagerActivity.class, intent).create().start().get();
        activity.getSupportFragmentManager().beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.appmanager_pager, AppManagerFragmentInstalledApps.class, null)
                .commit();
        AppManagerFragmentInstalledApps fragment = (AppManagerFragmentInstalledApps) activity.getSupportFragmentManager().findFragmentById(R.id.appmanager_pager);
        fragment.appListView.scrollBy(0,20);

        assert fragment.appList.size() == 4;
        assert fragment.getSystemAppsInCategory().size() ==4;
        device.setModel("silk");
        assert ! fragment.isCacheManager();
        assert fragment.getSystemAppsInCategory().size() ==7;
        fragment.refreshList();
        assert  fragment.appList.size() == 7;
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

    }
}