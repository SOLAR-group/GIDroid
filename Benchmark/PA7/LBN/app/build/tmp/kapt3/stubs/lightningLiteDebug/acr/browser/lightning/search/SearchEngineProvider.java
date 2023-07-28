package acr.browser.lightning.search;

import java.lang.System;

/**
 * The model that provides the search engine based
 * on the user's preference.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B5\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013J\u0006\u0010\u0014\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lacr/browser/lightning/search/SearchEngineProvider;", "", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "okHttpClient", "Lio/reactivex/Single;", "Lokhttp3/OkHttpClient;", "requestFactory", "Lacr/browser/lightning/search/suggestions/RequestFactory;", "application", "Landroid/app/Application;", "logger", "Lacr/browser/lightning/log/Logger;", "(Lacr/browser/lightning/preference/UserPreferences;Lio/reactivex/Single;Lacr/browser/lightning/search/suggestions/RequestFactory;Landroid/app/Application;Lacr/browser/lightning/log/Logger;)V", "mapSearchEngineToPreferenceIndex", "", "searchEngine", "Lacr/browser/lightning/search/engine/BaseSearchEngine;", "provideAllSearchEngines", "", "provideSearchEngine", "provideSearchSuggestions", "Lacr/browser/lightning/search/suggestions/SuggestionsRepository;", "app_lightningLiteDebug"})
@dagger.Reusable()
public final class SearchEngineProvider {
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final io.reactivex.Single<okhttp3.OkHttpClient> okHttpClient = null;
    private final acr.browser.lightning.search.suggestions.RequestFactory requestFactory = null;
    private final android.app.Application application = null;
    private final acr.browser.lightning.log.Logger logger = null;
    
    /**
     * Provide the [SuggestionsRepository] that maps to the user's current preference.
     */
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.search.suggestions.SuggestionsRepository provideSearchSuggestions() {
        return null;
    }
    
    /**
     * Provide the [BaseSearchEngine] that maps to the user's current preference.
     */
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.search.engine.BaseSearchEngine provideSearchEngine() {
        return null;
    }
    
    /**
     * Return the serializable index of of the provided [BaseSearchEngine].
     */
    public final int mapSearchEngineToPreferenceIndex(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.search.engine.BaseSearchEngine searchEngine) {
        return 0;
    }
    
    /**
     * Provide a list of all supported search engines.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<acr.browser.lightning.search.engine.BaseSearchEngine> provideAllSearchEngines() {
        return null;
    }
    
    @javax.inject.Inject()
    public SearchEngineProvider(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.SuggestionsClient()
    io.reactivex.Single<okhttp3.OkHttpClient> okHttpClient, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.search.suggestions.RequestFactory requestFactory, @org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger) {
        super();
    }
}