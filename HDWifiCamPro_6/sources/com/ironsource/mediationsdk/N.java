package com.ironsource.mediationsdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.AdapterDebugInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterAPSDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBidderInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterConsentInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterMetaDataInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterSettingsInterface;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdInteractionAdapter;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdInteractionListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdListener;
import com.ironsource.mediationsdk.adunit.adapter.internal.listener.AdapterAdRewardListener;
import com.ironsource.mediationsdk.adunit.adapter.listener.NetworkInitializationListener;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdData;
import com.ironsource.mediationsdk.adunit.adapter.utility.AdapterErrorType;
import com.ironsource.mediationsdk.adunit.b.c;
import com.ironsource.mediationsdk.adunit.b.d;
import com.ironsource.mediationsdk.c.b;
import com.ironsource.mediationsdk.config.ConfigFile;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.NetworkSettings;
import com.ironsource.mediationsdk.sdk.InterstitialSmashListener;
import com.ironsource.mediationsdk.sdk.RewardedVideoSmashListener;
import com.ironsource.mediationsdk.utils.ErrorBuilder;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class N<Listener extends AdapterAdInteractionListener> extends BaseAdInteractionAdapter<N<Listener>, Listener> implements AdapterDebugInterface, AdapterAPSDataInterface, AdapterBaseInterface, AdapterBidderInterface, AdapterConsentInterface, AdapterMetaDataInterface, AdapterSettingsInterface, InterstitialSmashListener, RewardedVideoSmashListener {
    IronSource.AD_UNIT a;
    private AbstractAdapter b;
    private d c;
    private NetworkInitializationListener d;
    private AdapterAdListener e;

    public N(AbstractAdapter abstractAdapter, NetworkSettings networkSettings, IronSource.AD_UNIT ad_unit) {
        super(ad_unit, networkSettings);
        this.b = abstractAdapter;
        this.a = ad_unit;
        this.c = new d(ad_unit, d.b.PROVIDER, (c) null);
        if (ad_unit == IronSource.AD_UNIT.INTERSTITIAL) {
            this.b.addInterstitialListener(this);
        } else if (ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO) {
            this.b.addRewardedVideoListener(this);
        } else {
            IronLog ironLog = IronLog.INTERNAL;
            ironLog.error(a("ad unit not supported - " + this.a));
        }
    }

    private String a(String str) {
        String ad_unit = this.a.toString();
        if (TextUtils.isEmpty(str)) {
            return ad_unit;
        }
        return ad_unit + " - " + str;
    }

    private boolean a(IronSourceError ironSourceError) {
        if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
            return ironSourceError.getErrorCode() == 1158;
        }
        if (this.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
            return ironSourceError.getErrorCode() == 1058;
        }
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.error(a("ad unit not supported - " + this.a));
        return false;
    }

    public final String getAdapterVersion() {
        try {
            return this.b.getVersion();
        } catch (Exception e2) {
            String str = "Exception while calling adapter.getVersion() from " + this.b.getProviderName() + " - " + e2.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            this.c.e.l(str);
            return null;
        }
    }

    public final Map<String, Object> getBiddingData(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
                return this.b.getInterstitialBiddingData(jSONObject);
            }
            if (this.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
                return this.b.getRewardedVideoBiddingData(jSONObject);
            }
            IronLog.INTERNAL.error(a("ad unit not supported - " + this.a));
            return null;
        } catch (Throwable th) {
            String str = "getBiddingData exception - " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            d dVar = this.c;
            if (dVar == null) {
                return null;
            }
            dVar.e.m(str);
            return null;
        }
    }

    public final LoadWhileShowSupportState getLoadWhileShowSupportedState(NetworkSettings networkSettings) {
        try {
            return this.a == IronSource.AD_UNIT.REWARDED_VIDEO ? this.b.getLoadWhileShowSupportState(networkSettings.getRewardedVideoSettings()) : LoadWhileShowSupportState.NONE;
        } catch (Exception e2) {
            IronLog.INTERNAL.error(a("Exception while calling adapter.getLoadWhileShowSupportedState from " + this.b.getProviderName() + " - " + e2.getLocalizedMessage()));
            return LoadWhileShowSupportState.NONE;
        }
    }

    public final /* bridge */ /* synthetic */ AdapterBaseInterface getNetworkAdapter() {
        return this;
    }

    public final String getNetworkSDKVersion() {
        try {
            return this.b.getCoreSDKVersion();
        } catch (Exception e2) {
            String str = "Exception while calling adapter.getCoreSDKVersion() from " + this.b.getProviderName() + " - " + e2.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            this.c.e.l(str);
            return null;
        }
    }

    public final void init(AdData adData, Context context, NetworkInitializationListener networkInitializationListener) {
        this.d = networkInitializationListener;
        String string = adData.getString("userId");
        try {
            String str = H.a().l;
            if (!TextUtils.isEmpty(str)) {
                this.b.setMediationSegment(str);
            }
            String pluginType = ConfigFile.getConfigFile().getPluginType();
            if (!TextUtils.isEmpty(pluginType)) {
                this.b.setPluginData(pluginType, ConfigFile.getConfigFile().getPluginFrameworkVersion());
            }
        } catch (Throwable th) {
            String str2 = "setCustomParams exception - " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str2));
            d dVar = this.c;
            if (dVar != null) {
                dVar.e.m(str2);
            }
        }
        JSONObject a2 = b.a(adData.getConfiguration());
        try {
            if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
                Integer num = adData.getInt("instanceType");
                if (num == null || num.intValue() != 1) {
                    this.b.initInterstitialForBidding("", string, a2, this);
                } else {
                    this.b.initInterstitial("", string, a2, this);
                }
            } else if (this.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
                this.b.initRewardedVideoWithCallback("", string, a2, this);
            } else {
                IronLog.INTERNAL.error("ad unit not supported - " + this.a);
            }
        } catch (Throwable th2) {
            String str3 = "init failed - " + th2.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str3));
            d dVar2 = this.c;
            if (dVar2 != null) {
                dVar2.e.m(str3);
            }
            if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
                onInterstitialInitFailed(new IronSourceError(IronSourceError.ERROR_IS_INIT_EXCEPTION, str3));
            } else if (this.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
                onRewardedVideoInitFailed(new IronSourceError(IronSourceError.ERROR_RV_INIT_EXCEPTION, str3));
            }
        }
    }

    public final boolean isAdAvailable(AdData adData) {
        JSONObject a2 = b.a(adData.getConfiguration());
        try {
            if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
                return this.b.isInterstitialReady(a2);
            }
            if (this.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
                return this.b.isRewardedVideoAvailable(a2);
            }
            IronLog.INTERNAL.error(a("ad unit not supported - " + this.a));
            return false;
        } catch (Throwable th) {
            String str = "isAdAvailable exception - " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            d dVar = this.c;
            if (dVar == null) {
                return false;
            }
            dVar.e.m(str);
            return false;
        }
    }

    public final /* synthetic */ void loadAd(AdData adData, Activity activity, Object obj) {
        this.e = (AdapterAdInteractionListener) obj;
        JSONObject a2 = b.a(adData.getConfiguration());
        try {
            if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
                Integer num = adData.getInt("instanceType");
                if (num == null || num.intValue() != 1) {
                    this.b.loadInterstitialForBidding(a2, this, adData.getServerData());
                } else {
                    this.b.loadInterstitial(a2, this);
                }
            } else if (this.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
                Integer num2 = adData.getInt("instanceType");
                if (num2 == null || num2.intValue() != 1) {
                    this.b.loadRewardedVideoForBidding(a2, this, adData.getServerData());
                } else {
                    this.b.fetchRewardedVideoForAutomaticLoad(a2, this);
                }
            } else {
                IronLog.INTERNAL.error(a("ad unit not supported - " + this.a));
            }
        } catch (Throwable th) {
            String str = "loadAd exception - " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            d dVar = this.c;
            if (dVar != null) {
                dVar.e.m(str);
            }
            if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
                onInterstitialAdLoadFailed(new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, str));
            } else if (this.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
                onRewardedVideoLoadFailed(new IronSourceError(IronSourceError.ERROR_CODE_GENERIC, str));
            }
        }
    }

    public final void onInterstitialAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener != null) {
            adapterAdListener.onAdClicked();
        }
    }

    public final void onInterstitialAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener instanceof AdapterAdInteractionListener) {
            ((AdapterAdInteractionListener) adapterAdListener).onAdClosed();
        }
    }

    public final void onInterstitialAdLoadFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(a("error = " + ironSourceError));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener != null) {
            adapterAdListener.onAdLoadFailed(a(ironSourceError) ? AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL : AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onInterstitialAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener instanceof AdapterAdInteractionListener) {
            ((AdapterAdInteractionListener) adapterAdListener).onAdOpened();
        }
    }

    public final void onInterstitialAdReady() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener != null) {
            adapterAdListener.onAdLoadSuccess();
        }
    }

    public final void onInterstitialAdShowFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(a("error = " + ironSourceError));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener instanceof AdapterAdInteractionListener) {
            ((AdapterAdInteractionListener) adapterAdListener).onAdShowFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onInterstitialAdShowSucceeded() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener instanceof AdapterAdInteractionListener) {
            ((AdapterAdInteractionListener) adapterAdListener).onAdShowSuccess();
        }
    }

    public final void onInterstitialAdVisible() {
    }

    public final void onInterstitialInitFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(a("error = " + ironSourceError));
        NetworkInitializationListener networkInitializationListener = this.d;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onInterstitialInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        NetworkInitializationListener networkInitializationListener = this.d;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    public final void onRewardedVideoAdClicked() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener != null) {
            adapterAdListener.onAdClicked();
        }
    }

    public final void onRewardedVideoAdClosed() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener instanceof AdapterAdInteractionListener) {
            ((AdapterAdInteractionListener) adapterAdListener).onAdClosed();
        }
    }

    public final void onRewardedVideoAdEnded() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener instanceof AdapterAdInteractionListener) {
            ((AdapterAdInteractionListener) adapterAdListener).onAdEnded();
        }
    }

    public final void onRewardedVideoAdOpened() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener instanceof AdapterAdInteractionListener) {
            ((AdapterAdInteractionListener) adapterAdListener).onAdOpened();
        }
    }

    public final void onRewardedVideoAdRewarded() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener instanceof AdapterAdRewardListener) {
            ((AdapterAdRewardListener) adapterAdListener).onAdRewarded();
        }
    }

    public final void onRewardedVideoAdShowFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(a("error = " + ironSourceError));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener instanceof AdapterAdInteractionListener) {
            ((AdapterAdInteractionListener) adapterAdListener).onAdShowFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onRewardedVideoAdStarted() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener instanceof AdapterAdInteractionListener) {
            ((AdapterAdInteractionListener) adapterAdListener).onAdStarted();
        }
    }

    public final void onRewardedVideoAdVisible() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener instanceof AdapterAdInteractionListener) {
            ((AdapterAdInteractionListener) adapterAdListener).onAdVisible();
        }
    }

    public final void onRewardedVideoAvailabilityChanged(boolean z) {
        IronLog ironLog = IronLog.INTERNAL;
        ironLog.verbose(a("available = " + z));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener == null) {
            return;
        }
        if (z) {
            adapterAdListener.onAdLoadSuccess();
            return;
        }
        IronSourceError buildLoadFailedError = ErrorBuilder.buildLoadFailedError(this.a.name(), this.b.getProviderName(), "availability changed to false");
        this.e.onAdLoadFailed(AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL, buildLoadFailedError.getErrorCode(), buildLoadFailedError.getErrorMessage());
    }

    public final void onRewardedVideoInitFailed(IronSourceError ironSourceError) {
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(a("error = " + ironSourceError));
        NetworkInitializationListener networkInitializationListener = this.d;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitFailed(ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onRewardedVideoInitSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        NetworkInitializationListener networkInitializationListener = this.d;
        if (networkInitializationListener != null) {
            networkInitializationListener.onInitSuccess();
        }
    }

    public final void onRewardedVideoLoadFailed(IronSourceError ironSourceError) {
        AdapterErrorType adapterErrorType;
        IronLog ironLog = IronLog.ADAPTER_CALLBACK;
        ironLog.verbose(a("error = " + ironSourceError));
        if (this.e != null) {
            if (a(ironSourceError)) {
                adapterErrorType = AdapterErrorType.ADAPTER_ERROR_TYPE_NO_FILL;
            } else {
                boolean z = false;
                if (this.a != IronSource.AD_UNIT.INTERSTITIAL) {
                    if (this.a != IronSource.AD_UNIT.REWARDED_VIDEO) {
                        IronLog ironLog2 = IronLog.INTERNAL;
                        ironLog2.error(a("ad unit not supported - " + this.a));
                    } else if (ironSourceError.getErrorCode() == 1057) {
                        z = true;
                    }
                }
                adapterErrorType = z ? AdapterErrorType.ADAPTER_ERROR_TYPE_AD_EXPIRED : AdapterErrorType.ADAPTER_ERROR_TYPE_INTERNAL;
            }
            this.e.onAdLoadFailed(adapterErrorType, ironSourceError.getErrorCode(), ironSourceError.getErrorMessage());
        }
    }

    public final void onRewardedVideoLoadSuccess() {
        IronLog.ADAPTER_CALLBACK.verbose(a(""));
        AdapterAdListener adapterAdListener = this.e;
        if (adapterAdListener != null) {
            adapterAdListener.onAdLoadSuccess();
        }
    }

    public final void releaseMemory() {
        AbstractAdapter abstractAdapter = this.b;
        if (abstractAdapter != null) {
            try {
                abstractAdapter.releaseMemory(this.a, new JSONObject());
                this.b = null;
            } catch (Exception e2) {
                String str = "Exception while calling adapter.releaseMemory() from " + this.b.getProviderName() + " - " + e2.getLocalizedMessage();
                IronLog.INTERNAL.error(a(str));
                this.c.e.l(str);
            }
        }
        this.d = null;
        this.e = null;
        d dVar = this.c;
        if (dVar != null) {
            dVar.a();
            this.c = null;
        }
    }

    public final void setAPSData(IronSource.AD_UNIT ad_unit, JSONObject jSONObject) {
        AbstractAdapter abstractAdapter = this.b;
        if (abstractAdapter != null && (abstractAdapter instanceof SetAPSInterface)) {
            ((SetAPSInterface) abstractAdapter).setAPSData(ad_unit, jSONObject);
        }
    }

    public final void setAdapterDebug(boolean z) {
        AbstractAdapter abstractAdapter = this.b;
        if (abstractAdapter != null) {
            try {
                abstractAdapter.setAdapterDebug(Boolean.valueOf(z));
            } catch (Exception e2) {
                String str = "Exception while calling adapter.setAdapterDebug(adapterDebug) from " + this.b.getProviderName() + " - " + e2.getLocalizedMessage();
                IronLog.INTERNAL.error(a(str));
                this.c.e.l(str);
            }
        }
    }

    public final void setConsent(boolean z) {
        AbstractAdapter abstractAdapter = this.b;
        if (abstractAdapter != null) {
            try {
                abstractAdapter.setConsent(z);
            } catch (Exception e2) {
                String str = "Exception while calling adapter.setConsent(consent) from " + this.b.getProviderName() + " - " + e2.getLocalizedMessage();
                IronLog.INTERNAL.error(a(str));
                this.c.e.l(str);
            }
        }
    }

    public final void setMetaData(String str, List<String> list) {
        AbstractAdapter abstractAdapter = this.b;
        if (abstractAdapter != null) {
            abstractAdapter.setMetaData(str, list);
        }
    }

    public final void showAd(AdData adData, Listener listener) {
        this.e = listener;
        JSONObject a2 = b.a(adData.getConfiguration());
        try {
            if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
                this.b.showInterstitial(a2, this);
            } else if (this.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
                this.b.showRewardedVideo(a2, this);
            } else {
                IronLog.INTERNAL.error(a("ad unit not supported - " + this.a));
            }
        } catch (Throwable th) {
            String str = "showAd exception - " + th.getLocalizedMessage();
            IronLog.INTERNAL.error(a(str));
            d dVar = this.c;
            if (dVar != null) {
                dVar.e.m(str);
            }
            if (this.a == IronSource.AD_UNIT.INTERSTITIAL) {
                onInterstitialAdShowFailed(new IronSourceError(IronSourceError.ERROR_IS_SHOW_EXCEPTION, str));
            } else if (this.a == IronSource.AD_UNIT.REWARDED_VIDEO) {
                onRewardedVideoAdShowFailed(new IronSourceError(IronSourceError.ERROR_RV_SHOW_EXCEPTION, str));
            }
        }
    }
}
