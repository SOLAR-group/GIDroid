package acr.browser.lightning.browser.di;

import android.app.Application;
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
public final class AppModule_ProvidesDefaultTabTitleFactory implements Factory<String> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvidesDefaultTabTitleFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public String get() {
    return providesDefaultTabTitle(module, applicationProvider.get());
  }

  public static AppModule_ProvidesDefaultTabTitleFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvidesDefaultTabTitleFactory(module, applicationProvider);
  }

  public static String providesDefaultTabTitle(AppModule instance, Application application) {
    return Preconditions.checkNotNullFromProvides(instance.providesDefaultTabTitle(application));
  }
}
