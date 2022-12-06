package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.adexpress.b.d;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.l.w;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;
import com.bytedance.sdk.openadsdk.multipro.b.a;

public class NativeExpressVideoView extends NativeExpressView implements c.C0021c, c.d, i {
    int a = 1;
    boolean b = false;
    boolean c = true;
    int d;
    boolean e = true;
    private ExpressVideoView t;
    /* access modifiers changed from: private */
    public a u;
    private long v;
    private long w;

    public void b() {
    }

    public void e() {
    }

    public NativeExpressVideoView(Context context, n nVar, AdSlot adSlot, String str) {
        super(context, nVar, adSlot, str, false);
        i();
    }

    /* access modifiers changed from: protected */
    public void i() {
        this.j = new FrameLayout(this.f);
        this.d = this.i != null ? this.i.aW() : 0;
        c(this.d);
        h();
        addView(this.j, new FrameLayout.LayoutParams(-1, -1));
        super.g();
        if (getWebView() != null) {
            getWebView().setBackgroundColor(0);
        }
    }

    private void h() {
        try {
            this.u = new a();
            this.t = new ExpressVideoView(this.f, this.i, this.g, this.q);
            this.t.setShouldCheckNetChange(false);
            this.t.setControllerStatusCallBack(new NativeVideoTsView.b() {
                public void a(boolean z, long j, long j2, long j3, boolean z2) {
                    NativeExpressVideoView.this.u.a = z;
                    NativeExpressVideoView.this.u.e = j;
                    NativeExpressVideoView.this.u.f = j2;
                    NativeExpressVideoView.this.u.g = j3;
                    NativeExpressVideoView.this.u.d = z2;
                }
            });
            this.t.setVideoAdLoadListener(this);
            this.t.setVideoAdInteractionListener(this);
            if ("embeded_ad".equals(this.g)) {
                this.t.setIsAutoPlay(this.b ? this.h.isAutoPlay() : this.c);
            } else if ("open_ad".equals(this.g)) {
                this.t.setIsAutoPlay(true);
            } else {
                this.t.setIsAutoPlay(this.c);
            }
            if ("open_ad".equals(this.g)) {
                this.t.setIsQuiet(true);
            } else {
                this.t.setIsQuiet(m.d().b(String.valueOf(this.d)));
            }
            this.t.d();
        } catch (Exception unused) {
            this.t = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i) {
        int a2 = m.d().a(i);
        if (3 == a2) {
            this.b = false;
            this.c = false;
        } else if (4 == a2) {
            this.b = true;
        } else {
            int c2 = o.c(m.a());
            if (1 == a2) {
                this.b = false;
                this.c = y.c(c2);
            } else if (2 == a2) {
                if (y.d(c2) || y.c(c2) || y.e(c2)) {
                    this.b = false;
                    this.c = true;
                }
            } else if (5 == a2 && (y.c(c2) || y.e(c2))) {
                this.b = false;
                this.c = true;
            }
        }
        if (!this.c) {
            this.a = 3;
        }
        l.c("NativeVideoAdView", "mIsAutoPlay=" + this.c + ",status=" + a2);
    }

    public a getVideoModel() {
        return this.u;
    }

    public void setCanInterruptVideoPlay(boolean z) {
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            expressVideoView.setCanInterruptVideoPlay(z);
        }
    }

    private void setShowAdInteractionView(boolean z) {
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            expressVideoView.setShowAdInteractionView(z);
        }
    }

    public void a(d<? extends View> dVar, com.bytedance.sdk.component.adexpress.b.m mVar) {
        this.s = dVar;
        if ((this.s instanceof n) && ((n) this.s).p() != null) {
            ((n) this.s).p().a((i) this);
        }
        if (mVar != null && mVar.a()) {
            a(mVar);
        }
        super.a(dVar, mVar);
    }

    private void a(final com.bytedance.sdk.component.adexpress.b.m mVar) {
        if (mVar != null) {
            w.a((Runnable) new Runnable() {
                public void run() {
                    NativeExpressVideoView.this.b(mVar);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void b(com.bytedance.sdk.component.adexpress.b.m mVar) {
        if (mVar != null) {
            double d2 = mVar.d();
            double e2 = mVar.e();
            double f = mVar.f();
            double g = mVar.g();
            int b2 = (int) z.b(this.f, (float) d2);
            int b3 = (int) z.b(this.f, (float) e2);
            int b4 = (int) z.b(this.f, (float) f);
            int b5 = (int) z.b(this.f, (float) g);
            float min = Math.min(Math.min(z.b(this.f, mVar.i()), z.b(this.f, mVar.j())), Math.min(z.b(this.f, mVar.k()), z.b(this.f, mVar.l())));
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
            if (this.t != null) {
                this.j.addView(this.t);
                z.b((View) this.j, min);
                this.t.a(0, true, false);
                c(this.d);
                if (!o.d(this.f) && !this.c && this.e) {
                    this.t.e();
                }
                setShowAdInteractionView(false);
            }
        }
    }

    public void a(boolean z) {
        l.b("NativeExpressVideoView", "onMuteVideo,mute:" + z);
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            expressVideoView.setIsQuiet(z);
            setSoundMute(z);
        }
    }

    public void a() {
        l.b("NativeExpressVideoView", "onSkipVideo");
    }

    public void a(int i) {
        l.b("NativeExpressVideoView", "onChangeVideoState,stateType:" + i);
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView == null) {
            l.e("NativeExpressVideoView", "onChangeVideoState,ExpressVideoView is null !!!!!!!!!!!!");
        } else if (i == 1) {
            expressVideoView.a(0, true, false);
        } else if (i == 2 || i == 3) {
            this.t.setCanInterruptVideoPlay(true);
            this.t.performClick();
        } else if (i == 4) {
            expressVideoView.getNativeVideoController().f();
        } else if (i == 5) {
            expressVideoView.a(0, true, false);
        }
    }

    public void a(View view, int i, com.bytedance.sdk.component.adexpress.c cVar) {
        if (i != -1 && cVar != null) {
            if (i != 4) {
                if (i != 11) {
                    super.a(view, i, cVar);
                    return;
                }
            } else if ("draw_ad".equals(this.g)) {
                ExpressVideoView expressVideoView = this.t;
                if (expressVideoView != null) {
                    expressVideoView.performClick();
                    return;
                }
                return;
            }
            try {
                if (this.t != null) {
                    this.t.setCanInterruptVideoPlay(true);
                    this.t.performClick();
                    if (this.k) {
                        this.t.findViewById(t.e(this.t.getContext(), "tt_video_play")).setVisibility(0);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public long c() {
        return this.v;
    }

    public int d() {
        ExpressVideoView expressVideoView;
        if (this.a == 3 && (expressVideoView = this.t) != null) {
            expressVideoView.d();
        }
        ExpressVideoView expressVideoView2 = this.t;
        if (expressVideoView2 == null || !expressVideoView2.getNativeVideoController().r()) {
            return this.a;
        }
        return 1;
    }

    public void c_() {
        this.e = false;
        l.b("NativeExpressVideoView", "onVideoAdStartPlay");
        this.a = 2;
    }

    public void d_() {
        this.e = false;
        l.b("NativeExpressVideoView", "onVideoAdPaused");
        this.k = true;
        this.a = 3;
    }

    public void e_() {
        this.e = false;
        l.b("NativeExpressVideoView", "onVideoAdContinuePlay");
        this.k = false;
        this.a = 2;
    }

    public void a(long j, long j2) {
        this.e = false;
        int i = this.a;
        if (!(i == 5 || i == 3 || j <= this.v)) {
            this.a = 2;
        }
        this.v = j;
        this.w = j2;
        if (this.r != null && this.r.d() != null) {
            this.r.d().setTimeUpdate(((int) (j2 - j)) / 1000);
        }
    }

    public void a_() {
        this.e = false;
        l.b("NativeExpressVideoView", "onVideoComplete");
        this.a = 5;
        if (this.r != null && this.r.d() != null) {
            this.r.d().f();
        }
    }

    public void b_() {
        l.b("NativeExpressVideoView", "onVideoLoad");
    }

    public void a(int i, int i2) {
        l.b("NativeExpressVideoView", "onVideoError,errorCode:" + i + ",extraCode:" + i2);
        this.v = this.w;
        this.a = 4;
    }

    public void j() {
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            expressVideoView.l();
        }
    }

    public void k() {
        ExpressVideoView expressVideoView = this.t;
        if (expressVideoView != null) {
            expressVideoView.n();
        }
    }

    /* access modifiers changed from: protected */
    public ExpressVideoView getExpressVideoView() {
        return this.t;
    }
}
