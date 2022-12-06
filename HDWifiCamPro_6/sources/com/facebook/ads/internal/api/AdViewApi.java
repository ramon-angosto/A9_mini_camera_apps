package com.facebook.ads.internal.api;

import android.content.res.Configuration;
import com.facebook.ads.Ad;
import com.facebook.ads.AdView;
import com.facebook.ads.ExtraHints;

public interface AdViewApi extends AdViewParentApi, Ad {
    AdView.AdViewLoadConfigBuilder buildLoadAdConfig();

    void loadAd(AdView.AdViewLoadConfig adViewLoadConfig);

    void onConfigurationChanged(Configuration configuration);

    @Deprecated
    void setExtraHints(ExtraHints extraHints);
}
