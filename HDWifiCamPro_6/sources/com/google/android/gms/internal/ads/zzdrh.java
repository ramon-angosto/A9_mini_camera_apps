package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdrh implements zzfsm {
    public final /* synthetic */ zzdrq zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzdrh(zzdrq zzdrq, JSONObject jSONObject) {
        this.zza = zzdrq;
        this.zzb = jSONObject;
    }

    public final Object apply(Object obj) {
        return this.zza.zza(this.zzb, (List) obj);
    }
}
