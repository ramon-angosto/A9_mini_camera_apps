package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzeed implements Callable {
    public final /* synthetic */ zzfzp zza;
    public final /* synthetic */ zzfzp zzb;

    public /* synthetic */ zzeed(zzfzp zzfzp, zzfzp zzfzp2) {
        this.zza = zzfzp;
        this.zzb = zzfzp2;
    }

    public final Object call() {
        zzfzp zzfzp = this.zza;
        zzfzp zzfzp2 = this.zzb;
        return new zzeej((zzeen) zzfzp.get(), ((zzeeh) zzfzp2.get()).zzb, ((zzeeh) zzfzp2.get()).zza);
    }
}
