package acr.browser.lightning.database.allowlist;

import android.app.Application;
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
public final class AdBlockAllowListDatabase_Factory implements Factory<AdBlockAllowListDatabase> {
  private final Provider<Application> applicationProvider;

  public AdBlockAllowListDatabase_Factory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public AdBlockAllowListDatabase get() {
    return newInstance(applicationProvider.get());
  }

  public static AdBlockAllowListDatabase_Factory create(Provider<Application> applicationProvider) {
    return new AdBlockAllowListDatabase_Factory(applicationProvider);
  }

  public static AdBlockAllowListDatabase newInstance(Application application) {
    return new AdBlockAllowListDatabase(application);
  }
}
