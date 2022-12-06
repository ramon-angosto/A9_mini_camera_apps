package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.push.C0879i;
import com.huawei.hms.push.C0890t;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;

public class PushMsgReceiver extends BroadcastReceiver {
    /* renamed from: a */
    public static void m1354a(Context context, Intent intent) {
        if (intent.hasExtra("selfshow_info")) {
            if (!C0890t.m1323a(context)) {
                HMSLog.m1379i("PushMsgReceiver", context.getPackageName() + " disable display notification.");
            }
            C0879i.m1226a(context, intent);
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && context != null) {
            HMSLog.m1379i("PushMsgReceiver", "push receive broadcast message, Intent:" + intent.getAction() + " pkgName:" + context.getPackageName());
            try {
                intent.getStringExtra("TestIntent");
                String action = intent.getAction();
                if (ResourceLoaderUtil.getmContext() == null) {
                    ResourceLoaderUtil.setmContext(context.getApplicationContext());
                }
                if ("com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action) || ("com.huawei.intent.action.PUSH".equals(action) && HwBuildEx.VERSION.EMUI_SDK_INT < 10)) {
                    m1354a(context, intent);
                    return;
                }
                HMSLog.m1379i("PushMsgReceiver", "message can't be recognised:" + intent.toUri(0));
            } catch (Exception unused) {
                HMSLog.m1377e("PushMsgReceiver", "intent has some error");
            }
        }
    }
}
