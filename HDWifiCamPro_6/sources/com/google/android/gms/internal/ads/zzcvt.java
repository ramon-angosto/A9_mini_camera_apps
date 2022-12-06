package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcvt implements Runnable {
    public final /* synthetic */ zzcvu zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcvt(zzcvu zzcvu, JSONObject jSONObject) {
        this.zza = zzcvu;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzd(this.zzb);
    }
}
