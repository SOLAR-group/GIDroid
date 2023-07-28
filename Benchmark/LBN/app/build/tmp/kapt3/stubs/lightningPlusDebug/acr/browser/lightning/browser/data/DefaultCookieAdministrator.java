package acr.browser.lightning.browser.data;

import java.lang.System;

/**
 * The default cookie administrator that sets cookie preferences for the default browser instance.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lacr/browser/lightning/browser/data/DefaultCookieAdministrator;", "Lacr/browser/lightning/browser/data/CookieAdministrator;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "(Lacr/browser/lightning/preference/UserPreferences;)V", "adjustCookieSettings", "", "app_lightningPlusDebug"})
public final class DefaultCookieAdministrator implements acr.browser.lightning.browser.data.CookieAdministrator {
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    
    @java.lang.Override()
    public void adjustCookieSettings() {
    }
    
    @javax.inject.Inject()
    public DefaultCookieAdministrator(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences) {
        super();
    }
}