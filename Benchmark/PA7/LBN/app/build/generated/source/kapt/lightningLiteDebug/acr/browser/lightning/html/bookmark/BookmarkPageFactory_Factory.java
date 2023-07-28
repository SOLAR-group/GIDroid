package acr.browser.lightning.html.bookmark;

import acr.browser.lightning.browser.theme.ThemeProvider;
import acr.browser.lightning.database.bookmark.BookmarkRepository;
import acr.browser.lightning.favicon.FaviconModel;
import android.app.Application;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class BookmarkPageFactory_Factory implements Factory<BookmarkPageFactory> {
  private final Provider<Application> applicationProvider;

  private final Provider<BookmarkRepository> bookmarkModelProvider;

  private final Provider<FaviconModel> faviconModelProvider;

  private final Provider<Scheduler> databaseSchedulerProvider;

  private final Provider<Scheduler> diskSchedulerProvider;

  private final Provider<BookmarkPageReader> bookmarkPageReaderProvider;

  private final Provider<ThemeProvider> themeProvider;

  public BookmarkPageFactory_Factory(Provider<Application> applicationProvider,
      Provider<BookmarkRepository> bookmarkModelProvider,
      Provider<FaviconModel> faviconModelProvider, Provider<Scheduler> databaseSchedulerProvider,
      Provider<Scheduler> diskSchedulerProvider,
      Provider<BookmarkPageReader> bookmarkPageReaderProvider,
      Provider<ThemeProvider> themeProvider) {
    this.applicationProvider = applicationProvider;
    this.bookmarkModelProvider = bookmarkModelProvider;
    this.faviconModelProvider = faviconModelProvider;
    this.databaseSchedulerProvider = databaseSchedulerProvider;
    this.diskSchedulerProvider = diskSchedulerProvider;
    this.bookmarkPageReaderProvider = bookmarkPageReaderProvider;
    this.themeProvider = themeProvider;
  }

  @Override
  public BookmarkPageFactory get() {
    return newInstance(applicationProvider.get(), bookmarkModelProvider.get(), faviconModelProvider.get(), databaseSchedulerProvider.get(), diskSchedulerProvider.get(), bookmarkPageReaderProvider.get(), themeProvider.get());
  }

  public static BookmarkPageFactory_Factory create(Provider<Application> applicationProvider,
      Provider<BookmarkRepository> bookmarkModelProvider,
      Provider<FaviconModel> faviconModelProvider, Provider<Scheduler> databaseSchedulerProvider,
      Provider<Scheduler> diskSchedulerProvider,
      Provider<BookmarkPageReader> bookmarkPageReaderProvider,
      Provider<ThemeProvider> themeProvider) {
    return new BookmarkPageFactory_Factory(applicationProvider, bookmarkModelProvider, faviconModelProvider, databaseSchedulerProvider, diskSchedulerProvider, bookmarkPageReaderProvider, themeProvider);
  }

  public static BookmarkPageFactory newInstance(Application application,
      BookmarkRepository bookmarkModel, FaviconModel faviconModel, Scheduler databaseScheduler,
      Scheduler diskScheduler, BookmarkPageReader bookmarkPageReader, ThemeProvider themeProvider) {
    return new BookmarkPageFactory(application, bookmarkModel, faviconModel, databaseScheduler, diskScheduler, bookmarkPageReader, themeProvider);
  }
}
