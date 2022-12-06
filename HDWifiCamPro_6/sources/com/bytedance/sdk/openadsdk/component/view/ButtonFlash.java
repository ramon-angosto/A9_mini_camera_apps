package com.bytedance.sdk.openadsdk.component.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.view.ViewCompat;

public class ButtonFlash extends TextView {
    /* access modifiers changed from: private */
    public int a;
    /* access modifiers changed from: private */
    public int b;
    private Paint c;
    /* access modifiers changed from: private */
    public LinearGradient d;
    private RectF e;
    /* access modifiers changed from: private */
    public Matrix f;
    private ValueAnimator g;
    private boolean h = true;

    public ButtonFlash(Context context) {
        super(context);
        b();
    }

    public ButtonFlash(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b();
    }

    public ButtonFlash(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        b();
    }

    private void b() {
        this.e = new RectF();
        this.c = new Paint();
        c();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.a = i;
        this.b = i2;
        this.d = new LinearGradient(0.0f, 0.0f, ((float) this.a) / 2.0f, (float) this.b, new int[]{ViewCompat.MEASURED_SIZE_MASK, 1358954495, ViewCompat.MEASURED_SIZE_MASK}, new float[]{0.1f, 0.3f, 0.5f}, Shader.TileMode.CLAMP);
        this.c.setShader(this.d);
        this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.LIGHTEN));
        this.f = new Matrix();
        this.f.setTranslate((float) (-this.a), (float) this.b);
        this.d.setLocalMatrix(this.f);
        this.e.set(0.0f, 0.0f, (float) this.a, (float) this.b);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f != null) {
            canvas.drawRoundRect(this.e, 100.0f, 100.0f, this.c);
        }
    }

    private void c() {
        this.g = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.g.setDuration(3000);
        this.g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float a2 = (((float) (ButtonFlash.this.a * 2)) * ((Float) valueAnimator.getAnimatedValue()).floatValue()) - ((float) ButtonFlash.this.a);
                if (ButtonFlash.this.f != null) {
                    ButtonFlash.this.f.setTranslate(a2, (float) ButtonFlash.this.b);
                }
                if (ButtonFlash.this.d != null) {
                    ButtonFlash.this.d.setLocalMatrix(ButtonFlash.this.f);
                }
                ButtonFlash.this.invalidate();
            }
        });
        if (this.h) {
            this.g.setRepeatCount(-1);
            ValueAnimator valueAnimator = this.g;
            if (valueAnimator != null) {
                valueAnimator.start();
            }
        }
    }

    public void setAutoRun(boolean z) {
        this.h = z;
    }

    public void a() {
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            invalidate();
        }
    }
}
