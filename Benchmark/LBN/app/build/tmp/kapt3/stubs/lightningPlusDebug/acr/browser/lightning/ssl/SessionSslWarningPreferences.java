package acr.browser.lightning.ssl;

import java.lang.System;

/**
 * An implementation of [SslWarningPreferences] which stores user preferences in memory and does not
 * persist them past an app restart.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0005H\u0016J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0006H\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lacr/browser/lightning/ssl/SessionSslWarningPreferences;", "Lacr/browser/lightning/ssl/SslWarningPreferences;", "()V", "ignoredSslWarnings", "Ljava/util/HashMap;", "", "Lacr/browser/lightning/ssl/SslWarningPreferences$Behavior;", "recallBehaviorForDomain", "url", "rememberBehaviorForDomain", "", "behavior", "app_lightningPlusDebug"})
@javax.inject.Singleton()
public final class SessionSslWarningPreferences implements acr.browser.lightning.ssl.SslWarningPreferences {
    private final java.util.HashMap<java.lang.String, acr.browser.lightning.ssl.SslWarningPreferences.Behavior> ignoredSslWarnings = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public acr.browser.lightning.ssl.SslWarningPreferences.Behavior recallBehaviorForDomain(@org.jetbrains.annotations.Nullable()
    java.lang.String url) {
        return null;
    }
    
    @java.lang.Override()
    public void rememberBehaviorForDomain(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.ssl.SslWarningPreferences.Behavior behavior) {
    }
    
    @javax.inject.Inject()
    public SessionSslWarningPreferences() {
        super();
    }
}