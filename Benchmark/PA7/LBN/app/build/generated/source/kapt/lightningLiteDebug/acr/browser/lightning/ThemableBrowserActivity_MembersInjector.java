package acr.browser.lightning;

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
public final class ThemableBrowserActivity_MembersInjector implements MembersInjector<ThemableBrowserActivity> {
  private final Provider<UserPreferences> userPreferencesProvider;

  public ThemableBrowserActivity_MembersInjector(
      Provider<UserPreferences> userPreferencesProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
  }

  public static MembersInjector<ThemableBrowserActivity> create(
      Provider<UserPreferences> userPreferencesProvider) {
    return new ThemableBrowserActivity_MembersInjector(userPreferencesProvider);
  }

  @Override
  public void injectMembers(ThemableBrowserActivity instance) {
    injectUserPreferences(instance, userPreferencesProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.ThemableBrowserActivity.userPreferences")
  public static void injectUserPreferences(ThemableBrowserActivity instance,
      UserPreferences userPreferences) {
    instance.userPreferences = userPreferences;
  }
}
