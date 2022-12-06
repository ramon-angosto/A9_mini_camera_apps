package com.huawei.android.pushagent.b.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.android.pushagent.PushService;
import com.huawei.android.pushagent.a.e;
import com.huawei.android.pushagent.b.d.b;
import com.huawei.android.pushagent.b.e.b;
import com.huawei.android.pushagent.plugin.tools.BLocation;
import java.net.InetSocketAddress;
import java.util.Date;

public class a extends e {
    private static a g;
    public boolean a = false;
    private Thread e = null;
    private long f = 300000;

    public a(Context context) {
        super(context);
        af();
    }

    public static synchronized a a(Context context) {
        a aVar;
        synchronized (a.class) {
            if (g == null) {
                g = new a(context);
            }
            aVar = g;
        }
        return aVar;
    }

    private synchronized boolean ah() {
        boolean z;
        if (ai()) {
            com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, " trsQuery thread already running, just wait!!");
            z = false;
        } else {
            this.e = new b(this, "PushTRSQuery");
            this.e.start();
            c.a(this.d, new com.huawei.android.pushagent.a.a("lastQueryTRSTime", Long.class, (Object) Long.valueOf(System.currentTimeMillis())));
            c.a(this.d, new com.huawei.android.pushagent.a.a("queryTrsTimes", Long.class, (Object) Long.valueOf(c.a(this.d, "queryTrsTimes", 0) + 1)));
            z = true;
        }
        return z;
    }

    private synchronized boolean ai() {
        return this.e != null && this.e.isAlive();
    }

    public static void b(Context context) {
        a aVar = g;
        if (aVar != null) {
            aVar.a("pushSrvValidTime", (Object) 0);
            g.a = true;
        }
    }

    /* access modifiers changed from: private */
    public boolean b(e eVar) {
        if (eVar == null || !eVar.V()) {
            com.huawei.android.pushagent.c.a.e.d(BLocation.TAG, "in PushSrvInfo:trsRetInfo, trsRetInfo is null or invalid:" + eVar);
            return false;
        }
        com.huawei.android.pushagent.c.a.e.b(BLocation.TAG, "queryTrs success!");
        if (!a(eVar)) {
            com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, "heart beat range change.");
            PushService.a(new Intent("com.huawei.android.push.intent.HEARTBEAT_RANGE_CHANGE"));
        }
        if (eVar.c.containsKey("USE_SSL")) {
            c.a((Context) null, new com.huawei.android.pushagent.a.a("USE_SSL", Integer.class, (Object) Integer.valueOf(((Integer) eVar.c.get("USE_SSL")).intValue())));
        }
        if (!a(eVar.b())) {
            com.huawei.android.pushagent.c.a.e.b(BLocation.TAG, "belongId changed, need to reRegisterDeviceToken");
            b.c(this.d);
        }
        this.c.putAll(eVar.c);
        a("pushSrvValidTime", (Object) Long.valueOf((f() * 1000) + System.currentTimeMillis()));
        this.f = q() * 1000;
        c.a(this.d, new com.huawei.android.pushagent.a.a("queryTrsTimes", Integer.class, (Object) 0));
        com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, "write the lastQueryTRSsucc_time to the pushConfig.xml file ");
        c.a(this.d, new com.huawei.android.pushagent.a.a("lastQueryTRSsucc_time", Long.class, (Object) Long.valueOf(System.currentTimeMillis())));
        this.a = false;
        this.c.remove("PushID");
        ag();
        com.huawei.android.pushagent.b.d.b.a(this.d).a(this.d, b.C0035b.TRS_QUERIED, new Bundle());
        PushService.a(new Intent("com.huawei.android.push.intent.TRS_QUERY_SUCCESS").putExtra("trs_result", eVar.toString()));
        return true;
    }

    public InetSocketAddress a(boolean z) {
        boolean c = c(z);
        if (!V() || c) {
            com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, "in getPushSrvAddr, have no invalid addr");
            return null;
        }
        com.huawei.android.pushagent.c.a.e.b(BLocation.TAG, "return valid PushSrvAddr");
        return new InetSocketAddress(c(), d());
    }

    public InetSocketAddress b(boolean z) {
        boolean c = c(z);
        if (!X() || c) {
            com.huawei.android.pushagent.c.a.e.d(BLocation.TAG, "in getPollingAddr, have no invalid addr");
            return null;
        }
        com.huawei.android.pushagent.c.a.e.b(BLocation.TAG, "return valid PollingSrvAddr");
        return new InetSocketAddress(C(), D());
    }

    public boolean c(boolean z) {
        StringBuilder sb;
        Date date;
        String sb2;
        if (ai()) {
            com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, "trsQuery thread is running");
            return true;
        }
        long a2 = c.a(this.d, "lastQueryTRSTime", 0);
        long a3 = c.a(this.d, "lastQueryTRSsucc_time", 0);
        com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, "isvalid:" + V() + " srvValidBefore:" + (c("pushSrvValidTime", Long.MAX_VALUE) - System.currentTimeMillis()) + " pushSrvNeedQueryTRS:" + this.a);
        if (V() && !this.a && c("pushSrvValidTime", Long.MAX_VALUE) >= System.currentTimeMillis() && System.currentTimeMillis() > a3) {
            sb2 = " need not query TRS";
        } else if (-1 == com.huawei.android.pushagent.c.a.b.a(this.d)) {
            sb2 = "in queryTRSInfo no network";
        } else {
            if (!z) {
                if (System.currentTimeMillis() - a3 < e() * 1000 && System.currentTimeMillis() > a3) {
                    sb = new StringBuilder();
                    sb.append("can not contect TRS Service when  the connect more than ");
                    sb.append(e());
                    sb.append(" sec last contected success time,");
                    sb.append("lastQueryTRSsucc_time = ");
                    date = new Date(a3);
                } else if (System.currentTimeMillis() - a2 < this.f && System.currentTimeMillis() > a2) {
                    sb = new StringBuilder();
                    sb.append("can't connect TRS Service when the connectting time more later ");
                    sb.append(this.f / 1000);
                    sb.append("sec than  last contectting time,lastQueryTRSTime =");
                    date = new Date(a2);
                } else if (c.a(this.d, "queryTrsTimes", 0) > t()) {
                    this.f = r() * 1000;
                }
                sb.append(date);
                sb2 = sb.toString();
            } else {
                com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, "Force to Connect TRS");
            }
            if (c.a(this.d, "cloudpush_isNoDelayConnect", false) || com.huawei.android.pushagent.b.d.a.a(this.d)) {
                return ah();
            }
            return false;
        }
        com.huawei.android.pushagent.c.a.e.a(BLocation.TAG, sb2);
        return false;
    }
}
