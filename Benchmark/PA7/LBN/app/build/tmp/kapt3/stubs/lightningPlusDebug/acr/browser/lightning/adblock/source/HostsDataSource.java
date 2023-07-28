package acr.browser.lightning.adblock.source;

import java.lang.System;

/**
 * A data source that contains hosts.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/adblock/source/HostsDataSource;", "", "identifier", "", "loadHosts", "Lio/reactivex/Single;", "Lacr/browser/lightning/adblock/source/HostsResult;", "app_lightningPlusDebug"})
public abstract interface HostsDataSource {
    
    /**
     * Load the hosts and emit them as a [Single] [HostsResult].
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<acr.browser.lightning.adblock.source.HostsResult> loadHosts();
    
    /**
     * The unique [String] identifier for this source.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String identifier();
}