package com.bytedance.sdk.openadsdk.core.widget;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.l.z;

public class TTCountdownView extends View {
    public static final String a = t.a(m.a(), "tt_count_down_view");
    private float b;
    private float c;
    private int d;
    private boolean e;
    private float f;
    private float g;
    private String h;
    private boolean i;
    private Paint j;
    private Paint k;
    private Paint l;
    private Paint m;
    /* access modifiers changed from: private */
    public float n;
    /* access modifiers changed from: private */
    public float o;
    private RectF p;
    private a q;
    private AnimatorSet r;
    private ValueAnimator s;
    private ValueAnimator t;
    private ValueAnimator u;

    public interface a {
    }

    public float a(float f2, float f3) {
        return f2 * f3;
    }

    public float a(float f2, int i2) {
        return ((float) i2) * f2;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        if (mode != 1073741824) {
            size = b();
        }
        if (mode2 != 1073741824) {
            size2 = b();
        }
        setMeasuredDimension(size, size2);
    }

    private int b() {
        return (int) ((((this.b / 2.0f) + this.c) * 2.0f) + z.b(getContext(), 4.0f));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f);
        b(canvas);
        a(canvas);
    }

    private void a(Canvas canvas) {
        String str;
        canvas.save();
        Paint.FontMetrics fontMetrics = this.m.getFontMetrics();
        String str2 = a;
        if (this.i) {
            str = "" + ((int) Math.ceil((double) a(this.o, this.g)));
        } else {
            str = this.h;
        }
        if (TextUtils.isEmpty(str)) {
            str = a;
        }
        canvas.drawText(str, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.m);
        canvas.restore();
    }

    private void b(Canvas canvas) {
        float f2;
        canvas.save();
        float a2 = a(this.n, 360);
        if (this.e) {
            f2 = ((float) this.d) - a2;
        } else {
            f2 = (float) this.d;
        }
        canvas.drawCircle(0.0f, 0.0f, this.c, this.k);
        canvas.drawCircle(0.0f, 0.0f, this.c, this.l);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.p, f2, a2, false, this.j);
        canvas.restore();
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.s;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.s = null;
        }
        this.s = ValueAnimator.ofFloat(new float[]{this.o, 0.0f});
        this.s.setInterpolator(new LinearInterpolator());
        this.s.setDuration((long) (a(this.o, this.g) * 1000.0f));
        this.s.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = TTCountdownView.this.o = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.s;
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.t;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.t = null;
        }
        this.t = ValueAnimator.ofFloat(new float[]{this.n, 0.0f});
        this.t.setInterpolator(new LinearInterpolator());
        this.t.setDuration((long) (a(this.n, this.f) * 1000.0f));
        this.t.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float unused = TTCountdownView.this.n = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TTCountdownView.this.postInvalidate();
            }
        });
        return this.t;
    }

    public void a() {
        AnimatorSet animatorSet = this.r;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.r = null;
        }
        ValueAnimator valueAnimator = this.u;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.u = null;
        }
        ValueAnimator valueAnimator2 = this.s;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
            this.s = null;
        }
        ValueAnimator valueAnimator3 = this.t;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
            this.t = null;
        }
        this.n = 1.0f;
        this.o = 1.0f;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        a();
        super.onDetachedFromWindow();
    }

    public void setCountDownTime(int i2) {
        float f2 = (float) i2;
        this.g = f2;
        this.f = f2;
        a();
    }

    public a getCountdownListener() {
        return this.q;
    }

    public void setCountdownListener(a aVar) {
        this.q = aVar;
    }
}
