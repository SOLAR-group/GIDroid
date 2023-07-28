package acr.browser.lightning.database.allowlist;

import java.lang.System;

/**
 * The interface used to communicate with the ad block whitelist interface.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0014\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\b0\u0007H&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u000f"}, d2 = {"Lacr/browser/lightning/database/allowlist/AdBlockAllowListRepository;", "", "addAllowListItem", "Lio/reactivex/Completable;", "whitelistItem", "Lacr/browser/lightning/database/allowlist/AllowListEntry;", "allAllowListItems", "Lio/reactivex/Single;", "", "allowListItemForUrl", "Lio/reactivex/Maybe;", "url", "", "clearAllowList", "removeAllowListItem", "app_lightningPlusDebug"})
public abstract interface AdBlockAllowListRepository {
    
    /**
     * Returns a [Single] that emits a list of all [AllowListEntry] in the database.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Single<java.util.List<acr.browser.lightning.database.allowlist.AllowListEntry>> allAllowListItems();
    
    /**
     * Returns a [Maybe] that emits the [AllowListEntry] associated with the [url] if there is one.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Maybe<acr.browser.lightning.database.allowlist.AllowListEntry> allowListItemForUrl(@org.jetbrains.annotations.NotNull()
    java.lang.String url);
    
    /**
     * Returns a [Completable] that adds a [AllowListEntry] to the database and completes when done.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable addAllowListItem(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.allowlist.AllowListEntry whitelistItem);
    
    /**
     * Returns a [Completable] that removes a [AllowListEntry] from the database and completes when
     * done.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable removeAllowListItem(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.allowlist.AllowListEntry whitelistItem);
    
    /**
     * Returns a [Completable] that clears the entire database.
     */
    @org.jetbrains.annotations.NotNull()
    public abstract io.reactivex.Completable clearAllowList();
}