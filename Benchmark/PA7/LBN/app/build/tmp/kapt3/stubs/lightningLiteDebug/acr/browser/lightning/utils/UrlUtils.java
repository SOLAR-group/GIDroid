package acr.browser.lightning.utils;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\u001a\u001e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004\u001a\f\u0010\u000b\u001a\u00020\t*\u0004\u0018\u00010\u0004\u001a\f\u0010\f\u001a\u00020\t*\u0004\u0018\u00010\u0004\u001a\f\u0010\r\u001a\u00020\t*\u0004\u0018\u00010\u0004\u001a\f\u0010\u000e\u001a\u00020\t*\u0004\u0018\u00010\u0004\u001a\f\u0010\u000f\u001a\u00020\t*\u0004\u0018\u00010\u0004\u001a\f\u0010\u0010\u001a\u00020\t*\u0004\u0018\u00010\u0004\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"ACCEPTED_URI_SCHEMA", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "QUERY_PLACE_HOLDER", "", "URL_ENCODED_SPACE", "smartUrlFilter", "url", "canBeSearch", "", "searchUrl", "isBookmarkUrl", "isDownloadsUrl", "isFileUrl", "isHistoryUrl", "isSpecialUrl", "isStartPageUrl", "app_lightningLiteDebug"})
public final class UrlUtils {
    private static final java.util.regex.Pattern ACCEPTED_URI_SCHEMA = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String QUERY_PLACE_HOLDER = "%s";
    private static final java.lang.String URL_ENCODED_SPACE = "%20";
    
    /**
     * Attempts to determine whether user input is a URL or search terms.  Anything with a space is
     * passed to search if [canBeSearch] is true.
     *
     * Converts to lowercase any mistakenly upper-cased scheme (i.e., "Http://" converts to
     * "http://")
     *
     * @param canBeSearch if true, will return a search url if it isn't a valid  URL. If false,
     * invalid URLs will return null.
     * @return original or modified URL.
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String smartUrlFilter(@org.jetbrains.annotations.NotNull()
    java.lang.String url, boolean canBeSearch, @org.jetbrains.annotations.NotNull()
    java.lang.String searchUrl) {
        return null;
    }
    
    /**
     * True if the URL is a file URL, false otherwise.
     */
    public static final boolean isFileUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String $this$isFileUrl) {
        return false;
    }
    
    /**
     * Returns whether the given url is the bookmarks/history page or a normal website
     */
    public static final boolean isSpecialUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String $this$isSpecialUrl) {
        return false;
    }
    
    /**
     * Determines if the url is a url for the bookmark page.
     *
     * @return true if the url is a bookmark url, false otherwise.
     */
    public static final boolean isBookmarkUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String $this$isBookmarkUrl) {
        return false;
    }
    
    /**
     * Determines if the url is a url for the bookmark page.
     *
     * @return true if the url is a bookmark url, false otherwise.
     */
    public static final boolean isDownloadsUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String $this$isDownloadsUrl) {
        return false;
    }
    
    /**
     * Determines if the url is a url for the history page.
     *
     * @return true if the url is a history url, false otherwise.
     */
    public static final boolean isHistoryUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String $this$isHistoryUrl) {
        return false;
    }
    
    /**
     * Determines if the url is a url for the start page.
     *
     * @return true if the url is a start page url, false otherwise.
     */
    public static final boolean isStartPageUrl(@org.jetbrains.annotations.Nullable()
    java.lang.String $this$isStartPageUrl) {
        return false;
    }
}