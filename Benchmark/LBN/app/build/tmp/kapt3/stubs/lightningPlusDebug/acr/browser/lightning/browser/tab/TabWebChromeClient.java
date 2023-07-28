package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * A [WebChromeClient] that supports the tab adaptation.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00cc\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B/\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u0012\u00105\u001a\u00020\u00102\b\u00106\u001a\u0004\u0018\u00010 H\u0002J\u0006\u00107\u001a\u00020\u0010J\u0010\u00108\u001a\u00020\u00102\u0006\u00109\u001a\u00020:H\u0016J(\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020:2\u0006\u0010>\u001a\u00020<2\u0006\u0010?\u001a\u00020<2\u0006\u0010@\u001a\u00020AH\u0016J\u0018\u0010B\u001a\u00020\u00102\u0006\u0010C\u001a\u00020*2\u0006\u0010D\u001a\u00020EH\u0016J\b\u0010F\u001a\u00020\u0010H\u0016J\u0010\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020IH\u0016J\u0018\u0010J\u001a\u00020\u00102\u0006\u0010=\u001a\u00020:2\u0006\u0010K\u001a\u00020\u0015H\u0016J\u0018\u0010L\u001a\u00020\u00102\u0006\u0010=\u001a\u00020:2\u0006\u0010M\u001a\u00020 H\u0016J\u0018\u0010N\u001a\u00020\u00102\u0006\u0010=\u001a\u00020:2\u0006\u0010O\u001a\u00020*H\u0016J\u000e\u0010P\u001a\u00020\u00102\u0006\u0010Q\u001a\u00020RJ\u0018\u0010S\u001a\u00020\u00102\u0006\u0010=\u001a\u0002012\u0006\u0010D\u001a\u00020\u001cH\u0016J,\u0010T\u001a\u00020<2\u0006\u0010U\u001a\u00020:2\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\'0&2\u0006\u0010V\u001a\u00020WH\u0016J*\u0010X\u001a\u00020\u00102\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020*0Z2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00100\\H\u0016J7\u0010]\u001a\u00020\u00102\u0006\u0010^\u001a\u00020*2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020*0\'2\u0012\u0010[\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00100\\H\u0016\u00a2\u0006\u0002\u0010`R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0012R\u001c\u0010%\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\'\u0018\u00010&X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\'X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010+R\u0017\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0012R\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0012R\u0017\u00100\u001a\b\u0012\u0004\u0012\u0002010\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0012R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020*0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0012R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006a"}, d2 = {"Lacr/browser/lightning/browser/tab/TabWebChromeClient;", "Landroid/webkit/WebChromeClient;", "Lacr/browser/lightning/browser/webrtc/WebRtcPermissionsView;", "activity", "Landroid/app/Activity;", "faviconModel", "Lacr/browser/lightning/favicon/FaviconModel;", "diskScheduler", "Lio/reactivex/Scheduler;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "webRtcPermissionsModel", "Lacr/browser/lightning/browser/webrtc/WebRtcPermissionsModel;", "(Landroid/app/Activity;Lacr/browser/lightning/favicon/FaviconModel;Lio/reactivex/Scheduler;Lacr/browser/lightning/preference/UserPreferences;Lacr/browser/lightning/browser/webrtc/WebRtcPermissionsModel;)V", "closeWindowObservable", "Lio/reactivex/subjects/PublishSubject;", "", "getCloseWindowObservable", "()Lio/reactivex/subjects/PublishSubject;", "colorChangeObservable", "Lio/reactivex/subjects/BehaviorSubject;", "", "getColorChangeObservable", "()Lio/reactivex/subjects/BehaviorSubject;", "createWindowObservable", "Lacr/browser/lightning/browser/tab/TabInitializer;", "getCreateWindowObservable", "customViewCallback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "defaultColor", "faviconObservable", "Lacr/browser/lightning/utils/Option;", "Landroid/graphics/Bitmap;", "getFaviconObservable", "fileChooserObservable", "Landroid/content/Intent;", "getFileChooserObservable", "filePathCallback", "Landroid/webkit/ValueCallback;", "", "Landroid/net/Uri;", "geoLocationPermissions", "", "[Ljava/lang/String;", "hideCustomViewObservable", "getHideCustomViewObservable", "progressObservable", "getProgressObservable", "showCustomViewObservable", "Landroid/view/View;", "getShowCustomViewObservable", "titleObservable", "getTitleObservable", "generateColorAndPropagate", "favicon", "hideCustomView", "onCloseWindow", "window", "Landroid/webkit/WebView;", "onCreateWindow", "", "view", "isDialog", "isUserGesture", "resultMsg", "Landroid/os/Message;", "onGeolocationPermissionsShowPrompt", "origin", "callback", "Landroid/webkit/GeolocationPermissions$Callback;", "onHideCustomView", "onPermissionRequest", "request", "Landroid/webkit/PermissionRequest;", "onProgressChanged", "newProgress", "onReceivedIcon", "icon", "onReceivedTitle", "title", "onResult", "activityResult", "Landroidx/activity/result/ActivityResult;", "onShowCustomView", "onShowFileChooser", "webView", "fileChooserParams", "Landroid/webkit/WebChromeClient$FileChooserParams;", "requestPermissions", "permissions", "", "onGrant", "Lkotlin/Function1;", "requestResources", "source", "resources", "(Ljava/lang/String;[Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "app_lightningPlusDebug"})
public final class TabWebChromeClient extends android.webkit.WebChromeClient implements acr.browser.lightning.browser.webrtc.WebRtcPermissionsView {
    private final int defaultColor = 0;
    private final java.lang.String[] geoLocationPermissions = {"android.permission.ACCESS_FINE_LOCATION"};
    
    /**
     * Emits changes to the page loading progress.
     */
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.PublishSubject<java.lang.Integer> progressObservable = null;
    
    /**
     * Emits changes to the page title.
     */
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.PublishSubject<java.lang.String> titleObservable = null;
    
    /**
     * Emits changes to the page favicon. Always emits the last emitted favicon.
     */
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.BehaviorSubject<acr.browser.lightning.utils.Option<android.graphics.Bitmap>> faviconObservable = null;
    
    /**
     * Emits create window requests.
     */
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.PublishSubject<acr.browser.lightning.browser.tab.TabInitializer> createWindowObservable = null;
    
    /**
     * Emits close window requests.
     */
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.PublishSubject<kotlin.Unit> closeWindowObservable = null;
    
    /**
     * Emits changes to the thematic color of the current page.
     */
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.BehaviorSubject<java.lang.Integer> colorChangeObservable = null;
    
    /**
     * Emits requests to open the file chooser for upload.
     */
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.PublishSubject<android.content.Intent> fileChooserObservable = null;
    
    /**
     * Emits requests to show a custom view (i.e. full screen video).
     */
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.PublishSubject<android.view.View> showCustomViewObservable = null;
    
    /**
     * Emits requests to hide the custom view that was shown prior.
     */
    @org.jetbrains.annotations.NotNull()
    private final io.reactivex.subjects.PublishSubject<kotlin.Unit> hideCustomViewObservable = null;
    private android.webkit.ValueCallback<android.net.Uri[]> filePathCallback;
    private android.webkit.WebChromeClient.CustomViewCallback customViewCallback;
    private final android.app.Activity activity = null;
    private final acr.browser.lightning.favicon.FaviconModel faviconModel = null;
    private final io.reactivex.Scheduler diskScheduler = null;
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final acr.browser.lightning.browser.webrtc.WebRtcPermissionsModel webRtcPermissionsModel = null;
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.PublishSubject<java.lang.Integer> getProgressObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.PublishSubject<java.lang.String> getTitleObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.BehaviorSubject<acr.browser.lightning.utils.Option<android.graphics.Bitmap>> getFaviconObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.PublishSubject<acr.browser.lightning.browser.tab.TabInitializer> getCreateWindowObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.PublishSubject<kotlin.Unit> getCloseWindowObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.BehaviorSubject<java.lang.Integer> getColorChangeObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.PublishSubject<android.content.Intent> getFileChooserObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.PublishSubject<android.view.View> getShowCustomViewObservable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.subjects.PublishSubject<kotlin.Unit> getHideCustomViewObservable() {
        return null;
    }
    
    /**
     * Handle the [activityResult] that was returned by the file chooser.
     */
    public final void onResult(@org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResult activityResult) {
    }
    
    /**
     * Notify the client that we have manually hidden the custom view.
     */
    public final void hideCustomView() {
    }
    
    @java.lang.Override()
    public boolean onCreateWindow(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, boolean isDialog, boolean isUserGesture, @org.jetbrains.annotations.NotNull()
    android.os.Message resultMsg) {
        return false;
    }
    
    @java.lang.Override()
    public void onCloseWindow(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView window) {
    }
    
    @java.lang.Override()
    public void onProgressChanged(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, int newProgress) {
    }
    
    @java.lang.Override()
    public void onReceivedTitle(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, @org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    @java.lang.Override()
    public void onReceivedIcon(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView view, @org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap icon) {
    }
    
    private final void generateColorAndPropagate(android.graphics.Bitmap favicon) {
    }
    
    @java.lang.Override()
    public boolean onShowFileChooser(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView, @org.jetbrains.annotations.NotNull()
    android.webkit.ValueCallback<android.net.Uri[]> filePathCallback, @org.jetbrains.annotations.NotNull()
    android.webkit.WebChromeClient.FileChooserParams fileChooserParams) {
        return false;
    }
    
    @java.lang.Override()
    public void onShowCustomView(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    android.webkit.WebChromeClient.CustomViewCallback callback) {
    }
    
    @java.lang.Override()
    public void onHideCustomView() {
    }
    
    @java.lang.Override()
    public void requestPermissions(@org.jetbrains.annotations.NotNull()
    java.util.Set<java.lang.String> permissions, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onGrant) {
    }
    
    @java.lang.Override()
    public void requestResources(@org.jetbrains.annotations.NotNull()
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    java.lang.String[] resources, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onGrant) {
    }
    
    @java.lang.Override()
    public void onPermissionRequest(@org.jetbrains.annotations.NotNull()
    android.webkit.PermissionRequest request) {
    }
    
    @java.lang.Override()
    public void onGeolocationPermissionsShowPrompt(@org.jetbrains.annotations.NotNull()
    java.lang.String origin, @org.jetbrains.annotations.NotNull()
    android.webkit.GeolocationPermissions.Callback callback) {
    }
    
    @javax.inject.Inject()
    public TabWebChromeClient(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.favicon.FaviconModel faviconModel, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DiskScheduler()
    io.reactivex.Scheduler diskScheduler, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.webrtc.WebRtcPermissionsModel webRtcPermissionsModel) {
        super();
    }
}