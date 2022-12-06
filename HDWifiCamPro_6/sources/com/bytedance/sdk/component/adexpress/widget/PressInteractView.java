package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.utils.t;

public class PressInteractView extends FrameLayout {
    /* access modifiers changed from: private */
    public Context a;
    /* access modifiers changed from: private */
    public ImageView b;
    /* access modifiers changed from: private */
    public SplashDiffuseView c;
    private AnimatorSet d;
    /* access modifiers changed from: private */
    public boolean e = true;
    private TextView f;

    public PressInteractView(Context context) {
        super(context);
        this.a = context;
        this.d = new AnimatorSet();
        c();
        d();
        post(new Runnable() {
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressInteractView.this.b.getLayoutParams();
                layoutParams.topMargin = ((int) ((((float) PressInteractView.this.c.getMeasuredHeight()) / 2.0f) - b.a(PressInteractView.this.getContext(), 5.0f))) + ((int) b.a(PressInteractView.this.a, 20.0f));
                layoutParams.leftMargin = ((int) ((((float) PressInteractView.this.c.getMeasuredWidth()) / 2.0f) - b.a(PressInteractView.this.getContext(), 5.0f))) + ((int) b.a(PressInteractView.this.a, 20.0f));
                layoutParams.bottomMargin = (int) ((((float) (-PressInteractView.this.c.getMeasuredHeight())) / 2.0f) + b.a(PressInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) ((((float) (-PressInteractView.this.c.getMeasuredWidth())) / 2.0f) + b.a(PressInteractView.this.getContext(), 5.0f));
                PressInteractView.this.b.setLayoutParams(layoutParams);
            }
        });
    }

    private void c() {
        this.c = new SplashDiffuseView(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) b.a(this.a, 50.0f), (int) b.a(this.a, 50.0f));
        layoutParams.gravity = 51;
        layoutParams.topMargin = (int) b.a(this.a, 20.0f);
        layoutParams.leftMargin = (int) b.a(this.a, 20.0f);
        addView(this.c, layoutParams);
        this.b = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) b.a(this.a, 78.0f), (int) b.a(this.a, 78.0f));
        this.b.setImageResource(t.d(this.a, "tt_splash_hand"));
        addView(this.b, layoutParams2);
        this.f = new TextView(this.a);
        this.f.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) b.a(this.a, 10.0f);
        addView(this.f, layoutParams3);
        this.f.setVisibility(8);
    }

    private void d() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "scaleX", new float[]{1.0f, 0.9f});
        ofFloat.setDuration(1000);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(PressInteractView.this.b, "alpha", new float[]{0.0f, 1.0f});
                ofFloat.setDuration(200);
                ofFloat.setInterpolator(new LinearInterpolator());
                ofFloat.start();
                PressInteractView.this.b.setVisibility(0);
            }

            public void onAnimationRepeat(Animator animator) {
                if (PressInteractView.this.e) {
                    PressInteractView.this.c.a();
                }
                PressInteractView pressInteractView = PressInteractView.this;
                boolean unused = pressInteractView.e = !pressInteractView.e;
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[]{1.0f, 0.9f});
        ofFloat2.setDuration(1000);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.d.playTogether(new Animator[]{ofFloat, ofFloat2});
    }

    public void setGuideText(String str) {
        this.f.setVisibility(0);
        this.f.setText(str);
    }

    public void setGuideTextColor(int i) {
        this.f.setTextColor(i);
    }

    public void a() {
        this.d.start();
    }

    public void b() {
        AnimatorSet animatorSet = this.d;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
