package acr.browser.lightning.search;

import acr.browser.lightning.log.Logger;
import acr.browser.lightning.preference.UserPreferences;
import acr.browser.lightning.search.suggestions.RequestFactory;
import android.app.Application;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import io.reactivex.Single;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SearchEngineProvider_Factory implements Factory<SearchEngineProvider> {
  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<Single<OkHttpClient>> okHttpClientProvider;

  private final Provider<RequestFactory> requestFactoryProvider;

  private final Provider<Application> applicationProvider;

  private final Provider<Logger> loggerProvider;

  public SearchEngineProvider_Factory(Provider<UserPreferences> userPreferencesProvider,
      Provider<Single<OkHttpClient>> okHttpClientProvider,
      Provider<RequestFactory> requestFactoryProvider, Provider<Application> applicationProvider,
      Provider<Logger> loggerProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
    this.okHttpClientProvider = okHttpClientProvider;
    this.requestFactoryProvider = requestFactoryProvider;
    this.applicationProvider = applicationProvider;
    this.loggerProvider = loggerProvider;
  }

  @Override
  public SearchEngineProvider get() {
    return newInstance(userPreferencesProvider.get(), okHttpClientProvider.get(), requestFactoryProvider.get(), applicationProvider.get(), loggerProvider.get());
  }

  public static SearchEngineProvider_Factory create(
      Provider<UserPreferences> userPreferencesProvider,
      Provider<Single<OkHttpClient>> okHttpClientProvider,
      Provider<RequestFactory> requestFactoryProvider, Provider<Application> applicationProvider,
      Provider<Logger> loggerProvider) {
    return new SearchEngineProvider_Factory(userPreferencesProvider, okHttpClientProvider, requestFactoryProvider, applicationProvider, loggerProvider);
  }

  public static SearchEngineProvider newInstance(UserPreferences userPreferences,
      Single<OkHttpClient> okHttpClient, RequestFactory requestFactory, Application application,
      Logger logger) {
    return new SearchEngineProvider(userPreferences, okHttpClient, requestFactory, application, logger);
  }
}
