package sg.bigo.ads.api;

import sg.bigo.ads.ad.a.a;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

public class NativeAdLoader extends AbstractAdLoader<NativeAd, NativeAdRequest> {

    public static class Builder implements AdLoader.Builder<NativeAd, Builder, NativeAdLoader> {
        /* access modifiers changed from: private */
        public AdLoadListener<NativeAd> mAdLoadListener;

        public NativeAdLoader build() {
            return new NativeAdLoader(this);
        }

        public Builder withAdLoadListener(AdLoadListener<NativeAd> adLoadListener) {
            this.mAdLoadListener = adLoadListener;
            return this;
        }
    }

    public NativeAdLoader(Builder builder) {
        super(builder.mAdLoadListener);
    }

    public final /* synthetic */ Ad a(g gVar) {
        return gVar.a.m() == 1 ? a.a(gVar.a.l(), gVar) : (NativeAd) super.a(gVar);
    }
}
