package acr.browser.lightning.database.adblock;

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
public final class InMemoryHostsRepository_Factory implements Factory<InMemoryHostsRepository> {
  @Override
  public InMemoryHostsRepository get() {
    return newInstance();
  }

  public static InMemoryHostsRepository_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static InMemoryHostsRepository newInstance() {
    return new InMemoryHostsRepository();
  }

  private static final class InstanceHolder {
    private static final InMemoryHostsRepository_Factory INSTANCE = new InMemoryHostsRepository_Factory();
  }
}
