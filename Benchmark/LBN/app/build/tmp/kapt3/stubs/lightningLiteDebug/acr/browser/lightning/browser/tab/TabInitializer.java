package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * An initializer that is run on a [WebView] after it is created.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/browser/tab/TabInitializer;", "", "initialize", "", "webView", "Landroid/webkit/WebView;", "headers", "", "", "app_lightningLiteDebug"})
public abstract interface TabInitializer {
    
    /**
     * Initialize the [WebView] instance held by the tab. If a url is loaded, the
     * provided [headers] should be used to load the url.
     */
    public abstract void initialize(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> headers);
}