package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * An initializer that displays the history page.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lacr/browser/lightning/browser/tab/HistoryPageInitializer;", "Lacr/browser/lightning/browser/tab/HtmlPageFactoryInitializer;", "historyPageFactory", "Lacr/browser/lightning/html/history/HistoryPageFactory;", "diskScheduler", "Lio/reactivex/Scheduler;", "foregroundScheduler", "(Lacr/browser/lightning/html/history/HistoryPageFactory;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V", "app_lightningLiteDebug"})
@dagger.Reusable()
public final class HistoryPageInitializer extends acr.browser.lightning.browser.tab.HtmlPageFactoryInitializer {
    
    @javax.inject.Inject()
    public HistoryPageInitializer(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.html.history.HistoryPageFactory historyPageFactory, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DiskScheduler()
    io.reactivex.Scheduler diskScheduler, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.MainScheduler()
    io.reactivex.Scheduler foregroundScheduler) {
        super(null, null, null);
    }
}