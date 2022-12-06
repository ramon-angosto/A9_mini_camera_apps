package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final /* synthetic */ class zzepa implements Runnable {
    public final /* synthetic */ zzepb zza;
    public final /* synthetic */ zze zzb;

    public /* synthetic */ zzepa(zzepb zzepb, zze zze) {
        this.zza = zzepb;
        this.zzb = zze;
    }

    public final void run() {
        zzepb zzepb = this.zza;
        zzepb.zze.zzd.zza().zza(this.zzb);
    }
}
