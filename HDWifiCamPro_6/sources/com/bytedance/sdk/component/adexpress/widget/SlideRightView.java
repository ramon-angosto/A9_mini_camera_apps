package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.utils.t;

public class SlideRightView extends FrameLayout {
    private Context a;
    /* access modifiers changed from: private */
    public ImageView b;
    /* access modifiers changed from: private */
    public ImageView c;
    /* access modifiers changed from: private */
    public ImageView d;
    private TextView e;
    /* access modifiers changed from: private */
    public AnimatorSet f = new AnimatorSet();
    private AnimatorSet g = new AnimatorSet();
    private AnimatorSet h = new AnimatorSet();
    private AnimatorSet i = new AnimatorSet();

    public SlideRightView(Context context) {
        super(context);
        this.a = context;
        b();
    }

    private void b() {
        this.d = new ImageView(this.a);
        this.d.setBackgroundResource(t.d(this.a, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        addView(this.d, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        this.c = new ImageView(this.a);
        this.c.setImageResource(t.d(this.a, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) b.a(this.a, 50.0f), (int) b.a(this.a, 50.0f));
        layoutParams2.gravity = 48;
        addView(this.c, layoutParams2);
        this.b = new ImageView(this.a);
        this.b.setImageResource(t.d(this.a, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) b.a(this.a, 80.0f), (int) b.a(this.a, 80.0f));
        layoutParams3.gravity = 48;
        addView(this.b, layoutParams3);
        this.e = new TextView(this.a);
        this.e.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.e, layoutParams4);
        post(new Runnable() {
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.b.getLayoutParams();
                layoutParams.topMargin = (int) ((((float) SlideRightView.this.c.getMeasuredHeight()) / 2.0f) - b.a(SlideRightView.this.getContext(), 7.0f));
                layoutParams.leftMargin = -SlideRightView.this.c.getMeasuredWidth();
                SlideRightView.this.b.setLayoutParams(layoutParams);
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) SlideRightView.this.d.getLayoutParams();
                layoutParams2.topMargin = (int) ((((float) SlideRightView.this.c.getMeasuredHeight()) / 2.0f) - b.a(SlideRightView.this.getContext(), 5.0f));
                layoutParams2.leftMargin = (int) (((float) SlideRightView.this.c.getMeasuredWidth()) / 2.0f);
                SlideRightView.this.d.setLayoutParams(layoutParams2);
            }
        });
    }

    private void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.c, "scaleX", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.c, "scaleY", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.d, "alpha", new float[]{0.0f, 1.0f});
        this.h.setDuration(300);
        this.h.playTogether(new Animator[]{ofFloat, ofFloat2, ofFloat3, ofFloat4});
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.b, "translationX", new float[]{0.0f, b.a(getContext(), 80.0f)});
        ofFloat5.setInterpolator(new a(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, (int) b.a(getContext(), 80.0f)});
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.d.getLayoutParams();
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SlideRightView.this.d.setLayoutParams(layoutParams);
            }
        });
        ofInt.setInterpolator(new a(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.c, "translationX", new float[]{0.0f, b.a(getContext(), 80.0f)});
        ofFloat6.setInterpolator(new a(0.2f, 0.0f, 0.3f, 1.0f));
        this.i.setDuration(1500);
        this.i.playTogether(new Animator[]{ofFloat5, ofInt, ofFloat6});
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.b, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.d, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.c, "alpha", new float[]{1.0f, 0.0f});
        this.g.setDuration(50);
        this.g.playTogether(new Animator[]{ofFloat7, ofFloat8, ofFloat9});
        this.f.playSequentially(new Animator[]{this.h, this.i, this.g});
    }

    public void a() {
        c();
        this.f.start();
        this.f.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideRightView.this.postDelayed(new Runnable() {
                    public void run() {
                        SlideRightView.this.f.start();
                    }
                }, 200);
            }
        });
    }

    public void setGuideText(String str) {
        this.e.setText(str);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
    }
}
