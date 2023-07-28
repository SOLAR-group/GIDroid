package acr.browser.lightning.adblock.parser;

import acr.browser.lightning.log.Logger;
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
public final class HostsFileParser_Factory implements Factory<HostsFileParser> {
  private final Provider<Logger> loggerProvider;

  public HostsFileParser_Factory(Provider<Logger> loggerProvider) {
    this.loggerProvider = loggerProvider;
  }

  @Override
  public HostsFileParser get() {
    return newInstance(loggerProvider.get());
  }

  public static HostsFileParser_Factory create(Provider<Logger> loggerProvider) {
    return new HostsFileParser_Factory(loggerProvider);
  }

  public static HostsFileParser newInstance(Logger logger) {
    return new HostsFileParser(logger);
  }
}
