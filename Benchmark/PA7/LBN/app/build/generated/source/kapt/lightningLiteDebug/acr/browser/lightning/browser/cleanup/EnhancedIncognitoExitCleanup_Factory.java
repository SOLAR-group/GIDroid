package acr.browser.lightning.browser.cleanup;

import acr.browser.lightning.log.Logger;
import android.app.Activity;
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
public final class EnhancedIncognitoExitCleanup_Factory implements Factory<EnhancedIncognitoExitCleanup> {
  private final Provider<Logger> loggerProvider;

  private final Provider<Activity> activityProvider;

  public EnhancedIncognitoExitCleanup_Factory(Provider<Logger> loggerProvider,
      Provider<Activity> activityProvider) {
    this.loggerProvider = loggerProvider;
    this.activityProvider = activityProvider;
  }

  @Override
  public EnhancedIncognitoExitCleanup get() {
    return newInstance(loggerProvider.get(), activityProvider.get());
  }

  public static EnhancedIncognitoExitCleanup_Factory create(Provider<Logger> loggerProvider,
      Provider<Activity> activityProvider) {
    return new EnhancedIncognitoExitCleanup_Factory(loggerProvider, activityProvider);
  }

  public static EnhancedIncognitoExitCleanup newInstance(Logger logger, Activity activity) {
    return new EnhancedIncognitoExitCleanup(logger, activity);
  }
}
