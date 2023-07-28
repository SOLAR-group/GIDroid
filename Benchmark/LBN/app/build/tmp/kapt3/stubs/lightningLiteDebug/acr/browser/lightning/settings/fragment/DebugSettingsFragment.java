package acr.browser.lightning.settings.fragment;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\u0010"}, d2 = {"Lacr/browser/lightning/settings/fragment/DebugSettingsFragment;", "Lacr/browser/lightning/settings/fragment/AbstractSettingsFragment;", "()V", "developerPreferences", "Lacr/browser/lightning/preference/DeveloperPreferences;", "getDeveloperPreferences$app_lightningLiteDebug", "()Lacr/browser/lightning/preference/DeveloperPreferences;", "setDeveloperPreferences$app_lightningLiteDebug", "(Lacr/browser/lightning/preference/DeveloperPreferences;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "providePreferencesXmlResource", "", "Companion", "app_lightningLiteDebug"})
public final class DebugSettingsFragment extends acr.browser.lightning.settings.fragment.AbstractSettingsFragment {
    @javax.inject.Inject()
    public acr.browser.lightning.preference.DeveloperPreferences developerPreferences;
    private static final java.lang.String LEAK_CANARY = "leak_canary_enabled";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.settings.fragment.DebugSettingsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.preference.DeveloperPreferences getDeveloperPreferences$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setDeveloperPreferences$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.DeveloperPreferences p0) {
    }
    
    @java.lang.Override()
    protected int providePreferencesXmlResource() {
        return 0;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public DebugSettingsFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/settings/fragment/DebugSettingsFragment$Companion;", "", "()V", "LEAK_CANARY", "", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}