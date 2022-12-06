package sg.bigo.ads.ad.interstitial;

import android.os.SystemClock;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.ad.c;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.controller.f.d;

public abstract class e extends c<InterstitialAd> implements InterstitialAd {
    protected b l;
    private long m;

    public interface a<T extends e> {
        T getAdInstance(g gVar);
    }

    interface b {
        void m();

        void w();
    }

    public e(g gVar) {
        super(gVar);
    }

    public final void a(int i) {
        f();
        sg.bigo.ads.api.core.c cVar = this.b.a;
        long j = 0;
        if (this.m > 0) {
            j = SystemClock.elapsedRealtime() - this.m;
        }
        sg.bigo.ads.core.d.a.a(cVar, i, j);
    }

    public final void a(String str) {
        b(2003, str);
    }

    public final void a(b.a<InterstitialAd> aVar) {
        super.a(aVar);
        b(aVar);
    }

    public final void a(b bVar) {
        this.l = bVar;
    }

    /* access modifiers changed from: protected */
    public abstract void b(b.a<InterstitialAd> aVar);

    public void destroy() {
        super.destroy();
        this.l = null;
    }

    /* access modifiers changed from: protected */
    public abstract boolean q();

    public final void r() {
        o();
        if (this.a != null) {
            this.a.onAdOpened();
        }
        this.m = SystemClock.elapsedRealtime();
        sg.bigo.ads.core.d.a.a(this.b.a);
    }

    /* access modifiers changed from: protected */
    public abstract Class<? extends sg.bigo.ads.controller.e.b<?>> s();

    public void show() {
        if (isExpired() || this.g) {
            b(2000, "The ad is expired.");
        } else if (this.e) {
            b(2003, "This ad cannot be shown repeatedly");
        } else {
            d.a(sg.bigo.ads.common.b.a.a, s(), this);
        }
    }
}
