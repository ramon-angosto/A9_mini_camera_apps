package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzebi implements Callable {
    public final /* synthetic */ zzebl zza;
    public final /* synthetic */ zzcbc zzb;

    public /* synthetic */ zzebi(zzebl zzebl, zzcbc zzcbc) {
        this.zza = zzebl;
        this.zzb = zzcbc;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb);
    }
}
