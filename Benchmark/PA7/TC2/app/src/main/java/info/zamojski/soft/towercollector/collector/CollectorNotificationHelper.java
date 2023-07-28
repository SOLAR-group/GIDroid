/* This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/. */

package info.zamojski.soft.towercollector.collector;

import info.zamojski.soft.towercollector.CollectorService;
import info.zamojski.soft.towercollector.MainActivity;
import info.zamojski.soft.towercollector.R;
import info.zamojski.soft.towercollector.model.Statistics;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

public class CollectorNotificationHelper {

    private Context context;
    NotificationCompat.Builder builder;

    public CollectorNotificationHelper(Context context) {
        this.context = context;
        this.builder = new NotificationCompat.Builder(context);
    }

    public Notification createNotification(Statistics stats) {
        String notificationText = createStatsText(stats);
        return prepareNotification(notificationText);
    }

    public Notification updateNotification(Statistics stats) {
        String notificationText = createStatsText(stats);
        return updateNotification(notificationText);
    }

    public Notification updateNotification(String notificationText) {
        builder.setContentText(notificationText);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText));
        return builder.build();
    }

    private Notification prepareNotification(String notificationText) {
        // set style
        builder.setSmallIcon(R.drawable.app_notification_icon);
        builder.setOngoing(true);
        builder.setWhen(System.currentTimeMillis());
        builder.setOnlyAlertOnce(true);
        // set intent
        PendingIntent mainActivityIntent = createOpenMainActivityIntent();
        builder.setContentIntent(mainActivityIntent);
        // set message
        builder.setContentTitle(context.getString(R.string.collector_notification_title));
        builder.setContentText(notificationText);
        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(notificationText));
        // set action
        PendingIntent stopCollectorIntent = createStopCollectorIntent();
        builder.addAction(R.drawable.menu_stop_dark, context.getString(R.string.main_menu_stop_button), stopCollectorIntent);
        return builder.build();
    }

    private String createStatsText(Statistics stats) {
        return context.getString(R.string.collector_notification_stats, stats.getLocationsToday(), stats.getCellsToday());
    }

    private PendingIntent createOpenMainActivityIntent() {
        Intent intent = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
        intent.setAction(CollectorService.SERVICE_FULL_NAME + "_NID_" + CollectorService.NOTIFICATION_ID);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        return pendingIntent;
    }

    private PendingIntent createStopCollectorIntent() {
        Intent intent = new Intent(CollectorService.BROADCAST_INTENT_STOP_SERVICE);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        return pendingIntent;
    }

}
