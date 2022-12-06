package com.xiaomi.push;

/* renamed from: com.xiaomi.push.bf */
public class C1650bf implements C1652bh {

    /* renamed from: a */
    private final String f1862a;

    /* renamed from: b */
    private final String f1863b;

    public C1650bf(String str, String str2) {
        if (str != null) {
            this.f1862a = str;
            this.f1863b = str2;
            return;
        }
        throw new IllegalArgumentException("Name may not be null");
    }

    /* renamed from: a */
    public String mo17253a() {
        return this.f1862a;
    }

    /* renamed from: b */
    public String mo17254b() {
        return this.f1863b;
    }
}
