package acr.browser.lightning.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0001H\u0086\b\u001a8\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\t"}, d2 = {"filterInstance", "Lio/reactivex/Observable;", "T", "", "onIOExceptionResumeNext", "Lio/reactivex/Single;", "mapper", "Lkotlin/Function1;", "Ljava/io/IOException;", "app_lightningLiteDebug"})
public final class ObservableExtensionsKt {
    
    /**
     * On an [IOException], resume with the value provided by the [mapper].
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>io.reactivex.Single<T> onIOExceptionResumeNext(@org.jetbrains.annotations.NotNull()
    io.reactivex.Single<T> $this$onIOExceptionResumeNext, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.io.IOException, ? extends T> mapper) {
        return null;
    }
}