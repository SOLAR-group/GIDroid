package acr.browser.lightning;

import java.lang.System;

/**
 * The default browsing experience.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"Lacr/browser/lightning/DefaultBrowserActivity;", "Lacr/browser/lightning/browser/BrowserActivity;", "()V", "homeIcon", "", "isIncognito", "", "menu", "app_lightningPlusDebug"})
public final class DefaultBrowserActivity extends acr.browser.lightning.browser.BrowserActivity {
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    public boolean isIncognito() {
        return false;
    }
    
    @java.lang.Override()
    public int menu() {
        return 0;
    }
    
    @java.lang.Override()
    public int homeIcon() {
        return 0;
    }
    
    public DefaultBrowserActivity() {
        super();
    }
}