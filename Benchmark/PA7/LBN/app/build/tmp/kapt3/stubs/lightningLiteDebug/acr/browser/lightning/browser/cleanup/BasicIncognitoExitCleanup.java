package acr.browser.lightning.browser.cleanup;

import java.lang.System;

/**
 * Exit cleanup that should run on API < 28 when the incognito instance is closed. This is
 * significantly less secure than on API > 28 since we can separate WebView data from
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/browser/cleanup/BasicIncognitoExitCleanup;", "Lacr/browser/lightning/browser/cleanup/ExitCleanup;", "()V", "cleanUp", "", "app_lightningLiteDebug"})
public final class BasicIncognitoExitCleanup implements acr.browser.lightning.browser.cleanup.ExitCleanup {
    
    @java.lang.Override()
    public void cleanUp() {
    }
    
    @javax.inject.Inject()
    public BasicIncognitoExitCleanup() {
        super();
    }
}