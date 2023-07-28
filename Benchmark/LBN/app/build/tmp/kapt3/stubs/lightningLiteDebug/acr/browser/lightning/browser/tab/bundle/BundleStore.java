package acr.browser.lightning.browser.tab.bundle;

import java.lang.System;

/**
 * Used to save tab data for future restoration when the browser goes into hibernation.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0005H&\u00a8\u0006\n"}, d2 = {"Lacr/browser/lightning/browser/tab/bundle/BundleStore;", "", "deleteAll", "", "retrieve", "", "Lacr/browser/lightning/browser/tab/TabInitializer;", "save", "tabs", "Lacr/browser/lightning/browser/tab/TabModel;", "app_lightningLiteDebug"})
public abstract interface BundleStore {
    
    /**
     * Save the tab data for the list of [tabs].
     */
    public abstract void save(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends acr.browser.lightning.browser.tab.TabModel> tabs);
    
    /**
     * Synchronously previously stored tab data.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract java.util.List<acr.browser.lightning.browser.tab.TabInitializer> retrieve();
    
    /**
     * Synchronously delete all stored tabs.
     */
    public abstract void deleteAll();
}