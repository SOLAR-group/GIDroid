package acr.browser.lightning.browser.download;

import acr.browser.lightning.database.downloads.DownloadsRepository;
import acr.browser.lightning.download.DownloadHandler;
import acr.browser.lightning.log.Logger;
import acr.browser.lightning.preference.UserPreferences;
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
public final class DownloadPermissionsHelper_Factory implements Factory<DownloadPermissionsHelper> {
  private final Provider<DownloadHandler> downloadHandlerProvider;

  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<Logger> loggerProvider;

  private final Provider<DownloadsRepository> downloadsRepositoryProvider;

  private final Provider<Scheduler> databaseSchedulerProvider;

  public DownloadPermissionsHelper_Factory(Provider<DownloadHandler> downloadHandlerProvider,
      Provider<UserPreferences> userPreferencesProvider, Provider<Logger> loggerProvider,
      Provider<DownloadsRepository> downloadsRepositoryProvider,
      Provider<Scheduler> databaseSchedulerProvider) {
    this.downloadHandlerProvider = downloadHandlerProvider;
    this.userPreferencesProvider = userPreferencesProvider;
    this.loggerProvider = loggerProvider;
    this.downloadsRepositoryProvider = downloadsRepositoryProvider;
    this.databaseSchedulerProvider = databaseSchedulerProvider;
  }

  @Override
  public DownloadPermissionsHelper get() {
    return newInstance(downloadHandlerProvider.get(), userPreferencesProvider.get(), loggerProvider.get(), downloadsRepositoryProvider.get(), databaseSchedulerProvider.get());
  }

  public static DownloadPermissionsHelper_Factory create(
      Provider<DownloadHandler> downloadHandlerProvider,
      Provider<UserPreferences> userPreferencesProvider, Provider<Logger> loggerProvider,
      Provider<DownloadsRepository> downloadsRepositoryProvider,
      Provider<Scheduler> databaseSchedulerProvider) {
    return new DownloadPermissionsHelper_Factory(downloadHandlerProvider, userPreferencesProvider, loggerProvider, downloadsRepositoryProvider, databaseSchedulerProvider);
  }

  public static DownloadPermissionsHelper newInstance(DownloadHandler downloadHandler,
      UserPreferences userPreferences, Logger logger, DownloadsRepository downloadsRepository,
      Scheduler databaseScheduler) {
    return new DownloadPermissionsHelper(downloadHandler, userPreferences, logger, downloadsRepository, databaseScheduler);
  }
}
