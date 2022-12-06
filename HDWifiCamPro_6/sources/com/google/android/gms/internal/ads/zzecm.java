package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzecm implements zzfyn {
    public final /* synthetic */ zzecp zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ String zzc;

    public /* synthetic */ zzecm(zzecp zzecp, String str, String str2) {
        this.zza = zzecp;
        this.zzb = str;
        this.zzc = str2;
    }

    public final zzfzp zza(Object obj) {
        String str = this.zzb;
        String str2 = this.zzc;
        String str3 = (String) obj;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            jSONObject3.put("headers", new JSONObject());
            jSONObject3.put(TtmlNode.TAG_BODY, str);
            jSONObject2.put("base_url", "");
            jSONObject2.put("signals", new JSONObject(str2));
            jSONObject.put("request", jSONObject2);
            jSONObject.put("response", jSONObject3);
            jSONObject.put("flags", new JSONObject());
            return zzfzg.zzi(jSONObject);
        } catch (JSONException e) {
            throw new JSONException("Preloaded loader: ".concat(String.valueOf(String.valueOf(e.getCause()))));
        }
    }
}
