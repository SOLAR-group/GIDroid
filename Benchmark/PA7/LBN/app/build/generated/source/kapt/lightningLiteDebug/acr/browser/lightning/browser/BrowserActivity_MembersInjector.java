package acr.browser.lightning.browser;

import acr.browser.lightning.ThemableBrowserActivity_MembersInjector;
import acr.browser.lightning.browser.image.ImageLoader;
import acr.browser.lightning.browser.keys.KeyEventAdapter;
import acr.browser.lightning.browser.menu.MenuItemAdapter;
import acr.browser.lightning.browser.search.IntentExtractor;
import acr.browser.lightning.browser.tab.TabPager;
import acr.browser.lightning.browser.ui.UiConfiguration;
import acr.browser.lightning.dialog.LightningDialogBuilder;
import acr.browser.lightning.preference.UserPreferences;
import acr.browser.lightning.utils.ProxyUtils;
import android.view.inputmethod.InputMethodManager;
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
public final class BrowserActivity_MembersInjector implements MembersInjector<BrowserActivity> {
  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<ImageLoader> imageLoaderProvider;

  private final Provider<KeyEventAdapter> keyEventAdapterProvider;

  private final Provider<MenuItemAdapter> menuItemAdapterProvider;

  private final Provider<InputMethodManager> inputMethodManagerProvider;

  private final Provider<BrowserPresenter> presenterProvider;

  private final Provider<TabPager> tabPagerProvider;

  private final Provider<IntentExtractor> intentExtractorProvider;

  private final Provider<LightningDialogBuilder> lightningDialogBuilderProvider;

  private final Provider<UiConfiguration> uiConfigurationProvider;

  private final Provider<ProxyUtils> proxyUtilsProvider;

  public BrowserActivity_MembersInjector(Provider<UserPreferences> userPreferencesProvider,
      Provider<ImageLoader> imageLoaderProvider, Provider<KeyEventAdapter> keyEventAdapterProvider,
      Provider<MenuItemAdapter> menuItemAdapterProvider,
      Provider<InputMethodManager> inputMethodManagerProvider,
      Provider<BrowserPresenter> presenterProvider, Provider<TabPager> tabPagerProvider,
      Provider<IntentExtractor> intentExtractorProvider,
      Provider<LightningDialogBuilder> lightningDialogBuilderProvider,
      Provider<UiConfiguration> uiConfigurationProvider, Provider<ProxyUtils> proxyUtilsProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
    this.imageLoaderProvider = imageLoaderProvider;
    this.keyEventAdapterProvider = keyEventAdapterProvider;
    this.menuItemAdapterProvider = menuItemAdapterProvider;
    this.inputMethodManagerProvider = inputMethodManagerProvider;
    this.presenterProvider = presenterProvider;
    this.tabPagerProvider = tabPagerProvider;
    this.intentExtractorProvider = intentExtractorProvider;
    this.lightningDialogBuilderProvider = lightningDialogBuilderProvider;
    this.uiConfigurationProvider = uiConfigurationProvider;
    this.proxyUtilsProvider = proxyUtilsProvider;
  }

  public static MembersInjector<BrowserActivity> create(
      Provider<UserPreferences> userPreferencesProvider, Provider<ImageLoader> imageLoaderProvider,
      Provider<KeyEventAdapter> keyEventAdapterProvider,
      Provider<MenuItemAdapter> menuItemAdapterProvider,
      Provider<InputMethodManager> inputMethodManagerProvider,
      Provider<BrowserPresenter> presenterProvider, Provider<TabPager> tabPagerProvider,
      Provider<IntentExtractor> intentExtractorProvider,
      Provider<LightningDialogBuilder> lightningDialogBuilderProvider,
      Provider<UiConfiguration> uiConfigurationProvider, Provider<ProxyUtils> proxyUtilsProvider) {
    return new BrowserActivity_MembersInjector(userPreferencesProvider, imageLoaderProvider, keyEventAdapterProvider, menuItemAdapterProvider, inputMethodManagerProvider, presenterProvider, tabPagerProvider, intentExtractorProvider, lightningDialogBuilderProvider, uiConfigurationProvider, proxyUtilsProvider);
  }

  @Override
  public void injectMembers(BrowserActivity instance) {
    ThemableBrowserActivity_MembersInjector.injectUserPreferences(instance, userPreferencesProvider.get());
    injectImageLoader(instance, imageLoaderProvider.get());
    injectKeyEventAdapter(instance, keyEventAdapterProvider.get());
    injectMenuItemAdapter(instance, menuItemAdapterProvider.get());
    injectInputMethodManager(instance, inputMethodManagerProvider.get());
    injectPresenter(instance, presenterProvider.get());
    injectTabPager(instance, tabPagerProvider.get());
    injectIntentExtractor(instance, intentExtractorProvider.get());
    injectLightningDialogBuilder(instance, lightningDialogBuilderProvider.get());
    injectUiConfiguration(instance, uiConfigurationProvider.get());
    injectProxyUtils(instance, proxyUtilsProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.browser.BrowserActivity.imageLoader")
  public static void injectImageLoader(BrowserActivity instance, ImageLoader imageLoader) {
    instance.imageLoader = imageLoader;
  }

  @InjectedFieldSignature("acr.browser.lightning.browser.BrowserActivity.keyEventAdapter")
  public static void injectKeyEventAdapter(BrowserActivity instance,
      KeyEventAdapter keyEventAdapter) {
    instance.keyEventAdapter = keyEventAdapter;
  }

  @InjectedFieldSignature("acr.browser.lightning.browser.BrowserActivity.menuItemAdapter")
  public static void injectMenuItemAdapter(BrowserActivity instance,
      MenuItemAdapter menuItemAdapter) {
    instance.menuItemAdapter = menuItemAdapter;
  }

  @InjectedFieldSignature("acr.browser.lightning.browser.BrowserActivity.inputMethodManager")
  public static void injectInputMethodManager(BrowserActivity instance,
      InputMethodManager inputMethodManager) {
    instance.inputMethodManager = inputMethodManager;
  }

  @InjectedFieldSignature("acr.browser.lightning.browser.BrowserActivity.presenter")
  public static void injectPresenter(BrowserActivity instance, BrowserPresenter presenter) {
    instance.presenter = presenter;
  }

  @InjectedFieldSignature("acr.browser.lightning.browser.BrowserActivity.tabPager")
  public static void injectTabPager(BrowserActivity instance, TabPager tabPager) {
    instance.tabPager = tabPager;
  }

  @InjectedFieldSignature("acr.browser.lightning.browser.BrowserActivity.intentExtractor")
  public static void injectIntentExtractor(BrowserActivity instance,
      IntentExtractor intentExtractor) {
    instance.intentExtractor = intentExtractor;
  }

  @InjectedFieldSignature("acr.browser.lightning.browser.BrowserActivity.lightningDialogBuilder")
  public static void injectLightningDialogBuilder(BrowserActivity instance,
      LightningDialogBuilder lightningDialogBuilder) {
    instance.lightningDialogBuilder = lightningDialogBuilder;
  }

  @InjectedFieldSignature("acr.browser.lightning.browser.BrowserActivity.uiConfiguration")
  public static void injectUiConfiguration(BrowserActivity instance,
      UiConfiguration uiConfiguration) {
    instance.uiConfiguration = uiConfiguration;
  }

  @InjectedFieldSignature("acr.browser.lightning.browser.BrowserActivity.proxyUtils")
  public static void injectProxyUtils(BrowserActivity instance, ProxyUtils proxyUtils) {
    instance.proxyUtils = proxyUtils;
  }
}
