package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * Ask the user's permission before loading the [url] and load the homepage instead if they deny
 * permission. Useful for scenarios where another app may attempt to open a malicious URL in the
 * browser via an intent.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lacr/browser/lightning/browser/tab/PermissionInitializer;", "Lacr/browser/lightning/browser/tab/TabInitializer;", "url", "", "activity", "Landroid/app/Activity;", "homePageInitializer", "Lacr/browser/lightning/browser/tab/HomePageInitializer;", "(Ljava/lang/String;Landroid/app/Activity;Lacr/browser/lightning/browser/tab/HomePageInitializer;)V", "initialize", "", "webView", "Landroid/webkit/WebView;", "headers", "", "Factory", "app_lightningLiteDebug"})
public final class PermissionInitializer implements acr.browser.lightning.browser.tab.TabInitializer {
    private final java.lang.String url = null;
    private final android.app.Activity activity = null;
    private final acr.browser.lightning.browser.tab.HomePageInitializer homePageInitializer = null;
    
    @java.lang.Override()
    public void initialize(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> headers) {
    }
    
    @dagger.assisted.AssistedInject()
    public PermissionInitializer(@org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.HomePageInitializer homePageInitializer) {
        super();
    }
    
    /**
     * The factory for constructing the permission initializer.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lacr/browser/lightning/browser/tab/PermissionInitializer$Factory;", "", "create", "Lacr/browser/lightning/browser/tab/PermissionInitializer;", "url", "", "app_lightningLiteDebug"})
    @dagger.assisted.AssistedFactory()
    public static abstract interface Factory {
        
        /**
         * Creates the initializer.
         */
        @org.jetbrains.annotations.NotNull()
        public abstract acr.browser.lightning.browser.tab.PermissionInitializer create(@org.jetbrains.annotations.NotNull()
        java.lang.String url);
    }
}