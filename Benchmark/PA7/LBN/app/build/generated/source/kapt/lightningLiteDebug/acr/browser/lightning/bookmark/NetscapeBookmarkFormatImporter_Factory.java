package acr.browser.lightning.bookmark;

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
public final class NetscapeBookmarkFormatImporter_Factory implements Factory<NetscapeBookmarkFormatImporter> {
  @Override
  public NetscapeBookmarkFormatImporter get() {
    return newInstance();
  }

  public static NetscapeBookmarkFormatImporter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static NetscapeBookmarkFormatImporter newInstance() {
    return new NetscapeBookmarkFormatImporter();
  }

  private static final class InstanceHolder {
    private static final NetscapeBookmarkFormatImporter_Factory INSTANCE = new NetscapeBookmarkFormatImporter_Factory();
  }
}
