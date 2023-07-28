package acr.browser.lightning.html.history;

import java.lang.System;

/**
 * Factory for the history page.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\f\u0010\u001c\u001a\u00020\f*\u00020\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lacr/browser/lightning/html/history/HistoryPageFactory;", "Lacr/browser/lightning/html/HtmlPageFactory;", "listPageReader", "Lacr/browser/lightning/html/ListPageReader;", "application", "Landroid/app/Application;", "historyRepository", "Lacr/browser/lightning/database/history/HistoryRepository;", "themeProvider", "Lacr/browser/lightning/browser/theme/ThemeProvider;", "(Lacr/browser/lightning/html/ListPageReader;Landroid/app/Application;Lacr/browser/lightning/database/history/HistoryRepository;Lacr/browser/lightning/browser/theme/ThemeProvider;)V", "backgroundColor", "", "getBackgroundColor", "()Ljava/lang/String;", "dividerColor", "getDividerColor", "subtitleColor", "getSubtitleColor", "textColor", "getTextColor", "title", "buildPage", "Lio/reactivex/Single;", "createHistoryPage", "Ljava/io/File;", "deleteHistoryPage", "Lio/reactivex/Completable;", "toColor", "", "Companion", "app_lightningPlusDebug"})
public final class HistoryPageFactory implements acr.browser.lightning.html.HtmlPageFactory {
    private final java.lang.String title = null;
    private final acr.browser.lightning.html.ListPageReader listPageReader = null;
    private final android.app.Application application = null;
    private final acr.browser.lightning.database.history.HistoryRepository historyRepository = null;
    private final acr.browser.lightning.browser.theme.ThemeProvider themeProvider = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FILENAME = "history.html";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.html.history.HistoryPageFactory.Companion Companion = null;
    
    private final java.lang.String toColor(int $this$toColor) {
        return null;
    }
    
    private final java.lang.String getBackgroundColor() {
        return null;
    }
    
    private final java.lang.String getDividerColor() {
        return null;
    }
    
    private final java.lang.String getTextColor() {
        return null;
    }
    
    private final java.lang.String getSubtitleColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.String> buildPage() {
        return null;
    }
    
    /**
     * Use this observable to immediately delete the history page. This will clear the cached
     * history page that was stored on file.
     *
     * @return a completable that deletes the history page when subscribed to.
     */
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Completable deleteHistoryPage() {
        return null;
    }
    
    private final java.io.File createHistoryPage() {
        return null;
    }
    
    @javax.inject.Inject()
    public HistoryPageFactory(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.html.ListPageReader listPageReader, @org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.history.HistoryRepository historyRepository, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.theme.ThemeProvider themeProvider) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/html/history/HistoryPageFactory$Companion;", "", "()V", "FILENAME", "", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}