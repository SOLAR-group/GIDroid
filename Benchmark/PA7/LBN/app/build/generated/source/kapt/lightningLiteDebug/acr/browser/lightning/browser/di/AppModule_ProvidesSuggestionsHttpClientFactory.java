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
public final class AppModule_ProvidesSuggestionsHttpClientFactory implements Factory<Single<OkHttpClient>> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvidesSuggestionsHttpClientFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Single<OkHttpClient> get() {
    return providesSuggestionsHttpClient(module, applicationProvider.get());
  }

  public static AppModule_ProvidesSuggestionsHttpClientFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvidesSuggestionsHttpClientFactory(module, applicationProvider);
  }

  public static Single<OkHttpClient> providesSuggestionsHttpClient(AppModule instance,
      Application application) {
    return Preconditions.checkNotNullFromProvides(instance.providesSuggestionsHttpClient(application));
  }
}
