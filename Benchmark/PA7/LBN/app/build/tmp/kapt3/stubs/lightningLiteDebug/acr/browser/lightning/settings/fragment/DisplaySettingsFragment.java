package acr.browser.lightning.settings.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\f\u0010\u0013\u001a\u00020\u0014*\u00020\u0015H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lacr/browser/lightning/settings/fragment/DisplaySettingsFragment;", "Lacr/browser/lightning/settings/fragment/AbstractSettingsFragment;", "()V", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "getUserPreferences$app_lightningLiteDebug", "()Lacr/browser/lightning/preference/UserPreferences;", "setUserPreferences$app_lightningLiteDebug", "(Lacr/browser/lightning/preference/UserPreferences;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "providePreferencesXmlResource", "", "showTextSizePicker", "showThemePicker", "summaryUpdater", "Lacr/browser/lightning/settings/fragment/SummaryUpdater;", "toDisplayString", "", "Lacr/browser/lightning/AppTheme;", "Companion", "TextSeekBarListener", "app_lightningLiteDebug"})
public final class DisplaySettingsFragment extends acr.browser.lightning.settings.fragment.AbstractSettingsFragment {
    @javax.inject.Inject()
    public acr.browser.lightning.preference.UserPreferences userPreferences;
    private static final java.lang.String SETTINGS_HIDESTATUSBAR = "fullScreenOption";
    private static final java.lang.String SETTINGS_FULLSCREEN = "fullscreen";
    private static final java.lang.String SETTINGS_VIEWPORT = "wideViewPort";
    private static final java.lang.String SETTINGS_OVERVIEWMODE = "overViewMode";
    private static final java.lang.String SETTINGS_REFLOW = "text_reflow";
    private static final java.lang.String SETTINGS_THEME = "app_theme";
    private static final java.lang.String SETTINGS_TEXTSIZE = "text_size";
    private static final java.lang.String SETTINGS_DRAWERTABS = "cb_drawertabs";
    private static final java.lang.String SETTINGS_SWAPTABS = "cb_swapdrawers";
    private static final java.lang.String SETTINGS_BLACK_STATUS = "black_status_bar";
    private static final float XX_LARGE = 30.0F;
    private static final float X_LARGE = 26.0F;
    private static final float LARGE = 22.0F;
    private static final float MEDIUM = 18.0F;
    private static final float SMALL = 14.0F;
    private static final float X_SMALL = 10.0F;
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.settings.fragment.DisplaySettingsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.preference.UserPreferences getUserPreferences$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setUserPreferences$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences p0) {
    }
    
    @java.lang.Override()
    protected int providePreferencesXmlResource() {
        return 0;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showTextSizePicker() {
    }
    
    private final void showThemePicker(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final java.lang.String toDisplayString(acr.browser.lightning.AppTheme $this$toDisplayString) {
        return null;
    }
    
    public DisplaySettingsFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lacr/browser/lightning/settings/fragment/DisplaySettingsFragment$TextSeekBarListener;", "Landroid/widget/SeekBar$OnSeekBarChangeListener;", "sampleText", "Landroid/widget/TextView;", "(Landroid/widget/TextView;)V", "onProgressChanged", "", "view", "Landroid/widget/SeekBar;", "size", "", "user", "", "onStartTrackingTouch", "arg0", "onStopTrackingTouch", "app_lightningLiteDebug"})
    static final class TextSeekBarListener implements android.widget.SeekBar.OnSeekBarChangeListener {
        private final android.widget.TextView sampleText = null;
        
        @java.lang.Override()
        public void onProgressChanged(@org.jetbrains.annotations.NotNull()
        android.widget.SeekBar view, int size, boolean user) {
        }
        
        @java.lang.Override()
        public void onStartTrackingTouch(@org.jetbrains.annotations.NotNull()
        android.widget.SeekBar arg0) {
        }
        
        @java.lang.Override()
        public void onStopTrackingTouch(@org.jetbrains.annotations.NotNull()
        android.widget.SeekBar arg0) {
        }
        
        public TextSeekBarListener(@org.jetbrains.annotations.NotNull()
        android.widget.TextView sampleText) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lacr/browser/lightning/settings/fragment/DisplaySettingsFragment$Companion;", "", "()V", "LARGE", "", "MEDIUM", "SETTINGS_BLACK_STATUS", "", "SETTINGS_DRAWERTABS", "SETTINGS_FULLSCREEN", "SETTINGS_HIDESTATUSBAR", "SETTINGS_OVERVIEWMODE", "SETTINGS_REFLOW", "SETTINGS_SWAPTABS", "SETTINGS_TEXTSIZE", "SETTINGS_THEME", "SETTINGS_VIEWPORT", "SMALL", "XX_LARGE", "X_LARGE", "X_SMALL", "getTextSize", "size", "", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private final float getTextSize(int size) {
            return 0.0F;
        }
        
        private Companion() {
            super();
        }
    }
}