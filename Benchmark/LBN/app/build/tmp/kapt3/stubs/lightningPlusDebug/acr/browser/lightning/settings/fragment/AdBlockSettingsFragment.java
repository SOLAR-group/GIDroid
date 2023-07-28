package acr.browser.lightning.settings.fragment;

import java.lang.System;

/**
 * Settings for the ad block mechanic.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\"\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u0012\u0010\'\u001a\u00020!2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020!H\u0016J\b\u0010+\u001a\u00020#H\u0014J\u0016\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\u0006\u0010/\u001a\u000200H\u0002J\u0010\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020\u0017H\u0002J\u0010\u00103\u001a\u00020!2\u0006\u00102\u001a\u00020\u0017H\u0002J\u0010\u00104\u001a\u00020!2\u0006\u00102\u001a\u00020\u0017H\u0002J\b\u00105\u001a\u00020!H\u0002J\b\u00106\u001a\u00020!H\u0002J\f\u00107\u001a\u000208*\u000209H\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000b\u001a\u00020\f8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\f8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000e\"\u0004\b\u0015\u0010\u0010R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\u00198\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006;"}, d2 = {"Lacr/browser/lightning/settings/fragment/AdBlockSettingsFragment;", "Lacr/browser/lightning/settings/fragment/AbstractSettingsFragment;", "()V", "bloomFilterAdBlocker", "Lacr/browser/lightning/adblock/BloomFilterAdBlocker;", "getBloomFilterAdBlocker$app_lightningPlusDebug", "()Lacr/browser/lightning/adblock/BloomFilterAdBlocker;", "setBloomFilterAdBlocker$app_lightningPlusDebug", "(Lacr/browser/lightning/adblock/BloomFilterAdBlocker;)V", "compositeDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "diskScheduler", "Lio/reactivex/Scheduler;", "getDiskScheduler$app_lightningPlusDebug", "()Lio/reactivex/Scheduler;", "setDiskScheduler$app_lightningPlusDebug", "(Lio/reactivex/Scheduler;)V", "forceRefreshHostsPreference", "Landroid/preference/Preference;", "mainScheduler", "getMainScheduler$app_lightningPlusDebug", "setMainScheduler$app_lightningPlusDebug", "recentSummaryUpdater", "Lacr/browser/lightning/settings/fragment/SummaryUpdater;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "getUserPreferences$app_lightningPlusDebug", "()Lacr/browser/lightning/preference/UserPreferences;", "setUserPreferences$app_lightningPlusDebug", "(Lacr/browser/lightning/preference/UserPreferences;)V", "isRefreshHostsEnabled", "", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "providePreferencesXmlResource", "readTextFromUri", "Lio/reactivex/Maybe;", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "showFileChooser", "summaryUpdater", "showHostsSourceChooser", "showUrlChooser", "updateForNewHostsSource", "updateRefreshHostsEnabledStatus", "toSummary", "", "Lacr/browser/lightning/adblock/source/HostsSourceType;", "Companion", "app_lightningPlusDebug"})
public final class AdBlockSettingsFragment extends acr.browser.lightning.settings.fragment.AbstractSettingsFragment {
    @javax.inject.Inject()
    public acr.browser.lightning.preference.UserPreferences userPreferences;
    @acr.browser.lightning.browser.di.MainScheduler()
    @javax.inject.Inject()
    public io.reactivex.Scheduler mainScheduler;
    @acr.browser.lightning.browser.di.DiskScheduler()
    @javax.inject.Inject()
    public io.reactivex.Scheduler diskScheduler;
    @javax.inject.Inject()
    public acr.browser.lightning.adblock.BloomFilterAdBlocker bloomFilterAdBlocker;
    private acr.browser.lightning.settings.fragment.SummaryUpdater recentSummaryUpdater;
    private final io.reactivex.disposables.CompositeDisposable compositeDisposable = null;
    private android.preference.Preference forceRefreshHostsPreference;
    private static final int FILE_REQUEST_CODE = 100;
    private static final java.lang.String AD_HOSTS_FILE = "local_hosts.txt";
    private static final java.lang.String TEXT_MIME_TYPE = "text/*";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.settings.fragment.AdBlockSettingsFragment.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.preference.UserPreferences getUserPreferences$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setUserPreferences$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Scheduler getMainScheduler$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setMainScheduler$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    io.reactivex.Scheduler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Scheduler getDiskScheduler$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setDiskScheduler$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    io.reactivex.Scheduler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.adblock.BloomFilterAdBlocker getBloomFilterAdBlocker$app_lightningPlusDebug() {
        return null;
    }
    
    public final void setBloomFilterAdBlocker$app_lightningPlusDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.adblock.BloomFilterAdBlocker p0) {
    }
    
    @java.lang.Override()
    protected int providePreferencesXmlResource() {
        return 0;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void updateRefreshHostsEnabledStatus() {
    }
    
    private final boolean isRefreshHostsEnabled() {
        return false;
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
    
    private final java.lang.String toSummary(acr.browser.lightning.adblock.source.HostsSourceType $this$toSummary) {
        return null;
    }
    
    private final void showHostsSourceChooser(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final void showFileChooser(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    private final void showUrlChooser(acr.browser.lightning.settings.fragment.SummaryUpdater summaryUpdater) {
    }
    
    @java.lang.Override()
    public void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void updateForNewHostsSource() {
    }
    
    private final io.reactivex.Maybe<java.io.File> readTextFromUri(android.net.Uri uri) {
        return null;
    }
    
    public AdBlockSettingsFragment() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lacr/browser/lightning/settings/fragment/AdBlockSettingsFragment$Companion;", "", "()V", "AD_HOSTS_FILE", "", "FILE_REQUEST_CODE", "", "TEXT_MIME_TYPE", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}