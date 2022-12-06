package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;

public class SplashDiffuseView extends View {
    private static int c = 50;
    private Paint a;
    /* access modifiers changed from: private */
    public int b;
    /* access modifiers changed from: private */
    public ObjectAnimator d;

    public SplashDiffuseView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SplashDiffuseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public SplashDiffuseView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = 10;
        b();
    }

    private void b() {
        this.a = new Paint();
        this.a.setAntiAlias(true);
        this.a.setColor(Color.parseColor("#FFFFFFFF"));
        this.a.setStyle(Paint.Style.STROKE);
        this.a.setStrokeWidth(18.0f);
        this.d = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f});
        this.d.setDuration(200);
    }

    public void invalidate() {
        if (hasWindowFocus()) {
            super.invalidate();
        }
    }

    public void onDraw(Canvas canvas) {
        this.a.setShader(new LinearGradient((float) (getMeasuredWidth() / 2), 0.0f, (float) (getMeasuredWidth() / 2), (float) getMeasuredHeight(), -1, ViewCompat.MEASURED_SIZE_MASK, Shader.TileMode.CLAMP));
        canvas.drawCircle(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f, (float) this.b, this.a);
    }

    public void a() {
        c = (int) Math.min(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f);
        c -= 18;
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{10, c});
        ofInt.setInterpolator(new a(0.0f, 0.2f, 0.3f, 1.0f));
        ofInt.setDuration(800);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int unused = SplashDiffuseView.this.b = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SplashDiffuseView.this.requestLayout();
            }
        });
        ofInt.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                SplashDiffuseView.this.setVisibility(0);
                SplashDiffuseView.this.setAlpha(1.0f);
            }

            public void onAnimationEnd(Animator animator) {
                SplashDiffuseView.this.d.start();
            }
        });
        ofInt.start();
    }
}
