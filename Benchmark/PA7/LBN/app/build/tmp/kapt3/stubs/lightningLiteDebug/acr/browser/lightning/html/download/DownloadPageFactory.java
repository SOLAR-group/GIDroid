package acr.browser.lightning.html.download;

import java.lang.System;

/**
 * The factory for the downloads page.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000eH\u0002J\f\u0010 \u001a\u00020\u000e*\u00020!H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lacr/browser/lightning/html/download/DownloadPageFactory;", "Lacr/browser/lightning/html/HtmlPageFactory;", "application", "Landroid/app/Application;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "manager", "Lacr/browser/lightning/database/downloads/DownloadsRepository;", "listPageReader", "Lacr/browser/lightning/html/ListPageReader;", "themeProvider", "Lacr/browser/lightning/browser/theme/ThemeProvider;", "(Landroid/app/Application;Lacr/browser/lightning/preference/UserPreferences;Lacr/browser/lightning/database/downloads/DownloadsRepository;Lacr/browser/lightning/html/ListPageReader;Lacr/browser/lightning/browser/theme/ThemeProvider;)V", "backgroundColor", "", "getBackgroundColor", "()Ljava/lang/String;", "dividerColor", "getDividerColor", "subtitleColor", "getSubtitleColor", "textColor", "getTextColor", "buildPage", "Lio/reactivex/Single;", "createDownloadsPageFile", "Ljava/io/File;", "createFileTitle", "downloadItem", "Lacr/browser/lightning/database/downloads/DownloadEntry;", "createFileUrl", "fileName", "toColor", "", "Companion", "app_lightningLiteDebug"})
public final class DownloadPageFactory implements acr.browser.lightning.html.HtmlPageFactory {
    private final android.app.Application application = null;
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final acr.browser.lightning.database.downloads.DownloadsRepository manager = null;
    private final acr.browser.lightning.html.ListPageReader listPageReader = null;
    private final acr.browser.lightning.browser.theme.ThemeProvider themeProvider = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FILENAME = "downloads.html";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.html.download.DownloadPageFactory.Companion Companion = null;
    
    private final java.lang.String toColor(int $this$toColor) {
        return null;
    }
    
    private final java.lang.String getBackgroundColor() {
        return null;
    }
    
    private final java.lang.String getDividerColor() {
        return null;
    }
    
    private final java.lang.String getTextColor() {
        return null;
    }
    
    private final java.lang.String getSubtitleColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.String> buildPage() {
        return null;
    }
    
    private final java.io.File createDownloadsPageFile() {
        return null;
    }
    
    private final java.lang.String createFileUrl(java.lang.String fileName) {
        return null;
    }
    
    private final java.lang.String createFileTitle(acr.browser.lightning.database.downloads.DownloadEntry downloadItem) {
        return null;
    }
    
    @javax.inject.Inject()
    public DownloadPageFactory(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.downloads.DownloadsRepository manager, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.html.ListPageReader listPageReader, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.theme.ThemeProvider themeProvider) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/html/download/DownloadPageFactory$Companion;", "", "()V", "FILENAME", "", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}