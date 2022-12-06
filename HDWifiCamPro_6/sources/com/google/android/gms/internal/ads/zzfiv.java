package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfiv {
    public final String zza;
    public final String zzb;

    public zzfiv(String str, String str2) {
        this.zza = str;
        this.zzb = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfiv)) {
            return false;
        }
        zzfiv zzfiv = (zzfiv) obj;
        return this.zza.equals(zzfiv.zza) && this.zzb.equals(zzfiv.zzb);
    }

    public final int hashCode() {
        return String.valueOf(this.zza).concat(String.valueOf(this.zzb)).hashCode();
    }
}
