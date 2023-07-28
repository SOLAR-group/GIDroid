package acr.browser.lightning.browser.di;

import acr.browser.lightning.search.suggestions.RequestFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.CacheControl;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvidesSuggestionsRequestFactoryFactory implements Factory<RequestFactory> {
  private final AppModule module;

  private final Provider<CacheControl> cacheControlProvider;

  public AppModule_ProvidesSuggestionsRequestFactoryFactory(AppModule module,
      Provider<CacheControl> cacheControlProvider) {
    this.module = module;
    this.cacheControlProvider = cacheControlProvider;
  }

  @Override
  public RequestFactory get() {
    return providesSuggestionsRequestFactory(module, cacheControlProvider.get());
  }

  public static AppModule_ProvidesSuggestionsRequestFactoryFactory create(AppModule module,
      Provider<CacheControl> cacheControlProvider) {
    return new AppModule_ProvidesSuggestionsRequestFactoryFactory(module, cacheControlProvider);
  }

  public static RequestFactory providesSuggestionsRequestFactory(AppModule instance,
      CacheControl cacheControl) {
    return Preconditions.checkNotNullFromProvides(instance.providesSuggestionsRequestFactory(cacheControl));
  }
}
