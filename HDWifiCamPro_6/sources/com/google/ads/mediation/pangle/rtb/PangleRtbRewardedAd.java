package com.google.ads.mediation.pangle.rtb;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardItem;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAd;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedAdLoadListener;
import com.bytedance.sdk.openadsdk.api.reward.PAGRewardedRequest;
import com.google.ads.mediation.pangle.PangleAdapterUtils;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.PangleMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.rewarded.RewardItem;

public class PangleRtbRewardedAd implements MediationRewardedAd {
    private final MediationRewardedAdConfiguration adConfiguration;
    /* access modifiers changed from: private */
    public final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> adLoadCallback;
    /* access modifiers changed from: private */
    public PAGRewardedAd pagRewardedAd;
    /* access modifiers changed from: private */
    public MediationRewardedAdCallback rewardedAdCallback;

    public PangleRtbRewardedAd(MediationRewardedAdConfiguration mediationRewardedAdConfiguration, MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> mediationAdLoadCallback) {
        this.adConfiguration = mediationRewardedAdConfiguration;
        this.adLoadCallback = mediationAdLoadCallback;
    }

    public void render() {
        PangleAdapterUtils.setCoppa(this.adConfiguration.taggedForChildDirectedTreatment());
        Bundle serverParameters = this.adConfiguration.getServerParameters();
        final String string = serverParameters.getString(PangleConstants.PLACEMENT_ID);
        if (TextUtils.isEmpty(string)) {
            AdError createAdapterError = PangleConstants.createAdapterError(101, "Failed to load rewarded ad from Pangle. Missing or invalid Placement ID.");
            Log.e(PangleMediationAdapter.TAG, createAdapterError.toString());
            this.adLoadCallback.onFailure(createAdapterError);
            return;
        }
        final String bidResponse = this.adConfiguration.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            AdError createAdapterError2 = PangleConstants.createAdapterError(103, "Failed to load rewarded ad from Pangle. Missing or invalid bid response.");
            Log.w(PangleMediationAdapter.TAG, createAdapterError2.toString());
            this.adLoadCallback.onFailure(createAdapterError2);
            return;
        }
        PangleInitializer.getInstance().initialize(this.adConfiguration.getContext(), serverParameters.getString("appid"), new PangleInitializer.Listener() {
            public void onInitializeSuccess() {
                PAGRewardedRequest pAGRewardedRequest = new PAGRewardedRequest();
                pAGRewardedRequest.setAdString(bidResponse);
                PAGRewardedAd.loadAd(string, pAGRewardedRequest, new PAGRewardedAdLoadListener() {
                    public void onError(int i, String str) {
                        AdError createSdkError = PangleConstants.createSdkError(i, str);
                        Log.w(PangleMediationAdapter.TAG, createSdkError.toString());
                        PangleRtbRewardedAd.this.adLoadCallback.onFailure(createSdkError);
                    }

                    public void onAdLoaded(PAGRewardedAd pAGRewardedAd) {
                        MediationRewardedAdCallback unused = PangleRtbRewardedAd.this.rewardedAdCallback = (MediationRewardedAdCallback) PangleRtbRewardedAd.this.adLoadCallback.onSuccess(PangleRtbRewardedAd.this);
                        PAGRewardedAd unused2 = PangleRtbRewardedAd.this.pagRewardedAd = pAGRewardedAd;
                    }
                });
            }

            public void onInitializeError(AdError adError) {
                Log.w(PangleMediationAdapter.TAG, adError.toString());
                PangleRtbRewardedAd.this.adLoadCallback.onFailure(adError);
            }
        });
    }

    public void showAd(Context context) {
        this.pagRewardedAd.setAdInteractionListener(new PAGRewardedAdInteractionListener() {
            public void onAdShowed() {
                if (PangleRtbRewardedAd.this.rewardedAdCallback != null) {
                    PangleRtbRewardedAd.this.rewardedAdCallback.onAdOpened();
                    PangleRtbRewardedAd.this.rewardedAdCallback.reportAdImpression();
                }
            }

            public void onAdClicked() {
                if (PangleRtbRewardedAd.this.rewardedAdCallback != null) {
                    PangleRtbRewardedAd.this.rewardedAdCallback.reportAdClicked();
                }
            }

            public void onAdDismissed() {
                if (PangleRtbRewardedAd.this.rewardedAdCallback != null) {
                    PangleRtbRewardedAd.this.rewardedAdCallback.onAdClosed();
                }
            }

            public void onUserEarnedReward(final PAGRewardItem pAGRewardItem) {
                AnonymousClass1 r0 = new RewardItem() {
                    public String getType() {
                        return pAGRewardItem.getRewardName();
                    }

                    public int getAmount() {
                        return pAGRewardItem.getRewardAmount();
                    }
                };
                if (PangleRtbRewardedAd.this.rewardedAdCallback != null) {
                    PangleRtbRewardedAd.this.rewardedAdCallback.onUserEarnedReward(r0);
                }
            }

            public void onUserEarnedRewardFail(int i, String str) {
                Log.d(PangleMediationAdapter.TAG, PangleConstants.createSdkError(i, String.format("Failed to reward user: %s", new Object[]{str})).toString());
            }
        });
        if (context instanceof Activity) {
            this.pagRewardedAd.show((Activity) context);
        } else {
            this.pagRewardedAd.show((Activity) null);
        }
    }
}
