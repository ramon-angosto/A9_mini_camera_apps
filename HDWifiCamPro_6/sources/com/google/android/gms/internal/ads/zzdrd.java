package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdrd {
    private final zzfzq zza;
    private final zzdrq zzb;
    private final zzdrv zzc;

    public zzdrd(zzfzq zzfzq, zzdrq zzdrq, zzdrv zzdrv) {
        this.zza = zzfzq;
        this.zzb = zzdrq;
        this.zzc = zzdrv;
    }

    public final zzfzp zza(zzfdw zzfdw, zzfdk zzfdk, JSONObject jSONObject) {
        zzfzp zzn;
        zzfdw zzfdw2 = zzfdw;
        zzfdk zzfdk2 = zzfdk;
        JSONObject jSONObject2 = jSONObject;
        zzfzp zzb2 = this.zza.zzb(new zzdrb(this, zzfdw2, zzfdk2, jSONObject2));
        zzfzp zzf = this.zzb.zzf(jSONObject2, "images");
        zzfzp zzg = this.zzb.zzg(jSONObject2, "images", zzfdk2, zzfdw2.zzb.zzb);
        zzfzp zze = this.zzb.zze(jSONObject2, "secondary_image");
        zzfzp zze2 = this.zzb.zze(jSONObject2, "app_icon");
        zzfzp zzd = this.zzb.zzd(jSONObject2, "attribution");
        zzfzp zzh = this.zzb.zzh(jSONObject2, zzfdk2, zzfdw2.zzb.zzb);
        zzdrq zzdrq = this.zzb;
        if (!jSONObject2.optBoolean("enable_omid")) {
            zzn = zzfzg.zzi((Object) null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzn = zzfzg.zzi((Object) null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzn = zzfzg.zzi((Object) null);
                } else {
                    zzn = zzfzg.zzn(zzfzg.zzi((Object) null), new zzdrf(zzdrq, optString), zzchc.zze);
                }
            }
        }
        zzfzp zzfzp = zzn;
        zzfzp zza2 = this.zzc.zza(jSONObject2, "custom_assets");
        return zzfzg.zzb(zzb2, zzf, zzg, zze, zze2, zzd, zzh, zzfzp, zza2).zza(new zzdrc(this, zzb2, zzf, zze2, zze, zzd, jSONObject, zzh, zzg, zzfzp, zza2), this.zza);
    }
}
