package acr.browser.lightning.browser.di;

import acr.browser.lightning.js.InvertPage;
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
public final class AppModule_ProvidesInvertPageFactory implements Factory<InvertPage> {
  private final AppModule module;

  public AppModule_ProvidesInvertPageFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public InvertPage get() {
    return providesInvertPage(module);
  }

  public static AppModule_ProvidesInvertPageFactory create(AppModule module) {
    return new AppModule_ProvidesInvertPageFactory(module);
  }

  public static InvertPage providesInvertPage(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesInvertPage());
  }
}
