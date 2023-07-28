package acr.browser.lightning.html.history;

import acr.browser.lightning.browser.theme.ThemeProvider;
import acr.browser.lightning.database.history.HistoryRepository;
import acr.browser.lightning.html.ListPageReader;
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
public final class HistoryPageFactory_Factory implements Factory<HistoryPageFactory> {
  private final Provider<ListPageReader> listPageReaderProvider;

  private final Provider<Application> applicationProvider;

  private final Provider<HistoryRepository> historyRepositoryProvider;

  private final Provider<ThemeProvider> themeProvider;

  public HistoryPageFactory_Factory(Provider<ListPageReader> listPageReaderProvider,
      Provider<Application> applicationProvider,
      Provider<HistoryRepository> historyRepositoryProvider,
      Provider<ThemeProvider> themeProvider) {
    this.listPageReaderProvider = listPageReaderProvider;
    this.applicationProvider = applicationProvider;
    this.historyRepositoryProvider = historyRepositoryProvider;
    this.themeProvider = themeProvider;
  }

  @Override
  public HistoryPageFactory get() {
    return newInstance(listPageReaderProvider.get(), applicationProvider.get(), historyRepositoryProvider.get(), themeProvider.get());
  }

  public static HistoryPageFactory_Factory create(Provider<ListPageReader> listPageReaderProvider,
      Provider<Application> applicationProvider,
      Provider<HistoryRepository> historyRepositoryProvider,
      Provider<ThemeProvider> themeProvider) {
    return new HistoryPageFactory_Factory(listPageReaderProvider, applicationProvider, historyRepositoryProvider, themeProvider);
  }

  public static HistoryPageFactory newInstance(ListPageReader listPageReader,
      Application application, HistoryRepository historyRepository, ThemeProvider themeProvider) {
    return new HistoryPageFactory(listPageReader, application, historyRepository, themeProvider);
  }
}
