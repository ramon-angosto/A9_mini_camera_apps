package com.shix.shixipc.view;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;

public class SlideRight extends BaseEffects {
    /* access modifiers changed from: protected */
    public void setupAnimation(View view) {
        getAnimatorSet().playTogether(new Animator[]{ObjectAnimator.ofFloat(view, "translationX", new float[]{300.0f, 0.0f}).setDuration(this.mDuration), ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f}).setDuration((this.mDuration * 3) / 2)});
    }
}
