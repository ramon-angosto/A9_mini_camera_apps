package com.google.ads.mediation.vungle.rtb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.ads.mediation.vungle.VungleInitializer;
import com.google.ads.mediation.vungle.VungleMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.vungle.mediation.VungleExtrasBuilder;
import com.vungle.mediation.VungleManager;
import com.vungle.warren.AdConfig;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.PlayAdCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;

public class VungleRtbRewardedAd implements MediationRewardedAd, LoadAdCallback, PlayAdCallback {
    /* access modifiers changed from: private */
    public AdConfig mAdConfig;
    /* access modifiers changed from: private */
    public String mAdMarkup;
    /* access modifiers changed from: private */
    public final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mMediationAdLoadCallback;
    /* access modifiers changed from: private */
    public MediationRewardedAdCallback mMediationRewardedAdCallback;
    /* access modifiers changed from: private */
    public String mPlacement;
    /* access modifiers changed from: private */
    public String mUserID;
    private final MediationRewardedAdConfiguration mediationRewardedAdConfiguration;

    public void creativeId(String str) {
    }

    @Deprecated
    public void onAdEnd(String str, boolean z, boolean z2) {
    }

    public void onAdLeftApplication(String str) {
    }

    public VungleRtbRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration2, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.mediationRewardedAdConfiguration = mediationRewardedAdConfiguration2;
        this.mMediationAdLoadCallback = mediationAdLoadCallback;
    }

    public void render() {
        Bundle mediationExtras = this.mediationRewardedAdConfiguration.getMediationExtras();
        Bundle serverParameters = this.mediationRewardedAdConfiguration.getServerParameters();
        if (mediationExtras != null) {
            this.mUserID = mediationExtras.getString("userId");
        }
        String string = serverParameters.getString("appid");
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "Missing or invalid App ID.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            this.mMediationAdLoadCallback.onFailure(adError);
            return;
        }
        this.mPlacement = VungleManager.getInstance().findPlacement(mediationExtras, serverParameters);
        if (TextUtils.isEmpty(this.mPlacement)) {
            AdError adError2 = new AdError(101, "Failed to load ad from Vungle. Missing or invalid Placement ID.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError2.toString());
            this.mMediationAdLoadCallback.onFailure(adError2);
            return;
        }
        this.mAdMarkup = this.mediationRewardedAdConfiguration.getBidResponse();
        String str = VungleMediationAdapter.TAG;
        Log.d(str, "Render rewarded mAdMarkup=" + this.mAdMarkup);
        this.mAdConfig = VungleExtrasBuilder.adConfigWithNetworkExtras(mediationExtras, false);
        VungleInitializer.getInstance().updateCoppaStatus(this.mediationRewardedAdConfiguration.taggedForChildDirectedTreatment());
        VungleInitializer.getInstance().initialize(string, this.mediationRewardedAdConfiguration.getContext(), new VungleInitializer.VungleInitializationListener() {
            public void onInitializeSuccess() {
                Vungle.setIncentivizedFields(VungleRtbRewardedAd.this.mUserID, (String) null, (String) null, (String) null, (String) null);
                if (Vungle.canPlayAd(VungleRtbRewardedAd.this.mPlacement, VungleRtbRewardedAd.this.mAdMarkup)) {
                    VungleRtbRewardedAd vungleRtbRewardedAd = VungleRtbRewardedAd.this;
                    MediationRewardedAdCallback unused = vungleRtbRewardedAd.mMediationRewardedAdCallback = (MediationRewardedAdCallback) vungleRtbRewardedAd.mMediationAdLoadCallback.onSuccess(VungleRtbRewardedAd.this);
                    return;
                }
                Vungle.loadAd(VungleRtbRewardedAd.this.mPlacement, VungleRtbRewardedAd.this.mAdMarkup, VungleRtbRewardedAd.this.mAdConfig, VungleRtbRewardedAd.this);
            }

            public void onInitializeError(AdError adError) {
                Log.w(VungleMediationAdapter.TAG, adError.toString());
                VungleRtbRewardedAd.this.mMediationAdLoadCallback.onFailure(adError);
            }
        });
    }

    public void showAd(Context context) {
        Vungle.playAd(this.mPlacement, this.mAdMarkup, this.mAdConfig, this);
    }

    public void onAdLoad(String str) {
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mMediationAdLoadCallback;
        if (mediationAdLoadCallback != null) {
            this.mMediationRewardedAdCallback = mediationAdLoadCallback.onSuccess(this);
        }
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
            this.mMediationRewardedAdCallback.onUserEarnedReward(new VungleMediationAdapter.VungleReward("vungle", 1));
        }
    }

    public void onError(String str, VungleException vungleException) {
        AdError adError = VungleMediationAdapter.getAdError(vungleException);
        Log.w(VungleMediationAdapter.TAG, adError.toString());
        MediationRewardedAdCallback mediationRewardedAdCallback = this.mMediationRewardedAdCallback;
        if (mediationRewardedAdCallback != null) {
            mediationRewardedAdCallback.onAdFailedToShow(adError);
            return;
        }
        MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback = this.mMediationAdLoadCallback;
        if (mediationAdLoadCallback != null) {
            mediationAdLoadCallback.onFailure(adError);
        }
    }

    public void onAdViewed(String str) {
        this.mMediationRewardedAdCallback.onVideoStart();
        this.mMediationRewardedAdCallback.reportAdImpression();
    }
}
