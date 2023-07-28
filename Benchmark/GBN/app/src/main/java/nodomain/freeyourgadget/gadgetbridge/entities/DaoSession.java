package nodomain.freeyourgadget.gadgetbridge.entities;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import nodomain.freeyourgadget.gadgetbridge.entities.UserAttributes;
import nodomain.freeyourgadget.gadgetbridge.entities.User;
import nodomain.freeyourgadget.gadgetbridge.entities.DeviceAttributes;
import nodomain.freeyourgadget.gadgetbridge.entities.Device;
import nodomain.freeyourgadget.gadgetbridge.entities.Tag;
import nodomain.freeyourgadget.gadgetbridge.entities.ActivityDescription;
import nodomain.freeyourgadget.gadgetbridge.entities.ActivityDescTagLink;
import nodomain.freeyourgadget.gadgetbridge.entities.MakibesHR3ActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.MiBandActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleHealthActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleHealthActivityOverlay;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleMisfitSample;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleMorpheuzSample;
import nodomain.freeyourgadget.gadgetbridge.entities.HPlusHealthActivityOverlay;
import nodomain.freeyourgadget.gadgetbridge.entities.HPlusHealthActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.No1F1ActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.XWatchActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.ZeTimeActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.ID115ActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.JYouActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.WatchXPlusActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.WatchXPlusHealthActivityOverlay;
import nodomain.freeyourgadget.gadgetbridge.entities.TLW64ActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.LefunActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.LefunBiometricSample;
import nodomain.freeyourgadget.gadgetbridge.entities.LefunSleepSample;
import nodomain.freeyourgadget.gadgetbridge.entities.SonySWR12Sample;
import nodomain.freeyourgadget.gadgetbridge.entities.BangleJSActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.CasioGBX100ActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.FitProActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.PineTimeActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.HybridHRActivitySample;
import nodomain.freeyourgadget.gadgetbridge.entities.CalendarSyncState;
import nodomain.freeyourgadget.gadgetbridge.entities.Alarm;
import nodomain.freeyourgadget.gadgetbridge.entities.Reminder;
import nodomain.freeyourgadget.gadgetbridge.entities.WorldClock;
import nodomain.freeyourgadget.gadgetbridge.entities.NotificationFilter;
import nodomain.freeyourgadget.gadgetbridge.entities.NotificationFilterEntry;
import nodomain.freeyourgadget.gadgetbridge.entities.BaseActivitySummary;
import nodomain.freeyourgadget.gadgetbridge.entities.BatteryLevel;

import nodomain.freeyourgadget.gadgetbridge.entities.UserAttributesDao;
import nodomain.freeyourgadget.gadgetbridge.entities.UserDao;
import nodomain.freeyourgadget.gadgetbridge.entities.DeviceAttributesDao;
import nodomain.freeyourgadget.gadgetbridge.entities.DeviceDao;
import nodomain.freeyourgadget.gadgetbridge.entities.TagDao;
import nodomain.freeyourgadget.gadgetbridge.entities.ActivityDescriptionDao;
import nodomain.freeyourgadget.gadgetbridge.entities.ActivityDescTagLinkDao;
import nodomain.freeyourgadget.gadgetbridge.entities.MakibesHR3ActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.MiBandActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleHealthActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleHealthActivityOverlayDao;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleMisfitSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.PebbleMorpheuzSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HPlusHealthActivityOverlayDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HPlusHealthActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.No1F1ActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.XWatchActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.ZeTimeActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.ID115ActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.JYouActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.WatchXPlusActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.WatchXPlusHealthActivityOverlayDao;
import nodomain.freeyourgadget.gadgetbridge.entities.TLW64ActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.LefunActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.LefunBiometricSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.LefunSleepSampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.SonySWR12SampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.BangleJSActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.CasioGBX100ActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.FitProActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.PineTimeActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.HybridHRActivitySampleDao;
import nodomain.freeyourgadget.gadgetbridge.entities.CalendarSyncStateDao;
import nodomain.freeyourgadget.gadgetbridge.entities.AlarmDao;
import nodomain.freeyourgadget.gadgetbridge.entities.ReminderDao;
import nodomain.freeyourgadget.gadgetbridge.entities.WorldClockDao;
import nodomain.freeyourgadget.gadgetbridge.entities.NotificationFilterDao;
import nodomain.freeyourgadget.gadgetbridge.entities.NotificationFilterEntryDao;
import nodomain.freeyourgadget.gadgetbridge.entities.BaseActivitySummaryDao;
import nodomain.freeyourgadget.gadgetbridge.entities.BatteryLevelDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig userAttributesDaoConfig;
    private final DaoConfig userDaoConfig;
    private final DaoConfig deviceAttributesDaoConfig;
    private final DaoConfig deviceDaoConfig;
    private final DaoConfig tagDaoConfig;
    private final DaoConfig activityDescriptionDaoConfig;
    private final DaoConfig activityDescTagLinkDaoConfig;
    private final DaoConfig makibesHR3ActivitySampleDaoConfig;
    private final DaoConfig miBandActivitySampleDaoConfig;
    private final DaoConfig pebbleHealthActivitySampleDaoConfig;
    private final DaoConfig pebbleHealthActivityOverlayDaoConfig;
    private final DaoConfig pebbleMisfitSampleDaoConfig;
    private final DaoConfig pebbleMorpheuzSampleDaoConfig;
    private final DaoConfig hPlusHealthActivityOverlayDaoConfig;
    private final DaoConfig hPlusHealthActivitySampleDaoConfig;
    private final DaoConfig no1F1ActivitySampleDaoConfig;
    private final DaoConfig xWatchActivitySampleDaoConfig;
    private final DaoConfig zeTimeActivitySampleDaoConfig;
    private final DaoConfig iD115ActivitySampleDaoConfig;
    private final DaoConfig jYouActivitySampleDaoConfig;
    private final DaoConfig watchXPlusActivitySampleDaoConfig;
    private final DaoConfig watchXPlusHealthActivityOverlayDaoConfig;
    private final DaoConfig tLW64ActivitySampleDaoConfig;
    private final DaoConfig lefunActivitySampleDaoConfig;
    private final DaoConfig lefunBiometricSampleDaoConfig;
    private final DaoConfig lefunSleepSampleDaoConfig;
    private final DaoConfig sonySWR12SampleDaoConfig;
    private final DaoConfig bangleJSActivitySampleDaoConfig;
    private final DaoConfig casioGBX100ActivitySampleDaoConfig;
    private final DaoConfig fitProActivitySampleDaoConfig;
    private final DaoConfig pineTimeActivitySampleDaoConfig;
    private final DaoConfig hybridHRActivitySampleDaoConfig;
    private final DaoConfig calendarSyncStateDaoConfig;
    private final DaoConfig alarmDaoConfig;
    private final DaoConfig reminderDaoConfig;
    private final DaoConfig worldClockDaoConfig;
    private final DaoConfig notificationFilterDaoConfig;
    private final DaoConfig notificationFilterEntryDaoConfig;
    private final DaoConfig baseActivitySummaryDaoConfig;
    private final DaoConfig batteryLevelDaoConfig;

    private final UserAttributesDao userAttributesDao;
    private final UserDao userDao;
    private final DeviceAttributesDao deviceAttributesDao;
    private final DeviceDao deviceDao;
    private final TagDao tagDao;
    private final ActivityDescriptionDao activityDescriptionDao;
    private final ActivityDescTagLinkDao activityDescTagLinkDao;
    private final MakibesHR3ActivitySampleDao makibesHR3ActivitySampleDao;
    private final MiBandActivitySampleDao miBandActivitySampleDao;
    private final PebbleHealthActivitySampleDao pebbleHealthActivitySampleDao;
    private final PebbleHealthActivityOverlayDao pebbleHealthActivityOverlayDao;
    private final PebbleMisfitSampleDao pebbleMisfitSampleDao;
    private final PebbleMorpheuzSampleDao pebbleMorpheuzSampleDao;
    private final HPlusHealthActivityOverlayDao hPlusHealthActivityOverlayDao;
    private final HPlusHealthActivitySampleDao hPlusHealthActivitySampleDao;
    private final No1F1ActivitySampleDao no1F1ActivitySampleDao;
    private final XWatchActivitySampleDao xWatchActivitySampleDao;
    private final ZeTimeActivitySampleDao zeTimeActivitySampleDao;
    private final ID115ActivitySampleDao iD115ActivitySampleDao;
    private final JYouActivitySampleDao jYouActivitySampleDao;
    private final WatchXPlusActivitySampleDao watchXPlusActivitySampleDao;
    private final WatchXPlusHealthActivityOverlayDao watchXPlusHealthActivityOverlayDao;
    private final TLW64ActivitySampleDao tLW64ActivitySampleDao;
    private final LefunActivitySampleDao lefunActivitySampleDao;
    private final LefunBiometricSampleDao lefunBiometricSampleDao;
    private final LefunSleepSampleDao lefunSleepSampleDao;
    private final SonySWR12SampleDao sonySWR12SampleDao;
    private final BangleJSActivitySampleDao bangleJSActivitySampleDao;
    private final CasioGBX100ActivitySampleDao casioGBX100ActivitySampleDao;
    private final FitProActivitySampleDao fitProActivitySampleDao;
    private final PineTimeActivitySampleDao pineTimeActivitySampleDao;
    private final HybridHRActivitySampleDao hybridHRActivitySampleDao;
    private final CalendarSyncStateDao calendarSyncStateDao;
    private final AlarmDao alarmDao;
    private final ReminderDao reminderDao;
    private final WorldClockDao worldClockDao;
    private final NotificationFilterDao notificationFilterDao;
    private final NotificationFilterEntryDao notificationFilterEntryDao;
    private final BaseActivitySummaryDao baseActivitySummaryDao;
    private final BatteryLevelDao batteryLevelDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        userAttributesDaoConfig = daoConfigMap.get(UserAttributesDao.class).clone();
        userAttributesDaoConfig.initIdentityScope(type);

        userDaoConfig = daoConfigMap.get(UserDao.class).clone();
        userDaoConfig.initIdentityScope(type);

        deviceAttributesDaoConfig = daoConfigMap.get(DeviceAttributesDao.class).clone();
        deviceAttributesDaoConfig.initIdentityScope(type);

        deviceDaoConfig = daoConfigMap.get(DeviceDao.class).clone();
        deviceDaoConfig.initIdentityScope(type);

        tagDaoConfig = daoConfigMap.get(TagDao.class).clone();
        tagDaoConfig.initIdentityScope(type);

        activityDescriptionDaoConfig = daoConfigMap.get(ActivityDescriptionDao.class).clone();
        activityDescriptionDaoConfig.initIdentityScope(type);

        activityDescTagLinkDaoConfig = daoConfigMap.get(ActivityDescTagLinkDao.class).clone();
        activityDescTagLinkDaoConfig.initIdentityScope(type);

        makibesHR3ActivitySampleDaoConfig = daoConfigMap.get(MakibesHR3ActivitySampleDao.class).clone();
        makibesHR3ActivitySampleDaoConfig.initIdentityScope(type);

        miBandActivitySampleDaoConfig = daoConfigMap.get(MiBandActivitySampleDao.class).clone();
        miBandActivitySampleDaoConfig.initIdentityScope(type);

        pebbleHealthActivitySampleDaoConfig = daoConfigMap.get(PebbleHealthActivitySampleDao.class).clone();
        pebbleHealthActivitySampleDaoConfig.initIdentityScope(type);

        pebbleHealthActivityOverlayDaoConfig = daoConfigMap.get(PebbleHealthActivityOverlayDao.class).clone();
        pebbleHealthActivityOverlayDaoConfig.initIdentityScope(type);

        pebbleMisfitSampleDaoConfig = daoConfigMap.get(PebbleMisfitSampleDao.class).clone();
        pebbleMisfitSampleDaoConfig.initIdentityScope(type);

        pebbleMorpheuzSampleDaoConfig = daoConfigMap.get(PebbleMorpheuzSampleDao.class).clone();
        pebbleMorpheuzSampleDaoConfig.initIdentityScope(type);

        hPlusHealthActivityOverlayDaoConfig = daoConfigMap.get(HPlusHealthActivityOverlayDao.class).clone();
        hPlusHealthActivityOverlayDaoConfig.initIdentityScope(type);

        hPlusHealthActivitySampleDaoConfig = daoConfigMap.get(HPlusHealthActivitySampleDao.class).clone();
        hPlusHealthActivitySampleDaoConfig.initIdentityScope(type);

        no1F1ActivitySampleDaoConfig = daoConfigMap.get(No1F1ActivitySampleDao.class).clone();
        no1F1ActivitySampleDaoConfig.initIdentityScope(type);

        xWatchActivitySampleDaoConfig = daoConfigMap.get(XWatchActivitySampleDao.class).clone();
        xWatchActivitySampleDaoConfig.initIdentityScope(type);

        zeTimeActivitySampleDaoConfig = daoConfigMap.get(ZeTimeActivitySampleDao.class).clone();
        zeTimeActivitySampleDaoConfig.initIdentityScope(type);

        iD115ActivitySampleDaoConfig = daoConfigMap.get(ID115ActivitySampleDao.class).clone();
        iD115ActivitySampleDaoConfig.initIdentityScope(type);

        jYouActivitySampleDaoConfig = daoConfigMap.get(JYouActivitySampleDao.class).clone();
        jYouActivitySampleDaoConfig.initIdentityScope(type);

        watchXPlusActivitySampleDaoConfig = daoConfigMap.get(WatchXPlusActivitySampleDao.class).clone();
        watchXPlusActivitySampleDaoConfig.initIdentityScope(type);

        watchXPlusHealthActivityOverlayDaoConfig = daoConfigMap.get(WatchXPlusHealthActivityOverlayDao.class).clone();
        watchXPlusHealthActivityOverlayDaoConfig.initIdentityScope(type);

        tLW64ActivitySampleDaoConfig = daoConfigMap.get(TLW64ActivitySampleDao.class).clone();
        tLW64ActivitySampleDaoConfig.initIdentityScope(type);

        lefunActivitySampleDaoConfig = daoConfigMap.get(LefunActivitySampleDao.class).clone();
        lefunActivitySampleDaoConfig.initIdentityScope(type);

        lefunBiometricSampleDaoConfig = daoConfigMap.get(LefunBiometricSampleDao.class).clone();
        lefunBiometricSampleDaoConfig.initIdentityScope(type);

        lefunSleepSampleDaoConfig = daoConfigMap.get(LefunSleepSampleDao.class).clone();
        lefunSleepSampleDaoConfig.initIdentityScope(type);

        sonySWR12SampleDaoConfig = daoConfigMap.get(SonySWR12SampleDao.class).clone();
        sonySWR12SampleDaoConfig.initIdentityScope(type);

        bangleJSActivitySampleDaoConfig = daoConfigMap.get(BangleJSActivitySampleDao.class).clone();
        bangleJSActivitySampleDaoConfig.initIdentityScope(type);

        casioGBX100ActivitySampleDaoConfig = daoConfigMap.get(CasioGBX100ActivitySampleDao.class).clone();
        casioGBX100ActivitySampleDaoConfig.initIdentityScope(type);

        fitProActivitySampleDaoConfig = daoConfigMap.get(FitProActivitySampleDao.class).clone();
        fitProActivitySampleDaoConfig.initIdentityScope(type);

        pineTimeActivitySampleDaoConfig = daoConfigMap.get(PineTimeActivitySampleDao.class).clone();
        pineTimeActivitySampleDaoConfig.initIdentityScope(type);

        hybridHRActivitySampleDaoConfig = daoConfigMap.get(HybridHRActivitySampleDao.class).clone();
        hybridHRActivitySampleDaoConfig.initIdentityScope(type);

        calendarSyncStateDaoConfig = daoConfigMap.get(CalendarSyncStateDao.class).clone();
        calendarSyncStateDaoConfig.initIdentityScope(type);

        alarmDaoConfig = daoConfigMap.get(AlarmDao.class).clone();
        alarmDaoConfig.initIdentityScope(type);

        reminderDaoConfig = daoConfigMap.get(ReminderDao.class).clone();
        reminderDaoConfig.initIdentityScope(type);

        worldClockDaoConfig = daoConfigMap.get(WorldClockDao.class).clone();
        worldClockDaoConfig.initIdentityScope(type);

        notificationFilterDaoConfig = daoConfigMap.get(NotificationFilterDao.class).clone();
        notificationFilterDaoConfig.initIdentityScope(type);

        notificationFilterEntryDaoConfig = daoConfigMap.get(NotificationFilterEntryDao.class).clone();
        notificationFilterEntryDaoConfig.initIdentityScope(type);

        baseActivitySummaryDaoConfig = daoConfigMap.get(BaseActivitySummaryDao.class).clone();
        baseActivitySummaryDaoConfig.initIdentityScope(type);

        batteryLevelDaoConfig = daoConfigMap.get(BatteryLevelDao.class).clone();
        batteryLevelDaoConfig.initIdentityScope(type);

        userAttributesDao = new UserAttributesDao(userAttributesDaoConfig, this);
        userDao = new UserDao(userDaoConfig, this);
        deviceAttributesDao = new DeviceAttributesDao(deviceAttributesDaoConfig, this);
        deviceDao = new DeviceDao(deviceDaoConfig, this);
        tagDao = new TagDao(tagDaoConfig, this);
        activityDescriptionDao = new ActivityDescriptionDao(activityDescriptionDaoConfig, this);
        activityDescTagLinkDao = new ActivityDescTagLinkDao(activityDescTagLinkDaoConfig, this);
        makibesHR3ActivitySampleDao = new MakibesHR3ActivitySampleDao(makibesHR3ActivitySampleDaoConfig, this);
        miBandActivitySampleDao = new MiBandActivitySampleDao(miBandActivitySampleDaoConfig, this);
        pebbleHealthActivitySampleDao = new PebbleHealthActivitySampleDao(pebbleHealthActivitySampleDaoConfig, this);
        pebbleHealthActivityOverlayDao = new PebbleHealthActivityOverlayDao(pebbleHealthActivityOverlayDaoConfig, this);
        pebbleMisfitSampleDao = new PebbleMisfitSampleDao(pebbleMisfitSampleDaoConfig, this);
        pebbleMorpheuzSampleDao = new PebbleMorpheuzSampleDao(pebbleMorpheuzSampleDaoConfig, this);
        hPlusHealthActivityOverlayDao = new HPlusHealthActivityOverlayDao(hPlusHealthActivityOverlayDaoConfig, this);
        hPlusHealthActivitySampleDao = new HPlusHealthActivitySampleDao(hPlusHealthActivitySampleDaoConfig, this);
        no1F1ActivitySampleDao = new No1F1ActivitySampleDao(no1F1ActivitySampleDaoConfig, this);
        xWatchActivitySampleDao = new XWatchActivitySampleDao(xWatchActivitySampleDaoConfig, this);
        zeTimeActivitySampleDao = new ZeTimeActivitySampleDao(zeTimeActivitySampleDaoConfig, this);
        iD115ActivitySampleDao = new ID115ActivitySampleDao(iD115ActivitySampleDaoConfig, this);
        jYouActivitySampleDao = new JYouActivitySampleDao(jYouActivitySampleDaoConfig, this);
        watchXPlusActivitySampleDao = new WatchXPlusActivitySampleDao(watchXPlusActivitySampleDaoConfig, this);
        watchXPlusHealthActivityOverlayDao = new WatchXPlusHealthActivityOverlayDao(watchXPlusHealthActivityOverlayDaoConfig, this);
        tLW64ActivitySampleDao = new TLW64ActivitySampleDao(tLW64ActivitySampleDaoConfig, this);
        lefunActivitySampleDao = new LefunActivitySampleDao(lefunActivitySampleDaoConfig, this);
        lefunBiometricSampleDao = new LefunBiometricSampleDao(lefunBiometricSampleDaoConfig, this);
        lefunSleepSampleDao = new LefunSleepSampleDao(lefunSleepSampleDaoConfig, this);
        sonySWR12SampleDao = new SonySWR12SampleDao(sonySWR12SampleDaoConfig, this);
        bangleJSActivitySampleDao = new BangleJSActivitySampleDao(bangleJSActivitySampleDaoConfig, this);
        casioGBX100ActivitySampleDao = new CasioGBX100ActivitySampleDao(casioGBX100ActivitySampleDaoConfig, this);
        fitProActivitySampleDao = new FitProActivitySampleDao(fitProActivitySampleDaoConfig, this);
        pineTimeActivitySampleDao = new PineTimeActivitySampleDao(pineTimeActivitySampleDaoConfig, this);
        hybridHRActivitySampleDao = new HybridHRActivitySampleDao(hybridHRActivitySampleDaoConfig, this);
        calendarSyncStateDao = new CalendarSyncStateDao(calendarSyncStateDaoConfig, this);
        alarmDao = new AlarmDao(alarmDaoConfig, this);
        reminderDao = new ReminderDao(reminderDaoConfig, this);
        worldClockDao = new WorldClockDao(worldClockDaoConfig, this);
        notificationFilterDao = new NotificationFilterDao(notificationFilterDaoConfig, this);
        notificationFilterEntryDao = new NotificationFilterEntryDao(notificationFilterEntryDaoConfig, this);
        baseActivitySummaryDao = new BaseActivitySummaryDao(baseActivitySummaryDaoConfig, this);
        batteryLevelDao = new BatteryLevelDao(batteryLevelDaoConfig, this);

        registerDao(UserAttributes.class, userAttributesDao);
        registerDao(User.class, userDao);
        registerDao(DeviceAttributes.class, deviceAttributesDao);
        registerDao(Device.class, deviceDao);
        registerDao(Tag.class, tagDao);
        registerDao(ActivityDescription.class, activityDescriptionDao);
        registerDao(ActivityDescTagLink.class, activityDescTagLinkDao);
        registerDao(MakibesHR3ActivitySample.class, makibesHR3ActivitySampleDao);
        registerDao(MiBandActivitySample.class, miBandActivitySampleDao);
        registerDao(PebbleHealthActivitySample.class, pebbleHealthActivitySampleDao);
        registerDao(PebbleHealthActivityOverlay.class, pebbleHealthActivityOverlayDao);
        registerDao(PebbleMisfitSample.class, pebbleMisfitSampleDao);
        registerDao(PebbleMorpheuzSample.class, pebbleMorpheuzSampleDao);
        registerDao(HPlusHealthActivityOverlay.class, hPlusHealthActivityOverlayDao);
        registerDao(HPlusHealthActivitySample.class, hPlusHealthActivitySampleDao);
        registerDao(No1F1ActivitySample.class, no1F1ActivitySampleDao);
        registerDao(XWatchActivitySample.class, xWatchActivitySampleDao);
        registerDao(ZeTimeActivitySample.class, zeTimeActivitySampleDao);
        registerDao(ID115ActivitySample.class, iD115ActivitySampleDao);
        registerDao(JYouActivitySample.class, jYouActivitySampleDao);
        registerDao(WatchXPlusActivitySample.class, watchXPlusActivitySampleDao);
        registerDao(WatchXPlusHealthActivityOverlay.class, watchXPlusHealthActivityOverlayDao);
        registerDao(TLW64ActivitySample.class, tLW64ActivitySampleDao);
        registerDao(LefunActivitySample.class, lefunActivitySampleDao);
        registerDao(LefunBiometricSample.class, lefunBiometricSampleDao);
        registerDao(LefunSleepSample.class, lefunSleepSampleDao);
        registerDao(SonySWR12Sample.class, sonySWR12SampleDao);
        registerDao(BangleJSActivitySample.class, bangleJSActivitySampleDao);
        registerDao(CasioGBX100ActivitySample.class, casioGBX100ActivitySampleDao);
        registerDao(FitProActivitySample.class, fitProActivitySampleDao);
        registerDao(PineTimeActivitySample.class, pineTimeActivitySampleDao);
        registerDao(HybridHRActivitySample.class, hybridHRActivitySampleDao);
        registerDao(CalendarSyncState.class, calendarSyncStateDao);
        registerDao(Alarm.class, alarmDao);
        registerDao(Reminder.class, reminderDao);
        registerDao(WorldClock.class, worldClockDao);
        registerDao(NotificationFilter.class, notificationFilterDao);
        registerDao(NotificationFilterEntry.class, notificationFilterEntryDao);
        registerDao(BaseActivitySummary.class, baseActivitySummaryDao);
        registerDao(BatteryLevel.class, batteryLevelDao);
    }
    
    public void clear() {
        userAttributesDaoConfig.getIdentityScope().clear();
        userDaoConfig.getIdentityScope().clear();
        deviceAttributesDaoConfig.getIdentityScope().clear();
        deviceDaoConfig.getIdentityScope().clear();
        tagDaoConfig.getIdentityScope().clear();
        activityDescriptionDaoConfig.getIdentityScope().clear();
        activityDescTagLinkDaoConfig.getIdentityScope().clear();
        makibesHR3ActivitySampleDaoConfig.getIdentityScope().clear();
        miBandActivitySampleDaoConfig.getIdentityScope().clear();
        pebbleHealthActivitySampleDaoConfig.getIdentityScope().clear();
        pebbleHealthActivityOverlayDaoConfig.getIdentityScope().clear();
        pebbleMisfitSampleDaoConfig.getIdentityScope().clear();
        pebbleMorpheuzSampleDaoConfig.getIdentityScope().clear();
        hPlusHealthActivityOverlayDaoConfig.getIdentityScope().clear();
        hPlusHealthActivitySampleDaoConfig.getIdentityScope().clear();
        no1F1ActivitySampleDaoConfig.getIdentityScope().clear();
        xWatchActivitySampleDaoConfig.getIdentityScope().clear();
        zeTimeActivitySampleDaoConfig.getIdentityScope().clear();
        iD115ActivitySampleDaoConfig.getIdentityScope().clear();
        jYouActivitySampleDaoConfig.getIdentityScope().clear();
        watchXPlusActivitySampleDaoConfig.getIdentityScope().clear();
        watchXPlusHealthActivityOverlayDaoConfig.getIdentityScope().clear();
        tLW64ActivitySampleDaoConfig.getIdentityScope().clear();
        lefunActivitySampleDaoConfig.getIdentityScope().clear();
        lefunBiometricSampleDaoConfig.getIdentityScope().clear();
        lefunSleepSampleDaoConfig.getIdentityScope().clear();
        sonySWR12SampleDaoConfig.getIdentityScope().clear();
        bangleJSActivitySampleDaoConfig.getIdentityScope().clear();
        casioGBX100ActivitySampleDaoConfig.getIdentityScope().clear();
        fitProActivitySampleDaoConfig.getIdentityScope().clear();
        pineTimeActivitySampleDaoConfig.getIdentityScope().clear();
        hybridHRActivitySampleDaoConfig.getIdentityScope().clear();
        calendarSyncStateDaoConfig.getIdentityScope().clear();
        alarmDaoConfig.getIdentityScope().clear();
        reminderDaoConfig.getIdentityScope().clear();
        worldClockDaoConfig.getIdentityScope().clear();
        notificationFilterDaoConfig.getIdentityScope().clear();
        notificationFilterEntryDaoConfig.getIdentityScope().clear();
        baseActivitySummaryDaoConfig.getIdentityScope().clear();
        batteryLevelDaoConfig.getIdentityScope().clear();
    }

    public UserAttributesDao getUserAttributesDao() {
        return userAttributesDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public DeviceAttributesDao getDeviceAttributesDao() {
        return deviceAttributesDao;
    }

    public DeviceDao getDeviceDao() {
        return deviceDao;
    }

    public TagDao getTagDao() {
        return tagDao;
    }

    public ActivityDescriptionDao getActivityDescriptionDao() {
        return activityDescriptionDao;
    }

    public ActivityDescTagLinkDao getActivityDescTagLinkDao() {
        return activityDescTagLinkDao;
    }

    public MakibesHR3ActivitySampleDao getMakibesHR3ActivitySampleDao() {
        return makibesHR3ActivitySampleDao;
    }

    public MiBandActivitySampleDao getMiBandActivitySampleDao() {
        return miBandActivitySampleDao;
    }

    public PebbleHealthActivitySampleDao getPebbleHealthActivitySampleDao() {
        return pebbleHealthActivitySampleDao;
    }

    public PebbleHealthActivityOverlayDao getPebbleHealthActivityOverlayDao() {
        return pebbleHealthActivityOverlayDao;
    }

    public PebbleMisfitSampleDao getPebbleMisfitSampleDao() {
        return pebbleMisfitSampleDao;
    }

    public PebbleMorpheuzSampleDao getPebbleMorpheuzSampleDao() {
        return pebbleMorpheuzSampleDao;
    }

    public HPlusHealthActivityOverlayDao getHPlusHealthActivityOverlayDao() {
        return hPlusHealthActivityOverlayDao;
    }

    public HPlusHealthActivitySampleDao getHPlusHealthActivitySampleDao() {
        return hPlusHealthActivitySampleDao;
    }

    public No1F1ActivitySampleDao getNo1F1ActivitySampleDao() {
        return no1F1ActivitySampleDao;
    }

    public XWatchActivitySampleDao getXWatchActivitySampleDao() {
        return xWatchActivitySampleDao;
    }

    public ZeTimeActivitySampleDao getZeTimeActivitySampleDao() {
        return zeTimeActivitySampleDao;
    }

    public ID115ActivitySampleDao getID115ActivitySampleDao() {
        return iD115ActivitySampleDao;
    }

    public JYouActivitySampleDao getJYouActivitySampleDao() {
        return jYouActivitySampleDao;
    }

    public WatchXPlusActivitySampleDao getWatchXPlusActivitySampleDao() {
        return watchXPlusActivitySampleDao;
    }

    public WatchXPlusHealthActivityOverlayDao getWatchXPlusHealthActivityOverlayDao() {
        return watchXPlusHealthActivityOverlayDao;
    }

    public TLW64ActivitySampleDao getTLW64ActivitySampleDao() {
        return tLW64ActivitySampleDao;
    }

    public LefunActivitySampleDao getLefunActivitySampleDao() {
        return lefunActivitySampleDao;
    }

    public LefunBiometricSampleDao getLefunBiometricSampleDao() {
        return lefunBiometricSampleDao;
    }

    public LefunSleepSampleDao getLefunSleepSampleDao() {
        return lefunSleepSampleDao;
    }

    public SonySWR12SampleDao getSonySWR12SampleDao() {
        return sonySWR12SampleDao;
    }

    public BangleJSActivitySampleDao getBangleJSActivitySampleDao() {
        return bangleJSActivitySampleDao;
    }

    public CasioGBX100ActivitySampleDao getCasioGBX100ActivitySampleDao() {
        return casioGBX100ActivitySampleDao;
    }

    public FitProActivitySampleDao getFitProActivitySampleDao() {
        return fitProActivitySampleDao;
    }

    public PineTimeActivitySampleDao getPineTimeActivitySampleDao() {
        return pineTimeActivitySampleDao;
    }

    public HybridHRActivitySampleDao getHybridHRActivitySampleDao() {
        return hybridHRActivitySampleDao;
    }

    public CalendarSyncStateDao getCalendarSyncStateDao() {
        return calendarSyncStateDao;
    }

    public AlarmDao getAlarmDao() {
        return alarmDao;
    }

    public ReminderDao getReminderDao() {
        return reminderDao;
    }

    public WorldClockDao getWorldClockDao() {
        return worldClockDao;
    }

    public NotificationFilterDao getNotificationFilterDao() {
        return notificationFilterDao;
    }

    public NotificationFilterEntryDao getNotificationFilterEntryDao() {
        return notificationFilterEntryDao;
    }

    public BaseActivitySummaryDao getBaseActivitySummaryDao() {
        return baseActivitySummaryDao;
    }

    public BatteryLevelDao getBatteryLevelDao() {
        return batteryLevelDao;
    }

}
