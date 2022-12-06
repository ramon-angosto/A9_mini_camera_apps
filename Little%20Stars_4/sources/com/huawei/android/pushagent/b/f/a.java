package com.huawei.android.pushagent.b.f;

import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.c.a.e;

public class a extends com.huawei.android.pushagent.b.a {
    private static String a = "PushLogAC2705";
    private static boolean b = false;

    public a(Context context) {
    }

    public static void a(Context context, boolean z, String str) {
        Intent intent = new Intent();
        String str2 = a;
        e.a(str2, "sendStateBroadcast the current push state is: " + z);
        intent.setAction("com.huawei.intent.action.PUSH_STATE").putExtra("push_state", z).setFlags(32).setPackage(str);
        context.sendBroadcast(intent);
    }

    private static synchronized void a(boolean z) {
        synchronized (a.class) {
            b = z;
        }
    }

    public void a(Context context, Intent intent) {
        String str = a;
        e.a(str, "enter ChannelRecorder:onReceive(intent:" + intent + " context:" + context);
        String action = intent.getAction();
        boolean a2 = com.huawei.android.pushagent.b.a.a.e().a();
        String str2 = a;
        e.a(str2, "PushState get action :" + action);
        if ("com.huawei.android.push.intent.GET_PUSH_STATE".equals(action)) {
            String stringExtra = intent.getStringExtra("pkg_name");
            String str3 = a;
            e.a(str3, "responseClinetGetPushState: get the client packageName: " + stringExtra);
            try {
                String str4 = a;
                e.a(str4, "current program pkgName" + context.getPackageName());
                String str5 = a;
                e.a(str5, "the current push curIsConnect:" + a2);
                a(context, a2, stringExtra);
            } catch (Exception e) {
                String str6 = a;
                e.a(str6, "e:" + e.toString());
            }
        }
        if (b != a2) {
            a(a2);
        }
    }
}
