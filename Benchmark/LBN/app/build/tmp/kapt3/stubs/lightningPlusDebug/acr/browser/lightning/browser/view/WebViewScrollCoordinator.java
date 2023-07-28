package acr.browser.lightning.browser.view;

import java.lang.System;

/**
 * Coordinates scrolling behavior between a [WebView] and a toolbar/search box.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0004\u001b\u001c\u001d\u001eB7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0006\u0010\u001a\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lacr/browser/lightning/browser/view/WebViewScrollCoordinator;", "", "activity", "Landroid/app/Activity;", "browserFrame", "Landroid/widget/FrameLayout;", "toolbarRoot", "Landroid/widget/LinearLayout;", "toolbar", "Landroid/view/View;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "inputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "(Landroid/app/Activity;Landroid/widget/FrameLayout;Landroid/widget/LinearLayout;Landroid/view/View;Lacr/browser/lightning/preference/UserPreferences;Landroid/view/inputmethod/InputMethodManager;)V", "currentToggleListener", "Lacr/browser/lightning/browser/view/WebViewScrollCoordinator$ToggleListener;", "gestureListener", "Lacr/browser/lightning/browser/view/WebViewScrollCoordinator$CustomGestureListener;", "touchListener", "Lacr/browser/lightning/browser/view/WebViewScrollCoordinator$TouchListener;", "configure", "", "webView", "Landroid/webkit/WebView;", "coordinate", "showToolbar", "Companion", "CustomGestureListener", "ToggleListener", "TouchListener", "app_lightningPlusDebug"})
public final class WebViewScrollCoordinator {
    private final acr.browser.lightning.browser.view.WebViewScrollCoordinator.CustomGestureListener gestureListener = null;
    private final acr.browser.lightning.browser.view.WebViewScrollCoordinator.TouchListener touchListener = null;
    private acr.browser.lightning.browser.view.WebViewScrollCoordinator.ToggleListener currentToggleListener;
    private final android.widget.FrameLayout browserFrame = null;
    private final android.widget.LinearLayout toolbarRoot = null;
    private final android.view.View toolbar = null;
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final android.view.inputmethod.InputMethodManager inputMethodManager = null;
    private static final int SCROLL_UP_THRESHOLD = 0;
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.browser.view.WebViewScrollCoordinator.Companion Companion = null;
    
    /**
     * Configure the [webView] to match its scrolling behavior with showing an hiding the toolbar.
     */
    public final void configure(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView) {
    }
    
    /**
     * Show the toolbar if it is hidden via scrolling. Has no effect if the toolbar is already
     * visible.
     */
    public final void showToolbar() {
    }
    
    private final void coordinate(android.view.View toolbar, android.webkit.WebView webView) {
    }
    
    @javax.inject.Inject()
    public WebViewScrollCoordinator(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.widget.FrameLayout browserFrame, @org.jetbrains.annotations.NotNull()
    android.widget.LinearLayout toolbarRoot, @org.jetbrains.annotations.NotNull()
    android.view.View toolbar, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    android.view.inputmethod.InputMethodManager inputMethodManager) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bb\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/browser/view/WebViewScrollCoordinator$ToggleListener;", "", "hideToolbar", "", "showToolbar", "app_lightningPlusDebug"})
    static abstract interface ToggleListener {
        
        public abstract void hideToolbar();
        
        public abstract void showToolbar();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lacr/browser/lightning/browser/view/WebViewScrollCoordinator$TouchListener;", "Landroid/view/View$OnTouchListener;", "gestureDetector", "Landroid/view/GestureDetector;", "(Landroid/view/GestureDetector;)V", "action", "", "location", "", "toggleListener", "Lacr/browser/lightning/browser/view/WebViewScrollCoordinator$ToggleListener;", "getToggleListener", "()Lacr/browser/lightning/browser/view/WebViewScrollCoordinator$ToggleListener;", "setToggleListener", "(Lacr/browser/lightning/browser/view/WebViewScrollCoordinator$ToggleListener;)V", "y", "onTouch", "", "view", "Landroid/view/View;", "arg1", "Landroid/view/MotionEvent;", "app_lightningPlusDebug"})
    static final class TouchListener implements android.view.View.OnTouchListener {
        private float location = 0.0F;
        private float y = 0.0F;
        private int action = 0;
        @org.jetbrains.annotations.Nullable()
        private acr.browser.lightning.browser.view.WebViewScrollCoordinator.ToggleListener toggleListener;
        private final android.view.GestureDetector gestureDetector = null;
        
        @org.jetbrains.annotations.Nullable()
        public final acr.browser.lightning.browser.view.WebViewScrollCoordinator.ToggleListener getToggleListener() {
            return null;
        }
        
        public final void setToggleListener(@org.jetbrains.annotations.Nullable()
        acr.browser.lightning.browser.view.WebViewScrollCoordinator.ToggleListener p0) {
        }
        
        @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
        @java.lang.Override()
        public boolean onTouch(@org.jetbrains.annotations.Nullable()
        android.view.View view, @org.jetbrains.annotations.NotNull()
        android.view.MotionEvent arg1) {
            return false;
        }
        
        public TouchListener(@org.jetbrains.annotations.NotNull()
        android.view.GestureDetector gestureDetector) {
            super();
        }
    }
    
    /**
     * The SimpleOnGestureListener used by the [TouchListener]
     * in order to delegate show/hide events to the action bar when
     * the user flings the page. Also handles long press events so
     * that we can capture them accurately.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J(\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0012"}, d2 = {"Lacr/browser/lightning/browser/view/WebViewScrollCoordinator$CustomGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "maxFling", "", "(F)V", "toggleListener", "Lacr/browser/lightning/browser/view/WebViewScrollCoordinator$ToggleListener;", "getToggleListener", "()Lacr/browser/lightning/browser/view/WebViewScrollCoordinator$ToggleListener;", "setToggleListener", "(Lacr/browser/lightning/browser/view/WebViewScrollCoordinator$ToggleListener;)V", "onFling", "", "e1", "Landroid/view/MotionEvent;", "e2", "velocityX", "velocityY", "app_lightningPlusDebug"})
    static final class CustomGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {
        @org.jetbrains.annotations.Nullable()
        private acr.browser.lightning.browser.view.WebViewScrollCoordinator.ToggleListener toggleListener;
        private final float maxFling = 0.0F;
        
        @org.jetbrains.annotations.Nullable()
        public final acr.browser.lightning.browser.view.WebViewScrollCoordinator.ToggleListener getToggleListener() {
            return null;
        }
        
        public final void setToggleListener(@org.jetbrains.annotations.Nullable()
        acr.browser.lightning.browser.view.WebViewScrollCoordinator.ToggleListener p0) {
        }
        
        @java.lang.Override()
        public boolean onFling(@org.jetbrains.annotations.NotNull()
        android.view.MotionEvent e1, @org.jetbrains.annotations.NotNull()
        android.view.MotionEvent e2, float velocityX, float velocityY) {
            return false;
        }
        
        public CustomGestureListener(float maxFling) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/browser/view/WebViewScrollCoordinator$Companion;", "", "()V", "SCROLL_UP_THRESHOLD", "", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}