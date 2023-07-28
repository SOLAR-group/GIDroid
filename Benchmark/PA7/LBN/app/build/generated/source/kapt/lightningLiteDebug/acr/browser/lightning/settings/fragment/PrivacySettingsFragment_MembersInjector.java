package acr.browser.lightning.settings.fragment;

import acr.browser.lightning.browser.di.DatabaseScheduler;
import acr.browser.lightning.browser.di.MainScheduler;
import acr.browser.lightning.database.history.HistoryRepository;
import acr.browser.lightning.preference.UserPreferences;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
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
public final class PrivacySettingsFragment_MembersInjector implements MembersInjector<PrivacySettingsFragment> {
  private final Provider<HistoryRepository> historyRepositoryProvider;

  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<Scheduler> databaseSchedulerProvider;

  private final Provider<Scheduler> mainSchedulerProvider;

  public PrivacySettingsFragment_MembersInjector(
      Provider<HistoryRepository> historyRepositoryProvider,
      Provider<UserPreferences> userPreferencesProvider,
      Provider<Scheduler> databaseSchedulerProvider, Provider<Scheduler> mainSchedulerProvider) {
    this.historyRepositoryProvider = historyRepositoryProvider;
    this.userPreferencesProvider = userPreferencesProvider;
    this.databaseSchedulerProvider = databaseSchedulerProvider;
    this.mainSchedulerProvider = mainSchedulerProvider;
  }

  public static MembersInjector<PrivacySettingsFragment> create(
      Provider<HistoryRepository> historyRepositoryProvider,
      Provider<UserPreferences> userPreferencesProvider,
      Provider<Scheduler> databaseSchedulerProvider, Provider<Scheduler> mainSchedulerProvider) {
    return new PrivacySettingsFragment_MembersInjector(historyRepositoryProvider, userPreferencesProvider, databaseSchedulerProvider, mainSchedulerProvider);
  }

  @Override
  public void injectMembers(PrivacySettingsFragment instance) {
    injectHistoryRepository(instance, historyRepositoryProvider.get());
    injectUserPreferences(instance, userPreferencesProvider.get());
    injectDatabaseScheduler(instance, databaseSchedulerProvider.get());
    injectMainScheduler(instance, mainSchedulerProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.PrivacySettingsFragment.historyRepository")
  public static void injectHistoryRepository(PrivacySettingsFragment instance,
      HistoryRepository historyRepository) {
    instance.historyRepository = historyRepository;
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.PrivacySettingsFragment.userPreferences")
  public static void injectUserPreferences(PrivacySettingsFragment instance,
      UserPreferences userPreferences) {
    instance.userPreferences = userPreferences;
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.PrivacySettingsFragment.databaseScheduler")
  @DatabaseScheduler
  public static void injectDatabaseScheduler(PrivacySettingsFragment instance,
      Scheduler databaseScheduler) {
    instance.databaseScheduler = databaseScheduler;
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.PrivacySettingsFragment.mainScheduler")
  @MainScheduler
  public static void injectMainScheduler(PrivacySettingsFragment instance,
      Scheduler mainScheduler) {
    instance.mainScheduler = mainScheduler;
  }
}
