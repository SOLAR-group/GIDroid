package acr.browser.lightning.browser;

import java.lang.System;

/**
 * An adapter between [BrowserContract.View] and the [BrowserActivity] that creates partial states
 * to render in the activity.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016J\b\u0010\u000f\u001a\u00020\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0006H\u0016J\u0016\u0010\u0013\u001a\u00020\u000b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J&\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\bH\u0016J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0010\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0016J\u0010\u0010#\u001a\u00020\u000b2\u0006\u0010$\u001a\u00020%H\u0016J.\u0010&\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\'\u001a\u00020\u00172\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00170\bH\u0016J\u0010\u0010(\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020\u000bH\u0016J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010\'\u001a\u00020.H\u0016J\u0010\u0010/\u001a\u00020\u000b2\u0006\u00100\u001a\u000201H\u0016J\u0010\u00102\u001a\u00020\u000b2\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u00020\u000b2\u0006\u00103\u001a\u000204H\u0016J\b\u00106\u001a\u00020\u000bH\u0016J\u0010\u00107\u001a\u00020\u000b2\u0006\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020\u000bH\u0016J\u0018\u0010;\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020=H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006?"}, d2 = {"Lacr/browser/lightning/browser/BrowserStateAdapter;", "Lacr/browser/lightning/browser/BrowserContract$View;", "browserActivity", "Lacr/browser/lightning/browser/BrowserActivity;", "(Lacr/browser/lightning/browser/BrowserActivity;)V", "currentState", "Lacr/browser/lightning/browser/BrowserViewState;", "currentTabs", "", "Lacr/browser/lightning/browser/tab/TabViewState;", "clearSearchFocus", "", "closeBookmarkDrawer", "closeTabDrawer", "hideCustomView", "openBookmarkDrawer", "openTabDrawer", "renderState", "viewState", "renderTabs", "tabs", "showAddBookmarkDialog", "title", "", "url", "folders", "showBookmarkOptionsDialog", "bookmark", "Lacr/browser/lightning/database/Bookmark$Entry;", "showCloseBrowserDialog", "id", "", "showCustomView", "view", "Landroid/view/View;", "showDownloadOptionsDialog", "download", "Lacr/browser/lightning/database/downloads/DownloadEntry;", "showEditBookmarkDialog", "folder", "showEditFolderDialog", "showFileChooser", "intent", "Landroid/content/Intent;", "showFindInPageDialog", "showFolderOptionsDialog", "Lacr/browser/lightning/database/Bookmark$Folder;", "showHistoryOptionsDialog", "historyEntry", "Lacr/browser/lightning/database/HistoryEntry;", "showImageLongPressDialog", "longPress", "Lacr/browser/lightning/browser/view/targetUrl/LongPress;", "showLinkLongPressDialog", "showLocalFileBlockedDialog", "showSslDialog", "sslCertificateInfo", "Lacr/browser/lightning/ssl/SslCertificateInfo;", "showToolbar", "showToolsDialog", "areAdsAllowed", "", "shouldShowAdBlockOption", "app_lightningPlusDebug"})
public final class BrowserStateAdapter implements acr.browser.lightning.browser.BrowserContract.View {
    private acr.browser.lightning.browser.BrowserViewState currentState;
    private java.util.List<acr.browser.lightning.browser.tab.TabViewState> currentTabs;
    private final acr.browser.lightning.browser.BrowserActivity browserActivity = null;
    
    @java.lang.Override()
    public void renderState(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserViewState viewState) {
    }
    
    @java.lang.Override()
    public void renderTabs(@org.jetbrains.annotations.NotNull()
    java.util.List<acr.browser.lightning.browser.tab.TabViewState> tabs) {
    }
    
    @java.lang.Override()
    public void showAddBookmarkDialog(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> folders) {
    }
    
    @java.lang.Override()
    public void showBookmarkOptionsDialog(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Entry bookmark) {
    }
    
    @java.lang.Override()
    public void showEditBookmarkDialog(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String folder, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> folders) {
    }
    
    @java.lang.Override()
    public void showFolderOptionsDialog(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Folder folder) {
    }
    
    @java.lang.Override()
    public void showEditFolderDialog(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    @java.lang.Override()
    public void showDownloadOptionsDialog(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.downloads.DownloadEntry download) {
    }
    
    @java.lang.Override()
    public void showHistoryOptionsDialog(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.HistoryEntry historyEntry) {
    }
    
    @java.lang.Override()
    public void showFindInPageDialog() {
    }
    
    @java.lang.Override()
    public void showLinkLongPressDialog(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.view.targetUrl.LongPress longPress) {
    }
    
    @java.lang.Override()
    public void showImageLongPressDialog(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.view.targetUrl.LongPress longPress) {
    }
    
    @java.lang.Override()
    public void showSslDialog(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.ssl.SslCertificateInfo sslCertificateInfo) {
    }
    
    @java.lang.Override()
    public void showCloseBrowserDialog(int id) {
    }
    
    @java.lang.Override()
    public void openBookmarkDrawer() {
    }
    
    @java.lang.Override()
    public void closeBookmarkDrawer() {
    }
    
    @java.lang.Override()
    public void openTabDrawer() {
    }
    
    @java.lang.Override()
    public void closeTabDrawer() {
    }
    
    @java.lang.Override()
    public void showToolbar() {
    }
    
    @java.lang.Override()
    public void showToolsDialog(boolean areAdsAllowed, boolean shouldShowAdBlockOption) {
    }
    
    @java.lang.Override()
    public void showLocalFileBlockedDialog() {
    }
    
    @java.lang.Override()
    public void showFileChooser(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    @java.lang.Override()
    public void showCustomView(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void hideCustomView() {
    }
    
    @java.lang.Override()
    public void clearSearchFocus() {
    }
    
    public BrowserStateAdapter(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserActivity browserActivity) {
        super();
    }
}