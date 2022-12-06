package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzckd implements Runnable {
    public final /* synthetic */ zzciy zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzckd(zzciy zzciy, Map map) {
        this.zza = zzciy;
        this.zzb = map;
    }

    public final void run() {
        zzciy zzciy = this.zza;
        Map map = this.zzb;
        int i = zzckg.zzc;
        zzciy.zzd("onGcacheInfoEvent", map);
    }
}
