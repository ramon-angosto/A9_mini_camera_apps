package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

public final class FadeThroughProvider implements VisibilityAnimatorProvider {
    static final float PROGRESS_THRESHOLD = 0.35f;

    public Animator createAppear(ViewGroup viewGroup, View view) {
        return createFadeThroughAnimator(view, 0.0f, 1.0f, PROGRESS_THRESHOLD, 1.0f);
    }

    public Animator createDisappear(ViewGroup viewGroup, View view) {
        return createFadeThroughAnimator(view, 1.0f, 0.0f, 0.0f, PROGRESS_THRESHOLD);
    }

    private static Animator createFadeThroughAnimator(View view, float f, float f2, float f3, float f4) {
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
