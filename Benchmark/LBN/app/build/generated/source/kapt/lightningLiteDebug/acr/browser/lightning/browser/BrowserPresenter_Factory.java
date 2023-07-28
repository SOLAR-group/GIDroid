package acr.browser.lightning.browser;

import acr.browser.lightning.adblock.allowlist.AllowListModel;
import acr.browser.lightning.browser.data.CookieAdministrator;
import acr.browser.lightning.browser.history.HistoryRecord;
import acr.browser.lightning.browser.notification.TabCountNotifier;
import acr.browser.lightning.browser.search.SearchBoxModel;
import acr.browser.lightning.browser.tab.DownloadPageInitializer;
import acr.browser.lightning.browser.tab.HistoryPageInitializer;
import acr.browser.lightning.browser.tab.HomePageInitializer;
import acr.browser.lightning.browser.ui.UiConfiguration;
import acr.browser.lightning.database.bookmark.BookmarkRepository;
import acr.browser.lightning.database.downloads.DownloadsRepository;
import acr.browser.lightning.database.history.HistoryRepository;
import acr.browser.lightning.html.bookmark.BookmarkPageFactory;
import acr.browser.lightning.html.history.HistoryPageFactory;
import acr.browser.lightning.search.SearchEngineProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import io.reactivex.Scheduler;
import javax.annotation.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class BrowserPresenter_Factory implements Factory<BrowserPresenter> {
  private final Provider<BrowserContract.Model> modelProvider;

  private final Provider<BrowserContract.Navigator> navigatorProvider;

  private final Provider<BookmarkRepository> bookmarkRepositoryProvider;

  private final Provider<DownloadsRepository> downloadsRepositoryProvider;

  private final Provider<HistoryRepository> historyRepositoryProvider;

  private final Provider<Scheduler> diskSchedulerProvider;

  private final Provider<Scheduler> mainSchedulerProvider;

  private final Provider<Scheduler> databaseSchedulerProvider;

  private final Provider<HistoryRecord> historyRecordProvider;

  private final Provider<BookmarkPageFactory> bookmarkPageFactoryProvider;

  private final Provider<HomePageInitializer> homePageInitializerProvider;

  private final Provider<HistoryPageInitializer> historyPageInitializerProvider;

  private final Provider<DownloadPageInitializer> downloadPageInitializerProvider;

  private final Provider<SearchBoxModel> searchBoxModelProvider;

  private final Provider<SearchEngineProvider> searchEngineProvider;

  private final Provider<UiConfiguration> uiConfigurationProvider;

  private final Provider<HistoryPageFactory> historyPageFactoryProvider;

  private final Provider<AllowListModel> allowListModelProvider;

  private final Provider<CookieAdministrator> cookieAdministratorProvider;

  private final Provider<TabCountNotifier> tabCountNotifierProvider;

  private final Provider<Boolean> incognitoModeProvider;

  public BrowserPresenter_Factory(Provider<BrowserContract.Model> modelProvider,
      Provider<BrowserContract.Navigator> navigatorProvider,
      Provider<BookmarkRepository> bookmarkRepositoryProvider,
      Provider<DownloadsRepository> downloadsRepositoryProvider,
      Provider<HistoryRepository> historyRepositoryProvider,
      Provider<Scheduler> diskSchedulerProvider, Provider<Scheduler> mainSchedulerProvider,
      Provider<Scheduler> databaseSchedulerProvider, Provider<HistoryRecord> historyRecordProvider,
      Provider<BookmarkPageFactory> bookmarkPageFactoryProvider,
      Provider<HomePageInitializer> homePageInitializerProvider,
      Provider<HistoryPageInitializer> historyPageInitializerProvider,
      Provider<DownloadPageInitializer> downloadPageInitializerProvider,
      Provider<SearchBoxModel> searchBoxModelProvider,
      Provider<SearchEngineProvider> searchEngineProvider,
      Provider<UiConfiguration> uiConfigurationProvider,
      Provider<HistoryPageFactory> historyPageFactoryProvider,
      Provider<AllowListModel> allowListModelProvider,
      Provider<CookieAdministrator> cookieAdministratorProvider,
      Provider<TabCountNotifier> tabCountNotifierProvider,
      Provider<Boolean> incognitoModeProvider) {
    this.modelProvider = modelProvider;
    this.navigatorProvider = navigatorProvider;
    this.bookmarkRepositoryProvider = bookmarkRepositoryProvider;
    this.downloadsRepositoryProvider = downloadsRepositoryProvider;
    this.historyRepositoryProvider = historyRepositoryProvider;
    this.diskSchedulerProvider = diskSchedulerProvider;
    this.mainSchedulerProvider = mainSchedulerProvider;
    this.databaseSchedulerProvider = databaseSchedulerProvider;
    this.historyRecordProvider = historyRecordProvider;
    this.bookmarkPageFactoryProvider = bookmarkPageFactoryProvider;
    this.homePageInitializerProvider = homePageInitializerProvider;
    this.historyPageInitializerProvider = historyPageInitializerProvider;
    this.downloadPageInitializerProvider = downloadPageInitializerProvider;
    this.searchBoxModelProvider = searchBoxModelProvider;
    this.searchEngineProvider = searchEngineProvider;
    this.uiConfigurationProvider = uiConfigurationProvider;
    this.historyPageFactoryProvider = historyPageFactoryProvider;
    this.allowListModelProvider = allowListModelProvider;
    this.cookieAdministratorProvider = cookieAdministratorProvider;
    this.tabCountNotifierProvider = tabCountNotifierProvider;
    this.incognitoModeProvider = incognitoModeProvider;
  }

  @Override
  public BrowserPresenter get() {
    return newInstance(modelProvider.get(), navigatorProvider.get(), bookmarkRepositoryProvider.get(), downloadsRepositoryProvider.get(), historyRepositoryProvider.get(), diskSchedulerProvider.get(), mainSchedulerProvider.get(), databaseSchedulerProvider.get(), historyRecordProvider.get(), bookmarkPageFactoryProvider.get(), homePageInitializerProvider.get(), historyPageInitializerProvider.get(), downloadPageInitializerProvider.get(), searchBoxModelProvider.get(), searchEngineProvider.get(), uiConfigurationProvider.get(), historyPageFactoryProvider.get(), allowListModelProvider.get(), cookieAdministratorProvider.get(), tabCountNotifierProvider.get(), incognitoModeProvider.get());
  }

  public static BrowserPresenter_Factory create(Provider<BrowserContract.Model> modelProvider,
      Provider<BrowserContract.Navigator> navigatorProvider,
      Provider<BookmarkRepository> bookmarkRepositoryProvider,
      Provider<DownloadsRepository> downloadsRepositoryProvider,
      Provider<HistoryRepository> historyRepositoryProvider,
      Provider<Scheduler> diskSchedulerProvider, Provider<Scheduler> mainSchedulerProvider,
      Provider<Scheduler> databaseSchedulerProvider, Provider<HistoryRecord> historyRecordProvider,
      Provider<BookmarkPageFactory> bookmarkPageFactoryProvider,
      Provider<HomePageInitializer> homePageInitializerProvider,
      Provider<HistoryPageInitializer> historyPageInitializerProvider,
      Provider<DownloadPageInitializer> downloadPageInitializerProvider,
      Provider<SearchBoxModel> searchBoxModelProvider,
      Provider<SearchEngineProvider> searchEngineProvider,
      Provider<UiConfiguration> uiConfigurationProvider,
      Provider<HistoryPageFactory> historyPageFactoryProvider,
      Provider<AllowListModel> allowListModelProvider,
      Provider<CookieAdministrator> cookieAdministratorProvider,
      Provider<TabCountNotifier> tabCountNotifierProvider,
      Provider<Boolean> incognitoModeProvider) {
    return new BrowserPresenter_Factory(modelProvider, navigatorProvider, bookmarkRepositoryProvider, downloadsRepositoryProvider, historyRepositoryProvider, diskSchedulerProvider, mainSchedulerProvider, databaseSchedulerProvider, historyRecordProvider, bookmarkPageFactoryProvider, homePageInitializerProvider, historyPageInitializerProvider, downloadPageInitializerProvider, searchBoxModelProvider, searchEngineProvider, uiConfigurationProvider, historyPageFactoryProvider, allowListModelProvider, cookieAdministratorProvider, tabCountNotifierProvider, incognitoModeProvider);
  }

  public static BrowserPresenter newInstance(BrowserContract.Model model,
      BrowserContract.Navigator navigator, BookmarkRepository bookmarkRepository,
      DownloadsRepository downloadsRepository, HistoryRepository historyRepository,
      Scheduler diskScheduler, Scheduler mainScheduler, Scheduler databaseScheduler,
      HistoryRecord historyRecord, BookmarkPageFactory bookmarkPageFactory,
      HomePageInitializer homePageInitializer, HistoryPageInitializer historyPageInitializer,
      DownloadPageInitializer downloadPageInitializer, SearchBoxModel searchBoxModel,
      SearchEngineProvider searchEngineProvider, UiConfiguration uiConfiguration,
      HistoryPageFactory historyPageFactory, AllowListModel allowListModel,
      CookieAdministrator cookieAdministrator, TabCountNotifier tabCountNotifier,
      boolean incognitoMode) {
    return new BrowserPresenter(model, navigator, bookmarkRepository, downloadsRepository, historyRepository, diskScheduler, mainScheduler, databaseScheduler, historyRecord, bookmarkPageFactory, homePageInitializer, historyPageInitializer, downloadPageInitializer, searchBoxModel, searchEngineProvider, uiConfiguration, historyPageFactory, allowListModel, cookieAdministrator, tabCountNotifier, incognitoMode);
  }
}
