package com.meizu.cloud.pushsdk;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.common.base.WorkReceiver;
import com.meizu.cloud.pushsdk.handler.a;
import com.meizu.cloud.pushsdk.notification.PushNotificationBuilder;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;
import com.meizu.cloud.pushsdk.platform.message.RegisterStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.cloud.pushsdk.util.d;

public abstract class MzPushMessageReceiver extends WorkReceiver {
    public static final String TAG = "MzPushMessageReceiver";

    public void onMessage(Context context, Intent intent) {
    }

    public abstract void onMessage(Context context, String str);

    public void onNotificationArrived(Context context, String str, String str2, String str3) {
    }

    public void onNotificationClicked(Context context, String str, String str2, String str3) {
    }

    public void onNotificationDeleted(Context context, String str, String str2, String str3) {
    }

    public void onNotifyMessageArrived(Context context, String str) {
    }

    public abstract void onPushStatus(Context context, PushSwitchStatus pushSwitchStatus);

    @Deprecated
    public abstract void onRegister(Context context, String str);

    public abstract void onRegisterStatus(Context context, RegisterStatus registerStatus);

    public abstract void onSubAliasStatus(Context context, SubAliasStatus subAliasStatus);

    public abstract void onSubTagsStatus(Context context, SubTagsStatus subTagsStatus);

    @Deprecated
    public abstract void onUnRegister(Context context, boolean z);

    public abstract void onUnRegisterStatus(Context context, UnRegisterStatus unRegisterStatus);

    public void onUpdateNotificationBuilder(PushNotificationBuilder pushNotificationBuilder) {
    }

    public void onReceive(Context context, Intent intent) {
        try {
            super.onReceive(context, intent);
        } catch (Exception e) {
            DebugLogger.e(TAG, "Event core error " + e.getMessage());
            String packageName = context.getPackageName();
            d.a(context, packageName, (String) null, (String) null, "3.3.170110", "MzPushMessageReceiver " + e.getMessage(), 3000);
        }
    }

    public void onHandleIntent(Context context, Intent intent) {
        DebugLogger.i(TAG, "receive action " + intent.getAction());
        a.a(context).a(TAG, new a() {
            public void a(Context context, String str) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onRegister " + str);
                MzPushMessageReceiver.this.onRegister(context, str);
            }

            public void b(Context context, String str) {
                MzPushMessageReceiver.this.onMessage(context, str);
                DebugLogger.i(MzPushMessageReceiver.TAG, "recive message " + str);
            }

            public void a(Context context, boolean z) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onUnRegister " + z);
                MzPushMessageReceiver.this.onUnRegister(context, z);
            }

            public void a(Context context, Intent intent) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onMessage Flyme3 " + intent);
                MzPushMessageReceiver.this.onMessage(context, intent);
            }

            public void a(PushNotificationBuilder pushNotificationBuilder) {
                MzPushMessageReceiver.this.onUpdateNotificationBuilder(pushNotificationBuilder);
            }

            public void a(Context context, PushSwitchStatus pushSwitchStatus) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onPushStatus " + pushSwitchStatus);
                MzPushMessageReceiver.this.onPushStatus(context, pushSwitchStatus);
            }

            public void a(Context context, RegisterStatus registerStatus) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onRegisterStatus " + registerStatus);
                MzPushMessageReceiver.this.onRegisterStatus(context, registerStatus);
            }

            public void a(Context context, UnRegisterStatus unRegisterStatus) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onUnRegisterStatus " + unRegisterStatus);
                MzPushMessageReceiver.this.onUnRegisterStatus(context, unRegisterStatus);
            }

            public void a(Context context, SubTagsStatus subTagsStatus) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onSubTagsStatus " + subTagsStatus);
                MzPushMessageReceiver.this.onSubTagsStatus(context, subTagsStatus);
            }

            public void a(Context context, SubAliasStatus subAliasStatus) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onSubAliasStatus " + subAliasStatus);
                MzPushMessageReceiver.this.onSubAliasStatus(context, subAliasStatus);
            }

            public void a(Context context, String str, String str2, String str3) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onNotificationClicked title " + str + "content " + str2 + " selfDefineContentString " + str3);
                MzPushMessageReceiver.this.onNotificationClicked(context, str, str2, str3);
            }

            public void b(Context context, String str, String str2, String str3) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onNotificationArrived title " + str + "content " + str2 + " selfDefineContentString " + str3);
                MzPushMessageReceiver.this.onNotificationArrived(context, str, str2, str3);
            }

            public void c(Context context, String str, String str2, String str3) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onNotificationDeleted title " + str + "content " + str2 + " selfDefineContentString " + str3);
                MzPushMessageReceiver.this.onNotificationDeleted(context, str, str2, str3);
            }

            public void c(Context context, String str) {
                DebugLogger.i(MzPushMessageReceiver.TAG, "onNotifyMessageArrived " + str);
                MzPushMessageReceiver.this.onNotifyMessageArrived(context, str);
            }
        }).a(intent);
    }
}
