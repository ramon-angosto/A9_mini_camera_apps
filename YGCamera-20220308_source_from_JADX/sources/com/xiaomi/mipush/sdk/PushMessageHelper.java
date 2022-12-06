package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.C1882ib;
import com.xiaomi.push.C1898ir;
import java.util.List;

public class PushMessageHelper {
    public static final String ERROR_MESSAGE = "error_message";
    public static final String ERROR_TYPE = "error_type";
    public static final String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_ERROR = 5;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode;

    public static MiPushCommandMessage generateCommandMessage(String str, List<String> list, long j, String str2, String str3) {
        MiPushCommandMessage miPushCommandMessage = new MiPushCommandMessage();
        miPushCommandMessage.setCommand(str);
        miPushCommandMessage.setCommandArguments(list);
        miPushCommandMessage.setResultCode(j);
        miPushCommandMessage.setReason(str2);
        miPushCommandMessage.setCategory(str3);
        return miPushCommandMessage;
    }

    public static MiPushMessage generateMessage(C1898ir irVar, C1882ib ibVar, boolean z) {
        MiPushMessage miPushMessage = new MiPushMessage();
        miPushMessage.setMessageId(irVar.mo18204a());
        if (!TextUtils.isEmpty(irVar.mo18209d())) {
            miPushMessage.setMessageType(1);
            miPushMessage.setAlias(irVar.mo18209d());
        } else if (!TextUtils.isEmpty(irVar.mo18207c())) {
            miPushMessage.setMessageType(2);
            miPushMessage.setTopic(irVar.mo18207c());
        } else if (!TextUtils.isEmpty(irVar.mo18212f())) {
            miPushMessage.setMessageType(3);
            miPushMessage.setUserAccount(irVar.mo18212f());
        } else {
            miPushMessage.setMessageType(0);
        }
        miPushMessage.setCategory(irVar.mo18210e());
        if (irVar.mo18204a() != null) {
            miPushMessage.setContent(irVar.mo18204a().mo17854c());
        }
        if (ibVar != null) {
            if (TextUtils.isEmpty(miPushMessage.getMessageId())) {
                miPushMessage.setMessageId(ibVar.mo17876a());
            }
            if (TextUtils.isEmpty(miPushMessage.getTopic())) {
                miPushMessage.setTopic(ibVar.mo17883b());
            }
            miPushMessage.setDescription(ibVar.mo17894d());
            miPushMessage.setTitle(ibVar.mo17888c());
            miPushMessage.setNotifyType(ibVar.mo17876a());
            miPushMessage.setNotifyId(ibVar.mo17888c());
            miPushMessage.setPassThrough(ibVar.mo17883b());
            miPushMessage.setExtra(ibVar.mo17876a());
        }
        miPushMessage.setNotified(z);
        return miPushMessage;
    }

    public static C1882ib generateMessage(MiPushMessage miPushMessage) {
        C1882ib ibVar = new C1882ib();
        ibVar.mo17879a(miPushMessage.getMessageId());
        ibVar.mo17885b(miPushMessage.getTopic());
        ibVar.mo17893d(miPushMessage.getDescription());
        ibVar.mo17890c(miPushMessage.getTitle());
        ibVar.mo17889c(miPushMessage.getNotifyId());
        ibVar.mo17878a(miPushMessage.getNotifyType());
        ibVar.mo17884b(miPushMessage.getPassThrough());
        ibVar.mo17880a(miPushMessage.getExtra());
        return ibVar;
    }

    public static int getPushMode(Context context) {
        if (pushMode == 0) {
            setPushMode(isUseCallbackPushMode(context) ? 1 : 2);
        }
        return pushMode;
    }

    private static boolean isIntentAvailable(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 32);
            return queryBroadcastReceivers != null && !queryBroadcastReceivers.isEmpty();
        } catch (Exception unused) {
            return true;
        }
    }

    public static boolean isUseCallbackPushMode(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setClassName(context.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(context, intent);
    }

    public static void sendCommandMessageBroadcast(Context context, MiPushCommandMessage miPushCommandMessage) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 3);
        intent.putExtra(KEY_COMMAND, miPushCommandMessage);
        new PushServiceReceiver().onReceive(context, intent);
    }

    public static void sendQuitMessageBroadcast(Context context) {
        Intent intent = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        intent.setPackage(context.getPackageName());
        intent.putExtra("message_type", 4);
        new PushServiceReceiver().onReceive(context, intent);
    }

    private static void setPushMode(int i) {
        pushMode = i;
    }
}
