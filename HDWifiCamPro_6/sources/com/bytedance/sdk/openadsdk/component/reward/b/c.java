package com.bytedance.sdk.openadsdk.component.reward.b;

import android.app.Activity;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.component.reward.b.a;
import com.bytedance.sdk.openadsdk.component.reward.view.FullInteractionStyleView;
import com.bytedance.sdk.openadsdk.component.reward.view.d;
import com.bytedance.sdk.openadsdk.core.model.n;

/* compiled from: RewardFullTypeInteraction */
public class c extends a {
    /* access modifiers changed from: private */
    public FullInteractionStyleView i;

    public c(Activity activity, n nVar, int i2, int i3) {
        super(activity, nVar, i2, i3);
    }

    public void a(FrameLayout frameLayout) {
        this.i = new FullInteractionStyleView(this.a, this.g);
        this.i.setDownloadListener(this.h);
        this.i.a(this.b, this.f, this.e, this.c, this.d);
        frameLayout.addView(this.i.getInteractionStyleRootView());
    }

    public static boolean a(n nVar) {
        return (nVar == null || nVar.an() == 100.0f) ? false : true;
    }

    public a.C0042a a() {
        return new a.C0042a() {
            public void a(boolean z) {
                if (c.this.i != null) {
                    c.this.i.setIsMute(z);
                }
            }
        };
    }

    public FrameLayout d() {
        FullInteractionStyleView fullInteractionStyleView = this.i;
        if (fullInteractionStyleView != null) {
            return fullInteractionStyleView.getVideoContainer();
        }
        return null;
    }

    public boolean b() {
        return e();
    }

    public boolean c() {
        return e();
    }

    public void a(com.bytedance.sdk.openadsdk.component.reward.a.c cVar, d dVar) {
        dVar.b(8);
        dVar.a(8);
        if (this.b.l() == 2) {
            cVar.a(false);
            cVar.c(false);
            cVar.d(false);
            dVar.d(8);
            return;
        }
        cVar.a(this.b.ap());
        cVar.c(e());
        cVar.d(e());
        if (e()) {
            dVar.d(8);
            return;
        }
        cVar.d();
        dVar.d(0);
    }

    private boolean e() {
        return n.c(this.b);
    }
}
