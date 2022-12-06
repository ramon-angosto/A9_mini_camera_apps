package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzw implements zzch<zzv> {
    private final zzcl<Application> zza;
    private final zzcl<zzac> zzb;
    private final zzcl<Handler> zzc;
    private final zzcl<Executor> zzd;
    private final zzcl<zzam> zze;
    private final zzcl<zzba> zzf;
    private final zzcl<zzn> zzg;
    private final zzcl<zzz> zzh;
    private final zzcl<zzh> zzi;

    public zzw(zzcl<Application> zzcl, zzcl<zzac> zzcl2, zzcl<Handler> zzcl3, zzcl<Executor> zzcl4, zzcl<zzam> zzcl5, zzcl<zzba> zzcl6, zzcl<zzn> zzcl7, zzcl<zzz> zzcl8, zzcl<zzh> zzcl9) {
        this.zza = zzcl;
        this.zzb = zzcl2;
        this.zzc = zzcl3;
        this.zzd = zzcl4;
        this.zze = zzcl5;
        this.zzf = zzcl6;
        this.zzg = zzcl7;
        this.zzh = zzcl8;
        this.zzi = zzcl9;
    }

    /* renamed from: zza */
    public final zzv zzb() {
        Handler handler = zzcd.zza;
        zzck.zza(handler);
        Executor executor = zzcd.zzb;
        zzck.zza(executor);
        return new zzv(this.zza.zzb(), this.zzb.zzb(), handler, executor, this.zze.zzb(), this.zzf.zzb(), ((zzp) this.zzg).zzb(), ((zzab) this.zzh).zzb(), this.zzi.zzb());
    }
}
