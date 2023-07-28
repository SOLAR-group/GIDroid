package be.digitalia.fosdem.db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.DataSource.Factory;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.paging.LimitOffsetDataSource;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import be.digitalia.fosdem.db.converters.GlobalTypeConverters;
import be.digitalia.fosdem.db.converters.NonNullDateTypeConverters;
import be.digitalia.fosdem.db.converters.NullableDateTypeConverters;
import be.digitalia.fosdem.db.entities.EventEntity;
import be.digitalia.fosdem.db.entities.EventTitles;
import be.digitalia.fosdem.db.entities.EventToPerson;
import be.digitalia.fosdem.model.Day;
import be.digitalia.fosdem.model.DetailedEvent;
import be.digitalia.fosdem.model.Event;
import be.digitalia.fosdem.model.Link;
import be.digitalia.fosdem.model.Person;
import be.digitalia.fosdem.model.StatusEvent;
import be.digitalia.fosdem.model.Track;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Iterable;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class ScheduleDao_Impl extends ScheduleDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Track> __insertionAdapterOfTrack;

  private final EntityInsertionAdapter<EventEntity> __insertionAdapterOfEventEntity;

  private final EntityInsertionAdapter<EventTitles> __insertionAdapterOfEventTitles;

  private final EntityInsertionAdapter<Person> __insertionAdapterOfPerson;

  private final EntityInsertionAdapter<EventToPerson> __insertionAdapterOfEventToPerson;

  private final EntityInsertionAdapter<Link> __insertionAdapterOfLink;

  private final EntityInsertionAdapter<Day> __insertionAdapterOfDay;

  private final SharedSQLiteStatement __preparedStmtOfPurgeOutdatedBookmarks;

  private final SharedSQLiteStatement __preparedStmtOfClearEvents;

  private final SharedSQLiteStatement __preparedStmtOfClearEventTitles;

  private final SharedSQLiteStatement __preparedStmtOfClearPersons;

  private final SharedSQLiteStatement __preparedStmtOfClearEventToPersons;

  private final SharedSQLiteStatement __preparedStmtOfClearLinks;

  private final SharedSQLiteStatement __preparedStmtOfClearTracks;

  private final SharedSQLiteStatement __preparedStmtOfClearDays;

  public ScheduleDao_Impl(AppDatabase __db) {
    super(__db);
    this.__db = __db;
    this.__insertionAdapterOfTrack = new EntityInsertionAdapter<Track>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `tracks` (`id`,`name`,`type`) VALUES (?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Track value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
        final String _tmp;
        _tmp = GlobalTypeConverters.fromTrackType(value.getType());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, _tmp);
        }
      }
    };
    this.__insertionAdapterOfEventEntity = new EntityInsertionAdapter<EventEntity>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `events` (`id`,`day_index`,`start_time`,`end_time`,`room_name`,`slug`,`track_id`,`abstract`,`description`) VALUES (?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EventEntity value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getDayIndex());
        final Long _tmp;
        _tmp = NullableDateTypeConverters.fromDate(value.getStartTime());
        if (_tmp == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindLong(3, _tmp);
        }
        final Long _tmp_1;
        _tmp_1 = NullableDateTypeConverters.fromDate(value.getEndTime());
        if (_tmp_1 == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindLong(4, _tmp_1);
        }
        if (value.getRoomName() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getRoomName());
        }
        if (value.getSlug() == null) {
          stmt.bindNull(6);
        } else {
          stmt.bindString(6, value.getSlug());
        }
        stmt.bindLong(7, value.getTrackId());
        if (value.getAbstractText() == null) {
          stmt.bindNull(8);
        } else {
          stmt.bindString(8, value.getAbstractText());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(9);
        } else {
          stmt.bindString(9, value.getDescription());
        }
      }
    };
    this.__insertionAdapterOfEventTitles = new EntityInsertionAdapter<EventTitles>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `events_titles` (`rowid`,`title`,`subtitle`) VALUES (nullif(?, 0),?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EventTitles value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        if (value.getSubTitle() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getSubTitle());
        }
      }
    };
    this.__insertionAdapterOfPerson = new EntityInsertionAdapter<Person>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `persons` (`rowid`,`name`) VALUES (nullif(?, 0),?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Person value) {
        stmt.bindLong(1, value.getId());
        if (value.getName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getName());
        }
      }
    };
    this.__insertionAdapterOfEventToPerson = new EntityInsertionAdapter<EventToPerson>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `events_persons` (`event_id`,`person_id`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, EventToPerson value) {
        stmt.bindLong(1, value.getEventId());
        stmt.bindLong(2, value.getPersonId());
      }
    };
    this.__insertionAdapterOfLink = new EntityInsertionAdapter<Link>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `links` (`id`,`event_id`,`url`,`description`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Link value) {
        stmt.bindLong(1, value.getId());
        stmt.bindLong(2, value.getEventId());
        if (value.getUrl() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getUrl());
        }
        if (value.getDescription() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getDescription());
        }
      }
    };
    this.__insertionAdapterOfDay = new EntityInsertionAdapter<Day>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `days` (`index`,`date`) VALUES (?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Day value) {
        stmt.bindLong(1, value.getIndex());
        final long _tmp;
        _tmp = NonNullDateTypeConverters.fromDate(value.getDate());
        stmt.bindLong(2, _tmp);
      }
    };
    this.__preparedStmtOfPurgeOutdatedBookmarks = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM bookmarks WHERE event_id < ?";
        return _query;
      }
    };
    this.__preparedStmtOfClearEvents = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM events";
        return _query;
      }
    };
    this.__preparedStmtOfClearEventTitles = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM events_titles";
        return _query;
      }
    };
    this.__preparedStmtOfClearPersons = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM persons";
        return _query;
      }
    };
    this.__preparedStmtOfClearEventToPersons = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM events_persons";
        return _query;
      }
    };
    this.__preparedStmtOfClearLinks = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM links";
        return _query;
      }
    };
    this.__preparedStmtOfClearTracks = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM tracks";
        return _query;
      }
    };
    this.__preparedStmtOfClearDays = new SharedSQLiteStatement(__db) {
      @Override
      public String createQuery() {
        final String _query = "DELETE FROM days";
        return _query;
      }
    };
  }

  @Override
  protected void insertTrack(final Track track) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfTrack.insert(track);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  protected void insertEvent(final EventEntity eventEntity, final EventTitles eventTitles) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEventEntity.insert(eventEntity);
      __insertionAdapterOfEventTitles.insert(eventTitles);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  protected void insertPersons(final List<Person> persons) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfPerson.insert(persons);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  protected void insertEventsToPersons(final EventToPerson[] eventsToPersons) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfEventToPerson.insert(eventsToPersons);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  protected void insertLinks(final List<Link> links) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfLink.insert(links);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  protected void insertDays(final Set<Day> days) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfDay.insert(days);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  protected int storeScheduleInternal(final Iterable<DetailedEvent> events,
      final String lastModifiedTag) {
    __db.beginTransaction();
    try {
      int _result = ScheduleDao_Impl.super.storeScheduleInternal(events, lastModifiedTag);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void clearSchedule() {
    __db.beginTransaction();
    try {
      ScheduleDao_Impl.super.clearSchedule();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  protected void purgeOutdatedBookmarks(final long minEventId) {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfPurgeOutdatedBookmarks.acquire();
    int _argIndex = 1;
    _stmt.bindLong(_argIndex, minEventId);
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfPurgeOutdatedBookmarks.release(_stmt);
    }
  }

  @Override
  protected void clearEvents() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearEvents.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearEvents.release(_stmt);
    }
  }

  @Override
  protected void clearEventTitles() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearEventTitles.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearEventTitles.release(_stmt);
    }
  }

  @Override
  protected void clearPersons() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearPersons.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearPersons.release(_stmt);
    }
  }

  @Override
  protected void clearEventToPersons() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearEventToPersons.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearEventToPersons.release(_stmt);
    }
  }

  @Override
  protected void clearLinks() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearLinks.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearLinks.release(_stmt);
    }
  }

  @Override
  protected void clearTracks() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearTracks.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearTracks.release(_stmt);
    }
  }

  @Override
  protected void clearDays() {
    __db.assertNotSuspendingTransaction();
    final SupportSQLiteStatement _stmt = __preparedStmtOfClearDays.acquire();
    __db.beginTransaction();
    try {
      _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
      __preparedStmtOfClearDays.release(_stmt);
    }
  }

  @Override
  protected LiveData<List<Day>> getDaysInternal() {
    final String _sql = "SELECT `index`, date FROM days ORDER BY `index` ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"days"}, false, new Callable<List<Day>>() {
      @Override
      public List<Day> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "index");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "date");
          final List<Day> _result = new ArrayList<Day>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Day _item;
            _item = new Day();
            final int _tmpIndex;
            _tmpIndex = _cursor.getInt(_cursorIndexOfIndex);
            _item.setIndex(_tmpIndex);
            final Date _tmpDate;
            final long _tmp;
            _tmp = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = NonNullDateTypeConverters.toDate(_tmp);
            _item.setDate(_tmpDate);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  protected long getConferenceStartDate() {
    final String _sql = "SELECT date FROM days ORDER BY `index` ASC LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final long _result;
      if(_cursor.moveToFirst()) {
        _result = _cursor.getLong(0);
      } else {
        _result = 0;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<List<Track>> getTracks(final Day day) {
    final String _sql = "SELECT t.id, t.name, t.type FROM tracks t JOIN events e ON t.id = e.track_id WHERE e.day_index = ? GROUP BY t.id ORDER BY t.name ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final long _tmp;
    _tmp = GlobalTypeConverters.fromDay(day);
    _statement.bindLong(_argIndex, _tmp);
    return __db.getInvalidationTracker().createLiveData(new String[]{"tracks","events"}, false, new Callable<List<Track>>() {
      @Override
      public List<Track> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "type");
          final List<Track> _result = new ArrayList<Track>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Track _item;
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final Track.Type _tmpType;
            final String _tmp_1;
            _tmp_1 = _cursor.getString(_cursorIndexOfType);
            _tmpType = GlobalTypeConverters.toTrackType(_tmp_1);
            _item = new Track(_tmpName,_tmpType);
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            _item.setId(_tmpId);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Event getEvent(final long id) {
    final String _sql = "SELECT e.id, e.start_time, e.end_time, e.room_name, e.slug, et.title, et.subtitle, e.abstract, e.description, GROUP_CONCAT(p.name, ', ') AS persons, e.day_index, d.date AS day_date, e.track_id, t.name AS track_name, t.type AS track_type FROM events e JOIN events_titles et ON e.id = et.`rowid` JOIN days d ON e.day_index = d.`index` JOIN tracks t ON e.track_id = t.id LEFT JOIN events_persons ep ON e.id = ep.event_id LEFT JOIN persons p ON ep.person_id = p.`rowid` WHERE e.id = ? GROUP BY e.id";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "start_time");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "end_time");
      final int _cursorIndexOfRoomName = CursorUtil.getColumnIndexOrThrow(_cursor, "room_name");
      final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "slug");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfAbstractText = CursorUtil.getColumnIndexOrThrow(_cursor, "abstract");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfPersonsSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "persons");
      final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "day_index");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "day_date");
      final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "track_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "track_name");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "track_type");
      final Event _result;
      if(_cursor.moveToFirst()) {
        final Day _tmpDay;
        _tmpDay = new Day();
        final int _tmpIndex;
        _tmpIndex = _cursor.getInt(_cursorIndexOfIndex);
        _tmpDay.setIndex(_tmpIndex);
        final Date _tmpDate;
        final long _tmp;
        _tmp = _cursor.getLong(_cursorIndexOfDate);
        _tmpDate = NonNullDateTypeConverters.toDate(_tmp);
        _tmpDay.setDate(_tmpDate);
        final Track _tmpTrack;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final Track.Type _tmpType;
        final String _tmp_1;
        _tmp_1 = _cursor.getString(_cursorIndexOfType);
        _tmpType = GlobalTypeConverters.toTrackType(_tmp_1);
        _tmpTrack = new Track(_tmpName,_tmpType);
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId_1);
        _tmpTrack.setId(_tmpId);
        _result = new Event();
        final long _tmpId_1;
        _tmpId_1 = _cursor.getLong(_cursorIndexOfId);
        _result.setId(_tmpId_1);
        final Date _tmpStartTime;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = NullableDateTypeConverters.toDate(_tmp_2);
        _result.setStartTime(_tmpStartTime);
        final Date _tmpEndTime;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfEndTime);
        }
        _tmpEndTime = NullableDateTypeConverters.toDate(_tmp_3);
        _result.setEndTime(_tmpEndTime);
        final String _tmpRoomName;
        _tmpRoomName = _cursor.getString(_cursorIndexOfRoomName);
        _result.setRoomName(_tmpRoomName);
        final String _tmpSlug;
        _tmpSlug = _cursor.getString(_cursorIndexOfSlug);
        _result.setSlug(_tmpSlug);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        _result.setTitle(_tmpTitle);
        final String _tmpSubTitle;
        _tmpSubTitle = _cursor.getString(_cursorIndexOfSubTitle);
        _result.setSubTitle(_tmpSubTitle);
        final String _tmpAbstractText;
        _tmpAbstractText = _cursor.getString(_cursorIndexOfAbstractText);
        _result.setAbstractText(_tmpAbstractText);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _result.setDescription(_tmpDescription);
        final String _tmpPersonsSummary;
        _tmpPersonsSummary = _cursor.getString(_cursorIndexOfPersonsSummary);
        _result.setPersonsSummary(_tmpPersonsSummary);
        _result.setDay(_tmpDay);
        _result.setTrack(_tmpTrack);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public DataSource.Factory<Integer, StatusEvent> getEvents(final long[] ids) {
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("SELECT e.id, e.start_time, e.end_time, e.room_name, e.slug, et.title, et.subtitle, e.abstract, e.description, GROUP_CONCAT(p.name, ', ') AS persons, e.day_index, d.date AS day_date, e.track_id, t.name AS track_name, t.type AS track_type, b.event_id IS NOT NULL AS is_bookmarked FROM events e JOIN events_titles et ON e.id = et.`rowid` JOIN days d ON e.day_index = d.`index` JOIN tracks t ON e.track_id = t.id LEFT JOIN events_persons ep ON e.id = ep.event_id LEFT JOIN persons p ON ep.person_id = p.`rowid` LEFT JOIN bookmarks b ON e.id = b.event_id WHERE e.id IN (");
    final int _inputSize = ids.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(") GROUP BY e.id ORDER BY e.start_time ASC");
    final String _sql = _stringBuilder.toString();
    final int _argCount = 0 + _inputSize;
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, _argCount);
    int _argIndex = 1;
    for (long _item : ids) {
      _statement.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    return new DataSource.Factory<Integer, StatusEvent>() {
      @Override
      public LimitOffsetDataSource<StatusEvent> create() {
        return new LimitOffsetDataSource<StatusEvent>(__db, _statement, false , "events", "events_titles", "days", "tracks", "events_persons", "persons", "bookmarks") {
          @Override
          protected List<StatusEvent> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(cursor, "start_time");
            final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(cursor, "end_time");
            final int _cursorIndexOfRoomName = CursorUtil.getColumnIndexOrThrow(cursor, "room_name");
            final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(cursor, "slug");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(cursor, "subtitle");
            final int _cursorIndexOfAbstractText = CursorUtil.getColumnIndexOrThrow(cursor, "abstract");
            final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(cursor, "description");
            final int _cursorIndexOfPersonsSummary = CursorUtil.getColumnIndexOrThrow(cursor, "persons");
            final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(cursor, "day_index");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(cursor, "day_date");
            final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(cursor, "track_id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(cursor, "track_name");
            final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(cursor, "track_type");
            final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(cursor, "is_bookmarked");
            final List<StatusEvent> _res = new ArrayList<StatusEvent>(cursor.getCount());
            while(cursor.moveToNext()) {
              final StatusEvent _item_1;
              final boolean _tmpIsBookmarked;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsBookmarked);
              _tmpIsBookmarked = _tmp != 0;
              final Event _tmpEvent;
              final Day _tmpDay;
              _tmpDay = new Day();
              final int _tmpIndex;
              _tmpIndex = cursor.getInt(_cursorIndexOfIndex);
              _tmpDay.setIndex(_tmpIndex);
              final Date _tmpDate;
              final long _tmp_1;
              _tmp_1 = cursor.getLong(_cursorIndexOfDate);
              _tmpDate = NonNullDateTypeConverters.toDate(_tmp_1);
              _tmpDay.setDate(_tmpDate);
              final Track _tmpTrack;
              final String _tmpName;
              _tmpName = cursor.getString(_cursorIndexOfName);
              final Track.Type _tmpType;
              final String _tmp_2;
              _tmp_2 = cursor.getString(_cursorIndexOfType);
              _tmpType = GlobalTypeConverters.toTrackType(_tmp_2);
              _tmpTrack = new Track(_tmpName,_tmpType);
              final long _tmpId;
              _tmpId = cursor.getLong(_cursorIndexOfId_1);
              _tmpTrack.setId(_tmpId);
              _tmpEvent = new Event();
              final long _tmpId_1;
              _tmpId_1 = cursor.getLong(_cursorIndexOfId);
              _tmpEvent.setId(_tmpId_1);
              final Date _tmpStartTime;
              final Long _tmp_3;
              if (cursor.isNull(_cursorIndexOfStartTime)) {
                _tmp_3 = null;
              } else {
                _tmp_3 = cursor.getLong(_cursorIndexOfStartTime);
              }
              _tmpStartTime = NullableDateTypeConverters.toDate(_tmp_3);
              _tmpEvent.setStartTime(_tmpStartTime);
              final Date _tmpEndTime;
              final Long _tmp_4;
              if (cursor.isNull(_cursorIndexOfEndTime)) {
                _tmp_4 = null;
              } else {
                _tmp_4 = cursor.getLong(_cursorIndexOfEndTime);
              }
              _tmpEndTime = NullableDateTypeConverters.toDate(_tmp_4);
              _tmpEvent.setEndTime(_tmpEndTime);
              final String _tmpRoomName;
              _tmpRoomName = cursor.getString(_cursorIndexOfRoomName);
              _tmpEvent.setRoomName(_tmpRoomName);
              final String _tmpSlug;
              _tmpSlug = cursor.getString(_cursorIndexOfSlug);
              _tmpEvent.setSlug(_tmpSlug);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _tmpEvent.setTitle(_tmpTitle);
              final String _tmpSubTitle;
              _tmpSubTitle = cursor.getString(_cursorIndexOfSubTitle);
              _tmpEvent.setSubTitle(_tmpSubTitle);
              final String _tmpAbstractText;
              _tmpAbstractText = cursor.getString(_cursorIndexOfAbstractText);
              _tmpEvent.setAbstractText(_tmpAbstractText);
              final String _tmpDescription;
              _tmpDescription = cursor.getString(_cursorIndexOfDescription);
              _tmpEvent.setDescription(_tmpDescription);
              final String _tmpPersonsSummary;
              _tmpPersonsSummary = cursor.getString(_cursorIndexOfPersonsSummary);
              _tmpEvent.setPersonsSummary(_tmpPersonsSummary);
              _tmpEvent.setDay(_tmpDay);
              _tmpEvent.setTrack(_tmpTrack);
              _item_1 = new StatusEvent(_tmpEvent,_tmpIsBookmarked);
              _res.add(_item_1);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public LiveData<List<StatusEvent>> getEvents(final Day day, final Track track) {
    final String _sql = "SELECT e.id, e.start_time, e.end_time, e.room_name, e.slug, et.title, et.subtitle, e.abstract, e.description, GROUP_CONCAT(p.name, ', ') AS persons, e.day_index, d.date AS day_date, e.track_id, t.name AS track_name, t.type AS track_type, b.event_id IS NOT NULL AS is_bookmarked FROM events e JOIN events_titles et ON e.id = et.`rowid` JOIN days d ON e.day_index = d.`index` JOIN tracks t ON e.track_id = t.id LEFT JOIN events_persons ep ON e.id = ep.event_id LEFT JOIN persons p ON ep.person_id = p.`rowid` LEFT JOIN bookmarks b ON e.id = b.event_id WHERE e.day_index = ? AND e.track_id = ? GROUP BY e.id ORDER BY e.start_time ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final long _tmp;
    _tmp = GlobalTypeConverters.fromDay(day);
    _statement.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    final long _tmp_1;
    _tmp_1 = GlobalTypeConverters.fromTrack(track);
    _statement.bindLong(_argIndex, _tmp_1);
    return __db.getInvalidationTracker().createLiveData(new String[]{"events","events_titles","days","tracks","events_persons","persons","bookmarks"}, false, new Callable<List<StatusEvent>>() {
      @Override
      public List<StatusEvent> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "start_time");
          final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "end_time");
          final int _cursorIndexOfRoomName = CursorUtil.getColumnIndexOrThrow(_cursor, "room_name");
          final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "slug");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
          final int _cursorIndexOfAbstractText = CursorUtil.getColumnIndexOrThrow(_cursor, "abstract");
          final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
          final int _cursorIndexOfPersonsSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "persons");
          final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "day_index");
          final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "day_date");
          final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "track_id");
          final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "track_name");
          final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "track_type");
          final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(_cursor, "is_bookmarked");
          final List<StatusEvent> _result = new ArrayList<StatusEvent>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final StatusEvent _item;
            final boolean _tmpIsBookmarked;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfIsBookmarked);
            _tmpIsBookmarked = _tmp_2 != 0;
            final Event _tmpEvent;
            final Day _tmpDay;
            _tmpDay = new Day();
            final int _tmpIndex;
            _tmpIndex = _cursor.getInt(_cursorIndexOfIndex);
            _tmpDay.setIndex(_tmpIndex);
            final Date _tmpDate;
            final long _tmp_3;
            _tmp_3 = _cursor.getLong(_cursorIndexOfDate);
            _tmpDate = NonNullDateTypeConverters.toDate(_tmp_3);
            _tmpDay.setDate(_tmpDate);
            final Track _tmpTrack;
            final String _tmpName;
            _tmpName = _cursor.getString(_cursorIndexOfName);
            final Track.Type _tmpType;
            final String _tmp_4;
            _tmp_4 = _cursor.getString(_cursorIndexOfType);
            _tmpType = GlobalTypeConverters.toTrackType(_tmp_4);
            _tmpTrack = new Track(_tmpName,_tmpType);
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId_1);
            _tmpTrack.setId(_tmpId);
            _tmpEvent = new Event();
            final long _tmpId_1;
            _tmpId_1 = _cursor.getLong(_cursorIndexOfId);
            _tmpEvent.setId(_tmpId_1);
            final Date _tmpStartTime;
            final Long _tmp_5;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp_5 = null;
            } else {
              _tmp_5 = _cursor.getLong(_cursorIndexOfStartTime);
            }
            _tmpStartTime = NullableDateTypeConverters.toDate(_tmp_5);
            _tmpEvent.setStartTime(_tmpStartTime);
            final Date _tmpEndTime;
            final Long _tmp_6;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_6 = null;
            } else {
              _tmp_6 = _cursor.getLong(_cursorIndexOfEndTime);
            }
            _tmpEndTime = NullableDateTypeConverters.toDate(_tmp_6);
            _tmpEvent.setEndTime(_tmpEndTime);
            final String _tmpRoomName;
            _tmpRoomName = _cursor.getString(_cursorIndexOfRoomName);
            _tmpEvent.setRoomName(_tmpRoomName);
            final String _tmpSlug;
            _tmpSlug = _cursor.getString(_cursorIndexOfSlug);
            _tmpEvent.setSlug(_tmpSlug);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            _tmpEvent.setTitle(_tmpTitle);
            final String _tmpSubTitle;
            _tmpSubTitle = _cursor.getString(_cursorIndexOfSubTitle);
            _tmpEvent.setSubTitle(_tmpSubTitle);
            final String _tmpAbstractText;
            _tmpAbstractText = _cursor.getString(_cursorIndexOfAbstractText);
            _tmpEvent.setAbstractText(_tmpAbstractText);
            final String _tmpDescription;
            _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
            _tmpEvent.setDescription(_tmpDescription);
            final String _tmpPersonsSummary;
            _tmpPersonsSummary = _cursor.getString(_cursorIndexOfPersonsSummary);
            _tmpEvent.setPersonsSummary(_tmpPersonsSummary);
            _tmpEvent.setDay(_tmpDay);
            _tmpEvent.setTrack(_tmpTrack);
            _item = new StatusEvent(_tmpEvent,_tmpIsBookmarked);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public List<Event> getEventsSnapshot(final Day day, final Track track) {
    final String _sql = "SELECT e.id, e.start_time, e.end_time, e.room_name, e.slug, et.title, et.subtitle, e.abstract, e.description, GROUP_CONCAT(p.name, ', ') AS persons, e.day_index, d.date AS day_date, e.track_id, t.name AS track_name, t.type AS track_type FROM events e JOIN events_titles et ON e.id = et.`rowid` JOIN days d ON e.day_index = d.`index` JOIN tracks t ON e.track_id = t.id LEFT JOIN events_persons ep ON e.id = ep.event_id LEFT JOIN persons p ON ep.person_id = p.`rowid` WHERE e.day_index = ? AND e.track_id = ? GROUP BY e.id ORDER BY e.start_time ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    final long _tmp;
    _tmp = GlobalTypeConverters.fromDay(day);
    _statement.bindLong(_argIndex, _tmp);
    _argIndex = 2;
    final long _tmp_1;
    _tmp_1 = GlobalTypeConverters.fromTrack(track);
    _statement.bindLong(_argIndex, _tmp_1);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "start_time");
      final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(_cursor, "end_time");
      final int _cursorIndexOfRoomName = CursorUtil.getColumnIndexOrThrow(_cursor, "room_name");
      final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(_cursor, "slug");
      final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
      final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "subtitle");
      final int _cursorIndexOfAbstractText = CursorUtil.getColumnIndexOrThrow(_cursor, "abstract");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final int _cursorIndexOfPersonsSummary = CursorUtil.getColumnIndexOrThrow(_cursor, "persons");
      final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(_cursor, "day_index");
      final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(_cursor, "day_date");
      final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(_cursor, "track_id");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "track_name");
      final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(_cursor, "track_type");
      final List<Event> _result = new ArrayList<Event>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Event _item;
        final Day _tmpDay;
        _tmpDay = new Day();
        final int _tmpIndex;
        _tmpIndex = _cursor.getInt(_cursorIndexOfIndex);
        _tmpDay.setIndex(_tmpIndex);
        final Date _tmpDate;
        final long _tmp_2;
        _tmp_2 = _cursor.getLong(_cursorIndexOfDate);
        _tmpDate = NonNullDateTypeConverters.toDate(_tmp_2);
        _tmpDay.setDate(_tmpDate);
        final Track _tmpTrack;
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        final Track.Type _tmpType;
        final String _tmp_3;
        _tmp_3 = _cursor.getString(_cursorIndexOfType);
        _tmpType = GlobalTypeConverters.toTrackType(_tmp_3);
        _tmpTrack = new Track(_tmpName,_tmpType);
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId_1);
        _tmpTrack.setId(_tmpId);
        _item = new Event();
        final long _tmpId_1;
        _tmpId_1 = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId_1);
        final Date _tmpStartTime;
        final Long _tmp_4;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp_4 = null;
        } else {
          _tmp_4 = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = NullableDateTypeConverters.toDate(_tmp_4);
        _item.setStartTime(_tmpStartTime);
        final Date _tmpEndTime;
        final Long _tmp_5;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmp_5 = null;
        } else {
          _tmp_5 = _cursor.getLong(_cursorIndexOfEndTime);
        }
        _tmpEndTime = NullableDateTypeConverters.toDate(_tmp_5);
        _item.setEndTime(_tmpEndTime);
        final String _tmpRoomName;
        _tmpRoomName = _cursor.getString(_cursorIndexOfRoomName);
        _item.setRoomName(_tmpRoomName);
        final String _tmpSlug;
        _tmpSlug = _cursor.getString(_cursorIndexOfSlug);
        _item.setSlug(_tmpSlug);
        final String _tmpTitle;
        _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
        _item.setTitle(_tmpTitle);
        final String _tmpSubTitle;
        _tmpSubTitle = _cursor.getString(_cursorIndexOfSubTitle);
        _item.setSubTitle(_tmpSubTitle);
        final String _tmpAbstractText;
        _tmpAbstractText = _cursor.getString(_cursorIndexOfAbstractText);
        _item.setAbstractText(_tmpAbstractText);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item.setDescription(_tmpDescription);
        final String _tmpPersonsSummary;
        _tmpPersonsSummary = _cursor.getString(_cursorIndexOfPersonsSummary);
        _item.setPersonsSummary(_tmpPersonsSummary);
        _item.setDay(_tmpDay);
        _item.setTrack(_tmpTrack);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public DataSource.Factory<Integer, StatusEvent> getEventsWithStartTime(final long minStartTime,
      final long maxStartTime) {
    final String _sql = "SELECT e.id, e.start_time, e.end_time, e.room_name, e.slug, et.title, et.subtitle, e.abstract, e.description, GROUP_CONCAT(p.name, ', ') AS persons, e.day_index, d.date AS day_date, e.track_id, t.name AS track_name, t.type AS track_type, b.event_id IS NOT NULL AS is_bookmarked FROM events e JOIN events_titles et ON e.id = et.`rowid` JOIN days d ON e.day_index = d.`index` JOIN tracks t ON e.track_id = t.id LEFT JOIN events_persons ep ON e.id = ep.event_id LEFT JOIN persons p ON ep.person_id = p.`rowid` LEFT JOIN bookmarks b ON e.id = b.event_id WHERE e.start_time BETWEEN ? AND ? GROUP BY e.id ORDER BY e.start_time ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, minStartTime);
    _argIndex = 2;
    _statement.bindLong(_argIndex, maxStartTime);
    return new DataSource.Factory<Integer, StatusEvent>() {
      @Override
      public LimitOffsetDataSource<StatusEvent> create() {
        return new LimitOffsetDataSource<StatusEvent>(__db, _statement, false , "events", "events_titles", "days", "tracks", "events_persons", "persons", "bookmarks") {
          @Override
          protected List<StatusEvent> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(cursor, "start_time");
            final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(cursor, "end_time");
            final int _cursorIndexOfRoomName = CursorUtil.getColumnIndexOrThrow(cursor, "room_name");
            final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(cursor, "slug");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(cursor, "subtitle");
            final int _cursorIndexOfAbstractText = CursorUtil.getColumnIndexOrThrow(cursor, "abstract");
            final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(cursor, "description");
            final int _cursorIndexOfPersonsSummary = CursorUtil.getColumnIndexOrThrow(cursor, "persons");
            final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(cursor, "day_index");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(cursor, "day_date");
            final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(cursor, "track_id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(cursor, "track_name");
            final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(cursor, "track_type");
            final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(cursor, "is_bookmarked");
            final List<StatusEvent> _res = new ArrayList<StatusEvent>(cursor.getCount());
            while(cursor.moveToNext()) {
              final StatusEvent _item;
              final boolean _tmpIsBookmarked;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsBookmarked);
              _tmpIsBookmarked = _tmp != 0;
              final Event _tmpEvent;
              final Day _tmpDay;
              _tmpDay = new Day();
              final int _tmpIndex;
              _tmpIndex = cursor.getInt(_cursorIndexOfIndex);
              _tmpDay.setIndex(_tmpIndex);
              final Date _tmpDate;
              final long _tmp_1;
              _tmp_1 = cursor.getLong(_cursorIndexOfDate);
              _tmpDate = NonNullDateTypeConverters.toDate(_tmp_1);
              _tmpDay.setDate(_tmpDate);
              final Track _tmpTrack;
              final String _tmpName;
              _tmpName = cursor.getString(_cursorIndexOfName);
              final Track.Type _tmpType;
              final String _tmp_2;
              _tmp_2 = cursor.getString(_cursorIndexOfType);
              _tmpType = GlobalTypeConverters.toTrackType(_tmp_2);
              _tmpTrack = new Track(_tmpName,_tmpType);
              final long _tmpId;
              _tmpId = cursor.getLong(_cursorIndexOfId_1);
              _tmpTrack.setId(_tmpId);
              _tmpEvent = new Event();
              final long _tmpId_1;
              _tmpId_1 = cursor.getLong(_cursorIndexOfId);
              _tmpEvent.setId(_tmpId_1);
              final Date _tmpStartTime;
              final Long _tmp_3;
              if (cursor.isNull(_cursorIndexOfStartTime)) {
                _tmp_3 = null;
              } else {
                _tmp_3 = cursor.getLong(_cursorIndexOfStartTime);
              }
              _tmpStartTime = NullableDateTypeConverters.toDate(_tmp_3);
              _tmpEvent.setStartTime(_tmpStartTime);
              final Date _tmpEndTime;
              final Long _tmp_4;
              if (cursor.isNull(_cursorIndexOfEndTime)) {
                _tmp_4 = null;
              } else {
                _tmp_4 = cursor.getLong(_cursorIndexOfEndTime);
              }
              _tmpEndTime = NullableDateTypeConverters.toDate(_tmp_4);
              _tmpEvent.setEndTime(_tmpEndTime);
              final String _tmpRoomName;
              _tmpRoomName = cursor.getString(_cursorIndexOfRoomName);
              _tmpEvent.setRoomName(_tmpRoomName);
              final String _tmpSlug;
              _tmpSlug = cursor.getString(_cursorIndexOfSlug);
              _tmpEvent.setSlug(_tmpSlug);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _tmpEvent.setTitle(_tmpTitle);
              final String _tmpSubTitle;
              _tmpSubTitle = cursor.getString(_cursorIndexOfSubTitle);
              _tmpEvent.setSubTitle(_tmpSubTitle);
              final String _tmpAbstractText;
              _tmpAbstractText = cursor.getString(_cursorIndexOfAbstractText);
              _tmpEvent.setAbstractText(_tmpAbstractText);
              final String _tmpDescription;
              _tmpDescription = cursor.getString(_cursorIndexOfDescription);
              _tmpEvent.setDescription(_tmpDescription);
              final String _tmpPersonsSummary;
              _tmpPersonsSummary = cursor.getString(_cursorIndexOfPersonsSummary);
              _tmpEvent.setPersonsSummary(_tmpPersonsSummary);
              _tmpEvent.setDay(_tmpDay);
              _tmpEvent.setTrack(_tmpTrack);
              _item = new StatusEvent(_tmpEvent,_tmpIsBookmarked);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, StatusEvent> getEventsInProgress(final long time) {
    final String _sql = "SELECT e.id, e.start_time, e.end_time, e.room_name, e.slug, et.title, et.subtitle, e.abstract, e.description, GROUP_CONCAT(p.name, ', ') AS persons, e.day_index, d.date AS day_date, e.track_id, t.name AS track_name, t.type AS track_type, b.event_id IS NOT NULL AS is_bookmarked FROM events e JOIN events_titles et ON e.id = et.`rowid` JOIN days d ON e.day_index = d.`index` JOIN tracks t ON e.track_id = t.id LEFT JOIN events_persons ep ON e.id = ep.event_id LEFT JOIN persons p ON ep.person_id = p.`rowid` LEFT JOIN bookmarks b ON e.id = b.event_id WHERE e.start_time <= ? AND ? < e.end_time GROUP BY e.id ORDER BY e.start_time DESC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 2);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, time);
    _argIndex = 2;
    _statement.bindLong(_argIndex, time);
    return new DataSource.Factory<Integer, StatusEvent>() {
      @Override
      public LimitOffsetDataSource<StatusEvent> create() {
        return new LimitOffsetDataSource<StatusEvent>(__db, _statement, false , "events", "events_titles", "days", "tracks", "events_persons", "persons", "bookmarks") {
          @Override
          protected List<StatusEvent> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(cursor, "start_time");
            final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(cursor, "end_time");
            final int _cursorIndexOfRoomName = CursorUtil.getColumnIndexOrThrow(cursor, "room_name");
            final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(cursor, "slug");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(cursor, "subtitle");
            final int _cursorIndexOfAbstractText = CursorUtil.getColumnIndexOrThrow(cursor, "abstract");
            final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(cursor, "description");
            final int _cursorIndexOfPersonsSummary = CursorUtil.getColumnIndexOrThrow(cursor, "persons");
            final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(cursor, "day_index");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(cursor, "day_date");
            final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(cursor, "track_id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(cursor, "track_name");
            final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(cursor, "track_type");
            final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(cursor, "is_bookmarked");
            final List<StatusEvent> _res = new ArrayList<StatusEvent>(cursor.getCount());
            while(cursor.moveToNext()) {
              final StatusEvent _item;
              final boolean _tmpIsBookmarked;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsBookmarked);
              _tmpIsBookmarked = _tmp != 0;
              final Event _tmpEvent;
              final Day _tmpDay;
              _tmpDay = new Day();
              final int _tmpIndex;
              _tmpIndex = cursor.getInt(_cursorIndexOfIndex);
              _tmpDay.setIndex(_tmpIndex);
              final Date _tmpDate;
              final long _tmp_1;
              _tmp_1 = cursor.getLong(_cursorIndexOfDate);
              _tmpDate = NonNullDateTypeConverters.toDate(_tmp_1);
              _tmpDay.setDate(_tmpDate);
              final Track _tmpTrack;
              final String _tmpName;
              _tmpName = cursor.getString(_cursorIndexOfName);
              final Track.Type _tmpType;
              final String _tmp_2;
              _tmp_2 = cursor.getString(_cursorIndexOfType);
              _tmpType = GlobalTypeConverters.toTrackType(_tmp_2);
              _tmpTrack = new Track(_tmpName,_tmpType);
              final long _tmpId;
              _tmpId = cursor.getLong(_cursorIndexOfId_1);
              _tmpTrack.setId(_tmpId);
              _tmpEvent = new Event();
              final long _tmpId_1;
              _tmpId_1 = cursor.getLong(_cursorIndexOfId);
              _tmpEvent.setId(_tmpId_1);
              final Date _tmpStartTime;
              final Long _tmp_3;
              if (cursor.isNull(_cursorIndexOfStartTime)) {
                _tmp_3 = null;
              } else {
                _tmp_3 = cursor.getLong(_cursorIndexOfStartTime);
              }
              _tmpStartTime = NullableDateTypeConverters.toDate(_tmp_3);
              _tmpEvent.setStartTime(_tmpStartTime);
              final Date _tmpEndTime;
              final Long _tmp_4;
              if (cursor.isNull(_cursorIndexOfEndTime)) {
                _tmp_4 = null;
              } else {
                _tmp_4 = cursor.getLong(_cursorIndexOfEndTime);
              }
              _tmpEndTime = NullableDateTypeConverters.toDate(_tmp_4);
              _tmpEvent.setEndTime(_tmpEndTime);
              final String _tmpRoomName;
              _tmpRoomName = cursor.getString(_cursorIndexOfRoomName);
              _tmpEvent.setRoomName(_tmpRoomName);
              final String _tmpSlug;
              _tmpSlug = cursor.getString(_cursorIndexOfSlug);
              _tmpEvent.setSlug(_tmpSlug);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _tmpEvent.setTitle(_tmpTitle);
              final String _tmpSubTitle;
              _tmpSubTitle = cursor.getString(_cursorIndexOfSubTitle);
              _tmpEvent.setSubTitle(_tmpSubTitle);
              final String _tmpAbstractText;
              _tmpAbstractText = cursor.getString(_cursorIndexOfAbstractText);
              _tmpEvent.setAbstractText(_tmpAbstractText);
              final String _tmpDescription;
              _tmpDescription = cursor.getString(_cursorIndexOfDescription);
              _tmpEvent.setDescription(_tmpDescription);
              final String _tmpPersonsSummary;
              _tmpPersonsSummary = cursor.getString(_cursorIndexOfPersonsSummary);
              _tmpEvent.setPersonsSummary(_tmpPersonsSummary);
              _tmpEvent.setDay(_tmpDay);
              _tmpEvent.setTrack(_tmpTrack);
              _item = new StatusEvent(_tmpEvent,_tmpIsBookmarked);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, StatusEvent> getEvents(final Person person) {
    final String _sql = "SELECT e.id , e.start_time, e.end_time, e.room_name, e.slug, et.title, et.subtitle, e.abstract, e.description, GROUP_CONCAT(p.name, ', ') AS persons, e.day_index, d.date AS day_date, e.track_id, t.name AS track_name, t.type AS track_type, b.event_id IS NOT NULL AS is_bookmarked FROM events e JOIN events_titles et ON e.id = et.`rowid` JOIN days d ON e.day_index = d.`index` JOIN tracks t ON e.track_id = t.id LEFT JOIN events_persons ep ON e.id = ep.event_id LEFT JOIN persons p ON ep.person_id = p.`rowid` LEFT JOIN bookmarks b ON e.id = b.event_id JOIN events_persons ep2 ON e.id = ep2.event_id WHERE ep2.person_id = ? GROUP BY e.id ORDER BY e.start_time ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final long _tmp;
    _tmp = GlobalTypeConverters.fromPerson(person);
    _statement.bindLong(_argIndex, _tmp);
    return new DataSource.Factory<Integer, StatusEvent>() {
      @Override
      public LimitOffsetDataSource<StatusEvent> create() {
        return new LimitOffsetDataSource<StatusEvent>(__db, _statement, false , "events", "events_titles", "days", "tracks", "events_persons", "persons", "bookmarks") {
          @Override
          protected List<StatusEvent> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(cursor, "start_time");
            final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(cursor, "end_time");
            final int _cursorIndexOfRoomName = CursorUtil.getColumnIndexOrThrow(cursor, "room_name");
            final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(cursor, "slug");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(cursor, "subtitle");
            final int _cursorIndexOfAbstractText = CursorUtil.getColumnIndexOrThrow(cursor, "abstract");
            final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(cursor, "description");
            final int _cursorIndexOfPersonsSummary = CursorUtil.getColumnIndexOrThrow(cursor, "persons");
            final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(cursor, "day_index");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(cursor, "day_date");
            final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(cursor, "track_id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(cursor, "track_name");
            final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(cursor, "track_type");
            final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(cursor, "is_bookmarked");
            final List<StatusEvent> _res = new ArrayList<StatusEvent>(cursor.getCount());
            while(cursor.moveToNext()) {
              final StatusEvent _item;
              final boolean _tmpIsBookmarked;
              final int _tmp_1;
              _tmp_1 = cursor.getInt(_cursorIndexOfIsBookmarked);
              _tmpIsBookmarked = _tmp_1 != 0;
              final Event _tmpEvent;
              final Day _tmpDay;
              _tmpDay = new Day();
              final int _tmpIndex;
              _tmpIndex = cursor.getInt(_cursorIndexOfIndex);
              _tmpDay.setIndex(_tmpIndex);
              final Date _tmpDate;
              final long _tmp_2;
              _tmp_2 = cursor.getLong(_cursorIndexOfDate);
              _tmpDate = NonNullDateTypeConverters.toDate(_tmp_2);
              _tmpDay.setDate(_tmpDate);
              final Track _tmpTrack;
              final String _tmpName;
              _tmpName = cursor.getString(_cursorIndexOfName);
              final Track.Type _tmpType;
              final String _tmp_3;
              _tmp_3 = cursor.getString(_cursorIndexOfType);
              _tmpType = GlobalTypeConverters.toTrackType(_tmp_3);
              _tmpTrack = new Track(_tmpName,_tmpType);
              final long _tmpId;
              _tmpId = cursor.getLong(_cursorIndexOfId_1);
              _tmpTrack.setId(_tmpId);
              _tmpEvent = new Event();
              final long _tmpId_1;
              _tmpId_1 = cursor.getLong(_cursorIndexOfId);
              _tmpEvent.setId(_tmpId_1);
              final Date _tmpStartTime;
              final Long _tmp_4;
              if (cursor.isNull(_cursorIndexOfStartTime)) {
                _tmp_4 = null;
              } else {
                _tmp_4 = cursor.getLong(_cursorIndexOfStartTime);
              }
              _tmpStartTime = NullableDateTypeConverters.toDate(_tmp_4);
              _tmpEvent.setStartTime(_tmpStartTime);
              final Date _tmpEndTime;
              final Long _tmp_5;
              if (cursor.isNull(_cursorIndexOfEndTime)) {
                _tmp_5 = null;
              } else {
                _tmp_5 = cursor.getLong(_cursorIndexOfEndTime);
              }
              _tmpEndTime = NullableDateTypeConverters.toDate(_tmp_5);
              _tmpEvent.setEndTime(_tmpEndTime);
              final String _tmpRoomName;
              _tmpRoomName = cursor.getString(_cursorIndexOfRoomName);
              _tmpEvent.setRoomName(_tmpRoomName);
              final String _tmpSlug;
              _tmpSlug = cursor.getString(_cursorIndexOfSlug);
              _tmpEvent.setSlug(_tmpSlug);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _tmpEvent.setTitle(_tmpTitle);
              final String _tmpSubTitle;
              _tmpSubTitle = cursor.getString(_cursorIndexOfSubTitle);
              _tmpEvent.setSubTitle(_tmpSubTitle);
              final String _tmpAbstractText;
              _tmpAbstractText = cursor.getString(_cursorIndexOfAbstractText);
              _tmpEvent.setAbstractText(_tmpAbstractText);
              final String _tmpDescription;
              _tmpDescription = cursor.getString(_cursorIndexOfDescription);
              _tmpEvent.setDescription(_tmpDescription);
              final String _tmpPersonsSummary;
              _tmpPersonsSummary = cursor.getString(_cursorIndexOfPersonsSummary);
              _tmpEvent.setPersonsSummary(_tmpPersonsSummary);
              _tmpEvent.setDay(_tmpDay);
              _tmpEvent.setTrack(_tmpTrack);
              _item = new StatusEvent(_tmpEvent,_tmpIsBookmarked);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public DataSource.Factory<Integer, StatusEvent> getSearchResults(final String query) {
    final String _sql = "SELECT e.id, e.start_time, e.end_time, e.room_name, e.slug, et.title, et.subtitle, e.abstract, e.description, GROUP_CONCAT(p.name, ', ') AS persons, e.day_index, d.date AS day_date, e.track_id, t.name AS track_name, t.type AS track_type, b.event_id IS NOT NULL AS is_bookmarked FROM events e JOIN events_titles et ON e.id = et.`rowid` JOIN days d ON e.day_index = d.`index` JOIN tracks t ON e.track_id = t.id LEFT JOIN events_persons ep ON e.id = ep.event_id LEFT JOIN persons p ON ep.person_id = p.`rowid` LEFT JOIN bookmarks b ON e.id = b.event_id WHERE e.id IN ( SELECT `rowid` FROM events_titles WHERE events_titles MATCH ? || '*' UNION SELECT e.id FROM events e JOIN tracks t ON e.track_id = t.id WHERE t.name LIKE '%' || ? || '%' UNION SELECT ep.event_id FROM events_persons ep JOIN persons p ON ep.person_id = p.`rowid` WHERE p.name MATCH ? || '*' ) GROUP BY e.id ORDER BY e.start_time ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 3);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 3;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    return new DataSource.Factory<Integer, StatusEvent>() {
      @Override
      public LimitOffsetDataSource<StatusEvent> create() {
        return new LimitOffsetDataSource<StatusEvent>(__db, _statement, false , "events", "events_titles", "days", "tracks", "events_persons", "persons", "bookmarks") {
          @Override
          protected List<StatusEvent> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "id");
            final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(cursor, "start_time");
            final int _cursorIndexOfEndTime = CursorUtil.getColumnIndexOrThrow(cursor, "end_time");
            final int _cursorIndexOfRoomName = CursorUtil.getColumnIndexOrThrow(cursor, "room_name");
            final int _cursorIndexOfSlug = CursorUtil.getColumnIndexOrThrow(cursor, "slug");
            final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(cursor, "title");
            final int _cursorIndexOfSubTitle = CursorUtil.getColumnIndexOrThrow(cursor, "subtitle");
            final int _cursorIndexOfAbstractText = CursorUtil.getColumnIndexOrThrow(cursor, "abstract");
            final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(cursor, "description");
            final int _cursorIndexOfPersonsSummary = CursorUtil.getColumnIndexOrThrow(cursor, "persons");
            final int _cursorIndexOfIndex = CursorUtil.getColumnIndexOrThrow(cursor, "day_index");
            final int _cursorIndexOfDate = CursorUtil.getColumnIndexOrThrow(cursor, "day_date");
            final int _cursorIndexOfId_1 = CursorUtil.getColumnIndexOrThrow(cursor, "track_id");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(cursor, "track_name");
            final int _cursorIndexOfType = CursorUtil.getColumnIndexOrThrow(cursor, "track_type");
            final int _cursorIndexOfIsBookmarked = CursorUtil.getColumnIndexOrThrow(cursor, "is_bookmarked");
            final List<StatusEvent> _res = new ArrayList<StatusEvent>(cursor.getCount());
            while(cursor.moveToNext()) {
              final StatusEvent _item;
              final boolean _tmpIsBookmarked;
              final int _tmp;
              _tmp = cursor.getInt(_cursorIndexOfIsBookmarked);
              _tmpIsBookmarked = _tmp != 0;
              final Event _tmpEvent;
              final Day _tmpDay;
              _tmpDay = new Day();
              final int _tmpIndex;
              _tmpIndex = cursor.getInt(_cursorIndexOfIndex);
              _tmpDay.setIndex(_tmpIndex);
              final Date _tmpDate;
              final long _tmp_1;
              _tmp_1 = cursor.getLong(_cursorIndexOfDate);
              _tmpDate = NonNullDateTypeConverters.toDate(_tmp_1);
              _tmpDay.setDate(_tmpDate);
              final Track _tmpTrack;
              final String _tmpName;
              _tmpName = cursor.getString(_cursorIndexOfName);
              final Track.Type _tmpType;
              final String _tmp_2;
              _tmp_2 = cursor.getString(_cursorIndexOfType);
              _tmpType = GlobalTypeConverters.toTrackType(_tmp_2);
              _tmpTrack = new Track(_tmpName,_tmpType);
              final long _tmpId;
              _tmpId = cursor.getLong(_cursorIndexOfId_1);
              _tmpTrack.setId(_tmpId);
              _tmpEvent = new Event();
              final long _tmpId_1;
              _tmpId_1 = cursor.getLong(_cursorIndexOfId);
              _tmpEvent.setId(_tmpId_1);
              final Date _tmpStartTime;
              final Long _tmp_3;
              if (cursor.isNull(_cursorIndexOfStartTime)) {
                _tmp_3 = null;
              } else {
                _tmp_3 = cursor.getLong(_cursorIndexOfStartTime);
              }
              _tmpStartTime = NullableDateTypeConverters.toDate(_tmp_3);
              _tmpEvent.setStartTime(_tmpStartTime);
              final Date _tmpEndTime;
              final Long _tmp_4;
              if (cursor.isNull(_cursorIndexOfEndTime)) {
                _tmp_4 = null;
              } else {
                _tmp_4 = cursor.getLong(_cursorIndexOfEndTime);
              }
              _tmpEndTime = NullableDateTypeConverters.toDate(_tmp_4);
              _tmpEvent.setEndTime(_tmpEndTime);
              final String _tmpRoomName;
              _tmpRoomName = cursor.getString(_cursorIndexOfRoomName);
              _tmpEvent.setRoomName(_tmpRoomName);
              final String _tmpSlug;
              _tmpSlug = cursor.getString(_cursorIndexOfSlug);
              _tmpEvent.setSlug(_tmpSlug);
              final String _tmpTitle;
              _tmpTitle = cursor.getString(_cursorIndexOfTitle);
              _tmpEvent.setTitle(_tmpTitle);
              final String _tmpSubTitle;
              _tmpSubTitle = cursor.getString(_cursorIndexOfSubTitle);
              _tmpEvent.setSubTitle(_tmpSubTitle);
              final String _tmpAbstractText;
              _tmpAbstractText = cursor.getString(_cursorIndexOfAbstractText);
              _tmpEvent.setAbstractText(_tmpAbstractText);
              final String _tmpDescription;
              _tmpDescription = cursor.getString(_cursorIndexOfDescription);
              _tmpEvent.setDescription(_tmpDescription);
              final String _tmpPersonsSummary;
              _tmpPersonsSummary = cursor.getString(_cursorIndexOfPersonsSummary);
              _tmpEvent.setPersonsSummary(_tmpPersonsSummary);
              _tmpEvent.setDay(_tmpDay);
              _tmpEvent.setTrack(_tmpTrack);
              _item = new StatusEvent(_tmpEvent,_tmpIsBookmarked);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  public Cursor getSearchSuggestionResults(final String query, final int limit) {
    final String _sql = "SELECT e.id AS _id, et.title AS suggest_text_1, IFNULL(GROUP_CONCAT(p.name, ', '), '') || ' - ' || t.name AS suggest_text_2, e.id AS suggest_intent_data FROM events e JOIN events_titles et ON e.id = et.`rowid` JOIN tracks t ON e.track_id = t.id LEFT JOIN events_persons ep ON e.id = ep.event_id LEFT JOIN persons p ON ep.person_id = p.`rowid` WHERE e.id IN ( SELECT `rowid` FROM events_titles WHERE events_titles MATCH ? || '*' UNION SELECT e.id FROM events e JOIN tracks t ON e.track_id = t.id WHERE t.name LIKE '%' || ? || '%' UNION SELECT ep.event_id FROM events_persons ep JOIN persons p ON ep.person_id = p.`rowid` WHERE p.name MATCH ? || '*' ) GROUP BY e.id ORDER BY e.start_time ASC LIMIT ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 4);
    int _argIndex = 1;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 2;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 3;
    if (query == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, query);
    }
    _argIndex = 4;
    _statement.bindLong(_argIndex, limit);
    final Cursor _tmpResult = __db.query(_statement);
    return _tmpResult;
  }

  @Override
  public DataSource.Factory<Integer, Person> getPersons() {
    final String _sql = "SELECT `rowid`, name FROM persons ORDER BY name COLLATE NOCASE";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return new DataSource.Factory<Integer, Person>() {
      @Override
      public LimitOffsetDataSource<Person> create() {
        return new LimitOffsetDataSource<Person>(__db, _statement, false , "persons") {
          @Override
          protected List<Person> convertRows(Cursor cursor) {
            final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(cursor, "rowid");
            final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(cursor, "name");
            final List<Person> _res = new ArrayList<Person>(cursor.getCount());
            while(cursor.moveToNext()) {
              final Person _item;
              _item = new Person();
              final long _tmpId;
              _tmpId = cursor.getLong(_cursorIndexOfId);
              _item.setId(_tmpId);
              final String _tmpName;
              _tmpName = cursor.getString(_cursorIndexOfName);
              _item.setName(_tmpName);
              _res.add(_item);
            }
            return _res;
          }
        };
      }
    };
  }

  @Override
  protected List<Person> getPersons(final Event event) {
    final String _sql = "SELECT p.`rowid`, p.name FROM persons p JOIN events_persons ep ON p.`rowid` = ep.person_id WHERE ep.event_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final long _tmp;
    _tmp = GlobalTypeConverters.fromEvent(event);
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "rowid");
      final int _cursorIndexOfName = CursorUtil.getColumnIndexOrThrow(_cursor, "name");
      final List<Person> _result = new ArrayList<Person>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Person _item;
        _item = new Person();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final String _tmpName;
        _tmpName = _cursor.getString(_cursorIndexOfName);
        _item.setName(_tmpName);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  protected List<Link> getLinks(final Event event) {
    final String _sql = "SELECT * FROM links WHERE event_id = ? ORDER BY id ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final long _tmp;
    _tmp = GlobalTypeConverters.fromEvent(event);
    _statement.bindLong(_argIndex, _tmp);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
      final int _cursorIndexOfEventId = CursorUtil.getColumnIndexOrThrow(_cursor, "event_id");
      final int _cursorIndexOfUrl = CursorUtil.getColumnIndexOrThrow(_cursor, "url");
      final int _cursorIndexOfDescription = CursorUtil.getColumnIndexOrThrow(_cursor, "description");
      final List<Link> _result = new ArrayList<Link>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final Link _item;
        _item = new Link();
        final long _tmpId;
        _tmpId = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId);
        final long _tmpEventId;
        _tmpEventId = _cursor.getLong(_cursorIndexOfEventId);
        _item.setEventId(_tmpEventId);
        final String _tmpUrl;
        _tmpUrl = _cursor.getString(_cursorIndexOfUrl);
        _item.setUrl(_tmpUrl);
        final String _tmpDescription;
        _tmpDescription = _cursor.getString(_cursorIndexOfDescription);
        _item.setDescription(_tmpDescription);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }
}
