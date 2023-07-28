package acr.browser.lightning.bookmark;

import java.lang.System;

/**
 * An importer that supports the Netscape Bookmark File Format.
 *
 * See https://msdn.microsoft.com/en-us/ie/aa753582(v=vs.94)
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0014\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0002J\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0004H\u0002\u00a8\u0006\u0013"}, d2 = {"Lacr/browser/lightning/bookmark/NetscapeBookmarkFormatImporter;", "Lacr/browser/lightning/bookmark/BookmarkImporter;", "()V", "computeFolderName", "", "parentFolder", "currentFolder", "importBookmarks", "", "Lacr/browser/lightning/database/Bookmark$Entry;", "inputStream", "Ljava/io/InputStream;", "isTag", "", "Lorg/jsoup/nodes/Element;", "tagName", "processFolder", "folderName", "Companion", "app_lightningLiteDebug"})
public final class NetscapeBookmarkFormatImporter implements acr.browser.lightning.bookmark.BookmarkImporter {
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ITEM_TAG = "DT";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String LIST_TAG = "DL";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String BOOKMARK_TAG = "A";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FOLDER_TAG = "H3";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HREF = "HREF";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ROOT_FOLDER_NAME = "";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.bookmark.NetscapeBookmarkFormatImporter.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<acr.browser.lightning.database.Bookmark.Entry> importBookmarks(@org.jetbrains.annotations.NotNull()
    java.io.InputStream inputStream) {
        return null;
    }
    
    /**
     * @return The [List] of [Bookmark.Entry] held by [Element] with the provided [folderName].
     */
    private final java.util.List<acr.browser.lightning.database.Bookmark.Entry> processFolder(org.jsoup.nodes.Element $this$processFolder, java.lang.String folderName) {
        return null;
    }
    
    /**
     * @return True if the element's tag name matches the [tagName], case insentitive, false
     * otherwise.
     */
    private final boolean isTag(org.jsoup.nodes.Element $this$isTag, java.lang.String tagName) {
        return false;
    }
    
    /**
     * @return The [currentFolder] if the [parentFolder] is empty, otherwise prepend the
     * [parentFolder] to the [currentFolder] and return that.
     */
    private final java.lang.String computeFolderName(java.lang.String parentFolder, java.lang.String currentFolder) {
        return null;
    }
    
    @javax.inject.Inject()
    public NetscapeBookmarkFormatImporter() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lacr/browser/lightning/bookmark/NetscapeBookmarkFormatImporter$Companion;", "", "()V", "BOOKMARK_TAG", "", "FOLDER_TAG", "HREF", "ITEM_TAG", "LIST_TAG", "ROOT_FOLDER_NAME", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}