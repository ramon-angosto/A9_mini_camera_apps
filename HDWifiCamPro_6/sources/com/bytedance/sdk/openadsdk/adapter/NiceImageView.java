package com.bytedance.sdk.openadsdk.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.bytedance.sdk.openadsdk.l.z;

public class NiceImageView extends ImageView {
    private final Context a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private Xfermode n;
    private int o;
    private int p;
    private float q;
    private float[] r;
    private float[] s;
    private RectF t;
    private RectF u;
    private Paint v;
    private Path w;
    private Path x;

    public NiceImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NiceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NiceImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.e = -1;
        this.g = -1;
        this.a = context;
        this.h = (int) z.b(context, 10.0f);
        this.r = new float[8];
        this.s = new float[8];
        this.u = new RectF();
        this.t = new RectF();
        this.v = new Paint();
        this.w = new Path();
        if (Build.VERSION.SDK_INT <= 27) {
            this.n = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            this.n = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this.x = new Path();
        }
        c();
        d();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.o = i2;
        this.p = i3;
        a();
        b();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.saveLayer(this.t, (Paint) null, 31);
        if (!this.c) {
            int i2 = this.o;
            int i3 = this.d;
            int i4 = this.f;
            int i5 = this.p;
            canvas.scale((((float) ((i2 - (i3 * 2)) - (i4 * 2))) * 1.0f) / ((float) i2), (((float) ((i5 - (i3 * 2)) - (i4 * 2))) * 1.0f) / ((float) i5), ((float) i2) / 2.0f, ((float) i5) / 2.0f);
        }
        super.onDraw(canvas);
        this.v.reset();
        this.w.reset();
        if (this.b) {
            this.w.addCircle(((float) this.o) / 2.0f, ((float) this.p) / 2.0f, this.q, Path.Direction.CCW);
        } else {
            this.w.addRoundRect(this.t, this.s, Path.Direction.CCW);
        }
        this.v.setAntiAlias(true);
        this.v.setStyle(Paint.Style.FILL);
        this.v.setXfermode(this.n);
        if (Build.VERSION.SDK_INT <= 27) {
            canvas.drawPath(this.w, this.v);
        } else {
            this.x.addRect(this.t, Path.Direction.CCW);
            this.x.op(this.w, Path.Op.DIFFERENCE);
            canvas.drawPath(this.x, this.v);
        }
        this.v.setXfermode((Xfermode) null);
        int i6 = this.m;
        if (i6 != 0) {
            this.v.setColor(i6);
            canvas.drawPath(this.w, this.v);
        }
        canvas.restore();
        a(canvas);
    }

    private void a(Canvas canvas) {
        if (this.b) {
            int i2 = this.d;
            if (i2 > 0) {
                a(canvas, i2, this.e, this.q - (((float) i2) / 2.0f));
            }
            int i3 = this.f;
            if (i3 > 0) {
                a(canvas, i3, this.g, (this.q - ((float) this.d)) - (((float) i3) / 2.0f));
                return;
            }
            return;
        }
        int i4 = this.d;
        if (i4 > 0) {
            a(canvas, i4, this.e, this.u, this.r);
        }
    }

    private void a(Canvas canvas, int i2, int i3, float f2) {
        a(i2, i3);
        this.w.addCircle(((float) this.o) / 2.0f, ((float) this.p) / 2.0f, f2, Path.Direction.CCW);
        canvas.drawPath(this.w, this.v);
    }

    private void a(Canvas canvas, int i2, int i3, RectF rectF, float[] fArr) {
        a(i2, i3);
        this.w.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.w, this.v);
    }

    private void a(int i2, int i3) {
        this.w.reset();
        this.v.setStrokeWidth((float) i2);
        this.v.setColor(i3);
        this.v.setStyle(Paint.Style.STROKE);
    }

    private void a() {
        if (!this.b) {
            RectF rectF = this.u;
            int i2 = this.d;
            rectF.set(((float) i2) / 2.0f, ((float) i2) / 2.0f, ((float) this.o) - (((float) i2) / 2.0f), ((float) this.p) - (((float) i2) / 2.0f));
        }
    }

    private void b() {
        if (this.b) {
            this.q = ((float) Math.min(this.o, this.p)) / 2.0f;
            RectF rectF = this.t;
            int i2 = this.o;
            float f2 = this.q;
            int i3 = this.p;
            rectF.set((((float) i2) / 2.0f) - f2, (((float) i3) / 2.0f) - f2, (((float) i2) / 2.0f) + f2, (((float) i3) / 2.0f) + f2);
            return;
        }
        this.t.set(0.0f, 0.0f, (float) this.o, (float) this.p);
        if (this.c) {
            this.t = this.u;
        }
    }

    private void c() {
        if (!this.b) {
            int i2 = 0;
            if (this.h > 0) {
                while (true) {
                    float[] fArr = this.r;
                    if (i2 < fArr.length) {
                        int i3 = this.h;
                        fArr[i2] = (float) i3;
                        this.s[i2] = ((float) i3) - (((float) this.d) / 2.0f);
                        i2++;
                    } else {
                        return;
                    }
                }
            } else {
                float[] fArr2 = this.r;
                int i4 = this.i;
                float f2 = (float) i4;
                fArr2[1] = f2;
                fArr2[0] = f2;
                int i5 = this.j;
                float f3 = (float) i5;
                fArr2[3] = f3;
                fArr2[2] = f3;
                int i6 = this.l;
                float f4 = (float) i6;
                fArr2[5] = f4;
                fArr2[4] = f4;
                int i7 = this.k;
                float f5 = (float) i7;
                fArr2[7] = f5;
                fArr2[6] = f5;
                float[] fArr3 = this.s;
                int i8 = this.d;
                float f6 = ((float) i4) - (((float) i8) / 2.0f);
                fArr3[1] = f6;
                fArr3[0] = f6;
                float f7 = ((float) i5) - (((float) i8) / 2.0f);
                fArr3[3] = f7;
                fArr3[2] = f7;
                float f8 = ((float) i6) - (((float) i8) / 2.0f);
                fArr3[5] = f8;
                fArr3[4] = f8;
                float f9 = ((float) i7) - (((float) i8) / 2.0f);
                fArr3[7] = f9;
                fArr3[6] = f9;
            }
        }
    }

    private void a(boolean z) {
        if (z) {
            this.h = 0;
        }
        c();
        a();
        invalidate();
    }

    private void d() {
        if (!this.b) {
            this.f = 0;
        }
    }

    public void isCoverSrc(boolean z) {
        this.c = z;
        b();
        invalidate();
    }

    public void isCircle(boolean z) {
        this.b = z;
        d();
        b();
        invalidate();
    }

    public void setBorderWidth(int i2) {
        this.d = (int) z.b(this.a, (float) i2);
        a(false);
    }

    public void setBorderColor(int i2) {
        this.e = i2;
        invalidate();
    }

    public void setInnerBorderWidth(int i2) {
        this.f = (int) z.b(this.a, (float) i2);
        d();
        invalidate();
    }

    public void setInnerBorderColor(int i2) {
        this.g = i2;
        invalidate();
    }

    public void setCornerRadius(int i2) {
        this.h = (int) z.b(this.a, (float) i2);
        a(false);
    }

    public void setCornerTopLeftRadius(int i2) {
        this.i = (int) z.b(this.a, (float) i2);
        a(true);
    }

    public void setCornerTopRightRadius(int i2) {
        this.j = (int) z.b(this.a, (float) i2);
        a(true);
    }

    public void setCornerBottomLeftRadius(int i2) {
        this.k = (int) z.b(this.a, (float) i2);
        a(true);
    }

    public void setCornerBottomRightRadius(int i2) {
        this.l = (int) z.b(this.a, (float) i2);
        a(true);
    }

    public void setMaskColor(int i2) {
        this.m = i2;
        invalidate();
    }
}
