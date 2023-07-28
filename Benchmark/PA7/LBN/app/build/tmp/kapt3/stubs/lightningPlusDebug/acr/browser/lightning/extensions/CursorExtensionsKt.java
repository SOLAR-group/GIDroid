package acr.browser.lightning.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\u001a1\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086\b\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u001a0\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0007\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00010\u0004H\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001\u00a8\u0006\b"}, d2 = {"firstOrNullMap", "T", "Landroid/database/Cursor;", "block", "Lkotlin/Function1;", "(Landroid/database/Cursor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "useMap", "", "app_lightningPlusDebug"})
public final class CursorExtensionsKt {
    
    /**
     * Map the cursor to a [List] of [T], passing the cursor back into the [block] for convenience, and
     * then closing the cursor upon return.
     */
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Object>java.util.List<T> useMap(@org.jetbrains.annotations.NotNull()
    android.database.Cursor $this$useMap, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.database.Cursor, ? extends T> block) {
        return null;
    }
    
    /**
     * Return the first element returned by this cursor as [T] or null if there were no elements in the
     * cursor.
     */
    @org.jetbrains.annotations.Nullable()
    public static final <T extends java.lang.Object>T firstOrNullMap(@org.jetbrains.annotations.NotNull()
    android.database.Cursor $this$firstOrNullMap, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.database.Cursor, ? extends T> block) {
        return null;
    }
}