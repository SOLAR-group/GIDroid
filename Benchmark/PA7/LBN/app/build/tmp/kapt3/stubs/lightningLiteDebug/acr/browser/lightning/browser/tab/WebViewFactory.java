package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * Constructs [WebView] instances configured for the browser based on user's preferences and create
 * the headers we will send with requests.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0001\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fJ\u0006\u0010\u000e\u001a\u00020\u000fJ\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tH\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lacr/browser/lightning/browser/tab/WebViewFactory;", "", "activity", "Landroid/app/Activity;", "logger", "Lacr/browser/lightning/log/Logger;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "incognitoMode", "", "(Landroid/app/Activity;Lacr/browser/lightning/log/Logger;Lacr/browser/lightning/preference/UserPreferences;Z)V", "createRequestHeaders", "", "", "createWebView", "Landroid/webkit/WebView;", "updateForPreferences", "", "isIncognito", "Companion", "app_lightningLiteDebug"})
public final class WebViewFactory {
    private final android.app.Activity activity = null;
    private final acr.browser.lightning.log.Logger logger = null;
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final boolean incognitoMode = false;
    private static final java.lang.String TAG = "WebViewFactory";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HEADER_REQUESTED_WITH = "X-Requested-With";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String HEADER_WAP_PROFILE = "X-Wap-Profile";
    private static final java.lang.String HEADER_DNT = "DNT";
    private static final java.lang.String HEADER_SAVEDATA = "Save-Data";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.browser.tab.WebViewFactory.Companion Companion = null;
    
    /**
     * Create the request headers that notify websites of various privacy and data preferences.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> createRequestHeaders() {
        return null;
    }
    
    /**
     * Construct a [WebView] based on the user's preferences.
     */
    @org.jetbrains.annotations.NotNull()
    public final android.webkit.WebView createWebView() {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"SetJavaScriptEnabled"})
    private final void updateForPreferences(android.webkit.WebView $this$updateForPreferences, acr.browser.lightning.preference.UserPreferences userPreferences, boolean isIncognito) {
    }
    
    @javax.inject.Inject()
    public WebViewFactory(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @acr.browser.lightning.browser.di.IncognitoMode()
    boolean incognitoMode) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/browser/tab/WebViewFactory$Companion;", "", "()V", "HEADER_DNT", "", "HEADER_REQUESTED_WITH", "HEADER_SAVEDATA", "HEADER_WAP_PROFILE", "TAG", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}