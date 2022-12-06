package sg.bigo.ads.ad.interstitial;

import sg.bigo.ads.ad.a.b;
import sg.bigo.ads.ad.a.c;
import sg.bigo.ads.ad.b;
import sg.bigo.ads.ad.interstitial.e;
import sg.bigo.ads.api.Ad;
import sg.bigo.ads.api.AdError;
import sg.bigo.ads.api.AdInteractionListener;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.NativeAd;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.core.f.a.p;

public class i extends e {
    final b m;
    /* access modifiers changed from: package-private */
    public sg.bigo.ads.ad.interstitial.a.b n;
    /* access modifiers changed from: package-private */
    public sg.bigo.ads.ad.interstitial.a.a o;

    class a implements AdInteractionListener {
        private final AdInteractionListener b;

        a(AdInteractionListener adInteractionListener) {
            this.b = adInteractionListener;
        }

        public final void onAdClicked() {
            this.b.onAdClicked();
            if (i.this.l != null) {
                i.this.l.m();
            }
        }

        public final void onAdClosed() {
            this.b.onAdClosed();
        }

        public final void onAdError(AdError adError) {
            this.b.onAdError(adError);
            if (adError.getCode() == 2002 && i.this.l != null) {
                e.b bVar = i.this.l;
                adError.getMessage();
                bVar.w();
            }
        }

        public final void onAdImpression() {
            this.b.onAdImpression();
        }

        public final void onAdOpened() {
            this.b.onAdOpened();
        }
    }

    public i(g gVar) {
        super(gVar);
        b a2 = sg.bigo.ads.ad.a.a.a(gVar.a.l(), gVar);
        if (a2 != null) {
            this.m = a2;
            return;
        }
        throw new IllegalArgumentException("Illegal adx type.");
    }

    public final <ValueType> ValueType b(String str, ValueType valuetype) {
        return this.m.b(str, valuetype);
    }

    /* access modifiers changed from: protected */
    public void b(final b.a<InterstitialAd> aVar) {
        this.m.a((b.a<NativeAd>) new b.a<NativeAd>() {
            public final /* synthetic */ void a(Ad ad) {
                NativeAd nativeAd = (NativeAd) ad;
                g a2 = i.this.b;
                i iVar = i.this;
                boolean z = nativeAd instanceof c;
                p pVar = null;
                sg.bigo.ads.ad.interstitial.a.b unused = iVar.n = new sg.bigo.ads.ad.interstitial.a.b(iVar, a2.b, a2.a, z ? ((c) nativeAd).p : null, z ? ((c) nativeAd).q : null);
                i iVar2 = i.this;
                boolean z2 = iVar2.n.a;
                i iVar3 = i.this;
                sg.bigo.ads.api.a.g gVar = a2.b;
                sg.bigo.ads.api.core.c cVar = a2.a;
                sg.bigo.ads.core.player.c cVar2 = z ? ((c) nativeAd).p : null;
                if (z) {
                    pVar = ((c) nativeAd).q;
                }
                sg.bigo.ads.ad.interstitial.a.a unused2 = iVar2.o = new sg.bigo.ads.ad.interstitial.a.a(z2, iVar3, gVar, cVar, cVar2, pVar);
                int i = 1;
                int i2 = i.this.n.a ? 1 : i.this.o.a ? 2 : 0;
                if (a2.a.c() != null && !a2.a.e()) {
                    i2 = 0;
                }
                a2.a.b(i2);
                sg.bigo.ads.api.core.c cVar3 = a2.a;
                if (!i.this.n.a && !(i.this.o.b instanceof sg.bigo.ads.ad.interstitial.a.a.b)) {
                    i = 2;
                }
                cVar3.c(i);
                aVar.a(i.this);
            }

            public final /* bridge */ /* synthetic */ void a(Ad ad, int i, String str) {
                aVar.a(i.this, i, str);
            }
        }, 0);
    }

    public void destroy() {
        if (!this.g) {
            super.destroy();
            this.m.destroy();
        }
    }

    public final void m() {
        this.m.m();
    }

    /* access modifiers changed from: protected */
    public final boolean q() {
        return this.m.q().ad();
    }

    /* access modifiers changed from: protected */
    public Class<? extends sg.bigo.ads.controller.e.b<?>> s() {
        return q() ? m.class : l.class;
    }

    public void setAdInteractionListener(AdInteractionListener adInteractionListener) {
        super.setAdInteractionListener(adInteractionListener);
        if (adInteractionListener != null) {
            this.m.setAdInteractionListener(new a(adInteractionListener));
        }
    }
}
