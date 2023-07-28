/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.uploader;

import info.zamojski.soft.towercollector.MainActivity;
import info.zamojski.soft.towercollector.R;
import info.zamojski.soft.towercollector.UploaderService;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class UploaderNotificationHelper {

    private Context context;
    NotificationCompat.Builder builder;

    public UploaderNotificationHelper(Context context) {
        this.context = context;
        this.builder = new NotificationCompat.Builder(context);
    }

    public Notification createNotification() {
        String notificationText = context.getString(R.string.uploader_starting);
        return prepareNotification(notificationText);
    }

    public Notification updateNotificationProgress(int partNumber, int partsCount) {
        String notificationText = context.getString(R.string.uploader_notification_progress_info, partNumber, partsCount);
        builder.setContentText(notificationText);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText));
        return builder.build();
    }

    public Notification updateNotificationCancelling() {
        builder.setWhen(System.currentTimeMillis());
        String notificationText = context.getString(R.string.uploader_aborting);
        builder.setContentText(notificationText);
        builder.setTicker(notificationText);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText));
        return builder.build();
    }

    public Notification updateNotificationFinished(int messageId, int descriptionId) {
        builder.setAutoCancel(true);
        builder.setWhen(System.currentTimeMillis());
        String notificationText = context.getString(messageId);
        builder.setContentText(notificationText);
        builder.setTicker(notificationText);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText));
        PendingIntent mainActivityIntent = createMainActivityResultIntent(descriptionId);
        builder.setContentIntent(mainActivityIntent);
        return builder.build();
    }

    private Notification prepareNotification(String notificationText) {
        // set style
        builder.setSmallIcon(R.drawable.app_notification_icon);
        builder.setWhen(System.currentTimeMillis());
        builder.setOnlyAlertOnce(true);
        // set intent
        PendingIntent cancelUploaderIntent = createCancelUploaderIntent();
        builder.setContentIntent(cancelUploaderIntent);
        // set message
        builder.setContentTitle(context.getString(R.string.uploader_notification_title));
        builder.setContentText(notificationText);
        builder.setTicker(notificationText);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText));
        return builder.build();
    }

    private PendingIntent createMainActivityResultIntent(int descriptionId) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setAction(UploaderService.SERVICE_FULL_NAME + "_NID_" + UploaderService.NOTIFICATION_ID);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.putExtra(UploaderService.INTENT_KEY_RESULT_DESCRIPTION, descriptionId);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        return pendingIntent;
    }

    private PendingIntent createCancelUploaderIntent() {
        Intent intent = new Intent(UploaderService.BROADCAST_INTENT_STOP_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        return pendingIntent;
    }

}
