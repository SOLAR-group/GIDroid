package acr.browser.lightning.browser.proxy;

import acr.browser.lightning.utils.ProxyUtils;
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
public final class ProxyAdapter_Factory implements Factory<ProxyAdapter> {
  private final Provider<ProxyUtils> proxyUtilsProvider;

  public ProxyAdapter_Factory(Provider<ProxyUtils> proxyUtilsProvider) {
    this.proxyUtilsProvider = proxyUtilsProvider;
  }

  @Override
  public ProxyAdapter get() {
    return newInstance(proxyUtilsProvider.get());
  }

  public static ProxyAdapter_Factory create(Provider<ProxyUtils> proxyUtilsProvider) {
    return new ProxyAdapter_Factory(proxyUtilsProvider);
  }

  public static ProxyAdapter newInstance(ProxyUtils proxyUtils) {
    return new ProxyAdapter(proxyUtils);
  }
}
