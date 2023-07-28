package acr.browser.lightning.browser.tab.bundle;

import acr.browser.lightning.browser.tab.BookmarkPageInitializer;
import acr.browser.lightning.browser.tab.DownloadPageInitializer;
import acr.browser.lightning.browser.tab.HistoryPageInitializer;
import acr.browser.lightning.browser.tab.HomePageInitializer;
import android.app.Application;
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
public final class DefaultBundleStore_Factory implements Factory<DefaultBundleStore> {
  private final Provider<Application> applicationProvider;

  private final Provider<BookmarkPageInitializer> bookmarkPageInitializerProvider;

  private final Provider<HomePageInitializer> homePageInitializerProvider;

  private final Provider<DownloadPageInitializer> downloadPageInitializerProvider;

  private final Provider<HistoryPageInitializer> historyPageInitializerProvider;

  private final Provider<Scheduler> diskSchedulerProvider;

  public DefaultBundleStore_Factory(Provider<Application> applicationProvider,
      Provider<BookmarkPageInitializer> bookmarkPageInitializerProvider,
      Provider<HomePageInitializer> homePageInitializerProvider,
      Provider<DownloadPageInitializer> downloadPageInitializerProvider,
      Provider<HistoryPageInitializer> historyPageInitializerProvider,
      Provider<Scheduler> diskSchedulerProvider) {
    this.applicationProvider = applicationProvider;
    this.bookmarkPageInitializerProvider = bookmarkPageInitializerProvider;
    this.homePageInitializerProvider = homePageInitializerProvider;
    this.downloadPageInitializerProvider = downloadPageInitializerProvider;
    this.historyPageInitializerProvider = historyPageInitializerProvider;
    this.diskSchedulerProvider = diskSchedulerProvider;
  }

  @Override
  public DefaultBundleStore get() {
    return newInstance(applicationProvider.get(), bookmarkPageInitializerProvider.get(), homePageInitializerProvider.get(), downloadPageInitializerProvider.get(), historyPageInitializerProvider.get(), diskSchedulerProvider.get());
  }

  public static DefaultBundleStore_Factory create(Provider<Application> applicationProvider,
      Provider<BookmarkPageInitializer> bookmarkPageInitializerProvider,
      Provider<HomePageInitializer> homePageInitializerProvider,
      Provider<DownloadPageInitializer> downloadPageInitializerProvider,
      Provider<HistoryPageInitializer> historyPageInitializerProvider,
      Provider<Scheduler> diskSchedulerProvider) {
    return new DefaultBundleStore_Factory(applicationProvider, bookmarkPageInitializerProvider, homePageInitializerProvider, downloadPageInitializerProvider, historyPageInitializerProvider, diskSchedulerProvider);
  }

  public static DefaultBundleStore newInstance(Application application,
      BookmarkPageInitializer bookmarkPageInitializer, HomePageInitializer homePageInitializer,
      DownloadPageInitializer downloadPageInitializer,
      HistoryPageInitializer historyPageInitializer, Scheduler diskScheduler) {
    return new DefaultBundleStore(application, bookmarkPageInitializer, homePageInitializer, downloadPageInitializer, historyPageInitializer, diskScheduler);
  }
}
