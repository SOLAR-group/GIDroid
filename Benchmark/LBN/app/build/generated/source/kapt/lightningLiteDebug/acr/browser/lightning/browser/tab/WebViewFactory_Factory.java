package acr.browser.lightning.browser.tab;

import acr.browser.lightning.log.Logger;
import acr.browser.lightning.preference.UserPreferences;
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
public final class WebViewFactory_Factory implements Factory<WebViewFactory> {
  private final Provider<Activity> activityProvider;

  private final Provider<Logger> loggerProvider;

  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<Boolean> incognitoModeProvider;

  public WebViewFactory_Factory(Provider<Activity> activityProvider,
      Provider<Logger> loggerProvider, Provider<UserPreferences> userPreferencesProvider,
      Provider<Boolean> incognitoModeProvider) {
    this.activityProvider = activityProvider;
    this.loggerProvider = loggerProvider;
    this.userPreferencesProvider = userPreferencesProvider;
    this.incognitoModeProvider = incognitoModeProvider;
  }

  @Override
  public WebViewFactory get() {
    return newInstance(activityProvider.get(), loggerProvider.get(), userPreferencesProvider.get(), incognitoModeProvider.get());
  }

  public static WebViewFactory_Factory create(Provider<Activity> activityProvider,
      Provider<Logger> loggerProvider, Provider<UserPreferences> userPreferencesProvider,
      Provider<Boolean> incognitoModeProvider) {
    return new WebViewFactory_Factory(activityProvider, loggerProvider, userPreferencesProvider, incognitoModeProvider);
  }

  public static WebViewFactory newInstance(Activity activity, Logger logger,
      UserPreferences userPreferences, boolean incognitoMode) {
    return new WebViewFactory(activity, logger, userPreferences, incognitoMode);
  }
}
