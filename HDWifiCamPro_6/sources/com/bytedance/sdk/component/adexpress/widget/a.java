package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.PointF;
import android.view.animation.Interpolator;

/* compiled from: CubicBezierInterpolator */
public class a implements Interpolator {
    private int a = 0;
    private final PointF b = new PointF();
    private final PointF c = new PointF();
    private float d = 0.0f;

    public static double a(double d2, double d3, double d4) {
        double d5 = 1.0d - d2;
        double d6 = d2 * d2;
        return (d5 * d5 * 3.0d * d2 * d3) + (d5 * 3.0d * d6 * d4) + (d6 * d2);
    }

    public a(float f, float f2, float f3, float f4) {
        PointF pointF = this.b;
        pointF.x = f;
        pointF.y = f2;
        PointF pointF2 = this.c;
        pointF2.x = f3;
        pointF2.y = f4;
    }

    public float getInterpolation(float f) {
        if (f < ((float) this.a)) {
            this.a = 0;
        }
        int i = this.a;
        float f2 = f;
        while (true) {
            if (i >= 4096) {
                break;
            }
            f2 = ((float) i) * 2.4414062E-4f;
            if (a((double) f2, (double) this.b.x, (double) this.c.x) >= ((double) f)) {
                this.a = i;
                break;
            }
            i++;
        }
        return (float) a((double) f2, (double) this.b.y, (double) this.c.y);
    }
}
