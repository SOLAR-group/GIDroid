package acr.browser.lightning.browser.di;

import android.app.Application;
import android.net.ConnectivityManager;
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
public final class AppModule_ProvidesConnectivityManagerFactory implements Factory<ConnectivityManager> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvidesConnectivityManagerFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public ConnectivityManager get() {
    return providesConnectivityManager(module, applicationProvider.get());
  }

  public static AppModule_ProvidesConnectivityManagerFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvidesConnectivityManagerFactory(module, applicationProvider);
  }

  public static ConnectivityManager providesConnectivityManager(AppModule instance,
      Application application) {
    return Preconditions.checkNotNullFromProvides(instance.providesConnectivityManager(application));
  }
}
