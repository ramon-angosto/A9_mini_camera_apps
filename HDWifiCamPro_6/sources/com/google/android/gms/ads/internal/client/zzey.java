package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class zzey extends zzdd {
    private final OnPaidEventListener zza;

    public zzey(OnPaidEventListener onPaidEventListener) {
        this.zza = onPaidEventListener;
    }

    public final void zze(zzs zzs) {
        OnPaidEventListener onPaidEventListener = this.zza;
        if (onPaidEventListener != null) {
            onPaidEventListener.onPaidEvent(AdValue.zza(zzs.zzb, zzs.zzc, zzs.zzd));
        }
    }
}
