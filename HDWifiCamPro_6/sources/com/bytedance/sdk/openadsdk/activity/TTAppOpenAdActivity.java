package com.bytedance.sdk.openadsdk.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.g.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.t;
import com.bytedance.sdk.component.utils.x;
import com.bytedance.sdk.openadsdk.AdSlot;
import com.bytedance.sdk.openadsdk.FilterWord;
import com.bytedance.sdk.openadsdk.IListenerManager;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.a.d.c;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.bytedance.sdk.openadsdk.c.f;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeDialog;
import com.bytedance.sdk.openadsdk.common.TTAdDislikeToast;
import com.bytedance.sdk.openadsdk.component.c;
import com.bytedance.sdk.openadsdk.component.f.a;
import com.bytedance.sdk.openadsdk.component.h.d;
import com.bytedance.sdk.openadsdk.component.view.ButtonFlash;
import com.bytedance.sdk.openadsdk.component.view.OpenScreenAdBackupView;
import com.bytedance.sdk.openadsdk.component.view.OpenScreenAdExpressView;
import com.bytedance.sdk.openadsdk.component.view.OpenScreenAdVideoExpressView;
import com.bytedance.sdk.openadsdk.core.b.b;
import com.bytedance.sdk.openadsdk.core.m;
import com.bytedance.sdk.openadsdk.core.model.k;
import com.bytedance.sdk.openadsdk.core.model.n;
import com.bytedance.sdk.openadsdk.core.nativeexpress.NativeExpressView;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.core.r;
import com.bytedance.sdk.openadsdk.core.settings.j;
import com.bytedance.sdk.openadsdk.k.a.e;
import com.bytedance.sdk.openadsdk.l.h;
import com.bytedance.sdk.openadsdk.l.z;
import com.bytedance.sdk.openadsdk.multipro.b;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class TTAppOpenAdActivity extends Activity implements x.a {
    private static c h;
    /* access modifiers changed from: private */
    public String A;
    /* access modifiers changed from: private */
    public n B;
    private IListenerManager C;
    /* access modifiers changed from: private */
    public c D;
    private final c.a E = new c.a() {
        public void a(long j, int i) {
            l.a("TTAppOpenAdActivity", "open_ad", "onComplete() called with: l = [" + j + "], i = [" + i + "]");
        }

        public void b(long j, int i) {
            l.a("TTAppOpenAdActivity", "open_ad", "onError() called with: totalPlayTime = [" + j + "], percent = [" + i + "]");
            TTAppOpenAdActivity.this.z();
            TTAppOpenAdActivity.this.finish();
        }

        public void a() {
            l.a("TTAppOpenAdActivity", "open_ad", "onTimeOut");
            TTAppOpenAdActivity.this.z();
            TTAppOpenAdActivity.this.finish();
        }

        public void a(long j, long j2) {
            TTAppOpenAdActivity.this.j.a(j);
            if (!TTAppOpenAdActivity.this.e && TTAppOpenAdActivity.this.s != null && TTAppOpenAdActivity.this.s.b()) {
                TTAppOpenAdActivity.this.s.d();
            }
            TTAppOpenAdActivity.this.u();
        }
    };
    /* access modifiers changed from: private */
    public int F;
    private int G;
    /* access modifiers changed from: private */
    public NativeExpressView H;
    private final a I = new a() {
        public void a(View view) {
            TTAppOpenAdActivity.this.a();
        }

        public void b(View view) {
            TTAppOpenAdActivity.this.b();
        }

        public void a() {
            l.a("TTAppOpenAdActivity", "open_ad", "onCountDownFinish() called");
            if (b.c()) {
                TTAppOpenAdActivity.this.a("onAdTimeOver");
            } else if (TTAppOpenAdActivity.this.D != null) {
                TTAppOpenAdActivity.this.D.d();
            }
            TTAppOpenAdActivity.this.finish();
        }

        public void a(int i, int i2) {
            if (TTAppOpenAdActivity.this.H != null && !TTAppOpenAdActivity.this.H.q()) {
                TTAppOpenAdActivity.this.H.a(String.valueOf(i), i2, 0, false);
            }
        }
    };
    private FrameLayout J;
    /* access modifiers changed from: private */
    public boolean K;
    private final Runnable L = new Runnable() {
        public void run() {
            if (!TTAppOpenAdActivity.this.l.get()) {
                f unused = TTAppOpenAdActivity.this.x = new f();
                TTAppOpenAdActivity.this.x.a(System.currentTimeMillis(), 1.0f);
                TTAppOpenAdActivity.this.w.d();
                if (TTAppOpenAdActivity.this.r != null && !TTAppOpenAdActivity.this.r.isStarted()) {
                    TTAppOpenAdActivity.this.r.start();
                }
                TTAppOpenAdActivity.this.y();
                View findViewById = TTAppOpenAdActivity.this.findViewById(16908290);
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("width", findViewById.getWidth());
                    jSONObject.put("height", findViewById.getHeight());
                    jSONObject.put("alpha", (double) findViewById.getAlpha());
                    HashMap hashMap = new HashMap();
                    hashMap.put("root_view", jSONObject.toString());
                    hashMap.put("ad_root", Integer.valueOf(TTAppOpenAdActivity.this.F));
                    hashMap.put("openad_creative_type", TTAppOpenAdActivity.this.y ? "video_normal_ad" : "image_normal_ad");
                    if (com.bytedance.sdk.openadsdk.component.view.a.c() == null) {
                        hashMap.put("appicon_acquirefail", "1");
                    }
                    if (TTAppOpenAdActivity.this.K) {
                        hashMap.put("dynamic_show_type", Integer.valueOf(TTAppOpenAdActivity.this.H.getDynamicShowType()));
                    }
                    com.bytedance.sdk.openadsdk.c.c.a(m.a(), TTAppOpenAdActivity.this.B, "open_ad", (Map<String, Object>) hashMap, (Double) null);
                    e.a(TTAppOpenAdActivity.this.findViewById(16908290), TTAppOpenAdActivity.this.B, TTAppOpenAdActivity.this.K ? TTAppOpenAdActivity.this.H.getDynamicShowType() : -1);
                    TTAppOpenAdActivity.this.l.set(true);
                } catch (JSONException e) {
                    Log.e("TTAppOpenAdActivity", "run: ", e);
                    TTAppOpenAdActivity.this.finish();
                }
            }
        }
    };
    protected final AtomicBoolean a = new AtomicBoolean(false);
    protected final x b = new x(Looper.getMainLooper(), this);
    final AtomicBoolean c = new AtomicBoolean(false);
    final AtomicBoolean d = new AtomicBoolean(false);
    protected boolean e = false;
    TTAdDislikeDialog f;
    TTAdDislikeToast g;
    private final com.bytedance.sdk.openadsdk.component.view.a i = new com.bytedance.sdk.openadsdk.component.view.a();
    /* access modifiers changed from: private */
    public final com.bytedance.sdk.openadsdk.component.h.a j = new com.bytedance.sdk.openadsdk.component.h.a();
    private final com.bytedance.sdk.openadsdk.component.f.b k = new com.bytedance.sdk.openadsdk.component.f.b(this.j);
    /* access modifiers changed from: private */
    public final AtomicBoolean l = new AtomicBoolean(false);
    private RelativeLayout m;
    private FrameLayout n;
    private ImageView o;
    private TextView p;
    private ButtonFlash q;
    /* access modifiers changed from: private */
    public ValueAnimator r;
    /* access modifiers changed from: private */
    public d s;
    private float t;
    private float u;
    private ImageView v;
    /* access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.l.x w = com.bytedance.sdk.openadsdk.l.x.b();
    /* access modifiers changed from: private */
    public f x;
    /* access modifiers changed from: private */
    public boolean y;
    private int z;

    /* access modifiers changed from: package-private */
    public void a() {
        l.a("TTAppOpenAdActivity", "open_ad", "onUserWantSkip() called");
        p.c(this.z);
        z();
        d dVar = this.s;
        if (dVar != null) {
            dVar.a(4);
        }
        com.bytedance.sdk.openadsdk.component.d.a.a(this.B, (int) this.j.b(), this.k.c(), this.j.a());
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (b(bundle)) {
            if (!PAGSdk.isInitSuccess()) {
                finish();
            }
            this.y = n.c(this.B);
            l.a("TTAppOpenAdActivity", "open_ad", "onCreate: isVideo is " + this.y);
            if (this.y) {
                this.j.a((float) this.B.J().f());
            } else {
                this.j.a((float) m.d().t(String.valueOf(this.z)));
            }
            l();
            this.k.a(this.I);
            this.J = new FrameLayout(this);
            this.J.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            setContentView(this.J);
            this.J.post(new Runnable() {
                public void run() {
                    TTAppOpenAdActivity.this.g();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void g() {
        Pair<Float, Float> a2 = com.bytedance.sdk.openadsdk.core.nativeexpress.a.a.a(getWindow(), this.G);
        AdSlot build = new AdSlot.Builder().setCodeId(String.valueOf(this.B.aW())).setExpressViewAcceptedSize(((Float) a2.first).floatValue(), ((Float) a2.second).floatValue()).build();
        AnonymousClass10 r0 = new com.bytedance.sdk.openadsdk.component.h.b() {
            public void a() {
                boolean q = TTAppOpenAdActivity.this.H.q();
                l.a("TTAppOpenAdActivity", "open_ad", "onRenderSuccess() called. isBackupShow=" + q);
                if (!q) {
                    TTAppOpenAdActivity.this.p();
                    TTAppOpenAdActivity.this.w.d();
                    TTAppOpenAdActivity.this.x();
                }
            }

            public void b() {
                TTAppOpenAdActivity.this.b();
            }
        };
        n.a G2 = this.B.G();
        int q2 = this.B.q();
        if (G2 != null) {
            l.a("TTAppOpenAdActivity", "open_ad", "tryDynamicNative: id is " + G2.b() + ", renderSequence is " + q2);
        }
        boolean z2 = true;
        this.B.h(1);
        if (this.y) {
            this.H = new OpenScreenAdVideoExpressView(this, this.B, build, "open_ad", this.I, this.E, r0, new com.bytedance.sdk.openadsdk.core.video.nativevideo.b() {
                public void a() {
                    if (!TTAppOpenAdActivity.this.isFinishing()) {
                        TTAppOpenAdActivity.this.t();
                    }
                }
            });
        } else {
            this.H = new OpenScreenAdExpressView(this, this.B, build, "open_ad", this.I, r0);
        }
        this.J.addView(this.H, new FrameLayout.LayoutParams(-1, -1));
        n nVar = this.B;
        if (!(nVar != null && nVar.l() == 2 && q2 == 3)) {
            z2 = false;
        }
        this.K = z2;
        if (this.K) {
            com.com.bytedance.overseas.sdk.a.c h2 = h();
            com.bytedance.sdk.openadsdk.core.nativeexpress.e eVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.e(this, this.B, "open_ad", 4);
            eVar.a((View) this.H);
            eVar.a(h2);
            com.bytedance.sdk.openadsdk.component.a.b.a((com.bytedance.sdk.openadsdk.core.b.b) eVar, this.B);
            this.H.setClickListener(eVar);
            com.bytedance.sdk.openadsdk.core.nativeexpress.d dVar = new com.bytedance.sdk.openadsdk.core.nativeexpress.d(this, this.B, "open_ad", 4);
            dVar.a((View) this.H);
            dVar.a(h2);
            com.bytedance.sdk.openadsdk.component.a.b.a((com.bytedance.sdk.openadsdk.core.b.b) dVar, this.B);
            this.H.setClickCreativeListener(dVar);
            dVar.a((b.a) new b.a() {
                public void a(View view, int i) {
                    TTAppOpenAdActivity.this.n();
                }
            });
            this.H.setBackupListener(new com.bytedance.sdk.component.adexpress.b.c() {
                public boolean a(ViewGroup viewGroup, int i) {
                    l.a("TTAppOpenAdActivity", "open_ad", "isUseBackup() called with: view = [" + viewGroup + "], errCode = [" + i + "]");
                    try {
                        ((NativeExpressView) viewGroup).p();
                        TTAppOpenAdActivity.this.i();
                        return true;
                    } catch (Exception e) {
                        Log.e("TTAppOpenAdActivity", "", e);
                        return false;
                    }
                }
            });
            this.H.m();
            return;
        }
        i();
    }

    private com.com.bytedance.overseas.sdk.a.c h() {
        if (this.B.L() == 4) {
            return com.com.bytedance.overseas.sdk.a.d.a(getApplicationContext(), this.B, "open_ad");
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void i() {
        l.a("TTAppOpenAdActivity", "open_ad", "performNativeRender() called");
        OpenScreenAdBackupView openScreenAdBackupView = new OpenScreenAdBackupView(this);
        openScreenAdBackupView.a(this.H, this.B);
        if (this.B.d() == 3 && this.G != 2) {
            this.G = 2;
            k();
        }
        a(openScreenAdBackupView);
        m();
        o();
    }

    private void j() {
        if (this.G != 2) {
            setRequestedOrientation(1);
        } else if (f()) {
            setRequestedOrientation(8);
        } else {
            setRequestedOrientation(0);
        }
        if (this.G == 2 || !z.c((Activity) this)) {
            getWindow().addFlags(1024);
        }
    }

    private void k() {
        int i2;
        int i3;
        l.a("TTAppOpenAdActivity", "open_ad", "changeScreenOrientation: mOrientation=" + this.G);
        if (Build.VERSION.SDK_INT != 26) {
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    j();
                } catch (Throwable th) {
                    th.printStackTrace();
                    return;
                }
            } else {
                j();
            }
        }
        Context applicationContext = getApplicationContext();
        Pair<Integer, Integer> h2 = z.h(applicationContext);
        if (this.G == 2) {
            i2 = Math.max(((Integer) h2.first).intValue(), ((Integer) h2.second).intValue());
            i3 = Math.min(((Integer) h2.first).intValue(), ((Integer) h2.second).intValue());
        } else {
            i2 = Math.min(((Integer) h2.first).intValue(), ((Integer) h2.second).intValue());
            i3 = Math.max(((Integer) h2.first).intValue(), ((Integer) h2.second).intValue());
        }
        this.t = (float) i3;
        this.u = (float) i2;
        float k2 = z.k(applicationContext);
        if (z.c((Activity) this)) {
            int i4 = this.G;
            if (i4 == 1) {
                this.t -= k2;
            } else if (i4 == 2) {
                this.u -= k2;
            }
        }
    }

    private void l() {
        if (26 != Build.VERSION.SDK_INT) {
            this.G = this.B.am();
        } else if (getResources().getConfiguration().orientation == 1) {
            this.G = 1;
        } else {
            this.G = 2;
        }
        k();
    }

    private void a(OpenScreenAdBackupView openScreenAdBackupView) {
        this.m = (RelativeLayout) openScreenAdBackupView.findViewById(t.e(this, "tt_open_ad_container"));
        this.v = (ImageView) openScreenAdBackupView.findViewById(t.e(this, "tt_open_ad_back_image"));
        this.n = (FrameLayout) openScreenAdBackupView.findViewById(t.e(this, "tt_open_ad_video_container"));
        this.o = (ImageView) openScreenAdBackupView.findViewById(t.e(this, "tt_open_ad_image"));
        this.q = (ButtonFlash) openScreenAdBackupView.findViewById(t.e(this, "tt_open_ad_click_button"));
        this.p = (TextView) openScreenAdBackupView.findViewById(t.e(this, "tt_ad_logo"));
        this.i.a(this, openScreenAdBackupView, this.B, this.u, this.t, this.y);
        this.k.a(this, openScreenAdBackupView);
    }

    private void m() {
        this.p.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    TTWebsiteActivity.a(TTAppOpenAdActivity.this, TTAppOpenAdActivity.this.B, "open_ad");
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
        com.bytedance.sdk.openadsdk.component.a.b bVar = new com.bytedance.sdk.openadsdk.component.a.b(this.B, this);
        bVar.a((b.a) new b.a() {
            public void a(View view, int i) {
                TTAppOpenAdActivity.this.n();
            }
        });
        com.bytedance.sdk.openadsdk.component.a.a a2 = bVar.a();
        if (this.B.c() == 1) {
            this.m.setOnClickListener(a2);
            this.m.setOnTouchListener(a2);
        }
        this.q.setOnClickListener(a2);
        this.q.setOnTouchListener(a2);
    }

    /* access modifiers changed from: private */
    public void n() {
        l.a("TTAppOpenAdActivity", "open_ad", "callbackAdClick() called");
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            a("onAdClicked");
            return;
        }
        com.bytedance.sdk.openadsdk.a.d.c cVar = this.D;
        if (cVar != null) {
            cVar.b();
        }
    }

    private void o() {
        this.i.a();
        this.q.setText(this.B.W());
        p();
        if (this.y) {
            a(0);
            b(8);
            r();
        } else {
            a(8);
            b(0);
            q();
        }
        this.w.d();
        x();
    }

    /* access modifiers changed from: private */
    public void p() {
        Log.d("TTAppOpenAdActivity", "startCountDownTimer() called");
        this.k.b(m.d().s(String.valueOf(this.z)));
        this.k.a(this.j.a());
        this.r = this.k.b();
        this.k.a(0);
    }

    private void q() {
        k kVar = this.B.P().get(0);
        h.a(new com.bytedance.sdk.openadsdk.i.a(kVar.a(), kVar.g()), kVar.b(), kVar.c(), new h.a() {
            public void a() {
            }

            public void b() {
            }

            public void a(com.bytedance.sdk.openadsdk.i.a.b bVar) {
                if (bVar.d()) {
                    TTAppOpenAdActivity.this.a(bVar);
                    if (bVar.b() != null) {
                        TTAppOpenAdActivity.this.a(bVar.a());
                    }
                }
            }
        }, com.bytedance.sdk.openadsdk.component.g.a.b(TextUtils.isEmpty(kVar.g()) ? com.bytedance.sdk.component.utils.e.a(kVar.a()) : kVar.g()).getParent(), 25);
    }

    /* access modifiers changed from: private */
    public void a(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                this.v.setImageDrawable(new BitmapDrawable(m.a().getResources(), bitmap));
            } catch (Throwable unused) {
                l.c("TTAppOpenAdActivity", "open_ad", "bindBackGroundImage error");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(com.bytedance.sdk.openadsdk.i.a.b bVar) {
        if (bVar.b() != null) {
            this.o.setImageBitmap(bVar.b());
        } else if (this.B.P() != null && this.B.P().get(0) != null) {
            Drawable a2 = h.a(bVar.c(), this.B.P().get(0).b());
            this.o.setScaleType(ImageView.ScaleType.FIT_CENTER);
            this.o.setImageDrawable(a2);
        }
    }

    private void r() {
        boolean z2;
        this.s = new d(this);
        this.s.a(this.n, this.B);
        this.s.a(this.E);
        try {
            z2 = this.s.a();
        } catch (Throwable th) {
            l.c("TTAppOpenAdActivity", "open_ad", "ttAppOpenAd playVideo error: " + th.getMessage());
            z2 = false;
        }
        if (z2) {
            t();
        } else {
            finish();
        }
        com.bytedance.sdk.openadsdk.component.c.a(this.B, (c.d) new c.d() {
            public void a() {
            }

            public void a(Bitmap bitmap) {
                TTAppOpenAdActivity.this.a(bitmap);
            }
        }, 25);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        z.a((View) this.n, i2);
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        z.a((View) this.o, i2);
    }

    /* access modifiers changed from: protected */
    public void b() {
        if (!isFinishing()) {
            if (this.d.get()) {
                v();
                return;
            }
            if (this.f == null) {
                s();
            }
            this.f.a();
        }
    }

    private void s() {
        if (this.f == null) {
            this.f = new TTAdDislikeDialog((Context) this, this.B);
            this.f.setCallback(new TTAdDislikeDialog.a() {
                public void c(View view) {
                }

                public void a(View view) {
                    TTAppOpenAdActivity.this.c.set(true);
                    TTAppOpenAdActivity.this.d();
                }

                public void b(View view) {
                    TTAppOpenAdActivity.this.c.set(false);
                    TTAppOpenAdActivity.this.c();
                }

                public void a(int i, FilterWord filterWord) {
                    if (!TTAppOpenAdActivity.this.d.get() && filterWord != null && !filterWord.hasSecondOptions()) {
                        TTAppOpenAdActivity.this.d.set(true);
                        TTAppOpenAdActivity.this.w();
                    }
                }
            });
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(16908290);
        frameLayout.addView(this.f);
        if (this.g == null) {
            this.g = new TTAdDislikeToast(this);
            frameLayout.addView(this.g);
        }
    }

    /* access modifiers changed from: private */
    public void t() {
        if (this.y) {
            this.b.sendEmptyMessageDelayed(100, DefaultRenderersFactory.DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS);
        }
    }

    /* access modifiers changed from: private */
    public void u() {
        this.b.removeMessages(100);
    }

    private void v() {
        this.g.a(j.d);
    }

    /* access modifiers changed from: private */
    public void w() {
        this.g.a(j.e);
    }

    public void onBackPressed() {
        if (m.d().r(String.valueOf(this.z)) == 1) {
            if (this.j.b() >= ((long) m.d().s(String.valueOf(this.z))) * 1000) {
                a();
            }
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (z2) {
            if (!this.K) {
                this.w.d();
            }
        } else if (this.l.get()) {
            if (this.w.e()) {
                com.bytedance.sdk.openadsdk.c.c.a(String.valueOf(this.w.c()), this.B, "open_ad", this.x);
            }
            this.w = com.bytedance.sdk.openadsdk.l.x.b();
        }
        e.a(this.B, z2 ? 4 : 8);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.e = true;
        if (this.a.getAndSet(true)) {
            c();
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.e = false;
        d();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.b.removeCallbacksAndMessages((Object) null);
        e.a(this.B);
        if (this.y) {
            com.bytedance.sdk.openadsdk.component.d.a.a(this.B, this.j.b(), this.j.a(), true);
        } else {
            com.bytedance.sdk.openadsdk.component.d.a.a(this.B, -1, this.j.a(), false);
        }
        if (this.w.e() && this.l.get()) {
            com.bytedance.sdk.openadsdk.c.c.a(String.valueOf(this.w.c()), this.B, "open_ad", this.x);
            this.w = com.bytedance.sdk.openadsdk.l.x.b();
        }
        ButtonFlash buttonFlash = this.q;
        if (buttonFlash != null) {
            buttonFlash.a();
        }
        d dVar = this.s;
        if (dVar != null) {
            dVar.f();
        }
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            a("recycleRes");
        }
        ValueAnimator valueAnimator = this.r;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        h = null;
        this.D = null;
        TTAdDislikeDialog tTAdDislikeDialog = this.f;
        if (tTAdDislikeDialog != null) {
            tTAdDislikeDialog.setCallback((TTAdDislikeDialog.a) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (this.y) {
            d dVar = this.s;
            if (dVar != null && dVar.c()) {
                this.s.e();
            }
            NativeExpressView nativeExpressView = this.H;
            if (nativeExpressView instanceof OpenScreenAdVideoExpressView) {
                ((OpenScreenAdVideoExpressView) nativeExpressView).k();
            }
            NativeExpressView nativeExpressView2 = this.H;
            if ((nativeExpressView2 != null && nativeExpressView2.q()) || this.y) {
                t();
            }
        }
        if (this.r != null && Build.VERSION.SDK_INT >= 19) {
            this.r.resume();
        }
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (this.y) {
            d dVar = this.s;
            if (dVar != null && dVar.b()) {
                this.s.d();
            }
            u();
            NativeExpressView nativeExpressView = this.H;
            if (nativeExpressView instanceof OpenScreenAdVideoExpressView) {
                ((OpenScreenAdVideoExpressView) nativeExpressView).j();
            }
        }
        if (this.r != null && Build.VERSION.SDK_INT >= 19) {
            this.r.pause();
        }
    }

    /* access modifiers changed from: private */
    public void x() {
        if (!this.l.get()) {
            try {
                getWindow().getDecorView().post(this.L);
            } catch (Throwable unused) {
                finish();
            }
        }
    }

    /* access modifiers changed from: private */
    public void y() {
        l.a("TTAppOpenAdActivity", "open_ad", "callbackAdShow() called");
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            a("onAdShow");
            return;
        }
        com.bytedance.sdk.openadsdk.a.d.c cVar = this.D;
        if (cVar != null) {
            cVar.a();
        }
    }

    /* access modifiers changed from: private */
    public void z() {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            a("onAdSkip");
            return;
        }
        com.bytedance.sdk.openadsdk.a.d.c cVar = this.D;
        if (cVar != null) {
            cVar.c();
        }
    }

    /* access modifiers changed from: private */
    public void a(final String str) {
        com.bytedance.sdk.component.g.e.c(new g("AppOpenAd_executeMultiProcessCallback") {
            public void run() {
                try {
                    TTAppOpenAdActivity.this.e().executeAppOpenAdCallback(TTAppOpenAdActivity.this.A, str);
                } catch (Throwable th) {
                    l.b("TTAppOpenAdActivity", "open_ad", "executeAppOpenAdCallback execute throw Exception : ", th);
                }
            }
        }, 5);
    }

    /* access modifiers changed from: protected */
    public IListenerManager e() {
        if (this.C == null) {
            this.C = com.bytedance.sdk.openadsdk.multipro.aidl.a.a.asInterface(com.bytedance.sdk.openadsdk.multipro.aidl.a.a(m.a()).a(7));
        }
        return this.C;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        z.a((Activity) this);
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() {
            public void onSystemUiVisibilityChange(int i) {
                if (i == 0) {
                    try {
                        if (!TTAppOpenAdActivity.this.isFinishing()) {
                            TTAppOpenAdActivity.this.getWindow().getDecorView().postDelayed(new Runnable() {
                                public void run() {
                                    z.a((Activity) TTAppOpenAdActivity.this);
                                }
                            }, 2500);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    private boolean b(Bundle bundle) {
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            Intent intent = getIntent();
            if (intent != null) {
                String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_MATERIALMETA);
                if (stringExtra != null) {
                    try {
                        this.B = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(stringExtra));
                    } catch (Exception e2) {
                        l.b("TTAppOpenAdActivity", "open_ad", "initData MultiGlobalInfo throws ", e2);
                    }
                }
                this.A = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_META_MD5);
            }
        } else {
            this.B = r.a().c();
            this.D = r.a().f();
            r.a().h();
        }
        a(getIntent());
        a(bundle);
        n nVar = this.B;
        if (nVar == null) {
            l.a("TTAppOpenAdActivity", "open_ad", "mMaterialMeta is null , no data to display ,the TTOpenAdActivity finished !!");
            finish();
            return false;
        }
        this.z = nVar.aW();
        return true;
    }

    /* access modifiers changed from: protected */
    public void a(Intent intent) {
        if (intent != null) {
            this.F = intent.getIntExtra("ad_source", 0);
        }
    }

    /* access modifiers changed from: protected */
    public void a(Bundle bundle) {
        if (bundle != null) {
            if (this.D == null) {
                this.D = h;
                h = null;
            }
            try {
                String string = bundle.getString("material_meta");
                this.A = bundle.getString(TTAdConstant.MULTI_PROCESS_META_MD5);
                this.F = bundle.getInt("ad_source", 0);
                this.B = com.bytedance.sdk.openadsdk.core.b.a(new JSONObject(string));
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle.putString("material_meta", this.B != null ? this.B.ar().toString() : null);
            bundle.putString(TTAdConstant.MULTI_PROCESS_META_MD5, this.A);
            bundle.putInt("ad_source", this.F);
        } catch (Throwable unused) {
        }
        h = this.D;
        super.onSaveInstanceState(bundle);
    }

    public void a(Message message) {
        if (message.what == 100) {
            d dVar = this.s;
            if (dVar != null) {
                dVar.a(1);
            }
            z();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public boolean f() {
        try {
            if (getIntent().getIntExtra("orientation_angle", 0) == 3) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
