package acr.browser.lightning.browser.tab;

import acr.browser.lightning.html.download.DownloadPageFactory;
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
public final class DownloadPageInitializer_Factory implements Factory<DownloadPageInitializer> {
  private final Provider<DownloadPageFactory> downloadPageFactoryProvider;

  private final Provider<Scheduler> diskSchedulerProvider;

  private final Provider<Scheduler> foregroundSchedulerProvider;

  public DownloadPageInitializer_Factory(Provider<DownloadPageFactory> downloadPageFactoryProvider,
      Provider<Scheduler> diskSchedulerProvider, Provider<Scheduler> foregroundSchedulerProvider) {
    this.downloadPageFactoryProvider = downloadPageFactoryProvider;
    this.diskSchedulerProvider = diskSchedulerProvider;
    this.foregroundSchedulerProvider = foregroundSchedulerProvider;
  }

  @Override
  public DownloadPageInitializer get() {
    return newInstance(downloadPageFactoryProvider.get(), diskSchedulerProvider.get(), foregroundSchedulerProvider.get());
  }

  public static DownloadPageInitializer_Factory create(
      Provider<DownloadPageFactory> downloadPageFactoryProvider,
      Provider<Scheduler> diskSchedulerProvider, Provider<Scheduler> foregroundSchedulerProvider) {
    return new DownloadPageInitializer_Factory(downloadPageFactoryProvider, diskSchedulerProvider, foregroundSchedulerProvider);
  }

  public static DownloadPageInitializer newInstance(DownloadPageFactory downloadPageFactory,
      Scheduler diskScheduler, Scheduler foregroundScheduler) {
    return new DownloadPageInitializer(downloadPageFactory, diskScheduler, foregroundScheduler);
  }
}
