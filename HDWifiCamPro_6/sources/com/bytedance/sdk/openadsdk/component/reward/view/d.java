package com.bytedance.sdk.openadsdk.component.reward.view;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.o;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.component.reward.a.c;
import com.bytedance.sdk.openadsdk.component.reward.a.e;
import com.bytedance.sdk.openadsdk.core.b.g;
import com.bytedance.sdk.openadsdk.core.f.a;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.l;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.model.p;
import com.bytedance.sdk.openadsdk.core.settings.j;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.core.widget.c;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* compiled from: RewardFullVideoLayout */
public class d {
    /* access modifiers changed from: private */
    public String A;
    private int B;
    private boolean C = false;
    int a = 3;
    Activity b;
    n c;
    c d;
    public View e;
    RelativeLayout f;
    ImageView g;
    RelativeLayout h;
    TTRoundRectImageView i;
    TextView j;
    TextView k;
    TextView l;
    FrameLayout m;
    FrameLayout n;
    FrameLayout o;
    TTRatingBar2 p;
    TextView q;
    TextView r;
    RelativeLayout s;
    com.bytedance.sdk.openadsdk.component.reward.a.d t;
    boolean u = true;
    protected int v = 0;
    protected final AtomicBoolean w = new AtomicBoolean(false);
    public l x;
    Runnable y = new Runnable() {
        public void run() {
            try {
                if ((d.this.c == null || !d.this.c.ba()) && d.this.d != null && d.this.h != null) {
                    int[] iArr = new int[2];
                    d.this.h.getLocationOnScreen(iArr);
                    d.this.d.b(iArr[0]);
                }
            } catch (Exception unused) {
            }
        }
    };
    private boolean z;

    private void a(a aVar) {
    }

    /* access modifiers changed from: protected */
    public boolean a() {
        return true;
    }

    public d(Activity activity) {
        this.b = activity;
    }

    public void a(n nVar, String str, int i2, boolean z2, c cVar) {
        if (!this.C) {
            this.C = true;
            this.c = nVar;
            this.A = str;
            this.B = i2;
            this.z = z2;
            this.d = cVar;
            if (this.b != null && a()) {
                this.t = new com.bytedance.sdk.openadsdk.component.reward.a.d(this.b);
                this.t.a(nVar, this.A, this.B);
            }
            s();
            this.x = new l(this.b, this.c, str, this.m);
            this.x.a();
        }
    }

    private void s() {
        RelativeLayout relativeLayout;
        Activity activity = this.b;
        this.e = activity.findViewById(t.e(activity, "tt_reward_root"));
        Activity activity2 = this.b;
        this.f = (RelativeLayout) activity2.findViewById(t.e(activity2, "tt_video_reward_bar"));
        Activity activity3 = this.b;
        this.l = (TextView) activity3.findViewById(t.e(activity3, "tt_reward_ad_download"));
        int c2 = z.c(m.a());
        int d2 = z.d(m.a());
        if (this.B == 2) {
            this.l.setMaxWidth((int) (((double) Math.max(c2, d2)) * 0.45d));
        } else {
            this.l.setMaxWidth((int) (((double) Math.min(c2, d2)) * 0.45d));
        }
        Activity activity4 = this.b;
        this.i = (TTRoundRectImageView) activity4.findViewById(t.e(activity4, "tt_reward_ad_icon"));
        Activity activity5 = this.b;
        this.j = (TextView) activity5.findViewById(t.e(activity5, "tt_reward_ad_appname"));
        Activity activity6 = this.b;
        this.k = (TextView) activity6.findViewById(t.e(activity6, "tt_comment_vertical"));
        Activity activity7 = this.b;
        this.q = (TextView) activity7.findViewById(t.e(activity7, "tt_ad_logo"));
        Activity activity8 = this.b;
        this.g = (ImageView) activity8.findViewById(t.e(activity8, "tt_video_ad_close"));
        Activity activity9 = this.b;
        this.h = (RelativeLayout) activity9.findViewById(t.e(activity9, "tt_video_ad_close_layout"));
        Activity activity10 = this.b;
        this.m = (FrameLayout) activity10.findViewById(t.e(activity10, "tt_video_reward_container"));
        Activity activity11 = this.b;
        this.n = (FrameLayout) activity11.findViewById(t.e(activity11, "tt_click_upper_non_content_layout"));
        Activity activity12 = this.b;
        this.o = (FrameLayout) activity12.findViewById(t.e(activity12, "tt_click_lower_non_content_layout"));
        Activity activity13 = this.b;
        this.p = (TTRatingBar2) activity13.findViewById(t.e(activity13, "tt_rb_score"));
        Activity activity14 = this.b;
        this.s = (RelativeLayout) activity14.findViewById(t.e(activity14, "tt_full_reward_video_loading_container"));
        TTRatingBar2 tTRatingBar2 = this.p;
        if (tTRatingBar2 != null) {
            z.a((TextView) null, tTRatingBar2, this.c, (Context) this.b);
        }
        com.bytedance.sdk.openadsdk.component.reward.a.d dVar = this.t;
        if (!(dVar == null || !dVar.d() || this.t.c() == null || (relativeLayout = this.s) == null)) {
            relativeLayout.addView(this.t.c(), new LinearLayout.LayoutParams(-1, -1));
            this.t.a();
        }
        n nVar = this.c;
        if (nVar != null && nVar.aw()) {
            Activity activity15 = this.b;
            this.r = (TextView) activity15.findViewById(t.e(activity15, "tt_reward_ad_description"));
        }
    }

    public void a(String str, boolean z2) {
        g();
        z.a((View) this.q, p.i(this.c) ? 8 : 0);
        f();
        a(str);
        a(z2);
        d();
        if (this.z) {
            c();
        }
        n nVar = this.c;
        if (nVar != null && nVar.ax() != null) {
            a(this.c.ax());
        }
    }

    public void a(int i2, int i3) {
        FrameLayout frameLayout;
        if (!this.u) {
            a(4);
        }
        try {
            if (this.B == 2 && this.c.v() == 1) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.l.getLayoutParams();
                layoutParams.height = (int) z.b((Context) this.b, 55.0f);
                layoutParams.topMargin = (int) z.b((Context) this.b, 20.0f);
                this.l.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f.getLayoutParams();
                layoutParams2.bottomMargin = (int) z.b((Context) this.b, 12.0f);
                this.f.setLayoutParams(layoutParams2);
            }
        } catch (Throwable unused) {
        }
        n nVar = this.c;
        if (nVar != null && nVar.v() == 1 && (frameLayout = this.m) != null && (frameLayout.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
            int c2 = z.c((Context) this.b);
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.m.getLayoutParams();
            layoutParams3.width = c2;
            int i4 = (c2 * 9) / 16;
            layoutParams3.height = i4;
            this.m.setLayoutParams(layoutParams3);
            this.v = (z.d((Context) this.b) - i4) / 2;
            com.bytedance.sdk.component.utils.l.e("RewardFullVideoLayout", "NonContentAreaHeight:" + this.v);
        }
    }

    public void a(com.bytedance.sdk.openadsdk.core.b.c cVar, View.OnTouchListener onTouchListener, final View.OnClickListener onClickListener, final e eVar) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        n nVar;
        n nVar2 = this.c;
        if (!(nVar2 == null || nVar2.w() == null)) {
            if (this.c.v() != 5) {
                if (this.c.w().e) {
                    this.l.setOnClickListener(cVar);
                    this.l.setOnTouchListener(onTouchListener);
                } else {
                    this.l.setOnClickListener(onClickListener);
                }
            }
            if (this.c.v() == 1) {
                if (this.c.w().a) {
                    z.a((View) this.f, (View.OnClickListener) cVar, "TTBaseVideoActivity#mRlDownloadBar");
                    z.a((View) this.f, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
                    this.j.setOnClickListener(cVar);
                    this.j.setOnTouchListener(onTouchListener);
                    this.k.setOnClickListener(cVar);
                    this.k.setOnTouchListener(onTouchListener);
                    this.p.setOnClickListener(cVar);
                    this.p.setOnTouchListener(onTouchListener);
                    this.i.setOnClickListener(cVar);
                    this.i.setOnTouchListener(onTouchListener);
                } else {
                    z.a((View) this.f, onClickListener, "TTBaseVideoActivity#mRlDownloadBar");
                    this.j.setOnClickListener(onClickListener);
                    this.k.setOnClickListener(onClickListener);
                    this.p.setOnClickListener(onClickListener);
                    this.i.setOnClickListener(onClickListener);
                }
            } else if (this.c.v() == 5) {
                if (this.c.w().e) {
                    AnonymousClass1 r8 = new g("VAST_ACTION_BUTTON", this.c.ax(), cVar) {
                        public void a() {
                        }
                    };
                    AnonymousClass2 r0 = new g("VAST_ICON", this.c.ax(), cVar) {
                        public void a() {
                        }
                    };
                    TextView textView = this.l;
                    if (textView != null) {
                        textView.setOnClickListener(r8);
                        this.l.setOnTouchListener(r8);
                    }
                    TTRoundRectImageView tTRoundRectImageView = this.i;
                    if (tTRoundRectImageView != null) {
                        tTRoundRectImageView.setOnClickListener(r0);
                        this.i.setOnTouchListener(r0);
                    }
                    TextView textView2 = this.j;
                    if (textView2 != null && !TextUtils.isEmpty(textView2.getText())) {
                        this.j.setOnClickListener(r8);
                        this.j.setOnTouchListener(r8);
                    }
                    TextView textView3 = this.r;
                    if (textView3 != null && !TextUtils.isEmpty(textView3.getText())) {
                        this.r.setOnClickListener(r8);
                        this.r.setOnTouchListener(r8);
                    }
                } else {
                    AnonymousClass3 r02 = new View.OnClickListener() {
                        public void onClick(View view) {
                            View.OnClickListener onClickListener = onClickListener;
                            if (onClickListener != null) {
                                onClickListener.onClick(view);
                            }
                            if (view == null || !"VAST_ICON".equals(view.getTag(t.e(m.a(), "tt_id_vast_click_type")))) {
                                if (d.this.c != null && d.this.c.ax() != null) {
                                    d.this.c.ax().a().g(eVar.s());
                                }
                            } else if (d.this.c != null && d.this.c.ax() != null && d.this.c.ax().b() != null) {
                                d.this.c.ax().b().a(eVar.s());
                            }
                        }
                    };
                    TextView textView4 = this.l;
                    if (textView4 != null) {
                        textView4.setOnClickListener(r02);
                    }
                    TextView textView5 = this.j;
                    if (textView5 != null && !TextUtils.isEmpty(textView5.getText())) {
                        this.j.setOnClickListener(r02);
                    }
                    TextView textView6 = this.r;
                    if (textView6 != null && !TextUtils.isEmpty(textView6.getText())) {
                        this.r.setOnClickListener(r02);
                    }
                    TTRoundRectImageView tTRoundRectImageView2 = this.i;
                    if (tTRoundRectImageView2 != null) {
                        tTRoundRectImageView2.setTag(t.e(m.a(), "tt_id_vast_click_type"), "VAST_ICON");
                        this.i.setOnClickListener(onClickListener);
                    }
                }
            } else if (this.c.w().c) {
                z.a((View) this.f, (View.OnClickListener) cVar, "TTBaseVideoActivity#mRlDownloadBar");
                z.a((View) this.f, onTouchListener, "TTBaseVideoActivity#mRlDownloadBar");
            } else {
                z.a((View) this.f, onClickListener, "TTBaseVideoActivity#mRlDownloadBar");
            }
        }
        if (!(this.m == null || (nVar = this.c) == null || nVar.w() == null)) {
            if (!this.c.w().f || l.b(this.c)) {
                a(onClickListener);
            } else {
                a((View.OnClickListener) cVar);
                a(cVar);
            }
        }
        n nVar3 = this.c;
        if (nVar3 != null && nVar3.v() == 1) {
            if (!(this.c.w() == null || (frameLayout2 = this.n) == null)) {
                z.a((View) frameLayout2, 0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.n.getLayoutParams();
                layoutParams.height = this.v;
                this.n.setLayoutParams(layoutParams);
                if (this.c.w().b) {
                    this.n.setOnClickListener(cVar);
                    this.n.setOnTouchListener(onTouchListener);
                } else {
                    this.n.setOnClickListener(onClickListener);
                }
            }
            if (!(this.c.w() == null || (frameLayout = this.o) == null)) {
                z.a((View) frameLayout, 0);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.o.getLayoutParams();
                layoutParams2.height = this.v;
                this.o.setLayoutParams(layoutParams2);
                if (this.c.w().d) {
                    this.o.setOnClickListener(cVar);
                    this.o.setOnTouchListener(onTouchListener);
                } else {
                    this.o.setOnClickListener(onClickListener);
                }
            }
        }
        TextView textView7 = this.q;
        if (textView7 != null) {
            textView7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    com.bytedance.sdk.component.utils.l.c("mAdLogo", "mAdLogo,,,,,,,onClick,,,,,");
                    try {
                        TTWebsiteActivity.a(d.this.b, d.this.c, d.this.A);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }

    public void b() {
        z.a((View) this.m, 8);
        z.a((View) this.n, 8);
        z.a((View) this.o, 8);
        z.a((View) this.f, 8);
        z.a((View) this.j, 8);
        z.a((View) this.i, 8);
        z.a((View) this.k, 8);
        z.a((View) this.p, 8);
        z.a((View) this.g, 8);
        z.a((View) this.h, 8);
        z.a((View) this.l, 8);
        z.a((View) this.q, 8);
        z.a((View) this.s, 8);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        this.a = this.c.z();
        if (this.a == -200) {
            j d2 = m.d();
            this.a = d2.l(this.c.aW() + "");
        }
        if (this.a == -1 && this.u) {
            z.a((View) this.f, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.c.v() == 3) {
            int[] iArr = {Color.parseColor("#0070FF")};
            c.a e2 = new c.a().a(iArr[0]).b(Color.parseColor("#80000000")).a(iArr).c((int) z.b((Context) this.b, 17.0f)).d(0).e((int) z.b((Context) this.b, 3.0f));
            Activity activity = this.b;
            com.bytedance.sdk.openadsdk.core.widget.c.a((LinearLayout) activity.findViewById(t.e(activity, "tt_reward_ad_download_layout")), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (this.B == 1) {
            TextView textView = this.j;
            if (textView != null) {
                textView.setMaxWidth((int) z.b((Context) this.b, 153.0f));
            }
        } else {
            TextView textView2 = this.j;
            if (textView2 != null) {
                textView2.setMaxWidth((int) z.b((Context) this.b, 404.0f));
            }
            RelativeLayout relativeLayout = this.h;
            if (relativeLayout != null && z2) {
                ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    int b2 = b("status_bar_height");
                    int b3 = b("navigation_bar_height");
                    if (b2 > 0) {
                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (b2 > marginLayoutParams.topMargin) {
                            marginLayoutParams.topMargin = b2;
                            this.d.a(b2);
                        }
                    }
                    if (b3 > 0) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
                        if (b3 > marginLayoutParams2.rightMargin) {
                            marginLayoutParams2.rightMargin = b3;
                        }
                    }
                }
            }
        }
        if (!this.z) {
            z.a((View) this.f, 0);
        }
    }

    private int b(String str) {
        Resources resources = this.b.getResources();
        if (resources != null) {
            return resources.getDimensionPixelSize(resources.getIdentifier(str, "dimen", "android"));
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        TextView textView;
        if (!this.c.aw()) {
            TextView textView2 = this.l;
            if (textView2 != null) {
                if (this.c.v() == 3) {
                    str = e();
                }
                textView2.setText(str);
            }
        } else if (this.c.ax() != null && TextUtils.isEmpty(this.c.ax().f()) && (textView = this.l) != null) {
            z.a((View) textView, 8);
        }
    }

    /* access modifiers changed from: protected */
    public String e() {
        boolean z2;
        String g2 = y.g((Context) this.b);
        if (g2 == null) {
            g2 = "";
        }
        try {
            z2 = g2.equals(Locale.ENGLISH.getLanguage());
        } catch (Throwable unused) {
            z2 = false;
        }
        n nVar = this.c;
        String str = "Install";
        if (nVar == null) {
            return str;
        }
        if (!TextUtils.isEmpty(nVar.W())) {
            str = this.c.W();
            if (str == null || !y.f(str) || str.length() <= 2) {
                if (str != null && !y.f(str) && str.length() > 7 && z2) {
                    str = t();
                }
            } else if (z2) {
                str = t();
            }
        } else if (this.c.L() != 4) {
            str = "View";
        }
        if (z2 && !y.f(str)) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.l.getLayoutParams();
            layoutParams.bottomMargin = (int) z.b((Context) this.b, 4.0f);
            this.l.setLayoutParams(layoutParams);
        }
        return str;
    }

    private String t() {
        n nVar = this.c;
        if (nVar == null) {
            return null;
        }
        return nVar.L() != 4 ? "View" : "Install";
    }

    /* access modifiers changed from: protected */
    public void f() {
        TextView textView = this.k;
        if (textView != null) {
            z.a(textView, this.c, (Context) this.b, "tt_comment_num");
        }
    }

    /* access modifiers changed from: protected */
    public void g() {
        if (!(this.i == null || this.c.M() == null || TextUtils.isEmpty(this.c.M().a()))) {
            final String a2 = this.c.M().a();
            if (this.c.aw()) {
                com.bytedance.sdk.openadsdk.e.a.a(this.c.M()).a(u.BITMAP).a((o) new o<Bitmap>() {
                    public void a(k<Bitmap> kVar) {
                        if (kVar != null && kVar.b() != null && d.this.i != null) {
                            d.this.i.setImageBitmap(kVar.b());
                        }
                    }

                    public void a(int i, String str, Throwable th) {
                        d.this.a(i, str, a2);
                    }
                });
                if (!(this.c.ax() == null || this.c.ax().b() == null)) {
                    this.c.ax().b().b(0);
                }
            } else {
                com.bytedance.sdk.openadsdk.i.d.a().a(this.c.M(), (ImageView) this.i);
            }
        }
        if (this.j != null) {
            if (this.B != 1 || this.c.aa() == null || TextUtils.isEmpty(this.c.aa().b())) {
                this.j.setText(this.c.U());
            } else {
                this.j.setText(this.c.aa().b());
            }
        }
        TextView textView = this.r;
        if (textView != null) {
            textView.setText(this.c.V());
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str, String str2) {
        final int i3 = i2;
        final String str3 = str;
        final String str4 = str2;
        com.bytedance.sdk.openadsdk.c.c.a((com.bytedance.sdk.component.g.g) new com.bytedance.sdk.component.g.g("load_vast_icon_fail") {
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("code", i3);
                    jSONObject.put("description", i3 + ":" + str3);
                    jSONObject.put("link", str4);
                } catch (Throwable unused) {
                }
                com.bytedance.sdk.openadsdk.c.c.b((Context) d.this.b, d.this.c, d.this.A, "load_vast_icon_fail", jSONObject);
            }
        });
    }

    public void b(boolean z2) {
        this.u = z2;
    }

    public void a(int i2) {
        z.a((View) this.f, i2);
    }

    public int a(n nVar) {
        int f2 = t.f(this.b, "tt_activity_full_reward_video_default_style");
        if (l.b(nVar)) {
            nVar.k(4);
            return t.f(this.b, "tt_activity_full_reward_video_landingpage_style");
        } else if (l.c(nVar)) {
            nVar.k(4);
            return t.f(this.b, "tt_activity_full_reward_landingpage_style");
        } else {
            int v2 = nVar.v();
            if (v2 == 0) {
                return t.f(this.b, "tt_activity_full_reward_video_default_style");
            }
            if (v2 == 1) {
                return p.i(this.c) ? t.f(this.b, "tt_activity_full_reward_video_default_style") : t.f(this.b, "tt_activity_full_reward_video_no_bar_style");
            } else if (v2 == 3) {
                return t.f(this.b, "tt_activity_full_reward_video_new_bar_style");
            } else {
                if (v2 != 5) {
                    return f2;
                }
                return t.f(this.b, "tt_activity_full_reward_video_vast_bar_style");
            }
        }
    }

    public FrameLayout h() {
        return this.m;
    }

    public void b(int i2) {
        z.a((View) this.q, i2);
    }

    public void c(int i2) {
        int i3 = this.a;
        if (i3 != -1 && i2 == i3 && !this.w.get()) {
            this.f.setVisibility(0);
            this.w.set(true);
            i();
        }
    }

    /* access modifiers changed from: protected */
    public void i() {
        if (this.f != null) {
            Keyframe ofFloat = Keyframe.ofFloat(0.0f, 0.0f);
            Keyframe ofFloat2 = Keyframe.ofFloat(0.65f, 1.0f);
            Keyframe ofFloat3 = Keyframe.ofFloat(0.765f, 0.9f);
            Keyframe ofFloat4 = Keyframe.ofFloat(0.88f, 1.0f);
            Keyframe ofFloat5 = Keyframe.ofFloat(0.95f, 0.95f);
            Keyframe ofFloat6 = Keyframe.ofFloat(1.0f, 1.0f);
            PropertyValuesHolder ofKeyframe = PropertyValuesHolder.ofKeyframe("scaleX", new Keyframe[]{ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6});
            PropertyValuesHolder ofKeyframe2 = PropertyValuesHolder.ofKeyframe("scaleY", new Keyframe[]{ofFloat, ofFloat2, ofFloat3, ofFloat4, ofFloat5, ofFloat6});
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(this.f, new PropertyValuesHolder[]{ofKeyframe, ofKeyframe2});
            ofPropertyValuesHolder.setDuration(1000);
            ofPropertyValuesHolder.start();
        }
    }

    public void d(int i2) {
        z.a((View) this.g, i2);
        z.a((View) this.h, i2);
        RelativeLayout relativeLayout = this.h;
        if (relativeLayout != null) {
            relativeLayout.post(this.y);
        }
    }

    public boolean j() {
        ImageView imageView = this.g;
        if (imageView == null || this.h == null || imageView.getVisibility() != 0 || this.h.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    public void a(View.OnClickListener onClickListener) {
        z.a((View) this.m, onClickListener, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    private void a(com.bytedance.sdk.openadsdk.core.b.c cVar) {
        z.a((View) this.m, (View.OnTouchListener) cVar, "TTBaseVideoActivity#mVideoNativeFrame");
    }

    public View k() {
        return this.h;
    }

    public View l() {
        return this.f;
    }

    public void a(float f2) {
        z.a((View) this.g, f2);
        z.a((View) this.h, f2);
    }

    public void a(Animation animation) {
        RelativeLayout relativeLayout = this.s;
        if (relativeLayout != null) {
            relativeLayout.setAnimation(animation);
        }
    }

    public void m() {
        try {
            if (this.t != null) {
                this.t.b();
            }
            if (this.e != null && this.s != null) {
                ((ViewGroup) this.e).removeView(this.s);
            }
        } catch (Throwable unused) {
            RelativeLayout relativeLayout = this.s;
            if (relativeLayout != null) {
                relativeLayout.setAlpha(0.0f);
            }
        }
    }

    public void n() {
        l lVar = this.x;
        if (lVar != null) {
            lVar.e();
        }
        RelativeLayout relativeLayout = this.h;
        if (relativeLayout != null) {
            relativeLayout.removeCallbacks(this.y);
        }
    }

    public void o() {
        l lVar = this.x;
        if (lVar != null) {
            lVar.f();
        }
    }

    public void p() {
        l lVar = this.x;
        if (lVar != null) {
            lVar.g();
        }
    }

    public void q() {
        l lVar = this.x;
        if (lVar != null) {
            lVar.h();
        }
    }

    public void r() {
        RelativeLayout relativeLayout = this.f;
        if (relativeLayout != null) {
            ViewGroup.LayoutParams layoutParams = relativeLayout.getLayoutParams();
            layoutParams.width = -1;
            this.f.setLayoutParams(layoutParams);
            this.f.setVisibility(0);
        }
    }
}
