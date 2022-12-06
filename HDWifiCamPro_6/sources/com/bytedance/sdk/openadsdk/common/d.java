package com.bytedance.sdk.openadsdk.common;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.core.model.m;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.l.z;
import java.util.Locale;

/* compiled from: LandingPageLoadingFirstStyle */
public class d extends e {
    AnimatorSet a;
    /* access modifiers changed from: private */
    public TextView h;
    /* access modifiers changed from: private */
    public TextView i;
    private ProgressBar j;
    private TextView k;
    /* access modifiers changed from: private */
    public FrameLayout l;
    private int m = 0;

    public d(Context context, String str, String[] strArr, k kVar, m mVar) {
        super(context, str, strArr, kVar, mVar);
    }

    /* access modifiers changed from: protected */
    public void a() {
        if (this.f != null) {
            this.e = LayoutInflater.from(this.f).inflate(t.f(this.f, "tt_landing_page_loading_1"), (ViewGroup) null);
            TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) this.e.findViewById(t.e(this.f, "tt_loading_icon"));
            TextView textView = (TextView) this.e.findViewById(t.e(this.f, "tt_loading_appname"));
            this.h = (TextView) this.e.findViewById(t.e(this.f, "tt_loading_text_1"));
            this.i = (TextView) this.e.findViewById(t.e(this.f, "tt_loading_text_2"));
            this.j = (ProgressBar) this.e.findViewById(t.e(this.f, "tt_loading_progressbar"));
            this.k = (TextView) this.e.findViewById(t.e(this.f, "tt_loading_progress_number"));
            this.l = (FrameLayout) this.e.findViewById(t.e(this.f, "tt_loading_tags_container"));
            if (textView != null) {
                if (!TextUtils.isEmpty(this.c)) {
                    textView.setText(this.c);
                } else {
                    textView.setVisibility(8);
                }
            }
            if (this.d == null || this.d.length <= 0) {
                FrameLayout frameLayout = this.l;
                if (frameLayout != null) {
                    frameLayout.setVisibility(8);
                }
            } else {
                TextView textView2 = this.i;
                if (textView2 != null) {
                    textView2.setText(this.d[0]);
                }
            }
            if (tTRoundRectImageView == null) {
                return;
            }
            if (this.b == null || TextUtils.isEmpty(this.b.a())) {
                tTRoundRectImageView.setVisibility(8);
            } else {
                com.bytedance.sdk.openadsdk.i.d.a().a(this.b, (ImageView) tTRoundRectImageView);
            }
        }
    }

    public void b() {
        b(0);
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        FrameLayout frameLayout = this.l;
        if (frameLayout != null && frameLayout.getVisibility() == 0) {
            this.l.postDelayed(new Runnable() {
                public void run() {
                    if (d.this.a == null) {
                        d.this.a = new AnimatorSet();
                        AnimatorSet animatorSet = d.this.a;
                        d dVar = d.this;
                        AnimatorSet.Builder play = animatorSet.play(dVar.a(dVar.h));
                        d dVar2 = d.this;
                        play.with(dVar2.b(dVar2.i));
                        d.this.a.setDuration(500);
                    }
                    d.this.a.start();
                }
            }, (long) i2);
        }
    }

    public void c() {
        AnimatorSet animatorSet = this.a;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    /* access modifiers changed from: private */
    public ObjectAnimator a(TextView textView) {
        return ObjectAnimator.ofFloat(textView, "translationY", new float[]{0.0f, (float) (-this.l.getHeight())});
    }

    /* access modifiers changed from: private */
    public ObjectAnimator b(final TextView textView) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(textView, "translationY", new float[]{((float) this.l.getHeight()) + z.b(this.f, 10.0f), 0.0f});
        ofFloat.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                super.onAnimationStart(animator);
                TextView textView = textView;
                if (textView != null) {
                    textView.setVisibility(0);
                }
            }

            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                if (d.this.d != null && d.this.d.length >= 2 && d.this.l != null) {
                    d.this.b(2000);
                    d.this.f();
                }
            }
        });
        return ofFloat;
    }

    /* access modifiers changed from: private */
    public void f() {
        if (this.d != null) {
            if (this.m >= this.d.length) {
                this.m = 0;
            }
            TextView textView = this.h;
            if (textView != null) {
                if (textView.getVisibility() != 0) {
                    this.h.setVisibility(0);
                }
                this.h.setText(this.d[this.m]);
                this.h.setY(0.0f);
            }
            if (this.i != null) {
                int i2 = this.m + 1;
                if (i2 >= this.d.length) {
                    i2 = 0;
                }
                this.i.setText(this.d[i2]);
                this.i.setVisibility(4);
            }
            this.m++;
        }
    }

    public void a(int i2) {
        ProgressBar progressBar = this.j;
        if (progressBar != null) {
            progressBar.setProgress(i2);
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", new Object[]{Integer.valueOf(i2)}));
        }
    }

    public void d() {
        super.d();
    }
}
