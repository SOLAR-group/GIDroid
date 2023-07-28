package acr.browser.lightning.dialog;

import java.lang.System;

/**
 * An item representing a list item in a list dialog. The item has an [icon], [title], an [onClick]
 * function to be invoked when the item is clicked, and a boolean condition [isConditionMet] which
 * defaults to true and allows the consumer to control the visibility of the item in the list.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\t\u001a\u00020\u000bR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0012R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lacr/browser/lightning/dialog/DialogItem;", "", "icon", "Landroid/graphics/drawable/Drawable;", "colorTint", "", "title", "isConditionMet", "", "onClick", "Lkotlin/Function0;", "", "(Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;IZLkotlin/jvm/functions/Function0;)V", "getColorTint", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIcon", "()Landroid/graphics/drawable/Drawable;", "()Z", "getTitle", "()I", "app_lightningLiteDebug"})
public final class DialogItem {
    @org.jetbrains.annotations.Nullable()
    private final android.graphics.drawable.Drawable icon = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer colorTint = null;
    private final int title = 0;
    private final boolean isConditionMet = false;
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onClick = null;
    
    public final void onClick() {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.graphics.drawable.Drawable getIcon() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getColorTint() {
        return null;
    }
    
    public final int getTitle() {
        return 0;
    }
    
    public final boolean isConditionMet() {
        return false;
    }
    
    public DialogItem(@org.jetbrains.annotations.Nullable()
    android.graphics.drawable.Drawable icon, @org.jetbrains.annotations.Nullable()
    @androidx.annotation.ColorInt()
    java.lang.Integer colorTint, @androidx.annotation.StringRes()
    int title, boolean isConditionMet, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
        super();
    }
}