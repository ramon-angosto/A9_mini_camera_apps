package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzbn implements zzch<zzbm> {
    private final zzcl<Application> zza;
    private final zzcl<zzbi> zzb;
    private final zzcl<Handler> zzc;
    private final zzcl<Executor> zzd;
    private final zzcl<zzh> zze;
    private final zzcl<zzak> zzf;
    private final zzcl<zzay> zzg;
    private final zzcl<zzam> zzh;

    public zzbn(zzcl<Application> zzcl, zzcl<zzbi> zzcl2, zzcl<Handler> zzcl3, zzcl<Executor> zzcl4, zzcl<zzh> zzcl5, zzcl<zzak> zzcl6, zzcl<zzay> zzcl7, zzcl<zzam> zzcl8) {
        this.zza = zzcl;
        this.zzb = zzcl2;
        this.zzc = zzcl3;
        this.zzd = zzcl4;
        this.zze = zzcl5;
        this.zzf = zzcl6;
        this.zzg = zzcl7;
        this.zzh = zzcl8;
    }

    /* renamed from: zza */
    public final zzbm zzb() {
        Handler handler = zzcd.zza;
        zzck.zza(handler);
        Executor executor = zzcd.zzb;
        zzck.zza(executor);
        return new zzbm(this.zza.zzb(), this.zzb.zzb(), handler, executor, this.zze.zzb(), ((zzal) this.zzf).zzb(), this.zzg.zzb(), this.zzh.zzb());
    }
}
