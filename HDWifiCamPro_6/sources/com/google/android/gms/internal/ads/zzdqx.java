package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdqx implements zzgxi {
    private final zzdqq zza;
    private final zzgxv zzb;
    private final zzgxv zzc;

    public zzdqx(zzdqq zzdqq, zzgxv zzgxv, zzgxv zzgxv2) {
        this.zza = zzdqq;
        this.zzb = zzgxv;
        this.zzc = zzgxv2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdkg(((zzdty) this.zzb).zzb(), (Executor) this.zzc.zzb());
    }
}
