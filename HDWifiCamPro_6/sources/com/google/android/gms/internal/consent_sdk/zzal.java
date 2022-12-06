package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzal implements zzch<zzak> {
    private final zzcl<Application> zza;
    private final zzcl<zzam> zzb;
    private final zzcl<Executor> zzc;

    public zzal(zzcl<Application> zzcl, zzcl<zzam> zzcl2, zzcl<Executor> zzcl3) {
        this.zza = zzcl;
        this.zzb = zzcl2;
        this.zzc = zzcl3;
    }

    /* renamed from: zza */
    public final zzak zzb() {
        Executor executor = zzcd.zzb;
        zzck.zza(executor);
        return new zzak(this.zza.zzb(), this.zzb.zzb(), executor);
    }
}
