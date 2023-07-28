package acr.browser.lightning.ssl;

import java.lang.System;

/**
 * An interface to remember the chosen browsing behavior when handling SSL warnings.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\n"}, d2 = {"Lacr/browser/lightning/ssl/SslWarningPreferences;", "", "recallBehaviorForDomain", "Lacr/browser/lightning/ssl/SslWarningPreferences$Behavior;", "url", "", "rememberBehaviorForDomain", "", "behavior", "Behavior", "app_lightningLiteDebug"})
public abstract interface SslWarningPreferences {
    
    /**
     * Remember the provided [behavior] for the given [url]. The behavior will be assigned to the
     * domain of the URL.
     */
    public abstract void rememberBehaviorForDomain(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.ssl.SslWarningPreferences.Behavior behavior);
    
    /**
     * Recall the [Behavior] for the provided [url]. If there was no behavior to be remembered, then
     * this function will return `null`.
     */
    @org.jetbrains.annotations.Nullable()
    public abstract acr.browser.lightning.ssl.SslWarningPreferences.Behavior recallBehaviorForDomain(@org.jetbrains.annotations.Nullable()
    java.lang.String url);
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/ssl/SslWarningPreferences$Behavior;", "", "(Ljava/lang/String;I)V", "PROCEED", "CANCEL", "app_lightningLiteDebug"})
    public static enum Behavior {
        /*public static final*/ PROCEED /* = new PROCEED() */,
        /*public static final*/ CANCEL /* = new CANCEL() */;
        
        Behavior() {
        }
    }
}