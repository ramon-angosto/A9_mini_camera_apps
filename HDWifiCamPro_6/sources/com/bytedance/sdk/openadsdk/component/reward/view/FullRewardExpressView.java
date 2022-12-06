package com.bytedance.sdk.openadsdk.component.reward.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.b.c;
import com.bytedance.sdk.component.adexpress.b.d;
import com.bytedance.sdk.component.adexpress.b.m;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.FullRewardExpressBackupView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.nativeexpress.i;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.z;

public class FullRewardExpressView extends NativeExpressView {
    public static float c = 100.0f;
    i a;
    FullRewardExpressBackupView b;

    public FullRewardExpressView(Context context, n nVar, AdSlot adSlot, String str, boolean z) {
        super(context, nVar, adSlot, str, z);
    }

    /* access modifiers changed from: protected */
    public void g() {
        this.l = true;
        this.j = new FrameLayout(this.f);
        addView(this.j, new FrameLayout.LayoutParams(-1, -1));
        super.g();
        if (getWebView() != null) {
            getWebView().setBackgroundColor(0);
        }
        h();
    }

    private void h() {
        setBackupListener(new c() {
            public boolean a(ViewGroup viewGroup, int i) {
                try {
                    ((NativeExpressView) viewGroup).p();
                    FullRewardExpressView.this.b = new FullRewardExpressBackupView(viewGroup.getContext());
                    FullRewardExpressView.this.b.a(FullRewardExpressView.this.i, (NativeExpressView) viewGroup);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        });
    }

    public void a(d<? extends View> dVar, m mVar) {
        if (this.i == null || !this.i.ba()) {
            if (dVar instanceof com.bytedance.sdk.openadsdk.core.nativeexpress.n) {
                com.bytedance.sdk.openadsdk.core.nativeexpress.n nVar = (com.bytedance.sdk.openadsdk.core.nativeexpress.n) dVar;
                if (nVar.p() != null) {
                    nVar.p().a((i) this);
                }
            }
            if (mVar != null && mVar.a()) {
                a(mVar);
            }
            super.a(dVar, mVar);
            return;
        }
        super.a(dVar, mVar);
    }

    public void setExpressVideoListenerProxy(i iVar) {
        this.a = iVar;
    }

    private void a(final m mVar) {
        if (mVar != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    FullRewardExpressView.this.b(mVar);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(m mVar) {
        if (mVar != null) {
            double d = mVar.d();
            double e = mVar.e();
            double f = mVar.f();
            double g = mVar.g();
            int b2 = (int) z.b(this.f, (float) d);
            int b3 = (int) z.b(this.f, (float) e);
            int b4 = (int) z.b(this.f, (float) f);
            int b5 = (int) z.b(this.f, (float) g);
            l.b("ExpressView", "videoWidth:" + f);
            l.b("ExpressView", "videoHeight:" + g);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.j.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(b4, b5);
            }
            layoutParams.width = b4;
            layoutParams.height = b5;
            layoutParams.topMargin = b3;
            layoutParams.leftMargin = b2;
            this.j.setLayoutParams(layoutParams);
            this.j.removeAllViews();
        }
    }

    public void a(boolean z) {
        l.b("FullRewardExpressView", "onMuteVideo,mute:" + z);
        i iVar = this.a;
        if (iVar != null) {
            iVar.a(z);
        }
        setSoundMute(z);
    }

    public void a() {
        l.b("FullRewardExpressView", "onSkipVideo");
        i iVar = this.a;
        if (iVar != null) {
            iVar.a();
        }
    }

    public void b() {
        i iVar = this.a;
        if (iVar != null) {
            iVar.b();
        }
    }

    public void a(int i) {
        l.b("FullRewardExpressView", "onChangeVideoState,stateType:" + i);
        i iVar = this.a;
        if (iVar != null) {
            iVar.a(i);
        }
    }

    public long c() {
        l.b("FullRewardExpressView", "onGetCurrentPlayTime");
        i iVar = this.a;
        if (iVar != null) {
            return iVar.c();
        }
        return 0;
    }

    public int d() {
        l.b("FullRewardExpressView", "onGetVideoState");
        i iVar = this.a;
        if (iVar != null) {
            return iVar.d();
        }
        return 0;
    }

    public void e() {
        i iVar = this.a;
        if (iVar != null) {
            iVar.e();
        }
    }

    public void a(View view, int i, com.bytedance.sdk.component.adexpress.c cVar) {
        if (i == -1 || cVar == null || i != 3) {
            super.a(view, i, cVar);
        } else {
            e();
        }
    }

    public FrameLayout getVideoFrameLayout() {
        if (q()) {
            return this.b.getVideoContainer();
        }
        return this.j;
    }

    public View getBackupContainerBackgroundView() {
        if (q()) {
            return this.b.getBackupContainerBackgroundView();
        }
        return null;
    }

    public void b(int i) {
        i iVar = this.a;
        if (iVar != null) {
            iVar.b(i);
        }
    }
}
