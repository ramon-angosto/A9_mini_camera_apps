package com.google.ads.mediation.pangle.rtb;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.google.ads.mediation.pangle.PangleAdapterUtils;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.PangleMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PangleRtbNativeAd extends UnifiedNativeAdMapper {
    private static final double PANGLE_SDK_IMAGE_SCALE = 1.0d;
    private final MediationNativeAdConfiguration adConfiguration;
    /* access modifiers changed from: private */
    public final MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> adLoadCallback;
    /* access modifiers changed from: private */
    public MediationNativeAdCallback callback;
    /* access modifiers changed from: private */
    public PAGNativeAd pagNativeAd;

    public PangleRtbNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        this.adConfiguration = mediationNativeAdConfiguration;
        this.adLoadCallback = mediationAdLoadCallback;
    }

    public void render() {
        PangleAdapterUtils.setCoppa(this.adConfiguration.taggedForChildDirectedTreatment());
        Bundle serverParameters = this.adConfiguration.getServerParameters();
        final String string = serverParameters.getString(PangleConstants.PLACEMENT_ID);
        if (TextUtils.isEmpty(string)) {
            AdError createAdapterError = PangleConstants.createAdapterError(101, "Failed to load native ad from Pangle. Missing or invalid Placement ID.");
            Log.e(PangleMediationAdapter.TAG, createAdapterError.toString());
            this.adLoadCallback.onFailure(createAdapterError);
            return;
        }
        final String bidResponse = this.adConfiguration.getBidResponse();
        if (TextUtils.isEmpty(bidResponse)) {
            AdError createAdapterError2 = PangleConstants.createAdapterError(103, "Failed to load native ad from Pangle. Missing or invalid bid response.");
            Log.w(PangleMediationAdapter.TAG, createAdapterError2.toString());
            this.adLoadCallback.onFailure(createAdapterError2);
            return;
        }
        PangleInitializer.getInstance().initialize(this.adConfiguration.getContext(), serverParameters.getString("appid"), new PangleInitializer.Listener() {
            public void onInitializeSuccess() {
                PAGNativeRequest pAGNativeRequest = new PAGNativeRequest();
                pAGNativeRequest.setAdString(bidResponse);
                PAGNativeAd.loadAd(string, pAGNativeRequest, new PAGNativeAdLoadListener() {
                    public void onError(int i, String str) {
                        AdError createSdkError = PangleConstants.createSdkError(i, str);
                        Log.w(PangleMediationAdapter.TAG, createSdkError.toString());
                        PangleRtbNativeAd.this.adLoadCallback.onFailure(createSdkError);
                    }

                    public void onAdLoaded(PAGNativeAd pAGNativeAd) {
                        PangleRtbNativeAd.this.mapNativeAd(pAGNativeAd);
                        MediationNativeAdCallback unused = PangleRtbNativeAd.this.callback = (MediationNativeAdCallback) PangleRtbNativeAd.this.adLoadCallback.onSuccess(PangleRtbNativeAd.this);
                    }
                });
            }

            public void onInitializeError(AdError adError) {
                Log.w(PangleMediationAdapter.TAG, adError.toString());
                PangleRtbNativeAd.this.adLoadCallback.onFailure(adError);
            }
        });
    }

    /* access modifiers changed from: private */
    public void mapNativeAd(PAGNativeAd pAGNativeAd) {
        this.pagNativeAd = pAGNativeAd;
        PAGNativeAdData nativeAdData = this.pagNativeAd.getNativeAdData();
        setHeadline(nativeAdData.getTitle());
        setBody(nativeAdData.getDescription());
        setCallToAction(nativeAdData.getButtonText());
        if (nativeAdData.getIcon() != null) {
            setIcon(new PangleNativeMappedImage((Drawable) null, Uri.parse(nativeAdData.getIcon().getImageUrl()), PANGLE_SDK_IMAGE_SCALE));
        }
        setOverrideClickHandling(true);
        setMediaView(nativeAdData.getMediaView());
        setAdChoicesContent(nativeAdData.getAdLogoView());
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
        HashMap hashMap = new HashMap(map);
        hashMap.remove("3011");
        hashMap.remove("3012");
        View view2 = (View) hashMap.get("3002");
        ArrayList arrayList = new ArrayList();
        if (view2 != null) {
            arrayList.add(view2);
        }
        this.pagNativeAd.registerViewForInteraction((ViewGroup) view, new ArrayList(hashMap.values()), arrayList, (View) null, new PAGNativeAdInteractionListener() {
            public void onAdDismissed() {
            }

            public void onAdClicked() {
                if (PangleRtbNativeAd.this.callback != null) {
                    PangleRtbNativeAd.this.callback.reportAdClicked();
                }
            }

            public void onAdShowed() {
                if (PangleRtbNativeAd.this.callback != null) {
                    PangleRtbNativeAd.this.callback.reportAdImpression();
                }
            }
        });
        getAdChoicesContent().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PangleRtbNativeAd.this.pagNativeAd.showPrivacyActivity();
            }
        });
    }

    public class PangleNativeMappedImage extends NativeAd.Image {
        private final Drawable drawable;
        private final Uri imageUri;
        private final double scale;

        private PangleNativeMappedImage(Drawable drawable2, Uri uri, double d) {
            this.drawable = drawable2;
            this.imageUri = uri;
            this.scale = d;
        }

        public Drawable getDrawable() {
            return this.drawable;
        }

        public Uri getUri() {
            return this.imageUri;
        }

        public double getScale() {
            return this.scale;
        }
    }
}
