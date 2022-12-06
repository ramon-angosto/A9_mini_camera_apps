package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzaaj {
    public final zzaam zza;
    public final zzaam zzb;

    public zzaaj(zzaam zzaam, zzaam zzaam2) {
        this.zza = zzaam;
        this.zzb = zzaam2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzaaj zzaaj = (zzaaj) obj;
            return this.zza.equals(zzaaj.zza) && this.zzb.equals(zzaaj.zzb);
        }
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        String obj = this.zza.toString();
        String concat = this.zza.equals(this.zzb) ? "" : ", ".concat(this.zzb.toString());
        return "[" + obj + concat + "]";
    }
}
