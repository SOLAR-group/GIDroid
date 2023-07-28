package acr.browser.lightning.browser.di;

import acr.browser.lightning.js.TextReflow;
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
public final class AppModule_ProvidesTextReflowFactory implements Factory<TextReflow> {
  private final AppModule module;

  public AppModule_ProvidesTextReflowFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public TextReflow get() {
    return providesTextReflow(module);
  }

  public static AppModule_ProvidesTextReflowFactory create(AppModule module) {
    return new AppModule_ProvidesTextReflowFactory(module);
  }

  public static TextReflow providesTextReflow(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesTextReflow());
  }
}
