package acr.browser.lightning.html.bookmark;

import java.lang.System;

/**
 * Created by anthonycr on 9/23/18.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 92\u00020\u0001:\u00019B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00110#H\u0016J\u001f\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u0017H\u0002\u00a2\u0006\u0002\u0010)J\u0016\u0010*\u001a\u00020\u00112\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0010\u0010.\u001a\u00020\u00172\b\u0010/\u001a\u0004\u0018\u000100J\u0010\u00101\u001a\u00020-2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020-2\u0006\u0010/\u001a\u000200H\u0002J\f\u00105\u001a\u00020-*\u000206H\u0002J\f\u00107\u001a\u00020\u0011*\u000208H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001b\u001a\u0004\b\u001d\u0010\u0019R\u0014\u0010\u001f\u001a\u00020\u00118BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010\u0013R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lacr/browser/lightning/html/bookmark/BookmarkPageFactory;", "Lacr/browser/lightning/html/HtmlPageFactory;", "application", "Landroid/app/Application;", "bookmarkModel", "Lacr/browser/lightning/database/bookmark/BookmarkRepository;", "faviconModel", "Lacr/browser/lightning/favicon/FaviconModel;", "databaseScheduler", "Lio/reactivex/Scheduler;", "diskScheduler", "bookmarkPageReader", "Lacr/browser/lightning/html/bookmark/BookmarkPageReader;", "themeProvider", "Lacr/browser/lightning/browser/theme/ThemeProvider;", "(Landroid/app/Application;Lacr/browser/lightning/database/bookmark/BookmarkRepository;Lacr/browser/lightning/favicon/FaviconModel;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;Lacr/browser/lightning/html/bookmark/BookmarkPageReader;Lacr/browser/lightning/browser/theme/ThemeProvider;)V", "backgroundColor", "", "getBackgroundColor", "()Ljava/lang/String;", "cardColor", "getCardColor", "defaultIconFile", "Ljava/io/File;", "getDefaultIconFile", "()Ljava/io/File;", "defaultIconFile$delegate", "Lkotlin/Lazy;", "folderIconFile", "getFolderIconFile", "folderIconFile$delegate", "textColor", "getTextColor", "title", "buildPage", "Lio/reactivex/Single;", "cacheIcon", "", "icon", "Landroid/graphics/Bitmap;", "file", "(Landroid/graphics/Bitmap;Ljava/io/File;)Lkotlin/Unit;", "construct", "list", "", "Lacr/browser/lightning/html/bookmark/BookmarkViewModel;", "createBookmarkPage", "folder", "Lacr/browser/lightning/database/Bookmark$Folder;", "createViewModelForBookmark", "entry", "Lacr/browser/lightning/database/Bookmark$Entry;", "createViewModelForFolder", "asViewModel", "Lacr/browser/lightning/database/Bookmark;", "toColor", "", "Companion", "app_lightningPlusDebug"})
public final class BookmarkPageFactory implements acr.browser.lightning.html.HtmlPageFactory {
    private final java.lang.String title = null;
    private final kotlin.Lazy folderIconFile$delegate = null;
    private final kotlin.Lazy defaultIconFile$delegate = null;
    private final android.app.Application application = null;
    private final acr.browser.lightning.database.bookmark.BookmarkRepository bookmarkModel = null;
    private final acr.browser.lightning.favicon.FaviconModel faviconModel = null;
    private final io.reactivex.Scheduler databaseScheduler = null;
    private final io.reactivex.Scheduler diskScheduler = null;
    private final acr.browser.lightning.html.bookmark.BookmarkPageReader bookmarkPageReader = null;
    private final acr.browser.lightning.browser.theme.ThemeProvider themeProvider = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FILENAME = "bookmarks.html";
    private static final java.lang.String FOLDER_ICON = "folder.png";
    private static final java.lang.String DEFAULT_ICON = "default.png";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.html.bookmark.BookmarkPageFactory.Companion Companion = null;
    
    private final java.io.File getFolderIconFile() {
        return null;
    }
    
    private final java.io.File getDefaultIconFile() {
        return null;
    }
    
    private final java.lang.String toColor(int $this$toColor) {
        return null;
    }
    
    private final java.lang.String getBackgroundColor() {
        return null;
    }
    
    private final java.lang.String getCardColor() {
        return null;
    }
    
    private final java.lang.String getTextColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.String> buildPage() {
        return null;
    }
    
    private final kotlin.Unit cacheIcon(android.graphics.Bitmap icon, java.io.File file) {
        return null;
    }
    
    private final java.lang.String construct(java.util.List<acr.browser.lightning.html.bookmark.BookmarkViewModel> list) {
        return null;
    }
    
    private final acr.browser.lightning.html.bookmark.BookmarkViewModel asViewModel(acr.browser.lightning.database.Bookmark $this$asViewModel) {
        return null;
    }
    
    private final acr.browser.lightning.html.bookmark.BookmarkViewModel createViewModelForFolder(acr.browser.lightning.database.Bookmark.Folder folder) {
        return null;
    }
    
    private final acr.browser.lightning.html.bookmark.BookmarkViewModel createViewModelForBookmark(acr.browser.lightning.database.Bookmark.Entry entry) {
        return null;
    }
    
    /**
     * Create the bookmark page file.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.io.File createBookmarkPage(@org.jetbrains.annotations.Nullable()
    acr.browser.lightning.database.Bookmark.Folder folder) {
        return null;
    }
    
    @javax.inject.Inject()
    public BookmarkPageFactory(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.bookmark.BookmarkRepository bookmarkModel, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.favicon.FaviconModel faviconModel, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DatabaseScheduler()
    io.reactivex.Scheduler databaseScheduler, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DiskScheduler()
    io.reactivex.Scheduler diskScheduler, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.html.bookmark.BookmarkPageReader bookmarkPageReader, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.theme.ThemeProvider themeProvider) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/html/bookmark/BookmarkPageFactory$Companion;", "", "()V", "DEFAULT_ICON", "", "FILENAME", "FOLDER_ICON", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}