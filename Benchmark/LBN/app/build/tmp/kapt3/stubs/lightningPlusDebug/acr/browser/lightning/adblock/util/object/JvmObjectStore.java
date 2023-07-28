package acr.browser.lightning.adblock.util.object;

import java.lang.System;

/**
 * An [ObjectStore] that serializes objects using the [ObjectInputStream].
 *
 * @param application Application used to construct files.
 * @param hashingAlgorithm The hashing algorithm used to construct cache file names.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000*\f\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\tH\u0002J\u0017\u0010\u0010\u001a\u0004\u0018\u00018\u00002\u0006\u0010\r\u001a\u00020\tH\u0016\u00a2\u0006\u0002\u0010\u0011J\u001d\u0010\u0012\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00028\u0000H\u0016\u00a2\u0006\u0002\u0010\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lacr/browser/lightning/adblock/util/object/JvmObjectStore;", "T", "", "Ljava/io/Serializable;", "Lacr/browser/lightning/adblock/util/object/ObjectStore;", "application", "Landroid/app/Application;", "hashingAlgorithm", "Lacr/browser/lightning/adblock/util/hash/HashingAlgorithm;", "", "(Landroid/app/Application;Lacr/browser/lightning/adblock/util/hash/HashingAlgorithm;)V", "clear", "", "key", "createStorageFile", "Ljava/io/File;", "retrieve", "(Ljava/lang/String;)Ljava/lang/Object;", "store", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "app_lightningPlusDebug"})
public final class JvmObjectStore<T extends java.lang.Object & java.io.Serializable> implements acr.browser.lightning.adblock.util.object.ObjectStore<T> {
    private final android.app.Application application = null;
    private final acr.browser.lightning.adblock.util.hash.HashingAlgorithm<java.lang.String> hashingAlgorithm = null;
    
    /**
     * Create the file in which to store the object, using the cache directory.
     */
    private final java.io.File createStorageFile(java.lang.String key) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @kotlin.Suppress(names = {"UNCHECKED_CAST"})
    @java.lang.Override()
    public T retrieve(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return null;
    }
    
    @java.lang.Override()
    public void store(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    T value) {
    }
    
    @java.lang.Override()
    public void clear(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    public JvmObjectStore(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.util.hash.HashingAlgorithm<java.lang.String> hashingAlgorithm) {
        super();
    }
}