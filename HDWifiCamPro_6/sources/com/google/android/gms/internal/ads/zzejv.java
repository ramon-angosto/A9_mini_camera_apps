package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.util.PlatformVersion;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzejv implements zzejp {
    private final zzdnd zza;
    private final zzfzq zzb;
    private final zzdrd zzc;
    private final zzffb zzd;
    private final zzdtt zze;

    public zzejv(zzdnd zzdnd, zzfzq zzfzq, zzdrd zzdrd, zzffb zzffb, zzdtt zzdtt) {
        this.zza = zzdnd;
        this.zzb = zzfzq;
        this.zzc = zzdrd;
        this.zzd = zzffb;
        this.zze = zzdtt;
    }

    private final zzfzp zzg(zzfdw zzfdw, zzfdk zzfdk, JSONObject jSONObject) {
        zzfzp zza2 = this.zzd.zza();
        zzfzp zza3 = this.zzc.zza(zzfdw, zzfdk, jSONObject);
        return zzfzg.zzd(zza2, zza3).zza(new zzejq(this, zza3, zza2, zzfdw, zzfdk, jSONObject), this.zzb);
    }

    public final zzfzp zza(zzfdw zzfdw, zzfdk zzfdk) {
        return zzfzg.zzn(zzfzg.zzn(this.zzd.zza(), new zzejs(this, zzfdk), this.zzb), new zzejt(this, zzfdw, zzfdk), this.zzb);
    }

    public final boolean zzb(zzfdw zzfdw, zzfdk zzfdk) {
        zzfdp zzfdp = zzfdk.zzt;
        return (zzfdp == null || zzfdp.zzc == null) ? false : true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdol zzc(zzfzp zzfzp, zzfzp zzfzp2, zzfdw zzfdw, zzfdk zzfdk, JSONObject jSONObject) throws Exception {
        zzdoq zzdoq = (zzdoq) zzfzp.get();
        zzdtn zzdtn = (zzdtn) zzfzp2.get();
        zzdor zzd2 = this.zza.zzd(new zzczt(zzfdw, zzfdk, (String) null), new zzdpc(zzdoq), new zzdns(jSONObject, zzdtn));
        zzd2.zzj().zzb();
        zzd2.zzk().zza(zzdtn);
        zzd2.zzg().zza(zzdoq.zzr());
        zzd2.zzl().zza(this.zze);
        return zzd2.zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzd(zzdtn zzdtn, JSONObject jSONObject) throws Exception {
        this.zzd.zzb(zzfzg.zzi(zzdtn));
        if (jSONObject.optBoolean("success")) {
            return zzfzg.zzi(jSONObject.getJSONObject("json").getJSONArray(CampaignUnit.JSON_KEY_ADS));
        }
        throw new zzbtz("process json failed");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zze(zzfdk zzfdk, zzdtn zzdtn) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isNonagon", true);
        if (((Boolean) zzay.zzc().zzb(zzbjc.zzhp)).booleanValue() && PlatformVersion.isAtLeastR()) {
            jSONObject.put("skipDeepLinkValidation", true);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("response", zzfdk.zzt.zzc);
        jSONObject2.put("sdk_params", jSONObject);
        return zzfzg.zzn(zzdtn.zzd("google.afma.nativeAds.preProcessJson", jSONObject2), new zzejr(this, zzdtn), this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzfzp zzf(zzfdw zzfdw, zzfdk zzfdk, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzfzg.zzh(new zzebh(3));
        }
        if (zzfdw.zza.zza.zzk <= 1) {
            return zzfzg.zzm(zzg(zzfdw, zzfdk, jSONArray.getJSONObject(0)), zzeju.zza, this.zzb);
        }
        int length = jSONArray.length();
        this.zzd.zzc(Math.min(length, zzfdw.zza.zza.zzk));
        ArrayList arrayList = new ArrayList(zzfdw.zza.zza.zzk);
        for (int i = 0; i < zzfdw.zza.zza.zzk; i++) {
            if (i < length) {
                arrayList.add(zzg(zzfdw, zzfdk, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzfzg.zzh(new zzebh(3)));
            }
        }
        return zzfzg.zzi(arrayList);
    }
}
