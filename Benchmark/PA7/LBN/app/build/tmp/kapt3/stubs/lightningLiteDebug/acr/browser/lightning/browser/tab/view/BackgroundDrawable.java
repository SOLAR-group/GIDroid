package acr.browser.lightning.browser.tab.view;

import java.lang.System;

/**
 * Create a new transition drawable with the specified list of layers. At least
 * 2 layers are required for this drawable to work properly.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lacr/browser/lightning/browser/tab/view/BackgroundDrawable;", "Landroid/graphics/drawable/TransitionDrawable;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "isSelected", "", "reverseTransition", "", "duration", "", "startTransition", "durationMillis", "app_lightningLiteDebug"})
public final class BackgroundDrawable extends android.graphics.drawable.TransitionDrawable {
    private boolean isSelected = false;
    
    @java.lang.Override()
    public void startTransition(int durationMillis) {
    }
    
    @java.lang.Override()
    public void reverseTransition(int duration) {
    }
    
    public BackgroundDrawable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
}