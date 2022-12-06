package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzgxs {
    private final List zza;
    private final List zzb;

    /* synthetic */ zzgxs(int i, int i2, zzgxr zzgxr) {
        this.zza = zzgxf.zzc(i);
        this.zzb = zzgxf.zzc(i2);
    }

    public final zzgxs zza(zzgxv zzgxv) {
        this.zzb.add(zzgxv);
        return this;
    }

    public final zzgxs zzb(zzgxv zzgxv) {
        this.zza.add(zzgxv);
        return this;
    }

    public final zzgxt zzc() {
        return new zzgxt(this.zza, this.zzb, (zzgxr) null);
    }
}
