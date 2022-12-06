package com.google.ads.mediation.vungle.rtb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.ads.mediation.vungle.VungleInitializer;
import com.google.ads.mediation.vungle.VungleMediationAdapter;
import com.google.ads.mediation.vungle.VungleNativeAd;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.vungle.mediation.VungleExtrasBuilder;
import com.vungle.mediation.VungleManager;
import com.vungle.warren.AdConfig;
import com.vungle.warren.NativeAd;
import com.vungle.warren.NativeAdLayout;
import com.vungle.warren.NativeAdListener;
import com.vungle.warren.error.VungleException;
import com.vungle.warren.model.Advertisement;
import com.vungle.warren.ui.view.MediaView;
import java.util.ArrayList;
import java.util.Map;

public class VungleRtbNativeAd extends UnifiedNativeAdMapper {
    public static final String EXTRA_DISABLE_FEED_MANAGEMENT = "disableFeedLifecycleManagement";
    /* access modifiers changed from: private */
    public AdConfig adConfig;
    private final MediationNativeAdConfiguration adConfiguration;
    /* access modifiers changed from: private */
    public String adMarkup;
    /* access modifiers changed from: private */
    public final MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> callback;
    /* access modifiers changed from: private */
    public MediationNativeAdCallback nativeAdCallback;
    /* access modifiers changed from: private */
    public String placementId;
    /* access modifiers changed from: private */
    public VungleNativeAd vungleNativeAd;

    public VungleRtbNativeAd(MediationNativeAdConfiguration mediationNativeAdConfiguration, MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback) {
        this.adConfiguration = mediationNativeAdConfiguration;
        this.callback = mediationAdLoadCallback;
    }

    public void render() {
        Bundle mediationExtras = this.adConfiguration.getMediationExtras();
        Bundle serverParameters = this.adConfiguration.getServerParameters();
        NativeAdOptions nativeAdOptions = this.adConfiguration.getNativeAdOptions();
        Context context = this.adConfiguration.getContext();
        String string = serverParameters.getString("appid");
        if (TextUtils.isEmpty(string)) {
            AdError adError = new AdError(101, "Failed to load ad from Vungle. Missing or invalid app ID.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.d(VungleMediationAdapter.TAG, adError.toString());
            this.callback.onFailure(adError);
            return;
        }
        this.placementId = VungleManager.getInstance().findPlacement(mediationExtras, serverParameters);
        if (TextUtils.isEmpty(this.placementId)) {
            AdError adError2 = new AdError(101, "Failed to load ad from Vungle. Missing or Invalid placement ID.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.d(VungleMediationAdapter.TAG, adError2.toString());
            this.callback.onFailure(adError2);
            return;
        }
        this.adMarkup = this.adConfiguration.getBidResponse();
        String str = VungleMediationAdapter.TAG;
        Log.d(str, "Render native adMarkup=" + this.adMarkup);
        this.adConfig = VungleExtrasBuilder.adConfigWithNetworkExtras(mediationExtras, nativeAdOptions, true);
        Log.d(VungleMediationAdapter.TAG, "start to render native ads...");
        this.vungleNativeAd = new VungleNativeAd(context, this.placementId, mediationExtras.getBoolean(EXTRA_DISABLE_FEED_MANAGEMENT, false));
        VungleManager.getInstance().registerNativeAd(this.placementId, this.vungleNativeAd);
        VungleInitializer.getInstance().initialize(string, context.getApplicationContext(), new VungleInitializer.VungleInitializationListener() {
            public void onInitializeSuccess() {
                VungleRtbNativeAd.this.vungleNativeAd.loadNativeAd(VungleRtbNativeAd.this.adConfig, VungleRtbNativeAd.this.adMarkup, new NativeListener());
            }

            public void onInitializeError(AdError adError) {
                VungleManager.getInstance().removeActiveNativeAd(VungleRtbNativeAd.this.placementId, VungleRtbNativeAd.this.vungleNativeAd);
                Log.d(VungleMediationAdapter.TAG, adError.toString());
                VungleRtbNativeAd.this.callback.onFailure(adError);
            }
        });
    }

    private class NativeListener implements NativeAdListener {
        public void creativeId(String str) {
        }

        private NativeListener() {
        }

        public void onNativeAdLoaded(NativeAd nativeAd) {
            VungleRtbNativeAd.this.mapNativeAd();
            VungleRtbNativeAd vungleRtbNativeAd = VungleRtbNativeAd.this;
            MediationNativeAdCallback unused = vungleRtbNativeAd.nativeAdCallback = (MediationNativeAdCallback) vungleRtbNativeAd.callback.onSuccess(VungleRtbNativeAd.this);
        }

        public void onAdLoadError(String str, VungleException vungleException) {
            VungleManager.getInstance().removeActiveNativeAd(str, VungleRtbNativeAd.this.vungleNativeAd);
            AdError adError = VungleMediationAdapter.getAdError(vungleException);
            Log.d(VungleMediationAdapter.TAG, adError.toString());
            VungleRtbNativeAd.this.callback.onFailure(adError);
        }

        public void onAdPlayError(String str, VungleException vungleException) {
            VungleManager.getInstance().removeActiveNativeAd(str, VungleRtbNativeAd.this.vungleNativeAd);
            AdError adError = VungleMediationAdapter.getAdError(vungleException);
            Log.d(VungleMediationAdapter.TAG, adError.toString());
            VungleRtbNativeAd.this.callback.onFailure(adError);
        }

        public void onAdClick(String str) {
            if (VungleRtbNativeAd.this.nativeAdCallback != null) {
                VungleRtbNativeAd.this.nativeAdCallback.reportAdClicked();
                VungleRtbNativeAd.this.nativeAdCallback.onAdOpened();
            }
        }

        public void onAdLeftApplication(String str) {
            if (VungleRtbNativeAd.this.nativeAdCallback != null) {
                VungleRtbNativeAd.this.nativeAdCallback.onAdLeftApplication();
            }
        }

        public void onAdImpression(String str) {
            if (VungleRtbNativeAd.this.nativeAdCallback != null) {
                VungleRtbNativeAd.this.nativeAdCallback.reportAdImpression();
            }
        }
    }

    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
        super.trackViews(view, map, map2);
        Log.d(VungleMediationAdapter.TAG, "trackViews()");
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (this.vungleNativeAd.getNativeAd() != null && this.vungleNativeAd.getNativeAd().canPlayAd()) {
                View childAt = viewGroup.getChildAt(viewGroup.getChildCount() - 1);
                if (!(childAt instanceof FrameLayout)) {
                    Log.d(VungleMediationAdapter.TAG, "Vungle requires a FrameLayout to render the native ad.");
                    return;
                }
                this.vungleNativeAd.getNativeAd().setAdOptionsRootView((FrameLayout) childAt);
                ArrayList arrayList = new ArrayList();
                ImageView imageView = null;
                KeyEvent.Callback callback2 = null;
                for (Map.Entry next : map.entrySet()) {
                    arrayList.add((View) next.getValue());
                    if (((String) next.getKey()).equals("3003")) {
                        callback2 = (View) next.getValue();
                    }
                }
                if (callback2 instanceof ImageView) {
                    imageView = (ImageView) callback2;
                } else {
                    Log.d(VungleMediationAdapter.TAG, "The view to display a Vungle native icon image is not a type of ImageView, so it can't be registered for click events.");
                }
                this.vungleNativeAd.getNativeAd().registerViewForInteraction(this.vungleNativeAd.getNativeAdLayout(), this.vungleNativeAd.getMediaView(), imageView, arrayList);
            }
        }
    }

    public void untrackView(View view) {
        super.untrackView(view);
        Log.d(VungleMediationAdapter.TAG, "untrackView()");
        if (this.vungleNativeAd.getNativeAd() != null) {
            this.vungleNativeAd.getNativeAd().unregisterView();
        }
    }

    /* access modifiers changed from: private */
    public void mapNativeAd() {
        NativeAd nativeAd = this.vungleNativeAd.getNativeAd();
        String adTitle = nativeAd.getAdTitle();
        if (adTitle != null) {
            setHeadline(adTitle);
        }
        String adBodyText = nativeAd.getAdBodyText();
        if (adBodyText != null) {
            setBody(adBodyText);
        }
        String adCallToActionText = nativeAd.getAdCallToActionText();
        if (adCallToActionText != null) {
            setCallToAction(adCallToActionText);
        }
        Double adStarRating = nativeAd.getAdStarRating();
        if (adStarRating != null) {
            setStarRating(adStarRating);
        }
        String adSponsoredText = nativeAd.getAdSponsoredText();
        if (adSponsoredText != null) {
            setAdvertiser(adSponsoredText);
        }
        NativeAdLayout nativeAdLayout = this.vungleNativeAd.getNativeAdLayout();
        MediaView mediaView = this.vungleNativeAd.getMediaView();
        nativeAdLayout.removeAllViews();
        nativeAdLayout.addView(mediaView);
        setMediaView(nativeAdLayout);
        String appIcon = nativeAd.getAppIcon();
        if (appIcon != null && appIcon.startsWith(Advertisement.FILE_SCHEME)) {
            setIcon(new VungleNativeMappedImage(Uri.parse(appIcon)));
        }
        setOverrideImpressionRecording(true);
        setOverrideClickHandling(true);
    }

    private static class VungleNativeMappedImage extends NativeAd.Image {
        private Uri imageUri;

        public Drawable getDrawable() {
            return null;
        }

        public double getScale() {
            return 1.0d;
        }

        public VungleNativeMappedImage(Uri uri) {
            this.imageUri = uri;
        }

        public Uri getUri() {
            return this.imageUri;
        }
    }

    public String toString() {
        return " [placementId=" + this.placementId + " # hashcode=" + hashCode() + " # vungleNativeAd=" + this.vungleNativeAd + "] ";
    }
}
