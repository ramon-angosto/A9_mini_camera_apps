package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzfbl implements Runnable {
    public final /* synthetic */ zzfbm zza;
    public final /* synthetic */ zze zzb;

    public /* synthetic */ zzfbl(zzfbm zzfbm, zze zze) {
        this.zza = zzfbm;
        this.zzb = zze;
    }

    public final void run() {
        zzfbm zzfbm = this.zza;
        zzfbm.zze.zze.zza(this.zzb);
    }
}
