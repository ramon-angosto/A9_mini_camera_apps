package sg.bigo.ads.api;

import sg.bigo.ads.ad.interstitial.e;
import sg.bigo.ads.ad.interstitial.i;
import sg.bigo.ads.api.core.g;

public class INAdCreator implements e.a<i> {
    public i getAdInstance(g gVar) {
        return new i(gVar);
    }
}
