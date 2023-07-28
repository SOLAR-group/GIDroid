package acr.browser.lightning.browser.di;

import android.app.Application;
import android.content.SharedPreferences;
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
public final class AppModule_ProvideAdBlockPreferencesFactory implements Factory<SharedPreferences> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvideAdBlockPreferencesFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public SharedPreferences get() {
    return provideAdBlockPreferences(module, applicationProvider.get());
  }

  public static AppModule_ProvideAdBlockPreferencesFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvideAdBlockPreferencesFactory(module, applicationProvider);
  }

  public static SharedPreferences provideAdBlockPreferences(AppModule instance,
      Application application) {
    return Preconditions.checkNotNullFromProvides(instance.provideAdBlockPreferences(application));
  }
}
