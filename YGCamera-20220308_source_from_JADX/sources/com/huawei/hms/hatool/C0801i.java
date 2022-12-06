package com.huawei.hms.hatool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.huawei.hms.hatool.i */
public final class C0801i {

    /* renamed from: b */
    public static Map<String, C0813m> f637b = new HashMap();

    /* renamed from: c */
    public static C0801i f638c;

    /* renamed from: a */
    public C0810l f639a = new C0810l();

    /* renamed from: c */
    public static C0801i m860c() {
        if (f638c == null) {
            m861d();
        }
        return f638c;
    }

    /* renamed from: d */
    public static synchronized void m861d() {
        synchronized (C0801i.class) {
            if (f638c == null) {
                f638c = new C0801i();
            }
        }
    }

    /* renamed from: a */
    public C0813m mo13979a(String str) {
        return f637b.get(str);
    }

    /* renamed from: a */
    public Set<String> mo13980a() {
        return f637b.keySet();
    }

    /* renamed from: a */
    public void mo13981a(String str, C0813m mVar) {
        f637b.put(str, mVar);
    }

    /* renamed from: b */
    public C0810l mo13982b() {
        return this.f639a;
    }
}
