package acr.browser.lightning.settings.fragment;

import acr.browser.lightning.adblock.BloomFilterAdBlocker;
import acr.browser.lightning.browser.di.DiskScheduler;
import acr.browser.lightning.browser.di.MainScheduler;
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
public final class AdBlockSettingsFragment_MembersInjector implements MembersInjector<AdBlockSettingsFragment> {
  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<Scheduler> mainSchedulerProvider;

  private final Provider<Scheduler> diskSchedulerProvider;

  private final Provider<BloomFilterAdBlocker> bloomFilterAdBlockerProvider;

  public AdBlockSettingsFragment_MembersInjector(Provider<UserPreferences> userPreferencesProvider,
      Provider<Scheduler> mainSchedulerProvider, Provider<Scheduler> diskSchedulerProvider,
      Provider<BloomFilterAdBlocker> bloomFilterAdBlockerProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
    this.mainSchedulerProvider = mainSchedulerProvider;
    this.diskSchedulerProvider = diskSchedulerProvider;
    this.bloomFilterAdBlockerProvider = bloomFilterAdBlockerProvider;
  }

  public static MembersInjector<AdBlockSettingsFragment> create(
      Provider<UserPreferences> userPreferencesProvider, Provider<Scheduler> mainSchedulerProvider,
      Provider<Scheduler> diskSchedulerProvider,
      Provider<BloomFilterAdBlocker> bloomFilterAdBlockerProvider) {
    return new AdBlockSettingsFragment_MembersInjector(userPreferencesProvider, mainSchedulerProvider, diskSchedulerProvider, bloomFilterAdBlockerProvider);
  }

  @Override
  public void injectMembers(AdBlockSettingsFragment instance) {
    injectUserPreferences(instance, userPreferencesProvider.get());
    injectMainScheduler(instance, mainSchedulerProvider.get());
    injectDiskScheduler(instance, diskSchedulerProvider.get());
    injectBloomFilterAdBlocker(instance, bloomFilterAdBlockerProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.AdBlockSettingsFragment.userPreferences")
  public static void injectUserPreferences(AdBlockSettingsFragment instance,
      UserPreferences userPreferences) {
    instance.userPreferences = userPreferences;
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.AdBlockSettingsFragment.mainScheduler")
  @MainScheduler
  public static void injectMainScheduler(AdBlockSettingsFragment instance,
      Scheduler mainScheduler) {
    instance.mainScheduler = mainScheduler;
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.AdBlockSettingsFragment.diskScheduler")
  @DiskScheduler
  public static void injectDiskScheduler(AdBlockSettingsFragment instance,
      Scheduler diskScheduler) {
    instance.diskScheduler = diskScheduler;
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.AdBlockSettingsFragment.bloomFilterAdBlocker")
  public static void injectBloomFilterAdBlocker(AdBlockSettingsFragment instance,
      BloomFilterAdBlocker bloomFilterAdBlocker) {
    instance.bloomFilterAdBlocker = bloomFilterAdBlocker;
  }
}
