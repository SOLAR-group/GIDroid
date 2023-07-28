package acr.browser.lightning.browser.bookmark;

import java.lang.System;

/**
 * An adapter that creates the views for bookmark list items and binds the bookmark data to them.
 *
 * @param onClick Invoked when the cell is clicked.
 * @param onLongClick Invoked when the cell is long pressed.
 * @param imageLoader The image loader needed to load favicons.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B5\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0006H\u0016J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lacr/browser/lightning/browser/bookmark/BookmarkRecyclerViewAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lacr/browser/lightning/database/Bookmark;", "Lacr/browser/lightning/browser/bookmark/BookmarkViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "onLongClick", "imageLoader", "Lacr/browser/lightning/browser/image/ImageLoader;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lacr/browser/lightning/browser/image/ImageLoader;)V", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "app_lightningLiteDebug"})
public final class BookmarkRecyclerViewAdapter extends androidx.recyclerview.widget.ListAdapter<acr.browser.lightning.database.Bookmark, acr.browser.lightning.browser.bookmark.BookmarkViewHolder> {
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onClick = null;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onLongClick = null;
    private final acr.browser.lightning.browser.image.ImageLoader imageLoader = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public acr.browser.lightning.browser.bookmark.BookmarkViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.bookmark.BookmarkViewHolder holder, int position) {
    }
    
    public BookmarkRecyclerViewAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onLongClick, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.image.ImageLoader imageLoader) {
        super(null);
    }
}