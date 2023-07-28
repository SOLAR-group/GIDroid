package acr.browser.lightning.browser.tab;

import acr.browser.lightning.log.Logger;
import acr.browser.lightning.utils.IntentUtils;
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
public final class UrlHandler_Factory implements Factory<UrlHandler> {
  private final Provider<Activity> activityProvider;

  private final Provider<Logger> loggerProvider;

  private final Provider<IntentUtils> intentUtilsProvider;

  private final Provider<Boolean> incognitoModeProvider;

  public UrlHandler_Factory(Provider<Activity> activityProvider, Provider<Logger> loggerProvider,
      Provider<IntentUtils> intentUtilsProvider, Provider<Boolean> incognitoModeProvider) {
    this.activityProvider = activityProvider;
    this.loggerProvider = loggerProvider;
    this.intentUtilsProvider = intentUtilsProvider;
    this.incognitoModeProvider = incognitoModeProvider;
  }

  @Override
  public UrlHandler get() {
    return newInstance(activityProvider.get(), loggerProvider.get(), intentUtilsProvider.get(), incognitoModeProvider.get());
  }

  public static UrlHandler_Factory create(Provider<Activity> activityProvider,
      Provider<Logger> loggerProvider, Provider<IntentUtils> intentUtilsProvider,
      Provider<Boolean> incognitoModeProvider) {
    return new UrlHandler_Factory(activityProvider, loggerProvider, intentUtilsProvider, incognitoModeProvider);
  }

  public static UrlHandler newInstance(Activity activity, Logger logger, IntentUtils intentUtils,
      boolean incognitoMode) {
    return new UrlHandler(activity, logger, intentUtils, incognitoMode);
  }
}
