package be.digitalia.fosdem.db;

import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomOpenHelper;
import androidx.room.RoomOpenHelper.Delegate;
import androidx.room.RoomOpenHelper.ValidationResult;
import androidx.room.util.DBUtil;
import androidx.room.util.FtsTableInfo;
import androidx.room.util.TableInfo;
import androidx.room.util.TableInfo.Column;
import androidx.room.util.TableInfo.ForeignKey;
import androidx.room.util.TableInfo.Index;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Callback;
import androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AppDatabase_Impl extends AppDatabase {
  private volatile ScheduleDao _scheduleDao;

  private volatile BookmarksDao _bookmarksDao;

  @Override
  protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration configuration) {
    final SupportSQLiteOpenHelper.Callback _openCallback = new RoomOpenHelper(configuration, new RoomOpenHelper.Delegate(2) {
      @Override
      public void createAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("CREATE TABLE IF NOT EXISTS `events` (`id` INTEGER NOT NULL, `day_index` INTEGER NOT NULL, `start_time` INTEGER, `end_time` INTEGER, `room_name` TEXT, `slug` TEXT, `track_id` INTEGER NOT NULL, `abstract` TEXT, `description` TEXT, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `event_day_index_idx` ON `events` (`day_index`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `event_start_time_idx` ON `events` (`start_time`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `event_end_time_idx` ON `events` (`end_time`)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `event_track_id_idx` ON `events` (`track_id`)");
        _db.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS `events_titles` USING FTS3(`title` TEXT, `subtitle` TEXT)");
        _db.execSQL("CREATE VIRTUAL TABLE IF NOT EXISTS `persons` USING FTS3(`name` TEXT)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `events_persons` (`event_id` INTEGER NOT NULL, `person_id` INTEGER NOT NULL, PRIMARY KEY(`event_id`, `person_id`))");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `event_person_person_id_idx` ON `events_persons` (`person_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `links` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `event_id` INTEGER NOT NULL, `url` TEXT NOT NULL, `description` TEXT)");
        _db.execSQL("CREATE INDEX IF NOT EXISTS `link_event_id_idx` ON `links` (`event_id`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `tracks` (`id` INTEGER NOT NULL, `name` TEXT NOT NULL, `type` TEXT NOT NULL, PRIMARY KEY(`id`))");
        _db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS `track_main_idx` ON `tracks` (`name`, `type`)");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `days` (`index` INTEGER NOT NULL, `date` INTEGER NOT NULL, PRIMARY KEY(`index`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS `bookmarks` (`event_id` INTEGER NOT NULL, PRIMARY KEY(`event_id`))");
        _db.execSQL("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
        _db.execSQL("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '5f8a7ef854ce48e5560eb86434957998')");
      }

      @Override
      public void dropAllTables(SupportSQLiteDatabase _db) {
        _db.execSQL("DROP TABLE IF EXISTS `events`");
        _db.execSQL("DROP TABLE IF EXISTS `events_titles`");
        _db.execSQL("DROP TABLE IF EXISTS `persons`");
        _db.execSQL("DROP TABLE IF EXISTS `events_persons`");
        _db.execSQL("DROP TABLE IF EXISTS `links`");
        _db.execSQL("DROP TABLE IF EXISTS `tracks`");
        _db.execSQL("DROP TABLE IF EXISTS `days`");
        _db.execSQL("DROP TABLE IF EXISTS `bookmarks`");
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onDestructiveMigration(_db);
          }
        }
      }

      @Override
      protected void onCreate(SupportSQLiteDatabase _db) {
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onCreate(_db);
          }
        }
      }

      @Override
      public void onOpen(SupportSQLiteDatabase _db) {
        mDatabase = _db;
        internalInitInvalidationTracker(_db);
        if (mCallbacks != null) {
          for (int _i = 0, _size = mCallbacks.size(); _i < _size; _i++) {
            mCallbacks.get(_i).onOpen(_db);
          }
        }
      }

      @Override
      public void onPreMigrate(SupportSQLiteDatabase _db) {
        DBUtil.dropFtsSyncTriggers(_db);
      }

      @Override
      public void onPostMigrate(SupportSQLiteDatabase _db) {
      }

      @Override
      protected RoomOpenHelper.ValidationResult onValidateSchema(SupportSQLiteDatabase _db) {
        final HashMap<String, TableInfo.Column> _columnsEvents = new HashMap<String, TableInfo.Column>(9);
        _columnsEvents.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("day_index", new TableInfo.Column("day_index", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("start_time", new TableInfo.Column("start_time", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("end_time", new TableInfo.Column("end_time", "INTEGER", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("room_name", new TableInfo.Column("room_name", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("slug", new TableInfo.Column("slug", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("track_id", new TableInfo.Column("track_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("abstract", new TableInfo.Column("abstract", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEvents.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEvents = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEvents = new HashSet<TableInfo.Index>(4);
        _indicesEvents.add(new TableInfo.Index("event_day_index_idx", false, Arrays.asList("day_index")));
        _indicesEvents.add(new TableInfo.Index("event_start_time_idx", false, Arrays.asList("start_time")));
        _indicesEvents.add(new TableInfo.Index("event_end_time_idx", false, Arrays.asList("end_time")));
        _indicesEvents.add(new TableInfo.Index("event_track_id_idx", false, Arrays.asList("track_id")));
        final TableInfo _infoEvents = new TableInfo("events", _columnsEvents, _foreignKeysEvents, _indicesEvents);
        final TableInfo _existingEvents = TableInfo.read(_db, "events");
        if (! _infoEvents.equals(_existingEvents)) {
          return new RoomOpenHelper.ValidationResult(false, "events(be.digitalia.fosdem.db.entities.EventEntity).\n"
                  + " Expected:\n" + _infoEvents + "\n"
                  + " Found:\n" + _existingEvents);
        }
        final HashSet<String> _columnsEventsTitles = new HashSet<String>(3);
        _columnsEventsTitles.add("title");
        _columnsEventsTitles.add("subtitle");
        final FtsTableInfo _infoEventsTitles = new FtsTableInfo("events_titles", _columnsEventsTitles, "CREATE VIRTUAL TABLE IF NOT EXISTS `events_titles` USING FTS3(`title` TEXT, `subtitle` TEXT)");
        final FtsTableInfo _existingEventsTitles = FtsTableInfo.read(_db, "events_titles");
        if (!_infoEventsTitles.equals(_existingEventsTitles)) {
          return new RoomOpenHelper.ValidationResult(false, "events_titles(be.digitalia.fosdem.db.entities.EventTitles).\n"
                  + " Expected:\n" + _infoEventsTitles + "\n"
                  + " Found:\n" + _existingEventsTitles);
        }
        final HashSet<String> _columnsPersons = new HashSet<String>(2);
        _columnsPersons.add("name");
        final FtsTableInfo _infoPersons = new FtsTableInfo("persons", _columnsPersons, "CREATE VIRTUAL TABLE IF NOT EXISTS `persons` USING FTS3(`name` TEXT)");
        final FtsTableInfo _existingPersons = FtsTableInfo.read(_db, "persons");
        if (!_infoPersons.equals(_existingPersons)) {
          return new RoomOpenHelper.ValidationResult(false, "persons(be.digitalia.fosdem.model.Person).\n"
                  + " Expected:\n" + _infoPersons + "\n"
                  + " Found:\n" + _existingPersons);
        }
        final HashMap<String, TableInfo.Column> _columnsEventsPersons = new HashMap<String, TableInfo.Column>(2);
        _columnsEventsPersons.put("event_id", new TableInfo.Column("event_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsEventsPersons.put("person_id", new TableInfo.Column("person_id", "INTEGER", true, 2, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysEventsPersons = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesEventsPersons = new HashSet<TableInfo.Index>(1);
        _indicesEventsPersons.add(new TableInfo.Index("event_person_person_id_idx", false, Arrays.asList("person_id")));
        final TableInfo _infoEventsPersons = new TableInfo("events_persons", _columnsEventsPersons, _foreignKeysEventsPersons, _indicesEventsPersons);
        final TableInfo _existingEventsPersons = TableInfo.read(_db, "events_persons");
        if (! _infoEventsPersons.equals(_existingEventsPersons)) {
          return new RoomOpenHelper.ValidationResult(false, "events_persons(be.digitalia.fosdem.db.entities.EventToPerson).\n"
                  + " Expected:\n" + _infoEventsPersons + "\n"
                  + " Found:\n" + _existingEventsPersons);
        }
        final HashMap<String, TableInfo.Column> _columnsLinks = new HashMap<String, TableInfo.Column>(4);
        _columnsLinks.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLinks.put("event_id", new TableInfo.Column("event_id", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLinks.put("url", new TableInfo.Column("url", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsLinks.put("description", new TableInfo.Column("description", "TEXT", false, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysLinks = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesLinks = new HashSet<TableInfo.Index>(1);
        _indicesLinks.add(new TableInfo.Index("link_event_id_idx", false, Arrays.asList("event_id")));
        final TableInfo _infoLinks = new TableInfo("links", _columnsLinks, _foreignKeysLinks, _indicesLinks);
        final TableInfo _existingLinks = TableInfo.read(_db, "links");
        if (! _infoLinks.equals(_existingLinks)) {
          return new RoomOpenHelper.ValidationResult(false, "links(be.digitalia.fosdem.model.Link).\n"
                  + " Expected:\n" + _infoLinks + "\n"
                  + " Found:\n" + _existingLinks);
        }
        final HashMap<String, TableInfo.Column> _columnsTracks = new HashMap<String, TableInfo.Column>(3);
        _columnsTracks.put("id", new TableInfo.Column("id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("name", new TableInfo.Column("name", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsTracks.put("type", new TableInfo.Column("type", "TEXT", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysTracks = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesTracks = new HashSet<TableInfo.Index>(1);
        _indicesTracks.add(new TableInfo.Index("track_main_idx", true, Arrays.asList("name","type")));
        final TableInfo _infoTracks = new TableInfo("tracks", _columnsTracks, _foreignKeysTracks, _indicesTracks);
        final TableInfo _existingTracks = TableInfo.read(_db, "tracks");
        if (! _infoTracks.equals(_existingTracks)) {
          return new RoomOpenHelper.ValidationResult(false, "tracks(be.digitalia.fosdem.model.Track).\n"
                  + " Expected:\n" + _infoTracks + "\n"
                  + " Found:\n" + _existingTracks);
        }
        final HashMap<String, TableInfo.Column> _columnsDays = new HashMap<String, TableInfo.Column>(2);
        _columnsDays.put("index", new TableInfo.Column("index", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        _columnsDays.put("date", new TableInfo.Column("date", "INTEGER", true, 0, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysDays = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesDays = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoDays = new TableInfo("days", _columnsDays, _foreignKeysDays, _indicesDays);
        final TableInfo _existingDays = TableInfo.read(_db, "days");
        if (! _infoDays.equals(_existingDays)) {
          return new RoomOpenHelper.ValidationResult(false, "days(be.digitalia.fosdem.model.Day).\n"
                  + " Expected:\n" + _infoDays + "\n"
                  + " Found:\n" + _existingDays);
        }
        final HashMap<String, TableInfo.Column> _columnsBookmarks = new HashMap<String, TableInfo.Column>(1);
        _columnsBookmarks.put("event_id", new TableInfo.Column("event_id", "INTEGER", true, 1, null, TableInfo.CREATED_FROM_ENTITY));
        final HashSet<TableInfo.ForeignKey> _foreignKeysBookmarks = new HashSet<TableInfo.ForeignKey>(0);
        final HashSet<TableInfo.Index> _indicesBookmarks = new HashSet<TableInfo.Index>(0);
        final TableInfo _infoBookmarks = new TableInfo("bookmarks", _columnsBookmarks, _foreignKeysBookmarks, _indicesBookmarks);
        final TableInfo _existingBookmarks = TableInfo.read(_db, "bookmarks");
        if (! _infoBookmarks.equals(_existingBookmarks)) {
          return new RoomOpenHelper.ValidationResult(false, "bookmarks(be.digitalia.fosdem.db.entities.Bookmark).\n"
                  + " Expected:\n" + _infoBookmarks + "\n"
                  + " Found:\n" + _existingBookmarks);
        }
        return new RoomOpenHelper.ValidationResult(true, null);
      }
    }, "5f8a7ef854ce48e5560eb86434957998", "544b068bc5d49c32cc732082ee3661a0");
    final SupportSQLiteOpenHelper.Configuration _sqliteConfig = SupportSQLiteOpenHelper.Configuration.builder(configuration.context)
        .name(configuration.name)
        .callback(_openCallback)
        .build();
    final SupportSQLiteOpenHelper _helper = configuration.sqliteOpenHelperFactory.create(_sqliteConfig);
    return _helper;
  }

  @Override
  protected InvalidationTracker createInvalidationTracker() {
    final HashMap<String, String> _shadowTablesMap = new HashMap<String, String>(2);
    _shadowTablesMap.put("events_titles", "events_titles_content");
    _shadowTablesMap.put("persons", "persons_content");
    HashMap<String, Set<String>> _viewTables = new HashMap<String, Set<String>>(0);
    return new InvalidationTracker(this, _shadowTablesMap, _viewTables, "events","events_titles","persons","events_persons","links","tracks","days","bookmarks");
  }

  @Override
  public void clearAllTables() {
    super.assertNotMainThread();
    final SupportSQLiteDatabase _db = super.getOpenHelper().getWritableDatabase();
    try {
      super.beginTransaction();
      _db.execSQL("DELETE FROM `events`");
      _db.execSQL("DELETE FROM `events_titles`");
      _db.execSQL("DELETE FROM `persons`");
      _db.execSQL("DELETE FROM `events_persons`");
      _db.execSQL("DELETE FROM `links`");
      _db.execSQL("DELETE FROM `tracks`");
      _db.execSQL("DELETE FROM `days`");
      _db.execSQL("DELETE FROM `bookmarks`");
      super.setTransactionSuccessful();
    } finally {
      super.endTransaction();
      _db.query("PRAGMA wal_checkpoint(FULL)").close();
      if (!_db.inTransaction()) {
        _db.execSQL("VACUUM");
      }
    }
  }

  @Override
  public ScheduleDao getScheduleDao() {
    if (_scheduleDao != null) {
      return _scheduleDao;
    } else {
      synchronized(this) {
        if(_scheduleDao == null) {
          _scheduleDao = new ScheduleDao_Impl(this);
        }
        return _scheduleDao;
      }
    }
  }

  @Override
  public BookmarksDao getBookmarksDao() {
    if (_bookmarksDao != null) {
      return _bookmarksDao;
    } else {
      synchronized(this) {
        if(_bookmarksDao == null) {
          _bookmarksDao = new BookmarksDao_Impl(this);
        }
        return _bookmarksDao;
      }
    }
  }
}
