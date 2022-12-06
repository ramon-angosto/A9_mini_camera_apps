package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcvi implements Runnable {
    public final /* synthetic */ zzcmp zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcvi(zzcmp zzcmp, JSONObject jSONObject) {
        this.zza = zzcmp;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzl("AFMA_updateActiveView", this.zzb);
    }
}
