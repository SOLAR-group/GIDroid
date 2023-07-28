package acr.browser.lightning.browser.data;

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
public final class IncognitoCookieAdministrator_Factory implements Factory<IncognitoCookieAdministrator> {
  private final Provider<UserPreferences> userPreferencesProvider;

  public IncognitoCookieAdministrator_Factory(Provider<UserPreferences> userPreferencesProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
  }

  @Override
  public IncognitoCookieAdministrator get() {
    return newInstance(userPreferencesProvider.get());
  }

  public static IncognitoCookieAdministrator_Factory create(
      Provider<UserPreferences> userPreferencesProvider) {
    return new IncognitoCookieAdministrator_Factory(userPreferencesProvider);
  }

  public static IncognitoCookieAdministrator newInstance(UserPreferences userPreferences) {
    return new IncognitoCookieAdministrator(userPreferences);
  }
}
