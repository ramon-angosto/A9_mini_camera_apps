package com.xiaomi.mipush.sdk;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.C1524b;
import com.xiaomi.push.C1618ak;
import com.xiaomi.push.C1764ej;
import com.xiaomi.push.C1766el;
import com.xiaomi.push.C1768en;
import com.xiaomi.push.C1873ht;
import com.xiaomi.push.C1878hy;
import com.xiaomi.push.C1894in;
import com.xiaomi.push.C1905iy;
import com.xiaomi.push.C1906iz;
import com.xiaomi.push.C1938m;
import com.xiaomi.push.service.C1995at;
import com.xiaomi.push.service.C1999aw;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.mipush.sdk.o */
public class C1593o {
    /* renamed from: a */
    public static void m2457a(Context context, Intent intent, Uri uri) {
        C1764ej a;
        C1766el elVar;
        if (context != null) {
            C1568ao.m2317a(context).mo17133a();
            if (C1764ej.m3355a(context.getApplicationContext()).mo17523a() == null) {
                C1764ej.m3355a(context.getApplicationContext()).mo17529a(C1578b.m2373a(context.getApplicationContext()).mo17163a(), context.getPackageName(), C1995at.m5047a(context.getApplicationContext()).mo18465a(C1873ht.AwakeInfoUploadWaySwitch.mo17806a(), 0), (C1768en) new C1580c());
                C1995at.m5047a(context).mo18469a((C1995at.C1996a) new C1595q(102, "awake online config", context));
            }
            if ((context instanceof Activity) && intent != null) {
                a = C1764ej.m3355a(context.getApplicationContext());
                elVar = C1766el.ACTIVITY;
            } else if (!(context instanceof Service) || intent == null) {
                if (uri != null && !TextUtils.isEmpty(uri.toString())) {
                    C1764ej.m3355a(context.getApplicationContext()).mo17526a(C1766el.PROVIDER, context, (Intent) null, uri.toString());
                    return;
                }
                return;
            } else if ("com.xiaomi.mipush.sdk.WAKEUP".equals(intent.getAction())) {
                a = C1764ej.m3355a(context.getApplicationContext());
                elVar = C1766el.SERVICE_COMPONENT;
            } else {
                a = C1764ej.m3355a(context.getApplicationContext());
                elVar = C1766el.SERVICE_ACTION;
            }
            a.mo17526a(elVar, context, intent, (String) null);
        }
    }

    /* renamed from: a */
    private static void m2458a(Context context, C1894in inVar) {
        boolean a = C1995at.m5047a(context).mo18472a(C1873ht.AwakeAppPingSwitch.mo17806a(), false);
        int a2 = C1995at.m5047a(context).mo18465a(C1873ht.AwakeAppPingFrequency.mo17806a(), 0);
        if (a2 >= 0 && a2 < 30) {
            C1524b.m2159c("aw_ping: frquency need > 30s.");
            a2 = 30;
        }
        if (a2 < 0) {
            a = false;
        }
        if (!C1938m.m4713a()) {
            m2459a(context, inVar, a, a2);
        } else if (a) {
            C1618ak.m2518a(context.getApplicationContext()).mo17215a((C1618ak.C1619a) new C1594p(inVar, context), a2);
        }
    }

    /* renamed from: a */
    public static final <T extends C1906iz<T, ?>> void m2459a(Context context, T t, boolean z, int i) {
        byte[] a = C1905iy.m4543a(t);
        if (a == null) {
            C1524b.m2141a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_help_ping");
        intent.putExtra("extra_help_ping_switch", z);
        intent.putExtra("extra_help_ping_frequency", i);
        intent.putExtra("mipush_payload", a);
        intent.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
        C1568ao.m2317a(context).mo17137a(intent);
    }

    /* renamed from: a */
    public static void m2460a(Context context, String str) {
        C1524b.m2141a("aw_ping : send aw_ping cmd and content to push service from 3rd app");
        HashMap hashMap = new HashMap();
        hashMap.put("awake_info", str);
        hashMap.put("event_type", String.valueOf(9999));
        hashMap.put("description", "ping message");
        C1894in inVar = new C1894in();
        inVar.mo18084b(C1578b.m2373a(context).mo17163a());
        inVar.mo18091d(context.getPackageName());
        inVar.mo18087c(C1878hy.AwakeAppResponse.f2959a);
        inVar.mo18078a(C1999aw.m5064a());
        inVar.f3224a = hashMap;
        m2458a(context, inVar);
    }

    /* renamed from: a */
    public static void m2461a(Context context, String str, int i, String str2) {
        C1894in inVar = new C1894in();
        inVar.mo18084b(str);
        inVar.mo18080a((Map<String, String>) new HashMap());
        inVar.mo18077a().put("extra_aw_app_online_cmd", String.valueOf(i));
        inVar.mo18077a().put("extra_help_aw_info", str2);
        inVar.mo18078a(C1999aw.m5064a());
        byte[] a = C1905iy.m4543a(inVar);
        if (a == null) {
            C1524b.m2141a("send message fail, because msgBytes is null.");
            return;
        }
        Intent intent = new Intent();
        intent.setAction("action_aw_app_logic");
        intent.putExtra("mipush_payload", a);
        C1568ao.m2317a(context).mo17137a(intent);
    }
}
