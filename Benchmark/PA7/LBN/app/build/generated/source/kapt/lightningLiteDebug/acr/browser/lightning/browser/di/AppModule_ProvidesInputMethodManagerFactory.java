package acr.browser.lightning.browser.di;

import android.app.Application;
import android.view.inputmethod.InputMethodManager;
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
public final class AppModule_ProvidesInputMethodManagerFactory implements Factory<InputMethodManager> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvidesInputMethodManagerFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public InputMethodManager get() {
    return providesInputMethodManager(module, applicationProvider.get());
  }

  public static AppModule_ProvidesInputMethodManagerFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvidesInputMethodManagerFactory(module, applicationProvider);
  }

  public static InputMethodManager providesInputMethodManager(AppModule instance,
      Application application) {
    return Preconditions.checkNotNullFromProvides(instance.providesInputMethodManager(application));
  }
}
