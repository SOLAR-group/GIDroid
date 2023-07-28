package acr.browser.lightning.network;

import java.lang.System;

/**
 * A model that supplies network connectivity status updates.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lacr/browser/lightning/network/NetworkConnectivityModel;", "", "connectivityManager", "Landroid/net/ConnectivityManager;", "application", "Landroid/app/Application;", "(Landroid/net/ConnectivityManager;Landroid/app/Application;)V", "connectivity", "Lio/reactivex/Observable;", "", "Companion", "app_lightningLiteDebug"})
@dagger.Reusable()
public final class NetworkConnectivityModel {
    private final android.net.ConnectivityManager connectivityManager = null;
    private final android.app.Application application = null;
    private static final java.lang.String NETWORK_BROADCAST_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.network.NetworkConnectivityModel.Companion Companion = null;
    
    /**
     * An infinite observable that emits a boolean value whenever the network condition changes.
     * Emitted value is true when the network is in the connected state, and it is false otherwise.
     */
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Observable<java.lang.Boolean> connectivity() {
        return null;
    }
    
    @javax.inject.Inject()
    public NetworkConnectivityModel(@org.jetbrains.annotations.NotNull()
    android.net.ConnectivityManager connectivityManager, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/network/NetworkConnectivityModel$Companion;", "", "()V", "NETWORK_BROADCAST_ACTION", "", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}