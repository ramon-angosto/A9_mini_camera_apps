package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdui implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;

    public zzdui(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
    }

    public final /* synthetic */ Object zzb() {
        zzgxv zzgxv = this.zza;
        zzgxv zzgxv2 = this.zzb;
        int i = ((zzdcr) this.zzc).zza().zzo.zza;
        int i2 = i - 1;
        if (i == 0) {
            throw null;
        } else if (i2 != 0) {
            return ((zzemc) zzgxv2).zzb();
        } else {
            return ((zzemc) zzgxv).zzb();
        }
    }
}
