package acr.browser.lightning.database.bookmark;

import android.app.Application;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class BookmarkDatabase_Factory implements Factory<BookmarkDatabase> {
  private final Provider<Application> applicationProvider;

  public BookmarkDatabase_Factory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public BookmarkDatabase get() {
    return newInstance(applicationProvider.get());
  }

  public static BookmarkDatabase_Factory create(Provider<Application> applicationProvider) {
    return new BookmarkDatabase_Factory(applicationProvider);
  }

  public static BookmarkDatabase newInstance(Application application) {
    return new BookmarkDatabase(application);
  }
}
