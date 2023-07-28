package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * An initializer that does not load anything into the [WebView].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0016\u00a8\u0006\n"}, d2 = {"Lacr/browser/lightning/browser/tab/NoOpInitializer;", "Lacr/browser/lightning/browser/tab/TabInitializer;", "()V", "initialize", "", "webView", "Landroid/webkit/WebView;", "headers", "", "", "app_lightningPlusDebug"})
public final class NoOpInitializer implements acr.browser.lightning.browser.tab.TabInitializer {
    
    @java.lang.Override()
    public void initialize(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> headers) {
    }
    
    public NoOpInitializer() {
        super();
    }
}