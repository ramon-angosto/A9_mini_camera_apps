package com.bytedance.sdk.openadsdk;

import android.app.Activity;
import java.util.Map;

@Deprecated
public interface TTInteractionAd extends TTClientBidding {

    public interface AdInteractionListener {
        void onAdClicked();

        void onAdDismiss();

        void onAdShow();
    }

    int getInteractionType();

    Map<String, Object> getMediaExtraInfo();

    void setAdInteractionListener(AdInteractionListener adInteractionListener);

    void showInteractionAd(Activity activity);
}
