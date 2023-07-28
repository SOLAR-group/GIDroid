package acr.browser.lightning.rx;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u00a0\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0004\b\u0003\u0010\u0006\"\b\b\u0004\u0010\u0002*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\u001a\b\u0004\u0010\t\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00050\u000b0\n2\u001a\b\u0004\u0010\f\u001a\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\u000b0\n2\u001a\b\u0004\u0010\u0000\u001a\u0014\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\rH\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\u000e"}, d2 = {"join", "Lio/reactivex/Flowable;", "S", "T", "R", "Selector_T", "Selector_R", "", "other", "selectorLeft", "Lkotlin/Function1;", "Lorg/reactivestreams/Publisher;", "selectorRight", "Lkotlin/Function2;", "app_lightningLiteDebug"})
public final class RxExtensionsKt {
    
    /**
     * Kotlin friendly version of [Observable.join].
     *
     * @param other The other observable that will be joined to the current one.
     * @param selectorLeft Provides an observable used to signal sampling windows for this observable.
     * @param selectorRight Provides an observable used to signal sampling windows for the [other]
     * observable.
     * @param join The function that joins the output of this and the [other] observable into the output
     * type.
     * @see Observable.join
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object, R extends java.lang.Object, Selector_T extends java.lang.Object, Selector_R extends java.lang.Object, S extends java.lang.Object>io.reactivex.Flowable<S> join(@org.jetbrains.annotations.NotNull()
    io.reactivex.Flowable<T> $this$join, @org.jetbrains.annotations.NotNull()
    io.reactivex.Flowable<R> other, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, ? extends org.reactivestreams.Publisher<Selector_T>> selectorLeft, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super R, ? extends org.reactivestreams.Publisher<Selector_R>> selectorRight, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super T, ? super R, ? extends S> join) {
        return null;
    }
}