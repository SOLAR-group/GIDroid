package acr.browser.lightning.browser.di;

import java.lang.System;

/**
 * Binds implementations to interfaces for the browser scope.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\'J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\'\u00a8\u0006\u001a"}, d2 = {"Lacr/browser/lightning/browser/di/Browser2BindsModule;", "", "bindsBrowserModel", "Lacr/browser/lightning/browser/BrowserContract$Model;", "tabsRepository", "Lacr/browser/lightning/browser/tab/TabsRepository;", "bindsBrowserNavigator", "Lacr/browser/lightning/browser/BrowserContract$Navigator;", "browserNavigator", "Lacr/browser/lightning/browser/BrowserNavigator;", "bindsExitCleanup", "Lacr/browser/lightning/browser/cleanup/ExitCleanup;", "delegatingExitCleanup", "Lacr/browser/lightning/browser/cleanup/DelegatingExitCleanup;", "bindsFaviconImageLoader", "Lacr/browser/lightning/browser/image/ImageLoader;", "faviconImageLoader", "Lacr/browser/lightning/browser/image/FaviconImageLoader;", "bindsProxy", "Lacr/browser/lightning/browser/proxy/Proxy;", "proxyAdapter", "Lacr/browser/lightning/browser/proxy/ProxyAdapter;", "bindsThemeProvider", "Lacr/browser/lightning/browser/theme/ThemeProvider;", "legacyThemeProvider", "Lacr/browser/lightning/browser/theme/DefaultThemeProvider;", "app_lightningPlusDebug"})
@dagger.Module()
public abstract interface Browser2BindsModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.browser.BrowserContract.Model bindsBrowserModel(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.TabsRepository tabsRepository);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.browser.image.ImageLoader bindsFaviconImageLoader(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.image.FaviconImageLoader faviconImageLoader);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.browser.BrowserContract.Navigator bindsBrowserNavigator(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserNavigator browserNavigator);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.browser.proxy.Proxy bindsProxy(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.proxy.ProxyAdapter proxyAdapter);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.browser.cleanup.ExitCleanup bindsExitCleanup(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.cleanup.DelegatingExitCleanup delegatingExitCleanup);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.browser.theme.ThemeProvider bindsThemeProvider(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.theme.DefaultThemeProvider legacyThemeProvider);
}