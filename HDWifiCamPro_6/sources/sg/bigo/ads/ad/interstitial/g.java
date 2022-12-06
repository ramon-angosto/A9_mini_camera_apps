package sg.bigo.ads.ad.interstitial;

import android.graphics.Point;
import android.text.TextUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.ad.banner.c;
import sg.bigo.ads.ad.banner.f;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.core.d;
import sg.bigo.ads.api.core.e;
import sg.bigo.ads.api.core.i;
import sg.bigo.ads.common.b.a;
import sg.bigo.ads.core.mraid.n;

public final class g extends e {
    final c<g> m;
    /* access modifiers changed from: package-private */
    public f n;
    private final boolean o;
    /* access modifiers changed from: private */
    public boolean p;
    private final AtomicBoolean q;

    public g(sg.bigo.ads.api.core.g gVar) {
        super(gVar);
        if (gVar.a instanceof i) {
            this.q = new AtomicBoolean(false);
            i iVar = (i) gVar.a;
            this.o = iVar.Q();
            this.m = new c(a.a, this, iVar, n.INTERSTITIAL, new f() {
                public final void a() {
                    if (g.this.n != null) {
                        g.this.n.a();
                    }
                }

                public final void a(Point point, e eVar) {
                    g.this.a(point, eVar);
                }

                public final void a(String str) {
                    sg.bigo.ads.common.k.a.a(0, 3, "InterstitialBannerAd", "InterstitialBannerAd onCustomJsOmImpression, adSessionId=".concat(String.valueOf(str)));
                    g.this.t();
                    sg.bigo.ads.core.d.a.b(g.this.b.a, (String) g.this.b("show_proportion", ""), g.this.e(), ((Integer) g.this.b("render_style", 0)).intValue());
                }

                public final void b() {
                    boolean unused = g.this.p = true;
                    if (g.this.e) {
                        g.this.t();
                    }
                }
            }, this.o);
            this.m.b = 0;
            return;
        }
        throw new IllegalArgumentException("Error data type for ad!");
    }

    /* access modifiers changed from: private */
    public void t() {
        if (this.q.compareAndSet(false, true)) {
            sg.bigo.ads.common.k.a.a(0, 3, "InterstitialBannerAd", "InterstitialBannerAd report impression AdEvent");
            super.g();
        }
    }

    /* access modifiers changed from: protected */
    public final void b(b.a<InterstitialAd> aVar) {
        sg.bigo.ads.api.core.c cVar = this.b.a;
        if (!(cVar instanceof i)) {
            aVar.a(this, 1005, "InterstitialBannerAd with invalid AdData class type.");
            return;
        }
        i iVar = (i) cVar;
        if (iVar.m() != 3) {
            aVar.a(this, 1005, "Unmatched ad type.");
        } else if (iVar.R() == null || TextUtils.isEmpty(iVar.R().c())) {
            aVar.a(this, 1005, "Empty content.");
        } else {
            this.m.a((b.C0113b) new b.C0113b() {
                public final void a() {
                }

                public final void a(d dVar) {
                }
            });
            aVar.a(this);
        }
    }

    public final void d() {
        super.d();
        c<g> cVar = this.m;
        if (cVar != null) {
            cVar.c();
        }
    }

    public final void destroy() {
        if (!this.g) {
            this.n = null;
            super.destroy();
            this.m.a();
        }
    }

    public final void g() {
        if (!this.o || this.p) {
            t();
        } else {
            sg.bigo.ads.common.k.a.a(0, 3, "InterstitialBannerAd", "BannerAd report impression AdEvent depend on om callback.");
        }
    }

    public final void h() {
        super.h();
        t();
    }

    /* access modifiers changed from: protected */
    public final boolean q() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final Class<? extends sg.bigo.ads.controller.e.b<?>> s() {
        return f.class;
    }
}
