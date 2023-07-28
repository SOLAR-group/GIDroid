package acr.browser.lightning.favicon;

import acr.browser.lightning.log.Logger;
import android.app.Application;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class FaviconModel_Factory implements Factory<FaviconModel> {
  private final Provider<Application> applicationProvider;

  private final Provider<Logger> loggerProvider;

  public FaviconModel_Factory(Provider<Application> applicationProvider,
      Provider<Logger> loggerProvider) {
    this.applicationProvider = applicationProvider;
    this.loggerProvider = loggerProvider;
  }

  @Override
  public FaviconModel get() {
    return newInstance(applicationProvider.get(), loggerProvider.get());
  }

  public static FaviconModel_Factory create(Provider<Application> applicationProvider,
      Provider<Logger> loggerProvider) {
    return new FaviconModel_Factory(applicationProvider, loggerProvider);
  }

  public static FaviconModel newInstance(Application application, Logger logger) {
    return new FaviconModel(application, logger);
  }
}
