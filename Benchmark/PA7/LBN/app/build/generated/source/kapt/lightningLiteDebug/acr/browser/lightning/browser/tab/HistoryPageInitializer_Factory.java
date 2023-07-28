package acr.browser.lightning.browser.tab;

import acr.browser.lightning.html.history.HistoryPageFactory;
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
public final class HistoryPageInitializer_Factory implements Factory<HistoryPageInitializer> {
  private final Provider<HistoryPageFactory> historyPageFactoryProvider;

  private final Provider<Scheduler> diskSchedulerProvider;

  private final Provider<Scheduler> foregroundSchedulerProvider;

  public HistoryPageInitializer_Factory(Provider<HistoryPageFactory> historyPageFactoryProvider,
      Provider<Scheduler> diskSchedulerProvider, Provider<Scheduler> foregroundSchedulerProvider) {
    this.historyPageFactoryProvider = historyPageFactoryProvider;
    this.diskSchedulerProvider = diskSchedulerProvider;
    this.foregroundSchedulerProvider = foregroundSchedulerProvider;
  }

  @Override
  public HistoryPageInitializer get() {
    return newInstance(historyPageFactoryProvider.get(), diskSchedulerProvider.get(), foregroundSchedulerProvider.get());
  }

  public static HistoryPageInitializer_Factory create(
      Provider<HistoryPageFactory> historyPageFactoryProvider,
      Provider<Scheduler> diskSchedulerProvider, Provider<Scheduler> foregroundSchedulerProvider) {
    return new HistoryPageInitializer_Factory(historyPageFactoryProvider, diskSchedulerProvider, foregroundSchedulerProvider);
  }

  public static HistoryPageInitializer newInstance(HistoryPageFactory historyPageFactory,
      Scheduler diskScheduler, Scheduler foregroundScheduler) {
    return new HistoryPageInitializer(historyPageFactory, diskScheduler, foregroundScheduler);
  }
}
