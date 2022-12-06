package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzsv implements zzvt {
    private final zzvt zza;
    private final zzcp zzb;

    public zzsv(zzvt zzvt, zzcp zzcp) {
        this.zza = zzvt;
        this.zzb = zzcp;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzsv)) {
            return false;
        }
        zzsv zzsv = (zzsv) obj;
        return this.zza.equals(zzsv.zza) && this.zzb.equals(zzsv.zzb);
    }

    public final int hashCode() {
        return ((this.zzb.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zza.hashCode();
    }

    public final int zza(int i) {
        return this.zza.zza(0);
    }

    public final int zzb(int i) {
        return this.zza.zzb(i);
    }

    public final int zzc() {
        return this.zza.zzc();
    }

    public final zzaf zzd(int i) {
        return this.zza.zzd(i);
    }

    public final zzcp zze() {
        return this.zzb;
    }
}
