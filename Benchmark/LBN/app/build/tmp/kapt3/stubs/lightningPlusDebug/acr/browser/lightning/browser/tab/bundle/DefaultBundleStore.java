package acr.browser.lightning.browser.tab.bundle;

import java.lang.System;

/**
 * A bundle store that serializes each tab state to disk and supports its retrieval.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u000e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0016\u0010\u0014\u001a\u00020\u00102\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0012H\u0016J\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lacr/browser/lightning/browser/tab/bundle/DefaultBundleStore;", "Lacr/browser/lightning/browser/tab/bundle/BundleStore;", "application", "Landroid/app/Application;", "bookmarkPageInitializer", "Lacr/browser/lightning/browser/tab/BookmarkPageInitializer;", "homePageInitializer", "Lacr/browser/lightning/browser/tab/HomePageInitializer;", "downloadPageInitializer", "Lacr/browser/lightning/browser/tab/DownloadPageInitializer;", "historyPageInitializer", "Lacr/browser/lightning/browser/tab/HistoryPageInitializer;", "diskScheduler", "Lio/reactivex/Scheduler;", "(Landroid/app/Application;Lacr/browser/lightning/browser/tab/BookmarkPageInitializer;Lacr/browser/lightning/browser/tab/HomePageInitializer;Lacr/browser/lightning/browser/tab/DownloadPageInitializer;Lacr/browser/lightning/browser/tab/HistoryPageInitializer;Lio/reactivex/Scheduler;)V", "deleteAll", "", "retrieve", "", "Lacr/browser/lightning/browser/tab/TabInitializer;", "save", "tabs", "Lacr/browser/lightning/browser/tab/TabModel;", "extractNumberFromEnd", "", "Companion", "app_lightningPlusDebug"})
public final class DefaultBundleStore implements acr.browser.lightning.browser.tab.bundle.BundleStore {
    private final android.app.Application application = null;
    private final acr.browser.lightning.browser.tab.BookmarkPageInitializer bookmarkPageInitializer = null;
    private final acr.browser.lightning.browser.tab.HomePageInitializer homePageInitializer = null;
    private final acr.browser.lightning.browser.tab.DownloadPageInitializer downloadPageInitializer = null;
    private final acr.browser.lightning.browser.tab.HistoryPageInitializer historyPageInitializer = null;
    private final io.reactivex.Scheduler diskScheduler = null;
    private static final java.lang.String TAG = "TabsRepository";
    private static final java.lang.String BUNDLE_KEY = "WEBVIEW_";
    private static final java.lang.String TAB_TITLE_KEY = "TITLE_";
    private static final java.lang.String URL_KEY = "URL_KEY";
    private static final java.lang.String BUNDLE_STORAGE = "SAVED_TABS.parcel";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.browser.tab.bundle.DefaultBundleStore.Companion Companion = null;
    
    @java.lang.Override()
    public void save(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends acr.browser.lightning.browser.tab.TabModel> tabs) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<acr.browser.lightning.browser.tab.TabInitializer> retrieve() {
        return null;
    }
    
    @java.lang.Override()
    public void deleteAll() {
    }
    
    private final java.lang.String extractNumberFromEnd(java.lang.String $this$extractNumberFromEnd) {
        return null;
    }
    
    @javax.inject.Inject()
    public DefaultBundleStore(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.BookmarkPageInitializer bookmarkPageInitializer, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.HomePageInitializer homePageInitializer, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.DownloadPageInitializer downloadPageInitializer, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.HistoryPageInitializer historyPageInitializer, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DiskScheduler()
    io.reactivex.Scheduler diskScheduler) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/browser/tab/bundle/DefaultBundleStore$Companion;", "", "()V", "BUNDLE_KEY", "", "BUNDLE_STORAGE", "TAB_TITLE_KEY", "TAG", "URL_KEY", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}