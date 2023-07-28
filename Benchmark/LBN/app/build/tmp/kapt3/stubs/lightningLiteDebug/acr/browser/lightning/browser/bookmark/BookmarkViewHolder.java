package acr.browser.lightning.browser.bookmark;

import java.lang.System;

/**
 * The view holder that shows bookmark items.
 *
 * @param onItemClickListener Invoked when the cell is clicked.
 * @param onItemLongClickListener Invoked when the cell is long pressed.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\u000bJ\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u0005H\u0016R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lacr/browser/lightning/browser/bookmark/BookmarkViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnLongClickListener;", "itemView", "Landroid/view/View;", "onItemLongClickListener", "Lkotlin/Function1;", "", "", "onItemClickListener", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "binding", "Lacr/browser/lightning/databinding/BookmarkListItemBinding;", "getBinding", "()Lacr/browser/lightning/databinding/BookmarkListItemBinding;", "onClick", "v", "onLongClick", "", "app_lightningLiteDebug"})
public final class BookmarkViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder implements android.view.View.OnClickListener, android.view.View.OnLongClickListener {
    @org.jetbrains.annotations.NotNull()
    private final acr.browser.lightning.databinding.BookmarkListItemBinding binding = null;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onItemLongClickListener = null;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onItemClickListener = null;
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.databinding.BookmarkListItemBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
    }
    
    @java.lang.Override()
    public boolean onLongClick(@org.jetbrains.annotations.NotNull()
    android.view.View v) {
        return false;
    }
    
    public BookmarkViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.View itemView, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onItemLongClickListener, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onItemClickListener) {
        super(null);
    }
}