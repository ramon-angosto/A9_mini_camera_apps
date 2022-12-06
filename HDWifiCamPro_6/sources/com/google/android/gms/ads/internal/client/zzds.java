package com.google.android.gms.ads.internal.client;

import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zzds implements Runnable {
    public final /* synthetic */ zzdu zza;
    public final /* synthetic */ IObjectWrapper zzb;

    public /* synthetic */ zzds(zzdu zzdu, IObjectWrapper iObjectWrapper) {
        this.zza = zzdu;
        this.zzb = iObjectWrapper;
    }

    public final void run() {
        this.zza.zzl(this.zzb);
    }
}
