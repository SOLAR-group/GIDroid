package acr.browser.lightning.browser.di;

import android.app.Application;
import android.content.res.AssetManager;
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
public final class AppModule_ProvidesAssetManagerFactory implements Factory<AssetManager> {
  private final AppModule module;

  private final Provider<Application> applicationProvider;

  public AppModule_ProvidesAssetManagerFactory(AppModule module,
      Provider<Application> applicationProvider) {
    this.module = module;
    this.applicationProvider = applicationProvider;
  }

  @Override
  public AssetManager get() {
    return providesAssetManager(module, applicationProvider.get());
  }

  public static AppModule_ProvidesAssetManagerFactory create(AppModule module,
      Provider<Application> applicationProvider) {
    return new AppModule_ProvidesAssetManagerFactory(module, applicationProvider);
  }

  public static AssetManager providesAssetManager(AppModule instance, Application application) {
    return Preconditions.checkNotNullFromProvides(instance.providesAssetManager(application));
  }
}
