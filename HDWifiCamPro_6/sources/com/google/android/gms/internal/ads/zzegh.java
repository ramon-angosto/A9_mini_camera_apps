package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzegh implements Callable {
    public final /* synthetic */ zzego zza;

    public /* synthetic */ zzegh(zzego zzego) {
        this.zza = zzego;
    }

    public final Object call() {
        return this.zza.getWritableDatabase();
    }
}
