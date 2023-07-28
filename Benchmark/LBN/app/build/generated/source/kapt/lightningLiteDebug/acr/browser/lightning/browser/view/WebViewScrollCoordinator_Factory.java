package acr.browser.lightning.browser.view;

import acr.browser.lightning.preference.UserPreferences;
import android.app.Activity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
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
public final class WebViewScrollCoordinator_Factory implements Factory<WebViewScrollCoordinator> {
  private final Provider<Activity> activityProvider;

  private final Provider<FrameLayout> browserFrameProvider;

  private final Provider<LinearLayout> toolbarRootProvider;

  private final Provider<View> toolbarProvider;

  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<InputMethodManager> inputMethodManagerProvider;

  public WebViewScrollCoordinator_Factory(Provider<Activity> activityProvider,
      Provider<FrameLayout> browserFrameProvider, Provider<LinearLayout> toolbarRootProvider,
      Provider<View> toolbarProvider, Provider<UserPreferences> userPreferencesProvider,
      Provider<InputMethodManager> inputMethodManagerProvider) {
    this.activityProvider = activityProvider;
    this.browserFrameProvider = browserFrameProvider;
    this.toolbarRootProvider = toolbarRootProvider;
    this.toolbarProvider = toolbarProvider;
    this.userPreferencesProvider = userPreferencesProvider;
    this.inputMethodManagerProvider = inputMethodManagerProvider;
  }

  @Override
  public WebViewScrollCoordinator get() {
    return newInstance(activityProvider.get(), browserFrameProvider.get(), toolbarRootProvider.get(), toolbarProvider.get(), userPreferencesProvider.get(), inputMethodManagerProvider.get());
  }

  public static WebViewScrollCoordinator_Factory create(Provider<Activity> activityProvider,
      Provider<FrameLayout> browserFrameProvider, Provider<LinearLayout> toolbarRootProvider,
      Provider<View> toolbarProvider, Provider<UserPreferences> userPreferencesProvider,
      Provider<InputMethodManager> inputMethodManagerProvider) {
    return new WebViewScrollCoordinator_Factory(activityProvider, browserFrameProvider, toolbarRootProvider, toolbarProvider, userPreferencesProvider, inputMethodManagerProvider);
  }

  public static WebViewScrollCoordinator newInstance(Activity activity, FrameLayout browserFrame,
      LinearLayout toolbarRoot, View toolbar, UserPreferences userPreferences,
      InputMethodManager inputMethodManager) {
    return new WebViewScrollCoordinator(activity, browserFrame, toolbarRoot, toolbar, userPreferences, inputMethodManager);
  }
}
