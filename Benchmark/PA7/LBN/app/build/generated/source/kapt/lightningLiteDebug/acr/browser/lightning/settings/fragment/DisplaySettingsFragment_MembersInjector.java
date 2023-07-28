package acr.browser.lightning.settings.fragment;

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
public final class DisplaySettingsFragment_MembersInjector implements MembersInjector<DisplaySettingsFragment> {
  private final Provider<UserPreferences> userPreferencesProvider;

  public DisplaySettingsFragment_MembersInjector(
      Provider<UserPreferences> userPreferencesProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
  }

  public static MembersInjector<DisplaySettingsFragment> create(
      Provider<UserPreferences> userPreferencesProvider) {
    return new DisplaySettingsFragment_MembersInjector(userPreferencesProvider);
  }

  @Override
  public void injectMembers(DisplaySettingsFragment instance) {
    injectUserPreferences(instance, userPreferencesProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.DisplaySettingsFragment.userPreferences")
  public static void injectUserPreferences(DisplaySettingsFragment instance,
      UserPreferences userPreferences) {
    instance.userPreferences = userPreferences;
  }
}
