package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public class zzax extends AdListener {
    private final Object zza = new Object();
    private AdListener zzb;

    public final void onAdClicked() {
        synchronized (this.zza) {
            AdListener adListener = this.zzb;
            if (adListener != null) {
                adListener.onAdClicked();
            }
        }
    }

    public final void onAdClosed() {
        synchronized (this.zza) {
            AdListener adListener = this.zzb;
            if (adListener != null) {
                adListener.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(LoadAdError loadAdError) {
        synchronized (this.zza) {
            AdListener adListener = this.zzb;
            if (adListener != null) {
                adListener.onAdFailedToLoad(loadAdError);
            }
        }
    }

    public final void onAdImpression() {
        synchronized (this.zza) {
            AdListener adListener = this.zzb;
            if (adListener != null) {
                adListener.onAdImpression();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.zza) {
            AdListener adListener = this.zzb;
            if (adListener != null) {
                adListener.onAdLoaded();
            }
        }
    }

    public final void onAdOpened() {
        synchronized (this.zza) {
            AdListener adListener = this.zzb;
            if (adListener != null) {
                adListener.onAdOpened();
            }
        }
    }

    public final void zza(AdListener adListener) {
        synchronized (this.zza) {
            this.zzb = adListener;
        }
    }
}
