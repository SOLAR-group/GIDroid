package acr.browser.lightning.browser.tab;

import acr.browser.lightning.html.bookmark.BookmarkPageFactory;
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
public final class BookmarkPageInitializer_Factory implements Factory<BookmarkPageInitializer> {
  private final Provider<BookmarkPageFactory> bookmarkPageFactoryProvider;

  private final Provider<Scheduler> diskSchedulerProvider;

  private final Provider<Scheduler> foregroundSchedulerProvider;

  public BookmarkPageInitializer_Factory(Provider<BookmarkPageFactory> bookmarkPageFactoryProvider,
      Provider<Scheduler> diskSchedulerProvider, Provider<Scheduler> foregroundSchedulerProvider) {
    this.bookmarkPageFactoryProvider = bookmarkPageFactoryProvider;
    this.diskSchedulerProvider = diskSchedulerProvider;
    this.foregroundSchedulerProvider = foregroundSchedulerProvider;
  }

  @Override
  public BookmarkPageInitializer get() {
    return newInstance(bookmarkPageFactoryProvider.get(), diskSchedulerProvider.get(), foregroundSchedulerProvider.get());
  }

  public static BookmarkPageInitializer_Factory create(
      Provider<BookmarkPageFactory> bookmarkPageFactoryProvider,
      Provider<Scheduler> diskSchedulerProvider, Provider<Scheduler> foregroundSchedulerProvider) {
    return new BookmarkPageInitializer_Factory(bookmarkPageFactoryProvider, diskSchedulerProvider, foregroundSchedulerProvider);
  }

  public static BookmarkPageInitializer newInstance(BookmarkPageFactory bookmarkPageFactory,
      Scheduler diskScheduler, Scheduler foregroundScheduler) {
    return new BookmarkPageInitializer(bookmarkPageFactory, diskScheduler, foregroundScheduler);
  }
}
