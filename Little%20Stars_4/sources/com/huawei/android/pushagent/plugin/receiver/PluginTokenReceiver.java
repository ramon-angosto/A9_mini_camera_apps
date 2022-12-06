package com.huawei.android.pushagent.plugin.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.tools.BLocation;

public class PluginTokenReceiver extends BroadcastReceiver {
    /* access modifiers changed from: private */
    public static com.huawei.android.pushagent.plugin.b.a a;

    private static class a extends Thread {
        private a() {
        }

        public void run() {
            PluginTokenReceiver.a.a();
        }
    }

    public PluginTokenReceiver(com.huawei.android.pushagent.plugin.b.a aVar) {
        a(aVar);
    }

    private static void a(com.huawei.android.pushagent.plugin.b.a aVar) {
        a = aVar;
    }

    public void onReceive(Context context, Intent intent) {
        try {
            e.a(BLocation.TAG, "enter PushMsgReceiver:onReceive(Intent:" + intent.getAction() + " pkgName:" + context.getPackageName() + ")");
            if ("com.huawei.android.push.intent.REGISTRATION".equals(intent.getAction()) && intent.hasExtra("device_token")) {
                String str = new String(intent.getByteArrayExtra("device_token"), "UTF-8");
                e.a(BLocation.TAG, "get deviceToken success");
                new com.huawei.android.pushagent.plugin.a.e(context).d(str);
                new a().start();
            }
        } catch (Exception e) {
            e.c(BLocation.TAG, "call onReceive(intent:" + intent + ") cause:" + e.toString(), e);
        }
    }
}
