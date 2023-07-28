package acr.browser.lightning.database.adblock;

import java.lang.System;

/**
 * A repository that stores [Host].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&\u00f8\u0001\u0000J\u0017\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\bH&\u00f8\u0001\u0000J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0006H&\u00f8\u0001\u0000\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u000e\u001a\u00020\nH&J\b\u0010\u000f\u001a\u00020\u0003H&\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lacr/browser/lightning/database/adblock/HostsRepository;", "", "addHosts", "Lio/reactivex/Completable;", "hosts", "", "Lacr/browser/lightning/database/adblock/Host;", "allHosts", "Lio/reactivex/Single;", "containsHost", "", "host", "containsHost-M0b_tl8", "(Ljava/lang/String;)Z", "hasHosts", "removeAllHosts", "app_lightningLiteDebug"})
public abstract interface HostsRepository {
    
    /**
     * Add the [List] of [Host] to the repository.
     *
     * @return A [Completable] that completes when the addition finishes.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable addHosts(@org.jetbrains.annotations.NotNull()
    java.util.List<acr.browser.lightning.database.adblock.Host> hosts);
    
    /**
     * Remove all hosts in the repository.
     *
     * @return A [Completable] that completes when the removal finishes.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable removeAllHosts();
    
    /**
     * @return `true` if the repository has been initialized, `false` otherwise.
     */
    public abstract boolean hasHosts();
    
    /**
     * @return A [Single] that emits a list of all hosts in the repository.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<acr.browser.lightning.database.adblock.Host>> allHosts();
}