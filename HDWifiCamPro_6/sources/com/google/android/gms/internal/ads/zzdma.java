package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdma implements zzgxi {
    private final zzdlk zza;
    private final zzgxv zzb;

    public zzdma(zzdlk zzdlk, zzgxv zzgxv) {
        this.zza = zzdlk;
        this.zzb = zzgxv;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return this.zza.zzd((Executor) this.zzb.zzb());
    }
}
