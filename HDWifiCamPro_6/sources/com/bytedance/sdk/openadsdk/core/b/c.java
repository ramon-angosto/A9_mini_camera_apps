package com.bytedance.sdk.openadsdk.core.b;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.settings.f;

/* compiled from: InteractionListener */
public abstract class c implements View.OnClickListener, View.OnTouchListener {
    protected static int B = ViewConfiguration.get(m.a()).getScaledTouchSlop();
    private static float a = 0.0f;
    private static float b = 0.0f;
    private static float c = 0.0f;
    private static float d = 0.0f;
    private static long e = 0;
    protected int A = -1;
    protected boolean C = true;
    protected View D;
    public SparseArray<a> E = new SparseArray<>();
    private int f = 0;
    private int g = 0;
    private final int h = m.b();
    protected float s = -1.0f;
    protected float t = -1.0f;
    protected float u = -1.0f;
    protected float v = -1.0f;
    protected long w = -1;
    protected long x = -1;
    protected int y = -1;
    protected int z = -1024;

    /* access modifiers changed from: protected */
    public abstract void a(View view, float f2, float f3, float f4, float f5, SparseArray<a> sparseArray, boolean z2);

    static {
        if (ViewConfiguration.get(m.a()) != null) {
        }
    }

    public void onClick(View view) {
        if (f.a()) {
            a(view, this.s, this.t, this.u, this.v, this.E, this.C);
        }
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        int i;
        this.z = motionEvent.getDeviceId();
        this.y = motionEvent.getToolType(0);
        this.A = motionEvent.getSource();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.f = (int) motionEvent.getRawX();
            this.g = (int) motionEvent.getRawY();
            this.s = motionEvent.getRawX();
            this.t = motionEvent.getRawY();
            this.w = System.currentTimeMillis();
            this.y = motionEvent.getToolType(0);
            this.z = motionEvent.getDeviceId();
            this.A = motionEvent.getSource();
            e = System.currentTimeMillis();
            this.C = true;
            this.D = view;
            i = 0;
        } else if (actionMasked != 1) {
            int i2 = 2;
            if (actionMasked != 2) {
                i2 = actionMasked != 3 ? -1 : 4;
            } else {
                c += Math.abs(motionEvent.getX() - a);
                d += Math.abs(motionEvent.getY() - b);
                a = motionEvent.getX();
                b = motionEvent.getY();
                if (System.currentTimeMillis() - e > 200) {
                    float f2 = c;
                    int i3 = B;
                    if (f2 > ((float) i3) || d > ((float) i3)) {
                        i2 = 1;
                    }
                }
                this.u = motionEvent.getRawX();
                this.v = motionEvent.getRawY();
                if (Math.abs(this.u - ((float) this.f)) >= ((float) this.h) || Math.abs(this.v - ((float) this.g)) >= ((float) this.h)) {
                    this.C = false;
                }
            }
            i = i2;
        } else {
            this.u = motionEvent.getRawX();
            this.v = motionEvent.getRawY();
            this.x = System.currentTimeMillis();
            if (Math.abs(this.u - ((float) this.f)) >= ((float) this.h) || Math.abs(this.v - ((float) this.g)) >= ((float) this.h)) {
                this.C = false;
            }
            Point point = new Point((int) this.u, (int) this.v);
            if (view != null && !b.c(view) && a((View) view.getParent(), point)) {
                return true;
            }
            i = 3;
        }
        this.E.put(motionEvent.getActionMasked(), new a(i, (double) motionEvent.getSize(), (double) motionEvent.getPressure(), System.currentTimeMillis()));
        return false;
    }

    private boolean a(View view, Point point) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            while (i < viewGroup.getChildCount()) {
                View childAt = viewGroup.getChildAt(i);
                if (b.c(childAt)) {
                    int[] iArr = new int[2];
                    childAt.getLocationOnScreen(iArr);
                    if (!view.isShown() || point.x < iArr[0] || point.x > iArr[0] + childAt.getWidth() || point.y < iArr[1] || point.y > iArr[1] + childAt.getHeight()) {
                        return false;
                    }
                    return true;
                } else if (a(childAt, point)) {
                    return true;
                } else {
                    i++;
                }
            }
        }
        return false;
    }

    /* compiled from: InteractionListener */
    public static class a {
        public int a = -1;
        public double b = -1.0d;
        public double c = -1.0d;
        public long d = -1;

        public a(int i, double d2, double d3, long j) {
            this.a = i;
            this.b = d2;
            this.c = d3;
            this.d = j;
        }
    }
}
