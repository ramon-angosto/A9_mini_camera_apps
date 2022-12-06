package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbpr implements zzbpu {
    zzbpr() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmp zzcmp = (zzcmp) obj;
        if (map.keySet().contains("start")) {
            zzcmp.zzP().zzk();
        } else if (map.keySet().contains("stop")) {
            zzcmp.zzP().zzl();
        } else if (map.keySet().contains("cancel")) {
            zzcmp.zzP().zzj();
        }
    }
}
