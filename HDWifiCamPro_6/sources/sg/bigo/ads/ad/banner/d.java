package sg.bigo.ads.ad.banner;

import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.ad.banner.e;
import sg.bigo.ads.ad.c;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.BannerAd;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.api.core.i;
import sg.bigo.ads.common.utils.r;
import sg.bigo.ads.controller.loader.AbstractAdLoader;
import sg.bigo.ads.core.mraid.n;

public final class d extends c<BannerAd> implements BannerAd {
    /* access modifiers changed from: private */
    public c<BannerAd> l;
    private a m;
    /* access modifiers changed from: private */
    public FrameLayout n;
    /* access modifiers changed from: private */
    public AbstractAdLoader o;
    /* access modifiers changed from: private */
    public boolean p;
    /* access modifiers changed from: private */
    public boolean q;
    /* access modifiers changed from: private */
    public final AtomicBoolean r = new AtomicBoolean(false);
    private boolean s;
    /* access modifiers changed from: private */
    public AdError[] t = new AdError[1];

    class a {
        int a = 20000;
        final Handler b = new Handler(Looper.getMainLooper());
        boolean c;

        public a() {
            sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "Enable bigo adx banner auto refreshing");
        }
    }

    public d(g gVar) {
        super(gVar);
        this.l = a(gVar, this.t);
        if (this.l != null && gVar.b.i()) {
            this.m = new a();
            a aVar = this.m;
            int j = gVar.b.j();
            if (j >= 10) {
                aVar.a = j * 1000;
            }
        }
    }

    /* access modifiers changed from: private */
    public c<BannerAd> a(g gVar, AdError[] adErrorArr) {
        if (!(gVar.a instanceof i)) {
            adErrorArr[0] = new AdError(1005, "Unable to init banner ad due to invalid ad data");
            return null;
        }
        i iVar = (i) gVar.a;
        this.p = iVar.Q();
        return new c(sg.bigo.ads.common.b.a.a, this, iVar, a(gVar.d.b()), new f() {
            public final void a() {
            }

            public final void a(Point point, e eVar) {
                d.this.a(point, eVar);
            }

            public final void a(String str) {
                sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "BannerAd onCustomJsOmImpression, adSessionId=".concat(String.valueOf(str)));
                d.this.s();
                sg.bigo.ads.core.d.a.b(d.this.b.a, (String) d.this.b("show_proportion", ""), d.this.e(), ((Integer) d.this.b("render_style", 0)).intValue());
            }

            public final void b() {
                boolean unused = d.this.q = true;
                if (d.this.e) {
                    d.this.s();
                }
            }
        }, this.p);
    }

    private static n a(int i) {
        return (i == 3 || i == 4) ? n.INTERSTITIAL : n.INLINE;
    }

    private void a(boolean z) {
        if (this.l != null) {
            final long elapsedRealtime = SystemClock.elapsedRealtime();
            final AnonymousClass3 r2 = new b.C0113b() {
                public final void a() {
                    sg.bigo.ads.core.d.a.a(d.this.b.a, "banner_load_cost", SystemClock.elapsedRealtime() - elapsedRealtime, 1, (Map<String, String>) null);
                    sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "banner load success");
                }

                public final void a(sg.bigo.ads.api.core.d dVar) {
                    sg.bigo.ads.core.d.a.a(d.this.b.a, "banner_load_cost", SystemClock.elapsedRealtime() - elapsedRealtime, 0, (Map<String, String>) null);
                    sg.bigo.ads.common.k.a.a(1, 5, "BannerAd", "Failed to load banner media.");
                }
            };
            if (z) {
                sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "Banner load when onAdLoaded() ");
                this.l.a((b.C0113b) r2);
                return;
            }
            sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "Banner load when adView() ");
            sg.bigo.ads.common.f.c.b(new Runnable() {
                public final void run() {
                    if (!d.this.l.b(r2)) {
                        r2.a(new sg.bigo.ads.api.core.d(3001, 10102, "Adx media load error when load"));
                    }
                }
            });
        }
    }

    static /* synthetic */ void o(d dVar) {
        a aVar = dVar.m;
        if (aVar != null) {
            aVar.c = true;
        }
    }

    /* access modifiers changed from: private */
    public View q() {
        if (!this.l.q) {
            a(false);
        }
        View b = this.l.b();
        if (this.n == null) {
            this.n = new FrameLayout(b.getContext());
        }
        this.n.removeAllViews();
        this.n.addView(b);
        o();
        a(this.n, t());
        return this.n;
    }

    private void r() {
        if (!this.s) {
            this.s = true;
        }
        sg.bigo.ads.common.f.c.a(3, new Runnable() {
            public final void run() {
                e.a.a.b(d.this);
            }
        });
    }

    static /* synthetic */ void r(d dVar) {
        sg.bigo.ads.api.b bVar = dVar.b.d;
        bVar.b = 1;
        BigoAdSdk.a(bVar, (sg.bigo.ads.controller.b) new sg.bigo.ads.controller.b() {
            public final void a(int i, int i2, int i3, String str, Object obj) {
                sg.bigo.ads.common.k.a.a(2, "BannerAd", "Banner auto-refresh failed");
            }

            public final /* synthetic */ void a(int i, Object obj) {
                g gVar = (g) obj;
                sg.bigo.ads.api.core.c cVar = gVar.a;
                if (cVar instanceof i) {
                    ((i) cVar).T();
                }
                final boolean h = d.this.p;
                final g i2 = d.this.b;
                final c g = d.this.l;
                final boolean z = d.this.r.get();
                g unused = d.this.b = gVar;
                d dVar = d.this;
                c unused2 = dVar.l = dVar.a(gVar, dVar.t);
                d.this.r.set(false);
                d.this.a((b.a<BannerAd>) new b.a<BannerAd>() {
                    public final /* synthetic */ void a(Ad ad) {
                        BannerAd bannerAd = (BannerAd) ad;
                        if (d.this.o != null) {
                            d.this.o.a(bannerAd);
                        }
                        sg.bigo.ads.common.f.c.b(new Runnable() {
                            public final void run() {
                                if (d.this.n != null && d.this.l != null) {
                                    d.o(d.this);
                                    d.this.b();
                                    View unused = d.this.q();
                                    sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "Start impression check for auto refreshed banner ad.");
                                }
                            }
                        });
                        sg.bigo.ads.common.f.c.b(new Runnable() {
                            public final void run() {
                                g.a();
                            }
                        });
                        sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "Banner auto refresh successfully");
                    }

                    public final /* synthetic */ void a(Ad ad, int i, String str) {
                        AnonymousClass5.super.a(i, str);
                        c unused = d.this.l = g;
                        g unused2 = d.this.b = i2;
                        boolean unused3 = d.this.p = h;
                        d.this.r.set(z);
                        sg.bigo.ads.common.k.a.a(2, "BannerAd", "Banner auto-refresh failed");
                    }
                });
            }
        });
        sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "Start auto refreshing for bigo adx banner");
    }

    /* access modifiers changed from: private */
    public void s() {
        if (this.r.compareAndSet(false, true)) {
            sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "BannerAd report impression AdEvent");
            super.g();
        }
    }

    private boolean t() {
        a aVar = this.m;
        return aVar != null && aVar.c;
    }

    /* access modifiers changed from: package-private */
    public final void a(long j) {
        a("attach_render_cost", (Object) Long.valueOf(j));
    }

    public final void a(b.a<BannerAd> aVar) {
        String str;
        super.a(aVar);
        if (this.o == null && (aVar instanceof AbstractAdLoader)) {
            this.o = (AbstractAdLoader) aVar;
        }
        this.s = false;
        AdError adError = null;
        if (this.l == null) {
            AdError[] adErrorArr = this.t;
            AdError adError2 = adErrorArr[0];
            if (adError2 != null) {
                adErrorArr[0] = null;
                adError = adError2;
            } else {
                adError = new AdError(1005, "Failed to create html ads.");
            }
        } else {
            sg.bigo.ads.api.core.c cVar = this.b.a;
            if (cVar instanceof i) {
                i iVar = (i) cVar;
                if (iVar.R() == null || TextUtils.isEmpty(iVar.R().c())) {
                    adError = new AdError(1005, "Empty content.");
                }
            } else {
                adError = new AdError(1005, "BannerAd with invalid AdData class type.");
            }
        }
        if (adError != null) {
            aVar.a(this, adError.getCode(), adError.getMessage());
            return;
        }
        i.a S = this.l.l.S();
        if (S != null && S.a()) {
            sg.bigo.ads.api.core.c n2 = n();
            if (!(n2 instanceof i ? ((i) n2).U() : false)) {
                sg.bigo.ads.api.core.c n3 = n();
                if (n3 == null) {
                    str = "Banner preload, adData is null.";
                } else if (!(n3 instanceof i)) {
                    str = "Banner preload, not BannerAdData type.";
                } else {
                    i iVar2 = (i) n3;
                    sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "Banner load when onAdLoaded() ");
                    if (e.a.a.a(this)) {
                        this.s = true;
                        iVar2.V();
                        a(true);
                    } else {
                        str = "Banner preload limit 3 BannerAds.";
                    }
                }
                sg.bigo.ads.common.k.a.a(0, 5, "BannerAd", str);
            }
        }
        aVar.a(this);
    }

    public final View adView() {
        if (!sg.bigo.ads.common.f.c.b()) {
            r.a("adView() must run on UI thread");
        }
        if (isExpired() || this.g) {
            b(2000, "The ad is expired.");
            return null;
        }
        FrameLayout frameLayout = this.n;
        if (frameLayout != null) {
            return frameLayout;
        }
        if (this.l == null) {
            return null;
        }
        return q();
    }

    public final void d() {
        c<BannerAd> cVar = this.l;
        if (cVar != null) {
            b.g(cVar);
            if (cVar.k instanceof d) {
                ((d) cVar.k).a(b.i(cVar));
            }
        }
        super.d();
        c<BannerAd> cVar2 = this.l;
        if (cVar2 != null) {
            cVar2.c();
        }
        a aVar = this.m;
        if (aVar != null) {
            sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "Start auto refreshing after " + (aVar.a / 1000) + " s");
            aVar.b.removeCallbacksAndMessages((Object) null);
            aVar.b.postDelayed(new Runnable() {
                public final void run() {
                    d.r(d.this);
                }
            }, (long) aVar.a);
        }
        r();
    }

    public final void destroy() {
        if (!this.g) {
            super.destroy();
            c<BannerAd> cVar = this.l;
            if (cVar != null) {
                cVar.a();
            }
            a aVar = this.m;
            if (aVar != null) {
                sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "bigo adx banner auto refreshing stop");
                aVar.b.removeCallbacksAndMessages((Object) null);
            }
            r();
        }
    }

    public final void g() {
        if (!this.p || this.q) {
            s();
        } else {
            sg.bigo.ads.common.k.a.a(0, 3, "BannerAd", "BannerAd report impression AdEvent depend on om callback.");
        }
    }

    public final void h() {
        super.h();
        s();
    }
}
