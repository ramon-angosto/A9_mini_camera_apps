package com.huawei.android.pushagent.plugin.tools;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.c.a.f;
import com.huawei.android.pushagent.plugin.b.a;
import com.huawei.android.pushagent.plugin.receiver.PluginTokenReceiver;

public class c {
    private static BroadcastReceiver a;

    private static synchronized void a(BroadcastReceiver broadcastReceiver) {
        synchronized (c.class) {
            a = broadcastReceiver;
        }
    }

    public static final synchronized void a(Context context) {
        synchronized (c.class) {
            try {
                if (a != null) {
                    context.getApplicationContext().unregisterReceiver(a);
                }
            } catch (Exception e) {
                e.c(BLocation.TAG, e.getMessage(), e);
            }
            a((BroadcastReceiver) null);
        }
    }

    public static final synchronized void a(Context context, a aVar) {
        synchronized (c.class) {
            if (a != null) {
                a(context);
            }
            e.a(BLocation.TAG, "enter PushEntity:getToken() pkgName" + context.getPackageName());
            Intent intent = new Intent("com.huawei.android.push.intent.REGISTER");
            intent.putExtra("pkg_name", context.getPackageName());
            intent.setFlags(32);
            context.sendBroadcast(intent);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.huawei.android.push.intent.REGISTRATION");
            a((BroadcastReceiver) new PluginTokenReceiver(aVar));
            context.getApplicationContext().registerReceiver(a, intentFilter);
        }
    }

    public static String b(Context context) {
        if (context == null) {
            return "";
        }
        String a2 = f.a(context, "push_client_self_info", "token_info");
        return !TextUtils.isEmpty(a2) ? a2 : new com.huawei.android.pushagent.plugin.a.e(context).h();
    }
}
