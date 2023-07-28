package acr.browser.lightning.log;

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
public final class NoOpLogger_Factory implements Factory<NoOpLogger> {
  @Override
  public NoOpLogger get() {
    return newInstance();
  }

  public static NoOpLogger_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NoOpLogger newInstance() {
    return new NoOpLogger();
  }

  private static final class InstanceHolder {
    private static final NoOpLogger_Factory INSTANCE = new NoOpLogger_Factory();
  }
}
