package acr.browser.lightning.bookmark;

import java.lang.System;

/**
 * An importer that imports [Bookmark.Entry] from an [InputStream]. Supported formats are details of
 * the implementation.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/bookmark/BookmarkImporter;", "", "importBookmarks", "", "Lacr/browser/lightning/database/Bookmark$Entry;", "inputStream", "Ljava/io/InputStream;", "app_lightningLiteDebug"})
public abstract interface BookmarkImporter {
    
    /**
     * Synchronously converts an [InputStream] to a [List] of [Bookmark.Entry].
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<acr.browser.lightning.database.Bookmark.Entry> importBookmarks(@org.jetbrains.annotations.NotNull()
    java.io.InputStream inputStream);
}