package acr.browser.lightning.search.suggestions;

import java.lang.System;

/**
 * A repository for search suggestions.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lacr/browser/lightning/search/suggestions/SuggestionsRepository;", "", "resultsForSearch", "Lio/reactivex/Single;", "", "Lacr/browser/lightning/database/SearchSuggestion;", "rawQuery", "", "app_lightningLiteDebug"})
public abstract interface SuggestionsRepository {
    
    /**
     * Creates a [Single] that fetches the search suggestion results for the provided query.
     *
     * @param rawQuery the raw query to retrieve the results for.
     * @return a [Single] that emits the list of results for the query.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<acr.browser.lightning.database.SearchSuggestion>> resultsForSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String rawQuery);
}