package com.xiaomi.push;

import java.util.Map;

/* renamed from: com.xiaomi.push.fv */
public class C1811fv implements Cloneable {

    /* renamed from: a */
    public static String f2451a = "wcc-ml-test10.bj";

    /* renamed from: b */
    public static final String f2452b = C1614ag.f1763a;

    /* renamed from: c */
    public static String f2453c = null;

    /* renamed from: a */
    private int f2454a;

    /* renamed from: a */
    private C1814fy f2455a;

    /* renamed from: a */
    private boolean f2456a = C1809fu.f2431a;

    /* renamed from: b */
    private boolean f2457b = true;

    /* renamed from: d */
    private String f2458d;

    /* renamed from: e */
    private String f2459e;

    /* renamed from: f */
    private String f2460f;

    public C1811fv(Map<String, Integer> map, int i, String str, C1814fy fyVar) {
        m3643a(map, i, str, fyVar);
    }

    /* renamed from: a */
    public static final String mo17670a() {
        String str = f2453c;
        return str != null ? str : C1611ad.m2504a() ? "sandbox.xmpush.xiaomi.com" : C1611ad.m2507b() ? f2452b : "app.chat.xiaomi.net";
    }

    /* renamed from: a */
    public static final void m3642a(String str) {
        f2453c = str;
    }

    /* renamed from: a */
    private void m3643a(Map<String, Integer> map, int i, String str, C1814fy fyVar) {
        this.f2454a = i;
        this.f2458d = str;
        this.f2455a = fyVar;
    }

    /* renamed from: a */
    public int m3644a() {
        return this.f2454a;
    }

    /* renamed from: a */
    public void mo17671a(boolean z) {
        this.f2456a = z;
    }

    /* renamed from: a */
    public boolean m3646a() {
        return this.f2456a;
    }

    /* renamed from: a */
    public byte[] m3647a() {
        return null;
    }

    /* renamed from: b */
    public String mo17672b() {
        return this.f2460f;
    }

    /* renamed from: b */
    public void mo17673b(String str) {
        this.f2460f = str;
    }

    /* renamed from: c */
    public String mo17674c() {
        if (this.f2459e == null) {
            this.f2459e = mo17670a();
        }
        return this.f2459e;
    }

    /* renamed from: c */
    public void mo17675c(String str) {
        this.f2459e = str;
    }
}
