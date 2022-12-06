package com.google.ads.mediation.vungle.rtb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.ads.mediation.vungle.VungleInitializer;
import com.google.ads.mediation.vungle.VungleMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.vungle.mediation.AdapterParametersParser;
import com.vungle.mediation.VungleExtrasBuilder;
import com.vungle.mediation.VungleManager;
import com.vungle.warren.AdConfig;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.PlayAdCallback;
import com.vungle.warren.Vungle;
import com.vungle.warren.error.VungleException;

public class VungleRtbInterstitialAd implements MediationInterstitialAd {
    private AdConfig mAdConfig;
    private String mAdMarkup;
    /* access modifiers changed from: private */
    public final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mMediationAdLoadCallback;
    private String mPlacement;
    /* access modifiers changed from: private */
    public MediationInterstitialAdCallback mediationInterstitialAdCallback;
    private final MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration;

    public VungleRtbInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration2, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.mediationInterstitialAdConfiguration = mediationInterstitialAdConfiguration2;
        this.mMediationAdLoadCallback = mediationAdLoadCallback;
    }

    public void render() {
        Bundle mediationExtras = this.mediationInterstitialAdConfiguration.getMediationExtras();
        Bundle serverParameters = this.mediationInterstitialAdConfiguration.getServerParameters();
        String string = serverParameters.getString("appid");
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "Missing or invalid App ID.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError.toString());
            this.mMediationAdLoadCallback.onFailure(adError);
            return;
        }
        this.mPlacement = VungleManager.getInstance().findPlacement(mediationExtras, serverParameters);
        if (TextUtils.isEmpty(this.mPlacement)) {
            AdError adError2 = new AdError(101, "Failed to load ad from Vungle. Missing or Invalid Placement ID.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.w(VungleMediationAdapter.TAG, adError2.toString());
            this.mMediationAdLoadCallback.onFailure(adError2);
            return;
        }
        this.mAdMarkup = this.mediationInterstitialAdConfiguration.getBidResponse();
        String str = VungleMediationAdapter.TAG;
        Log.d(str, "Render interstitial mAdMarkup=" + this.mAdMarkup);
        AdapterParametersParser.Config parse = AdapterParametersParser.parse(string, mediationExtras);
        this.mAdConfig = VungleExtrasBuilder.adConfigWithNetworkExtras(mediationExtras, false);
        VungleInitializer.getInstance().initialize(parse.getAppId(), this.mediationInterstitialAdConfiguration.getContext(), new VungleInitializer.VungleInitializationListener() {
            public void onInitializeSuccess() {
                VungleRtbInterstitialAd.this.loadAd();
            }

            public void onInitializeError(AdError adError) {
                Log.w(VungleMediationAdapter.TAG, adError.toString());
                VungleRtbInterstitialAd.this.mMediationAdLoadCallback.onFailure(adError);
            }
        });
    }

    /* access modifiers changed from: private */
    public void loadAd() {
        if (Vungle.canPlayAd(this.mPlacement, this.mAdMarkup)) {
            this.mediationInterstitialAdCallback = this.mMediationAdLoadCallback.onSuccess(this);
        } else {
            Vungle.loadAd(this.mPlacement, this.mAdMarkup, this.mAdConfig, new LoadAdCallback() {
                public void onAdLoad(String str) {
                    VungleRtbInterstitialAd vungleRtbInterstitialAd = VungleRtbInterstitialAd.this;
                    MediationInterstitialAdCallback unused = vungleRtbInterstitialAd.mediationInterstitialAdCallback = (MediationInterstitialAdCallback) vungleRtbInterstitialAd.mMediationAdLoadCallback.onSuccess(VungleRtbInterstitialAd.this);
                }

                public void onError(String str, VungleException vungleException) {
                    AdError adError = VungleMediationAdapter.getAdError(vungleException);
                    Log.w(VungleMediationAdapter.TAG, adError.toString());
                    VungleRtbInterstitialAd.this.mMediationAdLoadCallback.onFailure(adError);
                }
            });
        }
    }

    public void showAd(Context context) {
        Vungle.playAd(this.mPlacement, this.mAdMarkup, this.mAdConfig, new PlayAdCallback() {
            public void creativeId(String str) {
            }

            public void onAdEnd(String str, boolean z, boolean z2) {
            }

            public void onAdRewarded(String str) {
            }

            public void onAdStart(String str) {
                if (VungleRtbInterstitialAd.this.mediationInterstitialAdCallback != null) {
                    VungleRtbInterstitialAd.this.mediationInterstitialAdCallback.onAdOpened();
                }
            }

            public void onAdEnd(String str) {
                if (VungleRtbInterstitialAd.this.mediationInterstitialAdCallback != null) {
                    VungleRtbInterstitialAd.this.mediationInterstitialAdCallback.onAdClosed();
                }
            }

            public void onAdClick(String str) {
                if (VungleRtbInterstitialAd.this.mediationInterstitialAdCallback != null) {
                    VungleRtbInterstitialAd.this.mediationInterstitialAdCallback.reportAdClicked();
                }
            }

            public void onAdLeftApplication(String str) {
                if (VungleRtbInterstitialAd.this.mediationInterstitialAdCallback != null) {
                    VungleRtbInterstitialAd.this.mediationInterstitialAdCallback.onAdLeftApplication();
                }
            }

            public void onError(String str, VungleException vungleException) {
                Log.w(VungleMediationAdapter.TAG, VungleMediationAdapter.getAdError(vungleException).toString());
                if (VungleRtbInterstitialAd.this.mediationInterstitialAdCallback != null) {
                    VungleRtbInterstitialAd.this.mediationInterstitialAdCallback.onAdClosed();
                }
            }

            public void onAdViewed(String str) {
                if (VungleRtbInterstitialAd.this.mediationInterstitialAdCallback != null) {
                    VungleRtbInterstitialAd.this.mediationInterstitialAdCallback.reportAdImpression();
                }
            }
        });
    }
}
