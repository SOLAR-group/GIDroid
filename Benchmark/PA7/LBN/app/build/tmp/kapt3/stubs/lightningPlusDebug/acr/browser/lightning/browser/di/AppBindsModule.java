package acr.browser.lightning.browser.di;

import java.lang.System;

/**
 * Dependency injection module used to bind implementations to interfaces.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\'J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\'J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\'J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\'J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\'\u00a8\u0006&"}, d2 = {"Lacr/browser/lightning/browser/di/AppBindsModule;", "", "bindsAdBlockAllowListModel", "Lacr/browser/lightning/database/allowlist/AdBlockAllowListRepository;", "adBlockAllowListDatabase", "Lacr/browser/lightning/database/allowlist/AdBlockAllowListDatabase;", "bindsAllowListModel", "Lacr/browser/lightning/adblock/allowlist/AllowListModel;", "sessionAllowListModel", "Lacr/browser/lightning/adblock/allowlist/SessionAllowListModel;", "bindsBookmarkModel", "Lacr/browser/lightning/database/bookmark/BookmarkRepository;", "bookmarkDatabase", "Lacr/browser/lightning/database/bookmark/BookmarkDatabase;", "bindsDownloadsModel", "Lacr/browser/lightning/database/downloads/DownloadsRepository;", "downloadsDatabase", "Lacr/browser/lightning/database/downloads/DownloadsDatabase;", "bindsHistoryModel", "Lacr/browser/lightning/database/history/HistoryRepository;", "historyDatabase", "Lacr/browser/lightning/database/history/HistoryDatabase;", "bindsHostsDataSource", "Lacr/browser/lightning/adblock/source/HostsDataSource;", "assetsHostsDataSource", "Lacr/browser/lightning/adblock/source/AssetsHostsDataSource;", "bindsHostsDataSourceProvider", "Lacr/browser/lightning/adblock/source/HostsDataSourceProvider;", "preferencesHostsDataSourceProvider", "Lacr/browser/lightning/adblock/source/PreferencesHostsDataSourceProvider;", "bindsHostsRepository", "Lacr/browser/lightning/database/adblock/HostsRepository;", "hostsDatabase", "Lacr/browser/lightning/database/adblock/HostsDatabase;", "bindsSslWarningPreferences", "Lacr/browser/lightning/ssl/SslWarningPreferences;", "sessionSslWarningPreferences", "Lacr/browser/lightning/ssl/SessionSslWarningPreferences;", "app_lightningPlusDebug"})
@dagger.Module()
public abstract interface AppBindsModule {
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.database.bookmark.BookmarkRepository bindsBookmarkModel(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.bookmark.BookmarkDatabase bookmarkDatabase);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.database.downloads.DownloadsRepository bindsDownloadsModel(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.downloads.DownloadsDatabase downloadsDatabase);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.database.history.HistoryRepository bindsHistoryModel(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.history.HistoryDatabase historyDatabase);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.database.allowlist.AdBlockAllowListRepository bindsAdBlockAllowListModel(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.allowlist.AdBlockAllowListDatabase adBlockAllowListDatabase);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.adblock.allowlist.AllowListModel bindsAllowListModel(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.allowlist.SessionAllowListModel sessionAllowListModel);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.ssl.SslWarningPreferences bindsSslWarningPreferences(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.ssl.SessionSslWarningPreferences sessionSslWarningPreferences);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.adblock.source.HostsDataSource bindsHostsDataSource(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.source.AssetsHostsDataSource assetsHostsDataSource);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.database.adblock.HostsRepository bindsHostsRepository(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.adblock.HostsDatabase hostsDatabase);
    
    @org.jetbrains.annotations.NotNull()
    @dagger.Binds()
    public abstract acr.browser.lightning.adblock.source.HostsDataSourceProvider bindsHostsDataSourceProvider(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.source.PreferencesHostsDataSourceProvider preferencesHostsDataSourceProvider);
}