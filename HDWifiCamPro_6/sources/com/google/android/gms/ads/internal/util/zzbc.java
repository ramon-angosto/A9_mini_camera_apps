package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbc {
    public final String zza;
    public final double zzb;
    public final double zzc;
    public final double zzd;
    public final int zze;

    public zzbc(String str, double d, double d2, double d3, int i) {
        this.zza = str;
        this.zzc = d;
        this.zzb = d2;
        this.zzd = d3;
        this.zze = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzbc)) {
            return false;
        }
        zzbc zzbc = (zzbc) obj;
        if (Objects.equal(this.zza, zzbc.zza) && this.zzb == zzbc.zzb && this.zzc == zzbc.zzc && this.zze == zzbc.zze && Double.compare(this.zzd, zzbc.zzd) == 0) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, Double.valueOf(this.zzb), Double.valueOf(this.zzc), Double.valueOf(this.zzd), Integer.valueOf(this.zze));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add("name", this.zza).add("minBound", Double.valueOf(this.zzc)).add("maxBound", Double.valueOf(this.zzb)).add("percent", Double.valueOf(this.zzd)).add("count", Integer.valueOf(this.zze)).toString();
    }
}
