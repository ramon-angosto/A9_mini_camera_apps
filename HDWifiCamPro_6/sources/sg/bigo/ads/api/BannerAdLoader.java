package sg.bigo.ads.api;

import sg.bigo.ads.ad.banner.d;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

public class BannerAdLoader extends AbstractAdLoader<BannerAd, BannerAdRequest> {

    public static class Builder implements AdLoader.Builder<BannerAd, Builder, BannerAdLoader> {
        AdLoadListener<BannerAd> mBannerAdLoader;

        public BannerAdLoader build() {
            return new BannerAdLoader(this);
        }

        public Builder withAdLoadListener(AdLoadListener<BannerAd> adLoadListener) {
            this.mBannerAdLoader = adLoadListener;
            return this;
        }
    }

    public BannerAdLoader(Builder builder) {
        super(builder.mBannerAdLoader);
    }

    public final /* synthetic */ Ad a(g gVar) {
        return gVar.a.m() == 2 ? new d(gVar) : (BannerAd) super.a(gVar);
    }
}
