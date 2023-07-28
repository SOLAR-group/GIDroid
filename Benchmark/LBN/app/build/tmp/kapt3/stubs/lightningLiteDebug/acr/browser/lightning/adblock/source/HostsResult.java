package acr.browser.lightning.adblock.source;

import java.lang.System;

/**
 * The result of a request for the hosts to block.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0002\u0005\u0006\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/adblock/source/HostsResult;", "", "()V", "Failure", "Success", "Lacr/browser/lightning/adblock/source/HostsResult$Success;", "Lacr/browser/lightning/adblock/source/HostsResult$Failure;", "app_lightningLiteDebug"})
public abstract class HostsResult {
    
    private HostsResult() {
        super();
    }
    
    /**
     * A successful request.
     *
     * @param hosts The hosts to block.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003\u00f8\u0001\u0000J\u001c\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0001\u00f8\u0001\u0000J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00f8\u0001\u0000\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lacr/browser/lightning/adblock/source/HostsResult$Success;", "Lacr/browser/lightning/adblock/source/HostsResult;", "hosts", "", "Lacr/browser/lightning/database/adblock/Host;", "(Ljava/util/List;)V", "getHosts", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_lightningLiteDebug"})
    public static final class Success extends acr.browser.lightning.adblock.source.HostsResult {
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<acr.browser.lightning.database.adblock.Host> hosts = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<acr.browser.lightning.database.adblock.Host> getHosts() {
            return null;
        }
        
        public Success(@org.jetbrains.annotations.NotNull()
        java.util.List<acr.browser.lightning.database.adblock.Host> hosts) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<acr.browser.lightning.database.adblock.Host> component1() {
            return null;
        }
        
        /**
         * A successful request.
         *
         * @param hosts The hosts to block.
         */
        @org.jetbrains.annotations.NotNull()
        public final acr.browser.lightning.adblock.source.HostsResult.Success copy(@org.jetbrains.annotations.NotNull()
        java.util.List<acr.browser.lightning.database.adblock.Host> hosts) {
            return null;
        }
        
        /**
         * A successful request.
         *
         * @param hosts The hosts to block.
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        /**
         * A successful request.
         *
         * @param hosts The hosts to block.
         */
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        /**
         * A successful request.
         *
         * @param hosts The hosts to block.
         */
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
    
    /**
     * An unsuccessful request.
     *
     * @param cause The cause of the failure.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u00a2\u0006\u0002\u0010\u0005J\r\u0010\b\u001a\u00060\u0003j\u0002`\u0004H\u00c6\u0003J\u0017\u0010\t\u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004H\u00c6\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u00d6\u0003J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u0012"}, d2 = {"Lacr/browser/lightning/adblock/source/HostsResult$Failure;", "Lacr/browser/lightning/adblock/source/HostsResult;", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/Exception;)V", "getCause", "()Ljava/lang/Exception;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "app_lightningLiteDebug"})
    public static final class Failure extends acr.browser.lightning.adblock.source.HostsResult {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.Exception cause = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Exception getCause() {
            return null;
        }
        
        public Failure(@org.jetbrains.annotations.NotNull()
        java.lang.Exception cause) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.Exception component1() {
            return null;
        }
        
        /**
         * An unsuccessful request.
         *
         * @param cause The cause of the failure.
         */
        @org.jetbrains.annotations.NotNull()
        public final acr.browser.lightning.adblock.source.HostsResult.Failure copy(@org.jetbrains.annotations.NotNull()
        java.lang.Exception cause) {
            return null;
        }
        
        /**
         * An unsuccessful request.
         *
         * @param cause The cause of the failure.
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        /**
         * An unsuccessful request.
         *
         * @param cause The cause of the failure.
         */
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        /**
         * An unsuccessful request.
         *
         * @param cause The cause of the failure.
         */
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
}