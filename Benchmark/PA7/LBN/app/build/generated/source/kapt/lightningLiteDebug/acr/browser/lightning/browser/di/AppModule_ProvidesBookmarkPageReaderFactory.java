package acr.browser.lightning.browser.di;

import acr.browser.lightning.html.bookmark.BookmarkPageReader;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvidesBookmarkPageReaderFactory implements Factory<BookmarkPageReader> {
  private final AppModule module;

  public AppModule_ProvidesBookmarkPageReaderFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public BookmarkPageReader get() {
    return providesBookmarkPageReader(module);
  }

  public static AppModule_ProvidesBookmarkPageReaderFactory create(AppModule module) {
    return new AppModule_ProvidesBookmarkPageReaderFactory(module);
  }

  public static BookmarkPageReader providesBookmarkPageReader(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesBookmarkPageReader());
  }
}
