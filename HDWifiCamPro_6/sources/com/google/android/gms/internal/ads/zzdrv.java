package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdrv {
    private final Executor zza;
    private final zzdrq zzb;

    public zzdrv(Executor executor, zzdrq zzdrq) {
        this.zza = executor;
        this.zzb = zzdrq;
    }

    public final zzfzp zza(JSONObject jSONObject, String str) {
        zzfzp zzfzp;
        JSONArray optJSONArray = jSONObject.optJSONArray("custom_assets");
        if (optJSONArray == null) {
            return zzfzg.zzi(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                zzfzp = zzfzg.zzi((Object) null);
            } else {
                String optString = optJSONObject.optString("name");
                if (optString == null) {
                    zzfzp = zzfzg.zzi((Object) null);
                } else {
                    String optString2 = optJSONObject.optString("type");
                    if ("string".equals(optString2)) {
                        zzfzp = zzfzg.zzi(new zzdru(optString, optJSONObject.optString("string_value")));
                    } else if ("image".equals(optString2)) {
                        zzfzp = zzfzg.zzm(this.zzb.zze(optJSONObject, "image_value"), new zzdrs(optString), this.zza);
                    } else {
                        zzfzp = zzfzg.zzi((Object) null);
                    }
                }
            }
            arrayList.add(zzfzp);
        }
        return zzfzg.zzm(zzfzg.zze(arrayList), zzdrt.zza, this.zza);
    }
}
