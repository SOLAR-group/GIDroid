package acr.browser.lightning.device;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ScreenSize_Factory implements Factory<ScreenSize> {
  private final Provider<Context> contextProvider;

  public ScreenSize_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ScreenSize get() {
    return newInstance(contextProvider.get());
  }

  public static ScreenSize_Factory create(Provider<Context> contextProvider) {
    return new ScreenSize_Factory(contextProvider);
  }

  public static ScreenSize newInstance(Context context) {
    return new ScreenSize(context);
  }
}
