package acr.browser.lightning.browser.tab;

import dagger.internal.DaggerGenerated;
import dagger.internal.InstanceFactory;
import java.util.Map;
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
public final class TabWebViewClient_Factory_Impl implements TabWebViewClient.Factory {
  private final TabWebViewClient_Factory delegateFactory;

  TabWebViewClient_Factory_Impl(TabWebViewClient_Factory delegateFactory) {
    this.delegateFactory = delegateFactory;
  }

  @Override
  public TabWebViewClient create(Map<String, String> headers) {
    return delegateFactory.get(headers);
  }

  public static Provider<TabWebViewClient.Factory> create(
      TabWebViewClient_Factory delegateFactory) {
    return InstanceFactory.create(new TabWebViewClient_Factory_Impl(delegateFactory));
  }
}
