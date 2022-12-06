package com.bytedance.sdk.openadsdk.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.a.c.a;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.activity.TTWebsiteActivity;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.core.model.n;

public class LandingPageLoadingLayout extends FrameLayout {
    /* access modifiers changed from: private */
    public e a;
    /* access modifiers changed from: private */
    public int b;
    private long c = 10;
    private Runnable d;
    private Runnable e;

    public LandingPageLoadingLayout(Context context) {
        super(context);
        c();
    }

    public LandingPageLoadingLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c();
    }

    public LandingPageLoadingLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        c();
    }

    private void c() {
        LayoutInflater.from(getContext()).inflate(t.f(getContext(), "tt_landing_page_loading_layout"), this, true);
        setVisibility(8);
    }

    public void a(n nVar, String str) {
        a(nVar, str, false);
    }

    public void a(final n nVar, final String str, boolean z) {
        k kVar;
        String[] strArr;
        String str2;
        int i;
        k kVar2 = null;
        if (nVar != null) {
            if (nVar.a() != null) {
                this.c = nVar.a().a();
            }
            String aI = nVar.aI();
            String[] aJ = nVar.aJ();
            i = nVar.aH();
            if (nVar.M() != null && !TextUtils.isEmpty(nVar.M().a())) {
                kVar2 = nVar.M();
            }
            kVar = kVar2;
            str2 = aI;
            strArr = aJ;
        } else {
            i = 0;
            str2 = null;
            strArr = null;
            kVar = null;
        }
        if (i == 1) {
            this.a = new d(getContext(), str2, strArr, kVar, nVar.a());
        } else {
            this.a = new c(getContext(), str2, strArr, kVar, nVar.a());
        }
        View e2 = this.a.e();
        if (e2.getParent() instanceof ViewGroup) {
            ((ViewGroup) e2.getParent()).removeView(e2);
        }
        addView(e2);
        View findViewById = findViewById(t.e(getContext(), "tt_ad_landing_page_loading_logo"));
        if (findViewById != null) {
            if (z) {
                findViewById.setVisibility(0);
            }
            findViewById.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    TTWebsiteActivity.a(LandingPageLoadingLayout.this.getContext(), nVar, str);
                }
            });
        }
    }

    public void a() {
        post(new Runnable() {
            public void run() {
                if (LandingPageLoadingLayout.this.a != null) {
                    LandingPageLoadingLayout.this.setVisibility(0);
                    LandingPageLoadingLayout.this.a.b();
                }
            }
        });
        if (this.d == null) {
            this.d = new Runnable() {
                public void run() {
                    LandingPageLoadingLayout.this.b();
                }
            };
        }
        postDelayed(this.d, this.c * 1000);
    }

    public void a(int i) {
        if (i == 100 || i - this.b >= 7) {
            this.b = i;
            if (a.b()) {
                b(this.b);
                return;
            }
            if (this.e == null) {
                this.e = new Runnable() {
                    public void run() {
                        LandingPageLoadingLayout landingPageLoadingLayout = LandingPageLoadingLayout.this;
                        landingPageLoadingLayout.b(landingPageLoadingLayout.b);
                    }
                };
            }
            post(this.e);
        }
    }

    /* access modifiers changed from: private */
    public void b(int i) {
        e eVar = this.a;
        if (eVar != null) {
            eVar.a(i);
        }
        if (i == 100) {
            b();
        }
    }

    public void b() {
        this.b = 0;
        e eVar = this.a;
        if (eVar != null) {
            removeView(eVar.e);
            this.a.d();
        }
        setVisibility(8);
        this.a = null;
        Runnable runnable = this.d;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        Runnable runnable2 = this.e;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
        }
        this.e = null;
        this.d = null;
    }
}
