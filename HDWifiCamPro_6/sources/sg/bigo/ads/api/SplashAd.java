package sg.bigo.ads.api;

import android.view.ViewGroup;

public interface SplashAd extends Ad {

    public enum Style {
        VERTICAL_FULLSCREEN,
        VERTICAL_HALFSCREEN,
        HORIZONTAL
    }

    Style getStyle();

    boolean isSkippable();

    @Deprecated
    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void setAdInteractionListener(SplashAdInteractionListener splashAdInteractionListener);

    void showInAdContainer(ViewGroup viewGroup);
}
