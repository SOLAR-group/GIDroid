package acr.browser.lightning.browser.cleanup;

import java.lang.System;

/**
 * A command that runs as the browser instance is shutting down to clean up anything that needs to
 * be cleaned up. For instance, if the user has chosen to clear cache on exit or if incognito mode
 * is closing.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lacr/browser/lightning/browser/cleanup/ExitCleanup;", "", "cleanUp", "", "app_lightningPlusDebug"})
public abstract interface ExitCleanup {
    
    /**
     * Clean up the instance of the browser with the provided.
     */
    public abstract void cleanUp();
}