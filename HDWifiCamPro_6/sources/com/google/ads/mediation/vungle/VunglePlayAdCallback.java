package com.google.ads.mediation.vungle;

import com.vungle.mediation.VungleBannerAdapter;
import com.vungle.mediation.VungleManager;
import com.vungle.warren.PlayAdCallback;
import com.vungle.warren.error.VungleException;
import java.lang.ref.WeakReference;

public class VunglePlayAdCallback implements PlayAdCallback {
    private final WeakReference<VungleBannerAdapter> adapterReference;
    private final WeakReference<PlayAdCallback> callbackReference;
    private final VungleBannerAd vungleBannerAd;

    public void creativeId(String str) {
    }

    @Deprecated
    public void onAdEnd(String str, boolean z, boolean z2) {
    }

    public void onAdViewed(String str) {
    }

    public VunglePlayAdCallback(PlayAdCallback playAdCallback, VungleBannerAdapter vungleBannerAdapter, VungleBannerAd vungleBannerAd2) {
        this.callbackReference = new WeakReference<>(playAdCallback);
        this.adapterReference = new WeakReference<>(vungleBannerAdapter);
        this.vungleBannerAd = vungleBannerAd2;
    }

    public void onAdStart(String str) {
        PlayAdCallback playAdCallback = (PlayAdCallback) this.callbackReference.get();
        VungleBannerAdapter vungleBannerAdapter = (VungleBannerAdapter) this.adapterReference.get();
        if (playAdCallback != null && vungleBannerAdapter != null && vungleBannerAdapter.isRequestPending()) {
            playAdCallback.onAdStart(str);
        }
    }

    public void onAdEnd(String str) {
        PlayAdCallback playAdCallback = (PlayAdCallback) this.callbackReference.get();
        VungleBannerAdapter vungleBannerAdapter = (VungleBannerAdapter) this.adapterReference.get();
        if (playAdCallback != null && vungleBannerAdapter != null && vungleBannerAdapter.isRequestPending()) {
            playAdCallback.onAdEnd(str);
        }
    }

    public void onAdClick(String str) {
        PlayAdCallback playAdCallback = (PlayAdCallback) this.callbackReference.get();
        VungleBannerAdapter vungleBannerAdapter = (VungleBannerAdapter) this.adapterReference.get();
        if (playAdCallback != null && vungleBannerAdapter != null && vungleBannerAdapter.isRequestPending()) {
            playAdCallback.onAdClick(str);
        }
    }

    public void onAdRewarded(String str) {
        PlayAdCallback playAdCallback = (PlayAdCallback) this.callbackReference.get();
        VungleBannerAdapter vungleBannerAdapter = (VungleBannerAdapter) this.adapterReference.get();
        if (playAdCallback != null && vungleBannerAdapter != null && vungleBannerAdapter.isRequestPending()) {
            playAdCallback.onAdRewarded(str);
        }
    }

    public void onAdLeftApplication(String str) {
        PlayAdCallback playAdCallback = (PlayAdCallback) this.callbackReference.get();
        VungleBannerAdapter vungleBannerAdapter = (VungleBannerAdapter) this.adapterReference.get();
        if (playAdCallback != null && vungleBannerAdapter != null && vungleBannerAdapter.isRequestPending()) {
            playAdCallback.onAdLeftApplication(str);
        }
    }

    public void onError(String str, VungleException vungleException) {
        VungleManager.getInstance().removeActiveBannerAd(str, this.vungleBannerAd);
        PlayAdCallback playAdCallback = (PlayAdCallback) this.callbackReference.get();
        VungleBannerAdapter vungleBannerAdapter = (VungleBannerAdapter) this.adapterReference.get();
        if (playAdCallback != null && vungleBannerAdapter != null && vungleBannerAdapter.isRequestPending()) {
            playAdCallback.onError(str, vungleException);
        }
    }
}
