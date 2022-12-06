package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzewi implements zzevd {
    final String zza;
    final int zzb;

    public zzewi(String str, int i) {
        this.zza = str;
        this.zzb = i;
    }

    public final /* bridge */ /* synthetic */ void zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (!TextUtils.isEmpty(this.zza) && this.zzb != -1) {
            try {
                JSONObject zzf = zzbu.zzf(jSONObject, "pii");
                zzf.put("pvid", this.zza);
                zzf.put("pvid_s", this.zzb);
            } catch (JSONException e) {
                zze.zzb("Failed putting gms core app set ID info.", e);
            }
        }
    }
}
