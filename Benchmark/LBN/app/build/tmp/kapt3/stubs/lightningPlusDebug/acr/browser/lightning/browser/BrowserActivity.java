package acr.browser.lightning.browser;

import java.lang.System;

/**
 * The base browser activity that governs the browsing experience for both default and incognito
 * browsers.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008c\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u00020\u0010H\u0002J\u0006\u0010b\u001a\u00020`J\u0006\u0010c\u001a\u00020`J\u0006\u0010d\u001a\u00020`J\u0006\u0010e\u001a\u00020`J\b\u0010f\u001a\u00020\u0010H\'J\b\u0010g\u001a\u00020hH&J\b\u0010i\u001a\u00020\u0010H\'J\b\u0010j\u001a\u00020`H\u0016J\u0012\u0010k\u001a\u00020`2\b\u0010l\u001a\u0004\u0018\u00010mH\u0014J\u0010\u0010n\u001a\u00020h2\u0006\u0010i\u001a\u00020oH\u0016J\b\u0010p\u001a\u00020`H\u0014J\u0018\u0010q\u001a\u00020h2\u0006\u0010r\u001a\u00020\u00102\u0006\u0010s\u001a\u00020tH\u0016J\u0012\u0010u\u001a\u00020`2\b\u0010v\u001a\u0004\u0018\u00010.H\u0014J\u0010\u0010w\u001a\u00020h2\u0006\u0010x\u001a\u00020>H\u0016J\b\u0010y\u001a\u00020`H\u0014J\u0006\u0010z\u001a\u00020`J\u0006\u0010{\u001a\u00020`J\u000e\u0010|\u001a\u00020`2\u0006\u0010}\u001a\u00020~J\u0016\u0010\u007f\u001a\u00020`2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u00020W0\u0081\u0001J\u001b\u0010\u0082\u0001\u001a\u00020`2\u0007\u0010\u0083\u0001\u001a\u00020h2\u0007\u0010\u0084\u0001\u001a\u00020hH\u0002J,\u0010\u0085\u0001\u001a\u00020`2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0087\u00012\u000f\u0010\u0089\u0001\u001a\n\u0012\u0005\u0012\u00030\u0087\u00010\u0081\u0001J\u0011\u0010\u008a\u0001\u001a\u00020`2\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001J\u0010\u0010\u008d\u0001\u001a\u00020`2\u0007\u0010\u008e\u0001\u001a\u00020\u0010J\u0010\u0010\u008f\u0001\u001a\u00020`2\u0007\u0010\u0090\u0001\u001a\u00020\u000eJ\u0011\u0010\u0091\u0001\u001a\u00020`2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001J6\u0010\u0094\u0001\u001a\u00020`2\b\u0010\u0086\u0001\u001a\u00030\u0087\u00012\b\u0010\u0088\u0001\u001a\u00030\u0087\u00012\b\u0010\u0095\u0001\u001a\u00030\u0087\u00012\u000f\u0010\u0089\u0001\u001a\n\u0012\u0005\u0012\u00030\u0087\u00010\u0081\u0001J\u0011\u0010\u0096\u0001\u001a\u00020`2\b\u0010\u0097\u0001\u001a\u00030\u0087\u0001J\u000f\u0010\u0098\u0001\u001a\u00020`2\u0006\u0010v\u001a\u00020.J\u0007\u0010\u0099\u0001\u001a\u00020`J\u0011\u0010\u009a\u0001\u001a\u00020`2\b\u0010\u0095\u0001\u001a\u00030\u009b\u0001J\u0011\u0010\u009c\u0001\u001a\u00020`2\b\u0010\u009d\u0001\u001a\u00030\u009e\u0001J\u0011\u0010\u009f\u0001\u001a\u00020`2\b\u0010\u00a0\u0001\u001a\u00030\u00a1\u0001J\u0011\u0010\u00a2\u0001\u001a\u00020`2\b\u0010\u00a0\u0001\u001a\u00030\u00a1\u0001J\u0007\u0010\u00a3\u0001\u001a\u00020`J\u0007\u0010\u00a4\u0001\u001a\u00020`J\u0019\u0010\u00a5\u0001\u001a\u00020`2\u0007\u0010\u00a6\u0001\u001a\u00020h2\u0007\u0010\u00a7\u0001\u001a\u00020hJ\u000e\u0010\u00a8\u0001\u001a\u00020`*\u00030\u00a9\u0001H\u0002R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u00020\u00158\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001a\u001a\u00020\u001b8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020!8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001e\u0010&\u001a\u00020\'8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\"\u0010,\u001a\u0010\u0012\f\u0012\n /*\u0004\u0018\u00010.0.0-X\u0082\u0004\u00a2\u0006\b\n\u0000\u0012\u0004\b0\u0010\u0002R\u001e\u00101\u001a\u0002028\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001e\u00107\u001a\u0002088\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010>X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u0004\u0018\u00010>X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010>X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010>X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010C\u001a\u00020D8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001e\u0010I\u001a\u00020J8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u001e\u0010O\u001a\u00020P8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR\u001a\u0010U\u001a\u000e\u0012\u0004\u0012\u00020W\u0012\u0004\u0012\u00020X0VX\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010Y\u001a\u00020Z8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^\u00a8\u0006\u00aa\u0001"}, d2 = {"Lacr/browser/lightning/browser/BrowserActivity;", "Lacr/browser/lightning/ThemableBrowserActivity;", "()V", "backgroundDrawable", "Landroid/graphics/drawable/ColorDrawable;", "getBackgroundDrawable", "()Landroid/graphics/drawable/ColorDrawable;", "backgroundDrawable$delegate", "Lkotlin/Lazy;", "binding", "Lacr/browser/lightning/databinding/BrowserActivityBinding;", "bookmarksAdapter", "Lacr/browser/lightning/browser/bookmark/BookmarkRecyclerViewAdapter;", "customView", "Landroid/view/View;", "defaultColor", "", "getDefaultColor", "()I", "defaultColor$delegate", "imageLoader", "Lacr/browser/lightning/browser/image/ImageLoader;", "getImageLoader$app_lightningPlusDebug", "()Lacr/browser/lightning/browser/image/ImageLoader;", "setImageLoader$app_lightningPlusDebug", "(Lacr/browser/lightning/browser/image/ImageLoader;)V", "inputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "getInputMethodManager$app_lightningPlusDebug", "()Landroid/view/inputmethod/InputMethodManager;", "setInputMethodManager$app_lightningPlusDebug", "(Landroid/view/inputmethod/InputMethodManager;)V", "intentExtractor", "Lacr/browser/lightning/browser/search/IntentExtractor;", "getIntentExtractor$app_lightningPlusDebug", "()Lacr/browser/lightning/browser/search/IntentExtractor;", "setIntentExtractor$app_lightningPlusDebug", "(Lacr/browser/lightning/browser/search/IntentExtractor;)V", "keyEventAdapter", "Lacr/browser/lightning/browser/keys/KeyEventAdapter;", "getKeyEventAdapter$app_lightningPlusDebug", "()Lacr/browser/lightning/browser/keys/KeyEventAdapter;", "setKeyEventAdapter$app_lightningPlusDebug", "(Lacr/browser/lightning/browser/keys/KeyEventAdapter;)V", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "getLauncher$annotations", "lightningDialogBuilder", "Lacr/browser/lightning/dialog/LightningDialogBuilder;", "getLightningDialogBuilder$app_lightningPlusDebug", "()Lacr/browser/lightning/dialog/LightningDialogBuilder;", "setLightningDialogBuilder$app_lightningPlusDebug", "(Lacr/browser/lightning/dialog/LightningDialogBuilder;)V", "menuItemAdapter", "Lacr/browser/lightning/browser/menu/MenuItemAdapter;", "getMenuItemAdapter$app_lightningPlusDebug", "()Lacr/browser/lightning/browser/menu/MenuItemAdapter;", "setMenuItemAdapter$app_lightningPlusDebug", "(Lacr/browser/lightning/browser/menu/MenuItemAdapter;)V", "menuItemAddBookmark", "Landroid/view/MenuItem;", "menuItemAddToHome", "menuItemCopyLink", "menuItemReaderMode", "menuItemShare", "presenter", "Lacr/browser/lightning/browser/BrowserPresenter;", "getPresenter$app_lightningPlusDebug", "()Lacr/browser/lightning/browser/BrowserPresenter;", "setPresenter$app_lightningPlusDebug", "(Lacr/browser/lightning/browser/BrowserPresenter;)V", "proxyUtils", "Lacr/browser/lightning/utils/ProxyUtils;", "getProxyUtils$app_lightningPlusDebug", "()Lacr/browser/lightning/utils/ProxyUtils;", "setProxyUtils$app_lightningPlusDebug", "(Lacr/browser/lightning/utils/ProxyUtils;)V", "tabPager", "Lacr/browser/lightning/browser/tab/TabPager;", "getTabPager$app_lightningPlusDebug", "()Lacr/browser/lightning/browser/tab/TabPager;", "setTabPager$app_lightningPlusDebug", "(Lacr/browser/lightning/browser/tab/TabPager;)V", "tabsAdapter", "Landroidx/recyclerview/widget/ListAdapter;", "Lacr/browser/lightning/browser/tab/TabViewState;", "Lacr/browser/lightning/browser/tab/TabViewHolder;", "uiConfiguration", "Lacr/browser/lightning/browser/ui/UiConfiguration;", "getUiConfiguration$app_lightningPlusDebug", "()Lacr/browser/lightning/browser/ui/UiConfiguration;", "setUiConfiguration$app_lightningPlusDebug", "(Lacr/browser/lightning/browser/ui/UiConfiguration;)V", "animateColorChange", "", "color", "clearSearchFocus", "closeBookmarkDrawer", "closeTabDrawer", "hideCustomView", "homeIcon", "isIncognito", "", "menu", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "Landroid/view/Menu;", "onDestroy", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onNewIntent", "intent", "onOptionsItemSelected", "item", "onPause", "openBookmarkDrawer", "openTabDrawer", "renderState", "viewState", "Lacr/browser/lightning/browser/PartialBrowserViewState;", "renderTabs", "tabListState", "", "setFullscreen", "enabled", "immersive", "showAddBookmarkDialog", "title", "", "url", "folders", "showBookmarkOptionsDialog", "bookmark", "Lacr/browser/lightning/database/Bookmark$Entry;", "showCloseBrowserDialog", "id", "showCustomView", "view", "showDownloadOptionsDialog", "download", "Lacr/browser/lightning/database/downloads/DownloadEntry;", "showEditBookmarkDialog", "folder", "showEditFolderDialog", "oldTitle", "showFileChooser", "showFindInPageDialog", "showFolderOptionsDialog", "Lacr/browser/lightning/database/Bookmark$Folder;", "showHistoryOptionsDialog", "historyEntry", "Lacr/browser/lightning/database/HistoryEntry;", "showImageLongPressDialog", "longPress", "Lacr/browser/lightning/browser/view/targetUrl/LongPress;", "showLinkLongPressDialog", "showLocalFileBlockedDialog", "showToolbar", "showToolsDialog", "areAdsAllowed", "shouldShowAdBlockOption", "updateVisibilityForDrawable", "Landroid/widget/ImageView;", "app_lightningPlusDebug"})
public abstract class BrowserActivity extends acr.browser.lightning.ThemableBrowserActivity {
    private acr.browser.lightning.databinding.BrowserActivityBinding binding;
    private androidx.recyclerview.widget.ListAdapter<acr.browser.lightning.browser.tab.TabViewState, acr.browser.lightning.browser.tab.TabViewHolder> tabsAdapter;
    private acr.browser.lightning.browser.bookmark.BookmarkRecyclerViewAdapter bookmarksAdapter;
    private android.view.MenuItem menuItemShare;
    private android.view.MenuItem menuItemCopyLink;
    private android.view.MenuItem menuItemAddToHome;
    private android.view.MenuItem menuItemAddBookmark;
    private android.view.MenuItem menuItemReaderMode;
    private final kotlin.Lazy defaultColor$delegate = null;
    private final kotlin.Lazy backgroundDrawable$delegate = null;
    private android.view.View customView;
    private final androidx.activity.result.ActivityResultLauncher<android.content.Intent> launcher = null;
    @javax.inject.Inject()
    public acr.browser.lightning.browser.image.ImageLoader imageLoader;
    @javax.inject.Inject()
    public acr.browser.lightning.browser.keys.KeyEventAdapter keyEventAdapter;
    @javax.inject.Inject()
    public acr.browser.lightning.browser.menu.MenuItemAdapter menuItemAdapter;
    @javax.inject.Inject()
    public android.view.inputmethod.InputMethodManager inputMethodManager;
    @javax.inject.Inject()
    public acr.browser.lightning.browser.BrowserPresenter presenter;
    @javax.inject.Inject()
    public acr.browser.lightning.browser.tab.TabPager tabPager;
    @javax.inject.Inject()
    public acr.browser.lightning.browser.search.IntentExtractor intentExtractor;
    @javax.inject.Inject()
    public acr.browser.lightning.dialog.LightningDialogBuilder lightningDialogBuilder;
    @javax.inject.Inject()
    public acr.browser.lightning.browser.ui.UiConfiguration uiConfiguration;
    @javax.inject.Inject()
    public acr.browser.lightning.utils.ProxyUtils proxyUtils;
    private java.util.HashMap _$_findViewCache;
    
    private final int getDefaultColor() {
        return 0;
    }
    
    private final android.graphics.drawable.ColorDrawable getBackgroundDrawable() {
        return null;
    }
    
    @kotlin.Suppress(names = {"ConvertLambdaToReference"})
    @java.lang.Deprecated()
    private static void getLauncher$annotations() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.image.ImageLoader getImageLoader$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setImageLoader$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.image.ImageLoader p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.keys.KeyEventAdapter getKeyEventAdapter$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setKeyEventAdapter$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.keys.KeyEventAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.menu.MenuItemAdapter getMenuItemAdapter$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setMenuItemAdapter$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.menu.MenuItemAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.view.inputmethod.InputMethodManager getInputMethodManager$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setInputMethodManager$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    android.view.inputmethod.InputMethodManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.BrowserPresenter getPresenter$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setPresenter$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.BrowserPresenter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.tab.TabPager getTabPager$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setTabPager$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.tab.TabPager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.search.IntentExtractor getIntentExtractor$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setIntentExtractor$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.search.IntentExtractor p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.dialog.LightningDialogBuilder getLightningDialogBuilder$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setLightningDialogBuilder$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.dialog.LightningDialogBuilder p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.browser.ui.UiConfiguration getUiConfiguration$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setUiConfiguration$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.ui.UiConfiguration p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.utils.ProxyUtils getProxyUtils$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setProxyUtils$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.utils.ProxyUtils p0) {
    }
    
    /**
     * True if the activity is operating in incognito mode, false otherwise.
     */
    public abstract boolean isIncognito();
    
    /**
     * Provide the menu used by the browser instance.
     */
    @androidx.annotation.MenuRes()
    public abstract int menu();
    
    /**
     * Provide the home icon used by the browser instance.
     */
    @androidx.annotation.DrawableRes()
    public abstract int homeIcon();
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onKeyUp(int keyCode, @org.jetbrains.annotations.NotNull()
    android.view.KeyEvent event) {
        return false;
    }
    
    /**
     * @see BrowserContract.View.renderState
     */
    public final void renderState(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.PartialBrowserViewState viewState) {
    }
    
    /**
     * @see BrowserContract.View.renderTabs
     */
    public final void renderTabs(@org.jetbrains.annotations.NotNull()
    java.util.List<acr.browser.lightning.browser.tab.TabViewState> tabListState) {
    }
    
    /**
     * @see BrowserContract.View.showAddBookmarkDialog
     */
    public final void showAddBookmarkDialog(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> folders) {
    }
    
    /**
     * @see BrowserContract.View.showBookmarkOptionsDialog
     */
    public final void showBookmarkOptionsDialog(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Entry bookmark) {
    }
    
    /**
     * @see BrowserContract.View.showEditBookmarkDialog
     */
    public final void showEditBookmarkDialog(@org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    java.lang.String folder, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> folders) {
    }
    
    /**
     * @see BrowserContract.View.showFolderOptionsDialog
     */
    public final void showFolderOptionsDialog(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.Bookmark.Folder folder) {
    }
    
    /**
     * @see BrowserContract.View.showEditFolderDialog
     */
    public final void showEditFolderDialog(@org.jetbrains.annotations.NotNull()
    java.lang.String oldTitle) {
    }
    
    /**
     * @see BrowserContract.View.showDownloadOptionsDialog
     */
    public final void showDownloadOptionsDialog(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.downloads.DownloadEntry download) {
    }
    
    /**
     * @see BrowserContract.View.showHistoryOptionsDialog
     */
    public final void showHistoryOptionsDialog(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.HistoryEntry historyEntry) {
    }
    
    /**
     * @see BrowserContract.View.showFindInPageDialog
     */
    public final void showFindInPageDialog() {
    }
    
    /**
     * @see BrowserContract.View.showLinkLongPressDialog
     */
    public final void showLinkLongPressDialog(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.view.targetUrl.LongPress longPress) {
    }
    
    /**
     * @see BrowserContract.View.showImageLongPressDialog
     */
    public final void showImageLongPressDialog(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.browser.view.targetUrl.LongPress longPress) {
    }
    
    /**
     * @see BrowserContract.View.showCloseBrowserDialog
     */
    public final void showCloseBrowserDialog(int id) {
    }
    
    /**
     * @see BrowserContract.View.openBookmarkDrawer
     */
    public final void openBookmarkDrawer() {
    }
    
    /**
     * @see BrowserContract.View.closeBookmarkDrawer
     */
    public final void closeBookmarkDrawer() {
    }
    
    /**
     * @see BrowserContract.View.openTabDrawer
     */
    public final void openTabDrawer() {
    }
    
    /**
     * @see BrowserContract.View.closeTabDrawer
     */
    public final void closeTabDrawer() {
    }
    
    /**
     * @see BrowserContract.View.showToolbar
     */
    public final void showToolbar() {
    }
    
    /**
     * @see BrowserContract.View.showToolsDialog
     */
    public final void showToolsDialog(boolean areAdsAllowed, boolean shouldShowAdBlockOption) {
    }
    
    /**
     * @see BrowserContract.View.showLocalFileBlockedDialog
     */
    public final void showLocalFileBlockedDialog() {
    }
    
    /**
     * @see BrowserContract.View.showFileChooser
     */
    public final void showFileChooser(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
    }
    
    /**
     * @see BrowserContract.View.showCustomView
     */
    public final void showCustomView(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    /**
     * @see BrowserContract.View.hideCustomView
     */
    public final void hideCustomView() {
    }
    
    /**
     * @see BrowserContract.View.clearSearchFocus
     */
    public final void clearSearchFocus() {
    }
    
    private final void setFullscreen(boolean enabled, boolean immersive) {
    }
    
    private final void animateColorChange(int color) {
    }
    
    private final void updateVisibilityForDrawable(android.widget.ImageView $this$updateVisibilityForDrawable) {
    }
    
    public BrowserActivity() {
        super();
    }
}