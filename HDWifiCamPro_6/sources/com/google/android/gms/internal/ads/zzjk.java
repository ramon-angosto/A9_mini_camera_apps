package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzjk {
    public final zzsi zza;
    public final long zzb;
    public final long zzc;
    public final long zzd;
    public final long zze;
    public final boolean zzf;
    public final boolean zzg;
    public final boolean zzh;
    public final boolean zzi;

    zzjk(zzsi zzsi, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = true;
        zzdd.zzd(!z4 || z2);
        if (z3 && !z2) {
            z5 = false;
        }
        zzdd.zzd(z5);
        this.zza = zzsi;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = j3;
        this.zze = j4;
        this.zzf = false;
        this.zzg = z2;
        this.zzh = z3;
        this.zzi = z4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzjk zzjk = (zzjk) obj;
            return this.zzb == zzjk.zzb && this.zzc == zzjk.zzc && this.zzd == zzjk.zzd && this.zze == zzjk.zze && this.zzg == zzjk.zzg && this.zzh == zzjk.zzh && this.zzi == zzjk.zzi && zzen.zzT(this.zza, zzjk.zza);
        }
    }

    public final int hashCode() {
        return ((((((((((((((this.zza.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + ((int) this.zzb)) * 31) + ((int) this.zzc)) * 31) + ((int) this.zzd)) * 31) + ((int) this.zze)) * 961) + (this.zzg ? 1 : 0)) * 31) + (this.zzh ? 1 : 0)) * 31) + (this.zzi ? 1 : 0);
    }

    public final zzjk zza(long j) {
        if (j == this.zzc) {
            return this;
        }
        return new zzjk(this.zza, this.zzb, j, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }

    public final zzjk zzb(long j) {
        if (j == this.zzb) {
            return this;
        }
        return new zzjk(this.zza, j, this.zzc, this.zzd, this.zze, false, this.zzg, this.zzh, this.zzi);
    }
}
