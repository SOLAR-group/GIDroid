package acr.browser.lightning.animation;

import java.lang.System;

/**
 * Animation specific helper code.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0007\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/animation/AnimationUtils;", "", "()V", "createRotationTransitionAnimation", "Landroid/view/animation/Animation;", "imageView", "Landroid/widget/ImageView;", "drawableRes", "", "app_lightningPlusDebug"})
public final class AnimationUtils {
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.animation.AnimationUtils INSTANCE = null;
    
    /**
     * Creates an animation that rotates an [ImageView] around the Y axis by 180 degrees and changes
     * the image resource shown when the view is rotated 90 degrees to the user.
     *
     * @param imageView   the view to rotate.
     * @param drawableRes the drawable to set when the view is rotated by 90 degrees.
     * @return an animation that will change the image shown by the view.
     */
    @org.jetbrains.annotations.NotNull()
    public static final android.view.animation.Animation createRotationTransitionAnimation(@org.jetbrains.annotations.NotNull()
    android.widget.ImageView imageView, @androidx.annotation.DrawableRes()
    int drawableRes) {
        return null;
    }
    
    private AnimationUtils() {
        super();
    }
}