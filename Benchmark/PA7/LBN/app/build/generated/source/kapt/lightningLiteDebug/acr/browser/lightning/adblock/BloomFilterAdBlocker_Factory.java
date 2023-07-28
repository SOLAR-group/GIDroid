package acr.browser.lightning.adblock;

import acr.browser.lightning.adblock.source.HostsDataSourceProvider;
import acr.browser.lightning.database.adblock.HostsRepository;
import acr.browser.lightning.database.adblock.HostsRepositoryInfo;
import acr.browser.lightning.log.Logger;
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
public final class BloomFilterAdBlocker_Factory implements Factory<BloomFilterAdBlocker> {
  private final Provider<Logger> loggerProvider;

  private final Provider<HostsDataSourceProvider> hostsDataSourceProvider;

  private final Provider<HostsRepository> hostsRepositoryProvider;

  private final Provider<HostsRepositoryInfo> hostsRepositoryInfoProvider;

  private final Provider<Application> applicationProvider;

  private final Provider<Scheduler> databaseSchedulerProvider;

  private final Provider<Scheduler> mainSchedulerProvider;

  public BloomFilterAdBlocker_Factory(Provider<Logger> loggerProvider,
      Provider<HostsDataSourceProvider> hostsDataSourceProvider,
      Provider<HostsRepository> hostsRepositoryProvider,
      Provider<HostsRepositoryInfo> hostsRepositoryInfoProvider,
      Provider<Application> applicationProvider, Provider<Scheduler> databaseSchedulerProvider,
      Provider<Scheduler> mainSchedulerProvider) {
    this.loggerProvider = loggerProvider;
    this.hostsDataSourceProvider = hostsDataSourceProvider;
    this.hostsRepositoryProvider = hostsRepositoryProvider;
    this.hostsRepositoryInfoProvider = hostsRepositoryInfoProvider;
    this.applicationProvider = applicationProvider;
    this.databaseSchedulerProvider = databaseSchedulerProvider;
    this.mainSchedulerProvider = mainSchedulerProvider;
  }

  @Override
  public BloomFilterAdBlocker get() {
    return newInstance(loggerProvider.get(), hostsDataSourceProvider.get(), hostsRepositoryProvider.get(), hostsRepositoryInfoProvider.get(), applicationProvider.get(), databaseSchedulerProvider.get(), mainSchedulerProvider.get());
  }

  public static BloomFilterAdBlocker_Factory create(Provider<Logger> loggerProvider,
      Provider<HostsDataSourceProvider> hostsDataSourceProvider,
      Provider<HostsRepository> hostsRepositoryProvider,
      Provider<HostsRepositoryInfo> hostsRepositoryInfoProvider,
      Provider<Application> applicationProvider, Provider<Scheduler> databaseSchedulerProvider,
      Provider<Scheduler> mainSchedulerProvider) {
    return new BloomFilterAdBlocker_Factory(loggerProvider, hostsDataSourceProvider, hostsRepositoryProvider, hostsRepositoryInfoProvider, applicationProvider, databaseSchedulerProvider, mainSchedulerProvider);
  }

  public static BloomFilterAdBlocker newInstance(Logger logger,
      HostsDataSourceProvider hostsDataSourceProvider, HostsRepository hostsRepository,
      HostsRepositoryInfo hostsRepositoryInfo, Application application, Scheduler databaseScheduler,
      Scheduler mainScheduler) {
    return new BloomFilterAdBlocker(logger, hostsDataSourceProvider, hostsRepository, hostsRepositoryInfo, application, databaseScheduler, mainScheduler);
  }
}
