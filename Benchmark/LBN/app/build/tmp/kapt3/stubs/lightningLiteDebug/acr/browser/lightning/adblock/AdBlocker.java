package acr.browser.lightning.adblock;

import java.lang.System;

/**
 * The ad blocking interface.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lacr/browser/lightning/adblock/AdBlocker;", "", "isAd", "", "url", "", "app_lightningLiteDebug"})
public abstract interface AdBlocker {
    
    /**
     * a method that determines if the given URL is an ad or not. It performs a search of the URL's
     * domain on the blocked domain hash set.
     *
     * @param url the URL to check for being an ad.
     * @return true if it is an ad, false if it is not an ad.
     */
    public abstract boolean isAd(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
}