package acr.browser.lightning.adblock.allowlist;

import java.lang.System;

/**
 * An in memory representation of the ad blocking whitelist. Can be queried synchronously.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lacr/browser/lightning/adblock/allowlist/SessionAllowListModel;", "Lacr/browser/lightning/adblock/allowlist/AllowListModel;", "adBlockAllowListModel", "Lacr/browser/lightning/database/allowlist/AdBlockAllowListRepository;", "ioScheduler", "Lio/reactivex/Scheduler;", "logger", "Lacr/browser/lightning/log/Logger;", "(Lacr/browser/lightning/database/allowlist/AdBlockAllowListRepository;Lio/reactivex/Scheduler;Lacr/browser/lightning/log/Logger;)V", "whitelistSet", "Ljava/util/HashSet;", "", "addUrlToAllowList", "", "url", "isUrlAllowedAds", "", "removeUrlFromAllowList", "Companion", "app_lightningPlusDebug"})
@javax.inject.Singleton()
public final class SessionAllowListModel implements acr.browser.lightning.adblock.allowlist.AllowListModel {
    private java.util.HashSet<java.lang.String> whitelistSet;
    private final acr.browser.lightning.database.allowlist.AdBlockAllowListRepository adBlockAllowListModel = null;
    private final io.reactivex.Scheduler ioScheduler = null;
    private final acr.browser.lightning.log.Logger logger = null;
    private static final java.lang.String TAG = "SessionAllowListModel";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.adblock.allowlist.SessionAllowListModel.Companion Companion = null;
    
    @java.lang.Override()
    public boolean isUrlAllowedAds(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return false;
    }
    
    @java.lang.Override()
    public void addUrlToAllowList(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @java.lang.Override()
    public void removeUrlFromAllowList(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    @javax.inject.Inject()
    public SessionAllowListModel(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.allowlist.AdBlockAllowListRepository adBlockAllowListModel, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DatabaseScheduler()
    io.reactivex.Scheduler ioScheduler, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/adblock/allowlist/SessionAllowListModel$Companion;", "", "()V", "TAG", "", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}