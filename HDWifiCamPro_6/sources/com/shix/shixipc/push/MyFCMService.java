package com.shix.shixipc.push;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.media.SoundPool;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.shix.qhipc.R;
import com.shix.shixipc.CrashApplication;
import com.shix.shixipc.activity.NUIMainActivity;
import java.text.SimpleDateFormat;

public class MyFCMService extends FirebaseMessagingService {
    private static final String TAG = "MyFCMService";
    private String notifyData;
    private String notifyTitle;
    SoundPool sp = null;
    int status_code = 0;

    public MyFCMService() {
        Log.e(TAG, "FCM MyFCMService start");
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e(TAG, "FCM MyFCMService onMessageReceived time=" + remoteMessage.getSentTime());
        Log.e(TAG, "FCM MyFCMService onMessageReceived time=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(remoteMessage.getSentTime())));
        Log.e(TAG, "FCM MyFCMService From: " + remoteMessage.getFrom());
        this.notifyData = null;
        this.notifyTitle = null;
        if (remoteMessage.getData().size() > 0) {
            Log.e(TAG, "FCM MyFCMService Message data payload: " + remoteMessage.getData());
            this.notifyData = remoteMessage.getData().toString();
        }
        String str = remoteMessage.getData().get(CampaignEx.JSON_KEY_TITLE);
        String str2 = remoteMessage.getData().get(MimeTypes.BASE_TYPE_TEXT);
        if (str == null || str.length() == 0) {
            str = "FCM push no title";
        }
        if (str2 == null || str2.length() == 0) {
            str2 = "FCM push no text";
        }
        notifyMessage(str, str2);
        play();
    }

    private void sendNotification(String str, String str2) {
        Intent intent = new Intent(this, NUIMainActivity.class);
        intent.addFlags(67108864);
        ((NotificationManager) getSystemService("notification")).notify(0, new NotificationCompat.Builder(this).setSmallIcon((int) R.mipmap.qh_dev2).setContentTitle(str).setContentText(str2).setAutoCancel(true).setSound(RingtoneManager.getDefaultUri(2)).setContentIntent(PendingIntent.getActivity(this, 0, intent, 1073741824)).build());
    }

    public void InitSound() {
        if (this.sp == null) {
            this.sp = new SoundPool(5, 3, 0);
        }
    }

    public void playSound(int i) {
        this.sp.load(this, i, 1);
        this.sp.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            public void onLoadComplete(SoundPool soundPool, int i, int i2) {
                soundPool.play(1, 1.0f, 1.0f, 1, 0, 1.0f);
            }
        });
    }

    private void play() {
        InitSound();
        playSound(R.raw.alrm_111);
    }

    private void notifyMessage(String str, String str2) {
        Notification.Builder builder = new Notification.Builder(CrashApplication.getContext());
        Intent intent = new Intent(CrashApplication.getContext(), NUIMainActivity.class);
        intent.putExtra("zhaogenghuaiPush1", 110);
        PendingIntent activity = PendingIntent.getActivity(CrashApplication.getContext(), 0, intent, 134217728);
        builder.setTicker(str);
        builder.setContentTitle(str);
        builder.setContentText(str2);
        builder.setSmallIcon(R.mipmap.qh_dev2);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.qh_dev2));
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(false);
        builder.setContentIntent(activity);
        ((NotificationManager) CrashApplication.getContext().getSystemService("notification")).notify(this.status_code, builder.getNotification());
        this.status_code++;
    }
}
