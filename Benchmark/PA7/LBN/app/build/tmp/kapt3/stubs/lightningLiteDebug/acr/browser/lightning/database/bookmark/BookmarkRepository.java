package acr.browser.lightning.database.bookmark;

import java.lang.System;

/**
 * The interface that should be used to communicate with the bookmark database.
 *
 * Created by anthonycr on 5/6/17.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nH&J\b\u0010\u000b\u001a\u00020\fH\'J\b\u0010\r\u001a\u00020\bH&J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0018\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H&J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u00162\u0006\u0010\u0017\u001a\u00020\u0011H&J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\n0\u0003H&J\u001e\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\n0\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0011H&J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\n0\u0003H&J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\n0\u0003H&J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0017\u001a\u00020\u0011H&J\u0018\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u0011H&\u00a8\u0006#"}, d2 = {"Lacr/browser/lightning/database/bookmark/BookmarkRepository;", "", "addBookmarkIfNotExists", "Lio/reactivex/Single;", "", "entry", "Lacr/browser/lightning/database/Bookmark$Entry;", "addBookmarkList", "Lio/reactivex/Completable;", "bookmarkItems", "", "count", "", "deleteAllBookmarks", "deleteBookmark", "deleteFolder", "folderToDelete", "", "editBookmark", "oldBookmark", "newBookmark", "findBookmarkForUrl", "Lio/reactivex/Maybe;", "url", "getAllBookmarksSorted", "getBookmarksFromFolderSorted", "Lacr/browser/lightning/database/Bookmark;", "folder", "getFolderNames", "getFoldersSorted", "Lacr/browser/lightning/database/Bookmark$Folder;", "isBookmark", "renameFolder", "oldName", "newName", "app_lightningLiteDebug"})
public abstract interface BookmarkRepository {
    
    /**
     * Gets the bookmark associated with the URL.
     *
     * @param url the URL to look for.
     * @return an observable that will emit either the bookmark associated with the URL or null.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Maybe<acr.browser.lightning.database.Bookmark.Entry> findBookmarkForUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    /**
     * Determines if a URL is associated with a bookmark.
     *
     * @param url the URL to check.
     * @return an observable that will emit true if the URL is a bookmark, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.lang.Boolean> isBookmark(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    /**
     * Adds a bookmark if one does not already exist with the same URL.
     *
     * @param entry the bookmark to add.
     * @return an observable that emits true if the bookmark was added, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.lang.Boolean> addBookmarkIfNotExists(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Entry entry);
    
    /**
     * Adds a list of bookmarks to the database.
     *
     * @param bookmarkItems the bookmarks to add.
     * @return an observable that emits a complete event when all the bookmarks have been added.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable addBookmarkList(@org.jetbrains.annotations.NotNull()
    java.util.List<acr.browser.lightning.database.Bookmark.Entry> bookmarkItems);
    
    /**
     * Deletes a bookmark from the database. The [Bookmark.Entry.url] is used to delete the
     * bookmark.
     *
     * @param entry the bookmark to delete.
     * @return an observable that emits true when the entry is deleted, false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.lang.Boolean> deleteBookmark(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Entry entry);
    
    /**
     * Moves all bookmarks in the old folder to the new folder.
     *
     * @param oldName the name of the old folder.
     * @param newName the name of the new folder.
     * @return an observable that emits a completion event when the folder is renamed.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable renameFolder(@org.jetbrains.annotations.NotNull()
    java.lang.String oldName, @org.jetbrains.annotations.NotNull()
    java.lang.String newName);
    
    /**
     * Deletes a folder from the database, all bookmarks in that folder will be moved to the root
     * level.
     *
     * @param folderToDelete the folder to delete.
     * @return an observable that emits a completion event when the folder has been deleted.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable deleteFolder(@org.jetbrains.annotations.NotNull()
    java.lang.String folderToDelete);
    
    /**
     * Deletes all bookmarks in the database.
     *
     * @return an observable that emits a completion event when all bookmarks have been deleted.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable deleteAllBookmarks();
    
    /**
     * Changes the bookmark with the original URL with all the data from the new bookmark.
     *
     * @param oldBookmark the old bookmark to replace.
     * @param newBookmark the new bookmark.
     * @return an observable that emits a completion event when the bookmark edit is done.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable editBookmark(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Entry oldBookmark, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Entry newBookmark);
    
    /**
     * Emits a list of all bookmarks, sorted by folder, position, title, and url.
     *
     * @return an observable that emits a list of all bookmarks.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<acr.browser.lightning.database.Bookmark.Entry>> getAllBookmarksSorted();
    
    /**
     * Emits all bookmarks in a certain folder. If the folder chosen is null, then all bookmarks
     * without a specified folder will be returned.
     *
     * @param folder gets the bookmarks from this folder, may be null.
     * @return an observable that emits a list of bookmarks in the given folder.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<acr.browser.lightning.database.Bookmark>> getBookmarksFromFolderSorted(@org.jetbrains.annotations.Nullable()
    java.lang.String folder);
    
    /**
     * Returns all folders as [Bookmark.Folder]. The root folder is omitted.
     *
     * @return an observable that emits a list of folders.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<acr.browser.lightning.database.Bookmark.Folder>> getFoldersSorted();
    
    /**
     * Returns the names of all folders. The root folder is omitted.
     *
     * @return an observable that emits a list of folder names.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<java.lang.String>> getFolderNames();
    
    /**
     * A synchronous call to the model that returns the number of bookmarks. Should be called from a
     * background thread.
     *
     * @return the number of bookmarks in the database.
     */
    @androidx.annotation.WorkerThread()
    public abstract long count();
}