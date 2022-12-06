package com.bytedance.sdk.openadsdk.common;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.core.model.m;

/* compiled from: LandingPageLoadingDefaultStyle */
public class c extends e {
    ObjectAnimator a;
    private AnimatorSet h;
    private LinearLayout i;

    public void a(int i2) {
    }

    public c(Context context, String str, String[] strArr, k kVar, m mVar) {
        super(context, str, strArr, kVar, mVar);
    }

    /* access modifiers changed from: protected */
    public void a() {
        this.e = LayoutInflater.from(this.f).inflate(t.f(this.f, "tt_landing_page_loading_default"), (ViewGroup) null);
        if (this.e != null) {
            this.i = (LinearLayout) this.e.findViewById(t.e(this.f, "wave_container"));
        }
        TextView textView = (TextView) this.e.findViewById(t.e(this.f, "tt_loading_tip"));
        if (textView != null && this.g != null) {
            textView.setText(this.g.c());
        }
    }

    public void b() {
        this.h = new AnimatorSet();
        LinearLayout linearLayout = this.i;
        if (linearLayout != null) {
            this.a = ObjectAnimator.ofFloat(linearLayout.getChildAt(0), "translationY", new float[]{-9.0f, 9.0f}).setDuration(300);
            this.a.setRepeatMode(2);
            this.a.setRepeatCount(-1);
            AnimatorSet.Builder play = this.h.play(this.a);
            for (int i2 = 1; i2 < this.i.getChildCount(); i2++) {
                float f = i2 % 2 == 0 ? 9.0f : -9.0f;
                ObjectAnimator duration = ObjectAnimator.ofFloat(this.i.getChildAt(i2), "translationY", new float[]{-f, f}).setDuration(300);
                duration.setRepeatMode(2);
                duration.setRepeatCount(-1);
                play = play.with(duration);
            }
            this.h.start();
        }
    }

    public void c() {
        ObjectAnimator objectAnimator = this.a;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        AnimatorSet animatorSet = this.h;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void d() {
        super.d();
    }
}
