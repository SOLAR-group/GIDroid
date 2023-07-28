package acr.browser.lightning.adblock.source;

import acr.browser.lightning.log.Logger;
import acr.browser.lightning.preference.UserPreferences;
import android.app.Application;
import dagger.internal.DaggerGenerated;
import io.reactivex.Single;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.HttpUrl;
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
public final class UrlHostsDataSource_Factory {
  private final Provider<Single<OkHttpClient>> okHttpClientProvider;

  private final Provider<Logger> loggerProvider;

  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<Application> applicationProvider;

  public UrlHostsDataSource_Factory(Provider<Single<OkHttpClient>> okHttpClientProvider,
      Provider<Logger> loggerProvider, Provider<UserPreferences> userPreferencesProvider,
      Provider<Application> applicationProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
    this.loggerProvider = loggerProvider;
    this.userPreferencesProvider = userPreferencesProvider;
    this.applicationProvider = applicationProvider;
  }

  public UrlHostsDataSource get(HttpUrl url) {
    return newInstance(url, okHttpClientProvider.get(), loggerProvider.get(), userPreferencesProvider.get(), applicationProvider.get());
  }

  public static UrlHostsDataSource_Factory create(
      Provider<Single<OkHttpClient>> okHttpClientProvider, Provider<Logger> loggerProvider,
      Provider<UserPreferences> userPreferencesProvider,
      Provider<Application> applicationProvider) {
    return new UrlHostsDataSource_Factory(okHttpClientProvider, loggerProvider, userPreferencesProvider, applicationProvider);
  }

  public static UrlHostsDataSource newInstance(HttpUrl url, Single<OkHttpClient> okHttpClient,
      Logger logger, UserPreferences userPreferences, Application application) {
    return new UrlHostsDataSource(url, okHttpClient, logger, userPreferences, application);
  }
}
