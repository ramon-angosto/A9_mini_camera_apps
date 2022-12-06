package shix.ihdbell.project;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;
import com.jxl.app.littlestars.project.R;
import com.meizu.cloud.pushsdk.MzPushMessageReceiver;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import java.io.IOException;
import object.p2pipcam.content.ContentCommon;
import object.p2pipcam.system.SystemValue;
import object.p2pipcam.utils.CommonUtil;

public class MZPushMsgReceiver extends MzPushMessageReceiver {
    private static final String TAG = "comsince";

    @Deprecated
    public void onRegister(Context context, String str) {
        CommonUtil.Log(1, "MZ_onRegister pushID:" + str);
        if (ContentCommon.MZ_STRING == null || ContentCommon.MZ_STRING.length() < 6) {
            ContentCommon.MZ_STRING = str;
        }
        print(context, "receive pushID " + str);
    }

    public void onMessage(Context context, String str) {
        CommonUtil.Log(1, "MZ_onMessage:" + str);
        if (SystemValue.mPlayer == null) {
            SystemValue.BELL_UDID = str;
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
            CommonUtil.Log(1, "zhao1234--不为空开始播");
            SystemValue.mPlayer.start();
        }
    }

    public void onMessage(Context context, Intent intent) {
        String bundle = intent.getExtras().toString();
        CommonUtil.Log(1, "MZ_flyme3 onMessage:" + bundle);
        print(context, "flyme3 onMessage " + bundle);
    }

    @Deprecated
    public void onUnRegister(Context context, boolean z) {
        CommonUtil.Log(1, "MZ_onUnRegister");
        print(context, context.getPackageName() + " onUnRegister " + z);
    }

    public void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus) {
        CommonUtil.Log(1, "MZ_onPushStatus");
    }

    public void onRegisterStatus(Context context, RegisterStatus registerStatus) {
        CommonUtil.Log(1, "MZ_onRegisterStatus " + registerStatus + " " + context.getPackageName());
    }

    public void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus) {
        CommonUtil.Log(1, "MZ_onUnRegisterStatus " + unRegisterStatus + " " + context.getPackageName());
    }

    public void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus) {
        CommonUtil.Log(1, "MZ_onSubTagsStatus " + subTagsStatus + " " + context.getPackageName());
    }

    public void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus) {
        CommonUtil.Log(1, "MZ_onSubAliasStatus " + subAliasStatus + " " + context.getPackageName());
    }

    public void onUpdateNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
        pushNotificationBuilder.setmLargIcon(R.drawable.app);
        pushNotificationBuilder.setmStatusbarIcon(R.drawable.little_stars_logo_icon_green);
    }

    public void onNotificationArrived(Context context, String str, String str2, String str3) {
        CommonUtil.Log(1, "MZ_onNotificationArrived title " + str + "content " + str2 + " selfDefineContentString " + str3);
    }

    public void onNotificationClicked(Context context, String str, String str2, String str3) {
        CommonUtil.Log(1, "MZ_onNotificationClicked title " + str + "content " + str2 + " selfDefineContentString " + str3);
    }

    public void onNotificationDeleted(Context context, String str, String str2, String str3) {
        CommonUtil.Log(1, "MZ_onNotificationDeleted title " + str + "content " + str2 + " selfDefineContentString " + str3);
    }

    private void print(final Context context, final String str) {
        new Handler(context.getMainLooper()).post(new Runnable() {
            public void run() {
                Toast.makeText(context, str, 1).show();
            }
        });
    }
}
