package acr.browser.lightning.search;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u00c8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\u0018\u0000 _2\u00020\u00012\u00020\u0002:\u0002_`B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010E\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0F2\u0006\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020JH\u0016J\b\u0010K\u001a\u00020LH\u0016J\u0012\u0010M\u001a\u0004\u0018\u00010N2\u0006\u0010O\u001a\u00020JH\u0016J\u0010\u0010P\u001a\u00020Q2\u0006\u0010O\u001a\u00020JH\u0016J\"\u0010R\u001a\u00020S2\u0006\u0010O\u001a\u00020J2\b\u0010T\u001a\u0004\u0018\u00010S2\u0006\u0010U\u001a\u00020VH\u0016J\u0018\u0010W\u001a\u00020.2\u000e\u0010X\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\tH\u0002J\u0006\u0010Y\u001a\u00020.J\u0006\u0010Z\u001a\u00020.J\u001e\u0010[\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\t0\\*\b\u0012\u0004\u0012\u00020^0]H\u0002R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\u000e8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u001b\u001a\u00020\u001c8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010!\u001a\n #*\u0004\u0018\u00010\"0\"X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010$\u001a\u00020\u00148\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0016\"\u0004\b&\u0010\u0018R\u001e\u0010\'\u001a\u00020\u00148\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0016\"\u0004\b)\u0010\u0018R\u000e\u0010*\u001a\u00020+X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020.\u0018\u00010-X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001e\u00103\u001a\u0002048\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020:X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010>\u001a\u00020?8\u0000@\u0000X\u0081.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\u000e\u0010D\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006a"}, d2 = {"Lacr/browser/lightning/search/SuggestionsAdapter;", "Landroid/widget/BaseAdapter;", "Landroid/widget/Filterable;", "context", "Landroid/content/Context;", "isIncognito", "", "(Landroid/content/Context;Z)V", "allBookmarks", "", "Lacr/browser/lightning/database/Bookmark$Entry;", "bookmarkIcon", "Landroid/graphics/drawable/Drawable;", "bookmarkRepository", "Lacr/browser/lightning/database/bookmark/BookmarkRepository;", "getBookmarkRepository$app_lightningLiteDebug", "()Lacr/browser/lightning/database/bookmark/BookmarkRepository;", "setBookmarkRepository$app_lightningLiteDebug", "(Lacr/browser/lightning/database/bookmark/BookmarkRepository;)V", "databaseScheduler", "Lio/reactivex/Scheduler;", "getDatabaseScheduler$app_lightningLiteDebug", "()Lio/reactivex/Scheduler;", "setDatabaseScheduler$app_lightningLiteDebug", "(Lio/reactivex/Scheduler;)V", "filteredList", "Lacr/browser/lightning/database/WebPage;", "historyRepository", "Lacr/browser/lightning/database/history/HistoryRepository;", "getHistoryRepository$app_lightningLiteDebug", "()Lacr/browser/lightning/database/history/HistoryRepository;", "setHistoryRepository$app_lightningLiteDebug", "(Lacr/browser/lightning/database/history/HistoryRepository;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "mainScheduler", "getMainScheduler$app_lightningLiteDebug", "setMainScheduler$app_lightningLiteDebug", "networkScheduler", "getNetworkScheduler$app_lightningLiteDebug", "setNetworkScheduler$app_lightningLiteDebug", "onClick", "Landroid/view/View$OnClickListener;", "onSuggestionInsertClick", "Lkotlin/Function1;", "", "getOnSuggestionInsertClick", "()Lkotlin/jvm/functions/Function1;", "setOnSuggestionInsertClick", "(Lkotlin/jvm/functions/Function1;)V", "searchEngineProvider", "Lacr/browser/lightning/search/SearchEngineProvider;", "getSearchEngineProvider$app_lightningLiteDebug", "()Lacr/browser/lightning/search/SearchEngineProvider;", "setSearchEngineProvider$app_lightningLiteDebug", "(Lacr/browser/lightning/search/SearchEngineProvider;)V", "searchFilter", "Lacr/browser/lightning/search/SuggestionsAdapter$SearchFilter;", "searchIcon", "suggestionsRepository", "Lacr/browser/lightning/search/suggestions/SuggestionsRepository;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "getUserPreferences$app_lightningLiteDebug", "()Lacr/browser/lightning/preference/UserPreferences;", "setUserPreferences$app_lightningLiteDebug", "(Lacr/browser/lightning/preference/UserPreferences;)V", "webPageIcon", "getBookmarksForQuery", "Lio/reactivex/Single;", "query", "", "getCount", "", "getFilter", "Landroid/widget/Filter;", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "publishResults", "list", "refreshBookmarks", "refreshPreferences", "results", "Lio/reactivex/Flowable;", "Lio/reactivex/Observable;", "", "Companion", "SearchFilter", "app_lightningLiteDebug"})
public final class SuggestionsAdapter extends android.widget.BaseAdapter implements android.widget.Filterable {
    private java.util.List<? extends acr.browser.lightning.database.WebPage> filteredList;
    @javax.inject.Inject()
    public acr.browser.lightning.database.bookmark.BookmarkRepository bookmarkRepository;
    @javax.inject.Inject()
    public acr.browser.lightning.preference.UserPreferences userPreferences;
    @javax.inject.Inject()
    public acr.browser.lightning.database.history.HistoryRepository historyRepository;
    @acr.browser.lightning.browser.di.DatabaseScheduler()
    @javax.inject.Inject()
    public io.reactivex.Scheduler databaseScheduler;
    @acr.browser.lightning.browser.di.NetworkScheduler()
    @javax.inject.Inject()
    public io.reactivex.Scheduler networkScheduler;
    @acr.browser.lightning.browser.di.MainScheduler()
    @javax.inject.Inject()
    public io.reactivex.Scheduler mainScheduler;
    @javax.inject.Inject()
    public acr.browser.lightning.search.SearchEngineProvider searchEngineProvider;
    private java.util.List<acr.browser.lightning.database.Bookmark.Entry> allBookmarks;
    private final acr.browser.lightning.search.SuggestionsAdapter.SearchFilter searchFilter = null;
    private final android.graphics.drawable.Drawable searchIcon = null;
    private final android.graphics.drawable.Drawable webPageIcon = null;
    private final android.graphics.drawable.Drawable bookmarkIcon = null;
    private acr.browser.lightning.search.suggestions.SuggestionsRepository suggestionsRepository;
    
    /**
     * The listener that is fired when the insert button on a [SearchSuggestion] is clicked.
     */
    @org.jetbrains.annotations.Nullable()
    private kotlin.jvm.functions.Function1<? super acr.browser.lightning.database.WebPage, kotlin.Unit> onSuggestionInsertClick;
    private final android.view.View.OnClickListener onClick = null;
    private final android.view.LayoutInflater layoutInflater = null;
    private final boolean isIncognito = false;
    private static final int MAX_SUGGESTIONS = 5;
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.search.SuggestionsAdapter.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.database.bookmark.BookmarkRepository getBookmarkRepository$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setBookmarkRepository$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.bookmark.BookmarkRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.preference.UserPreferences getUserPreferences$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setUserPreferences$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.database.history.HistoryRepository getHistoryRepository$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setHistoryRepository$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.history.HistoryRepository p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Scheduler getDatabaseScheduler$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setDatabaseScheduler$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    io.reactivex.Scheduler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Scheduler getNetworkScheduler$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setNetworkScheduler$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    io.reactivex.Scheduler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final io.reactivex.Scheduler getMainScheduler$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setMainScheduler$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    io.reactivex.Scheduler p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final acr.browser.lightning.search.SearchEngineProvider getSearchEngineProvider$app_lightningLiteDebug() {
        return null;
    }
    
    public final void setSearchEngineProvider$app_lightningLiteDebug(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.search.SearchEngineProvider p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kotlin.jvm.functions.Function1<acr.browser.lightning.database.WebPage, kotlin.Unit> getOnSuggestionInsertClick() {
        return null;
    }
    
    public final void setOnSuggestionInsertClick(@org.jetbrains.annotations.Nullable()
    kotlin.jvm.functions.Function1<? super acr.browser.lightning.database.WebPage, kotlin.Unit> p0) {
    }
    
    public final void refreshPreferences() {
    }
    
    public final void refreshBookmarks() {
    }
    
    @java.lang.Override()
    public int getCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getItem(int position) {
        return null;
    }
    
    @java.lang.Override()
    public long getItemId(int position) {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.view.View getView(int position, @org.jetbrains.annotations.Nullable()
    android.view.View convertView, @org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.widget.Filter getFilter() {
        return null;
    }
    
    private final void publishResults(java.util.List<? extends acr.browser.lightning.database.WebPage> list) {
    }
    
    private final io.reactivex.Single<java.util.List<acr.browser.lightning.database.Bookmark.Entry>> getBookmarksForQuery(java.lang.String query) {
        return null;
    }
    
    private final io.reactivex.Flowable<java.util.List<acr.browser.lightning.database.WebPage>> results(io.reactivex.Observable<java.lang.CharSequence> $this$results) {
        return null;
    }
    
    public SuggestionsAdapter(@org.jetbrains.annotations.NotNull()
    android.content.Context context, boolean isIncognito) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u0014J\u001c\u0010\u0012\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0014R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lacr/browser/lightning/search/SuggestionsAdapter$SearchFilter;", "Landroid/widget/Filter;", "suggestionsAdapter", "Lacr/browser/lightning/search/SuggestionsAdapter;", "(Lacr/browser/lightning/search/SuggestionsAdapter;)V", "publishSubject", "Lio/reactivex/subjects/PublishSubject;", "", "kotlin.jvm.PlatformType", "convertResultToString", "", "resultValue", "", "input", "Lio/reactivex/Observable;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "constraint", "publishResults", "", "results", "app_lightningLiteDebug"})
    static final class SearchFilter extends android.widget.Filter {
        private final io.reactivex.subjects.PublishSubject<java.lang.CharSequence> publishSubject = null;
        private final acr.browser.lightning.search.SuggestionsAdapter suggestionsAdapter = null;
        
        @org.jetbrains.annotations.NotNull()
        public final io.reactivex.Observable<java.lang.CharSequence> input() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        protected android.widget.Filter.FilterResults performFiltering(@org.jetbrains.annotations.Nullable()
        java.lang.CharSequence constraint) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.String convertResultToString(@org.jetbrains.annotations.NotNull()
        java.lang.Object resultValue) {
            return null;
        }
        
        @java.lang.Override()
        protected void publishResults(@org.jetbrains.annotations.Nullable()
        java.lang.CharSequence constraint, @org.jetbrains.annotations.Nullable()
        android.widget.Filter.FilterResults results) {
        }
        
        public SearchFilter(@org.jetbrains.annotations.NotNull()
        acr.browser.lightning.search.SuggestionsAdapter suggestionsAdapter) {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/search/SuggestionsAdapter$Companion;", "", "()V", "MAX_SUGGESTIONS", "", "app_lightningLiteDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}