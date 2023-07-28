package acr.browser.lightning.database.downloads;

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
public final class DownloadsDatabase_Factory implements Factory<DownloadsDatabase> {
  private final Provider<Application> applicationProvider;

  public DownloadsDatabase_Factory(Provider<Application> applicationProvider) {
    this.applicationProvider = applicationProvider;
  }

  @Override
  public DownloadsDatabase get() {
    return newInstance(applicationProvider.get());
  }

  public static DownloadsDatabase_Factory create(Provider<Application> applicationProvider) {
    return new DownloadsDatabase_Factory(applicationProvider);
  }

  public static DownloadsDatabase newInstance(Application application) {
    return new DownloadsDatabase(application);
  }
}
