package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * An initializer that loads the url built by the [HtmlPageFactory].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J$\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lacr/browser/lightning/browser/tab/HtmlPageFactoryInitializer;", "Lacr/browser/lightning/browser/tab/TabInitializer;", "htmlPageFactory", "Lacr/browser/lightning/html/HtmlPageFactory;", "diskScheduler", "Lio/reactivex/Scheduler;", "foregroundScheduler", "(Lacr/browser/lightning/html/HtmlPageFactory;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V", "initialize", "", "webView", "Landroid/webkit/WebView;", "headers", "", "", "app_lightningLiteDebug"})
public abstract class HtmlPageFactoryInitializer implements acr.browser.lightning.browser.tab.TabInitializer {
    private final acr.browser.lightning.html.HtmlPageFactory htmlPageFactory = null;
    private final io.reactivex.Scheduler diskScheduler = null;
    private final io.reactivex.Scheduler foregroundScheduler = null;
    
    @java.lang.Override()
    public void initialize(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> headers) {
    }
    
    public HtmlPageFactoryInitializer(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.html.HtmlPageFactory htmlPageFactory, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DiskScheduler()
    io.reactivex.Scheduler diskScheduler, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.MainScheduler()
    io.reactivex.Scheduler foregroundScheduler) {
        super();
    }
}