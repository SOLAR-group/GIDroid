package acr.browser.lightning.search;

import acr.browser.lightning.browser.di.DatabaseScheduler;
import acr.browser.lightning.browser.di.MainScheduler;
import acr.browser.lightning.browser.di.NetworkScheduler;
import acr.browser.lightning.database.bookmark.BookmarkRepository;
import acr.browser.lightning.database.history.HistoryRepository;
import acr.browser.lightning.preference.UserPreferences;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import io.reactivex.Scheduler;
import javax.annotation.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class SuggestionsAdapter_MembersInjector implements MembersInjector<SuggestionsAdapter> {
  private final Provider<BookmarkRepository> bookmarkRepositoryProvider;

  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<HistoryRepository> historyRepositoryProvider;

  private final Provider<Scheduler> databaseSchedulerProvider;

  private final Provider<Scheduler> networkSchedulerProvider;

  private final Provider<Scheduler> mainSchedulerProvider;

  private final Provider<SearchEngineProvider> searchEngineProvider;

  public SuggestionsAdapter_MembersInjector(Provider<BookmarkRepository> bookmarkRepositoryProvider,
      Provider<UserPreferences> userPreferencesProvider,
      Provider<HistoryRepository> historyRepositoryProvider,
      Provider<Scheduler> databaseSchedulerProvider, Provider<Scheduler> networkSchedulerProvider,
      Provider<Scheduler> mainSchedulerProvider,
      Provider<SearchEngineProvider> searchEngineProvider) {
    this.bookmarkRepositoryProvider = bookmarkRepositoryProvider;
    this.userPreferencesProvider = userPreferencesProvider;
    this.historyRepositoryProvider = historyRepositoryProvider;
    this.databaseSchedulerProvider = databaseSchedulerProvider;
    this.networkSchedulerProvider = networkSchedulerProvider;
    this.mainSchedulerProvider = mainSchedulerProvider;
    this.searchEngineProvider = searchEngineProvider;
  }

  public static MembersInjector<SuggestionsAdapter> create(
      Provider<BookmarkRepository> bookmarkRepositoryProvider,
      Provider<UserPreferences> userPreferencesProvider,
      Provider<HistoryRepository> historyRepositoryProvider,
      Provider<Scheduler> databaseSchedulerProvider, Provider<Scheduler> networkSchedulerProvider,
      Provider<Scheduler> mainSchedulerProvider,
      Provider<SearchEngineProvider> searchEngineProvider) {
    return new SuggestionsAdapter_MembersInjector(bookmarkRepositoryProvider, userPreferencesProvider, historyRepositoryProvider, databaseSchedulerProvider, networkSchedulerProvider, mainSchedulerProvider, searchEngineProvider);
  }

  @Override
  public void injectMembers(SuggestionsAdapter instance) {
    injectBookmarkRepository(instance, bookmarkRepositoryProvider.get());
    injectUserPreferences(instance, userPreferencesProvider.get());
    injectHistoryRepository(instance, historyRepositoryProvider.get());
    injectDatabaseScheduler(instance, databaseSchedulerProvider.get());
    injectNetworkScheduler(instance, networkSchedulerProvider.get());
    injectMainScheduler(instance, mainSchedulerProvider.get());
    injectSearchEngineProvider(instance, searchEngineProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.search.SuggestionsAdapter.bookmarkRepository")
  public static void injectBookmarkRepository(SuggestionsAdapter instance,
      BookmarkRepository bookmarkRepository) {
    instance.bookmarkRepository = bookmarkRepository;
  }

  @InjectedFieldSignature("acr.browser.lightning.search.SuggestionsAdapter.userPreferences")
  public static void injectUserPreferences(SuggestionsAdapter instance,
      UserPreferences userPreferences) {
    instance.userPreferences = userPreferences;
  }

  @InjectedFieldSignature("acr.browser.lightning.search.SuggestionsAdapter.historyRepository")
  public static void injectHistoryRepository(SuggestionsAdapter instance,
      HistoryRepository historyRepository) {
    instance.historyRepository = historyRepository;
  }

  @InjectedFieldSignature("acr.browser.lightning.search.SuggestionsAdapter.databaseScheduler")
  @DatabaseScheduler
  public static void injectDatabaseScheduler(SuggestionsAdapter instance,
      Scheduler databaseScheduler) {
    instance.databaseScheduler = databaseScheduler;
  }

  @InjectedFieldSignature("acr.browser.lightning.search.SuggestionsAdapter.networkScheduler")
  @NetworkScheduler
  public static void injectNetworkScheduler(SuggestionsAdapter instance,
      Scheduler networkScheduler) {
    instance.networkScheduler = networkScheduler;
  }

  @InjectedFieldSignature("acr.browser.lightning.search.SuggestionsAdapter.mainScheduler")
  @MainScheduler
  public static void injectMainScheduler(SuggestionsAdapter instance, Scheduler mainScheduler) {
    instance.mainScheduler = mainScheduler;
  }

  @InjectedFieldSignature("acr.browser.lightning.search.SuggestionsAdapter.searchEngineProvider")
  public static void injectSearchEngineProvider(SuggestionsAdapter instance,
      SearchEngineProvider searchEngineProvider) {
    instance.searchEngineProvider = searchEngineProvider;
  }
}
