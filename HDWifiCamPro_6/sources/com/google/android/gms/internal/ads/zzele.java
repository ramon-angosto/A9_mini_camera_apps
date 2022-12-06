package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzele implements zzehe {
    private final Map zza = new HashMap();
    private final zzdvl zzb;

    public zzele(zzdvl zzdvl) {
        this.zzb = zzdvl;
    }

    public final zzehf zza(String str, JSONObject jSONObject) throws zzfek {
        zzehf zzehf;
        synchronized (this) {
            zzehf = (zzehf) this.zza.get(str);
            if (zzehf == null) {
                zzehf = new zzehf(this.zzb.zzc(str, jSONObject), new zzeiy(), str);
                this.zza.put(str, zzehf);
            }
        }
        return zzehf;
    }
}
