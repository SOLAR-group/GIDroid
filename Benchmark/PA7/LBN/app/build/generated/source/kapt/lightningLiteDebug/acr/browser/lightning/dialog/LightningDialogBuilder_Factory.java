package acr.browser.lightning.dialog;

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
public final class LightningDialogBuilder_Factory implements Factory<LightningDialogBuilder> {
  @Override
  public LightningDialogBuilder get() {
    return newInstance();
  }

  public static LightningDialogBuilder_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static LightningDialogBuilder newInstance() {
    return new LightningDialogBuilder();
  }

  private static final class InstanceHolder {
    private static final LightningDialogBuilder_Factory INSTANCE = new LightningDialogBuilder_Factory();
  }
}
