package acr.browser.lightning.browser.di;

import acr.browser.lightning.adblock.AdBlocker;
import acr.browser.lightning.adblock.BloomFilterAdBlocker;
import acr.browser.lightning.adblock.NoOpAdBlocker;
import acr.browser.lightning.preference.UserPreferences;
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
public final class Browser2Module_ProvidesAdBlockerFactory implements Factory<AdBlocker> {
  private final Browser2Module module;

  private final Provider<UserPreferences> userPreferencesProvider;

  private final Provider<BloomFilterAdBlocker> bloomFilterAdBlockerProvider;

  private final Provider<NoOpAdBlocker> noOpAdBlockerProvider;

  public Browser2Module_ProvidesAdBlockerFactory(Browser2Module module,
      Provider<UserPreferences> userPreferencesProvider,
      Provider<BloomFilterAdBlocker> bloomFilterAdBlockerProvider,
      Provider<NoOpAdBlocker> noOpAdBlockerProvider) {
    this.module = module;
    this.userPreferencesProvider = userPreferencesProvider;
    this.bloomFilterAdBlockerProvider = bloomFilterAdBlockerProvider;
    this.noOpAdBlockerProvider = noOpAdBlockerProvider;
  }

  @Override
  public AdBlocker get() {
    return providesAdBlocker(module, userPreferencesProvider.get(), bloomFilterAdBlockerProvider, noOpAdBlockerProvider.get());
  }

  public static Browser2Module_ProvidesAdBlockerFactory create(Browser2Module module,
      Provider<UserPreferences> userPreferencesProvider,
      Provider<BloomFilterAdBlocker> bloomFilterAdBlockerProvider,
      Provider<NoOpAdBlocker> noOpAdBlockerProvider) {
    return new Browser2Module_ProvidesAdBlockerFactory(module, userPreferencesProvider, bloomFilterAdBlockerProvider, noOpAdBlockerProvider);
  }

  public static AdBlocker providesAdBlocker(Browser2Module instance,
      UserPreferences userPreferences, Provider<BloomFilterAdBlocker> bloomFilterAdBlocker,
      NoOpAdBlocker noOpAdBlocker) {
    return Preconditions.checkNotNullFromProvides(instance.providesAdBlocker(userPreferences, bloomFilterAdBlocker, noOpAdBlocker));
  }
}
