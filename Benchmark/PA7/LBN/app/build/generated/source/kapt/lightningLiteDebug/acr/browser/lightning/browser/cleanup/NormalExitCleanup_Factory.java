package acr.browser.lightning.browser.cleanup;

import acr.browser.lightning.database.history.HistoryDatabase;
import acr.browser.lightning.log.Logger;
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
public final class NormalExitCleanup_Factory implements Factory<NormalExitCleanup> {
  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<Logger> loggerProvider;

  private final Provider<HistoryDatabase> historyDatabaseProvider;

  private final Provider<Scheduler> databaseSchedulerProvider;

  private final Provider<Activity> activityProvider;

  public NormalExitCleanup_Factory(Provider<UserPreferences> userPreferencesProvider,
      Provider<Logger> loggerProvider, Provider<HistoryDatabase> historyDatabaseProvider,
      Provider<Scheduler> databaseSchedulerProvider, Provider<Activity> activityProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
    this.loggerProvider = loggerProvider;
    this.historyDatabaseProvider = historyDatabaseProvider;
    this.databaseSchedulerProvider = databaseSchedulerProvider;
    this.activityProvider = activityProvider;
  }

  @Override
  public NormalExitCleanup get() {
    return newInstance(userPreferencesProvider.get(), loggerProvider.get(), historyDatabaseProvider.get(), databaseSchedulerProvider.get(), activityProvider.get());
  }

  public static NormalExitCleanup_Factory create(Provider<UserPreferences> userPreferencesProvider,
      Provider<Logger> loggerProvider, Provider<HistoryDatabase> historyDatabaseProvider,
      Provider<Scheduler> databaseSchedulerProvider, Provider<Activity> activityProvider) {
    return new NormalExitCleanup_Factory(userPreferencesProvider, loggerProvider, historyDatabaseProvider, databaseSchedulerProvider, activityProvider);
  }

  public static NormalExitCleanup newInstance(UserPreferences userPreferences, Logger logger,
      HistoryDatabase historyDatabase, Scheduler databaseScheduler, Activity activity) {
    return new NormalExitCleanup(userPreferences, logger, historyDatabase, databaseScheduler, activity);
  }
}
