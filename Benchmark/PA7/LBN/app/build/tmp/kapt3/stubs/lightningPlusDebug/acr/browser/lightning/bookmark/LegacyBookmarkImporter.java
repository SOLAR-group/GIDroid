package acr.browser.lightning.bookmark;

import java.lang.System;

/**
 * A [BookmarkImporter] that imports bookmark files that were produced by [BookmarkExporter].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lacr/browser/lightning/bookmark/LegacyBookmarkImporter;", "Lacr/browser/lightning/bookmark/BookmarkImporter;", "()V", "importBookmarks", "", "Lacr/browser/lightning/database/Bookmark$Entry;", "inputStream", "Ljava/io/InputStream;", "app_lightningPlusDebug"})
public final class LegacyBookmarkImporter implements acr.browser.lightning.bookmark.BookmarkImporter {
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<acr.browser.lightning.database.Bookmark.Entry> importBookmarks(@org.jetbrains.annotations.NotNull()
    java.io.InputStream inputStream) {
        return null;
    }
    
    @javax.inject.Inject()
    public LegacyBookmarkImporter() {
        super();
    }
}