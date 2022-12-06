package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzdnp implements zzbpu {
    private final WeakReference zza;

    /* synthetic */ zzdnp(zzdnq zzdnq, zzdno zzdno) {
        this.zza = new WeakReference(zzdnq);
    }

    public final void zza(Object obj, Map map) {
        zzdnq zzdnq = (zzdnq) this.zza.get();
        if (zzdnq != null) {
            zzdnq.zzg.zza();
        }
    }
}
