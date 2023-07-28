package acr.browser.lightning.browser.di;

import acr.browser.lightning.utils.IntentUtils;
import android.app.Activity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class Browser2Module_ProvidesIntentUtilsFactory implements Factory<IntentUtils> {
  private final Browser2Module module;

  private final Provider<Activity> activityProvider;

  public Browser2Module_ProvidesIntentUtilsFactory(Browser2Module module,
      Provider<Activity> activityProvider) {
    this.module = module;
    this.activityProvider = activityProvider;
  }

  @Override
  public IntentUtils get() {
    return providesIntentUtils(module, activityProvider.get());
  }

  public static Browser2Module_ProvidesIntentUtilsFactory create(Browser2Module module,
      Provider<Activity> activityProvider) {
    return new Browser2Module_ProvidesIntentUtilsFactory(module, activityProvider);
  }

  public static IntentUtils providesIntentUtils(Browser2Module instance, Activity activity) {
    return Preconditions.checkNotNullFromProvides(instance.providesIntentUtils(activity));
  }
}
