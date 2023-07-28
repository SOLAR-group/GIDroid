package acr.browser.lightning.database.bookmark;

import java.lang.System;

/**
 * The disk backed bookmark database. See [BookmarkRepository] for function documentation.
 *
 * Created by anthonycr on 5/6/17.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001>B\u000f\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0014H\u0016J\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0018\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00122\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0016\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00120%2\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0014\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00160\u000fH\u0016J\u001e\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0\u00160\u000f2\b\u0010)\u001a\u0004\u0018\u00010\rH\u0016J\u0014\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u00160\u000fH\u0016J\u0014\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00160\u000fH\u0016J\u0016\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\u0018\u001a\u00020\rH\u0016J\u0010\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u0007H\u0016J \u00101\u001a\u00020/2\u0006\u00100\u001a\u00020\u00072\u0006\u00102\u001a\u00020 2\u0006\u00103\u001a\u00020 H\u0016J\u0010\u00104\u001a\u0002052\u0006\u0010\u0018\u001a\u00020\rH\u0002J\u0018\u00106\u001a\u00020\u00142\u0006\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020\rH\u0016J\u0018\u00109\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010:\u001a\u00020;H\u0002J\f\u0010<\u001a\u00020;*\u00020\u0012H\u0002J\f\u0010=\u001a\u00020\u0012*\u000205H\u0002R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006?"}, d2 = {"Lacr/browser/lightning/database/bookmark/BookmarkDatabase;", "Landroid/database/sqlite/SQLiteOpenHelper;", "Lacr/browser/lightning/database/bookmark/BookmarkRepository;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "database", "Landroid/database/sqlite/SQLiteDatabase;", "getDatabase", "()Landroid/database/sqlite/SQLiteDatabase;", "database$delegate", "Lkotlin/properties/ReadOnlyProperty;", "defaultBookmarkTitle", "", "addBookmarkIfNotExists", "Lio/reactivex/Single;", "", "entry", "Lacr/browser/lightning/database/Bookmark$Entry;", "addBookmarkList", "Lio/reactivex/Completable;", "bookmarkItems", "", "alternateSlashUrl", "url", "count", "", "deleteAllBookmarks", "deleteBookmark", "deleteFolder", "folderToDelete", "deleteWithOptionalEndSlash", "", "editBookmark", "oldBookmark", "newBookmark", "findBookmarkForUrl", "Lio/reactivex/Maybe;", "getAllBookmarksSorted", "getBookmarksFromFolderSorted", "Lacr/browser/lightning/database/Bookmark;", "folder", "getFolderNames", "getFoldersSorted", "Lacr/browser/lightning/database/Bookmark$Folder;", "isBookmark", "onCreate", "", "db", "onUpgrade", "oldVersion", "newVersion", "queryWithOptionalEndSlash", "Landroid/database/Cursor;", "renameFolder", "oldName", "newName", "updateWithOptionalEndSlash", "contentValues", "Landroid/content/ContentValues;", "bindBookmarkToContentValues", "bindToBookmarkEntry", "Companion", "app_lightningPlusDebug"})
@javax.inject.Singleton()
public final class BookmarkDatabase extends android.database.sqlite.SQLiteOpenHelper implements acr.browser.lightning.database.bookmark.BookmarkRepository {
    private final java.lang.String defaultBookmarkTitle = null;
    private final kotlin.properties.ReadOnlyProperty database$delegate = null;
    private static final int DATABASE_VERSION = 1;
    private static final java.lang.String DATABASE_NAME = "bookmarkManager";
    private static final java.lang.String TABLE_BOOKMARK = "bookmark";
    private static final java.lang.String KEY_ID = "id";
    private static final java.lang.String KEY_URL = "url";
    private static final java.lang.String KEY_TITLE = "title";
    private static final java.lang.String KEY_FOLDER = "folder";
    private static final java.lang.String KEY_POSITION = "position";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.database.bookmark.BookmarkDatabase.Companion Companion = null;
    
    private final android.database.sqlite.SQLiteDatabase getDatabase() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.NotNull()
    android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    
    /**
     * Queries the database for bookmarks with the provided URL. If it
     * cannot find any bookmarks with the given URL, it will try to query
     * for bookmarks with the [.alternateSlashUrl] as its URL.
     *
     * @param url the URL to query for.
     * @return a cursor with bookmarks matching the URL.
     */
    private final android.database.Cursor queryWithOptionalEndSlash(java.lang.String url) {
        return null;
    }
    
    /**
     * Deletes a bookmark from the database with the provided URL. If it
     * cannot find any bookmark with the given URL, it will try to delete
     * a bookmark with the [.alternateSlashUrl] as its URL.
     *
     * @param url the URL to delete.
     * @return the number of deleted rows.
     */
    private final int deleteWithOptionalEndSlash(java.lang.String url) {
        return 0;
    }
    
    /**
     * Updates a bookmark in the database with the provided URL. If it
     * cannot find any bookmark with the given URL, it will try to update
     * a bookmark with the [.alternateSlashUrl] as its URL.
     *
     * @param url           the URL to update.
     * @param contentValues the new values to update to.
     * @return the number of rows updated.
     */
    private final int updateWithOptionalEndSlash(java.lang.String url, android.content.ContentValues contentValues) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Maybe<acr.browser.lightning.database.Bookmark.Entry> findBookmarkForUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.Boolean> isBookmark(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.Boolean> addBookmarkIfNotExists(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Entry entry) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable addBookmarkList(@org.jetbrains.annotations.NotNull()
    java.util.List<acr.browser.lightning.database.Bookmark.Entry> bookmarkItems) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.Boolean> deleteBookmark(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Entry entry) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable renameFolder(@org.jetbrains.annotations.NotNull()
    java.lang.String oldName, @org.jetbrains.annotations.NotNull()
    java.lang.String newName) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable deleteFolder(@org.jetbrains.annotations.NotNull()
    java.lang.String folderToDelete) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable deleteAllBookmarks() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable editBookmark(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Entry oldBookmark, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Entry newBookmark) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<acr.browser.lightning.database.Bookmark.Entry>> getAllBookmarksSorted() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<acr.browser.lightning.database.Bookmark>> getBookmarksFromFolderSorted(@org.jetbrains.annotations.Nullable()
    java.lang.String folder) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<acr.browser.lightning.database.Bookmark.Folder>> getFoldersSorted() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<java.lang.String>> getFolderNames() {
        return null;
    }
    
    @java.lang.Override()
    public long count() {
        return 0L;
    }
    
    /**
     * Binds a [Bookmark.Entry] to [ContentValues].
     *
     * @return a valid values object that can be inserted into the database.
     */
    private final android.content.ContentValues bindBookmarkToContentValues(acr.browser.lightning.database.Bookmark.Entry $this$bindBookmarkToContentValues) {
        return null;
    }
    
    /**
     * Binds a cursor to a [Bookmark.Entry]. This is
     * a non consuming operation on the cursor. Note that
     * this operation is not safe to perform on a cursor
     * unless you know that the cursor is of history items.
     *
     * @return a valid item containing all the pertinent information.
     */
    private final acr.browser.lightning.database.Bookmark.Entry bindToBookmarkEntry(android.database.Cursor $this$bindToBookmarkEntry) {
        return null;
    }
    
    /**
     * URLs can represent the same thing with or without a trailing slash,
     * for instance, google.com/ is the same page as google.com. Since these
     * can be represented as different bookmarks within the bookmark database,
     * it is important to be able to get the alternate version of a URL.
     *
     * @param url the string that might have a trailing slash.
     * @return a string without a trailing slash if the original had one,
     * or a string with a trailing slash if the original did not.
     */
    private final java.lang.String alternateSlashUrl(java.lang.String url) {
        return null;
    }
    
    @javax.inject.Inject()
    public BookmarkDatabase(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null, null, null, 0);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lacr/browser/lightning/database/bookmark/BookmarkDatabase$Companion;", "", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "KEY_FOLDER", "KEY_ID", "KEY_POSITION", "KEY_TITLE", "KEY_URL", "TABLE_BOOKMARK", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}