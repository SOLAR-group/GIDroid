package acr.browser.lightning.settings.fragment;

import acr.browser.lightning.bookmark.LegacyBookmarkImporter;
import acr.browser.lightning.bookmark.NetscapeBookmarkFormatImporter;
import acr.browser.lightning.browser.di.DatabaseScheduler;
import acr.browser.lightning.browser.di.MainScheduler;
import acr.browser.lightning.database.bookmark.BookmarkRepository;
import acr.browser.lightning.log.Logger;
import android.app.Application;
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
public final class BookmarkSettingsFragment_MembersInjector implements MembersInjector<BookmarkSettingsFragment> {
  private final Provider<BookmarkRepository> bookmarkRepositoryProvider;

  private final Provider<Application> applicationProvider;

  private final Provider<NetscapeBookmarkFormatImporter> netscapeBookmarkFormatImporterProvider;

  private final Provider<LegacyBookmarkImporter> legacyBookmarkImporterProvider;

  private final Provider<Scheduler> databaseSchedulerProvider;

  private final Provider<Scheduler> mainSchedulerProvider;

  private final Provider<Logger> loggerProvider;

  public BookmarkSettingsFragment_MembersInjector(
      Provider<BookmarkRepository> bookmarkRepositoryProvider,
      Provider<Application> applicationProvider,
      Provider<NetscapeBookmarkFormatImporter> netscapeBookmarkFormatImporterProvider,
      Provider<LegacyBookmarkImporter> legacyBookmarkImporterProvider,
      Provider<Scheduler> databaseSchedulerProvider, Provider<Scheduler> mainSchedulerProvider,
      Provider<Logger> loggerProvider) {
    this.bookmarkRepositoryProvider = bookmarkRepositoryProvider;
    this.applicationProvider = applicationProvider;
    this.netscapeBookmarkFormatImporterProvider = netscapeBookmarkFormatImporterProvider;
    this.legacyBookmarkImporterProvider = legacyBookmarkImporterProvider;
    this.databaseSchedulerProvider = databaseSchedulerProvider;
    this.mainSchedulerProvider = mainSchedulerProvider;
    this.loggerProvider = loggerProvider;
  }

  public static MembersInjector<BookmarkSettingsFragment> create(
      Provider<BookmarkRepository> bookmarkRepositoryProvider,
      Provider<Application> applicationProvider,
      Provider<NetscapeBookmarkFormatImporter> netscapeBookmarkFormatImporterProvider,
      Provider<LegacyBookmarkImporter> legacyBookmarkImporterProvider,
      Provider<Scheduler> databaseSchedulerProvider, Provider<Scheduler> mainSchedulerProvider,
      Provider<Logger> loggerProvider) {
    return new BookmarkSettingsFragment_MembersInjector(bookmarkRepositoryProvider, applicationProvider, netscapeBookmarkFormatImporterProvider, legacyBookmarkImporterProvider, databaseSchedulerProvider, mainSchedulerProvider, loggerProvider);
  }

  @Override
  public void injectMembers(BookmarkSettingsFragment instance) {
    injectBookmarkRepository(instance, bookmarkRepositoryProvider.get());
    injectApplication(instance, applicationProvider.get());
    injectNetscapeBookmarkFormatImporter(instance, netscapeBookmarkFormatImporterProvider.get());
    injectLegacyBookmarkImporter(instance, legacyBookmarkImporterProvider.get());
    injectDatabaseScheduler(instance, databaseSchedulerProvider.get());
    injectMainScheduler(instance, mainSchedulerProvider.get());
    injectLogger(instance, loggerProvider.get());
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.BookmarkSettingsFragment.bookmarkRepository")
  public static void injectBookmarkRepository(BookmarkSettingsFragment instance,
      BookmarkRepository bookmarkRepository) {
    instance.bookmarkRepository = bookmarkRepository;
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.BookmarkSettingsFragment.application")
  public static void injectApplication(BookmarkSettingsFragment instance, Application application) {
    instance.application = application;
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.BookmarkSettingsFragment.netscapeBookmarkFormatImporter")
  public static void injectNetscapeBookmarkFormatImporter(BookmarkSettingsFragment instance,
      NetscapeBookmarkFormatImporter netscapeBookmarkFormatImporter) {
    instance.netscapeBookmarkFormatImporter = netscapeBookmarkFormatImporter;
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.BookmarkSettingsFragment.legacyBookmarkImporter")
  public static void injectLegacyBookmarkImporter(BookmarkSettingsFragment instance,
      LegacyBookmarkImporter legacyBookmarkImporter) {
    instance.legacyBookmarkImporter = legacyBookmarkImporter;
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.BookmarkSettingsFragment.databaseScheduler")
  @DatabaseScheduler
  public static void injectDatabaseScheduler(BookmarkSettingsFragment instance,
      Scheduler databaseScheduler) {
    instance.databaseScheduler = databaseScheduler;
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.BookmarkSettingsFragment.mainScheduler")
  @MainScheduler
  public static void injectMainScheduler(BookmarkSettingsFragment instance,
      Scheduler mainScheduler) {
    instance.mainScheduler = mainScheduler;
  }

  @InjectedFieldSignature("acr.browser.lightning.settings.fragment.BookmarkSettingsFragment.logger")
  public static void injectLogger(BookmarkSettingsFragment instance, Logger logger) {
    instance.logger = logger;
  }
}
