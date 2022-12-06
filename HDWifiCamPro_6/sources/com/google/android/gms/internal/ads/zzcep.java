package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcep implements Callable {
    public final /* synthetic */ zzceu zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzcep(zzceu zzceu, Context context) {
        this.zza = zzceu;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zzg(this.zzb);
    }
}
