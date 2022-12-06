package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.b.e;
import com.bytedance.sdk.openadsdk.core.model.j;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.TTRoundRectImageView;
import com.bytedance.sdk.openadsdk.e.a;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;
import com.com.bytedance.overseas.sdk.a.b;
import com.com.bytedance.overseas.sdk.a.c;
import java.util.List;

public class FullInteractionStyleView extends BackupView {
    private float a;
    private boolean m;
    private int n;
    private int o;
    private int p = 1;
    private View q;
    private View r;
    private FrameLayout s;
    private e t;

    /* access modifiers changed from: protected */
    public void a(View view, int i, j jVar) {
    }

    public FullInteractionStyleView(Context context, String str) {
        super(context, str);
        this.b = context;
    }

    public void a(n nVar, float f, int i, int i2, int i3) {
        this.a = f;
        this.p = i;
        this.c = nVar;
        this.f = "fullscreen_interstitial_ad";
        this.n = i2;
        this.o = i3;
        a(this.i);
        b();
    }

    private void b() {
        this.g = (int) z.b(this.b, (float) this.n);
        this.h = (int) z.b(this.b, (float) this.o);
        int i = (int) (this.a * 1000.0f);
        if (this.p == 1) {
            if (i == 666) {
                e();
            } else if (i == 1000) {
                c();
            } else if (i == 1500) {
                k();
            } else if (i != 1777) {
                a(0.562f);
                l();
            } else {
                m();
            }
        } else if (i == 562) {
            i();
        } else if (i == 666) {
            g();
        } else if (i == 1000) {
            c();
        } else if (i != 1500) {
            a(1.777f);
            j();
        } else {
            h();
        }
    }

    private void c() {
        this.q = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_interaction_style_1_1"), this, true);
        d();
        f();
    }

    private void d() {
        this.s = (FrameLayout) this.q.findViewById(t.e(this.b, "tt_ad_container"));
        ImageView imageView = (ImageView) this.q.findViewById(t.e(this.b, "tt_full_img"));
        TTRoundRectImageView tTRoundRectImageView = (TTRoundRectImageView) this.q.findViewById(t.e(this.b, "tt_full_ad_icon"));
        TextView textView = (TextView) this.q.findViewById(t.e(this.b, "tt_full_ad_app_name"));
        TextView textView2 = (TextView) this.q.findViewById(t.e(this.b, "tt_full_ad_download"));
        LinearLayout linearLayout = (LinearLayout) this.q.findViewById(t.e(this.b, "tt_ad_logo_layout"));
        if (!TextUtils.isEmpty(this.c.W())) {
            textView2.setText(this.c.W());
        }
        a(this.s, imageView);
        if (this.c.M() != null && !TextUtils.isEmpty(this.c.M().a())) {
            d.a().a(this.c.M().a(), (ImageView) tTRoundRectImageView);
        }
        textView.setText(getTitle());
        b((View) this.s);
        b((View) imageView);
        b((View) tTRoundRectImageView);
        b((View) textView);
        b((View) textView2);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.a(FullInteractionStyleView.this.b, FullInteractionStyleView.this.c, FullInteractionStyleView.this.f);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void e() {
        this.q = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_interaction_style_2_3"), this, true);
        d();
        f();
    }

    private void f() {
        TextView textView = (TextView) this.q.findViewById(t.e(this.b, "tt_full_ad_desc"));
        if (textView != null) {
            textView.setText(getDescription());
            b((View) textView);
        }
    }

    private void g() {
        this.q = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_interaction_style_2_3_h"), this, true);
        d();
        f();
    }

    private void h() {
        this.q = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_interaction_style_3_2_h"), this, true);
        d();
    }

    private void i() {
        this.q = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_interaction_style_9_16_h"), this, true);
        d();
        f();
    }

    private void j() {
        this.q = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_interaction_style_16_9_h"), this, true);
        d();
    }

    private void k() {
        this.q = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_interaction_style_3_2"), this, true);
        this.s = (FrameLayout) this.q.findViewById(t.e(this.b, "tt_ad_container"));
        ImageView imageView = (ImageView) this.q.findViewById(t.e(this.b, "tt_bu_img"));
        TextView textView = (TextView) this.q.findViewById(t.e(this.b, "tt_bu_desc"));
        a(this.s, imageView);
        textView.setText(getDescription());
        b((View) this.s);
        b((View) imageView);
        b((View) textView);
        ((LinearLayout) this.q.findViewById(t.e(this.b, "tt_ad_logo_layout"))).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.a(FullInteractionStyleView.this.b, FullInteractionStyleView.this.c, FullInteractionStyleView.this.f);
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    private void a(FrameLayout frameLayout, ImageView imageView) {
        if (this.c != null) {
            boolean c = n.c(this.c);
            if (this.c.J() == null || !c) {
                a(imageView);
                z.a((View) imageView, 0);
                z.a((View) frameLayout, 8);
                return;
            }
            z.a((View) imageView, 8);
            z.a((View) frameLayout, 0);
        }
    }

    private void a(ImageView imageView) {
        List<k> P;
        if (this.c != null && (P = this.c.P()) != null && P.size() > 0) {
            a.a(P.get(0)).a(imageView);
        }
    }

    private void l() {
        this.q = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_interaction_style_9_16_v"), this, true);
        d();
    }

    private void m() {
        this.q = LayoutInflater.from(this.b).inflate(t.f(this.b, "tt_interaction_style_16_9_v"), this, true);
        d();
        f();
    }

    private void b(View view) {
        if (view != null) {
            com.bytedance.sdk.openadsdk.core.b.a aVar = this.t;
            if (aVar == null) {
                aVar = new com.bytedance.sdk.openadsdk.core.b.a(this.b, this.c, this.f, y.a(this.f));
                aVar.a(a(this.c, this.b));
            }
            view.setOnTouchListener(aVar);
            view.setOnClickListener(aVar);
        }
    }

    private c a(n nVar, Context context) {
        if (nVar != null && nVar.L() == 4) {
            return new b(context, nVar, this.f);
        }
        return null;
    }

    public View getInteractionStyleRootView() {
        return this.q;
    }

    public void setIsMute(boolean z) {
        this.m = z;
        View view = this.r;
        if (view != null && (view instanceof NativeVideoTsView)) {
            ((NativeVideoTsView) view).setIsQuiet(z);
        }
    }

    public FrameLayout getVideoContainer() {
        return this.s;
    }

    public void setDownloadListener(e eVar) {
        this.t = eVar;
    }

    private float getHeightDp() {
        return (float) z.c(this.b, (float) z.i(this.b));
    }

    private float getWidthDp() {
        return (float) z.c(this.b, (float) z.j(this.b));
    }

    private void a(float f) {
        float f2;
        float f3;
        int i;
        int i2;
        float heightDp = getHeightDp();
        float widthDp = getWidthDp();
        if (this.p == 2) {
            f2 = Math.max(heightDp, widthDp);
            f3 = Math.min(heightDp, widthDp);
        } else {
            f2 = Math.min(heightDp, widthDp);
            f3 = Math.max(heightDp, widthDp);
        }
        if (this.p != 2 && z.c((Activity) this.b)) {
            f3 -= (float) z.c(this.b, z.k(this.b));
        }
        int i3 = 20;
        int i4 = 0;
        if (this.p != 2) {
            if (!(f == 0.0f || f == 100.0f)) {
                float f4 = (float) 20;
                i = (int) Math.max((f3 - (((f2 - f4) - f4) / f)) / 2.0f, 0.0f);
                i2 = 20;
                i4 = 20;
                i3 = i;
                ((Activity) this.b).getWindow().getDecorView().setPadding((int) z.b(this.b, (float) i4), (int) z.b(this.b, (float) i), (int) z.b(this.b, (float) i2), (int) z.b(this.b, (float) i3));
            }
        } else if (!(f == 0.0f || f == 100.0f)) {
            float f5 = (float) 20;
            i2 = (int) Math.max((f2 - (((f3 - f5) - f5) * f)) / 2.0f, 0.0f);
            i4 = i2;
            i = 20;
            ((Activity) this.b).getWindow().getDecorView().setPadding((int) z.b(this.b, (float) i4), (int) z.b(this.b, (float) i), (int) z.b(this.b, (float) i2), (int) z.b(this.b, (float) i3));
        }
        i = 0;
        i2 = 0;
        i3 = 0;
        ((Activity) this.b).getWindow().getDecorView().setPadding((int) z.b(this.b, (float) i4), (int) z.b(this.b, (float) i), (int) z.b(this.b, (float) i2), (int) z.b(this.b, (float) i3));
    }
}
