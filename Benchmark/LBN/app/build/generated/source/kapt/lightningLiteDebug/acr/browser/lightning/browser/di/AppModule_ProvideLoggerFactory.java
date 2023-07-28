package acr.browser.lightning.browser.di;

import acr.browser.lightning.device.BuildInfo;
import acr.browser.lightning.log.Logger;
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
public final class AppModule_ProvideLoggerFactory implements Factory<Logger> {
  private final AppModule module;

  private final Provider<BuildInfo> buildInfoProvider;

  public AppModule_ProvideLoggerFactory(AppModule module, Provider<BuildInfo> buildInfoProvider) {
    this.module = module;
    this.buildInfoProvider = buildInfoProvider;
  }

  @Override
  public Logger get() {
    return provideLogger(module, buildInfoProvider.get());
  }

  public static AppModule_ProvideLoggerFactory create(AppModule module,
      Provider<BuildInfo> buildInfoProvider) {
    return new AppModule_ProvideLoggerFactory(module, buildInfoProvider);
  }

  public static Logger provideLogger(AppModule instance, BuildInfo buildInfo) {
    return Preconditions.checkNotNullFromProvides(instance.provideLogger(buildInfo));
  }
}
