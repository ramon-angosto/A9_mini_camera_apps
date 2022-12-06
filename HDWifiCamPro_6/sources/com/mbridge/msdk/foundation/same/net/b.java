package com.mbridge.msdk.foundation.same.net;

import com.mbridge.msdk.foundation.same.net.a.a;

/* compiled from: DefaultRetryPolicy */
public final class b implements l {
    private int a;
    private int b;
    private final int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;

    public b() {
        this(30000, 0);
    }

    public b(int i, int i2) {
        this.d = 2;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.a = i <= 0 ? 30000 : i;
        this.c = i2;
    }

    public b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.d = 2;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.e = Math.max(i, 0);
        this.f = Math.max(i2, 0);
        this.g = Math.max(i3, 0);
        this.h = Math.max(i4, 0);
        this.c = Math.max(i5, 0);
        this.d = i6;
    }

    public final int a() {
        return this.c;
    }

    public final int b() {
        return this.a;
    }

    public final int c() {
        return this.b;
    }

    public final boolean a(a aVar) {
        this.b++;
        if (this.b > this.c) {
            return false;
        }
        return true;
    }

    public final int d() {
        return this.e;
    }

    public final int e() {
        return this.f;
    }

    public final int f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }
}
