package acr.browser.lightning.adblock.allowlist;

import acr.browser.lightning.database.allowlist.AdBlockAllowListRepository;
import acr.browser.lightning.log.Logger;
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
public final class SessionAllowListModel_Factory implements Factory<SessionAllowListModel> {
  private final Provider<AdBlockAllowListRepository> adBlockAllowListModelProvider;

  private final Provider<Scheduler> ioSchedulerProvider;

  private final Provider<Logger> loggerProvider;

  public SessionAllowListModel_Factory(
      Provider<AdBlockAllowListRepository> adBlockAllowListModelProvider,
      Provider<Scheduler> ioSchedulerProvider, Provider<Logger> loggerProvider) {
    this.adBlockAllowListModelProvider = adBlockAllowListModelProvider;
    this.ioSchedulerProvider = ioSchedulerProvider;
    this.loggerProvider = loggerProvider;
  }

  @Override
  public SessionAllowListModel get() {
    return newInstance(adBlockAllowListModelProvider.get(), ioSchedulerProvider.get(), loggerProvider.get());
  }

  public static SessionAllowListModel_Factory create(
      Provider<AdBlockAllowListRepository> adBlockAllowListModelProvider,
      Provider<Scheduler> ioSchedulerProvider, Provider<Logger> loggerProvider) {
    return new SessionAllowListModel_Factory(adBlockAllowListModelProvider, ioSchedulerProvider, loggerProvider);
  }

  public static SessionAllowListModel newInstance(AdBlockAllowListRepository adBlockAllowListModel,
      Scheduler ioScheduler, Logger logger) {
    return new SessionAllowListModel(adBlockAllowListModel, ioScheduler, logger);
  }
}
