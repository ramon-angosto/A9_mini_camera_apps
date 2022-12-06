package com.shix.shixipc.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.shix.shixipc.utils.CommonUtil;
import com.shix.shixipc.utils.MyNotificationManager;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import shix.cykj.camera.R;

public class DemoMessageReceiver extends PushMessageReceiver {
    private String mAccount;
    private String mAlias;
    private String mEndTime;
    private String mRegId;
    private String mStartTime;
    private String mTopic;
    int status_code = 0;

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
        CommonUtil.Log(1, "小米推送 -------------onReceivePassThroughMessage()：" + miPushMessage.toString());
        if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
            this.mTopic = miPushMessage.getTopic();
        } else if (!TextUtils.isEmpty(miPushMessage.getAlias())) {
            this.mAlias = miPushMessage.getAlias();
        }
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
        CommonUtil.Log(1, "小米推送 -------------onNotificationMessageClicked()：" + miPushMessage.toString());
        if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
            this.mTopic = miPushMessage.getTopic();
        } else if (!TextUtils.isEmpty(miPushMessage.getAlias())) {
            this.mAlias = miPushMessage.getAlias();
        }
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
        CommonUtil.Log(1, "小米推送 -Z------------onNotificationMessageArrived()：" + miPushMessage.toString());
        if (!TextUtils.isEmpty(miPushMessage.getTopic())) {
            this.mTopic = miPushMessage.getTopic();
        } else if (!TextUtils.isEmpty(miPushMessage.getAlias())) {
            this.mAlias = miPushMessage.getAlias();
        }
        String title = miPushMessage.getTitle();
        String description = miPushMessage.getDescription();
        if (title == null || title.length() == 0) {
            title = "XM push no title";
        }
        if (description == null || description.length() == 0) {
            description = "XM push no text";
        }
        notifyMessage(context, title + "    " + description);
    }

    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        CommonUtil.Log(1, "小米推送 -------------onCommandResult()：" + miPushCommandMessage.toString());
        String command = miPushCommandMessage.getCommand();
        List<String> commandArguments = miPushCommandMessage.getCommandArguments();
        String str = null;
        String str2 = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
        if (commandArguments != null && commandArguments.size() > 1) {
            str = commandArguments.get(1);
        }
        if (MiPushClient.COMMAND_REGISTER.equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mRegId = str2;
            }
        } else if (MiPushClient.COMMAND_SET_ALIAS.equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mAlias = str2;
            }
        } else if (MiPushClient.COMMAND_UNSET_ALIAS.equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mAlias = str2;
            }
        } else if (MiPushClient.COMMAND_SET_ACCOUNT.equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mAccount = str2;
            }
        } else if (MiPushClient.COMMAND_UNSET_ACCOUNT.equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mAccount = str2;
            }
        } else if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mTopic = str2;
            }
        } else if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(command)) {
            if (miPushCommandMessage.getResultCode() == 0) {
                this.mTopic = str2;
            }
        } else if (!MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(command)) {
            miPushCommandMessage.getReason();
        } else if (miPushCommandMessage.getResultCode() == 0) {
            this.mStartTime = str2;
            this.mEndTime = str;
        }
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
        CommonUtil.Log(1, "小米推送 -------------onReceiveRegisterResult()：" + miPushCommandMessage.toString());
        String command = miPushCommandMessage.getCommand();
        List<String> commandArguments = miPushCommandMessage.getCommandArguments();
        String str = (commandArguments == null || commandArguments.size() <= 0) ? null : commandArguments.get(0);
        if (!MiPushClient.COMMAND_REGISTER.equals(command)) {
            miPushCommandMessage.getReason();
        } else if (miPushCommandMessage.getResultCode() == 0) {
            this.mRegId = str;
        }
    }

    public void onRequirePermissions(Context context, String[] strArr) {
        super.onRequirePermissions(context, strArr);
        if (Build.VERSION.SDK_INT >= 23 && context.getApplicationInfo().targetSdkVersion >= 23) {
            Intent intent = new Intent();
            intent.putExtra("permissions", strArr);
            intent.setComponent(new ComponentName(context.getPackageName(), PermissionActivity.class.getCanonicalName()));
            intent.addFlags(276824064);
            context.startActivity(intent);
        }
    }

    private static String getSimpleDate() {
        return new SimpleDateFormat("MM-dd hh:mm:ss").format(new Date());
    }

    public String arrayToString(String[] strArr) {
        String str = " ";
        for (String str2 : strArr) {
            str = str + str2 + " ";
        }
        return str;
    }

    private void notifyMessage(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 26) {
            MyNotificationManager.showChannel1Notification(context, str + "", Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.beep));
        }
        this.status_code++;
    }
}
