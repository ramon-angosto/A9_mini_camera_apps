package com.google.android.gms.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class AdapterResponseInfo {
    private final zzu zza;
    private final AdError zzb;

    private AdapterResponseInfo(zzu zzu) {
        this.zza = zzu;
        zze zze = zzu.zzc;
        this.zzb = zze == null ? null : zze.zza();
    }

    public static AdapterResponseInfo zza(zzu zzu) {
        if (zzu != null) {
            return new AdapterResponseInfo(zzu);
        }
        return null;
    }

    public AdError getAdError() {
        return this.zzb;
    }

    public String getAdSourceId() {
        return this.zza.zzf;
    }

    public String getAdSourceInstanceId() {
        return this.zza.zzh;
    }

    public String getAdSourceInstanceName() {
        return this.zza.zzg;
    }

    public String getAdSourceName() {
        return this.zza.zze;
    }

    public String getAdapterClassName() {
        return this.zza.zza;
    }

    public Bundle getCredentials() {
        return this.zza.zzd;
    }

    public long getLatencyMillis() {
        return this.zza.zzb;
    }

    public String toString() {
        try {
            return zzb().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final JSONObject zzb() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("Adapter", this.zza.zza);
        jSONObject.put("Latency", this.zza.zzb);
        String adSourceName = getAdSourceName();
        if (adSourceName == null) {
            jSONObject.put("Ad Source Name", "null");
        } else {
            jSONObject.put("Ad Source Name", adSourceName);
        }
        String adSourceId = getAdSourceId();
        if (adSourceId == null) {
            jSONObject.put("Ad Source ID", "null");
        } else {
            jSONObject.put("Ad Source ID", adSourceId);
        }
        String adSourceInstanceName = getAdSourceInstanceName();
        if (adSourceInstanceName == null) {
            jSONObject.put("Ad Source Instance Name", "null");
        } else {
            jSONObject.put("Ad Source Instance Name", adSourceInstanceName);
        }
        String adSourceInstanceId = getAdSourceInstanceId();
        if (adSourceInstanceId == null) {
            jSONObject.put("Ad Source Instance ID", "null");
        } else {
            jSONObject.put("Ad Source Instance ID", adSourceInstanceId);
        }
        JSONObject jSONObject2 = new JSONObject();
        for (String str : this.zza.zzd.keySet()) {
            jSONObject2.put(str, this.zza.zzd.get(str));
        }
        jSONObject.put("Credentials", jSONObject2);
        AdError adError = this.zzb;
        if (adError == null) {
            jSONObject.put("Ad Error", "null");
        } else {
            jSONObject.put("Ad Error", adError.zzb());
        }
        return jSONObject;
    }
}
