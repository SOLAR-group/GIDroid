package acr.browser.lightning.extensions;

import java.lang.System;

@kotlin.Suppress(names = {"NOTHING_TO_INLINE"})
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0017\u0010\t\u001a\u00020\n*\u00020\u00022\b\b\u0001\u0010\u000b\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\f\u001a\u00020\n*\u00020\u00022\b\b\u0001\u0010\r\u001a\u00020\nH\u0086\b\u001a\u0017\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0001\u0010\u0010\u001a\u00020\nH\u0086\b\u001a\u0017\u0010\u0011\u001a\u00020\u0012*\u00020\u00022\b\b\u0001\u0010\u0013\u001a\u00020\nH\u0086\b\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00028\u00c6\u0002\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0014"}, d2 = {"inflater", "Landroid/view/LayoutInflater;", "Landroid/content/Context;", "getInflater", "(Landroid/content/Context;)Landroid/view/LayoutInflater;", "preferredLocale", "Ljava/util/Locale;", "getPreferredLocale", "(Landroid/content/Context;)Ljava/util/Locale;", "color", "", "colorRes", "dimen", "dimenRes", "drawable", "Landroid/graphics/drawable/Drawable;", "drawableRes", "toast", "", "stringRes", "app_lightningLiteDebug"})
public final class ContextExtensionsKt {
    
    /**
     * Returns the dimension in pixels.
     *
     * @param dimenRes the dimension resource to fetch.
     */
    public static final int dimen(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$dimen, @androidx.annotation.DimenRes()
    int dimenRes) {
        return 0;
    }
    
    /**
     * Returns the [ColorRes] as a [ColorInt]
     */
    @androidx.annotation.ColorInt()
    public static final int color(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$color, @androidx.annotation.ColorRes()
    int colorRes) {
        return 0;
    }
    
    /**
     * Shows a toast with the provided [StringRes].
     */
    public static final void toast(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$toast, @androidx.annotation.StringRes()
    int stringRes) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final android.view.LayoutInflater getInflater(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$inflater) {
        return null;
    }
    
    /**
     * Gets a drawable from the context.
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.graphics.drawable.Drawable drawable(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$drawable, @androidx.annotation.DrawableRes()
    int drawableRes) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.util.Locale getPreferredLocale(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$preferredLocale) {
        return null;
    }
}