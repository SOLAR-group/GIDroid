package be.digitalia.fosdem.db;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.room.util.StringUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import be.digitalia.fosdem.db.converters.GlobalTypeConverters;
import be.digitalia.fosdem.db.converters.NonNullDateTypeConverters;
import be.digitalia.fosdem.db.converters.NullableDateTypeConverters;
import be.digitalia.fosdem.db.entities.Bookmark;
import be.digitalia.fosdem.model.AlarmInfo;
import be.digitalia.fosdem.model.Day;
import be.digitalia.fosdem.model.Event;
import be.digitalia.fosdem.model.Track;
import java.lang.Boolean;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class BookmarksDao_Impl extends BookmarksDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Bookmark> __insertionAdapterOfBookmark;

  public BookmarksDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfBookmark = new EntityInsertionAdapter<Bookmark>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR IGNORE INTO `bookmarks` (`event_id`) VALUES (?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Bookmark value) {
        stmt.bindLong(1, value.getEventId());
      }
    };
  }

  @Override
  protected long addBookmarkInternal(final Bookmark bookmark) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      long _result = __insertionAdapterOfBookmark.insertAndReturnId(bookmark);
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Event>> getBookmarks(final long minStartTime) {
    final String _sql = "SELECT e.id, e.start_time, e.end_time, e.room_name, e.slug, et.title, et.subtitle, e.abstract, e.description, GROUP_CONCAT(p.name, ', ') AS persons, e.day_index, d.date AS day_date, e.track_id, t.name AS track_name, t.type AS track_type FROM bookmarks b JOIN events e ON b.event_id = e.id JOIN events_titles et ON e.id = et.`rowid` JOIN days d ON e.day_index = d.`index` JOIN tracks t ON e.track_id = t.id LEFT JOIN events_persons ep ON e.id = ep.event_id LEFT JOIN persons p ON ep.person_id = p.`rowid` WHERE e.start_time > ? GROUP BY e.id ORDER BY e.start_time ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, minStartTime);
    return __db.getInvalidationTracker().createLiveData(new String[]{"bookmarks","events","events_titles","days","tracks","events_persons","persons"}, false, new Callable<List<Event>>() {
      @Override
      public List<Event> call() throws Exception {
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
            _item = new Event();
            final long _tmpId_1;
            _tmpId_1 = _cursor.getLong(_cursorIndexOfId);
            _item.setId(_tmpId_1);
            final Date _tmpStartTime;
            final Long _tmp_2;
            if (_cursor.isNull(_cursorIndexOfStartTime)) {
              _tmp_2 = null;
            } else {
              _tmp_2 = _cursor.getLong(_cursorIndexOfStartTime);
            }
            _tmpStartTime = NullableDateTypeConverters.toDate(_tmp_2);
            _item.setStartTime(_tmpStartTime);
            final Date _tmpEndTime;
            final Long _tmp_3;
            if (_cursor.isNull(_cursorIndexOfEndTime)) {
              _tmp_3 = null;
            } else {
              _tmp_3 = _cursor.getLong(_cursorIndexOfEndTime);
            }
            _tmpEndTime = NullableDateTypeConverters.toDate(_tmp_3);
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
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public Event[] getBookmarks() {
    final String _sql = "SELECT e.id, e.start_time, e.end_time, e.room_name, e.slug, et.title, et.subtitle, e.abstract, e.description, GROUP_CONCAT(p.name, ', ') AS persons, e.day_index, d.date AS day_date, e.track_id, t.name AS track_name, t.type AS track_type FROM bookmarks b JOIN events e ON b.event_id = e.id JOIN events_titles et ON e.id = et.`rowid` JOIN days d ON e.day_index = d.`index` JOIN tracks t ON e.track_id = t.id LEFT JOIN events_persons ep ON e.id = ep.event_id LEFT JOIN persons p ON ep.person_id = p.`rowid` GROUP BY e.id ORDER BY e.start_time ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
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
      final Event[] _result = new Event[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final Event _item;
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
        _item = new Event();
        final long _tmpId_1;
        _tmpId_1 = _cursor.getLong(_cursorIndexOfId);
        _item.setId(_tmpId_1);
        final Date _tmpStartTime;
        final Long _tmp_2;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp_2 = null;
        } else {
          _tmp_2 = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = NullableDateTypeConverters.toDate(_tmp_2);
        _item.setStartTime(_tmpStartTime);
        final Date _tmpEndTime;
        final Long _tmp_3;
        if (_cursor.isNull(_cursorIndexOfEndTime)) {
          _tmp_3 = null;
        } else {
          _tmp_3 = _cursor.getLong(_cursorIndexOfEndTime);
        }
        _tmpEndTime = NullableDateTypeConverters.toDate(_tmp_3);
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
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public AlarmInfo[] getBookmarksAlarmInfo(final long minStartTime) {
    final String _sql = "SELECT b.event_id, e.start_time FROM bookmarks b JOIN events e ON b.event_id = e.id WHERE e.start_time > ? ORDER BY e.start_time ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, minStartTime);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfEventId = CursorUtil.getColumnIndexOrThrow(_cursor, "event_id");
      final int _cursorIndexOfStartTime = CursorUtil.getColumnIndexOrThrow(_cursor, "start_time");
      final AlarmInfo[] _result = new AlarmInfo[_cursor.getCount()];
      int _index = 0;
      while(_cursor.moveToNext()) {
        final AlarmInfo _item;
        final long _tmpEventId;
        _tmpEventId = _cursor.getLong(_cursorIndexOfEventId);
        final Date _tmpStartTime;
        final Long _tmp;
        if (_cursor.isNull(_cursorIndexOfStartTime)) {
          _tmp = null;
        } else {
          _tmp = _cursor.getLong(_cursorIndexOfStartTime);
        }
        _tmpStartTime = NullableDateTypeConverters.toDate(_tmp);
        _item = new AlarmInfo(_tmpEventId,_tmpStartTime);
        _result[_index] = _item;
        _index ++;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public LiveData<Boolean> getBookmarkStatus(final Event event) {
    final String _sql = "SELECT COUNT(*) FROM bookmarks WHERE event_id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    final long _tmp;
    _tmp = GlobalTypeConverters.fromEvent(event);
    _statement.bindLong(_argIndex, _tmp);
    return __db.getInvalidationTracker().createLiveData(new String[]{"bookmarks"}, false, new Callable<Boolean>() {
      @Override
      public Boolean call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final Boolean _result;
          if(_cursor.moveToFirst()) {
            final Integer _tmp_1;
            if (_cursor.isNull(0)) {
              _tmp_1 = null;
            } else {
              _tmp_1 = _cursor.getInt(0);
            }
            _result = _tmp_1 == null ? null : _tmp_1 != 0;
          } else {
            _result = null;
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
  protected int removeBookmarksInternal(final long[] eventIds) {
    __db.assertNotSuspendingTransaction();
    StringBuilder _stringBuilder = StringUtil.newStringBuilder();
    _stringBuilder.append("DELETE FROM bookmarks WHERE event_id IN (");
    final int _inputSize = eventIds.length;
    StringUtil.appendPlaceholders(_stringBuilder, _inputSize);
    _stringBuilder.append(")");
    final String _sql = _stringBuilder.toString();
    final SupportSQLiteStatement _stmt = __db.compileStatement(_sql);
    int _argIndex = 1;
    for (long _item : eventIds) {
      _stmt.bindLong(_argIndex, _item);
      _argIndex ++;
    }
    __db.beginTransaction();
    try {
      final int _result = _stmt.executeUpdateDelete();
      __db.setTransactionSuccessful();
      return _result;
    } finally {
      __db.endTransaction();
    }
  }
}
