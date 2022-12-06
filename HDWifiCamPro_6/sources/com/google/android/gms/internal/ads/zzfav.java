package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfav {
    private final zzffq zza;
    private final zzdcj zzb;
    private final Executor zzc;
    /* access modifiers changed from: private */
    public zzfau zzd;

    public zzfav(zzffq zzffq, zzdcj zzdcj, Executor executor) {
        this.zza = zzffq;
        this.zzb = zzdcj;
        this.zzc = executor;
    }

    /* access modifiers changed from: private */
    @Deprecated
    public final zzfga zze() {
        zzfef zzg = this.zzb.zzg();
        return this.zza.zzc(zzg.zzd, zzg.zzf, zzg.zzj);
    }

    public final zzfzp zzc() {
        zzfzp zzfzp;
        zzfau zzfau = this.zzd;
        if (zzfau != null) {
            return zzfzg.zzi(zzfau);
        }
        if (!((Boolean) zzbky.zza.zze()).booleanValue()) {
            this.zzd = new zzfau((zzcbc) null, zze(), (zzfat) null);
            zzfzp = zzfzg.zzi(this.zzd);
        } else {
            zzfzp = zzfzg.zzf(zzfzg.zzm(zzfyx.zzv(this.zzb.zzb().zze(this.zza.zza())), new zzfas(this), this.zzc), zzedj.class, new zzfar(this), this.zzc);
        }
        return zzfzg.zzm(zzfzp, zzfaq.zza, this.zzc);
    }
}
