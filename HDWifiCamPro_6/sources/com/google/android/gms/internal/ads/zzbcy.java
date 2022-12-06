package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbcy {
    final long zza;
    final String zzb;
    final int zzc;

    zzbcy(long j, String str, int i) {
        this.zza = j;
        this.zzb = str;
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof zzbcy)) {
            zzbcy zzbcy = (zzbcy) obj;
            if (zzbcy.zza == this.zza && zzbcy.zzc == this.zzc) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return (int) this.zza;
    }
}
