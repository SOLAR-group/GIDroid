package acr.browser.lightning.browser.view;

import java.lang.System;

/**
 * Handles long presses on a [WebView] and converts them into [LongPress] events.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003\u0010\u0011\u0012B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nJ\f\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lacr/browser/lightning/browser/view/WebViewLongPressHandler;", "", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "configure", "Lio/reactivex/functions/Cancellable;", "webView", "Landroid/webkit/WebView;", "onLongClick", "Lkotlin/Function1;", "Lacr/browser/lightning/browser/view/targetUrl/LongPress;", "", "asLongPressCategory", "Lacr/browser/lightning/browser/view/targetUrl/LongPress$Category;", "", "CustomGestureListener", "GestureTriggeringTouchListener", "MessageHandler", "app_lightningPlusDebug"})
public final class WebViewLongPressHandler {
    private final android.app.Activity activity = null;
    
    /**
     * Configure the provided [webView] for listening to long press events and invoke [onLongClick]
     * whenever a long press is detected.
     */
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.functions.Cancellable configure(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super acr.browser.lightning.browser.view.targetUrl.LongPress, kotlin.Unit> onLongClick) {
        return null;
    }
    
    private final acr.browser.lightning.browser.view.targetUrl.LongPress.Category asLongPressCategory(int $this$asLongPressCategory) {
        return null;
    }
    
    @javax.inject.Inject()
    public WebViewLongPressHandler(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lacr/browser/lightning/browser/view/WebViewLongPressHandler$GestureTriggeringTouchListener;", "Landroid/view/View$OnTouchListener;", "gestureDetector", "Landroid/view/GestureDetector;", "(Landroid/view/GestureDetector;)V", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "app_lightningPlusDebug"})
    static final class GestureTriggeringTouchListener implements android.view.View.OnTouchListener {
        private final android.view.GestureDetector gestureDetector = null;
        
        @android.annotation.SuppressLint(value = {"ClickableViewAccessibility"})
        @java.lang.Override()
        public boolean onTouch(@org.jetbrains.annotations.NotNull()
        android.view.View v, @org.jetbrains.annotations.NotNull()
        android.view.MotionEvent event) {
            return false;
        }
        
        public GestureTriggeringTouchListener(@org.jetbrains.annotations.NotNull()
        android.view.GestureDetector gestureDetector) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016R\u001c\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lacr/browser/lightning/browser/view/WebViewLongPressHandler$MessageHandler;", "Landroid/os/Handler;", "onUrlLongPress", "Lkotlin/Function1;", "", "", "(Lkotlin/jvm/functions/Function1;)V", "handleMessage", "msg", "Landroid/os/Message;", "Companion", "app_lightningPlusDebug"})
    static final class MessageHandler extends android.os.Handler {
        private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onUrlLongPress = null;
        private static final java.lang.String KEY_URL = "url";
        @org.jetbrains.annotations.NotNull()
        public static final acr.browser.lightning.browser.view.WebViewLongPressHandler.MessageHandler.Companion Companion = null;
        
        @java.lang.Override()
        public void handleMessage(@org.jetbrains.annotations.NotNull()
        android.os.Message msg) {
        }
        
        public MessageHandler(@org.jetbrains.annotations.NotNull()
        kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onUrlLongPress) {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/browser/view/WebViewLongPressHandler$MessageHandler$Companion;", "", "()V", "KEY_URL", "", "app_lightningPlusDebug"})
        public static final class Companion {
            
            private Companion() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lacr/browser/lightning/browser/view/WebViewLongPressHandler$CustomGestureListener;", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "messageHandler", "Lacr/browser/lightning/browser/view/WebViewLongPressHandler$MessageHandler;", "webView", "Landroid/webkit/WebView;", "(Lacr/browser/lightning/browser/view/WebViewLongPressHandler$MessageHandler;Landroid/webkit/WebView;)V", "canTriggerLongPress", "", "onDoubleTapEvent", "e", "Landroid/view/MotionEvent;", "onLongPress", "", "onShowPress", "app_lightningPlusDebug"})
    static final class CustomGestureListener extends android.view.GestureDetector.SimpleOnGestureListener {
        
        /**
         * Without this, onLongPress is not called when user is zooming using two fingers, but is
         * when using only one.
         *
         * The required behaviour is to avoid triggering this when the user is zooming, it shouldn't
         * matter how many fingers the user is using.
         */
        private boolean canTriggerLongPress = true;
        private final acr.browser.lightning.browser.view.WebViewLongPressHandler.MessageHandler messageHandler = null;
        private final android.webkit.WebView webView = null;
        
        @java.lang.Override()
        public void onLongPress(@org.jetbrains.annotations.NotNull()
        android.view.MotionEvent e) {
        }
        
        /**
         * Is called when the user is swiping after the doubl tap, which in our case means that they
         * are zooming.
         */
        @java.lang.Override()
        public boolean onDoubleTapEvent(@org.jetbrains.annotations.NotNull()
        android.view.MotionEvent e) {
            return false;
        }
        
        /**
         * Is called when something is starting being pressed, always before onLongPress.
         */
        @java.lang.Override()
        public void onShowPress(@org.jetbrains.annotations.NotNull()
        android.view.MotionEvent e) {
        }
        
        public CustomGestureListener(@org.jetbrains.annotations.NotNull()
        acr.browser.lightning.browser.view.WebViewLongPressHandler.MessageHandler messageHandler, @org.jetbrains.annotations.NotNull()
        android.webkit.WebView webView) {
            super();
        }
    }
}