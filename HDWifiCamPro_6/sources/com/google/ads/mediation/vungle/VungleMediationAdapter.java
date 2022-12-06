package com.google.ads.mediation.vungle;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.ads.mediation.vungle.VungleInitializer;
import com.google.ads.mediation.vungle.rtb.VungleRtbInterstitialAd;
import com.google.ads.mediation.vungle.rtb.VungleRtbNativeAd;
import com.google.ads.mediation.vungle.rtb.VungleRtbRewardedAd;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
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
import com.google.android.gms.ads.rewarded.RewardItem;
import com.vungle.mediation.VungleExtrasBuilder;
import com.vungle.mediation.VungleManager;
import com.vungle.warren.AdConfig;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.PlayAdCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class VungleMediationAdapter extends RtbAdapter implements MediationRewardedAd, LoadAdCallback, PlayAdCallback {
    public static final int ERROR_AD_ALREADY_LOADED = 104;
    public static final int ERROR_BANNER_SIZE_MISMATCH = 102;
    public static final int ERROR_CANNOT_PLAY_AD = 107;
    public static final String ERROR_DOMAIN = "com.google.ads.mediation.vungle";
    public static final int ERROR_INITIALIZATION_FAILURE = 105;
    public static final int ERROR_INVALID_SERVER_PARAMETERS = 101;
    public static final int ERROR_REQUIRES_ACTIVITY_CONTEXT = 103;
    public static final int ERROR_VUNGLE_BANNER_NULL = 106;
    public static final String KEY_APP_ID = "appid";
    public static final String TAG = VungleMediationAdapter.class.getSimpleName();
    public static final String VUNGLE_SDK_ERROR_DOMAIN = "com.vungle.warren";
    /* access modifiers changed from: private */
    public static final HashMap<String, WeakReference<VungleMediationAdapter>> mPlacementsInUse = new HashMap<>();
    /* access modifiers changed from: private */
    public AdConfig mAdConfig;
    /* access modifiers changed from: private */
    public MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mMediationAdLoadCallback;
    /* access modifiers changed from: private */
    public MediationRewardedAdCallback mMediationRewardedAdCallback;
    /* access modifiers changed from: private */
    public String mPlacement;
    /* access modifiers changed from: private */
    public String mUserID;
    private VungleRtbInterstitialAd rtbInterstitialAd;
    private VungleRtbNativeAd rtbNativeAd;
    private VungleRtbRewardedAd rtbRewardedAd;
    private VungleRtbRewardedAd rtbRewardedInterstitialAd;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AdapterError {
    }

    public void creativeId(String str) {
    }

    @Deprecated
    public void onAdEnd(String str, boolean z, boolean z2) {
    }

    public void onAdLeftApplication(String str) {
    }

    public static AdError getAdError(VungleException vungleException) {
        return new AdError(vungleException.getExceptionCode(), vungleException.getLocalizedMessage(), "com.vungle.warren");
    }

    public VersionInfo getVersionInfo() {
        String[] split = "6.12.0.0".split("\\.");
        if (split.length >= 4) {
            return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), (Integer.parseInt(split[2]) * 100) + Integer.parseInt(split[3]));
        }
        Log.w(TAG, String.format("Unexpected adapter version format: %s. Returning 0.0.0 for adapter version.", new Object[]{"6.12.0.0"}));
        return new VersionInfo(0, 0, 0);
    }

    public VersionInfo getSDKVersionInfo() {
        String[] split = "6.12.0".split("\\.");
        if (split.length >= 3) {
            return new VersionInfo(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));
        }
        Log.w(TAG, String.format("Unexpected SDK version format: %s. Returning 0.0.0 for SDK version.", new Object[]{"6.12.0"}));
        return new VersionInfo(0, 0, 0);
    }

    public void collectSignals(RtbSignalData rtbSignalData, SignalCallbacks signalCallbacks) {
        String availableBidTokens = Vungle.getAvailableBidTokens(rtbSignalData.getContext());
        String str = TAG;
        Log.d(str, "token=" + availableBidTokens);
        signalCallbacks.onSuccess(availableBidTokens);
    }

    public void initialize(Context context, final InitializationCompleteCallback initializationCompleteCallback, List<MediationConfiguration> list) {
        if (Vungle.isInitialized()) {
            initializationCompleteCallback.onInitializationSucceeded();
            return;
        }
        HashSet hashSet = new HashSet();
        for (MediationConfiguration serverParameters : list) {
            String string = serverParameters.getServerParameters().getString("appid");
            if (!TextUtils.isEmpty(string)) {
                hashSet.add(string);
            }
        }
        int size = hashSet.size();
        if (size > 0) {
            String str = (String) hashSet.iterator().next();
            if (size > 1) {
                Log.w(TAG, String.format("Multiple '%s' entries found: %s. Using '%s' to initialize the Vungle SDK.", new Object[]{"appid", hashSet, str}));
            }
            VungleInitializer.getInstance().initialize(str, context.getApplicationContext(), new VungleInitializer.VungleInitializationListener() {
                public void onInitializeSuccess() {
                    initializationCompleteCallback.onInitializationSucceeded();
                }

                public void onInitializeError(AdError adError) {
                    Log.w(VungleMediationAdapter.TAG, adError.toString());
                    initializationCompleteCallback.onInitializationFailed(adError.toString());
                }
            });
        } else if (initializationCompleteCallback != null) {
            AdError adError = new AdError(101, "Missing or Invalid App ID.", ERROR_DOMAIN);
            Log.w(TAG, adError.toString());
            initializationCompleteCallback.onInitializationFailed(adError.toString());
        }
    }

    public void loadRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.mMediationAdLoadCallback = mediationAdLoadCallback;
        Bundle mediationExtras = mediationRewardedAdConfiguration.getMediationExtras();
        Bundle serverParameters = mediationRewardedAdConfiguration.getServerParameters();
        if (mediationExtras != null) {
            this.mUserID = mediationExtras.getString("userId");
        }
        this.mPlacement = VungleManager.getInstance().findPlacement(mediationExtras, serverParameters);
        if (TextUtils.isEmpty(this.mPlacement)) {
            AdError adError = new AdError(101, "Failed to load ad from Vungle. Missing or invalid Placement ID.", ERROR_DOMAIN);
            Log.w(TAG, adError.toString());
            mediationAdLoadCallback.onFailure(adError);
        } else if (!mPlacementsInUse.containsKey(this.mPlacement) || mPlacementsInUse.get(this.mPlacement).get() == null) {
            String string = serverParameters.getString("appid");
            if (TextUtils.isEmpty(string)) {
                AdError adError2 = new AdError(101, "Failed to load ad from Vungle. Missing or Invalid App ID.", ERROR_DOMAIN);
                Log.w(TAG, adError2.toString());
                mediationAdLoadCallback.onFailure(adError2);
                return;
            }
            this.mAdConfig = VungleExtrasBuilder.adConfigWithNetworkExtras(mediationExtras, false);
            VungleInitializer.getInstance().updateCoppaStatus(mediationRewardedAdConfiguration.taggedForChildDirectedTreatment());
            VungleInitializer.getInstance().initialize(string, mediationRewardedAdConfiguration.getContext(), new VungleInitializer.VungleInitializationListener() {
                public void onInitializeSuccess() {
                    Vungle.setIncentivizedFields(VungleMediationAdapter.this.mUserID, (String) null, (String) null, (String) null, (String) null);
                    VungleMediationAdapter.mPlacementsInUse.put(VungleMediationAdapter.this.mPlacement, new WeakReference(VungleMediationAdapter.this));
                    if (Vungle.canPlayAd(VungleMediationAdapter.this.mPlacement)) {
                        VungleMediationAdapter vungleMediationAdapter = VungleMediationAdapter.this;
                        MediationRewardedAdCallback unused = vungleMediationAdapter.mMediationRewardedAdCallback = (MediationRewardedAdCallback) vungleMediationAdapter.mMediationAdLoadCallback.onSuccess(VungleMediationAdapter.this);
                        return;
                    }
                    Vungle.loadAd(VungleMediationAdapter.this.mPlacement, VungleMediationAdapter.this.mAdConfig, VungleMediationAdapter.this);
                }

                public void onInitializeError(AdError adError) {
                    Log.w(VungleMediationAdapter.TAG, adError.toString());
                    VungleMediationAdapter.this.mMediationAdLoadCallback.onFailure(adError);
                    VungleMediationAdapter.mPlacementsInUse.remove(VungleMediationAdapter.this.mPlacement);
                }
            });
        } else {
            AdError adError3 = new AdError(104, "Only a maximum of one ad can be loaded per placement.", ERROR_DOMAIN);
            Log.w(TAG, adError3.toString());
            mediationAdLoadCallback.onFailure(adError3);
        }
    }

    public void showAd(Context context) {
        Vungle.playAd(this.mPlacement, this.mAdConfig, this);
    }

    public void onAdLoad(String str) {
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mMediationAdLoadCallback;
        if (mediationAdLoadCallback != null) {
            this.mMediationRewardedAdCallback = mediationAdLoadCallback.onSuccess(this);
        }
        mPlacementsInUse.put(this.mPlacement, new WeakReference(this));
    }

    public void onAdStart(String str) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mMediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdOpened();
        }
    }

    public void onAdEnd(String str) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mMediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdClosed();
        }
        mPlacementsInUse.remove(str);
    }

    public void onAdClick(String str) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mMediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.reportAdClicked();
        }
    }

    public void onAdRewarded(String str) {
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mMediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onVideoComplete();
            this.mMediationRewardedAdCallback.onUserEarnedReward(new VungleReward("vungle", 1));
        }
    }

    public void onError(String str, VungleException vungleException) {
        AdError adError = getAdError(vungleException);
        Log.w(TAG, adError.toString());
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mMediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdFailedToShow(adError);
        } else {
            MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mMediationAdLoadCallback;
            if (mediationAdLoadCallback != null) {
                mediationAdLoadCallback.onFailure(adError);
            }
        }
        mPlacementsInUse.remove(str);
    }

    public void onAdViewed(String str) {
        this.mMediationRewardedAdCallback.onVideoStart();
        this.mMediationRewardedAdCallback.reportAdImpression();
    }

    public static class VungleReward implements RewardItem {
        private final int mAmount;
        private final String mType;

        public VungleReward(String str, int i) {
            this.mType = str;
            this.mAmount = i;
        }

        public int getAmount() {
            return this.mAmount;
        }

        public String getType() {
            return this.mType;
        }
    }

    public void loadNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadNativeAd()...");
        VungleInitializer.getInstance().updateCoppaStatus(mediationNativeAdConfiguration.taggedForChildDirectedTreatment());
        this.rtbNativeAd = new VungleRtbNativeAd(mediationNativeAdConfiguration, mediationAdLoadCallback);
        this.rtbNativeAd.render();
    }

    public void loadRewardedInterstitialAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadRewardedInterstitialAd()...");
        Log.d(TAG, "Vungle adapter was asked to load a rewarded interstitial ad. Using the rewarded ad request flow to load the ad to attempt to load a rewarded interstitial ad from Vungle.");
        loadRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
    }

    public void loadRtbRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadRtbRewardedAd()...");
        VungleInitializer.getInstance().updateCoppaStatus(mediationRewardedAdConfiguration.taggedForChildDirectedTreatment());
        this.rtbRewardedAd = new VungleRtbRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
        this.rtbRewardedAd.render();
    }

    public void loadRtbInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadRtbInterstitialAd()...");
        VungleInitializer.getInstance().updateCoppaStatus(mediationInterstitialAdConfiguration.taggedForChildDirectedTreatment());
        this.rtbInterstitialAd = new VungleRtbInterstitialAd(mediationInterstitialAdConfiguration, mediationAdLoadCallback);
        this.rtbInterstitialAd.render();
    }

    public void loadRtbNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadRtbNativeAd()...");
        VungleInitializer.getInstance().updateCoppaStatus(mediationNativeAdConfiguration.taggedForChildDirectedTreatment());
        this.rtbNativeAd = new VungleRtbNativeAd(mediationNativeAdConfiguration, mediationAdLoadCallback);
        this.rtbNativeAd.render();
    }

    public void loadRtbRewardedInterstitialAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        Log.d(TAG, "loadRtbRewardedInterstitialAd()...");
        Log.d(TAG, "Vungle adapter was asked to load a rewarded interstitial ad. Using the rewarded ad request flow to load the ad to attempt to load a rewarded interstitial ad from Vungle.");
        VungleInitializer.getInstance().updateCoppaStatus(mediationRewardedAdConfiguration.taggedForChildDirectedTreatment());
        this.rtbRewardedInterstitialAd = new VungleRtbRewardedAd(mediationRewardedAdConfiguration, mediationAdLoadCallback);
        this.rtbRewardedInterstitialAd.render();
    }
}
