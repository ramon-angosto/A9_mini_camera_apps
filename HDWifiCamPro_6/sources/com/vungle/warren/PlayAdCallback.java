package com.vungle.warren;

import com.vungle.warren.error.VungleException;

public interface PlayAdCallback {
    void creativeId(String str);

    void onAdClick(String str);

    void onAdEnd(String str);

    @Deprecated
    void onAdEnd(String str, boolean z, boolean z2);

    void onAdLeftApplication(String str);

    void onAdRewarded(String str);

    void onAdStart(String str);

    void onAdViewed(String str);

    void onError(String str, VungleException vungleException);
}
