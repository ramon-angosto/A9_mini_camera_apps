package shix.ihdbell.project;

import android.app.NotificationManager;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import com.huawei.android.pushagent.PushReceiver;
import com.huawei.android.pushagent.api.PushEventReceiver;
import com.jxl.app.littlestars.project.R;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;

public class HWMyReceiver extends PushEventReceiver {
    public void onToken(Context context, String str, Bundle bundle) {
        CommonUtil.Log(1, "HW_content:" + ("获取token和belongId成功，token = " + str + ",belongId = " + bundle.getString("belongId")));
        if (ContentCommon.HW_STRING == null || ContentCommon.HW_STRING.length() < 6) {
            ContentCommon.HW_STRING = str;
        }
    }

    public boolean onPushMsg(Context context, byte[] bArr, Bundle bundle) {
        try {
            CommonUtil.Log(1, "HW_onPushMsg:" + ("收到条Push消息 " + new String(bArr, "UTF-8")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (SystemValue.mPlayer == null) {
            try {
                SystemValue.BELL_UDID = new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
            SystemValue.mPlayer = MediaPlayer.create(context, R.raw.beep);
            SystemValue.mPlayer.setLooping(false);
            try {
                SystemValue.mPlayer.prepare();
            } catch (IllegalStateException e3) {
                e3.printStackTrace();
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            CommonUtil.Log(1, "zhao1234--初始化开始播");
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
        return false;
    }

    public void onEvent(Context context, PushReceiver.Event event, Bundle bundle) {
        if (PushReceiver.Event.NOTIFICATION_OPENED.equals(event) || PushReceiver.Event.NOTIFICATION_CLICK_BTN.equals(event)) {
            int i = bundle.getInt(PushReceiver.BOUND_KEY.pushNotifyId, 0);
            if (i != 0) {
                ((NotificationManager) context.getSystemService("notification")).cancel(i);
            }
            CommonUtil.Log(1, "HW_onEvent:" + ("收到通知附加消息 " + bundle.getString(PushReceiver.BOUND_KEY.pushMsgKey)));
        } else if (PushReceiver.Event.PLUGINRSP.equals(event)) {
            int i2 = bundle.getInt(PushReceiver.BOUND_KEY.PLUGINREPORTTYPE, -1);
            bundle.getBoolean(PushReceiver.BOUND_KEY.PLUGINREPORTRESULT, false);
            if (1 != i2) {
            }
        }
        super.onEvent(context, event, bundle);
    }
}
