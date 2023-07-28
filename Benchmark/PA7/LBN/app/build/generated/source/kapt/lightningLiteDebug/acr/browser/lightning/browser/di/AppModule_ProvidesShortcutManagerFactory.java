package acr.browser.lightning.browser.di;

import android.app.Application;
import android.content.pm.ShortcutManager;
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
public final class AppModule_ProvidesShortcutManagerFactory implements Factory<ShortcutManager> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvidesShortcutManagerFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public ShortcutManager get() {
    return providesShortcutManager(module, applicationProvider.get());
  }

  public static AppModule_ProvidesShortcutManagerFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvidesShortcutManagerFactory(module, applicationProvider);
  }

  public static ShortcutManager providesShortcutManager(AppModule instance,
      Application application) {
    return Preconditions.checkNotNullFromProvides(instance.providesShortcutManager(application));
  }
}
