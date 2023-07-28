package acr.browser.lightning.database.downloads;

import java.lang.System;

/**
 * The interface that should be used to communicate with the download database.
 *
 * Created by df1e on 29/5/17.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH&J\b\u0010\u000b\u001a\u00020\fH\'J\b\u0010\r\u001a\u00020\bH&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\u0003H&J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u000f\u001a\u00020\u0010H&\u00a8\u0006\u0015"}, d2 = {"Lacr/browser/lightning/database/downloads/DownloadsRepository;", "", "addDownloadIfNotExists", "Lio/reactivex/Single;", "", "entry", "Lacr/browser/lightning/database/downloads/DownloadEntry;", "addDownloadsList", "Lio/reactivex/Completable;", "downloadEntries", "", "count", "", "deleteAllDownloads", "deleteDownload", "url", "", "findDownloadForUrl", "Lio/reactivex/Maybe;", "getAllDownloads", "isDownload", "app_lightningLiteDebug"})
public abstract interface DownloadsRepository {
    
    /**
     * Determines if a URL is associated with a download.
     *
     * @param url the URL to check.
     * @return an observable that will emit true if the URL is a download, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.lang.Boolean> isDownload(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    /**
     * Gets the download associated with the URL.
     *
     * @param url the URL to look for.
     * @return an observable that will emit either the download associated with the URL or null.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Maybe<acr.browser.lightning.database.downloads.DownloadEntry> findDownloadForUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    /**
     * Adds a download if one does not already exist with the same URL.
     *
     * @param entry the download to add.
     * @return an observable that emits true if the download was added, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.lang.Boolean> addDownloadIfNotExists(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.downloads.DownloadEntry entry);
    
    /**
     * Adds a list of downloads to the database.
     *
     * @param downloadEntries the downloads to add.
     * @return an observable that emits a complete event when all the downloads have been added.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable addDownloadsList(@org.jetbrains.annotations.NotNull()
    java.util.List<acr.browser.lightning.database.downloads.DownloadEntry> downloadEntries);
    
    /**
     * Deletes a download from the database.
     *
     * @param url the download url to delete.
     * @return an observable that emits true when the download is deleted, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.lang.Boolean> deleteDownload(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    /**
     * Deletes all downloads in the database.
     *
     * @return an observable that emits a completion event when all downloads have been deleted.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable deleteAllDownloads();
    
    /**
     * Emits a list of all downloads, sorted by primary key.
     *
     * @return an observable that emits a list of all downloads.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<acr.browser.lightning.database.downloads.DownloadEntry>> getAllDownloads();
    
    /**
     * A synchronous call to the model that returns the number of downloads. Should be called from a
     * background thread.
     *
     * @return the number of downloads in the database.
     */
    @androidx.annotation.WorkerThread()
    public abstract long count();
}