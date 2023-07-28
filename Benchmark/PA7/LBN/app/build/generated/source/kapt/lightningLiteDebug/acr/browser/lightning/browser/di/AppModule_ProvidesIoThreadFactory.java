package acr.browser.lightning.browser.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import io.reactivex.Scheduler;
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
public final class AppModule_ProvidesIoThreadFactory implements Factory<Scheduler> {
  private final AppModule module;

  public AppModule_ProvidesIoThreadFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public Scheduler get() {
    return providesIoThread(module);
  }

  public static AppModule_ProvidesIoThreadFactory create(AppModule module) {
    return new AppModule_ProvidesIoThreadFactory(module);
  }

  public static Scheduler providesIoThread(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesIoThread());
  }
}
