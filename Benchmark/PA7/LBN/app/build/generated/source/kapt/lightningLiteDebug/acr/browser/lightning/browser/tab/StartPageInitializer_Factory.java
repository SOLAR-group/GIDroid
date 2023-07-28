package acr.browser.lightning.browser.tab;

import acr.browser.lightning.html.homepage.HomePageFactory;
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
public final class StartPageInitializer_Factory implements Factory<StartPageInitializer> {
  private final Provider<HomePageFactory> homePageFactoryProvider;

  private final Provider<Scheduler> diskSchedulerProvider;

  private final Provider<Scheduler> foregroundSchedulerProvider;

  public StartPageInitializer_Factory(Provider<HomePageFactory> homePageFactoryProvider,
      Provider<Scheduler> diskSchedulerProvider, Provider<Scheduler> foregroundSchedulerProvider) {
    this.homePageFactoryProvider = homePageFactoryProvider;
    this.diskSchedulerProvider = diskSchedulerProvider;
    this.foregroundSchedulerProvider = foregroundSchedulerProvider;
  }

  @Override
  public StartPageInitializer get() {
    return newInstance(homePageFactoryProvider.get(), diskSchedulerProvider.get(), foregroundSchedulerProvider.get());
  }

  public static StartPageInitializer_Factory create(
      Provider<HomePageFactory> homePageFactoryProvider, Provider<Scheduler> diskSchedulerProvider,
      Provider<Scheduler> foregroundSchedulerProvider) {
    return new StartPageInitializer_Factory(homePageFactoryProvider, diskSchedulerProvider, foregroundSchedulerProvider);
  }

  public static StartPageInitializer newInstance(HomePageFactory homePageFactory,
      Scheduler diskScheduler, Scheduler foregroundScheduler) {
    return new StartPageInitializer(homePageFactory, diskScheduler, foregroundScheduler);
  }
}
