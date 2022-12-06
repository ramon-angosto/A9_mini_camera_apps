package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzbso {
    public static void zza(zzbsp zzbsp, String str, Map map) {
        try {
            zzbsp.zze(str, zzaw.zzb().zzi(map));
        } catch (JSONException unused) {
            zze.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzbsp zzbsp, String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        zze.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzbsp.zza(sb.toString());
    }

    public static void zzc(zzbsp zzbsp, String str, String str2) {
        zzbsp.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzbsp zzbsp, String str, JSONObject jSONObject) {
        zzbsp.zzb(str, jSONObject.toString());
    }
}
