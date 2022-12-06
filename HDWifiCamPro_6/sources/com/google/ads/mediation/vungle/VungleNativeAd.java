package com.google.ads.mediation.vungle;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import com.vungle.warren.AdConfig;
import com.vungle.warren.NativeAd;
import com.vungle.warren.NativeAdLayout;
import com.vungle.warren.NativeAdListener;
import com.vungle.warren.ui.view.MediaView;

public class VungleNativeAd {
    private final MediaView mediaView;
    private final NativeAd nativeAd;
    private final NativeAdLayout nativeAdLayout;
    private final String placementId;

    public VungleNativeAd(Context context, String str, boolean z) {
        this.placementId = str;
        this.nativeAd = new NativeAd(context, str);
        this.nativeAdLayout = new NativeAdLayout(context);
        this.nativeAdLayout.disableLifeCycleManagement(z);
        this.mediaView = new MediaView(context);
    }

    public void loadNativeAd(AdConfig adConfig, String str, NativeAdListener nativeAdListener) {
        this.nativeAd.loadAd(adConfig, str, nativeAdListener);
    }

    public NativeAd getNativeAd() {
        return this.nativeAd;
    }

    public NativeAdLayout getNativeAdLayout() {
        return this.nativeAdLayout;
    }

    public MediaView getMediaView() {
        return this.mediaView;
    }

    public void destroyAd() {
        NativeAdLayout nativeAdLayout2 = this.nativeAdLayout;
        if (nativeAdLayout2 != null) {
            nativeAdLayout2.removeAllViews();
            if (this.nativeAdLayout.getParent() != null) {
                ((ViewGroup) this.nativeAdLayout.getParent()).removeView(this.nativeAdLayout);
            }
        }
        MediaView mediaView2 = this.mediaView;
        if (mediaView2 != null) {
            mediaView2.removeAllViews();
            if (this.mediaView.getParent() != null) {
                ((ViewGroup) this.mediaView.getParent()).removeView(this.mediaView);
            }
        }
        if (this.nativeAd != null) {
            String str = VungleMediationAdapter.TAG;
            Log.d(str, "Vungle native adapter cleanUp: destroyAd # " + this.nativeAd.hashCode());
            this.nativeAd.unregisterView();
            this.nativeAd.destroy();
        }
    }

    public String toString() {
        return " [placementId=" + this.placementId + " # nativeAdLayout=" + this.nativeAdLayout + " # mediaView=" + this.mediaView + " # nativeAd=" + this.nativeAd + " # hashcode=" + hashCode() + "] ";
    }
}
