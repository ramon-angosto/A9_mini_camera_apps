package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzexh implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;

    public zzexh(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzexf(new zzbzg(), (ScheduledExecutorService) this.zzb.zzb(), ((zzcos) this.zzc).zza(), (byte[]) null);
    }
}
