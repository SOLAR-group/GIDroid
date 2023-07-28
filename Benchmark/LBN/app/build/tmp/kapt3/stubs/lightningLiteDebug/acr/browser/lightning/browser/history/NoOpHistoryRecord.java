package acr.browser.lightning.browser.history;

import java.lang.System;

/**
 * A non functional history record that ignores all attempts to record a visit.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"Lacr/browser/lightning/browser/history/NoOpHistoryRecord;", "Lacr/browser/lightning/browser/history/HistoryRecord;", "()V", "recordVisit", "", "title", "", "url", "app_lightningLiteDebug"})
public final class NoOpHistoryRecord implements acr.browser.lightning.browser.history.HistoryRecord {
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.browser.history.NoOpHistoryRecord INSTANCE = null;
    
    @java.lang.Override()
    public void recordVisit(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    private NoOpHistoryRecord() {
        super();
    }
}