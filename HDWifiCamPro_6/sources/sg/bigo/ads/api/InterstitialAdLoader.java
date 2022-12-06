package sg.bigo.ads.api;

import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

public class InterstitialAdLoader extends AbstractAdLoader<InterstitialAd, InterstitialAdRequest> {

    public static class Builder implements AdLoader.Builder<InterstitialAd, Builder, InterstitialAdLoader> {
        /* access modifiers changed from: private */
        public AdLoadListener<InterstitialAd> mAdLoadListener;

        public InterstitialAdLoader build() {
            return new InterstitialAdLoader(this);
        }

        public Builder withAdLoadListener(AdLoadListener<InterstitialAd> adLoadListener) {
            this.mAdLoadListener = adLoadListener;
            return this;
        }
    }

    public InterstitialAdLoader(Builder builder) {
        super(builder.mAdLoadListener);
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [sg.bigo.ads.api.Ad] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ sg.bigo.ads.api.Ad a(sg.bigo.ads.api.core.g r5) {
        /*
            r4 = this;
            sg.bigo.ads.api.core.c r0 = r5.a
            int r0 = r0.m()
            r1 = 3
            if (r0 != r1) goto L_0x004f
            sg.bigo.ads.api.core.c r0 = r5.a
            int r0 = r0.l()
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L_0x0036
            r2 = 2
            if (r0 == r2) goto L_0x0036
            if (r0 == r1) goto L_0x0019
            goto L_0x004e
        L_0x0019:
            sg.bigo.ads.ad.interstitial.e$a<?> r0 = sg.bigo.ads.ad.interstitial.d.b
            if (r0 != 0) goto L_0x0029
            java.lang.Class<sg.bigo.ads.ad.interstitial.e$a> r0 = sg.bigo.ads.ad.interstitial.e.a.class
            java.lang.String r1 = "sg.bigo.ads.api.IBAdCreator"
            java.lang.Object r0 = sg.bigo.ads.common.i.a.a(r1, r0)
            sg.bigo.ads.ad.interstitial.e$a r0 = (sg.bigo.ads.ad.interstitial.e.a) r0
            sg.bigo.ads.ad.interstitial.d.b = r0
        L_0x0029:
            sg.bigo.ads.ad.interstitial.e$a<?> r0 = sg.bigo.ads.ad.interstitial.d.b
            if (r0 != 0) goto L_0x002e
            goto L_0x004e
        L_0x002e:
            sg.bigo.ads.ad.interstitial.e$a<?> r0 = sg.bigo.ads.ad.interstitial.d.b
        L_0x0030:
            sg.bigo.ads.ad.interstitial.e r5 = r0.getAdInstance(r5)
            r3 = r5
            goto L_0x004e
        L_0x0036:
            sg.bigo.ads.ad.interstitial.e$a<?> r0 = sg.bigo.ads.ad.interstitial.d.a
            if (r0 != 0) goto L_0x0046
            java.lang.Class<sg.bigo.ads.ad.interstitial.e$a> r0 = sg.bigo.ads.ad.interstitial.e.a.class
            java.lang.String r1 = "sg.bigo.ads.api.INAdCreator"
            java.lang.Object r0 = sg.bigo.ads.common.i.a.a(r1, r0)
            sg.bigo.ads.ad.interstitial.e$a r0 = (sg.bigo.ads.ad.interstitial.e.a) r0
            sg.bigo.ads.ad.interstitial.d.a = r0
        L_0x0046:
            sg.bigo.ads.ad.interstitial.e$a<?> r0 = sg.bigo.ads.ad.interstitial.d.a
            if (r0 != 0) goto L_0x004b
            goto L_0x004e
        L_0x004b:
            sg.bigo.ads.ad.interstitial.e$a<?> r0 = sg.bigo.ads.ad.interstitial.d.a
            goto L_0x0030
        L_0x004e:
            return r3
        L_0x004f:
            sg.bigo.ads.api.Ad r5 = super.a((sg.bigo.ads.api.core.g) r5)
            sg.bigo.ads.api.InterstitialAd r5 = (sg.bigo.ads.api.InterstitialAd) r5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: sg.bigo.ads.api.InterstitialAdLoader.a(sg.bigo.ads.api.core.g):sg.bigo.ads.api.Ad");
    }
}
