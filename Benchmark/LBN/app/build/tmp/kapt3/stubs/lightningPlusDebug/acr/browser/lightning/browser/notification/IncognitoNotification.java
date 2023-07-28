package acr.browser.lightning.browser.notification;

import java.lang.System;

/**
 * A notification helper that displays the current number of tabs open in a notification as a
 * warning. When the notification is pressed, the incognito browser will open.
 */
@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\fH\u0003J\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lacr/browser/lightning/browser/notification/IncognitoNotification;", "", "activity", "Landroid/app/Activity;", "notificationManager", "Landroid/app/NotificationManager;", "(Landroid/app/Activity;Landroid/app/NotificationManager;)V", "channelId", "", "incognitoNotificationId", "", "createNotificationChannel", "", "hide", "show", "number", "app_lightningPlusDebug"})
public final class IncognitoNotification {
    private final int incognitoNotificationId = 1;
    private final java.lang.String channelId = "channel_incognito";
    private final android.app.Activity activity = null;
    private final android.app.NotificationManager notificationManager = null;
    
    @android.annotation.TargetApi(value = android.os.Build.VERSION_CODES.O)
    private final void createNotificationChannel() {
    }
    
    /**
     * Shows the notification for the provided [number] of tabs. If a notification already exists,
     * it will be updated.
     *
     * @param number the number of tabs, must be > 0.
     */
    public final void show(int number) {
    }
    
    /**
     * Hides the current notification if there is one.
     */
    public final void hide() {
    }
    
    @javax.inject.Inject()
    public IncognitoNotification(@org.jetbrains.annotations.NotNull()
    android.app.Activity activity, @org.jetbrains.annotations.NotNull()
    android.app.NotificationManager notificationManager) {
        super();
    }
}