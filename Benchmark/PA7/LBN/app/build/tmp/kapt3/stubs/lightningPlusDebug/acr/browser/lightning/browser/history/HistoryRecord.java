package acr.browser.lightning.browser.history;

import java.lang.System;

/**
 * Records browser history.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/browser/history/HistoryRecord;", "", "recordVisit", "", "title", "", "url", "app_lightningPlusDebug"})
public abstract interface HistoryRecord {
    
    /**
     * Record a visit to the [url] with the provided [title].
     */
    public abstract void recordVisit(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String url);
}