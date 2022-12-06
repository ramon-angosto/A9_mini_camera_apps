package sg.bigo.ads.api;

public interface SplashAdInteractionListener extends AdInteractionListener {
    void onAdFinished();

    void onAdSkipped();
}
