package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * A sort of coordinator that manages the relationship between [WebViews][WebView] and the container
 * the views are placed in.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0011J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u000bJ\u0006\u0010\u001d\u001a\u00020\u0011J\u001a\u0010\u001e\u001a\u00020\u0018*\b\u0012\u0004\u0012\u00020\u00180\u001f2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\f\u0010 \u001a\u00020\u0011*\u00020\u0003H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000RL\u0010\t\u001a4\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lacr/browser/lightning/browser/tab/TabPager;", "", "container", "Landroid/widget/FrameLayout;", "webViewScrollCoordinator", "Lacr/browser/lightning/browser/view/WebViewScrollCoordinator;", "webViewLongPressHandler", "Lacr/browser/lightning/browser/view/WebViewLongPressHandler;", "(Landroid/widget/FrameLayout;Lacr/browser/lightning/browser/view/WebViewScrollCoordinator;Lacr/browser/lightning/browser/view/WebViewLongPressHandler;)V", "longPressListener", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "id", "Lacr/browser/lightning/browser/view/targetUrl/LongPress;", "longPress", "", "getLongPressListener", "()Lkotlin/jvm/functions/Function2;", "setLongPressListener", "(Lkotlin/jvm/functions/Function2;)V", "webViews", "", "Landroid/webkit/WebView;", "addTab", "webView", "clearTab", "selectTab", "showToolbar", "forId", "", "removeWebViews", "app_lightningPlusDebug"})
@acr.browser.lightning.browser.di.Browser2Scope()
public final class TabPager {
    private final java.util.List<android.webkit.WebView> webViews = null;
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super acr.browser.lightning.browser.view.targetUrl.LongPress, kotlin.Unit> longPressListener;
    private final android.widget.FrameLayout container = null;
    private final acr.browser.lightning.browser.view.WebViewScrollCoordinator webViewScrollCoordinator = null;
    private final acr.browser.lightning.browser.view.WebViewLongPressHandler webViewLongPressHandler = null;
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function2<java.lang.Integer, acr.browser.lightning.browser.view.targetUrl.LongPress, kotlin.Unit> getLongPressListener() {
        return null;
    }
    
    public final void setLongPressListener(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super acr.browser.lightning.browser.view.targetUrl.LongPress, kotlin.Unit> p0) {
    }
    
    /**
     * Select the tab with the provided [id] to be displayed by the pager.
     */
    public final void selectTab(int id) {
    }
    
    /**
     * Clear the container of the [WebView] currently shown.
     */
    public final void clearTab() {
    }
    
    /**
     * Add a [WebView] to the list of views shown by this pager.
     */
    public final void addTab(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView) {
    }
    
    /**
     * Show the toolbar/search box if it is currently hidden.
     */
    public final void showToolbar() {
    }
    
    private final void removeWebViews(android.widget.FrameLayout $this$removeWebViews) {
    }
    
    private final android.webkit.WebView forId(java.util.List<? extends android.webkit.WebView> $this$forId, int id) {
        return null;
    }
    
    @javax.inject.Inject()
    public TabPager(@org.jetbrains.annotations.NotNull()
    android.widget.FrameLayout container, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.view.WebViewScrollCoordinator webViewScrollCoordinator, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.view.WebViewLongPressHandler webViewLongPressHandler) {
        super();
    }
}