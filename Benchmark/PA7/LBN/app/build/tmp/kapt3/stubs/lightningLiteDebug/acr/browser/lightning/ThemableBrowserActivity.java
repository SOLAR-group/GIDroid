package acr.browser.lightning;

import java.lang.System;

/**
 * A theme aware activity that updates its theme based on the user preferences.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0014J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u000fH\u0014J\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0015\u00a2\u0006\u0002\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u000fH\u0002J\b\u0010\u001d\u001a\u00020\u000fH\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u00020\t8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lacr/browser/lightning/ThemableBrowserActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "shouldRunOnResumeActions", "", "showTabsInDrawer", "themeId", "Lacr/browser/lightning/AppTheme;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "getUserPreferences$app_lightningLiteDebug", "()Lacr/browser/lightning/preference/UserPreferences;", "setUserPreferences$app_lightningLiteDebug", "(Lacr/browser/lightning/preference/UserPreferences;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onResume", "onWindowFocusChanged", "hasFocus", "onWindowVisibleToUserAfterResume", "provideThemeOverride", "", "()Ljava/lang/Integer;", "resetPreferences", "restart", "app_lightningLiteDebug"})
public abstract class ThemableBrowserActivity extends androidx.appcompat.app.AppCompatActivity {
    @javax.inject.Inject()
    public acr.browser.lightning.preference.UserPreferences userPreferences;
    private acr.browser.lightning.AppTheme themeId = acr.browser.lightning.AppTheme.LIGHT;
    private boolean showTabsInDrawer = false;
    private boolean shouldRunOnResumeActions = false;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.preference.UserPreferences getUserPreferences$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setUserPreferences$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences p0) {
    }
    
    /**
     * Override this to provide an alternate theme that should be set for every instance of this
     * activity regardless of the user's preference.
     */
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.StyleRes()
    protected java.lang.Integer provideThemeOverride() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu) {
        return false;
    }
    
    private final void resetPreferences() {
    }
    
    @java.lang.Override()
    public void onWindowFocusChanged(boolean hasFocus) {
    }
    
    /**
     * Called after the activity is resumed
     * and the UI becomes visible to the user.
     * Called by onWindowFocusChanged only if
     * onResume has been called.
     */
    protected void onWindowVisibleToUserAfterResume() {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    protected final void restart() {
    }
    
    public ThemableBrowserActivity() {
        super();
    }
}