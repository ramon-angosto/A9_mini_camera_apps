package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.a.e.b;
import com.bykv.vk.openvk.component.video.api.b.a;
import com.bykv.vk.openvk.component.video.api.d.b;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderSurfaceView;
import com.bykv.vk.openvk.component.video.api.renderview.SSRenderTextureView;
import com.bytedance.sdk.component.d.k;
import com.bytedance.sdk.component.d.u;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.o;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.core.b.a;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.CornerIV;
import com.bytedance.sdk.openadsdk.core.widget.d;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.l.y;
import com.bytedance.sdk.openadsdk.l.z;
import com.com.bytedance.overseas.sdk.a.c;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import org.json.JSONObject;

/* compiled from: NativeVideoLayout */
public class e implements a, b<n>, com.bykv.vk.openvk.component.video.api.renderview.a, x.a, a.C0043a, d.a, e.b {
    a A;
    boolean B;
    c C;
    com.bykv.vk.openvk.component.video.api.d.c D;
    com.bytedance.sdk.openadsdk.core.b.a E;
    com.bytedance.sdk.openadsdk.core.b.a F;
    boolean G;
    private View H;
    private TextView I;
    private TextView J;
    /* access modifiers changed from: private */
    public NativeVideoTsView.a K;
    private long L;
    private final String M;
    View a;
    com.bykv.vk.openvk.component.video.api.renderview.b b;
    ImageView c;
    View d;
    View e;
    ImageView f;
    ViewStub g;
    View h;
    ImageView i;
    View j;
    CornerIV k;
    TextView l;
    TextView m;
    TextView n;
    ViewStub o;
    int p;
    int q;
    int r;
    int s;
    boolean t;
    boolean u;
    int v;
    EnumSet<b.a> w;
    n x;
    Context y;
    com.bytedance.sdk.openadsdk.core.widget.e z;

    public void a(long j2) {
    }

    public void a(long j2, long j3) {
    }

    public void a(Message message) {
    }

    public void a(View view, boolean z2) {
    }

    public void a(ViewGroup viewGroup) {
    }

    public void a(String str) {
    }

    public void b(SurfaceTexture surfaceTexture) {
    }

    public void b(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    public void b(ViewGroup viewGroup) {
    }

    public void b(boolean z2) {
    }

    public boolean b(int i2) {
        return false;
    }

    public void c(boolean z2) {
    }

    public void e() {
    }

    public void f() {
    }

    public boolean j() {
        return false;
    }

    public void n() {
    }

    public e(Context context, View view, boolean z2, EnumSet<b.a> enumSet, n nVar, com.bykv.vk.openvk.component.video.api.d.c cVar, boolean z3) {
        this.t = true;
        this.B = true;
        this.G = true;
        this.M = Build.MODEL;
        if (!(this instanceof d)) {
            this.y = m.a().getApplicationContext();
            d(z3);
            this.a = view;
            this.t = z2;
            this.w = enumSet == null ? EnumSet.noneOf(b.a.class) : enumSet;
            this.D = cVar;
            this.x = nVar;
            c(8);
            a(context, this.a);
            d();
            p();
        }
    }

    public e(Context context, View view, boolean z2, EnumSet<b.a> enumSet, n nVar, com.bykv.vk.openvk.component.video.api.d.c cVar) {
        this(context, view, z2, enumSet, nVar, cVar, true);
    }

    /* access modifiers changed from: package-private */
    public void p() {
        int i2;
        String str;
        com.bytedance.sdk.openadsdk.core.b.a aVar;
        int i3;
        String str2;
        String str3 = this.B ? "embeded_ad" : "embeded_ad_landingpage";
        if (this.x.aQ()) {
            str = this.B ? "draw_ad" : "draw_ad_landingpage";
            i2 = 6;
        } else {
            if (this.x.aT()) {
                i3 = 7;
                str2 = "rewarded_video";
            } else if (this.x.aU()) {
                i3 = 5;
                str2 = "fullscreen_interstitial_ad";
            } else if (this.x.aV()) {
                i3 = 2;
                str2 = "banner_ad";
            } else {
                str = str3;
                i2 = 1;
            }
            i2 = i3;
            str = str2;
        }
        if (this.x.L() == 4) {
            this.C = com.com.bytedance.overseas.sdk.a.d.a(this.y, this.x, str);
        }
        z();
        this.E = new com.bytedance.sdk.openadsdk.core.b.a(this.y, this.x, str, i2);
        this.E.a((a.C0043a) this);
        this.E.b(true);
        if (this.B) {
            this.E.a(true);
        } else {
            this.E.a(false);
            this.E.c(true);
        }
        this.E.a(this.D);
        this.E.d(true);
        this.E.a((b.a) new b.a() {
            public void a(View view, int i) {
                if (e.this.K != null) {
                    e.this.K.a(view, i);
                }
            }
        });
        c cVar = this.C;
        if (!(cVar == null || (aVar = this.E) == null)) {
            aVar.a(cVar);
        }
        if (y()) {
            this.F = new com.bytedance.sdk.openadsdk.core.b.a(this.y, this.x, str, i2) {
                public boolean b() {
                    boolean a2 = e.this.z != null ? e.this.z.a() : false;
                    StringBuilder sb = new StringBuilder();
                    sb.append("isVisible=");
                    sb.append(a2);
                    sb.append(",mPlayBtn.getVisibility() == VISIBLE->");
                    sb.append(e.this.c.getVisibility() == 0);
                    l.c("ClickCreativeListener", sb.toString());
                    if (a2 || e.this.c.getVisibility() == 0) {
                        return true;
                    }
                    return false;
                }

                public boolean c() {
                    return (e.this.h != null && e.this.h.getVisibility() == 0) || (e.this.j != null && e.this.j.getVisibility() == 0) || ((e.this.k != null && e.this.k.getVisibility() == 0) || (e.this.l != null && e.this.l.getVisibility() == 0));
                }
            };
            this.F.a((b.a) new b.a() {
                public void a(View view, int i) {
                    if (e.this.K != null) {
                        e.this.K.a(view, i);
                    }
                }
            });
            this.F.b(true);
            if (this.B) {
                this.F.a(true);
            } else {
                this.F.a(false);
            }
            this.F.a(this.D);
            this.F.d(true);
            c cVar2 = this.C;
            if (cVar2 != null) {
                this.F.a(cVar2);
            }
            this.F.a((a.C0043a) this);
            View view = this.a;
            if (view != null) {
                view.setOnClickListener(this.F);
                this.a.setOnTouchListener(this.F);
            }
        }
    }

    private boolean y() {
        return n.c(this.x) && this.x.G() == null && this.x.p() == 1;
    }

    public void a(NativeVideoTsView.a aVar) {
        this.K = aVar;
    }

    public void a(PAGNativeAd pAGNativeAd) {
        com.bytedance.sdk.openadsdk.core.b.a aVar = this.E;
        if (aVar != null) {
            aVar.a(pAGNativeAd);
        }
        com.bytedance.sdk.openadsdk.core.b.a aVar2 = this.F;
        if (aVar2 != null) {
            aVar2.a(pAGNativeAd);
        }
    }

    private void z() {
        Context context = this.y;
        if (context != null && this.a != null) {
            AnonymousClass5 r1 = new View(context) {
                private void a() {
                }

                private void b() {
                }

                public void onFinishTemporaryDetach() {
                    super.onFinishTemporaryDetach();
                    a();
                }

                /* access modifiers changed from: protected */
                public void onDetachedFromWindow() {
                    super.onDetachedFromWindow();
                    b();
                }

                public void onStartTemporaryDetach() {
                    super.onStartTemporaryDetach();
                    b();
                }
            };
            View view = this.a;
            if (view instanceof ViewGroup) {
                ((ViewGroup) view).addView(r1, 0, new RelativeLayout.LayoutParams(0, 0));
            }
        }
    }

    public com.bykv.vk.openvk.component.video.api.renderview.b q() {
        return this.b;
    }

    /* access modifiers changed from: package-private */
    public void a(Context context, View view) {
        View view2;
        long currentTimeMillis = System.currentTimeMillis();
        if (view != null) {
            view.setKeepScreenOn(true);
        }
        com.bykv.vk.openvk.component.video.api.d.c cVar = this.D;
        if (cVar == null || !cVar.s()) {
            view2 = new SSRenderSurfaceView(this.y);
            l.b("NewLiveViewLayout", "use SurfaceView......");
        } else {
            view2 = new SSRenderTextureView(this.y);
            l.b("NewLiveViewLayout", "use TextureView......");
        }
        if (view instanceof RelativeLayout) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ((RelativeLayout) view).addView(view2, 0, layoutParams);
        }
        z.a(view2, 8);
        this.b = (com.bykv.vk.openvk.component.video.api.renderview.b) view2;
        this.c = (ImageView) view.findViewById(t.e(context, "tt_video_play"));
        this.d = view.findViewById(t.e(context, "tt_video_loading_retry_layout"));
        this.e = view.findViewById(t.e(context, "tt_video_loading_progress"));
        this.f = (ImageView) view.findViewById(t.e(context, "tt_video_loading_cover_image"));
        this.g = (ViewStub) view.findViewById(t.e(context, "tt_video_ad_cover"));
        this.o = (ViewStub) view.findViewById(t.e(context, "tt_video_draw_layout_viewStub"));
        l.b("useTime", "NativeVideoLayout**findViews use time :" + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* access modifiers changed from: package-private */
    public void a(View view, Context context) {
        ViewStub viewStub;
        if (view != null && context != null && (viewStub = this.g) != null && viewStub.getParent() != null && this.h == null) {
            this.h = this.g.inflate();
            this.i = (ImageView) view.findViewById(t.e(context, "tt_video_ad_finish_cover_image"));
            this.j = view.findViewById(t.e(context, "tt_video_ad_cover_center_layout"));
            this.k = (CornerIV) view.findViewById(t.e(context, "tt_video_ad_logo_image"));
            this.l = (TextView) view.findViewById(t.e(context, "tt_video_btn_ad_image_tv"));
            this.m = (TextView) view.findViewById(t.e(context, "tt_video_ad_name"));
            this.n = (TextView) view.findViewById(t.e(context, "tt_video_ad_button"));
        }
    }

    private void b(View view, Context context) {
        ViewStub viewStub;
        if (view != null && context != null && (viewStub = this.o) != null && viewStub.getParent() != null && this.H == null) {
            this.o.inflate();
            this.H = view.findViewById(t.e(context, "tt_video_ad_cover_center_layout_draw"));
            this.I = (TextView) view.findViewById(t.e(context, "tt_video_ad_button_draw"));
            this.J = (TextView) view.findViewById(t.e(context, "tt_video_ad_replay"));
        }
    }

    /* access modifiers changed from: package-private */
    public void r() {
        if (this.A != null && this.z == null) {
            long currentTimeMillis = System.currentTimeMillis();
            this.z = new com.bytedance.sdk.openadsdk.core.widget.e();
            this.z.a(this.y, this.a);
            this.z.a(this.A, (e.b) this);
            l.b("useTime", "mVideoTrafficTipLayout use time :" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public boolean a(int i2, com.bykv.vk.openvk.component.video.api.c.b bVar, boolean z2) {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.z;
        return eVar == null || eVar.a(i2, bVar, z2);
    }

    public void s() {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.z;
        if (eVar != null) {
            eVar.a(false);
        }
    }

    public void a(com.bykv.vk.openvk.component.video.api.d.a aVar) {
        if (aVar instanceof a) {
            this.A = (a) aVar;
            r();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean t() {
        if (this.A != null) {
            return true;
        }
        l.e("NewLiveViewLayout", "callback is null");
        return false;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.b.a(this);
        this.c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (!e.this.t()) {
                    return;
                }
                if (e.this.n == null || e.this.n.getVisibility() != 0) {
                    e.this.A.a((com.bykv.vk.openvk.component.video.api.d.b) e.this, view);
                }
            }
        });
    }

    public void d(int i2) {
        z.a(this.a, 0);
        com.bykv.vk.openvk.component.video.api.renderview.b bVar = this.b;
        if (bVar != null) {
            bVar.setVisibility(i2);
        }
    }

    public void d(boolean z2) {
        this.B = z2;
        if (this.B) {
            com.bytedance.sdk.openadsdk.core.b.a aVar = this.E;
            if (aVar != null) {
                aVar.a(true);
            }
            com.bytedance.sdk.openadsdk.core.b.a aVar2 = this.F;
            if (aVar2 != null) {
                aVar2.a(true);
                return;
            }
            return;
        }
        com.bytedance.sdk.openadsdk.core.b.a aVar3 = this.E;
        if (aVar3 != null) {
            aVar3.a(false);
        }
        com.bytedance.sdk.openadsdk.core.b.a aVar4 = this.F;
        if (aVar4 != null) {
            aVar4.a(false);
        }
    }

    public void a(int i2, int i3) {
        if (i2 == -1) {
            i2 = z.c(this.y);
        }
        if (i2 > 0) {
            this.p = i2;
            if (k() || j() || this.w.contains(b.a.fixedSize)) {
                this.q = i3;
            } else {
                this.q = e(i2);
            }
            b(this.p, this.q);
        }
    }

    public void b(boolean z2, boolean z3) {
        ImageView imageView = this.c;
        if (imageView == null) {
            return;
        }
        if (z2) {
            imageView.setImageResource(t.d(this.y, "tt_play_movebar_textpage"));
        } else {
            imageView.setImageResource(t.d(this.y, "tt_stop_movebar_textpage"));
        }
    }

    public void b(int i2, int i3) {
        ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
        if (i2 == -1 || i2 == -2 || i2 > 0) {
            layoutParams.width = i2;
        }
        if (i3 == -1 || i3 == -2 || i3 > 0) {
            layoutParams.height = i3;
        }
        this.a.setLayoutParams(layoutParams);
    }

    private int e(int i2) {
        if (this.r <= 0 || this.s <= 0) {
            return 0;
        }
        int dimensionPixelSize = this.y.getResources().getDimensionPixelSize(t.i(this.y, "tt_video_container_maxheight"));
        int dimensionPixelSize2 = this.y.getResources().getDimensionPixelSize(t.i(this.y, "tt_video_container_minheight"));
        int i3 = (int) (((float) this.s) * ((((float) i2) * 1.0f) / ((float) this.r)));
        if (i3 > dimensionPixelSize) {
            return dimensionPixelSize;
        }
        return i3 < dimensionPixelSize2 ? dimensionPixelSize2 : i3;
    }

    public void c(int i2, int i3) {
        this.r = i2;
        this.s = i3;
    }

    public void a(int i2) {
        l.c("Progress", "setSeekProgress-percent=" + i2);
    }

    public void c(ViewGroup viewGroup) {
        if (viewGroup != null) {
            if (this.a.getParent() == null) {
                viewGroup.addView(this.a);
            }
            c(0);
        }
    }

    public View c() {
        return this.a;
    }

    public void g() {
        n nVar;
        z.f(this.d);
        z.f(this.e);
        if (!(this.f == null || (nVar = this.x) == null || nVar.J() == null || this.x.J().h() == null)) {
            z.f((View) this.f);
            com.bytedance.sdk.openadsdk.i.d.a().a(this.x.J().h(), this.f);
        }
        if (this.c.getVisibility() == 0) {
            z.a((View) this.c, 8);
        }
    }

    public void u() {
        z.f(this.d);
        z.f(this.e);
        if (this.c.getVisibility() == 0) {
            z.a((View) this.c, 8);
        }
    }

    public void a() {
        a(false, this.t);
        w();
    }

    public void v() {
        z.a(this.a, 0);
        com.bykv.vk.openvk.component.video.api.renderview.b bVar = this.b;
        if (bVar != null) {
            z.a(bVar.getView(), 0);
        }
    }

    /* access modifiers changed from: package-private */
    public void w() {
        try {
            z.a(this.h, 8);
            z.a((View) this.i, 8);
            z.a(this.j, 8);
            z.a((View) this.k, 8);
            z.a((View) this.l, 8);
            z.a((View) this.m, 8);
            z.a((View) this.n, 8);
        } catch (Exception unused) {
        }
    }

    private void f(int i2) {
        z.a(this.j, i2);
        z.a(this.H, i2);
    }

    public void a(boolean z2) {
        this.G = z2;
    }

    public void a(final n nVar, WeakReference<Context> weakReference, boolean z2) {
        String str;
        n nVar2;
        n nVar3;
        n nVar4;
        if (nVar != null) {
            a(false, this.t);
            a(this.a, m.a());
            View view = this.h;
            if (view != null) {
                z.a(view, 0);
            }
            ImageView imageView = this.i;
            if (imageView != null) {
                z.a((View) imageView, 0);
            }
            if (this.x.aQ()) {
                b(this.a, m.a());
                z.a(this.j, 8);
                z.a((View) this.i, 0);
                z.a(this.H, 0);
                z.a((View) this.I, 0);
                z.a((View) this.J, 0);
                if (this.J != null && o.c(m.a()) == 0) {
                    z.a((View) this.J, 8);
                }
                View view2 = this.h;
                if (view2 != null) {
                    view2.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (e.this.D != null) {
                                ((com.bykv.vk.openvk.component.video.api.d.a) e.this.D).a();
                            }
                        }
                    });
                }
                if (!(this.i == null || (nVar4 = this.x) == null || nVar4.J() == null || this.x.J().h() == null)) {
                    com.bykv.vk.openvk.component.video.a.e.b.a((long) this.x.J().f(), this.x.J().i(), new b.C0019b() {
                        public void a(Bitmap bitmap) {
                            if (bitmap != null) {
                                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) e.this.i.getLayoutParams();
                                if (bitmap.getWidth() > bitmap.getHeight()) {
                                    layoutParams.width = z.c(m.a());
                                    layoutParams.height = (int) ((float) ((bitmap.getHeight() * z.c(m.a())) / bitmap.getWidth()));
                                    layoutParams.addRule(13);
                                    e.this.i.setLayoutParams(layoutParams);
                                }
                                e.this.i.setImageBitmap(bitmap);
                                return;
                            }
                            com.bytedance.sdk.openadsdk.i.d.a().a(e.this.x.J().h(), e.this.i);
                        }
                    });
                }
            } else {
                z.a(this.j, 0);
                if (!(this.i == null || (nVar3 = this.x) == null || nVar3.J() == null || this.x.J().h() == null)) {
                    com.bytedance.sdk.openadsdk.i.d.a().a(this.x.J().h(), this.i);
                }
            }
            if (!TextUtils.isEmpty(nVar.K())) {
                str = nVar.K();
            } else if (!TextUtils.isEmpty(nVar.U())) {
                str = nVar.U();
            } else {
                str = !TextUtils.isEmpty(nVar.V()) ? nVar.V() : "";
            }
            if (this.k != null && (nVar2 = this.x) != null && nVar2.M() != null && this.x.M().a() != null) {
                z.a((View) this.k, 0);
                z.a((View) this.l, 4);
                n nVar5 = this.x;
                if (nVar5 == null || !nVar5.aw()) {
                    com.bytedance.sdk.openadsdk.i.d.a().a(this.x.M(), (ImageView) this.k);
                } else {
                    com.bytedance.sdk.openadsdk.e.a.a(this.x.M()).a(u.BITMAP).a((com.bytedance.sdk.component.d.o) new com.bytedance.sdk.component.d.o<Bitmap>() {
                        public void a(k<Bitmap> kVar) {
                            if (kVar != null && kVar.b() != null && e.this.k != null) {
                                e.this.k.setImageBitmap(kVar.b());
                            }
                        }

                        public void a(int i, String str, Throwable th) {
                            e.this.a(i, str, nVar);
                        }
                    });
                    if (!(this.x.ax() == null || this.x.ax().b() == null)) {
                        this.x.ax().b().b(0);
                    }
                }
                n nVar6 = this.x;
                if (nVar6 != null && nVar6.aw()) {
                    try {
                        this.k.setTag(t.e(this.y, "tt_id_vast_click_type"), "VAST_ICON");
                    } catch (Throwable unused) {
                    }
                }
                n nVar7 = this.x;
                if (!(nVar7 == null || nVar7.ax() == null || this.x.ax().b() == null)) {
                    final com.bytedance.sdk.openadsdk.core.f.b b2 = this.x.ax().b();
                    CornerIV cornerIV = this.k;
                    if (cornerIV != null) {
                        cornerIV.post(new Runnable() {
                            public void run() {
                                com.bytedance.sdk.openadsdk.core.f.b bVar;
                                if (e.this.k != null && e.this.k.isShown() && (bVar = b2) != null) {
                                    bVar.b(e.this.getVideoProgress());
                                }
                            }
                        });
                    }
                }
                if (y()) {
                    this.k.setOnClickListener(this.F);
                    this.k.setOnTouchListener(this.F);
                } else {
                    this.k.setOnClickListener(this.E);
                    this.k.setOnTouchListener(this.E);
                }
            } else if (!TextUtils.isEmpty(str)) {
                z.a((View) this.k, 4);
                z.a((View) this.l, 0);
                TextView textView = this.l;
                if (textView != null) {
                    textView.setText(str.substring(0, 1));
                    if (y()) {
                        this.l.setOnClickListener(this.F);
                        this.l.setOnTouchListener(this.F);
                    } else {
                        this.l.setOnClickListener(this.E);
                        this.l.setOnTouchListener(this.E);
                    }
                }
            }
            if (this.m != null && !TextUtils.isEmpty(str)) {
                this.m.setText(str);
                this.m.setTag(t.e(this.y, "tt_id_vast_click_type"), "VAST_TITLE");
            }
            z.a((View) this.m, 0);
            z.a((View) this.n, 0);
            String W = nVar.W();
            if (TextUtils.isEmpty(W)) {
                int L2 = nVar.L();
                if (L2 == 2 || L2 == 3) {
                    W = t.a(this.y, "tt_video_mobile_go_detail");
                } else if (L2 != 4) {
                    W = L2 != 5 ? t.a(this.y, "tt_video_mobile_go_detail") : t.a(this.y, "tt_video_dial_phone");
                } else {
                    W = t.a(this.y, "tt_video_download_apk");
                }
            }
            TextView textView2 = this.n;
            if (textView2 != null) {
                textView2.setText(W);
                this.n.setOnClickListener(this.E);
                this.n.setOnTouchListener(this.E);
            }
            TextView textView3 = this.I;
            if (textView3 != null) {
                textView3.setText(W);
                this.I.setOnClickListener(this.E);
                this.I.setOnTouchListener(this.E);
            }
            if (!this.G) {
                f(4);
            }
        }
    }

    /* access modifiers changed from: private */
    public void a(int i2, String str, n nVar) {
        final int i3 = i2;
        final String str2 = str;
        final n nVar2 = nVar;
        com.bytedance.sdk.openadsdk.c.c.a((g) new g("load_vast_icon_fail") {
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("error_code", i3);
                    jSONObject.put("description", i3 + ":" + str2);
                    jSONObject.put("link", e.this.x.M().a());
                } catch (Throwable unused) {
                }
                String str = null;
                if (e.this.x != null) {
                    str = y.b(nVar2.aR());
                }
                com.bytedance.sdk.openadsdk.c.c.b(e.this.y, e.this.x, str, "load_vast_icon_fail", jSONObject);
            }
        });
    }

    public void b() {
        z.e(this.d);
        z.e(this.e);
        ImageView imageView = this.f;
        if (imageView != null) {
            z.e((View) imageView);
        }
    }

    public void h() {
        z.e(this.d);
    }

    public void a(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == this.b.getHolder()) {
            this.u = true;
            if (t()) {
                this.A.a((com.bykv.vk.openvk.component.video.api.d.b) this, surfaceHolder);
            }
        }
    }

    public void a(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        if (surfaceHolder == this.b.getHolder() && t()) {
            this.A.a(this, surfaceHolder, i2, i3, i4);
        }
    }

    public void b(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == this.b.getHolder()) {
            this.u = false;
            if (t()) {
                this.A.b((com.bykv.vk.openvk.component.video.api.d.b) this, surfaceHolder);
            }
        }
    }

    public void a(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.u = true;
        if (t()) {
            this.A.a((com.bykv.vk.openvk.component.video.api.d.b) this, surfaceTexture);
        }
    }

    public boolean a(SurfaceTexture surfaceTexture) {
        this.u = false;
        if (!t()) {
            return true;
        }
        this.A.b((com.bykv.vk.openvk.component.video.api.d.b) this, surfaceTexture);
        return true;
    }

    public void i() {
        c(8);
        if (x()) {
            this.b.setVisibility(8);
        }
        ImageView imageView = this.f;
        if (imageView != null) {
            imageView.setImageDrawable((Drawable) null);
        }
        c(8);
        z.a(this.h, 8);
        z.a((View) this.i, 8);
        z.a(this.j, 8);
        z.a((View) this.k, 8);
        z.a((View) this.l, 8);
        z.a((View) this.m, 8);
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.z;
        if (eVar != null) {
            eVar.a(true);
        }
    }

    public boolean k() {
        return this.t;
    }

    public void a(boolean z2, boolean z3, boolean z4) {
        z.a((View) this.c, (!z2 || this.d.getVisibility() == 0) ? 8 : 0);
    }

    public void a(boolean z2, boolean z3) {
        z.a((View) this.c, 8);
    }

    public void l() {
        a(true, false);
    }

    public boolean m() {
        return this.u;
    }

    public void c(int i2) {
        this.v = i2;
        z.a(this.a, i2);
    }

    public boolean o() {
        com.bytedance.sdk.openadsdk.core.widget.e eVar = this.z;
        return eVar != null && eVar.a();
    }

    /* access modifiers changed from: package-private */
    public boolean x() {
        return !this.w.contains(b.a.alwayShowMediaView) || this.t;
    }

    public void a(Drawable drawable) {
        View view = this.a;
        if (view != null) {
            view.setBackgroundDrawable(drawable);
        }
    }

    public long getVideoProgress() {
        if (this.L <= 0) {
            n nVar = this.x;
            if (!(nVar == null || nVar.J() == null)) {
                this.L = (long) (this.x.J().f() * 1000.0d);
            }
            com.bykv.vk.openvk.component.video.api.d.c cVar = this.D;
            if (cVar != null) {
                this.L = cVar.j();
            }
        }
        return this.L;
    }
}
