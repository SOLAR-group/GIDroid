package acr.browser.lightning.browser.tab;

import java.lang.System;

/**
 * The adapter that renders tabs in the desktop form.
 *
 * @param onClick Invoked when the tab is clicked.
 * @param onLongClick Invoked when the tab is long pressed.
 * @param onCloseClick Invoked when the tab's close button is clicked.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001BI\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0002\u0010\fJ\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\bJ\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0018\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\"\u0010 \u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00032\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lacr/browser/lightning/browser/tab/DesktopTabRecyclerViewAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lacr/browser/lightning/browser/tab/TabViewState;", "Lacr/browser/lightning/browser/tab/TabViewHolder;", "context", "Landroid/content/Context;", "onClick", "Lkotlin/Function1;", "", "", "onLongClick", "onCloseClick", "(Landroid/content/Context;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "backgroundTabDrawable", "Landroid/graphics/drawable/Drawable;", "foregroundLayout", "Landroid/widget/LinearLayout;", "foregroundTabDrawable", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "i", "updateForegroundTabColor", "color", "updateViewHolderAppearance", "viewHolder", "isForeground", "", "updateViewHolderBackground", "updateViewHolderFavicon", "favicon", "Landroid/graphics/Bitmap;", "app_lightningPlusDebug"})
public final class DesktopTabRecyclerViewAdapter extends androidx.recyclerview.widget.ListAdapter<acr.browser.lightning.browser.tab.TabViewState, acr.browser.lightning.browser.tab.TabViewHolder> {
    private final android.graphics.drawable.Drawable backgroundTabDrawable = null;
    private final android.graphics.drawable.Drawable foregroundTabDrawable = null;
    private android.widget.LinearLayout foregroundLayout;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onClick = null;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onLongClick = null;
    private final kotlin.jvm.functions.Function1<java.lang.Integer, kotlin.Unit> onCloseClick = null;
    
    public final void updateForegroundTabColor(int color) {
    }
    
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
    
    public DesktopTabRecyclerViewAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onLongClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> onCloseClick) {
        super(null);
    }
}