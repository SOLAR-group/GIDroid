package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * The adapter that renders tabs in the drawer list form.
 *
 * @param onClick Invoked when the tab is clicked.
 * @param onLongClick Invoked when the tab is long pressed.
 * @param onCloseClick Invoked when the tab's close button is clicked.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BA\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0018\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\"\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lacr/browser/lightning/browser/tab/DrawerTabRecyclerViewAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lacr/browser/lightning/browser/tab/TabViewState;", "Lacr/browser/lightning/browser/tab/TabViewHolder;", "onClick", "Lkotlin/Function1;", "", "", "onLongClick", "onCloseClick", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "i", "updateViewHolderAppearance", "viewHolder", "isForeground", "", "updateViewHolderBackground", "updateViewHolderFavicon", "favicon", "Landroid/graphics/Bitmap;", "app_lightningPlusDebug"})
public final class DrawerTabRecyclerViewAdapter extends androidx.recyclerview.widget.ListAdapter<acr.browser.lightning.browser.tab.TabViewState, acr.browser.lightning.browser.tab.TabViewHolder> {
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onClick = null;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onLongClick = null;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onCloseClick = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public acr.browser.lightning.browser.tab.TabViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup viewGroup, int i) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.TabViewHolder holder, int position) {
    }
    
    private final void updateViewHolderFavicon(acr.browser.lightning.browser.tab.TabViewHolder viewHolder, android.graphics.Bitmap favicon, boolean isForeground) {
    }
    
    private final void updateViewHolderBackground(acr.browser.lightning.browser.tab.TabViewHolder viewHolder, boolean isForeground) {
    }
    
    private final void updateViewHolderAppearance(acr.browser.lightning.browser.tab.TabViewHolder viewHolder, boolean isForeground) {
    }
    
    public DrawerTabRecyclerViewAdapter(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onLongClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onCloseClick) {
        super(null);
    }
}