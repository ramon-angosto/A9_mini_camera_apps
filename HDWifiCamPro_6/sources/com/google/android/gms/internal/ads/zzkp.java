package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzkp {
    public final long zza;
    public final zzcn zzb;
    public final int zzc;
    public final zzsi zzd;
    public final long zze;
    public final zzcn zzf;
    public final int zzg;
    public final zzsi zzh;
    public final long zzi;
    public final long zzj;

    public zzkp(long j, zzcn zzcn, int i, zzsi zzsi, long j2, zzcn zzcn2, int i2, zzsi zzsi2, long j3, long j4) {
        this.zza = j;
        this.zzb = zzcn;
        this.zzc = i;
        this.zzd = zzsi;
        this.zze = j2;
        this.zzf = zzcn2;
        this.zzg = i2;
        this.zzh = zzsi2;
        this.zzi = j3;
        this.zzj = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzkp zzkp = (zzkp) obj;
            return this.zza == zzkp.zza && this.zzc == zzkp.zzc && this.zze == zzkp.zze && this.zzg == zzkp.zzg && this.zzi == zzkp.zzi && this.zzj == zzkp.zzj && zzfss.zza(this.zzb, zzkp.zzb) && zzfss.zza(this.zzd, zzkp.zzd) && zzfss.zza(this.zzf, zzkp.zzf) && zzfss.zza(this.zzh, zzkp.zzh);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj)});
    }
}
