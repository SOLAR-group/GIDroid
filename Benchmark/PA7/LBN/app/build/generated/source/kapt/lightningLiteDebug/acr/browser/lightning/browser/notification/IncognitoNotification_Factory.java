package acr.browser.lightning.browser.notification;

import android.app.Activity;
import android.app.NotificationManager;
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
public final class IncognitoNotification_Factory implements Factory<IncognitoNotification> {
  private final Provider<Activity> activityProvider;

  private final Provider<NotificationManager> notificationManagerProvider;

  public IncognitoNotification_Factory(Provider<Activity> activityProvider,
      Provider<NotificationManager> notificationManagerProvider) {
    this.activityProvider = activityProvider;
    this.notificationManagerProvider = notificationManagerProvider;
  }

  @Override
  public IncognitoNotification get() {
    return newInstance(activityProvider.get(), notificationManagerProvider.get());
  }

  public static IncognitoNotification_Factory create(Provider<Activity> activityProvider,
      Provider<NotificationManager> notificationManagerProvider) {
    return new IncognitoNotification_Factory(activityProvider, notificationManagerProvider);
  }

  public static IncognitoNotification newInstance(Activity activity,
      NotificationManager notificationManager) {
    return new IncognitoNotification(activity, notificationManager);
  }
}
