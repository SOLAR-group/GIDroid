package acr.browser.lightning.ssl;

import java.lang.System;

/**
 * Representing the SSL state of the browser.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0003\u0006\u0007\b\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/ssl/SslState;", "", "()V", "Invalid", "None", "Valid", "Lacr/browser/lightning/ssl/SslState$None;", "Lacr/browser/lightning/ssl/SslState$Valid;", "Lacr/browser/lightning/ssl/SslState$Invalid;", "app_lightningLiteDebug"})
public abstract class SslState {
    
    private SslState() {
        super();
    }
    
    /**
     * No SSL.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lacr/browser/lightning/ssl/SslState$None;", "Lacr/browser/lightning/ssl/SslState;", "()V", "app_lightningLiteDebug"})
    public static final class None extends acr.browser.lightning.ssl.SslState {
        @org.jetbrains.annotations.NotNull()
        public static final acr.browser.lightning.ssl.SslState.None INSTANCE = null;
        
        private None() {
            super();
        }
    }
    
    /**
     * Valid SSL connection.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lacr/browser/lightning/ssl/SslState$Valid;", "Lacr/browser/lightning/ssl/SslState;", "()V", "app_lightningLiteDebug"})
    public static final class Valid extends acr.browser.lightning.ssl.SslState {
        @org.jetbrains.annotations.NotNull()
        public static final acr.browser.lightning.ssl.SslState.Valid INSTANCE = null;
        
        private Valid() {
            super();
        }
    }
    
    /**
     * Broken SSL connection.
     *
     * @param sslError The error that is causing the invalid SSL state.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/ssl/SslState$Invalid;", "Lacr/browser/lightning/ssl/SslState;", "sslError", "Landroid/net/http/SslError;", "(Landroid/net/http/SslError;)V", "getSslError", "()Landroid/net/http/SslError;", "app_lightningLiteDebug"})
    public static final class Invalid extends acr.browser.lightning.ssl.SslState {
        @org.jetbrains.annotations.NotNull()
        private final android.net.http.SslError sslError = null;
        
        @org.jetbrains.annotations.NotNull()
        public final android.net.http.SslError getSslError() {
            return null;
        }
        
        public Invalid(@org.jetbrains.annotations.NotNull()
        android.net.http.SslError sslError) {
            super();
        }
    }
}