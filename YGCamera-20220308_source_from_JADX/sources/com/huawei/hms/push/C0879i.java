package com.huawei.hms.push;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.push.utils.PluginUtil;
import com.huawei.hms.support.log.HMSLog;

/* renamed from: com.huawei.hms.push.i */
/* compiled from: SelfShow */
public class C0879i {
    /* renamed from: a */
    public static void m1226a(Context context, Intent intent) {
        if (context == null || intent == null) {
            HMSLog.m1374d("PushSelfShowLog", "enter SelfShowReceiver receiver, context or intent is null");
            return;
        }
        try {
            String action = intent.getAction();
            if (!"com.huawei.intent.action.PUSH".equals(action)) {
                if (!"com.huawei.push.msg.NOTIFY_MSG".equals(action)) {
                    if (!"com.huawei.intent.action.PUSH_DELAY_NOTIFY".equals(action)) {
                        return;
                    }
                }
            }
            byte[] byteArrayExtra = intent.getByteArrayExtra("selfshow_info");
            byte[] byteArrayExtra2 = intent.getByteArrayExtra("selfshow_token");
            if (!(byteArrayExtra == null || byteArrayExtra2 == null || byteArrayExtra.length == 0)) {
                if (byteArrayExtra2.length != 0) {
                    m1229a(context, intent, byteArrayExtra, byteArrayExtra2);
                    return;
                }
            }
            HMSLog.m1379i("PushSelfShowLog", "self show info or token is null.");
        } catch (RuntimeException e) {
            HMSLog.m1378e("PushSelfShowLog", "onReceive RuntimeException.", (Throwable) e);
        } catch (Exception unused) {
            HMSLog.m1374d("PushSelfShowLog", "onReceive Exception.");
        }
    }

    /* renamed from: a */
    public static void m1229a(Context context, Intent intent, byte[] bArr, byte[] bArr2) {
        String stringExtra = intent.getStringExtra("selfshow_event_id");
        int intExtra = intent.getIntExtra("selfshow_notify_id", 0);
        HMSLog.m1379i("PushSelfShowLog", "get notifyId:" + intExtra);
        C0881k kVar = new C0881k(bArr, bArr2);
        if (!kVar.mo14329z()) {
            HMSLog.m1374d("PushSelfShowLog", "parseMessage failed");
            return;
        }
        HMSLog.m1379i("PushSelfShowLog", "onReceive the msg id = " + kVar.mo14319p() + ",and cmd is " + kVar.mo14309i() + ",and the eventId is " + stringExtra);
        if (stringExtra == null) {
            m1227a(context, intent, kVar);
        } else {
            m1228a(context, intent, stringExtra, kVar, intExtra);
        }
    }

    /* renamed from: a */
    public static void m1227a(Context context, Intent intent, C0881k kVar) {
        HMSLog.m1379i("PushSelfShowLog", "receive a selfshow message, the cmd type is " + kVar.mo14309i());
        if (C0880j.m1230b(kVar.mo14309i())) {
            long a = C0887q.m1301a(kVar.mo14297c());
            if (a == 0) {
                new C0886p(context, kVar).start();
                return;
            }
            HMSLog.m1374d("PushSelfShowLog", "waiting...");
            intent.setPackage(context.getPackageName());
            C0887q.m1306a(context, intent, a);
        }
    }

    /* renamed from: a */
    public static void m1228a(Context context, Intent intent, String str, C0881k kVar, int i) {
        HMSLog.m1374d("PushSelfShowLog", "receive a selfshow user handle message eventId = " + str);
        if (!"-1".equals(str)) {
            C0887q.m1305a(context, intent);
        } else {
            C0887q.m1304a(context, i);
        }
        if ("1".equals(str)) {
            new C0880j(context, kVar).mo14288c();
            PluginUtil.onNotificationClicked(context, kVar.mo14319p(), kVar.mo14295b());
        } else if ("2".equals(str)) {
            C0875e.m1221a(context, kVar.mo14319p(), kVar.mo14295b(), "2");
        } else {
            HMSLog.m1374d("PushSelfShowLog", "other event");
        }
    }
}
