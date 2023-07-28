package acr.browser.lightning.adblock.source;

import java.lang.System;

/**
 * The provider for the hosts data source.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lacr/browser/lightning/adblock/source/HostsDataSourceProvider;", "", "createHostsDataSource", "Lacr/browser/lightning/adblock/source/HostsDataSource;", "app_lightningPlusDebug"})
public abstract interface HostsDataSourceProvider {
    
    /**
     * Create the hosts data source.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract acr.browser.lightning.adblock.source.HostsDataSource createHostsDataSource();
}