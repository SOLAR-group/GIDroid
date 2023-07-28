package acr.browser.lightning.adblock.util.object;

import java.lang.System;

/**
 * A store of objects matched to keys.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u0000*\f\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0017\u0010\b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a2\u0006\u0002\u0010\tJ\u001d\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00028\u0000H&\u00a2\u0006\u0002\u0010\f\u00a8\u0006\r"}, d2 = {"Lacr/browser/lightning/adblock/util/object/ObjectStore;", "T", "", "Ljava/io/Serializable;", "clear", "", "key", "", "retrieve", "(Ljava/lang/String;)Ljava/lang/Object;", "store", "value", "(Ljava/lang/String;Ljava/lang/Object;)V", "app_lightningLiteDebug"})
public abstract interface ObjectStore<T extends java.lang.Object & java.io.Serializable> {
    
    /**
     * Retrieve the value held for [key] or `null` if it is absent.
     */
    @org.jetbrains.annotations.Nullable()
    public abstract T retrieve(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
    
    /**
     * Stores the [value] matched to the provided [key].
     */
    public abstract void store(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    T value);
    
    /**
     * Clears the value held for [key].
     */
    public abstract void clear(@org.jetbrains.annotations.NotNull()
    java.lang.String key);
}