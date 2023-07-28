package acr.browser.lightning.browser.di;

import acr.browser.lightning.browser.data.CookieAdministrator;
import acr.browser.lightning.browser.data.DefaultCookieAdministrator;
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
public final class Browser2Module_ProvidesCookieAdministratorFactory implements Factory<CookieAdministrator> {
  private final Browser2Module module;

  private final Provider<Boolean> incognitoModeProvider;

  private final Provider<DefaultCookieAdministrator> defaultCookieAdministratorProvider;

  private final Provider<DefaultCookieAdministrator> incognitoCookieAdministratorProvider;

  public Browser2Module_ProvidesCookieAdministratorFactory(Browser2Module module,
      Provider<Boolean> incognitoModeProvider,
      Provider<DefaultCookieAdministrator> defaultCookieAdministratorProvider,
      Provider<DefaultCookieAdministrator> incognitoCookieAdministratorProvider) {
    this.module = module;
    this.incognitoModeProvider = incognitoModeProvider;
    this.defaultCookieAdministratorProvider = defaultCookieAdministratorProvider;
    this.incognitoCookieAdministratorProvider = incognitoCookieAdministratorProvider;
  }

  @Override
  public CookieAdministrator get() {
    return providesCookieAdministrator(module, incognitoModeProvider.get(), defaultCookieAdministratorProvider.get(), incognitoCookieAdministratorProvider.get());
  }

  public static Browser2Module_ProvidesCookieAdministratorFactory create(Browser2Module module,
      Provider<Boolean> incognitoModeProvider,
      Provider<DefaultCookieAdministrator> defaultCookieAdministratorProvider,
      Provider<DefaultCookieAdministrator> incognitoCookieAdministratorProvider) {
    return new Browser2Module_ProvidesCookieAdministratorFactory(module, incognitoModeProvider, defaultCookieAdministratorProvider, incognitoCookieAdministratorProvider);
  }

  public static CookieAdministrator providesCookieAdministrator(Browser2Module instance,
      boolean incognitoMode, DefaultCookieAdministrator defaultCookieAdministrator,
      DefaultCookieAdministrator incognitoCookieAdministrator) {
    return Preconditions.checkNotNullFromProvides(instance.providesCookieAdministrator(incognitoMode, defaultCookieAdministrator, incognitoCookieAdministrator));
  }
}
