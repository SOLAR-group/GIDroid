package acr.browser.lightning.database;

import java.lang.System;

/**
 * A data type that represents an entity that has been bookmarked by the user or contains a page
 * that has been bookmarked by the user.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\t\nB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u0082\u0001\u0002\u000b\f\u00a8\u0006\r"}, d2 = {"Lacr/browser/lightning/database/Bookmark;", "Lacr/browser/lightning/database/WebPage;", "url", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getUrl", "Entry", "Folder", "Lacr/browser/lightning/database/Bookmark$Entry;", "Lacr/browser/lightning/database/Bookmark$Folder;", "app_lightningPlusDebug"})
public abstract class Bookmark extends acr.browser.lightning.database.WebPage {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String url = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String getTitle() {
        return null;
    }
    
    private Bookmark(java.lang.String url, java.lang.String title) {
    }
    
    /**
     * A data type that has been bookmarked by the user.
     *
     * @param position The position of the bookmark in its folder.
     * @param folder The folder in which the bookmark resides.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\bH\u00c6\u0003J1\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u00d6\u0003J\t\u0010\u001a\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000f\u00a8\u0006\u001c"}, d2 = {"Lacr/browser/lightning/database/Bookmark$Entry;", "Lacr/browser/lightning/database/Bookmark;", "url", "", "title", "position", "", "folder", "Lacr/browser/lightning/database/Bookmark$Folder;", "(Ljava/lang/String;Ljava/lang/String;ILacr/browser/lightning/database/Bookmark$Folder;)V", "getFolder", "()Lacr/browser/lightning/database/Bookmark$Folder;", "getPosition", "()I", "getTitle", "()Ljava/lang/String;", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "app_lightningPlusDebug"})
    public static final class Entry extends acr.browser.lightning.database.Bookmark {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String url = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String title = null;
        private final int position = 0;
        @org.jetbrains.annotations.NotNull()
        private final acr.browser.lightning.database.Bookmark.Folder folder = null;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String getUrl() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String getTitle() {
            return null;
        }
        
        public final int getPosition() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final acr.browser.lightning.database.Bookmark.Folder getFolder() {
            return null;
        }
        
        public Entry(@org.jetbrains.annotations.NotNull()
        java.lang.String url, @org.jetbrains.annotations.NotNull()
        java.lang.String title, int position, @org.jetbrains.annotations.NotNull()
        acr.browser.lightning.database.Bookmark.Folder folder) {
            super(null, null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component2() {
            return null;
        }
        
        public final int component3() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final acr.browser.lightning.database.Bookmark.Folder component4() {
            return null;
        }
        
        /**
         * A data type that has been bookmarked by the user.
         *
         * @param position The position of the bookmark in its folder.
         * @param folder The folder in which the bookmark resides.
         */
        @org.jetbrains.annotations.NotNull()
        public final acr.browser.lightning.database.Bookmark.Entry copy(@org.jetbrains.annotations.NotNull()
        java.lang.String url, @org.jetbrains.annotations.NotNull()
        java.lang.String title, int position, @org.jetbrains.annotations.NotNull()
        acr.browser.lightning.database.Bookmark.Folder folder) {
            return null;
        }
        
        /**
         * A data type that has been bookmarked by the user.
         *
         * @param position The position of the bookmark in its folder.
         * @param folder The folder in which the bookmark resides.
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        /**
         * A data type that has been bookmarked by the user.
         *
         * @param position The position of the bookmark in its folder.
         * @param folder The folder in which the bookmark resides.
         */
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        /**
         * A data type that has been bookmarked by the user.
         *
         * @param position The position of the bookmark in its folder.
         * @param folder The folder in which the bookmark resides.
         */
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
    
    /**
     * A data type that represents a container for a [Bookmark.Entry].
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\t\nB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u0082\u0001\u0002\u000b\f\u00a8\u0006\r"}, d2 = {"Lacr/browser/lightning/database/Bookmark$Folder;", "Lacr/browser/lightning/database/Bookmark;", "url", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getUrl", "Entry", "Root", "Lacr/browser/lightning/database/Bookmark$Folder$Root;", "Lacr/browser/lightning/database/Bookmark$Folder$Entry;", "app_lightningPlusDebug"})
    public static abstract class Folder extends acr.browser.lightning.database.Bookmark {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String url = null;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String title = null;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String getUrl() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String getTitle() {
            return null;
        }
        
        private Folder(java.lang.String url, java.lang.String title) {
            super(null, null);
        }
        
        /**
         * The root folder that contains bookmarks and other folders.
         */
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lacr/browser/lightning/database/Bookmark$Folder$Root;", "Lacr/browser/lightning/database/Bookmark$Folder;", "()V", "app_lightningPlusDebug"})
        public static final class Root extends acr.browser.lightning.database.Bookmark.Folder {
            @org.jetbrains.annotations.NotNull()
            public static final acr.browser.lightning.database.Bookmark.Folder.Root INSTANCE = null;
            
            private Root() {
                super(null, null);
            }
        }
        
        /**
         * A folder that contains bookmarks.
         */
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lacr/browser/lightning/database/Bookmark$Folder$Entry;", "Lacr/browser/lightning/database/Bookmark$Folder;", "url", "", "title", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_lightningPlusDebug"})
        public static final class Entry extends acr.browser.lightning.database.Bookmark.Folder {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String url = null;
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String title = null;
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String getUrl() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String getTitle() {
                return null;
            }
            
            public Entry(@org.jetbrains.annotations.NotNull()
            java.lang.String url, @org.jetbrains.annotations.NotNull()
            java.lang.String title) {
                super(null, null);
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component2() {
                return null;
            }
            
            /**
             * A folder that contains bookmarks.
             */
            @org.jetbrains.annotations.NotNull()
            public final acr.browser.lightning.database.Bookmark.Folder.Entry copy(@org.jetbrains.annotations.NotNull()
            java.lang.String url, @org.jetbrains.annotations.NotNull()
            java.lang.String title) {
                return null;
            }
            
            /**
             * A folder that contains bookmarks.
             */
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            /**
             * A folder that contains bookmarks.
             */
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            /**
             * A folder that contains bookmarks.
             */
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object p0) {
                return false;
            }
        }
    }
}