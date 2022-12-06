package com.bytedance.sdk.openadsdk.component.e;

import com.bytedance.sdk.openadsdk.core.model.n;

/* compiled from: TTAppOpenAdCallBackResult */
public class b {
    private int a;
    private int b;
    private n c;
    private int d;
    private String e;
    private boolean f;

    public b(int i, int i2, n nVar) {
        this.a = i;
        this.b = i2;
        this.c = nVar;
    }

    public b(int i, int i2, int i3, String str) {
        this.a = i;
        this.b = i2;
        this.d = i3;
        this.e = str;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public boolean a() {
        return this.f;
    }

    public int b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public n d() {
        return this.c;
    }

    public int e() {
        return this.d;
    }

    public String f() {
        return this.e;
    }
}
