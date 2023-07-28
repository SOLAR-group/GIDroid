package acr.browser.lightning.list;

import java.lang.System;

/**
 * A [RecyclerView.Adapter] that displays [DialogItem] with icons.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0017"}, d2 = {"Lacr/browser/lightning/list/RecyclerViewDialogItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lacr/browser/lightning/list/DialogItemViewHolder;", "listItems", "", "Lacr/browser/lightning/dialog/DialogItem;", "(Ljava/util/List;)V", "onItemClickListener", "Lkotlin/Function1;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_lightningLiteDebug"})
public final class RecyclerViewDialogItemAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<acr.browser.lightning.list.DialogItemViewHolder> {
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super acr.browser.lightning.dialog.DialogItem, kotlin.Unit> onItemClickListener;
    private final java.util.List<acr.browser.lightning.dialog.DialogItem> listItems = null;
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<acr.browser.lightning.dialog.DialogItem, kotlin.Unit> getOnItemClickListener() {
        return null;
    }
    
    public final void setOnItemClickListener(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super acr.browser.lightning.dialog.DialogItem, kotlin.Unit> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public acr.browser.lightning.list.DialogItemViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.list.DialogItemViewHolder holder, int position) {
    }
    
    public RecyclerViewDialogItemAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<acr.browser.lightning.dialog.DialogItem> listItems) {
        super();
    }
}