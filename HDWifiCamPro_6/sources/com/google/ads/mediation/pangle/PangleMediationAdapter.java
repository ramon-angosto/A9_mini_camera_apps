package com.google.ads.mediation.pangle;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.init.PAGConfig;
import com.bytedance.sdk.openadsdk.api.init.PAGSdk;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.rtb.PangleRtbBannerAd;
import com.google.ads.mediation.pangle.rtb.PangleRtbInterstitialAd;
import com.google.ads.mediation.pangle.rtb.PangleRtbNativeAd;
import com.google.ads.mediation.pangle.rtb.PangleRtbRewardedAd;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import java.util.HashSet;
import java.util.List;

public class PangleMediationAdapter extends RtbAdapter {
    public static final String TAG = PangleMediationAdapter.class.getSimpleName();
    private static int ccpa = -1;
    private static int gdpr = -1;
    private PangleRtbBannerAd bannerAd;
    private PangleRtbInterstitialAd interstitialAd;
    private PangleRtbNativeAd nativeAd;
    private PangleRtbRewardedAd rewardedAd;

    public void collectSignals(RtbSignalData rtbSignalData, SignalCallbacks signalCallbacks) {
        Bundle networkExtras = rtbSignalData.getNetworkExtras();
        if (networkExtras != null && networkExtras.containsKey("user_data")) {
            PAGConfig.setUserData(networkExtras.getString("user_data", ""));
        }
        signalCallbacks.onSuccess(PAGSdk.getBiddingToken());
    }

    public void initialize(Context context, final InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        HashSet hashSet = new HashSet();
        for (MediationConfiguration serverParameters : list) {
            String string = serverParameters.getServerParameters().getString("appid");
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        int size = hashSet.size();
        if (size <= 0) {
            AdError createAdapterError = PangleConstants.createAdapterError(101, "Missing or invalid App ID.");
            Log.w(TAG, createAdapterError.toString());
            initializationCompleteCallback.onInitializationFailed(createAdapterError.toString());
            return;
        }
        String str = (String) hashSet.iterator().next();
        if (size > 1) {
            Log.w(TAG, String.format("Found multiple app IDs in %s. Using %s to initialize Pangle SDK.", new Object[]{hashSet, str}));
        }
        PangleAdapterUtils.setCoppa(MobileAds.getRequestConfiguration().getTagForChildDirectedTreatment());
        PangleInitializer.getInstance().initialize(context, str, new PangleInitializer.Listener() {
            public void onInitializeSuccess() {
                initializationCompleteCallback.onInitializationSucceeded();
            }

            public void onInitializeError(AdError adError) {
                Log.w(PangleMediationAdapter.TAG, adError.toString());
                initializationCompleteCallback.onInitializationFailed(adError.getMessage());
            }
        });
    }

    public VersionInfo getVersionInfo() {
        String[] split = BuildConfig.ADAPTER_VERSION.split("\\.");
        if (split.length >= 4) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            int parseInt3 = (Integer.parseInt(split[2]) * 100) + Integer.parseInt(split[3]);
            if (split.length >= 5) {
                parseInt3 = (parseInt3 * 100) + Integer.parseInt(split[4]);
            }
            return new VersionInfo(parseInt, parseInt2, parseInt3);
        }
        Log.w(TAG, String.format("Unexpected adapter version format: %s. Returning 0.0.0 for adapter version.", new Object[]{BuildConfig.ADAPTER_VERSION}));
        return new VersionInfo(0, 0, 0);
    }

    public VersionInfo getSDKVersionInfo() {
        String sDKVersion = PAGSdk.getSDKVersion();
        String[] split = sDKVersion.split("\\.");
        if (split.length >= 3) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            int parseInt3 = Integer.parseInt(split[2]);
            if (split.length >= 4) {
                parseInt3 = (parseInt3 * 100) + Integer.parseInt(split[3]);
            }
            return new VersionInfo(parseInt, parseInt2, parseInt3);
        }
        Log.w(TAG, String.format("Unexpected SDK version format: %s. Returning 0.0.0 for SDK version.", new Object[]{sDKVersion}));
        return new VersionInfo(0, 0, 0);
    }

    public void loadRtbBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.bannerAd = new PangleRtbBannerAd(mediationBannerAdConfiguration, mediationAdLoadCallback);
        this.bannerAd.render();
    }

    public void loadRtbInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.interstitialAd = new PangleRtbInterstitialAd(mediationInterstitialAdConfiguration, mediationAdLoadCallback);
        this.interstitialAd.render();
    }

    public void loadRtbNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        this.nativeAd = new PangleRtbNativeAd(mediationNativeAdConfiguration, mediationAdLoadCallback);
        this.nativeAd.render();
    }

    public void loadRtbRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.rewardedAd = new PangleRtbRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
        this.rewardedAd.render();
    }

    public static void setGDPRConsent(int i) {
        if (i == 1 || i == 0 || i == -1) {
            if (PAGSdk.isInitSuccess()) {
                PAGConfig.setGDPRConsent(i);
            }
            gdpr = i;
            return;
        }
        Log.w(TAG, "Invalid GDPR value. Pangle SDK only accepts -1, 0 or 1.");
    }

    public static int getGDPRConsent() {
        return gdpr;
    }

    public static void setDoNotSell(int i) {
        if (i == 0 || i == 1 || i == -1) {
            if (PAGSdk.isInitSuccess()) {
                PAGConfig.setDoNotSell(i);
            }
            ccpa = i;
            return;
        }
        Log.w(TAG, "Invalid CCPA value. Pangle SDK only accepts -1, 0 or 1.");
    }

    public static int getDoNotSell() {
        return ccpa;
    }
}
