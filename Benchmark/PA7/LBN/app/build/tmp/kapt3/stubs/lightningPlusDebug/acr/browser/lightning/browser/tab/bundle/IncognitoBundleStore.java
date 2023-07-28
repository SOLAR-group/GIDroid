package acr.browser.lightning.browser.tab.bundle;

import java.lang.System;

/**
 * A bundle store implementation that no-ops for for incognito mode.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0006H\u0016\u00a8\u0006\u000b"}, d2 = {"Lacr/browser/lightning/browser/tab/bundle/IncognitoBundleStore;", "Lacr/browser/lightning/browser/tab/bundle/BundleStore;", "()V", "deleteAll", "", "retrieve", "", "Lacr/browser/lightning/browser/tab/TabInitializer;", "save", "tabs", "Lacr/browser/lightning/browser/tab/TabModel;", "app_lightningPlusDebug"})
public final class IncognitoBundleStore implements acr.browser.lightning.browser.tab.bundle.BundleStore {
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.browser.tab.bundle.IncognitoBundleStore INSTANCE = null;
    
    @java.lang.Override()
    public void save(@org.jetbrains.annotations.NotNull()
    java.util.List<? extends acr.browser.lightning.browser.tab.TabModel> tabs) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.util.List<acr.browser.lightning.browser.tab.TabInitializer> retrieve() {
        return null;
    }
    
    @java.lang.Override()
    public void deleteAll() {
    }
    
    private IncognitoBundleStore() {
        super();
    }
}