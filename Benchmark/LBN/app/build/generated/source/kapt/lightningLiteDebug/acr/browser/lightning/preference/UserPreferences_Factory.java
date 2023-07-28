package acr.browser.lightning.preference;

import acr.browser.lightning.device.ScreenSize;
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
public final class UserPreferences_Factory implements Factory<UserPreferences> {
  private final Provider<SharedPreferences> preferencesProvider;

  private final Provider<ScreenSize> screenSizeProvider;

  public UserPreferences_Factory(Provider<SharedPreferences> preferencesProvider,
      Provider<ScreenSize> screenSizeProvider) {
    this.preferencesProvider = preferencesProvider;
    this.screenSizeProvider = screenSizeProvider;
  }

  @Override
  public UserPreferences get() {
    return newInstance(preferencesProvider.get(), screenSizeProvider.get());
  }

  public static UserPreferences_Factory create(Provider<SharedPreferences> preferencesProvider,
      Provider<ScreenSize> screenSizeProvider) {
    return new UserPreferences_Factory(preferencesProvider, screenSizeProvider);
  }

  public static UserPreferences newInstance(SharedPreferences preferences, ScreenSize screenSize) {
    return new UserPreferences(preferences, screenSize);
  }
}
