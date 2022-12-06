package com.google.android.gms.internal.consent_sdk;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
public final /* synthetic */ class zzf implements Callable {
    public final /* synthetic */ zzg zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ JSONObject zzc;

    public /* synthetic */ zzf(zzg zzg, String str, JSONObject jSONObject) {
        this.zza = zzg;
        this.zzb = str;
        this.zzc = jSONObject;
    }

    public final Object call() {
        return Boolean.valueOf(this.zza.zzb(this.zzb, this.zzc));
    }
}
