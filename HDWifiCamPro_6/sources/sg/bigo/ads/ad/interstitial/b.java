package sg.bigo.ads.ad.interstitial;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import sg.bigo.ads.common.utils.a;

final class b {
    public static void a(final View view) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, (float) view.getHeight());
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(a.a(1));
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new a.C0127a() {
            public final void onAnimationEnd(Animation animation) {
                view.clearAnimation();
                view.setVisibility(8);
            }
        });
        view.startAnimation(translateAnimation);
    }

    public static void a(View view, Animation.AnimationListener animationListener) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) view.getHeight(), 0.0f);
        translateAnimation.setDuration(200);
        translateAnimation.setInterpolator(a.a(2));
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(animationListener);
        view.startAnimation(translateAnimation);
    }

    public static void b(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setInterpolator(a.a(2));
        alphaAnimation.setFillAfter(true);
        view.startAnimation(alphaAnimation);
    }

    public static void c(final View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setInterpolator(a.a(1));
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setAnimationListener(new a.C0127a() {
            public final void onAnimationEnd(Animation animation) {
                view.setVisibility(8);
            }
        });
        view.startAnimation(alphaAnimation);
    }

    public static void d(View view) {
        AnimationSet animationSet = new AnimationSet(true);
        Interpolator a = a.a(2);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(200);
        alphaAnimation.setInterpolator(a);
        animationSet.addAnimation(alphaAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.1f, 1.0f, 0.1f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300);
        alphaAnimation.setInterpolator(a);
        animationSet.addAnimation(scaleAnimation);
        view.startAnimation(animationSet);
    }

    public static void e(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.9f, 1.0f, 0.9f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200);
        scaleAnimation.setInterpolator(a.a(1));
        scaleAnimation.setRepeatCount(-1);
        scaleAnimation.setRepeatMode(2);
        view.startAnimation(scaleAnimation);
    }
}
