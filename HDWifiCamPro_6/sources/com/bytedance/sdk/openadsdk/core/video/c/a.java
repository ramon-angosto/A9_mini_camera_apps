package com.bytedance.sdk.openadsdk.core.video.c;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.a.a.a.a.b.g;
import com.bykv.vk.openvk.component.video.a.d.d;
import com.bykv.vk.openvk.component.video.api.a;
import com.bykv.vk.openvk.component.video.api.d.b;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.v;
import com.bytedance.sdk.openadsdk.core.f.f;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.e;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.l.z;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.Map;

/* compiled from: BaseVideoController */
public abstract class a extends com.bytedance.sdk.openadsdk.core.video.a.a {
    a.C0020a A;
    private final ViewGroup B;
    /* access modifiers changed from: private */
    public long C = 0;
    /* access modifiers changed from: private */
    public long D = 0;
    /* access modifiers changed from: private */
    public c.a E;
    /* access modifiers changed from: private */
    public boolean F;
    private boolean G;
    private boolean H;
    private WeakReference<c.b> I;
    private int J;
    /* access modifiers changed from: private */
    public boolean K;
    private boolean L;
    /* access modifiers changed from: private */
    public long M;
    private boolean N;
    /* access modifiers changed from: private */
    public boolean O;
    /* access modifiers changed from: private */
    public final Runnable P;
    private long Q;
    private final BroadcastReceiver R;
    private final v.a S;
    private int T;
    private boolean U;
    protected Map<String, Object> s;
    protected long t;
    protected long u;
    protected boolean v;
    protected boolean w;
    protected com.bykv.vk.openvk.component.video.api.c.c x;
    protected boolean y;
    f z;

    /* access modifiers changed from: protected */
    public abstract void a(int i, int i2);

    public void a(b bVar, View view, boolean z2) {
    }

    public void a(c.d dVar) {
    }

    public void d(boolean z2) {
    }

    /* access modifiers changed from: protected */
    public abstract int t();

    /* access modifiers changed from: protected */
    public abstract void u();

    /* access modifiers changed from: protected */
    public abstract void v();

    /* access modifiers changed from: protected */
    public abstract void w();

    /* access modifiers changed from: protected */
    public abstract void x();

    /* access modifiers changed from: protected */
    public abstract void y();

    /* access modifiers changed from: protected */
    public abstract void z();

    public void H() {
        a.C0020a aVar = this.A;
        if (aVar != null) {
            aVar.a((com.bykv.vk.openvk.component.video.api.a) null, 0, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void g(boolean z2) {
        try {
            l.c("changeVideoSize", "landingPageChangeVideoSize start.......mMaterialMeta.getAdSlot()=" + this.e.x());
            if (!T() || z2) {
                l.c("changeVideoSize", "landingPageChangeVideoSize start check condition complete ... go ..");
                float j = (float) this.c.j();
                float k = (float) this.c.k();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) j, (int) k);
                layoutParams.addRule(13);
                if (J() != null) {
                    if (J() instanceof TextureView) {
                        ((TextureView) J()).setLayoutParams(layoutParams);
                    } else if (J() instanceof SurfaceView) {
                        ((SurfaceView) J()).setLayoutParams(layoutParams);
                    }
                    ViewGroup.LayoutParams layoutParams2 = this.B.getLayoutParams();
                    if (this.B.getHeight() > 0) {
                        float min = Math.min(((float) this.B.getWidth()) / j, ((float) this.B.getHeight()) / k);
                        if (layoutParams2 != null) {
                            layoutParams.width = (int) (j * min);
                            layoutParams.height = (int) (k * min);
                            if (J() instanceof TextureView) {
                                ((TextureView) J()).setLayoutParams(layoutParams);
                            } else if (J() instanceof SurfaceView) {
                                ((SurfaceView) J()).setLayoutParams(layoutParams);
                            }
                            if (this.O) {
                                layoutParams2.width = layoutParams.width;
                                layoutParams2.height = layoutParams.height;
                                this.B.setLayoutParams(layoutParams2);
                            }
                        }
                    }
                }
                l.b("changeVideoSize", "changeVideoSize .... complete ... end !!!");
            }
        } catch (Throwable th) {
            l.c("changeVideoSize", "changeSize error", th);
        }
    }

    private void a(Context context) {
        EnumSet<E> noneOf = EnumSet.noneOf(b.a.class);
        noneOf.add(b.a.hideCloseBtn);
        noneOf.add(b.a.hideBackBtn);
        this.d = new e(context.getApplicationContext(), LayoutInflater.from(context.getApplicationContext()).inflate(t.f(context, "tt_video_play_layout_for_live"), (ViewGroup) null, false), true, noneOf, this.e, this);
        this.d.a((com.bykv.vk.openvk.component.video.api.d.a) this);
    }

    protected a(Context context, ViewGroup viewGroup, n nVar) {
        int i = 0;
        this.F = false;
        this.G = false;
        this.H = false;
        this.s = null;
        this.t = 0;
        this.u = 0;
        this.v = false;
        this.w = false;
        this.K = false;
        this.L = true;
        this.N = false;
        this.A = new a.C0020a() {
            public void a(com.bykv.vk.openvk.component.video.api.a aVar) {
                l.c("CSJ_VIDEO_BaseController", "IVideoPlayerCallback onCompletion: ");
                a.this.k.post(new Runnable() {
                    public void run() {
                        a.this.Q();
                        if (a.this.z != null) {
                            a.this.z.a(9);
                        }
                    }
                });
                if (!(a.this.e.ax() == null || a.this.e.ax().a() == null)) {
                    a.this.e.ax().a().d(a.this.g());
                    a.this.e.ax().a().e(a.this.g());
                }
                com.bytedance.sdk.openadsdk.k.a.e.a(a.this.e, 5);
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, final long j) {
                l.c("CSJ_VIDEO_BaseController", "IVideoPlayerCallback onRenderStart: ");
                a.this.k.post(new Runnable() {
                    public void run() {
                        if (a.this.d != null) {
                            a.this.d.b();
                            a.this.k.removeCallbacks(a.this.P);
                            boolean unused = a.this.K = false;
                        }
                        if (!a.this.F) {
                            a.this.u = j;
                            a.this.x();
                            a.this.X();
                            boolean unused2 = a.this.F = true;
                            a.this.w = true;
                        }
                        com.bytedance.sdk.openadsdk.k.a.e.a(a.this.e, 0);
                        if (a.this.z != null) {
                            a.this.z.c();
                        }
                    }
                });
                long unused = a.this.M = System.currentTimeMillis();
            }

            public void b(com.bykv.vk.openvk.component.video.api.a aVar) {
                l.c("CSJ_VIDEO_BaseController", "IVideoPlayerCallback onPrepared: ");
                a.this.k.post(new Runnable() {
                    public void run() {
                        if (a.this.k != null) {
                            a.this.k.removeCallbacks(a.this.P);
                        }
                        if (a.this.d != null) {
                            a.this.d.b();
                        }
                        if (a.this.z != null) {
                            a.this.z.a(a.this.j(), a.this.p());
                        }
                    }
                });
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, final com.bykv.vk.openvk.component.video.api.c.a aVar2) {
                l.c("CSJ_VIDEO_BaseController", "IVideoPlayerCallback onError: ");
                if (aVar2 != null) {
                    a.this.k.post(new Runnable() {
                        public void run() {
                            a.this.a(aVar2.a(), aVar2.b());
                            a.this.k.removeCallbacks(a.this.P);
                            if (a.this.d != null) {
                                a.this.d.b();
                            }
                            if (a.this.E != null) {
                                a.this.E.b(a.this.D, com.bykv.vk.openvk.component.video.a.e.a.a(a.this.f, a.this.q));
                            }
                            com.bytedance.sdk.openadsdk.k.a.e.a(a.this.e, 6);
                            if (a.this.z != null) {
                                a.this.z.a(14);
                            }
                        }
                    });
                    aVar2.a();
                    aVar2.c();
                }
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, boolean z) {
                l.c("CSJ_VIDEO_BaseController", "IVideoPlayerCallback onSeekCompletion: ");
                a.this.k.post(new Runnable() {
                    public void run() {
                        a.this.k.removeCallbacks(a.this.P);
                        if (a.this.d != null) {
                            a.this.d.b();
                        }
                    }
                });
            }

            public void c(com.bykv.vk.openvk.component.video.api.a aVar) {
                l.c("CSJ_VIDEO_BaseController", "IVideoPlayerCallback onRelease: ");
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2) {
                l.c("CSJ_VIDEO_BaseController", "IVideoPlayerCallback onVideoSizeChanged: ");
                a.this.k.post(new Runnable() {
                    public void run() {
                        if (!a.this.R()) {
                            a.this.S();
                        } else if (a.this.e != null && (com.bytedance.sdk.openadsdk.core.model.l.b(a.this.e) || a.this.O)) {
                            a.this.g(true);
                        } else if (a.this.e != null && a.this.e.t() == 3) {
                            a.this.g(true);
                        } else if (a.this.e == null || a.this.e.t() != 0) {
                            a.this.U();
                        } else {
                            a.this.V();
                        }
                    }
                });
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2, int i3) {
                l.c("CSJ_VIDEO_BaseController", "IVideoPlayerCallback onBufferStart: ");
                a.this.k.post(new Runnable() {
                    public void run() {
                        if (a.this.d != null) {
                            a.this.d.u();
                            a.this.P();
                            boolean unused = a.this.K = true;
                        }
                        com.bytedance.sdk.openadsdk.k.a.e.a(a.this.e, 3);
                        if (a.this.z != null) {
                            a.this.z.a(4);
                        }
                    }
                });
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
                l.c("CSJ_VIDEO_BaseController", "IVideoPlayerCallback onBufferEnd: ");
                a.this.k.post(new Runnable() {
                    public void run() {
                        if (a.this.d != null) {
                            a.this.d.b();
                            a.this.k.removeCallbacks(a.this.P);
                            boolean unused = a.this.K = false;
                        }
                        com.bytedance.sdk.openadsdk.k.a.e.a(a.this.e, 0);
                        if (a.this.z != null) {
                            a.this.z.a(5);
                        }
                    }
                });
            }

            public void b(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
                l.c("CSJ_VIDEO_BaseController", "IVideoPlayerCallback onBufferingUpdate: ");
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, long j, long j2) {
                if (Math.abs(j - a.this.f) >= 50) {
                    final long j3 = j;
                    final long j4 = j2;
                    a.this.k.post(new Runnable() {
                        public void run() {
                            a.this.a(j3, j4);
                        }
                    });
                    if (a.this.e.ax() != null && a.this.e.ax().a() != null) {
                        a.this.e.ax().a().a(j, j2, a.this.z);
                    }
                }
            }

            public void d(com.bykv.vk.openvk.component.video.api.a aVar) {
                com.bytedance.sdk.openadsdk.k.a.e.a(a.this.e, 3);
                if (a.this.z != null) {
                    a.this.k.post(new Runnable() {
                        public void run() {
                            if (a.this.z != null) {
                                a.this.z.a(0);
                            }
                        }
                    });
                }
            }

            public void e(com.bykv.vk.openvk.component.video.api.a aVar) {
                com.bytedance.sdk.openadsdk.k.a.e.a(a.this.e, 0);
                if (a.this.z != null) {
                    a.this.k.post(new Runnable() {
                        public void run() {
                            if (a.this.z != null) {
                                a.this.z.a(1);
                            }
                        }
                    });
                }
            }
        };
        this.P = new Runnable() {
            public void run() {
                if (a.this.E != null) {
                    a.this.z();
                    a.this.E.a();
                }
            }
        };
        this.R = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                try {
                    if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        a.this.b();
                    }
                } catch (Throwable unused) {
                }
            }
        };
        this.S = new v.a() {
            public void a(Context context, Intent intent, boolean z) {
                int i = 0;
                if (z) {
                    try {
                        NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                        if (networkInfo != null) {
                            int type = networkInfo.getType();
                            if (type == 1) {
                                i = 4;
                            } else if (type == 0) {
                                i = 1;
                            }
                        } else {
                            i = o.c(context);
                        }
                    } catch (Throwable unused) {
                        return;
                    }
                }
                a.this.a(context, i);
            }
        };
        this.T = 1;
        this.U = false;
        this.T = o.c(context);
        this.B = viewGroup;
        this.h = new WeakReference(context);
        this.e = nVar;
        a(context);
        this.J = nVar != null ? nVar.aW() : i;
        if (nVar != null && nVar.aw() && nVar.ax() != null && this.B != null) {
            if (this.z == null) {
                this.z = f.a();
            }
            this.z.a((View) this.B, nVar.ax().n());
        }
    }

    public boolean a(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        int i;
        View view;
        c(false);
        if (cVar == null) {
            return false;
        }
        if (this.c == null || !this.c.m()) {
            if (this.z != null) {
                if (this.y) {
                    i = m.d().p(String.valueOf(this.J));
                } else {
                    i = m.d().o(String.valueOf(this.J));
                }
                ViewGroup viewGroup = this.B;
                if (!(viewGroup == null || (view = (View) viewGroup.getParent()) == null)) {
                    try {
                        View findViewById = view.findViewById(t.e(view.getContext(), "tt_video_reward_bar"));
                        View findViewById2 = view.findViewById(t.e(view.getContext(), "tt_ad_logo"));
                        View findViewById3 = view.findViewById(t.e(view.getContext(), "tt_real_top_layout_proxy"));
                        this.z.a(findViewById, g.OTHER);
                        this.z.a(findViewById3, g.OTHER);
                        this.z.a(findViewById2, g.OTHER);
                    } catch (Throwable unused) {
                    }
                }
                this.z.a(i > 0, ((float) i) / 1000.0f);
            }
            this.x = cVar;
            l.b("CSJ_VIDEO_BaseController", "video local url " + cVar.k());
            if (TextUtils.isEmpty(cVar.k())) {
                l.e("CSJ_VIDEO_BaseController", "No video info");
                return false;
            }
            y();
            this.v = !cVar.k().startsWith("http");
            this.n = cVar.g();
            if (cVar.f() > 0) {
                this.f = cVar.f();
                this.g = this.g > this.f ? this.g : this.f;
            }
            if (this.d != null) {
                this.d.a();
                this.d.g();
                this.d.c(cVar.d(), cVar.e());
                this.d.c(this.B);
            }
            if (!(this.c != null || cVar.m() == -2 || cVar.m() == 1)) {
                this.c = new d();
            }
            if (this.c != null) {
                this.c.a(this.A);
            }
            A();
            this.D = 0;
            try {
                c(cVar);
                return true;
            } catch (Exception unused2) {
                return false;
            }
        } else {
            this.c.a();
            return true;
        }
    }

    public boolean r() {
        return this.K;
    }

    public void e(boolean z2) {
        this.L = z2;
    }

    public void b(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        this.x = cVar;
    }

    public int l() {
        return com.bykv.vk.openvk.component.video.a.e.a.a(this.g, this.q);
    }

    public void a(Map<String, Object> map) {
        this.s = map;
    }

    private void c(com.bykv.vk.openvk.component.video.api.c.c cVar) throws Exception {
        if (cVar != null) {
            this.x = cVar;
            if (this.c != null) {
                if (this.e != null) {
                    cVar.d(String.valueOf(this.e.aW()));
                }
                cVar.c(1);
                this.c.a(cVar);
            }
            this.C = System.currentTimeMillis();
            if (!TextUtils.isEmpty(cVar.k())) {
                this.d.d(8);
                this.d.d(0);
                a((Runnable) new Runnable() {
                    public void run() {
                        long unused = a.this.C = System.currentTimeMillis();
                        a.this.d.c(0);
                        if (a.this.c != null && a.this.f == 0) {
                            a.this.c.a(true, 0, a.this.n);
                        } else if (a.this.c != null) {
                            a.this.c.a(true, a.this.f, a.this.n);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void P() {
        int i;
        int t2 = t();
        if (t2 == 2 || t2 == 1) {
            i = m.d().H() * 1000;
        } else {
            i = t2 == 3 ? m.d().g(String.valueOf(this.J)) : 5;
        }
        this.k.removeCallbacks(this.P);
        this.k.postDelayed(this.P, (long) i);
    }

    public void a(c.b bVar) {
        this.I = new WeakReference<>(bVar);
    }

    /* access modifiers changed from: private */
    public void Q() {
        if (C() && this.d != null) {
            this.k.removeCallbacks(this.P);
            this.d.b();
            this.D = System.currentTimeMillis() - this.C;
            c.a aVar = this.E;
            if (aVar != null) {
                aVar.a(this.D, com.bykv.vk.openvk.component.video.a.e.a.a(this.f, this.q));
            }
            if (!this.G) {
                this.G = true;
                a(this.q, this.q);
                long j = this.q;
                this.f = j;
                this.g = j;
                u();
            }
            this.l = true;
        }
    }

    public void a(c.a aVar) {
        this.E = aVar;
    }

    public void b() {
        if (this.c != null) {
            this.c.b();
        }
        if (!this.G && this.F) {
            v();
            if (this.e.ax() != null && this.e.ax().a() != null) {
                this.e.ax().a().b(this.f);
            }
        }
    }

    public void d() {
        if (this.d != null) {
            this.d.a();
            this.d.s();
            this.d.v();
        }
        l.b("CSJ_VIDEO_BaseController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.j));
        if (this.c != null) {
            if (this.c.m()) {
                if (this.j) {
                    E();
                } else {
                    b(this.r);
                }
                l.b("CSJ_VIDEO_BaseController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.j));
            } else {
                this.c.a(false, this.f, this.n);
            }
        }
        if (!this.G && this.F) {
            w();
            if (this.e.ax() != null && this.e.ax().a() != null) {
                this.e.ax().a().c(g());
            }
        }
    }

    public void I() {
        if (!this.G && this.F) {
            w();
            if (this.e.ax() != null && this.e.ax().a() != null) {
                this.e.ax().a().c(g());
            }
        }
    }

    public void d(long j) {
        this.f = j;
        this.g = this.g > this.f ? this.g : this.f;
        if (this.d != null) {
            this.d.a();
        }
        if (this.c != null) {
            this.c.a(true, this.f, this.n);
        }
    }

    public void e() {
        if (this.c != null) {
            this.c.d();
            this.c = null;
        }
        if (this.d != null) {
            this.d.i();
        }
        if (this.k != null) {
            this.k.removeCallbacks(this.P);
            this.k.removeCallbacksAndMessages((Object) null);
        }
        f fVar = this.z;
        if (fVar != null) {
            fVar.d();
        }
    }

    public void a(boolean z2, int i) {
        e();
    }

    public void f() {
        e();
    }

    /* access modifiers changed from: private */
    public boolean R() {
        if (this.e == null || this.e.an() == 100.0f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void S() {
        try {
            if (J() != null && this.c != null) {
                if (this.B != null) {
                    int width = this.B.getWidth();
                    int height = this.B.getHeight();
                    float j = (float) this.c.j();
                    float k = (float) this.c.k();
                    float f = (float) width;
                    float f2 = (float) height;
                    if (j / (f * 1.0f) <= k / (f2 * 1.0f)) {
                        f = (f2 / (k * 1.0f)) * j;
                    } else {
                        f2 = (f / (j * 1.0f)) * k;
                    }
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams((int) f, (int) f2);
                    layoutParams.addRule(13);
                    if (J() instanceof TextureView) {
                        ((TextureView) J()).setLayoutParams(layoutParams);
                    } else if (J() instanceof SurfaceView) {
                        ((SurfaceView) J()).setLayoutParams(layoutParams);
                    }
                }
            }
        } catch (Throwable th) {
            l.c("changeVideoSize", "changeVideoSizeSupportInteraction error", th);
        }
    }

    private boolean T() throws Throwable {
        if (this.h == null || this.h.get() == null || J() == null || this.c == null || this.e == null || this.e.G() != null || this.e.v() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x011d A[Catch:{ all -> 0x0188 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x013b A[Catch:{ all -> 0x0188 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014e A[Catch:{ all -> 0x0188 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void U() {
        /*
            r15 = this;
            java.lang.String r0 = ",videoWidth="
            java.lang.String r1 = "changeVideoSize"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r2.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r3 = "changeVideoSize start.......mMaterialMeta.getAdSlot()="
            r2.append(r3)     // Catch:{ all -> 0x0188 }
            com.bytedance.sdk.openadsdk.core.model.n r3 = r15.e     // Catch:{ all -> 0x0188 }
            com.bytedance.sdk.openadsdk.AdSlot r3 = r3.x()     // Catch:{ all -> 0x0188 }
            r2.append(r3)     // Catch:{ all -> 0x0188 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0188 }
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0188 }
            boolean r2 = r15.T()     // Catch:{ all -> 0x0188 }
            if (r2 == 0) goto L_0x0025
            return
        L_0x0025:
            java.lang.String r2 = "changeVideoSize start check condition complete ... go .."
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x0188 }
            android.content.Context r2 = com.bytedance.sdk.openadsdk.core.m.a()     // Catch:{ all -> 0x0188 }
            int[] r2 = com.bytedance.sdk.openadsdk.l.z.b((android.content.Context) r2)     // Catch:{ all -> 0x0188 }
            com.bytedance.sdk.openadsdk.core.model.n r3 = r15.e     // Catch:{ all -> 0x0188 }
            int r3 = r3.am()     // Catch:{ all -> 0x0188 }
            r4 = 0
            r5 = 1
            if (r3 != r5) goto L_0x003e
            r3 = r5
            goto L_0x003f
        L_0x003e:
            r3 = r4
        L_0x003f:
            r6 = r2[r4]     // Catch:{ all -> 0x0188 }
            float r8 = (float) r6     // Catch:{ all -> 0x0188 }
            r2 = r2[r5]     // Catch:{ all -> 0x0188 }
            float r9 = (float) r2     // Catch:{ all -> 0x0188 }
            com.bykv.vk.openvk.component.video.api.a r2 = r15.c     // Catch:{ all -> 0x0188 }
            int r2 = r2.j()     // Catch:{ all -> 0x0188 }
            float r10 = (float) r2     // Catch:{ all -> 0x0188 }
            com.bykv.vk.openvk.component.video.api.a r2 = r15.c     // Catch:{ all -> 0x0188 }
            int r2 = r2.k()     // Catch:{ all -> 0x0188 }
            float r11 = (float) r2     // Catch:{ all -> 0x0188 }
            if (r3 == 0) goto L_0x0064
            int r2 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x0073
            java.lang.String r0 = "Separate adaptation for landscape to portrait ....."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x0188 }
            r12 = 1
            r7 = r15
            r7.a(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0188 }
            return
        L_0x0064:
            int r2 = (r10 > r11 ? 1 : (r10 == r11 ? 0 : -1))
            if (r2 >= 0) goto L_0x0073
            java.lang.String r0 = "Separate adaptation for portrait to landscape....."
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x0188 }
            r12 = 0
            r7 = r15
            r7.a(r8, r9, r10, r11, r12)     // Catch:{ all -> 0x0188 }
            return
        L_0x0073:
            float r2 = r10 / r11
            float r6 = r8 / r9
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r7.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r12 = "screenHeight="
            r7.append(r12)     // Catch:{ all -> 0x0188 }
            r7.append(r9)     // Catch:{ all -> 0x0188 }
            java.lang.String r12 = ",screenWidth="
            r7.append(r12)     // Catch:{ all -> 0x0188 }
            r7.append(r8)     // Catch:{ all -> 0x0188 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0188 }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r7)     // Catch:{ all -> 0x0188 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r7.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r12 = "videoHeight="
            r7.append(r12)     // Catch:{ all -> 0x0188 }
            r7.append(r11)     // Catch:{ all -> 0x0188 }
            r7.append(r0)     // Catch:{ all -> 0x0188 }
            r7.append(r10)     // Catch:{ all -> 0x0188 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0188 }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r7)     // Catch:{ all -> 0x0188 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r7.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r12 = "video w/h,videoScale="
            r7.append(r12)     // Catch:{ all -> 0x0188 }
            r7.append(r2)     // Catch:{ all -> 0x0188 }
            java.lang.String r12 = ",screen  w/h .screenScale="
            r7.append(r12)     // Catch:{ all -> 0x0188 }
            r7.append(r6)     // Catch:{ all -> 0x0188 }
            java.lang.String r12 = ",VERTICAL_SCALE(9:16)="
            r7.append(r12)     // Catch:{ all -> 0x0188 }
            r12 = 1058013184(0x3f100000, float:0.5625)
            r7.append(r12)     // Catch:{ all -> 0x0188 }
            java.lang.String r13 = ",HORIZONTAL_SCALE(16:9) ="
            r7.append(r13)     // Catch:{ all -> 0x0188 }
            r13 = 1071877689(0x3fe38e39, float:1.7777778)
            r7.append(r13)     // Catch:{ all -> 0x0188 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0188 }
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r7)     // Catch:{ all -> 0x0188 }
            r7 = 1098907648(0x41800000, float:16.0)
            r14 = 1091567616(0x41100000, float:9.0)
            if (r3 == 0) goto L_0x00f2
            int r3 = (r6 > r12 ? 1 : (r6 == r12 ? 0 : -1))
            if (r3 >= 0) goto L_0x00ff
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x00ff
            float r14 = r14 * r9
            float r2 = r14 / r7
            r10 = r2
            r2 = r9
            goto L_0x0101
        L_0x00f2:
            int r3 = (r6 > r13 ? 1 : (r6 == r13 ? 0 : -1))
            if (r3 <= 0) goto L_0x00ff
            int r2 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x00ff
            float r14 = r14 * r8
            float r2 = r14 / r7
            r10 = r8
            goto L_0x0101
        L_0x00ff:
            r5 = r4
            r2 = r11
        L_0x0101:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r3.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r4 = "Width and height after adaptation：videoHeight="
            r3.append(r4)     // Catch:{ all -> 0x0188 }
            r3.append(r2)     // Catch:{ all -> 0x0188 }
            r3.append(r0)     // Catch:{ all -> 0x0188 }
            r3.append(r10)     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x0188 }
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x0188 }
            if (r5 != 0) goto L_0x013b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r0.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r2 = " Screen w/h == Video w/h and in other cases，use screen width and height，videoHeight="
            r0.append(r2)     // Catch:{ all -> 0x0188 }
            r0.append(r9)     // Catch:{ all -> 0x0188 }
            java.lang.String r2 = "，videoWidth="
            r0.append(r2)     // Catch:{ all -> 0x0188 }
            r0.append(r8)     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0188 }
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x0188 }
            r2 = r9
            goto L_0x013c
        L_0x013b:
            r8 = r10
        L_0x013c:
            android.widget.RelativeLayout$LayoutParams r0 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0188 }
            int r3 = (int) r8     // Catch:{ all -> 0x0188 }
            int r2 = (int) r2     // Catch:{ all -> 0x0188 }
            r0.<init>(r3, r2)     // Catch:{ all -> 0x0188 }
            r4 = 13
            r0.addRule(r4)     // Catch:{ all -> 0x0188 }
            com.bykv.vk.openvk.component.video.api.renderview.b r4 = r15.J()     // Catch:{ all -> 0x0188 }
            if (r4 == 0) goto L_0x0182
            com.bykv.vk.openvk.component.video.api.renderview.b r4 = r15.J()     // Catch:{ all -> 0x0188 }
            boolean r4 = r4 instanceof android.view.TextureView     // Catch:{ all -> 0x0188 }
            if (r4 == 0) goto L_0x0160
            com.bykv.vk.openvk.component.video.api.renderview.b r4 = r15.J()     // Catch:{ all -> 0x0188 }
            android.view.TextureView r4 = (android.view.TextureView) r4     // Catch:{ all -> 0x0188 }
            r4.setLayoutParams(r0)     // Catch:{ all -> 0x0188 }
            goto L_0x0171
        L_0x0160:
            com.bykv.vk.openvk.component.video.api.renderview.b r4 = r15.J()     // Catch:{ all -> 0x0188 }
            boolean r4 = r4 instanceof android.view.SurfaceView     // Catch:{ all -> 0x0188 }
            if (r4 == 0) goto L_0x0171
            com.bykv.vk.openvk.component.video.api.renderview.b r4 = r15.J()     // Catch:{ all -> 0x0188 }
            android.view.SurfaceView r4 = (android.view.SurfaceView) r4     // Catch:{ all -> 0x0188 }
            r4.setLayoutParams(r0)     // Catch:{ all -> 0x0188 }
        L_0x0171:
            android.view.ViewGroup r0 = r15.B     // Catch:{ all -> 0x0188 }
            android.view.ViewGroup$LayoutParams r0 = r0.getLayoutParams()     // Catch:{ all -> 0x0188 }
            if (r0 == 0) goto L_0x0182
            r0.height = r2     // Catch:{ all -> 0x0188 }
            r0.width = r3     // Catch:{ all -> 0x0188 }
            android.view.ViewGroup r2 = r15.B     // Catch:{ all -> 0x0188 }
            r2.setLayoutParams(r0)     // Catch:{ all -> 0x0188 }
        L_0x0182:
            java.lang.String r0 = "changeVideoSize .... complete ... end !!!"
            com.bytedance.sdk.component.utils.l.b((java.lang.String) r1, (java.lang.String) r0)     // Catch:{ all -> 0x0188 }
            goto L_0x018e
        L_0x0188:
            r0 = move-exception
            java.lang.String r2 = "changeSize error"
            com.bytedance.sdk.component.utils.l.c((java.lang.String) r1, (java.lang.String) r2, (java.lang.Throwable) r0)
        L_0x018e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.c.a.U():void");
    }

    /* access modifiers changed from: private */
    public void V() {
        try {
            if (this.h != null && this.h.get() != null && J() != null && this.c != null) {
                if (this.e != null) {
                    boolean z2 = this.e.am() == 1;
                    int[] b = z.b(m.a());
                    a((float) b[0], (float) b[1], (float) this.c.j(), (float) this.c.k(), z2);
                    l.b("changeVideoSize", "changeSize=end");
                }
            }
        } catch (Throwable th) {
            l.a("changeVideoSize", "changeSize error", th);
        }
    }

    private void a(float f, float f2, float f3, float f4, boolean z2) {
        RelativeLayout.LayoutParams layoutParams;
        try {
            l.b("changeVideoSize", "screenWidth=" + f + ",screenHeight=" + f2);
            l.b("changeVideoSize", "videoHeight=" + f4 + ",videoWidth=" + f3);
            if (f3 <= 0.0f || f4 <= 0.0f) {
                f3 = (float) this.e.J().c();
                f4 = (float) this.e.J().b();
            }
            if (f4 <= 0.0f) {
                return;
            }
            if (f3 > 0.0f) {
                if (z2) {
                    if (f3 >= f4) {
                        l.b("changeVideoSize", "Vertical screen mode use video width compute scale value");
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) f, (int) ((f4 * f) / f3));
                        layoutParams2.addRule(13);
                        layoutParams = layoutParams2;
                    } else {
                        return;
                    }
                } else if (f3 <= f4) {
                    l.b("changeVideoSize", "Landscape screen mode use video height compute scale value");
                    layoutParams = new RelativeLayout.LayoutParams((int) ((f3 * f2) / f4), (int) f2);
                    layoutParams.addRule(13);
                } else {
                    return;
                }
                if (J() == null) {
                    return;
                }
                if (J() instanceof TextureView) {
                    ((TextureView) J()).setLayoutParams(layoutParams);
                } else if (J() instanceof SurfaceView) {
                    ((SurfaceView) J()).setLayoutParams(layoutParams);
                }
            }
        } catch (Throwable th) {
            l.a("changeVideoSize", "changeSize error", th);
        }
    }

    public void a(b bVar, View view) {
        if (this.c != null && C()) {
            if (this.c.l()) {
                b();
                this.d.b(true, false);
                this.d.f();
            } else if (!this.c.m()) {
                if (this.d != null) {
                    this.d.c(this.B);
                }
                d(this.f);
                if (this.d != null) {
                    this.d.b(false, false);
                }
            } else {
                d();
                if (this.d != null) {
                    this.d.b(false, false);
                }
            }
        }
    }

    public void a(b bVar, int i) {
        if (this.c != null) {
            a(this.Q, b(i));
        }
    }

    public void b(b bVar, int i) {
        if (this.d != null) {
            this.d.f();
        }
    }

    public void a(b bVar, int i, boolean z2) {
        if (C()) {
            long n = (long) ((((float) (((long) i) * this.q)) * 1.0f) / ((float) t.n((Context) this.h.get(), "tt_video_progress_max")));
            if (this.q > 0) {
                this.Q = (long) ((int) n);
            } else {
                this.Q = 0;
            }
            if (this.d != null) {
                this.d.a(this.Q);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(long j, long j2) {
        this.f = j;
        this.q = j2;
        this.d.a(j, j2);
        this.d.a(com.bykv.vk.openvk.component.video.a.e.a.a(j, j2));
        try {
            if (this.E != null) {
                this.E.a(j, j2);
            }
        } catch (Throwable th) {
            l.c("CSJ_VIDEO_BaseController", "onProgressUpdate error: ", th);
        }
    }

    public void b(b bVar, View view) {
        b(bVar, view, false, false);
    }

    public void b(b bVar, View view, boolean z2, boolean z3) {
        if (C()) {
            f(!this.p);
            if (!(this.h.get() instanceof Activity)) {
                l.b("CSJ_VIDEO_BaseController", "context is not activity, not support this function.");
                return;
            }
            if (this.p) {
                a(z2 ? 8 : 0);
                if (this.d != null) {
                    this.d.a(this.B);
                    this.d.c(false);
                }
            } else {
                a(1);
                if (this.d != null) {
                    this.d.b(this.B);
                    this.d.c(false);
                }
            }
            WeakReference<c.b> weakReference = this.I;
            c.b bVar2 = weakReference != null ? (c.b) weakReference.get() : null;
            if (bVar2 != null) {
                bVar2.a(this.p);
            }
        }
    }

    public void a(int i) {
        if (C()) {
            boolean z2 = i == 0 || i == 8;
            Context context = (Context) this.h.get();
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                try {
                    activity.setRequestedOrientation(i);
                } catch (Throwable unused) {
                }
                if (!z2) {
                    activity.getWindow().setFlags(1024, 1024);
                } else {
                    activity.getWindow().clearFlags(1024);
                }
            }
        }
    }

    public void c(b bVar, View view) {
        if (this.d != null) {
            this.d.i();
        }
        a(true, 3);
    }

    public void a(b bVar, View view, boolean z2, boolean z3) {
        if (this.m) {
            b();
        }
        if (z2 && !this.m && !K()) {
            this.d.b(!L(), false);
            this.d.a(z3, true, false);
        }
        if (this.c == null || !this.c.l()) {
            this.d.f();
            return;
        }
        this.d.f();
        this.d.e();
    }

    public void d(b bVar, View view) {
        if (this.p) {
            f(false);
            if (this.d != null) {
                this.d.b(this.B);
            }
            a(1);
            return;
        }
        a(true, 3);
    }

    public void e(b bVar, View view) {
        a(bVar, view, false);
    }

    public com.bykv.vk.openvk.component.video.api.renderview.b J() {
        if (this.h == null || this.h.get() == null || this.d == null) {
            return null;
        }
        return this.d.q();
    }

    public boolean K() {
        return this.c.h();
    }

    public void a() {
        if (this.d != null) {
            this.d.e();
            this.d.a();
        }
        if (this.d != null) {
            this.d.v();
        }
        d(-1);
    }

    public boolean L() {
        return this.c != null && this.c.l();
    }

    private void a(long j, boolean z2) {
        if (this.c != null) {
            if (z2) {
                W();
            }
            this.c.a(j);
        }
    }

    private boolean b(int i) {
        return this.d.b(i);
    }

    private void W() {
        if (this.d != null) {
            this.d.c(0);
            this.d.a(false, false);
            this.d.c(false);
            this.d.e();
            this.d.g();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.c.a$7  reason: invalid class name */
    /* compiled from: BaseVideoController */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] a = new int[e.a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            /*
                com.bytedance.sdk.openadsdk.core.widget.e$a[] r0 = com.bytedance.sdk.openadsdk.core.widget.e.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.bytedance.sdk.openadsdk.core.widget.e$a r1 = com.bytedance.sdk.openadsdk.core.widget.e.a.PAUSE_VIDEO     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001f }
                com.bytedance.sdk.openadsdk.core.widget.e$a r1 = com.bytedance.sdk.openadsdk.core.widget.e.a.RELEASE_VIDEO     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x002a }
                com.bytedance.sdk.openadsdk.core.widget.e$a r1 = com.bytedance.sdk.openadsdk.core.widget.e.a.START_VIDEO     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.c.a.AnonymousClass7.<clinit>():void");
        }
    }

    public void a(e.a aVar, String str) {
        int i = AnonymousClass7.a[aVar.ordinal()];
        if (i == 1) {
            b();
        } else if (i == 2) {
            a(true, 3);
        } else if (i == 3) {
            d();
            this.o = false;
            this.H = true;
        }
    }

    private boolean b(int i, int i2) {
        if (i2 != 4 && i2 != 0) {
            b();
            this.o = true;
            this.H = false;
            if (!(this.d == null || this.e == null)) {
                return this.d.a(i, this.e.J(), true);
            }
        } else if (i2 == 4) {
            this.o = false;
            if (this.d != null) {
                this.d.s();
            }
        }
        return true;
    }

    /* access modifiers changed from: private */
    public void a(Context context, int i) {
        if (C() && this.T != i) {
            if (!this.H) {
                b(2, i);
            }
            this.T = i;
        }
    }

    public void M() {
        this.O = true;
    }

    /* access modifiers changed from: private */
    public void X() {
        if (this.e != null) {
            com.bytedance.sdk.openadsdk.c.a.c.a(com.bytedance.sdk.openadsdk.k.a.a(this.e.T(), true, this.e));
        }
    }

    public long k() {
        return g() + h();
    }

    public void b(final boolean z2) {
        super.b(z2);
        if (this.z == null) {
            return;
        }
        if (com.bykv.vk.openvk.component.video.a.c.a.b()) {
            this.z.a(z2);
        } else {
            this.k.post(new Runnable() {
                public void run() {
                    a.this.z.a(z2);
                }
            });
        }
    }

    public void N() {
        f fVar = this.z;
        if (fVar != null) {
            fVar.a(2);
        }
    }

    public void O() {
        f fVar = this.z;
        if (fVar != null) {
            fVar.a(13);
        }
    }
}
