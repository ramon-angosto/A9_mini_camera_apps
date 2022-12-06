package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzejo implements zzehe {
    private final zzdvl zza;

    public zzejo(zzdvl zzdvl) {
        this.zza = zzdvl;
    }

    public final zzehf zza(String str, JSONObject jSONObject) throws zzfek {
        return new zzehf(this.zza.zzc(str, jSONObject), new zzeix(), str);
    }
}
