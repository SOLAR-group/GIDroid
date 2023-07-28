package acr.browser.lightning.browser.tab;

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
public final class RecentTabModel_Factory implements Factory<RecentTabModel> {
  @Override
  public RecentTabModel get() {
    return newInstance();
  }

  public static RecentTabModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static RecentTabModel newInstance() {
    return new RecentTabModel();
  }

  private static final class InstanceHolder {
    private static final RecentTabModel_Factory INSTANCE = new RecentTabModel_Factory();
  }
}
