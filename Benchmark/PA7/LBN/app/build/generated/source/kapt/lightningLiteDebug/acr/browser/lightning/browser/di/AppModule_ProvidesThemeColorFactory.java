package acr.browser.lightning.browser.di;

import acr.browser.lightning.js.ThemeColor;
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
public final class AppModule_ProvidesThemeColorFactory implements Factory<ThemeColor> {
  private final AppModule module;

  public AppModule_ProvidesThemeColorFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public ThemeColor get() {
    return providesThemeColor(module);
  }

  public static AppModule_ProvidesThemeColorFactory create(AppModule module) {
    return new AppModule_ProvidesThemeColorFactory(module);
  }

  public static ThemeColor providesThemeColor(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesThemeColor());
  }
}
