package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.mbridge.msdk.foundation.webview.a;

public class ProgressBar extends View implements a {
    Runnable a = new Runnable() {
        public final void run() {
            ProgressBar.this.invalidate();
        }
    };
    private Rect b = new Rect();
    private float c;
    private float d = 0.95f;
    private long e;
    private float f;
    private boolean g;
    private float h;
    private float i;
    private float j;
    private long k;
    private int l;
    private int m;
    private int n;
    private int o;
    private long p = 25;
    private Drawable q;
    private Drawable r;
    private Drawable s;
    private Drawable t;
    private boolean u = false;
    private a.C0065a v;
    private Handler w = new Handler(Looper.getMainLooper());
    private boolean x;
    private boolean y = false;

    public Bitmap getDrawingCache(boolean z) {
        return null;
    }

    public ProgressBar(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0044, code lost:
        if (r10.x != false) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005f, code lost:
        if (r10.x != false) goto L_0x0061;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0179  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:81:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r11) {
        /*
            r10 = this;
            boolean r0 = r10.u
            r1 = 1
            if (r0 != 0) goto L_0x0007
            r10.u = r1
        L_0x0007:
            long r2 = java.lang.System.currentTimeMillis()
            boolean r0 = r10.y
            if (r0 == 0) goto L_0x0012
            r4 = 0
            goto L_0x0016
        L_0x0012:
            long r4 = r10.e
            long r4 = r2 - r4
        L_0x0016:
            float r0 = (float) r4
            r6 = 1148846080(0x447a0000, float:1000.0)
            float r0 = r0 / r6
            float r0 = java.lang.Math.abs(r0)
            r10.f = r0
            r10.e = r2
            long r2 = r10.k
            long r2 = r2 + r4
            r10.k = r2
            boolean r0 = r10.g
            r2 = 1045220557(0x3e4ccccd, float:0.2)
            r3 = 1028443341(0x3d4ccccd, float:0.05)
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 1053609165(0x3ecccccd, float:0.4)
            if (r0 != 0) goto L_0x005d
            long r6 = r10.k
            r8 = 2000(0x7d0, double:9.88E-321)
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x005b
            int r0 = r10.n
            if (r0 != r1) goto L_0x0047
            boolean r0 = r10.x
            if (r0 == 0) goto L_0x0062
            goto L_0x0061
        L_0x0047:
            int r0 = r10.m
            if (r0 != r1) goto L_0x0052
            boolean r0 = r10.x
            if (r0 == 0) goto L_0x0050
            goto L_0x0062
        L_0x0050:
            r5 = r2
            goto L_0x0062
        L_0x0052:
            boolean r0 = r10.x
            if (r0 == 0) goto L_0x0058
            r0 = r2
            goto L_0x0059
        L_0x0058:
            r0 = r3
        L_0x0059:
            r5 = r0
            goto L_0x0062
        L_0x005b:
            r5 = r3
            goto L_0x0062
        L_0x005d:
            boolean r0 = r10.x
            if (r0 == 0) goto L_0x0062
        L_0x0061:
            r5 = r4
        L_0x0062:
            r10.j = r5
            float r0 = r10.i
            float r1 = r10.j
            float r5 = r10.f
            float r1 = r1 * r5
            float r0 = r0 + r1
            r10.i = r0
            boolean r0 = r10.g
            if (r0 != 0) goto L_0x007c
            float r0 = r10.i
            float r1 = r10.d
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x007c
            r10.i = r1
        L_0x007c:
            android.graphics.Rect r0 = r10.b
            float r1 = r10.i
            float r5 = r10.c
            float r1 = r1 * r5
            int r1 = (int) r1
            r0.right = r1
            android.os.Handler r0 = r10.w
            r1 = 0
            r0.removeCallbacksAndMessages(r1)
            android.os.Handler r0 = r10.w
            java.lang.Runnable r1 = r10.a
            long r5 = r10.p
            r0.postDelayed(r1, r5)
            super.draw(r11)
            float r0 = r10.f
            boolean r1 = r10.g
            r5 = 0
            r6 = 0
            if (r1 == 0) goto L_0x00d9
            float r1 = r10.h
            float r7 = r10.c
            r8 = 1056964608(0x3f000000, float:0.5)
            float r7 = r7 * r8
            float r1 = r1 / r7
            float r4 = r4 - r1
            r1 = 1132396544(0x437f0000, float:255.0)
            float r4 = r4 * r1
            int r1 = (int) r4
            if (r1 >= 0) goto L_0x00b0
            r1 = r6
        L_0x00b0:
            float r4 = r10.h
            float r7 = r10.c
            float r7 = r7 * r8
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x00bc
            r10.setVisible(r6)
        L_0x00bc:
            android.graphics.drawable.Drawable r4 = r10.r
            if (r4 == 0) goto L_0x00c3
            r4.setAlpha(r1)
        L_0x00c3:
            android.graphics.drawable.Drawable r4 = r10.s
            if (r4 == 0) goto L_0x00ca
            r4.setAlpha(r1)
        L_0x00ca:
            android.graphics.drawable.Drawable r4 = r10.q
            if (r4 == 0) goto L_0x00d1
            r4.setAlpha(r1)
        L_0x00d1:
            r11.save()
            float r1 = r10.h
            r11.translate(r1, r5)
        L_0x00d9:
            android.graphics.drawable.Drawable r1 = r10.r
            if (r1 == 0) goto L_0x0100
            android.graphics.drawable.Drawable r1 = r10.q
            if (r1 == 0) goto L_0x0100
            android.graphics.Rect r1 = r10.b
            int r1 = r1.width()
            float r1 = (float) r1
            android.graphics.drawable.Drawable r4 = r10.q
            int r4 = r4.getIntrinsicWidth()
            float r4 = (float) r4
            float r4 = r4 * r3
            float r1 = r1 - r4
            int r1 = (int) r1
            android.graphics.drawable.Drawable r3 = r10.r
            int r4 = r3.getIntrinsicHeight()
            r3.setBounds(r6, r6, r1, r4)
            android.graphics.drawable.Drawable r1 = r10.r
            r1.draw(r11)
        L_0x0100:
            boolean r1 = r10.g
            if (r1 == 0) goto L_0x0129
            android.graphics.drawable.Drawable r1 = r10.s
            if (r1 == 0) goto L_0x0129
            android.graphics.drawable.Drawable r3 = r10.q
            if (r3 == 0) goto L_0x0129
            int r1 = r1.getIntrinsicWidth()
            android.graphics.drawable.Drawable r3 = r10.s
            int r4 = r3.getIntrinsicHeight()
            r3.setBounds(r6, r6, r1, r4)
            r11.save()
            int r1 = -r1
            float r1 = (float) r1
            r11.translate(r1, r5)
            android.graphics.drawable.Drawable r1 = r10.s
            r1.draw(r11)
            r11.restore()
        L_0x0129:
            android.graphics.drawable.Drawable r1 = r10.q
            if (r1 == 0) goto L_0x0147
            r11.save()
            android.graphics.Rect r1 = r10.b
            int r1 = r1.width()
            int r3 = r10.getWidth()
            int r1 = r1 - r3
            float r1 = (float) r1
            r11.translate(r1, r5)
            android.graphics.drawable.Drawable r1 = r10.q
            r1.draw(r11)
            r11.restore()
        L_0x0147:
            boolean r1 = r10.g
            if (r1 != 0) goto L_0x0193
            float r1 = r10.i
            float r3 = r10.d
            float r1 = r1 - r3
            float r1 = java.lang.Math.abs(r1)
            r3 = 925353388(0x3727c5ac, float:1.0E-5)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0193
            android.graphics.drawable.Drawable r1 = r10.t
            if (r1 == 0) goto L_0x0193
            int r3 = r10.l
            float r3 = (float) r3
            float r0 = r0 * r2
            float r2 = r10.c
            float r0 = r0 * r2
            float r3 = r3 + r0
            int r0 = (int) r3
            r10.l = r0
            int r0 = r10.l
            int r1 = r1.getIntrinsicWidth()
            int r0 = r0 + r1
            android.graphics.Rect r1 = r10.b
            int r1 = r1.width()
            if (r0 < r1) goto L_0x0182
            android.graphics.drawable.Drawable r0 = r10.t
            int r0 = r0.getIntrinsicWidth()
            int r0 = -r0
            r10.l = r0
        L_0x0182:
            r11.save()
            int r0 = r10.l
            float r0 = (float) r0
            r11.translate(r0, r5)
            android.graphics.drawable.Drawable r0 = r10.t
            r0.draw(r11)
            r11.restore()
        L_0x0193:
            boolean r0 = r10.g
            if (r0 == 0) goto L_0x019a
            r11.restore()
        L_0x019a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.webview.ProgressBar.draw(android.graphics.Canvas):void");
    }

    public void onThemeChange() {
        if (this.u) {
            initResource(true);
        }
    }

    public void initResource(boolean z) {
        if (z || (this.t == null && this.q == null && this.r == null && this.s == null)) {
            this.t = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_highlight", "drawable", com.mbridge.msdk.foundation.controller.a.e().b()));
            Drawable drawable = this.t;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.t.getIntrinsicHeight());
            }
            this.q = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_head", "drawable", com.mbridge.msdk.foundation.controller.a.e().b()));
            Drawable drawable2 = this.q;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.q.getIntrinsicHeight());
            }
            this.r = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_tail", "drawable", com.mbridge.msdk.foundation.controller.a.e().b()));
            this.s = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_end_animation", "drawable", com.mbridge.msdk.foundation.controller.a.e().b()));
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        Drawable drawable = this.t;
        if (drawable != null) {
            drawable.setBounds(0, 0, (int) (((double) drawable.getIntrinsicWidth()) * 1.5d), getHeight());
        }
        Drawable drawable2 = this.q;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
    }

    public void startEndAnimation() {
        if (!this.g) {
            this.g = true;
            this.h = 0.0f;
        }
    }

    public void setProgress(float f2, boolean z) {
        if (z && f2 >= 1.0f) {
            startEndAnimation();
        }
    }

    public void setVisible(boolean z) {
        if (z) {
            this.x = true;
            this.e = System.currentTimeMillis();
            this.f = 0.0f;
            this.k = 0;
            this.g = false;
            this.h = 0.0f;
            this.i = 0.0f;
            this.c = (float) getMeasuredWidth();
            this.y = false;
            this.m = 0;
            this.n = 0;
            this.o = 0;
            Drawable drawable = this.t;
            if (drawable != null) {
                this.l = -drawable.getIntrinsicWidth();
            } else {
                this.l = 0;
            }
            Drawable drawable2 = this.r;
            if (drawable2 != null) {
                drawable2.setAlpha(255);
            }
            Drawable drawable3 = this.s;
            if (drawable3 != null) {
                drawable3.setAlpha(255);
            }
            Drawable drawable4 = this.q;
            if (drawable4 != null) {
                drawable4.setAlpha(255);
            }
            setVisibility(0);
            invalidate();
            return;
        }
        setVisibility(4);
    }

    public float getProgress() {
        return this.i;
    }

    public void setProgressBarListener(a.C0065a aVar) {
        this.v = aVar;
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 0) {
            a.C0065a aVar = this.v;
            if (aVar != null) {
                aVar.a(true);
                return;
            }
            return;
        }
        a.C0065a aVar2 = this.v;
        if (aVar2 != null) {
            aVar2.a(false);
        }
    }

    public void setProgressState(int i2) {
        if (i2 == 5) {
            this.m = 1;
            this.n = 0;
            this.o = 0;
            this.k = 0;
        } else if (i2 == 6) {
            this.n = 1;
            if (this.o == 1) {
                startEndAnimation();
            }
            this.k = 0;
        } else if (i2 == 7) {
            startEndAnimation();
        } else if (i2 == 8) {
            this.o = 1;
            if (this.n == 1) {
                startEndAnimation();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.c = (float) getMeasuredWidth();
    }

    public void setPaused(boolean z) {
        this.y = z;
        if (!z) {
            this.e = System.currentTimeMillis();
        }
    }
}
