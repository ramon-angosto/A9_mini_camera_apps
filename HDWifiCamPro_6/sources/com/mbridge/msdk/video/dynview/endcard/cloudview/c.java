package com.mbridge.msdk.video.dynview.endcard.cloudview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: TagCloud */
public final class c {
    private static final float[] c = {0.886f, 0.725f, 0.188f, 1.0f};
    private static final float[] d = {0.3f, 0.3f, 0.3f, 1.0f};
    private List<a> a;
    private int b;
    private float[] e;
    private float[] f;
    private float g;
    private float h;
    private float i;
    private float j;
    private float k;
    private float l;
    private float m;
    private float n;
    private float o;
    private int p;
    private int q;
    private boolean r;
    private float s;
    private float t;

    public c() {
        this(3);
    }

    private c(int i2) {
        this(new ArrayList(), i2);
    }

    private c(List<a> list, int i2) {
        this(list, i2, c, d);
    }

    private c(List<a> list, int i2, float[] fArr, float[] fArr2) {
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.r = true;
        this.a = list;
        this.b = i2;
        this.e = fArr;
        this.f = fArr2;
    }

    public final void a(boolean z) {
        double d2;
        double d3;
        this.r = z;
        boolean z2 = this.r;
        try {
            int size = this.a.size();
            for (int i2 = 1; i2 < size + 1; i2++) {
                if (z2) {
                    double d4 = (double) size;
                    d2 = Math.acos((((((double) i2) * 2.0d) - 1.0d) / d4) - 4.0d);
                    d3 = Math.sqrt(d4 * 3.141592653589793d) * d2;
                } else {
                    d2 = Math.random() * 3.141592653589793d;
                    d3 = Math.random() * 6.283185307179586d;
                }
                int i3 = i2 - 1;
                this.a.get(i3).a((float) ((int) (((double) this.b) * Math.cos(d3) * Math.sin(d2))));
                this.a.get(i3).b((float) ((int) (((double) this.b) * Math.sin(d3) * Math.sin(d2))));
                this.a.get(i3).c((float) ((int) (((double) this.b) * Math.cos(d2))));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        int i4 = 0;
        while (i4 < this.a.size()) {
            try {
                int f2 = this.a.get(i4).f();
                this.q = Math.max(this.q, f2);
                this.p = Math.min(this.p, f2);
                i4++;
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
        for (a b2 : this.a) {
            b(b2);
        }
        f();
        e();
    }

    public final void a() {
        this.a.clear();
    }

    public final List<a> b() {
        return this.a;
    }

    public final a a(int i2) {
        return this.a.get(i2);
    }

    public final void c() {
        a(this.r);
    }

    public final void d() {
        if (Math.abs(this.n) > 0.1f || Math.abs(this.o) > 0.1f) {
            f();
            e();
        }
    }

    private void b(a aVar) {
        aVar.a(a(c(aVar)));
    }

    private float c(a aVar) {
        int f2 = aVar.f();
        int i2 = this.p;
        int i3 = this.q;
        if (i2 == i3) {
            return 1.0f;
        }
        return (((float) f2) - ((float) i2)) / (((float) i3) - ((float) i2));
    }

    public final void a(a aVar) {
        b(aVar);
        double random = Math.random() * 3.141592653589793d;
        double random2 = Math.random() * 6.283185307179586d;
        aVar.a((float) ((int) (((double) this.b) * Math.cos(random2) * Math.sin(random))));
        aVar.b((float) ((int) (((double) this.b) * Math.sin(random2) * Math.sin(random))));
        aVar.c((float) ((int) (((double) this.b) * Math.cos(random))));
        this.a.add(aVar);
        e();
    }

    private void e() {
        int i2 = 0;
        while (i2 < this.a.size()) {
            try {
                a aVar = this.a.get(i2);
                float a2 = aVar.a();
                float b2 = aVar.b();
                float c2 = aVar.c();
                float f2 = (this.h * b2) + ((-this.g) * c2);
                float f3 = (b2 * this.g) + (c2 * this.h);
                float f4 = (this.j * a2) + (this.i * f3);
                float f5 = (a2 * (-this.i)) + (f3 * this.j);
                float f6 = (this.l * f4) + ((-this.k) * f2);
                float f7 = (f4 * this.k) + (f2 * this.l);
                aVar.a(f6);
                aVar.b(f7);
                aVar.c(f5);
                float f8 = (float) (this.b * 2);
                float f9 = f8 / 1.0f;
                float f10 = f8 + f5;
                float f11 = f9 / f10;
                aVar.f((float) ((int) (f6 * f11)));
                aVar.g((float) ((int) (f7 * f11)));
                aVar.d(f11);
                this.s = Math.max(this.s, f10);
                this.t = Math.min(this.t, f10);
                aVar.e(1.0f - ((f10 - this.t) / (this.s - this.t)));
                i2++;
            } catch (Exception e2) {
                e2.printStackTrace();
                return;
            }
        }
        Collections.sort(this.a);
    }

    private float[] a(float f2) {
        float[] fArr = this.f;
        float f3 = 1.0f - f2;
        float[] fArr2 = this.e;
        return new float[]{1.0f, (fArr[0] * f2) + (fArr2[0] * f3), (fArr[1] * f2) + (fArr2[1] * f3), (f2 * fArr[2]) + (f3 * fArr2[2])};
    }

    private void f() {
        this.g = (float) Math.sin(((double) this.n) * 0.017453292519943295d);
        this.h = (float) Math.cos(((double) this.n) * 0.017453292519943295d);
        this.i = (float) Math.sin(((double) this.o) * 0.017453292519943295d);
        this.j = (float) Math.cos(((double) this.o) * 0.017453292519943295d);
        this.k = (float) Math.sin(((double) this.m) * 0.017453292519943295d);
        this.l = (float) Math.cos(((double) this.m) * 0.017453292519943295d);
    }

    public final void b(int i2) {
        this.b = i2;
    }

    public final void a(float[] fArr) {
        this.e = fArr;
    }

    public final void b(float[] fArr) {
        this.f = fArr;
    }

    public final void a(float f2, float f3) {
        this.n = f2;
        this.o = f3;
    }
}
