package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdpu implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;

    public zzdpu(zzgxv zzgxv, zzgxv zzgxv2) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdpt(((zzdnx) this.zza).zza(), (Clock) this.zzb.zzb());
    }
}
