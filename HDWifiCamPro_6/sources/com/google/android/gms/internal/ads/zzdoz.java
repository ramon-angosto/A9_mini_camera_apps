package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdoz {
    zzbnf zza;
    zzbnc zzb;
    zzbns zzc;
    zzbnp zzd;
    zzbsl zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdoz zza(zzbnc zzbnc) {
        this.zzb = zzbnc;
        return this;
    }

    public final zzdoz zzb(zzbnf zzbnf) {
        this.zza = zzbnf;
        return this;
    }

    public final zzdoz zzc(String str, zzbnl zzbnl, zzbni zzbni) {
        this.zzf.put(str, zzbnl);
        if (zzbni != null) {
            this.zzg.put(str, zzbni);
        }
        return this;
    }

    public final zzdoz zzd(zzbsl zzbsl) {
        this.zze = zzbsl;
        return this;
    }

    public final zzdoz zze(zzbnp zzbnp) {
        this.zzd = zzbnp;
        return this;
    }

    public final zzdoz zzf(zzbns zzbns) {
        this.zzc = zzbns;
        return this;
    }

    public final zzdpb zzg() {
        return new zzdpb(this);
    }
}
