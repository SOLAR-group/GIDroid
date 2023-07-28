package acr.browser.lightning.browser.data;

import java.lang.System;

/**
 * The administrator used to manage browser cookie preferences.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&\u00a8\u0006\u0004"}, d2 = {"Lacr/browser/lightning/browser/data/CookieAdministrator;", "", "adjustCookieSettings", "", "app_lightningLiteDebug"})
public abstract interface CookieAdministrator {
    
    /**
     * Adjust the cookie setting based on the current preferences.
     */
    public abstract void adjustCookieSettings();
}