package sg.bigo.ads.ad.b;

import sg.bigo.ads.ad.b;
import sg.bigo.ads.ad.interstitial.i;
import sg.bigo.ads.api.InterstitialAd;
import sg.bigo.ads.api.RewardAdInteractionListener;
import sg.bigo.ads.api.RewardVideoAd;
import sg.bigo.ads.api.core.g;

public final class c extends i implements RewardVideoAd {
    RewardAdInteractionListener p;

    public c(g gVar) {
        super(gVar);
    }

    public final void b(b.a<InterstitialAd> aVar) {
        if (!q()) {
            aVar.a(this, 1006, "Missing media video.");
        } else {
            super.b(aVar);
        }
    }

    public final Class<? extends sg.bigo.ads.controller.e.b<?>> s() {
        return b.class;
    }

    public final void setAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener) {
        super.setAdInteractionListener(rewardAdInteractionListener);
        this.p = rewardAdInteractionListener;
    }
}
