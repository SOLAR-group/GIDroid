package acr.browser.lightning.dialog;

import java.lang.System;

/**
 * A builder of various dialogs.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002Jy\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2K\u0010\f\u001aG\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\rJ\"\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u0015J\u0081\u0001\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2K\u0010\f\u001aG\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00040\rJ\"\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00040\u0015J\"\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00040\u0015J\"\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00040\u0015JN\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\b26\u0010\f\u001a2\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\"\u0012\u0004\u0012\u00020\u00040!\u00a8\u0006#"}, d2 = {"Lacr/browser/lightning/dialog/LightningDialogBuilder;", "", "()V", "showAddBookmarkDialog", "", "activity", "Landroid/app/Activity;", "currentTitle", "", "currentUrl", "folders", "", "onSave", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "title", "url", "folder", "showBookmarkFolderLongPressedDialog", "onClick", "Lkotlin/Function1;", "Lacr/browser/lightning/browser/BrowserContract$FolderOptionEvent;", "showEditBookmarkDialog", "currentFolder", "showLongPressedDialogForBookmarkUrl", "Lacr/browser/lightning/browser/BrowserContract$BookmarkOptionEvent;", "showLongPressedDialogForDownloadUrl", "Lacr/browser/lightning/browser/BrowserContract$DownloadOptionEvent;", "showLongPressedHistoryLinkDialog", "Lacr/browser/lightning/browser/BrowserContract$HistoryOptionEvent;", "showRenameFolderDialog", "oldTitle", "Lkotlin/Function2;", "newTitle", "app_lightningLiteDebug"})
@dagger.Reusable()
public final class LightningDialogBuilder {
    
    /**
     * Show the appropriated dialog for the long pressed link. It means that we try to understand
     * if the link is relative to a bookmark or is just a folder.
     *
     * @param activity used to show the dialog
     */
    public final void showLongPressedDialogForBookmarkUrl(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super acr.browser.lightning.browser.BrowserContract.BookmarkOptionEvent, kotlin.Unit> onClick) {
    }
    
    /**
     * Show the appropriated dialog for the long pressed link.
     *
     * @param activity used to show the dialog
     */
    public final void showLongPressedDialogForDownloadUrl(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super acr.browser.lightning.browser.BrowserContract.DownloadOptionEvent, kotlin.Unit> onClick) {
    }
    
    /**
     * Show the add bookmark dialog. Shows a dialog with the title and URL pre-populated.
     */
    public final void showAddBookmarkDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String currentTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String currentUrl, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> folders, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.String, ? super java.lang.String, kotlin.Unit> onSave) {
    }
    
    public final void showEditBookmarkDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String currentTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String currentUrl, @org.jetbrains.annotations.NotNull()
    java.lang.String currentFolder, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> folders, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super java.lang.String, ? super java.lang.String, ? super java.lang.String, kotlin.Unit> onSave) {
    }
    
    public final void showBookmarkFolderLongPressedDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super acr.browser.lightning.browser.BrowserContract.FolderOptionEvent, kotlin.Unit> onClick) {
    }
    
    public final void showRenameFolderDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    java.lang.String oldTitle, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.String, ? super java.lang.String, kotlin.Unit> onSave) {
    }
    
    public final void showLongPressedHistoryLinkDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super acr.browser.lightning.browser.BrowserContract.HistoryOptionEvent, kotlin.Unit> onClick) {
    }
    
    @javax.inject.Inject()
    public LightningDialogBuilder() {
        super();
    }
}