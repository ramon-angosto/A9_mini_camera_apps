package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzedz implements Callable {
    public final /* synthetic */ zzfzp zza;
    public final /* synthetic */ zzfzp zzb;
    public final /* synthetic */ zzfzp zzc;

    public /* synthetic */ zzedz(zzfzp zzfzp, zzfzp zzfzp2, zzfzp zzfzp3) {
        this.zza = zzfzp;
        this.zzb = zzfzp2;
        this.zzc = zzfzp3;
    }

    public final Object call() {
        return new zzeej((zzeen) this.zza.get(), (JSONObject) this.zzb.get(), (zzcbf) this.zzc.get());
    }
}
