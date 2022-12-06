package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcyh implements zzgxi {
    private final zzgxv zza;

    public zzcyh(zzgxv zzgxv) {
        this.zza = zzgxv;
    }

    /* renamed from: zza */
    public final Boolean zzb() {
        boolean z = true;
        if (((zzdcr) this.zza).zza().zza() == null) {
            if (!((Boolean) zzay.zzc().zzb(zzbjc.zzeF)).booleanValue()) {
                z = false;
            }
        }
        return Boolean.valueOf(z);
    }
}
