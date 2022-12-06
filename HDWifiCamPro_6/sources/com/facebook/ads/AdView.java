package com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.RelativeLayout;
import com.facebook.ads.Ad;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

public class AdView extends RelativeLayout implements Ad {
    private final AdViewApi mAdViewApi;
    private final AdViewParentApi mAdViewParentApi = new AdViewParentApi() {
        public void onConfigurationChanged(Configuration configuration) {
            AdView.super.onConfigurationChanged(configuration);
        }
    };

    public interface AdViewLoadConfig extends Ad.LoadAdConfig {
    }

    public interface AdViewLoadConfigBuilder extends Ad.LoadConfigBuilder {
        AdViewLoadConfig build();

        AdViewLoadConfigBuilder withAdListener(AdListener adListener);

        AdViewLoadConfigBuilder withBid(String str);
    }

    public AdView(Context context, String str, AdSize adSize) {
        super(context);
        this.mAdViewApi = DynamicLoaderFactory.makeLoader(context).createAdViewApi(context, str, adSize, this.mAdViewParentApi, this);
    }

    public AdView(Context context, String str, String str2) throws Exception {
        super(context);
        this.mAdViewApi = DynamicLoaderFactory.makeLoader(context).createAdViewApi(context, str, str2, this.mAdViewParentApi, this);
    }

    public void loadAd() {
        this.mAdViewApi.loadAd();
    }

    public void loadAd(AdViewLoadConfig adViewLoadConfig) {
        this.mAdViewApi.loadAd(adViewLoadConfig);
    }

    public boolean isAdInvalidated() {
        return this.mAdViewApi.isAdInvalidated();
    }

    @Deprecated
    public void setExtraHints(ExtraHints extraHints) {
        this.mAdViewApi.setExtraHints(extraHints);
    }

    public void destroy() {
        this.mAdViewApi.destroy();
    }

    public String getPlacementId() {
        return this.mAdViewApi.getPlacementId();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        this.mAdViewApi.onConfigurationChanged(configuration);
    }

    public AdViewLoadConfigBuilder buildLoadAdConfig() {
        return this.mAdViewApi.buildLoadAdConfig();
    }
}
