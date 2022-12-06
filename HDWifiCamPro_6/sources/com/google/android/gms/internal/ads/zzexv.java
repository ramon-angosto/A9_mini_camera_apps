package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzexv implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;

    public zzexv(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4, zzgxv zzgxv5, zzgxv zzgxv6, zzgxv zzgxv7) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
        this.zze = zzgxv5;
        this.zzf = zzgxv6;
        this.zzg = zzgxv7;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        boolean booleanValue = ((zzexl) this.zzb).zzb().booleanValue();
        boolean booleanValue2 = ((zzexm) this.zzc).zzb().booleanValue();
        zzcfn zzcfn = new zzcfn();
        zzfzq zzfzq = zzchc.zza;
        zzgxq.zzb(zzfzq);
        return new zzext((zzcfy) this.zza.zzb(), booleanValue, booleanValue2, zzcfn, zzfzq, ((zzexj) this.zzf).zza(), (ScheduledExecutorService) this.zzg.zzb(), (byte[]) null);
    }
}
