package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzs;
import com.google.android.gms.ads.internal.zzt;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.vungle.warren.model.ReportDBAdapter;
import com.vungle.warren.model.VisionDataDBAdapter;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdrb implements Callable {
    public final /* synthetic */ zzdrd zza;
    public final /* synthetic */ zzfdw zzb;
    public final /* synthetic */ zzfdk zzc;
    public final /* synthetic */ JSONObject zzd;

    public /* synthetic */ zzdrb(zzdrd zzdrd, zzfdw zzfdw, zzfdk zzfdk, JSONObject jSONObject) {
        this.zza = zzdrd;
        this.zzb = zzfdw;
        this.zzc = zzfdk;
        this.zzd = jSONObject;
    }

    public final Object call() {
        zzfdw zzfdw = this.zzb;
        zzfdk zzfdk = this.zzc;
        JSONObject jSONObject = this.zzd;
        zzdoq zzdoq = new zzdoq();
        zzdoq.zzV(jSONObject.optInt(ReportDBAdapter.ReportColumns.COLUMN_TEMPATE_ID, -1));
        zzdoq.zzI(jSONObject.optString("custom_template_id"));
        JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
        zzdoq.zzS(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
        zzfef zzfef = zzfdw.zza.zza;
        if (zzfef.zzg.contains(Integer.toString(zzdoq.zzc()))) {
            if (zzdoq.zzc() == 3) {
                if (zzdoq.zzy() == null) {
                    throw new zzekr(1, "No custom template id for custom template ad response.");
                } else if (!zzfef.zzh.contains(zzdoq.zzy())) {
                    throw new zzekr(1, "Unexpected custom template id in the response.");
                }
            }
            zzdoq.zzT(jSONObject.optDouble(CampaignEx.JSON_KEY_STAR, -1.0d));
            String optString = jSONObject.optString("headline", (String) null);
            if (zzfdk.zzN) {
                zzt.zzp();
                optString = zzs.zzv() + " : " + optString;
            }
            zzdoq.zzU("headline", optString);
            zzdoq.zzU(TtmlNode.TAG_BODY, jSONObject.optString(TtmlNode.TAG_BODY, (String) null));
            zzdoq.zzU("call_to_action", jSONObject.optString("call_to_action", (String) null));
            zzdoq.zzU("store", jSONObject.optString("store", (String) null));
            zzdoq.zzU("price", jSONObject.optString("price", (String) null));
            zzdoq.zzU(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER, jSONObject.optString(VisionDataDBAdapter.VisionDataColumns.COLUMN_ADVERTISER, (String) null));
            return zzdoq;
        }
        throw new zzekr(1, "Invalid template ID: " + zzdoq.zzc());
    }
}
