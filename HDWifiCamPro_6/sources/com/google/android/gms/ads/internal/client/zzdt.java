package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.LoadAdError;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
final class zzdt extends zzax {
    final /* synthetic */ zzdu zza;

    zzdt(zzdu zzdu) {
        this.zza = zzdu;
    }

    public final void onAdFailedToLoad(LoadAdError loadAdError) {
        zzdu zzdu = this.zza;
        zzdu.zze.zzb(zzdu.zzi());
        super.onAdFailedToLoad(loadAdError);
    }

    public final void onAdLoaded() {
        zzdu zzdu = this.zza;
        zzdu.zze.zzb(zzdu.zzi());
        super.onAdLoaded();
    }
}
