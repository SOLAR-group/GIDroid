package acr.browser.lightning.browser.di;

import android.app.Application;
import android.content.ClipboardManager;
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
public final class AppModule_ProvidesClipboardManagerFactory implements Factory<ClipboardManager> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvidesClipboardManagerFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public ClipboardManager get() {
    return providesClipboardManager(module, applicationProvider.get());
  }

  public static AppModule_ProvidesClipboardManagerFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvidesClipboardManagerFactory(module, applicationProvider);
  }

  public static ClipboardManager providesClipboardManager(AppModule instance,
      Application application) {
    return Preconditions.checkNotNullFromProvides(instance.providesClipboardManager(application));
  }
}
