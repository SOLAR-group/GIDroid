package acr.browser.lightning.settings.fragment;

import java.lang.System;

/**
 * An abstract settings fragment which performs wiring for an instance of [PreferenceFragment].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0004J:\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0\fH\u0004J4\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u0013H\u0004J\u0012\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H%J6\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fH\u0004\u00a8\u0006\u001b"}, d2 = {"Lacr/browser/lightning/settings/fragment/AbstractSettingsFragment;", "Landroid/preference/PreferenceFragment;", "()V", "checkBoxPreference", "Landroid/preference/CheckBoxPreference;", "preference", "", "isChecked", "", "isEnabled", "summary", "onCheckChange", "Lkotlin/Function1;", "", "clickableDynamicPreference", "Landroid/preference/Preference;", "onClick", "Lacr/browser/lightning/settings/fragment/SummaryUpdater;", "clickablePreference", "Lkotlin/Function0;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "providePreferencesXmlResource", "", "togglePreference", "Landroid/preference/SwitchPreference;", "app_lightningLiteDebug"})
public abstract class AbstractSettingsFragment extends android.preference.PreferenceFragment {
    private java.util.HashMap _$_findViewCache;
    
    /**
     * Provide the XML resource which holds the preferences.
     */
    @androidx.annotation.XmlRes()
    protected abstract int providePreferencesXmlResource();
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Creates a [CheckBoxPreference] with the provided options and listener.
     *
     * @param preference the preference to create.
     * @param isChecked true if it should be initialized as checked, false otherwise.
     * @param isEnabled true if the preference should be enabled, false otherwise. Defaults to true.
     * @param summary the summary to display. Defaults to null, which results in no summary.
     * @param onCheckChange the function that should be called when the check box is toggled.
     */
    @org.jetbrains.annotations.NotNull()
    protected final android.preference.CheckBoxPreference checkBoxPreference(@org.jetbrains.annotations.NotNull()
    java.lang.String preference, boolean isChecked, boolean isEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.String summary, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onCheckChange) {
        return null;
    }
    
    /**
     * Creates a simple [Preference] which reacts to clicks with the provided options and listener.
     *
     * @param preference the preference to create.
     * @param isEnabled true if the preference should be enabled, false otherwise. Defaults to true.
     * @param summary the summary to display. Defaults to null, which results in no summary.
     * @param onClick the function that should be called when the preference is clicked.
     */
    @org.jetbrains.annotations.NotNull()
    protected final android.preference.Preference clickablePreference(@org.jetbrains.annotations.NotNull()
    java.lang.String preference, boolean isEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.String summary, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
        return null;
    }
    
    /**
     * Creates a simple [Preference] which reacts to clicks with the provided options and listener.
     * It also allows its summary to be updated when clicked.
     *
     * @param preference the preference to create.
     * @param isEnabled true if the preference should be enabled, false otherwise. Defaults to true.
     * @param summary the summary to display. Defaults to null, which results in no summary.
     * @param onClick the function that should be called when the preference is clicked. The
     * function is supplied with a [SummaryUpdater] object so that it can update the summary if
     * desired.
     */
    @org.jetbrains.annotations.NotNull()
    protected final android.preference.Preference clickableDynamicPreference(@org.jetbrains.annotations.NotNull()
    java.lang.String preference, boolean isEnabled, @org.jetbrains.annotations.Nullable()
    java.lang.String summary, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super acr.browser.lightning.settings.fragment.SummaryUpdater, kotlin.Unit> onClick) {
        return null;
    }
    
    /**
     * Creates a [SwitchPreference] with the provided options and listener.
     *
     * @param preference the preference to create.
     * @param isChecked true if it should be initialized as checked, false otherwise.
     * @param isEnabled true if the preference should be enabled, false otherwise. Defaults to true.
     * @param onCheckChange the function that should be called when the toggle is toggled.
     */
    @org.jetbrains.annotations.NotNull()
    protected final android.preference.SwitchPreference togglePreference(@org.jetbrains.annotations.NotNull()
    java.lang.String preference, boolean isChecked, boolean isEnabled, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onCheckChange) {
        return null;
    }
    
    public AbstractSettingsFragment() {
        super();
    }
}