package acr.browser.lightning.browser.tab;

import android.app.Activity;
import dagger.internal.DaggerGenerated;
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
public final class PermissionInitializer_Factory {
  private final Provider<Activity> activityProvider;

  private final Provider<HomePageInitializer> homePageInitializerProvider;

  public PermissionInitializer_Factory(Provider<Activity> activityProvider,
      Provider<HomePageInitializer> homePageInitializerProvider) {
    this.activityProvider = activityProvider;
    this.homePageInitializerProvider = homePageInitializerProvider;
  }

  public PermissionInitializer get(String url) {
    return newInstance(url, activityProvider.get(), homePageInitializerProvider.get());
  }

  public static PermissionInitializer_Factory create(Provider<Activity> activityProvider,
      Provider<HomePageInitializer> homePageInitializerProvider) {
    return new PermissionInitializer_Factory(activityProvider, homePageInitializerProvider);
  }

  public static PermissionInitializer newInstance(String url, Activity activity,
      HomePageInitializer homePageInitializer) {
    return new PermissionInitializer(url, activity, homePageInitializer);
  }
}
