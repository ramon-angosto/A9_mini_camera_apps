package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfaa implements zzfaz {
    private zzdcj zza;
    private final Executor zzb = zzfzw.zzb();

    public final zzdcj zza() {
        return this.zza;
    }

    public final zzfzp zzb(zzfba zzfba, zzfay zzfay, zzdcj zzdcj) {
        zzdci zza2 = zzfay.zza(zzfba.zzb);
        zza2.zzb(new zzfbf(true));
        this.zza = (zzdcj) zza2.zzh();
        zzdah zzb2 = this.zza.zzb();
        zzffz zzffz = new zzffz();
        return zzfzg.zzm(zzfzg.zzn(zzfyx.zzv(zzb2.zzi()), new zzezy(this, zzffz, zzb2), this.zzb), new zzezz(zzffz), this.zzb);
    }

    public final /* bridge */ /* synthetic */ zzfzp zzc(zzfba zzfba, zzfay zzfay, Object obj) {
        return zzb(zzfba, zzfay, (zzdcj) null);
    }

    public final /* synthetic */ Object zzd() {
        return this.zza;
    }
}
