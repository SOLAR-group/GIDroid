package acr.browser.lightning.adblock.util;

import java.lang.System;

/**
 * A bloom filter.
 *
 * See [https://en.wikipedia.org/wiki/Bloom_filter] for data structure details.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\fH&\u00a8\u0006\r"}, d2 = {"Lacr/browser/lightning/adblock/util/BloomFilter;", "T", "", "mightContain", "", "item", "(Ljava/lang/Object;)Z", "put", "", "(Ljava/lang/Object;)V", "putAll", "collection", "", "app_lightningLiteDebug"})
public abstract interface BloomFilter<T extends java.lang.Object> {
    
    /**
     * Adds the [item] to the filter. Adding the [item] guarantees that a subsequent call to
     * [mightContain] with the same arguments will return `true`.
     */
    public abstract void put(T item);
    
    /**
     * Adds all elements of the [collection] to the filter. Adding these elements guarantees that a
     * subsequent call to [mightContain] with the same element will return `true`.
     */
    public abstract void putAll(@org.jetbrains.annotations.NotNull()
    java.util.Collection<? extends T> collection);
    
    /**
     * Returns `true` if the [item] might have been added to the filter, `false` otherwise. Due to
     * the probabilistic nature of this data structure, returning `true` cannot guarantee that the
     * [item] was ever added, but returning `false` guarantees that it was not.
     */
    public abstract boolean mightContain(T item);
}