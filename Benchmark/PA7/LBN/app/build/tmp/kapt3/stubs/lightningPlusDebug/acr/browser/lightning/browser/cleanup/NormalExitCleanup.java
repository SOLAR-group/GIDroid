package acr.browser.lightning.browser.cleanup;

import java.lang.System;

/**
 * Exit cleanup that should run whenever the main browser process is exiting.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lacr/browser/lightning/browser/cleanup/NormalExitCleanup;", "Lacr/browser/lightning/browser/cleanup/ExitCleanup;", "userPreferences", "Lacr/browser/lightning/preference/UserPreferences;", "logger", "Lacr/browser/lightning/log/Logger;", "historyDatabase", "Lacr/browser/lightning/database/history/HistoryDatabase;", "databaseScheduler", "Lio/reactivex/Scheduler;", "activity", "Landroid/app/Activity;", "(Lacr/browser/lightning/preference/UserPreferences;Lacr/browser/lightning/log/Logger;Lacr/browser/lightning/database/history/HistoryDatabase;Lio/reactivex/Scheduler;Landroid/app/Activity;)V", "cleanUp", "", "Companion", "app_lightningPlusDebug"})
public final class NormalExitCleanup implements acr.browser.lightning.browser.cleanup.ExitCleanup {
    private final acr.browser.lightning.preference.UserPreferences userPreferences = null;
    private final acr.browser.lightning.log.Logger logger = null;
    private final acr.browser.lightning.database.history.HistoryDatabase historyDatabase = null;
    private final io.reactivex.Scheduler databaseScheduler = null;
    private final android.app.Activity activity = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String TAG = "NormalExitCleanup";
    @org.jetbrains.annotations.NotNull()
    public static final acr.browser.lightning.browser.cleanup.NormalExitCleanup.Companion Companion = null;
    
    @java.lang.Override()
    public void cleanUp() {
    }
    
    @javax.inject.Inject()
    public NormalExitCleanup(@org.jetbrains.annotations.NotNull()
    acr.browser.lightning.preference.UserPreferences userPreferences, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.log.Logger logger, @org.jetbrains.annotations.NotNull()
    acr.browser.lightning.database.history.HistoryDatabase historyDatabase, @org.jetbrains.annotations.NotNull()
    @acr.browser.lightning.browser.di.DatabaseScheduler()
    io.reactivex.Scheduler databaseScheduler, @org.jetbrains.annotations.NotNull()
    android.app.Activity activity) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lacr/browser/lightning/browser/cleanup/NormalExitCleanup$Companion;", "", "()V", "TAG", "", "app_lightningPlusDebug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}