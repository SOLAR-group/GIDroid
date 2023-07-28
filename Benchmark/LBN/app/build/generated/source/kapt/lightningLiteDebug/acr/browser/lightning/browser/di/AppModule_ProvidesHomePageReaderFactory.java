package acr.browser.lightning.browser.di;

import acr.browser.lightning.html.homepage.HomePageReader;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvidesHomePageReaderFactory implements Factory<HomePageReader> {
  private final AppModule module;

  public AppModule_ProvidesHomePageReaderFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public HomePageReader get() {
    return providesHomePageReader(module);
  }

  public static AppModule_ProvidesHomePageReaderFactory create(AppModule module) {
    return new AppModule_ProvidesHomePageReaderFactory(module);
  }

  public static HomePageReader providesHomePageReader(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesHomePageReader());
  }
}
