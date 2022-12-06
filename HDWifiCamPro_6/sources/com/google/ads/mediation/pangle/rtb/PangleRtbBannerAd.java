package com.google.ads.mediation.pangle.rtb;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAd;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerAdLoadListener;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerRequest;
import com.bytedance.sdk.openadsdk.api.banner.PAGBannerSize;
import com.google.ads.mediation.pangle.PangleAdapterUtils;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.PangleMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.MediationUtils;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import java.util.ArrayList;
import ms.bd.o.Pgl.c;

public class PangleRtbBannerAd implements MediationBannerAd, PAGBannerAdInteractionListener {
    /* access modifiers changed from: private */
    public final MediationBannerAdConfiguration adConfiguration;
    /* access modifiers changed from: private */
    public final MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> adLoadCallback;
    /* access modifiers changed from: private */
    public MediationBannerAdCallback bannerAdCallback;
    /* access modifiers changed from: private */
    public FrameLayout wrappedAdView;

    public void onAdDismissed() {
    }

    public PangleRtbBannerAd(MediationBannerAdConfiguration mediationBannerAdConfiguration, MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> mediationAdLoadCallback) {
        this.adConfiguration = mediationBannerAdConfiguration;
        this.adLoadCallback = mediationAdLoadCallback;
    }

    public void render() {
        PangleAdapterUtils.setCoppa(this.adConfiguration.taggedForChildDirectedTreatment());
        Bundle serverParameters = this.adConfiguration.getServerParameters();
        final String string = serverParameters.getString(PangleConstants.PLACEMENT_ID);
        if (TextUtils.isEmpty(string)) {
            AdError createAdapterError = PangleConstants.createAdapterError(101, "Failed to load banner ad from Pangle. Missing or invalid Placement ID.");
            Log.e(PangleMediationAdapter.TAG, createAdapterError.toString());
            this.adLoadCallback.onFailure(createAdapterError);
            return;
        }
        final String bidResponse = this.adConfiguration.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            AdError createAdapterError2 = PangleConstants.createAdapterError(103, "Failed to load banner ad from Pangle. Missing or invalid bid response.");
            Log.w(PangleMediationAdapter.TAG, createAdapterError2.toString());
            this.adLoadCallback.onFailure(createAdapterError2);
            return;
        }
        final Context context = this.adConfiguration.getContext();
        PangleInitializer.getInstance().initialize(context, serverParameters.getString("appid"), new PangleInitializer.Listener() {
            public void onInitializeSuccess() {
                ArrayList arrayList = new ArrayList(3);
                arrayList.add(new AdSize(320, 50));
                arrayList.add(new AdSize(c.COLLECT_MODE_FINANCE, 250));
                arrayList.add(new AdSize(728, 90));
                AdSize findClosestSize = MediationUtils.findClosestSize(context, PangleRtbBannerAd.this.adConfiguration.getAdSize(), arrayList);
                if (findClosestSize == null) {
                    AdError createAdapterError = PangleConstants.createAdapterError(102, "Failed to request banner ad from Pangle. Invalid banner size.");
                    Log.w(PangleMediationAdapter.TAG, createAdapterError.toString());
                    PangleRtbBannerAd.this.adLoadCallback.onFailure(createAdapterError);
                    return;
                }
                FrameLayout unused = PangleRtbBannerAd.this.wrappedAdView = new FrameLayout(context);
                PAGBannerRequest pAGBannerRequest = new PAGBannerRequest(new PAGBannerSize(findClosestSize.getWidth(), findClosestSize.getHeight()));
                pAGBannerRequest.setAdString(bidResponse);
                PAGBannerAd.loadAd(string, pAGBannerRequest, new PAGBannerAdLoadListener() {
                    public void onError(int i, String str) {
                        AdError createSdkError = PangleConstants.createSdkError(i, str);
                        Log.w(PangleMediationAdapter.TAG, createSdkError.toString());
                        PangleRtbBannerAd.this.adLoadCallback.onFailure(createSdkError);
                    }

                    public void onAdLoaded(PAGBannerAd pAGBannerAd) {
                        pAGBannerAd.setAdInteractionListener(PangleRtbBannerAd.this);
                        PangleRtbBannerAd.this.wrappedAdView.addView(pAGBannerAd.getBannerView());
                        MediationBannerAdCallback unused = PangleRtbBannerAd.this.bannerAdCallback = (MediationBannerAdCallback) PangleRtbBannerAd.this.adLoadCallback.onSuccess(PangleRtbBannerAd.this);
                    }
                });
            }

            public void onInitializeError(AdError adError) {
                Log.w(PangleMediationAdapter.TAG, adError.toString());
                PangleRtbBannerAd.this.adLoadCallback.onFailure(adError);
            }
        });
    }

    public View getView() {
        return this.wrappedAdView;
    }

    public void onAdShowed() {
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdImpression();
        }
    }

    public void onAdClicked() {
        MediationBannerAdCallback mediationBannerAdCallback = this.bannerAdCallback;
        if (mediationBannerAdCallback != null) {
            mediationBannerAdCallback.reportAdClicked();
        }
    }
}
