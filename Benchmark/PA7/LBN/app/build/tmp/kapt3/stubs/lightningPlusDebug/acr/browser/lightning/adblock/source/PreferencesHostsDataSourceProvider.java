package acr.browser.lightning.adblock.source;

import java.lang.System;

/**
 * A [HostsDataSourceProvider] backed by [UserPreferences].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lacr/browser/lightning/adblock/source/PreferencesHostsDataSourceProvider;", "Lacr/browser/lightning/adblock/source/HostsDataSourceProvider;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "assetsHostsDataSource", "Lacr/browser/lightning/adblock/source/AssetsHostsDataSource;", "fileHostsDataSourceFactory", "Lacr/browser/lightning/adblock/source/FileHostsDataSource$Factory;", "urlHostsDataSourceFactory", "Lacr/browser/lightning/adblock/source/UrlHostsDataSource$Factory;", "(Lacr/browser/lightning/preference/UserPreferences;Lacr/browser/lightning/adblock/source/AssetsHostsDataSource;Lacr/browser/lightning/adblock/source/FileHostsDataSource$Factory;Lacr/browser/lightning/adblock/source/UrlHostsDataSource$Factory;)V", "createHostsDataSource", "Lacr/browser/lightning/adblock/source/HostsDataSource;", "app_lightningPlusDebug"})
@dagger.Reusable()
public final class PreferencesHostsDataSourceProvider implements acr.browser.lightning.adblock.source.HostsDataSourceProvider {
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final acr.browser.lightning.adblock.source.AssetsHostsDataSource assetsHostsDataSource = null;
    private final acr.browser.lightning.adblock.source.FileHostsDataSource.Factory fileHostsDataSourceFactory = null;
    private final acr.browser.lightning.adblock.source.UrlHostsDataSource.Factory urlHostsDataSourceFactory = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public acr.browser.lightning.adblock.source.HostsDataSource createHostsDataSource() {
        return null;
    }
    
    @javax.inject.Inject()
    public PreferencesHostsDataSourceProvider(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.source.AssetsHostsDataSource assetsHostsDataSource, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.source.FileHostsDataSource.Factory fileHostsDataSourceFactory, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.source.UrlHostsDataSource.Factory urlHostsDataSourceFactory) {
        super();
    }
}