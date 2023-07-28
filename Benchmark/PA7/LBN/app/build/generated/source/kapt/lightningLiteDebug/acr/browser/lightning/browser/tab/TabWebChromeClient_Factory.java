package acr.browser.lightning.browser.tab;

import acr.browser.lightning.browser.webrtc.WebRtcPermissionsModel;
import acr.browser.lightning.favicon.FaviconModel;
import acr.browser.lightning.preference.UserPreferences;
import android.app.Activity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import io.reactivex.Scheduler;
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
public final class TabWebChromeClient_Factory implements Factory<TabWebChromeClient> {
  private final Provider<Activity> activityProvider;

  private final Provider<FaviconModel> faviconModelProvider;

  private final Provider<Scheduler> diskSchedulerProvider;

  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<WebRtcPermissionsModel> webRtcPermissionsModelProvider;

  public TabWebChromeClient_Factory(Provider<Activity> activityProvider,
      Provider<FaviconModel> faviconModelProvider, Provider<Scheduler> diskSchedulerProvider,
      Provider<UserPreferences> userPreferencesProvider,
      Provider<WebRtcPermissionsModel> webRtcPermissionsModelProvider) {
    this.activityProvider = activityProvider;
    this.faviconModelProvider = faviconModelProvider;
    this.diskSchedulerProvider = diskSchedulerProvider;
    this.userPreferencesProvider = userPreferencesProvider;
    this.webRtcPermissionsModelProvider = webRtcPermissionsModelProvider;
  }

  @Override
  public TabWebChromeClient get() {
    return newInstance(activityProvider.get(), faviconModelProvider.get(), diskSchedulerProvider.get(), userPreferencesProvider.get(), webRtcPermissionsModelProvider.get());
  }

  public static TabWebChromeClient_Factory create(Provider<Activity> activityProvider,
      Provider<FaviconModel> faviconModelProvider, Provider<Scheduler> diskSchedulerProvider,
      Provider<UserPreferences> userPreferencesProvider,
      Provider<WebRtcPermissionsModel> webRtcPermissionsModelProvider) {
    return new TabWebChromeClient_Factory(activityProvider, faviconModelProvider, diskSchedulerProvider, userPreferencesProvider, webRtcPermissionsModelProvider);
  }

  public static TabWebChromeClient newInstance(Activity activity, FaviconModel faviconModel,
      Scheduler diskScheduler, UserPreferences userPreferences,
      WebRtcPermissionsModel webRtcPermissionsModel) {
    return new TabWebChromeClient(activity, faviconModel, diskScheduler, userPreferences, webRtcPermissionsModel);
  }
}
