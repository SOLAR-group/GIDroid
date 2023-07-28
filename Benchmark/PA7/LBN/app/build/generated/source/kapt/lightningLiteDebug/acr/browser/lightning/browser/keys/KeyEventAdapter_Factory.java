package acr.browser.lightning.browser.keys;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.annotation.Generated;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class KeyEventAdapter_Factory implements Factory<KeyEventAdapter> {
  @Override
  public KeyEventAdapter get() {
    return newInstance();
  }

  public static KeyEventAdapter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static KeyEventAdapter newInstance() {
    return new KeyEventAdapter();
  }

  private static final class InstanceHolder {
    private static final KeyEventAdapter_Factory INSTANCE = new KeyEventAdapter_Factory();
  }
}
