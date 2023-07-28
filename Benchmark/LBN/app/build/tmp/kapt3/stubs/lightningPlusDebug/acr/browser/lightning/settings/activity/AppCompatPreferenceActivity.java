package acr.browser.lightning.settings.activity;

import java.lang.System;

/**
 * A [android.preference.PreferenceActivity] which implements and proxies the necessary calls
 * to be used with AppCompat.
 *
 * This technique can be used with an [android.app.Activity] class, not just
 * [android.preference.PreferenceActivity].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u000f\u001a\u00020\u0006H\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0006H\u0014J\b\u0010\u0017\u001a\u00020\u0006H\u0014J\u0012\u0010\u0018\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0019\u001a\u00020\u0006H\u0014J\b\u0010\u001a\u001a\u00020\u0006H\u0014J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0014J\u0010\u0010 \u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010 \u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010 \u001a\u00020\u00062\b\b\u0001\u0010!\u001a\u00020\u001fH\u0016J\u0010\u0010\"\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010$R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006%"}, d2 = {"Lacr/browser/lightning/settings/activity/AppCompatPreferenceActivity;", "Landroid/preference/PreferenceActivity;", "()V", "delegate", "Landroidx/appcompat/app/AppCompatDelegate;", "addContentView", "", "view", "Landroid/view/View;", "params", "Landroid/view/ViewGroup$LayoutParams;", "getMenuInflater", "Landroid/view/MenuInflater;", "getSupportActionBar", "Landroidx/appcompat/app/ActionBar;", "invalidateOptionsMenu", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onPostCreate", "onPostResume", "onStop", "onTitleChanged", "title", "", "color", "", "setContentView", "layoutResID", "setSupportActionbar", "toolbar", "Landroidx/appcompat/widget/Toolbar;", "app_lightningPlusDebug"})
public abstract class AppCompatPreferenceActivity extends android.preference.PreferenceActivity {
    private androidx.appcompat.app.AppCompatDelegate delegate;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onPostCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void setSupportActionbar(@org.jetbrains.annotations.Nullable()
    androidx.appcompat.widget.Toolbar toolbar) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.appcompat.app.ActionBar getSupportActionBar() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.MenuInflater getMenuInflater() {
        return null;
    }
    
    @java.lang.Override()
    public void setContentView(@androidx.annotation.LayoutRes()
    int layoutResID) {
    }
    
    @java.lang.Override()
    public void setContentView(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    @java.lang.Override()
    public void setContentView(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup.LayoutParams params) {
    }
    
    @java.lang.Override()
    public void addContentView(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup.LayoutParams params) {
    }
    
    @java.lang.Override()
    protected void onPostResume() {
    }
    
    @java.lang.Override()
    protected void onTitleChanged(@org.jetbrains.annotations.NotNull()
    java.lang.CharSequence title, int color) {
    }
    
    @java.lang.Override()
    public void onConfigurationChanged(@org.jetbrains.annotations.NotNull()
    android.content.res.Configuration newConfig) {
    }
    
    @java.lang.Override()
    protected void onPause() {
    }
    
    @java.lang.Override()
    protected void onStop() {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    @java.lang.Override()
    public void invalidateOptionsMenu() {
    }
    
    public AppCompatPreferenceActivity() {
        super();
    }
}