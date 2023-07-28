package acr.browser.lightning.browser.cleanup;

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
public final class BasicIncognitoExitCleanup_Factory implements Factory<BasicIncognitoExitCleanup> {
  @Override
  public BasicIncognitoExitCleanup get() {
    return newInstance();
  }

  public static BasicIncognitoExitCleanup_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BasicIncognitoExitCleanup newInstance() {
    return new BasicIncognitoExitCleanup();
  }

  private static final class InstanceHolder {
    private static final BasicIncognitoExitCleanup_Factory INSTANCE = new BasicIncognitoExitCleanup_Factory();
  }
}
