package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzcnj implements Runnable {
    public final /* synthetic */ zzcnl zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzcnj(zzcnl zzcnl, Map map) {
        this.zza = zzcnl;
        this.zzb = map;
    }

    public final void run() {
        this.zza.zzr(this.zzb);
    }
}
