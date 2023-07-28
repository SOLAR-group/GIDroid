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
public final class AppModule_ProvidesDiskThreadFactory implements Factory<Scheduler> {
  private final AppModule module;

  public AppModule_ProvidesDiskThreadFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public Scheduler get() {
    return providesDiskThread(module);
  }

  public static AppModule_ProvidesDiskThreadFactory create(AppModule module) {
    return new AppModule_ProvidesDiskThreadFactory(module);
  }

  public static Scheduler providesDiskThread(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesDiskThread());
  }
}
