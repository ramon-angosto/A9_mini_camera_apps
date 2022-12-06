package com.google.android.gms.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzdh;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.internal.ads.zzcgp;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final class ResponseInfo {
    private final zzdh zza;
    private final List zzb = new ArrayList();
    private AdapterResponseInfo zzc;

    private ResponseInfo(zzdh zzdh) {
        this.zza = zzdh;
        zzdh zzdh2 = this.zza;
        if (zzdh2 != null) {
            try {
                List<zzu> zzj = zzdh2.zzj();
                if (zzj != null) {
                    for (zzu zza2 : zzj) {
                        AdapterResponseInfo zza3 = AdapterResponseInfo.zza(zza2);
                        if (zza3 != null) {
                            this.zzb.add(zza3);
                        }
                    }
                }
            } catch (RemoteException e) {
                zzcgp.zzh("Could not forward getAdapterResponseInfo to ResponseInfo.", e);
            }
        }
        zzdh zzdh3 = this.zza;
        if (zzdh3 != null) {
            try {
                zzu zzf = zzdh3.zzf();
                if (zzf != null) {
                    this.zzc = AdapterResponseInfo.zza(zzf);
                }
            } catch (RemoteException e2) {
                zzcgp.zzh("Could not forward getLoadedAdapterResponse to ResponseInfo.", e2);
            }
        }
    }

    public static ResponseInfo zza(zzdh zzdh) {
        if (zzdh != null) {
            return new ResponseInfo(zzdh);
        }
        return null;
    }

    public static ResponseInfo zzb(zzdh zzdh) {
        return new ResponseInfo(zzdh);
    }

    public List<AdapterResponseInfo> getAdapterResponses() {
        return this.zzb;
    }

    public AdapterResponseInfo getLoadedAdapterResponseInfo() {
        return this.zzc;
    }

    public String getMediationAdapterClassName() {
        try {
            zzdh zzdh = this.zza;
            if (zzdh != null) {
                return zzdh.zzg();
            }
            return null;
        } catch (RemoteException e) {
            zzcgp.zzh("Could not forward getMediationAdapterClassName to ResponseInfo.", e);
            return null;
        }
    }

    public Bundle getResponseExtras() {
        try {
            zzdh zzdh = this.zza;
            if (zzdh != null) {
                return zzdh.zze();
            }
        } catch (RemoteException e) {
            zzcgp.zzh("Could not forward getResponseExtras to ResponseInfo.", e);
        }
        return new Bundle();
    }

    public String getResponseId() {
        try {
            zzdh zzdh = this.zza;
            if (zzdh != null) {
                return zzdh.zzi();
            }
            return null;
        } catch (RemoteException e) {
            zzcgp.zzh("Could not forward getResponseId to ResponseInfo.", e);
            return null;
        }
    }

    public String toString() {
        try {
            return zzd().toString(2);
        } catch (JSONException unused) {
            return "Error forming toString output.";
        }
    }

    public final zzdh zzc() {
        return this.zza;
    }

    public final JSONObject zzd() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String responseId = getResponseId();
        if (responseId == null) {
            jSONObject.put("Response ID", "null");
        } else {
            jSONObject.put("Response ID", responseId);
        }
        String mediationAdapterClassName = getMediationAdapterClassName();
        if (mediationAdapterClassName == null) {
            jSONObject.put("Mediation Adapter Class Name", "null");
        } else {
            jSONObject.put("Mediation Adapter Class Name", mediationAdapterClassName);
        }
        JSONArray jSONArray = new JSONArray();
        for (AdapterResponseInfo zzb2 : this.zzb) {
            jSONArray.put(zzb2.zzb());
        }
        jSONObject.put("Adapter Responses", jSONArray);
        AdapterResponseInfo adapterResponseInfo = this.zzc;
        if (adapterResponseInfo != null) {
            jSONObject.put("Loaded Adapter Response", adapterResponseInfo.zzb());
        }
        Bundle responseExtras = getResponseExtras();
        if (responseExtras != null) {
            jSONObject.put("Response Extras", zzaw.zzb().zzh(responseExtras));
        }
        return jSONObject;
    }
}
