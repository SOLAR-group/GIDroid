package acr.browser.lightning.browser.history;

import acr.browser.lightning.database.history.HistoryRepository;
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
public final class DefaultHistoryRecord_Factory implements Factory<DefaultHistoryRecord> {
  private final Provider<HistoryRepository> historyRepositoryProvider;

  private final Provider<Scheduler> databaseSchedulerProvider;

  public DefaultHistoryRecord_Factory(Provider<HistoryRepository> historyRepositoryProvider,
      Provider<Scheduler> databaseSchedulerProvider) {
    this.historyRepositoryProvider = historyRepositoryProvider;
    this.databaseSchedulerProvider = databaseSchedulerProvider;
  }

  @Override
  public DefaultHistoryRecord get() {
    return newInstance(historyRepositoryProvider.get(), databaseSchedulerProvider.get());
  }

  public static DefaultHistoryRecord_Factory create(
      Provider<HistoryRepository> historyRepositoryProvider,
      Provider<Scheduler> databaseSchedulerProvider) {
    return new DefaultHistoryRecord_Factory(historyRepositoryProvider, databaseSchedulerProvider);
  }

  public static DefaultHistoryRecord newInstance(HistoryRepository historyRepository,
      Scheduler databaseScheduler) {
    return new DefaultHistoryRecord(historyRepository, databaseScheduler);
  }
}
