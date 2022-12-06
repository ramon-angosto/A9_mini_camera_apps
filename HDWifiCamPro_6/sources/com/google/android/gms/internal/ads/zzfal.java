package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfal implements zzfaz {
    private final zzffq zza;
    private final Executor zzb;
    private final zzfzc zzc = new zzfaj(this);

    public zzfal(zzffq zzffq, Executor executor) {
        this.zza = zzffq;
        this.zzb = executor;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zza(zzdcj zzdcj, zzfau zzfau) throws Exception {
        zzfga zzfga = zzfau.zzb;
        zzcbc zzcbc = zzfau.zza;
        zzffz zzb2 = zzfga != null ? this.zza.zzb(zzfga) : null;
        if (zzfga == null) {
            return zzfzg.zzi((Object) null);
        }
        if (!(zzb2 == null || zzcbc == null)) {
            zzfzg.zzr(zzdcj.zzb().zzg(zzcbc), this.zzc, this.zzb);
        }
        return zzfzg.zzi(new zzfak(zzfga, zzcbc, zzb2));
    }

    public final zzfzp zzb(zzfba zzfba, zzfay zzfay, zzdcj zzdcj) {
        return zzfzg.zzf(zzfzg.zzn(zzfyx.zzv(new zzfav(this.zza, zzdcj, this.zzb).zzc()), new zzfah(this, zzdcj), this.zzb), Exception.class, new zzfai(this), this.zzb);
    }

    public final /* bridge */ /* synthetic */ zzfzp zzc(zzfba zzfba, zzfay zzfay, Object obj) {
        return zzb(zzfba, zzfay, (zzdcj) null);
    }

    public final /* bridge */ /* synthetic */ Object zzd() {
        return null;
    }
}
