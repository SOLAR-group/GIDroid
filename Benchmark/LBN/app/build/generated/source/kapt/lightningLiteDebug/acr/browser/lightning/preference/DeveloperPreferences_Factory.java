package acr.browser.lightning.preference;

import android.content.SharedPreferences;
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
public final class DeveloperPreferences_Factory implements Factory<DeveloperPreferences> {
  private final Provider<SharedPreferences> preferencesProvider;

  public DeveloperPreferences_Factory(Provider<SharedPreferences> preferencesProvider) {
    this.preferencesProvider = preferencesProvider;
  }

  @Override
  public DeveloperPreferences get() {
    return newInstance(preferencesProvider.get());
  }

  public static DeveloperPreferences_Factory create(
      Provider<SharedPreferences> preferencesProvider) {
    return new DeveloperPreferences_Factory(preferencesProvider);
  }

  public static DeveloperPreferences newInstance(SharedPreferences preferences) {
    return new DeveloperPreferences(preferences);
  }
}
