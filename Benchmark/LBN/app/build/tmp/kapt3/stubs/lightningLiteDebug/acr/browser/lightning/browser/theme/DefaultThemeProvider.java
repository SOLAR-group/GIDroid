package acr.browser.lightning.browser.theme;

import java.lang.System;

/**
 * The default theme attribute provider that delegates to the activity.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lacr/browser/lightning/browser/theme/DefaultThemeProvider;", "Lacr/browser/lightning/browser/theme/ThemeProvider;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "color", "", "attrRes", "app_lightningLiteDebug"})
public final class DefaultThemeProvider implements acr.browser.lightning.browser.theme.ThemeProvider {
    private final android.app.Activity activity = null;
    
    @java.lang.Override()
    public int color(int attrRes) {
        return 0;
    }
    
    @javax.inject.Inject()
    public DefaultThemeProvider(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        super();
    }
}