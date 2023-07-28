package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * Handle URLs loaded by the [WebView] and determine if they should be loaded by the browser or
 * another app.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ,\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\rH\u0002J*\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lacr/browser/lightning/browser/tab/UrlHandler;", "", "activity", "Landroid/app/Activity;", "logger", "Lacr/browser/lightning/log/Logger;", "intentUtils", "Lacr/browser/lightning/utils/IntentUtils;", "incognitoMode", "", "(Landroid/app/Activity;Lacr/browser/lightning/log/Logger;Lacr/browser/lightning/utils/IntentUtils;Z)V", "continueLoadingUrl", "webView", "Landroid/webkit/WebView;", "url", "", "headers", "", "isMailOrIntent", "view", "shouldOverrideLoading", "Companion", "app_lightningLiteDebug"})
public final class UrlHandler {
    private final android.app.Activity activity = null;
    private final acr.browser.lightning.log.Logger logger = null;
    private final acr.browser.lightning.utils.IntentUtils intentUtils = null;
    private final boolean incognitoMode = false;
    private static final java.lang.String TAG = "UrlHandler";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.browser.tab.UrlHandler.Companion Companion = null;
    
    /**
     * Return true if the [url] should be loaded by another app or in another way, false if the
     * browser can let the [view] continue loading as it wants.
     */
    public final boolean shouldOverrideLoading(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> headers) {
        return false;
    }
    
    private final boolean continueLoadingUrl(android.webkit.WebView webView, java.lang.String url, java.util.Map<java.lang.String, java.lang.String> headers) {
        return false;
    }
    
    private final boolean isMailOrIntent(java.lang.String url, android.webkit.WebView view) {
        return false;
    }
    
    @javax.inject.Inject()
    public UrlHandler(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.utils.IntentUtils intentUtils, @acr.browser.lightning.browser.di.IncognitoMode()
    boolean incognitoMode) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/browser/tab/UrlHandler$Companion;", "", "()V", "TAG", "", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}