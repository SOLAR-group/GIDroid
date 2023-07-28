package acr.browser.lightning.adblock.source;

import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
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
public final class FileHostsDataSource_Factory_Impl implements FileHostsDataSource.Factory {
  private final FileHostsDataSource_Factory delegateFactory;

  FileHostsDataSource_Factory_Impl(FileHostsDataSource_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public FileHostsDataSource create(File file) {
    return delegateFactory.get(file);
  }

  public static Provider<FileHostsDataSource.Factory> create(
      FileHostsDataSource_Factory delegateFactory) {
    return InstanceFactory.create(new FileHostsDataSource_Factory_Impl(delegateFactory));
  }
}
