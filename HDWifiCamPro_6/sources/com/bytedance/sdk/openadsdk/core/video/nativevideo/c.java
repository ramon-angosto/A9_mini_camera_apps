package com.bytedance.sdk.openadsdk.core.video.nativevideo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.c.c.b.o;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import com.bytedance.sdk.openadsdk.core.widget.e;
import com.bytedance.sdk.openadsdk.k.a.e;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

/* compiled from: NativeVideoController */
public class c extends com.bytedance.sdk.openadsdk.core.video.a.a {
    private boolean A;
    private String B;
    private boolean C;
    private boolean D;
    private WeakReference<c.b> E;
    private boolean F;
    private boolean G;
    private boolean H;
    private boolean I;
    /* access modifiers changed from: private */
    public WeakReference<c.d> J;
    /* access modifiers changed from: private */
    public WeakReference<a> K;
    private int L;
    private int M;
    private int N;
    /* access modifiers changed from: private */
    public boolean O;
    private boolean P;
    private com.bykv.vk.openvk.component.video.api.c.c Q;
    /* access modifiers changed from: private */
    public long R;
    private f S;
    private b T;
    private a.C0020a U;
    private int V;
    private long W;
    private long X;
    private long Y;
    private long Z;
    private final BroadcastReceiver aa;
    private final v.a ab;
    private int ac;
    private boolean ad;
    com.bytedance.sdk.openadsdk.core.f.f s;
    Runnable t;
    private final WeakReference<ViewGroup> u;
    /* access modifiers changed from: private */
    public long v = 0;
    /* access modifiers changed from: private */
    public long w = 0;
    /* access modifiers changed from: private */
    public c.a x;
    /* access modifiers changed from: private */
    public final boolean y;
    private boolean z;

    /* compiled from: NativeVideoController */
    public interface a {
        void a(int i);

        void f();
    }

    public void a(int i) {
    }

    public void a(Map<String, Object> map) {
    }

    public void g(boolean z2) {
        this.I = z2;
    }

    public void a(final NativeVideoTsView.a aVar) {
        if (this.m && this.d != null) {
            this.d.a((NativeVideoTsView.a) new NativeVideoTsView.a() {
                public void a(View view, int i) {
                    NativeVideoTsView.a aVar = aVar;
                    if (aVar != null) {
                        aVar.a(view, i);
                    }
                }
            });
        }
    }

    public void a(PAGNativeAd pAGNativeAd) {
        if (this.m && this.d != null) {
            this.d.a(pAGNativeAd);
        }
    }

    public void a(int i, int i2) {
        if (i != 0 && i2 != 0) {
            this.L = i;
            this.M = i2;
            l.b("CSJ_VIDEO_NativeController", "width=" + i + "height=" + i2);
        }
    }

    public void a(b bVar) {
        this.T = bVar;
    }

    private void a(Context context) {
        View view;
        EnumSet<E> noneOf = EnumSet.noneOf(b.a.class);
        noneOf.add(b.a.hideCloseBtn);
        noneOf.add(b.a.hideBackBtn);
        if (this.m) {
            view = b(context);
        } else {
            view = LayoutInflater.from(context.getApplicationContext()).inflate(t.f(context, "tt_video_detail_layout"), (ViewGroup) null, false);
        }
        View view2 = view;
        if (view2 != null) {
            if (this.m) {
                this.d = new e(context, view2, true, noneOf, this.e, this, G());
            } else {
                this.d = new d(context, view2, true, noneOf, this.e, this, false);
            }
            this.d.a((com.bykv.vk.openvk.component.video.api.d.a) this);
        }
    }

    private View b(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        relativeLayout.setId(t.e(context, "tt_root_view"));
        relativeLayout.setBackgroundColor(-16777216);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout2.setId(t.e(context, "tt_video_loading_retry_layout"));
        relativeLayout2.setBackgroundColor(0);
        relativeLayout2.setGravity(17);
        relativeLayout2.setLayoutParams(layoutParams);
        relativeLayout.addView(relativeLayout2);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setId(t.e(context, "tt_video_loading_cover_image"));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams2);
        relativeLayout2.addView(imageView);
        ProgressBar progressBar = new ProgressBar(context);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        progressBar.setId(t.e(context, "tt_video_loading_progress"));
        layoutParams3.addRule(13, -1);
        progressBar.setLayoutParams(layoutParams3);
        progressBar.setIndeterminateDrawable(t.c(context, "tt_video_loading_progress_bar"));
        relativeLayout2.addView(progressBar);
        ImageView imageView2 = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        imageView2.setId(t.e(context, "tt_video_play"));
        layoutParams4.addRule(13, -1);
        imageView2.setScaleType(ImageView.ScaleType.CENTER);
        imageView2.setImageResource(t.d(context, "tt_play_movebar_textpage"));
        imageView2.setVisibility(8);
        imageView2.setLayoutParams(layoutParams4);
        relativeLayout.addView(imageView2);
        ViewStub viewStub = new ViewStub(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        viewStub.setId(t.e(context, "tt_video_ad_cover"));
        viewStub.setLayoutParams(layoutParams5);
        viewStub.setLayoutResource(t.f(context, "tt_video_ad_cover_layout"));
        relativeLayout.addView(viewStub);
        ViewStub viewStub2 = new ViewStub(context);
        RelativeLayout.LayoutParams layoutParams6 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams6.addRule(13, -1);
        viewStub2.setId(t.e(context, "tt_video_draw_layout_viewStub"));
        viewStub2.setLayoutParams(layoutParams6);
        viewStub2.setLayoutResource(t.f(context, "tt_video_draw_btn_layout"));
        relativeLayout.addView(viewStub2);
        return relativeLayout;
    }

    public c(Context context, ViewGroup viewGroup, n nVar, String str, boolean z2, boolean z3, boolean z4, f fVar) {
        boolean z5 = false;
        this.z = false;
        this.A = false;
        this.B = "embeded_ad";
        this.C = false;
        this.D = true;
        this.F = false;
        this.G = false;
        this.H = true;
        this.I = true;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = false;
        this.P = true;
        this.U = new a.C0020a() {
            public void b(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
            }

            public void c(com.bykv.vk.openvk.component.video.api.a aVar) {
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        c.this.y();
                        e.a(c.this.e, 5);
                        if (c.this.s != null) {
                            c.this.s.a(9);
                        }
                    }
                });
                c.this.a(4);
                if (c.this.e.ax() != null && c.this.e.ax().a() != null) {
                    c.this.e.ax().a().d(c.this.f);
                }
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, long j) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        if (c.this.d != null) {
                            c.this.d.b();
                            c.this.k.removeCallbacks(c.this.t);
                            boolean unused = c.this.O = false;
                        }
                        if (!(!c.this.m || c.this.K == null || c.this.K.get() == null)) {
                            ((a) c.this.K.get()).f();
                        }
                        c.this.M();
                        c.this.k.removeCallbacks(c.this.t);
                        e.a(c.this.e, 0);
                        if (c.this.s != null) {
                            c.this.s.c();
                        }
                    }
                });
                c.this.H();
                long unused = c.this.R = System.currentTimeMillis();
            }

            public void b(com.bykv.vk.openvk.component.video.api.a aVar) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        if (!(c.this.J == null || c.this.J.get() == null)) {
                            ((c.d) c.this.J.get()).b_();
                        }
                        if (!c.this.y) {
                            c.this.H();
                        }
                        if (c.this.d != null) {
                            c.this.d.b();
                        }
                        c.this.k.removeCallbacks(c.this.t);
                        if (c.this.s != null) {
                            c.this.s.a(c.this.j(), c.this.p());
                        }
                    }
                });
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, final com.bykv.vk.openvk.component.video.api.c.a aVar2) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        int a2 = aVar2.a();
                        int b2 = aVar2.b();
                        c.this.b(a2, b2);
                        l.e("CSJ_VIDEO_NativeController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                        if (!c.this.u() || b2 == -1004) {
                            l.e("CSJ_VIDEO_NativeController", "Video play error： errorcode,extra、、、、、、、" + a2 + "," + b2);
                            if (c.this.d(a2, b2)) {
                                l.e("CSJ_VIDEO_NativeController", "Play video error，show result page、、、、、、、");
                                c.this.d.a(c.this.e, (WeakReference<Context>) c.this.h, false);
                                c.this.c(true);
                                c.this.f();
                            }
                            if (c.this.d != null) {
                                c.this.d.b();
                            }
                            if (c.this.x != null) {
                                c.this.x.b(c.this.w, com.bykv.vk.openvk.component.video.a.e.a.a(c.this.f, c.this.q));
                            }
                            if (!(c.this.J == null || c.this.J.get() == null || c.this.u())) {
                                ((c.d) c.this.J.get()).a(a2, b2);
                            }
                            e.a(c.this.e, 6);
                            if (c.this.s != null) {
                                c.this.s.a(14);
                            }
                        }
                    }
                });
                if (c.this.e != null && c.this.e.ax() != null && c.this.e.ax().a() != null) {
                    c.this.e.ax().a().a(com.bytedance.sdk.openadsdk.core.f.a.a.GENERAL_LINEAR_AD_ERROR);
                }
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, boolean z) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        if (c.this.d != null) {
                            c.this.d.b();
                        }
                    }
                });
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        c.this.I();
                    }
                });
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2, int i3) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        if (c.this.d != null) {
                            c.this.d.u();
                            c.this.k.postDelayed(c.this.t, 8000);
                            boolean unused = c.this.O = true;
                        }
                        e.a(c.this.e, 2);
                        if (c.this.s != null) {
                            c.this.s.a(4);
                        }
                    }
                });
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        c.this.d.b();
                        c.this.k.removeCallbacks(c.this.t);
                        boolean unused = c.this.O = false;
                        e.a(c.this.e, 0);
                        if (c.this.s != null) {
                            c.this.s.a(5);
                        }
                    }
                });
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, long j, long j2) {
                if (Math.abs(j - c.this.f) >= 50) {
                    final long j3 = j;
                    final long j4 = j2;
                    c.this.k.post(new Runnable() {
                        public void run() {
                            c.this.a(j3, j4);
                        }
                    });
                }
            }

            public void d(com.bykv.vk.openvk.component.video.api.a aVar) {
                if (!(c.this.e.ax() == null || c.this.e.ax().a() == null)) {
                    c.this.e.ax().a().b(c.this.f);
                }
                if (c.this.s != null) {
                    c.this.s.a(0);
                }
            }

            public void e(com.bykv.vk.openvk.component.video.api.a aVar) {
                if (!(c.this.e.ax() == null || c.this.e.ax().a() == null)) {
                    c.this.e.ax().a().c(c.this.f);
                }
                if (c.this.s != null) {
                    c.this.s.a(1);
                }
            }
        };
        this.V = 0;
        this.W = 0;
        this.t = new Runnable() {
            public void run() {
                if (c.this.d != null) {
                    c.this.d.a(c.this.e, (WeakReference<Context>) c.this.h, false);
                    c.this.d.b();
                    c.this.c(true);
                    l.e("CSJ_VIDEO_NativeController", "Show result page after error.......showAdCard");
                }
            }
        };
        this.X = 0;
        this.Y = 0;
        this.aa = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    c.this.b();
                }
            }
        };
        this.ab = new v.a() {
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
                c.this.c(context, i);
            }
        };
        this.ac = 1;
        this.ad = false;
        this.ac = o.c(context);
        a(z2);
        this.B = str;
        try {
            this.L = viewGroup.getWidth();
            this.M = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.u = new WeakReference<>(viewGroup);
        this.h = new WeakReference(context);
        this.e = nVar;
        a(context);
        this.y = Build.VERSION.SDK_INT >= 17 ? true : z5;
        this.C = z3;
        this.D = z4;
        if (fVar != null) {
            this.S = fVar;
        }
    }

    public c(Context context, ViewGroup viewGroup, n nVar, String str, boolean z2, boolean z3, f fVar) {
        boolean z4 = false;
        this.z = false;
        this.A = false;
        this.B = "embeded_ad";
        this.C = false;
        this.D = true;
        this.F = false;
        this.G = false;
        this.H = true;
        this.I = true;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.O = false;
        this.P = true;
        this.U = new a.C0020a() {
            public void b(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
            }

            public void c(com.bykv.vk.openvk.component.video.api.a aVar) {
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        c.this.y();
                        e.a(c.this.e, 5);
                        if (c.this.s != null) {
                            c.this.s.a(9);
                        }
                    }
                });
                c.this.a(4);
                if (c.this.e.ax() != null && c.this.e.ax().a() != null) {
                    c.this.e.ax().a().d(c.this.f);
                }
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, long j) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        if (c.this.d != null) {
                            c.this.d.b();
                            c.this.k.removeCallbacks(c.this.t);
                            boolean unused = c.this.O = false;
                        }
                        if (!(!c.this.m || c.this.K == null || c.this.K.get() == null)) {
                            ((a) c.this.K.get()).f();
                        }
                        c.this.M();
                        c.this.k.removeCallbacks(c.this.t);
                        e.a(c.this.e, 0);
                        if (c.this.s != null) {
                            c.this.s.c();
                        }
                    }
                });
                c.this.H();
                long unused = c.this.R = System.currentTimeMillis();
            }

            public void b(com.bykv.vk.openvk.component.video.api.a aVar) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        if (!(c.this.J == null || c.this.J.get() == null)) {
                            ((c.d) c.this.J.get()).b_();
                        }
                        if (!c.this.y) {
                            c.this.H();
                        }
                        if (c.this.d != null) {
                            c.this.d.b();
                        }
                        c.this.k.removeCallbacks(c.this.t);
                        if (c.this.s != null) {
                            c.this.s.a(c.this.j(), c.this.p());
                        }
                    }
                });
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, final com.bykv.vk.openvk.component.video.api.c.a aVar2) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        int a2 = aVar2.a();
                        int b2 = aVar2.b();
                        c.this.b(a2, b2);
                        l.e("CSJ_VIDEO_NativeController", "CALLBACK_ON_ERROR、、before isVideoPlaying、、、、、");
                        if (!c.this.u() || b2 == -1004) {
                            l.e("CSJ_VIDEO_NativeController", "Video play error： errorcode,extra、、、、、、、" + a2 + "," + b2);
                            if (c.this.d(a2, b2)) {
                                l.e("CSJ_VIDEO_NativeController", "Play video error，show result page、、、、、、、");
                                c.this.d.a(c.this.e, (WeakReference<Context>) c.this.h, false);
                                c.this.c(true);
                                c.this.f();
                            }
                            if (c.this.d != null) {
                                c.this.d.b();
                            }
                            if (c.this.x != null) {
                                c.this.x.b(c.this.w, com.bykv.vk.openvk.component.video.a.e.a.a(c.this.f, c.this.q));
                            }
                            if (!(c.this.J == null || c.this.J.get() == null || c.this.u())) {
                                ((c.d) c.this.J.get()).a(a2, b2);
                            }
                            e.a(c.this.e, 6);
                            if (c.this.s != null) {
                                c.this.s.a(14);
                            }
                        }
                    }
                });
                if (c.this.e != null && c.this.e.ax() != null && c.this.e.ax().a() != null) {
                    c.this.e.ax().a().a(com.bytedance.sdk.openadsdk.core.f.a.a.GENERAL_LINEAR_AD_ERROR);
                }
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, boolean z) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        if (c.this.d != null) {
                            c.this.d.b();
                        }
                    }
                });
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        c.this.I();
                    }
                });
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i, int i2, int i3) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        if (c.this.d != null) {
                            c.this.d.u();
                            c.this.k.postDelayed(c.this.t, 8000);
                            boolean unused = c.this.O = true;
                        }
                        e.a(c.this.e, 2);
                        if (c.this.s != null) {
                            c.this.s.a(4);
                        }
                    }
                });
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, int i) {
                c.this.k.post(new Runnable() {
                    public void run() {
                        c.this.d.b();
                        c.this.k.removeCallbacks(c.this.t);
                        boolean unused = c.this.O = false;
                        e.a(c.this.e, 0);
                        if (c.this.s != null) {
                            c.this.s.a(5);
                        }
                    }
                });
            }

            public void a(com.bykv.vk.openvk.component.video.api.a aVar, long j, long j2) {
                if (Math.abs(j - c.this.f) >= 50) {
                    final long j3 = j;
                    final long j4 = j2;
                    c.this.k.post(new Runnable() {
                        public void run() {
                            c.this.a(j3, j4);
                        }
                    });
                }
            }

            public void d(com.bykv.vk.openvk.component.video.api.a aVar) {
                if (!(c.this.e.ax() == null || c.this.e.ax().a() == null)) {
                    c.this.e.ax().a().b(c.this.f);
                }
                if (c.this.s != null) {
                    c.this.s.a(0);
                }
            }

            public void e(com.bykv.vk.openvk.component.video.api.a aVar) {
                if (!(c.this.e.ax() == null || c.this.e.ax().a() == null)) {
                    c.this.e.ax().a().c(c.this.f);
                }
                if (c.this.s != null) {
                    c.this.s.a(1);
                }
            }
        };
        this.V = 0;
        this.W = 0;
        this.t = new Runnable() {
            public void run() {
                if (c.this.d != null) {
                    c.this.d.a(c.this.e, (WeakReference<Context>) c.this.h, false);
                    c.this.d.b();
                    c.this.c(true);
                    l.e("CSJ_VIDEO_NativeController", "Show result page after error.......showAdCard");
                }
            }
        };
        this.X = 0;
        this.Y = 0;
        this.aa = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                    c.this.b();
                }
            }
        };
        this.ab = new v.a() {
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
                c.this.c(context, i);
            }
        };
        this.ac = 1;
        this.ad = false;
        this.ac = o.c(context);
        try {
            this.L = viewGroup.getWidth();
            this.M = viewGroup.getHeight();
        } catch (Throwable unused) {
        }
        this.u = new WeakReference<>(viewGroup);
        this.B = str;
        this.h = new WeakReference(context);
        this.e = nVar;
        a(context);
        this.y = Build.VERSION.SDK_INT >= 17 ? true : z4;
        this.C = z2;
        this.D = z3;
        if (fVar != null) {
            this.S = fVar;
        }
    }

    /* renamed from: F */
    public e o() {
        return this.d;
    }

    public com.bytedance.sdk.openadsdk.core.f.f a(View view, List<Pair<View, g>> list) {
        if (this.e == null || !this.e.aw()) {
            return null;
        }
        if (this.s == null) {
            this.s = com.bytedance.sdk.openadsdk.core.f.f.a();
        }
        this.s.a(view, this.e.ax().n());
        if (list != null && list.size() > 0) {
            for (Pair next : list) {
                if (next != null) {
                    this.s.a((View) next.first, next.second == null ? g.OTHER : (g) next.second);
                }
            }
        }
        return this.s;
    }

    public void a(c.d dVar) {
        this.J = new WeakReference<>(dVar);
    }

    public boolean a(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        b bVar = this.T;
        if (bVar != null) {
            bVar.a();
        }
        c(false);
        l.b("tag_video_play", "[video] start NativeVideoController#playVideoUrl and video url is :\r\n" + cVar.k());
        if (TextUtils.isEmpty(cVar.k())) {
            l.e("tag_video_play", "[video] play video stop , because no video info");
            return false;
        }
        this.Q = cVar;
        N();
        com.bytedance.sdk.openadsdk.core.f.f fVar = this.s;
        if (fVar != null) {
            fVar.a(false, 0.0f);
        }
        this.n = cVar.g();
        if (!com.bytedance.sdk.openadsdk.core.nativeexpress.n.b(this.B) || this.f <= 0) {
            this.f = cVar.f();
        }
        if (cVar.f() <= 0) {
            this.A = false;
            this.z = false;
        }
        if (cVar.f() > 0) {
            this.f = cVar.f();
            this.g = this.g > this.f ? this.g : this.f;
        }
        if (this.d != null) {
            this.d.a();
            if (this.V == 0) {
                this.d.g();
            }
            this.d.c(cVar.d(), cVar.e());
            this.d.c((ViewGroup) this.u.get());
            this.d.a(cVar.d(), cVar.e());
        }
        if (!(this.c != null || cVar.m() == -2 || cVar.m() == 1)) {
            this.c = new d();
        }
        if (this.c != null) {
            this.c.a(this.U);
        }
        A();
        l.b("tag_video_play", "[video] new MediaPlayer");
        this.w = 0;
        try {
            c(cVar);
            return true;
        } catch (Exception e) {
            l.e("tag_video_play", "[video] invoke NativeVideoController#playVideo cause exception :" + e.toString());
            return false;
        }
    }

    public int l() {
        return com.bykv.vk.openvk.component.video.a.e.a.a(this.g, this.q);
    }

    private void c(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        l.b("tag_video_play", "[video] NativeVideoController#playVideo has invoke !");
        if (cVar == null) {
            l.b("tag_video_play", "VideoUrlModel is null  !!!");
            return;
        }
        if (this.c != null) {
            if (this.e != null) {
                cVar.d(String.valueOf(this.e.aW()));
            }
            cVar.c(0);
            this.c.a(cVar);
            l.b("tag_video_play", "[video] MediaPlayerProxy has setDataSource !");
        }
        this.v = System.currentTimeMillis();
        if (!TextUtils.isEmpty(cVar.k())) {
            this.d.d(8);
            this.d.d(0);
            a((Runnable) new Runnable() {
                public void run() {
                    long unused = c.this.v = System.currentTimeMillis();
                    c.this.d.c(0);
                    if (c.this.c != null && c.this.f == 0) {
                        c.this.c.a(true, 0, c.this.n);
                    } else if (c.this.c != null) {
                        c.this.c.a(true, c.this.f, c.this.n);
                    }
                }
            });
        }
        if (this.m) {
            v();
        }
    }

    public void a(c.b bVar) {
        this.E = new WeakReference<>(bVar);
    }

    public long h() {
        if (n() == null) {
            return 0;
        }
        return n().o();
    }

    public int i() {
        if (n() == null) {
            return 0;
        }
        return n().p();
    }

    public long j() {
        if (n() == null) {
            return 0;
        }
        return n().q();
    }

    /* access modifiers changed from: private */
    public void y() {
        this.V++;
        if (C() && this.d != null) {
            this.d.b();
            c.a aVar = this.x;
            if (aVar != null) {
                aVar.a(this.w, com.bykv.vk.openvk.component.video.a.e.a.a(this.f, this.q));
            }
            this.w = System.currentTimeMillis() - this.v;
            if ((!this.e.aQ() || this.V >= 2) && this.I) {
                this.d.a(this.e, (WeakReference<Context>) this.h, true);
            }
            if (!this.A) {
                this.A = true;
                a(this.q, this.q);
                long j = this.q;
                this.f = j;
                this.g = j;
                o.a aVar2 = new o.a();
                aVar2.a(g());
                aVar2.c(j());
                aVar2.b(h());
                aVar2.f(i());
                com.bytedance.sdk.openadsdk.c.c.a.a.b(this.d, aVar2, this.S);
            }
            if (!this.m && this.p) {
                e(this.d, (View) null);
            }
            this.l = true;
            if (this.e.aQ() && this.V < 2) {
                a();
            }
        }
    }

    public void a(c.a aVar) {
        this.x = aVar;
    }

    public void b() {
        if (this.c != null) {
            this.c.b();
        }
        if (!this.A && this.z) {
            if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
                if (com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", true)) {
                    o.a aVar = new o.a();
                    aVar.a(g());
                    aVar.c(j());
                    aVar.b(h());
                    com.bytedance.sdk.openadsdk.c.c.a.a.a((com.bykv.vk.openvk.component.video.api.b.a) this.d, aVar);
                }
                com.bytedance.sdk.openadsdk.multipro.d.a.a("sp_multi_single_app_data_class", "IsCanLoadPauseLog", (Boolean) true);
                return;
            }
            if (r.a().b()) {
                o.a aVar2 = new o.a();
                aVar2.a(g());
                aVar2.c(j());
                aVar2.b(h());
                com.bytedance.sdk.openadsdk.c.c.a.a.a((com.bykv.vk.openvk.component.video.api.b.a) this.d, aVar2);
            }
            r.a().a(true);
        }
    }

    public void d() {
        if (this.d != null) {
            this.d.a();
        }
        if (this.d != null) {
            this.d.v();
        }
        z();
    }

    public void h(boolean z2) {
        if (this.d != null) {
            this.d.a();
        }
        if (this.d != null && z2) {
            this.d.v();
        }
        z();
    }

    private void z() {
        l.b("CSJ_VIDEO_NativeController", "resumeVideo:  mIsSurfaceValid = ", Boolean.valueOf(this.j));
        if (this.c != null) {
            if (this.c.m()) {
                if (this.j) {
                    E();
                } else {
                    b(this.r);
                }
                l.b("CSJ_VIDEO_NativeController", "resumeVideo: isPaused = true , mIsSurfaceValid = ", Boolean.valueOf(this.j));
            } else {
                this.c.a(false, this.f, this.n);
            }
        }
        if (this.z) {
            o.a aVar = new o.a();
            aVar.a(g());
            aVar.c(j());
            aVar.b(h());
            com.bytedance.sdk.openadsdk.c.c.a.a.b(o(), aVar);
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
        a(true, 3);
    }

    public void a(boolean z2, int i) {
        if (this.m) {
            this.W = j();
            a(1);
        }
        if (!this.A && this.z) {
            if (z2) {
                o.a aVar = new o.a();
                aVar.a(g());
                aVar.c(j());
                aVar.b(h());
                aVar.e(i);
                aVar.f(i());
                com.bytedance.sdk.openadsdk.c.c.a.a.a((com.bykv.vk.openvk.component.video.api.b.a) this.d, aVar, this.S);
                this.A = false;
            } else {
                o.a aVar2 = new o.a();
                aVar2.a(g());
                aVar2.c(j());
                aVar2.b(h());
                com.bytedance.sdk.openadsdk.c.c.a.a.a((com.bykv.vk.openvk.component.video.api.b.a) this.d, aVar2);
            }
        }
        f();
        com.bytedance.sdk.openadsdk.core.f.f fVar = this.s;
        if (fVar != null) {
            fVar.d();
        }
    }

    public void f() {
        if (this.c != null) {
            this.c.d();
            this.c = null;
        }
        if (!this.e.aQ() || this.V == 2) {
            if (this.I) {
                this.d.a(this.e, (WeakReference<Context>) this.h, true);
            } else {
                return;
            }
        }
        if (this.k != null) {
            this.k.removeCallbacksAndMessages((Object) null);
        }
        if (this.i != null) {
            this.i.clear();
        }
        if (this.m) {
            w();
        }
    }

    /* access modifiers changed from: private */
    public void H() {
        if (!this.z) {
            o.a aVar = new o.a();
            aVar.a(this.H);
            aVar.c(j());
            com.bytedance.sdk.openadsdk.c.c.a.a.a(m.a(), (com.bykv.vk.openvk.component.video.api.b.a) this.d, aVar, this.S);
            this.z = true;
        }
    }

    /* access modifiers changed from: private */
    public void b(int i, int i2) {
        if (this.e != null) {
            o.a aVar = new o.a();
            aVar.b(h());
            aVar.c(j());
            aVar.a(g());
            aVar.a(i);
            aVar.b(i2);
            com.bytedance.sdk.openadsdk.c.c.a.a.c(o(), aVar);
        }
    }

    /* access modifiers changed from: private */
    public void I() {
        int i;
        int i2;
        l.b("ChangeVideoSize", "[step-0]  TAG is 'ChangeVideoSize' ....... start  changeVideoSize >>>>>>>>>>>>>>>>>>>>>>>");
        try {
            if (!(this.h == null || this.h.get() == null || J() == null || this.c == null || this.u == null)) {
                if (this.u.get() != null) {
                    int j = this.c.j();
                    int k = this.c.k();
                    int width = ((ViewGroup) this.u.get()).getWidth();
                    int height = ((ViewGroup) this.u.get()).getHeight();
                    if (width > 0 && height > 0 && k > 0) {
                        if (j > 0) {
                            if (j == k) {
                                i2 = width > height ? height : width;
                                i = i2;
                            } else if (j > k) {
                                i2 = (int) ((((double) width) * 1.0d) / ((double) ((((float) j) * 1.0f) / ((float) k))));
                                i = width;
                            } else {
                                i = (int) ((((double) height) * 1.0d) / ((double) ((((float) k) * 1.0f) / ((float) j))));
                                i2 = height;
                            }
                            if (i2 > height || i2 <= 0) {
                                i2 = height;
                            }
                            if (i > width || i <= 0) {
                                i = width;
                            }
                            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i, i2);
                            layoutParams.addRule(13);
                            if (J() instanceof TextureView) {
                                ((TextureView) J()).setLayoutParams(layoutParams);
                                l.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to TextureView complete ! >>>>>>>");
                                return;
                            } else if (J() instanceof SurfaceView) {
                                ((SurfaceView) J()).setLayoutParams(layoutParams);
                                l.b("ChangeVideoSize", "[step-9] >>>>> setLayoutParams to SurfaceView complete !>>>>>>>");
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                    l.b("ChangeVideoSize", " container or video exist size <= 0");
                    return;
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[step-1] >>>>> mContextRef=");
            sb.append(this.h);
            sb.append(",mContextRef.get()=");
            sb.append(this.h != null ? (Context) this.h.get() : null);
            sb.append(",getIRenderView() =");
            sb.append(J());
            l.b("ChangeVideoSize", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append("[step-1] >>>>> mMediaPlayerProxy == null:");
            boolean z2 = true;
            sb2.append(this.c == null);
            sb2.append(",mMediaPlayerProxy.getMediaPlayer() == null:");
            if (this.c == null) {
                z2 = false;
            }
            sb2.append(z2);
            l.b("ChangeVideoSize", sb2.toString());
        } catch (Throwable th) {
            l.b("ChangeVideoSize", "[step-11] >>>>> changeVideoSize error !!!!! ：" + th.toString());
        }
    }

    private com.bykv.vk.openvk.component.video.api.renderview.b J() {
        if (this.h == null || this.h.get() == null || ((Context) this.h.get()).getResources().getConfiguration().orientation != 1 || this.d == null) {
            return null;
        }
        return this.d.q();
    }

    public void a(b bVar, View view) {
        if (this.c != null && C()) {
            if (this.c.l()) {
                b();
                this.d.b(true, false);
                this.d.f();
            } else if (!this.c.m()) {
                if (this.d != null) {
                    this.d.c((ViewGroup) this.u.get());
                }
                d(this.f);
                if (this.d != null) {
                    this.d.b(false, false);
                }
            } else {
                h(false);
                if (this.d != null) {
                    this.d.b(false, false);
                }
            }
        }
    }

    public void a(b bVar, int i) {
        if (this.c != null) {
            a(this.Z, c(i));
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
                this.Z = (long) ((int) n);
            } else {
                this.Z = 0;
            }
            if (this.d != null) {
                this.d.a(this.Z);
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
            if (this.x != null) {
                this.x.a(j, j2);
            }
        } catch (Throwable th) {
            l.c("CSJ_VIDEO_NativeController", "onProgressUpdate error: ", th);
        }
        if (this.e.ax() != null && this.e.ax().a() != null) {
            this.e.ax().a().a(j, j2, this.s);
        }
    }

    public void b(b bVar, View view) {
        b(bVar, view, false, false);
    }

    public void b(b bVar, View view, boolean z2, boolean z3) {
        if (C()) {
            f(!this.p);
            if (!(this.h.get() instanceof Activity)) {
                l.b("CSJ_VIDEO_NativeController", "context is not activity, not support this function.");
                return;
            }
            if (this.p) {
                b(z2 ? 8 : 0);
                if (this.d != null) {
                    this.d.a((ViewGroup) this.u.get());
                    this.d.c(false);
                }
            } else {
                b(1);
                if (this.d != null) {
                    this.d.b((ViewGroup) this.u.get());
                    this.d.c(false);
                }
            }
            WeakReference<c.b> weakReference = this.E;
            c.b bVar2 = weakReference != null ? (c.b) weakReference.get() : null;
            if (bVar2 != null) {
                bVar2.a(this.p);
            }
        }
    }

    public void b(int i) {
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
        e();
    }

    public void a(b bVar, View view, boolean z2, boolean z3) {
        if (this.m) {
            b();
        }
        if (z2 && !this.m && !t()) {
            this.d.b(!u(), false);
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
                this.d.b((ViewGroup) this.u.get());
            }
            b(1);
            return;
        }
        e();
    }

    public void e(b bVar, View view) {
        a(bVar, view, false);
    }

    public void a(b bVar, View view, boolean z2) {
        K();
    }

    private void K() {
        if (C()) {
            f(!this.p);
            if (!(this.h.get() instanceof Activity)) {
                l.b("CSJ_VIDEO_NativeController", "context is not activity, not support this function.");
                return;
            }
            if (this.d != null) {
                this.d.b((ViewGroup) this.u.get());
                this.d.c(false);
            }
            b(1);
            WeakReference<c.b> weakReference = this.E;
            c.b bVar = weakReference != null ? (c.b) weakReference.get() : null;
            if (bVar != null) {
                bVar.a(this.p);
            }
        }
    }

    public boolean t() {
        return this.c == null || this.c.h();
    }

    public void a() {
        if (com.bytedance.sdk.component.utils.o.c(m.a()) != 0) {
            f();
            com.bykv.vk.openvk.component.video.api.c.c cVar = this.Q;
            if (cVar != null) {
                cVar.b(this.e.Y());
                this.Q.a(this.L);
                this.Q.b(this.M);
                this.Q.a((List<String>) null);
                this.Q.c(this.e.ac());
                this.Q.a(0);
                this.Q.a(p());
                com.bykv.vk.openvk.component.video.api.c.c cVar2 = this.Q;
                cVar2.a(cVar2.a());
                a(this.Q);
                c(false);
            }
        }
    }

    public boolean u() {
        return this.c != null && this.c.l();
    }

    private void a(long j, boolean z2) {
        if (this.c != null) {
            if (z2) {
                L();
            }
            this.c.a(j);
        }
    }

    private boolean c(int i) {
        return this.d.b(i);
    }

    private void L() {
        if (this.d != null) {
            this.d.c(0);
            this.d.a(false, false);
            this.d.c(false);
            this.d.e();
            this.d.g();
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.video.nativevideo.c$8  reason: invalid class name */
    /* compiled from: NativeVideoController */
    static /* synthetic */ class AnonymousClass8 {
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
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.video.nativevideo.c.AnonymousClass8.<clinit>():void");
        }
    }

    public void a(e.a aVar, String str) {
        int i = AnonymousClass8.a[aVar.ordinal()];
        if (i == 1) {
            b();
        } else if (i == 2) {
            e();
        } else if (i == 3) {
            d();
            this.o = false;
            this.F = true;
        }
    }

    private boolean c(int i, int i2) {
        if (i2 == 0) {
            b();
            this.o = true;
            if (this.d != null) {
                this.d.a(this.e, (WeakReference<Context>) this.h, false);
            }
        }
        if (i2 != 4 && i2 != 0) {
            if (this.d != null) {
                this.d.a();
            }
            b();
            this.o = true;
            this.F = false;
            if (!(this.d == null || this.e == null)) {
                return this.d.a(i, this.e.J(), this.D);
            }
        } else if (i2 == 4) {
            this.o = false;
            if (this.d != null) {
                this.d.s();
            }
        }
        return true;
    }

    private void b(Context context, int i) {
        if (C() && context != null && this.ac != i) {
            this.ac = i;
            if (!(i == 4 || i == 0)) {
                this.F = false;
            }
            if (!this.F && !q() && this.C) {
                c(2, i);
            }
            WeakReference<a> weakReference = this.K;
            if (weakReference != null && weakReference.get() != null) {
                ((a) this.K.get()).a(this.ac);
            }
        }
    }

    /* access modifiers changed from: private */
    public void c(Context context, int i) {
        b(context, i);
        if (i == 4) {
            this.o = false;
        }
    }

    public void a(Context context, int i) {
        b(context, i);
        if (i == 4) {
            this.o = false;
            d();
        }
    }

    public void v() {
        if (!this.ad && this.P) {
            Context applicationContext = m.a().getApplicationContext();
            this.ad = true;
            v.a(this.ab, applicationContext);
        }
    }

    public void w() {
        if (this.ad && this.P) {
            m.a().getApplicationContext();
            this.ad = false;
            v.a(this.ab);
        }
    }

    public void a(a aVar) {
        this.K = new WeakReference<>(aVar);
    }

    public void c(boolean z2) {
        this.l = z2;
    }

    public void d(boolean z2) {
        this.H = z2;
    }

    public boolean r() {
        return this.O;
    }

    public void e(boolean z2) {
        this.P = z2;
    }

    public void b(com.bykv.vk.openvk.component.video.api.c.c cVar) {
        this.Q = cVar;
    }

    /* access modifiers changed from: private */
    public boolean d(int i, int i2) {
        l.b("TTVideoLandingPage", "OnError - Error code: " + i + " Extra code: " + i2);
        boolean z2 = i == -1010 || i == -1007 || i == -1004 || i == -110 || i == 100 || i == 200;
        if (i2 == 1 || i2 == 700 || i2 == 800) {
            return true;
        }
        return z2;
    }

    public void x() {
        com.bytedance.sdk.openadsdk.core.f.f fVar = this.s;
        if (fVar != null) {
            fVar.a(13);
        }
    }

    public long k() {
        return g() + h();
    }

    /* access modifiers changed from: private */
    public void M() {
        if (this.e != null) {
            com.bytedance.sdk.openadsdk.c.a.c.a(com.bytedance.sdk.openadsdk.k.a.a(this.e.T(), true, this.e));
        }
    }

    private void N() {
        if (this.h != null) {
            com.bytedance.sdk.openadsdk.c.c.a.a.a(this.e, (com.bykv.vk.openvk.component.video.api.b.a) this.d, this.Q);
        }
    }

    public void b(final boolean z2) {
        super.b(z2);
        if (this.s == null) {
            return;
        }
        if (com.bykv.vk.openvk.component.video.a.c.a.b()) {
            this.s.a(z2);
        } else {
            this.k.post(new Runnable() {
                public void run() {
                    c.this.s.a(z2);
                }
            });
        }
    }
}
