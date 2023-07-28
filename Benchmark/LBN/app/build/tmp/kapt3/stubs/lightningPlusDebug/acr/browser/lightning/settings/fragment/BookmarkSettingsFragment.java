package acr.browser.lightning.settings.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020.H\u0002J\b\u00100\u001a\u00020.H\u0002J\u001d\u00101\u001a\b\u0012\u0004\u0012\u000203022\b\u00104\u001a\u0004\u0018\u000103H\u0002\u00a2\u0006\u0002\u00105J\u0012\u00106\u001a\u00020.2\b\u00107\u001a\u0004\u0018\u000108H\u0016J\b\u00109\u001a\u00020.H\u0016J\b\u0010:\u001a\u00020.H\u0016J\b\u0010;\u001a\u00020<H\u0014J\b\u0010=\u001a\u00020.H\u0002J\u0012\u0010>\u001a\u00020.2\b\u00104\u001a\u0004\u0018\u000103H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00108\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u00020\u001f8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001e\u0010$\u001a\u00020\u00108\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0012\"\u0004\b&\u0010\u0014R\u001e\u0010\'\u001a\u00020(8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,\u00a8\u0006A"}, d2 = {"Lacr/browser/lightning/settings/fragment/BookmarkSettingsFragment;", "Lacr/browser/lightning/settings/fragment/AbstractSettingsFragment;", "()V", "application", "Landroid/app/Application;", "getApplication$app_lightningPlusDebug", "()Landroid/app/Application;", "setApplication$app_lightningPlusDebug", "(Landroid/app/Application;)V", "bookmarkRepository", "Lacr/browser/lightning/database/bookmark/BookmarkRepository;", "getBookmarkRepository$app_lightningPlusDebug", "()Lacr/browser/lightning/database/bookmark/BookmarkRepository;", "setBookmarkRepository$app_lightningPlusDebug", "(Lacr/browser/lightning/database/bookmark/BookmarkRepository;)V", "databaseScheduler", "Lio/reactivex/Scheduler;", "getDatabaseScheduler$app_lightningPlusDebug", "()Lio/reactivex/Scheduler;", "setDatabaseScheduler$app_lightningPlusDebug", "(Lio/reactivex/Scheduler;)V", "exportSubscription", "Lio/reactivex/disposables/Disposable;", "importSubscription", "legacyBookmarkImporter", "Lacr/browser/lightning/bookmark/LegacyBookmarkImporter;", "getLegacyBookmarkImporter$app_lightningPlusDebug", "()Lacr/browser/lightning/bookmark/LegacyBookmarkImporter;", "setLegacyBookmarkImporter$app_lightningPlusDebug", "(Lacr/browser/lightning/bookmark/LegacyBookmarkImporter;)V", "logger", "Lacr/browser/lightning/log/Logger;", "getLogger$app_lightningPlusDebug", "()Lacr/browser/lightning/log/Logger;", "setLogger$app_lightningPlusDebug", "(Lacr/browser/lightning/log/Logger;)V", "mainScheduler", "getMainScheduler$app_lightningPlusDebug", "setMainScheduler$app_lightningPlusDebug", "netscapeBookmarkFormatImporter", "Lacr/browser/lightning/bookmark/NetscapeBookmarkFormatImporter;", "getNetscapeBookmarkFormatImporter$app_lightningPlusDebug", "()Lacr/browser/lightning/bookmark/NetscapeBookmarkFormatImporter;", "setNetscapeBookmarkFormatImporter$app_lightningPlusDebug", "(Lacr/browser/lightning/bookmark/NetscapeBookmarkFormatImporter;)V", "deleteAllBookmarks", "", "exportBookmarks", "importBookmarks", "loadFileList", "", "Ljava/io/File;", "path", "(Ljava/io/File;)[Ljava/io/File;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDestroyView", "providePreferencesXmlResource", "", "showDeleteBookmarksDialog", "showImportBookmarkDialog", "Companion", "SortName", "app_lightningPlusDebug"})
public final class BookmarkSettingsFragment extends acr.browser.lightning.settings.fragment.AbstractSettingsFragment {
    @javax.inject.Inject()
    public acr.browser.lightning.database.bookmark.BookmarkRepository bookmarkRepository;
    @javax.inject.Inject()
    public android.app.Application application;
    @javax.inject.Inject()
    public acr.browser.lightning.bookmark.NetscapeBookmarkFormatImporter netscapeBookmarkFormatImporter;
    @javax.inject.Inject()
    public acr.browser.lightning.bookmark.LegacyBookmarkImporter legacyBookmarkImporter;
    @acr.browser.lightning.browser.di.DatabaseScheduler()
    @javax.inject.Inject()
    public io.reactivex.Scheduler databaseScheduler;
    @acr.browser.lightning.browser.di.MainScheduler()
    @javax.inject.Inject()
    public io.reactivex.Scheduler mainScheduler;
    @javax.inject.Inject()
    public acr.browser.lightning.log.Logger logger;
    private io.reactivex.disposables.Disposable importSubscription;
    private io.reactivex.disposables.Disposable exportSubscription;
    private static final java.lang.String TAG = "BookmarkSettingsFrag";
    private static final java.lang.String EXTENSION_HTML = "html";
    private static final java.lang.String SETTINGS_EXPORT = "export_bookmark";
    private static final java.lang.String SETTINGS_IMPORT = "import_bookmark";
    private static final java.lang.String SETTINGS_DELETE_BOOKMARKS = "delete_bookmarks";
    private static final java.lang.String[] REQUIRED_PERMISSIONS = {"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.settings.fragment.BookmarkSettingsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.database.bookmark.BookmarkRepository getBookmarkRepository$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setBookmarkRepository$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.bookmark.BookmarkRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.app.Application getApplication$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setApplication$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    android.app.Application p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.bookmark.NetscapeBookmarkFormatImporter getNetscapeBookmarkFormatImporter$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setNetscapeBookmarkFormatImporter$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.bookmark.NetscapeBookmarkFormatImporter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.bookmark.LegacyBookmarkImporter getLegacyBookmarkImporter$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setLegacyBookmarkImporter$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.bookmark.LegacyBookmarkImporter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Scheduler getDatabaseScheduler$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setDatabaseScheduler$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    io.reactivex.Scheduler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Scheduler getMainScheduler$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setMainScheduler$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    io.reactivex.Scheduler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.log.Logger getLogger$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setLogger$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger p0) {
    }
    
    @java.lang.Override()
    protected int providePreferencesXmlResource() {
        return 0;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final void exportBookmarks() {
    }
    
    private final void importBookmarks() {
    }
    
    private final void deleteAllBookmarks() {
    }
    
    private final void showDeleteBookmarksDialog() {
    }
    
    private final java.io.File[] loadFileList(java.io.File path) {
        return null;
    }
    
    private final void showImportBookmarkDialog(java.io.File path) {
    }
    
    public BookmarkSettingsFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/settings/fragment/BookmarkSettingsFragment$SortName;", "Ljava/util/Comparator;", "Ljava/io/File;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "app_lightningPlusDebug"})
    static final class SortName implements java.util.Comparator<java.io.File> {
        
        @java.lang.Override()
        public int compare(@org.jetbrains.annotations.NotNull()
        java.io.File a, @org.jetbrains.annotations.NotNull()
        java.io.File b) {
            return 0;
        }
        
        public SortName() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lacr/browser/lightning/settings/fragment/BookmarkSettingsFragment$Companion;", "", "()V", "EXTENSION_HTML", "", "REQUIRED_PERMISSIONS", "", "[Ljava/lang/String;", "SETTINGS_DELETE_BOOKMARKS", "SETTINGS_EXPORT", "SETTINGS_IMPORT", "TAG", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}