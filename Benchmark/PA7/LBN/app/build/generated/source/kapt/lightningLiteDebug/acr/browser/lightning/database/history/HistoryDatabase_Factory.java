package acr.browser.lightning.database.history;

import android.app.Application;
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
public final class HistoryDatabase_Factory implements Factory<HistoryDatabase> {
  private final Provider<Application> applicationProvider;

  public HistoryDatabase_Factory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public HistoryDatabase get() {
    return newInstance(applicationProvider.get());
  }

  public static HistoryDatabase_Factory create(Provider<Application> applicationProvider) {
    return new HistoryDatabase_Factory(applicationProvider);
  }

  public static HistoryDatabase newInstance(Application application) {
    return new HistoryDatabase(application);
  }
}
