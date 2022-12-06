package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzk {
    public static final zzk zza = new zzk(0, 0, 1, 1, 0, (zzj) null);
    public static final zzn zzb = zze.zza;
    public final int zzc = 1;
    private zzi zzd;

    /* synthetic */ zzk(int i, int i2, int i3, int i4, int i5, zzj zzj) {
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        zzk zzk = (zzk) obj;
        return true;
    }

    public final int hashCode() {
        return 486696559;
    }

    public final zzi zza() {
        if (this.zzd == null) {
            this.zzd = new zzi(this, (zzh) null);
        }
        return this.zzd;
    }
}
