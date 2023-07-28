package acr.browser.lightning.preference.delegates;

import java.lang.System;

/**
 * An [Enum] delegate that is backed by [SharedPreferences].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0012\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H\u00010\u0004B+\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00028\u0000\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\"\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u00052\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001bH\u0096\u0002\u00a2\u0006\u0002\u0010\u001cJ*\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0019\u001a\u00020\u00052\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u001b2\u0006\u0010\u001f\u001a\u00028\u0000H\u0096\u0002\u00a2\u0006\u0002\u0010 R+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00028\u0000X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0017\u00a8\u0006!"}, d2 = {"Lacr/browser/lightning/preference/delegates/EnumPreference;", "T", "", "Lacr/browser/lightning/preference/IntEnum;", "Lkotlin/properties/ReadWriteProperty;", "", "name", "", "defaultValue", "clazz", "Ljava/lang/Class;", "preferences", "Landroid/content/SharedPreferences;", "(Ljava/lang/String;Ljava/lang/Enum;Ljava/lang/Class;Landroid/content/SharedPreferences;)V", "<set-?>", "", "backingInt", "getBackingInt", "()I", "setBackingInt", "(I)V", "backingInt$delegate", "Lkotlin/properties/ReadWriteProperty;", "Ljava/lang/Enum;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Enum;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Enum;)V", "app_lightningLiteDebug"})
public final class EnumPreference<T extends java.lang.Enum<T> & acr.browser.lightning.preference.IntEnum> implements kotlin.properties.ReadWriteProperty<java.lang.Object, T> {
    private final kotlin.properties.ReadWriteProperty backingInt$delegate = null;
    private final T defaultValue = null;
    private final java.lang.Class<T> clazz = null;
    
    private final int getBackingInt() {
        return 0;
    }
    
    private final void setBackingInt(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public T getValue(@org.jetbrains.annotations.NotNull()
    java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KProperty<?> property) {
        return null;
    }
    
    @java.lang.Override()
    public void setValue(@org.jetbrains.annotations.NotNull()
    java.lang.Object thisRef, @org.jetbrains.annotations.NotNull()
    kotlin.reflect.KProperty<?> property, @org.jetbrains.annotations.NotNull()
    T value) {
    }
    
    public EnumPreference(@org.jetbrains.annotations.NotNull()
    java.lang.String name, @org.jetbrains.annotations.NotNull()
    T defaultValue, @org.jetbrains.annotations.NotNull()
    java.lang.Class<T> clazz, @org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences preferences) {
        super();
    }
}