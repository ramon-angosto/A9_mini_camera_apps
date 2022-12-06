package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfap implements zzfaz {
    private final zzfaz zza;
    private zzdcj zzb;

    public zzfap(zzfaz zzfaz) {
        this.zza = zzfaz;
    }

    /* renamed from: zza */
    public final synchronized zzdcj zzd() {
        return this.zzb;
    }

    public final synchronized zzfzp zzb(zzfba zzfba, zzfay zzfay, zzdcj zzdcj) {
        this.zzb = zzdcj;
        if (zzfba.zza != null) {
            zzdah zzb2 = this.zzb.zzb();
            return zzb2.zzh(zzb2.zzj(zzfzg.zzi(zzfba.zza)));
        }
        return ((zzfao) this.zza).zzb(zzfba, zzfay, zzdcj);
    }

    public final /* bridge */ /* synthetic */ zzfzp zzc(zzfba zzfba, zzfay zzfay, Object obj) {
        return zzb(zzfba, zzfay, (zzdcj) null);
    }
}
