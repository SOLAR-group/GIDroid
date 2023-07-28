package acr.browser.lightning.dialog;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J3\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010H\u0007\u00a2\u0006\u0002\u0010\u0011J3\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010H\u0007\u00a2\u0006\u0002\u0010\u0013J/\u0010\u0014\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001d\u0010\u0015\u001a\u0019\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u0016\u00a2\u0006\u0002\b\u0018JB\u0010\u0019\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u001a\u001a\u00020\r2\b\b\u0001\u0010\u001b\u001a\u00020\r2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u001dH\u0007JL\u0010\u0019\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u001a\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00122\b\b\u0001\u0010\u001b\u001a\u00020\r2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u001dH\u0007J1\u0010\u001f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010\u00a2\u0006\u0002\u0010\u0011JY\u0010 \u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0001\u0010!\u001a\u00020\r2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040&H\u0007\u00a2\u0006\u0002\u0010\'J1\u0010(\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u00122\u0012\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f\"\u00020\u0010\u00a2\u0006\u0002\u0010)\u00a8\u0006*"}, d2 = {"Lacr/browser/lightning/dialog/BrowserDialog;", "", "()V", "setDialogSize", "", "context", "Landroid/content/Context;", "dialog", "Landroid/app/Dialog;", "show", "activity", "Landroid/app/Activity;", "title", "", "items", "", "Lacr/browser/lightning/dialog/DialogItem;", "(Landroid/app/Activity;I[Lacr/browser/lightning/dialog/DialogItem;)V", "", "(Landroid/app/Activity;Ljava/lang/String;[Lacr/browser/lightning/dialog/DialogItem;)V", "showCustomDialog", "block", "Lkotlin/Function2;", "Landroidx/appcompat/app/AlertDialog$Builder;", "Lkotlin/ExtensionFunctionType;", "showEditText", "hint", "action", "textInputListener", "Lkotlin/Function1;", "currentText", "showListChoices", "showPositiveNegativeDialog", "message", "messageArguments", "positiveButton", "negativeButton", "onCancel", "Lkotlin/Function0;", "(Landroid/app/Activity;II[Ljava/lang/Object;Lacr/browser/lightning/dialog/DialogItem;Lacr/browser/lightning/dialog/DialogItem;Lkotlin/jvm/functions/Function0;)V", "showWithIcons", "(Landroid/content/Context;Ljava/lang/String;[Lacr/browser/lightning/dialog/DialogItem;)V", "app_lightningLiteDebug"})
public final class BrowserDialog {
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.dialog.BrowserDialog INSTANCE = null;
    
    public static final void show(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @androidx.annotation.StringRes()
    int title, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.dialog.DialogItem... items) {
    }
    
    public final void showWithIcons(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.dialog.DialogItem... items) {
    }
    
    /**
     * Show a singly selectable list of [DialogItem] with the provided [title]. All items will be
     * shown, and the first [DialogItem] where [DialogItem.isConditionMet] returns `true` will be
     * the selected item when the dialog is shown. The dialog has an OK button which just dismisses
     * the dialog.
     */
    public final void showListChoices(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @androidx.annotation.StringRes()
    int title, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.dialog.DialogItem... items) {
    }
    
    public static final void show(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.Nullable()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.dialog.DialogItem... items) {
    }
    
    public static final void showPositiveNegativeDialog(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @androidx.annotation.StringRes()
    int title, @androidx.annotation.StringRes()
    int message, @org.jetbrains.annotations.Nullable()
    java.lang.Object[] messageArguments, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.dialog.DialogItem positiveButton, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.dialog.DialogItem negativeButton, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onCancel) {
    }
    
    public static final void showEditText(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @androidx.annotation.StringRes()
    int title, @androidx.annotation.StringRes()
    int hint, @androidx.annotation.StringRes()
    int action, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> textInputListener) {
    }
    
    public static final void showEditText(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @androidx.annotation.StringRes()
    int title, @androidx.annotation.StringRes()
    int hint, @org.jetbrains.annotations.Nullable()
    java.lang.String currentText, @androidx.annotation.StringRes()
    int action, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> textInputListener) {
    }
    
    public static final void setDialogSize(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.app.Dialog dialog) {
    }
    
    /**
     * Show the custom dialog with the custom builder arguments applied.
     */
    public final void showCustomDialog(@org.jetbrains.annotations.Nullable()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super androidx.appcompat.app.AlertDialog.Builder, ? super android.app.Activity, kotlin.Unit> block) {
    }
    
    private BrowserDialog() {
        super();
    }
}