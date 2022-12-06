package sg.bigo.ads.controller.loader;

import sg.bigo.ads.BigoAdSdk;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdLoadListener;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.b;
import sg.bigo.ads.api.core.f;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.core.d.a;

public abstract class AbstractAdLoader<U extends Ad, T extends b> implements b.a<U>, AdLoader<T>, sg.bigo.ads.controller.b {
    private final f<U> a;

    public AbstractAdLoader(AdLoadListener<U> adLoadListener) {
        if (adLoadListener == null) {
            this.a = new f<>();
        } else {
            this.a = new f<>(adLoadListener);
        }
    }

    /* access modifiers changed from: protected */
    public U a(g gVar) {
        return null;
    }

    public final void a(int i, int i2, int i3, String str, Object obj) {
        this.a.onError(new AdError(i2, str));
    }

    public final /* bridge */ /* synthetic */ void a(int i, Object obj) {
        g gVar = (g) obj;
        Ad a2 = a(gVar);
        if (a2 == null) {
            a((Ad) null, 1005, "Unmatched ad type.");
            a.a(gVar.a, 0, 1005, "Unmatched ad type.");
        } else if (a2 instanceof sg.bigo.ads.ad.b) {
            ((sg.bigo.ads.ad.b) a2).a(this);
        } else {
            a(a2, 1005, "Unknown ad.");
        }
    }

    public final void a(U u) {
        if (u instanceof sg.bigo.ads.ad.b) {
            ((sg.bigo.ads.ad.b) u).a();
        }
        this.a.onAdLoaded(u);
    }

    public final void a(U u, int i, String str) {
        if (u instanceof sg.bigo.ads.ad.b) {
            ((sg.bigo.ads.ad.b) u).a(i, str);
        }
        sg.bigo.ads.common.k.a.a(2, 5, "", "Failed to load ads: (" + i + ") " + str);
        this.a.onError(new AdError(i, str));
    }

    public void loadAd(T t) {
        t.b = 0;
        BigoAdSdk.a((sg.bigo.ads.api.b) t, (sg.bigo.ads.controller.b) this);
    }
}
