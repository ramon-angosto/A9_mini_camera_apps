package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.huawei.hms.hatool.e0 */
public final class C0788e0 {

    /* renamed from: b */
    public static C0788e0 f615b;

    /* renamed from: a */
    public volatile Map<String, C0792f0> f616a = new HashMap();

    /* renamed from: a */
    public static C0788e0 m792a() {
        if (f615b == null) {
            m793b();
        }
        return f615b;
    }

    /* renamed from: b */
    public static synchronized void m793b() {
        synchronized (C0788e0.class) {
            if (f615b == null) {
                f615b = new C0788e0();
            }
        }
    }

    /* renamed from: a */
    public final C0792f0 mo13947a(String str) {
        if (!this.f616a.containsKey(str)) {
            this.f616a.put(str, new C0792f0());
        }
        return this.f616a.get(str);
    }

    /* renamed from: a */
    public C0792f0 mo13948a(String str, long j) {
        C0792f0 a = mo13947a(str);
        a.mo13953a(j);
        return a;
    }
}
