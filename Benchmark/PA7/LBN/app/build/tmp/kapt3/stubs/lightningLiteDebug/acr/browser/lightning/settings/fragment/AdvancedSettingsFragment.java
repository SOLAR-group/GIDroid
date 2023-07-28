package acr.browser.lightning.settings.fragment;

import java.lang.System;

/**
 * The advanced settings of the app.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0016H\u0002J\f\u0010\u0014\u001a\u00020\u0015*\u00020\u0017H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0019"}, d2 = {"Lacr/browser/lightning/settings/fragment/AdvancedSettingsFragment;", "Lacr/browser/lightning/settings/fragment/AbstractSettingsFragment;", "()V", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "getUserPreferences$app_lightningLiteDebug", "()Lacr/browser/lightning/preference/UserPreferences;", "setUserPreferences$app_lightningLiteDebug", "(Lacr/browser/lightning/preference/UserPreferences;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "providePreferencesXmlResource", "", "showRenderingDialogPicker", "summaryUpdater", "Lacr/browser/lightning/settings/fragment/SummaryUpdater;", "showTextEncodingDialogPicker", "showUrlBoxDialogPicker", "toDisplayString", "", "Lacr/browser/lightning/browser/search/SearchBoxDisplayChoice;", "Lacr/browser/lightning/browser/view/RenderingMode;", "Companion", "app_lightningLiteDebug"})
public final class AdvancedSettingsFragment extends acr.browser.lightning.settings.fragment.AbstractSettingsFragment {
    @javax.inject.Inject()
    public acr.browser.lightning.preference.UserPreferences userPreferences;
    private static final java.lang.String SETTINGS_NEW_WINDOW = "allow_new_window";
    private static final java.lang.String SETTINGS_ENABLE_COOKIES = "allow_cookies";
    private static final java.lang.String SETTINGS_COOKIES_INCOGNITO = "incognito_cookies";
    private static final java.lang.String SETTINGS_RESTORE_TABS = "restore_tabs";
    private static final java.lang.String SETTINGS_RENDERING_MODE = "rendering_mode";
    private static final java.lang.String SETTINGS_URL_CONTENT = "url_contents";
    private static final java.lang.String SETTINGS_TEXT_ENCODING = "text_encoding";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.settings.fragment.AdvancedSettingsFragment.Companion Companion = null;
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
    
    /**
     * Shows the dialog which allows the user to choose the browser's rendering method.
     *
     * @param summaryUpdater the command which allows the summary to be updated.
     */
    private final void showRenderingDialogPicker(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    /**
     * Shows the dialog which allows the user to choose the browser's text encoding.
     *
     * @param summaryUpdater the command which allows the summary to be updated.
     */
    private final void showTextEncodingDialogPicker(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    /**
     * Shows the dialog which allows the user to choose the browser's URL box display options.
     *
     * @param summaryUpdater the command which allows the summary to be updated.
     */
    private final void showUrlBoxDialogPicker(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final java.lang.String toDisplayString(acr.browser.lightning.browser.search.SearchBoxDisplayChoice $this$toDisplayString) {
        return null;
    }
    
    private final java.lang.String toDisplayString(acr.browser.lightning.browser.view.RenderingMode $this$toDisplayString) {
        return null;
    }
    
    public AdvancedSettingsFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lacr/browser/lightning/settings/fragment/AdvancedSettingsFragment$Companion;", "", "()V", "SETTINGS_COOKIES_INCOGNITO", "", "SETTINGS_ENABLE_COOKIES", "SETTINGS_NEW_WINDOW", "SETTINGS_RENDERING_MODE", "SETTINGS_RESTORE_TABS", "SETTINGS_TEXT_ENCODING", "SETTINGS_URL_CONTENT", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}