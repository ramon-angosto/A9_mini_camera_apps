package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzbzi {
    public final boolean zza;
    public final String zzb;

    public zzbzi(boolean z, String str) {
        this.zza = z;
        this.zzb = str;
    }

    public static zzbzi zza(JSONObject jSONObject) {
        return new zzbzi(jSONObject.optBoolean("enable_prewarming", false), jSONObject.optString("prefetch_url", ""));
    }
}
