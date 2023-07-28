package acr.browser.lightning.database.adblock;

import java.lang.System;

/**
 * An in memory hosts repository. Hosts are stored in a [Set].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tH\u0016\u00f8\u0001\u0000J\u0017\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u000bH\u0016\u00f8\u0001\u0000J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0011\u001a\u00020\rH\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00f8\u0001\u0000\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0013"}, d2 = {"Lacr/browser/lightning/database/adblock/InMemoryHostsRepository;", "Lacr/browser/lightning/database/adblock/HostsRepository;", "()V", "mutableHostsSet", "", "Lacr/browser/lightning/database/adblock/Host;", "addHosts", "Lio/reactivex/Completable;", "hosts", "", "allHosts", "Lio/reactivex/Single;", "containsHost", "", "host", "containsHost-M0b_tl8", "(Ljava/lang/String;)Z", "hasHosts", "removeAllHosts", "app_lightningPlusDebug"})
@javax.inject.Singleton()
public final class InMemoryHostsRepository implements acr.browser.lightning.database.adblock.HostsRepository {
    private java.util.Set<acr.browser.lightning.database.adblock.Host> mutableHostsSet;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable addHosts(@org.jetbrains.annotations.NotNull()
    java.util.List<acr.browser.lightning.database.adblock.Host> hosts) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Completable removeAllHosts() {
        return null;
    }
    
    @java.lang.Override()
    public boolean hasHosts() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<acr.browser.lightning.database.adblock.Host>> allHosts() {
        return null;
    }
    
    @javax.inject.Inject()
    public InMemoryHostsRepository() {
        super();
    }
}