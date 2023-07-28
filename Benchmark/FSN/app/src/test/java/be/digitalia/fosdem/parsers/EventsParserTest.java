package be.digitalia.fosdem.parsers;

import static org.junit.Assert.*;


import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.android.XmlResourceParserImpl;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import be.digitalia.fosdem.api.FosdemApi;
import be.digitalia.fosdem.api.FosdemUrls;
import be.digitalia.fosdem.db.AppDatabase;
import be.digitalia.fosdem.db.ScheduleDao;
import be.digitalia.fosdem.model.DetailedEvent;
import be.digitalia.fosdem.model.Link;
import be.digitalia.fosdem.model.Person;
import be.digitalia.fosdem.utils.network.HttpUtils;
import okio.Buffer;
import okio.BufferedSource;


@RunWith(RobolectricTestRunner.class)
public class EventsParserTest {
    Map<Integer, String> tracks;

    @Test(timeout=10000)
    public void test1() throws Exception {
        tracks = new HashMap<>();
        tracks.put(0, "FOSDEM");
        tracks.put(1, "Community");
        tracks.put(2, "Community");
        tracks.put(3, "Community");
        ScheduleDao scheduleDao = AppDatabase.getInstance(ApplicationProvider.getApplicationContext()).getScheduleDao();
        HttpUtils.Response httpResponse = HttpUtils.get(
                FosdemUrls.getSchedule(),
                scheduleDao.getLastModifiedTag(),
                null);
        Iterable<DetailedEvent> events = new EventsParser().parse(httpResponse.source);
        int count = 0;
        for(DetailedEvent event : events) {
            if (count > 3) {
                break;
            }
            assert event.getPersons().size() <= 2;
            assert event.getLinks().size() == 3 || event.getLinks().size() == 6|| event.getLinks().size() == 4;
            assert event.getStartTime().before(event.getEndTime());
            assert "keynotes_welcomefuss_remote_accessopen_sourcing_toolsschul_frei".contains(event.getSlug())  && event.getSlug().length() > 1;
            assert "Welcome to FOSDEM 2021Empowering the school of the futureTools and Concepts for Successfully Open Sourcing Your Projectschul-frei".contains(event.getTitle()) && event.getTitle().length() > 1;
//            assert event.getSubTitle().length() > 1;
            assert tracks.get(Integer.valueOf(count)).equals(event.getTrack().toString());
            assert event.getTrack().toString().length() > 1;
            assert event.getAbstractText().length() > 0;
            assert event.getDescription().length() > 0;
            for (Person p : event.getPersons()) {
                assert p.getName().length() > 1;
                assert p.getId() >0;
            }
            for (Link l : event.getLinks()) {
                assert l.getId() == 0;
                assert l.getUrl().length() > 0;
                assert l.getDescription().length() > 0;
            }
            count++;
        }
        Buffer source = new Buffer();

        source.writeString ("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<schedule>\n" +
                "  <conference>\n" +
                "    <title>FOSDEM 2021</title>\n" +
                "    <subtitle/>\n" +
                "    <venue>Online</venue>\n" +
                "    <city/>\n" +
                "    <start>2021-02-06</start>\n" +
                "    <end>2021-02-07</end>\n" +
                "    <days>2</days>\n" +
                "    <day_change>00:00:00</day_change>\n" +
                "    <timeslot_duration>00:05:00</timeslot_duration>\n" +
                "  </conference>\n" +
                "  <day index=\"1\" date=\"2021-02-06\">\n" +
                "    <room name=\"K.fosdem\">     \n" +
                "    </room>\n" +
                "  </day>\n" +
                "</schedule>\n", StandardCharsets.UTF_8);
        events = new EventsParser().parse(source);
        return;
    }

    @After
    public void tearDown() {
        System.out.println("\nGin Memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
    }

}
