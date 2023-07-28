package acr.browser.lightning.adblock;

import java.lang.System;

/**
 * An [AdBlocker] that is backed by a [BloomFilter].
 *
 * @param logger The logger used to log status.
 * @param hostsDataSourceProvider The provider that provides the data source used to populate the
 * bloom filter and [hostsRepository].
 * @param hostsRepository The long term store for blocked hosts.
 * @param databaseScheduler The scheduler used to communicate with the database asynchronously.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B?\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000fJ%\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001a0\u00192\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u001cH\u0002\u00f8\u0001\u0000J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0017\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u001a0\"H\u0002\u00f8\u0001\u0000J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001eJ\u001b\u0010&\u001a\u0004\u0018\u00010\u0012*\u00020 H\u0002\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\'\u0010(R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00170\u0016X\u0082\u0004\u00f8\u0001\u0000\u00a2\u0006\u0002\n\u0000\u0082\u0002\b\n\u0002\b\u0019\n\u0002\b!\u00a8\u0006*"}, d2 = {"Lacr/browser/lightning/adblock/BloomFilterAdBlocker;", "Lacr/browser/lightning/adblock/AdBlocker;", "logger", "Lacr/browser/lightning/log/Logger;", "hostsDataSourceProvider", "Lacr/browser/lightning/adblock/source/HostsDataSourceProvider;", "hostsRepository", "Lacr/browser/lightning/database/adblock/HostsRepository;", "hostsRepositoryInfo", "Lacr/browser/lightning/database/adblock/HostsRepositoryInfo;", "application", "Landroid/app/Application;", "databaseScheduler", "Lio/reactivex/Scheduler;", "mainScheduler", "(Lacr/browser/lightning/log/Logger;Lacr/browser/lightning/adblock/source/HostsDataSourceProvider;Lacr/browser/lightning/database/adblock/HostsRepository;Lacr/browser/lightning/database/adblock/HostsRepositoryInfo;Landroid/app/Application;Lio/reactivex/Scheduler;Lio/reactivex/Scheduler;)V", "bloomFilter", "Lacr/browser/lightning/adblock/util/DelegatingBloomFilter;", "Lacr/browser/lightning/database/adblock/Host;", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "objectStore", "Lacr/browser/lightning/adblock/util/object/ObjectStore;", "Lacr/browser/lightning/adblock/util/DefaultBloomFilter;", "createAndSaveBloomFilter", "Lio/reactivex/Single;", "Lacr/browser/lightning/adblock/util/BloomFilter;", "hosts", "", "isAd", "", "url", "", "loadStoredBloomFilter", "Lio/reactivex/Maybe;", "populateAdBlockerFromDataSource", "", "forceRefresh", "host", "host-hFOJgYU", "(Ljava/lang/String;)Ljava/lang/String;", "Companion", "app_lightningLiteDebug"})
@javax.inject.Singleton()
public final class BloomFilterAdBlocker implements acr.browser.lightning.adblock.AdBlocker {
    private final acr.browser.lightning.adblock.util.DelegatingBloomFilter<acr.browser.lightning.database.adblock.Host> bloomFilter = null;
    private final acr.browser.lightning.adblock.util.object.ObjectStore<acr.browser.lightning.adblock.util.DefaultBloomFilter<acr.browser.lightning.database.adblock.Host>> objectStore = null;
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    private final acr.browser.lightning.log.Logger logger = null;
    private final acr.browser.lightning.adblock.source.HostsDataSourceProvider hostsDataSourceProvider = null;
    private final acr.browser.lightning.database.adblock.HostsRepository hostsRepository = null;
    private final acr.browser.lightning.database.adblock.HostsRepositoryInfo hostsRepositoryInfo = null;
    private final android.app.Application application = null;
    private final io.reactivex.Scheduler databaseScheduler = null;
    private final io.reactivex.Scheduler mainScheduler = null;
    private static final java.lang.String TAG = "BloomFilterAdBlocker";
    private static final java.lang.String BLOOM_FILTER_KEY = "AdBlockingBloomFilter";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.adblock.BloomFilterAdBlocker.Companion Companion = null;
    
    /**
     * Force the ad blocker to (re)populate its internal hosts filter from the provided hosts data
     * source.
     */
    public final void populateAdBlockerFromDataSource(boolean forceRefresh) {
    }
    
    private final io.reactivex.Maybe<acr.browser.lightning.adblock.util.BloomFilter<acr.browser.lightning.database.adblock.Host>> loadStoredBloomFilter() {
        return null;
    }
    
    private final io.reactivex.Single<acr.browser.lightning.adblock.util.BloomFilter<acr.browser.lightning.database.adblock.Host>> createAndSaveBloomFilter(java.util.List<acr.browser.lightning.database.adblock.Host> hosts) {
        return null;
    }
    
    @java.lang.Override()
    public boolean isAd(@org.jetbrains.annotations.NotNull()
    java.lang.String url) {
        return false;
    }
    
    @javax.inject.Inject()
    public BloomFilterAdBlocker(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.source.HostsDataSourceProvider hostsDataSourceProvider, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.adblock.HostsRepository hostsRepository, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.adblock.HostsRepositoryInfo hostsRepositoryInfo, @org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DatabaseScheduler()
    io.reactivex.Scheduler databaseScheduler, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.MainScheduler()
    io.reactivex.Scheduler mainScheduler) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lacr/browser/lightning/adblock/BloomFilterAdBlocker$Companion;", "", "()V", "BLOOM_FILTER_KEY", "", "TAG", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}