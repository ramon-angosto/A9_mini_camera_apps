package sg.bigo.ads.api;

import sg.bigo.ads.api.Ad;

public interface AdLoadListener<T extends Ad> {
    void onAdLoaded(T t);

    void onError(AdError adError);
}
