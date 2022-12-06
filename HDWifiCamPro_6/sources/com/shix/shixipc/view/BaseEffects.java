package com.shix.shixipc.view;

import android.animation.AnimatorSet;
import android.view.View;
import com.nineoldandroids.view.ViewHelper;

public abstract class BaseEffects {
    private static final int DURATION = 500;
    private AnimatorSet mAnimatorSet = new AnimatorSet();
    protected long mDuration = 500;

    /* access modifiers changed from: protected */
    public abstract void setupAnimation(View view);

    public void start(View view) {
        reset(view);
        setupAnimation(view);
        this.mAnimatorSet.start();
    }

    public void reset(View view) {
        ViewHelper.setPivotX(view, ((float) view.getMeasuredWidth()) / 2.0f);
        ViewHelper.setPivotY(view, ((float) view.getMeasuredHeight()) / 2.0f);
    }

    public AnimatorSet getAnimatorSet() {
        return this.mAnimatorSet;
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }
}
