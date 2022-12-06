package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzkd {
    public static final zzkd zza = new zzkd(0, 0);
    public static final zzkd zzb = new zzkd(Long.MAX_VALUE, Long.MAX_VALUE);
    public static final zzkd zzc = new zzkd(Long.MAX_VALUE, 0);
    public static final zzkd zzd = new zzkd(0, Long.MAX_VALUE);
    public static final zzkd zze = zza;
    public final long zzf;
    public final long zzg;

    public zzkd(long j, long j2) {
        boolean z = true;
        zzdd.zzd(j >= 0);
        zzdd.zzd(j2 < 0 ? false : z);
        this.zzf = j;
        this.zzg = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzkd zzkd = (zzkd) obj;
            return this.zzf == zzkd.zzf && this.zzg == zzkd.zzg;
        }
    }

    public final int hashCode() {
        return (((int) this.zzf) * 31) + ((int) this.zzg);
    }
}
