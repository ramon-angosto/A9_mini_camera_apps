package com.vungle.mediation;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.google.ads.mediation.vungle.VungleBannerAd;
import com.google.ads.mediation.vungle.VungleInitializer;
import com.google.ads.mediation.vungle.VungleMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.vungle.mediation.AdapterParametersParser;
import com.vungle.warren.AdConfig;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.PlayAdCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;

public class VungleInterstitialAdapter implements MediationInterstitialAdapter, MediationBannerAdapter {
    private AdConfig mAdConfig;
    private MediationBannerListener mMediationBannerListener;
    /* access modifiers changed from: private */
    public MediationInterstitialListener mMediationInterstitialListener;
    private String mPlacement;
    private VungleManager mVungleManager;
    private VungleBannerAdapter vungleBannerAdapter;

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        String string = bundle.getString("appid");
        if (!TextUtils.isEmpty(string)) {
            this.mMediationInterstitialListener = mediationInterstitialListener;
            this.mVungleManager = VungleManager.getInstance();
            this.mPlacement = this.mVungleManager.findPlacement(bundle2, bundle);
            if (TextUtils.isEmpty(this.mPlacement)) {
                AdError adError = new AdError(101, "Failed to load ad from Vungle. Missing or Invalid Placement ID.", VungleMediationAdapter.ERROR_DOMAIN);
                Log.w(VungleMediationAdapter.TAG, adError.toString());
                this.mMediationInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) this, adError);
                return;
            }
            VungleInitializer.getInstance().updateCoppaStatus(mediationAdRequest.taggedForChildDirectedTreatment());
            AdapterParametersParser.Config parse = AdapterParametersParser.parse(string, bundle2);
            this.mAdConfig = VungleExtrasBuilder.adConfigWithNetworkExtras(bundle2, false);
            VungleInitializer.getInstance().initialize(parse.getAppId(), context.getApplicationContext(), new VungleInitializer.VungleInitializationListener() {
                public void onInitializeSuccess() {
                    VungleInterstitialAdapter.this.loadAd();
                }

                public void onInitializeError(AdError adError) {
                    if (VungleInterstitialAdapter.this.mMediationInterstitialListener != null) {
                        VungleInterstitialAdapter.this.mMediationInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) VungleInterstitialAdapter.this, adError);
                        Log.w(VungleMediationAdapter.TAG, adError.toString());
                    }
                }
            });
        } else if (mediationInterstitialListener != null) {
            AdError adError2 = new AdError(101, "Missing or invalid App ID.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError2.toString());
            mediationInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) this, adError2);
        }
    }

    /* access modifiers changed from: private */
    public void loadAd() {
        if (Vungle.canPlayAd(this.mPlacement)) {
            MediationInterstitialListener mediationInterstitialListener = this.mMediationInterstitialListener;
            if (mediationInterstitialListener != null) {
                mediationInterstitialListener.onAdLoaded(this);
                return;
            }
            return;
        }
        Vungle.loadAd(this.mPlacement, new LoadAdCallback() {
            public void onAdLoad(String str) {
                if (VungleInterstitialAdapter.this.mMediationInterstitialListener != null) {
                    VungleInterstitialAdapter.this.mMediationInterstitialListener.onAdLoaded(VungleInterstitialAdapter.this);
                }
            }

            public void onError(String str, VungleException vungleException) {
                AdError adError = VungleMediationAdapter.getAdError(vungleException);
                Log.w(VungleMediationAdapter.TAG, adError.toString());
                if (VungleInterstitialAdapter.this.mMediationInterstitialListener != null) {
                    VungleInterstitialAdapter.this.mMediationInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) VungleInterstitialAdapter.this, adError);
                }
            }
        });
    }

    public void showInterstitial() {
        Vungle.playAd(this.mPlacement, this.mAdConfig, new PlayAdCallback() {
            public void creativeId(String str) {
            }

            public void onAdEnd(String str, boolean z, boolean z2) {
            }

            public void onAdRewarded(String str) {
            }

            public void onAdViewed(String str) {
            }

            public void onAdStart(String str) {
                if (VungleInterstitialAdapter.this.mMediationInterstitialListener != null) {
                    VungleInterstitialAdapter.this.mMediationInterstitialListener.onAdOpened(VungleInterstitialAdapter.this);
                }
            }

            public void onAdEnd(String str) {
                if (VungleInterstitialAdapter.this.mMediationInterstitialListener != null) {
                    VungleInterstitialAdapter.this.mMediationInterstitialListener.onAdClosed(VungleInterstitialAdapter.this);
                }
            }

            public void onAdClick(String str) {
                if (VungleInterstitialAdapter.this.mMediationInterstitialListener != null) {
                    VungleInterstitialAdapter.this.mMediationInterstitialListener.onAdClicked(VungleInterstitialAdapter.this);
                }
            }

            public void onAdLeftApplication(String str) {
                if (VungleInterstitialAdapter.this.mMediationInterstitialListener != null) {
                    VungleInterstitialAdapter.this.mMediationInterstitialListener.onAdLeftApplication(VungleInterstitialAdapter.this);
                }
            }

            public void onError(String str, VungleException vungleException) {
                Log.w(VungleMediationAdapter.TAG, VungleMediationAdapter.getAdError(vungleException).toString());
                if (VungleInterstitialAdapter.this.mMediationInterstitialListener != null) {
                    VungleInterstitialAdapter.this.mMediationInterstitialListener.onAdClosed(VungleInterstitialAdapter.this);
                }
            }
        });
    }

    public void onDestroy() {
        String str = VungleMediationAdapter.TAG;
        Log.d(str, "onDestroy: " + hashCode());
        VungleBannerAdapter vungleBannerAdapter2 = this.vungleBannerAdapter;
        if (vungleBannerAdapter2 != null) {
            vungleBannerAdapter2.destroy();
            this.vungleBannerAdapter = null;
        }
    }

    public void onPause() {
        Log.d(VungleMediationAdapter.TAG, "onPause");
        VungleBannerAdapter vungleBannerAdapter2 = this.vungleBannerAdapter;
        if (vungleBannerAdapter2 != null) {
            vungleBannerAdapter2.updateVisibility(false);
        }
    }

    public void onResume() {
        Log.d(VungleMediationAdapter.TAG, "onResume");
        VungleBannerAdapter vungleBannerAdapter2 = this.vungleBannerAdapter;
        if (vungleBannerAdapter2 != null) {
            vungleBannerAdapter2.updateVisibility(true);
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.mMediationBannerListener = mediationBannerListener;
        String string = bundle.getString("appid");
        AdapterParametersParser.Config parse = AdapterParametersParser.parse(string, bundle2);
        if (!TextUtils.isEmpty(string)) {
            VungleInitializer.getInstance().updateCoppaStatus(mediationAdRequest.taggedForChildDirectedTreatment());
            this.mVungleManager = VungleManager.getInstance();
            String findPlacement = this.mVungleManager.findPlacement(bundle2, bundle);
            String str = VungleMediationAdapter.TAG;
            Log.d(str, "requestBannerAd for Placement: " + findPlacement + " ### Adapter instance: " + hashCode());
            if (TextUtils.isEmpty(findPlacement)) {
                AdError adError = new AdError(101, "Failed to load ad from Vungle. Missing or Invalid placement ID.", VungleMediationAdapter.ERROR_DOMAIN);
                Log.w(VungleMediationAdapter.TAG, adError.toString());
                this.mMediationBannerListener.onAdFailedToLoad((MediationBannerAdapter) this, adError);
                return;
            }
            AdConfig adConfigWithNetworkExtras = VungleExtrasBuilder.adConfigWithNetworkExtras(bundle2, true);
            if (!this.mVungleManager.hasBannerSizeAd(context, adSize, adConfigWithNetworkExtras)) {
                AdError adError2 = new AdError(102, "Failed to load ad from Vungle. Invalid banner size.", VungleMediationAdapter.ERROR_DOMAIN);
                Log.w(VungleMediationAdapter.TAG, adError2.toString());
                this.mMediationBannerListener.onAdFailedToLoad((MediationBannerAdapter) this, adError2);
                return;
            }
            String requestUniqueId = parse.getRequestUniqueId();
            if (!this.mVungleManager.canRequestBannerAd(findPlacement, requestUniqueId)) {
                AdError adError3 = new AdError(104, "Vungle adapter does not support multiple banner instances for same placement.", VungleMediationAdapter.ERROR_DOMAIN);
                Log.w(VungleMediationAdapter.TAG, adError3.toString());
                this.mMediationBannerListener.onAdFailedToLoad((MediationBannerAdapter) this, adError3);
                return;
            }
            this.vungleBannerAdapter = new VungleBannerAdapter(findPlacement, requestUniqueId, adConfigWithNetworkExtras, this);
            String str2 = VungleMediationAdapter.TAG;
            Log.d(str2, "New banner adapter: " + this.vungleBannerAdapter + "; size: " + adConfigWithNetworkExtras.getAdSize());
            this.mVungleManager.registerBannerAd(findPlacement, new VungleBannerAd(findPlacement, this.vungleBannerAdapter));
            String str3 = VungleMediationAdapter.TAG;
            Log.d(str3, "Requesting banner with ad size: " + adConfigWithNetworkExtras.getAdSize());
            this.vungleBannerAdapter.requestBannerAd(context, parse.getAppId(), adSize, this.mMediationBannerListener);
        } else if (mediationBannerListener != null) {
            AdError adError4 = new AdError(101, "Failed to load ad from Vungle. Missing or invalid app ID.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError4.toString());
            mediationBannerListener.onAdFailedToLoad((MediationBannerAdapter) this, adError4);
        }
    }

    public View getBannerView() {
        String str = VungleMediationAdapter.TAG;
        Log.d(str, "getBannerView # instance: " + hashCode());
        return this.vungleBannerAdapter.getAdLayout();
    }
}
