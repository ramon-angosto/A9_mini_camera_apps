package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzbuv implements zzbqi {
    final /* synthetic */ zzbuw zza;
    private final zzchh zzb;

    public zzbuv(zzbuw zzbuw, zzchh zzchh) {
        this.zza = zzbuw;
        this.zzb = zzchh;
    }

    public final void zza(String str) {
        if (str == null) {
            try {
                this.zzb.zze(new zzbtz());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zzb.zze(new zzbtz(str));
        }
    }

    public final void zzb(JSONObject jSONObject) {
        try {
            this.zzb.zzd(jSONObject);
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzb.zze(e);
        }
    }
}
