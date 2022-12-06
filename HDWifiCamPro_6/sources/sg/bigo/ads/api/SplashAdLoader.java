package sg.bigo.ads.api;

import sg.bigo.ads.ad.splash.b;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

public class SplashAdLoader extends AbstractAdLoader<SplashAd, SplashAdRequest> {

    public static class Builder implements AdLoader.Builder<SplashAd, Builder, SplashAdLoader> {
        /* access modifiers changed from: private */
        public AdLoadListener<SplashAd> mAdLoadListener;

        public SplashAdLoader build() {
            return new SplashAdLoader(this);
        }

        public Builder withAdLoadListener(AdLoadListener<SplashAd> adLoadListener) {
            this.mAdLoadListener = adLoadListener;
            return this;
        }
    }

    public SplashAdLoader(Builder builder) {
        super(builder.mAdLoadListener);
    }

    public final /* synthetic */ Ad a(g gVar) {
        return gVar.a.m() == 12 ? new b(gVar) : (SplashAd) super.a(gVar);
    }
}
