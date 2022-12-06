package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdcf implements Callable {
    public final /* synthetic */ zzdcg zza;
    public final /* synthetic */ zzfzp zzb;

    public /* synthetic */ zzdcf(zzdcg zzdcg, zzfzp zzfzp) {
        this.zza = zzdcg;
        this.zzb = zzfzp;
    }

    public final Object call() {
        return this.zza.zza(this.zzb);
    }
}
