package acr.browser.lightning.html.homepage;

import java.lang.System;

/**
 * A factory for the home page.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0015H\u0016J\u0006\u0010\u0016\u001a\u00020\u0017J\f\u0010\u0018\u001a\u00020\f*\u00020\u0019H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\u00020\f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lacr/browser/lightning/html/homepage/HomePageFactory;", "Lacr/browser/lightning/html/HtmlPageFactory;", "application", "Landroid/app/Application;", "searchEngineProvider", "Lacr/browser/lightning/search/SearchEngineProvider;", "homePageReader", "Lacr/browser/lightning/html/homepage/HomePageReader;", "themeProvider", "Lacr/browser/lightning/browser/theme/ThemeProvider;", "(Landroid/app/Application;Lacr/browser/lightning/search/SearchEngineProvider;Lacr/browser/lightning/html/homepage/HomePageReader;Lacr/browser/lightning/browser/theme/ThemeProvider;)V", "backgroundColor", "", "getBackgroundColor", "()Ljava/lang/String;", "cardColor", "getCardColor", "textColor", "getTextColor", "title", "buildPage", "Lio/reactivex/Single;", "createHomePage", "Ljava/io/File;", "toColor", "", "Companion", "app_lightningPlusDebug"})
public final class HomePageFactory implements acr.browser.lightning.html.HtmlPageFactory {
    private final java.lang.String title = null;
    private final android.app.Application application = null;
    private final acr.browser.lightning.search.SearchEngineProvider searchEngineProvider = null;
    private final acr.browser.lightning.html.homepage.HomePageReader homePageReader = null;
    private final acr.browser.lightning.browser.theme.ThemeProvider themeProvider = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String FILENAME = "homepage.html";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.html.homepage.HomePageFactory.Companion Companion = null;
    
    private final java.lang.String toColor(int $this$toColor) {
        return null;
    }
    
    private final java.lang.String getBackgroundColor() {
        return null;
    }
    
    private final java.lang.String getCardColor() {
        return null;
    }
    
    private final java.lang.String getTextColor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.lang.String> buildPage() {
        return null;
    }
    
    /**
     * Create the home page file.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.io.File createHomePage() {
        return null;
    }
    
    @javax.inject.Inject()
    public HomePageFactory(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.search.SearchEngineProvider searchEngineProvider, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.html.homepage.HomePageReader homePageReader, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.theme.ThemeProvider themeProvider) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/html/homepage/HomePageFactory$Companion;", "", "()V", "FILENAME", "", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}