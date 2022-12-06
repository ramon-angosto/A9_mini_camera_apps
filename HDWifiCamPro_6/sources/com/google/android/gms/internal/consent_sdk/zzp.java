package com.google.android.gms.internal.consent_sdk;

import android.app.Application;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzp implements zzch<zzn> {
    private final zzcl<Application> zza;
    private final zzcl<zzb> zzb;
    private final zzcl<zzam> zzc;

    public zzp(zzcl<Application> zzcl, zzcl<zzb> zzcl2, zzcl<zzam> zzcl3) {
        this.zza = zzcl;
        this.zzb = zzcl2;
        this.zzc = zzcl3;
    }

    /* renamed from: zza */
    public final zzn zzb() {
        return new zzn(this.zza.zzb(), ((zzc) this.zzb).zzb(), this.zzc.zzb());
    }
}
