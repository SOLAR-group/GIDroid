package acr.browser.lightning.database.adblock;

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
public final class HostsDatabase_Factory implements Factory<HostsDatabase> {
  private final Provider<Application> applicationProvider;

  public HostsDatabase_Factory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public HostsDatabase get() {
    return newInstance(applicationProvider.get());
  }

  public static HostsDatabase_Factory create(Provider<Application> applicationProvider) {
    return new HostsDatabase_Factory(applicationProvider);
  }

  public static HostsDatabase newInstance(Application application) {
    return new HostsDatabase(application);
  }
}
