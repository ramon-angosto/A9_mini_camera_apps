package com.google.ads.mediation.adcolony;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAppOptions;
import com.adcolony.sdk.AdColonySignalsListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.VersionInfo;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;
import com.jirbo.adcolony.AdColonyManager;
import com.jirbo.adcolony.BuildConfig;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AdColonyMediationAdapter extends RtbAdapter {
    private static final String ADCOLONY_SDK_ERROR_DOMAIN = "com.jirbo.adcolony";
    public static final int ERROR_ADCOLONY_NOT_INITIALIZED = 103;
    public static final int ERROR_ADCOLONY_SDK = 100;
    public static final int ERROR_AD_ALREADY_REQUESTED = 102;
    public static final int ERROR_BANNER_SIZE_MISMATCH = 104;
    public static final int ERROR_CONTEXT_NOT_ACTIVITY = 106;
    private static final String ERROR_DOMAIN = "com.google.ads.mediation.adcolony";
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    public static final int ERROR_PRESENTATION_AD_NOT_LOADED = 105;
    public static final String TAG = AdColonyMediationAdapter.class.getSimpleName();
    private static final AdColonyAppOptions appOptions = new AdColonyAppOptions();
    private AdColonyBannerRenderer adColonyBannerRenderer;
    private AdColonyInterstitialRenderer adColonyInterstitialRenderer;
    private AdColonyRewardedRenderer adColonyRewardedRenderer;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AdapterError {
    }

    public static AdError createAdapterError(int i, String str) {
        return new AdError(i, str, ERROR_DOMAIN);
    }

    public static AdError createSdkError() {
        return createSdkError(100, "AdColony SDK returned a failure callback.");
    }

    public static AdError createSdkError(int i, String str) {
        return new AdError(i, str, "com.jirbo.adcolony");
    }

    public VersionInfo getVersionInfo() {
        String[] split = BuildConfig.ADAPTER_VERSION.split("\\.");
        if (split.length >= 4) {
            return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), (Integer.parseInt(split[2]) * 100) + Integer.parseInt(split[3]));
        }
        Log.w(TAG, String.format("Unexpected adapter version format: %s. Returning 0.0.0 for adapter version.", new Object[]{BuildConfig.ADAPTER_VERSION}));
        return new VersionInfo(0, 0, 0);
    }

    public VersionInfo getSDKVersionInfo() {
        String sDKVersion = AdColony.getSDKVersion();
        String[] split = sDKVersion.split("\\.");
        if (split.length >= 3) {
            return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }
        Log.w(TAG, String.format("Unexpected SDK version format: %s. Returning 0.0.0 for SDK version.", new Object[]{sDKVersion}));
        return new VersionInfo(0, 0, 0);
    }

    public void initialize(Context context, final InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        if ((context instanceof Activity) || (context instanceof Application)) {
            HashSet hashSet = new HashSet();
            ArrayList arrayList = new ArrayList();
            for (MediationConfiguration serverParameters : list) {
                Bundle serverParameters2 = serverParameters.getServerParameters();
                String string = serverParameters2.getString("app_id");
                if (!TextUtils.isEmpty(string)) {
                    hashSet.add(string);
                }
                ArrayList<String> parseZoneList = AdColonyManager.getInstance().parseZoneList(serverParameters2);
                if (parseZoneList != null && parseZoneList.size() > 0) {
                    arrayList.addAll(parseZoneList);
                }
            }
            int size = hashSet.size();
            if (size <= 0) {
                initializationCompleteCallback.onInitializationFailed(createAdapterError(101, "Missing or invalid AdColony app ID.").toString());
                return;
            }
            String str = (String) hashSet.iterator().next();
            if (size > 1) {
                Log.w(TAG, String.format("Multiple '%s' entries found: %s. Using '%s' to initialize the AdColony SDK.", new Object[]{"app_id", hashSet, str}));
            }
            appOptions.setMediationNetwork(AdColonyAppOptions.ADMOB, BuildConfig.ADAPTER_VERSION);
            AdColonyManager.getInstance().configureAdColony(context, appOptions, str, arrayList, new AdColonyManager.InitializationListener() {
                public void onInitializeSuccess() {
                    initializationCompleteCallback.onInitializationSucceeded();
                }

                public void onInitializeFailed(AdError adError) {
                    initializationCompleteCallback.onInitializationFailed(adError.toString());
                }
            });
            return;
        }
        initializationCompleteCallback.onInitializationFailed(createAdapterError(106, "AdColony SDK requires an Activity or Application context to initialize.").toString());
    }

    public void loadRtbBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.adColonyBannerRenderer = new AdColonyBannerRenderer(mediationBannerAdConfiguration, mediationAdLoadCallback);
        this.adColonyBannerRenderer.render();
    }

    public void loadRtbInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.adColonyInterstitialRenderer = new AdColonyInterstitialRenderer(mediationInterstitialAdConfiguration, mediationAdLoadCallback);
        this.adColonyInterstitialRenderer.render();
    }

    public void loadRtbRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        loadRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.adColonyRewardedRenderer = new AdColonyRewardedRenderer(mediationRewardedAdConfiguration, mediationAdLoadCallback);
        this.adColonyRewardedRenderer.render();
    }

    public static AdColonyAppOptions getAppOptions() {
        return appOptions;
    }

    public void collectSignals(RtbSignalData rtbSignalData, final SignalCallbacks signalCallbacks) {
        AdColony.collectSignals(new AdColonySignalsListener() {
            public void onSuccess(String str) {
                signalCallbacks.onSuccess(str);
            }

            public void onFailure() {
                AdError createSdkError = AdColonyMediationAdapter.createSdkError(100, "Failed to get signals from AdColony.");
                Log.e(AdColonyMediationAdapter.TAG, createSdkError.getMessage());
                signalCallbacks.onFailure(createSdkError);
            }
        });
    }
}
