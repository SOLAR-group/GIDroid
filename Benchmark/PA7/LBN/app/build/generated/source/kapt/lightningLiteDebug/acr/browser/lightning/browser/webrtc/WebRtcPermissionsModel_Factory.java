package acr.browser.lightning.browser.webrtc;

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
public final class WebRtcPermissionsModel_Factory implements Factory<WebRtcPermissionsModel> {
  @Override
  public WebRtcPermissionsModel get() {
    return newInstance();
  }

  public static WebRtcPermissionsModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static WebRtcPermissionsModel newInstance() {
    return new WebRtcPermissionsModel();
  }

  private static final class InstanceHolder {
    private static final WebRtcPermissionsModel_Factory INSTANCE = new WebRtcPermissionsModel_Factory();
  }
}
