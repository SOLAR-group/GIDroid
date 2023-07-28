package info.zamojski.soft.towercollector.dao;

import static org.junit.Assert.*;

import android.content.pm.ApplicationInfo;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;

import org.acra.jraf.android.util.activitylifecyclecallbackscompat.ApplicationHelper;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import de.greenrobot.event.EventBus;
import info.zamojski.soft.towercollector.model.Measurement;
import info.zamojski.soft.towercollector.model.Statistics;

@RunWith(RobolectricTestRunner.class)
public class MeasurementsDatabaseTest {
    private MeasurementsDatabase database;

    @Before
    public void setUp(){
        if (database==null) {
            database = new MeasurementsDatabase(ApplicationProvider.getApplicationContext());
        }
        database.deleteAllMeasurements();
        }



    @Test
    public void insertMeasurements() {
        Measurement[] measurements = new Measurement[100];
        for (int i=0;i<100;i++) {
            Measurement measurement = new Measurement();
            measurements[i] = measurement;
        }
        database.insertMeasurements(measurements);
        assert (database.getAllMeasurementsCount()==100);
	System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

    }

    @Test
    public void insertMeasurement() {
        Measurement measurement = new Measurement();
        measurement.setTimestamp(1);
        measurement.setGpsAccuracy(1.0f);
        database.insertMeasurement(measurement);
        Measurement measurement2  = database.getFirstMeasurement();
        assert (measurement.getGpsAccuracy() == measurement2.getGpsAccuracy());
        assert (measurement.getTimestamp() == measurement2.getTimestamp());
        measurement2  = database.getLastMeasurement();
        assert (measurement.getGpsAccuracy() == measurement2.getGpsAccuracy());
        assert (measurement.getTimestamp() == measurement2.getTimestamp());
	System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));


    }


    @Test
    public void getAllMeasurementsCount() {
        for (int i=0;i<100;i++) {
            Measurement measurement = new Measurement();
            database.insertMeasurement(measurement);
        }
        assert (database.getAllMeasurementsCount()==100);
	System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

    }

    @Test
    public void getMeasurementsStatistics() {
        Measurement[] measurements = new Measurement[100];
        for (int i=0;i<100;i++) {
            Measurement measurement = new Measurement();
            measurements[i] = measurement;
        }
        database.insertMeasurements(measurements);
        Statistics stats = database.getMeasurementsStatistics();
        assert (stats.getCellsLocal()==1);
        assert (stats.getCellsToday()==1);
        assert (stats.getLocationsToday()==100);
        assert (stats.getLocationsToday()==100);
	System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

    }

    @Test
    public void deleteAllMeasurements() {
        for (int i=0;i<100;i++) {
            Measurement measurement = new Measurement();
            database.insertMeasurement(measurement);
        }
        assert (database.getAllMeasurementsCount()==100);
        database.deleteAllMeasurements();
        assert (database.getAllMeasurementsCount() == 0);
	System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

    }

    @Test
    public void deleteMeasurements() {
        for (int i=0;i<100;i++) {
            Measurement measurement = new Measurement();
            database.insertMeasurement(measurement);
        }
        assert (database.getAllMeasurementsCount()==100);
        database.deleteMeasurements(new int[]{1,2,30,4,95});
        assert (database.getAllMeasurementsCount()==95);
        assert(database.deleteMeasurements(new int[]{101})==0);


	System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));

    }


    @After
    public void tearDown(){
    }
}
