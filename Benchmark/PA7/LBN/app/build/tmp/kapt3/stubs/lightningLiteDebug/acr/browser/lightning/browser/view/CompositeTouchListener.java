package acr.browser.lightning.browser.view;

import java.lang.System;

/**
 * A composite [View.OnTouchListener] that delegates touches to multiple listeners.
 *
 * @param delegates The actual listeners we are delegating to.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u00a2\u0006\u0002\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0017R\u001f\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lacr/browser/lightning/browser/view/CompositeTouchListener;", "Landroid/view/View$OnTouchListener;", "delegates", "", "", "(Ljava/util/Map;)V", "getDelegates", "()Ljava/util/Map;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "app_lightningLiteDebug"})
public final class CompositeTouchListener implements android.view.View.OnTouchListener {
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, android.view.View.OnTouchListener> delegates = null;
    
    @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
    @java.lang.Override()
    public boolean onTouch(@org.jetbrains.annotations.NotNull()
    android.view.View v, @org.jetbrains.annotations.NotNull()
    android.view.MotionEvent event) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, android.view.View.OnTouchListener> getDelegates() {
        return null;
    }
    
    public CompositeTouchListener(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, android.view.View.OnTouchListener> delegates) {
        super();
    }
    
    public CompositeTouchListener() {
        super();
    }
}