package com.google.android.gms.ads.nativead;

import android.view.View;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.nativead.NativeAd;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public interface NativeCustomFormatAd {
    public static final String ASSET_NAME_VIDEO = "_videoMediaView";

    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public interface DisplayOpenMeasurement {
        void setView(View view);

        boolean start();
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public interface OnCustomClickListener {
        void onCustomClick(NativeCustomFormatAd nativeCustomFormatAd, String str);
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
    public interface OnCustomFormatAdLoadedListener {
        void onCustomFormatAdLoaded(NativeCustomFormatAd nativeCustomFormatAd);
    }

    void destroy();

    List<String> getAvailableAssetNames();

    String getCustomFormatId();

    DisplayOpenMeasurement getDisplayOpenMeasurement();

    NativeAd.Image getImage(String str);

    MediaContent getMediaContent();

    CharSequence getText(String str);

    @Deprecated
    VideoController getVideoController();

    @Deprecated
    MediaView getVideoMediaView();

    void performClick(String str);

    void recordImpression();
}
