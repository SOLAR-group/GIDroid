package acr.browser.lightning.rx;

import java.lang.System;

/**
 * An [Observable] of [Intent] emitted from a [BroadcastReceiver] registered with the [Application].
 *
 * Created by anthonycr on 3/30/18.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u000e\u0010\n\u001a\n\u0012\u0006\b\u0000\u0012\u00020\u00020\u000bH\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lacr/browser/lightning/rx/BroadcastReceiverObservable;", "Lio/reactivex/Observable;", "Landroid/content/Intent;", "action", "", "application", "Landroid/app/Application;", "(Ljava/lang/String;Landroid/app/Application;)V", "subscribeActual", "", "observer", "Lio/reactivex/Observer;", "app_lightningPlusDebug"})
public final class BroadcastReceiverObservable extends io.reactivex.Observable<android.content.Intent> {
    private final java.lang.String action = null;
    private final android.app.Application application = null;
    
    @java.lang.Override()
    protected void subscribeActual(@org.jetbrains.annotations.NotNull()
    io.reactivex.Observer<? super android.content.Intent> observer) {
    }
    
    public BroadcastReceiverObservable(@org.jetbrains.annotations.NotNull()
    java.lang.String action, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
}