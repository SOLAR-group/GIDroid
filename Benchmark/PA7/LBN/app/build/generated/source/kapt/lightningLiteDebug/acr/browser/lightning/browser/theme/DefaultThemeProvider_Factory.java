package acr.browser.lightning.browser.theme;

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
public final class DefaultThemeProvider_Factory implements Factory<DefaultThemeProvider> {
  private final Provider<Activity> activityProvider;

  public DefaultThemeProvider_Factory(Provider<Activity> activityProvider) {
    this.activityProvider = activityProvider;
  }

  @Override
  public DefaultThemeProvider get() {
    return newInstance(activityProvider.get());
  }

  public static DefaultThemeProvider_Factory create(Provider<Activity> activityProvider) {
    return new DefaultThemeProvider_Factory(activityProvider);
  }

  public static DefaultThemeProvider newInstance(Activity activity) {
    return new DefaultThemeProvider(activity);
  }
}
