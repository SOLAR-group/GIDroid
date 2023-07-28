package acr.browser.lightning.network;

import android.app.Application;
import android.net.ConnectivityManager;
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
public final class NetworkConnectivityModel_Factory implements Factory<NetworkConnectivityModel> {
  private final Provider<ConnectivityManager> connectivityManagerProvider;

  private final Provider<Application> applicationProvider;

  public NetworkConnectivityModel_Factory(Provider<ConnectivityManager> connectivityManagerProvider,
      Provider<Application> applicationProvider) {
    this.connectivityManagerProvider = connectivityManagerProvider;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public NetworkConnectivityModel get() {
    return newInstance(connectivityManagerProvider.get(), applicationProvider.get());
  }

  public static NetworkConnectivityModel_Factory create(
      Provider<ConnectivityManager> connectivityManagerProvider,
      Provider<Application> applicationProvider) {
    return new NetworkConnectivityModel_Factory(connectivityManagerProvider, applicationProvider);
  }

  public static NetworkConnectivityModel newInstance(ConnectivityManager connectivityManager,
      Application application) {
    return new NetworkConnectivityModel(connectivityManager, application);
  }
}
