package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.u;

public class ShakeAnimationView extends LinearLayout {
    private TextView a;
    /* access modifiers changed from: private */
    public ImageView b;
    private u c;
    private TextView d;
    private a e;
    private LinearLayout f;
    private int g;
    private int h;
    private int i;

    public interface a {
    }

    public ShakeAnimationView(Context context, int i2, int i3, int i4, int i5) {
        super(context);
        this.g = i3;
        this.h = i4;
        this.i = i5;
        a(context, i2);
    }

    private void a(Context context, int i2) {
        inflate(context, i2, this);
        this.f = (LinearLayout) findViewById(t.e(context, "tt_hand_container"));
        this.b = (ImageView) findViewById(t.e(context, "tt_splash_rock_img"));
        this.a = (TextView) findViewById(t.e(context, "tt_splash_rock_top_text"));
        this.d = (TextView) findViewById(t.e(context, "tt_splash_rock_text"));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.f.setBackground(gradientDrawable);
    }

    public void setShakeText(String str) {
        this.d.setText(str);
    }

    public LinearLayout getShakeLayout() {
        return this.f;
    }

    public void setOnShakeViewListener(a aVar) {
        this.e = aVar;
    }

    public void a() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", new float[]{0.0f, 1.0f});
        ofFloat.setDuration(300);
        ofFloat.start();
        postDelayed(new Runnable() {
            public void run() {
                if (ShakeAnimationView.this.b != null) {
                    final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                    rotateAnimation.setInterpolator(new b());
                    rotateAnimation.setDuration(1000);
                    rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }

                        public void onAnimationEnd(Animation animation) {
                            ShakeAnimationView.this.postDelayed(new Runnable() {
                                public void run() {
                                    ShakeAnimationView.this.b.startAnimation(rotateAnimation);
                                }
                            }, 250);
                        }
                    });
                    ShakeAnimationView.this.b.startAnimation(rotateAnimation);
                }
            }
        }, 500);
    }

    private static class b implements Interpolator {
        public float getInterpolation(float f) {
            return f <= 0.25f ? (f * -2.0f) + 0.5f : f <= 0.5f ? (f * 4.0f) - 1.0f : f <= 0.75f ? (f * -4.0f) + 3.0f : (f * 2.0f) - 1.5f;
        }

        private b() {
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.c == null) {
                this.c = new u(getContext().getApplicationContext());
            }
            this.c.a((u.a) new u.a() {
            });
            this.c.a((float) this.g);
            this.c.c((float) this.h);
            this.c.a(this.i);
            this.c.a();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        u uVar = this.c;
        if (uVar == null) {
            return;
        }
        if (z) {
            uVar.a();
        } else {
            uVar.b();
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u uVar = this.c;
        if (uVar != null) {
            uVar.b();
        }
    }
}
