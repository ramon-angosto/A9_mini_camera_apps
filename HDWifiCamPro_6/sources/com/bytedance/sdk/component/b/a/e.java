package com.bytedance.sdk.component.b.a;

/* compiled from: Headers */
public final class e {
    private final String[] a;

    public e(String[] strArr) {
        this.a = strArr;
    }

    public int a() {
        return this.a.length / 2;
    }

    public String a(int i) {
        return this.a[i * 2];
    }

    public String b(int i) {
        return this.a[(i * 2) + 1];
    }
}
