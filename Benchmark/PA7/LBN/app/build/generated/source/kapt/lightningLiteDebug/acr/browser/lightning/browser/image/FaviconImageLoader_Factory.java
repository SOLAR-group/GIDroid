package acr.browser.lightning.browser.image;

import acr.browser.lightning.favicon.FaviconModel;
import android.app.Application;
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
public final class FaviconImageLoader_Factory implements Factory<FaviconImageLoader> {
  private final Provider<FaviconModel> faviconModelProvider;

  private final Provider<Application> applicationProvider;

  private final Provider<Scheduler> networkSchedulerProvider;

  private final Provider<Scheduler> mainSchedulerProvider;

  public FaviconImageLoader_Factory(Provider<FaviconModel> faviconModelProvider,
      Provider<Application> applicationProvider, Provider<Scheduler> networkSchedulerProvider,
      Provider<Scheduler> mainSchedulerProvider) {
    this.faviconModelProvider = faviconModelProvider;
    this.applicationProvider = applicationProvider;
    this.networkSchedulerProvider = networkSchedulerProvider;
    this.mainSchedulerProvider = mainSchedulerProvider;
  }

  @Override
  public FaviconImageLoader get() {
    return newInstance(faviconModelProvider.get(), applicationProvider.get(), networkSchedulerProvider.get(), mainSchedulerProvider.get());
  }

  public static FaviconImageLoader_Factory create(Provider<FaviconModel> faviconModelProvider,
      Provider<Application> applicationProvider, Provider<Scheduler> networkSchedulerProvider,
      Provider<Scheduler> mainSchedulerProvider) {
    return new FaviconImageLoader_Factory(faviconModelProvider, applicationProvider, networkSchedulerProvider, mainSchedulerProvider);
  }

  public static FaviconImageLoader newInstance(FaviconModel faviconModel, Application application,
      Scheduler networkScheduler, Scheduler mainScheduler) {
    return new FaviconImageLoader(faviconModel, application, networkScheduler, mainScheduler);
  }
}
