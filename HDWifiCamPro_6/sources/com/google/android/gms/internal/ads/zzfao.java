package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfao implements zzfaz {
    private zzdcj zza;

    /* renamed from: zza */
    public final synchronized zzdcj zzd() {
        return this.zza;
    }

    public final /* bridge */ /* synthetic */ zzfzp zzc(zzfba zzfba, zzfay zzfay, Object obj) {
        return zzb(zzfba, zzfay, (zzdcj) null);
    }

    public final synchronized zzfzp zzb(zzfba zzfba, zzfay zzfay, zzdcj zzdcj) {
        zzdah zzb;
        if (zzdcj != null) {
            this.zza = zzdcj;
        } else {
            this.zza = (zzdcj) zzfay.zza(zzfba.zzb).zzh();
        }
        zzb = this.zza.zzb();
        return zzb.zzh(zzb.zzi());
    }
}
