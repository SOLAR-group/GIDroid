package acr.browser.lightning.adblock.allowlist;

import java.lang.System;

/**
 * The model that determines if a URL is whitelisted or not.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/adblock/allowlist/AllowListModel;", "", "addUrlToAllowList", "", "url", "", "isUrlAllowedAds", "", "removeUrlFromAllowList", "app_lightningLiteDebug"})
public abstract interface AllowListModel {
    
    /**
     * Returns `true` if the [url] is allowed to display ads, `false` otherwise.
     */
    public abstract boolean isUrlAllowedAds(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    /**
     * Adds the provided [url] to the list of sites that are allowed to display ads.
     */
    public abstract void addUrlToAllowList(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    /**
     * Removes the provided [url] from the whitelist.
     */
    public abstract void removeUrlFromAllowList(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
}