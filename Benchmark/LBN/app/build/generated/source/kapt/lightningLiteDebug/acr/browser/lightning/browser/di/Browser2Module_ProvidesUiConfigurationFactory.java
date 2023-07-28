package acr.browser.lightning.browser.di;

import acr.browser.lightning.browser.ui.UiConfiguration;
import acr.browser.lightning.preference.UserPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class Browser2Module_ProvidesUiConfigurationFactory implements Factory<UiConfiguration> {
  private final Browser2Module module;

  private final Provider<UserPreferences> userPreferencesProvider;

  public Browser2Module_ProvidesUiConfigurationFactory(Browser2Module module,
      Provider<UserPreferences> userPreferencesProvider) {
    this.module = module;
    this.userPreferencesProvider = userPreferencesProvider;
  }

  @Override
  public UiConfiguration get() {
    return providesUiConfiguration(module, userPreferencesProvider.get());
  }

  public static Browser2Module_ProvidesUiConfigurationFactory create(Browser2Module module,
      Provider<UserPreferences> userPreferencesProvider) {
    return new Browser2Module_ProvidesUiConfigurationFactory(module, userPreferencesProvider);
  }

  public static UiConfiguration providesUiConfiguration(Browser2Module instance,
      UserPreferences userPreferences) {
    return Preconditions.checkNotNullFromProvides(instance.providesUiConfiguration(userPreferences));
  }
}
