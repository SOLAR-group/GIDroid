package acr.browser.lightning.browser.di;

import acr.browser.lightning.browser.tab.bundle.BundleStore;
import acr.browser.lightning.browser.tab.bundle.DefaultBundleStore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class Browser2Module_ProvidesBundleStoreFactory implements Factory<BundleStore> {
  private final Browser2Module module;

  private final Provider<Boolean> incognitoModeProvider;

  private final Provider<DefaultBundleStore> defaultBundleStoreProvider;

  public Browser2Module_ProvidesBundleStoreFactory(Browser2Module module,
      Provider<Boolean> incognitoModeProvider,
      Provider<DefaultBundleStore> defaultBundleStoreProvider) {
    this.module = module;
    this.incognitoModeProvider = incognitoModeProvider;
    this.defaultBundleStoreProvider = defaultBundleStoreProvider;
  }

  @Override
  public BundleStore get() {
    return providesBundleStore(module, incognitoModeProvider.get(), defaultBundleStoreProvider.get());
  }

  public static Browser2Module_ProvidesBundleStoreFactory create(Browser2Module module,
      Provider<Boolean> incognitoModeProvider,
      Provider<DefaultBundleStore> defaultBundleStoreProvider) {
    return new Browser2Module_ProvidesBundleStoreFactory(module, incognitoModeProvider, defaultBundleStoreProvider);
  }

  public static BundleStore providesBundleStore(Browser2Module instance, boolean incognitoMode,
      DefaultBundleStore defaultBundleStore) {
    return Preconditions.checkNotNullFromProvides(instance.providesBundleStore(incognitoMode, defaultBundleStore));
  }
}
