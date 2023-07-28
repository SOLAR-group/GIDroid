package acr.browser.lightning.browser.di;

import android.app.Application;
import android.app.NotificationManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvidesNotificationManagerFactory implements Factory<NotificationManager> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvidesNotificationManagerFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public NotificationManager get() {
    return providesNotificationManager(module, applicationProvider.get());
  }

  public static AppModule_ProvidesNotificationManagerFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvidesNotificationManagerFactory(module, applicationProvider);
  }

  public static NotificationManager providesNotificationManager(AppModule instance,
      Application application) {
    return Preconditions.checkNotNullFromProvides(instance.providesNotificationManager(application));
  }
}
