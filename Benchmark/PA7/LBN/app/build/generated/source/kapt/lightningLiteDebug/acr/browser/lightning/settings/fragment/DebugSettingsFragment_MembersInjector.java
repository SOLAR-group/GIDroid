package acr.browser.lightning.settings.fragment;

import acr.browser.lightning.preference.DeveloperPreferences;
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
public final class DebugSettingsFragment_MembersInjector implements MembersInjector<DebugSettingsFragment> {
  private final Provider<DeveloperPreferences> developerPreferencesProvider;

  public DebugSettingsFragment_MembersInjector(
      Provider<DeveloperPreferences> developerPreferencesProvider) {
    this.developerPreferencesProvider = developerPreferencesProvider;
  }

  public static MembersInjector<DebugSettingsFragment> create(
      Provider<DeveloperPreferences> developerPreferencesProvider) {
    return new DebugSettingsFragment_MembersInjector(developerPreferencesProvider);
  }

  @Override
  public void injectMembers(DebugSettingsFragment instance) {
    injectDeveloperPreferences(instance, developerPreferencesProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.DebugSettingsFragment.developerPreferences")
  public static void injectDeveloperPreferences(DebugSettingsFragment instance,
      DeveloperPreferences developerPreferences) {
    instance.developerPreferences = developerPreferences;
  }
}
