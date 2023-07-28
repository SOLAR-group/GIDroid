package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * The repository for tabs that implements the [BrowserContract.Model] interface. Manages the state
 * of the tabs list and adding new tabs to it or removing tabs from it.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B[\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0015J\u000e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00180$H\u0002J\b\u0010%\u001a\u00020&H\u0016J\u0016\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u001b0$2\u0006\u0010(\u001a\u00020)H\u0016J\u0016\u0010*\u001a\b\u0012\u0004\u0012\u00020\u001b0$2\u0006\u0010(\u001a\u00020)H\u0002J\b\u0010+\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020&H\u0016J\u0014\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001d02H\u0016J\u000e\u00103\u001a\b\u0012\u0004\u0012\u00020\u001b02H\u0016J\u0010\u00104\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/H\u0016J\u0014\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001d06H\u0016J\u001a\u00107\u001a\u00020\u001b*\b\u0012\u0004\u0012\u00020\u001b0\u001d2\u0006\u0010.\u001a\u00020/H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R*\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001d@RX\u0096\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R(\u0010!\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u001b \u0019*\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001d0\u001d0\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00068"}, d2 = {"Lacr/browser/lightning/browser/tab/TabsRepository;", "Lacr/browser/lightning/browser/BrowserContract$Model;", "webViewFactory", "Lacr/browser/lightning/browser/tab/WebViewFactory;", "tabPager", "Lacr/browser/lightning/browser/tab/TabPager;", "diskScheduler", "Lio/reactivex/Scheduler;", "mainScheduler", "bundleStore", "Lacr/browser/lightning/browser/tab/bundle/BundleStore;", "recentTabModel", "Lacr/browser/lightning/browser/tab/RecentTabModel;", "tabFactory", "Lacr/browser/lightning/browser/tab/TabFactory;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "initialUrl", "", "permissionInitializerFactory", "Lacr/browser/lightning/browser/tab/PermissionInitializer$Factory;", "(Lacr/browser/lightning/browser/tab/WebViewFactory;Lacr/browser/lightning/browser/tab/TabPager;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;Lacr/browser/lightning/browser/tab/bundle/BundleStore;Lacr/browser/lightning/browser/tab/RecentTabModel;Lacr/browser/lightning/browser/tab/TabFactory;Lacr/browser/lightning/preference/UserPreferences;Ljava/lang/String;Lacr/browser/lightning/browser/tab/PermissionInitializer$Factory;)V", "isInitialized", "Lio/reactivex/subjects/BehaviorSubject;", "", "kotlin.jvm.PlatformType", "selectedTab", "Lacr/browser/lightning/browser/tab/TabModel;", "<set-?>", "", "tabsList", "getTabsList", "()Ljava/util/List;", "tabsListObservable", "Lio/reactivex/subjects/PublishSubject;", "afterInitialization", "Lio/reactivex/Single;", "clean", "", "createTab", "tabInitializer", "Lacr/browser/lightning/browser/tab/TabInitializer;", "createTabUnsafe", "deleteAllTabs", "Lio/reactivex/Completable;", "deleteTab", "id", "", "freeze", "initializeTabs", "Lio/reactivex/Maybe;", "reopenTab", "selectTab", "tabsListChanges", "Lio/reactivex/Observable;", "forId", "app_lightningLiteDebug"})
public final class TabsRepository implements acr.browser.lightning.browser.BrowserContract.Model {
    private io.reactivex.subjects.BehaviorSubject<java.lang.Boolean> isInitialized;
    private acr.browser.lightning.browser.tab.TabModel selectedTab;
    private final io.reactivex.subjects.PublishSubject<java.util.List<acr.browser.lightning.browser.tab.TabModel>> tabsListObservable = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<? extends acr.browser.lightning.browser.tab.TabModel> tabsList;
    private final acr.browser.lightning.browser.tab.WebViewFactory webViewFactory = null;
    private final acr.browser.lightning.browser.tab.TabPager tabPager = null;
    private final io.reactivex.Scheduler diskScheduler = null;
    private final io.reactivex.Scheduler mainScheduler = null;
    private final acr.browser.lightning.browser.tab.bundle.BundleStore bundleStore = null;
    private final acr.browser.lightning.browser.tab.RecentTabModel recentTabModel = null;
    private final acr.browser.lightning.browser.tab.TabFactory tabFactory = null;
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final java.lang.String initialUrl = null;
    private final acr.browser.lightning.browser.tab.PermissionInitializer.Factory permissionInitializerFactory = null;
    
    private final io.reactivex.Single<java.lang.Boolean> afterInitialization() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable deleteTab(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable deleteAllTabs() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<acr.browser.lightning.browser.tab.TabModel> createTab(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.TabInitializer tabInitializer) {
        return null;
    }
    
    /**
     * Creates a tab without waiting for the browser to be initialized.
     */
    private final io.reactivex.Single<acr.browser.lightning.browser.tab.TabModel> createTabUnsafe(acr.browser.lightning.browser.tab.TabInitializer tabInitializer) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Maybe<acr.browser.lightning.browser.tab.TabModel> reopenTab() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public acr.browser.lightning.browser.tab.TabModel selectTab(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<acr.browser.lightning.browser.tab.TabModel> getTabsList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<java.util.List<acr.browser.lightning.browser.tab.TabModel>> tabsListChanges() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Maybe<java.util.List<acr.browser.lightning.browser.tab.TabModel>> initializeTabs() {
        return null;
    }
    
    @java.lang.Override()
    public void freeze() {
    }
    
    @java.lang.Override()
    public void clean() {
    }
    
    private final acr.browser.lightning.browser.tab.TabModel forId(java.util.List<? extends acr.browser.lightning.browser.tab.TabModel> $this$forId, int id) {
        return null;
    }
    
    @javax.inject.Inject()
    public TabsRepository(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.WebViewFactory webViewFactory, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.TabPager tabPager, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DiskScheduler()
    io.reactivex.Scheduler diskScheduler, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.MainScheduler()
    io.reactivex.Scheduler mainScheduler, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.bundle.BundleStore bundleStore, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.RecentTabModel recentTabModel, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.TabFactory tabFactory, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.Nullable()
    @acr.browser.lightning.browser.di.InitialUrl()
    java.lang.String initialUrl, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.PermissionInitializer.Factory permissionInitializerFactory) {
        super();
    }
}