package acr.browser.lightning.html.homepage;

import acr.browser.lightning.browser.theme.ThemeProvider;
import acr.browser.lightning.search.SearchEngineProvider;
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
public final class HomePageFactory_Factory implements Factory<HomePageFactory> {
  private final Provider<Application> applicationProvider;

  private final Provider<SearchEngineProvider> searchEngineProvider;

  private final Provider<HomePageReader> homePageReaderProvider;

  private final Provider<ThemeProvider> themeProvider;

  public HomePageFactory_Factory(Provider<Application> applicationProvider,
      Provider<SearchEngineProvider> searchEngineProvider,
      Provider<HomePageReader> homePageReaderProvider, Provider<ThemeProvider> themeProvider) {
    this.applicationProvider = applicationProvider;
    this.searchEngineProvider = searchEngineProvider;
    this.homePageReaderProvider = homePageReaderProvider;
    this.themeProvider = themeProvider;
  }

  @Override
  public HomePageFactory get() {
    return newInstance(applicationProvider.get(), searchEngineProvider.get(), homePageReaderProvider.get(), themeProvider.get());
  }

  public static HomePageFactory_Factory create(Provider<Application> applicationProvider,
      Provider<SearchEngineProvider> searchEngineProvider,
      Provider<HomePageReader> homePageReaderProvider, Provider<ThemeProvider> themeProvider) {
    return new HomePageFactory_Factory(applicationProvider, searchEngineProvider, homePageReaderProvider, themeProvider);
  }

  public static HomePageFactory newInstance(Application application,
      SearchEngineProvider searchEngineProvider, HomePageReader homePageReader,
      ThemeProvider themeProvider) {
    return new HomePageFactory(application, searchEngineProvider, homePageReader, themeProvider);
  }
}
