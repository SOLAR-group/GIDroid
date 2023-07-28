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
public final class AdvancedSettingsFragment_MembersInjector implements MembersInjector<AdvancedSettingsFragment> {
  private final Provider<UserPreferences> userPreferencesProvider;

  public AdvancedSettingsFragment_MembersInjector(
      Provider<UserPreferences> userPreferencesProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
  }

  public static MembersInjector<AdvancedSettingsFragment> create(
      Provider<UserPreferences> userPreferencesProvider) {
    return new AdvancedSettingsFragment_MembersInjector(userPreferencesProvider);
  }

  @Override
  public void injectMembers(AdvancedSettingsFragment instance) {
    injectUserPreferences(instance, userPreferencesProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.AdvancedSettingsFragment.userPreferences")
  public static void injectUserPreferences(AdvancedSettingsFragment instance,
      UserPreferences userPreferences) {
    instance.userPreferences = userPreferences;
  }
}
