package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzt {
    public static final zzt zza = new zzt(0, 0, 0);
    public static final zzn zzb = zzs.zza;
    public final int zzc = 0;
    public final int zzd;
    public final int zze;

    public zzt(int i, int i2, int i3) {
        this.zzd = i2;
        this.zze = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt zzt = (zzt) obj;
        int i = zzt.zzc;
        return this.zzd == zzt.zzd && this.zze == zzt.zze;
    }

    public final int hashCode() {
        return ((this.zzd + 16337) * 31) + this.zze;
    }
}
