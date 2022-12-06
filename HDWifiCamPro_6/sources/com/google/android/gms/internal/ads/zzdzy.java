package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzaw;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zze;
import com.google.android.gms.ads.internal.client.zzu;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.model.AdvertisementDBAdapter;
import com.vungle.warren.model.ReportDBAdapter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdzy implements zzddd, zzdfv, zzdes {
    private final zzeak zza;
    private final String zzb;
    private final String zzc;
    private int zzd = 0;
    private zzdzx zze = zzdzx.AD_REQUESTED;
    private zzdct zzf;
    private zze zzg;
    private String zzh;
    private String zzi;
    private boolean zzj;
    private boolean zzk;

    zzdzy(zzeak zzeak, zzfef zzfef, String str) {
        this.zza = zzeak;
        this.zzc = str;
        this.zzb = zzfef.zzf;
    }

    private static JSONObject zzh(zze zze2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("errorDomain", zze2.zzc);
        jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, zze2.zza);
        jSONObject.put("errorDescription", zze2.zzb);
        zze zze3 = zze2.zzd;
        jSONObject.put("underlyingError", zze3 == null ? null : zzh(zze3));
        return jSONObject;
    }

    private final JSONObject zzi(zzdct zzdct) throws JSONException {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("winningAdapterClassName", zzdct.zzg());
        jSONObject2.put("responseSecsSinceEpoch", zzdct.zzc());
        jSONObject2.put("responseId", zzdct.zzi());
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhV)).booleanValue()) {
            String zzd2 = zzdct.zzd();
            if (!TextUtils.isEmpty(zzd2)) {
                com.google.android.gms.ads.internal.util.zze.zze("Bidding data: ".concat(String.valueOf(zzd2)));
                jSONObject2.put("biddingData", new JSONObject(zzd2));
            }
        }
        if (!TextUtils.isEmpty(this.zzh)) {
            jSONObject2.put("adRequestUrl", this.zzh);
        }
        if (!TextUtils.isEmpty(this.zzi)) {
            jSONObject2.put("postBody", this.zzi);
        }
        JSONArray jSONArray = new JSONArray();
        for (zzu zzu : zzdct.zzj()) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("adapterClassName", zzu.zza);
            jSONObject3.put("latencyMillis", zzu.zzb);
            if (((Boolean) zzay.zzc().zzb(zzbjc.zzhW)).booleanValue()) {
                jSONObject3.put("credentials", zzaw.zzb().zzh(zzu.zzd));
            }
            zze zze2 = zzu.zzc;
            if (zze2 == null) {
                jSONObject = null;
            } else {
                jSONObject = zzh(zze2);
            }
            jSONObject3.put(CampaignEx.JSON_NATIVE_VIDEO_ERROR, jSONObject);
            jSONArray.put(jSONObject3);
        }
        jSONObject2.put("adNetworks", jSONArray);
        return jSONObject2;
    }

    public final void zza(zze zze2) {
        this.zze = zzdzx.AD_LOAD_FAILED;
        this.zzg = zze2;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzia)).booleanValue()) {
            this.zza.zzf(this.zzb, this);
        }
    }

    public final void zzb(zzfdw zzfdw) {
        if (!zzfdw.zzb.zza.isEmpty()) {
            this.zzd = ((zzfdk) zzfdw.zzb.zza.get(0)).zzb;
        }
        if (!TextUtils.isEmpty(zzfdw.zzb.zzb.zzk)) {
            this.zzh = zzfdw.zzb.zzb.zzk;
        }
        if (!TextUtils.isEmpty(zzfdw.zzb.zzb.zzl)) {
            this.zzi = zzfdw.zzb.zzb.zzl;
        }
    }

    public final void zzbE(zzcbc zzcbc) {
        if (!((Boolean) zzay.zzc().zzb(zzbjc.zzia)).booleanValue()) {
            this.zza.zzf(this.zzb, this);
        }
    }

    public final void zzbH(zzcze zzcze) {
        this.zzf = zzcze.zzl();
        this.zze = zzdzx.AD_LOADED;
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzia)).booleanValue()) {
            this.zza.zzf(this.zzb, this);
        }
    }

    public final String zzc() {
        return this.zzc;
    }

    public final JSONObject zzd() throws JSONException {
        IBinder iBinder;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(AdvertisementDBAdapter.AdvertisementColumns.COLUMN_STATE, this.zze);
        jSONObject.put("format", zzfdk.zza(this.zzd));
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzia)).booleanValue()) {
            jSONObject.put("isOutOfContext", this.zzj);
            if (this.zzj) {
                jSONObject.put("shown", this.zzk);
            }
        }
        zzdct zzdct = this.zzf;
        JSONObject jSONObject2 = null;
        if (zzdct != null) {
            jSONObject2 = zzi(zzdct);
        } else {
            zze zze2 = this.zzg;
            if (!(zze2 == null || (iBinder = zze2.zze) == null)) {
                zzdct zzdct2 = (zzdct) iBinder;
                jSONObject2 = zzi(zzdct2);
                if (zzdct2.zzj().isEmpty()) {
                    JSONArray jSONArray = new JSONArray();
                    jSONArray.put(zzh(this.zzg));
                    jSONObject2.put(ReportDBAdapter.ReportColumns.COLUMN_ERRORS, jSONArray);
                }
            }
        }
        jSONObject.put("responseInfo", jSONObject2);
        return jSONObject;
    }

    public final void zze() {
        this.zzj = true;
    }

    public final void zzf() {
        this.zzk = true;
    }

    public final boolean zzg() {
        return this.zze != zzdzx.AD_REQUESTED;
    }
}
