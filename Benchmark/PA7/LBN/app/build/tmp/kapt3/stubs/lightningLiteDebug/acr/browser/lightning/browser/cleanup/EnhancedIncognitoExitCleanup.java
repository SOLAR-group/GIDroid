package acr.browser.lightning.browser.cleanup;

import java.lang.System;

/**
 * Exit cleanup that should be run when the incognito process is exited on API >= 28. This cleanup
 * clears cookies and all web data, which can be done without affecting
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lacr/browser/lightning/browser/cleanup/EnhancedIncognitoExitCleanup;", "Lacr/browser/lightning/browser/cleanup/ExitCleanup;", "logger", "Lacr/browser/lightning/log/Logger;", "activity", "Landroid/app/Activity;", "(Lacr/browser/lightning/log/Logger;Landroid/app/Activity;)V", "cleanUp", "", "Companion", "app_lightningLiteDebug"})
public final class EnhancedIncognitoExitCleanup implements acr.browser.lightning.browser.cleanup.ExitCleanup {
    private final acr.browser.lightning.log.Logger logger = null;
    private final android.app.Activity activity = null;
    private static final java.lang.String TAG = "EnhancedIncognitoExitCleanup";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.browser.cleanup.EnhancedIncognitoExitCleanup.Companion Companion = null;
    
    @java.lang.Override()
    public void cleanUp() {
    }
    
    @javax.inject.Inject()
    public EnhancedIncognitoExitCleanup(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/browser/cleanup/EnhancedIncognitoExitCleanup$Companion;", "", "()V", "TAG", "", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}