package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * A [WebViewClient] that supports the tab adaptation.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00ac\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 O2\u00020\u0001:\u0002OPB]\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0014\b\u0001\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\u0002\u0010\u0015J \u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0016J\u0018\u00102\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u00103\u001a\u00020\nH\u0016J\"\u00104\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u00103\u001a\u00020\n2\b\u00105\u001a\u0004\u0018\u000106H\u0016J(\u00107\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\nH\u0016J \u0010<\u001a\u00020,2\u0006\u0010=\u001a\u00020.2\u0006\u00108\u001a\u00020>2\u0006\u0010?\u001a\u00020@H\u0017J \u0010A\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010B\u001a\u00020*2\u0006\u0010C\u001a\u00020*H\u0016J\u0018\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u00020\n2\u0006\u0010F\u001a\u00020\nH\u0002J\u001a\u0010G\u001a\u0004\u0018\u00010H2\u0006\u0010-\u001a\u00020.2\u0006\u0010I\u001a\u00020JH\u0016J\u0018\u0010K\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.2\u0006\u0010I\u001a\u00020JH\u0017J\u0018\u0010K\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.2\u0006\u00103\u001a\u00020\nH\u0016J\u0012\u0010L\u001a\b\u0012\u0004\u0012\u00020N0M*\u00020@H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 @BX\u0086\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020 0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\n0\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001bR\u0010\u0010(\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006Q"}, d2 = {"Lacr/browser/lightning/browser/tab/TabWebViewClient;", "Landroid/webkit/WebViewClient;", "adBlocker", "Lacr/browser/lightning/adblock/AdBlocker;", "allowListModel", "Lacr/browser/lightning/adblock/allowlist/AllowListModel;", "urlHandler", "Lacr/browser/lightning/browser/tab/UrlHandler;", "headers", "", "", "proxy", "Lacr/browser/lightning/browser/proxy/Proxy;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "sslWarningPreferences", "Lacr/browser/lightning/ssl/SslWarningPreferences;", "textReflow", "Lacr/browser/lightning/js/TextReflow;", "logger", "Lacr/browser/lightning/log/Logger;", "(Lacr/browser/lightning/adblock/AdBlocker;Lacr/browser/lightning/adblock/allowlist/AllowListModel;Lacr/browser/lightning/browser/tab/UrlHandler;Ljava/util/Map;Lacr/browser/lightning/browser/proxy/Proxy;Lacr/browser/lightning/preference/UserPreferences;Lacr/browser/lightning/ssl/SslWarningPreferences;Lacr/browser/lightning/js/TextReflow;Lacr/browser/lightning/log/Logger;)V", "currentUrl", "goBackObservable", "Lio/reactivex/subjects/PublishSubject;", "", "getGoBackObservable", "()Lio/reactivex/subjects/PublishSubject;", "goForwardObservable", "getGoForwardObservable", "isReflowRunning", "<set-?>", "Lacr/browser/lightning/ssl/SslState;", "sslState", "getSslState", "()Lacr/browser/lightning/ssl/SslState;", "sslStateObservable", "getSslStateObservable", "urlObservable", "getUrlObservable", "urlWithSslError", "zoomScale", "", "onFormResubmission", "", "view", "Landroid/webkit/WebView;", "dontResend", "Landroid/os/Message;", "resend", "onPageFinished", "url", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedHttpAuthRequest", "handler", "Landroid/webkit/HttpAuthHandler;", "host", "realm", "onReceivedSslError", "webView", "Landroid/webkit/SslErrorHandler;", "error", "Landroid/net/http/SslError;", "onScaleChanged", "oldScale", "newScale", "shouldBlockRequest", "pageUrl", "requestUrl", "shouldInterceptRequest", "Landroid/webkit/WebResourceResponse;", "request", "Landroid/webkit/WebResourceRequest;", "shouldOverrideUrlLoading", "getAllSslErrorMessageCodes", "", "", "Companion", "Factory", "app_lightningLiteDebug"})
public final class TabWebViewClient extends android.webkit.WebViewClient {
    
    /**
     * Emits changes to the current URL.
     */
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.PublishSubject<java.lang.String> urlObservable = null;
    
    /**
     * Emits changes to the current SSL state.
     */
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.PublishSubject<acr.browser.lightning.ssl.SslState> sslStateObservable = null;
    
    /**
     * Emits changes to the can go back state of the browser.
     */
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.PublishSubject<java.lang.Boolean> goBackObservable = null;
    
    /**
     * Emits changes to the can go forward state of the browser.
     */
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.PublishSubject<java.lang.Boolean> goForwardObservable = null;
    
    /**
     * The current SSL state of the page.
     */
    @org.jetbrains.annotations.NotNull()
    private acr.browser.lightning.ssl.SslState sslState;
    private java.lang.String currentUrl = "";
    private boolean isReflowRunning = false;
    private float zoomScale = 0.0F;
    private java.lang.String urlWithSslError;
    private final acr.browser.lightning.adblock.AdBlocker adBlocker = null;
    private final acr.browser.lightning.adblock.allowlist.AllowListModel allowListModel = null;
    private final acr.browser.lightning.browser.tab.UrlHandler urlHandler = null;
    private final java.util.Map<java.lang.String, java.lang.String> headers = null;
    private final acr.browser.lightning.browser.proxy.Proxy proxy = null;
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final acr.browser.lightning.ssl.SslWarningPreferences sslWarningPreferences = null;
    private final acr.browser.lightning.js.TextReflow textReflow = null;
    private final acr.browser.lightning.log.Logger logger = null;
    private static final java.lang.String TAG = "TabWebViewClient";
    private static final byte[] emptyResponseByteArray = {};
    private static final java.lang.String BLOCKED_RESPONSE_MIME_TYPE = "text/plain";
    private static final java.lang.String BLOCKED_RESPONSE_ENCODING = "utf-8";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.browser.tab.TabWebViewClient.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.PublishSubject<java.lang.String> getUrlObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.PublishSubject<acr.browser.lightning.ssl.SslState> getSslStateObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.PublishSubject<java.lang.Boolean> getGoBackObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.PublishSubject<java.lang.Boolean> getGoForwardObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.ssl.SslState getSslState() {
        return null;
    }
    
    private final boolean shouldBlockRequest(java.lang.String pageUrl, java.lang.String requestUrl) {
        return false;
    }
    
    @java.lang.Override()
    public void onPageStarted(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap favicon) {
    }
    
    @java.lang.Override()
    public void onPageFinished(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @java.lang.Override()
    public void onScaleChanged(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, float oldScale, float newScale) {
    }
    
    @java.lang.Override()
    public void onReceivedHttpAuthRequest(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, @org.jetbrains.annotations.NotNull()
    android.webkit.HttpAuthHandler handler, @org.jetbrains.annotations.NotNull()
    java.lang.String host, @org.jetbrains.annotations.NotNull()
    java.lang.String realm) {
    }
    
    @java.lang.Override()
    public void onFormResubmission(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, @org.jetbrains.annotations.NotNull()
    android.os.Message dontResend, @org.jetbrains.annotations.NotNull()
    android.os.Message resend) {
    }
    
    @android.annotation.SuppressLint(value = {"WebViewClientOnReceivedSslError"})
    @java.lang.Override()
    public void onReceivedSslError(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView, @org.jetbrains.annotations.NotNull()
    android.webkit.SslErrorHandler handler, @org.jetbrains.annotations.NotNull()
    android.net.http.SslError error) {
    }
    
    @java.lang.Override()
    public boolean shouldOverrideUrlLoading(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return false;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.N)
    @java.lang.Override()
    public boolean shouldOverrideUrlLoading(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, @org.jetbrains.annotations.NotNull()
    android.webkit.WebResourceRequest request) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.webkit.WebResourceResponse shouldInterceptRequest(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, @org.jetbrains.annotations.NotNull()
    android.webkit.WebResourceRequest request) {
        return null;
    }
    
    private final java.util.List<java.lang.Integer> getAllSslErrorMessageCodes(android.net.http.SslError $this$getAllSslErrorMessageCodes) {
        return null;
    }
    
    @dagger.assisted.AssistedInject()
    public TabWebViewClient(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.AdBlocker adBlocker, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.allowlist.AllowListModel allowListModel, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.UrlHandler urlHandler, @org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    java.util.Map<java.lang.String, java.lang.String> headers, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.proxy.Proxy proxy, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.ssl.SslWarningPreferences sslWarningPreferences, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.js.TextReflow textReflow, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger) {
        super();
    }
    
    /**
     * The factory for constructing the client.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/browser/tab/TabWebViewClient$Factory;", "", "create", "Lacr/browser/lightning/browser/tab/TabWebViewClient;", "headers", "", "", "app_lightningLiteDebug"})
    @dagger.assisted.AssistedFactory()
    public static abstract interface Factory {
        
        /**
         * Create the client.
         */
        @org.jetbrains.annotations.NotNull()
        public abstract acr.browser.lightning.browser.tab.TabWebViewClient create(@org.jetbrains.annotations.NotNull()
        java.util.Map<java.lang.String, java.lang.String> headers);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/browser/tab/TabWebViewClient$Companion;", "", "()V", "BLOCKED_RESPONSE_ENCODING", "", "BLOCKED_RESPONSE_MIME_TYPE", "TAG", "emptyResponseByteArray", "", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}