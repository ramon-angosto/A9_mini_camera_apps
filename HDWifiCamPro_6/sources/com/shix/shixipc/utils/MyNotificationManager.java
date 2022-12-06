package com.shix.shixipc.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.internal.view.SupportMenu;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.shix.qhipc.R;
import com.shix.shixipc.activity.NUIMainActivity;

public class MyNotificationManager {
    public static final String TAG = "MyNotificationManager";

    public static void initNotificationChannel(Context context) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        notificationManager.createNotificationChannelGroup(new NotificationChannelGroup(CampaignUnit.JSON_KEY_SESSION_ID, CampaignUnit.JSON_KEY_SESSION_ID));
        NotificationChannel notificationChannel = new NotificationChannel("1", "Channel1", 3);
        notificationChannel.enableLights(true);
        notificationChannel.setLightColor(-16711936);
        notificationChannel.setShowBadge(true);
        notificationManager.createNotificationChannel(notificationChannel);
        NotificationChannel notificationChannel2 = new NotificationChannel("2", "Channel2", 3);
        notificationChannel2.enableLights(true);
        notificationChannel2.setLightColor(-16711936);
        notificationChannel2.setGroup(CampaignUnit.JSON_KEY_SESSION_ID);
        notificationManager.createNotificationChannel(notificationChannel2);
    }

    public static void showChannel1Notification(Context context, String str, String str2, Uri uri) {
        NotificationChannel notificationChannel = new NotificationChannel("1", "channel_name", 4);
        notificationChannel.setLightColor(SupportMenu.CATEGORY_MASK);
        notificationChannel.setLockscreenVisibility(0);
        notificationChannel.setShowBadge(true);
        notificationChannel.setBypassDnd(true);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
        notificationManager.createNotificationChannel(notificationChannel);
        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentText(str2);
        builder.setContentTitle(str);
        builder.setSmallIcon(R.mipmap.app);
        builder.setChannelId("1");
        builder.setDefaults(2);
        Intent intent = new Intent(context, NUIMainActivity.class);
        intent.putExtra("zhaogenghuaiPush1", 110);
        builder.setContentIntent(PendingIntent.getActivity(context, 0, intent, 134217728));
        notificationManager.notify((int) (Math.random() * 1000.0d), builder.build());
    }

    public static void showChannel2Notification(Context context) {
        Notification.Builder builder = new Notification.Builder(context, "2");
        builder.setSmallIcon(17301623).setContentText("xxx").setNumber(3).setContentTitle("Title");
        ((NotificationManager) context.getSystemService("notification")).notify(4661, builder.build());
    }
}
