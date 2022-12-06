package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzg extends zzbe {
    private final AdListener zza;

    public zzg(AdListener adListener) {
        this.zza = adListener;
    }

    public final AdListener zzb() {
        return this.zza;
    }

    public final void zzc() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdClicked();
        }
    }

    public final void zzd() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdClosed();
        }
    }

    public final void zze(int i) {
    }

    public final void zzf(zze zze) {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdFailedToLoad(zze.zzb());
        }
    }

    public final void zzg() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdImpression();
        }
    }

    public final void zzh() {
    }

    public final void zzi() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdLoaded();
        }
    }

    public final void zzj() {
        AdListener adListener = this.zza;
        if (adListener != null) {
            adListener.onAdOpened();
        }
    }
}
