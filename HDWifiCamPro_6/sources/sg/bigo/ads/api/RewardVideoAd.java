package sg.bigo.ads.api;

public interface RewardVideoAd extends InterstitialAd {
    @Deprecated
    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void setAdInteractionListener(RewardAdInteractionListener rewardAdInteractionListener);
}
