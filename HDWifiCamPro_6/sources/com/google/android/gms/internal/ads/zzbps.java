package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbps implements zzbpu {
    zzbps() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcmp zzcmp = (zzcmp) obj;
        if (map.keySet().contains("start")) {
            zzcmp.zzau(true);
        }
        if (map.keySet().contains("stop")) {
            zzcmp.zzau(false);
        }
    }
}
