package acr.browser.lightning.browser;

import java.lang.System;

/**
 * A partial copy of [BrowserViewState], where null indicates that the value is unchanged.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b(\b\u0086\b\u0018\u00002\u00020\u0001B\u0093\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0016J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0010\u0010\'\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010(\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010)\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u000b\u0010*\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u0010\u0010-\u001a\u0004\u0018\u00010\tH\u00c6\u0003\u00a2\u0006\u0002\u0010 J\u0010\u0010.\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u0011\u0010/\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\fH\u00c6\u0003J\u0010\u00100\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u0010\u00101\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001cJ\u0011\u00102\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u00c6\u0003J\u00b6\u0001\u00103\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001\u00a2\u0006\u0002\u00104J\u0013\u00105\u001a\u00020\u00072\b\u00106\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00107\u001a\u00020\tH\u00d6\u0001J\t\u00108\u001a\u00020\u0003H\u00d6\u0001R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001aR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u000e\u0010\u001cR\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0013\u0010\u001cR\u0015\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0012\u0010\u001cR\u0015\u0010\r\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\r\u0010\u001cR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0006\u0010\u001cR\u0015\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0014\u0010\u001cR\u0015\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%\u00a8\u00069"}, d2 = {"Lacr/browser/lightning/browser/PartialBrowserViewState;", "", "displayUrl", "", "sslState", "Lacr/browser/lightning/ssl/SslState;", "isRefresh", "", "progress", "", "enableFullMenu", "themeColor", "Lacr/browser/lightning/utils/Option;", "isForwardEnabled", "isBackEnabled", "bookmarks", "", "Lacr/browser/lightning/database/Bookmark;", "isBookmarked", "isBookmarkEnabled", "isRootFolder", "findInPage", "(Ljava/lang/String;Lacr/browser/lightning/ssl/SslState;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Lacr/browser/lightning/utils/Option;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)V", "getBookmarks", "()Ljava/util/List;", "getDisplayUrl", "()Ljava/lang/String;", "getEnableFullMenu", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFindInPage", "getProgress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getSslState", "()Lacr/browser/lightning/ssl/SslState;", "getThemeColor", "()Lacr/browser/lightning/utils/Option;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lacr/browser/lightning/ssl/SslState;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Lacr/browser/lightning/utils/Option;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;)Lacr/browser/lightning/browser/PartialBrowserViewState;", "equals", "other", "hashCode", "toString", "app_lightningPlusDebug"})
public final class PartialBrowserViewState {
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String displayUrl = null;
    @org.jetbrains.annotations.Nullable()
    private final acr.browser.lightning.ssl.SslState sslState = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isRefresh = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer progress = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean enableFullMenu = null;
    @org.jetbrains.annotations.Nullable()
    private final acr.browser.lightning.utils.Option<java.lang.Integer> themeColor = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isForwardEnabled = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isBackEnabled = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<acr.browser.lightning.database.Bookmark> bookmarks = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isBookmarked = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isBookmarkEnabled = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Boolean isRootFolder = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String findInPage = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getDisplayUrl() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final acr.browser.lightning.ssl.SslState getSslState() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isRefresh() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getEnableFullMenu() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final acr.browser.lightning.utils.Option<java.lang.Integer> getThemeColor() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isForwardEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isBackEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<acr.browser.lightning.database.Bookmark> getBookmarks() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isBookmarked() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isBookmarkEnabled() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean isRootFolder() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFindInPage() {
        return null;
    }
    
    public PartialBrowserViewState(@org.jetbrains.annotations.Nullable()
    java.lang.String displayUrl, @org.jetbrains.annotations.Nullable()
    acr.browser.lightning.ssl.SslState sslState, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRefresh, @org.jetbrains.annotations.Nullable()
    java.lang.Integer progress, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean enableFullMenu, @org.jetbrains.annotations.Nullable()
    acr.browser.lightning.utils.Option<java.lang.Integer> themeColor, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isForwardEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isBackEnabled, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends acr.browser.lightning.database.Bookmark> bookmarks, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isBookmarked, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isBookmarkEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRootFolder, @org.jetbrains.annotations.Nullable()
    java.lang.String findInPage) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final acr.browser.lightning.ssl.SslState component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final acr.browser.lightning.utils.Option<java.lang.Integer> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component7() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component8() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<acr.browser.lightning.database.Bookmark> component9() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component10() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component11() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean component12() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component13() {
        return null;
    }
    
    /**
     * A partial copy of [BrowserViewState], where null indicates that the value is unchanged.
     */
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.PartialBrowserViewState copy(@org.jetbrains.annotations.Nullable()
    java.lang.String displayUrl, @org.jetbrains.annotations.Nullable()
    acr.browser.lightning.ssl.SslState sslState, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRefresh, @org.jetbrains.annotations.Nullable()
    java.lang.Integer progress, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean enableFullMenu, @org.jetbrains.annotations.Nullable()
    acr.browser.lightning.utils.Option<java.lang.Integer> themeColor, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isForwardEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isBackEnabled, @org.jetbrains.annotations.Nullable()
    java.util.List<? extends acr.browser.lightning.database.Bookmark> bookmarks, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isBookmarked, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isBookmarkEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isRootFolder, @org.jetbrains.annotations.Nullable()
    java.lang.String findInPage) {
        return null;
    }
    
    /**
     * A partial copy of [BrowserViewState], where null indicates that the value is unchanged.
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    /**
     * A partial copy of [BrowserViewState], where null indicates that the value is unchanged.
     */
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    /**
     * A partial copy of [BrowserViewState], where null indicates that the value is unchanged.
     */
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}