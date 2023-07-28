package acr.browser.lightning.browser.history;

import java.lang.System;

/**
 * The default history record that records the history in a permanent data store.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lacr/browser/lightning/browser/history/DefaultHistoryRecord;", "Lacr/browser/lightning/browser/history/HistoryRecord;", "historyRepository", "Lacr/browser/lightning/database/history/HistoryRepository;", "databaseScheduler", "Lio/reactivex/Scheduler;", "(Lacr/browser/lightning/database/history/HistoryRepository;Lio/reactivex/Scheduler;)V", "recordVisit", "", "title", "", "url", "app_lightningLiteDebug"})
public final class DefaultHistoryRecord implements acr.browser.lightning.browser.history.HistoryRecord {
    private final acr.browser.lightning.database.history.HistoryRepository historyRepository = null;
    private final io.reactivex.Scheduler databaseScheduler = null;
    
    @java.lang.Override()
    public void recordVisit(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @javax.inject.Inject()
    public DefaultHistoryRecord(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.history.HistoryRepository historyRepository, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DatabaseScheduler()
    io.reactivex.Scheduler databaseScheduler) {
        super();
    }
}