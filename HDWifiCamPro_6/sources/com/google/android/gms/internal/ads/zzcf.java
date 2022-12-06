package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcf {
    public static final zzn zza = zzce.zza;
    public final Object zzb;
    public final int zzc;
    public final zzbg zzd;
    public final Object zze;
    public final int zzf;
    public final long zzg;
    public final long zzh;
    public final int zzi;
    public final int zzj;

    public zzcf(Object obj, int i, zzbg zzbg, Object obj2, int i2, long j, long j2, int i3, int i4) {
        this.zzb = obj;
        this.zzc = i;
        this.zzd = zzbg;
        this.zze = obj2;
        this.zzf = i2;
        this.zzg = j;
        this.zzh = j2;
        this.zzi = i3;
        this.zzj = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzcf zzcf = (zzcf) obj;
            return this.zzc == zzcf.zzc && this.zzf == zzcf.zzf && this.zzg == zzcf.zzg && this.zzh == zzcf.zzh && this.zzi == zzcf.zzi && this.zzj == zzcf.zzj && zzfss.zza(this.zzb, zzcf.zzb) && zzfss.zza(this.zze, zzcf.zze) && zzfss.zza(this.zzd, zzcf.zzd);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zzb, Integer.valueOf(this.zzc), this.zzd, this.zze, Integer.valueOf(this.zzf), Long.valueOf(this.zzg), Long.valueOf(this.zzh), Integer.valueOf(this.zzi), Integer.valueOf(this.zzj)});
    }
}
