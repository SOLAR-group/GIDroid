package acr.browser.lightning.browser.search;

import acr.browser.lightning.search.SearchEngineProvider;
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
public final class IntentExtractor_Factory implements Factory<IntentExtractor> {
  private final Provider<SearchEngineProvider> searchEngineProvider;

  public IntentExtractor_Factory(Provider<SearchEngineProvider> searchEngineProvider) {
    this.searchEngineProvider = searchEngineProvider;
  }

  @Override
  public IntentExtractor get() {
    return newInstance(searchEngineProvider.get());
  }

  public static IntentExtractor_Factory create(
      Provider<SearchEngineProvider> searchEngineProvider) {
    return new IntentExtractor_Factory(searchEngineProvider);
  }

  public static IntentExtractor newInstance(SearchEngineProvider searchEngineProvider) {
    return new IntentExtractor(searchEngineProvider);
  }
}
