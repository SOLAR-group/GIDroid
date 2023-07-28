package acr.browser.lightning.reading.activity;

import acr.browser.lightning.browser.di.MainScheduler;
import acr.browser.lightning.browser.di.NetworkScheduler;
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
public final class ReadingActivity_MembersInjector implements MembersInjector<ReadingActivity> {
  private final Provider<UserPreferences> mUserPreferencesProvider;

  private final Provider<Scheduler> mNetworkSchedulerProvider;

  private final Provider<Scheduler> mMainSchedulerProvider;

  public ReadingActivity_MembersInjector(Provider<UserPreferences> mUserPreferencesProvider,
      Provider<Scheduler> mNetworkSchedulerProvider, Provider<Scheduler> mMainSchedulerProvider) {
    this.mUserPreferencesProvider = mUserPreferencesProvider;
    this.mNetworkSchedulerProvider = mNetworkSchedulerProvider;
    this.mMainSchedulerProvider = mMainSchedulerProvider;
  }

  public static MembersInjector<ReadingActivity> create(
      Provider<UserPreferences> mUserPreferencesProvider,
      Provider<Scheduler> mNetworkSchedulerProvider, Provider<Scheduler> mMainSchedulerProvider) {
    return new ReadingActivity_MembersInjector(mUserPreferencesProvider, mNetworkSchedulerProvider, mMainSchedulerProvider);
  }

  @Override
  public void injectMembers(ReadingActivity instance) {
    injectMUserPreferences(instance, mUserPreferencesProvider.get());
    injectMNetworkScheduler(instance, mNetworkSchedulerProvider.get());
    injectMMainScheduler(instance, mMainSchedulerProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.reading.activity.ReadingActivity.mUserPreferences")
  public static void injectMUserPreferences(ReadingActivity instance,
      UserPreferences mUserPreferences) {
    instance.mUserPreferences = mUserPreferences;
  }

  @InjectedFieldSignature("acr.browser.lightning.reading.activity.ReadingActivity.mNetworkScheduler")
  @NetworkScheduler
  public static void injectMNetworkScheduler(ReadingActivity instance,
      Scheduler mNetworkScheduler) {
    instance.mNetworkScheduler = mNetworkScheduler;
  }

  @InjectedFieldSignature("acr.browser.lightning.reading.activity.ReadingActivity.mMainScheduler")
  @MainScheduler
  public static void injectMMainScheduler(ReadingActivity instance, Scheduler mMainScheduler) {
    instance.mMainScheduler = mMainScheduler;
  }
}
