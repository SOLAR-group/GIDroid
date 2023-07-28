package be.digitalia.fosdem.activities;

import static org.junit.Assert.*;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.CursorIndexOutOfBoundsException;
import android.os.Bundle;

import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.controller.ActivityController;

import java.util.Date;

import be.digitalia.fosdem.loaders.TrackScheduleLoader;
import be.digitalia.fosdem.model.Day;
import be.digitalia.fosdem.model.Track;

@RunWith(RobolectricTestRunner.class)
public class TrackScheduleEventActivityTest {

    @Test
    public void testCreate() {
        Intent intent = new Intent();
        Day day = new Day();
        day.setDate(new Date());
        intent.putExtra("day", day);
        intent.putExtra("track", new Track("test", Track.Type.other));
        intent.putExtra("position", 1);
        Bundle outState = new Bundle();
        ActivityController<TrackScheduleEventActivity> controller = Robolectric.buildActivity(TrackScheduleEventActivity.class, intent);
        TrackScheduleEventActivity activity = controller.create().start().resume().visible().get();
        controller.pause().saveInstanceState(outState).stop();



        activity.onLoadFinished(LoaderManager.getInstance(activity).getLoader(1), new MockCursor());
        controller.pause().saveInstanceState(outState).stop();
        assert activity.initialPosition ==-1;
        assert activity.day.equals(day);
        assert  activity.track.getName().equals("test");
        assert  activity.adapter.getCount() == 0;
        assert activity.adapter.getCursor().isBeforeFirst();
        activity = Robolectric.buildActivity(TrackScheduleEventActivity.class, intent).create(outState).start().get();
        activity.onLoadFinished(LoaderManager.getInstance(activity).getLoader(1), new MockCursor());
        assert activity.initialPosition ==-1;
        assert activity.day.equals(day);
        assert  activity.track.getName().equals("test");
        assert  activity.adapter.getCount() == 0;
        assert ! activity.adapter.getCursor().isBeforeFirst();
        assert activity.pager.getCurrentItem() == 0;
        assert activity.pager.getAdapter().equals(activity.adapter);
        assert activity.pageIndicator.getViewPager().equals(activity.pager);
	System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }

}
