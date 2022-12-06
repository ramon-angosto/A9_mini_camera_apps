package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public final class FadeProvider implements VisibilityAnimatorProvider {
    private float incomingEndThreshold = 1.0f;

    public float getIncomingEndThreshold() {
        return this.incomingEndThreshold;
    }

    public void setIncomingEndThreshold(float f) {
        this.incomingEndThreshold = f;
    }

    public Animator createAppear(ViewGroup viewGroup, View view) {
        return createFadeAnimator(view, 0.0f, 1.0f, 0.0f, this.incomingEndThreshold);
    }

    public Animator createDisappear(ViewGroup viewGroup, View view) {
        return createFadeAnimator(view, 1.0f, 0.0f, 0.0f, 1.0f);
    }

    private static Animator createFadeAnimator(View view, float f, float f2, float f3, float f4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        final View view2 = view;
        final float f5 = f;
        final float f6 = f2;
        final float f7 = f3;
        final float f8 = f4;
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view2.setAlpha(TransitionUtils.lerp(f5, f6, f7, f8, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            }
        });
        return ofFloat;
    }
}
