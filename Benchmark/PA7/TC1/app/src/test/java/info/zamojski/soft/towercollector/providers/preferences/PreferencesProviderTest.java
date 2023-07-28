package info.zamojski.soft.towercollector.providers.preferences;

import static org.junit.Assert.*;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;


@RunWith(RobolectricTestRunner.class)
public class PreferencesProviderTest {
    PreferencesProvider preferencesProvider;

    @Before
    public void setUp() {
        preferencesProvider = new PreferencesProvider(ApplicationProvider.getApplicationContext());
    }

    @Test
    public void isMainMapEnabled() {

        preferencesProvider.setMainMapEnabled(true);
        assert preferencesProvider.isMainMapEnabled();
        assert preferencesProvider.isMainMapEnabled();
        preferencesProvider.setMainMapEnabled(false);
        assert !preferencesProvider.isMainMapEnabled();
        preferencesProvider.setMainMapEnabled(true);
        assert preferencesProvider.isMainMapEnabled();
	System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

    }
}
