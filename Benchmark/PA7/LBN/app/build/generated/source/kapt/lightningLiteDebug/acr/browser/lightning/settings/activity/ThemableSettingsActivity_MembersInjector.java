package acr.browser.lightning.settings.activity;

import acr.browser.lightning.preference.UserPreferences;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
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
public final class ThemableSettingsActivity_MembersInjector implements MembersInjector<ThemableSettingsActivity> {
  private final Provider<UserPreferences> userPreferencesProvider;

  public ThemableSettingsActivity_MembersInjector(
      Provider<UserPreferences> userPreferencesProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
  }

  public static MembersInjector<ThemableSettingsActivity> create(
      Provider<UserPreferences> userPreferencesProvider) {
    return new ThemableSettingsActivity_MembersInjector(userPreferencesProvider);
  }

  @Override
  public void injectMembers(ThemableSettingsActivity instance) {
    injectUserPreferences(instance, userPreferencesProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.activity.ThemableSettingsActivity.userPreferences")
  public static void injectUserPreferences(ThemableSettingsActivity instance,
      UserPreferences userPreferences) {
    instance.userPreferences = userPreferences;
  }
}
