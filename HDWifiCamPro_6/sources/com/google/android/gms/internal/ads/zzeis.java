package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzeis implements Callable {
    public final /* synthetic */ zzeiv zza;
    public final /* synthetic */ zzfdw zzb;
    public final /* synthetic */ zzfdk zzc;

    public /* synthetic */ zzeis(zzeiv zzeiv, zzfdw zzfdw, zzfdk zzfdk) {
        this.zza = zzeiv;
        this.zzb = zzfdw;
        this.zzc = zzfdk;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc);
    }
}
