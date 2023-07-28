package acr.browser.lightning.browser.di;

import android.app.Application;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import javax.annotation.Generated;
import javax.inject.Provider;
import net.i2p.android.ui.I2PAndroidHelper;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AppModule_ProvideI2PAndroidHelperFactory implements Factory<I2PAndroidHelper> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvideI2PAndroidHelperFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public I2PAndroidHelper get() {
    return provideI2PAndroidHelper(module, applicationProvider.get());
  }

  public static AppModule_ProvideI2PAndroidHelperFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvideI2PAndroidHelperFactory(module, applicationProvider);
  }

  public static I2PAndroidHelper provideI2PAndroidHelper(AppModule instance,
      Application application) {
    return Preconditions.checkNotNullFromProvides(instance.provideI2PAndroidHelper(application));
  }
}
