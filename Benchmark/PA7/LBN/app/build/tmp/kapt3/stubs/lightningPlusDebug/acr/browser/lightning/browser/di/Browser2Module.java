package acr.browser.lightning.browser.di;

import java.lang.System;

/**
 * Constructs dependencies for the browser scope.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u001a\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\"\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0007J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u001a\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\"H\u0007J\u001c\u0010#\u001a\u0004\u0018\u00010\u00182\b\b\u0001\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'H\u0007J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u001a\u0010*\u001a\u00020+2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010,\u001a\u00020-H\u0007J\u0010\u0010.\u001a\u00020/2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u00060"}, d2 = {"Lacr/browser/lightning/browser/di/Browser2Module;", "", "()V", "providesAdBlocker", "Lacr/browser/lightning/adblock/AdBlocker;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "bloomFilterAdBlocker", "Ljavax/inject/Provider;", "Lacr/browser/lightning/adblock/BloomFilterAdBlocker;", "noOpAdBlocker", "Lacr/browser/lightning/adblock/NoOpAdBlocker;", "providesBundleStore", "Lacr/browser/lightning/browser/tab/bundle/BundleStore;", "incognitoMode", "", "defaultBundleStore", "Lacr/browser/lightning/browser/tab/bundle/DefaultBundleStore;", "providesCookieAdministrator", "Lacr/browser/lightning/browser/data/CookieAdministrator;", "defaultCookieAdministrator", "Lacr/browser/lightning/browser/data/DefaultCookieAdministrator;", "incognitoCookieAdministrator", "providesDefaultUserAgent", "", "application", "Landroid/app/Application;", "providesFrozenIcon", "Landroid/graphics/Bitmap;", "activity", "Landroid/app/Activity;", "providesHistoryRecord", "Lacr/browser/lightning/browser/history/HistoryRecord;", "defaultHistoryRecord", "Lacr/browser/lightning/browser/history/DefaultHistoryRecord;", "providesInitialUrl", "initialIntent", "Landroid/content/Intent;", "intentExtractor", "Lacr/browser/lightning/browser/search/IntentExtractor;", "providesIntentUtils", "Lacr/browser/lightning/utils/IntentUtils;", "providesTabCountNotifier", "Lacr/browser/lightning/browser/notification/TabCountNotifier;", "incognitoTabCountNotifier", "Lacr/browser/lightning/browser/notification/IncognitoTabCountNotifier;", "providesUiConfiguration", "Lacr/browser/lightning/browser/ui/UiConfiguration;", "app_lightningPlusDebug"})
@dagger.Module()
public final class Browser2Module {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final acr.browser.lightning.adblock.AdBlocker providesAdBlocker(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    javax.inject.Provider<acr.browser.lightning.adblock.BloomFilterAdBlocker> bloomFilterAdBlocker, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.NoOpAdBlocker noOpAdBlocker) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @InitialUrl()
    @dagger.Provides()
    public final java.lang.String providesInitialUrl(@org.jetbrains.annotations.NotNull()
    @InitialIntent()
    android.content.Intent initialIntent, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.search.IntentExtractor intentExtractor) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final acr.browser.lightning.utils.IntentUtils providesIntentUtils(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final acr.browser.lightning.browser.ui.UiConfiguration providesUiConfiguration(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @acr.browser.lightning.browser.tab.DefaultUserAgent()
    public final java.lang.String providesDefaultUserAgent(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final acr.browser.lightning.browser.history.HistoryRecord providesHistoryRecord(@IncognitoMode()
    boolean incognitoMode, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.history.DefaultHistoryRecord defaultHistoryRecord) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final acr.browser.lightning.browser.data.CookieAdministrator providesCookieAdministrator(@IncognitoMode()
    boolean incognitoMode, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.data.DefaultCookieAdministrator defaultCookieAdministrator, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.data.DefaultCookieAdministrator incognitoCookieAdministrator) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final acr.browser.lightning.browser.notification.TabCountNotifier providesTabCountNotifier(@IncognitoMode()
    boolean incognitoMode, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.notification.IncognitoTabCountNotifier incognitoTabCountNotifier) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    public final acr.browser.lightning.browser.tab.bundle.BundleStore providesBundleStore(@IncognitoMode()
    boolean incognitoMode, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.bundle.DefaultBundleStore defaultBundleStore) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Provides()
    @acr.browser.lightning.browser.image.IconFreeze()
    public final android.graphics.Bitmap providesFrozenIcon(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        return null;
    }
    
    public Browser2Module() {
        super();
    }
}