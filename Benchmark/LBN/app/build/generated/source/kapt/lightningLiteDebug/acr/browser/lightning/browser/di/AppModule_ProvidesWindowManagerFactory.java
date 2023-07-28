package acr.browser.lightning.browser.di;

import android.app.Application;
import android.view.WindowManager;
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
public final class AppModule_ProvidesWindowManagerFactory implements Factory<WindowManager> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvidesWindowManagerFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public WindowManager get() {
    return providesWindowManager(module, applicationProvider.get());
  }

  public static AppModule_ProvidesWindowManagerFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvidesWindowManagerFactory(module, applicationProvider);
  }

  public static WindowManager providesWindowManager(AppModule instance, Application application) {
    return Preconditions.checkNotNullFromProvides(instance.providesWindowManager(application));
  }
}
