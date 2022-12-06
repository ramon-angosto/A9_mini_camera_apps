package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzaga implements zzaal {
    final /* synthetic */ zzagb zza;

    /* synthetic */ zzaga(zzagb zzagb, zzafz zzafz) {
        this.zza = zzagb;
    }

    public final long zze() {
        zzagb zzagb = this.zza;
        return zzagb.zzd.zzf(zzagb.zzf);
    }

    public final zzaaj zzg(long j) {
        zzagb zzagb = this.zza;
        long zzg = zzagb.zzd.zzg(j);
        long zzb = zzagb.zzb;
        long zza2 = zzg * (zzagb.zzc - zzagb.zzb);
        zzaam zzaam = new zzaam(j, zzen.zzr(-30000 + zzb + (zza2 / zzagb.zzf), zzagb.zzb, zzagb.zzc - 1));
        return new zzaaj(zzaam, zzaam);
    }

    public final boolean zzh() {
        return true;
    }
}
