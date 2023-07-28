package acr.browser.lightning.browser.tab;

import acr.browser.lightning.browser.proxy.Proxy;
import acr.browser.lightning.preference.UserPreferences;
import android.graphics.Bitmap;
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
public final class TabFactory_Factory implements Factory<TabFactory> {
  private final Provider<WebViewFactory> webViewFactoryProvider;

  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<String> defaultUserAgentProvider;

  private final Provider<String> defaultTabTitleProvider;

  private final Provider<Bitmap> iconFreezeProvider;

  private final Provider<Proxy> proxyProvider;

  private final Provider<TabWebViewClient.Factory> tabWebViewClientFactoryProvider;

  private final Provider<TabWebChromeClient> tabWebChromeClientProvider;

  public TabFactory_Factory(Provider<WebViewFactory> webViewFactoryProvider,
      Provider<UserPreferences> userPreferencesProvider, Provider<String> defaultUserAgentProvider,
      Provider<String> defaultTabTitleProvider, Provider<Bitmap> iconFreezeProvider,
      Provider<Proxy> proxyProvider,
      Provider<TabWebViewClient.Factory> tabWebViewClientFactoryProvider,
      Provider<TabWebChromeClient> tabWebChromeClientProvider) {
    this.webViewFactoryProvider = webViewFactoryProvider;
    this.userPreferencesProvider = userPreferencesProvider;
    this.defaultUserAgentProvider = defaultUserAgentProvider;
    this.defaultTabTitleProvider = defaultTabTitleProvider;
    this.iconFreezeProvider = iconFreezeProvider;
    this.proxyProvider = proxyProvider;
    this.tabWebViewClientFactoryProvider = tabWebViewClientFactoryProvider;
    this.tabWebChromeClientProvider = tabWebChromeClientProvider;
  }

  @Override
  public TabFactory get() {
    return newInstance(webViewFactoryProvider.get(), userPreferencesProvider.get(), defaultUserAgentProvider.get(), defaultTabTitleProvider.get(), iconFreezeProvider.get(), proxyProvider.get(), tabWebViewClientFactoryProvider.get(), tabWebChromeClientProvider);
  }

  public static TabFactory_Factory create(Provider<WebViewFactory> webViewFactoryProvider,
      Provider<UserPreferences> userPreferencesProvider, Provider<String> defaultUserAgentProvider,
      Provider<String> defaultTabTitleProvider, Provider<Bitmap> iconFreezeProvider,
      Provider<Proxy> proxyProvider,
      Provider<TabWebViewClient.Factory> tabWebViewClientFactoryProvider,
      Provider<TabWebChromeClient> tabWebChromeClientProvider) {
    return new TabFactory_Factory(webViewFactoryProvider, userPreferencesProvider, defaultUserAgentProvider, defaultTabTitleProvider, iconFreezeProvider, proxyProvider, tabWebViewClientFactoryProvider, tabWebChromeClientProvider);
  }

  public static TabFactory newInstance(WebViewFactory webViewFactory,
      UserPreferences userPreferences, String defaultUserAgent, String defaultTabTitle,
      Bitmap iconFreeze, Proxy proxy, TabWebViewClient.Factory tabWebViewClientFactory,
      Provider<TabWebChromeClient> tabWebChromeClientProvider) {
    return new TabFactory(webViewFactory, userPreferences, defaultUserAgent, defaultTabTitle, iconFreeze, proxy, tabWebViewClientFactory, tabWebChromeClientProvider);
  }
}
