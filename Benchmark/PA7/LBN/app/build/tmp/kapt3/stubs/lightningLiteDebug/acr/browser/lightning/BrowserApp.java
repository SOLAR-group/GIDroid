package acr.browser.lightning;

import java.lang.System;

/**
 * The browser application.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 02\u00020\u0001:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020\u0010H\u0002J\b\u0010.\u001a\u00020/H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u00020\u00168\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u001c8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00020\"8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010\'\u001a\u00020(8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u00061"}, d2 = {"Lacr/browser/lightning/BrowserApp;", "Landroid/app/Application;", "()V", "applicationComponent", "Lacr/browser/lightning/browser/di/AppComponent;", "getApplicationComponent", "()Lacr/browser/lightning/browser/di/AppComponent;", "setApplicationComponent", "(Lacr/browser/lightning/browser/di/AppComponent;)V", "bookmarkModel", "Lacr/browser/lightning/database/bookmark/BookmarkRepository;", "getBookmarkModel$app_lightningLiteDebug", "()Lacr/browser/lightning/database/bookmark/BookmarkRepository;", "setBookmarkModel$app_lightningLiteDebug", "(Lacr/browser/lightning/database/bookmark/BookmarkRepository;)V", "buildInfo", "Lacr/browser/lightning/device/BuildInfo;", "getBuildInfo$app_lightningLiteDebug", "()Lacr/browser/lightning/device/BuildInfo;", "setBuildInfo$app_lightningLiteDebug", "(Lacr/browser/lightning/device/BuildInfo;)V", "databaseScheduler", "Lio/reactivex/Scheduler;", "getDatabaseScheduler$app_lightningLiteDebug", "()Lio/reactivex/Scheduler;", "setDatabaseScheduler$app_lightningLiteDebug", "(Lio/reactivex/Scheduler;)V", "developerPreferences", "Lacr/browser/lightning/preference/DeveloperPreferences;", "getDeveloperPreferences$app_lightningLiteDebug", "()Lacr/browser/lightning/preference/DeveloperPreferences;", "setDeveloperPreferences$app_lightningLiteDebug", "(Lacr/browser/lightning/preference/DeveloperPreferences;)V", "logger", "Lacr/browser/lightning/log/Logger;", "getLogger$app_lightningLiteDebug", "()Lacr/browser/lightning/log/Logger;", "setLogger$app_lightningLiteDebug", "(Lacr/browser/lightning/log/Logger;)V", "proxyAdapter", "Lacr/browser/lightning/browser/proxy/ProxyAdapter;", "getProxyAdapter$app_lightningLiteDebug", "()Lacr/browser/lightning/browser/proxy/ProxyAdapter;", "setProxyAdapter$app_lightningLiteDebug", "(Lacr/browser/lightning/browser/proxy/ProxyAdapter;)V", "createBuildInfo", "onCreate", "", "Companion", "app_lightningLiteDebug"})
public final class BrowserApp extends android.app.Application {
    @javax.inject.Inject()
    public acr.browser.lightning.preference.DeveloperPreferences developerPreferences;
    @javax.inject.Inject()
    public acr.browser.lightning.database.bookmark.BookmarkRepository bookmarkModel;
    @acr.browser.lightning.browser.di.DatabaseScheduler()
    @javax.inject.Inject()
    public io.reactivex.Scheduler databaseScheduler;
    @javax.inject.Inject()
    public acr.browser.lightning.log.Logger logger;
    @javax.inject.Inject()
    public acr.browser.lightning.device.BuildInfo buildInfo;
    @javax.inject.Inject()
    public acr.browser.lightning.browser.proxy.ProxyAdapter proxyAdapter;
    public acr.browser.lightning.browser.di.AppComponent applicationComponent;
    private static final java.lang.String TAG = "BrowserApp";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.BrowserApp.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.preference.DeveloperPreferences getDeveloperPreferences$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setDeveloperPreferences$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.DeveloperPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.database.bookmark.BookmarkRepository getBookmarkModel$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setBookmarkModel$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.bookmark.BookmarkRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Scheduler getDatabaseScheduler$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setDatabaseScheduler$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    io.reactivex.Scheduler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.log.Logger getLogger$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setLogger$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.device.BuildInfo getBuildInfo$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setBuildInfo$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.device.BuildInfo p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.proxy.ProxyAdapter getProxyAdapter$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setProxyAdapter$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.proxy.ProxyAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.di.AppComponent getApplicationComponent() {
        return null;
    }
    
    public final void setApplicationComponent(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.di.AppComponent p0) {
    }
    
    @java.lang.Override()
    public void onCreate() {
    }
    
    /**
     * Create the [BuildType] from the [BuildConfig].
     */
    private final acr.browser.lightning.device.BuildInfo createBuildInfo() {
        return null;
    }
    
    public BrowserApp() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/BrowserApp$Companion;", "", "()V", "TAG", "", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}