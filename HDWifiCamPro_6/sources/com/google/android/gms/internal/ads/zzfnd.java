package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzfnd extends zzfmz {
    private final String zza;
    private final boolean zzb;
    private final boolean zzc;

    /* synthetic */ zzfnd(String str, boolean z, boolean z2, zzfnc zzfnc) {
        this.zza = str;
        this.zzb = z;
        this.zzc = z2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfmz) {
            zzfmz zzfmz = (zzfmz) obj;
            return this.zza.equals(zzfmz.zzb()) && this.zzb == zzfmz.zzd() && this.zzc == zzfmz.zzc();
        }
    }

    public final int hashCode() {
        int i = 1237;
        int hashCode = (((this.zza.hashCode() ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231)) * 1000003;
        if (true == this.zzc) {
            i = 1231;
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String str = this.zza;
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        return "AdShield2Options{clientVersion=" + str + ", shouldGetAdvertisingId=" + z + ", isGooglePlayServicesAvailable=" + z2 + "}";
    }

    public final String zzb() {
        return this.zza;
    }

    public final boolean zzc() {
        return this.zzc;
    }

    public final boolean zzd() {
        return this.zzb;
    }
}
