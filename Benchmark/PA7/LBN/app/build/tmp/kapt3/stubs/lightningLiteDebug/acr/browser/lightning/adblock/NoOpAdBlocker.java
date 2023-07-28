package acr.browser.lightning.adblock;

import java.lang.System;

/**
 * A no-op ad blocker implementation. Always returns false for [isAd].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/adblock/NoOpAdBlocker;", "Lacr/browser/lightning/adblock/AdBlocker;", "()V", "isAd", "", "url", "", "app_lightningLiteDebug"})
@dagger.Reusable()
public final class NoOpAdBlocker implements acr.browser.lightning.adblock.AdBlocker {
    
    @java.lang.Override()
    public boolean isAd(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return false;
    }
    
    @javax.inject.Inject()
    public NoOpAdBlocker() {
        super();
    }
}