package com.shix.fcmpush1;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.util.Log;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.jxl.app.littlestars.project.R;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import java.io.IOException;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;
import shix.ihdbell.project.MainActivity;

@SuppressLint({"NewApi"})
public class MyMessagingService extends FirebaseMessagingService {
    private static final String TAG = "FCM";
    private static Context context;
    private static int status_code;

    public void onCreate() {
        super.onCreate();
        context = FcmPush.context;
        Log.d("FCM", "消息接收服务被启�?");
    }

    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.e("FCM", "收到信息:" + remoteMessage.getData());
        Log.e("FCM", "From: " + remoteMessage.getFrom());
        Log.e("FCM", "Title: " + remoteMessage.getData().get(PushConstants.TITLE));
        Log.e("FCM", "data: " + remoteMessage.getData().get("text"));
        if (SystemValue.isSoftRun) {
            CommonUtil.Log(1, "zhao1234--程序在前�?");
            return;
        }
        notifyMessage(remoteMessage);
        SystemValue.BELL_UDID = remoteMessage.getData().get("text");
        CommonUtil.Log(1, "zhaogenghuai---SystemValue.BELL_UDID:" + SystemValue.BELL_UDID);
        if (SystemValue.mPlayer == null) {
            SystemValue.mPlayer = MediaPlayer.create(context, R.raw.beep);
            SystemValue.mPlayer.setLooping(false);
            try {
                SystemValue.mPlayer.prepare();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            CommonUtil.Log(1, "zhao1234--初始化开始播�?");
            SystemValue.mPlayer.start();
            SystemValue.mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                public void onCompletion(MediaPlayer mediaPlayer) {
                    Log.d("tag", "zhao1234--播放完毕");
                    if (SystemValue.mPlayer != null) {
                        CommonUtil.Log(1, "zhao1234--释放句柄");
                        SystemValue.mPlayer.stop();
                        SystemValue.mPlayer.release();
                        SystemValue.mPlayer = null;
                    }
                }
            });
        } else if (!SystemValue.mPlayer.isPlaying()) {
            CommonUtil.Log(1, "zhao1234--不为空开始播�?");
            SystemValue.mPlayer.start();
        }
    }

    public void onDeletedMessages() {
        Log.d("FCM", "刪除信息");
        if (SystemValue.mPlayer != null) {
            CommonUtil.Log(1, "zhao1234--释放-NOTIFACTION_CLICKED_TYPE");
            SystemValue.mPlayer.stop();
            SystemValue.mPlayer.release();
            SystemValue.mPlayer = null;
        }
        super.onDeletedMessages();
    }

    private void notifyMessage(RemoteMessage remoteMessage) {
        Notification.Builder builder = new Notification.Builder(context);
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("zhaogenghuaiPush1", 110);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        builder.setTicker(remoteMessage.getData().get(PushConstants.TITLE));
        builder.setContentTitle(remoteMessage.getData().get(PushConstants.TITLE));
        builder.setContentText(remoteMessage.getData().get("text"));
        builder.setSmallIcon(R.drawable.app);
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.app));
        builder.setWhen(System.currentTimeMillis());
        builder.setAutoCancel(true);
        builder.setContentIntent(activity);
        ((NotificationManager) context.getSystemService("notification")).notify(status_code, builder.getNotification());
        status_code++;
    }
}
