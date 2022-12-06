package com.bytedance.sdk.openadsdk.component.reward.view;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdWrapperListener;
import com.bytedance.sdk.openadsdk.core.EmptyView;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.d;
import com.bytedance.sdk.openadsdk.core.nativeexpress.e;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.l.z;
import com.com.bytedance.overseas.sdk.a.c;

/* compiled from: RewardFullExpressVideoLayout */
public class b {
    c a;
    Handler b;
    boolean c = false;
    boolean d = false;
    boolean e = false;
    private final Activity f;
    private n g;
    private String h;
    private FullRewardExpressView i;

    public b(Activity activity) {
        this.f = activity;
    }

    public void a(n nVar, AdSlot adSlot, String str, boolean z) {
        if (!this.e) {
            this.e = true;
            this.g = nVar;
            this.h = str;
            this.i = new FullRewardExpressView(this.f, nVar, adSlot, str, z);
        }
    }

    public FullRewardExpressView a() {
        return this.i;
    }

    public FrameLayout b() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView == null) {
            return null;
        }
        FrameLayout videoFrameLayout = fullRewardExpressView.getVideoFrameLayout();
        if (this.i.q()) {
            a(videoFrameLayout);
        }
        return videoFrameLayout;
    }

    public boolean c() {
        return this.c;
    }

    public void a(boolean z) {
        this.c = z;
    }

    public boolean d() {
        return this.d;
    }

    public void b(boolean z) {
        this.d = z;
    }

    public void a(e eVar, d dVar) {
        n nVar;
        if (this.i != null && (nVar = this.g) != null) {
            this.a = a(nVar);
            com.bytedance.sdk.openadsdk.c.c.a(this.g);
            EmptyView a2 = a((ViewGroup) this.i);
            if (a2 == null) {
                a2 = new EmptyView(this.f, this.i);
                this.i.addView(a2);
            }
            eVar.a((View) this.i);
            eVar.a(this.a);
            this.i.setClickListener(eVar);
            dVar.a((View) this.i);
            dVar.a(this.a);
            this.i.setClickCreativeListener(dVar);
            a2.setNeedCheckingShow(false);
        }
    }

    private c a(n nVar) {
        if (nVar.L() == 4) {
            return com.com.bytedance.overseas.sdk.a.d.a(this.f, nVar, this.h);
        }
        return null;
    }

    private EmptyView a(ViewGroup viewGroup) {
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt instanceof EmptyView) {
                return (EmptyView) childAt;
            }
        }
        return null;
    }

    public void a(i iVar) {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.setExpressVideoListenerProxy(iVar);
        }
    }

    public void a(PAGBannerAdWrapperListener pAGBannerAdWrapperListener) {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.setExpressInteractionListener(pAGBannerAdWrapperListener);
        }
    }

    public Handler e() {
        if (this.b == null) {
            this.b = new Handler(Looper.getMainLooper());
        }
        return this.b;
    }

    public void f() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.o();
        }
        Handler handler = this.b;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public void g() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.n();
        }
    }

    public boolean h() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView == null) {
            return false;
        }
        return fullRewardExpressView.q();
    }

    public int i() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            return fullRewardExpressView.getDynamicShowType();
        }
        return 0;
    }

    public void j() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.l();
        }
    }

    public void k() {
        FullRewardExpressView fullRewardExpressView = this.i;
        if (fullRewardExpressView != null) {
            fullRewardExpressView.m();
            this.i.n();
        }
    }

    public void a(FrameLayout frameLayout) {
        n nVar = this.g;
        if (nVar != null && n.c(nVar) && this.g.t() == 3 && this.g.v() == 0) {
            try {
                if (this.g.am() == 1) {
                    int b2 = (int) z.b(m.a(), 90.0f);
                    FrameLayout frameLayout2 = (FrameLayout) this.i.getBackupContainerBackgroundView();
                    if (frameLayout2 != null) {
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) frameLayout2.getLayoutParams();
                        layoutParams.bottomMargin = b2;
                        frameLayout2.setLayoutParams(layoutParams);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
