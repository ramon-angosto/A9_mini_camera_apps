package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zzbu;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzdou extends zzdov {
    private final JSONObject zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final boolean zzf;
    private final String zzg;
    private final JSONObject zzh;

    public zzdou(zzfdk zzfdk, JSONObject jSONObject) {
        super(zzfdk);
        this.zzb = zzbu.zzg(jSONObject, "tracking_urls_and_actions", "active_view");
        boolean z = false;
        this.zzc = zzbu.zzk(false, jSONObject, "allow_pub_owned_ad_view");
        this.zzd = zzbu.zzk(false, jSONObject, "attribution", "allow_pub_rendering");
        this.zze = zzbu.zzk(false, jSONObject, "enable_omid");
        this.zzg = zzbu.zzb("", jSONObject, "watermark_overlay_png_base64");
        this.zzf = jSONObject.optJSONObject("overlay") != null ? true : z;
        this.zzh = ((Boolean) zzay.zzc().zzb(zzbjc.zzek)).booleanValue() ? jSONObject.optJSONObject("omid_settings") : null;
    }

    public final zzfei zza() {
        JSONObject jSONObject = this.zzh;
        return jSONObject != null ? new zzfei(jSONObject) : this.zza.zzW;
    }

    public final String zzb() {
        return this.zzg;
    }

    public final JSONObject zzc() {
        JSONObject jSONObject = this.zzb;
        if (jSONObject != null) {
            return jSONObject;
        }
        try {
            return new JSONObject(this.zza.zzA);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final boolean zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return this.zzc;
    }

    public final boolean zzf() {
        return this.zzd;
    }

    public final boolean zzg() {
        return this.zzf;
    }
}
