package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcyp implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;

    public zzcyp(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcyk(((zzdaz) this.zza).zzb(), ((zzcyo) this.zzb).zza(), ((zzcyn) this.zzc).zza(), (Executor) this.zzd.zzb());
    }
}
