package acr.browser.lightning.list;

import java.lang.System;

/**
 * A simple [RecyclerView.Adapter] that displays a [List] of [String].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B,\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\b\t\u00a2\u0006\u0002\u0010\nJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0012H\u0016R\u001f\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\b0\u0007\u00a2\u0006\u0002\b\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\f\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lacr/browser/lightning/list/RecyclerViewStringAdapter;", "T", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lacr/browser/lightning/list/SimpleStringViewHolder;", "listItems", "", "convertToString", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "onItemClickListener", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_lightningPlusDebug"})
public final class RecyclerViewStringAdapter<T extends java.lang.Object> extends androidx.recyclerview.widget.RecyclerView.Adapter<acr.browser.lightning.list.SimpleStringViewHolder> {
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super T, kotlin.Unit> onItemClickListener;
    private final java.util.List<T> listItems = null;
    private final kotlin.jvm.functions.Function1<T, java.lang.String> convertToString = null;
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<T, kotlin.Unit> getOnItemClickListener() {
        return null;
    }
    
    public final void setOnItemClickListener(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super T, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public acr.browser.lightning.list.SimpleStringViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.list.SimpleStringViewHolder holder, int position) {
    }
    
    public RecyclerViewStringAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends T> listItems, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super T, java.lang.String> convertToString) {
        super();
    }
}