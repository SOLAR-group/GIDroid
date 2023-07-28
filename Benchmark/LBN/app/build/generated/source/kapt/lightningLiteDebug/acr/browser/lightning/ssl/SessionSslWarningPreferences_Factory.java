package acr.browser.lightning.ssl;

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
public final class SessionSslWarningPreferences_Factory implements Factory<SessionSslWarningPreferences> {
  @Override
  public SessionSslWarningPreferences get() {
    return newInstance();
  }

  public static SessionSslWarningPreferences_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static SessionSslWarningPreferences newInstance() {
    return new SessionSslWarningPreferences();
  }

  private static final class InstanceHolder {
    private static final SessionSslWarningPreferences_Factory INSTANCE = new SessionSslWarningPreferences_Factory();
  }
}
