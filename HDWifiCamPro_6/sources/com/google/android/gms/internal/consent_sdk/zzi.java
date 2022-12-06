package com.google.android.gms.internal.consent_sdk;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzi implements zzch<zzh> {
    private final zzcl<Executor> zza;

    public zzi(zzcl<Executor> zzcl) {
        this.zza = zzcl;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Executor executor = zzcd.zzb;
        zzck.zza(executor);
        return new zzh(executor);
    }
}
