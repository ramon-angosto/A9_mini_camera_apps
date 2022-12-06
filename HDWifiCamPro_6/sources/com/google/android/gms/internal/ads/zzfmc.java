package com.google.android.gms.internal.ads;

import java.util.HashSet;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzfmc {
    private JSONObject zza;
    private final zzfml zzb;

    public zzfmc(zzfml zzfml) {
        this.zzb = zzfml;
    }

    public final JSONObject zza() {
        return this.zza;
    }

    public final void zzb() {
        this.zzb.zzb(new zzfmm(this, (byte[]) null));
    }

    public final void zzc(JSONObject jSONObject, HashSet hashSet, long j) {
        this.zzb.zzb(new zzfmn(this, hashSet, jSONObject, j, (byte[]) null));
    }

    public final void zzd(JSONObject jSONObject, HashSet hashSet, long j) {
        this.zzb.zzb(new zzfmo(this, hashSet, jSONObject, j, (byte[]) null));
    }

    public final void zze(JSONObject jSONObject) {
        this.zza = jSONObject;
    }
}
