package acr.browser.lightning.download;

import acr.browser.lightning.database.downloads.DownloadsRepository;
import acr.browser.lightning.log.Logger;
import acr.browser.lightning.preference.UserPreferences;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
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
public final class LightningDownloadListener_MembersInjector implements MembersInjector<LightningDownloadListener> {
  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<DownloadHandler> downloadHandlerProvider;

  private final Provider<DownloadsRepository> downloadsRepositoryProvider;

  private final Provider<Logger> loggerProvider;

  public LightningDownloadListener_MembersInjector(
      Provider<UserPreferences> userPreferencesProvider,
      Provider<DownloadHandler> downloadHandlerProvider,
      Provider<DownloadsRepository> downloadsRepositoryProvider, Provider<Logger> loggerProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
    this.downloadHandlerProvider = downloadHandlerProvider;
    this.downloadsRepositoryProvider = downloadsRepositoryProvider;
    this.loggerProvider = loggerProvider;
  }

  public static MembersInjector<LightningDownloadListener> create(
      Provider<UserPreferences> userPreferencesProvider,
      Provider<DownloadHandler> downloadHandlerProvider,
      Provider<DownloadsRepository> downloadsRepositoryProvider, Provider<Logger> loggerProvider) {
    return new LightningDownloadListener_MembersInjector(userPreferencesProvider, downloadHandlerProvider, downloadsRepositoryProvider, loggerProvider);
  }

  @Override
  public void injectMembers(LightningDownloadListener instance) {
    injectUserPreferences(instance, userPreferencesProvider.get());
    injectDownloadHandler(instance, downloadHandlerProvider.get());
    injectDownloadsRepository(instance, downloadsRepositoryProvider.get());
    injectLogger(instance, loggerProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.download.LightningDownloadListener.userPreferences")
  public static void injectUserPreferences(LightningDownloadListener instance,
      UserPreferences userPreferences) {
    instance.userPreferences = userPreferences;
  }

  @InjectedFieldSignature("acr.browser.lightning.download.LightningDownloadListener.downloadHandler")
  public static void injectDownloadHandler(LightningDownloadListener instance,
      DownloadHandler downloadHandler) {
    instance.downloadHandler = downloadHandler;
  }

  @InjectedFieldSignature("acr.browser.lightning.download.LightningDownloadListener.downloadsRepository")
  public static void injectDownloadsRepository(LightningDownloadListener instance,
      DownloadsRepository downloadsRepository) {
    instance.downloadsRepository = downloadsRepository;
  }

  @InjectedFieldSignature("acr.browser.lightning.download.LightningDownloadListener.logger")
  public static void injectLogger(LightningDownloadListener instance, Logger logger) {
    instance.logger = logger;
  }
}
