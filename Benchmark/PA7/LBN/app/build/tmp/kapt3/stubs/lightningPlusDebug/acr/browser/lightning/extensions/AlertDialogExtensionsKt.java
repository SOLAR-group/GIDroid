package acr.browser.lightning.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u001aK\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0005*\u00020\u00022\u0018\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\t0\b0\u00072\u0006\u0010\n\u001a\u0002H\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u0002H\u0005\u0012\u0004\u0012\u00020\u00040\f\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"resizeAndShow", "Landroid/app/Dialog;", "Landroidx/appcompat/app/AlertDialog$Builder;", "withSingleChoiceItems", "", "T", "items", "", "Lkotlin/Pair;", "", "checkedItem", "onClick", "Lkotlin/Function1;", "(Landroidx/appcompat/app/AlertDialog$Builder;Ljava/util/List;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "app_lightningPlusDebug"})
public final class AlertDialogExtensionsKt {
    
    /**
     * Show single choice items.
     *
     * @param items A list of items and their user readable string description.
     * @param checkedItem The item that will be checked when the dialog is displayed.
     * @param onClick Called when an item is clicked. The item clicked is provided.
     */
    public static final <T extends java.lang.Object>void withSingleChoiceItems(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AlertDialog.Builder $this$withSingleChoiceItems, @org.jetbrains.annotations.NotNull()
    java.util.List<? extends kotlin.Pair<? extends T, java.lang.String>> items, T checkedItem, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> onClick) {
    }
    
    /**
     * Ensures that the dialog is appropriately sized and displays it.
     */
    @org.jetbrains.annotations.NotNull()
    @kotlin.Suppress(names = {"NOTHING_TO_INLINE"})
    public static final android.app.Dialog resizeAndShow(@org.jetbrains.annotations.NotNull()
    androidx.appcompat.app.AlertDialog.Builder $this$resizeAndShow) {
        return null;
    }
}