package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.adexpress.d;
import com.bytedance.sdk.component.utils.t;

public class SlideUpView extends RelativeLayout {
    private ImageView a;
    private ImageView b;
    /* access modifiers changed from: private */
    public ImageView c;
    private TextView d;
    /* access modifiers changed from: private */
    public AnimatorSet e = new AnimatorSet();
    private AnimatorSet f = new AnimatorSet();
    private AnimatorSet g = new AnimatorSet();
    private String h;
    private AnimatorSet i = new AnimatorSet();
    private int j = 100;

    public SlideUpView(Context context, String str) {
        super(context);
        setClipChildren(false);
        this.h = str;
        a(context);
    }

    private void a(Context context) {
        if (context == null) {
            context = d.a();
        }
        if ("5".equals(this.h)) {
            inflate(context, t.f(context, "tt_dynamic_splash_slide_up_5"), this);
            this.j = (int) (((double) this.j) * 1.25d);
        } else {
            inflate(context, t.f(context, "tt_dynamic_splash_slide_up"), this);
        }
        this.a = (ImageView) findViewById(t.e(context, "tt_splash_slide_up_finger"));
        this.b = (ImageView) findViewById(t.e(context, "tt_splash_slide_up_circle"));
        this.d = (TextView) findViewById(t.e(context, "slide_guide_text"));
        this.c = (ImageView) findViewById(t.e(context, "tt_splash_slide_up_bg"));
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.e;
    }

    public void a() {
        b();
        this.e.start();
        this.e.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideUpView.this.postDelayed(new Runnable() {
                    public void run() {
                        SlideUpView.this.e.start();
                    }
                }, 200);
            }
        });
    }

    public void b() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.a, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.a, "translationY", new float[]{0.0f, b.a(getContext(), (float) (-this.j))});
        ofFloat3.setInterpolator(new a(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, (int) b.a(getContext(), (float) this.j)});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.c.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SlideUpView.this.c.setLayoutParams(layoutParams);
            }
        });
        ofInt.setInterpolator(new a(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.b, "scaleX", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.b, "translationY", new float[]{0.0f, b.a(getContext(), (float) (-this.j))});
        ValueAnimator valueAnimator = ofInt;
        ofFloat10.setInterpolator(new a(0.2f, 0.0f, 0.3f, 1.0f));
        this.f.setDuration(50);
        this.i.setDuration(1500);
        this.g.setDuration(50);
        this.f.playTogether(new Animator[]{ofFloat2, ofFloat7, ofFloat5});
        this.g.playTogether(new Animator[]{ofFloat, ofFloat6, ofFloat8, ofFloat9, ofFloat4});
        this.i.playTogether(new Animator[]{ofFloat3, valueAnimator, ofFloat10});
        this.e.playSequentially(new Animator[]{this.g, this.i, this.f});
    }

    public void c() {
        AnimatorSet animatorSet = this.e;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.g;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.f;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.i;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
    }

    public void setGuideText(String str) {
        this.d.setText(str);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c();
    }
}
