package sg.bigo.ads.api;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;

public interface NativeAd extends Ad {

    public enum CreativeType {
        IMAGE,
        VIDEO,
        UNKNOWN
    }

    String getCallToAction();

    CreativeType getCreativeType();

    String getDescription();

    String getTitle();

    VideoController getVideoController();

    String getWarning();

    boolean hasIcon();

    void registerViewForInteraction(ViewGroup viewGroup, MediaView mediaView, ImageView imageView, AdOptionsView adOptionsView, List<View> list);

    void registerViewForInteraction(NativeAdView nativeAdView, MediaView mediaView, AdIconView adIconView, AdOptionsView adOptionsView, List<View> list);
}
