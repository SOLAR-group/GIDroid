package acr.browser.lightning.browser.tab;

import acr.browser.lightning.preference.UserPreferences;
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
public final class HomePageInitializer_Factory implements Factory<HomePageInitializer> {
  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<StartPageInitializer> startPageInitializerProvider;

  private final Provider<BookmarkPageInitializer> bookmarkPageInitializerProvider;

  public HomePageInitializer_Factory(Provider<UserPreferences> userPreferencesProvider,
      Provider<StartPageInitializer> startPageInitializerProvider,
      Provider<BookmarkPageInitializer> bookmarkPageInitializerProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
    this.startPageInitializerProvider = startPageInitializerProvider;
    this.bookmarkPageInitializerProvider = bookmarkPageInitializerProvider;
  }

  @Override
  public HomePageInitializer get() {
    return newInstance(userPreferencesProvider.get(), startPageInitializerProvider.get(), bookmarkPageInitializerProvider.get());
  }

  public static HomePageInitializer_Factory create(
      Provider<UserPreferences> userPreferencesProvider,
      Provider<StartPageInitializer> startPageInitializerProvider,
      Provider<BookmarkPageInitializer> bookmarkPageInitializerProvider) {
    return new HomePageInitializer_Factory(userPreferencesProvider, startPageInitializerProvider, bookmarkPageInitializerProvider);
  }

  public static HomePageInitializer newInstance(UserPreferences userPreferences,
      StartPageInitializer startPageInitializer, BookmarkPageInitializer bookmarkPageInitializer) {
    return new HomePageInitializer(userPreferences, startPageInitializer, bookmarkPageInitializer);
  }
}
