package acr.browser.lightning.browser.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00c4\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010!\u001a\u00020\"H\u0007J\u0010\u0010#\u001a\u00020$2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010%\u001a\u00020&H\u0007J\u0016\u0010\'\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010*\u001a\u00020+2\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010,\u001a\u00020-H\u0007J\b\u0010.\u001a\u00020\"H\u0007J\b\u0010/\u001a\u000200H\u0007J\b\u00101\u001a\u00020\"H\u0007J\b\u00102\u001a\u00020\"H\u0007J\u0010\u00103\u001a\u0002042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u00105\u001a\u0002062\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u00107\u001a\u000208H\u0007J\u0016\u00109\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u000208H\u0007J\b\u0010=\u001a\u00020>H\u0007J\b\u0010?\u001a\u00020@H\u0007J\u0010\u0010A\u001a\u00020B2\u0006\u0010\t\u001a\u00020\nH\u0007\u00a8\u0006C"}, d2 = {"Lacr/browser/lightning/browser/di/AppModule;", "", "()V", "createInterceptorWithMaxCacheAge", "Lokhttp3/Interceptor;", "maxCacheAgeSeconds", "", "provideAdBlockPreferences", "Landroid/content/SharedPreferences;", "application", "Landroid/app/Application;", "provideContext", "Landroid/content/Context;", "provideDebugPreferences", "provideI2PAndroidHelper", "Lnet/i2p/android/ui/I2PAndroidHelper;", "provideLogger", "Lacr/browser/lightning/log/Logger;", "buildInfo", "Lacr/browser/lightning/device/BuildInfo;", "provideMainHandler", "Landroid/os/Handler;", "provideUserPreferences", "providesAssetManager", "Landroid/content/res/AssetManager;", "providesBookmarkPageReader", "Lacr/browser/lightning/html/bookmark/BookmarkPageReader;", "providesClipboardManager", "Landroid/content/ClipboardManager;", "providesConnectivityManager", "Landroid/net/ConnectivityManager;", "providesDefaultTabTitle", "", "providesDiskThread", "Lio/reactivex/Scheduler;", "providesDownloadManager", "Landroid/app/DownloadManager;", "providesHomePageReader", "Lacr/browser/lightning/html/homepage/HomePageReader;", "providesHostsHttpClient", "Lio/reactivex/Single;", "Lokhttp3/OkHttpClient;", "providesInputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "providesInvertPage", "Lacr/browser/lightning/js/InvertPage;", "providesIoThread", "providesListPageReader", "Lacr/browser/lightning/html/ListPageReader;", "providesMainThread", "providesNetworkThread", "providesNotificationManager", "Landroid/app/NotificationManager;", "providesShortcutManager", "Landroid/content/pm/ShortcutManager;", "providesSuggestionsCacheControl", "Lokhttp3/CacheControl;", "providesSuggestionsHttpClient", "providesSuggestionsRequestFactory", "Lacr/browser/lightning/search/suggestions/RequestFactory;", "cacheControl", "providesTextReflow", "Lacr/browser/lightning/js/TextReflow;", "providesThemeColor", "Lacr/browser/lightning/js/ThemeColor;", "providesWindowManager", "Landroid/view/WindowManager;", "app_lightningPlusDebug"})
@dagger.Module()
public final class AppModule {
    
    @org.jetbrains.annotations.NotNull()
    @MainHandler()
    @dagger.Provides()
    public final android.os.Handler provideMainHandler() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final android.content.Context provideContext(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @UserPrefs()
    @dagger.Provides()
    public final android.content.SharedPreferences provideUserPreferences(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @DevPrefs()
    @dagger.Provides()
    public final android.content.SharedPreferences provideDebugPreferences(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @AdBlockPrefs()
    @dagger.Provides()
    public final android.content.SharedPreferences provideAdBlockPreferences(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final android.content.res.AssetManager providesAssetManager(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final android.content.ClipboardManager providesClipboardManager(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final android.view.inputmethod.InputMethodManager providesInputMethodManager(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final android.app.DownloadManager providesDownloadManager(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final android.net.ConnectivityManager providesConnectivityManager(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final android.app.NotificationManager providesNotificationManager(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final android.view.WindowManager providesWindowManager(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N_MR1)
    @dagger.Provides()
    public final android.content.pm.ShortcutManager providesShortcutManager(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @DatabaseScheduler()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final io.reactivex.Scheduler providesIoThread() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @DiskScheduler()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final io.reactivex.Scheduler providesDiskThread() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @NetworkScheduler()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final io.reactivex.Scheduler providesNetworkThread() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @MainScheduler()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final io.reactivex.Scheduler providesMainThread() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final okhttp3.CacheControl providesSuggestionsCacheControl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final acr.browser.lightning.search.suggestions.RequestFactory providesSuggestionsRequestFactory(@org.jetbrains.annotations.NotNull()
    okhttp3.CacheControl cacheControl) {
        return null;
    }
    
    private final okhttp3.Interceptor createInterceptorWithMaxCacheAge(long maxCacheAgeSeconds) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @SuggestionsClient()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final io.reactivex.Single<okhttp3.OkHttpClient> providesSuggestionsHttpClient(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @HostsClient()
    @dagger.Provides()
    @javax.inject.Singleton()
    public final io.reactivex.Single<okhttp3.OkHttpClient> providesHostsHttpClient(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final acr.browser.lightning.log.Logger provideLogger(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.device.BuildInfo buildInfo) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final net.i2p.android.ui.I2PAndroidHelper provideI2PAndroidHelper(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final acr.browser.lightning.html.ListPageReader providesListPageReader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final acr.browser.lightning.html.homepage.HomePageReader providesHomePageReader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final acr.browser.lightning.html.bookmark.BookmarkPageReader providesBookmarkPageReader() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final acr.browser.lightning.js.TextReflow providesTextReflow() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final acr.browser.lightning.js.ThemeColor providesThemeColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final acr.browser.lightning.js.InvertPage providesInvertPage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @acr.browser.lightning.browser.tab.DefaultTabTitle()
    public final java.lang.String providesDefaultTabTitle(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    public AppModule() {
        super();
    }
}