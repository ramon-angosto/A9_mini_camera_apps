package com.bytedance.sdk.openadsdk.component.reward.a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.TwoSemicirclesView;
import com.bytedance.sdk.openadsdk.e.a;
import com.bytedance.sdk.openadsdk.l.z;

/* compiled from: RewardFullVideoLoadingManager */
public class d {
    TTRoundRectImageView a;
    TextView b;
    ProgressBar c;
    TextView d;
    /* access modifiers changed from: private */
    public n e;
    /* access modifiers changed from: private */
    public Context f;
    private int g = 0;
    private View h;
    private boolean i = false;
    private LinearLayout j;
    private TwoSemicirclesView k;
    private TwoSemicirclesView l;
    private TextView m;
    /* access modifiers changed from: private */
    public String n;
    private int o;
    private AnimatorSet p;
    private AnimatorSet q;

    public d(Context context) {
        this.f = context;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|9|10|11|(2:13|(2:15|(2:17|(2:19|29)(2:20|30))(2:21|31))(2:22|32))(2:23|33)) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0039 A[Catch:{ all -> 0x0056 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0051 A[Catch:{ all -> 0x0056 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.bytedance.sdk.openadsdk.core.model.n r3, java.lang.String r4, int r5) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            r2.e = r3     // Catch:{ all -> 0x0056 }
            com.bytedance.sdk.openadsdk.core.model.n r3 = r2.e     // Catch:{ all -> 0x0056 }
            boolean r3 = com.bytedance.sdk.openadsdk.core.model.n.c((com.bytedance.sdk.openadsdk.core.model.n) r3)     // Catch:{ all -> 0x0056 }
            if (r3 == 0) goto L_0x0055
            com.bytedance.sdk.openadsdk.core.model.n r3 = r2.e     // Catch:{ all -> 0x0056 }
            boolean r3 = com.bytedance.sdk.openadsdk.core.model.p.i(r3)     // Catch:{ all -> 0x0056 }
            if (r3 == 0) goto L_0x0017
            goto L_0x0055
        L_0x0017:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ JSONException -> 0x002e }
            com.bytedance.sdk.openadsdk.core.model.n r1 = r2.e     // Catch:{ JSONException -> 0x002e }
            com.bytedance.sdk.openadsdk.core.model.n$a r1 = r1.G()     // Catch:{ JSONException -> 0x002e }
            java.lang.String r1 = r1.g()     // Catch:{ JSONException -> 0x002e }
            r3.<init>(r1)     // Catch:{ JSONException -> 0x002e }
            java.lang.String r1 = "loading_page_type"
            int r3 = r3.optInt(r1, r0)     // Catch:{ JSONException -> 0x002e }
            r2.g = r3     // Catch:{ JSONException -> 0x002e }
        L_0x002e:
            r2.n = r4     // Catch:{ all -> 0x0056 }
            r2.o = r5     // Catch:{ all -> 0x0056 }
            r3 = 1
            r2.i = r3     // Catch:{ all -> 0x0056 }
            int r4 = r2.g     // Catch:{ all -> 0x0056 }
            if (r4 == r3) goto L_0x0051
            r3 = 2
            if (r4 == r3) goto L_0x004d
            r3 = 3
            if (r4 == r3) goto L_0x0049
            r3 = 4
            if (r4 == r3) goto L_0x0045
            r2.i = r0     // Catch:{ all -> 0x0056 }
            goto L_0x0058
        L_0x0045:
            r2.h()     // Catch:{ all -> 0x0056 }
            goto L_0x0058
        L_0x0049:
            r2.g()     // Catch:{ all -> 0x0056 }
            goto L_0x0058
        L_0x004d:
            r2.f()     // Catch:{ all -> 0x0056 }
            goto L_0x0058
        L_0x0051:
            r2.e()     // Catch:{ all -> 0x0056 }
            goto L_0x0058
        L_0x0055:
            return
        L_0x0056:
            r2.i = r0
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.a.d.a(com.bytedance.sdk.openadsdk.core.model.n, java.lang.String, int):void");
    }

    public void a() {
        try {
            int i2 = this.g;
            if (i2 == 1) {
                i();
            } else if (i2 == 2) {
                j();
            } else if (i2 == 3) {
                k();
            } else if (i2 == 4) {
                l();
            }
        } catch (Throwable unused) {
        }
    }

    private void e() {
        this.h = LayoutInflater.from(this.f).inflate(t.f(this.f, "tt_full_reward_video_loading"), (ViewGroup) null, false);
        this.a = (TTRoundRectImageView) this.h.findViewById(t.e(this.f, "tt_loading_icon"));
        this.b = (TextView) this.h.findViewById(t.e(this.f, "tt_loading_appname"));
        this.c = (ProgressBar) this.h.findViewById(t.e(this.f, "tt_loading_progressbar"));
        this.d = (TextView) this.h.findViewById(t.e(this.f, "tt_loading_progress_number"));
        this.m = (TextView) this.h.findViewById(t.e(this.f, "tt_ad_loading_logo"));
        if (this.o == 1 && this.e.aa() != null && !TextUtils.isEmpty(this.e.aa().b())) {
            this.b.setText(this.e.aa().b());
        } else if (!TextUtils.isEmpty(this.e.U())) {
            this.b.setText(this.e.U());
        } else {
            this.b.setVisibility(8);
        }
        m();
        this.m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTWebsiteActivity.a(d.this.f, d.this.e, d.this.n);
            }
        });
    }

    private void f() {
        this.h = LayoutInflater.from(this.f).inflate(t.f(this.f, "tt_full_reward_video_loading2"), (ViewGroup) null, false);
        this.a = (TTRoundRectImageView) this.h.findViewById(t.e(this.f, "tt_loading_icon"));
        this.d = (TextView) this.h.findViewById(t.e(this.f, "tt_loading_progress_number"));
        this.m = (TextView) this.h.findViewById(t.e(this.f, "tt_ad_loading_logo"));
        m();
        this.m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTWebsiteActivity.a(d.this.f, d.this.e, d.this.n);
            }
        });
    }

    private void g() {
        this.h = LayoutInflater.from(this.f).inflate(t.f(this.f, "tt_full_reward_video_loading3"), (ViewGroup) null, false);
        this.j = (LinearLayout) this.h.findViewById(t.e(this.f, "wave_container"));
        this.d = (TextView) this.h.findViewById(t.e(this.f, "tt_loading_progress_number"));
        this.m = (TextView) this.h.findViewById(t.e(this.f, "tt_ad_loading_logo"));
        this.m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTWebsiteActivity.a(d.this.f, d.this.e, d.this.n);
            }
        });
    }

    private void h() {
        this.h = LayoutInflater.from(this.f).inflate(t.f(this.f, "tt_full_reward_video_loading4"), (ViewGroup) null, false);
        this.k = (TwoSemicirclesView) this.h.findViewById(t.e(this.f, "inner_circle"));
        this.l = (TwoSemicirclesView) this.h.findViewById(t.e(this.f, "outer_circle"));
        this.k.setRadius(z.b(this.f, 80.0f));
        Paint paintTwo = this.k.getPaintTwo();
        paintTwo.setColor(Color.parseColor("#C4C4C4"));
        this.k.setPaintTwo(paintTwo);
        this.l.setRadius(z.b(this.f, 95.0f));
        Paint paintTwo2 = this.l.getPaintTwo();
        paintTwo2.setStrokeWidth(6.0f);
        paintTwo2.setColor(Color.parseColor("#118BFF"));
        this.l.setPaintTwo(paintTwo2);
        this.d = (TextView) this.h.findViewById(t.e(this.f, "tt_loading_progress_number"));
        this.m = (TextView) this.h.findViewById(t.e(this.f, "tt_ad_loading_logo"));
        this.m.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                TTWebsiteActivity.a(d.this.f, d.this.e, d.this.n);
            }
        });
    }

    private void i() {
        n();
    }

    private void j() {
        Context context = this.f;
        this.a.setAnimation(AnimationUtils.loadAnimation(context, t.l(context, "tt_loading_two_icon_scale")));
        n();
    }

    private void k() {
        this.p = new AnimatorSet();
        LinearLayout linearLayout = this.j;
        if (linearLayout != null) {
            ObjectAnimator duration = ObjectAnimator.ofFloat(linearLayout.getChildAt(0), "translationY", new float[]{-9.0f, 9.0f}).setDuration(300);
            duration.setRepeatMode(2);
            duration.setRepeatCount(-1);
            AnimatorSet.Builder play = this.p.play(duration);
            for (int i2 = 1; i2 < this.j.getChildCount(); i2++) {
                float f2 = i2 % 2 == 0 ? 9.0f : -9.0f;
                ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.j.getChildAt(i2), "translationY", new float[]{-f2, f2}).setDuration(300);
                duration2.setRepeatMode(2);
                duration2.setRepeatCount(-1);
                play = play.with(duration2);
            }
            this.p.start();
        }
        n();
    }

    private void l() {
        this.p = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.k, "rotation", new float[]{0.0f, 360.0f}).setDuration(1500);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatCount(-1);
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(this.l, "rotation", new float[]{0.0f, 360.0f}).setDuration(2500);
        duration2.setRepeatCount(-1);
        this.p.playTogether(new Animator[]{duration, duration2});
        this.p.start();
        n();
    }

    private void m() {
        if (this.e.M() == null || TextUtils.isEmpty(this.e.M().a())) {
            this.a.setVisibility(8);
            return;
        }
        try {
            a.a(this.e.M()).a((o) new o<Bitmap>() {
                public void a(k<Bitmap> kVar) {
                    if (kVar != null) {
                        try {
                            if (kVar.b() != null) {
                                d.this.a.setImageBitmap(kVar.b());
                                return;
                            }
                        } catch (Throwable unused) {
                            d.this.a.setVisibility(8);
                            return;
                        }
                    }
                    d.this.a.setVisibility(8);
                }

                public void a(int i, String str, Throwable th) {
                    d.this.a.setVisibility(8);
                }
            });
        } catch (Throwable unused) {
            this.a.setVisibility(8);
        }
    }

    private void n() {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{1, 80});
        ofInt.setDuration(2000);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (d.this.c != null) {
                    d.this.c.setProgress(intValue);
                }
                d.this.d.setText(String.valueOf(intValue));
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{81, 99});
        ofInt2.setDuration(3000);
        ofInt2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                if (d.this.c != null) {
                    d.this.c.setProgress(intValue);
                }
                d.this.d.setText(String.valueOf(intValue));
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofInt).before(ofInt2);
        animatorSet.start();
        this.q = new AnimatorSet();
        this.q.play(ofInt).before(ofInt2);
        this.q.start();
    }

    public void b() {
        AnimatorSet animatorSet = this.p;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.q;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
    }

    public View c() {
        return this.h;
    }

    public boolean d() {
        return this.i;
    }
}
