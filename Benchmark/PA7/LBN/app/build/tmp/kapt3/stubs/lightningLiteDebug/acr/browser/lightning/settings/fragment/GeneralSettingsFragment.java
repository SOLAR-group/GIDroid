package acr.browser.lightning.settings.fragment;

import java.lang.System;

/**
 * The general settings of the app.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 <2\u00020\u0001:\u0002<=B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00042\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002\u00a2\u0006\u0002\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0015H\u0014J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010&\u001a\u00020\'H\u0002J\u0010\u0010(\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020.2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u0010/\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00100\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00101\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J\u0018\u00102\u001a\u00020!2\u0006\u00103\u001a\u0002042\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00105\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00106\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00107\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J\u0010\u00108\u001a\u00020!2\u0006\u0010)\u001a\u00020*H\u0002J \u00109\u001a\u00020!2\u0006\u0010&\u001a\u00020:2\u0006\u00103\u001a\u0002042\u0006\u0010)\u001a\u00020*H\u0002J\f\u0010;\u001a\u00020\u0005*\u00020:H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082.\u00a2\u0006\u0004\n\u0002\u0010\u0006R\u001e\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006>"}, d2 = {"Lacr/browser/lightning/settings/fragment/GeneralSettingsFragment;", "Lacr/browser/lightning/settings/fragment/AbstractSettingsFragment;", "()V", "proxyChoices", "", "", "[Ljava/lang/String;", "searchEngineProvider", "Lacr/browser/lightning/search/SearchEngineProvider;", "getSearchEngineProvider", "()Lacr/browser/lightning/search/SearchEngineProvider;", "setSearchEngineProvider", "(Lacr/browser/lightning/search/SearchEngineProvider;)V", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "getUserPreferences", "()Lacr/browser/lightning/preference/UserPreferences;", "setUserPreferences", "(Lacr/browser/lightning/preference/UserPreferences;)V", "choiceToUserAgent", "index", "", "convertSearchEngineToString", "", "searchEngines", "", "Lacr/browser/lightning/search/engine/BaseSearchEngine;", "(Ljava/util/List;)[Ljava/lang/CharSequence;", "getSearchEngineSummary", "baseSearchEngine", "homePageUrlToDisplayTitle", "url", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "providePreferencesXmlResource", "searchSuggestionChoiceToTitle", "choice", "Lacr/browser/lightning/search/Suggestions;", "showCustomDownloadLocationPicker", "summaryUpdater", "Lacr/browser/lightning/settings/fragment/SummaryUpdater;", "showCustomHomePagePicker", "showCustomSearchDialog", "customSearch", "Lacr/browser/lightning/search/engine/CustomSearch;", "showCustomUserAgentPicker", "showDownloadLocationDialog", "showHomePageDialog", "showManualProxyPicker", "activity", "Landroid/app/Activity;", "showProxyPicker", "showSearchProviderDialog", "showSearchSuggestionsDialog", "showUserAgentChooserDialog", "updateProxyChoice", "Lacr/browser/lightning/browser/proxy/ProxyChoice;", "toSummary", "Companion", "DownloadLocationTextWatcher", "app_lightningLiteDebug"})
public final class GeneralSettingsFragment extends acr.browser.lightning.settings.fragment.AbstractSettingsFragment {
    @javax.inject.Inject()
    public acr.browser.lightning.search.SearchEngineProvider searchEngineProvider;
    @javax.inject.Inject()
    public acr.browser.lightning.preference.UserPreferences userPreferences;
    private java.lang.String[] proxyChoices;
    private static final java.lang.String SETTINGS_PROXY = "proxy";
    private static final java.lang.String SETTINGS_IMAGES = "cb_images";
    private static final java.lang.String SETTINGS_SAVEDATA = "savedata";
    private static final java.lang.String SETTINGS_JAVASCRIPT = "cb_javascript";
    private static final java.lang.String SETTINGS_COLOR_MODE = "cb_colormode";
    private static final java.lang.String SETTINGS_USER_AGENT = "agent";
    private static final java.lang.String SETTINGS_DOWNLOAD = "download";
    private static final java.lang.String SETTINGS_HOME = "home";
    private static final java.lang.String SETTINGS_SEARCH_ENGINE = "search";
    private static final java.lang.String SETTINGS_SUGGESTIONS = "suggestions_choice";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.settings.fragment.GeneralSettingsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.search.SearchEngineProvider getSearchEngineProvider() {
        return null;
    }
    
    public final void setSearchEngineProvider(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.search.SearchEngineProvider p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.preference.UserPreferences getUserPreferences() {
        return null;
    }
    
    public final void setUserPreferences(@org.jetbrains.annotations.NotNull()
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
    
    private final java.lang.String toSummary(acr.browser.lightning.browser.proxy.ProxyChoice $this$toSummary) {
        return null;
    }
    
    private final void showProxyPicker(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final void updateProxyChoice(acr.browser.lightning.browser.proxy.ProxyChoice choice, android.app.Activity activity, acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final void showManualProxyPicker(android.app.Activity activity, acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final java.lang.String choiceToUserAgent(int index) {
        return null;
    }
    
    private final void showUserAgentChooserDialog(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final void showCustomUserAgentPicker(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final void showDownloadLocationDialog(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final void showCustomDownloadLocationPicker(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final java.lang.String homePageUrlToDisplayTitle(java.lang.String url) {
        return null;
    }
    
    private final void showHomePageDialog(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final void showCustomHomePagePicker(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final java.lang.String getSearchEngineSummary(acr.browser.lightning.search.engine.BaseSearchEngine baseSearchEngine) {
        return null;
    }
    
    private final java.lang.CharSequence[] convertSearchEngineToString(java.util.List<? extends acr.browser.lightning.search.engine.BaseSearchEngine> searchEngines) {
        return null;
    }
    
    private final void showSearchProviderDialog(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final void showCustomSearchDialog(acr.browser.lightning.search.engine.CustomSearch customSearch, acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final java.lang.String searchSuggestionChoiceToTitle(acr.browser.lightning.search.Suggestions choice) {
        return null;
    }
    
    private final void showSearchSuggestionsDialog(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    public GeneralSettingsFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J(\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H\u0016J(\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lacr/browser/lightning/settings/fragment/GeneralSettingsFragment$DownloadLocationTextWatcher;", "Landroid/text/TextWatcher;", "getDownload", "Landroid/widget/EditText;", "errorColor", "", "regularColor", "(Landroid/widget/EditText;II)V", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "count", "after", "onTextChanged", "before", "app_lightningLiteDebug"})
    static final class DownloadLocationTextWatcher implements android.text.TextWatcher {
        private final android.widget.EditText getDownload = null;
        private final int errorColor = 0;
        private final int regularColor = 0;
        
        @java.lang.Override()
        public void beforeTextChanged(@org.jetbrains.annotations.NotNull()
        java.lang.CharSequence s, int start, int count, int after) {
        }
        
        @java.lang.Override()
        public void onTextChanged(@org.jetbrains.annotations.NotNull()
        java.lang.CharSequence s, int start, int before, int count) {
        }
        
        @java.lang.Override()
        public void afterTextChanged(@org.jetbrains.annotations.NotNull()
        android.text.Editable s) {
        }
        
        public DownloadLocationTextWatcher(@org.jetbrains.annotations.NotNull()
        android.widget.EditText getDownload, int errorColor, int regularColor) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lacr/browser/lightning/settings/fragment/GeneralSettingsFragment$Companion;", "", "()V", "SETTINGS_COLOR_MODE", "", "SETTINGS_DOWNLOAD", "SETTINGS_HOME", "SETTINGS_IMAGES", "SETTINGS_JAVASCRIPT", "SETTINGS_PROXY", "SETTINGS_SAVEDATA", "SETTINGS_SEARCH_ENGINE", "SETTINGS_SUGGESTIONS", "SETTINGS_USER_AGENT", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}