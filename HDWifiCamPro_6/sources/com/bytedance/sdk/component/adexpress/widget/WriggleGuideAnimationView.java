package com.bytedance.sdk.component.adexpress.widget;

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

public class WriggleGuideAnimationView extends LinearLayout {
    private TextView a;
    /* access modifiers changed from: private */
    public ImageView b;
    private u c;
    private TextView d;
    private a e;
    private LinearLayout f;
    private WriggleGuideView g;
    private int h;

    public interface a {
    }

    public WriggleGuideAnimationView(Context context, int i, int i2) {
        super(context);
        this.h = i2;
        a(context, i);
    }

    private void a(Context context, int i) {
        inflate(context, i, this);
        this.f = (LinearLayout) findViewById(t.e(context, "tt_interact_splash_wriggle_layout"));
        this.b = (ImageView) findViewById(t.e(context, "tt_interact_splash_top_img"));
        this.g = (WriggleGuideView) findViewById(t.e(context, "tt_interact_splash_progress_img"));
        this.a = (TextView) findViewById(t.e(context, "tt_interact_splash_top_text"));
        this.d = (TextView) findViewById(t.e(context, "tt_interact_splash_click_bar_text"));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.f.setBackground(gradientDrawable);
    }

    public void setShakeText(String str) {
        this.d.setText(str);
    }

    public LinearLayout getWriggleLayout() {
        return this.f;
    }

    public WriggleGuideView getWriggleProgressIv() {
        return this.g;
    }

    public TextView getTopTextView() {
        return this.a;
    }

    public void setOnShakeViewListener(a aVar) {
        this.e = aVar;
    }

    public void a() {
        postDelayed(new Runnable() {
            public void run() {
                if (WriggleGuideAnimationView.this.b != null) {
                    final RotateAnimation rotateAnimation = new RotateAnimation(0.0f, -35.0f, 1, 0.5f, 1, 0.5f);
                    rotateAnimation.setInterpolator(new b());
                    rotateAnimation.setDuration(1500);
                    rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                        public void onAnimationRepeat(Animation animation) {
                        }

                        public void onAnimationStart(Animation animation) {
                        }

                        public void onAnimationEnd(Animation animation) {
                            WriggleGuideAnimationView.this.postDelayed(new Runnable() {
                                public void run() {
                                    WriggleGuideAnimationView.this.b.startAnimation(rotateAnimation);
                                }
                            }, 300);
                        }
                    });
                    WriggleGuideAnimationView.this.b.startAnimation(rotateAnimation);
                }
            }
        }, 500);
    }

    private static class b implements Interpolator {
        public float getInterpolation(float f) {
            return f <= 0.4f ? f * 2.5f : f <= 0.8f ? (f * -2.2f) + 1.86f : (f * -0.7f) + 0.7f;
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
            this.c.b((float) this.h);
            this.c.a();
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
}
