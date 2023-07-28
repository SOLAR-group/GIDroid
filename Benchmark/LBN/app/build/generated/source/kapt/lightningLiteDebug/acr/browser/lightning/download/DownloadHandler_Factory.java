package acr.browser.lightning.download;

import acr.browser.lightning.log.Logger;
import android.app.DownloadManager;
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
public final class DownloadHandler_Factory implements Factory<DownloadHandler> {
  private final Provider<DownloadManager> downloadManagerProvider;

  private final Provider<Scheduler> networkSchedulerProvider;

  private final Provider<Scheduler> mainSchedulerProvider;

  private final Provider<Logger> loggerProvider;

  public DownloadHandler_Factory(Provider<DownloadManager> downloadManagerProvider,
      Provider<Scheduler> networkSchedulerProvider, Provider<Scheduler> mainSchedulerProvider,
      Provider<Logger> loggerProvider) {
    this.downloadManagerProvider = downloadManagerProvider;
    this.networkSchedulerProvider = networkSchedulerProvider;
    this.mainSchedulerProvider = mainSchedulerProvider;
    this.loggerProvider = loggerProvider;
  }

  @Override
  public DownloadHandler get() {
    return newInstance(downloadManagerProvider.get(), networkSchedulerProvider.get(), mainSchedulerProvider.get(), loggerProvider.get());
  }

  public static DownloadHandler_Factory create(Provider<DownloadManager> downloadManagerProvider,
      Provider<Scheduler> networkSchedulerProvider, Provider<Scheduler> mainSchedulerProvider,
      Provider<Logger> loggerProvider) {
    return new DownloadHandler_Factory(downloadManagerProvider, networkSchedulerProvider, mainSchedulerProvider, loggerProvider);
  }

  public static DownloadHandler newInstance(DownloadManager downloadManager,
      Scheduler networkScheduler, Scheduler mainScheduler, Logger logger) {
    return new DownloadHandler(downloadManager, networkScheduler, mainScheduler, logger);
  }
}
