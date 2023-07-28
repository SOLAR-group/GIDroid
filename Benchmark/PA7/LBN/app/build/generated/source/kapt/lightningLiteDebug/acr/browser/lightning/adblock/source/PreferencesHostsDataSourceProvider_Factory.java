package acr.browser.lightning.adblock.source;

import acr.browser.lightning.preference.UserPreferences;
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
public final class PreferencesHostsDataSourceProvider_Factory implements Factory<PreferencesHostsDataSourceProvider> {
  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<AssetsHostsDataSource> assetsHostsDataSourceProvider;

  private final Provider<FileHostsDataSource.Factory> fileHostsDataSourceFactoryProvider;

  private final Provider<UrlHostsDataSource.Factory> urlHostsDataSourceFactoryProvider;

  public PreferencesHostsDataSourceProvider_Factory(
      Provider<UserPreferences> userPreferencesProvider,
      Provider<AssetsHostsDataSource> assetsHostsDataSourceProvider,
      Provider<FileHostsDataSource.Factory> fileHostsDataSourceFactoryProvider,
      Provider<UrlHostsDataSource.Factory> urlHostsDataSourceFactoryProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
    this.assetsHostsDataSourceProvider = assetsHostsDataSourceProvider;
    this.fileHostsDataSourceFactoryProvider = fileHostsDataSourceFactoryProvider;
    this.urlHostsDataSourceFactoryProvider = urlHostsDataSourceFactoryProvider;
  }

  @Override
  public PreferencesHostsDataSourceProvider get() {
    return newInstance(userPreferencesProvider.get(), assetsHostsDataSourceProvider.get(), fileHostsDataSourceFactoryProvider.get(), urlHostsDataSourceFactoryProvider.get());
  }

  public static PreferencesHostsDataSourceProvider_Factory create(
      Provider<UserPreferences> userPreferencesProvider,
      Provider<AssetsHostsDataSource> assetsHostsDataSourceProvider,
      Provider<FileHostsDataSource.Factory> fileHostsDataSourceFactoryProvider,
      Provider<UrlHostsDataSource.Factory> urlHostsDataSourceFactoryProvider) {
    return new PreferencesHostsDataSourceProvider_Factory(userPreferencesProvider, assetsHostsDataSourceProvider, fileHostsDataSourceFactoryProvider, urlHostsDataSourceFactoryProvider);
  }

  public static PreferencesHostsDataSourceProvider newInstance(UserPreferences userPreferences,
      AssetsHostsDataSource assetsHostsDataSource,
      FileHostsDataSource.Factory fileHostsDataSourceFactory,
      UrlHostsDataSource.Factory urlHostsDataSourceFactory) {
    return new PreferencesHostsDataSourceProvider(userPreferences, assetsHostsDataSource, fileHostsDataSourceFactory, urlHostsDataSourceFactory);
  }
}
