package acr.browser.lightning.browser.di;

import acr.browser.lightning.browser.search.IntentExtractor;
import android.content.Intent;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import javax.annotation.Generated;
import javax.inject.Provider;
import org.jetbrains.annotations.Nullable;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class Browser2Module_ProvidesInitialUrlFactory implements Factory<String> {
  private final Browser2Module module;

  private final Provider<Intent> initialIntentProvider;

  private final Provider<IntentExtractor> intentExtractorProvider;

  public Browser2Module_ProvidesInitialUrlFactory(Browser2Module module,
      Provider<Intent> initialIntentProvider, Provider<IntentExtractor> intentExtractorProvider) {
    this.module = module;
    this.initialIntentProvider = initialIntentProvider;
    this.intentExtractorProvider = intentExtractorProvider;
  }

  @Override
  @Nullable
  public String get() {
    return providesInitialUrl(module, initialIntentProvider.get(), intentExtractorProvider.get());
  }

  public static Browser2Module_ProvidesInitialUrlFactory create(Browser2Module module,
      Provider<Intent> initialIntentProvider, Provider<IntentExtractor> intentExtractorProvider) {
    return new Browser2Module_ProvidesInitialUrlFactory(module, initialIntentProvider, intentExtractorProvider);
  }

  @Nullable
  public static String providesInitialUrl(Browser2Module instance, Intent initialIntent,
      IntentExtractor intentExtractor) {
    return instance.providesInitialUrl(initialIntent, intentExtractor);
  }
}
