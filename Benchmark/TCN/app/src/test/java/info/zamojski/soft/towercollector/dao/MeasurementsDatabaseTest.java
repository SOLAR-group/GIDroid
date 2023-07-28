package info.zamojski.soft.towercollector.dao;

import static org.junit.Assert.*;

import android.content.pm.ApplicationInfo;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.runner.lifecycle.ApplicationLifecycleCallback;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.validator.ValidateWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import java.util.ArrayList;
import java.util.List;

import info.zamojski.soft.towercollector.model.Boundaries;
import info.zamojski.soft.towercollector.model.Cell;
import info.zamojski.soft.towercollector.model.MapCell;
import info.zamojski.soft.towercollector.model.MapMeasurement;
import info.zamojski.soft.towercollector.model.Measurement;
import info.zamojski.soft.towercollector.model.Statistics;

@RunWith(RobolectricTestRunner.class)
public class MeasurementsDatabaseTest {
    private MeasurementsDatabase database;

    @Before
    public void setUp() {
        if (database == null) {
            database = new MeasurementsDatabase(ApplicationProvider.getApplicationContext());
        }
        database.deleteAllMeasurements();
    }


    @Test
    public void insertMeasurements() {
        for (int i = 0; i < 100; i++) {
            Measurement measurement = new Measurement();
            database.insertMeasurement(measurement);
        }
        assert (database.getAllLocationsCount(true) == 100);

    }

    @Test
    public void insertMeasurement() {
        Measurement measurement = new Measurement();
        measurement.setGpsAccuracy(1.0f);
        measurement.addCell(new Cell());
        database.insertMeasurement(measurement);
        Measurement measurement2 = database.getFirstMeasurement();
        assert (measurement.getGpsAccuracy() == measurement2.getGpsAccuracy());
        measurement2 = database.getLastMeasurement();
        assert (measurement.getGpsAccuracy() == measurement2.getGpsAccuracy());
    }


    @Test
    public void getAllMeasurementsCount() {
        for (int i = 0; i < 100; i++) {
            Measurement measurement = new Measurement();
            database.insertMeasurement(measurement);
        }
        assert (database.getAllLocationsCount(true) == 100);
    }

    @Test
    public void getMeasurementsStatistics() {
        for (int i = 0; i < 100; i++) {
            Measurement measurement = new Measurement();
            measurement.addCell(new Cell());
            database.insertMeasurement(measurement);
        }
        Statistics stats = database.getMeasurementsStatistics();
        assert (stats.getCellsLocal() == 1);
        assert (stats.getCellsLocal() == 1);
        assert (stats.getLocationsGlobal() == 100);
    }

    @Test
    public void deleteAllMeasurements() {
        for (int i = 0; i < 100; i++) {
            Measurement measurement = new Measurement();
            database.insertMeasurement(measurement);
        }
        assert (database.getAllLocationsCount(true) == 100);
        database.deleteAllMeasurements();
        assert (database.getAllLocationsCount(true) == 0);
    }


    @Test
    public void getMeasurementsInAreaTest() {
        Measurement measurement = new Measurement();
        measurement.setLatitude(10);
        measurement.setLongitude(10);
        measurement.addCell(new Cell());
        database.insertMeasurement(measurement);
        measurement = new Measurement();
        measurement.setLatitude(60);
        measurement.setLongitude(10);
        measurement.addCell(new Cell());
        database.insertMeasurement(measurement);
        measurement = new Measurement();
        measurement.setLatitude(10);
        measurement.setLongitude(60);
        measurement.addCell(new Cell());
        database.insertMeasurement(measurement);
        measurement = new Measurement();
        measurement.setLatitude(60);
        measurement.setLongitude(60);
        measurement.addCell(new Cell());
        database.insertMeasurement(measurement);
        Boundaries boundaries = new Boundaries(0, 0, 50, 50);

        List<MapMeasurement> measurements =  database.getMeasurementsInArea(boundaries);
        assert (measurements.size() == 1);
        measurement.setLatitude(30);
        measurement.setLongitude(30);
        measurement.addCell(new Cell());
        database.insertMeasurement(measurement);

        measurements =  database.getMeasurementsInArea(boundaries);
        assert (measurements.size() == 2);
    }



    @After
    public void tearDown() {
        database.clearAllData();
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }
}
