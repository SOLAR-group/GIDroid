package acr.browser.lightning.search.suggestions;

import java.lang.System;

/**
 * A search suggestions repository that doesn't fetch any results.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\b\u001a\u00020\tH\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lacr/browser/lightning/search/suggestions/NoOpSuggestionsRepository;", "Lacr/browser/lightning/search/suggestions/SuggestionsRepository;", "()V", "emptySingle", "Lio/reactivex/Single;", "", "Lacr/browser/lightning/database/SearchSuggestion;", "resultsForSearch", "rawQuery", "", "app_lightningLiteDebug"})
public final class NoOpSuggestionsRepository implements acr.browser.lightning.search.suggestions.SuggestionsRepository {
    private final io.reactivex.Single<java.util.List<acr.browser.lightning.database.SearchSuggestion>> emptySingle = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public io.reactivex.Single<java.util.List<acr.browser.lightning.database.SearchSuggestion>> resultsForSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String rawQuery) {
        return null;
    }
    
    public NoOpSuggestionsRepository() {
        super();
    }
}