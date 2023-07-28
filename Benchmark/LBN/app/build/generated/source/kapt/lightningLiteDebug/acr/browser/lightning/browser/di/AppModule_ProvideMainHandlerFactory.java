package acr.browser.lightning.browser.di;

import android.os.Handler;
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
public final class AppModule_ProvideMainHandlerFactory implements Factory<Handler> {
  private final AppModule module;

  public AppModule_ProvideMainHandlerFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public Handler get() {
    return provideMainHandler(module);
  }

  public static AppModule_ProvideMainHandlerFactory create(AppModule module) {
    return new AppModule_ProvideMainHandlerFactory(module);
  }

  public static Handler provideMainHandler(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideMainHandler());
  }
}
