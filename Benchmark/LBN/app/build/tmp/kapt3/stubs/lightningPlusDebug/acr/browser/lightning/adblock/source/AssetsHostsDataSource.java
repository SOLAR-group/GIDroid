package acr.browser.lightning.adblock.source;

import java.lang.System;

/**
 * A [HostsDataSource] that reads from the hosts list in assets.
 *
 * @param assetManager The store for application assets.
 * @param hostsFileParserProvider The provider used to construct the parser.
 * @param logger The logger used to log status.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lacr/browser/lightning/adblock/source/AssetsHostsDataSource;", "Lacr/browser/lightning/adblock/source/HostsDataSource;", "assetManager", "Landroid/content/res/AssetManager;", "hostsFileParserProvider", "Ljavax/inject/Provider;", "Lacr/browser/lightning/adblock/parser/HostsFileParser;", "logger", "Lacr/browser/lightning/log/Logger;", "(Landroid/content/res/AssetManager;Ljavax/inject/Provider;Lacr/browser/lightning/log/Logger;)V", "identifier", "", "loadHosts", "Lio/reactivex/Single;", "Lacr/browser/lightning/adblock/source/HostsResult;", "Companion", "app_lightningPlusDebug"})
public final class AssetsHostsDataSource implements acr.browser.lightning.adblock.source.HostsDataSource {
    private final android.content.res.AssetManager assetManager = null;
    private final javax.inject.Provider<acr.browser.lightning.adblock.parser.HostsFileParser> hostsFileParserProvider = null;
    private final acr.browser.lightning.log.Logger logger = null;
    private static final java.lang.String TAG = "AssetsHostsDataSource";
    private static final java.lang.String BLOCKED_DOMAINS_LIST_FILE_NAME = "hosts.txt";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.adblock.source.AssetsHostsDataSource.Companion Companion = null;
    
    /**
     * A [Single] that reads through a hosts file and extracts the domains that should be redirected
     * to localhost (a.k.a. IP address 127.0.0.1). It can handle files that simply have a list of
     * host names to block, or it can handle a full blown hosts file. It will strip out comments,
     * references to the base IP address and just extract the domains to be used.
     *
     * @see HostsDataSource.loadHosts
     */
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<acr.browser.lightning.adblock.source.HostsResult> loadHosts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String identifier() {
        return null;
    }
    
    @javax.inject.Inject()
    public AssetsHostsDataSource(@org.jetbrains.annotations.NotNull()
    android.content.res.AssetManager assetManager, @org.jetbrains.annotations.NotNull()
    javax.inject.Provider<acr.browser.lightning.adblock.parser.HostsFileParser> hostsFileParserProvider, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lacr/browser/lightning/adblock/source/AssetsHostsDataSource$Companion;", "", "()V", "BLOCKED_DOMAINS_LIST_FILE_NAME", "", "TAG", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}