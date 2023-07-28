package acr.browser.lightning.browser.di;

import acr.browser.lightning.BrowserApp;
import acr.browser.lightning.BrowserApp_MembersInjector;
import acr.browser.lightning.ThemableBrowserActivity;
import acr.browser.lightning.ThemableBrowserActivity_MembersInjector;
import acr.browser.lightning.adblock.AdBlocker;
import acr.browser.lightning.adblock.BloomFilterAdBlocker;
import acr.browser.lightning.adblock.BloomFilterAdBlocker_Factory;
import acr.browser.lightning.adblock.NoOpAdBlocker;
import acr.browser.lightning.adblock.NoOpAdBlocker_Factory;
import acr.browser.lightning.adblock.allowlist.SessionAllowListModel;
import acr.browser.lightning.adblock.allowlist.SessionAllowListModel_Factory;
import acr.browser.lightning.adblock.parser.HostsFileParser;
import acr.browser.lightning.adblock.parser.HostsFileParser_Factory;
import acr.browser.lightning.adblock.source.AssetsHostsDataSource;
import acr.browser.lightning.adblock.source.AssetsHostsDataSource_Factory;
import acr.browser.lightning.adblock.source.FileHostsDataSource;
import acr.browser.lightning.adblock.source.FileHostsDataSource_Factory;
import acr.browser.lightning.adblock.source.FileHostsDataSource_Factory_Impl;
import acr.browser.lightning.adblock.source.PreferencesHostsDataSourceProvider;
import acr.browser.lightning.adblock.source.PreferencesHostsDataSourceProvider_Factory;
import acr.browser.lightning.adblock.source.UrlHostsDataSource;
import acr.browser.lightning.adblock.source.UrlHostsDataSource_Factory;
import acr.browser.lightning.adblock.source.UrlHostsDataSource_Factory_Impl;
import acr.browser.lightning.bookmark.LegacyBookmarkImporter;
import acr.browser.lightning.bookmark.NetscapeBookmarkFormatImporter;
import acr.browser.lightning.browser.BrowserActivity;
import acr.browser.lightning.browser.BrowserActivity_MembersInjector;
import acr.browser.lightning.browser.BrowserNavigator;
import acr.browser.lightning.browser.BrowserNavigator_Factory;
import acr.browser.lightning.browser.BrowserPresenter;
import acr.browser.lightning.browser.BrowserPresenter_Factory;
import acr.browser.lightning.browser.cleanup.BasicIncognitoExitCleanup_Factory;
import acr.browser.lightning.browser.cleanup.DelegatingExitCleanup;
import acr.browser.lightning.browser.cleanup.DelegatingExitCleanup_Factory;
import acr.browser.lightning.browser.cleanup.EnhancedIncognitoExitCleanup;
import acr.browser.lightning.browser.cleanup.EnhancedIncognitoExitCleanup_Factory;
import acr.browser.lightning.browser.cleanup.NormalExitCleanup;
import acr.browser.lightning.browser.cleanup.NormalExitCleanup_Factory;
import acr.browser.lightning.browser.data.CookieAdministrator;
import acr.browser.lightning.browser.data.DefaultCookieAdministrator;
import acr.browser.lightning.browser.data.DefaultCookieAdministrator_Factory;
import acr.browser.lightning.browser.download.DownloadPermissionsHelper;
import acr.browser.lightning.browser.download.DownloadPermissionsHelper_Factory;
import acr.browser.lightning.browser.history.DefaultHistoryRecord;
import acr.browser.lightning.browser.history.DefaultHistoryRecord_Factory;
import acr.browser.lightning.browser.history.HistoryRecord;
import acr.browser.lightning.browser.image.FaviconImageLoader;
import acr.browser.lightning.browser.keys.KeyEventAdapter;
import acr.browser.lightning.browser.menu.MenuItemAdapter;
import acr.browser.lightning.browser.notification.IncognitoNotification;
import acr.browser.lightning.browser.notification.IncognitoNotification_Factory;
import acr.browser.lightning.browser.notification.IncognitoTabCountNotifier;
import acr.browser.lightning.browser.notification.IncognitoTabCountNotifier_Factory;
import acr.browser.lightning.browser.notification.TabCountNotifier;
import acr.browser.lightning.browser.proxy.ProxyAdapter;
import acr.browser.lightning.browser.proxy.ProxyAdapter_Factory;
import acr.browser.lightning.browser.search.IntentExtractor;
import acr.browser.lightning.browser.search.IntentExtractor_Factory;
import acr.browser.lightning.browser.search.SearchBoxModel;
import acr.browser.lightning.browser.search.SearchBoxModel_Factory;
import acr.browser.lightning.browser.tab.BookmarkPageInitializer;
import acr.browser.lightning.browser.tab.BookmarkPageInitializer_Factory;
import acr.browser.lightning.browser.tab.DownloadPageInitializer;
import acr.browser.lightning.browser.tab.DownloadPageInitializer_Factory;
import acr.browser.lightning.browser.tab.HistoryPageInitializer;
import acr.browser.lightning.browser.tab.HistoryPageInitializer_Factory;
import acr.browser.lightning.browser.tab.HomePageInitializer;
import acr.browser.lightning.browser.tab.HomePageInitializer_Factory;
import acr.browser.lightning.browser.tab.PermissionInitializer;
import acr.browser.lightning.browser.tab.PermissionInitializer_Factory;
import acr.browser.lightning.browser.tab.PermissionInitializer_Factory_Impl;
import acr.browser.lightning.browser.tab.RecentTabModel_Factory;
import acr.browser.lightning.browser.tab.StartPageInitializer;
import acr.browser.lightning.browser.tab.StartPageInitializer_Factory;
import acr.browser.lightning.browser.tab.TabFactory;
import acr.browser.lightning.browser.tab.TabFactory_Factory;
import acr.browser.lightning.browser.tab.TabPager;
import acr.browser.lightning.browser.tab.TabPager_Factory;
import acr.browser.lightning.browser.tab.TabWebChromeClient;
import acr.browser.lightning.browser.tab.TabWebChromeClient_Factory;
import acr.browser.lightning.browser.tab.TabWebViewClient;
import acr.browser.lightning.browser.tab.TabWebViewClient_Factory;
import acr.browser.lightning.browser.tab.TabWebViewClient_Factory_Impl;
import acr.browser.lightning.browser.tab.TabsRepository;
import acr.browser.lightning.browser.tab.TabsRepository_Factory;
import acr.browser.lightning.browser.tab.UrlHandler;
import acr.browser.lightning.browser.tab.UrlHandler_Factory;
import acr.browser.lightning.browser.tab.WebViewFactory;
import acr.browser.lightning.browser.tab.WebViewFactory_Factory;
import acr.browser.lightning.browser.tab.bundle.BundleStore;
import acr.browser.lightning.browser.tab.bundle.DefaultBundleStore;
import acr.browser.lightning.browser.tab.bundle.DefaultBundleStore_Factory;
import acr.browser.lightning.browser.theme.DefaultThemeProvider;
import acr.browser.lightning.browser.theme.DefaultThemeProvider_Factory;
import acr.browser.lightning.browser.ui.UiConfiguration;
import acr.browser.lightning.browser.view.WebViewLongPressHandler;
import acr.browser.lightning.browser.view.WebViewLongPressHandler_Factory;
import acr.browser.lightning.browser.view.WebViewScrollCoordinator;
import acr.browser.lightning.browser.view.WebViewScrollCoordinator_Factory;
import acr.browser.lightning.browser.webrtc.WebRtcPermissionsModel;
import acr.browser.lightning.browser.webrtc.WebRtcPermissionsModel_Factory;
import acr.browser.lightning.database.adblock.HostsDatabase;
import acr.browser.lightning.database.adblock.HostsDatabase_Factory;
import acr.browser.lightning.database.adblock.HostsRepositoryInfo;
import acr.browser.lightning.database.adblock.HostsRepositoryInfo_Factory;
import acr.browser.lightning.database.allowlist.AdBlockAllowListDatabase;
import acr.browser.lightning.database.allowlist.AdBlockAllowListDatabase_Factory;
import acr.browser.lightning.database.bookmark.BookmarkDatabase;
import acr.browser.lightning.database.bookmark.BookmarkDatabase_Factory;
import acr.browser.lightning.database.downloads.DownloadsDatabase;
import acr.browser.lightning.database.downloads.DownloadsDatabase_Factory;
import acr.browser.lightning.database.history.HistoryDatabase;
import acr.browser.lightning.database.history.HistoryDatabase_Factory;
import acr.browser.lightning.device.BuildInfo;
import acr.browser.lightning.device.ScreenSize;
import acr.browser.lightning.device.ScreenSize_Factory;
import acr.browser.lightning.dialog.LightningDialogBuilder;
import acr.browser.lightning.dialog.LightningDialogBuilder_Factory;
import acr.browser.lightning.download.DownloadHandler;
import acr.browser.lightning.download.DownloadHandler_Factory;
import acr.browser.lightning.download.LightningDownloadListener;
import acr.browser.lightning.download.LightningDownloadListener_MembersInjector;
import acr.browser.lightning.favicon.FaviconModel;
import acr.browser.lightning.favicon.FaviconModel_Factory;
import acr.browser.lightning.html.ListPageReader;
import acr.browser.lightning.html.bookmark.BookmarkPageFactory;
import acr.browser.lightning.html.bookmark.BookmarkPageFactory_Factory;
import acr.browser.lightning.html.bookmark.BookmarkPageReader;
import acr.browser.lightning.html.download.DownloadPageFactory;
import acr.browser.lightning.html.download.DownloadPageFactory_Factory;
import acr.browser.lightning.html.history.HistoryPageFactory;
import acr.browser.lightning.html.history.HistoryPageFactory_Factory;
import acr.browser.lightning.html.homepage.HomePageFactory;
import acr.browser.lightning.html.homepage.HomePageFactory_Factory;
import acr.browser.lightning.html.homepage.HomePageReader;
import acr.browser.lightning.js.TextReflow;
import acr.browser.lightning.log.Logger;
import acr.browser.lightning.preference.DeveloperPreferences;
import acr.browser.lightning.preference.DeveloperPreferences_Factory;
import acr.browser.lightning.preference.UserPreferences;
import acr.browser.lightning.preference.UserPreferences_Factory;
import acr.browser.lightning.reading.activity.ReadingActivity;
import acr.browser.lightning.reading.activity.ReadingActivity_MembersInjector;
import acr.browser.lightning.search.SearchEngineProvider;
import acr.browser.lightning.search.SearchEngineProvider_Factory;
import acr.browser.lightning.search.SuggestionsAdapter;
import acr.browser.lightning.search.SuggestionsAdapter_MembersInjector;
import acr.browser.lightning.search.suggestions.RequestFactory;
import acr.browser.lightning.settings.activity.SettingsActivity;
import acr.browser.lightning.settings.activity.SettingsActivity_MembersInjector;
import acr.browser.lightning.settings.activity.ThemableSettingsActivity;
import acr.browser.lightning.settings.activity.ThemableSettingsActivity_MembersInjector;
import acr.browser.lightning.settings.fragment.AdBlockSettingsFragment;
import acr.browser.lightning.settings.fragment.AdBlockSettingsFragment_MembersInjector;
import acr.browser.lightning.settings.fragment.AdvancedSettingsFragment;
import acr.browser.lightning.settings.fragment.AdvancedSettingsFragment_MembersInjector;
import acr.browser.lightning.settings.fragment.BookmarkSettingsFragment;
import acr.browser.lightning.settings.fragment.BookmarkSettingsFragment_MembersInjector;
import acr.browser.lightning.settings.fragment.DebugSettingsFragment;
import acr.browser.lightning.settings.fragment.DebugSettingsFragment_MembersInjector;
import acr.browser.lightning.settings.fragment.DisplaySettingsFragment;
import acr.browser.lightning.settings.fragment.DisplaySettingsFragment_MembersInjector;
import acr.browser.lightning.settings.fragment.GeneralSettingsFragment;
import acr.browser.lightning.settings.fragment.GeneralSettingsFragment_MembersInjector;
import acr.browser.lightning.settings.fragment.PrivacySettingsFragment;
import acr.browser.lightning.settings.fragment.PrivacySettingsFragment_MembersInjector;
import acr.browser.lightning.ssl.SessionSslWarningPreferences;
import acr.browser.lightning.ssl.SessionSslWarningPreferences_Factory;
import acr.browser.lightning.utils.IntentUtils;
import acr.browser.lightning.utils.ProxyUtils;
import acr.browser.lightning.utils.ProxyUtils_Factory;
import android.app.Activity;
import android.app.Application;
import android.app.DownloadManager;
import android.app.NotificationManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import dagger.internal.SingleCheck;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import javax.annotation.Generated;
import javax.inject.Provider;
import net.i2p.android.ui.I2PAndroidHelper;
import okhttp3.CacheControl;
import okhttp3.OkHttpClient;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerAppComponent implements AppComponent {
  private final Application application;

  private final BuildInfo buildInfo;

  private final AppModule appModule;

  private final DaggerAppComponent appComponent = this;

  private Provider<Application> applicationProvider;

  private Provider<BookmarkDatabase> bookmarkDatabaseProvider;

  private Provider<Scheduler> providesIoThreadProvider;

  private Provider<Scheduler> providesMainThreadProvider;

  private Provider<BuildInfo> buildInfoProvider;

  private Provider<Logger> provideLoggerProvider;

  private Provider<SharedPreferences> provideUserPreferencesProvider;

  private Provider<Context> provideContextProvider;

  private Provider<ScreenSize> screenSizeProvider;

  private Provider<UserPreferences> userPreferencesProvider;

  private Provider<SharedPreferences> provideDebugPreferencesProvider;

  private Provider<DeveloperPreferences> developerPreferencesProvider;

  private Provider<I2PAndroidHelper> provideI2PAndroidHelperProvider;

  private Provider<ProxyUtils> proxyUtilsProvider;

  private Provider<ProxyAdapter> proxyAdapterProvider;

  private Provider<Scheduler> providesNetworkThreadProvider;

  private Provider<DownloadManager> providesDownloadManagerProvider;

  private Provider<DownloadHandler> downloadHandlerProvider;

  private Provider<DownloadsDatabase> downloadsDatabaseProvider;

  private Provider<HistoryDatabase> historyDatabaseProvider;

  private Provider<Single<OkHttpClient>> providesSuggestionsHttpClientProvider;

  private Provider<CacheControl> providesSuggestionsCacheControlProvider;

  private Provider<RequestFactory> providesSuggestionsRequestFactoryProvider;

  private Provider<SearchEngineProvider> searchEngineProvider;

  private Provider<Scheduler> providesDiskThreadProvider;

  private Provider<AssetManager> providesAssetManagerProvider;

  private Provider<HostsFileParser> hostsFileParserProvider;

  private Provider<AssetsHostsDataSource> assetsHostsDataSourceProvider;

  private FileHostsDataSource_Factory fileHostsDataSourceProvider;

  private Provider<FileHostsDataSource.Factory> factoryProvider;

  private Provider<Single<OkHttpClient>> providesHostsHttpClientProvider;

  private UrlHostsDataSource_Factory urlHostsDataSourceProvider;

  private Provider<UrlHostsDataSource.Factory> factoryProvider2;

  private Provider<PreferencesHostsDataSourceProvider> preferencesHostsDataSourceProvider;

  private Provider<HostsDatabase> hostsDatabaseProvider;

  private Provider<SharedPreferences> provideAdBlockPreferencesProvider;

  private Provider<HostsRepositoryInfo> hostsRepositoryInfoProvider;

  private Provider<BloomFilterAdBlocker> bloomFilterAdBlockerProvider;

  private Provider<NoOpAdBlocker> noOpAdBlockerProvider;

  private Provider<FaviconModel> faviconModelProvider;

  private Provider<InputMethodManager> providesInputMethodManagerProvider;

  private Provider<BookmarkPageReader> providesBookmarkPageReaderProvider;

  private Provider<HomePageReader> providesHomePageReaderProvider;

  private Provider<ListPageReader> providesListPageReaderProvider;

  private Provider<String> providesDefaultTabTitleProvider;

  private Provider<AdBlockAllowListDatabase> adBlockAllowListDatabaseProvider;

  private Provider<SessionAllowListModel> sessionAllowListModelProvider;

  private Provider<SessionSslWarningPreferences> sessionSslWarningPreferencesProvider;

  private Provider<TextReflow> providesTextReflowProvider;

  private Provider<WebRtcPermissionsModel> webRtcPermissionsModelProvider;

  private Provider<ClipboardManager> providesClipboardManagerProvider;

  private Provider<NotificationManager> providesNotificationManagerProvider;

  private DaggerAppComponent(AppModule appModuleParam, Application applicationParam,
      BuildInfo buildInfoParam) {
    this.application = applicationParam;
    this.buildInfo = buildInfoParam;
    this.appModule = appModuleParam;
    initialize(appModuleParam, applicationParam, buildInfoParam);

  }

  public static AppComponent.Builder builder() {
    return new Builder();
  }

  private InputMethodManager inputMethodManager() {
    return AppModule_ProvidesInputMethodManagerFactory.providesInputMethodManager(appModule, application);
  }

  @SuppressWarnings("unchecked")
  private void initialize(final AppModule appModuleParam, final Application applicationParam,
      final BuildInfo buildInfoParam) {
    this.applicationProvider = InstanceFactory.create(applicationParam);
    this.bookmarkDatabaseProvider = DoubleCheck.provider(BookmarkDatabase_Factory.create(applicationProvider));
    this.providesIoThreadProvider = DoubleCheck.provider(AppModule_ProvidesIoThreadFactory.create(appModuleParam));
    this.providesMainThreadProvider = DoubleCheck.provider(AppModule_ProvidesMainThreadFactory.create(appModuleParam));
    this.buildInfoProvider = InstanceFactory.create(buildInfoParam);
    this.provideLoggerProvider = DoubleCheck.provider(AppModule_ProvideLoggerFactory.create(appModuleParam, buildInfoProvider));
    this.provideUserPreferencesProvider = AppModule_ProvideUserPreferencesFactory.create(appModuleParam, applicationProvider);
    this.provideContextProvider = AppModule_ProvideContextFactory.create(appModuleParam, applicationProvider);
    this.screenSizeProvider = SingleCheck.provider(ScreenSize_Factory.create(provideContextProvider));
    this.userPreferencesProvider = DoubleCheck.provider(UserPreferences_Factory.create(provideUserPreferencesProvider, screenSizeProvider));
    this.provideDebugPreferencesProvider = AppModule_ProvideDebugPreferencesFactory.create(appModuleParam, applicationProvider);
    this.developerPreferencesProvider = DoubleCheck.provider(DeveloperPreferences_Factory.create(provideDebugPreferencesProvider));
    this.provideI2PAndroidHelperProvider = DoubleCheck.provider(AppModule_ProvideI2PAndroidHelperFactory.create(appModuleParam, applicationProvider));
    this.proxyUtilsProvider = DoubleCheck.provider(ProxyUtils_Factory.create(userPreferencesProvider, developerPreferencesProvider, provideI2PAndroidHelperProvider));
    this.proxyAdapterProvider = DoubleCheck.provider(ProxyAdapter_Factory.create(proxyUtilsProvider));
    this.providesNetworkThreadProvider = DoubleCheck.provider(AppModule_ProvidesNetworkThreadFactory.create(appModuleParam));
    this.providesDownloadManagerProvider = AppModule_ProvidesDownloadManagerFactory.create(appModuleParam, applicationProvider);
    this.downloadHandlerProvider = DoubleCheck.provider(DownloadHandler_Factory.create(providesDownloadManagerProvider, providesNetworkThreadProvider, providesMainThreadProvider, provideLoggerProvider));
    this.downloadsDatabaseProvider = DoubleCheck.provider(DownloadsDatabase_Factory.create(applicationProvider));
    this.historyDatabaseProvider = DoubleCheck.provider(HistoryDatabase_Factory.create(applicationProvider));
    this.providesSuggestionsHttpClientProvider = DoubleCheck.provider(AppModule_ProvidesSuggestionsHttpClientFactory.create(appModuleParam, applicationProvider));
    this.providesSuggestionsCacheControlProvider = DoubleCheck.provider(AppModule_ProvidesSuggestionsCacheControlFactory.create(appModuleParam));
    this.providesSuggestionsRequestFactoryProvider = DoubleCheck.provider(AppModule_ProvidesSuggestionsRequestFactoryFactory.create(appModuleParam, providesSuggestionsCacheControlProvider));
    this.searchEngineProvider = SingleCheck.provider(SearchEngineProvider_Factory.create(userPreferencesProvider, providesSuggestionsHttpClientProvider, providesSuggestionsRequestFactoryProvider, applicationProvider, provideLoggerProvider));
    this.providesDiskThreadProvider = DoubleCheck.provider(AppModule_ProvidesDiskThreadFactory.create(appModuleParam));
    this.providesAssetManagerProvider = AppModule_ProvidesAssetManagerFactory.create(appModuleParam, applicationProvider);
    this.hostsFileParserProvider = HostsFileParser_Factory.create(provideLoggerProvider);
    this.assetsHostsDataSourceProvider = AssetsHostsDataSource_Factory.create(providesAssetManagerProvider, hostsFileParserProvider, provideLoggerProvider);
    this.fileHostsDataSourceProvider = FileHostsDataSource_Factory.create(provideLoggerProvider);
    this.factoryProvider = FileHostsDataSource_Factory_Impl.create(fileHostsDataSourceProvider);
    this.providesHostsHttpClientProvider = DoubleCheck.provider(AppModule_ProvidesHostsHttpClientFactory.create(appModuleParam, applicationProvider));
    this.urlHostsDataSourceProvider = UrlHostsDataSource_Factory.create(providesHostsHttpClientProvider, provideLoggerProvider, userPreferencesProvider, applicationProvider);
    this.factoryProvider2 = UrlHostsDataSource_Factory_Impl.create(urlHostsDataSourceProvider);
    this.preferencesHostsDataSourceProvider = SingleCheck.provider(PreferencesHostsDataSourceProvider_Factory.create(userPreferencesProvider, assetsHostsDataSourceProvider, factoryProvider, factoryProvider2));
    this.hostsDatabaseProvider = DoubleCheck.provider(HostsDatabase_Factory.create(applicationProvider));
    this.provideAdBlockPreferencesProvider = AppModule_ProvideAdBlockPreferencesFactory.create(appModuleParam, applicationProvider);
    this.hostsRepositoryInfoProvider = HostsRepositoryInfo_Factory.create(provideAdBlockPreferencesProvider);
    this.bloomFilterAdBlockerProvider = DoubleCheck.provider(BloomFilterAdBlocker_Factory.create(provideLoggerProvider, (Provider) preferencesHostsDataSourceProvider, (Provider) hostsDatabaseProvider, hostsRepositoryInfoProvider, applicationProvider, providesIoThreadProvider, providesMainThreadProvider));
    this.noOpAdBlockerProvider = SingleCheck.provider(NoOpAdBlocker_Factory.create());
    this.faviconModelProvider = DoubleCheck.provider(FaviconModel_Factory.create(applicationProvider, provideLoggerProvider));
    this.providesInputMethodManagerProvider = AppModule_ProvidesInputMethodManagerFactory.create(appModuleParam, applicationProvider);
    this.providesBookmarkPageReaderProvider = AppModule_ProvidesBookmarkPageReaderFactory.create(appModuleParam);
    this.providesHomePageReaderProvider = AppModule_ProvidesHomePageReaderFactory.create(appModuleParam);
    this.providesListPageReaderProvider = AppModule_ProvidesListPageReaderFactory.create(appModuleParam);
    this.providesDefaultTabTitleProvider = AppModule_ProvidesDefaultTabTitleFactory.create(appModuleParam, applicationProvider);
    this.adBlockAllowListDatabaseProvider = DoubleCheck.provider(AdBlockAllowListDatabase_Factory.create(applicationProvider));
    this.sessionAllowListModelProvider = DoubleCheck.provider(SessionAllowListModel_Factory.create((Provider) adBlockAllowListDatabaseProvider, providesIoThreadProvider, provideLoggerProvider));
    this.sessionSslWarningPreferencesProvider = DoubleCheck.provider(SessionSslWarningPreferences_Factory.create());
    this.providesTextReflowProvider = AppModule_ProvidesTextReflowFactory.create(appModuleParam);
    this.webRtcPermissionsModelProvider = DoubleCheck.provider(WebRtcPermissionsModel_Factory.create());
    this.providesClipboardManagerProvider = AppModule_ProvidesClipboardManagerFactory.create(appModuleParam, applicationProvider);
    this.providesNotificationManagerProvider = AppModule_ProvidesNotificationManagerFactory.create(appModuleParam, applicationProvider);
  }

  @Override
  public void inject(BookmarkSettingsFragment fragment) {
    injectBookmarkSettingsFragment(fragment);
  }

  @Override
  public void inject(LightningDialogBuilder builder) {
  }

  @Override
  public void inject(ThemableBrowserActivity activity) {
    injectThemableBrowserActivity(activity);
  }

  @Override
  public void inject(AdvancedSettingsFragment advancedSettingsFragment) {
    injectAdvancedSettingsFragment(advancedSettingsFragment);
  }

  @Override
  public void inject(BrowserApp app) {
    injectBrowserApp(app);
  }

  @Override
  public void inject(ReadingActivity activity) {
    injectReadingActivity(activity);
  }

  @Override
  public void inject(SettingsActivity activity) {
    injectSettingsActivity(activity);
  }

  @Override
  public void inject(ThemableSettingsActivity activity) {
    injectThemableSettingsActivity(activity);
  }

  @Override
  public void inject(LightningDownloadListener listener) {
    injectLightningDownloadListener(listener);
  }

  @Override
  public void inject(PrivacySettingsFragment fragment) {
    injectPrivacySettingsFragment(fragment);
  }

  @Override
  public void inject(DebugSettingsFragment fragment) {
    injectDebugSettingsFragment(fragment);
  }

  @Override
  public void inject(SuggestionsAdapter suggestionsAdapter) {
    injectSuggestionsAdapter(suggestionsAdapter);
  }

  @Override
  public void inject(SearchBoxModel searchBoxModel) {
  }

  @Override
  public void inject(GeneralSettingsFragment generalSettingsFragment) {
    injectGeneralSettingsFragment(generalSettingsFragment);
  }

  @Override
  public void inject(DisplaySettingsFragment displaySettingsFragment) {
    injectDisplaySettingsFragment(displaySettingsFragment);
  }

  @Override
  public void inject(AdBlockSettingsFragment adBlockSettingsFragment) {
    injectAdBlockSettingsFragment(adBlockSettingsFragment);
  }

  @Override
  public BloomFilterAdBlocker provideBloomFilterAdBlocker() {
    return bloomFilterAdBlockerProvider.get();
  }

  @Override
  public NoOpAdBlocker provideNoOpAdBlocker() {
    return noOpAdBlockerProvider.get();
  }

  @Override
  public Browser2Component.Builder browser2ComponentBuilder() {
    return new Browser2ComponentBuilder(appComponent);
  }

  private BookmarkSettingsFragment injectBookmarkSettingsFragment(
      BookmarkSettingsFragment instance) {
    BookmarkSettingsFragment_MembersInjector.injectBookmarkRepository(instance, bookmarkDatabaseProvider.get());
    BookmarkSettingsFragment_MembersInjector.injectApplication(instance, application);
    BookmarkSettingsFragment_MembersInjector.injectNetscapeBookmarkFormatImporter(instance, new NetscapeBookmarkFormatImporter());
    BookmarkSettingsFragment_MembersInjector.injectLegacyBookmarkImporter(instance, new LegacyBookmarkImporter());
    BookmarkSettingsFragment_MembersInjector.injectDatabaseScheduler(instance, providesIoThreadProvider.get());
    BookmarkSettingsFragment_MembersInjector.injectMainScheduler(instance, providesMainThreadProvider.get());
    BookmarkSettingsFragment_MembersInjector.injectLogger(instance, provideLoggerProvider.get());
    return instance;
  }

  private ThemableBrowserActivity injectThemableBrowserActivity(ThemableBrowserActivity instance) {
    ThemableBrowserActivity_MembersInjector.injectUserPreferences(instance, userPreferencesProvider.get());
    return instance;
  }

  private AdvancedSettingsFragment injectAdvancedSettingsFragment(
      AdvancedSettingsFragment instance) {
    AdvancedSettingsFragment_MembersInjector.injectUserPreferences(instance, userPreferencesProvider.get());
    return instance;
  }

  private BrowserApp injectBrowserApp(BrowserApp instance) {
    BrowserApp_MembersInjector.injectDeveloperPreferences(instance, developerPreferencesProvider.get());
    BrowserApp_MembersInjector.injectBookmarkModel(instance, bookmarkDatabaseProvider.get());
    BrowserApp_MembersInjector.injectDatabaseScheduler(instance, providesIoThreadProvider.get());
    BrowserApp_MembersInjector.injectLogger(instance, provideLoggerProvider.get());
    BrowserApp_MembersInjector.injectBuildInfo(instance, buildInfo);
    BrowserApp_MembersInjector.injectProxyAdapter(instance, proxyAdapterProvider.get());
    return instance;
  }

  private ReadingActivity injectReadingActivity(ReadingActivity instance) {
    ReadingActivity_MembersInjector.injectMUserPreferences(instance, userPreferencesProvider.get());
    ReadingActivity_MembersInjector.injectMNetworkScheduler(instance, providesNetworkThreadProvider.get());
    ReadingActivity_MembersInjector.injectMMainScheduler(instance, providesMainThreadProvider.get());
    return instance;
  }

  private SettingsActivity injectSettingsActivity(SettingsActivity instance) {
    ThemableSettingsActivity_MembersInjector.injectUserPreferences(instance, userPreferencesProvider.get());
    SettingsActivity_MembersInjector.injectBuildInfo(instance, buildInfo);
    return instance;
  }

  private ThemableSettingsActivity injectThemableSettingsActivity(
      ThemableSettingsActivity instance) {
    ThemableSettingsActivity_MembersInjector.injectUserPreferences(instance, userPreferencesProvider.get());
    return instance;
  }

  private LightningDownloadListener injectLightningDownloadListener(
      LightningDownloadListener instance) {
    LightningDownloadListener_MembersInjector.injectUserPreferences(instance, userPreferencesProvider.get());
    LightningDownloadListener_MembersInjector.injectDownloadHandler(instance, downloadHandlerProvider.get());
    LightningDownloadListener_MembersInjector.injectDownloadsRepository(instance, downloadsDatabaseProvider.get());
    LightningDownloadListener_MembersInjector.injectLogger(instance, provideLoggerProvider.get());
    return instance;
  }

  private PrivacySettingsFragment injectPrivacySettingsFragment(PrivacySettingsFragment instance) {
    PrivacySettingsFragment_MembersInjector.injectHistoryRepository(instance, historyDatabaseProvider.get());
    PrivacySettingsFragment_MembersInjector.injectUserPreferences(instance, userPreferencesProvider.get());
    PrivacySettingsFragment_MembersInjector.injectDatabaseScheduler(instance, providesIoThreadProvider.get());
    PrivacySettingsFragment_MembersInjector.injectMainScheduler(instance, providesMainThreadProvider.get());
    return instance;
  }

  private DebugSettingsFragment injectDebugSettingsFragment(DebugSettingsFragment instance) {
    DebugSettingsFragment_MembersInjector.injectDeveloperPreferences(instance, developerPreferencesProvider.get());
    return instance;
  }

  private SuggestionsAdapter injectSuggestionsAdapter(SuggestionsAdapter instance) {
    SuggestionsAdapter_MembersInjector.injectBookmarkRepository(instance, bookmarkDatabaseProvider.get());
    SuggestionsAdapter_MembersInjector.injectUserPreferences(instance, userPreferencesProvider.get());
    SuggestionsAdapter_MembersInjector.injectHistoryRepository(instance, historyDatabaseProvider.get());
    SuggestionsAdapter_MembersInjector.injectDatabaseScheduler(instance, providesIoThreadProvider.get());
    SuggestionsAdapter_MembersInjector.injectNetworkScheduler(instance, providesNetworkThreadProvider.get());
    SuggestionsAdapter_MembersInjector.injectMainScheduler(instance, providesMainThreadProvider.get());
    SuggestionsAdapter_MembersInjector.injectSearchEngineProvider(instance, searchEngineProvider.get());
    return instance;
  }

  private GeneralSettingsFragment injectGeneralSettingsFragment(GeneralSettingsFragment instance) {
    GeneralSettingsFragment_MembersInjector.injectSearchEngineProvider(instance, searchEngineProvider.get());
    GeneralSettingsFragment_MembersInjector.injectUserPreferences(instance, userPreferencesProvider.get());
    return instance;
  }

  private DisplaySettingsFragment injectDisplaySettingsFragment(DisplaySettingsFragment instance) {
    DisplaySettingsFragment_MembersInjector.injectUserPreferences(instance, userPreferencesProvider.get());
    return instance;
  }

  private AdBlockSettingsFragment injectAdBlockSettingsFragment(AdBlockSettingsFragment instance) {
    AdBlockSettingsFragment_MembersInjector.injectUserPreferences(instance, userPreferencesProvider.get());
    AdBlockSettingsFragment_MembersInjector.injectMainScheduler(instance, providesMainThreadProvider.get());
    AdBlockSettingsFragment_MembersInjector.injectDiskScheduler(instance, providesDiskThreadProvider.get());
    AdBlockSettingsFragment_MembersInjector.injectBloomFilterAdBlocker(instance, bloomFilterAdBlockerProvider.get());
    return instance;
  }

  private static final class Builder implements AppComponent.Builder {
    private Application application;

    private BuildInfo buildInfo;

    @Override
    public Builder application(Application application) {
      this.application = Preconditions.checkNotNull(application);
      return this;
    }

    @Override
    public Builder buildInfo(BuildInfo buildInfo) {
      this.buildInfo = Preconditions.checkNotNull(buildInfo);
      return this;
    }

    @Override
    public AppComponent build() {
      Preconditions.checkBuilderRequirement(application, Application.class);
      Preconditions.checkBuilderRequirement(buildInfo, BuildInfo.class);
      return new DaggerAppComponent(new AppModule(), application, buildInfo);
    }
  }

  private static final class Browser2ComponentBuilder implements Browser2Component.Builder {
    private final DaggerAppComponent appComponent;

    private Activity activity;

    private FrameLayout browserFrame;

    private LinearLayout toolbarRoot;

    private View toolbar;

    private Intent initialIntent;

    private Boolean incognitoMode;

    private Browser2ComponentBuilder(DaggerAppComponent appComponent) {
      this.appComponent = appComponent;
    }

    @Override
    public Browser2ComponentBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public Browser2ComponentBuilder browserFrame(FrameLayout frameLayout) {
      this.browserFrame = Preconditions.checkNotNull(frameLayout);
      return this;
    }

    @Override
    public Browser2ComponentBuilder toolbarRoot(LinearLayout linearLayout) {
      this.toolbarRoot = Preconditions.checkNotNull(linearLayout);
      return this;
    }

    @Override
    public Browser2ComponentBuilder toolbar(View toolbar) {
      this.toolbar = Preconditions.checkNotNull(toolbar);
      return this;
    }

    @Override
    public Browser2ComponentBuilder initialIntent(Intent intent) {
      this.initialIntent = Preconditions.checkNotNull(intent);
      return this;
    }

    @Override
    public Browser2ComponentBuilder incognitoMode(boolean incognitoMode) {
      this.incognitoMode = Preconditions.checkNotNull(incognitoMode);
      return this;
    }

    @Override
    public Browser2Component build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      Preconditions.checkBuilderRequirement(browserFrame, FrameLayout.class);
      Preconditions.checkBuilderRequirement(toolbarRoot, LinearLayout.class);
      Preconditions.checkBuilderRequirement(toolbar, View.class);
      Preconditions.checkBuilderRequirement(initialIntent, Intent.class);
      Preconditions.checkBuilderRequirement(incognitoMode, Boolean.class);
      return new Browser2ComponentImpl(appComponent, new Browser2Module(), activity, browserFrame, toolbarRoot, toolbar, initialIntent, incognitoMode);
    }
  }

  private static final class Browser2ComponentImpl implements Browser2Component {
    private final Browser2Module browser2Module;

    private final DaggerAppComponent appComponent;

    private final Browser2ComponentImpl browser2ComponentImpl = this;

    private Provider<Activity> activityProvider;

    private Provider<Boolean> incognitoModeProvider;

    private Provider<WebViewFactory> webViewFactoryProvider;

    private Provider<FrameLayout> browserFrameProvider;

    private Provider<LinearLayout> toolbarRootProvider;

    private Provider<View> toolbarProvider;

    private Provider<WebViewScrollCoordinator> webViewScrollCoordinatorProvider;

    private Provider<WebViewLongPressHandler> webViewLongPressHandlerProvider;

    private Provider<TabPager> tabPagerProvider;

    private Provider<DefaultThemeProvider> defaultThemeProvider;

    private Provider<BookmarkPageFactory> bookmarkPageFactoryProvider;

    private Provider<BookmarkPageInitializer> bookmarkPageInitializerProvider;

    private Provider<HomePageFactory> homePageFactoryProvider;

    private Provider<StartPageInitializer> startPageInitializerProvider;

    private Provider<HomePageInitializer> homePageInitializerProvider;

    private Provider<DownloadPageFactory> downloadPageFactoryProvider;

    private Provider<DownloadPageInitializer> downloadPageInitializerProvider;

    private Provider<HistoryPageFactory> historyPageFactoryProvider;

    private Provider<HistoryPageInitializer> historyPageInitializerProvider;

    private Provider<DefaultBundleStore> defaultBundleStoreProvider;

    private Provider<BundleStore> providesBundleStoreProvider;

    private Provider<String> providesDefaultUserAgentProvider;

    private Provider<Bitmap> providesFrozenIconProvider;

    private Provider<AdBlocker> providesAdBlockerProvider;

    private Provider<IntentUtils> providesIntentUtilsProvider;

    private Provider<UrlHandler> urlHandlerProvider;

    private TabWebViewClient_Factory tabWebViewClientProvider;

    private Provider<TabWebViewClient.Factory> factoryProvider;

    private Provider<TabWebChromeClient> tabWebChromeClientProvider;

    private Provider<TabFactory> tabFactoryProvider;

    private Provider<Intent> initialIntentProvider;

    private Provider<IntentExtractor> intentExtractorProvider;

    private Provider<String> providesInitialUrlProvider;

    private PermissionInitializer_Factory permissionInitializerProvider;

    private Provider<PermissionInitializer.Factory> factoryProvider2;

    private Provider<TabsRepository> tabsRepositoryProvider;

    private Provider<DownloadPermissionsHelper> downloadPermissionsHelperProvider;

    private Provider<EnhancedIncognitoExitCleanup> enhancedIncognitoExitCleanupProvider;

    private Provider<NormalExitCleanup> normalExitCleanupProvider;

    private Provider<DelegatingExitCleanup> delegatingExitCleanupProvider;

    private Provider<BrowserNavigator> browserNavigatorProvider;

    private Provider<DefaultHistoryRecord> defaultHistoryRecordProvider;

    private Provider<HistoryRecord> providesHistoryRecordProvider;

    private Provider<SearchBoxModel> searchBoxModelProvider;

    private Provider<UiConfiguration> providesUiConfigurationProvider;

    private Provider<DefaultCookieAdministrator> defaultCookieAdministratorProvider;

    private Provider<CookieAdministrator> providesCookieAdministratorProvider;

    private Provider<IncognitoNotification> incognitoNotificationProvider;

    private Provider<IncognitoTabCountNotifier> incognitoTabCountNotifierProvider;

    private Provider<TabCountNotifier> providesTabCountNotifierProvider;

    private Provider<BrowserPresenter> browserPresenterProvider;

    private Provider<LightningDialogBuilder> lightningDialogBuilderProvider;

    private Browser2ComponentImpl(DaggerAppComponent appComponent,
        Browser2Module browser2ModuleParam, Activity activityParam, FrameLayout browserFrameParam,
        LinearLayout toolbarRootParam, View toolbarParam, Intent initialIntentParam,
        Boolean incognitoModeParam) {
      this.appComponent = appComponent;
      this.browser2Module = browser2ModuleParam;
      initialize(browser2ModuleParam, activityParam, browserFrameParam, toolbarRootParam, toolbarParam, initialIntentParam, incognitoModeParam);

    }

    private FaviconImageLoader faviconImageLoader() {
      return new FaviconImageLoader(appComponent.faviconModelProvider.get(), appComponent.application, appComponent.providesNetworkThreadProvider.get(), appComponent.providesMainThreadProvider.get());
    }

    private IntentExtractor intentExtractor() {
      return new IntentExtractor(appComponent.searchEngineProvider.get());
    }

    private UiConfiguration uiConfiguration() {
      return Browser2Module_ProvidesUiConfigurationFactory.providesUiConfiguration(browser2Module, appComponent.userPreferencesProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final Browser2Module browser2ModuleParam, final Activity activityParam,
        final FrameLayout browserFrameParam, final LinearLayout toolbarRootParam,
        final View toolbarParam, final Intent initialIntentParam,
        final Boolean incognitoModeParam) {
      this.activityProvider = InstanceFactory.create(activityParam);
      this.incognitoModeProvider = InstanceFactory.create(incognitoModeParam);
      this.webViewFactoryProvider = WebViewFactory_Factory.create(activityProvider, appComponent.provideLoggerProvider, appComponent.userPreferencesProvider, incognitoModeProvider);
      this.browserFrameProvider = InstanceFactory.create(browserFrameParam);
      this.toolbarRootProvider = InstanceFactory.create(toolbarRootParam);
      this.toolbarProvider = InstanceFactory.create(toolbarParam);
      this.webViewScrollCoordinatorProvider = WebViewScrollCoordinator_Factory.create(activityProvider, browserFrameProvider, toolbarRootProvider, toolbarProvider, appComponent.userPreferencesProvider, appComponent.providesInputMethodManagerProvider);
      this.webViewLongPressHandlerProvider = WebViewLongPressHandler_Factory.create(activityProvider);
      this.tabPagerProvider = DoubleCheck.provider(TabPager_Factory.create(browserFrameProvider, webViewScrollCoordinatorProvider, webViewLongPressHandlerProvider));
      this.defaultThemeProvider = DefaultThemeProvider_Factory.create(activityProvider);
      this.bookmarkPageFactoryProvider = BookmarkPageFactory_Factory.create(appComponent.applicationProvider, (Provider) appComponent.bookmarkDatabaseProvider, appComponent.faviconModelProvider, appComponent.providesIoThreadProvider, appComponent.providesDiskThreadProvider, appComponent.providesBookmarkPageReaderProvider, (Provider) defaultThemeProvider);
      this.bookmarkPageInitializerProvider = SingleCheck.provider(BookmarkPageInitializer_Factory.create(bookmarkPageFactoryProvider, appComponent.providesDiskThreadProvider, appComponent.providesMainThreadProvider));
      this.homePageFactoryProvider = HomePageFactory_Factory.create(appComponent.applicationProvider, appComponent.searchEngineProvider, appComponent.providesHomePageReaderProvider, (Provider) defaultThemeProvider);
      this.startPageInitializerProvider = SingleCheck.provider(StartPageInitializer_Factory.create(homePageFactoryProvider, appComponent.providesDiskThreadProvider, appComponent.providesMainThreadProvider));
      this.homePageInitializerProvider = SingleCheck.provider(HomePageInitializer_Factory.create(appComponent.userPreferencesProvider, startPageInitializerProvider, bookmarkPageInitializerProvider));
      this.downloadPageFactoryProvider = DownloadPageFactory_Factory.create(appComponent.applicationProvider, appComponent.userPreferencesProvider, (Provider) appComponent.downloadsDatabaseProvider, appComponent.providesListPageReaderProvider, (Provider) defaultThemeProvider);
      this.downloadPageInitializerProvider = SingleCheck.provider(DownloadPageInitializer_Factory.create(downloadPageFactoryProvider, appComponent.providesDiskThreadProvider, appComponent.providesMainThreadProvider));
      this.historyPageFactoryProvider = HistoryPageFactory_Factory.create(appComponent.providesListPageReaderProvider, appComponent.applicationProvider, (Provider) appComponent.historyDatabaseProvider, (Provider) defaultThemeProvider);
      this.historyPageInitializerProvider = SingleCheck.provider(HistoryPageInitializer_Factory.create(historyPageFactoryProvider, appComponent.providesDiskThreadProvider, appComponent.providesMainThreadProvider));
      this.defaultBundleStoreProvider = DefaultBundleStore_Factory.create(appComponent.applicationProvider, bookmarkPageInitializerProvider, homePageInitializerProvider, downloadPageInitializerProvider, historyPageInitializerProvider, appComponent.providesDiskThreadProvider);
      this.providesBundleStoreProvider = Browser2Module_ProvidesBundleStoreFactory.create(browser2ModuleParam, incognitoModeProvider, defaultBundleStoreProvider);
      this.providesDefaultUserAgentProvider = Browser2Module_ProvidesDefaultUserAgentFactory.create(browser2ModuleParam, appComponent.applicationProvider);
      this.providesFrozenIconProvider = Browser2Module_ProvidesFrozenIconFactory.create(browser2ModuleParam, activityProvider);
      this.providesAdBlockerProvider = Browser2Module_ProvidesAdBlockerFactory.create(browser2ModuleParam, appComponent.userPreferencesProvider, appComponent.bloomFilterAdBlockerProvider, appComponent.noOpAdBlockerProvider);
      this.providesIntentUtilsProvider = Browser2Module_ProvidesIntentUtilsFactory.create(browser2ModuleParam, activityProvider);
      this.urlHandlerProvider = UrlHandler_Factory.create(activityProvider, appComponent.provideLoggerProvider, providesIntentUtilsProvider, incognitoModeProvider);
      this.tabWebViewClientProvider = TabWebViewClient_Factory.create(providesAdBlockerProvider, (Provider) appComponent.sessionAllowListModelProvider, urlHandlerProvider, (Provider) appComponent.proxyAdapterProvider, appComponent.userPreferencesProvider, (Provider) appComponent.sessionSslWarningPreferencesProvider, appComponent.providesTextReflowProvider, appComponent.provideLoggerProvider);
      this.factoryProvider = TabWebViewClient_Factory_Impl.create(tabWebViewClientProvider);
      this.tabWebChromeClientProvider = TabWebChromeClient_Factory.create(activityProvider, appComponent.faviconModelProvider, appComponent.providesDiskThreadProvider, appComponent.userPreferencesProvider, appComponent.webRtcPermissionsModelProvider);
      this.tabFactoryProvider = TabFactory_Factory.create(webViewFactoryProvider, appComponent.userPreferencesProvider, providesDefaultUserAgentProvider, appComponent.providesDefaultTabTitleProvider, providesFrozenIconProvider, (Provider) appComponent.proxyAdapterProvider, factoryProvider, tabWebChromeClientProvider);
      this.initialIntentProvider = InstanceFactory.create(initialIntentParam);
      this.intentExtractorProvider = IntentExtractor_Factory.create(appComponent.searchEngineProvider);
      this.providesInitialUrlProvider = Browser2Module_ProvidesInitialUrlFactory.create(browser2ModuleParam, initialIntentProvider, intentExtractorProvider);
      this.permissionInitializerProvider = PermissionInitializer_Factory.create(activityProvider, homePageInitializerProvider);
      this.factoryProvider2 = PermissionInitializer_Factory_Impl.create(permissionInitializerProvider);
      this.tabsRepositoryProvider = TabsRepository_Factory.create(webViewFactoryProvider, tabPagerProvider, appComponent.providesDiskThreadProvider, appComponent.providesMainThreadProvider, providesBundleStoreProvider, RecentTabModel_Factory.create(), tabFactoryProvider, appComponent.userPreferencesProvider, providesInitialUrlProvider, factoryProvider2);
      this.downloadPermissionsHelperProvider = DownloadPermissionsHelper_Factory.create(appComponent.downloadHandlerProvider, appComponent.userPreferencesProvider, appComponent.provideLoggerProvider, (Provider) appComponent.downloadsDatabaseProvider, appComponent.providesIoThreadProvider);
      this.enhancedIncognitoExitCleanupProvider = EnhancedIncognitoExitCleanup_Factory.create(appComponent.provideLoggerProvider, activityProvider);
      this.normalExitCleanupProvider = NormalExitCleanup_Factory.create(appComponent.userPreferencesProvider, appComponent.provideLoggerProvider, appComponent.historyDatabaseProvider, appComponent.providesIoThreadProvider, activityProvider);
      this.delegatingExitCleanupProvider = DelegatingExitCleanup_Factory.create(BasicIncognitoExitCleanup_Factory.create(), enhancedIncognitoExitCleanupProvider, normalExitCleanupProvider, activityProvider);
      this.browserNavigatorProvider = BrowserNavigator_Factory.create(activityProvider, appComponent.providesClipboardManagerProvider, appComponent.provideLoggerProvider, downloadPermissionsHelperProvider, (Provider) delegatingExitCleanupProvider);
      this.defaultHistoryRecordProvider = DefaultHistoryRecord_Factory.create((Provider) appComponent.historyDatabaseProvider, appComponent.providesIoThreadProvider);
      this.providesHistoryRecordProvider = Browser2Module_ProvidesHistoryRecordFactory.create(browser2ModuleParam, incognitoModeProvider, defaultHistoryRecordProvider);
      this.searchBoxModelProvider = SingleCheck.provider(SearchBoxModel_Factory.create(appComponent.userPreferencesProvider, appComponent.applicationProvider));
      this.providesUiConfigurationProvider = Browser2Module_ProvidesUiConfigurationFactory.create(browser2ModuleParam, appComponent.userPreferencesProvider);
      this.defaultCookieAdministratorProvider = DefaultCookieAdministrator_Factory.create(appComponent.userPreferencesProvider);
      this.providesCookieAdministratorProvider = Browser2Module_ProvidesCookieAdministratorFactory.create(browser2ModuleParam, incognitoModeProvider, defaultCookieAdministratorProvider, defaultCookieAdministratorProvider);
      this.incognitoNotificationProvider = IncognitoNotification_Factory.create(activityProvider, appComponent.providesNotificationManagerProvider);
      this.incognitoTabCountNotifierProvider = IncognitoTabCountNotifier_Factory.create(incognitoNotificationProvider);
      this.providesTabCountNotifierProvider = Browser2Module_ProvidesTabCountNotifierFactory.create(browser2ModuleParam, incognitoModeProvider, incognitoTabCountNotifierProvider);
      this.browserPresenterProvider = DoubleCheck.provider(BrowserPresenter_Factory.create((Provider) tabsRepositoryProvider, (Provider) browserNavigatorProvider, (Provider) appComponent.bookmarkDatabaseProvider, (Provider) appComponent.downloadsDatabaseProvider, (Provider) appComponent.historyDatabaseProvider, appComponent.providesDiskThreadProvider, appComponent.providesMainThreadProvider, appComponent.providesIoThreadProvider, providesHistoryRecordProvider, bookmarkPageFactoryProvider, homePageInitializerProvider, historyPageInitializerProvider, downloadPageInitializerProvider, searchBoxModelProvider, appComponent.searchEngineProvider, providesUiConfigurationProvider, historyPageFactoryProvider, (Provider) appComponent.sessionAllowListModelProvider, providesCookieAdministratorProvider, providesTabCountNotifierProvider, incognitoModeProvider));
      this.lightningDialogBuilderProvider = SingleCheck.provider(LightningDialogBuilder_Factory.create());
    }

    @Override
    public void inject(BrowserActivity browserActivity) {
      injectBrowserActivity(browserActivity);
    }

    private BrowserActivity injectBrowserActivity(BrowserActivity instance) {
      ThemableBrowserActivity_MembersInjector.injectUserPreferences(instance, appComponent.userPreferencesProvider.get());
      BrowserActivity_MembersInjector.injectImageLoader(instance, faviconImageLoader());
      BrowserActivity_MembersInjector.injectKeyEventAdapter(instance, new KeyEventAdapter());
      BrowserActivity_MembersInjector.injectMenuItemAdapter(instance, new MenuItemAdapter());
      BrowserActivity_MembersInjector.injectInputMethodManager(instance, appComponent.inputMethodManager());
      BrowserActivity_MembersInjector.injectPresenter(instance, browserPresenterProvider.get());
      BrowserActivity_MembersInjector.injectTabPager(instance, tabPagerProvider.get());
      BrowserActivity_MembersInjector.injectIntentExtractor(instance, intentExtractor());
      BrowserActivity_MembersInjector.injectLightningDialogBuilder(instance, lightningDialogBuilderProvider.get());
      BrowserActivity_MembersInjector.injectUiConfiguration(instance, uiConfiguration());
      BrowserActivity_MembersInjector.injectProxyUtils(instance, appComponent.proxyUtilsProvider.get());
      return instance;
    }
  }
}
