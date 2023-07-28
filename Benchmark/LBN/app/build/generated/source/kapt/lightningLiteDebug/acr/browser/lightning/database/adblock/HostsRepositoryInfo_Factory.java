package acr.browser.lightning.database.adblock;

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
public final class HostsRepositoryInfo_Factory implements Factory<HostsRepositoryInfo> {
  private final Provider<SharedPreferences> preferencesProvider;

  public HostsRepositoryInfo_Factory(Provider<SharedPreferences> preferencesProvider) {
    this.preferencesProvider = preferencesProvider;
  }

  @Override
  public HostsRepositoryInfo get() {
    return newInstance(preferencesProvider.get());
  }

  public static HostsRepositoryInfo_Factory create(
      Provider<SharedPreferences> preferencesProvider) {
    return new HostsRepositoryInfo_Factory(preferencesProvider);
  }

  public static HostsRepositoryInfo newInstance(SharedPreferences preferences) {
    return new HostsRepositoryInfo(preferences);
  }
}
