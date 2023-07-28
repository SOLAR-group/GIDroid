package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * The representation of a browser tab.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010#\u001a\u00020\u000fH&J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000f0%H&J\b\u0010&\u001a\u00020\u000fH&J\u000e\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u000f0%H&J\b\u0010(\u001a\u00020)H&J\u000e\u0010*\u001a\b\u0012\u0004\u0012\u00020)0%H&J\u000e\u0010+\u001a\b\u0012\u0004\u0012\u00020,0%H&J\b\u0010-\u001a\u00020)H&J\u000e\u0010.\u001a\b\u0012\u0004\u0012\u00020/0%H&J\u0014\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u0003010%H&J\u000e\u00102\u001a\b\u0012\u0004\u0012\u0002030%H&J\u0010\u00104\u001a\u00020)2\u0006\u00105\u001a\u00020\u0007H&J\b\u00106\u001a\u00020)H&J\b\u00107\u001a\u00020)H&J\b\u00108\u001a\u000209H&J\b\u0010:\u001a\u00020)H&J\b\u0010;\u001a\u00020)H&J\u0010\u0010<\u001a\u00020)2\u0006\u0010=\u001a\u00020>H&J\b\u0010?\u001a\u00020)H&J\u000e\u0010@\u001a\b\u0012\u0004\u0012\u00020)0%H&J\u0010\u0010A\u001a\u00020)2\u0006\u0010B\u001a\u00020,H&J\u0010\u0010C\u001a\u00020)2\u0006\u0010!\u001a\u00020\u0007H&J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0%H&J\b\u0010D\u001a\u00020)H&J\u000e\u0010E\u001a\b\u0012\u0004\u0012\u00020F0%H&J\u000e\u0010G\u001a\b\u0012\u0004\u0012\u00020\u001a0%H&J\b\u0010H\u001a\u00020)H&J\u000e\u0010I\u001a\b\u0012\u0004\u0012\u00020\u000b0%H&J\u000e\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00070%H&J\b\u0010K\u001a\u00020)H&J\u000e\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00070%H&R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX\u00a6\u000e\u00a2\u0006\f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u000bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\rR\u0014\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u001aX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u000b8gX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001e\u0010\rR\u0012\u0010\u001f\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\tR\u0012\u0010!\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010\t\u00a8\u0006M"}, d2 = {"Lacr/browser/lightning/browser/tab/TabModel;", "", "favicon", "Landroid/graphics/Bitmap;", "getFavicon", "()Landroid/graphics/Bitmap;", "findQuery", "", "getFindQuery", "()Ljava/lang/String;", "id", "", "getId", "()I", "isForeground", "", "()Z", "setForeground", "(Z)V", "loadingProgress", "getLoadingProgress", "sslCertificateInfo", "Lacr/browser/lightning/ssl/SslCertificateInfo;", "getSslCertificateInfo", "()Lacr/browser/lightning/ssl/SslCertificateInfo;", "sslState", "Lacr/browser/lightning/ssl/SslState;", "getSslState", "()Lacr/browser/lightning/ssl/SslState;", "themeColor", "getThemeColor", "title", "getTitle", "url", "getUrl", "canGoBack", "canGoBackChanges", "Lio/reactivex/Observable;", "canGoForward", "canGoForwardChanges", "clearFindMatches", "", "closeWindowRequests", "createWindowRequests", "Lacr/browser/lightning/browser/tab/TabInitializer;", "destroy", "downloadRequests", "Lacr/browser/lightning/browser/download/PendingDownload;", "faviconChanges", "Lacr/browser/lightning/utils/Option;", "fileChooserRequests", "Landroid/content/Intent;", "find", "query", "findNext", "findPrevious", "freeze", "Landroid/os/Bundle;", "goBack", "goForward", "handleFileChooserResult", "activityResult", "Landroidx/activity/result/ActivityResult;", "hideCustomView", "hideCustomViewRequests", "loadFromInitializer", "tabInitializer", "loadUrl", "reload", "showCustomViewRequests", "Landroid/view/View;", "sslChanges", "stopLoading", "themeColorChanges", "titleChanges", "toggleDesktopAgent", "urlChanges", "app_lightningPlusDebug"})
public abstract interface TabModel {
    
    /**
     * The tab identifier.
     */
    public abstract int getId();
    
    /**
     * Load a [url] in the tab.
     */
    public abstract void loadUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    /**
     * Load a URL using the provided [tabInitializer].
     */
    public abstract void loadFromInitializer(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.TabInitializer tabInitializer);
    
    /**
     * Go back in the navigation tree.
     */
    public abstract void goBack();
    
    /**
     * True if [goBack] has something to go back to, false otherwise.
     */
    public abstract boolean canGoBack();
    
    /**
     * Emits changes to the [canGoBack] status.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<java.lang.Boolean> canGoBackChanges();
    
    /**
     * Go forward in the navigation tree.
     */
    public abstract void goForward();
    
    /**
     * True if [goForward] has something to go forward to, false otherwise.
     */
    public abstract boolean canGoForward();
    
    /**
     * Emits changes to the [canGoForward] status.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<java.lang.Boolean> canGoForwardChanges();
    
    /**
     * Toggle the user agent used by the browser to a desktop one or back to the default one.
     */
    public abstract void toggleDesktopAgent();
    
    /**
     * Reload the page the browser is currently showing.
     */
    public abstract void reload();
    
    /**
     * Stop loading the current page if it is loading. If the page is not loading, has no effect.
     */
    public abstract void stopLoading();
    
    /**
     * Highlight words in the webpage that match the [query].
     */
    public abstract void find(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    /**
     * Move to the next word highlighted by [find].
     */
    public abstract void findNext();
    
    /**
     * Move to the previous word highlighted by [find].
     */
    public abstract void findPrevious();
    
    /**
     * Remove highlighting from all words highlighted by [find].
     */
    public abstract void clearFindMatches();
    
    /**
     * The current query that is being highlighted by [find].
     */
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.String getFindQuery();
    
    /**
     * The current favicon of the webpage or null if there isn't one.
     */
    @org.jetbrains.annotations.Nullable()
    public abstract android.graphics.Bitmap getFavicon();
    
    /**
     * Emits changes to the [favicon].
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<acr.browser.lightning.utils.Option<android.graphics.Bitmap>> faviconChanges();
    
    /**
     * The thematic color of the current webpage.
     */
    @androidx.annotation.ColorInt()
    public abstract int getThemeColor();
    
    /**
     * Emits changes to the [themeColor].
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<java.lang.Integer> themeColorChanges();
    
    /**
     * The URL of the currently displayed webpage.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getUrl();
    
    /**
     * Emits changes to the [url].
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<java.lang.String> urlChanges();
    
    /**
     * The title of the current webpage.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getTitle();
    
    /**
     * Emits changes to the [title].
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<java.lang.String> titleChanges();
    
    /**
     * The current SSL certificate information about the webpage.
     */
    @org.jetbrains.annotations.Nullable()
    public abstract acr.browser.lightning.ssl.SslCertificateInfo getSslCertificateInfo();
    
    /**
     * The current state of the SSL certificate.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract acr.browser.lightning.ssl.SslState getSslState();
    
    /**
     * Emits changes to [sslState].
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<acr.browser.lightning.ssl.SslState> sslChanges();
    
    /**
     * The loading progress for the current webpage on a scale of 0-100. If the page is completely
     * loaded, then the progress will be 100.
     */
    public abstract int getLoadingProgress();
    
    /**
     * Emits changes to [sslState].
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<java.lang.Integer> loadingProgress();
    
    /**
     * Emits requests to download a file represented by [PendingDownload] that are triggered by the
     * browser.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<acr.browser.lightning.browser.download.PendingDownload> downloadRequests();
    
    /**
     * Emits requests to open the file chooser that are triggered by the browser.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<android.content.Intent> fileChooserRequests();
    
    /**
     * Handle a resulting file to upload after selecting a file from the file chooser.
     */
    public abstract void handleFileChooserResult(@org.jetbrains.annotations.NotNull()
    androidx.activity.result.ActivityResult activityResult);
    
    /**
     * Emits requests by the browser to display a custom view (i.e. full screen video) over the
     * regular webpage content.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<android.view.View> showCustomViewRequests();
    
    /**
     * Emits requests by the browser to hide the custom view it previously requested to display via
     * [showCustomViewRequests].
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<kotlin.Unit> hideCustomViewRequests();
    
    /**
     * Notify the browser that we are manually hiding the custom view requested to be shown by
     * [showCustomViewRequests].
     */
    public abstract void hideCustomView();
    
    /**
     * Emits requests by the browser to automatically open a new tab and load the URL provided by
     * the [TabInitializer].
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<acr.browser.lightning.browser.tab.TabInitializer> createWindowRequests();
    
    /**
     * Emits requests by the browser to automatically close the current tab.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Observable<kotlin.Unit> closeWindowRequests();
    
    /**
     * True if the tab is in the foreground, false if it is in the background. Used to prevent
     * background tabs from consuming disproportionate amounts of resources when they are unused.
     */
    public abstract boolean isForeground();
    
    /**
     * True if the tab is in the foreground, false if it is in the background. Used to prevent
     * background tabs from consuming disproportionate amounts of resources when they are unused.
     */
    public abstract void setForeground(boolean p0);
    
    /**
     * Teardown the current tab and release held resources.
     */
    public abstract void destroy();
    
    /**
     * Freeze the current state of the tab and return it as a [Bundle].
     */
    @org.jetbrains.annotations.NotNull()
    public abstract android.os.Bundle freeze();
}