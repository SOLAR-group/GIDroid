package acr.browser.lightning.browser.proxy;

import java.lang.System;

/**
 * A proxy for the proxy that determines if the proxy is ready (proxy-ception).
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lacr/browser/lightning/browser/proxy/Proxy;", "", "isProxyReady", "", "app_lightningPlusDebug"})
public abstract interface Proxy {
    
    /**
     * True if the proxy is ready for use or if no proxy is being used, false otherwise.
     */
    public abstract boolean isProxyReady();
}