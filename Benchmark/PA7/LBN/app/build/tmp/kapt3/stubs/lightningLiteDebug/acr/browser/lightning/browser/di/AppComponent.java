package acr.browser.lightning.browser.di;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001%J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0010H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0013H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0014H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001bH&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dH&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020 H&J\b\u0010!\u001a\u00020\"H&J\b\u0010#\u001a\u00020$H&\u00a8\u0006&"}, d2 = {"Lacr/browser/lightning/browser/di/AppComponent;", "", "browser2ComponentBuilder", "Lacr/browser/lightning/browser/di/Browser2Component$Builder;", "inject", "", "app", "Lacr/browser/lightning/BrowserApp;", "activity", "Lacr/browser/lightning/ThemableBrowserActivity;", "searchBoxModel", "Lacr/browser/lightning/browser/search/SearchBoxModel;", "builder", "Lacr/browser/lightning/dialog/LightningDialogBuilder;", "listener", "Lacr/browser/lightning/download/LightningDownloadListener;", "Lacr/browser/lightning/reading/activity/ReadingActivity;", "suggestionsAdapter", "Lacr/browser/lightning/search/SuggestionsAdapter;", "Lacr/browser/lightning/settings/activity/SettingsActivity;", "Lacr/browser/lightning/settings/activity/ThemableSettingsActivity;", "adBlockSettingsFragment", "Lacr/browser/lightning/settings/fragment/AdBlockSettingsFragment;", "advancedSettingsFragment", "Lacr/browser/lightning/settings/fragment/AdvancedSettingsFragment;", "fragment", "Lacr/browser/lightning/settings/fragment/BookmarkSettingsFragment;", "Lacr/browser/lightning/settings/fragment/DebugSettingsFragment;", "displaySettingsFragment", "Lacr/browser/lightning/settings/fragment/DisplaySettingsFragment;", "generalSettingsFragment", "Lacr/browser/lightning/settings/fragment/GeneralSettingsFragment;", "Lacr/browser/lightning/settings/fragment/PrivacySettingsFragment;", "provideBloomFilterAdBlocker", "Lacr/browser/lightning/adblock/BloomFilterAdBlocker;", "provideNoOpAdBlocker", "Lacr/browser/lightning/adblock/NoOpAdBlocker;", "Builder", "app_lightningLiteDebug"})
@dagger.Component(modules = {acr.browser.lightning.browser.di.AppModule.class, acr.browser.lightning.browser.di.AppBindsModule.class, acr.browser.lightning.browser.di.Submodules.class})
@javax.inject.Singleton()
public abstract interface AppComponent {
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.settings.fragment.BookmarkSettingsFragment fragment);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.dialog.LightningDialogBuilder builder);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.ThemableBrowserActivity activity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.settings.fragment.AdvancedSettingsFragment advancedSettingsFragment);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.BrowserApp app);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.reading.activity.ReadingActivity activity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.settings.activity.SettingsActivity activity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.settings.activity.ThemableSettingsActivity activity);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.download.LightningDownloadListener listener);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.settings.fragment.PrivacySettingsFragment fragment);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.settings.fragment.DebugSettingsFragment fragment);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.search.SuggestionsAdapter suggestionsAdapter);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.search.SearchBoxModel searchBoxModel);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.settings.fragment.GeneralSettingsFragment generalSettingsFragment);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.settings.fragment.DisplaySettingsFragment displaySettingsFragment);
    
    public abstract void inject(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.settings.fragment.AdBlockSettingsFragment adBlockSettingsFragment);
    
    @org.jetbrains.annotations.NotNull()
    public abstract acr.browser.lightning.adblock.BloomFilterAdBlocker provideBloomFilterAdBlocker();
    
    @org.jetbrains.annotations.NotNull()
    public abstract acr.browser.lightning.adblock.NoOpAdBlocker provideNoOpAdBlocker();
    
    @org.jetbrains.annotations.NotNull()
    public abstract acr.browser.lightning.browser.di.Browser2Component.Builder browser2ComponentBuilder();
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H\'J\b\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007H\'\u00a8\u0006\b"}, d2 = {"Lacr/browser/lightning/browser/di/AppComponent$Builder;", "", "application", "Landroid/app/Application;", "build", "Lacr/browser/lightning/browser/di/AppComponent;", "buildInfo", "Lacr/browser/lightning/device/BuildInfo;", "app_lightningLiteDebug"})
    @dagger.Component.Builder()
    public static abstract interface Builder {
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract acr.browser.lightning.browser.di.AppComponent.Builder application(@org.jetbrains.annotations.NotNull()
        android.app.Application application);
        
        @org.jetbrains.annotations.NotNull()
        @dagger.BindsInstance()
        public abstract acr.browser.lightning.browser.di.AppComponent.Builder buildInfo(@org.jetbrains.annotations.NotNull()
        acr.browser.lightning.device.BuildInfo buildInfo);
        
        @org.jetbrains.annotations.NotNull()
        public abstract acr.browser.lightning.browser.di.AppComponent build();
    }
}