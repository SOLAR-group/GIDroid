package acr.browser.lightning.adblock;

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
public final class NoOpAdBlocker_Factory implements Factory<NoOpAdBlocker> {
  @Override
  public NoOpAdBlocker get() {
    return newInstance();
  }

  public static NoOpAdBlocker_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NoOpAdBlocker newInstance() {
    return new NoOpAdBlocker();
  }

  private static final class InstanceHolder {
    private static final NoOpAdBlocker_Factory INSTANCE = new NoOpAdBlocker_Factory();
  }
}
