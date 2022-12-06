package com.ironsource.adapters.facebook;

import android.widget.FrameLayout;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import java.lang.ref.WeakReference;

public class FacebookBannerAdListener implements AdListener {
    private WeakReference<FacebookAdapter> mAdapter;
    private FrameLayout.LayoutParams mBannerLayoutParams;
    private BannerSmashListener mListener;
    private String mPlacementId;

    public FacebookBannerAdListener(FacebookAdapter facebookAdapter, BannerSmashListener bannerSmashListener, String str, FrameLayout.LayoutParams layoutParams) {
        this.mAdapter = new WeakReference<>(facebookAdapter);
        this.mListener = bannerSmashListener;
        this.mPlacementId = str;
        this.mBannerLayoutParams = layoutParams;
    }

    public void onError(Ad ad, AdError adError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.error("error = " + adError.getErrorCode() + ", " + adError.getErrorMessage());
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        int errorCode = adError.getErrorCode() == 1001 ? IronSourceError.ERROR_BN_LOAD_NO_FILL : adError.getErrorCode();
        if (adError.getErrorMessage() != null) {
            this.mListener.onBannerAdLoadFailed(new IronSourceError(errorCode, adError.getErrorCode() + ":" + adError.getErrorMessage()));
            return;
        }
        this.mListener.onBannerAdLoadFailed(new IronSourceError(errorCode, "Empty error string"));
    }

    public void onAdLoaded(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else if (((FacebookAdapter) this.mAdapter.get()).mBNPlacementToAdMap.containsKey(this.mPlacementId)) {
            this.mListener.onBannerAdLoaded(((FacebookAdapter) this.mAdapter.get()).mBNPlacementToAdMap.get(this.mPlacementId), this.mBannerLayoutParams);
        }
    }

    public void onAdClicked(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdClicked();
        }
    }

    public void onLoggingImpression(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            bannerSmashListener.onBannerAdShown();
        }
    }
}
