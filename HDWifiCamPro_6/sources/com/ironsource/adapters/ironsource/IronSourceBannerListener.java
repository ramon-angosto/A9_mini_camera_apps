package com.ironsource.adapters.ironsource;

import android.widget.FrameLayout;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.sdk.BannerSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import com.ironsource.sdk.c.a;
import com.ironsource.sdk.j.b;
import java.lang.ref.WeakReference;

class IronSourceBannerListener implements b {
    private WeakReference<IronSourceAdapter> mAdapter;
    private final String mDemandSourceName;
    private final BannerSmashListener mListener;

    IronSourceBannerListener(IronSourceAdapter ironSourceAdapter, BannerSmashListener bannerSmashListener, String str) {
        this.mDemandSourceName = str;
        this.mListener = bannerSmashListener;
        this.mAdapter = new WeakReference<>(ironSourceAdapter);
    }

    public void onBannerClick() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " bannerListener");
        this.mListener.onBannerAdClicked();
    }

    public void onBannerInitFailed(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " bannerListener");
        this.mListener.onBannerInitFailed(new IronSourceError(IronSourceError.ERROR_BN_INSTANCE_INIT_ERROR, str));
    }

    public void onBannerInitSuccess() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " bannerListener");
        this.mListener.onBannerInitSuccess();
    }

    public void onBannerLoadFail(String str) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " bannerListener");
        BannerSmashListener bannerSmashListener = this.mListener;
        bannerSmashListener.onBannerAdLoadFailed(ErrorBuilder.buildLoadFailedError("load failed - error = " + str));
    }

    public void onBannerLoadSuccess(a aVar) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " bannerListener");
        if (this.mAdapter.get() == null) {
            return;
        }
        if (aVar == null) {
            this.mListener.onBannerAdLoadFailed(ErrorBuilder.adContainerIsNull(((IronSourceAdapter) this.mAdapter.get()).getProviderName()));
            return;
        }
        ((IronSourceAdapter) this.mAdapter.get()).mBannerAdContainer = aVar;
        com.ironsource.sdk.a aVar2 = aVar.a != null ? aVar.a.d : new com.ironsource.sdk.a();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(aVar2.a, aVar2.b);
        layoutParams.gravity = 17;
        this.mListener.onBannerAdLoaded(aVar, layoutParams);
    }

    public void onBannerShowSuccess() {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(this.mDemandSourceName + " onBannerShowSuccess");
        BannerSmashListener bannerSmashListener = this.mListener;
        if (bannerSmashListener != null) {
            bannerSmashListener.onBannerAdShown();
        }
    }
}
