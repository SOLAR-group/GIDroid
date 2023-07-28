package acr.browser.lightning.browser;

import java.lang.System;

/**
 * The contract for the browser.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\f\bf\u0018\u00002\u00020\u0001:\u000b\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\u00a8\u0006\r"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract;", "", "Action", "BookmarkOptionEvent", "CloseTabEvent", "DownloadOptionEvent", "FolderOptionEvent", "HistoryOptionEvent", "ImageLongPressEvent", "LinkLongPressEvent", "Model", "Navigator", "View", "app_lightningLiteDebug"})
public abstract interface BrowserContract {
    
    /**
     * The view that renders the browser state.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J&\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020 H&J.\u0010!\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\"\u001a\u00020\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\u000eH&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020&H&J\b\u0010\'\u001a\u00020\u0003H&J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020)H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H&J\u0010\u00100\u001a\u00020\u00032\u0006\u0010.\u001a\u00020/H&J\b\u00101\u001a\u00020\u0003H&J\u0010\u00102\u001a\u00020\u00032\u0006\u00103\u001a\u000204H&J\b\u00105\u001a\u00020\u0003H&J\u0018\u00106\u001a\u00020\u00032\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u000208H&\u00a8\u0006:"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract$View;", "", "clearSearchFocus", "", "closeBookmarkDrawer", "closeTabDrawer", "hideCustomView", "openBookmarkDrawer", "openTabDrawer", "renderState", "viewState", "Lacr/browser/lightning/browser/BrowserViewState;", "renderTabs", "tabs", "", "Lacr/browser/lightning/browser/tab/TabViewState;", "showAddBookmarkDialog", "title", "", "url", "folders", "showBookmarkOptionsDialog", "bookmark", "Lacr/browser/lightning/database/Bookmark$Entry;", "showCloseBrowserDialog", "id", "", "showCustomView", "view", "Landroid/view/View;", "showDownloadOptionsDialog", "download", "Lacr/browser/lightning/database/downloads/DownloadEntry;", "showEditBookmarkDialog", "folder", "showEditFolderDialog", "showFileChooser", "intent", "Landroid/content/Intent;", "showFindInPageDialog", "showFolderOptionsDialog", "Lacr/browser/lightning/database/Bookmark$Folder;", "showHistoryOptionsDialog", "historyEntry", "Lacr/browser/lightning/database/HistoryEntry;", "showImageLongPressDialog", "longPress", "Lacr/browser/lightning/browser/view/targetUrl/LongPress;", "showLinkLongPressDialog", "showLocalFileBlockedDialog", "showSslDialog", "sslCertificateInfo", "Lacr/browser/lightning/ssl/SslCertificateInfo;", "showToolbar", "showToolsDialog", "areAdsAllowed", "", "shouldShowAdBlockOption", "app_lightningLiteDebug"})
    public static abstract interface View {
        
        /**
         * Render the [viewState] for the current tab in the browser.
         */
        public abstract void renderState(@org.jetbrains.annotations.NotNull()
        acr.browser.lightning.browser.BrowserViewState viewState);
        
        /**
         * Render the [tabs] in the tabs list.
         */
        public abstract void renderTabs(@org.jetbrains.annotations.NotNull()
        java.util.List<acr.browser.lightning.browser.tab.TabViewState> tabs);
        
        /**
         * Show the dialog to add a bookmark for the current page.
         *
         * @param title The current title of the page.
         * @param url The current URL of the page.
         * @param folders The available folders that the bookmark can be moved to.
         */
        public abstract void showAddBookmarkDialog(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String url, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> folders);
        
        /**
         * Show the options dialog for the provided [bookmark].
         */
        public abstract void showBookmarkOptionsDialog(@org.jetbrains.annotations.NotNull()
        acr.browser.lightning.database.Bookmark.Entry bookmark);
        
        /**
         * Show the dialog to edit a bookmark.
         *
         * @param title The current title of the bookmark.
         * @param url The current URL of the bookmark.
         * @param folder The current folder the bookmark is in.
         * @param folders The available folders that the bookmark can be moved to.
         */
        public abstract void showEditBookmarkDialog(@org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.NotNull()
        java.lang.String url, @org.jetbrains.annotations.NotNull()
        java.lang.String folder, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> folders);
        
        /**
         * Show the options dialog for the provided [folder].
         */
        public abstract void showFolderOptionsDialog(@org.jetbrains.annotations.NotNull()
        acr.browser.lightning.database.Bookmark.Folder folder);
        
        /**
         * Show the edit folder dialog for the folder with the provided [title].
         */
        public abstract void showEditFolderDialog(@org.jetbrains.annotations.NotNull()
        java.lang.String title);
        
        /**
         * Show the options dialog for the provided [download].
         */
        public abstract void showDownloadOptionsDialog(@org.jetbrains.annotations.NotNull()
        acr.browser.lightning.database.downloads.DownloadEntry download);
        
        /**
         * Show the options dialog for the provided [historyEntry].
         */
        public abstract void showHistoryOptionsDialog(@org.jetbrains.annotations.NotNull()
        acr.browser.lightning.database.HistoryEntry historyEntry);
        
        /**
         * Show the dialog that allows the user to search the web page for a query.
         */
        public abstract void showFindInPageDialog();
        
        /**
         * Show the options menu for long pressing a link in the web page.
         */
        public abstract void showLinkLongPressDialog(@org.jetbrains.annotations.NotNull()
        acr.browser.lightning.browser.view.targetUrl.LongPress longPress);
        
        /**
         * Show the options menu for long pressing an image in the web page.
         */
        public abstract void showImageLongPressDialog(@org.jetbrains.annotations.NotNull()
        acr.browser.lightning.browser.view.targetUrl.LongPress longPress);
        
        /**
         * Show the informational dialog about the SSL certificate info.
         */
        public abstract void showSslDialog(@org.jetbrains.annotations.NotNull()
        acr.browser.lightning.ssl.SslCertificateInfo sslCertificateInfo);
        
        /**
         * Show the close browser dialog for the dialog with the provide [id].
         */
        public abstract void showCloseBrowserDialog(int id);
        
        /**
         * Open the bookmark drawer if it is closed.
         */
        public abstract void openBookmarkDrawer();
        
        /**
         * Close the bookmark drawer if it is open.
         */
        public abstract void closeBookmarkDrawer();
        
        /**
         * Open the tab drawer if it is closed.
         */
        public abstract void openTabDrawer();
        
        /**
         * Close the tab drawer if it is open.
         */
        public abstract void closeTabDrawer();
        
        /**
         * Show the toolbar/search box if it has been hidden due to scrolling.
         */
        public abstract void showToolbar();
        
        /**
         * Show the tools dialog that allows the user to toggle ad blocking and user agent for the
         * current page.
         *
         * @param areAdsAllowed True if ads are currently allowed on the page, false otherwise.
         * @param shouldShowAdBlockOption True if ad block toggling is available for the current
         * page.
         */
        public abstract void showToolsDialog(boolean areAdsAllowed, boolean shouldShowAdBlockOption);
        
        /**
         * Show a warning to the user that they are about to open a local file in the browser that
         * could be potentially dangerous.
         */
        public abstract void showLocalFileBlockedDialog();
        
        /**
         * Show the file chooser with the provided [intent].
         */
        public abstract void showFileChooser(@org.jetbrains.annotations.NotNull()
        android.content.Intent intent);
        
        /**
         * Show a custom [view] over everything that will play a video.
         */
        public abstract void showCustomView(@org.jetbrains.annotations.NotNull()
        android.view.View view);
        
        /**
         * Hide the custom view that was previously shown by calling [showCustomView].
         */
        public abstract void hideCustomView();
        
        /**
         * Clear focus from the search view if it has focus.
         */
        public abstract void clearSearchFocus();
    }
    
    /**
     * The model used to manage tabs in the browser.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u000eH&J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0012\u001a\u00020\bH&J\u0014\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0014H&J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H&J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0014\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0018H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0019"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract$Model;", "", "tabsList", "", "Lacr/browser/lightning/browser/tab/TabModel;", "getTabsList", "()Ljava/util/List;", "clean", "", "createTab", "Lio/reactivex/Single;", "tabInitializer", "Lacr/browser/lightning/browser/tab/TabInitializer;", "deleteAllTabs", "Lio/reactivex/Completable;", "deleteTab", "id", "", "freeze", "initializeTabs", "Lio/reactivex/Maybe;", "reopenTab", "selectTab", "tabsListChanges", "Lio/reactivex/Observable;", "app_lightningLiteDebug"})
    public static abstract interface Model {
        
        /**
         * Delete the tab with the provided [id].
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Completable deleteTab(int id);
        
        /**
         * Delete all open tabs.
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Completable deleteAllTabs();
        
        /**
         * Create a tab that will be initialized with the [tabInitializer].
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Single<acr.browser.lightning.browser.tab.TabModel> createTab(@org.jetbrains.annotations.NotNull()
        acr.browser.lightning.browser.tab.TabInitializer tabInitializer);
        
        /**
         * Reopen the most recently closed tab if there is a closed tab to re-open.
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Maybe<acr.browser.lightning.browser.tab.TabModel> reopenTab();
        
        /**
         * Select the tab with the provide [id] as the currently viewed tab.
         */
        @org.jetbrains.annotations.NotNull()
        public abstract acr.browser.lightning.browser.tab.TabModel selectTab(int id);
        
        /**
         * Initialize all tabs that were previously frozen when the browser was last open, and
         * initialize any tabs that should be opened from the initial browser action.
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Maybe<java.util.List<acr.browser.lightning.browser.tab.TabModel>> initializeTabs();
        
        /**
         * Notifies the model that all tabs need to be frozen before the browser shuts down.
         */
        public abstract void freeze();
        
        /**
         * Clean all permanent stored content.
         */
        public abstract void clean();
        
        /**
         * The current open tabs.
         */
        @org.jetbrains.annotations.NotNull()
        public abstract java.util.List<acr.browser.lightning.browser.tab.TabModel> getTabsList();
        
        /**
         * Changes to the current open tabs.
         */
        @org.jetbrains.annotations.NotNull()
        public abstract io.reactivex.Observable<java.util.List<acr.browser.lightning.browser.tab.TabModel>> tabsListChanges();
    }
    
    /**
     * Used by the browser to navigate between screens and perform other navigation events.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH&J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u0003H&J\u001a\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0013"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract$Navigator;", "", "addToHomeScreen", "", "url", "", "title", "favicon", "Landroid/graphics/Bitmap;", "backgroundBrowser", "closeBrowser", "copyPageLink", "download", "pendingDownload", "Lacr/browser/lightning/browser/download/PendingDownload;", "launchIncognito", "openReaderMode", "openSettings", "sharePage", "app_lightningLiteDebug"})
    public static abstract interface Navigator {
        
        /**
         * Open the browser settings screen.
         */
        public abstract void openSettings();
        
        /**
         * Open the reader mode and load the provided [url].
         */
        public abstract void openReaderMode(@org.jetbrains.annotations.NotNull()
        java.lang.String url);
        
        /**
         * Share the web page with the provided [url] and [title].
         */
        public abstract void sharePage(@org.jetbrains.annotations.NotNull()
        java.lang.String url, @org.jetbrains.annotations.Nullable()
        java.lang.String title);
        
        /**
         * Copy the page [url] to the clip board.
         */
        public abstract void copyPageLink(@org.jetbrains.annotations.NotNull()
        java.lang.String url);
        
        /**
         * Close the browser and terminate the session.
         */
        public abstract void closeBrowser();
        
        /**
         * Add a shortcut to the home screen that opens the [url]. Use the provided [title] and
         * [favicon] to create the shortcut.
         */
        public abstract void addToHomeScreen(@org.jetbrains.annotations.NotNull()
        java.lang.String url, @org.jetbrains.annotations.NotNull()
        java.lang.String title, @org.jetbrains.annotations.Nullable()
        android.graphics.Bitmap favicon);
        
        /**
         * Download the file provided by the [pendingDownload].
         */
        public abstract void download(@org.jetbrains.annotations.NotNull()
        acr.browser.lightning.browser.download.PendingDownload pendingDownload);
        
        /**
         * Move the browser to the background without terminating the session.
         */
        public abstract void backgroundBrowser();
        
        /**
         * launch the incognito browser and load the provided [url].
         */
        public abstract void launchIncognito(@org.jetbrains.annotations.Nullable()
        java.lang.String url);
    }
    
    /**
     * The options for the close tab menu dialog.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract$CloseTabEvent;", "", "(Ljava/lang/String;I)V", "CLOSE_CURRENT", "CLOSE_OTHERS", "CLOSE_ALL", "app_lightningLiteDebug"})
    public static enum CloseTabEvent {
        /*public static final*/ CLOSE_CURRENT /* = new CLOSE_CURRENT() */,
        /*public static final*/ CLOSE_OTHERS /* = new CLOSE_OTHERS() */,
        /*public static final*/ CLOSE_ALL /* = new CLOSE_ALL() */;
        
        CloseTabEvent() {
        }
    }
    
    /**
     * The options for the bookmark menu dialog.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract$BookmarkOptionEvent;", "", "(Ljava/lang/String;I)V", "NEW_TAB", "BACKGROUND_TAB", "INCOGNITO_TAB", "SHARE", "COPY_LINK", "REMOVE", "EDIT", "app_lightningLiteDebug"})
    public static enum BookmarkOptionEvent {
        /*public static final*/ NEW_TAB /* = new NEW_TAB() */,
        /*public static final*/ BACKGROUND_TAB /* = new BACKGROUND_TAB() */,
        /*public static final*/ INCOGNITO_TAB /* = new INCOGNITO_TAB() */,
        /*public static final*/ SHARE /* = new SHARE() */,
        /*public static final*/ COPY_LINK /* = new COPY_LINK() */,
        /*public static final*/ REMOVE /* = new REMOVE() */,
        /*public static final*/ EDIT /* = new EDIT() */;
        
        BookmarkOptionEvent() {
        }
    }
    
    /**
     * The options for the history menu dialog.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract$HistoryOptionEvent;", "", "(Ljava/lang/String;I)V", "NEW_TAB", "BACKGROUND_TAB", "INCOGNITO_TAB", "SHARE", "COPY_LINK", "REMOVE", "app_lightningLiteDebug"})
    public static enum HistoryOptionEvent {
        /*public static final*/ NEW_TAB /* = new NEW_TAB() */,
        /*public static final*/ BACKGROUND_TAB /* = new BACKGROUND_TAB() */,
        /*public static final*/ INCOGNITO_TAB /* = new INCOGNITO_TAB() */,
        /*public static final*/ SHARE /* = new SHARE() */,
        /*public static final*/ COPY_LINK /* = new COPY_LINK() */,
        /*public static final*/ REMOVE /* = new REMOVE() */;
        
        HistoryOptionEvent() {
        }
    }
    
    /**
     * The options for the download menu dialog.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract$DownloadOptionEvent;", "", "(Ljava/lang/String;I)V", "DELETE", "DELETE_ALL", "app_lightningLiteDebug"})
    public static enum DownloadOptionEvent {
        /*public static final*/ DELETE /* = new DELETE() */,
        /*public static final*/ DELETE_ALL /* = new DELETE_ALL() */;
        
        DownloadOptionEvent() {
        }
    }
    
    /**
     * The options for the folder menu dialog.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract$FolderOptionEvent;", "", "(Ljava/lang/String;I)V", "RENAME", "REMOVE", "app_lightningLiteDebug"})
    public static enum FolderOptionEvent {
        /*public static final*/ RENAME /* = new RENAME() */,
        /*public static final*/ REMOVE /* = new REMOVE() */;
        
        FolderOptionEvent() {
        }
    }
    
    /**
     * The options for the link long press menu dialog.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract$LinkLongPressEvent;", "", "(Ljava/lang/String;I)V", "NEW_TAB", "BACKGROUND_TAB", "INCOGNITO_TAB", "SHARE", "COPY_LINK", "app_lightningLiteDebug"})
    public static enum LinkLongPressEvent {
        /*public static final*/ NEW_TAB /* = new NEW_TAB() */,
        /*public static final*/ BACKGROUND_TAB /* = new BACKGROUND_TAB() */,
        /*public static final*/ INCOGNITO_TAB /* = new INCOGNITO_TAB() */,
        /*public static final*/ SHARE /* = new SHARE() */,
        /*public static final*/ COPY_LINK /* = new COPY_LINK() */;
        
        LinkLongPressEvent() {
        }
    }
    
    /**
     * The options for the image long press menu dialog.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract$ImageLongPressEvent;", "", "(Ljava/lang/String;I)V", "NEW_TAB", "BACKGROUND_TAB", "INCOGNITO_TAB", "SHARE", "COPY_LINK", "DOWNLOAD", "app_lightningLiteDebug"})
    public static enum ImageLongPressEvent {
        /*public static final*/ NEW_TAB /* = new NEW_TAB() */,
        /*public static final*/ BACKGROUND_TAB /* = new BACKGROUND_TAB() */,
        /*public static final*/ INCOGNITO_TAB /* = new INCOGNITO_TAB() */,
        /*public static final*/ SHARE /* = new SHARE() */,
        /*public static final*/ COPY_LINK /* = new COPY_LINK() */,
        /*public static final*/ DOWNLOAD /* = new DOWNLOAD() */;
        
        ImageLongPressEvent() {
        }
    }
    
    /**
     * Supported actions that can be passed to the browser.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract$Action;", "", "()V", "LoadUrl", "Panic", "Lacr/browser/lightning/browser/BrowserContract$Action$LoadUrl;", "Lacr/browser/lightning/browser/BrowserContract$Action$Panic;", "app_lightningLiteDebug"})
    public static abstract class Action {
        
        private Action() {
            super();
        }
        
        /**
         * The action to load the provided [url].
         */
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract$Action$LoadUrl;", "Lacr/browser/lightning/browser/BrowserContract$Action;", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_lightningLiteDebug"})
        public static final class LoadUrl extends acr.browser.lightning.browser.BrowserContract.Action {
            @org.jetbrains.annotations.NotNull()
            private final java.lang.String url = null;
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getUrl() {
                return null;
            }
            
            public LoadUrl(@org.jetbrains.annotations.NotNull()
            java.lang.String url) {
                super();
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String component1() {
                return null;
            }
            
            /**
             * The action to load the provided [url].
             */
            @org.jetbrains.annotations.NotNull()
            public final acr.browser.lightning.browser.BrowserContract.Action.LoadUrl copy(@org.jetbrains.annotations.NotNull()
            java.lang.String url) {
                return null;
            }
            
            /**
             * The action to load the provided [url].
             */
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            /**
             * The action to load the provided [url].
             */
            @java.lang.Override()
            public int hashCode() {
                return 0;
            }
            
            /**
             * The action to load the provided [url].
             */
            @java.lang.Override()
            public boolean equals(@org.jetbrains.annotations.Nullable()
            java.lang.Object p0) {
                return false;
            }
        }
        
        /**
         * The action to emergency clean the entire browser contents and stored data.
         */
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lacr/browser/lightning/browser/BrowserContract$Action$Panic;", "Lacr/browser/lightning/browser/BrowserContract$Action;", "()V", "app_lightningLiteDebug"})
        public static final class Panic extends acr.browser.lightning.browser.BrowserContract.Action {
            @org.jetbrains.annotations.NotNull()
            public static final acr.browser.lightning.browser.BrowserContract.Action.Panic INSTANCE = null;
            
            private Panic() {
                super();
            }
        }
    }
}