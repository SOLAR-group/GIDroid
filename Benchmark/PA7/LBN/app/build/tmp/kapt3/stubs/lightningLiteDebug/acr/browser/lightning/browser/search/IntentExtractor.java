package acr.browser.lightning.browser.search;

import java.lang.System;

/**
 * Extracts data from an [Intent] and into a [BrowserContract.Action].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lacr/browser/lightning/browser/search/IntentExtractor;", "", "searchEngineProvider", "Lacr/browser/lightning/search/SearchEngineProvider;", "(Lacr/browser/lightning/search/SearchEngineProvider;)V", "extractSearchFromIntent", "", "intent", "Landroid/content/Intent;", "extractUrlFromIntent", "Lacr/browser/lightning/browser/BrowserContract$Action;", "Companion", "app_lightningLiteDebug"})
public final class IntentExtractor {
    private final acr.browser.lightning.search.SearchEngineProvider searchEngineProvider = null;
    private static final java.lang.String INTENT_PANIC_TRIGGER = "info.guardianproject.panic.action.TRIGGER";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.browser.search.IntentExtractor.Companion Companion = null;
    
    /**
     * Extract the action from the [intent] or return null if no data was extracted.
     */
    @org.jetbrains.annotations.Nullable()
    public final acr.browser.lightning.browser.BrowserContract.Action extractUrlFromIntent(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
        return null;
    }
    
    private final java.lang.String extractSearchFromIntent(android.content.Intent intent) {
        return null;
    }
    
    @javax.inject.Inject()
    public IntentExtractor(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.search.SearchEngineProvider searchEngineProvider) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/browser/search/IntentExtractor$Companion;", "", "()V", "INTENT_PANIC_TRIGGER", "", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}