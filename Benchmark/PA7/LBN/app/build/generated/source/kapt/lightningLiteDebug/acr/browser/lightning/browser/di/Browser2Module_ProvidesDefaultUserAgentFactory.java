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
public final class Browser2Module_ProvidesDefaultUserAgentFactory implements Factory<String> {
  private final Browser2Module module;

  private final Provider<Application> applicationProvider;

  public Browser2Module_ProvidesDefaultUserAgentFactory(Browser2Module module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public String get() {
    return providesDefaultUserAgent(module, applicationProvider.get());
  }

  public static Browser2Module_ProvidesDefaultUserAgentFactory create(Browser2Module module,
      Provider<Application> applicationProvider) {
    return new Browser2Module_ProvidesDefaultUserAgentFactory(module, applicationProvider);
  }

  public static String providesDefaultUserAgent(Browser2Module instance, Application application) {
    return Preconditions.checkNotNullFromProvides(instance.providesDefaultUserAgent(application));
  }
}
