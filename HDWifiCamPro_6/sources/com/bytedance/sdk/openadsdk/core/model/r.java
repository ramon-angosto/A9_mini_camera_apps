package com.bytedance.sdk.openadsdk.core.model;

import com.bytedance.sdk.openadsdk.l.x;

/* compiled from: TTAppOpenAdReportModel */
public class r {
    private x a = x.b();
    private x b = x.b();
    private long c;
    private long d;
    private long e;
    private long f;
    private long g;
    private long h;
    private int i;

    public void a(x xVar, x xVar2, int i2, x xVar3) {
        this.c = xVar.a(this.a);
        this.d = xVar2.a(xVar);
        this.e = (long) i2;
        this.f = xVar3.a(xVar2);
    }

    public void a(x xVar) {
        this.a = xVar;
    }

    public void b(x xVar) {
        this.b = xVar;
        this.g = xVar.a(this.a);
    }

    public x a() {
        return this.a;
    }

    public long b() {
        return this.c;
    }

    public long c() {
        return this.d;
    }

    public long d() {
        return this.e;
    }

    public long e() {
        return this.f;
    }

    public long f() {
        return this.g;
    }

    public long g() {
        return this.h;
    }

    public void a(long j) {
        this.h = j;
    }

    public int h() {
        return this.i;
    }

    public void a(int i2) {
        this.i = i2;
    }
}
