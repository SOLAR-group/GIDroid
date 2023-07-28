package acr.browser.lightning.utils;

import acr.browser.lightning.preference.DeveloperPreferences;
import acr.browser.lightning.preference.UserPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import net.i2p.android.ui.I2PAndroidHelper;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ProxyUtils_Factory implements Factory<ProxyUtils> {
  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<DeveloperPreferences> developerPreferencesProvider;

  private final Provider<I2PAndroidHelper> i2PAndroidHelperProvider;

  public ProxyUtils_Factory(Provider<UserPreferences> userPreferencesProvider,
      Provider<DeveloperPreferences> developerPreferencesProvider,
      Provider<I2PAndroidHelper> i2PAndroidHelperProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
    this.developerPreferencesProvider = developerPreferencesProvider;
    this.i2PAndroidHelperProvider = i2PAndroidHelperProvider;
  }

  @Override
  public ProxyUtils get() {
    return newInstance(userPreferencesProvider.get(), developerPreferencesProvider.get(), i2PAndroidHelperProvider.get());
  }

  public static ProxyUtils_Factory create(Provider<UserPreferences> userPreferencesProvider,
      Provider<DeveloperPreferences> developerPreferencesProvider,
      Provider<I2PAndroidHelper> i2PAndroidHelperProvider) {
    return new ProxyUtils_Factory(userPreferencesProvider, developerPreferencesProvider, i2PAndroidHelperProvider);
  }

  public static ProxyUtils newInstance(UserPreferences userPreferences,
      DeveloperPreferences developerPreferences, I2PAndroidHelper i2PAndroidHelper) {
    return new ProxyUtils(userPreferences, developerPreferences, i2PAndroidHelper);
  }
}
