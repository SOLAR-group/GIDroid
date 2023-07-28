package acr.browser.lightning.browser.di;

import android.app.Application;
import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideContextFactory implements Factory<Context> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvideContextFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public Context get() {
    return provideContext(module, applicationProvider.get());
  }

  public static AppModule_ProvideContextFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvideContextFactory(module, applicationProvider);
  }

  public static Context provideContext(AppModule instance, Application application) {
    return Preconditions.checkNotNullFromProvides(instance.provideContext(application));
  }
}
