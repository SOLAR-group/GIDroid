package acr.browser.lightning.settings.fragment;

import acr.browser.lightning.preference.UserPreferences;
import acr.browser.lightning.search.SearchEngineProvider;
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
public final class GeneralSettingsFragment_MembersInjector implements MembersInjector<GeneralSettingsFragment> {
  private final Provider<SearchEngineProvider> searchEngineProvider;

  private final Provider<UserPreferences> userPreferencesProvider;

  public GeneralSettingsFragment_MembersInjector(
      Provider<SearchEngineProvider> searchEngineProvider,
      Provider<UserPreferences> userPreferencesProvider) {
    this.searchEngineProvider = searchEngineProvider;
    this.userPreferencesProvider = userPreferencesProvider;
  }

  public static MembersInjector<GeneralSettingsFragment> create(
      Provider<SearchEngineProvider> searchEngineProvider,
      Provider<UserPreferences> userPreferencesProvider) {
    return new GeneralSettingsFragment_MembersInjector(searchEngineProvider, userPreferencesProvider);
  }

  @Override
  public void injectMembers(GeneralSettingsFragment instance) {
    injectSearchEngineProvider(instance, searchEngineProvider.get());
    injectUserPreferences(instance, userPreferencesProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.GeneralSettingsFragment.searchEngineProvider")
  public static void injectSearchEngineProvider(GeneralSettingsFragment instance,
      SearchEngineProvider searchEngineProvider) {
    instance.searchEngineProvider = searchEngineProvider;
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.GeneralSettingsFragment.userPreferences")
  public static void injectUserPreferences(GeneralSettingsFragment instance,
      UserPreferences userPreferences) {
    instance.userPreferences = userPreferences;
  }
}
