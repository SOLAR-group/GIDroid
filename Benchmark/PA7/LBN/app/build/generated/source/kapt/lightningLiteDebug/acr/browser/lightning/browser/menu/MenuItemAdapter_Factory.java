package acr.browser.lightning.browser.menu;

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
public final class MenuItemAdapter_Factory implements Factory<MenuItemAdapter> {
  @Override
  public MenuItemAdapter get() {
    return newInstance();
  }

  public static MenuItemAdapter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MenuItemAdapter newInstance() {
    return new MenuItemAdapter();
  }

  private static final class InstanceHolder {
    private static final MenuItemAdapter_Factory INSTANCE = new MenuItemAdapter_Factory();
  }
}
