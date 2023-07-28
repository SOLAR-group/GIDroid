package acr.browser.lightning.extensions;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 2, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"snackbar", "", "Landroid/app/Activity;", "resource", "", "message", "", "app_lightningPlusDebug"})
public final class ActivityExtensions {
    
    /**
     * Displays a snackbar to the user with a [StringRes] message.
     *
     * NOTE: If there is an accessibility manager enabled on
     * the device, such as LastPass, then the snackbar animations
     * will not work.
     *
     * @param resource the string resource to display to the user.
     */
    public static final void snackbar(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$snackbar, @androidx.annotation.StringRes()
    int resource) {
    }
    
    /**
     * Display a snackbar to the user with a [String] message.
     *
     * @param message the message to display to the user.
     * @see snackbar
     */
    public static final void snackbar(@org.jetbrains.annotations.NotNull()
    android.app.Activity $this$snackbar, @org.jetbrains.annotations.NotNull()
    java.lang.String message) {
    }
}