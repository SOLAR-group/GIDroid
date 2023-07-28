package acr.browser.lightning.browser.di;

import android.app.Application;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.Single;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvidesHostsHttpClientFactory implements Factory<Single<OkHttpClient>> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvidesHostsHttpClientFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Single<OkHttpClient> get() {
    return providesHostsHttpClient(module, applicationProvider.get());
  }

  public static AppModule_ProvidesHostsHttpClientFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvidesHostsHttpClientFactory(module, applicationProvider);
  }

  public static Single<OkHttpClient> providesHostsHttpClient(AppModule instance,
      Application application) {
    return Preconditions.checkNotNullFromProvides(instance.providesHostsHttpClient(application));
  }
}
