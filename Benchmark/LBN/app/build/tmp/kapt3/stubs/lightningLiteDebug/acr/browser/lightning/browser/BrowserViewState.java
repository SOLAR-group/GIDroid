package acr.browser.lightning.browser;

import java.lang.System;

/**
 * The browser view state.
 *
 * @param displayUrl The current text shown in the search box.
 * @param sslState The current SSL state shown in the search box.
 * @param isRefresh True if the refresh button shows a refresh icon, false if it shows an X.
 * @param progress The current page loading progress out of 100.
 * @param enableFullMenu True if the full options menu should be shown, false if the limited one
 * should be shown for a local web page.
 * @param themeColor The UI theme as determined from the current web page.
 * @param isForwardEnabled True if the go forward button should be enabled, false otherwise.
 * @param isBackEnabled True if the go back button should be enabled, false otherwise.
 * @param bookmarks The current list of bookmarks that is displayed.
 * @param isBookmarked True if the current page is bookmarked, false otherwise.
 * @param isBookmarkEnabled True if the user should be allowed to bookmark the current page, false
 * otherwise.
 * @param isRootFolder True if the current bookmark folder is the root folder, false if it is a
 * child folder.
 * @param findInPage The text that we are searching the page for.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\b\u0086\b\u0018\u00002\u00020\u0001By\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0016J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0007H\u00c6\u0003J\t\u0010&\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0007H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0005H\u00c6\u0003J\t\u0010*\u001a\u00020\u0007H\u00c6\u0003J\t\u0010+\u001a\u00020\tH\u00c6\u0003J\t\u0010,\u001a\u00020\u0007H\u00c6\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u00c6\u0003J\t\u0010.\u001a\u00020\u0007H\u00c6\u0003J\t\u0010/\u001a\u00020\u0007H\u00c6\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u00c6\u0003J\u0097\u0001\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00072\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0003H\u00c6\u0001J\u0013\u00102\u001a\u00020\u00072\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u00020\tH\u00d6\u0001J\t\u00105\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\n\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0015\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0011\u0010\u000e\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001cR\u0011\u0010\r\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u001cR\u0011\u0010\u0014\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u001cR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#\u00a8\u00066"}, d2 = {"Lacr/browser/lightning/browser/BrowserViewState;", "", "displayUrl", "", "sslState", "Lacr/browser/lightning/ssl/SslState;", "isRefresh", "", "progress", "", "enableFullMenu", "themeColor", "Lacr/browser/lightning/utils/Option;", "isForwardEnabled", "isBackEnabled", "bookmarks", "", "Lacr/browser/lightning/database/Bookmark;", "isBookmarked", "isBookmarkEnabled", "isRootFolder", "findInPage", "(Ljava/lang/String;Lacr/browser/lightning/ssl/SslState;ZIZLacr/browser/lightning/utils/Option;ZZLjava/util/List;ZZZLjava/lang/String;)V", "getBookmarks", "()Ljava/util/List;", "getDisplayUrl", "()Ljava/lang/String;", "getEnableFullMenu", "()Z", "getFindInPage", "getProgress", "()I", "getSslState", "()Lacr/browser/lightning/ssl/SslState;", "getThemeColor", "()Lacr/browser/lightning/utils/Option;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_lightningLiteDebug"})
public final class BrowserViewState {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String displayUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final acr.browser.lightning.ssl.SslState sslState = null;
    private final boolean isRefresh = false;
    private final int progress = 0;
    private final boolean enableFullMenu = false;
    @org.jetbrains.annotations.NotNull()
    private final acr.browser.lightning.utils.Option<java.lang.Integer> themeColor = null;
    private final boolean isForwardEnabled = false;
    private final boolean isBackEnabled = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<acr.browser.lightning.database.Bookmark> bookmarks = null;
    private final boolean isBookmarked = false;
    private final boolean isBookmarkEnabled = false;
    private final boolean isRootFolder = false;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String findInPage = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDisplayUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.ssl.SslState getSslState() {
        return null;
    }
    
    public final boolean isRefresh() {
        return false;
    }
    
    public final int getProgress() {
        return 0;
    }
    
    public final boolean getEnableFullMenu() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.utils.Option<java.lang.Integer> getThemeColor() {
        return null;
    }
    
    public final boolean isForwardEnabled() {
        return false;
    }
    
    public final boolean isBackEnabled() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<acr.browser.lightning.database.Bookmark> getBookmarks() {
        return null;
    }
    
    public final boolean isBookmarked() {
        return false;
    }
    
    public final boolean isBookmarkEnabled() {
        return false;
    }
    
    public final boolean isRootFolder() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFindInPage() {
        return null;
    }
    
    public BrowserViewState(@org.jetbrains.annotations.NotNull()
    java.lang.String displayUrl, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.ssl.SslState sslState, boolean isRefresh, int progress, boolean enableFullMenu, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.utils.Option<java.lang.Integer> themeColor, boolean isForwardEnabled, boolean isBackEnabled, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends acr.browser.lightning.database.Bookmark> bookmarks, boolean isBookmarked, boolean isBookmarkEnabled, boolean isRootFolder, @org.jetbrains.annotations.NotNull()
    java.lang.String findInPage) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.ssl.SslState component2() {
        return null;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.utils.Option<java.lang.Integer> component6() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<acr.browser.lightning.database.Bookmark> component9() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final boolean component12() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component13() {
        return null;
    }
    
    /**
     * The browser view state.
     *
     * @param displayUrl The current text shown in the search box.
     * @param sslState The current SSL state shown in the search box.
     * @param isRefresh True if the refresh button shows a refresh icon, false if it shows an X.
     * @param progress The current page loading progress out of 100.
     * @param enableFullMenu True if the full options menu should be shown, false if the limited one
     * should be shown for a local web page.
     * @param themeColor The UI theme as determined from the current web page.
     * @param isForwardEnabled True if the go forward button should be enabled, false otherwise.
     * @param isBackEnabled True if the go back button should be enabled, false otherwise.
     * @param bookmarks The current list of bookmarks that is displayed.
     * @param isBookmarked True if the current page is bookmarked, false otherwise.
     * @param isBookmarkEnabled True if the user should be allowed to bookmark the current page, false
     * otherwise.
     * @param isRootFolder True if the current bookmark folder is the root folder, false if it is a
     * child folder.
     * @param findInPage The text that we are searching the page for.
     */
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.BrowserViewState copy(@org.jetbrains.annotations.NotNull()
    java.lang.String displayUrl, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.ssl.SslState sslState, boolean isRefresh, int progress, boolean enableFullMenu, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.utils.Option<java.lang.Integer> themeColor, boolean isForwardEnabled, boolean isBackEnabled, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends acr.browser.lightning.database.Bookmark> bookmarks, boolean isBookmarked, boolean isBookmarkEnabled, boolean isRootFolder, @org.jetbrains.annotations.NotNull()
    java.lang.String findInPage) {
        return null;
    }
    
    /**
     * The browser view state.
     *
     * @param displayUrl The current text shown in the search box.
     * @param sslState The current SSL state shown in the search box.
     * @param isRefresh True if the refresh button shows a refresh icon, false if it shows an X.
     * @param progress The current page loading progress out of 100.
     * @param enableFullMenu True if the full options menu should be shown, false if the limited one
     * should be shown for a local web page.
     * @param themeColor The UI theme as determined from the current web page.
     * @param isForwardEnabled True if the go forward button should be enabled, false otherwise.
     * @param isBackEnabled True if the go back button should be enabled, false otherwise.
     * @param bookmarks The current list of bookmarks that is displayed.
     * @param isBookmarked True if the current page is bookmarked, false otherwise.
     * @param isBookmarkEnabled True if the user should be allowed to bookmark the current page, false
     * otherwise.
     * @param isRootFolder True if the current bookmark folder is the root folder, false if it is a
     * child folder.
     * @param findInPage The text that we are searching the page for.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * The browser view state.
     *
     * @param displayUrl The current text shown in the search box.
     * @param sslState The current SSL state shown in the search box.
     * @param isRefresh True if the refresh button shows a refresh icon, false if it shows an X.
     * @param progress The current page loading progress out of 100.
     * @param enableFullMenu True if the full options menu should be shown, false if the limited one
     * should be shown for a local web page.
     * @param themeColor The UI theme as determined from the current web page.
     * @param isForwardEnabled True if the go forward button should be enabled, false otherwise.
     * @param isBackEnabled True if the go back button should be enabled, false otherwise.
     * @param bookmarks The current list of bookmarks that is displayed.
     * @param isBookmarked True if the current page is bookmarked, false otherwise.
     * @param isBookmarkEnabled True if the user should be allowed to bookmark the current page, false
     * otherwise.
     * @param isRootFolder True if the current bookmark folder is the root folder, false if it is a
     * child folder.
     * @param findInPage The text that we are searching the page for.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * The browser view state.
     *
     * @param displayUrl The current text shown in the search box.
     * @param sslState The current SSL state shown in the search box.
     * @param isRefresh True if the refresh button shows a refresh icon, false if it shows an X.
     * @param progress The current page loading progress out of 100.
     * @param enableFullMenu True if the full options menu should be shown, false if the limited one
     * should be shown for a local web page.
     * @param themeColor The UI theme as determined from the current web page.
     * @param isForwardEnabled True if the go forward button should be enabled, false otherwise.
     * @param isBackEnabled True if the go back button should be enabled, false otherwise.
     * @param bookmarks The current list of bookmarks that is displayed.
     * @param isBookmarked True if the current page is bookmarked, false otherwise.
     * @param isBookmarkEnabled True if the user should be allowed to bookmark the current page, false
     * otherwise.
     * @param isRootFolder True if the current bookmark folder is the root folder, false if it is a
     * child folder.
     * @param findInPage The text that we are searching the page for.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}