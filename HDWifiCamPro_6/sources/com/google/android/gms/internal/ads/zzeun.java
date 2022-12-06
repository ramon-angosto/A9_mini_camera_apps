package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeun implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;
    private final zzgxv zzf;

    public zzeun(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4, zzgxv zzgxv5, zzgxv zzgxv6) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
        this.zze = zzgxv5;
        this.zzf = zzgxv6;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfzq zzfzq = zzchc.zza;
        zzgxq.zzb(zzfzq);
        return new zzeul(zzfzq, (ScheduledExecutorService) this.zzb.zzb(), (String) this.zzc.zzb(), (Context) this.zzd.zzb(), ((zzdcr) this.zze).zza(), (zzcom) this.zzf.zzb());
    }
}
