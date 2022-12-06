package com.ironsource.adapters.ironsource;

import android.text.TextUtils;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.ironsource.sdk.j.c;
import org.json.JSONObject;

public class IronSourceRewardedVideoListener implements c {
    public final String AD_VISIBLE_EVENT_NAME = "impressions";
    private final String mDemandSourceName;
    boolean mIsRvDemandOnly;
    RewardedVideoSmashListener mListener;

    IronSourceRewardedVideoListener(RewardedVideoSmashListener rewardedVideoSmashListener, String str, boolean z) {
        this.mDemandSourceName = str;
        this.mListener = rewardedVideoSmashListener;
        this.mIsRvDemandOnly = z;
    }

    public void onInterstitialAdRewarded(String str, int i) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener demandSourceId=" + str + " amount=" + i);
        this.mListener.onRewardedVideoAdRewarded();
    }

    public void onInterstitialClick() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
        this.mListener.onRewardedVideoAdClicked();
    }

    public void onInterstitialClose() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
        this.mListener.onRewardedVideoAdClosed();
    }

    public void onInterstitialEventNotificationReceived(String str, JSONObject jSONObject) {
        if (!TextUtils.isEmpty(str)) {
            IronLog ironLog = IronLog.ADAPTER_CALLBACK;
            ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener eventName = " + str);
            if ("impressions".equals(str)) {
                this.mListener.onRewardedVideoAdVisible();
            }
        }
    }

    public void onInterstitialInitFailed(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
    }

    public void onInterstitialInitSuccess() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
    }

    public void onInterstitialLoadFailed(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener " + str);
        this.mListener.onRewardedVideoLoadFailed(ErrorBuilder.buildLoadFailedError(str));
        if (!this.mIsRvDemandOnly) {
            this.mListener.onRewardedVideoAvailabilityChanged(false);
        }
    }

    public void onInterstitialLoadSuccess() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
        if (this.mIsRvDemandOnly) {
            this.mListener.onRewardedVideoLoadSuccess();
        } else {
            this.mListener.onRewardedVideoAvailabilityChanged(true);
        }
    }

    public void onInterstitialOpen() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
        this.mListener.onRewardedVideoAdOpened();
    }

    public void onInterstitialShowFailed(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + "rewardedVideoListener " + str);
        this.mListener.onRewardedVideoAdShowFailed(ErrorBuilder.buildShowFailedError(IronSourceConstants.REWARDED_VIDEO_AD_UNIT, str));
    }

    public void onInterstitialShowSuccess() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " rewardedVideoListener");
        if (!this.mIsRvDemandOnly) {
            this.mListener.onRewardedVideoAvailabilityChanged(false);
        }
    }
}
