package acr.browser.lightning.browser.cleanup;

import java.lang.System;

/**
 * Exit cleanup that determines which sort of cleanup to do at runtime. It determines which cleanup
 * to perform based on the API version and whether we are in incognito mode or normal mode.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lacr/browser/lightning/browser/cleanup/DelegatingExitCleanup;", "Lacr/browser/lightning/browser/cleanup/ExitCleanup;", "basicIncognitoExitCleanup", "Lacr/browser/lightning/browser/cleanup/BasicIncognitoExitCleanup;", "enhancedIncognitoExitCleanup", "Lacr/browser/lightning/browser/cleanup/EnhancedIncognitoExitCleanup;", "normalExitCleanup", "Lacr/browser/lightning/browser/cleanup/NormalExitCleanup;", "activity", "Landroid/app/Activity;", "(Lacr/browser/lightning/browser/cleanup/BasicIncognitoExitCleanup;Lacr/browser/lightning/browser/cleanup/EnhancedIncognitoExitCleanup;Lacr/browser/lightning/browser/cleanup/NormalExitCleanup;Landroid/app/Activity;)V", "cleanUp", "", "app_lightningLiteDebug"})
public final class DelegatingExitCleanup implements acr.browser.lightning.browser.cleanup.ExitCleanup {
    private final acr.browser.lightning.browser.cleanup.BasicIncognitoExitCleanup basicIncognitoExitCleanup = null;
    private final acr.browser.lightning.browser.cleanup.EnhancedIncognitoExitCleanup enhancedIncognitoExitCleanup = null;
    private final acr.browser.lightning.browser.cleanup.NormalExitCleanup normalExitCleanup = null;
    private final android.app.Activity activity = null;
    
    @java.lang.Override()
    public void cleanUp() {
    }
    
    @javax.inject.Inject()
    public DelegatingExitCleanup(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.cleanup.BasicIncognitoExitCleanup basicIncognitoExitCleanup, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.cleanup.EnhancedIncognitoExitCleanup enhancedIncognitoExitCleanup, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.cleanup.NormalExitCleanup normalExitCleanup, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        super();
    }
}