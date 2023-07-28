package acr.browser.lightning.rx;

import java.lang.System;

/**
 * A [Disposable] that safely unregisters a [BroadcastReceiver] when disposed.
 *
 * Created by anthonycr on 10/21/17.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lacr/browser/lightning/rx/BroadcastReceiverDisposable;", "Lio/reactivex/disposables/Disposable;", "context", "Landroid/content/Context;", "broadcastReceiver", "Landroid/content/BroadcastReceiver;", "(Landroid/content/Context;Landroid/content/BroadcastReceiver;)V", "disposed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "dispose", "", "isDisposed", "", "app_lightningPlusDebug"})
public final class BroadcastReceiverDisposable implements io.reactivex.disposables.Disposable {
    private final java.util.concurrent.atomic.AtomicBoolean disposed = null;
    private final android.content.Context context = null;
    private final android.content.BroadcastReceiver broadcastReceiver = null;
    
    @java.lang.Override()
    public boolean isDisposed() {
        return false;
    }
    
    @java.lang.Override()
    public void dispose() {
    }
    
    public BroadcastReceiverDisposable(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    android.content.BroadcastReceiver broadcastReceiver) {
        super();
    }
}