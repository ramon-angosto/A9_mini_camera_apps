package com.google.android.gms.internal.ads;

import com.ironsource.mediationsdk.logger.IronSourceError;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public class zzbn {
    public final Object zza;
    public final int zzb;
    public final int zzc;
    public final long zzd;
    public final int zze;

    protected zzbn(zzbn zzbn) {
        this.zza = zzbn.zza;
        this.zzb = zzbn.zzb;
        this.zzc = zzbn.zzc;
        this.zzd = zzbn.zzd;
        this.zze = zzbn.zze;
    }

    public zzbn(Object obj, int i, int i2, long j) {
        this(obj, i, i2, j, -1);
    }

    private zzbn(Object obj, int i, int i2, long j, int i3) {
        this.zza = obj;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = j;
        this.zze = i3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbn)) {
            return false;
        }
        zzbn zzbn = (zzbn) obj;
        return this.zza.equals(zzbn.zza) && this.zzb == zzbn.zzb && this.zzc == zzbn.zzc && this.zzd == zzbn.zzd && this.zze == zzbn.zze;
    }

    public final int hashCode() {
        return ((((((((this.zza.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE) * 31) + this.zzb) * 31) + this.zzc) * 31) + ((int) this.zzd)) * 31) + this.zze;
    }

    public final zzbn zza(Object obj) {
        if (this.zza.equals(obj)) {
            return this;
        }
        return new zzbn(obj, this.zzb, this.zzc, this.zzd, this.zze);
    }

    public final boolean zzb() {
        return this.zzb != -1;
    }

    public zzbn(Object obj, long j) {
        this(obj, -1, -1, j, -1);
    }

    public zzbn(Object obj, long j, int i) {
        this(obj, -1, -1, j, i);
    }
}
