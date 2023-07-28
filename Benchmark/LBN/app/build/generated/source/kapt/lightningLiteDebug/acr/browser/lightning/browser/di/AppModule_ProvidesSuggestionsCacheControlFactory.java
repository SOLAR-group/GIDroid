package acr.browser.lightning.browser.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
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
public final class AppModule_ProvidesSuggestionsCacheControlFactory implements Factory<CacheControl> {
  private final AppModule module;

  public AppModule_ProvidesSuggestionsCacheControlFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public CacheControl get() {
    return providesSuggestionsCacheControl(module);
  }

  public static AppModule_ProvidesSuggestionsCacheControlFactory create(AppModule module) {
    return new AppModule_ProvidesSuggestionsCacheControlFactory(module);
  }

  public static CacheControl providesSuggestionsCacheControl(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesSuggestionsCacheControl());
  }
}
