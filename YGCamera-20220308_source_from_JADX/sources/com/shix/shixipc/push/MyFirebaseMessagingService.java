package com.shix.shixipc.push;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.shix.shixipc.activity.NUIMainActivity;
import com.shix.shixipc.utils.CommonUtil;
import shix.cykj.camera.R;

public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final String TAG = "MyFirebaseMsgService";
    private static int status_code;

    private void scheduleJob() {
    }

    private void sendRegistrationToServer(String str) {
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        String str;
        String str2;
        Log.d(TAG, "FCM From: " + remoteMessage.getFrom());
        if (remoteMessage.getData().size() > 0) {
            Log.d(TAG, "FCM Message data payload: " + remoteMessage.getData());
            scheduleJob();
        }
        if (remoteMessage.getNotification() != null) {
            Log.d(TAG, "FCM Message Notification Body: " + remoteMessage.getNotification().getBody());
        }
        if (remoteMessage.getNotification() == null) {
            str2 = remoteMessage.getData().get("title");
            str = remoteMessage.getData().get("text");
        } else {
            str2 = remoteMessage.getNotification().getBody();
            str = remoteMessage.getNotification().getTitle();
        }
        String str3 = str + "!";
        if (str2 == null || str2.length() == 0) {
            str2 = "FCM push no title";
        }
        if (str3 == null || str3.length() == 0) {
            str3 = "FCM push no text";
        }
        sendNotification(str2, str3);
    }

    public void onNewToken(String str) {
        Log.d(TAG, "FCM Refreshed token: " + str);
        sendRegistrationToServer(str);
    }

    private void handleNow() {
        Log.d(TAG, "FCM Short lived task is done.");
    }

    private void sendNotification(String str, String str2) {
        Intent intent = new Intent(this, NUIMainActivity.class);
        intent.addFlags(67108864);
        PendingIntent activity = PendingIntent.getActivity(this, 0, intent, 1073741824);
        String string = getString(R.string.default_notification_channel_id);
        NotificationCompat.Builder contentIntent = new NotificationCompat.Builder(this, string).setSmallIcon(R.mipmap.qh_dev2).setContentTitle(str).setContentText(str2).setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(4)).setContentIntent(activity);
        NotificationManager notificationManager = (NotificationManager) getSystemService(RemoteMessageConst.NOTIFICATION);
        if (Build.VERSION.SDK_INT >= 26) {
            notificationManager.createNotificationChannel(new NotificationChannel(string, "Channel human readable title", 3));
        }
        CommonUtil.Log(1, "FCM status_code:" + status_code);
        notificationManager.notify(status_code, contentIntent.build());
        status_code = status_code + 1;
    }
}
