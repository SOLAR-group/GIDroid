package acr.browser.lightning.adblock.util;

import java.lang.System;

/**
 * A bloom filter that delegates to a mutable [BloomFilter]. It does not support additions.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0017\u0012\u0010\b\u0002\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002\u00a2\u0006\u0002\u0010\u0004J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u000f\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0002X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\u0012"}, d2 = {"Lacr/browser/lightning/adblock/util/DelegatingBloomFilter;", "T", "Lacr/browser/lightning/adblock/util/BloomFilter;", "delegate", "(Lacr/browser/lightning/adblock/util/BloomFilter;)V", "getDelegate", "()Lacr/browser/lightning/adblock/util/BloomFilter;", "setDelegate", "mightContain", "", "item", "(Ljava/lang/Object;)Z", "put", "", "(Ljava/lang/Object;)Ljava/lang/Void;", "putAll", "collection", "", "app_lightningLiteDebug"})
public final class DelegatingBloomFilter<T extends java.lang.Object> implements acr.browser.lightning.adblock.util.BloomFilter<T> {
    @org.jetbrains.annotations.Nullable()
    private acr.browser.lightning.adblock.util.BloomFilter<T> delegate;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Void put(T item) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.Void putAll(@org.jetbrains.annotations.NotNull()
    java.util.Collection<? extends T> collection) {
        return null;
    }
    
    @java.lang.Override()
    public boolean mightContain(T item) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final acr.browser.lightning.adblock.util.BloomFilter<T> getDelegate() {
        return null;
    }
    
    public final void setDelegate(@org.jetbrains.annotations.Nullable()
    acr.browser.lightning.adblock.util.BloomFilter<T> p0) {
    }
    
    public DelegatingBloomFilter(@org.jetbrains.annotations.Nullable()
    acr.browser.lightning.adblock.util.BloomFilter<T> delegate) {
        super();
    }
    
    public DelegatingBloomFilter() {
        super();
    }
}