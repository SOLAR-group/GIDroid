package nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.adapter.fossil_hr;

import static org.junit.Assert.*;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowBluetoothAdapter;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.EnumSet;

import nodomain.freeyourgadget.gadgetbridge.GBApplication;
import nodomain.freeyourgadget.gadgetbridge.GBException;
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice;
import nodomain.freeyourgadget.gadgetbridge.model.DeviceType;
import nodomain.freeyourgadget.gadgetbridge.service.DeviceCommunicationServiceTestCase;
import nodomain.freeyourgadget.gadgetbridge.service.DeviceCommunicationServiceTestCase;
import nodomain.freeyourgadget.gadgetbridge.service.DeviceSupportFactory;
import nodomain.freeyourgadget.gadgetbridge.service.ServiceDeviceSupport;
import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.QHybridSupport;
import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.requests.fossil_hr.widget.CustomWidget;
import nodomain.freeyourgadget.gadgetbridge.service.devices.qhybrid.requests.fossil_hr.widget.Widget;
import nodomain.freeyourgadget.gadgetbridge.test.TestBase;
import nodomain.freeyourgadget.gadgetbridge.util.Prefs;

@RunWith(RobolectricTestRunner.class)
public class FossilHRWatchAdapterTest extends TestBase {

    FossilHRWatchAdapter adapter;

    @Before
    public void setup() {
        GBDevice device = new GBDevice("hel::lo", "Test", DeviceType.FOSSILQHYBRID);

        QHybridSupport support = null;
        support = (QHybridSupport) new ServiceDeviceSupport(new QHybridSupport(), EnumSet.of(ServiceDeviceSupport.Flags.BUSY_CHECKING)).delegate;
        support.setContext(device, BluetoothAdapter.getDefaultAdapter(), app.getApplicationContext());
        adapter = new FossilHRWatchAdapter(support);
        adapter.initialize();
    }

    @Test
    public void testRenderWidget() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(baos));
        Prefs prefs = new Prefs(GBApplication.getDeviceSpecificSharedPrefs(adapter.getDeviceSupport().getDevice().getAddress()));
        prefs.getPreferences().edit().putBoolean("widget_draw_circles", true).commit();
        adapter.widgets.add(new CustomWidget("test1",0,10,"blue"));
        adapter.widgets.add(new Widget(Widget.WidgetType.BATTERY, 0,10,"blue"));
        adapter.widgets.add(new Widget(Widget.WidgetType.CALORIES, 0,10,"black"));
        adapter.updateWidgets();
        assert adapter.getJsonIndex() == 4;
        assert adapter.imageNameIndex == 0;
        assert adapter.backGroundImage == null;

        String output = baos.toString();
        assert  output.contains("dropping requetst WidgetsPutRequest");
        output = output.replaceFirst("dropping requetst WidgetsPutRequest","");
        assert ! output.contains("dropping requetst WidgetsPutRequest");
        assert  output.contains("dropping requetst AssetFilePutRequest");
        output = output.replaceFirst("dropping requetst AssetFilePutRequest","");
        assert ! output.contains("dropping requetst AssetFilePutRequest");
        assert  output.contains("dropping requetst ImagesSetRequest");
        output = output.replaceFirst("dropping requetst ImagesSetRequest","");
        assert ! output.contains("dropping requetst ImagesSetRequest");
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        System.out.println("\n    Gin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }


}
