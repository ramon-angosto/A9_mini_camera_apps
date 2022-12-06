package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaam {
    public static final zzaam zza = new zzaam(0, 0);
    public final long zzb;
    public final long zzc;

    public zzaam(long j, long j2) {
        this.zzb = j;
        this.zzc = j2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaam zzaam = (zzaam) obj;
            return this.zzb == zzaam.zzb && this.zzc == zzaam.zzc;
        }
    }

    public final int hashCode() {
        return (((int) this.zzb) * 31) + ((int) this.zzc);
    }

    public final String toString() {
        long j = this.zzb;
        long j2 = this.zzc;
        return "[timeUs=" + j + ", position=" + j2 + "]";
    }
}
