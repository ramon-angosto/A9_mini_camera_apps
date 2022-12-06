package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzboq implements zzbpu {
    private final zzbor zza;

    public zzboq(zzbor zzbor) {
        this.zza = zzbor;
    }

    public final void zza(Object obj, Map map) {
        String str = (String) map.get("name");
        if (str == null) {
            zze.zzj("App event with no name parameter.");
        } else {
            this.zza.zzbD(str, (String) map.get("info"));
        }
    }
}
