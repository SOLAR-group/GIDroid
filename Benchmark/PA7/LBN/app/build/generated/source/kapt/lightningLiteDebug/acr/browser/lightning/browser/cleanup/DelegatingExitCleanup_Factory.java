package acr.browser.lightning.browser.cleanup;

import android.app.Activity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class DelegatingExitCleanup_Factory implements Factory<DelegatingExitCleanup> {
  private final Provider<BasicIncognitoExitCleanup> basicIncognitoExitCleanupProvider;

  private final Provider<EnhancedIncognitoExitCleanup> enhancedIncognitoExitCleanupProvider;

  private final Provider<NormalExitCleanup> normalExitCleanupProvider;

  private final Provider<Activity> activityProvider;

  public DelegatingExitCleanup_Factory(
      Provider<BasicIncognitoExitCleanup> basicIncognitoExitCleanupProvider,
      Provider<EnhancedIncognitoExitCleanup> enhancedIncognitoExitCleanupProvider,
      Provider<NormalExitCleanup> normalExitCleanupProvider, Provider<Activity> activityProvider) {
    this.basicIncognitoExitCleanupProvider = basicIncognitoExitCleanupProvider;
    this.enhancedIncognitoExitCleanupProvider = enhancedIncognitoExitCleanupProvider;
    this.normalExitCleanupProvider = normalExitCleanupProvider;
    this.activityProvider = activityProvider;
  }

  @Override
  public DelegatingExitCleanup get() {
    return newInstance(basicIncognitoExitCleanupProvider.get(), enhancedIncognitoExitCleanupProvider.get(), normalExitCleanupProvider.get(), activityProvider.get());
  }

  public static DelegatingExitCleanup_Factory create(
      Provider<BasicIncognitoExitCleanup> basicIncognitoExitCleanupProvider,
      Provider<EnhancedIncognitoExitCleanup> enhancedIncognitoExitCleanupProvider,
      Provider<NormalExitCleanup> normalExitCleanupProvider, Provider<Activity> activityProvider) {
    return new DelegatingExitCleanup_Factory(basicIncognitoExitCleanupProvider, enhancedIncognitoExitCleanupProvider, normalExitCleanupProvider, activityProvider);
  }

  public static DelegatingExitCleanup newInstance(
      BasicIncognitoExitCleanup basicIncognitoExitCleanup,
      EnhancedIncognitoExitCleanup enhancedIncognitoExitCleanup,
      NormalExitCleanup normalExitCleanup, Activity activity) {
    return new DelegatingExitCleanup(basicIncognitoExitCleanup, enhancedIncognitoExitCleanup, normalExitCleanup, activity);
  }
}
