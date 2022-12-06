package com.bytedance.sdk.openadsdk.component.reward.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.reward.view.RatioImageView;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.e.a;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;
import com.com.bytedance.overseas.sdk.a.c;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: RewardFullTypeImage */
public class b extends a {
    protected View i;
    private boolean j = false;
    private int k = 33;
    private RatioImageView l;
    private TTRoundRectImageView m;
    private TextView n;
    private TextView o;
    private TextView p;
    private TTRatingBar2 q;
    /* access modifiers changed from: private */
    public TextView r;
    /* access modifiers changed from: private */
    public n s;
    /* access modifiers changed from: private */
    public String t = "fullscreen_interstitial_ad";

    public b(Activity activity, n nVar, int i2, int i3) {
        super(activity, nVar, i2, i3);
        boolean z = false;
        this.s = nVar;
        this.k = this.s.ad();
        this.j = this.e == 2 ? true : z;
    }

    private void d() {
        this.j = this.e == 2;
        if (this.j) {
            int i2 = this.k;
            if (i2 == 3) {
                f();
            } else if (i2 != 33) {
                j();
            } else {
                h();
            }
        } else {
            int i3 = this.k;
            if (i3 == 3) {
                e();
            } else if (i3 != 33) {
                i();
            } else {
                g();
            }
        }
    }

    private void e() {
        this.i = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_activity_full_image_model_3_191_v"), (ViewGroup) null, true);
        k();
    }

    private void f() {
        this.i = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_activity_full_image_model_3_191_h"), (ViewGroup) null, true);
        this.l = (RatioImageView) this.i.findViewById(t.e(this.a, "tt_ratio_image_view"));
        this.m = (TTRoundRectImageView) this.i.findViewById(t.e(this.a, "tt_full_ad_icon"));
        this.n = (TextView) this.i.findViewById(t.e(this.a, "tt_full_ad_app_name"));
        this.o = (TextView) this.i.findViewById(t.e(this.a, "tt_full_desc"));
        this.p = (TextView) this.i.findViewById(t.e(this.a, "tt_full_comment"));
        this.r = (TextView) this.i.findViewById(t.e(this.a, "tt_full_ad_download"));
        final View findViewById = this.i.findViewById(t.e(this.a, "tt_image_full_bar"));
        a((View) this.l);
        a((View) this.m);
        a((View) this.n);
        a((View) this.o);
        a((View) this.p);
        a((View) this.r);
        ((TextView) this.i.findViewById(t.e(this.a, "tt_ad_logo"))).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.a(b.this.a, b.this.s, b.this.t);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        this.r.post(new Runnable() {
            public void run() {
                int width = findViewById.getWidth() / 2;
                if (width >= z.c(m.a(), 90.0f)) {
                    ViewGroup.LayoutParams layoutParams = b.this.r.getLayoutParams();
                    if (layoutParams.width > 0) {
                        layoutParams.width = Math.min(width, layoutParams.width);
                        b.this.r.setLayoutParams(layoutParams);
                    }
                }
            }
        });
    }

    private void g() {
        this.i = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_activity_full_image_model_33_v"), (ViewGroup) null, true);
        k();
    }

    private void h() {
        this.i = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_activity_full_image_model_33_h"), (ViewGroup) null, true);
        k();
    }

    private void i() {
        this.i = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_activity_full_image_model_173_v"), (ViewGroup) null, true);
        this.l = (RatioImageView) this.i.findViewById(t.e(this.a, "tt_ratio_image_view"));
        this.m = (TTRoundRectImageView) this.i.findViewById(t.e(this.a, "tt_full_ad_icon"));
        this.n = (TextView) this.i.findViewById(t.e(this.a, "tt_full_ad_app_name"));
        this.o = (TextView) this.i.findViewById(t.e(this.a, "tt_full_desc"));
        this.r = (TextView) this.i.findViewById(t.e(this.a, "tt_full_ad_download"));
        a((View) this.l);
        a((View) this.m);
        a((View) this.n);
        a((View) this.o);
        a((View) this.r);
        ((TextView) this.i.findViewById(t.e(this.a, "tt_ad_logo"))).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.a(b.this.a, b.this.s, b.this.t);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void j() {
        this.i = LayoutInflater.from(this.a).inflate(t.f(this.a, "tt_activity_full_image_model_173_h"), (ViewGroup) null, true);
        k();
    }

    private void k() {
        View view = this.i;
        if (view != null) {
            this.l = (RatioImageView) view.findViewById(t.e(this.a, "tt_ratio_image_view"));
            this.m = (TTRoundRectImageView) this.i.findViewById(t.e(this.a, "tt_full_ad_icon"));
            this.n = (TextView) this.i.findViewById(t.e(this.a, "tt_full_ad_app_name"));
            this.o = (TextView) this.i.findViewById(t.e(this.a, "tt_full_desc"));
            this.p = (TextView) this.i.findViewById(t.e(this.a, "tt_full_comment"));
            this.q = (TTRatingBar2) this.i.findViewById(t.e(this.a, "tt_full_rb_score"));
            this.r = (TextView) this.i.findViewById(t.e(this.a, "tt_full_ad_download"));
            a((View) this.l);
            a((View) this.m);
            a((View) this.n);
            a((View) this.o);
            a((View) this.p);
            a((View) this.q);
            a((View) this.r);
            ((TextView) this.i.findViewById(t.e(this.a, "tt_ad_logo"))).setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    try {
                        TTWebsiteActivity.a(b.this.a, b.this.s, b.this.t);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    private void d(n nVar) {
        if (nVar != null) {
            RatioImageView ratioImageView = this.l;
            if (ratioImageView != null) {
                int i2 = this.k;
                if (i2 == 33) {
                    ratioImageView.setRatio(1.0f);
                } else if (i2 == 3) {
                    ratioImageView.setRatio(1.91f);
                } else {
                    ratioImageView.setRatio(0.56f);
                }
                a((ImageView) this.l);
            }
            if (!(this.m == null || this.s.M() == null || TextUtils.isEmpty(this.s.M().a()))) {
                d.a().a(this.s.M().a(), (ImageView) this.m);
            }
            TextView textView = this.n;
            if (textView != null) {
                textView.setText(a(this.s));
            }
            TextView textView2 = this.o;
            if (textView2 != null) {
                textView2.setText(b(this.s));
            }
            l();
            m();
        }
    }

    /* access modifiers changed from: protected */
    public String a(n nVar) {
        if (nVar == null) {
            return "";
        }
        if (nVar.aa() != null && !TextUtils.isEmpty(nVar.aa().b())) {
            return nVar.aa().b();
        }
        if (!TextUtils.isEmpty(nVar.K())) {
            return nVar.K();
        }
        if (!TextUtils.isEmpty(nVar.U())) {
            return nVar.U();
        }
        return "";
    }

    /* access modifiers changed from: protected */
    public String b(n nVar) {
        if (nVar == null) {
            return "";
        }
        if (!TextUtils.isEmpty(nVar.U())) {
            return nVar.U();
        }
        if (!TextUtils.isEmpty(nVar.V())) {
            return nVar.V();
        }
        return "";
    }

    private void a(ImageView imageView) {
        List<k> P;
        n nVar = this.s;
        if (nVar != null && (P = nVar.P()) != null && P.size() > 0) {
            a.a(P.get(0)).a(imageView);
        }
    }

    private void l() {
        TTRatingBar2 tTRatingBar2 = this.q;
        if (tTRatingBar2 != null) {
            z.a((TextView) null, tTRatingBar2, this.b, (Context) this.a);
        }
    }

    private void m() {
        n nVar;
        TextView textView = this.p;
        if (textView != null && (nVar = this.s) != null) {
            z.a(textView, nVar, (Context) this.a, "tt_comment_num_backup");
        }
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        com.bytedance.sdk.openadsdk.core.b.b bVar;
        if (view != null && this.a != null && this.s != null) {
            if (this.h == null) {
                Activity activity = this.a;
                n nVar = this.s;
                String str = this.t;
                bVar = new com.bytedance.sdk.openadsdk.core.b.a(activity, nVar, str, y.a(str));
                bVar.a(e(this.s));
                HashMap hashMap = new HashMap();
                if (p.i(this.b)) {
                    hashMap.put("click_scence", 3);
                } else {
                    hashMap.put("click_scence", 1);
                }
                bVar.a((Map<String, Object>) hashMap);
            } else {
                bVar = this.h;
            }
            if (this.a != null) {
                bVar.a(this.a);
            }
            view.setOnTouchListener(bVar);
            view.setOnClickListener(bVar);
        }
    }

    private c e(n nVar) {
        if (nVar.L() == 4) {
            return new com.com.bytedance.overseas.sdk.a.b(m.a(), nVar, this.t);
        }
        return null;
    }

    public void a(FrameLayout frameLayout) {
        d();
        d(this.s);
        frameLayout.addView(this.i);
    }

    public static boolean c(n nVar) {
        if (nVar != null && !n.c(nVar) && nVar.an() == 100.0f) {
            return true;
        }
        return false;
    }

    public boolean b() {
        return n();
    }

    public boolean c() {
        return n();
    }

    private boolean n() {
        n nVar = this.s;
        if (nVar != null && nVar.l() == 2) {
            return true;
        }
        return false;
    }

    public void a(com.bytedance.sdk.openadsdk.component.reward.a.c cVar, com.bytedance.sdk.openadsdk.component.reward.view.d dVar) {
        dVar.b(8);
        dVar.a(8);
        cVar.c(false);
        cVar.d(false);
        if (this.b.l() == 2) {
            cVar.a(false);
            dVar.d(8);
            return;
        }
        cVar.a(this.b.ap());
        dVar.d(0);
        cVar.d();
    }
}
