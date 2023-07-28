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
public final class DefaultCookieAdministrator_Factory implements Factory<DefaultCookieAdministrator> {
  private final Provider<UserPreferences> userPreferencesProvider;

  public DefaultCookieAdministrator_Factory(Provider<UserPreferences> userPreferencesProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
  }

  @Override
  public DefaultCookieAdministrator get() {
    return newInstance(userPreferencesProvider.get());
  }

  public static DefaultCookieAdministrator_Factory create(
      Provider<UserPreferences> userPreferencesProvider) {
    return new DefaultCookieAdministrator_Factory(userPreferencesProvider);
  }

  public static DefaultCookieAdministrator newInstance(UserPreferences userPreferences) {
    return new DefaultCookieAdministrator(userPreferences);
  }
}
