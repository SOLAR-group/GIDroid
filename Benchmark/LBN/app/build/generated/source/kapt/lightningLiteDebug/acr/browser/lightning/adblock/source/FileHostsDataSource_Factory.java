package acr.browser.lightning.adblock.source;

import acr.browser.lightning.log.Logger;
import dagger.internal.DaggerGenerated;
import java.io.File;
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
public final class FileHostsDataSource_Factory {
  private final Provider<Logger> loggerProvider;

  public FileHostsDataSource_Factory(Provider<Logger> loggerProvider) {
    this.loggerProvider = loggerProvider;
  }

  public FileHostsDataSource get(File file) {
    return newInstance(loggerProvider.get(), file);
  }

  public static FileHostsDataSource_Factory create(Provider<Logger> loggerProvider) {
    return new FileHostsDataSource_Factory(loggerProvider);
  }

  public static FileHostsDataSource newInstance(Logger logger, File file) {
    return new FileHostsDataSource(logger, file);
  }
}
