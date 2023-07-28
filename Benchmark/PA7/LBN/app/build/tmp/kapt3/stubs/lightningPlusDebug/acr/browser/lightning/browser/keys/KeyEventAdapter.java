package acr.browser.lightning.browser.keys;

import java.lang.System;

/**
 * Adapts [KeyEvents][KeyEvent] to [KeyCombos][KeyCombo].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/browser/keys/KeyEventAdapter;", "", "()V", "adaptKeyEvent", "Lacr/browser/lightning/browser/keys/KeyCombo;", "event", "Landroid/view/KeyEvent;", "app_lightningPlusDebug"})
public final class KeyEventAdapter {
    
    /**
     * Adapt the [event] or return null if the key combo is unsupported.
     */
    @org.jetbrains.annotations.Nullable()
    public final acr.browser.lightning.browser.keys.KeyCombo adaptKeyEvent(@org.jetbrains.annotations.NotNull()
    android.view.KeyEvent event) {
        return null;
    }
    
    @javax.inject.Inject()
    public KeyEventAdapter() {
        super();
    }
}