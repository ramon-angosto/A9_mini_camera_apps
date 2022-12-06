package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.c.c.b.o;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.core.h;
import com.bytedance.sdk.openadsdk.core.k;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.c;
import com.bytedance.sdk.openadsdk.i.d;
import com.bytedance.sdk.openadsdk.l.g;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeVideoTsView extends FrameLayout implements c.a, x.a, c.a {
    /* access modifiers changed from: private */
    public static Integer v = 0;
    private static Integer w = 1;
    private boolean A;
    private long B;
    private boolean C;
    private final Handler D;
    /* access modifiers changed from: private */
    public boolean E;
    private boolean F;
    private final String G;
    private ViewStub H;
    private c.C0021c I;
    private boolean J;
    private final AtomicBoolean K;
    private Runnable L;
    private boolean M;
    private AtomicBoolean N;
    protected final n a;
    protected com.bykv.vk.openvk.component.video.api.d.c b;
    protected FrameLayout c;
    protected boolean d;
    public boolean e;
    public f f;
    protected RelativeLayout g;
    protected ImageView h;
    protected ImageView i;
    protected ImageView j;
    protected boolean k;
    protected String l;
    protected int m;
    AtomicBoolean n;
    boolean o;
    public b p;
    private final Context q;
    /* access modifiers changed from: private */
    public ViewGroup r;
    private boolean s;
    private boolean t;
    private String u;
    private String x;
    private boolean y;
    private boolean z;

    public interface a {
        void a(View view, int i);
    }

    public interface b {
        void a(boolean z, long j, long j2, long j3, boolean z2);
    }

    public void a() {
    }

    public void b(long j2, int i2) {
    }

    public void setIsNeedShowDetail(boolean z2) {
        this.J = z2;
    }

    public void setAdCreativeClickListener(a aVar) {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            ((c) cVar).a(aVar);
        }
    }

    public void setVideoPlayCallback(b bVar) {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            ((c) cVar).a(bVar);
        }
    }

    public void setControllerStatusCallBack(b bVar) {
        this.p = bVar;
    }

    public void a(long j2, int i2) {
        c.C0021c cVar = this.I;
        if (cVar != null) {
            cVar.a_();
        }
    }

    private void d() {
        a(0, 0);
        this.I = null;
    }

    public void a(long j2, long j3) {
        c.C0021c cVar = this.I;
        if (cVar != null) {
            cVar.a(j2, j3);
        }
    }

    public NativeVideoTsView(Context context, n nVar, boolean z2, f fVar) {
        this(context, nVar, z2, "embeded_ad", false, false, fVar);
    }

    public NativeVideoTsView(Context context, n nVar, String str, boolean z2, boolean z3, f fVar) {
        this(context, nVar, false, str, z2, z3, fVar);
    }

    public NativeVideoTsView(Context context, n nVar, f fVar) {
        this(context, nVar, false, fVar);
    }

    public NativeVideoTsView(Context context, n nVar, boolean z2, String str, boolean z3, boolean z4, f fVar) {
        super(context);
        this.s = true;
        this.d = true;
        this.t = false;
        this.e = false;
        this.y = false;
        this.z = true;
        this.k = true;
        this.l = "embeded_ad";
        this.m = 50;
        this.A = true;
        this.n = new AtomicBoolean(false);
        this.C = false;
        this.D = new x(k.c().getLooper(), this);
        this.F = false;
        this.G = Build.MODEL;
        this.o = false;
        this.J = true;
        this.K = new AtomicBoolean(false);
        this.L = new Runnable() {
            public void run() {
                NativeVideoTsView nativeVideoTsView = NativeVideoTsView.this;
                nativeVideoTsView.a(nativeVideoTsView.E, NativeVideoTsView.v.intValue());
            }
        };
        this.M = true;
        this.N = new AtomicBoolean(false);
        try {
            if (nVar.aS()) {
                if (Build.VERSION.SDK_INT >= 23) {
                    this.x = CacheDirFactory.getICacheDir(0).b();
                } else {
                    this.x = g.a();
                }
            }
        } catch (Throwable unused) {
        }
        if (fVar != null) {
            this.f = fVar;
        }
        this.l = str;
        this.q = context;
        this.a = nVar;
        this.t = z2;
        setContentDescription("NativeVideoAdView");
        this.y = z3;
        this.z = z4;
        b();
        e();
    }

    /* access modifiers changed from: protected */
    public void b() {
        n nVar = this.a;
        if (nVar != null) {
            int aW = nVar.aW();
            int a2 = m.d().a(aW);
            int c2 = o.c(m.a());
            if (a2 == 1) {
                this.s = y.c(c2);
            } else if (a2 == 2) {
                this.s = y.d(c2) || y.c(c2) || y.e(c2);
            } else if (a2 == 3) {
                this.s = false;
            } else if (a2 == 4) {
                this.o = true;
            } else if (a2 == 5) {
                this.s = y.c(c2) || y.e(c2);
            }
            if (this.t) {
                this.d = false;
            } else if (!this.e || !com.bytedance.sdk.openadsdk.core.nativeexpress.n.b(this.l)) {
                this.d = m.d().b(String.valueOf(aW));
            }
            if ("open_ad".equals(this.l)) {
                this.s = true;
                this.d = true;
            }
            com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
            if (cVar != null) {
                cVar.d(this.s);
            }
            this.e = true;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        b bVar;
        com.bykv.vk.openvk.component.video.api.d.c cVar;
        if (!(this.t || (bVar = this.p) == null || (cVar = this.b) == null)) {
            bVar.a(cVar.q(), this.b.j(), this.b.k(), this.b.g(), this.s);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private View a(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setId(t.e(this.q, "tt_native_video_layout"));
        layoutParams.gravity = 17;
        frameLayout.setVisibility(8);
        this.r = frameLayout;
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
        frameLayout2.setId(t.e(this.q, "tt_native_video_frame"));
        layoutParams2.gravity = 17;
        frameLayout2.setLayoutParams(layoutParams2);
        frameLayout.addView(frameLayout2);
        this.c = frameLayout2;
        ViewStub viewStub = new ViewStub(context);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -1);
        viewStub.setId(t.e(this.q, "tt_native_video_img_cover_viewStub"));
        viewStub.setLayoutResource(t.f(this.q, "tt_native_video_img_cover_layout"));
        viewStub.setLayoutParams(layoutParams3);
        frameLayout.addView(viewStub);
        this.H = viewStub;
        return frameLayout;
    }

    private void e() {
        addView(a(this.q));
        r();
    }

    public void setVideoAdClickListenerTTNativeAd(PAGNativeAd pAGNativeAd) {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            ((c) cVar).a(pAGNativeAd);
        }
    }

    public void g() {
        ViewStub viewStub;
        if (this.q != null && (viewStub = this.H) != null && viewStub.getParent() != null && this.a != null && this.g == null) {
            this.g = (RelativeLayout) this.H.inflate();
            this.h = (ImageView) findViewById(t.e(this.q, "tt_native_video_img_id"));
            this.j = (ImageView) findViewById(t.e(this.q, "tt_native_video_play"));
            if (this.k) {
                z.a((View) this.j, 0);
            }
            if (!(this.a.J() == null || this.a.J().h() == null)) {
                d.a().a(this.a.J().h(), this.h);
            }
            ImageView imageView = this.j;
            if (imageView != null) {
                imageView.setClickable(true);
                this.j.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        NativeVideoTsView.this.c();
                    }
                });
            }
            q();
        }
    }

    private void q() {
        if ((this instanceof NativeDrawVideoTsView) && !this.n.get() && h.d().r() != null) {
            this.j.setImageBitmap(h.d().r());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.j.getLayoutParams();
            int b2 = (int) z.b(getContext(), (float) this.m);
            layoutParams.width = b2;
            layoutParams.height = b2;
            this.j.setLayoutParams(layoutParams);
            this.n.set(true);
        }
    }

    private void r() {
        this.b = new c(this.q, this.c, this.a, this.l, !C(), this.y, this.z, this.f);
        s();
        this.r.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                if (NativeVideoTsView.this.r != null && NativeVideoTsView.this.r.getViewTreeObserver() != null && NativeVideoTsView.this.b != null) {
                    ((c) NativeVideoTsView.this.b).a(NativeVideoTsView.this.r.getWidth(), NativeVideoTsView.this.r.getHeight());
                    NativeVideoTsView.this.r.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            }
        });
    }

    public void setVideoAdLoadListener(c.d dVar) {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            cVar.a(dVar);
        }
    }

    public boolean a(long j2, boolean z2, boolean z3) {
        boolean z4 = false;
        this.r.setVisibility(0);
        if (this.b == null) {
            this.b = new c(this.q, this.c, this.a, this.l, this.y, this.z, this.f);
            s();
        }
        this.B = j2;
        if (!C()) {
            return true;
        }
        this.b.a(false);
        n nVar = this.a;
        if (!(nVar == null || nVar.J() == null)) {
            com.bykv.vk.openvk.component.video.api.c.c a2 = n.a(CacheDirFactory.getICacheDir(this.a.aL()).c(), this.a);
            a2.b(this.a.Y());
            a2.a(this.r.getWidth());
            a2.b(this.r.getHeight());
            a2.c(this.a.ac());
            a2.a(j2);
            a2.a(i());
            a(a2);
            if (z3) {
                this.b.b(a2);
                return true;
            }
            z4 = this.b.a(a2);
        }
        int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
        if (((i2 > 0 && !z2 && !z3) || (i2 > 0 && z2 && !this.C)) && this.b != null) {
            o.a aVar = new o.a();
            aVar.a(this.b.g());
            aVar.c(this.b.j());
            aVar.b(this.b.h());
            com.bytedance.sdk.openadsdk.c.c.a.a.b(this.b.o(), aVar);
        }
        return z4;
    }

    private void s() {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            cVar.d(this.s);
            ((c) this.b).a((c.a) this);
            this.b.a((c.a) this);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        t();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        t();
    }

    private void t() {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar == null) {
            r();
        } else if ((cVar instanceof c) && !C()) {
            ((c) this.b).v();
        }
        if (this.b != null && this.K.get()) {
            this.K.set(false);
            b();
            if (h()) {
                z.a((View) this.g, 8);
                ImageView imageView = this.i;
                if (imageView != null) {
                    z.a((View) imageView, 8);
                }
                n nVar = this.a;
                if (nVar == null || nVar.J() == null) {
                    l.e("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                    return;
                }
                com.bykv.vk.openvk.component.video.api.c.c a2 = n.a(CacheDirFactory.getICacheDir(this.a.aL()).c(), this.a);
                a2.b(this.a.Y());
                a2.a(this.r.getWidth());
                a2.b(this.r.getHeight());
                a2.c(this.a.ac());
                a2.a(0);
                a2.a(i());
                a(a2);
                this.b.a(a2);
                this.b.c(false);
            } else if (this.b.q()) {
                l.b("NativeVideoAdView", "attachTask-mNativeVideoController.isPlayComplete()=" + this.b.q());
                b(true);
            } else {
                l.c("NativeVideoAdView", "attachTask.......mRlImgCover.....VISIBLE");
                g();
                z.a((View) this.g, 0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        u();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        u();
    }

    private void u() {
        this.p = null;
        j();
        a(false);
        v();
    }

    private void v() {
        if (!this.K.get()) {
            this.K.set(true);
            com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
            if (cVar != null) {
                cVar.a(true, 3);
            }
        }
        this.N.set(false);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 4 || i2 == 8) {
            v();
        }
    }

    public void a(Message message) {
        if (message.what == 1) {
            w();
        }
    }

    private void w() {
        this.E = k();
        this.D.sendEmptyMessageDelayed(1, 500);
        post(this.L);
    }

    private boolean x() {
        if (C()) {
            return false;
        }
        boolean a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", false);
        if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", false) || a2) {
            return true;
        }
        return false;
    }

    private void y() {
        if (!C()) {
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_isfromvideodetailpage", (Boolean) false);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_from_detail_page", (Boolean) false);
        }
    }

    /* access modifiers changed from: private */
    public void a(boolean z2, int i2) {
        if (this.a != null && this.b != null) {
            boolean x2 = x();
            y();
            if (x2 && this.b.q()) {
                l.b("NativeVideoAdView", "changeVideoStatus---isFromDetailPage()=" + x2 + "，mNativeVideoController.isPlayComplete()=" + this.b.q());
                b(true);
                d();
            } else if (!z2 || this.b.q() || this.b.m()) {
                if (this.b.n() != null && this.b.n().l()) {
                    this.b.b();
                    a(true);
                    c.C0021c cVar = this.I;
                    if (cVar != null) {
                        cVar.d_();
                    }
                }
            } else if (this.b.n() == null || !this.b.n().m()) {
                if (this.s && this.b.n() == null) {
                    if (!this.K.get()) {
                        this.K.set(true);
                    }
                    this.N.set(false);
                    t();
                }
            } else if (this.s || i2 == 1) {
                com.bykv.vk.openvk.component.video.api.d.c cVar2 = this.b;
                if (cVar2 != null) {
                    setIsQuiet(cVar2.p());
                }
                if ("ALP-AL00".equals(this.G)) {
                    this.b.d();
                } else {
                    if (!h.d().q()) {
                        x2 = true;
                    }
                    ((c) this.b).h(x2);
                }
                a(false);
                c.C0021c cVar3 = this.I;
                if (cVar3 != null) {
                    cVar3.e_();
                }
            }
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        com.bykv.vk.openvk.component.video.api.d.c cVar;
        com.bykv.vk.openvk.component.video.api.d.c cVar2;
        com.bykv.vk.openvk.component.video.api.d.c cVar3;
        com.bykv.vk.openvk.component.video.api.d.c cVar4;
        super.onWindowFocusChanged(z2);
        z();
        if (!x() || (cVar4 = this.b) == null || !cVar4.q()) {
            b();
            if (C() || !h() || (cVar2 = this.b) == null || cVar2.m()) {
                if (h()) {
                    return;
                }
                if (!z2 && (cVar = this.b) != null && cVar.n() != null && this.b.n().l()) {
                    this.D.removeMessages(1);
                    a(false, v.intValue());
                } else if (z2) {
                    this.D.obtainMessage(1).sendToTarget();
                }
            } else if (this.D == null) {
            } else {
                if (!z2 || (cVar3 = this.b) == null || cVar3.q()) {
                    this.D.removeMessages(1);
                    a(false, v.intValue());
                    return;
                }
                this.D.obtainMessage(1).sendToTarget();
            }
        } else {
            y();
            z.a((View) this.g, 8);
            b(true);
            d();
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i2) {
        com.bykv.vk.openvk.component.video.api.d.c cVar;
        n nVar;
        com.bykv.vk.openvk.component.video.api.d.c cVar2;
        com.bykv.vk.openvk.component.video.api.d.c cVar3;
        super.onWindowVisibilityChanged(i2);
        z();
        if (this.M) {
            this.M = i2 == 0;
        }
        if (!x() || (cVar3 = this.b) == null || !cVar3.q()) {
            b();
            if (!C() && h() && (cVar = this.b) != null && !cVar.m() && (nVar = this.a) != null) {
                if (!this.A || nVar.J() == null) {
                    l.e("NativeVideoAdView", "attachTask materialMeta.getVideo() is null !!");
                } else {
                    this.a.J();
                    com.bykv.vk.openvk.component.video.api.c.c a2 = n.a(CacheDirFactory.getICacheDir(this.a.aL()).c(), this.a);
                    a2.b(this.a.Y());
                    a2.a(this.r.getWidth());
                    a2.b(this.r.getHeight());
                    a2.c(this.a.ac());
                    a2.a(this.B);
                    a2.a(i());
                    a(a2);
                    this.b.a(a2);
                    this.A = false;
                    z.a((View) this.g, 8);
                }
                if (i2 == 0 && this.D != null && (cVar2 = this.b) != null && !cVar2.q()) {
                    this.D.obtainMessage(1).sendToTarget();
                    return;
                }
                return;
            }
            return;
        }
        y();
        z.a((View) this.g, 8);
        b(true);
        d();
    }

    private void z() {
        if (!(this.b == null || C() || !com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", false))) {
            boolean a2 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_native_video_complete", false);
            long a3 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_current_play_position", 0);
            long a4 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_total_play_duration", this.b.j() + this.b.h());
            long a5 = com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_duration", this.b.j());
            this.b.c(a2);
            this.b.a(a3);
            this.b.b(a4);
            this.b.c(a5);
            com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_native_video_data", "key_video_is_update_flag", (Boolean) false);
            l.e("MultiProcess", "onResumeFeedNativeVideoControllerData-isComplete=" + a2 + ",position=" + a3 + ",totalPlayDuration=" + a4 + ",duration=" + a5);
        }
    }

    public void setNativeVideoController(com.bykv.vk.openvk.component.video.api.d.c cVar) {
        this.b = cVar;
    }

    public com.bykv.vk.openvk.component.video.api.d.c getNativeVideoController() {
        return this.b;
    }

    public boolean h() {
        return this.s;
    }

    public void setIsAutoPlay(boolean z2) {
        if (!this.F) {
            int a2 = m.d().a(this.a.aW());
            if (z2 && a2 != 4 && (!com.bytedance.sdk.component.utils.o.e(this.q) ? !(!com.bytedance.sdk.component.utils.o.f(this.q) ? com.bytedance.sdk.component.utils.o.d(this.q) : A() || B()) : !A())) {
                z2 = false;
            }
            this.s = z2;
            com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
            if (cVar != null) {
                cVar.d(this.s);
            }
            if (!this.s) {
                g();
                RelativeLayout relativeLayout = this.g;
                if (relativeLayout != null) {
                    z.a((View) relativeLayout, 0);
                    n nVar = this.a;
                    if (!(nVar == null || nVar.J() == null)) {
                        d.a().a(this.a.J().h(), this.h);
                    }
                }
            } else {
                z.a((View) this.g, 8);
            }
            this.F = true;
        }
    }

    private boolean A() {
        return 2 == m.d().a(this.a.aW());
    }

    private boolean B() {
        return 5 == m.d().a(this.a.aW());
    }

    public boolean i() {
        return this.d;
    }

    public void setIsQuiet(boolean z2) {
        this.d = z2;
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            cVar.b(z2);
        }
    }

    private boolean C() {
        return this.t;
    }

    public void setVideoAdInteractionListener(c.C0021c cVar) {
        this.I = cVar;
    }

    public void f() {
        c.C0021c cVar = this.I;
        if (cVar != null) {
            cVar.c_();
        }
    }

    public void setNeedNativeVideoPlayBtnVisible(boolean z2) {
        this.k = z2;
    }

    public void a(int i2) {
        b();
    }

    /* access modifiers changed from: protected */
    public void c() {
        if (!l()) {
            n();
        }
    }

    /* access modifiers changed from: protected */
    public void a(boolean z2) {
        if (this.i == null) {
            this.i = new ImageView(getContext());
            if (h.d().r() != null) {
                this.i.setImageBitmap(h.d().r());
            } else {
                this.i.setImageResource(t.d(m.a(), "tt_new_play_video"));
            }
            this.i.setScaleType(ImageView.ScaleType.FIT_XY);
            int b2 = (int) z.b(getContext(), (float) this.m);
            int b3 = (int) z.b(getContext(), 10.0f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(b2, b2);
            layoutParams.gravity = 17;
            layoutParams.rightMargin = b3;
            layoutParams.bottomMargin = b3;
            this.r.addView(this.i, layoutParams);
            this.i.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    NativeVideoTsView.this.n();
                }
            });
        }
        if (z2) {
            this.i.setVisibility(0);
        } else {
            this.i.setVisibility(8);
        }
    }

    public void b(boolean z2) {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            cVar.c(z2);
            com.bykv.vk.openvk.component.video.api.d.b o2 = this.b.o();
            if (o2 != null) {
                o2.b();
                View c2 = o2.c();
                if (c2 != null) {
                    if (c2.getParent() != null) {
                        ((ViewGroup) c2.getParent()).removeView(c2);
                    }
                    c2.setVisibility(0);
                    addView(c2);
                    o2.a(this.a, new WeakReference(this.q), false);
                }
            }
        }
    }

    public void j() {
        com.bykv.vk.openvk.component.video.api.d.b o2;
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null && (o2 = cVar.o()) != null) {
            o2.a();
            View c2 = o2.c();
            if (c2 != null) {
                c2.setVisibility(8);
                if (c2.getParent() != null) {
                    ((ViewGroup) c2.getParent()).removeView(c2);
                }
            }
        }
    }

    private void D() {
        z.e((View) this.i);
        z.e((View) this.g);
    }

    public void setVideoCacheUrl(String str) {
        this.u = str;
    }

    /* access modifiers changed from: package-private */
    public boolean k() {
        return v.a(this, 50, com.bytedance.sdk.openadsdk.core.nativeexpress.n.b(this.l) ? 1 : 5);
    }

    public boolean l() {
        boolean z2 = false;
        if (com.bytedance.sdk.component.utils.o.c(m.a()) == 0) {
            return false;
        }
        if (this.b.n() != null && this.b.n().l()) {
            a(false, v.intValue());
            Handler handler = this.D;
            z2 = true;
            if (handler != null) {
                handler.removeMessages(1);
            }
        }
        return z2;
    }

    public void m() {
        if (getNativeVideoController() != null && (getNativeVideoController() instanceof c)) {
            c cVar = (c) getNativeVideoController();
            cVar.a((com.bykv.vk.openvk.component.video.api.d.b) cVar.o(), (View) this);
        }
    }

    public void n() {
        if (com.bytedance.sdk.component.utils.o.c(m.a()) == 0 || !k()) {
            return;
        }
        if (this.b.n() != null && this.b.n().m()) {
            a(true, w.intValue());
            b();
            Handler handler = this.D;
            if (handler != null) {
                handler.sendEmptyMessageDelayed(1, 500);
            }
        } else if (!h() && !this.N.get()) {
            this.N.set(true);
            D();
            n nVar = this.a;
            if (!(nVar == null || nVar.J() == null)) {
                D();
                this.a.J();
                com.bykv.vk.openvk.component.video.api.c.c a2 = n.a(CacheDirFactory.getICacheDir(this.a.aL()).c(), this.a);
                a2.b(this.a.Y());
                a2.a(this.r.getWidth());
                a2.b(this.r.getHeight());
                a2.c(this.a.ac());
                a2.a(this.B);
                a2.a(i());
                a2.a(CacheDirFactory.getICacheDir(this.a.aL()).c());
                a(a2);
                this.b.a(a2);
            }
            Handler handler2 = this.D;
            if (handler2 != null) {
                handler2.sendEmptyMessageDelayed(1, 500);
            }
            a(false);
        }
    }

    public double getCurrentPlayTime() {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar != null) {
            return (((double) cVar.g()) * 1.0d) / 1000.0d;
        }
        return 0.0d;
    }

    public void o() {
        n nVar = this.a;
        if (nVar != null && nVar.ax() != null) {
            this.a.ax().o();
            this.a.ax().a().e(this.B);
        }
    }

    public com.bytedance.sdk.openadsdk.core.f.f a(List<Pair<View, com.a.a.a.a.b.g>> list) {
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.b;
        if (cVar instanceof c) {
            return ((c) cVar).a((View) this, list);
        }
        return null;
    }

    private void a(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        try {
            if (this.a.aS()) {
                cVar.a(this.x);
            }
        } catch (Throwable unused) {
        }
    }
}
