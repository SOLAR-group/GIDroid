package acr.browser.lightning.browser.theme;

import java.lang.System;

/**
 * Provides themed attributes.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0003H\'\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/browser/theme/ThemeProvider;", "", "color", "", "attrRes", "app_lightningLiteDebug"})
public abstract interface ThemeProvider {
    
    /**
     * Provide a themed color attribute.
     */
    @androidx.annotation.ColorInt()
    public abstract int color(@androidx.annotation.AttrRes()
    int attrRes);
}