package com.google.android.gms.internal.consent_sdk;

import android.os.Handler;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final class zzbh implements zzch<zzbg> {
    private final zzcl<zzbi> zza;
    private final zzcl<Handler> zzb;
    private final zzcl<zzbm> zzc;

    public zzbh(zzcl<zzbi> zzcl, zzcl<Handler> zzcl2, zzcl<zzbm> zzcl3) {
        this.zza = zzcl;
        this.zzb = zzcl2;
        this.zzc = zzcl3;
    }

    /* renamed from: zza */
    public final zzbg zzb() {
        Handler handler = zzcd.zza;
        zzck.zza(handler);
        return new zzbg(this.zza.zzb(), handler, ((zzbn) this.zzc).zzb());
    }
}
