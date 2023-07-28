package acr.browser.lightning.icon;

import java.lang.System;

/**
 * A view that draws a count enclosed by a border. Defaults to drawing zero, draws infinity if the
 * number is greater than 99.
 *
 * Attributes:
 * - [R.styleable.TabCountView_tabIconColor] - The color used to draw the number and border.
 * Defaults to black.
 * - [R.styleable.TabCountView_tabIconTextSize] - The count text size, defaults to 14.
 * - [R.styleable.TabCountView_tabIconBorderRadius] - The radius of the border's corners. Defaults
 * to 0.
 * - [R.styleable.TabCountView_tabIconBorderWidth] - The width of the border. Defaults to 0.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0014J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lacr/browser/lightning/icon/TabCountView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "borderRadius", "", "borderWidth", "clearMode", "Landroid/graphics/PorterDuffXfermode;", "count", "numberFormat", "Ljava/text/NumberFormat;", "kotlin.jvm.PlatformType", "overMode", "paint", "Landroid/graphics/Paint;", "workingRect", "Landroid/graphics/RectF;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "updateCount", "Companion", "app_lightningPlusDebug"})
public final class TabCountView extends android.view.View {
    private final java.text.NumberFormat numberFormat = null;
    private final android.graphics.PorterDuffXfermode clearMode = null;
    private final android.graphics.PorterDuffXfermode overMode = null;
    private final android.graphics.Paint paint = null;
    private float borderRadius = 0.0F;
    private float borderWidth = 0.0F;
    private final android.graphics.RectF workingRect = null;
    private int count = 0;
    private static final int MAX_DISPLAYABLE_NUMBER = 99;
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.icon.TabCountView.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    /**
     * Update the number count displayed by the view.
     */
    public final void updateCount(int count) {
    }
    
    @java.lang.Override()
    protected void onDraw(@org.jetbrains.annotations.NotNull()
    android.graphics.Canvas canvas) {
    }
    
    public TabCountView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    public TabCountView(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public TabCountView(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/icon/TabCountView$Companion;", "", "()V", "MAX_DISPLAYABLE_NUMBER", "", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}