package acr.browser.lightning.search.suggestions;

import java.lang.System;

/**
 * The search suggestions provider for the DuckDuckGo search engine.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lacr/browser/lightning/search/suggestions/DuckSuggestionsModel;", "Lacr/browser/lightning/search/suggestions/BaseSuggestionsModel;", "okHttpClient", "Lio/reactivex/Single;", "Lokhttp3/OkHttpClient;", "requestFactory", "Lacr/browser/lightning/search/suggestions/RequestFactory;", "application", "Landroid/app/Application;", "logger", "Lacr/browser/lightning/log/Logger;", "(Lio/reactivex/Single;Lacr/browser/lightning/search/suggestions/RequestFactory;Landroid/app/Application;Lacr/browser/lightning/log/Logger;)V", "searchSubtitle", "", "createQueryUrl", "Lokhttp3/HttpUrl;", "query", "language", "parseResults", "", "Lacr/browser/lightning/database/SearchSuggestion;", "responseBody", "Lokhttp3/ResponseBody;", "app_lightningPlusDebug"})
public final class DuckSuggestionsModel extends acr.browser.lightning.search.suggestions.BaseSuggestionsModel {
    private final java.lang.String searchSubtitle = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public okhttp3.HttpUrl createQueryUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String query, @org.jetbrains.annotations.NotNull()
    java.lang.String language) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected java.util.List<acr.browser.lightning.database.SearchSuggestion> parseResults(@org.jetbrains.annotations.NotNull()
    okhttp3.ResponseBody responseBody) {
        return null;
    }
    
    public DuckSuggestionsModel(@org.jetbrains.annotations.NotNull()
    io.reactivex.Single<okhttp3.OkHttpClient> okHttpClient, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.search.suggestions.RequestFactory requestFactory, @org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger) {
        super(null, null, null, null, null);
    }
}