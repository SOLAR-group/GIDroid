package acr.browser.lightning.browser.di;

import android.app.Application;
import android.app.DownloadManager;
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
public final class AppModule_ProvidesDownloadManagerFactory implements Factory<DownloadManager> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvidesDownloadManagerFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public DownloadManager get() {
    return providesDownloadManager(module, applicationProvider.get());
  }

  public static AppModule_ProvidesDownloadManagerFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvidesDownloadManagerFactory(module, applicationProvider);
  }

  public static DownloadManager providesDownloadManager(AppModule instance,
      Application application) {
    return Preconditions.checkNotNullFromProvides(instance.providesDownloadManager(application));
  }
}
