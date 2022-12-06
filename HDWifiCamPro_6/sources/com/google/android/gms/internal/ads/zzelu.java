package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzelu implements zzehe {
    private final zzemy zza;

    public zzelu(zzemy zzemy) {
        this.zza = zzemy;
    }

    public final zzehf zza(String str, JSONObject jSONObject) throws zzfek {
        zzbxd zza2 = this.zza.zza(str);
        if (zza2 == null) {
            return null;
        }
        return new zzehf(zza2, new zzeix(), str);
    }
}
