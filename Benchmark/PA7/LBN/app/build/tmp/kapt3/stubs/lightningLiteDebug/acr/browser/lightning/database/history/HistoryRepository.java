package acr.browser.lightning.database.history;

import java.lang.System;

/**
 * An interface that should be used to communicate with the history database.
 *
 * Created by anthonycr on 6/9/17.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\u0006H&J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u001a\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\u000f"}, d2 = {"Lacr/browser/lightning/database/history/HistoryRepository;", "", "deleteHistory", "Lio/reactivex/Completable;", "deleteHistoryEntry", "url", "", "findHistoryEntriesContaining", "Lio/reactivex/Single;", "", "Lacr/browser/lightning/database/HistoryEntry;", "query", "lastHundredVisitedHistoryEntries", "visitHistoryEntry", "title", "app_lightningLiteDebug"})
public abstract interface HistoryRepository {
    
    /**
     * An observable that deletes browser history.
     *
     * @return a valid observable.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable deleteHistory();
    
    /**
     * An observable that deletes the history entry with the specific URL.
     *
     * @param url the URL of the item to delete.
     * @return a valid observable.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable deleteHistoryEntry(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    /**
     * An observable that visits the URL by adding it to the database if it doesn't exist or
     * updating the time visited if it does.
     *
     * @param url   the URL of the item that was visited.
     * @param title the title of the item that was visited.
     * @return a valid observable.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable visitHistoryEntry(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String title);
    
    /**
     * An observable that finds all history items containing the given query. If the query is
     * contained anywhere within the title or the URL of the history item, it will be returned. For
     * the sake of performance, only the first five items will be emitted.
     *
     * @param query the query to search for.
     * @return a valid observable that emits
     * a list of history items.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<acr.browser.lightning.database.HistoryEntry>> findHistoryEntriesContaining(@org.jetbrains.annotations.NotNull()
    java.lang.String query);
    
    /**
     * An observable that emits a list of the last 100 visited history items.
     *
     * @return a valid observable that emits a list of history items.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<acr.browser.lightning.database.HistoryEntry>> lastHundredVisitedHistoryEntries();
}