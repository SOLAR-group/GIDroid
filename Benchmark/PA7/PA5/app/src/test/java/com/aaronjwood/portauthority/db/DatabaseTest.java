package com.aaronjwood.portauthority.db;

import static org.junit.Assert.*;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class DatabaseTest {

    @Test
    public  void dbTest() {
        Database database = new Database(ApplicationProvider.getApplicationContext());
        String vendor = database.selectVendor("testMac");
        assert vendor == null;
        database.insertOui("testMac", "testVendor");
        vendor = database.selectVendor("testMac");
        assert vendor.equals("testVendor");
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }

}