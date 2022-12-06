package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzewx implements Callable {
    public final /* synthetic */ zzfzp zza;
    public final /* synthetic */ zzfzp zzb;

    public /* synthetic */ zzewx(zzfzp zzfzp, zzfzp zzfzp2) {
        this.zza = zzfzp;
        this.zzb = zzfzp2;
    }

    public final Object call() {
        return new zzewz((String) this.zza.get(), (String) this.zzb.get());
    }
}
