package acr.browser.lightning.browser.di;

import android.app.Activity;
import android.graphics.Bitmap;
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
public final class Browser2Module_ProvidesFrozenIconFactory implements Factory<Bitmap> {
  private final Browser2Module module;

  private final Provider<Activity> activityProvider;

  public Browser2Module_ProvidesFrozenIconFactory(Browser2Module module,
      Provider<Activity> activityProvider) {
    this.module = module;
    this.activityProvider = activityProvider;
  }

  @Override
  public Bitmap get() {
    return providesFrozenIcon(module, activityProvider.get());
  }

  public static Browser2Module_ProvidesFrozenIconFactory create(Browser2Module module,
      Provider<Activity> activityProvider) {
    return new Browser2Module_ProvidesFrozenIconFactory(module, activityProvider);
  }

  public static Bitmap providesFrozenIcon(Browser2Module instance, Activity activity) {
    return Preconditions.checkNotNullFromProvides(instance.providesFrozenIcon(activity));
  }
}
