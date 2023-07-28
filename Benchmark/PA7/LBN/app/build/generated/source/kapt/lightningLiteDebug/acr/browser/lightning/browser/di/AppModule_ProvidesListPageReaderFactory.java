package acr.browser.lightning.browser.di;

import acr.browser.lightning.html.ListPageReader;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvidesListPageReaderFactory implements Factory<ListPageReader> {
  private final AppModule module;

  public AppModule_ProvidesListPageReaderFactory(AppModule module) {
    this.module = module;
  }

  @Override
  public ListPageReader get() {
    return providesListPageReader(module);
  }

  public static AppModule_ProvidesListPageReaderFactory create(AppModule module) {
    return new AppModule_ProvidesListPageReaderFactory(module);
  }

  public static ListPageReader providesListPageReader(AppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.providesListPageReader());
  }
}
