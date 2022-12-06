package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzewj implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;

    public zzewj(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4, zzgxv zzgxv5) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
        this.zze = zzgxv5;
    }

    public static zzewh zza(String str, zzbds zzbds, zzcfy zzcfy, ScheduledExecutorService scheduledExecutorService, zzfzq zzfzq) {
        return new zzewh(str, zzbds, zzcfy, scheduledExecutorService, zzfzq, (byte[]) null);
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfzq zzfzq = zzchc.zza;
        zzgxq.zzb(zzfzq);
        return new zzewh(((zzexj) this.zza).zza(), new zzbds(), (zzcfy) this.zzc.zzb(), (ScheduledExecutorService) this.zzd.zzb(), zzfzq, (byte[]) null);
    }
}
