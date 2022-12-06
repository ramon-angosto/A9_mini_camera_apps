package com.huawei.hms.hatool;

/* renamed from: com.huawei.hms.hatool.m */
public class C0813m {

    /* renamed from: a */
    public C0807k f707a;

    /* renamed from: b */
    public C0807k f708b;

    /* renamed from: c */
    public C0807k f709c;

    /* renamed from: d */
    public C0807k f710d;

    public C0813m(String str) {
    }

    /* renamed from: a */
    public C0807k mo14071a() {
        return this.f709c;
    }

    /* renamed from: a */
    public C0807k mo14072a(String str) {
        if (str.equals("oper")) {
            return mo14076c();
        }
        if (str.equals("maint")) {
            return mo14074b();
        }
        if (str.equals("diffprivacy")) {
            return mo14071a();
        }
        if (str.equals("preins")) {
            return mo14077d();
        }
        C0841y.m1092f("hmsSdk", "HiAnalyticsInstData.getConfig(type): wrong type: " + str);
        return null;
    }

    /* renamed from: a */
    public void mo14073a(C0807k kVar) {
        this.f707a = kVar;
    }

    /* renamed from: b */
    public C0807k mo14074b() {
        return this.f707a;
    }

    /* renamed from: b */
    public void mo14075b(C0807k kVar) {
        this.f708b = kVar;
    }

    /* renamed from: c */
    public C0807k mo14076c() {
        return this.f708b;
    }

    /* renamed from: d */
    public C0807k mo14077d() {
        return this.f710d;
    }
}
