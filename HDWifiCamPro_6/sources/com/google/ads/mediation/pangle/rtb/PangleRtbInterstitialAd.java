package com.google.ads.mediation.pangle.rtb;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAd;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialAdLoadListener;
import com.bytedance.sdk.openadsdk.api.interstitial.PAGInterstitialRequest;
import com.google.ads.mediation.pangle.PangleAdapterUtils;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.PangleMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;

public class PangleRtbInterstitialAd implements MediationInterstitialAd {
    private final MediationInterstitialAdConfiguration adConfiguration;
    /* access modifiers changed from: private */
    public final MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> adLoadCallback;
    /* access modifiers changed from: private */
    public MediationInterstitialAdCallback interstitialAdCallback;
    /* access modifiers changed from: private */
    public PAGInterstitialAd pagInterstitialAd;

    public PangleRtbInterstitialAd(MediationInterstitialAdConfiguration mediationInterstitialAdConfiguration, MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> mediationAdLoadCallback) {
        this.adConfiguration = mediationInterstitialAdConfiguration;
        this.adLoadCallback = mediationAdLoadCallback;
    }

    public void render() {
        PangleAdapterUtils.setCoppa(this.adConfiguration.taggedForChildDirectedTreatment());
        Bundle serverParameters = this.adConfiguration.getServerParameters();
        final String string = serverParameters.getString(PangleConstants.PLACEMENT_ID);
        if (TextUtils.isEmpty(string)) {
            AdError createAdapterError = PangleConstants.createAdapterError(101, "Failed to load interstitial ad from Pangle. Missing or invalid Placement ID.");
            Log.e(PangleMediationAdapter.TAG, createAdapterError.toString());
            this.adLoadCallback.onFailure(createAdapterError);
            return;
        }
        final String bidResponse = this.adConfiguration.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            AdError createAdapterError2 = PangleConstants.createAdapterError(103, "Failed to load interstitial ad from Pangle. Missing or invalid bid response.");
            Log.w(PangleMediationAdapter.TAG, createAdapterError2.toString());
            this.adLoadCallback.onFailure(createAdapterError2);
            return;
        }
        PangleInitializer.getInstance().initialize(this.adConfiguration.getContext(), serverParameters.getString("appid"), new PangleInitializer.Listener() {
            public void onInitializeSuccess() {
                PAGInterstitialRequest pAGInterstitialRequest = new PAGInterstitialRequest();
                pAGInterstitialRequest.setAdString(bidResponse);
                PAGInterstitialAd.loadAd(string, pAGInterstitialRequest, new PAGInterstitialAdLoadListener() {
                    public void onError(int i, String str) {
                        AdError createSdkError = PangleConstants.createSdkError(i, str);
                        Log.w(PangleMediationAdapter.TAG, createSdkError.toString());
                        PangleRtbInterstitialAd.this.adLoadCallback.onFailure(createSdkError);
                    }

                    public void onAdLoaded(PAGInterstitialAd pAGInterstitialAd) {
                        MediationInterstitialAdCallback unused = PangleRtbInterstitialAd.this.interstitialAdCallback = (MediationInterstitialAdCallback) PangleRtbInterstitialAd.this.adLoadCallback.onSuccess(PangleRtbInterstitialAd.this);
                        PAGInterstitialAd unused2 = PangleRtbInterstitialAd.this.pagInterstitialAd = pAGInterstitialAd;
                    }
                });
            }

            public void onInitializeError(AdError adError) {
                Log.w(PangleMediationAdapter.TAG, adError.toString());
                PangleRtbInterstitialAd.this.adLoadCallback.onFailure(adError);
            }
        });
    }

    public void showAd(Context context) {
        this.pagInterstitialAd.setAdInteractionListener(new PAGInterstitialAdInteractionListener() {
            public void onAdShowed() {
                if (PangleRtbInterstitialAd.this.interstitialAdCallback != null) {
                    PangleRtbInterstitialAd.this.interstitialAdCallback.onAdOpened();
                    PangleRtbInterstitialAd.this.interstitialAdCallback.reportAdImpression();
                }
            }

            public void onAdClicked() {
                if (PangleRtbInterstitialAd.this.interstitialAdCallback != null) {
                    PangleRtbInterstitialAd.this.interstitialAdCallback.reportAdClicked();
                }
            }

            public void onAdDismissed() {
                if (PangleRtbInterstitialAd.this.interstitialAdCallback != null) {
                    PangleRtbInterstitialAd.this.interstitialAdCallback.onAdClosed();
                }
            }
        });
        if (context instanceof Activity) {
            this.pagInterstitialAd.show((Activity) context);
        } else {
            this.pagInterstitialAd.show((Activity) null);
        }
    }
}
