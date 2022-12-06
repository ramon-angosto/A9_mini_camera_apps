package com.huawei.android.pushagent.plugin.tools;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.PushPlugins;
import com.huawei.android.pushagent.plugin.a.f;
import com.huawei.android.pushagent.plugin.c;
import com.huawei.android.pushagent.plugin.c.b;
import java.util.List;

public class PushPluginsBroadcastMgr {
    /* access modifiers changed from: private */
    public static String a = "PushLogSC2705";

    private static class a implements Runnable {
        private b a;
        private Context b;

        private a(Context context, b bVar) {
            this.a = bVar;
            this.b = context;
        }

        public void run() {
            try {
                String a2 = this.a.a(this.b);
                if (!TextUtils.isEmpty(a2)) {
                    new c(this.b).a(a2, this.a.a(), this.a.c());
                    return;
                }
                String a3 = PushPluginsBroadcastMgr.a;
                e.b(a3, "plus data is null, cannot report:" + this.a.b());
            } catch (Exception e) {
                String a4 = PushPluginsBroadcastMgr.a;
                e.c(a4, "report plugin data error:" + e.getMessage(), e);
            }
        }
    }

    public static void handleEvent(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            b a2 = b.a(context);
            List<b> a3 = a2.a();
            if ("com.huawei.android.push.PLUGIN".equals(action)) {
                if (intent.hasExtra("plusAlarm")) {
                    e.b(a, "alarm reached , prepare to report message");
                    if (a3.isEmpty()) {
                        a2.c(context);
                        return;
                    }
                    for (b bVar : a3) {
                        if ((bVar.c(context) + bVar.b(context)) - 5000 < System.currentTimeMillis()) {
                            if (f.LBS.b() == bVar.a()) {
                                BLocation.getInstance(context).requestLocation();
                            }
                            bVar.b(context, System.currentTimeMillis());
                            new Thread(new a(context, bVar)).start();
                        } else {
                            String str = a;
                            e.b(str, "plus cycle has not reached :" + bVar.b());
                        }
                    }
                    return;
                }
            }
            if ("com.huawei.android.push.PLUGIN".equals(action) && intent.hasExtra("plusReport")) {
                Bundle bundleExtra = intent.getBundleExtra("plusReport");
                if (bundleExtra == null) {
                    e.b(a, "plusReport not found in intent");
                    return;
                }
                int i = bundleExtra.getInt("plusType");
                int i2 = bundleExtra.getInt("operType");
                String str2 = a;
                e.a(str2, "receive plugin broadcast, plusType:" + i + ",operType:" + i2);
                if (i2 == 0) {
                    new PushPlugins(context).closeCyclePlus(i);
                } else if (1 == i2) {
                    long j = bundleExtra.getLong("cycle");
                    new PushPlugins(context).reportPlus(i, bundleExtra.getString("content"), j);
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                e.a(a, "network change");
                if (!a3.isEmpty()) {
                    boolean z = false;
                    for (b bVar2 : a3) {
                        if (bVar2.c(context) + bVar2.b(context) < System.currentTimeMillis()) {
                            bVar2.b(context, System.currentTimeMillis());
                            z = true;
                        } else {
                            String str3 = a;
                            e.a(str3, "plus cycle has not reached :" + bVar2.b());
                        }
                    }
                    if (z) {
                        com.huawei.android.pushagent.c.a.a.a(context, new Intent("com.huawei.android.push.PLUGIN").putExtra("plusAlarm", "alarm").setPackage(context.getPackageName()), b.a(context).b(context));
                        return;
                    }
                    return;
                }
                e.b(a, "no cycle task need to run");
            }
        } catch (Exception e) {
            e.c(a, e.getMessage(), e);
        }
    }
}
