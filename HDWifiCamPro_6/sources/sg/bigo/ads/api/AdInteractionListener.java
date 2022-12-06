package sg.bigo.ads.api;

public interface AdInteractionListener {
    void onAdClicked();

    void onAdClosed();

    void onAdError(AdError adError);

    void onAdImpression();

    void onAdOpened();
}
