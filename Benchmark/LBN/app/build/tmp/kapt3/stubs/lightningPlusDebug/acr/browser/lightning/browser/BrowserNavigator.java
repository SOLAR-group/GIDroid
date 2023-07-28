package acr.browser.lightning.browser;

import java.lang.System;

/**
 * The navigator implementation.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u001c\u001a\u00020\u000eH\u0016J\u001a\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lacr/browser/lightning/browser/BrowserNavigator;", "Lacr/browser/lightning/browser/BrowserContract$Navigator;", "activity", "Landroid/app/Activity;", "clipboardManager", "Landroid/content/ClipboardManager;", "logger", "Lacr/browser/lightning/log/Logger;", "downloadPermissionsHelper", "Lacr/browser/lightning/browser/download/DownloadPermissionsHelper;", "exitCleanup", "Lacr/browser/lightning/browser/cleanup/ExitCleanup;", "(Landroid/app/Activity;Landroid/content/ClipboardManager;Lacr/browser/lightning/log/Logger;Lacr/browser/lightning/browser/download/DownloadPermissionsHelper;Lacr/browser/lightning/browser/cleanup/ExitCleanup;)V", "addToHomeScreen", "", "url", "", "title", "favicon", "Landroid/graphics/Bitmap;", "backgroundBrowser", "closeBrowser", "copyPageLink", "download", "pendingDownload", "Lacr/browser/lightning/browser/download/PendingDownload;", "launchIncognito", "openReaderMode", "openSettings", "sharePage", "Companion", "app_lightningPlusDebug"})
public final class BrowserNavigator implements acr.browser.lightning.browser.BrowserContract.Navigator {
    private final android.app.Activity activity = null;
    private final android.content.ClipboardManager clipboardManager = null;
    private final acr.browser.lightning.log.Logger logger = null;
    private final acr.browser.lightning.browser.download.DownloadPermissionsHelper downloadPermissionsHelper = null;
    private final acr.browser.lightning.browser.cleanup.ExitCleanup exitCleanup = null;
    private static final java.lang.String TAG = "BrowserNavigator";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.browser.BrowserNavigator.Companion Companion = null;
    
    @java.lang.Override()
    public void openSettings() {
    }
    
    @java.lang.Override()
    public void openReaderMode(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @java.lang.Override()
    public void sharePage(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String title) {
    }
    
    @java.lang.Override()
    public void copyPageLink(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @java.lang.Override()
    public void closeBrowser() {
    }
    
    @java.lang.Override()
    public void addToHomeScreen(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.Nullable()
    android.graphics.Bitmap favicon) {
    }
    
    @java.lang.Override()
    public void download(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.download.PendingDownload pendingDownload) {
    }
    
    @java.lang.Override()
    public void backgroundBrowser() {
    }
    
    @java.lang.Override()
    public void launchIncognito(@org.jetbrains.annotations.Nullable()
    java.lang.String url) {
    }
    
    @javax.inject.Inject()
    public BrowserNavigator(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.content.ClipboardManager clipboardManager, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.download.DownloadPermissionsHelper downloadPermissionsHelper, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.cleanup.ExitCleanup exitCleanup) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/browser/BrowserNavigator$Companion;", "", "()V", "TAG", "", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}