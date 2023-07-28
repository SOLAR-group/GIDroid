package acr.browser.lightning;

import acr.browser.lightning.browser.di.DatabaseScheduler;
import acr.browser.lightning.browser.proxy.ProxyAdapter;
import acr.browser.lightning.database.bookmark.BookmarkRepository;
import acr.browser.lightning.device.BuildInfo;
import acr.browser.lightning.log.Logger;
import acr.browser.lightning.preference.DeveloperPreferences;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import io.reactivex.Scheduler;
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
public final class BrowserApp_MembersInjector implements MembersInjector<BrowserApp> {
  private final Provider<DeveloperPreferences> developerPreferencesProvider;

  private final Provider<BookmarkRepository> bookmarkModelProvider;

  private final Provider<Scheduler> databaseSchedulerProvider;

  private final Provider<Logger> loggerProvider;

  private final Provider<BuildInfo> buildInfoProvider;

  private final Provider<ProxyAdapter> proxyAdapterProvider;

  public BrowserApp_MembersInjector(Provider<DeveloperPreferences> developerPreferencesProvider,
      Provider<BookmarkRepository> bookmarkModelProvider,
      Provider<Scheduler> databaseSchedulerProvider, Provider<Logger> loggerProvider,
      Provider<BuildInfo> buildInfoProvider, Provider<ProxyAdapter> proxyAdapterProvider) {
    this.developerPreferencesProvider = developerPreferencesProvider;
    this.bookmarkModelProvider = bookmarkModelProvider;
    this.databaseSchedulerProvider = databaseSchedulerProvider;
    this.loggerProvider = loggerProvider;
    this.buildInfoProvider = buildInfoProvider;
    this.proxyAdapterProvider = proxyAdapterProvider;
  }

  public static MembersInjector<BrowserApp> create(
      Provider<DeveloperPreferences> developerPreferencesProvider,
      Provider<BookmarkRepository> bookmarkModelProvider,
      Provider<Scheduler> databaseSchedulerProvider, Provider<Logger> loggerProvider,
      Provider<BuildInfo> buildInfoProvider, Provider<ProxyAdapter> proxyAdapterProvider) {
    return new BrowserApp_MembersInjector(developerPreferencesProvider, bookmarkModelProvider, databaseSchedulerProvider, loggerProvider, buildInfoProvider, proxyAdapterProvider);
  }

  @Override
  public void injectMembers(BrowserApp instance) {
    injectDeveloperPreferences(instance, developerPreferencesProvider.get());
    injectBookmarkModel(instance, bookmarkModelProvider.get());
    injectDatabaseScheduler(instance, databaseSchedulerProvider.get());
    injectLogger(instance, loggerProvider.get());
    injectBuildInfo(instance, buildInfoProvider.get());
    injectProxyAdapter(instance, proxyAdapterProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.BrowserApp.developerPreferences")
  public static void injectDeveloperPreferences(BrowserApp instance,
      DeveloperPreferences developerPreferences) {
    instance.developerPreferences = developerPreferences;
  }

  @InjectedFieldSignature("acr.browser.lightning.BrowserApp.bookmarkModel")
  public static void injectBookmarkModel(BrowserApp instance, BookmarkRepository bookmarkModel) {
    instance.bookmarkModel = bookmarkModel;
  }

  @InjectedFieldSignature("acr.browser.lightning.BrowserApp.databaseScheduler")
  @DatabaseScheduler
  public static void injectDatabaseScheduler(BrowserApp instance, Scheduler databaseScheduler) {
    instance.databaseScheduler = databaseScheduler;
  }

  @InjectedFieldSignature("acr.browser.lightning.BrowserApp.logger")
  public static void injectLogger(BrowserApp instance, Logger logger) {
    instance.logger = logger;
  }

  @InjectedFieldSignature("acr.browser.lightning.BrowserApp.buildInfo")
  public static void injectBuildInfo(BrowserApp instance, BuildInfo buildInfo) {
    instance.buildInfo = buildInfo;
  }

  @InjectedFieldSignature("acr.browser.lightning.BrowserApp.proxyAdapter")
  public static void injectProxyAdapter(BrowserApp instance, ProxyAdapter proxyAdapter) {
    instance.proxyAdapter = proxyAdapter;
  }
}
