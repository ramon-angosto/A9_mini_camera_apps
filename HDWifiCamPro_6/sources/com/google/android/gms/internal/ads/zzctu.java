package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzctu {
    private final Map zza;
    private final Map zzb;

    zzctu(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzfdw zzfdw) throws Exception {
        for (zzfdu zzfdu : zzfdw.zzb.zzc) {
            if (this.zza.containsKey(zzfdu.zza)) {
                ((zzctx) this.zza.get(zzfdu.zza)).zza(zzfdu.zzb);
            } else if (this.zzb.containsKey(zzfdu.zza)) {
                zzctw zzctw = (zzctw) this.zzb.get(zzfdu.zza);
                JSONObject jSONObject = zzfdu.zzb;
                HashMap hashMap = new HashMap();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    String optString = jSONObject.optString(next);
                    if (optString != null) {
                        hashMap.put(next, optString);
                    }
                }
                zzctw.zza(hashMap);
            }
        }
    }
}
