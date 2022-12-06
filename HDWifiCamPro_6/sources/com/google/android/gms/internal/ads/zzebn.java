package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzebn implements Callable {
    public final /* synthetic */ zzape zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzebn(zzape zzape, Context context) {
        this.zza = zzape;
        this.zzb = context;
    }

    public final Object call() {
        zzape zzape = this.zza;
        return zzape.zzc().zzg(this.zzb);
    }
}
