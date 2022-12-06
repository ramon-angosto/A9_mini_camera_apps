package com.bytedance.sdk.openadsdk.core.widget;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.z;

/* compiled from: VideoOnTouchLayout */
public class d {
    /* access modifiers changed from: private */
    public final a a;
    /* access modifiers changed from: private */
    public boolean b = false;
    /* access modifiers changed from: private */
    public boolean c = false;
    /* access modifiers changed from: private */
    public float d;
    /* access modifiers changed from: private */
    public float e;
    /* access modifiers changed from: private */
    public int f;
    /* access modifiers changed from: private */
    public int g;
    /* access modifiers changed from: private */
    public boolean h = true;
    /* access modifiers changed from: private */
    public boolean i = false;
    private final View.OnTouchListener j = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!d.this.a.o()) {
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                int action = motionEvent.getAction();
                if (action == 0) {
                    d dVar = d.this;
                    boolean unused = dVar.k = dVar.a(motionEvent);
                    float unused2 = d.this.d = x;
                    float unused3 = d.this.e = y;
                    int unused4 = d.this.f = (int) x;
                    int unused5 = d.this.g = (int) y;
                    boolean unused6 = d.this.h = true;
                    if (d.this.a != null && d.this.c && !d.this.b) {
                        d.this.a.a(view, true);
                    }
                } else if (action == 1) {
                    if (Math.abs(x - ((float) d.this.f)) > 20.0f || Math.abs(y - ((float) d.this.g)) > 20.0f) {
                        boolean unused7 = d.this.h = false;
                    }
                    if (!d.this.b) {
                        boolean unused8 = d.this.h = true;
                    }
                    boolean unused9 = d.this.i = false;
                    float unused10 = d.this.d = 0.0f;
                    float unused11 = d.this.e = 0.0f;
                    int unused12 = d.this.f = 0;
                    if (d.this.a != null) {
                        d.this.a.a(view, d.this.h);
                    }
                    boolean unused13 = d.this.k = false;
                } else if (action != 2) {
                    if (action == 3) {
                        boolean unused14 = d.this.k = false;
                    }
                } else if (d.this.b && !d.this.k) {
                    float abs = Math.abs(x - d.this.d);
                    float abs2 = Math.abs(y - d.this.e);
                    if (!d.this.i) {
                        if (abs <= 20.0f && abs2 <= 20.0f) {
                            return true;
                        }
                        boolean unused15 = d.this.i = true;
                    }
                    if (d.this.a != null) {
                        d.this.a.n();
                    }
                    float unused16 = d.this.d = x;
                    float unused17 = d.this.e = y;
                }
                if (d.this.b || !d.this.c) {
                    return true;
                }
                return false;
            } else if (d.this.b || !d.this.c) {
                return true;
            } else {
                return false;
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean k;

    /* compiled from: VideoOnTouchLayout */
    public interface a {
        void a(View view, boolean z);

        void n();

        boolean o();
    }

    public d(a aVar) {
        this.a = aVar;
    }

    public void a(View view) {
        if (view != null) {
            view.setOnTouchListener(this.j);
        }
    }

    public void a(boolean z) {
        this.c = z;
    }

    /* access modifiers changed from: private */
    public boolean a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        int c2 = z.c(m.a().getApplicationContext());
        int d2 = z.d(m.a().getApplicationContext());
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float f2 = (float) c2;
        if (rawX > f2 * 0.01f && rawX < f2 * 0.99f) {
            float f3 = (float) d2;
            if (rawY <= 0.01f * f3 || rawY >= f3 * 0.99f) {
                return true;
            }
            return false;
        }
        return true;
    }
}
