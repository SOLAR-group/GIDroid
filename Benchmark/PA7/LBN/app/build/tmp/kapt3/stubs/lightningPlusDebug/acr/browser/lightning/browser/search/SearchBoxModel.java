package acr.browser.lightning.browser.search;

import java.lang.System;

/**
 * A UI model for the search box.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lacr/browser/lightning/browser/search/SearchBoxModel;", "", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "application", "Landroid/app/Application;", "(Lacr/browser/lightning/preference/UserPreferences;Landroid/app/Application;)V", "untitledTitle", "", "getDisplayContent", "url", "title", "isLoading", "", "safeDomain", "app_lightningPlusDebug"})
@dagger.Reusable()
public final class SearchBoxModel {
    private final java.lang.String untitledTitle = null;
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    
    /**
     * Returns the contents of the search box based on a variety of factors.
     *
     * - The user's preference to show either the URL, domain, or page title
     * - Whether or not the current page is loading
     * - Whether or not the current page is a Lightning generated page.
     *
     * This method uses the URL, title, and loading information to determine what
     * should be displayed by the search box.
     *
     * @param url       the URL of the current page.
     * @param title     the title of the current page, if known.
     * @param isLoading whether the page is currently loading or not.
     * @return the string that should be displayed by the search box.
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDisplayContent(@org.jetbrains.annotations.NotNull()
    java.lang.String url, @org.jetbrains.annotations.Nullable()
    java.lang.String title, boolean isLoading) {
        return null;
    }
    
    private final java.lang.String safeDomain(java.lang.String url) {
        return null;
    }
    
    @javax.inject.Inject()
    public SearchBoxModel(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super();
    }
}