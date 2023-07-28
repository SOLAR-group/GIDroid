package acr.browser.lightning.adblock.source;

import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import javax.annotation.Generated;
import javax.inject.Provider;
import okhttp3.HttpUrl;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class UrlHostsDataSource_Factory_Impl implements UrlHostsDataSource.Factory {
  private final UrlHostsDataSource_Factory delegateFactory;

  UrlHostsDataSource_Factory_Impl(UrlHostsDataSource_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public UrlHostsDataSource create(HttpUrl url) {
    return delegateFactory.get(url);
  }

  public static Provider<UrlHostsDataSource.Factory> create(
      UrlHostsDataSource_Factory delegateFactory) {
    return InstanceFactory.create(new UrlHostsDataSource_Factory_Impl(delegateFactory));
  }
}
