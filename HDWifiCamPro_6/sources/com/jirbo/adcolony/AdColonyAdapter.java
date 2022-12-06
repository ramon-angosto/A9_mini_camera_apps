package com.jirbo.adcolony;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAdSize;
import com.adcolony.sdk.AdColonyAdView;
import com.adcolony.sdk.AdColonyInterstitial;
import com.google.ads.mediation.adcolony.AdColonyAdapterUtils;
import com.google.ads.mediation.adcolony.AdColonyMediationAdapter;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.jirbo.adcolony.AdColonyManager;
import java.util.Locale;

public class AdColonyAdapter extends AdColonyMediationAdapter implements MediationInterstitialAdapter, MediationBannerAdapter {
    private AdColonyAdView adColonyAdView;
    /* access modifiers changed from: private */
    public AdColonyBannerAdListener adColonyBannerAdListener;
    private AdColonyInterstitial adColonyInterstitial;
    /* access modifiers changed from: private */
    public AdColonyAdListener adColonyInterstitialListener;

    public void onPause() {
    }

    public void onResume() {
    }

    public void onDestroy() {
        AdColonyInterstitial adColonyInterstitial2 = this.adColonyInterstitial;
        if (adColonyInterstitial2 != null) {
            adColonyInterstitial2.cancel();
            this.adColonyInterstitial.destroy();
        }
        AdColonyAdListener adColonyAdListener = this.adColonyInterstitialListener;
        if (adColonyAdListener != null) {
            adColonyAdListener.destroy();
        }
        AdColonyAdView adColonyAdView2 = this.adColonyAdView;
        if (adColonyAdView2 != null) {
            adColonyAdView2.destroy();
        }
        AdColonyBannerAdListener adColonyBannerAdListener2 = this.adColonyBannerAdListener;
        if (adColonyBannerAdListener2 != null) {
            adColonyBannerAdListener2.destroy();
        }
    }

    public void requestInterstitialAd(Context context, final MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        final String zoneFromRequest = AdColonyManager.getInstance().getZoneFromRequest(AdColonyManager.getInstance().parseZoneList(bundle), bundle2);
        if (TextUtils.isEmpty(zoneFromRequest)) {
            AdError createAdapterError = createAdapterError(101, "Missing or invalid Zone ID.");
            Log.e(TAG, createAdapterError.getMessage());
            mediationInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) this, createAdapterError);
            return;
        }
        this.adColonyInterstitialListener = new AdColonyAdListener(this, mediationInterstitialListener);
        AdColonyManager.getInstance().configureAdColony(context, bundle, mediationAdRequest, new AdColonyManager.InitializationListener() {
            public void onInitializeSuccess() {
                AdColony.requestInterstitial(zoneFromRequest, AdColonyAdapter.this.adColonyInterstitialListener);
            }

            public void onInitializeFailed(AdError adError) {
                Log.w(AdColonyMediationAdapter.TAG, adError.getMessage());
                mediationInterstitialListener.onAdFailedToLoad((MediationInterstitialAdapter) AdColonyAdapter.this, adError);
            }
        });
    }

    public void showInterstitial() {
        showAdColonyInterstitial();
    }

    private void showAdColonyInterstitial() {
        AdColonyInterstitial adColonyInterstitial2 = this.adColonyInterstitial;
        if (adColonyInterstitial2 != null) {
            adColonyInterstitial2.show();
        }
    }

    /* access modifiers changed from: package-private */
    public void setAd(AdColonyInterstitial adColonyInterstitial2) {
        this.adColonyInterstitial = adColonyInterstitial2;
    }

    public void requestBannerAd(Context context, final MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        final AdColonyAdSize adColonyAdSizeFromAdMobAdSize = AdColonyAdapterUtils.adColonyAdSizeFromAdMobAdSize(context, adSize);
        if (adColonyAdSizeFromAdMobAdSize == null) {
            AdError createAdapterError = createAdapterError(104, "Failed to request banner with unsupported size: " + adSize);
            Log.e(TAG, createAdapterError.getMessage());
            mediationBannerListener.onAdFailedToLoad((MediationBannerAdapter) this, createAdapterError);
            return;
        }
        final String zoneFromRequest = AdColonyManager.getInstance().getZoneFromRequest(AdColonyManager.getInstance().parseZoneList(bundle), bundle2);
        if (TextUtils.isEmpty(zoneFromRequest)) {
            AdError createAdapterError2 = createAdapterError(101, "Failed to request ad: zone ID is null or empty");
            Log.e(TAG, createAdapterError2.getMessage());
            mediationBannerListener.onAdFailedToLoad((MediationBannerAdapter) this, createAdapterError2);
            return;
        }
        this.adColonyBannerAdListener = new AdColonyBannerAdListener(this, mediationBannerListener);
        AdColonyManager.getInstance().configureAdColony(context, bundle, mediationAdRequest, new AdColonyManager.InitializationListener() {
            public void onInitializeSuccess() {
                Log.d(AdColonyMediationAdapter.TAG, String.format(Locale.US, "Requesting banner with ad size: %dx%d", new Object[]{Integer.valueOf(adColonyAdSizeFromAdMobAdSize.getWidth()), Integer.valueOf(adColonyAdSizeFromAdMobAdSize.getHeight())}));
                AdColony.requestAdView(zoneFromRequest, AdColonyAdapter.this.adColonyBannerAdListener, adColonyAdSizeFromAdMobAdSize);
            }

            public void onInitializeFailed(AdError adError) {
                Log.w(AdColonyMediationAdapter.TAG, adError.getMessage());
                mediationBannerListener.onAdFailedToLoad((MediationBannerAdapter) AdColonyAdapter.this, adError);
            }
        });
    }

    public View getBannerView() {
        return this.adColonyAdView;
    }

    /* access modifiers changed from: package-private */
    public void setAdView(AdColonyAdView adColonyAdView2) {
        this.adColonyAdView = adColonyAdView2;
    }
}
