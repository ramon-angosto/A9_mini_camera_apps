package com.ironsource.adapters.facebook;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdExtendedListener;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import java.lang.ref.WeakReference;

public class FacebookInterstitialAdListener implements InterstitialAdExtendedListener {
    private WeakReference<FacebookAdapter> mAdapter;
    private InterstitialSmashListener mListener;
    private String mPlacementId;

    FacebookInterstitialAdListener(FacebookAdapter facebookAdapter, InterstitialSmashListener interstitialSmashListener, String str) {
        this.mAdapter = new WeakReference<>(facebookAdapter);
        this.mListener = interstitialSmashListener;
        this.mPlacementId = str;
    }

    public void onInterstitialDisplayed(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
    }

    public void onInterstitialDismissed(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        ((FacebookAdapter) this.mAdapter.get()).mDidCallClosed = true;
        this.mListener.onInterstitialAdClosed();
    }

    public void onInterstitialActivityDestroyed() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
        } else if (!((FacebookAdapter) this.mAdapter.get()).mDidCallClosed) {
            this.mListener.onInterstitialAdClosed();
        }
    }

    public void onError(Ad ad, AdError adError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.error("mPlacementId = " + this.mPlacementId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        IronSourceError ironSourceError = new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, "Empty error string");
        if (adError != null) {
            IronLog ironLog2 = IronLog.ADAPTER_CALLBACK;
            ironLog2.error("error = " + adError.getErrorCode() + ", " + adError.getErrorMessage());
            ironSourceError = new IronSourceError(adError.getErrorCode() == 1001 ? IronSourceError.ERROR_IS_LOAD_NO_FILL : adError.getErrorCode(), adError.getErrorMessage());
        }
        if (((FacebookAdapter) this.mAdapter.get()).mInterstitialPlacementIdShowCalled.get(this.mPlacementId).booleanValue()) {
            IronLog.ADAPTER_CALLBACK.error("onInterstitialAdShowFailed");
            this.mListener.onInterstitialAdShowFailed(ironSourceError);
        } else {
            this.mListener.onInterstitialAdLoadFailed(ironSourceError);
        }
        ((FacebookAdapter) this.mAdapter.get()).mInterstitialAdsAvailability.put(this.mPlacementId, false);
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
            return;
        }
        this.mListener.onInterstitialAdReady();
        ((FacebookAdapter) this.mAdapter.get()).mInterstitialAdsAvailability.put(this.mPlacementId, true);
    }

    public void onAdClicked(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
        InterstitialSmashListener interstitialSmashListener = this.mListener;
        if (interstitialSmashListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
        } else {
            interstitialSmashListener.onInterstitialAdClicked();
        }
    }

    public void onLoggingImpression(Ad ad) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
        if (this.mListener == null) {
            IronLog.INTERNAL.verbose("listener is null");
            return;
        }
        WeakReference<FacebookAdapter> weakReference = this.mAdapter;
        if (weakReference == null || weakReference.get() == null) {
            IronLog.INTERNAL.verbose("adapter is null");
            return;
        }
        ((FacebookAdapter) this.mAdapter.get()).mDidCallClosed = false;
        this.mListener.onInterstitialAdOpened();
        this.mListener.onInterstitialAdShowSucceeded();
    }

    public void onRewardedAdCompleted() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
    }

    public void onRewardedAdServerSucceeded() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
    }

    public void onRewardedAdServerFailed() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose("mPlacementId = " + this.mPlacementId);
    }
}
