package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzeei implements zzbud {
    zzeei() {
    }

    public final /* bridge */ /* synthetic */ JSONObject zzb(Object obj) throws JSONException {
        zzeej zzeej = (zzeej) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhX)).booleanValue()) {
            jSONObject2.put("ad_request_url", zzeej.zzd.zze());
            jSONObject2.put("ad_request_post_body", zzeej.zzd.zzd());
        }
        jSONObject2.put("base_url", zzeej.zzd.zzb());
        jSONObject2.put("signals", zzeej.zzc);
        jSONObject3.put(TtmlNode.TAG_BODY, zzeej.zzb.zzc);
        jSONObject3.put("headers", zzaw.zzb().zzi(zzeej.zzb.zzb));
        jSONObject3.put("response_code", zzeej.zzb.zza);
        jSONObject3.put("latency", zzeej.zzb.zzd);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzeej.zzd.zzg());
        return jSONObject;
    }
}
