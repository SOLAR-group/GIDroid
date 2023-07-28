package acr.browser.lightning.adblock.source;

import java.lang.System;

/**
 * The source from which hosts should be loaded.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/adblock/source/HostsSourceType;", "", "()V", "Default", "Local", "Remote", "Lacr/browser/lightning/adblock/source/HostsSourceType$Default;", "Lacr/browser/lightning/adblock/source/HostsSourceType$Local;", "Lacr/browser/lightning/adblock/source/HostsSourceType$Remote;", "app_lightningLiteDebug"})
public abstract class HostsSourceType {
    
    private HostsSourceType() {
        super();
    }
    
    /**
     * The default source, included in the app assets.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lacr/browser/lightning/adblock/source/HostsSourceType$Default;", "Lacr/browser/lightning/adblock/source/HostsSourceType;", "()V", "app_lightningLiteDebug"})
    public static final class Default extends acr.browser.lightning.adblock.source.HostsSourceType {
        @org.jetbrains.annotations.NotNull()
        public static final acr.browser.lightning.adblock.source.HostsSourceType.Default INSTANCE = null;
        
        private Default() {
            super();
        }
    }
    
    /**
     * A local source, loaded from a local file.
     *
     * @param file The hosts file to use, must have access to it.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/adblock/source/HostsSourceType$Local;", "Lacr/browser/lightning/adblock/source/HostsSourceType;", "file", "Ljava/io/File;", "(Ljava/io/File;)V", "getFile", "()Ljava/io/File;", "app_lightningLiteDebug"})
    public static final class Local extends acr.browser.lightning.adblock.source.HostsSourceType {
        @org.jetbrains.annotations.NotNull()
        private final java.io.File file = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.io.File getFile() {
            return null;
        }
        
        public Local(@org.jetbrains.annotations.NotNull()
        java.io.File file) {
            super();
        }
    }
    
    /**
     * A remote source, loaded from a URL.
     *
     * @param httpUrl The URL of the hosts file.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/adblock/source/HostsSourceType$Remote;", "Lacr/browser/lightning/adblock/source/HostsSourceType;", "httpUrl", "Lokhttp3/HttpUrl;", "(Lokhttp3/HttpUrl;)V", "getHttpUrl", "()Lokhttp3/HttpUrl;", "app_lightningLiteDebug"})
    public static final class Remote extends acr.browser.lightning.adblock.source.HostsSourceType {
        @org.jetbrains.annotations.NotNull()
        private final okhttp3.HttpUrl httpUrl = null;
        
        @org.jetbrains.annotations.NotNull()
        public final okhttp3.HttpUrl getHttpUrl() {
            return null;
        }
        
        public Remote(@org.jetbrains.annotations.NotNull()
        okhttp3.HttpUrl httpUrl) {
            super();
        }
    }
}