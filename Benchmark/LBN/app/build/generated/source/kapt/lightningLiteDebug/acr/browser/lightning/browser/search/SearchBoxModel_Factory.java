package acr.browser.lightning.browser.search;

import acr.browser.lightning.preference.UserPreferences;
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
public final class SearchBoxModel_Factory implements Factory<SearchBoxModel> {
  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<Application> applicationProvider;

  public SearchBoxModel_Factory(Provider<UserPreferences> userPreferencesProvider,
      Provider<Application> applicationProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public SearchBoxModel get() {
    return newInstance(userPreferencesProvider.get(), applicationProvider.get());
  }

  public static SearchBoxModel_Factory create(Provider<UserPreferences> userPreferencesProvider,
      Provider<Application> applicationProvider) {
    return new SearchBoxModel_Factory(userPreferencesProvider, applicationProvider);
  }

  public static SearchBoxModel newInstance(UserPreferences userPreferences,
      Application application) {
    return new SearchBoxModel(userPreferences, application);
  }
}
