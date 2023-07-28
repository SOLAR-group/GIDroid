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
public final class LegacyBookmarkImporter_Factory implements Factory<LegacyBookmarkImporter> {
  @Override
  public LegacyBookmarkImporter get() {
    return newInstance();
  }

  public static LegacyBookmarkImporter_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static LegacyBookmarkImporter newInstance() {
    return new LegacyBookmarkImporter();
  }

  private static final class InstanceHolder {
    private static final LegacyBookmarkImporter_Factory INSTANCE = new LegacyBookmarkImporter_Factory();
  }
}
