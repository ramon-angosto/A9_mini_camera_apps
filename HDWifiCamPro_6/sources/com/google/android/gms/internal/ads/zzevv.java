package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzevv implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;

    public zzevv(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4, zzgxv zzgxv5) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
        this.zze = zzgxv5;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfzq zzfzq = zzchc.zza;
        zzgxq.zzb(zzfzq);
        return new zzevt(new zzcfp(), ((zzcos) this.zzb).zza(), (ScheduledExecutorService) this.zzc.zzb(), zzfzq, ((zzexk) this.zze).zzb().intValue(), (byte[]) null);
    }
}
