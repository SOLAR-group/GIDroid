package acr.browser.lightning.browser.color;

import java.lang.System;

/**
 * An animator that creates animations between two different colors.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004JF\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000326\u0010\n\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000bJ\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lacr/browser/lightning/browser/color/ColorAnimator;", "", "defaultColor", "", "(I)V", "currentColor", "Ljava/lang/Integer;", "animateTo", "Landroid/view/animation/Animation;", "color", "onChange", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "mainColor", "secondaryColor", "", "mixSearchBarColor", "requestedColor", "app_lightningLiteDebug"})
public final class ColorAnimator {
    private java.lang.Integer currentColor;
    private final int defaultColor = 0;
    
    private final int mixSearchBarColor(int requestedColor, int defaultColor) {
        return 0;
    }
    
    /**
     * Creates an animation that animates from the current color to the new [color].
     */
    @org.jetbrains.annotations.NotNull()
    public final android.view.animation.Animation animateTo(int color, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> onChange) {
        return null;
    }
    
    public ColorAnimator(int defaultColor) {
        super();
    }
}