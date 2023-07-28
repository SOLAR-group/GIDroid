package acr.browser.lightning.browser.menu;

import java.lang.System;

/**
 * Adapts a click on a menu item to a [MenuSelection].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/browser/menu/MenuItemAdapter;", "", "()V", "adaptMenuItem", "Lacr/browser/lightning/browser/menu/MenuSelection;", "menuItem", "Landroid/view/MenuItem;", "app_lightningLiteDebug"})
public final class MenuItemAdapter {
    
    /**
     * Adapt the [menuItem] or return null if the item is unsupported.
     */
    @org.jetbrains.annotations.Nullable()
    public final acr.browser.lightning.browser.menu.MenuSelection adaptMenuItem(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem menuItem) {
        return null;
    }
    
    @javax.inject.Inject()
    public MenuItemAdapter() {
        super();
    }
}