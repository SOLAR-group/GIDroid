package acr.browser.lightning.search.suggestions;

import java.lang.System;

/**
 * The base search suggestions API. Provides common fetching and caching functionality for each
 * potential suggestions provider.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB5\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u00a2\u0006\u0002\u0010\rJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH&J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H$J\u001c\u0010\u0017\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00032\u0006\u0010\u0018\u001a\u00020\bH\u0016J\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u001a*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lacr/browser/lightning/search/suggestions/BaseSuggestionsModel;", "Lacr/browser/lightning/search/suggestions/SuggestionsRepository;", "okHttpClient", "Lio/reactivex/Single;", "Lokhttp3/OkHttpClient;", "requestFactory", "Lacr/browser/lightning/search/suggestions/RequestFactory;", "encoding", "", "locale", "Ljava/util/Locale;", "logger", "Lacr/browser/lightning/log/Logger;", "(Lio/reactivex/Single;Lacr/browser/lightning/search/suggestions/RequestFactory;Ljava/lang/String;Ljava/util/Locale;Lacr/browser/lightning/log/Logger;)V", "language", "createQueryUrl", "Lokhttp3/HttpUrl;", "query", "parseResults", "", "Lacr/browser/lightning/database/SearchSuggestion;", "responseBody", "Lokhttp3/ResponseBody;", "resultsForSearch", "rawQuery", "downloadSuggestionsForQuery", "Lokhttp3/Response;", "Companion", "app_lightningPlusDebug"})
public abstract class BaseSuggestionsModel implements acr.browser.lightning.search.suggestions.SuggestionsRepository {
    private final java.lang.String language = null;
    private final io.reactivex.Single<okhttp3.OkHttpClient> okHttpClient = null;
    private final acr.browser.lightning.search.suggestions.RequestFactory requestFactory = null;
    private final java.lang.String encoding = null;
    private final acr.browser.lightning.log.Logger logger = null;
    private static final java.lang.String TAG = "BaseSuggestionsModel";
    private static final int MAX_RESULTS = 5;
    private static final java.lang.String DEFAULT_LANGUAGE = "en";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.search.suggestions.BaseSuggestionsModel.Companion Companion = null;
    
    /**
     * Create a URL for the given query in the given language.
     *
     * @param query    the query that was made.
     * @param language the locale of the user.
     * @return should return a [HttpUrl] that can be fetched using a GET.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract okhttp3.HttpUrl createQueryUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    java.lang.String language);
    
    /**
     * Parse the results of an input stream into a list of [SearchSuggestion].
     *
     * @param responseBody the raw [ResponseBody] to parse.
     */
    @org.jetbrains.annotations.NotNull()
    protected abstract java.util.List<acr.browser.lightning.database.SearchSuggestion> parseResults(@org.jetbrains.annotations.NotNull()
    okhttp3.ResponseBody responseBody);
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<acr.browser.lightning.database.SearchSuggestion>> resultsForSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String rawQuery) {
        return null;
    }
    
    /**
     * This method downloads the search suggestions for the specific query.
     * NOTE: This is a blocking operation, do not fetchResults on the UI thread.
     *
     * @param query the query to get suggestions for
     *
     * @return the cache file containing the suggestions
     */
    private final okhttp3.Response downloadSuggestionsForQuery(okhttp3.OkHttpClient $this$downloadSuggestionsForQuery, java.lang.String query, java.lang.String language) {
        return null;
    }
    
    public BaseSuggestionsModel(@org.jetbrains.annotations.NotNull()
    io.reactivex.Single<okhttp3.OkHttpClient> okHttpClient, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.search.suggestions.RequestFactory requestFactory, @org.jetbrains.annotations.NotNull()
    java.lang.String encoding, @org.jetbrains.annotations.NotNull()
    java.util.Locale locale, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lacr/browser/lightning/search/suggestions/BaseSuggestionsModel$Companion;", "", "()V", "DEFAULT_LANGUAGE", "", "MAX_RESULTS", "", "TAG", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}