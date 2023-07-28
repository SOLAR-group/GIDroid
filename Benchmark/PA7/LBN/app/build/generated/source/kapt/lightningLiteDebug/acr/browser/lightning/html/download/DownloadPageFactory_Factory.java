package acr.browser.lightning.html.download;

import acr.browser.lightning.browser.theme.ThemeProvider;
import acr.browser.lightning.database.downloads.DownloadsRepository;
import acr.browser.lightning.html.ListPageReader;
import acr.browser.lightning.preference.UserPreferences;
import android.app.Application;
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
public final class DownloadPageFactory_Factory implements Factory<DownloadPageFactory> {
  private final Provider<Application> applicationProvider;

  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<DownloadsRepository> managerProvider;

  private final Provider<ListPageReader> listPageReaderProvider;

  private final Provider<ThemeProvider> themeProvider;

  public DownloadPageFactory_Factory(Provider<Application> applicationProvider,
      Provider<UserPreferences> userPreferencesProvider,
      Provider<DownloadsRepository> managerProvider,
      Provider<ListPageReader> listPageReaderProvider, Provider<ThemeProvider> themeProvider) {
    this.applicationProvider = applicationProvider;
    this.userPreferencesProvider = userPreferencesProvider;
    this.managerProvider = managerProvider;
    this.listPageReaderProvider = listPageReaderProvider;
    this.themeProvider = themeProvider;
  }

  @Override
  public DownloadPageFactory get() {
    return newInstance(applicationProvider.get(), userPreferencesProvider.get(), managerProvider.get(), listPageReaderProvider.get(), themeProvider.get());
  }

  public static DownloadPageFactory_Factory create(Provider<Application> applicationProvider,
      Provider<UserPreferences> userPreferencesProvider,
      Provider<DownloadsRepository> managerProvider,
      Provider<ListPageReader> listPageReaderProvider, Provider<ThemeProvider> themeProvider) {
    return new DownloadPageFactory_Factory(applicationProvider, userPreferencesProvider, managerProvider, listPageReaderProvider, themeProvider);
  }

  public static DownloadPageFactory newInstance(Application application,
      UserPreferences userPreferences, DownloadsRepository manager, ListPageReader listPageReader,
      ThemeProvider themeProvider) {
    return new DownloadPageFactory(application, userPreferences, manager, listPageReader, themeProvider);
  }
}
