package acr.browser.lightning.adblock.source;

import acr.browser.lightning.adblock.parser.HostsFileParser;
import acr.browser.lightning.log.Logger;
import android.content.res.AssetManager;
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
public final class AssetsHostsDataSource_Factory implements Factory<AssetsHostsDataSource> {
  private final Provider<AssetManager> assetManagerProvider;

  private final Provider<HostsFileParser> hostsFileParserProvider;

  private final Provider<Logger> loggerProvider;

  public AssetsHostsDataSource_Factory(Provider<AssetManager> assetManagerProvider,
      Provider<HostsFileParser> hostsFileParserProvider, Provider<Logger> loggerProvider) {
    this.assetManagerProvider = assetManagerProvider;
    this.hostsFileParserProvider = hostsFileParserProvider;
    this.loggerProvider = loggerProvider;
  }

  @Override
  public AssetsHostsDataSource get() {
    return newInstance(assetManagerProvider.get(), hostsFileParserProvider, loggerProvider.get());
  }

  public static AssetsHostsDataSource_Factory create(Provider<AssetManager> assetManagerProvider,
      Provider<HostsFileParser> hostsFileParserProvider, Provider<Logger> loggerProvider) {
    return new AssetsHostsDataSource_Factory(assetManagerProvider, hostsFileParserProvider, loggerProvider);
  }

  public static AssetsHostsDataSource newInstance(AssetManager assetManager,
      Provider<HostsFileParser> hostsFileParserProvider, Logger logger) {
    return new AssetsHostsDataSource(assetManager, hostsFileParserProvider, logger);
  }
}
