package acr.browser.lightning.browser.di;

import acr.browser.lightning.browser.notification.IncognitoTabCountNotifier;
import acr.browser.lightning.browser.notification.TabCountNotifier;
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
public final class Browser2Module_ProvidesTabCountNotifierFactory implements Factory<TabCountNotifier> {
  private final Browser2Module module;

  private final Provider<Boolean> incognitoModeProvider;

  private final Provider<IncognitoTabCountNotifier> incognitoTabCountNotifierProvider;

  public Browser2Module_ProvidesTabCountNotifierFactory(Browser2Module module,
      Provider<Boolean> incognitoModeProvider,
      Provider<IncognitoTabCountNotifier> incognitoTabCountNotifierProvider) {
    this.module = module;
    this.incognitoModeProvider = incognitoModeProvider;
    this.incognitoTabCountNotifierProvider = incognitoTabCountNotifierProvider;
  }

  @Override
  public TabCountNotifier get() {
    return providesTabCountNotifier(module, incognitoModeProvider.get(), incognitoTabCountNotifierProvider.get());
  }

  public static Browser2Module_ProvidesTabCountNotifierFactory create(Browser2Module module,
      Provider<Boolean> incognitoModeProvider,
      Provider<IncognitoTabCountNotifier> incognitoTabCountNotifierProvider) {
    return new Browser2Module_ProvidesTabCountNotifierFactory(module, incognitoModeProvider, incognitoTabCountNotifierProvider);
  }

  public static TabCountNotifier providesTabCountNotifier(Browser2Module instance,
      boolean incognitoMode, IncognitoTabCountNotifier incognitoTabCountNotifier) {
    return Preconditions.checkNotNullFromProvides(instance.providesTabCountNotifier(incognitoMode, incognitoTabCountNotifier));
  }
}
