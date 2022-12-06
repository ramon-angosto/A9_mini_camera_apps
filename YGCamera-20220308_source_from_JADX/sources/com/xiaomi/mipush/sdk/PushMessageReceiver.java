package com.xiaomi.mipush.sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.entity.auth.AuthCode;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.mipush.sdk.MessageHandleService;
import com.xiaomi.push.C1776eu;

public abstract class PushMessageReceiver extends BroadcastReceiver {
    public void onCommandResult(Context context, MiPushCommandMessage miPushCommandMessage) {
    }

    public void onNotificationMessageArrived(Context context, MiPushMessage miPushMessage) {
    }

    public void onNotificationMessageClicked(Context context, MiPushMessage miPushMessage) {
    }

    public final void onReceive(Context context, Intent intent) {
        MessageHandleService.addJob(context.getApplicationContext(), new MessageHandleService.C1543a(intent, this));
        try {
            int intExtra = intent.getIntExtra("eventMessageType", -1);
            if (intExtra == 2000) {
                C1776eu.m3405a(context.getApplicationContext()).mo17534a(context.getPackageName(), intent, 2003, (String) null);
            } else if (intExtra == 6000) {
                C1776eu.m3405a(context.getApplicationContext()).mo17534a(context.getPackageName(), intent, (int) AuthCode.StatusCode.PERMISSION_NOT_AUTHORIZED, (String) null);
            }
        } catch (Exception e) {
            C1524b.m2155a((Throwable) e);
        }
    }

    @Deprecated
    public void onReceiveMessage(Context context, MiPushMessage miPushMessage) {
    }

    public void onReceivePassThroughMessage(Context context, MiPushMessage miPushMessage) {
    }

    public void onReceiveRegisterResult(Context context, MiPushCommandMessage miPushCommandMessage) {
    }

    public void onRequirePermissions(Context context, String[] strArr) {
    }
}
