package acr.browser.lightning.browser;

import acr.browser.lightning.browser.cleanup.ExitCleanup;
import acr.browser.lightning.browser.download.DownloadPermissionsHelper;
import acr.browser.lightning.log.Logger;
import android.app.Activity;
import android.content.ClipboardManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class BrowserNavigator_Factory implements Factory<BrowserNavigator> {
  private final Provider<Activity> activityProvider;

  private final Provider<ClipboardManager> clipboardManagerProvider;

  private final Provider<Logger> loggerProvider;

  private final Provider<DownloadPermissionsHelper> downloadPermissionsHelperProvider;

  private final Provider<ExitCleanup> exitCleanupProvider;

  public BrowserNavigator_Factory(Provider<Activity> activityProvider,
      Provider<ClipboardManager> clipboardManagerProvider, Provider<Logger> loggerProvider,
      Provider<DownloadPermissionsHelper> downloadPermissionsHelperProvider,
      Provider<ExitCleanup> exitCleanupProvider) {
    this.activityProvider = activityProvider;
    this.clipboardManagerProvider = clipboardManagerProvider;
    this.loggerProvider = loggerProvider;
    this.downloadPermissionsHelperProvider = downloadPermissionsHelperProvider;
    this.exitCleanupProvider = exitCleanupProvider;
  }

  @Override
  public BrowserNavigator get() {
    return newInstance(activityProvider.get(), clipboardManagerProvider.get(), loggerProvider.get(), downloadPermissionsHelperProvider.get(), exitCleanupProvider.get());
  }

  public static BrowserNavigator_Factory create(Provider<Activity> activityProvider,
      Provider<ClipboardManager> clipboardManagerProvider, Provider<Logger> loggerProvider,
      Provider<DownloadPermissionsHelper> downloadPermissionsHelperProvider,
      Provider<ExitCleanup> exitCleanupProvider) {
    return new BrowserNavigator_Factory(activityProvider, clipboardManagerProvider, loggerProvider, downloadPermissionsHelperProvider, exitCleanupProvider);
  }

  public static BrowserNavigator newInstance(Activity activity, ClipboardManager clipboardManager,
      Logger logger, DownloadPermissionsHelper downloadPermissionsHelper, ExitCleanup exitCleanup) {
    return new BrowserNavigator(activity, clipboardManager, logger, downloadPermissionsHelper, exitCleanup);
  }
}
