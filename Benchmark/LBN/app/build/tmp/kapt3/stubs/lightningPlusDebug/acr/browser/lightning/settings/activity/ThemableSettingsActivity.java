package acr.browser.lightning.settings.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0014J\b\u0010\u0010\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0005\u001a\u00020\u00068\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lacr/browser/lightning/settings/activity/ThemableSettingsActivity;", "Lacr/browser/lightning/settings/activity/AppCompatPreferenceActivity;", "()V", "themeId", "Lacr/browser/lightning/AppTheme;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "getUserPreferences$app_lightningPlusDebug", "()Lacr/browser/lightning/preference/UserPreferences;", "setUserPreferences$app_lightningPlusDebug", "(Lacr/browser/lightning/preference/UserPreferences;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "resetPreferences", "app_lightningPlusDebug"})
public abstract class ThemableSettingsActivity extends acr.browser.lightning.settings.activity.AppCompatPreferenceActivity {
    private acr.browser.lightning.AppTheme themeId = acr.browser.lightning.AppTheme.LIGHT;
    @javax.inject.Inject()
    public acr.browser.lightning.preference.UserPreferences userPreferences;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.preference.UserPreferences getUserPreferences$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setUserPreferences$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void resetPreferences() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    public ThemableSettingsActivity() {
        super();
    }
}