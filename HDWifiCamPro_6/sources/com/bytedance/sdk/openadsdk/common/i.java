package com.bytedance.sdk.openadsdk.common;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.settings.j;
import com.bytedance.sdk.openadsdk.l.z;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: TTTitleNewStyleManager */
public class i {
    TTAdDislikeDialog a;
    TTAdDislikeToast b;
    final AtomicBoolean c = new AtomicBoolean(false);
    final AtomicBoolean d = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public final RelativeLayout e;
    private final n f;
    private Context g;
    private ImageView h;
    private TextView i;
    private ImageView j;
    private ProgressBar k;
    private final int l;
    /* access modifiers changed from: private */
    public boolean m;

    public i(Context context, RelativeLayout relativeLayout, n nVar) {
        this.g = context;
        this.e = relativeLayout;
        this.f = nVar;
        this.l = (int) z.b(m.a(), 44.0f);
        e();
    }

    private void e() {
        this.h = (ImageView) this.e.findViewById(t.e(this.g, "tt_title_bar_close"));
        this.i = (TextView) this.e.findViewById(t.e(this.g, "tt_title_bar_title"));
        this.j = (ImageView) this.e.findViewById(t.e(this.g, "tt_title_bar_feedback"));
        this.k = (ProgressBar) this.e.findViewById(t.e(this.g, "tt_title_bar_browser_progress"));
        n nVar = this.f;
        if (nVar != null) {
            this.i.setText(TextUtils.isEmpty(nVar.U()) ? t.a(this.g, "tt_web_title_default") : this.f.U());
        }
        this.j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                i.this.d();
            }
        });
    }

    public void a(WebView webView, int i2) {
        if (i2 == 100) {
            this.k.setVisibility(8);
            return;
        }
        this.k.setVisibility(0);
        this.k.setProgress(i2);
    }

    public void a() {
        try {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            if (!this.m && marginLayoutParams.topMargin == (-this.l)) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{-this.l, 0});
                ofInt.setDuration(300);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        i.this.e.setLayoutParams(marginLayoutParams);
                    }
                });
                ofInt.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        boolean unused = i.this.m = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        boolean unused = i.this.m = false;
                    }
                });
                ofInt.start();
            }
        } catch (Throwable unused) {
        }
    }

    public void b() {
        try {
            final ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.e.getLayoutParams();
            if (!this.m && marginLayoutParams.topMargin == 0) {
                ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, -this.l});
                ofInt.setDuration(300);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        marginLayoutParams.topMargin = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                        i.this.e.setLayoutParams(marginLayoutParams);
                    }
                });
                ofInt.addListener(new Animator.AnimatorListener() {
                    public void onAnimationCancel(Animator animator) {
                    }

                    public void onAnimationRepeat(Animator animator) {
                    }

                    public void onAnimationStart(Animator animator) {
                        boolean unused = i.this.m = true;
                    }

                    public void onAnimationEnd(Animator animator) {
                        boolean unused = i.this.m = false;
                    }
                });
                ofInt.start();
            }
        } catch (Throwable unused) {
        }
    }

    public ImageView c() {
        return this.h;
    }

    /* access modifiers changed from: protected */
    public void d() {
        if (this.d.get()) {
            g();
            return;
        }
        if (this.a == null) {
            f();
        }
        this.a.a();
    }

    private void f() {
        try {
            if (this.a == null) {
                this.a = new TTAdDislikeDialog(this.g, this.f);
                this.a.setCallback(new TTAdDislikeDialog.a() {
                    public void c(View view) {
                    }

                    public void a(View view) {
                        i.this.c.set(true);
                    }

                    public void b(View view) {
                        i.this.c.set(false);
                    }

                    public void a(int i, FilterWord filterWord) {
                        if (!i.this.d.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                            i.this.d.set(true);
                        }
                    }
                });
            }
            ((FrameLayout) this.e.getRootView().findViewById(16908290)).addView(this.a);
            if (this.b == null) {
                this.b = new TTAdDislikeToast(this.g);
                ((FrameLayout) this.e.getRootView().findViewById(16908290)).addView(this.b);
            }
        } catch (Throwable unused) {
        }
    }

    private void g() {
        this.b.a(j.d);
    }
}
