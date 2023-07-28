package acr.browser.lightning.browser.view;

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
public final class WebViewLongPressHandler_Factory implements Factory<WebViewLongPressHandler> {
  private final Provider<Activity> activityProvider;

  public WebViewLongPressHandler_Factory(Provider<Activity> activityProvider) {
    this.activityProvider = activityProvider;
  }

  @Override
  public WebViewLongPressHandler get() {
    return newInstance(activityProvider.get());
  }

  public static WebViewLongPressHandler_Factory create(Provider<Activity> activityProvider) {
    return new WebViewLongPressHandler_Factory(activityProvider);
  }

  public static WebViewLongPressHandler newInstance(Activity activity) {
    return new WebViewLongPressHandler(activity);
  }
}
