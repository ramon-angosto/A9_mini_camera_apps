package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdzt implements zzgxi {
    private final zzgxv zza;
    private final zzgxv zzb;
    private final zzgxv zzc;
    private final zzgxv zzd;
    private final zzgxv zze;
    private final zzgxv zzf;
    private final zzgxv zzg;
    private final zzgxv zzh;
    private final zzgxv zzi;
    private final zzgxv zzj;

    public zzdzt(zzgxv zzgxv, zzgxv zzgxv2, zzgxv zzgxv3, zzgxv zzgxv4, zzgxv zzgxv5, zzgxv zzgxv6, zzgxv zzgxv7, zzgxv zzgxv8, zzgxv zzgxv9, zzgxv zzgxv10) {
        this.zza = zzgxv;
        this.zzb = zzgxv2;
        this.zzc = zzgxv3;
        this.zzd = zzgxv4;
        this.zze = zzgxv5;
        this.zzf = zzgxv6;
        this.zzg = zzgxv7;
        this.zzh = zzgxv8;
        this.zzi = zzgxv9;
        this.zzj = zzgxv10;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Context zza2 = ((zzcos) this.zzb).zza();
        WeakReference zza3 = ((zzcot) this.zzc).zza();
        zzfzq zzfzq = zzchc.zza;
        zzgxq.zzb(zzfzq);
        return new zzdzs((Executor) this.zza.zzb(), zza2, zza3, zzfzq, (zzdvl) this.zze.zzb(), (ScheduledExecutorService) this.zzf.zzb(), (zzdxz) this.zzg.zzb(), ((zzcpc) this.zzh).zza(), ((zzdjs) this.zzi).zzb(), (zzfjw) this.zzj.zzb());
    }
}
