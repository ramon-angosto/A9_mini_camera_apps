package com.vungle.mediation;

import android.content.Context;
import android.util.Log;
import android.widget.RelativeLayout;
import com.google.ads.mediation.vungle.VungleBannerAd;
import com.google.ads.mediation.vungle.VungleInitializer;
import com.google.ads.mediation.vungle.VungleMediationAdapter;
import com.google.ads.mediation.vungle.VunglePlayAdCallback;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.vungle.warren.AdConfig;
import com.vungle.warren.BannerAdConfig;
import com.vungle.warren.Banners;
import com.vungle.warren.LoadAdCallback;
import com.vungle.warren.PlayAdCallback;
import com.vungle.warren.VungleBanner;
import com.vungle.warren.error.VungleException;

public class VungleBannerAdapter implements PlayAdCallback {
    private RelativeLayout adLayout;
    private final AdConfig mAdConfig;
    private final LoadAdCallback mAdLoadCallback = new LoadAdCallback() {
        public void onAdLoad(String str) {
            VungleBannerAdapter.this.createBanner();
        }

        public void onError(String str, VungleException vungleException) {
            VungleBannerAdapter.this.mVungleManager.removeActiveBannerAd(VungleBannerAdapter.this.placementId, VungleBannerAdapter.this.vungleBannerAd);
            if (!VungleBannerAdapter.this.mPendingRequestBanner) {
                Log.w(VungleMediationAdapter.TAG, "No banner request fired.");
            } else if (VungleBannerAdapter.this.mediationAdapter != null && VungleBannerAdapter.this.mediationListener != null) {
                AdError adError = VungleMediationAdapter.getAdError(vungleException);
                Log.w(VungleMediationAdapter.TAG, adError.toString());
                VungleBannerAdapter.this.mediationListener.onAdFailedToLoad(VungleBannerAdapter.this.mediationAdapter, adError);
            }
        }
    };
    /* access modifiers changed from: private */
    public boolean mPendingRequestBanner = false;
    private boolean mVisibility = true;
    /* access modifiers changed from: private */
    public final VungleManager mVungleManager = VungleManager.getInstance();
    /* access modifiers changed from: private */
    public MediationBannerAdapter mediationAdapter;
    /* access modifiers changed from: private */
    public MediationBannerListener mediationListener;
    /* access modifiers changed from: private */
    public final String placementId;
    private final String uniqueRequestId;
    /* access modifiers changed from: private */
    public VungleBannerAd vungleBannerAd;

    public void creativeId(String str) {
    }

    public void onAdEnd(String str) {
    }

    @Deprecated
    public void onAdEnd(String str, boolean z, boolean z2) {
    }

    public void onAdRewarded(String str) {
    }

    public void onAdViewed(String str) {
    }

    VungleBannerAdapter(String str, String str2, AdConfig adConfig, MediationBannerAdapter mediationBannerAdapter) {
        this.placementId = str;
        this.uniqueRequestId = str2;
        this.mAdConfig = adConfig;
        this.mediationAdapter = mediationBannerAdapter;
    }

    public String getUniqueRequestId() {
        return this.uniqueRequestId;
    }

    public RelativeLayout getAdLayout() {
        return this.adLayout;
    }

    public boolean isRequestPending() {
        return this.mPendingRequestBanner;
    }

    /* access modifiers changed from: package-private */
    public void requestBannerAd(Context context, String str, AdSize adSize, MediationBannerListener mediationBannerListener) {
        this.mediationListener = mediationBannerListener;
        requestBannerAd(context, str, adSize);
    }

    private void requestBannerAd(Context context, String str, AdSize adSize) {
        this.adLayout = new RelativeLayout(context) {
            /* access modifiers changed from: protected */
            public void onAttachedToWindow() {
                super.onAttachedToWindow();
                VungleBannerAdapter.this.attach();
            }

            /* access modifiers changed from: protected */
            public void onDetachedFromWindow() {
                super.onDetachedFromWindow();
                VungleBannerAdapter.this.detach();
            }
        };
        int heightInPixels = adSize.getHeightInPixels(context);
        if (heightInPixels <= 0) {
            heightInPixels = Math.round(((float) this.mAdConfig.getAdSize().getHeight()) * context.getResources().getDisplayMetrics().density);
        }
        this.adLayout.setLayoutParams(new RelativeLayout.LayoutParams(adSize.getWidthInPixels(context), heightInPixels));
        String str2 = VungleMediationAdapter.TAG;
        Log.d(str2, "requestBannerAd: " + this);
        this.mPendingRequestBanner = true;
        VungleInitializer.getInstance().initialize(str, context.getApplicationContext(), new VungleInitializer.VungleInitializationListener() {
            public void onInitializeSuccess() {
                VungleBannerAdapter.this.loadBanner();
            }

            public void onInitializeError(AdError adError) {
                VungleBannerAdapter.this.mVungleManager.removeActiveBannerAd(VungleBannerAdapter.this.placementId, VungleBannerAdapter.this.vungleBannerAd);
                if (VungleBannerAdapter.this.mPendingRequestBanner && VungleBannerAdapter.this.mediationAdapter != null && VungleBannerAdapter.this.mediationListener != null) {
                    Log.w(VungleMediationAdapter.TAG, adError.toString());
                    VungleBannerAdapter.this.mediationListener.onAdFailedToLoad(VungleBannerAdapter.this.mediationAdapter, adError);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        String str = VungleMediationAdapter.TAG;
        Log.d(str, "Vungle banner adapter destroy:" + this);
        this.mVisibility = false;
        this.mVungleManager.removeActiveBannerAd(this.placementId, this.vungleBannerAd);
        VungleBannerAd vungleBannerAd2 = this.vungleBannerAd;
        if (vungleBannerAd2 != null) {
            vungleBannerAd2.detach();
            this.vungleBannerAd.destroyAd();
        }
        this.vungleBannerAd = null;
        this.mPendingRequestBanner = false;
    }

    /* access modifiers changed from: package-private */
    public void preCache() {
        Banners.loadBanner(this.placementId, new BannerAdConfig((BaseAdConfig) this.mAdConfig), (LoadAdCallback) null);
    }

    /* access modifiers changed from: package-private */
    public void updateVisibility(boolean z) {
        VungleBannerAd vungleBannerAd2 = this.vungleBannerAd;
        if (vungleBannerAd2 != null) {
            this.mVisibility = z;
            if (vungleBannerAd2.getVungleBanner() != null) {
                this.vungleBannerAd.getVungleBanner().setAdVisibility(z);
            }
        }
    }

    /* access modifiers changed from: private */
    public void loadBanner() {
        String str = VungleMediationAdapter.TAG;
        Log.d(str, "loadBanner: " + this);
        Banners.loadBanner(this.placementId, new BannerAdConfig((BaseAdConfig) this.mAdConfig), this.mAdLoadCallback);
    }

    /* access modifiers changed from: private */
    public void createBanner() {
        MediationBannerListener mediationBannerListener;
        MediationBannerListener mediationBannerListener2;
        MediationBannerListener mediationBannerListener3;
        String str = VungleMediationAdapter.TAG;
        Log.d(str, "create banner: " + this);
        if (this.mPendingRequestBanner) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.vungleBannerAd = this.mVungleManager.getVungleBannerAd(this.placementId);
            VunglePlayAdCallback vunglePlayAdCallback = new VunglePlayAdCallback(this, this, this.vungleBannerAd);
            if (AdConfig.AdSize.isBannerAdSize(this.mAdConfig.getAdSize())) {
                VungleBanner banner = Banners.getBanner(this.placementId, new BannerAdConfig((BaseAdConfig) this.mAdConfig), (PlayAdCallback) vunglePlayAdCallback);
                if (banner != null) {
                    String str2 = VungleMediationAdapter.TAG;
                    Log.d(str2, "display banner:" + banner.hashCode() + this);
                    VungleBannerAd vungleBannerAd2 = this.vungleBannerAd;
                    if (vungleBannerAd2 != null) {
                        vungleBannerAd2.setVungleBanner(banner);
                    }
                    updateVisibility(this.mVisibility);
                    banner.setLayoutParams(layoutParams);
                    MediationBannerAdapter mediationBannerAdapter = this.mediationAdapter;
                    if (mediationBannerAdapter != null && (mediationBannerListener3 = this.mediationListener) != null) {
                        mediationBannerListener3.onAdLoaded(mediationBannerAdapter);
                        return;
                    }
                    return;
                }
                AdError adError = new AdError(106, "Vungle SDK returned a successful load callback, but Banners.getBanner() or Vungle.getNativeAd() returned null.", VungleMediationAdapter.ERROR_DOMAIN);
                Log.d(VungleMediationAdapter.TAG, adError.toString());
                MediationBannerAdapter mediationBannerAdapter2 = this.mediationAdapter;
                if (mediationBannerAdapter2 != null && (mediationBannerListener2 = this.mediationListener) != null) {
                    mediationBannerListener2.onAdFailedToLoad(mediationBannerAdapter2, adError);
                    return;
                }
                return;
            }
            AdError adError2 = new AdError(106, "Vungle SDK returned a successful load callback, but Banners.getBanner() or Vungle.getNativeAd() returned null.", VungleMediationAdapter.ERROR_DOMAIN);
            Log.d(VungleMediationAdapter.TAG, adError2.toString());
            MediationBannerAdapter mediationBannerAdapter3 = this.mediationAdapter;
            if (mediationBannerAdapter3 != null && (mediationBannerListener = this.mediationListener) != null) {
                mediationBannerListener.onAdFailedToLoad(mediationBannerAdapter3, adError2);
            }
        }
    }

    public String toString() {
        return " [placementId=" + this.placementId + " # uniqueRequestId=" + this.uniqueRequestId + " # hashcode=" + hashCode() + "] ";
    }

    /* access modifiers changed from: package-private */
    public void attach() {
        VungleBannerAd vungleBannerAd2 = this.vungleBannerAd;
        if (vungleBannerAd2 != null) {
            vungleBannerAd2.attach();
        }
    }

    /* access modifiers changed from: package-private */
    public void detach() {
        VungleBannerAd vungleBannerAd2 = this.vungleBannerAd;
        if (vungleBannerAd2 != null) {
            vungleBannerAd2.detach();
        }
    }

    public void onAdStart(String str) {
        preCache();
    }

    public void onAdClick(String str) {
        MediationBannerListener mediationBannerListener;
        MediationBannerAdapter mediationBannerAdapter = this.mediationAdapter;
        if (mediationBannerAdapter != null && (mediationBannerListener = this.mediationListener) != null) {
            mediationBannerListener.onAdClicked(mediationBannerAdapter);
            this.mediationListener.onAdOpened(this.mediationAdapter);
        }
    }

    public void onAdLeftApplication(String str) {
        MediationBannerListener mediationBannerListener;
        MediationBannerAdapter mediationBannerAdapter = this.mediationAdapter;
        if (mediationBannerAdapter != null && (mediationBannerListener = this.mediationListener) != null) {
            mediationBannerListener.onAdLeftApplication(mediationBannerAdapter);
        }
    }

    public void onError(String str, VungleException vungleException) {
        MediationBannerListener mediationBannerListener;
        AdError adError = VungleMediationAdapter.getAdError(vungleException);
        Log.w(VungleMediationAdapter.TAG, adError.toString());
        MediationBannerAdapter mediationBannerAdapter = this.mediationAdapter;
        if (mediationBannerAdapter != null && (mediationBannerListener = this.mediationListener) != null) {
            mediationBannerListener.onAdFailedToLoad(mediationBannerAdapter, adError);
        }
    }
}
