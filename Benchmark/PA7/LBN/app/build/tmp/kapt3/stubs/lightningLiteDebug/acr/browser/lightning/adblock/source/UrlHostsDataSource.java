package acr.browser.lightning.adblock.source;

import java.lang.System;

/**
 * A [HostsDataSource] that loads hosts from an [HttpUrl].
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B7\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0005H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lacr/browser/lightning/adblock/source/UrlHostsDataSource;", "Lacr/browser/lightning/adblock/source/HostsDataSource;", "url", "Lokhttp3/HttpUrl;", "okHttpClient", "Lio/reactivex/Single;", "Lokhttp3/OkHttpClient;", "logger", "Lacr/browser/lightning/log/Logger;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "application", "Landroid/app/Application;", "(Lokhttp3/HttpUrl;Lio/reactivex/Single;Lacr/browser/lightning/log/Logger;Lacr/browser/lightning/preference/UserPreferences;Landroid/app/Application;)V", "identifier", "", "loadHosts", "Lacr/browser/lightning/adblock/source/HostsResult;", "Companion", "Factory", "app_lightningLiteDebug"})
public final class UrlHostsDataSource implements acr.browser.lightning.adblock.source.HostsDataSource {
    private final okhttp3.HttpUrl url = null;
    private final io.reactivex.Single<okhttp3.OkHttpClient> okHttpClient = null;
    private final acr.browser.lightning.log.Logger logger = null;
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final android.app.Application application = null;
    private static final java.lang.String TAG = "UrlHostsDataSource";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.adblock.source.UrlHostsDataSource.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<acr.browser.lightning.adblock.source.HostsResult> loadHosts() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String identifier() {
        return null;
    }
    
    @dagger.assisted.AssistedInject()
    public UrlHostsDataSource(@org.jetbrains.annotations.NotNull()
    @dagger.assisted.Assisted()
    okhttp3.HttpUrl url, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.HostsClient()
    io.reactivex.Single<okhttp3.OkHttpClient> okHttpClient, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
    
    /**
     * Used to create the data source.
     */
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lacr/browser/lightning/adblock/source/UrlHostsDataSource$Factory;", "", "create", "Lacr/browser/lightning/adblock/source/UrlHostsDataSource;", "url", "Lokhttp3/HttpUrl;", "app_lightningLiteDebug"})
    @dagger.assisted.AssistedFactory()
    public static abstract interface Factory {
        
        /**
         * Create the data source for the provided URL.
         */
        @org.jetbrains.annotations.NotNull()
        public abstract acr.browser.lightning.adblock.source.UrlHostsDataSource create(@org.jetbrains.annotations.NotNull()
        okhttp3.HttpUrl url);
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/adblock/source/UrlHostsDataSource$Companion;", "", "()V", "TAG", "", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}