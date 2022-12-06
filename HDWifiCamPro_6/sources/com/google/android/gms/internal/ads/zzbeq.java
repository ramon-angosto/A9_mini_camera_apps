package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads-lite@@21.3.0 */
public final /* synthetic */ class zzbeq implements Runnable {
    public final /* synthetic */ zzbev zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzbeq(zzbev zzbev, Context context) {
        this.zza = zzbev;
        this.zzb = context;
    }

    public final void run() {
        this.zza.zzb(this.zzb);
    }
}
