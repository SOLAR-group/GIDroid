package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * Creates the adaptation between a [WebView] and the [TabModel] interface used by the browser.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001Ba\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\u0006\u0010\u0010\u001a\u00020\b\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0015J\b\u0010>\u001a\u00020&H\u0016J\u000e\u0010?\u001a\b\u0012\u0004\u0012\u00020&0@H\u0016J\b\u0010A\u001a\u00020&H\u0016J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020&0@H\u0016J\b\u0010C\u001a\u00020DH\u0016J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00020D0@H\u0016J\u000e\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00030@H\u0016J\b\u0010G\u001a\u00020DH\u0016J\u000e\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00180@H\u0016J\u0014\u0010I\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120J0@H\u0016J\u000e\u0010K\u001a\b\u0012\u0004\u0012\u00020L0@H\u0016J\u0010\u0010M\u001a\u00020D2\u0006\u0010N\u001a\u00020\bH\u0016J\b\u0010O\u001a\u00020DH\u0016J\b\u0010P\u001a\u00020DH\u0016J\b\u0010Q\u001a\u00020RH\u0016J\b\u0010S\u001a\u00020DH\u0016J\b\u0010T\u001a\u00020DH\u0016J\u0010\u0010U\u001a\u00020D2\u0006\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020DH\u0016J\u000e\u0010Y\u001a\b\u0012\u0004\u0012\u00020D0@H\u0016J\u0010\u0010Z\u001a\u00020D2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010[\u001a\u00020D2\u0006\u0010<\u001a\u00020\bH\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020\"0@H\u0016J\b\u0010\\\u001a\u00020DH\u0016J\u000e\u0010]\u001a\b\u0012\u0004\u0012\u00020^0@H\u0016J\u000e\u0010_\u001a\b\u0012\u0004\u0012\u0002040@H\u0016J\b\u0010`\u001a\u00020DH\u0016J\u000e\u0010a\u001a\b\u0012\u0004\u0012\u00020\"0@H\u0016J\u000e\u0010b\u001a\b\u0012\u0004\u0012\u00020\b0@H\u0016J\b\u0010c\u001a\u00020DH\u0016J\u000e\u0010d\u001a\b\u0012\u0004\u0012\u00020\b0@H\u0016R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00128VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\u0004\u0018\u00010\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010!\u001a\u00020\"X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R$\u0010\'\u001a\u00020&2\u0006\u0010%\u001a\u00020&@VX\u0096\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010-\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b.\u0010$R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010/\u001a\u0004\u0018\u0001008VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b1\u00102R\u0014\u00103\u001a\u0002048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b5\u00106R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u00107\u001a\u00020\"8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b8\u0010$R\u0014\u00109\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010 R\u000e\u0010;\u001a\u00020&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010<\u001a\u00020\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b=\u0010 R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006e"}, d2 = {"Lacr/browser/lightning/browser/tab/TabAdapter;", "Lacr/browser/lightning/browser/tab/TabModel;", "tabInitializer", "Lacr/browser/lightning/browser/tab/TabInitializer;", "webView", "Landroid/webkit/WebView;", "requestHeaders", "", "", "tabWebViewClient", "Lacr/browser/lightning/browser/tab/TabWebViewClient;", "tabWebChromeClient", "Lacr/browser/lightning/browser/tab/TabWebChromeClient;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "defaultUserAgent", "defaultTabTitle", "iconFreeze", "Landroid/graphics/Bitmap;", "proxy", "Lacr/browser/lightning/browser/proxy/Proxy;", "(Lacr/browser/lightning/browser/tab/TabInitializer;Landroid/webkit/WebView;Ljava/util/Map;Lacr/browser/lightning/browser/tab/TabWebViewClient;Lacr/browser/lightning/browser/tab/TabWebChromeClient;Lacr/browser/lightning/preference/UserPreferences;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;Lacr/browser/lightning/browser/proxy/Proxy;)V", "downloadsSubject", "Lio/reactivex/subjects/PublishSubject;", "Lacr/browser/lightning/browser/download/PendingDownload;", "kotlin.jvm.PlatformType", "favicon", "getFavicon", "()Landroid/graphics/Bitmap;", "findInPageQuery", "findQuery", "getFindQuery", "()Ljava/lang/String;", "id", "", "getId", "()I", "value", "", "isForeground", "()Z", "setForeground", "(Z)V", "latentInitializer", "Lacr/browser/lightning/browser/tab/FreezableBundleInitializer;", "loadingProgress", "getLoadingProgress", "sslCertificateInfo", "Lacr/browser/lightning/ssl/SslCertificateInfo;", "getSslCertificateInfo", "()Lacr/browser/lightning/ssl/SslCertificateInfo;", "sslState", "Lacr/browser/lightning/ssl/SslState;", "getSslState", "()Lacr/browser/lightning/ssl/SslState;", "themeColor", "getThemeColor", "title", "getTitle", "toggleDesktop", "url", "getUrl", "canGoBack", "canGoBackChanges", "Lio/reactivex/Observable;", "canGoForward", "canGoForwardChanges", "clearFindMatches", "", "closeWindowRequests", "createWindowRequests", "destroy", "downloadRequests", "faviconChanges", "Lacr/browser/lightning/utils/Option;", "fileChooserRequests", "Landroid/content/Intent;", "find", "query", "findNext", "findPrevious", "freeze", "Landroid/os/Bundle;", "goBack", "goForward", "handleFileChooserResult", "activityResult", "Landroidx/activity/result/ActivityResult;", "hideCustomView", "hideCustomViewRequests", "loadFromInitializer", "loadUrl", "reload", "showCustomViewRequests", "Landroid/view/View;", "sslChanges", "stopLoading", "themeColorChanges", "titleChanges", "toggleDesktopAgent", "urlChanges", "app_lightningPlusDebug"})
public final class TabAdapter implements acr.browser.lightning.browser.tab.TabModel {
    private acr.browser.lightning.browser.tab.FreezableBundleInitializer latentInitializer;
    private java.lang.String findInPageQuery;
    private boolean toggleDesktop = false;
    private final io.reactivex.subjects.PublishSubject<acr.browser.lightning.browser.download.PendingDownload> downloadsSubject = null;
    private final int id = 0;
    private boolean isForeground = false;
    private final android.webkit.WebView webView = null;
    private final java.util.Map<java.lang.String, java.lang.String> requestHeaders = null;
    private final acr.browser.lightning.browser.tab.TabWebViewClient tabWebViewClient = null;
    private final acr.browser.lightning.browser.tab.TabWebChromeClient tabWebChromeClient = null;
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final java.lang.String defaultUserAgent = null;
    private final java.lang.String defaultTabTitle = null;
    private final android.graphics.Bitmap iconFreeze = null;
    private final acr.browser.lightning.browser.proxy.Proxy proxy = null;
    
    @java.lang.Override()
    public int getId() {
        return 0;
    }
    
    @java.lang.Override()
    public void loadUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @java.lang.Override()
    public void loadFromInitializer(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.TabInitializer tabInitializer) {
    }
    
    @java.lang.Override()
    public void goBack() {
    }
    
    @java.lang.Override()
    public boolean canGoBack() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<java.lang.Boolean> canGoBackChanges() {
        return null;
    }
    
    @java.lang.Override()
    public void goForward() {
    }
    
    @java.lang.Override()
    public boolean canGoForward() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<java.lang.Boolean> canGoForwardChanges() {
        return null;
    }
    
    @java.lang.Override()
    public void toggleDesktopAgent() {
    }
    
    @java.lang.Override()
    public void reload() {
    }
    
    @java.lang.Override()
    public void stopLoading() {
    }
    
    @java.lang.Override()
    public void find(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    @java.lang.Override()
    public void findNext() {
    }
    
    @java.lang.Override()
    public void findPrevious() {
    }
    
    @java.lang.Override()
    public void clearFindMatches() {
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.String getFindQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.graphics.Bitmap getFavicon() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<acr.browser.lightning.utils.Option<android.graphics.Bitmap>> faviconChanges() {
        return null;
    }
    
    @java.lang.Override()
    public int getThemeColor() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<java.lang.Integer> themeColorChanges() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<java.lang.String> urlChanges() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<java.lang.String> titleChanges() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public acr.browser.lightning.ssl.SslCertificateInfo getSslCertificateInfo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public acr.browser.lightning.ssl.SslState getSslState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<acr.browser.lightning.ssl.SslState> sslChanges() {
        return null;
    }
    
    @java.lang.Override()
    public int getLoadingProgress() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<java.lang.Integer> loadingProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<acr.browser.lightning.browser.download.PendingDownload> downloadRequests() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<android.content.Intent> fileChooserRequests() {
        return null;
    }
    
    @java.lang.Override()
    public void handleFileChooserResult(@org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResult activityResult) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<android.view.View> showCustomViewRequests() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<kotlin.Unit> hideCustomViewRequests() {
        return null;
    }
    
    @java.lang.Override()
    public void hideCustomView() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<acr.browser.lightning.browser.tab.TabInitializer> createWindowRequests() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Observable<kotlin.Unit> closeWindowRequests() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isForeground() {
        return false;
    }
    
    @java.lang.Override()
    public void setForeground(boolean value) {
    }
    
    @java.lang.Override()
    public void destroy() {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.os.Bundle freeze() {
        return null;
    }
    
    public TabAdapter(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.TabInitializer tabInitializer, @org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> requestHeaders, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.TabWebViewClient tabWebViewClient, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.TabWebChromeClient tabWebChromeClient, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    java.lang.String defaultUserAgent, @org.jetbrains.annotations.NotNull()
    java.lang.String defaultTabTitle, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap iconFreeze, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.proxy.Proxy proxy) {
        super();
    }
}