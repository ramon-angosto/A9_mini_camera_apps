package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzdtm implements zzbpu {
    final /* synthetic */ zzdtn zza;
    private final WeakReference zzb;
    private final String zzc;
    private final zzbpu zzd;

    /* synthetic */ zzdtm(zzdtn zzdtn, WeakReference weakReference, String str, zzbpu zzbpu, zzdtl zzdtl) {
        this.zza = zzdtn;
        this.zzb = weakReference;
        this.zzc = str;
        this.zzd = zzbpu;
    }

    public final void zza(Object obj, Map map) {
        Object obj2 = this.zzb.get();
        if (obj2 == null) {
            this.zza.zzk(this.zzc, this);
        } else {
            this.zzd.zza(obj2, map);
        }
    }
}
