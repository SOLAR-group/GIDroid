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
public final class AppModule_ProvidesNetworkThreadFactory implements Factory<Scheduler> {
  private final AppModule module;

  public AppModule_ProvidesNetworkThreadFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public Scheduler get() {
    return providesNetworkThread(module);
  }

  public static AppModule_ProvidesNetworkThreadFactory create(AppModule module) {
    return new AppModule_ProvidesNetworkThreadFactory(module);
  }

  public static Scheduler providesNetworkThread(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesNetworkThread());
  }
}
