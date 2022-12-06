package com.bytedance.sdk.openadsdk.c.a;

import com.bytedance.sdk.openadsdk.h.b;

/* compiled from: ADEventMonitor */
public class a {
    public static final b a = new b(0);
    public static final b b = new b(1);
    public static final b c = new b(2);
    public static final b d = new b(0);
    public static final b e = new b(1);
    public static final b f = new b(2);

    public static void a(b bVar, boolean z, int i, long j) {
        try {
            bVar.g.getAndSet(true);
            if (z) {
                bVar.a.incrementAndGet();
                bVar.c.addAndGet(j);
                return;
            }
            bVar.b.incrementAndGet();
            if (bVar.f.containsKey(Integer.valueOf(i))) {
                bVar.f.put(Integer.valueOf(i), bVar.f.get(Integer.valueOf(i)));
            } else {
                bVar.f.put(Integer.valueOf(i), 1);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(b bVar, boolean z) {
        try {
            bVar.g.getAndSet(true);
            if (z) {
                bVar.a.incrementAndGet();
            } else {
                bVar.b.incrementAndGet();
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(b bVar) {
        try {
            bVar.g.getAndSet(true);
            bVar.e.incrementAndGet();
        } catch (Throwable unused) {
        }
    }

    public static void a() {
        try {
            if (a.g.get()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_net_ad", "tt_sdk_event_net_ad", a.a().toString());
            }
            if (b.g.get()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_net_state", "tt_sdk_event_net_state", b.a().toString());
            }
            if (c.g.get()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_net_trail", "tt_sdk_event_net_trail", c.a().toString());
            }
            if (d.g.get()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_db_ad", "tt_sdk_event_db_ad", d.b().toString());
            }
            if (e.g.get()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_db_state", "tt_sdk_event_db_state", e.b().toString());
            }
            if (f.g.get()) {
                com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_db_trail", "tt_sdk_event_db_trail", f.b().toString());
            }
        } catch (Throwable unused) {
        }
    }

    public static void b() {
        try {
            b.a("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_event_net_ad", "tt_sdk_event_net_ad", ""));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_net_ad");
            b.a("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_event_net_state", "tt_sdk_event_net_state", ""));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_net_state");
            b.a("net_upload_monitor", com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_event_net_trail", "tt_sdk_event_net_trail", ""));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_net_trail");
            b.a("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_event_db_ad", "tt_sdk_event_db_ad", ""));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_db_ad");
            b.a("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_event_db_state", "tt_sdk_event_db_state", ""));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_db_state");
            b.a("db_upload_monitor", com.bytedance.sdk.openadsdk.multipro.d.a.b("tt_sdk_event_db_trail", "tt_sdk_event_db_trail", ""));
            com.bytedance.sdk.openadsdk.multipro.d.a.a("tt_sdk_event_db_trail");
        } catch (Throwable unused) {
        }
    }
}
