package acr.browser.lightning.settings.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 %2\u00020\u0001:\u0001%B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0012\u0010 \u001a\u00020\u00192\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020$H\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00048\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u00020\u00138\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006&"}, d2 = {"Lacr/browser/lightning/settings/fragment/PrivacySettingsFragment;", "Lacr/browser/lightning/settings/fragment/AbstractSettingsFragment;", "()V", "databaseScheduler", "Lio/reactivex/Scheduler;", "getDatabaseScheduler$app_lightningPlusDebug", "()Lio/reactivex/Scheduler;", "setDatabaseScheduler$app_lightningPlusDebug", "(Lio/reactivex/Scheduler;)V", "historyRepository", "Lacr/browser/lightning/database/history/HistoryRepository;", "getHistoryRepository$app_lightningPlusDebug", "()Lacr/browser/lightning/database/history/HistoryRepository;", "setHistoryRepository$app_lightningPlusDebug", "(Lacr/browser/lightning/database/history/HistoryRepository;)V", "mainScheduler", "getMainScheduler$app_lightningPlusDebug", "setMainScheduler$app_lightningPlusDebug", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "getUserPreferences$app_lightningPlusDebug", "()Lacr/browser/lightning/preference/UserPreferences;", "setUserPreferences$app_lightningPlusDebug", "(Lacr/browser/lightning/preference/UserPreferences;)V", "clearCache", "", "clearCookies", "Lio/reactivex/Completable;", "clearCookiesDialog", "clearHistory", "clearHistoryDialog", "clearWebStorage", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "providePreferencesXmlResource", "", "Companion", "app_lightningPlusDebug"})
public final class PrivacySettingsFragment extends acr.browser.lightning.settings.fragment.AbstractSettingsFragment {
    @javax.inject.Inject()
    public acr.browser.lightning.database.history.HistoryRepository historyRepository;
    @javax.inject.Inject()
    public acr.browser.lightning.preference.UserPreferences userPreferences;
    @acr.browser.lightning.browser.di.DatabaseScheduler()
    @javax.inject.Inject()
    public io.reactivex.Scheduler databaseScheduler;
    @acr.browser.lightning.browser.di.MainScheduler()
    @javax.inject.Inject()
    public io.reactivex.Scheduler mainScheduler;
    private static final java.lang.String SETTINGS_LOCATION = "location";
    private static final java.lang.String SETTINGS_THIRDPCOOKIES = "third_party";
    private static final java.lang.String SETTINGS_SAVEPASSWORD = "password";
    private static final java.lang.String SETTINGS_CACHEEXIT = "clear_cache_exit";
    private static final java.lang.String SETTINGS_HISTORYEXIT = "clear_history_exit";
    private static final java.lang.String SETTINGS_COOKIEEXIT = "clear_cookies_exit";
    private static final java.lang.String SETTINGS_CLEARCACHE = "clear_cache";
    private static final java.lang.String SETTINGS_CLEARHISTORY = "clear_history";
    private static final java.lang.String SETTINGS_CLEARCOOKIES = "clear_cookies";
    private static final java.lang.String SETTINGS_CLEARWEBSTORAGE = "clear_webstorage";
    private static final java.lang.String SETTINGS_WEBSTORAGEEXIT = "clear_webstorage_exit";
    private static final java.lang.String SETTINGS_DONOTTRACK = "do_not_track";
    private static final java.lang.String SETTINGS_WEBRTC = "webrtc_support";
    private static final java.lang.String SETTINGS_IDENTIFYINGHEADERS = "remove_identifying_headers";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.settings.fragment.PrivacySettingsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.database.history.HistoryRepository getHistoryRepository$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setHistoryRepository$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.history.HistoryRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.preference.UserPreferences getUserPreferences$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setUserPreferences$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Scheduler getDatabaseScheduler$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setDatabaseScheduler$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    io.reactivex.Scheduler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Scheduler getMainScheduler$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setMainScheduler$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    io.reactivex.Scheduler p0) {
    }
    
    @java.lang.Override()
    protected int providePreferencesXmlResource() {
        return 0;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void clearHistoryDialog() {
    }
    
    private final void clearCookiesDialog() {
    }
    
    private final void clearCache() {
    }
    
    private final io.reactivex.Completable clearHistory() {
        return null;
    }
    
    private final io.reactivex.Completable clearCookies() {
        return null;
    }
    
    private final void clearWebStorage() {
    }
    
    public PrivacySettingsFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lacr/browser/lightning/settings/fragment/PrivacySettingsFragment$Companion;", "", "()V", "SETTINGS_CACHEEXIT", "", "SETTINGS_CLEARCACHE", "SETTINGS_CLEARCOOKIES", "SETTINGS_CLEARHISTORY", "SETTINGS_CLEARWEBSTORAGE", "SETTINGS_COOKIEEXIT", "SETTINGS_DONOTTRACK", "SETTINGS_HISTORYEXIT", "SETTINGS_IDENTIFYINGHEADERS", "SETTINGS_LOCATION", "SETTINGS_SAVEPASSWORD", "SETTINGS_THIRDPCOOKIES", "SETTINGS_WEBRTC", "SETTINGS_WEBSTORAGEEXIT", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}