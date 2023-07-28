package acr.browser.lightning.settings.activity;

import acr.browser.lightning.device.BuildInfo;
import acr.browser.lightning.preference.UserPreferences;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
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
public final class SettingsActivity_MembersInjector implements MembersInjector<SettingsActivity> {
  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<BuildInfo> buildInfoProvider;

  public SettingsActivity_MembersInjector(Provider<UserPreferences> userPreferencesProvider,
      Provider<BuildInfo> buildInfoProvider) {
    this.userPreferencesProvider = userPreferencesProvider;
    this.buildInfoProvider = buildInfoProvider;
  }

  public static MembersInjector<SettingsActivity> create(
      Provider<UserPreferences> userPreferencesProvider, Provider<BuildInfo> buildInfoProvider) {
    return new SettingsActivity_MembersInjector(userPreferencesProvider, buildInfoProvider);
  }

  @Override
  public void injectMembers(SettingsActivity instance) {
    ThemableSettingsActivity_MembersInjector.injectUserPreferences(instance, userPreferencesProvider.get());
    injectBuildInfo(instance, buildInfoProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.activity.SettingsActivity.buildInfo")
  public static void injectBuildInfo(SettingsActivity instance, BuildInfo buildInfo) {
    instance.buildInfo = buildInfo;
  }
}
