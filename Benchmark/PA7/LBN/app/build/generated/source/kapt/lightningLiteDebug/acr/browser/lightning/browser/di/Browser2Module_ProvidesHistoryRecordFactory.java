package acr.browser.lightning.browser.di;

import acr.browser.lightning.browser.history.DefaultHistoryRecord;
import acr.browser.lightning.browser.history.HistoryRecord;
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
public final class Browser2Module_ProvidesHistoryRecordFactory implements Factory<HistoryRecord> {
  private final Browser2Module module;

  private final Provider<Boolean> incognitoModeProvider;

  private final Provider<DefaultHistoryRecord> defaultHistoryRecordProvider;

  public Browser2Module_ProvidesHistoryRecordFactory(Browser2Module module,
      Provider<Boolean> incognitoModeProvider,
      Provider<DefaultHistoryRecord> defaultHistoryRecordProvider) {
    this.module = module;
    this.incognitoModeProvider = incognitoModeProvider;
    this.defaultHistoryRecordProvider = defaultHistoryRecordProvider;
  }

  @Override
  public HistoryRecord get() {
    return providesHistoryRecord(module, incognitoModeProvider.get(), defaultHistoryRecordProvider.get());
  }

  public static Browser2Module_ProvidesHistoryRecordFactory create(Browser2Module module,
      Provider<Boolean> incognitoModeProvider,
      Provider<DefaultHistoryRecord> defaultHistoryRecordProvider) {
    return new Browser2Module_ProvidesHistoryRecordFactory(module, incognitoModeProvider, defaultHistoryRecordProvider);
  }

  public static HistoryRecord providesHistoryRecord(Browser2Module instance, boolean incognitoMode,
      DefaultHistoryRecord defaultHistoryRecord) {
    return Preconditions.checkNotNullFromProvides(instance.providesHistoryRecord(incognitoMode, defaultHistoryRecord));
  }
}
