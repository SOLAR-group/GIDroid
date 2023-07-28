package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * Constructs a [TabModel].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BS\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\u0007\u0012\b\b\u0001\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\u0002\u0010\u0012J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lacr/browser/lightning/browser/tab/TabFactory;", "", "webViewFactory", "Lacr/browser/lightning/browser/tab/WebViewFactory;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "defaultUserAgent", "", "defaultTabTitle", "iconFreeze", "Landroid/graphics/Bitmap;", "proxy", "Lacr/browser/lightning/browser/proxy/Proxy;", "tabWebViewClientFactory", "Lacr/browser/lightning/browser/tab/TabWebViewClient$Factory;", "tabWebChromeClientProvider", "Ljavax/inject/Provider;", "Lacr/browser/lightning/browser/tab/TabWebChromeClient;", "(Lacr/browser/lightning/browser/tab/WebViewFactory;Lacr/browser/lightning/preference/UserPreferences;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Lacr/browser/lightning/browser/proxy/Proxy;Lacr/browser/lightning/browser/tab/TabWebViewClient$Factory;Ljavax/inject/Provider;)V", "constructTab", "Lacr/browser/lightning/browser/tab/TabModel;", "tabInitializer", "Lacr/browser/lightning/browser/tab/TabInitializer;", "webView", "Landroid/webkit/WebView;", "app_lightningPlusDebug"})
public final class TabFactory {
    private final acr.browser.lightning.browser.tab.WebViewFactory webViewFactory = null;
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final java.lang.String defaultUserAgent = null;
    private final java.lang.String defaultTabTitle = null;
    private final android.graphics.Bitmap iconFreeze = null;
    private final acr.browser.lightning.browser.proxy.Proxy proxy = null;
    private final acr.browser.lightning.browser.tab.TabWebViewClient.Factory tabWebViewClientFactory = null;
    private final javax.inject.Provider<acr.browser.lightning.browser.tab.TabWebChromeClient> tabWebChromeClientProvider = null;
    
    /**
     * Constructs a tab from the [webView] with the provided [tabInitializer].
     */
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.tab.TabModel constructTab(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.TabInitializer tabInitializer, @org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView) {
        return null;
    }
    
    @javax.inject.Inject()
    public TabFactory(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.WebViewFactory webViewFactory, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    @DefaultUserAgent()
    java.lang.String defaultUserAgent, @org.jetbrains.annotations.NotNull()
    @DefaultTabTitle()
    java.lang.String defaultTabTitle, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.image.IconFreeze()
    android.graphics.Bitmap iconFreeze, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.proxy.Proxy proxy, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.TabWebViewClient.Factory tabWebViewClientFactory, @org.jetbrains.annotations.NotNull()
    javax.inject.Provider<acr.browser.lightning.browser.tab.TabWebChromeClient> tabWebChromeClientProvider) {
        super();
    }
}