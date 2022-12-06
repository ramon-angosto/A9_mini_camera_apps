package shix.ihdbell.project;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.util.Log;
import com.jxl.app.littlestars.project.R;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;

@SuppressLint({"NewApi"})
public class XMMessageReceiver extends PushMessageReceiver {
    String CHANNEL_ONE_ID = ContentCommon.XM_PACKAGE_NAME;
    private int status_code = 0;

    @SuppressLint({"SimpleDateFormat"})
    private static String getSimpleDate() {
        return new SimpleDateFormat("MM-dd hh:mm:ss").format(new Date());
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        CommonUtil.Log(1, "XM_onReceivePassThroughMessage:" + miPushMessage.toString());
        CommonUtil.Log(1, "XM_TEST11:" + miPushMessage.getContent());
        if (SystemValue.mPlayer == null) {
            SystemValue.BELL_UDID = miPushMessage.getContent();
            SystemValue.mPlayer = MediaPlayer.create(context, R.raw.beep);
            SystemValue.mPlayer.setLooping(false);
            try {
                SystemValue.mPlayer.prepare();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            CommonUtil.Log(1, "zhao1234--初始化开始播�??");
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
            CommonUtil.Log(1, "zhao1234--不为空开始播�??");
            SystemValue.mPlayer.start();
        }
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        SystemValue.BELL_UDID = miPushMessage.toString();
        CommonUtil.Log(1, "XM_onNotificationMessageClicked:" + miPushMessage.toString());
    }

    private void notifyMessage(Context context, String str) {
        CommonUtil.Log(1, "notifyMessage :" + str);
        Log.e("notifyMessage", "#####xmmmessage");
        Notification.Builder channelId = new Notification.Builder(context).setChannelId(this.CHANNEL_ONE_ID);
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("zhaogenghuaiPush1", 110);
        PendingIntent activity = PendingIntent.getActivity(context, 0, intent, 134217728);
        channelId.setTicker("iHD Bell");
        channelId.setContentTitle("iHD Bell");
        channelId.setContentText(str);
        channelId.setSmallIcon(R.drawable.app);
        channelId.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.app));
        channelId.setWhen(System.currentTimeMillis());
        channelId.setAutoCancel(true);
        channelId.setContentIntent(activity);
        ((NotificationManager) context.getSystemService("notification")).notify(123, channelId.getNotification());
        this.status_code++;
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        CommonUtil.Log(1, "XM_onNotificationMessageArrived:" + miPushMessage.toString());
        CommonUtil.Log(1, "XM_TEST22:" + miPushMessage.getDescription());
        notifyMessage(context, miPushMessage.getDescription());
        if (SystemValue.mPlayer == null) {
            SystemValue.BELL_UDID = miPushMessage.getDescription();
            SystemValue.mPlayer = MediaPlayer.create(context, R.raw.beep);
            SystemValue.mPlayer.setLooping(false);
            try {
                SystemValue.mPlayer.prepare();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            CommonUtil.Log(1, "zhao1234--初始化开始播�??");
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
            CommonUtil.Log(1, "zhao1234--不为空开始播�??");
            SystemValue.mPlayer.start();
        }
    }

    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        CommonUtil.Log(1, "XM_onCommandResult:" + miPushCommandMessage.toString());
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        CommonUtil.Log(1, "XM_onReceiveRegisterResult:" + miPushCommandMessage.toString());
    }
}
