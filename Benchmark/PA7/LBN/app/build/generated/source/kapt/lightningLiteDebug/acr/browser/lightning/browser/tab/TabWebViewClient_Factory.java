package acr.browser.lightning.browser.tab;

import acr.browser.lightning.adblock.AdBlocker;
import acr.browser.lightning.adblock.allowlist.AllowListModel;
import acr.browser.lightning.browser.proxy.Proxy;
import acr.browser.lightning.js.TextReflow;
import acr.browser.lightning.log.Logger;
import acr.browser.lightning.preference.UserPreferences;
import acr.browser.lightning.ssl.SslWarningPreferences;
import dagger.internal.DaggerGenerated;
import java.util.Map;
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
public final class TabWebViewClient_Factory {
  private final Provider<AdBlocker> adBlockerProvider;

  private final Provider<AllowListModel> allowListModelProvider;

  private final Provider<UrlHandler> urlHandlerProvider;

  private final Provider<Proxy> proxyProvider;

  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<SslWarningPreferences> sslWarningPreferencesProvider;

  private final Provider<TextReflow> textReflowProvider;

  private final Provider<Logger> loggerProvider;

  public TabWebViewClient_Factory(Provider<AdBlocker> adBlockerProvider,
      Provider<AllowListModel> allowListModelProvider, Provider<UrlHandler> urlHandlerProvider,
      Provider<Proxy> proxyProvider, Provider<UserPreferences> userPreferencesProvider,
      Provider<SslWarningPreferences> sslWarningPreferencesProvider,
      Provider<TextReflow> textReflowProvider, Provider<Logger> loggerProvider) {
    this.adBlockerProvider = adBlockerProvider;
    this.allowListModelProvider = allowListModelProvider;
    this.urlHandlerProvider = urlHandlerProvider;
    this.proxyProvider = proxyProvider;
    this.userPreferencesProvider = userPreferencesProvider;
    this.sslWarningPreferencesProvider = sslWarningPreferencesProvider;
    this.textReflowProvider = textReflowProvider;
    this.loggerProvider = loggerProvider;
  }

  public TabWebViewClient get(Map<String, String> headers) {
    return newInstance(adBlockerProvider.get(), allowListModelProvider.get(), urlHandlerProvider.get(), headers, proxyProvider.get(), userPreferencesProvider.get(), sslWarningPreferencesProvider.get(), textReflowProvider.get(), loggerProvider.get());
  }

  public static TabWebViewClient_Factory create(Provider<AdBlocker> adBlockerProvider,
      Provider<AllowListModel> allowListModelProvider, Provider<UrlHandler> urlHandlerProvider,
      Provider<Proxy> proxyProvider, Provider<UserPreferences> userPreferencesProvider,
      Provider<SslWarningPreferences> sslWarningPreferencesProvider,
      Provider<TextReflow> textReflowProvider, Provider<Logger> loggerProvider) {
    return new TabWebViewClient_Factory(adBlockerProvider, allowListModelProvider, urlHandlerProvider, proxyProvider, userPreferencesProvider, sslWarningPreferencesProvider, textReflowProvider, loggerProvider);
  }

  public static TabWebViewClient newInstance(AdBlocker adBlocker, AllowListModel allowListModel,
      UrlHandler urlHandler, Map<String, String> headers, Proxy proxy,
      UserPreferences userPreferences, SslWarningPreferences sslWarningPreferences,
      TextReflow textReflow, Logger logger) {
    return new TabWebViewClient(adBlocker, allowListModel, urlHandler, headers, proxy, userPreferences, sslWarningPreferences, textReflow, logger);
  }
}
