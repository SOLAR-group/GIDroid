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
public final class AppModule_ProvidesMainThreadFactory implements Factory<Scheduler> {
  private final AppModule module;

  public AppModule_ProvidesMainThreadFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public Scheduler get() {
    return providesMainThread(module);
  }

  public static AppModule_ProvidesMainThreadFactory create(AppModule module) {
    return new AppModule_ProvidesMainThreadFactory(module);
  }

  public static Scheduler providesMainThread(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesMainThread());
  }
}
