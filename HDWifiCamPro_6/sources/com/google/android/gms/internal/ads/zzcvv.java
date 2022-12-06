package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzcvv implements zzgxi {
    private final zzgxv zza;

    public zzcvv(zzgxv zzgxv) {
        this.zza = zzgxv;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzczu) this.zza).zza().zzA);
        } catch (JSONException unused) {
            return null;
        }
    }
}
