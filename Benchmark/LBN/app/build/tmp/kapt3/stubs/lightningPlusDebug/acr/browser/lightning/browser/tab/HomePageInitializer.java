package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * An initializer that displays the page set as the user's homepage preference.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lacr/browser/lightning/browser/tab/HomePageInitializer;", "Lacr/browser/lightning/browser/tab/TabInitializer;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "startPageInitializer", "Lacr/browser/lightning/browser/tab/StartPageInitializer;", "bookmarkPageInitializer", "Lacr/browser/lightning/browser/tab/BookmarkPageInitializer;", "(Lacr/browser/lightning/preference/UserPreferences;Lacr/browser/lightning/browser/tab/StartPageInitializer;Lacr/browser/lightning/browser/tab/BookmarkPageInitializer;)V", "initialize", "", "webView", "Landroid/webkit/WebView;", "headers", "", "", "app_lightningPlusDebug"})
@dagger.Reusable()
public final class HomePageInitializer implements acr.browser.lightning.browser.tab.TabInitializer {
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final acr.browser.lightning.browser.tab.StartPageInitializer startPageInitializer = null;
    private final acr.browser.lightning.browser.tab.BookmarkPageInitializer bookmarkPageInitializer = null;
    
    @java.lang.Override()
    public void initialize(@org.jetbrains.annotations.NotNull()
    android.webkit.WebView webView, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> headers) {
    }
    
    @javax.inject.Inject()
    public HomePageInitializer(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.StartPageInitializer startPageInitializer, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.BookmarkPageInitializer bookmarkPageInitializer) {
        super();
    }
}