package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzdnl implements zzbpu {
    private final WeakReference zza;

    /* synthetic */ zzdnl(zzdnq zzdnq, zzdnk zzdnk) {
        this.zza = new WeakReference(zzdnq);
    }

    public final void zza(Object obj, Map map) {
        zzdnq zzdnq = (zzdnq) this.zza.get();
        if (zzdnq != null && "_ac".equals((String) map.get("eventName"))) {
            zzdnq.zzh.onAdClicked();
            if (((Boolean) zzay.zzc().zzb(zzbjc.zziw)).booleanValue()) {
                zzdnq.zzi.zzq();
            }
        }
    }
}
