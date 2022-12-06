package com.huawei.hms.hatool;

import android.content.Context;

/* renamed from: com.huawei.hms.hatool.f1 */
public final class C0794f1 {

    /* renamed from: b */
    public static C0794f1 f627b;

    /* renamed from: c */
    public static final Object f628c = new Object();

    /* renamed from: a */
    public Context f629a;

    static {
        new String[]{"ABTesting", "_default_config_tag", "_openness_config_tag", "_hms_config_tag"};
    }

    /* renamed from: a */
    public static C0794f1 m820a() {
        if (f627b == null) {
            m821b();
        }
        return f627b;
    }

    /* renamed from: b */
    public static synchronized void m821b() {
        synchronized (C0794f1.class) {
            if (f627b == null) {
                f627b = new C0794f1();
            }
        }
    }

    /* renamed from: a */
    public void mo13959a(Context context) {
        synchronized (f628c) {
            if (this.f629a != null) {
                C0841y.m1092f("hmsSdk", "DataManager already initialized.");
                return;
            }
            this.f629a = context;
            C0801i.m860c().mo13982b().mo14041a(this.f629a);
            C0801i.m860c().mo13982b().mo14054g(context.getPackageName());
            C0839x0.m1066a().mo14135a(context);
        }
    }

    /* renamed from: a */
    public void mo13960a(String str) {
        C0841y.m1087c("hmsSdk", "HiAnalyticsDataManager.setAppid(String appid) is execute.");
        Context context = this.f629a;
        if (context == null) {
            C0841y.m1091e("hmsSdk", "sdk is not init");
            return;
        }
        C0801i.m860c().mo13982b().mo14052f(C0824q0.m1002a("appID", str, "[a-zA-Z0-9_][a-zA-Z0-9. _-]{0,255}", context.getPackageName()));
    }
}
