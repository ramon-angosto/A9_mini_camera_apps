package com.mbridge.msdk.video.dynview.endcard.cloudview;

import android.graphics.Color;
import android.graphics.PointF;
import android.view.View;

/* compiled from: CTag */
public final class a implements Comparable<a> {
    private int a;
    private float b;
    private float[] c;
    private View d;
    private PointF e;
    private com.mbridge.msdk.video.dynview.endcard.cloudview.a.a f;

    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.b > ((a) obj).b ? 1 : -1;
    }

    public a() {
        this(0.0f, 0.0f, 0.0f, 1.0f, 0);
    }

    public a(int i) {
        this(0.0f, 0.0f, 0.0f, 1.0f, i);
    }

    private a(float f2, float f3, float f4, float f5, int i) {
        this.f = new com.mbridge.msdk.video.dynview.endcard.cloudview.a.a(f2, f3, f4);
        this.e = new PointF(0.0f, 0.0f);
        this.c = new float[]{1.0f, 0.5f, 0.5f, 0.5f};
        this.b = f5;
        this.a = i;
    }

    public final float a() {
        return this.f.a;
    }

    public final void a(float f2) {
        this.f.a = f2;
    }

    public final float b() {
        return this.f.b;
    }

    public final void b(float f2) {
        this.f.b = f2;
    }

    public final float c() {
        return this.f.c;
    }

    public final void c(float f2) {
        this.f.c = f2;
    }

    public final float d() {
        return this.b;
    }

    public final void d(float f2) {
        this.b = f2;
    }

    public final View e() {
        return this.d;
    }

    public final void a(View view) {
        this.d = view;
    }

    public final void e(float f2) {
        this.c[0] = f2;
    }

    public final int f() {
        return this.a;
    }

    public final float g() {
        return this.e.x;
    }

    public final void f(float f2) {
        this.e.x = f2;
    }

    public final float h() {
        return this.e.y;
    }

    public final void g(float f2) {
        this.e.y = f2;
    }

    public final void a(float[] fArr) {
        if (fArr != null) {
            float[] fArr2 = this.c;
            System.arraycopy(fArr, 0, fArr2, fArr2.length - fArr.length, fArr.length);
        }
    }

    public final float i() {
        return this.c[0];
    }

    public final int j() {
        int[] iArr = new int[4];
        for (int i = 0; i < 4; i++) {
            iArr[i] = (int) (this.c[i] * 255.0f);
        }
        return Color.argb(iArr[0], iArr[1], iArr[2], iArr[3]);
    }
}
