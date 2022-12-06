package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.c.b;
import com.bytedance.sdk.component.utils.t;

public class PressButtonInteractView extends FrameLayout {
    private Context a;
    /* access modifiers changed from: private */
    public ImageView b;
    /* access modifiers changed from: private */
    public SplashDiffuseView c;
    private AnimatorSet d;
    /* access modifiers changed from: private */
    public boolean e = true;

    public PressButtonInteractView(Context context) {
        super(context);
        this.a = context;
        this.d = new AnimatorSet();
        c();
        d();
        post(new Runnable() {
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressButtonInteractView.this.b.getLayoutParams();
                layoutParams.topMargin = (int) ((((float) PressButtonInteractView.this.c.getMeasuredHeight()) / 2.0f) - b.a(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((((float) PressButtonInteractView.this.c.getMeasuredWidth()) / 2.0f) - b.a(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) ((((float) (-PressButtonInteractView.this.c.getMeasuredHeight())) / 2.0f) + b.a(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) ((((float) (-PressButtonInteractView.this.c.getMeasuredWidth())) / 2.0f) + b.a(PressButtonInteractView.this.getContext(), 5.0f));
                PressButtonInteractView.this.b.setLayoutParams(layoutParams);
            }
        });
    }

    private void c() {
        this.c = new SplashDiffuseView(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) b.a(this.a, 40.0f), (int) b.a(this.a, 40.0f));
        layoutParams.gravity = 19;
        addView(this.c, layoutParams);
        this.b = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) b.a(this.a, 62.0f), (int) b.a(this.a, 62.0f));
        layoutParams2.gravity = 16;
        this.b.setImageResource(t.d(this.a, "tt_splash_hand"));
        addView(this.b, layoutParams2);
    }

    private void d() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.b, "scaleX", new float[]{1.0f, 0.9f});
        ofFloat.setDuration(800);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(PressButtonInteractView.this.b, "alpha", new float[]{0.0f, 1.0f});
                ofFloat.setDuration(200);
                ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat.start();
                PressButtonInteractView.this.b.setVisibility(0);
            }

            public void onAnimationRepeat(Animator animator) {
                if (PressButtonInteractView.this.e) {
                    PressButtonInteractView.this.c.a();
                }
                PressButtonInteractView pressButtonInteractView = PressButtonInteractView.this;
                boolean unused = pressButtonInteractView.e = !pressButtonInteractView.e;
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[]{1.0f, 0.9f});
        ofFloat2.setDuration(800);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.d.playTogether(new Animator[]{ofFloat, ofFloat2});
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
