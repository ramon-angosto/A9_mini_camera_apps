package com.shix.shixipc.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.shix.shixipc.activity.SplashActivity;
import shix.cykj.camera.R;

public class MyNotificationManager {
    public static final String TAG = "MyNotificationManager";

    public static void initNotificationChannel(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
        notificationManager.createNotificationChannelGroup(new NotificationChannelGroup("a", "a"));
        NotificationChannel notificationChannel = new NotificationChannel("1", "Channel1", 3);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setShowBadge(true);
        notificationManager.createNotificationChannel(notificationChannel);
        NotificationChannel notificationChannel2 = new NotificationChannel("2", "Channel2", 3);
        notificationChannel2.enableLights(true);
        notificationChannel2.setLightColor(-16711936);
        notificationChannel2.setGroup("a");
        notificationManager.createNotificationChannel(notificationChannel2);
    }

    public static void showChannel1Notification(Context context, String str, Uri uri) {
        NotificationChannel notificationChannel = new NotificationChannel("1", "channel_name", 4);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
        notificationManager.createNotificationChannel(notificationChannel);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentText(str);
        builder.setSmallIcon(R.mipmap.qh_dev2);
        builder.setChannelId("1");
        builder.setDefaults(2);
        Intent intent = new Intent(context, SplashActivity.class);
        intent.putExtra("zhaogenghuaiPush1", 110);
        builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 134217728));
        notificationManager.notify(4660, builder.build());
    }

    public static void showChannel2Notification(Context context) {
        Notification.Builder builder = new Notification.Builder(context, "2");
        builder.setSmallIcon(17301623).setContentText("xxx").setNumber(3).setContentTitle("Title");
        ((NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION)).notify(4661, builder.build());
    }
}
