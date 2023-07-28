package acr.browser.lightning.browser.tab;

import acr.browser.lightning.browser.tab.bundle.BundleStore;
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
public final class TabsRepository_Factory implements Factory<TabsRepository> {
  private final Provider<WebViewFactory> webViewFactoryProvider;

  private final Provider<TabPager> tabPagerProvider;

  private final Provider<Scheduler> diskSchedulerProvider;

  private final Provider<Scheduler> mainSchedulerProvider;

  private final Provider<BundleStore> bundleStoreProvider;

  private final Provider<RecentTabModel> recentTabModelProvider;

  private final Provider<TabFactory> tabFactoryProvider;

  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<String> initialUrlProvider;

  private final Provider<PermissionInitializer.Factory> permissionInitializerFactoryProvider;

  public TabsRepository_Factory(Provider<WebViewFactory> webViewFactoryProvider,
      Provider<TabPager> tabPagerProvider, Provider<Scheduler> diskSchedulerProvider,
      Provider<Scheduler> mainSchedulerProvider, Provider<BundleStore> bundleStoreProvider,
      Provider<RecentTabModel> recentTabModelProvider, Provider<TabFactory> tabFactoryProvider,
      Provider<UserPreferences> userPreferencesProvider, Provider<String> initialUrlProvider,
      Provider<PermissionInitializer.Factory> permissionInitializerFactoryProvider) {
    this.webViewFactoryProvider = webViewFactoryProvider;
    this.tabPagerProvider = tabPagerProvider;
    this.diskSchedulerProvider = diskSchedulerProvider;
    this.mainSchedulerProvider = mainSchedulerProvider;
    this.bundleStoreProvider = bundleStoreProvider;
    this.recentTabModelProvider = recentTabModelProvider;
    this.tabFactoryProvider = tabFactoryProvider;
    this.userPreferencesProvider = userPreferencesProvider;
    this.initialUrlProvider = initialUrlProvider;
    this.permissionInitializerFactoryProvider = permissionInitializerFactoryProvider;
  }

  @Override
  public TabsRepository get() {
    return newInstance(webViewFactoryProvider.get(), tabPagerProvider.get(), diskSchedulerProvider.get(), mainSchedulerProvider.get(), bundleStoreProvider.get(), recentTabModelProvider.get(), tabFactoryProvider.get(), userPreferencesProvider.get(), initialUrlProvider.get(), permissionInitializerFactoryProvider.get());
  }

  public static TabsRepository_Factory create(Provider<WebViewFactory> webViewFactoryProvider,
      Provider<TabPager> tabPagerProvider, Provider<Scheduler> diskSchedulerProvider,
      Provider<Scheduler> mainSchedulerProvider, Provider<BundleStore> bundleStoreProvider,
      Provider<RecentTabModel> recentTabModelProvider, Provider<TabFactory> tabFactoryProvider,
      Provider<UserPreferences> userPreferencesProvider, Provider<String> initialUrlProvider,
      Provider<PermissionInitializer.Factory> permissionInitializerFactoryProvider) {
    return new TabsRepository_Factory(webViewFactoryProvider, tabPagerProvider, diskSchedulerProvider, mainSchedulerProvider, bundleStoreProvider, recentTabModelProvider, tabFactoryProvider, userPreferencesProvider, initialUrlProvider, permissionInitializerFactoryProvider);
  }

  public static TabsRepository newInstance(WebViewFactory webViewFactory, TabPager tabPager,
      Scheduler diskScheduler, Scheduler mainScheduler, BundleStore bundleStore,
      RecentTabModel recentTabModel, TabFactory tabFactory, UserPreferences userPreferences,
      String initialUrl, PermissionInitializer.Factory permissionInitializerFactory) {
    return new TabsRepository(webViewFactory, tabPager, diskScheduler, mainScheduler, bundleStore, recentTabModel, tabFactory, userPreferences, initialUrl, permissionInitializerFactory);
  }
}
