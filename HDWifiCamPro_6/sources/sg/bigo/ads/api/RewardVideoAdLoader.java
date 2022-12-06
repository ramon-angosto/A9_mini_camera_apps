package sg.bigo.ads.api;

import sg.bigo.ads.ad.b.c;
import sg.bigo.ads.api.AdLoader;
import sg.bigo.ads.api.core.g;
import sg.bigo.ads.controller.loader.AbstractAdLoader;

public class RewardVideoAdLoader extends AbstractAdLoader<RewardVideoAd, RewardVideoAdRequest> {

    public static class Builder implements AdLoader.Builder<RewardVideoAd, Builder, RewardVideoAdLoader> {
        /* access modifiers changed from: private */
        public AdLoadListener<RewardVideoAd> mAdLoadListener;

        public RewardVideoAdLoader build() {
            return new RewardVideoAdLoader(this);
        }

        public Builder withAdLoadListener(AdLoadListener<RewardVideoAd> adLoadListener) {
            this.mAdLoadListener = adLoadListener;
            return this;
        }
    }

    public RewardVideoAdLoader(Builder builder) {
        super(builder.mAdLoadListener);
    }

    public final /* synthetic */ Ad a(g gVar) {
        return gVar.a.m() == 4 ? new c(gVar) : (RewardVideoAd) super.a(gVar);
    }
}
