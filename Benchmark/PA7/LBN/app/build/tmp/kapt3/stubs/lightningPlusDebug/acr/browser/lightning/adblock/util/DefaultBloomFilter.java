package acr.browser.lightning.adblock.util;

import java.lang.System;

/**
 * A [BloomFilter] implementation is based off the algorithm described
 * in [https://en.wikipedia.org/wiki/Bloom_filter] and borrows from Guava's bloom filter
 * implementation.
 *
 * The number of bits and number of hash functions are calculated as follows:
 * ```
 * n = number of elements
 * p = false positive rate
 * m = number of bits
 * k = number of hash functions
 *
 * m = -n ln p / (ln 2) ^ 2
 *
 * k = m ln 2 / n
 * ```
 * This bloom filter is backed by a bit array, and at very large input values and very low false
 * positive rates, the bloom filter will not perform optimally, since the maximum number of bits is
 * limited to [Int.MAX_VALUE].
 *
 * @param numberOfElements The number of elements that will be added to this filter.
 * @param falsePositiveRate The acceptable rate of false positives.
 * @param hashingAlgorithm The algorithm that should be used to hash the values.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B#\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u00a2\u0006\u0002\u0010\nJ\u0015\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lacr/browser/lightning/adblock/util/DefaultBloomFilter;", "T", "Lacr/browser/lightning/adblock/util/BloomFilter;", "Ljava/io/Serializable;", "numberOfElements", "", "falsePositiveRate", "", "hashingAlgorithm", "Lacr/browser/lightning/adblock/util/hash/HashingAlgorithm;", "(IDLacr/browser/lightning/adblock/util/hash/HashingAlgorithm;)V", "bitSet", "Ljava/util/BitSet;", "numberOfBits", "numberOfHashes", "mightContain", "", "item", "(Ljava/lang/Object;)Z", "put", "", "(Ljava/lang/Object;)V", "putAll", "collection", "", "app_lightningPlusDebug"})
public final class DefaultBloomFilter<T extends java.lang.Object> implements acr.browser.lightning.adblock.util.BloomFilter<T>, java.io.Serializable {
    private final int numberOfBits = 0;
    private final int numberOfHashes = 0;
    private final java.util.BitSet bitSet = null;
    private final acr.browser.lightning.adblock.util.hash.HashingAlgorithm<T> hashingAlgorithm = null;
    
    @java.lang.Override()
    public void put(T item) {
    }
    
    @java.lang.Override()
    public void putAll(@org.jetbrains.annotations.NotNull()
    java.util.Collection<? extends T> collection) {
    }
    
    @java.lang.Override()
    public boolean mightContain(T item) {
        return false;
    }
    
    public DefaultBloomFilter(int numberOfElements, double falsePositiveRate, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.util.hash.HashingAlgorithm<T> hashingAlgorithm) {
        super();
    }
}