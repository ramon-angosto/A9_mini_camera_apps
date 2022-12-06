package com.google.android.gms.ads.internal.overlay;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzu implements Runnable {
    public final /* synthetic */ zzw zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ Map zzc;

    public /* synthetic */ zzu(zzw zzw, String str, Map map) {
        this.zza = zzw;
        this.zzb = str;
        this.zzc = map;
    }

    public final void run() {
        this.zza.zzh(this.zzb, this.zzc);
    }
}
