package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzdzk implements Callable {
    public final /* synthetic */ zzdzs zza;
    public final /* synthetic */ zzfjj zzb;

    public /* synthetic */ zzdzk(zzdzs zzdzs, zzfjj zzfjj) {
        this.zza = zzdzs;
        this.zzb = zzfjj;
    }

    public final Object call() {
        this.zza.zzf(this.zzb);
        return null;
    }
}
