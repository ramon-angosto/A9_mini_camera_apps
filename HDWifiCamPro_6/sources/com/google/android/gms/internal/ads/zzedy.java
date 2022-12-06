package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzedy implements Callable {
    public final /* synthetic */ zzfzp zza;
    public final /* synthetic */ zzfzp zzb;

    public /* synthetic */ zzedy(zzfzp zzfzp, zzfzp zzfzp2) {
        this.zza = zzfzp;
        this.zzb = zzfzp2;
    }

    public final Object call() {
        return new zzeeq((JSONObject) this.zza.get(), (zzcbf) this.zzb.get());
    }
}
