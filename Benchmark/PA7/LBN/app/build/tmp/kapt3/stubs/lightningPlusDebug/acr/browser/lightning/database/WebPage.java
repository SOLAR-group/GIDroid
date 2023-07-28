package acr.browser.lightning.database;

import java.lang.System;

/**
 * A data type that represents a page that can be loaded.
 *
 * @param url The URL of the web page.
 * @param title The title of the web page.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u0082\u0001\u0003\t\n\u000b\u00a8\u0006\f"}, d2 = {"Lacr/browser/lightning/database/WebPage;", "", "url", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getUrl", "Lacr/browser/lightning/database/HistoryEntry;", "Lacr/browser/lightning/database/Bookmark;", "Lacr/browser/lightning/database/SearchSuggestion;", "app_lightningPlusDebug"})
public abstract class WebPage {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getTitle() {
        return null;
    }
    
    private WebPage(java.lang.String url, java.lang.String title) {
        super();
    }
}