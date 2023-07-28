package acr.browser.lightning.utils;

import java.lang.System;

/**
 * An option type, taken from the Arrow library.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u0004*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u0082\u0001\u0002\u0007\b\u00a8\u0006\t"}, d2 = {"Lacr/browser/lightning/utils/Option;", "T", "", "()V", "Companion", "None", "Some", "Lacr/browser/lightning/utils/Option$Some;", "Lacr/browser/lightning/utils/Option$None;", "app_lightningPlusDebug"})
public abstract class Option<T extends java.lang.Object> {
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.utils.Option.Companion Companion = null;
    
    private Option() {
        super();
    }
    
    /**
     * A type representing the presences of [some] [T].
     *
     * @param some Some [T].
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001H\u00c6\u0003\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001H\u00c6\u0001\u00a2\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u00d6\u0003J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001R\u0013\u0010\u0003\u001a\u00028\u0001\u00a2\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lacr/browser/lightning/utils/Option$Some;", "T", "Lacr/browser/lightning/utils/Option;", "some", "(Ljava/lang/Object;)V", "getSome", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lacr/browser/lightning/utils/Option$Some;", "equals", "", "other", "", "hashCode", "", "toString", "", "app_lightningPlusDebug"})
    public static final class Some<T extends java.lang.Object> extends acr.browser.lightning.utils.Option<T> {
        private final T some = null;
        
        public final T getSome() {
            return null;
        }
        
        public Some(T some) {
            super();
        }
        
        public final T component1() {
            return null;
        }
        
        /**
         * A type representing the presences of [some] [T].
         *
         * @param some Some [T].
         */
        @org.jetbrains.annotations.NotNull()
        public final acr.browser.lightning.utils.Option.Some<T> copy(T some) {
            return null;
        }
        
        /**
         * A type representing the presences of [some] [T].
         *
         * @param some Some [T].
         */
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String toString() {
            return null;
        }
        
        /**
         * A type representing the presences of [some] [T].
         *
         * @param some Some [T].
         */
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        /**
         * A type representing the presences of [some] [T].
         *
         * @param some Some [T].
         */
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
            return false;
        }
    }
    
    /**
     * A type representing the absence of [T].
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lacr/browser/lightning/utils/Option$None;", "Lacr/browser/lightning/utils/Option;", "", "()V", "app_lightningPlusDebug"})
    public static final class None extends acr.browser.lightning.utils.Option {
        @org.jetbrains.annotations.NotNull()
        public static final acr.browser.lightning.utils.Option.None INSTANCE = null;
        
        private None() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J!\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u0001H\u0005\u00a2\u0006\u0002\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lacr/browser/lightning/utils/Option$Companion;", "", "()V", "fromNullable", "Lacr/browser/lightning/utils/Option;", "T", "value", "(Ljava/lang/Object;)Lacr/browser/lightning/utils/Option;", "app_lightningPlusDebug"})
    public static final class Companion {
        
        /**
         * Creates an [Option] from the potentially nullable [value].
         */
        @org.jetbrains.annotations.NotNull()
        public final <T extends java.lang.Object>acr.browser.lightning.utils.Option<T> fromNullable(@org.jetbrains.annotations.Nullable()
        T value) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}