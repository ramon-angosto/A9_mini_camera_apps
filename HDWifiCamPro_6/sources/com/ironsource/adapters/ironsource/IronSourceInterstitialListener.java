package com.ironsource.adapters.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.j.c;
import org.json.JSONObject;

public class IronSourceInterstitialListener implements c {
    public final String AD_VISIBLE_EVENT_NAME = "impressions";
    private final String mDemandSourceName;
    private final InterstitialSmashListener mListener;

    IronSourceInterstitialListener(InterstitialSmashListener interstitialSmashListener, String str) {
        this.mDemandSourceName = str;
        this.mListener = interstitialSmashListener;
    }

    public void onInterstitialAdRewarded(String str, int i) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " interstitialListener demandSourceId=" + str + " amount=" + i);
    }

    public void onInterstitialClick() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " interstitialListener");
        this.mListener.onInterstitialAdClicked();
    }

    public void onInterstitialClose() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " interstitialListener");
        this.mListener.onInterstitialAdClosed();
    }

    public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " interstitialListener eventName = " + str);
            if ("impressions".equals(str)) {
                this.mListener.onInterstitialAdVisible();
            }
        }
    }

    public void onInterstitialInitFailed(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " interstitialListener");
    }

    public void onInterstitialInitSuccess() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " interstitialListener");
    }

    public void onInterstitialLoadFailed(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " interstitialListener " + str);
        this.mListener.onInterstitialAdLoadFailed(ErrorBuilder.buildLoadFailedError(str));
    }

    public void onInterstitialLoadSuccess() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " interstitialListener");
        this.mListener.onInterstitialAdReady();
    }

    public void onInterstitialOpen() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " interstitialListener");
        this.mListener.onInterstitialAdOpened();
    }

    public void onInterstitialShowFailed(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " interstitialListener " + str);
        this.mListener.onInterstitialAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.INTERSTITIAL_AD_UNIT, str));
    }

    public void onInterstitialShowSuccess() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " interstitialListener");
        this.mListener.onInterstitialAdShowSucceeded();
    }
}
