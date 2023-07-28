package acr.browser.lightning.adblock.source;

import java.lang.System;

/**
 * A [HostsDataSource] that loads hosts from the file found in [UserPreferences].
 *
 * @param logger The logger used to log information about the loading process.
 * @param file The file from which hosts will be loaded. Must have read access to the file.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lacr/browser/lightning/adblock/source/FileHostsDataSource;", "Lacr/browser/lightning/adblock/source/HostsDataSource;", "logger", "Lacr/browser/lightning/log/Logger;", "file", "Ljava/io/File;", "(Lacr/browser/lightning/log/Logger;Ljava/io/File;)V", "identifier", "", "loadHosts", "Lio/reactivex/Single;", "Lacr/browser/lightning/adblock/source/HostsResult;", "Companion", "Factory", "app_lightningLiteDebug"})
public final class FileHostsDataSource implements acr.browser.lightning.adblock.source.HostsDataSource {
    private final acr.browser.lightning.log.Logger logger = null;
    private final java.io.File file = null;
    private static final java.lang.String TAG = "FileHostsDataSource";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.adblock.source.FileHostsDataSource.Companion Companion = null;
    
    /**
     * A [Single] that reads through a local hosts file and extracts the domains that should be
     * redirected to localhost (a.k.a. IP address 127.0.0.1). It can handle files that simply have a
     * list of host names to block, or it can handle a full blown hosts file. It will strip out
     * comments, references to the base IP address and just extract the domains to be used.
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
    
    @dagger.assisted.AssistedInject()
    public FileHostsDataSource(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger, @org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    java.io.File file) {
        super();
    }
    
    /**
     * The factory used to construct the data source.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lacr/browser/lightning/adblock/source/FileHostsDataSource$Factory;", "", "create", "Lacr/browser/lightning/adblock/source/FileHostsDataSource;", "file", "Ljava/io/File;", "app_lightningLiteDebug"})
    @dagger.assisted.AssistedFactory()
    public static abstract interface Factory {
        
        /**
         * Create the data source for the provided file.
         */
        @org.jetbrains.annotations.NotNull()
        public abstract acr.browser.lightning.adblock.source.FileHostsDataSource create(@org.jetbrains.annotations.NotNull()
        java.io.File file);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/adblock/source/FileHostsDataSource$Companion;", "", "()V", "TAG", "", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}