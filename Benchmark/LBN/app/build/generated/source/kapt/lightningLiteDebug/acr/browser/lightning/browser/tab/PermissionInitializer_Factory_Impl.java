package acr.browser.lightning.browser.tab;

import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
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
public final class PermissionInitializer_Factory_Impl implements PermissionInitializer.Factory {
  private final PermissionInitializer_Factory delegateFactory;

  PermissionInitializer_Factory_Impl(PermissionInitializer_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public PermissionInitializer create(String url) {
    return delegateFactory.get(url);
  }

  public static Provider<PermissionInitializer.Factory> create(
      PermissionInitializer_Factory delegateFactory) {
    return InstanceFactory.create(new PermissionInitializer_Factory_Impl(delegateFactory));
  }
}
